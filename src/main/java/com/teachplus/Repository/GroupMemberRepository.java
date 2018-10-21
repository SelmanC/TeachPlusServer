package com.teachplus.Repository;

import com.teachplus.Entity.Group;
import com.teachplus.Entity.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> {
    public Collection<GroupMember> findByGroupOwnerId(Long groupOwnerId);
    public Collection<GroupMember> findByUserMemberId(Long userMemberId);
    public void deleteByGroupOwnerId(Long groupOnwerId);
}
