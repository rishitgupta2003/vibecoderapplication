package dev.rishit.vibecoder.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ResponseBuilder {

    public ResponseEntity<Map<String, Object>> buildOkResponse(Object data){
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "status", "success",
                "data", data
        ));
    }

    public ResponseEntity<Map<String, Object>> buildCreatedResponse(Object data){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Map.of(
                        "status", "success",
                        "data", data
                )
        );
    }

    public ResponseEntity<Map<String, Object>> buildConflictResponse(Object data){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                Map.of(
                        "status", "error",
                        "message", data
                )
        );
    }

    public ResponseEntity<Map<String, Object>> buildExpectationFailed(Object data){
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(
                Map.of(
                        "status", "error",
                        "message", data
                )
        );
    }

    public ResponseEntity<Map<String, Object>> buildBadRequestResponse(Object data){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Map.of(
                        "status", "error",
                        "message", data
                )
        );
    }

    public ResponseEntity<Map<String, Object>> buildNotFoundResponse(Object data) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                        "status", "error",
                        "message", data
                )
        );
    }

    public ResponseEntity<Map<String, Object>> buildNoContentResponse(){
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(
                        Map.of(
                                "status", "success",
                                "message", "Requested Operation Executed"
                        )
                );
    }
}
