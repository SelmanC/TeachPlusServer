package com.teachplus.Repository;

import com.teachplus.Entity.Stundenplan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface StundenplanRepository extends JpaRepository<Stundenplan, Long> {

    @Query(value = "SELECT * FROM stundenplan s WHERE s.class_id in :groupIds", nativeQuery = true)
    public Collection<Stundenplan> findByGroupIds(@Param("groupIds") Long[] groupIds);
}
