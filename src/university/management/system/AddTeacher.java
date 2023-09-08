package university.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class AddTeacher extends JFrame implements ActionListener{

    JTextField tfname, tfpname, tfaddress, tfphone, tfemail, tfx, tfxii, tfaadhar;
    JLabel labelempid;
    JDateChooser dcdob;
    JComboBox<String> cbcourse;
    JComboBox cbbranch;
    JButton submit, cancel;

    Random ran = new Random();
    Conn con = new Conn();
    long first4;
    private String x;

    long rollno() throws SQLException {
        first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);//to keep the value between 1000 and 9999
        ResultSet rs=con.s.executeQuery("select count(*) from student where rollno = '1533"+first4+"';");
        System.out.println("select count(*) from student where rollno = '1533"+first4+"';");
        rs.next();
        if(rs.getInt(1)==0) return first4;
        else return rollno();
    }
    AddTeacher() throws SQLException {


        setSize(900, 700);
        setLocation(350, 50);

        setLayout(null);

        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);

        JLabel lblpname = new JLabel("Parent's Name");
        lblpname.setBounds(400, 150, 200, 30);
        lblpname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblpname);

        tfpname = new JTextField();
        tfpname.setBounds(600, 150, 150, 30);
        add(tfpname);

        JLabel lblempid = new JLabel("Employee ID");
        lblempid.setBounds(50, 200, 200, 30);
        lblempid.setFont(new Font("serif", Font.BOLD, 20));
        add(lblempid);



        labelempid = new JLabel("1733"+rollno());
        System.out.println(labelempid.getText());
        labelempid.setBounds(200, 200, 200, 30);
        labelempid.setFont(new Font("serif", Font.BOLD, 20));
        add(labelempid);

        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(600, 200, 150, 30);
        add(dcdob);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);

        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);

        JLabel lblx = new JLabel("Class X (%)");
        lblx.setBounds(400, 300, 200, 30);
        lblx.setFont(new Font("serif", Font.BOLD, 20));
        add(lblx);

        tfx = new JTextField();
        tfx.setBounds(600, 300, 150, 30);
        add(tfx);

        JLabel lblxii = new JLabel("Class XII (%)");
        lblxii.setBounds(50, 350, 200, 30);
        lblxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lblxii);

        tfxii = new JTextField();
        tfxii.setBounds(200, 350, 150, 30);
        add(tfxii);

        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(400, 350, 200, 30);
        lblaadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 350, 150, 30);
        add(tfaadhar);

        JLabel lblcourse = new JLabel("Highest Qualification");
        lblcourse.setBounds(10, 400, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);

        String[] course = {"B.Tech", "BBA", "BCA", "Bsc", "Msc", "MBA", "MCA", "MCom", "MA", "BA"};
        cbcourse = new JComboBox<>(course);
        cbcourse.setBounds(200, 400, 150, 30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        ComboBoxModel[] models =new ComboBoxModel[2];
        models[0]=new DefaultComboBoxModel<>(new String[]{"CS","IT","Civil","ECE","Mech","EEE"});
        models[1]=new DefaultComboBoxModel<>(new String[]{"Humanities","Management","Arts","Finance"});

        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);

        cbbranch = new JComboBox(models[0]);
        cbbranch.setBounds(600, 400, 150, 30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
        cbcourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i=cbcourse.getSelectedIndex(); //setting combo box 2 details depending on the first one
                if(i==0) cbbranch.setModel(models[0]);
                else cbbranch.setModel(models[1]);
            }
        });

        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String name = tfname.getText();
            String pname = tfpname.getText();
            String empid = labelempid.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String x = tfx.getText();
            String xii = tfxii.getText();
            String aadhar = tfaadhar.getText();
            if(aadhar.length()!=12){JOptionPane.showMessageDialog(this,
                    "Aadhar no. should be of 12 digits.",
                    "Inane error",
                    JOptionPane.ERROR_MESSAGE);
                tfaadhar.setText("");
            }
            String qual = (String) cbcourse.getSelectedItem();
            String dept = (String) cbbranch.getSelectedItem();
            if(!tfaadhar.getText().isEmpty() || !name.isEmpty()){
                try {
                    String query = "insert into teacher values('"+name+"', '"+pname+"', '"+empid+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+x+"', '"+xii+"', '"+aadhar+"', '"+qual+"', '"+dept+"')";


                    con.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Teacher Details Inserted Successfully");
                    dispose();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {JOptionPane.showMessageDialog(this,
                    "Field can not be empty",
                    "Inane error",
                    JOptionPane.ERROR_MESSAGE);}
        }else {
            dispose();
        }
    }

    public static void main(String[] args) throws SQLException {
        new AddTeacher();
    }
}