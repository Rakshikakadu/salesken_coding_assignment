package com.salesken.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMarksSemesterWiseRepo extends JpaRepository<StudentMarksSemesterWiseRepo, Integer>{

}
