package niraj.code.domain;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A Employee.
 */
@Entity
@Table(name = "employee")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "title")
    private String title;

    @Column(name = "business_unit")
    private String businessUnit;

    @Column(name = "place")
    private String place;

    @Column(name = "supervisor_id")
    private Long supervisorId;

    @Column(name = "competencies")
    private String competencies;

    @Column(name = "salary")
    private Double salary;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public Employee employeeId(Long employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Employee employeeName(String employeeName) {
        this.employeeName = employeeName;
        return this;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getTitle() {
        return title;
    }

    public Employee title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public Employee businessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
        return this;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getPlace() {
        return place;
    }

    public Employee place(String place) {
        this.place = place;
        return this;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Long getSupervisorId() {
        return supervisorId;
    }

    public Employee supervisorId(Long supervisorId) {
        this.supervisorId = supervisorId;
        return this;
    }

    public void setSupervisorId(Long supervisorId) {
        this.supervisorId = supervisorId;
    }

    public String getCompetencies() {
        return competencies;
    }

    public Employee competencies(String competencies) {
        this.competencies = competencies;
        return this;
    }

    public void setCompetencies(String competencies) {
        this.competencies = competencies;
    }

    public Double getSalary() {
        return salary;
    }

    public Employee salary(Double salary) {
        this.salary = salary;
        return this;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }
        return id != null && id.equals(((Employee) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Employee{" +
            "id=" + getId() +
            ", employeeId=" + getEmployeeId() +
            ", employeeName='" + getEmployeeName() + "'" +
            ", title='" + getTitle() + "'" +
            ", businessUnit='" + getBusinessUnit() + "'" +
            ", place='" + getPlace() + "'" +
            ", supervisorId=" + getSupervisorId() +
            ", competencies='" + getCompetencies() + "'" +
            ", salary=" + getSalary() +
            "}";
    }
}
