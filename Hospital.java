import java.sql.*;
import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        Scanner hos = new Scanner(System.in);
        int choice;
        while(true){
            System.out.println("Enter the options below");
            System.out.println("1 .Insert");
            System.out.println("2 .View");
            System.out.println("3 .Search");
            System.out.println("4 .Update");
            System.out.println("5 .Delete");
            System.out.println("6 .Exit");

            choice = hos.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Insert the data ");
                    System.out.println("Enter the patient Id");
                    int id = hos.nextInt();
                    System.out.println("Enter the patient name");
                    String name = hos.next();
                    System.out.println("Address");
                    String add = hos.next();
                    System.out.println("pincode");
                    int pin = hos.nextInt();
                    System.out.println("Phone Number");
                    String phone = hos.next();
                    System.out.println("Symptoms");
                    String symp = hos.next();
                    System.out.println("Doctor name");
                    String docName = hos.next();

                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_db","root","");
                        String sql = "INSERT INTO `patients`(`Patient_id`, `Patient_name`, `Address`, `Pincode`, `PhoneNumber`, `Symptoms`, `Doctor_Name`) VALUES (?,?,?,?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setInt(1,id);
                        stmt.setString(2,name);
                        stmt.setString(3,add);
                        stmt.setInt(4,pin);
                        stmt.setString(5,phone);
                        stmt.setString(6,symp);
                        stmt.setString(7,docName);
                        stmt.executeUpdate();
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 2:
                    System.out.println("View the data ");
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_db","root","");
                        String sql = "SELECT `Patient_id`, `Patient_name`, `Address`, `Pincode`, `PhoneNumber`, `Symptoms`, `Doctor_Name` FROM `patients` ";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()){
                            String getId = rs.getString("Patient_id");
                            String getName = rs.getString("Patient_name");
                            String getAddr = rs.getString("Address");
                            String getPin = rs.getString("Pincode");
                            String getPhone = rs.getString("PhoneNumber");
                            String getSymp = rs.getString("Symptoms");
                            String getDoc = rs.getString("Doctor_Name");
                            System.out.println("Patient id="+getId);
                            System.out.println("Patient name="+getName);
                            System.out.println("Patient Address="+getAddr);
                            System.out.println("Patient pincode="+getPin);
                            System.out.println("Patient phone="+getPhone);
                            System.out.println("Patient Symptoms="+getSymp);
                            System.out.println("Patient Doctor name="+getDoc+'\n');
                        }
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 3:
                    System.out.println("Search the data ");
                    id = hos.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_db","root","");
                        String sql = "SELECT `Patient_id`, `Patient_name`, `Address`, `Pincode`, `PhoneNumber`, `Symptoms`, `Doctor_Name` FROM `patients` WHERE `Patient_id`="+String.valueOf(id);
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()){
                            String getId = rs.getString("Patient_id");
                            String getName = rs.getString("Patient_name");
                            String getAddr = rs.getString("Address");
                            String getPin = rs.getString("Pincode");
                            String getPhone = rs.getString("PhoneNumber");
                            String getSymp = rs.getString("Symptoms");
                            String getDoc = rs.getString("Doctor_Name");
                            System.out.println("Patient id="+getId);
                            System.out.println("Patient name="+getName);
                            System.out.println("Patient Address="+getAddr);
                            System.out.println("Patient pincode="+getPin);
                            System.out.println("Patient phone="+getPhone);
                            System.out.println("Patient Symptoms="+getSymp);
                            System.out.println("Patient Doctor name="+getDoc+'\n');
                        }
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 4:
                    System.out.println("Update the data ");
                    System.out.println("Enter the patient Id");
                    id = hos.nextInt();
                    System.out.println("Enter the patient name");
                    name = hos.next();
                    System.out.println("Address");
                    add = hos.next();
                    System.out.println("pincode");
                    pin = hos.nextInt();
                    System.out.println("Phone Number");
                    phone = hos.next();
                    System.out.println("Symptoms");
                    symp = hos.next();
                    System.out.println("Doctor name");
                    docName = hos.next();
                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_db","root","");
                        String sql = "UPDATE `patients` SET `Patient_id`='"+id+"',`Patient_name`='"+name+"',`Address`='"+add+"',`Pincode`='"+pin+"',`PhoneNumber`='"+phone+"',`Symptoms`='"+symp+"',`Doctor_Name`='"+docName+"' WHERE `Patient_id`="+id;
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("Updated successfully");
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 5:
                    System.out.println("Delete the data");
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
