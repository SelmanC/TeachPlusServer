package com.teachplus.Entity;

import com.fasterxml.jackson.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user_groups")
@JsonIgnoreProperties(value={ "absenceLists", "groupMember", "hibernateLazyInitializer", "handler" }, allowSetters= true)
public class Group {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @Column(length=30)
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "groupOwner")
    private Collection<GroupMember> groupOwner;

    @OneToMany(mappedBy = "groupMember")
    private Collection<GroupMember> groupMember;

    @OneToMany(mappedBy = "groupClass", cascade = CascadeType.REMOVE)
    private Collection<AbsenceList> absenceLists;

    @Value("${some.key:group}")
    @Column(length=30)
    private String role;

    public Group() {}

    public Group(long id, String name, Collection<GroupMember> groupOwner, Collection<GroupMember> groupMember, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<GroupMember> getGroupOwner() {
        return groupOwner;
    }

    public void setGroupOwner(Collection<GroupMember> groupOwner) {
        this.groupOwner = groupOwner;
    }

    public Collection<GroupMember> getGroupMember() {
        return groupMember;
    }

    public void setGroupMember(Collection<GroupMember> groupMember) {
        this.groupMember = groupMember;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Collection<AbsenceList> getAbsenceLists() {
        return absenceLists;
    }

    public void setAbsenceLists(Collection<AbsenceList> absenceLists) {
        if(absenceLists == null) {
            this.absenceLists.clear();
        }
        else {
            this.absenceLists.addAll(absenceLists);
        }
    }
}
