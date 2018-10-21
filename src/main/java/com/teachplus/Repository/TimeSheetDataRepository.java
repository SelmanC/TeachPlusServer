package com.teachplus.Repository;

import com.teachplus.Entity.TimeSheetData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSheetDataRepository extends JpaRepository<TimeSheetData, Long> {
}
