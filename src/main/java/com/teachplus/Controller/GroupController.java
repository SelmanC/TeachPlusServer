package com.teachplus.Controller;

import com.teachplus.Entity.Group;
import com.teachplus.Entity.GroupMember;
import com.teachplus.Service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    GroupService groupService;

    @GetMapping(produces = { "application/json" })
    public ResponseEntity getAllGroups() {
        Collection<Group> allGroups = groupService.getAllGroups();

        if (allGroups == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(allGroups);
    }

    @GetMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity getGroupById(@PathVariable("id") long id) {
        Group group = groupService.getGroupById(id);

        if (group == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(group);
    }

    @GetMapping(value = "/users/{id}", produces = { "application/json" })
    public ResponseEntity getGroupsByUserId(@PathVariable("id") long id) {
        Collection<Group> group = groupService.getGroupsByUserId(id);

        if (group == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(group);
    }

    @PostMapping(consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity addGroup(@RequestBody Group group) {
        Group savedGroup = groupService.addGroup(group);
        return ResponseEntity.ok().body(savedGroup);
    }

    @PostMapping(value="/{id}/members", consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity addGroupList(@PathVariable("id") long id, @RequestBody List<GroupMember> groupMemberList) {
        Collection<GroupMember> savedGroupMemberList = groupService.addGroupMember(id, groupMemberList);
        return ResponseEntity.ok().body(savedGroupMemberList);
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable("id") long id) {
        groupService.deleteGroup(id);
    }
}
