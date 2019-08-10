package edu.mum.cs.cs425.publicrecords.repository;

import edu.mum.cs.cs425.publicrecords.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStateRepository extends JpaRepository<State, Integer> {
}
