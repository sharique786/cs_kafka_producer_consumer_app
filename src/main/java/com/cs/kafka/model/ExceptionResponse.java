package com.cs.kafka.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class ExceptionResponse {

    private Date timeStamp;
    private String message;
    List<String> details;

    public ExceptionResponse(Date timeStamp, String message, List<String> details) {
        super();
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }
}
