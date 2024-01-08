package error_response.spring_error_response.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ApiResponse<T> {

    private Status status;
    private Metedata metedata;
    private List<T> results = new ArrayList<>();

    public ApiResponse(Status status, Metedata metedata, List<T> results) {
        this.status = status;
        this.metedata = metedata;
        this.results = results;
    }

    public ApiResponse(List<T> results) {
        this.status = new Status(ErrorCode.OK.getCode(), ErrorCode.OK.getMessage());
        this.metedata = new Metedata(results.size());
        this.results = results;
    }

    public ApiResponse(int code, String message, T value) {
        this.status = new Status(code, message);
        this.metedata = new Metedata(results.size());
        this.results = Collections.singletonList(value);
    }

    public Status getStatus() {
        return status;
    }

    public Metedata getMetedata() {
        return metedata;
    }

    public List<T> getResults() {
        return results;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setMetedata(Metedata metedata) {
        this.metedata = metedata;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    private static class Status {
        private int code;
        private String message;

        public Status(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class Metedata {
        private int resultCount = 0;

        public Metedata(int resultCount) {
            this.resultCount = resultCount;
        }

        public int getResultCount() {
            return resultCount;
        }

        public void setResultCount(int resultCount) {
            this.resultCount = resultCount;
        }
    }


}
