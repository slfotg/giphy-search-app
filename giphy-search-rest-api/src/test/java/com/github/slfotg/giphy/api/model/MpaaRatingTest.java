package com.github.slfotg.giphy.api.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MpaaRatingTest {

    @Test
    public void testFromCode() {
        assertThat(MpaaRating.fromCode("y"), equalTo(MpaaRating.Y));
        assertThat(MpaaRating.fromCode("g"), equalTo(MpaaRating.G));
        assertThat(MpaaRating.fromCode("pg"), equalTo(MpaaRating.PG));
        assertThat(MpaaRating.fromCode("pg-13"), equalTo(MpaaRating.PG_13));
        assertThat(MpaaRating.fromCode("r"), equalTo(MpaaRating.R));
        assertThat(MpaaRating.fromCode("unrated"), equalTo(MpaaRating.UNRATED));
        assertThat(MpaaRating.fromCode("nsfw"), equalTo(MpaaRating.NSFW));
    }

    @Test
    public void testGetCode() {
        assertThat(MpaaRating.Y.getCode(), equalTo("y"));
        assertThat(MpaaRating.G.getCode(), equalTo("g"));
        assertThat(MpaaRating.PG.getCode(), equalTo("pg"));
        assertThat(MpaaRating.PG_13.getCode(), equalTo("pg-13"));
        assertThat(MpaaRating.R.getCode(), equalTo("r"));
        assertThat(MpaaRating.UNRATED.getCode(), equalTo("unrated"));
        assertThat(MpaaRating.NSFW.getCode(), equalTo("nsfw"));
    }
}
