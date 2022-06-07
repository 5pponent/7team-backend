package team7.capstone.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * 에러 코드, 데이터 반환 폼
 */
public class ResponseForm {
    
    public static <T> ResponseEntity<T> ok(T data) {
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    public static <T> ResponseEntity<T> notFound(T data) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
    }

    public static <T> ResponseEntity<T> badRequest(T data) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(data);
    }

    public static <T> ResponseEntity<T> internalServerError(T data) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(data);
    }
}
