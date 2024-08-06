import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EncryptText {

    private JFrame frame;
    private JTextField textField;
    private SecretKey secretKeyWindow;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EncryptText window = new EncryptText();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public EncryptText() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 13));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Enter the text to encrypt :");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel.setBounds(92, 68, 183, 14);
        frame.getContentPane().add(lblNewLabel);
        
        textField = new JTextField();
        textField.setBounds(92, 105, 168, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        JButton btnNewButton = new JButton("OK");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        btnNewButton.setBounds(102, 143, 53, 23);
        frame.getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Cancel");
        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        btnNewButton_1.setBounds(160, 144, 89, 23);
        frame.getContentPane().add(btnNewButton_1);
        
        // Action listener for "OK" button
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (secretKeyWindow == null) {
                    secretKeyWindow = new SecretKey();
                }
                secretKeyWindow.getFrame().setVisible(true);
            }
        });
        
        // Action listener for "Cancel" button
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the EncryptText window
            }
        });
    }

    public JFrame getFrame() {
        return frame;
    }
}
