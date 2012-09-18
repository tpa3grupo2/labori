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
}
