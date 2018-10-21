package com.teachplus.Service;

import com.teachplus.Entity.AbsenceData;
import com.teachplus.Entity.AbsenceList;
import com.teachplus.Repository.AbsenceDataRepository;
import com.teachplus.Repository.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class AbsenceService {
    @Autowired
    AbsenceRepository absenceRepository;

    @Autowired
    AbsenceDataRepository absenceDataRepository;

    public Collection<AbsenceList> getAbsenceListOverTeacherId(Long teacherId) {
        return absenceRepository.findByTeacherId(teacherId);
    }

    public Collection<AbsenceData> getAbsenceDataByAbsenceList(Long absenceListId, int month) {
        return absenceDataRepository.findByAbsenceListIdAndMonth(absenceListId, month);
    }

    @Transactional
    public void createAbsenceListTeacher(Long absenceListId, Long teacherId) {
        absenceRepository.createAbsenceListTeacher(absenceListId, teacherId);
    }

    public AbsenceList addAbsenceList(AbsenceList absenceList) {
        return absenceRepository.save(absenceList);
    }

    public AbsenceData addAbsenceData(AbsenceData absenceData) {
        return absenceDataRepository.save(absenceData);
    }
}
