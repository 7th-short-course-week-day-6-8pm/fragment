package com.rathana.fragment_demo.eventbus;

import android.app.Person;

import java.util.List;

public class Contact {
    private String email;
    public Contact(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
