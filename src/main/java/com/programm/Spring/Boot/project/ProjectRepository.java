package com.programm.Spring.Boot.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Optional<Project> findByNameIgnoreCase(String name);

    @Query("select p from Project p where upper(p.name) = upper(?1)")
    Optional<Project> findByName(String name);

    @Query("select p from Project p where upper(p.name) = upper(?1)")
    Collection<Project> findByAllName(String name);
}