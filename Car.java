public class Car {
    private int ID;
    private int NoOfSeats;
    private String Type;
    private String LicenseNo;
    private String Description;
    private String Status;
    private static int id;
    public Car (String Status){
        this.ID = id++;
        this.Description = "Descript Nubmer " + Integer.toString(id);
        this.NoOfSeats = id % 2 == 0 ? 4 : 7;
        this.Type = "Type Nubmer " + Integer.toString(id);
        this.LicenseNo = "LicenseNo Nubmer " + Integer.toString(id);
        this.Status = Status;
    }
    public String getInfo(){
        String info  = String.format(
        " Id: %d\n NoOfSeats: %d\n Type :%s\n LicenseNo: %s\n Description: %s\n Status:%s\n",
        this.ID, this.NoOfSeats, this.Type, this.LicenseNo, this.Description, this.Status);
        return info;
    }
    public String getDescription() {
        return Description;
    }
    public int getID() {
        return ID;
    }
    public String getLicenseNo() {
        return LicenseNo;
    }
    public int getNoOfSeats() {
        return NoOfSeats;
    }
    public String getStatus() {
        return Status;
    }
    public String getType() {
        return Type;
    }
    public void setDescription(String description) {
        Description = description;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public void setLicenseNo(String licenseNo) {
        LicenseNo = licenseNo;
    }
    public void setNoOfSeats(int noOfSeats) {
        NoOfSeats = noOfSeats;
    }
    public void setStatus(String status) {
        Status = status;
    }
    public void setType(String type) {
        Type = type;
    }
}