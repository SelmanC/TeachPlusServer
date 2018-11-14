package com.teachplus.Repository;

import com.teachplus.Entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(value = "SELECT * FROM messages m WHERE m.to_group_id in :groupIds", nativeQuery = true)
    public List<Message> getMessageByToGroupIds(@Param("groupIds") Long[] groupIds);

    @Query(value = "SELECT * FROM messages m WHERE m.to_group_id in :groupIds or m.from_id = :userId or m.to_user_id = :userId order by m.created_at ASC", nativeQuery = true)
    public List<Message> getAllMessages(@Param("groupIds") Long[] groupIds, @Param("userId") Long userId);

    public List<Message> getMessageByFromId(Long fromId);

    public List<Message> getMessageByToUserId(Long toUserId);

}
