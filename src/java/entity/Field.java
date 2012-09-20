package entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Field implements Serializable {

    @Id
    @GeneratedValue(generator = "Emp_Gen")
    @SequenceGenerator(name = "Emp_Gen", allocationSize = 1)
    private Long id;

    @Column(unique = true, length = 64)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
