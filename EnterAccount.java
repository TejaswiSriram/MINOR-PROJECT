import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane; // Add this import

public class EnterAccount {

    private JFrame frame;
    private JTextField textField;
    private String accountName;
    private StoreYourPassword storeYourPassword;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EnterAccount window = new EnterAccount();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public EnterAccount() {
        initialize();
    }

    public JFrame getFrame() {
        return frame;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setStoreYourPassword(StoreYourPassword storeYourPassword) {
        this.storeYourPassword = storeYourPassword;
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 14));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Enter your account name :");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel.setBounds(78, 64, 166, 17);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(78, 104, 175, 27);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("OK");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        btnNewButton.setBounds(84, 154, 61, 27);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Cancel");
        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        btnNewButton_1.setBounds(155, 154, 89, 27);
        frame.getContentPane().add(btnNewButton_1);

        // Action listener for "OK" button
        btnNewButton.addActionListener(e -> {
            accountName = textField.getText();
            // Check if the account name exists in StoreYourPassword
            if (storeYourPassword != null && storeYourPassword.getAccountInfoMap().containsKey(accountName)) {
                // If it exists, show the CopyYourPassword window
                String accountPassword = storeYourPassword.getAccountInfoMap().get(accountName);
                CopyYourPassword copyYourPassword = new CopyYourPassword(accountPassword);
                copyYourPassword.getFrame().setVisible(true);
            } else {
                // If it doesn't exist, show an error message
                showError("Account not found!");
            }
            frame.dispose(); // Close the EnterAccount window
        });

        // Action listener for "Cancel" button
        btnNewButton_1.addActionListener(e -> {
            accountName = null;
            frame.dispose(); // Close the EnterAccount window
        });
    }

    private void showError(String message) {
        // Display an error message dialog
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}