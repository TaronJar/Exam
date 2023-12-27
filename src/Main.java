import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        System.out.println("Базовая сложность:");
        System.out.println();

        employees[0] = new Employee("Максимов", "Максим", "Максимович", 1, 100);
        employees[1] = new Employee("Александров", "Александр", "Александрович", 2, 200);
        employees[2] = new Employee("Дмитриев", "Дмитрий", "Дмитриевич", 3, 300);
        employees[3] = new Employee("Козлов", "Стас", "Бабуинович", 4, 400);
        employees[4] = new Employee("Валерьев", "Гордон", "Баранович", 5, 500);
        employees[5] = new Employee("Асатрян", "Манвел", "Робертович", 2, 600);
        employees[6] = new Employee("Сперцян", "Хачатур", "Хачатурович", 1, 700);
        employees[7] = new Employee("Бабаян", "Серж", "Азатович", 4, 800);
        employees[8] = new Employee("Оганесян", "Никол", "Манвелович", 3, 900);
        employees[9] = new Employee("Владислав", "Димитрий", "Петрович", 2, 1000);
        all();
        System.out.println();
        System.out.println("1." + "Сумма зарплат в месяц: " + getSumSalaryPerMonth());
        System.out.println("2." + "Минимальная зп сотрудника: " + getMinSalary());
        System.out.println("3." + "Максимальная зп сотрудника: " + getMaxSalary());
        System.out.println("4." + "Среднаяя зп сотрудника: " + getAverageSalary());
    }

    public static void all() {
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }


    public static Employee getMinSalary() {
        double min = 0;
        int index = 0;


        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                min = employees[i].getSalary();
                index = i;
                break;
            }

        }
        Employee minSalary = employees[index];
        for (int i = index; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getSalary() < min) {
                min = employees[i].getSalary();
                minSalary = employees[i];

            }

        }
        return minSalary;

    }

    public static double getSumSalaryPerMonth() {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee == null) continue;
            sum += employee.getSalary();
        }
        return sum;
    }

    public static Employee getMaxSalary() {
        double max = 0;
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                max = employees[i].getSalary();
                index = i;
                break;
            }
        }
        Employee maxSalary = employees[index];
        for (int i = index; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getSalary() > max) {
                max = employees[i].getSalary();
                maxSalary = employees[i];
            }
        }
        return maxSalary;
    }

    public static double getAverageSalary() {
        double sum = getSumSalaryPerMonth();
        int count = countEmployees();
        return sum / count;
    }

    public static int countEmployees() {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                count++;
            }
        }
        return count;
    }

    public static void aVoid() {
        for (Employee employee : employees) {
            System.out.println(employee.getPullName());
        }
    }

}
