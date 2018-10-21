package com.teachplus.Repository;

import com.teachplus.Entity.Group;
import com.teachplus.Entity.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query(value="SELECT * FROM user_groups g INNER JOIN group_members m ON m.group_owner_id = g.id where m.user_member_id = :userId", nativeQuery = true)
    public Collection<Group> findByUserMemberId(@Param("userId") Long userId);
}
