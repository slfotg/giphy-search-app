package com.github.slfotg.giphy.api.model;

import java.io.Serializable;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * The Pagination Object contains information relating to the number of total
 * results available as well as the number of results fetched and their relative
 * positions.
 *
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Pagination implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer offset;
    private Integer totalCount;
    private Integer count;

    /**
     * Get the position in pagination
     * 
     * @return the position in pagination
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * Set the position in pagination
     * 
     * @param offset the position in pagination
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * Get the total number of items available
     * 
     * @return the total number of items available
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * Set the total number of items available
     * 
     * @param totalCount the total number of items available
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * Get the total number of items returned
     * 
     * @return the total number of items returned
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Set the total number of items returned
     * 
     * @param count the total number of items returned
     */
    public void setCount(Integer count) {
        this.count = count;
    }

}
