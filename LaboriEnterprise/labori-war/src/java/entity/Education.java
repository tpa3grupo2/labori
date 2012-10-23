package entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Education implements Serializable {

    @Id
    @GeneratedValue(generator = "Emp_Gen")
    @SequenceGenerator(name = "Emp_Gen", allocationSize = 1)
    private Long id;

    private Integer startYear;
    private Integer endYear;

    @Column(length=64)
    private String curse;

    @ManyToOne()
    private UserLabori user;

    @ManyToOne()
    private University university;

    public String getCurse() {
        return curse;
    }

    public void setCurse(String curse) {
        this.curse = curse;
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

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public UserLabori getUser() {
        return user;
    }

    public void setUser(UserLabori user) {
        this.user = user;
    }
}
