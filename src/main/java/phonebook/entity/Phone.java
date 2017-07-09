package phonebook.entity;

import phonebook.enums.PhoneType;

import javax.persistence.*;

/**
 * The entity class, describe user phone, implements a set of standard methods for working with this entity.
 *
 * @author Viacheslav Malhinich
 * @version 1.0
 */
@Entity
@Table(name = "phones")
public class Phone {

    /**
     * Unique identifier.
     */
    @Id
    @GeneratedValue
    private int id;

    /**
     * Phone number.
     */
    @Column(name = "phonenumber")
    private String phoneNumber;

    /**
     * Type of phone (home, mobile or unknown)
     */
    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private PhoneType phoneType;

    /**
     * Additional information about phone.
     */
    @Column(name = "comment")
    private String comment;

    /**
     * No-parameter constructor.
     */
    public Phone() {
        this.phoneNumber = "";
        this.phoneType = PhoneType.UNKNOWN;
        this.comment = "";
    }

    /**
     * Constructor.
     *
     * @param phoneNumber a phone number.
     * @param phoneType   a type of phone.
     * @param comment     information about the contact.
     */
    public Phone(String phoneNumber, PhoneType phoneType, String comment) {
        this.phoneNumber = phoneNumber;
        this.phoneType = phoneType;
        this.comment = comment;
    }

    /**
     * Constructor.
     *
     * @param phoneNumber a phone number.
     * @param phoneType   a type of phone.
     */
    public Phone(String phoneNumber, PhoneType phoneType) {
        this(phoneNumber, phoneType, "");
    }

    /**
     * Constructor.
     *
     * @param phoneNumber a phone number.
     */
    public Phone(String phoneNumber) {
        this(phoneNumber, PhoneType.UNKNOWN);
    }

    /**
     * Getter for field id.
     *
     * @return value of field id.
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for field phoneNumber.
     *
     * @return value of field phoneNumber.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    /**
     * Getter for field comment.
     *
     * @return value of field comment.
     */
    public String getComment() {
        return comment;
    }

    /**
     * Setter for field id.
     *
     * @param id new value of id.
     * @return this changed instance.
     */
    public Phone setId(int id) {
        this.id = id;
        return this;
    }

    /**
     * The method creates and returns a string performance of the instance of this class.
     *
     * @return a string performance of the instance of this class.
     */
    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", phoneType=" + phoneType +
                ", comment='" + comment + '\'' +
                '}';
    }
}
