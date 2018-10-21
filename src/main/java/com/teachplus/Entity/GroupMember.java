package com.teachplus.Entity;

import com.fasterxml.jackson.annotation.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "group_members")
@JsonIgnoreProperties(value={ "hibernateLazyInitializer", "handler" }, allowSetters= true)
public class GroupMember {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonBackReference
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="group_owner_id")
    private Group groupOwner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_member_id")
    private User userMember;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="group_member_id")
    private Group groupMember;

    public GroupMember() {}

    public GroupMember(long id, Group groupOwner, User userMember, Group groupMember) {
        this.id = id;
        this.groupOwner = groupOwner;
        this.userMember = userMember;
        this.groupMember = groupMember;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Group getGroupOwner() {
        return groupOwner;
    }

    public void setGroupOwner(Group groupOwner) {
        this.groupOwner = groupOwner;
    }

    public User getUserMember() {
        return userMember;
    }

    public void setUserMember(User userMember) {
        this.userMember = userMember;
    }

    public Group getGroupMember() {
        return groupMember;
    }

    public void setGroupMember(Group groupMember) {
        this.groupMember = groupMember;
    }
}
