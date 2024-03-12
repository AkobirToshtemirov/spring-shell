package com.akobir.shell.service;

import java.util.List;

public interface PasswordService {
    String addPassword(String name, String password);

    List<String> getPassword(String name);

    String createPasswordWithLength(int length);

    String createStrongPassword();
}
