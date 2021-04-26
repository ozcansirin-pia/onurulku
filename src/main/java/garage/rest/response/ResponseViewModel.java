package garage.rest.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import garage.enums.ResponseStatus;

import java.io.Serializable;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseViewModel implements Serializable {

    private static final long serialVersionUID = -34537847565621525L;
    private int statusCode;

    private ResponseStatus status;

    private Optional<String> error;

    private Object data;

    public ResponseViewModel(){}

    public ResponseViewModel(int statusCode, ResponseStatus status, Optional<String> error, Object data) {
        this.statusCode = statusCode;
        this.status = status;
        this.error = error;
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public Optional<String> getError() {
        return error;
    }

    public void setError(Optional<String> error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
