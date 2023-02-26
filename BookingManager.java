import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Comparator;

public class BookingManager {
    private static final String MANAGE_CAR      = "1";
    private static final String MANAGE_DRIVER   = "2";
    private static final String MANAGE_CUSTOMER = "3";
    private static final String BOOKING         = "4";
    private static final String SHOW_BOOKING    = "5";
    private static final String SEARCH_CAR      = "6";
    private static final String SEARCH_DRIVER   = "7";
    private static final String EXIT            = "0";

    private static final String ADD_CAR      = "1";
    private static final String EDIT_CAR     = "2";
    private static final String REMOVE_CAR   = "3";
    private static final String SHOW_CAR     = "4";


    private static final String ADD_DRIVER      = "1";
    private static final String EDIT_DRIVER     = "2";
    private static final String REMOVE_DRIVER   = "3";
    private static final String SHOW_DRIVER     = "4";

    private static final String ADD_CUSTOMER      = "1";
    private static final String EDIT_CUSTOMER     = "2";
    private static final String REMOVE_CUSTOMER   = "3";
    private static final String SHOW_CUSTOMER     = "4";



    private static BookingManager instance;
    private List<Booking> ListBooking = new ArrayList<Booking>();
    private List<Driver> ListDriver = new ArrayList<Driver>();
    private List<Car> ListCar = new ArrayList<Car>();
    private List<Customer> ListCustomer = new ArrayList<Customer>();
    private BookingManager(){};
    InputHandler Input = new InputHandler();
    
    public static BookingManager Instance(){
        if(instance == null){
            instance = new BookingManager();
        }
        return instance;
    }
    
    public void manage(){
        while(true){
            showMenu();
            System.out.println("Input:");
            String inputString = Input.getInputString();
            if(inputString.equals(EXIT)){
                break;
            }
            ManageByUserInput(inputString);
        }
    }
    
    private void manageCar(){
        System.out.println("1. Add Car");
        System.out.println("2. Edit Car");
        System.out.println("3. Remove Car");
        System.out.println("4. Show Car");

        String inputString = Input.getInputString();
        switch (inputString) {
            case ADD_CAR:
                Car newCar = createCar();
                ListCar.add(newCar);
                break;
            case EDIT_CAR:
                editCar();
                break;
            case REMOVE_CAR:
                removeCar();
                break;
            case SHOW_CAR:
                showCar();
                break;
            default:
                break;
        }
    }
    private Car createCar(){
        System.out.println("Input Status");
        String statusString  = Input.getInputString();
        Car newCar = new Car(statusString);
        return newCar;
    }
    private Car getCarByID(int id){
        Car retCar = ListCar.stream().filter(car -> car.getID() == id).findAny().orElse(null);
        return retCar;
    }
    private Car getFreeCar(){
        Car retCar = ListCar.stream().filter(car -> (car.getStatus().equals("Free") || car.getStatus().equals("free") || car.getStatus().equals("FREE"))).findFirst().orElse(null);
        return retCar;
    }
    private void editCar(){
        System.out.println("Input id");
        int inputID = Input.getInputNumber();
        System.out.println("Input Status");
        String statusString = Input.getInputString();
        Car editCar = getCarByID(inputID);
        if(editCar != null){
            editCar.setStatus(statusString);
        }
        else{
            System.out.println("Not found");
        }
    }
    private void removeCar(){
        System.out.println("Input id");
        int inputID = Input.getInputNumber();
        Car editCar = getCarByID(inputID);
        if(editCar != null){
           ListCar.remove(editCar);
        }
        else{  
            System.out.println("Not found");
        }
    }
    private void showCar(){
        ListCar.forEach(car ->  System.out.println(car.getInfo()));
    }

    private void manageDriver(){
        System.out.println("1. Add Driver");
        System.out.println("2. Edit Driver");
        System.out.println("3. Remove Driver");
        System.out.println("4. Show Driver");

        String inputString = Input.getInputString();
        switch (inputString) {
            case ADD_DRIVER:
                Driver newDriver = createDriver();
                ListDriver.add(newDriver);
                break;
            case EDIT_DRIVER:
                editDriver();
                break;
            case REMOVE_DRIVER:
                removeDriver();
                break;
            case SHOW_DRIVER:
                showDriver();
                break;
            default:
                break;
        }
    }

    private Driver createDriver(){
        System.out.println("Input Rating");
        double Rating = Input.getInputFloatNumber();
        Driver newDriver = new Driver(Rating);
        return newDriver;
    }
    private Driver getDriverByID(int id){
        Driver retDriver = ListDriver.stream().filter(driver -> driver.getID() == id).findAny().orElse(null);
        return retDriver;
    }
    private Driver getDriverTopRate(){
        List<Driver> sortedDriverList = ListDriver.stream().sorted(Comparator.comparingDouble(Driver::getRating).reversed()).collect(Collectors.toList());
        Driver retDriver = sortedDriverList.stream().findFirst().orElse(null);
        return retDriver;
    }
    private void editDriver(){
        System.out.println("Input id");
        int inputID = Input.getInputNumber();
        System.out.println("Input Rating");
        double Rating = Input.getInputFloatNumber();
        Driver editDriver = getDriverByID(inputID);
        if(editDriver != null){
            editDriver.setRating(Rating);
        }
        else{
            System.out.println("Not found");
        }
    }
    private void removeDriver(){
        System.out.println("Input id");
        int inputID = Input.getInputNumber();
        Driver editDriver = getDriverByID(inputID);
        if(editDriver != null){
           ListDriver.remove(editDriver);
        }
        else{  
            System.out.println("Not found");
        }
    }
    
