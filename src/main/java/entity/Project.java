package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Alex on 06.07.2017.
 */

@Entity
@Table (name = "Project")
public class Project implements Serializable{

    private static final long serialVersionUID = 1796556740932985128L;

    @Id
    private Long id;

    @Column (name = "TITLE")
    private String title;

    @ManyToMany (mappedBy = "projects")
    private Set<Employee> employees;

    public Project() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
