import domain.Employee;
import domain.Manager;
import domain.Salesman;

public class Main {
    public static void main(String[] args) {
        printEmployee(new Manager());
        printEmployee(new Salesman());
    }

    public static void printEmployee(Employee employee){

        System.out.printf("===%s===\n",employee.getClass().getCanonicalName());

        switch (employee){
            case Manager manager -> {
                manager.setSalary(5000);
                manager.setCode("123");
                manager.setName("Felipe");
                manager.setLogin("felipe");
                manager.setPassword("123");
                manager.setCommission(1200);

                System.out.println(manager.getCode());
                System.out.println(manager.getSalary());
                System.out.println(manager.getName());
                System.out.println(manager.getLogin());
                System.out.println(manager.getPassword());
                System.out.println(manager.getCommission());
                System.out.println(manager.getFullSalary(500));
            }
            case Salesman salesman -> {
                salesman.setSalary(2800);
                salesman.setCode("123456");
                salesman.setName("Lucas");
                salesman.setPercentPerSold(10);
                salesman.setSoldAmount(1000);

                System.out.println(salesman.getCode());
                System.out.println(salesman.getSalary());
                System.out.println(salesman.getName());
                System.out.println(salesman.getPercentPerSold());
            }
        }
        System.out.println(employee.getFullSalary());
        System.out.printf("======\n");
    }
}