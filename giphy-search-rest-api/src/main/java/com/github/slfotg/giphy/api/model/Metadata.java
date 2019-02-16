package com.github.slfotg.giphy.api.model;

import java.io.Serializable;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * The Meta Object contains basic information regarding the request, whether it
 * was successful, and the response given by the API
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Metadata implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;
    private Integer status;
    private String responseId;

    /**
     * Get the HTTP Response Message
     * 
     * @return the HTTP Response Message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set the HTTP Response Message
     * 
     * @param message the HTTP Response Message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Get the HTTP Response Code
     * 
     * @return the HTTP Response Code
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Set the HTTP Response Code
     * 
     * @param status the HTTP Response Code
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * Get the unique ID paired with this response from the API
     * 
     * @return the unique ID paired with this response from the API
     */
    public String getResponseId() {
        return responseId;
    }

    /**
     * Set the unique ID paired with this response from the API
     * 
     * @param responseId the unique ID paired with this response from the API
     */
    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

}
