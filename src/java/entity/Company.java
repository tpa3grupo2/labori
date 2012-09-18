package entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Company implements Serializable {

    @Id
    @GeneratedValue(generator = "Emp_Gen")
    @SequenceGenerator(name = "Emp_Gen", allocationSize = 1)
    private Long id;

    @Column(length = 64)
    private String name;
    
    @Column(unique = true, length = 32)
    private String cnpj;

}
