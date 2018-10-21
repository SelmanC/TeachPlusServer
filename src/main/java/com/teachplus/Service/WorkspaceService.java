package com.teachplus.Service;

import com.teachplus.Entity.User;
import com.teachplus.Entity.Workspace;
import com.teachplus.Repository.UserRepository;
import com.teachplus.Repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkspaceService {
    @Autowired
    WorkspaceRepository workspaceRepository;

    public Workspace getWorkspaceByName(String name) {
        return workspaceRepository.findWorkspaceByName(name);
    }
}
