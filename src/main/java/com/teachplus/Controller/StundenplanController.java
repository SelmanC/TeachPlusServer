package com.teachplus.Controller;

import com.teachplus.Entity.TimeColumn;
import com.teachplus.Entity.TimeRow;
import com.teachplus.Entity.TimeSheetData;
import com.teachplus.Entity.Stundenplan;
import com.teachplus.Service.StundenplanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/timesheets")
public class StundenplanController {

    @Autowired
    StundenplanService stundenplanService;

    @GetMapping(produces = { "application/json" })
    public ResponseEntity getStundenplanByGroupId(@RequestParam("groupId") Long[] groupIds) {
        Collection<Stundenplan> stundenplaene = stundenplanService.findByGroupClassIds(groupIds);
        if (stundenplaene == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(stundenplaene);
    }

    @GetMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity getStundenplanById(@PathVariable("id") long id) {
        Stundenplan stundenplan = stundenplanService.getStundenplanById(id);
        if (stundenplan == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(stundenplan);
    }

    @PostMapping(consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity addStundenplan(@RequestBody Stundenplan stundenplan) {
        Stundenplan newStundenplan = stundenplanService.addStundenplan(stundenplan);
        return ResponseEntity.ok().body(newStundenplan);
    }

    @PostMapping(value="/data/column", consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity addStundenplanColumn(@RequestBody TimeColumn timeColumn) {
        TimeColumn newStundenplanColumn = stundenplanService.addStundenplanColumn(timeColumn);
        return ResponseEntity.ok().body(newStundenplanColumn);
    }

    @PostMapping(value="/data/columns", consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity addStundenplanColumns(@RequestBody List<TimeColumn> timeColumns) {
        List<TimeColumn> newStundenplanColumns = stundenplanService.addStundenplanColumns(timeColumns);
        return ResponseEntity.ok().body(newStundenplanColumns);
    }

    @PostMapping(value="/data/row", consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity addStundenplanRow(@RequestBody TimeRow timeRow) {
        TimeRow newStundenplanRow = stundenplanService.addStundenplanRow(timeRow);
        return ResponseEntity.ok().body(newStundenplanRow);
    }

    @PostMapping(value="/data/rows", consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity addStundenplanRows(@RequestBody List<TimeRow> timeRows) {
        List<TimeRow> newStundenplanRows = stundenplanService.addStundenplanRows(timeRows);
        return ResponseEntity.ok().body(newStundenplanRows);
    }

    @PostMapping(value="/data/row/subjects", consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity addStundenplanData(@RequestBody List<TimeSheetData> timeSheetData) {
        List<TimeSheetData> newStundenplanData = stundenplanService.addStundenplanData(timeSheetData);
        return ResponseEntity.ok().body(newStundenplanData);
    }

    @DeleteMapping("/{id}")
    public void deleteStundenplan(@PathVariable("id") long id) {
        stundenplanService.deleteStundenplan(id);
    }

    @DeleteMapping("/data/column/{id}")
    public void deleteStundenplanColumn(@PathVariable("id") long id) {
        stundenplanService.deleteStundenplanColumn(id);
    }

    @DeleteMapping("/data/row/{id}")
    public void deleteStundenplanRow(@PathVariable("id") long id) {
        stundenplanService.deleteStundenplanRow(id);
    }

    @DeleteMapping("/data/row/subjects/{id}")
    public void deleteStundenplanData(@PathVariable("id") long id) {
        stundenplanService.deleteStundenplanData(id);
    }
}
