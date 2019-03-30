package music.service.jamendo.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JamendoHeaders {

    String status;
    int code;
    int results_fullcount;
    String error_message;
    int results_count;

    public JamendoHeaders(String status, int code, int results_fullcount, String error_message, int results_count) {
        this.status = status;
        this.code = code;
        this.results_fullcount = results_fullcount;
        this.error_message = error_message;
        this.results_count = results_count;
    }

    public JamendoHeaders() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getResults_fullcount() {
        return results_fullcount;
    }

    public void setResults_fullcount(int results_fullcount) {
        this.results_fullcount = results_fullcount;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public int getResults_count() {
        return results_count;
    }

    public void setResults_count(int results_count) {
        this.results_count = results_count;
    }
}
