package de.perdoctus.ebikeconnect.api;

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


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.jaxrs.annotation.JacksonFeatures;
import de.perdoctus.ebikeconnect.api.activities.EBCActivityDetailsResponse;
import de.perdoctus.ebikeconnect.api.activities.EBCActivityHeadersResponse;
import de.perdoctus.ebikeconnect.api.activities.EBCRawActivityResponse;
import de.perdoctus.ebikeconnect.api.login.EBCLoginRequest;
import de.perdoctus.ebikeconnect.api.login.EBCLoginResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ebikeconnect")
public interface EBCApi {

    /**
     * @return status 200 and a {@link EBCLoginResponse} when login was sucessful. Otherwise Status 301.
     */
    @POST
    @Path("/api/portal/login/public")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response login(@HeaderParam("User-Agent") final String userAgent,
                   final EBCLoginRequest loginRequest);

    /**
     * @return Status 200 when session is valid. Otherwise status 301.
     */
    @GET
    @Path("/user/checkSession")
    Response checkSession(@HeaderParam("User-Agent") final String userAgent,
                          @HeaderParam("Protect-from") final String protectFrom,
                          @CookieParam("JSESSIONID") final String sessionId);

    /**
     * @return Always status 200.
     */
    @GET
    @Path("/user/logout")
    @Produces(MediaType.TEXT_PLAIN)
    Response logout(@HeaderParam("User-Agent") final String userAgent,
                    @CookieParam("JSESSIONID") final String sessionId);

    @GET
    @Path("/api/activities/headers")
    @Produces(MediaType.APPLICATION_JSON)
    @JacksonFeatures(deserializationEnable = DeserializationFeature.UNWRAP_ROOT_VALUE)
    EBCActivityHeadersResponse readActivityHeaders(@HeaderParam("User-Agent") final String userAgent,
                                                   @HeaderParam("Protect-from") final String protectFrom,
                                                   @HeaderParam("If-Modified-Since") final String ifModifiedSince,
                                                   @CookieParam("JSESSIONID") final String sessionId);

    @GET
    @Path("/api/activities/headers")
    @Produces(MediaType.APPLICATION_JSON)
    @JacksonFeatures(deserializationEnable = DeserializationFeature.UNWRAP_ROOT_VALUE)
    EBCActivityHeadersResponse readActivityHeaders(@HeaderParam("User-Agent") final String userAgent,
                                                   @HeaderParam("Protect-from") final String protectFrom,
                                                   @HeaderParam("If-Modified-Since") final String ifModifiedSince,
                                                   @CookieParam("JSESSIONID") final String sessionId,
                                                   @QueryParam("filters") final String filterExpression);

    @GET
    @Path("/api/activities/details/{startTime}")
    @Produces(MediaType.APPLICATION_JSON)
    EBCActivityDetailsResponse readActivityDetails(@HeaderParam("User-Agent") final String userAgent,
                                                   @HeaderParam("Protect-from") final String protectFrom,
                                                   @HeaderParam("If-Modified-Since") final String ifModifiedSince,
                                                   @CookieParam("JSESSIONID") final String sessionId,
                                                   @PathParam("startTime") final long startTime);

    @GET
    @Path("/api/activities")
    @Produces(MediaType.APPLICATION_JSON)
    @JacksonFeatures(deserializationEnable = DeserializationFeature.UNWRAP_ROOT_VALUE)
    EBCRawActivityResponse readRawActivityDetails(@HeaderParam("User-Agent") final String userAgent,
                                                  @HeaderParam("Protect-from") final String protectFrom,
                                                  @HeaderParam("If-Modified-Since") final String ifModifiedSince,
                                                  @CookieParam("JSESSIONID") final String sessionId,
                                                  @QueryParam("filters") final String filterExpression);
}
