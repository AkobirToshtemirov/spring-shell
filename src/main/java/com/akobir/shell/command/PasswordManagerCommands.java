package com.akobir.shell.command;

import com.akobir.shell.service.PasswordService;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;

import java.util.List;

@ShellComponent
public class PasswordManagerCommands {

    private final PasswordService passwordService;

    public PasswordManagerCommands(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @ShellMethod(key = "add-password", value = "Add password")
    public String addPassword(@ShellOption(value = "--name") String name, @ShellOption(value = "--password") String password) {
        return passwordService.addPassword(name, password);
    }

    @ShellMethod(key = "get-password", value = "Get password")
    public List<String> getPassword(@ShellOption(value = "--name") String name) {
        return passwordService.getPassword(name);
    }

    @ShellMethod(key = "create-password-with-length", value = "Create password with length")
    public String createPasswordWithLength(@ShellOption(value = "--length", defaultValue = "8") int length) {
        return passwordService.createPasswordWithLength(length);
    }

    @ShellMethod(key = "create-strong-password", value = "Create strong password")
    public String createStrongPassword() {
        return passwordService.createStrongPassword();
    }

    @ShellMethodAvailability({"add-password", "get-password", "create-password-with-length", "create-strong-password"})
    public Availability isAvailable() {
        return Availability.available();
    }

}
