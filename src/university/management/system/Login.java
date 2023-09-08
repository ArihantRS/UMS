package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login, cancel;
    JTextField username, password;
Login(){
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    JLabel lblusername = new JLabel("Username");
    lblusername.setBounds(40, 20, 100, 20);
    add(lblusername);

    username = new JTextField();
    username.setBounds(150, 20, 150, 20);
    add(username);

    JLabel lpassword = new JLabel("Password");
    lpassword.setBounds(40, 70, 100, 20);
    add(lpassword);

    password = new JPasswordField();
    password.setBounds(150, 70, 150, 20);
    add(password);

    login = new JButton("Login");
    login.setBounds(40, 140, 120, 30);
    login.setBackground(Color.BLACK);
    login.setForeground(Color.WHITE);
    login.addActionListener(this);
    login.setFont(new Font("Tahoma", Font.BOLD, 15));
    add(login);

    cancel = new JButton("Cancel");
    cancel.setBounds(180, 140, 120, 30);
    cancel.setBackground(Color.BLACK);
    cancel.setForeground(Color.WHITE);
   cancel.addActionListener(this);
    cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
    add(cancel);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
    Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(350, 0, 200, 200);
    add(image);

    setSize(600, 300);
    setLocation(500, 250);
    setVisible(true);
}
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String username = this.username.getText();
            String password = this.password.getText();

            String query = "select * from login where username='"+username+"' and password='"+password+"'";

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new Project();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    this.username.setText("");
                    this.password.setText("");

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            dispose();

        }
    }

    public static void main(String[] args) {
        new Login();
    }}
