package com.teachplus.Repository;

import com.teachplus.Entity.Vertretung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.Date;

@Repository
public interface VertretungsRepository extends JpaRepository<Vertretung, Long> {

    @Query(value = "SELECT * FROM vertretungen v WHERE v.group_class_id in :groupIds AND v.date >= :date ORDER BY v.date, v.group_class_id ASC", nativeQuery = true)
    public Collection<Vertretung> findByGroupIdGroupByDate(@Param("groupIds") Long[] groupIds, @Param("date") Date date);

}
