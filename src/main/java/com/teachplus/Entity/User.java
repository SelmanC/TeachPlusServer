package com.teachplus.Entity;

import com.fasterxml.jackson.annotation.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Collection;

//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
@Entity
@Table(name = "users")
@JsonIgnoreProperties(value={ "children", "parents", "password", "hibernateLazyInitializer", "handler" }, allowSetters= true)
public class User {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @Column(length=30)
    private String name;

    @NonNull
    @Column(length=30)
    private String lastname;

    @NonNull
    @Column(unique = true, length = 250)
    private String email;

    @NonNull
    @Column(length = 30)
    private String password;

    @NonNull
    @Column(length=30)
    private String role;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workspace_id")
    private Workspace workspace;

    @ManyToMany
    @JoinTable(name = "family", joinColumns = {
            @JoinColumn(name = "parent", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "child", referencedColumnName = "id", nullable = false)})
    private Collection<User> children;

    @ManyToMany(mappedBy = "children")
    private Collection<User> parents;

    private String strasse;

    private String ort;

    private String land;

    public User() {
    }

    public User(long id, String name, String lastname, String email, String password, String role, String strasse, String ort, String land, Workspace workspace, Collection<User> parents, Collection<User> children) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.workspace = workspace;
        this.strasse = strasse;
        this.ort = ort;
        this.land = land;
        this.parents = parents;
        this.children = children;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Workspace getWorkspace() {
        return workspace;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public Collection<User> getParents() {
        return parents;
    }

    public void setParents(Collection<User> parents) {
        this.parents = parents;
    }

    public Collection<User> getChildren() {
        return children;
    }

    public void setChildren(Collection<User> children) {
        this.children = children;
    }

}
