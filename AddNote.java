import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNote {

    private JFrame frame;
    private JTextField textField;
    private static String storedNote;

    public AddNote() {
        initialize();
    }

    public JFrame getFrame() {
        return frame;
    }

    public static String getStoredNote() {
        return storedNote;
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Add Note:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel.setBounds(45, 30, 174, 22);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(80, 63, 296, 140);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("ADD NOTE");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String noteText = textField.getText();
                if (noteText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Error: The text field is empty.");
                } else {
                    storedNote = noteText;
                    JOptionPane.showMessageDialog(frame, "Success: Note added!");
                }
            }
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        btnNewButton.setBounds(112, 214, 116, 23);
        frame.getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Cancel");
        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        btnNewButton_1.setBounds(241, 214, 89, 23);
        frame.getContentPane().add(btnNewButton_1);
        
        // Action listener for "Cancel" button to close the window
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }
}
