import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CopyYourPassword {

    private JFrame frame;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CopyYourPassword window = new CopyYourPassword("");
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CopyYourPassword(String generatedPassword) {
        initialize(generatedPassword);
    }

    public JFrame getFrame() {
        return frame;
    }

    private void initialize(String generatedPassword) {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textField = new JTextField();
        textField.setBounds(62, 50, 276, 154);
        textField.setText(generatedPassword); // Set the generated password
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel = new JLabel("Copy your password :");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel.setBounds(62, 22, 182, 17);
        frame.getContentPane().add(lblNewLabel);

        JButton btnNewButton = new JButton("OK");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        btnNewButton.setBounds(160, 215, 71, 23);
        frame.getContentPane().add(btnNewButton);

        // Action listener for "OK" button
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the frame
                frame.dispose();
            }
        });
    }
}
