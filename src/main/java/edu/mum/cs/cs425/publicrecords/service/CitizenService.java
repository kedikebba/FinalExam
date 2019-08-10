package edu.mum.cs.cs425.publicrecords.service;

import edu.mum.cs.cs425.publicrecords.model.Citizen;

import java.util.List;

public interface CitizenService {

    public abstract List<Citizen> listCitizens();
    public abstract Citizen saveCitizen(Citizen citizen);
    public abstract Double totalIncome(List<Citizen> citizens);

}
