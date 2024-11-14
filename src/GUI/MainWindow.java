package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    public MainWindow() {
        // Configuración de la ventana principal
        setTitle("Censo de Población");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Mensaje de bienvenida
        JLabel welcomeLabel = new JLabel("Bienvenido. ¿Qué desea hacer?", SwingConstants.CENTER);
        add(welcomeLabel, BorderLayout.NORTH);

        // Panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton registerButton = new JButton("Registrar Usuario");
        JButton loginButton = new JButton("Iniciar Sesión");

        // Agregar botones al panel
        buttonPanel.add(registerButton);
        buttonPanel.add(loginButton);

        // Añadir el panel al centro de la ventana
        add(buttonPanel, BorderLayout.CENTER);

        // Eventos para los botones
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterUserWindow().setVisible(true);
                dispose(); // Cierra la ventana actual
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginWindow().setVisible(true);
                dispose(); // Cierra la ventana principal
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
}
