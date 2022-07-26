package com.sda.studysystem.handlers.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Model for Error Response
 *
 * @author Marek Uibo
 */

@Data
@AllArgsConstructor
public class ErrorResponse {

    private String message;
    private List<String> details;
}
