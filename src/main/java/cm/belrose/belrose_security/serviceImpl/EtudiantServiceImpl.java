/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.belrose.belrose_security.serviceImpl;

import cm.belrose.belrose_security.dao.EtudiantDao;
import cm.belrose.belrose_security.entities.Etudiant;
import cm.belrose.belrose_security.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ngnawen
 */
@Service
public class EtudiantServiceImpl extends GenericServiceImpl<Etudiant, Long, EtudiantDao> 
        implements EtudiantService{
    
    @Autowired
    public EtudiantServiceImpl(EtudiantDao etudiantDao) {
        super(etudiantDao);
    }
    
}
