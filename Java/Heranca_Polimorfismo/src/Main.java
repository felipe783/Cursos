public class Main {
    public static void main(String[] args) {

        // =========================
        // TODO: HERANÇA
        // =========================
        /*
        Employee employee = new Employee();
        Marnager marnager = new marnager();

        marnager.setName("Felipe");
        marnager.setLogin("felipe");
        marnager.setPassword("123");

        System.out.println(marnager.getName());
        System.out.println(marnager.getLogin());
        System.out.println(marnager.getPassword());

        marnager.setName("Felipe");
        marnager.setLogin("felipe");
        marnager.setPassword("123");

        System.out.println(marnager.getName());
        System.out.println(marnager.getLogin());
        System.out.println(marnager.getPassword());
        */
        /*
        // =========================
        // TODO: POLIMORFISMO
        // =========================

        // Objeto comum
        Employee employee = new Employee();

        // Polimorfismo: referência do tipo Employee apontando para marnager
        Employee marnager = new marnager();

        // Classe abstrata não pode ser instanciada diretamente
        // AbsEmployee employee = new AbsEmployee(); // ERRO

        // Forma correta: usar uma classe que estende a abstrata
        AbsEmployee marnager2 = new Absmarnager();

        marnager.setName("Felipe");

        // Métodos específicos de marnager não são acessíveis aqui
        // marnager.setLogin("felipe");
        // marnager.setPassword("123");

        System.out.println(marnager.getName());
        */
        printEmployee(new AbsManager());
        printEmployee(new AbsSalesman());
    }

    public static void printEmployee(AbsEmployee employee){

        System.out.printf("===%s===\n",employee.getClass().getCanonicalName());

        switch (employee){
            case AbsManager manager -> {
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
            }
            case AbsSalesman salesman -> {
                salesman.setSalary(2800);
                salesman.setCode("123456");
                salesman.setName("Lucas");
                salesman.setPercentPerSold(10);

                System.out.println(salesman.getCode());
                System.out.println(salesman.getSalary());
                System.out.println(salesman.getName());
                System.out.println(salesman.getPercentPerSold());
            }
            default -> throw new IllegalStateException("Unexpected value: " + employee);
        }
        System.out.printf("======\n");
    }
}