package com.akobir.shell.service.impl;

import com.akobir.shell.service.PasswordService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PasswordServiceImpl implements PasswordService {

    private final Map<String, List<String>> passwords = new HashMap<>();

    public String addPassword(String name, String password) {
        List<String> strings = passwords.get(name);
        if (strings == null) {
            strings = List.of();
        }
        strings.add(password);
        passwords.put(name, strings);
        return "saved";
    }

    public List<String> getPassword(String name) {
        return passwords.get(name);
    }

    public String createPasswordWithLength(int length) {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            password.append((char) ((int) (Math.random() * 26) + 97));
        }
        return password.toString();
    }

    public String createStrongPassword() {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            password.append((char) ((int) (Math.random() * 26) + 97));
        }
        return password.toString();
    }

}
