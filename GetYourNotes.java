import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GetYourNotes {

    private JFrame frame;
    private JTextField textField;

    public GetYourNotes() {
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

        JLabel lblNewLabel = new JLabel("Get your notes:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel.setBounds(35, 23, 162, 17);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(55, 51, 297, 140);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("OK");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the GetYourNotes window
                frame.setVisible(false);
            }
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        btnNewButton.setBounds(237, 202, 57, 23);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("GET NOTE");
        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        btnNewButton_1.setBounds(109, 202, 118, 23);
        frame.getContentPane().add(btnNewButton_1);

        // Action listener for the "GET NOTE" button
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Set the text field with the stored note from AddNote
                textField.setText(AddNote.getStoredNote());
            }
        });
    }
}
