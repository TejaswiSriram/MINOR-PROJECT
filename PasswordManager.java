import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PasswordManager {

    private JFrame frame;
    private PasswordLength passwordLengthWindow;
    private EncryptText encryptTextWindow;
    private StoreYourPassword storeYourPasswordWindow;
    private EnterAccount enterAccountWindow;
    private AddNote addNoteWindow;
    private GetYourNotes getYourNotesWindow;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PasswordManager window = new PasswordManager();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PasswordManager() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnGeneratePassword = new JButton("GENERATE PASSWORD");
        btnGeneratePassword.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
        btnGeneratePassword.setBounds(137, 44, 173, 23);
        frame.getContentPane().add(btnGeneratePassword);

        JButton btnEncryptText = new JButton("ENCRYPT Text");
        btnEncryptText.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
        btnEncryptText.setBounds(137, 76, 173, 23);
        frame.getContentPane().add(btnEncryptText);

        JButton btnStorePassword = new JButton("STORE PASSWORD");
        btnStorePassword.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
        btnStorePassword.setBounds(137, 110, 173, 23);
        frame.getContentPane().add(btnStorePassword);

        JButton btnSearchPassword = new JButton("SEARCH PASSWORD");
        btnSearchPassword.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
        btnSearchPassword.setBounds(137, 147, 173, 23);
        frame.getContentPane().add(btnSearchPassword);

        JButton btnAddNote = new JButton("ADD NOTE");
        btnAddNote.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
        btnAddNote.setBounds(137, 181, 173, 23);
        frame.getContentPane().add(btnAddNote);

        JButton btnGetNote = new JButton("GET NOTES"); // Changed button text
        btnGetNote.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
        btnGetNote.setBounds(137, 215, 173, 23);
        frame.getContentPane().add(btnGetNote);
        
        JLabel lblNewLabel = new JLabel("HOME");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel.setBounds(0, 11, 434, 22);
        frame.getContentPane().add(lblNewLabel);

        // Create instances of other windows
        
        addNoteWindow = new AddNote();
        getYourNotesWindow = new GetYourNotes();

        // Action listener for "GENERATE PASSWORD" button
        btnGeneratePassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (passwordLengthWindow == null) {
                    passwordLengthWindow = new PasswordLength();
                }
                passwordLengthWindow.getFrame().setVisible(true);
            }
        });

        // Action listener for "ENCRYPT Text" button
        btnEncryptText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (encryptTextWindow == null) {
                    encryptTextWindow = new EncryptText();
                }
                encryptTextWindow.getFrame().setVisible(true);
            }
        });

        // Action listener for "STORE PASSWORD" button
        btnStorePassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (storeYourPasswordWindow == null) {
                    storeYourPasswordWindow = new StoreYourPassword();
                }
                storeYourPasswordWindow.getFrame().setVisible(true);
            }
        });
        
        // Action listener for "SEARCH PASSWORD" button
        btnSearchPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (enterAccountWindow == null) {
                    enterAccountWindow = new EnterAccount();
                }
                enterAccountWindow.setStoreYourPassword(storeYourPasswordWindow);
                enterAccountWindow.getFrame().setVisible(true);
            }
        });

        // Action listener for "ADD NOTE" button
        btnAddNote.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addNoteWindow.getFrame().setVisible(true);
            }
        });

        // Action listener for "GET NOTES" button
        btnGetNote.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getYourNotesWindow.getFrame().setVisible(true);
            }
        });
    }
}
