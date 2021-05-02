
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bharath
 */
@SuppressWarnings("serial")
class EmployeeCrud implements Serializable {

    public int id;
    public String name;
    public float salary;
    public long phone_number;
    public String email_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public EmployeeCrud(int id, String name, float salary, long phone_number, String email_id) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.phone_number = phone_number;
        this.email_id = email_id;
    }

    @Override
    public String toString() {
        return "EmployeeCrud{" + "id=" + id + ", name=" + name + ", salary=" + salary + ", phone_number=" + phone_number + ", email_id=" + email_id + '}';
    }

}


//Method 

public class Employee {

    static void show(ArrayList<EmployeeCrud> arraylist) {
        System.out.println("\n--------------Employee Detailed List---------------\n");
        System.out.println(String.format("%-10s%-15s%-10s%-10s%-10s", "ID", "Name", "Salary", "Phone-no", "Email-Id"));
        for (EmployeeCrud emp : arraylist) {
            System.out.println(String.format("%-5s%-20s%-10s%-15s%-10s", emp.id, emp.name, emp.salary, emp.phone_number, emp.email_id));
        }
    }
    //Main Method

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int id;
        String name;
        float salary;
        long phone_number;
        String email_id;

        Scanner sc = new Scanner(System.in);
        ArrayList<EmployeeCrud> arraylist = new ArrayList<EmployeeCrud>();

        File file = null;
        FileInputStream fiinput = null;
        ObjectInputStream oinput = null;
        FileOutputStream foutput = null;
        ObjectOutputStream ooutput = null;

        try {

            file = new File("/Users/bharath/Desktop/EmployeeDataList1.txt");
            if (file.exists()) {
                fiinput = new FileInputStream(file);
                oinput = new ObjectInputStream(fiinput);
                arraylist = (ArrayList<EmployeeCrud>) oinput.readObject();
            }

        } catch (Exception exp) {
            System.out.println(exp);
        }
        do {
            System.out.println("\n*********Welcome to Employee Group**********\n");
            System.out.println("1). Create Employee to the List\n" + "2). Search for Employees\n" + "3). Update Employee details\n" + "4). Delete Employee Details\n"
                    + "5). Display all Employees\n");
            System.out.println("Enter the above list to Create Update Display or Delete : ");
            int output = sc.nextInt();

            switch (output) {
                case 1:
                    System.out.println("\nEnter the details to Create list:\n");
                    System.out.println("Enter the employee's ID number:");
                    id = sc.nextInt();
                    System.out.println("Enter the Name of emplloyee's :");
                    name = sc.next();
                    System.out.println("Enter the Salary of employee's:");
                    salary = sc.nextFloat();
                    System.out.println("Enter the Phone No of employee's:");
                    phone_number = sc.nextLong();
                    System.out.println("Enter the EmailID of employee:");
                    email_id = sc.next();
                    arraylist.add(new EmployeeCrud(id, name, salary, phone_number, email_id));
                    show(arraylist);
                    break;

                case 2:
                    System.out.println("Enter the Employee's ID number to search :");
                    id = sc.nextInt();
                    int x = 0;
                    for (EmployeeCrud emp : arraylist) {
                        if (id == emp.id) {
                            System.out.println(emp + "\n");
                            x++;
                        }
                    }
                    if (x == 0) {
                        System.out.println("\nEmployee Details you entered is not available, Please enter a valid ID");
                    }
                    break;

                case 3:
                    System.out.println("\nEnter the Employee ID to UPDATE the details");
                    id = sc.nextInt();
                    int y = 0;
                    for (EmployeeCrud emp : arraylist) {
                        if (id == emp.id) {
                            y++;
                            do {
                                int ch = 0;
                                System.out.println("\n UPDATE Employee Details :\n"
                                        + "1). Employee ID\n" + "2). Name\n" + "3). Salary\n" + "4). Phone No.\n" + "5). EmailId\n" + "6). GO BACK\n");
                                System.out.println("Enter the numbers to update the details  : ");
                                ch = sc.nextInt();
                                switch (ch) {
                                    case 1:
                                        System.out.println("\nEnter new Employee ID numbner:");
                                        emp.id = sc.nextInt();
                                        System.out.println(emp + "\n");
                                        break;

                                    case 2:
                                        System.out.println("Enter new Employee's Name :");
                                        emp.name = sc.nextLine();
                                        System.out.println(emp + "\n");
                                        break;

                                    case 3:
                                        System.out.println("Enter new Employee's Salary:");
                                        emp.salary = sc.nextFloat();
                                        System.out.println(emp + "\n");
                                        break;

                                    case 4:
                                        System.out.println("Enter new Employee Phone number :");
                                        emp.phone_number = sc.nextLong();
                                        System.out.println(emp + "\n");
                                        break;

                                    case 5:
                                        System.out.println("Enter new Employee Emailid :");
                                        emp.email_id = sc.next();
                                        System.out.println(emp + "\n");
                                        break;

                                    case 6:
                                        y++;
                                        break;

                                    default:
                                        System.out.println("\nEnter a correct number from List :");
                                        break;

                                }
                            } while (y == 1);
                        }
                    }
                    if (y == 0) {
                        System.out.println("\n Employee Details are not Correct, Please enter a valid Employe ID");
                    }

                    break;

                case 4:
                    System.out.println("\nEnter Employee ID to DELETE  :");
                    id = sc.nextInt();
                    int i = 0;
                    try {
                        for (EmployeeCrud emp : arraylist) {
                            if (id == emp.id) {
                                arraylist.remove(emp);
                                show(arraylist);
                                i++;
                            }
                        }
                        if (i == 0) {
                            System.out.println("\nEmployee Details are not available, Please enter a valid ID!!");
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                    break;

                case 5: 
                    try {
                    arraylist = (ArrayList<EmployeeCrud>) oinput.readObject();

                } catch (ClassNotFoundException e2) {

                    System.out.println(e2);
                } catch (Exception e2) {

                    System.out.println(e2);
                }
                show(arraylist);
                break;
            }
        } while (true);
    }

}
