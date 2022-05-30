package team7.capstone.web;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter @Setter @Slf4j
public class ResponseError {

    private Map<String, String> errors;

    public ResponseError() {
        this.errors = new ConcurrentHashMap<>();
    }

    public void put(String target, String message) {
        errors.put(target, message);
    }

}
