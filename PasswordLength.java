import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordLength {

    private JFrame frame;
    private JTextField textField;
    private CopyYourPassword passwordLengthWindow;
    private String generatedPassword;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PasswordLength window = new PasswordLength();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PasswordLength() {
        initialize();
    }

    public JFrame getFrame() {
        return frame;
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose instead of exit
        frame.getContentPane().setLayout(null);

        textField = new JTextField();
        textField.setBounds(110, 107, 163, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel = new JLabel("Enter the password length :");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        lblNewLabel.setBounds(110, 57, 196, 26);
        frame.getContentPane().add(lblNewLabel);

        JButton btnNewButton = new JButton("OK");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
        btnNewButton.setBounds(120, 149, 52, 23);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Cancel");
        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
        btnNewButton_1.setBounds(182, 149, 78, 23);
        frame.getContentPane().add(btnNewButton_1);

        // Action listener for "OK" button
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int passwordLength = Integer.parseInt(textField.getText());
                generatedPassword = generatePassword(passwordLength);

                // Close the frame
                frame.dispose();

                // Show the CopyYourPassword frame
                if (passwordLengthWindow == null) {
                    passwordLengthWindow = new CopyYourPassword(generatedPassword);
                }
                passwordLengthWindow.getFrame().setVisible(true);
            }
        });

        // Action listener for "Cancel" button
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the frame
                frame.dispose();
            }
        });
    }

    private String generatePassword(int length) {
        // Implement your password generation logic here
        // For example, you can use a random password generator library
        // For simplicity, we'll generate a random alphanumeric password here
        String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = (int) (Math.random() * charset.length());
            password.append(charset.charAt(randomIndex));
        }

        return password.toString();
    }
}
