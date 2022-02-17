package com.example.final_project.repos;

import com.example.final_project.domain.Massage;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MassageRepo extends CrudRepository<Massage, Integer> {

    List<Massage> findByTag(String tag);
}
