package edu.mum.cs.cs425.publicrecords.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "CITIZENS")
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long citizenId;

    @NotNull(message = "*Social Security Number is Required!")
    private String socialSecurityNumber;
    @NotNull(message = "*First Name is Required!")
    private String firstName;

    private String middleName;
    @NotNull(message = "*Last Name is Required!")
    private String lastName;

    @NotNull(message = "*Date of Birth is Required!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @Digits(integer = 9, fraction = 2, message = "* Balance must be a numeric/monetary amount in decimal format")
    @NumberFormat(pattern = "#,###.##")
    private Double yearlyIncome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stateId")
    private State state;

    public Citizen() {
    }

    public Citizen(@NotNull(message = "*Social Security Number is Required!") String socialSecurityNumber, @NotNull(message = "*First Name is Required!") String firstName, String middleName, @NotNull(message = "*Last Name is Required!") String lastName, @NotNull(message = "*Date of Birth is Required!") LocalDate dateOfBirth, @NotNull(message = "*Income is Required!") Double yearlyIncome, State state) {
        this.socialSecurityNumber = socialSecurityNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.yearlyIncome = yearlyIncome;
        this.state = state;
    }

    public Long getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Long citizenId) {
        this.citizenId = citizenId;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Double getYearlyIncome() {
        return yearlyIncome;
    }

    public void setYearlyIncome(Double yearlyIncome) {
        this.yearlyIncome = yearlyIncome;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "citizenId=" + citizenId +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", yearlyIncome=" + yearlyIncome +
                ", state=" + state +
                '}';
    }
}
