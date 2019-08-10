package edu.mum.cs.cs425.publicrecords.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "STATES")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer stateId;

    @NotNull(message = "*StateCode is required, should be 3 Characters")
    private String stateCode;

    @NotNull(message = "*State Name is Required!")
    private String stateName;

    public State() {
    }

    public State(@NotNull(message = "*StateCode is required, should be 3 Characters") String stateCode, @NotNull(message = "*State Name is Required!") String stateName) {
        this.stateCode = stateCode;
        this.stateName = stateName;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public String toString() {
        return "State{" +
                "stateId=" + stateId +
                ", stateCode='" + stateCode + '\'' +
                ", stateName='" + stateName + '\'' +
                '}';
    }

    public String getStateDetails(){
        return stateCode + " - " + stateName;
    }
}
