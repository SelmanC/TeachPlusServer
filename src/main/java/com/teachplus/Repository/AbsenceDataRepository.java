package com.teachplus.Repository;

import com.teachplus.Entity.AbsenceData;
import com.teachplus.Entity.AbsenceList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbsenceDataRepository extends JpaRepository<AbsenceData, Long> {
    public List<AbsenceData> findByAbsenceListIdAndMonth(Long absenceListId, int month);
}
