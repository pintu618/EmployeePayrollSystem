import java.util.ArrayList;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public int getid() {
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee[name=" + name + ",id=" + id + ",salary=" + calculateSalary() + "]";
    }
}
    class fulltimeEmployee extends Employee{
        private double monthlySalary;

        public fulltimeEmployee(String name, int id, double monthlySalary){
            super(name, id);
            this.monthlySalary=monthlySalary;

        }
        @Override
        public double calculateSalary(){
            return monthlySalary;
        }
    }
    class parttimeEmployee extends Employee {
        private int hoursWork;
        private double hourlyRate;

        public parttimeEmployee(String name, int id, int hoursWork, double hourlyRate) {
            super(name, id);
            this.hourlyRate = hourlyRate;
            this.hoursWork = hoursWork;

        }

        @Override
        public double calculateSalary() {
            return hoursWork * hourlyRate;
        }

}
class payrollSystem{
    private ArrayList<Employee>employeelist;

    public payrollSystem(){
        employeelist=new ArrayList<>();

    }
    public void addemployee(Employee employee ){
       employeelist.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeetoremove =null;
        for(Employee employee:employeelist){
            if(employee.getid()==id){
                employeetoremove=employee;
                break;
            }
        }
        if(employeetoremove!=null){
            employeelist.remove(employeetoremove);
        }
    }
    public void displayEmployee(){
        for(Employee employee: employeelist){
            System.out.println(employee);
        }
    }



}

public class Main {
    public static void main(String[] args) {
        System.out.println(" Welcome to Employee payroll system");

        payrollSystem PayrollSystem = new payrollSystem();
        fulltimeEmployee emp1 = new fulltimeEmployee("vikas", 1, 10000);
        parttimeEmployee emp2 = new parttimeEmployee("suraj", 2, 4, 100);

        PayrollSystem.addemployee(emp1);
        PayrollSystem.addemployee(emp2);
        System.out.println("initial Employee Details : ");
        PayrollSystem.displayEmployee();
        System.out.println("removing employee");
        PayrollSystem.removeEmployee(2);
        System.out.println("remaining employee detail");
        PayrollSystem.displayEmployee();




    }
}