package mts.mtech.appointments.dto;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

/**
 * @author Mitchell Tawanda Severa
 * 10/17/18
 * 11:26 PM
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Data
public class ResponseWrapper<T> implements Serializable {
    private boolean success;
    private String message;
    private T data;

    public  ResponseWrapper<T> buildSuccessResponse(String message) {
        this.success = true;
        this.message = message;
        this.data = null;
        return this;
    }

    public ResponseWrapper<T> buildSuccessResponse(String message, final T result) {
        this.success = true;
        this.message = message;
        this.data = result;
        return this;
    }

    public ResponseWrapper<T> buildErrorResponse(String message) {
        this.success = false;
        this.message = message;
        this.data = null;
        return this;
    }

    public ResponseEntity<ResponseWrapper<T>> toResponseEntity(HttpStatus status) {
        return new ResponseEntity<>(this, status);
    }
}