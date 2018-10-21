package com.teachplus.Controller;

import com.teachplus.Entity.Vertretung;
import com.teachplus.Service.VertretungsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vertretung")
public class VetretungsController {
    @Autowired
    VertretungsService vertretungsService;

    @GetMapping(produces = { "application/json" })
    public ResponseEntity getVertretungByGroupId(@RequestParam("groupId") Long[] groupIds) {
        Map<String, Map<String, List<Vertretung>>> vertretungen = vertretungsService.getVertretungByGroupId(groupIds);
        if (vertretungen == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(vertretungen);

    }

    @PostMapping(consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity addVertretung(@RequestBody Vertretung vertretung) {
        Vertretung newVertretung = vertretungsService.addVertretung(vertretung);
        return ResponseEntity.ok().body(newVertretung);
    }

    @DeleteMapping("/{id}")
    public void deleteVertretung(@PathVariable("id") long id) {
        vertretungsService.deleteVertretung(id);
    }
}
