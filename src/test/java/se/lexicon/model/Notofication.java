package se.lexicon.model;

import java.time.LocalDateTime;

public abstract class Notofication {
    //Private fields
    private String id;
    private LocalDateTime createDateTime;
    private boolean status;

    //No constructor- we will use the default constructor


    //Getters and setter for all fields

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    //to string

    @Override
    public String toString() {
        return "Notofication{" +
                "id='" + id + '\'' +
                ", createDateTime=" + createDateTime +
                ", status=" + status +
                '}';
    }

    //  abstract method for summary
    public abstract String summary();
}
