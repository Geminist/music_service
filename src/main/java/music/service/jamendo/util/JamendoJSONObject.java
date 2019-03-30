package music.service.jamendo.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JamendoJSONObject {
    JamendoHeaders headers;

    JamendoTrack[] results;

    public JamendoJSONObject(JamendoHeaders headers, JamendoTrack[] results) {
        this.headers = headers;
        this.results = results;
    }

    public JamendoJSONObject() {
    }

    public JamendoHeaders getHeaders() {
        return headers;
    }

    public void setHeaders(JamendoHeaders headers) {
        this.headers = headers;
    }

    public JamendoTrack[] getResults() {
        return results;
    }

    public void setResults(JamendoTrack[] results) {
        this.results = results;
    }
}
