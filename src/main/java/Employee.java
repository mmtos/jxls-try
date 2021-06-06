import java.util.Date;

public class Employee {
    private String name;
    private Date birthDay;
    private int departmentCode;

    public Employee(String name, Date birthDay, int departmentCode) {
        this.name = name;
        this.birthDay = birthDay;
        this.departmentCode = departmentCode;
    }

    public Employee() {

    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", departmentCode=" + departmentCode +
                '}';
    }

    public String getName() {
        return name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public int getDepartmentCode() {
        return departmentCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public void setDepartmentCode(int departmentCode) {
        this.departmentCode = departmentCode;
    }
}
