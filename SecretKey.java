import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SecretKey {

    private JFrame frame;
    private JTextField textField;
    private CopyYourPassword copyYourPasswordWindow;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SecretKey window = new SecretKey();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SecretKey() {
        initialize();
    }

    public JFrame getFrame() {
        return frame;
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Enter the secret key :");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel.setBounds(77, 62, 202, 23);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(77, 103, 193, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("OK");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        btnNewButton.setBounds(87, 134, 69, 23);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Cancel");
        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        btnNewButton_1.setBounds(166, 135, 89, 23);
        frame.getContentPane().add(btnNewButton_1);

        // Action listener for "OK" button
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (copyYourPasswordWindow == null) {
                    // Generate a random password (you can customize this logic)
                    String generatedPassword = generateRandomPassword();
                    copyYourPasswordWindow = new CopyYourPassword(generatedPassword);
                }
                copyYourPasswordWindow.getFrame().setVisible(true);
            }
        });

        // Action listener for "Cancel" button
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the SecretKey window
            }
        });
    }

    // Method to generate a random password (customize as needed)
    private String generateRandomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[]{}|;:,.<>?";
        int length = 12;
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }
}
