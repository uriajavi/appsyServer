/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * This class is for the Client entity, it has the attributes: dateStart and the
 * User attributes: idUser, password, enumPrivilege, enumStatus, fullName, email
 * and login.
 *
 * @author Alain Lozano Isasi
 */
@Entity
@Table(name = "client", schema = "appsydb") 
public class Client extends User implements Serializable {

    private static final long serialVersionUID = 1L;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate dateStart;

    /**
     * @return the dateStart
     */
    public LocalDate getDateStart() {
        return dateStart;
    }

    /**
     * @param dateStart the dateStart to set
     */
    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    
    @OneToMany(cascade=ALL,mappedBy = "Client")
    private Set<Appointment> appointments;
    
     @OneToMany(cascade=ALL,mappedBy = "Client")
    private Set<ClientResource> clientResources;
    
     
    /**
     * @return the appointments
     */
    public Set<Appointment> getAppointments() {
        return appointments;
    }

    /**
     * @param appointments the appointments to set
     */
    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    /**
     * @return the clientResources
     */
    public Set<ClientResource> getClientResources() {
        return clientResources;
    }

    /**
     * @param clientResources the clientResources to set
     */
    public void setClientResources(Set<ClientResource> clientResources) {
        this.clientResources = clientResources;
    }
    

}
