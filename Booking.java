import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar; 
public class Booking {
    private int ID;
    private String Description;
    private String BookingDate;
    private Car car;
    private Customer customer;
    private Driver driver;
    private static int id;
    public Booking (Car car, Customer customer, Driver driver){
        this.ID = id++;
        this.Description = "Descript Nubmer " + Integer.toString(id);
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
        this.BookingDate = dateFormat.format(date);
        this.car = car;
        this.driver = driver;
        this.customer = customer;
    }
    public String getInfo(){
        String info = "ID: " + Integer.toString(id) + "\nDate:" + BookingDate;
        info +=  "\nDriver INFO: \n" + this.driver.getInfo() + "Car INFO: \n" + this.car.getInfo() + "Customer INFO: \n" + this.customer.getInfo();
        return info;
    }
    public String getBookingDate() {
        return BookingDate;
    }
    public String getDescription() {
        return Description;
    }
    public int getID() {
        return ID;
    }
    public void setBookingDate(String bookingDate) {
        BookingDate = bookingDate;
    }
    public void setDescription(String description) {
        Description = description;
    }
    public void setID(int iD) {
        ID = iD;
    }

}