package helper;

import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

public class WireMockHelper {
    public static WireMockServer wireMockServer;

    public static WireMockServer getWireMock() {
        if (wireMockServer == null) {
            _setupWireMock();
        }

        return wireMockServer;
    }

    public static void stubWireMock(String responseFileName) {
        wireMockServer.resetAll();

        wireMockServer.stubFor(post(urlEqualTo("/graphql"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withStatus(200)
                        .withBodyFile(responseFileName)));
    }

    private static void _setupWireMock() {
        wireMockServer = new WireMockServer(options()
                .port(11080)
                .withRootDirectory("src/test/resources/wiremock"));
    }

    private WireMockHelper() {
        // HideUtilityClassConstructor
    }
}
