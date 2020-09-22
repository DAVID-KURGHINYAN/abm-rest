package am.abm.abm.models;

import java.io.Serializable;
import java.util.List;

public class ResponseModel<T> implements Serializable {
    private T data;
    private boolean success;
    private List<String> message;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
}
