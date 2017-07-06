package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by Alex on 06.07.2017.
 */

@Entity
@Table (name = "EMPLOYEE")
public class Employee implements Serializable {

    private static final long serialVersionUID = -7544538017359643203L;

    @Id
    private Long id;

    @Column (name = "FIRST_NAME")
    private String firstName;

    @Column (name = "SECOND_NAME")
    private String secondName;

    @Column (name = "BIRTHDAY")
    private Date birthday;

    @OneToOne (cascade = CascadeType.ALL)
    private Address address;

    @ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable (
            name = "EMPL_PROJ",
            joinColumns = @JoinColumn (name = "EMPLOYEE_ID"),
            inverseJoinColumns = @JoinColumn (name = "PROJECT_ID")
    )
    private Set<Project> projects;

    public Employee() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", birthday=" + birthday +
                ", address=" + address +
                '}';
    }
}
