package com.teachplus.Entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "groupmembers")
public class GroupMembers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private Group groupOwner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private User userMember;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private Group groupMember;
}
