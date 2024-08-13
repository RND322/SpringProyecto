
package com.proyecto.proytecobd.Controllers;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.proytecobd.Classes.DatabaseConnection;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/banco")
public class LoginController {
    
@Autowired
private DatabaseConnection databaseConnection;

@PostMapping("/login")
public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
    try (Connection connection = databaseConnection.getConnection(username, password)) {
        session.setAttribute("username", username);
        session.setAttribute("password", password);
        return "Login successful";
    } catch (SQLException e) {
        return "Invalid username or password";
    }
}

@PostMapping("/logout")
public String logout(HttpSession session) {
    session.invalidate();
    return "Logout successful";
}

}
