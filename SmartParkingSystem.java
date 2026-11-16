import java.util.Scanner;


abstract class Vehicle {
    private String plateNo;  
    private int hours;

    public Vehicle(String plateNo, int hours) { 
        this.plateNo = plateNo;
        this.hours = hours;
    }

    public String getPlateNo() {
        return plateNo; 
        
    }
    public int getHours() { return hours; }

    abstract double getRate();  
    abstract String getType();  

 
    public double calculateFee() { 
        return hours * getRate(); 
    }


    public double calculateFee(int extraHours) { 
        return calculateFee() + extraHours * getRate(); 
    }
}


class Car extends Vehicle {
    public Car(String plate, int hours) {
        super(plate, hours); 
        
    }

    @Override
    double getRate() { 
        return 50;
    }

    @Override
    String getType() {
        return "Car"; 
        
    }
}


class Bike extends Vehicle {
    public Bike(String plate, int hours) { 
        super(plate, hours);
    }

    @Override
    double getRate() {
        return 20; 
        
    }

    @Override
    String getType() {
        return "Bike"; 
        
    }
}


class ElectricVehicle extends Vehicle {
    public ElectricVehicle(String plate, int hours) {
        super(plate, hours); 
        
    }

    @Override
    double getRate() {
        return 40; 
        
    }

    @Override
    String getType() {
        return "Electric Vehicle"; 
        
    }

  
    @Override
    public double calculateFee() { 
        return super.calculateFee() * 0.9; 
    }
}


public class SmartParkingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Smart Parking System ===");

        while (true) {
            System.out.println("\n1.Car 2.Bike 3.Electric 0.Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt(); sc.nextLine();

            if(choice == 0) break;

            System.out.print("Plate No: "); 
            String plate = sc.nextLine();

            System.out.print("Hours: "); 
            int hours = sc.nextInt(); sc.nextLine();

            Vehicle v = null;
            if(choice==1) v = new Car(plate,hours);
            else if(choice==2) v = new Bike(plate,hours);
            else if(choice==3) v = new ElectricVehicle(plate,hours);
            else {
                System.out.println("Invalid Choice!");
                continue;
            }

            System.out.println("\n--- Receipt ---");
            System.out.println("Type  : " + v.getType());
            System.out.println("Plate : " + v.getPlateNo());
            System.out.println("Hours : " + v.getHours());
            System.out.println("Fee   : " + v.calculateFee());

            System.out.println("Fee with 1 extra hour: " + v.calculateFee(1));
        }

        sc.close();
        System.out.println("\nThank you for using this service!");
    }
}
