package com.spring.batches.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.batches.domain.Students;

/**************************************************************************
 * Class for
 * @author RSHANMUGAM2:Apr 16, 2020: 11:57:00 AM
 **************************************************************************/
@Repository
public interface StudentsRepository extends JpaRepository<Students, Integer> {

}
