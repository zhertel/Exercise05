import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressBook {

    private JPanel rootPanel;
    private JLabel addressBookLabel;
    private JLabel addContactLabel;
    private JLabel addNameLabel;
    private JTextField nameTextField;
    private JLabel addEmailLabel;
    private JTextField emailTextField;
    private JButton addDataButton;
    private JLabel searchContactsLabel;
    private JLabel searchNameLabel;
    private JTextField searchTextField;
    private JLabel searchEmailLabel;
    private JLabel searchResults;
    private JButton searchDataButton;

    public static Map<String, String> addressBookData = new HashMap<>();

    public AddressBook() {
        addDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Person contact = new Person(nameTextField.getText(), emailTextField.getText());
                AddressBook.addressBookData.put(contact.getPersonName(), contact.getPersonEmail());
            }
        });

        searchDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = searchTextField.getText();
                String email = addressBookData.get(name);
                searchResults.setText(email);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Address Book");
        frame.setContentPane(new AddressBook().rootPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}

class Person {
    private String name;
    private String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getPersonName() {
        return name;
    }

    public String getPersonEmail() {
        return email;
    }
}