package com.teachplus.Repository;

import com.teachplus.Entity.TimeRow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRowRepository extends JpaRepository<TimeRow, Long> {
}
