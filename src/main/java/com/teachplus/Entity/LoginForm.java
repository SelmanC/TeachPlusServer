package com.teachplus.Entity;

public class LoginForm {
    private String email;
    private String password;
    private long workspace;

    public LoginForm() { }

    public LoginForm(String email, String password, long workspace) {
        this.email = email;
        this.password = password;
        this.workspace = workspace;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getWorkspace() {
        return workspace;
    }

    public void setWorkspace(long workspace) {
        this.workspace = workspace;
    }
}
