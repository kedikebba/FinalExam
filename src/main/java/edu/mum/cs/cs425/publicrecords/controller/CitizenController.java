package edu.mum.cs.cs425.publicrecords.controller;

import edu.mum.cs.cs425.publicrecords.model.Citizen;
import edu.mum.cs.cs425.publicrecords.service.CitizenService;
import edu.mum.cs.cs425.publicrecords.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CitizenController {

    @Autowired
    private CitizenService citizenService;

    @Autowired
    private StateService stateService;

    @GetMapping(value = "/publicrecords/citizen/list")
    public String displayCitizens(Model model){
        List<Citizen> citizens = citizenService.listCitizens();
        Double totalIncome = citizenService.totalIncome(citizens);
        model.addAttribute("citizens",citizens);
        model.addAttribute("totalIncome",totalIncome);
        return "citizen/list";
    }

    @GetMapping(value = "/publicrecords/citizen/new")
    public String createNewCitizenForm(Model model){
        model.addAttribute("citizen", new Citizen());
        model.addAttribute("states", stateService.listStates());
        return "citizen/new";
    }

    @PostMapping(value = "/publicrecords/citizen/new")
    public String createNewCitizen(@Valid @ModelAttribute("citizen") Citizen citizen, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "citizen/new";
        }
        citizen = citizenService.saveCitizen(citizen);
        return"redirect:/publicrecords/citizen/list";
    }


}
