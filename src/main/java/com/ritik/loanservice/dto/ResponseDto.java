package com.ritik.loanservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@AllArgsConstructor
@Schema(description = "Response DTO for API operations")
public class ResponseDto {

    @Schema(description = "Status code of the operation", example = "200")
    private String statusCode;

    @Schema(description = "Status message describing the operation result", example = "Operation completed successfully")
    private String statusMsg;

}