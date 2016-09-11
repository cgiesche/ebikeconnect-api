package de.perdoctus.ebikeconnect;

/*
 * #%L
 * ebikeconnect-api
 * %%
 * Copyright (C) 2016 Christoph Giesche
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */

import de.perdoctus.ebikeconnect.api.EBCApi;
import de.perdoctus.ebikeconnect.api.activities.EBCActivityDetailsResponse;
import de.perdoctus.ebikeconnect.api.activities.EBCActivityHeadersResponse;
import de.perdoctus.ebikeconnect.api.activities.EBCRawActivity;
import de.perdoctus.ebikeconnect.api.activities.EBCRawActivityResponse;
import de.perdoctus.ebikeconnect.api.login.EBCLoginRequest;
import de.perdoctus.ebikeconnect.api.login.EBCLoginResponse;
import de.perdoctus.ebikeconnect.jaxrs.ObjectMapperProvider;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Closeable;
import java.io.IOException;

public class EbikeConnectService implements Closeable {

    public static final String DEFAULT_ENDPOINT = "https://www.ebike-connect.com";
    private final Client client;
    private final EBCApi ebikeConnectAPI;
    private String sessionId = null;

    public EbikeConnectService() {
        this(DEFAULT_ENDPOINT);
    }

    public EbikeConnectService(final String endpointURL) {
        this.client = ClientBuilder.newClient();
        this.client.register(ObjectMapperProvider.class);

        final WebTarget webTarget = client.target(endpointURL);
        final ResteasyWebTarget resteasyWebTarget = (ResteasyWebTarget) webTarget;
        this.ebikeConnectAPI = resteasyWebTarget.proxy(EBCApi.class);
    }

    public void close() throws IOException {
        if (sessionId != null) {
            logout();
        }
        client.close();
    }

    public EBCLoginResponse login(final String username, final String password) throws LoginFailedException {
        final Response rawLoginResponse = ebikeConnectAPI.login(new EBCLoginRequest(username, password));

        if (rawLoginResponse.getStatus() != Response.Status.OK.getStatusCode()) {
            rawLoginResponse.close();
            throw new LoginFailedException(rawLoginResponse.getStatusInfo().getReasonPhrase());
        }

        // ARGH! The answer from login-service is JSON but Content-Type header contains "text/html". Hackety hack - fixed :)
        rawLoginResponse.getHeaders().remove("Content-Type");
        rawLoginResponse.getHeaders().add("Content-Type", MediaType.APPLICATION_JSON);

        this.sessionId = rawLoginResponse.getCookies().get("JSESSIONID").getValue();
        return rawLoginResponse.readEntity(EBCLoginResponse.class);
    }

    public void logout() {
        if (isLoggedIn()) {
            ebikeConnectAPI.logout(sessionId);
            sessionId = null;
        }
    }

    public EBCActivityHeadersResponse getAllActivityHeaders() throws UnauthenticatedException {
        requireLoggedIn();

        return ebikeConnectAPI.readActivityHeaders(this.sessionId);
    }

    public EBCActivityDetailsResponse getActivityDetails(final long startTime) throws UnauthenticatedException {
        requireLoggedIn();

        return ebikeConnectAPI.readActivityDetails(this.sessionId, startTime);
    }

    public EBCRawActivity getRawActivity(final long startTime) throws UnauthenticatedException {
        requireLoggedIn();

        final EBCRawActivityResponse ebcRawActivityResponse = ebikeConnectAPI.readRawActivityDetails(sessionId, "[start_time|eq|" + startTime + ";]");
        if (ebcRawActivityResponse.getActivityList().isEmpty()) {
            return null;
        }

        return ebcRawActivityResponse.getActivityList().get(0);
    }

    public boolean isLoggedIn() {
        return this.sessionId != null;
    }

    private void requireLoggedIn() throws UnauthenticatedException {
        if (!isLoggedIn()) {
            throw new UnauthenticatedException();
        }
    }

}
