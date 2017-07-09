package phonebook.entity;

import javax.persistence.*;

/**
 * The entity class, describe user entity, implements a set of standard methods for working with this entity.
 *
 * @author Viacheslav Malhinich
 * @version 1.0
 */
@Entity
@Table(name = "users")
@NamedQuery(name = "getAll", query = "SELECT u from User u")
public class User {

    /**
     * Unique identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * User's name.
     */
    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private Phone phone;

    /**
     * No-parameter constructor.
     */
    public User() {
        this.name = "";
        this.phone = new Phone();
    }

    /**
     * Constructor.
     *
     * @param name  user's name.
     * @param phone user's phone.
     */
    public User(String name, Phone phone) {
        this.name = name;
        this.phone = phone;
    }

    /**
     * Getter for field id.
     *
     * @return value of field id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter for field id.
     *
     * @param id new value for field id.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for field name.
     *
     * @return user's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for field phone.
     *
     * @return user's phone.
     */
    public Phone getPhone() {
        return phone;
    }

    /**
     * The method creates and returns a string performance of the instance of this class.
     *
     * @return a string performance of the instance of this class.
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                '}';
    }
}


