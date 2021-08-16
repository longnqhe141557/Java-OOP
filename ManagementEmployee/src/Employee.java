
public class Employee {
    private String ID;
    private String fName;
    private String lName;
    private String phoneNumber;
    private String email;
    private String address;
    private String dob;
    private String sex;
    private double salary;
    private String egency;

    public Employee() {
    }

    public Employee(String ID, String fName, String lName, String phoneNumber, String email, String address, String dob, String sex, double salary, String egency) {
        this.ID = ID;
        this.fName = fName;
        this.lName = lName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.dob = dob;
        this.sex = sex;
        this.salary = salary;
        this.egency = egency;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEgency() {
        return egency;
    }

    public void setEgency(String egency) {
        this.egency = egency;
    }

    @Override
    public String toString() {
        return  String.format("%-10s%-10s%-10s%-20s%-20s%-15s%-15s%-10s%-9.0f%-10s\n", getID(),
                    getfName(), getlName(), getPhoneNumber(), getEmail(),
                    getAddress(), getDob(), getSex(), getSalary(), getEgency());
    }
    
   
}
