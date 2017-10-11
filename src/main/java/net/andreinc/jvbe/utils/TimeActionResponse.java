package net.andreinc.jvbe.utils;

public class TimeActionResponse<T> {

    private T response;
    private long time;

    public TimeActionResponse(T response, long time) {
        this.response = response;
        this.time = time;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
