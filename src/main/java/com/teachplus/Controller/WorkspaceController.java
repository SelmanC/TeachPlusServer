package com.teachplus.Controller;

import com.teachplus.Entity.Workspace;
import com.teachplus.Service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workspaces")
public class WorkspaceController {

    @Autowired
    WorkspaceService workspaceService;

    @GetMapping
    public ResponseEntity getWorkspaceByName(@RequestParam("name") String name) {
        Workspace workspace = workspaceService.getWorkspaceByName(name);

        if (workspace == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(workspace);
    }

}
