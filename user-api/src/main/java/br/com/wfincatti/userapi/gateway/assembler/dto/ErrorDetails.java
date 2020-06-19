package br.com.wfincatti.userapi.gateway.assembler.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

@Builder
@Getter
public class ErrorDetails {

    private String message;
    private LocalDate timestamp;
    private HttpStatus error;
    private Integer status;
    private String path;

}
