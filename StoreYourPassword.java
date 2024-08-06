import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class StoreYourPassword {

    private JFrame frame;
    private JTextField textFieldName;
    private JTextField textFieldPassword;
    private Map<String, String> accountInfoMap = new HashMap<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StoreYourPassword window = new StoreYourPassword();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public StoreYourPassword() {
        initialize();
    }

    public JFrame getFrame() {
        return frame;
    }

    public Map<String, String> getAccountInfoMap() {
        return accountInfoMap;
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("ACCOUNT NAME :");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel.setBounds(125, 22, 134, 32);
        frame.getContentPane().add(lblNewLabel);

        textFieldName = new JTextField();
        textFieldName.setBounds(125, 66, 139, 32);
        frame.getContentPane().add(textFieldName);
        textFieldName.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("ACCOUNT PASSWORD :");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_1.setBounds(125, 122, 197, 17);
        frame.getContentPane().add(lblNewLabel_1);

        textFieldPassword = new JTextField();
        textFieldPassword.setBounds(125, 164, 139, 32);
        frame.getContentPane().add(textFieldPassword);
        textFieldPassword.setColumns(10);

        JButton btnNewButton = new JButton("STORE");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        btnNewButton.setBounds(101, 207, 89, 23);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Cancel");
        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        btnNewButton_1.setBounds(198, 207, 89, 23);
        frame.getContentPane().add(btnNewButton_1);

        // Action listener for "Cancel" button
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the window when "Cancel" is clicked
            }
        });

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String accountName = textFieldName.getText();
                String accountPassword = textFieldPassword.getText();

                if (accountName.isEmpty() || accountPassword.isEmpty()) {
                    showError("Fill in both account name and password properly.");
                } else {
                    accountInfoMap.put(accountName, accountPassword);
                    showMessage("Account information saved successfully.");
                    textFieldName.setText("");
                    textFieldPassword.setText("");
                }
            }
        });
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(frame, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
