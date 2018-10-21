package com.teachplus.Repository;

import com.teachplus.Entity.AbsenceList;
import com.teachplus.Entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AbsenceRepository extends JpaRepository<AbsenceList, Long>  {
    @Query(value="SELECT * FROM absences a INNER JOIN absence_teacher at ON at.absence_list= a.id where at.teacher = :teacherId", nativeQuery = true)
    public Collection<AbsenceList> findByTeacherId(@Param("teacherId") Long teacherId);

    @Modifying
    @Query(value="INSERT into absence_teacher (absence_list, teacher) VALUES (:absenceListId, :teacherId)", nativeQuery = true)
    public void createAbsenceListTeacher(@Param("absenceListId") Long absenceListId, @Param("teacherId") Long teacherId);

}
