/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * This class is for the User entity is has this attributes: idUser, password,
 * enumPrivilege, enumStatus, fullName, email and login.
 *
 * @author Alain Lozano Isasi
 */
@Entity
@Table(name = "user", schema = "appsydb")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idUser;
    @NotNull
    private String password;
    @NotNull
    @Enumerated(EnumType.STRING)
    private EnumPrivilege enumPrivilege;
    @NotNull
    @Enumerated(EnumType.STRING)
    private EnumStatus enumStatus;
    @NotNull
    private String fullName;
    @NotNull
    private String email;
    @NotNull
    @Column(name = "login", unique = true)
    private String login;
    @OneToMany
    private Set<LastSignIn> lastSignins;

    public Integer getId() {
        return idUser;
    }

    public void setId(Integer id) {
        this.idUser = id;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the enumPrivilege
     */
    public EnumPrivilege getEnumPrivilege() {
        return enumPrivilege;
    }

    /**
     * @param enumPrivilege the enumPrivilege to set
     */
    public void setEnumPrivilege(EnumPrivilege enumPrivilege) {
        this.enumPrivilege = enumPrivilege;
    }

    /**
     * @return the enumStatus
     */
    public EnumStatus getEnumStatus() {
        return enumStatus;
    }

    /**
     * @param enumStatus the enumStatus to set
     */
    public void setEnumStatus(EnumStatus enumStatus) {
        this.enumStatus = enumStatus;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the lastSignins
     */
    public Set<LastSignIn> getLastSignins() {
        return lastSignins;
    }

    /**
     * @param lastSignins the lastSignins to set
     */
    public void setLastSignins(Set<LastSignIn> lastSignins) {
        this.lastSignins = lastSignins;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.idUser);
        hash = 31 * hash + Objects.hashCode(this.password);
        hash = 31 * hash + Objects.hashCode(this.enumPrivilege);
        hash = 31 * hash + Objects.hashCode(this.enumStatus);
        hash = 31 * hash + Objects.hashCode(this.fullName);
        hash = 31 * hash + Objects.hashCode(this.email);
        hash = 31 * hash + Objects.hashCode(this.login);
        hash = 31 * hash + Objects.hashCode(this.lastSignins);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.fullName, other.fullName)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.idUser, other.idUser)) {
            return false;
        }
        if (this.enumPrivilege != other.enumPrivilege) {
            return false;
        }
        if (this.enumStatus != other.enumStatus) {
            return false;
        }
        if (!Objects.equals(this.lastSignins, other.lastSignins)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", password=" + password + ", enumPrivilege=" + enumPrivilege + ", enumStatus=" + enumStatus + ", fullName=" + fullName + ", email=" + email + ", login=" + login + ", lastSignins=" + lastSignins + '}';
    }

}
