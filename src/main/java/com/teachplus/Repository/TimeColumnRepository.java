package com.teachplus.Repository;

import com.teachplus.Entity.TimeColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeColumnRepository extends JpaRepository<TimeColumn, Long> {
}
