package com.spds.rcms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.spds.rcms.dto.GenericResponse;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;


/***
 * 
 * @author abinjola This class was creaded on 08-Dec-2024.
 */
@ControllerAdvice
@Slf4j
public class GlobleExceptionHandler {
	
	
	/*********************Changes by Harsh Raj for adding custom Exception**************************/
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND) // Return 404 Not Found status
	@ResponseBody
	public GenericResponse<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
	    log.error("Resource not found: {}", ex.getMessage());
	    
	    return new GenericResponse<>(
	        true, 
	        ex.getMessage(), 
	        null, 
	        null 
	    );
	}

	
	/*********************Changes by Harsh Raj for adding custom Exception End **************************/
	
	
	
	@ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)  // You can set the appropriate HTTP status (403 Forbidden)
    @ResponseBody
    public ErrorResponse handleAccessDeniedException(AccessDeniedException ex) {
        // Customize your response message or structure here
		log.error("FORBIDDEN");
        return new ErrorResponse("Access Denied", "You do not have permission to access this resource");
    }
	
	@ExceptionHandler(ExpiredJwtException .class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)  // You can set the appropriate HTTP status (403 Forbidden)
    @ResponseBody
    public ErrorResponse handleExpiredJwtException(ExpiredJwtException  ex) {
        // Customize your response message or structure here
		log.error("UNAUTHORIZED");
        return new ErrorResponse("Access Denied", "JWT token has expired. Please login again.");
    }

    // Define other exceptions here if needed
	@Data
    static class ErrorResponse {
        private String error;
        private String message;

        public ErrorResponse(String error, String message) {
            this.error = error;
            this.message = message;
        }

        // Getters and setters
    }

}
