package com.interviewpanel.repository;

import com.interviewpanel.models.Credentials;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CredentialsRepository {
    private final List<Credentials> credentialsList = new ArrayList<>();
    private Map<Integer, Credentials> credentialsMap = new HashMap<>();

    private static CredentialsRepository credentialsRepository;

    private CredentialsRepository() {
        Credentials adminCred = new Credentials(1,"admin", "admin");
        credentialsList.add(adminCred);
    }

    public static CredentialsRepository getInstance() {
        if (credentialsRepository == null) {
            credentialsRepository = new CredentialsRepository();
        }
        return credentialsRepository;
    }

    public boolean checkIfUsernamePresent(String username) {
        return credentialsList.stream().anyMatch(cred -> cred.getUsername().equals(username));
    }
    public String getPassword(String username) {
        return credentialsList.stream().filter(cred -> cred.getUsername().equals(username)).findFirst().get().getPassword();
    }
    public boolean checkDuplicateUsername(String username) {
        return credentialsList.stream().anyMatch(cred -> cred.getUsername().equals(username));
    }

    public int getCredentialsId(String username) {
        return credentialsList.stream().filter(cred -> cred.getUsername().equals(username)).findFirst().get().getCredId();
    }
}
