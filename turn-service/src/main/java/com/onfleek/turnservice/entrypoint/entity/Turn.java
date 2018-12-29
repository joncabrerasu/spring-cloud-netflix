package com.onfleek.turnservice.entrypoint.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Turn {

    private String id;

    private String source;

    private String target;

    private String status;

    @JsonProperty("git_url")
    private String gitUrl;

    @JsonProperty("request_date")
    private Date requestDate;

    @JsonProperty("finish_date")
    private Date finishDate;

}
