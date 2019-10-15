/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.belrose.belrose_security.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Ngnawen
 */
@Entity
public class Etudiant implements Serializable  {
    @Id @GeneratedValue
    private Long idEtudiant;
    private String nom;
    private String prenom;
    @Temporal(javax.persistence.TemporalType.DATE) //Précision: Date uniquement
    //@Temporal(javax.persistence.TemporalType.TIME) //Précision: Heure uniquement
    //@Temporal(javax.persistence.TemporalType.TIMESTAMP) //Précision: Date et heure
    //@JsonFormat(pattern = "dd-MM-yyyy HH:mm a z")
    private Date dateNaissance;

    public Etudiant() {
    }

    public Etudiant(String nom, String prenom, Date dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    
    public Long getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(Long idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
   
    
}
