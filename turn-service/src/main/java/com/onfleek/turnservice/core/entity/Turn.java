package com.onfleek.turnservice.core.entity;

import java.util.Date;

public class Turn {

    private String id;

    private String source;

    private String target;

    private String status;

    private String gitUrl;

    private Date requestDate;

    private Date finishDate;

    public Turn() {}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public String toString() {
        return "Turn{" +
                "id='" + id + '\'' +
                ", source='" + source + '\'' +
                ", target='" + target + '\'' +
                ", status='" + status + '\'' +
                ", gitUrl='" + gitUrl + '\'' +
                ", requestDate=" + requestDate +
                ", finishDate=" + finishDate +
                '}';
    }
}
