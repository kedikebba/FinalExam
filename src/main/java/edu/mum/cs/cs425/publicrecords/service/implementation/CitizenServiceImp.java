package edu.mum.cs.cs425.publicrecords.service.implementation;

import edu.mum.cs.cs425.publicrecords.model.Citizen;
import edu.mum.cs.cs425.publicrecords.repository.ICitizenRepository;
import edu.mum.cs.cs425.publicrecords.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenServiceImp implements CitizenService {

    @Autowired
    private ICitizenRepository iCitizenRepository;

    @Override
    public List<Citizen> listCitizens() {
        return iCitizenRepository.findAll(Sort.by("lastName"));
    }

    @Override
    public Citizen saveCitizen(Citizen citizen) {
        return iCitizenRepository.save(citizen);
    }

    @Override
    public Double totalIncome(List<Citizen> citizens) {
        Double total = 0.0;
        for(Citizen citizen: citizens){
            total+=citizen.getYearlyIncome();
        }
        return total;
    }
}
