package university.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDetails extends JFrame implements ActionListener {

    Choice cempno;
    JTable table;
    JButton search, print, update, add, cancel;

    TeacherDetails() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel heading = new JLabel("Search by Teacher No.");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        cempno = new Choice();
        cempno.setBounds(180, 20, 150, 20);
        add(cempno);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()) {
                cempno.add(rs.getString("empid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        add = new JButton("Add");
        add.setBounds(220, 70, 80, 20);
        add.addActionListener(this);
        add(add);

        update = new JButton("Update");
        update.setBounds(320, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(420, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from teacher where rollno = '"+cempno.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == add) {
            //setVisible(false);
            try {
                new AddTeacher();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if (ae.getSource() == update) {
            setVisible(false);
             new UpdateTeacher();

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherDetails();
    }
}