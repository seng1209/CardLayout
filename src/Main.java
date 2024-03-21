

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Main implements ActionListener
{
    JFrame f;
    JLabel labelCardOne, labelCardTwo, labelCardThree;
    JButton btnNext, btnClear, btnLogin;
    JPanel panelCards, panelCardOne, panelCardTwo, panelCardThree, panelButton;
    JTextField textField, confirmTextField;
    JPasswordField passwordField, confirmPassword, passwordField2;
    CardLayout cl;
    public Main(){
        f = new JFrame("Testing");
        f.setLayout(new BorderLayout(10,10));
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        labelCardOne = new JLabel("This is Card One");
        labelCardTwo = new JLabel("This is Card Two");
        labelCardThree = new JLabel("This is Card Three");

        btnNext = new JButton("Sign Up");
        btnClear = new JButton("Clear");

        cl = new CardLayout();

        panelCards = new JPanel(cl);

        panelCardOne = new JPanel(new GridLayout(3,2));
        panelCardTwo = new JPanel(new GridLayout(2,2));
        panelCardThree = new JPanel(new FlowLayout());

        panelButton = new JPanel(new FlowLayout());

        panelButton.add(btnNext);
        panelButton.add(btnClear);

        JLabel lblUserName = new JLabel("User Name:");
        JLabel lblPassword = new JLabel("Password:");
        JLabel lblRePassword = new JLabel("Re-Password:");
        textField = new JTextField(10);
        passwordField = new JPasswordField(10);
        confirmPassword = new JPasswordField(10);

        panelCardOne.add(lblUserName);
        panelCardOne.add(textField);
        panelCardOne.add(lblPassword);
        panelCardOne.add(passwordField);
        panelCardOne.add(lblRePassword);
        panelCardOne.add(confirmPassword);

        JLabel userName = new JLabel("User Name: ");
        confirmTextField = new JTextField(10);
        JLabel pass = new JLabel("Password:");
        passwordField2 = new JPasswordField(10);

        panelCardTwo.add(userName);
        panelCardTwo.add(confirmTextField);
        panelCardTwo.add(pass);
        panelCardTwo.add(passwordField2);

        panelCards.add(panelCardOne,"card1");
        panelCards.add(panelCardTwo,"card2");

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                passwordField.setText("");
                confirmPassword.setText("");
            }
        });

        btnNext.addActionListener(this);

        f.add(panelCards, BorderLayout.CENTER);
        f.add(panelButton, BorderLayout.SOUTH);

        f.setSize(500,200);
        f.setVisible(true);

    }

    public static void main(String[] arg){
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Arrays.equals(passwordField.getPassword(), confirmPassword.getPassword())) {
            if (e.getSource() == btnNext){
                btnNext.setText("Sign In");
                cl.next(panelCards);
            }
        }else if (!Arrays.equals(passwordField.getPassword(), confirmPassword.getPassword())){
            JOptionPane.showMessageDialog(null, "Passwords do not match.", "Woops", JOptionPane.ERROR_MESSAGE);
        }
    }
}