    private void showDriver(){
        ListDriver.forEach(driver ->  System.out.println(driver.getInfo()));
    }


    private void manageCustomer(){
        System.out.println("1. Add Customer");
        System.out.println("2. Edit Customer");
        System.out.println("3. Remove Customer");
        System.out.println("4. Show Customer");

        String inputString = Input.getInputString();
        switch (inputString) {
            case ADD_CUSTOMER:
                Customer newCustomer = createCustomer();
                ListCustomer.add(newCustomer);
                break;
            case EDIT_CUSTOMER:
                editCustomer();
                break;
            case REMOVE_CUSTOMER:
                removeCustomer();
                break;
            case SHOW_CUSTOMER:
                showCustomer();
                break;
            default:
                break;
        }
    }

    private Customer createCustomer(){
        System.out.println("Input Name");
        String name = Input.getInputString();
        Customer newCustomer = new Customer(name);
        return newCustomer;
        
    }
    private Customer getCustomerByID(int id){
        Customer retCustomer = ListCustomer.stream().filter(customer -> customer.getID() == id).findAny().orElse(null);
        return retCustomer;
    }
    private void editCustomer(){
        System.out.println("Input id");
        int inputID = Input.getInputNumber();
        System.out.println("Input Name");
        String name = Input.getInputString();
        Customer editCustomer = getCustomerByID(inputID);
        if(editCustomer != null){
            editCustomer.setName(name);
        }
        else{
            System.out.println("Not found");
        }
    }
    private void removeCustomer(){
        System.out.println("Input id");
        int inputID = Input.getInputNumber();
        Customer editCustomer = ListCustomer.stream().filter(customer -> customer.getID() == inputID).findAny().orElse(null);
        if(editCustomer != null){
           ListCustomer.remove(editCustomer);
        }
        else{  
            System.out.println("Not found");
        }
    }
    
    private void showCustomer(){
        ListCustomer.forEach(customer ->  System.out.println(customer.getInfo()));
    }
    
    private Booking createBooking(){
        Booking booking = null;
        System.out.println("Car id");
        int inputID = Input.getInputNumber();
        Car car = getCarByID(inputID);

        System.out.println("Customer id");
        inputID = Input.getInputNumber();
        Customer customer = getCustomerByID(inputID);

        System.out.println("Driver id");
        inputID = Input.getInputNumber();
        Driver driver = getDriverByID(inputID);
        if(car != null && customer != null && driver != null){
            booking = new Booking(car, customer, driver);
        }
        return booking;
    }
    private void showMenu(){

        System.out.println("-------------------------------");
        System.out.println("1. Manage Car");
        System.out.println("2. Manage Driver");
        System.out.println("3. Manage Customer");
        System.out.println("4. Booking");
        System.out.println("5. Show Booking");
        System.out.println("6. Search Free Car");
        System.out.println("7. Search Top Rating Driver");
        System.out.println("0. Exit");
        System.out.println("-------------------------------");
    }
    private void ManageByUserInput(String input)
    {
        switch (input) {
            case MANAGE_CAR:
                System.out.println("MANAGE_CAR");
                manageCar();
                break;
            case MANAGE_DRIVER:
                System.out.println("MANAGE_DRIVER");
                manageDriver();
                break;
            case MANAGE_CUSTOMER:
                System.out.println("MANAGE_CUSTOMER");
                manageCustomer();
                break;
            case BOOKING:
                System.out.println("BOOKING");
                Booking newBooking = createBooking();
                if( newBooking != null) {
                    ListBooking.add(newBooking);
                } else {
                    System.out.println("Booking add failure");
                }
                break;
            case SHOW_BOOKING:
                System.out.println("SHOW_BOOKING");
                ListBooking.forEach(booking -> System.out.println(booking.getInfo()));
                break;
            case SEARCH_CAR:
                System.out.println("SEARCH_CAR");
                Car searchCar = getFreeCar();
                if( searchCar != null ){
                    System.out.println(searchCar.getInfo());
                } else {
                    System.out.println("Not found");
                }
                break;
            case SEARCH_DRIVER:
                System.out.println("SEARCH_CAR");
                Driver searchDriver = getDriverTopRate();
                if( searchDriver != null ){
                    System.out.println(searchDriver.getInfo());
                } else {
                    System.out.println("Not found");
                }
                break;
            default:
                System.out.println("Wrong input !!!");
                break;
        }
    }
}
