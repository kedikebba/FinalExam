package edu.mum.cs.cs425.publicrecords.repository;

import edu.mum.cs.cs425.publicrecords.model.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICitizenRepository extends JpaRepository<Citizen, Long> {


}
