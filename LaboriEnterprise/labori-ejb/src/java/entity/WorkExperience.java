package entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class WorkExperience implements Serializable {

    @Id
    @GeneratedValue(generator = "Emp_Gen")
    @SequenceGenerator(name = "Emp_Gen", allocationSize = 1)
    private Long id;

    private Integer startYear;
    private Integer endYear;

    @Column(unique=true, length=64)
    private String position;

    @ManyToOne(cascade=CascadeType.PERSIST)
    private UserLabori user;

    @ManyToOne(cascade=CascadeType.PERSIST)
    private Company company;

    public void setUser(UserLabori user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public UserLabori getUser() {
        return user;
    }
}
