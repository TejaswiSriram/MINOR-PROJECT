import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class LoginPage {

    private JFrame frame;
    private JTextField textField;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginPage window = new LoginPage();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public LoginPage() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("USERNAME :");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel.setBounds(127, 30, 133, 23);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(127, 70, 133, 30);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("PASSWORD :");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_1.setBounds(127, 111, 97, 23);
        frame.getContentPane().add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        btnNewButton.setBounds(145, 202, 97, 23);
        frame.getContentPane().add(btnNewButton);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(127, 145, 133, 30);
        frame.getContentPane().add(passwordField);

        btnNewButton.addActionListener(e -> {
            String username = textField.getText();
            char[] password = passwordField.getPassword();

            if (isValidCredentials(username, password)) {
                // Display the second application when login is successful
                frame.dispose(); // Close the login window
                openPasswordManager(); // Open the PasswordManager application
            } else {
                JOptionPane.showMessageDialog(frame, "Login failed. Please check your credentials.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private boolean isValidCredentials(String username, char[] password) {
        String validUsername = "JAVAPRO";
        String validPassword = "Password";

        return username.equals(validUsername) && new String(password).equals(validPassword);
    }

    // Open the PasswordManager application
    private void openPasswordManager() {
        PasswordManager.main(new String[]{}); // Start the PasswordManager application
    }
}
