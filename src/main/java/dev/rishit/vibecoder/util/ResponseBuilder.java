package dev.rishit.vibecoder.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ResponseBuilder {

    public ResponseEntity<Map<String, Object>> buildOkResponse(Object data){
        return ResponseEntity.ok(Map.of(
                "status", "success",
                "data", data
        ));
    }

    public ResponseEntity<Map<String, Object>> buildCreatedResponse(Object data){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Map.of(
                        "status", "sucess",
                        "data", data
                )
        );
    }

}
