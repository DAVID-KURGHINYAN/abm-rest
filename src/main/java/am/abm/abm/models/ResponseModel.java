package am.abm.abm.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ResponseModel<T> implements Serializable {
    private T data;
    private boolean success;
    private List<String> message;

}
