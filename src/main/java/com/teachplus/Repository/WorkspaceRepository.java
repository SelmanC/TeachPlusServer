package com.teachplus.Repository;

import com.teachplus.Entity.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {
    public Workspace findWorkspaceByName(String name);
}
