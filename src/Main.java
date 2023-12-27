import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        System.out.println("Базовая сложность + Повышенная сложность");
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
        //Базовая сложность
        System.out.println("Сумма зарплат в месяц: " + getSumSalaryPerMonth());
        System.out.println("Минимальная зп сотрудника: " + getMinSalary());
        System.out.println("Максимальная зп сотрудника: " + getMaxSalary());
        System.out.println("Среднаяя зп сотрудника: " + getAverageSalary());
        //Повышенная сложность
        // Задание 1.
        System.out.println(" ");
        getIndexSalary();
        System.out.println(" ");
        System.out.println(" ");
        //Повышенная сложность
        // Задание 2. (a)
        int departmentNumber = 3;
        System.out.println(" ");
        getEmployeeWithMinSalary(departmentNumber);
// Задание 2. b.
        System.out.println(" ");
        System.out.println("Сотрудник с максимальной зарплатой в отделе № "+ departmentNumber +" - " + getMaxDepartmentSalary(2));
        System.out.println(" ");
        // Задание 2. c.
        System.out.printf("Сумма затрат на зарплаты в месяц: в отделе № " + departmentNumber + " - %.2f рублей.", getSumSalaryDepartmentPerMonth(departmentNumber));
        System.out.println(" ");
        System.out.println(" ");
        // Задание 2. d.
        System.out.printf("Среднее значение зарплат: в отделе № " + departmentNumber +" - %.2f рублей.", getAverageSalaryDepartment(departmentNumber));
        System.out.println(" ");
        System.out.println(" ");
        // Задание 2. e.
        getIndexSalaryDepartment(departmentNumber);
        System.out.println(" ");
        System.out.println(" ");
        // Задание 3 a.
        double EmployeesSalary = 30000.00d;
        getAllEmployeesSalaryMin(EmployeesSalary);
        System.out.println(" ");
        // Задание 3 б.
        getAllEmployeesSalaryMax(EmployeesSalary);
    }
    //Повышенная сложность.
    public static void getAllEmployeesSalaryMax(double EmployeesSalary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= EmployeesSalary) {
                System.out.println("Информация о сотруднике: (Уникальный идентификатор = " + employee.getId() + ", " + employee.getPullName() + ", З/П в месяц: " + employee.getSalary() + ')');
            }
        }
    }

    //Повышенная сложность.
    public static void getAllEmployeesSalaryMin(double EmployeesSalary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < EmployeesSalary) {
                System.out.println("Информация о сотруднике: (Уникальный идентификатор = " + employee.getId() + ", " + employee.getPullName() + ", З/П в месяц: " + employee.getSalary() + ')');
            }
        }
    }

    //Повышенная сложность.
    public static void getAllEmployeesDepartment(int departmentNumber) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartments() == departmentNumber) {
                System.out.println("Информация о сотруднике: (Уникальный идентификатор = " + employee.getId() + ", " + employee.getPullName() + ", З/П в месяц: " + employee.getSalary() + ')');
            }
        }
    }
    //Повышенная сложность.
    public static void getIndexSalaryDepartment(int departmentNumber) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartments() == departmentNumber) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * departmentNumber / 100);
                System.out.printf("%.2f  ", employee.getSalary());
            }
        }
    }
    // a. Сотрудник с минимальной зарплатой в отделе
    private static void getEmployeeWithMinSalary(int department) {
        Employee minSalaryEmployee = null;
        double minSalary = Double.MAX_VALUE;
        for (Employee employee : employees) {
            if (employee.getDepartments() == department && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                minSalaryEmployee = employee;
            }
        }
        if (minSalaryEmployee != null) {
            System.out.println("Сотрудник с минимальной зарплатой в отделе " + department + ":");
            System.out.println(minSalaryEmployee);
        } else {
            System.out.println("В отделе " + department + " нет сотрудников.");
        }
    }
    //Повышенная сложность.
    public static double getAverageSalaryDepartment(int departmentNumber) {
        double sum = 0;
        int countEmp = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getDepartments() == departmentNumber) {
                countEmp++;
                sum += employees[i].getSalary();
            }
        }
        return sum / countEmp;
    }
    //Повышенная сложность.
    public static double getSumSalaryDepartmentPerMonth(int departmentNumber) {
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getDepartments() == departmentNumber) {
                sum += employees[i].getSalary();
            }
        }
        return sum;
    }
    //Повышенная сложность
    public static void getIndexSalary() {
        double arg = 10;
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * arg / 100);
                System.out.printf(" %.2f  ", employee.getSalary());

            }
        }

    }
    public static void getAllEmployees() {
        if (employees != null) {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    //Повышенная сложность.
    public static Employee getMinDepartmentSalary(int departmentNumber) {
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
            if (employees[i].getSalary() < min && employees[i].getDepartments() == departmentNumber) {
                min = employees[i].getSalary();
                minSalary = employees[i];
            }
        }
        return minSalary;
    }

    //Повышенная сложность.
    public static Employee getMaxDepartmentSalary(int departmentNumber) {
        double max = 0;
        int index = 0;
        Employee maxSalary = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                max = employees[i].getSalary();
                maxSalary = employees[i];
                index = i;
                break;
            }
        }


        for (int i = index; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getSalary() > max && employees[i].getDepartments() == departmentNumber) {
                max = employees[i].getSalary();
                maxSalary = employees[i];
            }
        }
        return maxSalary;
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


