package de.perdoctus.ebikeconnect.api.login;

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


import de.perdoctus.ebikeconnect.EbikeConnectService;
import de.perdoctus.ebikeconnect.IntegrationTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginIT extends IntegrationTest {

    @Test
    public void loginAndLogout() throws Exception {
        final EbikeConnectService service = new EbikeConnectService();

        // when
        final EBCLoginResponse login = service.login(username, password);

        // then
        assertThat(service.isLoggedIn()).isTrue();
        assertThat(login).isNotNull();
        assertThat(login.getUser()).isNotNull();
        assertThat(login.getUser().getEmail()).isNotEmpty();

        // when
        Thread.sleep(2000);
        service.logout();

        // then
        assertThat(service.isLoggedIn()).isFalse();
    }

}
