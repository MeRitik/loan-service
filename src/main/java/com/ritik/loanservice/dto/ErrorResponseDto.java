package com.ritik.loanservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(description = "DTO for error response information")
@Data
@AllArgsConstructor
public class ErrorResponseDto {

    @Schema(description = "API path where error occurred")
    private String apiPath;

    @Schema(description = "HTTP status code of the error", example = "BAD_REQUEST")
    private HttpStatus errorCode;

    @Schema(description = "Detailed error message", example = "Invalid loan amount provided")
    private String errorMessage;

    @Schema(description = "Timestamp when error occurred", example = "2024-01-01T12:00:00")
    private LocalDateTime errorTime;

}