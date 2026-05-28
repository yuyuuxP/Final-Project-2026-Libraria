package com.libraria.models;

public class Member extends User {
    private String secretquestion;
    private String secretanswer;
    
    public Member() {}

    public Member(String email, String password) {
        super(email, password);
    }

    public Member(String email, String password, String secretquestion, String secretanswer) {
        super(email, password);
        this.secretquestion = secretquestion;
        this.secretanswer = secretanswer;
    }

    public String getEmail() {
        return email;
    }

    public String getSecretquestion() {
        return secretquestion;
    }
    
    public String getSecretanswer() {
        return secretanswer;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSecretquestion(String secretquestion) {
        this.secretquestion = secretquestion;
    }

    public void setSecretanswer(String secretanswer) {
        this.secretanswer = secretanswer;
    }
}