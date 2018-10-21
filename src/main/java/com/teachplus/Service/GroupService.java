package com.teachplus.Service;

import com.teachplus.Entity.Group;
import com.teachplus.Entity.GroupMember;
import com.teachplus.Entity.User;
import com.teachplus.Repository.GroupMemberRepository;
import com.teachplus.Repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
public class GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    GroupMemberRepository groupMemberRepository;

    public Collection<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group getGroupById(long id) {
        Group group = groupRepository.getOne(id);
        Collection<GroupMember> groupMembers = groupMemberRepository.findByGroupOwnerId(id);
        group.setGroupMember(groupMembers);
        return group;
    }

    public Collection<Group> getGroupsByUserId(long userId) {
        Collection<Group> groups = groupRepository.findByUserMemberId(userId);
        return groups;
    }


    public Group addGroup(Group group) {
        return groupRepository.save(group);
    }

    @Transactional
    public Collection<GroupMember> addGroupMember(Long groupid, Collection<GroupMember> groupMemberList) {
        Group currGroup = groupRepository.getOne(groupid);
        groupMemberRepository.deleteByGroupOwnerId(groupid);

        for(GroupMember groupMember : groupMemberList) {
            groupMember.setGroupOwner(currGroup);
        }

        return groupMemberRepository.saveAll(groupMemberList);
    }

    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }
}
