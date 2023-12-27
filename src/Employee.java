import java.util.Objects;

public class Employee {
    private final int id;
    private String surname;
    private String name;
    private String middleName;
    private int departments;
    private double salary;
    private static int counter;

    public Employee(String surname, String name, String middleName, int departments, double salary) {
        if (departments <= 0 || departments > 5) throw new IllegalArgumentException ("Введено невалидное значение departments");
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.departments = departments;
        this.salary = salary;
        counter++;
        this.id = getCounter();
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }


    public String getName() {
        return name;
    }


    public String getMiddleName() {
        return middleName;
    }

    public int getDepartments() {
        return departments;
    }

    public void setDepartments(int departments) {
        departments = departments;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        salary = salary;
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "employee{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", departments=" + departments +
                ", salary=" + salary +
                '}';
    }

    public String getPullName() {
        return "employee{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && departments == employee.departments && Double.compare(salary, employee.salary) == 0 && Objects.equals(surname, employee.surname) && Objects.equals(name, employee.name) && Objects.equals(middleName, employee.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}