package id.ac.polban.employee.model;

import id.ac.polban.employee.service.EmployeeService;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistem Manajemen Pegawai ===");

        Department deptIT = new Department("Information Technology");
        Department deptHR = new Department("Human Resources");
        
        EmploymentType typeFullTime = new EmploymentType("Full-Time");
        EmploymentType typeContract = new EmploymentType("Contract");

        Employee emp1 = new Employee(251524, "Ismail Basyir", deptIT, typeFullTime, 7500000);
        Employee emp2 = new Employee(251525, "Jokowi dodo", deptHR, typeContract, 5000000);

        System.out.println("Total Pegawai Terdaftar: " + Employee.getTotalEmployees() + " orang\n");

        EmployeeService service = new EmployeeService();
        service.addEmployee(emp1);
        service.addEmployee(emp2);

        System.out.println("--- Data Awal ---");
        cetakInfoPegawai(service.getEmployee(251524));
        cetakInfoPegawai(service.getEmployee(251525));

        System.out.println("--- Proses Kenaikan Gaji ---");
        System.out.println("Menaikkan gaji Ismail sebesar 15%...");
        service.raiseSalary(251524, 15.0);

        System.out.println("\n--- Data Setelah Kenaikan Gaji ---");
        cetakInfoPegawai(service.getEmployee(251524));
    }

    private static void cetakInfoPegawai(Employee emp) {
        if (emp != null) {
            System.out.println("ID Pegawai : " + emp.getId());
            System.out.println("Nama       : " + emp.getName());
            System.out.println("Departemen : " + emp.getDepartment().getName());
            System.out.println("Status     : " + emp.getType().getType());
            System.out.println("Gaji       : Rp " + emp.getSalary());
            System.out.println("---------------------------------");
        } else {
            System.out.println("Pegawai tidak ditemukan.");
        }
    }
}