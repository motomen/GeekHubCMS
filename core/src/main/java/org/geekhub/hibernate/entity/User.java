package org.geekhub.hibernate.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 13.05.2015.
 *
 * @Author Odahovskiy (Odahovskiy@gmail.com)
 * @Author Palyvoda (jekainfinity@gmail.com)
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private int id;

    @Column(name = "U_LOGIN", unique = true, nullable = false, length = 25)
    private String login;

    @Column(name = "U_PASSWORD", unique = false, nullable = false, length = 100)
    private String password;

    @Temporal(TemporalType.DATE)
    @Column(name = "U_REG_DATE")
    @NotNull(message = "Registration date should be not null")
    private Date registrationDate;

    @Column(name = "FIRST_NAME", length = 25, nullable = false)
    @NotBlank(message = "Name should be not empty")
    private String firstName;

    @Column(name = "LAST_NAME", length = 25, nullable = false)
    @NotBlank(message = "Surname should be not empty")
    private String lastName;

    @Column(name = "PATRONYMIC", length = 25, nullable = false)
    @NotBlank(message = "Patronymic should be not empty")
    private String patronymic;

    @Column(name = "E_MAIL", length = 40, nullable = false)
    private String email;

    @Column(name = "SKYPE", length = 40)
    private String skype;

    @Column(name = "ICQ", length = 40)
    private String icq;

    @Column(name = "PHONE_NUMBER", length = 40, nullable = false)
    private String phoneNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "B_DAY")
    private Date birthDay;

    @Column(name = "ENABLED", nullable = false)
    private byte enable;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = {@JoinColumn(name = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")})
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private Set<Role> roles = new HashSet<Role>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_COURSES", joinColumns = {@JoinColumn(name = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "COURSE_ID")})
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private Set<Course> courses = new HashSet<Course>();

    public User(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getIcq() {
        return icq;
    }

    public void setIcq(String icq) {
        this.icq = icq;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public byte getEnable() {
        return enable;
    }

    public void setEnable(byte enable) {
        this.enable = enable;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}