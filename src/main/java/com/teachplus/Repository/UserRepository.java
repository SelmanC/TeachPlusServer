package com.teachplus.Repository;


import com.teachplus.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Collection<User> findByRole(String role);

    public User findByWorkspaceIdAndEmailIgnoreCaseAndPassword(long workspace, String email, String password);

    @Query(value="SELECT * FROM users c INNER JOIN family f ON f.child=c.id where f.parent = :Id", nativeQuery = true)
    public List<User> findChildren(@Param("Id") Long Id);

    @Modifying
    @Query(value="INSERT into family (parent, child) VALUES (:parentId, :childId)", nativeQuery = true)
    public void createChildren(@Param("parentId") Long parentId, @Param("childId") Long childId);

    @Modifying
    @Query(value="Delete FROM family where parent = :Id", nativeQuery = true)
    public void deleteFamiliyByParent(@Param("Id") Long Id);
}
