package com.teachplus.Controller;

import com.teachplus.Entity.AbsenceData;
import com.teachplus.Entity.AbsenceList;
import com.teachplus.Entity.Note;
import com.teachplus.Service.AbsenceService;
import com.teachplus.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/absences")
public class AbsenceController {
    @Autowired
    AbsenceService absenceService;

    @GetMapping(value="/teacher/{teacherId}", produces = { "application/json" })
    public ResponseEntity getAbsenceListByTeacherId(@PathVariable("teacherId") Long teacherId) {
        Collection<AbsenceList> absences = absenceService.getAbsenceListOverTeacherId(teacherId);
        if (absences == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(absences);
    }

    @GetMapping(value="/{id}/data", produces = { "application/json" })
    public ResponseEntity getAbsenceDataByAbsenceList(@PathVariable("id") Long id, @RequestParam("month") Integer month) {
        Collection<AbsenceData> absenceData = absenceService.getAbsenceDataByAbsenceList(id, month);
        System.out.println("getAbsenceDataByAbsenceList: " + absenceData.size());
        if (absenceData == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(absenceData);
    }

    @PostMapping(consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity addAbsenceList(@RequestBody AbsenceList absenceList) {
        AbsenceList newAbsenceList = absenceService.addAbsenceList(absenceList);
        return ResponseEntity.ok().body(newAbsenceList);
    }

    @PostMapping(value="/{id}/teacher/{teacherId}", consumes = { "application/json" }, produces = { "application/json" })
    public void addAbsenceListTeacher(@PathVariable("id") Long id, @PathVariable("teacherId") Long teacherId) {
        absenceService.createAbsenceListTeacher(id, teacherId);
    }

    @PostMapping(value="/data", consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity addAbsenceData(@RequestBody AbsenceData absenceData) {
        AbsenceData newAbsenceData = absenceService.addAbsenceData(absenceData);
        return ResponseEntity.ok().body(newAbsenceData);
    }

}
