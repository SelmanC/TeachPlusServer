package com.teachplus.Service;

import com.teachplus.Entity.Stundenplan;
import com.teachplus.Entity.TimeColumn;
import com.teachplus.Entity.TimeRow;
import com.teachplus.Entity.TimeSheetData;
import com.teachplus.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.Collection;
import java.util.List;

@Service
public class StundenplanService {
    @Autowired
    StundenplanRepository stundenplanRepository;

    @Autowired
    TimeColumnRepository timeColumnRepository;

    @Autowired
    TimeRowRepository timeRowRepository;

    @Autowired
    TimeSheetDataRepository timeSheetDataRepository;

    public Collection<Stundenplan> findByGroupClassIds(Long[] groupIds) {
        return stundenplanRepository.findByGroupIds(groupIds);
    }

    public Stundenplan getStundenplanById(Long id) {
        return stundenplanRepository.findById(id).get();
    }


    public Stundenplan addStundenplan(Stundenplan stundenplan) {
        return stundenplanRepository.save(stundenplan);
    }

    public TimeColumn addStundenplanColumn(TimeColumn timeColumn) {
        return timeColumnRepository.save(timeColumn);
    }

    @Transactional
    public List<TimeColumn> addStundenplanColumns(List<TimeColumn> timeColumns) {
        return timeColumnRepository.saveAll(timeColumns);
    }

    public TimeRow addStundenplanRow(TimeRow timeRow) {
        return timeRowRepository.save(timeRow);
    }

    @Transactional
    public List<TimeRow> addStundenplanRows(List<TimeRow> timeRows) {
        return timeRowRepository.saveAll(timeRows);
    }


    @Transactional
    public List<TimeSheetData> addStundenplanData(List<TimeSheetData> timeSheetData) {
        return timeSheetDataRepository.saveAll(timeSheetData);
    }

    public void deleteStundenplan(Long id) {
        stundenplanRepository.deleteById(id);
    }

    public void deleteStundenplanColumn(Long id) {
        timeColumnRepository.deleteById(id);
    }

    public void deleteStundenplanRow(Long id) {
        timeRowRepository.deleteById(id);
    }

    public void deleteStundenplanData(Long id) {
        timeSheetDataRepository.deleteById(id);
    }

}
