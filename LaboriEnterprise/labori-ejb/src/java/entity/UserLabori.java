package entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(
    uniqueConstraints =@UniqueConstraint(columnNames = {"id", "email"})
)
public class UserLabori implements Serializable {

    @Id
    @GeneratedValue(generator = "Emp_Gen")
    @SequenceGenerator(name = "Emp_Gen", allocationSize = 1)
    private Long id;

    @Column(unique = true, length = 64)
    private String email;

    @Column(length = 32)
    private String password;

    @Column(length = 64)
    private String name;

    @Column(length = 16)
    private String phone;

    @Column(length=4000)
    private String additionalInformation;

    @ManyToOne(cascade=CascadeType.ALL)
    private Uf uf;

    @Column(length = 32)
    private String city;

    @Column(length = 64)
    private String address;

    @Column(length = 16)
    private String cep;

    @ManyToOne(cascade=CascadeType.ALL)
    private Field field;

    @ManyToOne(cascade=CascadeType.ALL)
    private Education education;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

}
