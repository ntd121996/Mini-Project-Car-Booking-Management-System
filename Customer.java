public class Customer {
    private int ID;
    private String Name;
    private String PhoneNo;
    private String Email;
    private String Address;
    private static int id;
    public Customer (String name){
        this.ID = id++;
        this.Name = name;
        this.Address = "Address Nubmer " + Integer.toString(id);
        this.PhoneNo = "PhoneNo Nubmer " + Integer.toString(id);
        this.Email = "Email Nubmer " + Integer.toString(id);
    }
    public String getInfo(){
        String info  = String.format(
        " Id: %d\n Name :%s\n PhoneNo: %s\n Email: %s\n Address:%s\n",
        this.ID, this.Name, this.PhoneNo, this.Email, this.Address);
        return info;
    }
    public String getAddress() {
        return Address;
    }
    public String getEmail() {
        return Email;
    }
    public int getID() {
        return ID;
    }
    public String getName() {
        return Name;
    }
    public String getPhoneNo() {
        return PhoneNo;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

}