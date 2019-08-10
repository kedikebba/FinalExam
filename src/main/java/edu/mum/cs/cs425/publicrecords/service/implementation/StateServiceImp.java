package edu.mum.cs.cs425.publicrecords.service.implementation;

import edu.mum.cs.cs425.publicrecords.model.State;
import edu.mum.cs.cs425.publicrecords.repository.IStateRepository;
import edu.mum.cs.cs425.publicrecords.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImp implements StateService {

    @Autowired
    private IStateRepository iStateRepository;


    @Override
    public List<State> listStates() {
        return iStateRepository.findAll();
    }
}
