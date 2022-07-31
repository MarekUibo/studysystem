package com.sda.studysystem.repositories;

import com.sda.studysystem.models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * to handle the Scmodel
 *
 * @author Marek Uibo
 */

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {

    Optional<School> findByName(String name);
}
