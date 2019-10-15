/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.belrose.belrose_security.controller;

import cm.belrose.belrose_security.entities.Etudiant;
import cm.belrose.belrose_security.service.EtudiantService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ngnawen
 */
@RestController
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;
    
    //Ajout d'un nouvel Etudiant
    @Secured(value={"ROLE_ADMIN","ROLE_SCOLARITE"})
    @PostMapping ("/etudiant")
    public Etudiant createEtudiant(@RequestBody Etudiant e) throws Exception{
        return etudiantService.create(e);
    }

    //Liste de tous les etudiats
    @Secured(value={"ROLE_ADMIN","ROLE_SCOLARITE","ROLE_PROF","ROLE_ETUDIANT"})
    @GetMapping("/etudiants")
    public List<Etudiant> listeEtudiants( ) throws Exception{
        return etudiantService.findAll();
    }
    
    //afficher un etudiant
    @Secured(value={"ROLE_ADMIN","ROLE_ETUDIANT"})
    @GetMapping("/etudiant/{id}")
    public Etudiant unEtudiant(@PathVariable("id") Long id) throws Exception{
        return etudiantService.findById(id);
    }
    
    //Supprime un Etudiant
    @Secured(value={"ROLE_ADMIN","ROLE_SCOLARITE"})
     @DeleteMapping(value = "/etudiant/{id}")
    public void deleteEtudian(@PathVariable("id")Long id) throws Exception{
        Etudiant etudiant = etudiantService.findById(id);
        etudiantService.delete(etudiant);
        
    }
    
    
}
