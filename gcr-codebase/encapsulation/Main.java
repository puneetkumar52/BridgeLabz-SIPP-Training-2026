public class Main {

    public static void main(String[] args) {

        
        // Shape Hierarchy
        

        System.out.println("===== SHAPE REPORT =====");

        Shape[] shapes = new Shape[3];

        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(4, 6);
        shapes[2] = new Triangle(3, 4, 5);

        for (Shape s : shapes) {
            System.out.println("Area = " + s.area());
            System.out.println("Perimeter = " + s.perimeter());
            System.out.println();
        }

        
        // Employee Payroll System
        

        System.out.println("===== EMPLOYEE PAYROLL =====");

        FullTimeEmployee fullTime = new FullTimeEmployee();
        fullTime.setEmployeeId(101);
        fullTime.setEmployeeName("Ananya");
        fullTime.setMonthlySalary(50000);

        PartTimeEmployee partTime = new PartTimeEmployee();
        partTime.setEmployeeId(102);
        partTime.setEmployeeName("Rahul");
        partTime.setHoursWorked(40);
        partTime.setHourlyRate(300);

        System.out.println("\nFull Time Employee");
        fullTime.displayEmployeeInfo();
        System.out.println("Salary = " + fullTime.calculateSalary());

        System.out.println();

        System.out.println("Part Time Employee");
        partTime.displayEmployeeInfo();
        System.out.println("Salary = " + partTime.calculateSalary());

        
        // Hospital Patient Management
        

        System.out.println("\n===== HOSPITAL PATIENT MANAGEMENT =====");

        InPatient inPatient = new InPatient();
        inPatient.setPatientId(201);
        inPatient.setName("Rohan");
        inPatient.setAge(35);
        inPatient.setRoomCharges(5000);
        inPatient.setTreatmentCharges(12000);

        OutPatient outPatient = new OutPatient();
        outPatient.setPatientId(202);
        outPatient.setName("Priya");
        outPatient.setAge(28);
        outPatient.setConsultationFees(1000);
        outPatient.setTreatmentCharges(3000);

        System.out.println("\nIn Patient");
        inPatient.displayPatientDetails();
        System.out.println("Bill = " + inPatient.calculateBill());

        System.out.println();

        System.out.println("Out Patient");
        outPatient.displayPatientDetails();
        System.out.println("Bill = " + outPatient.calculateBill());
    }
}