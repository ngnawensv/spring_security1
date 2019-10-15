package cm.belrose.belrose_security;

import cm.belrose.belrose_security.entities.Etudiant;
import cm.belrose.belrose_security.service.EtudiantService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BelroseSecurityApplication {

    public static void main(String[] args) throws ParseException, Exception {
        SpringApplication.run(BelroseSecurityApplication.class, args);
        /* 
        ApplicationContext applicationContext = SpringApplication.run(BelroseSecurityApplication.class, args);
        EtudiantService  etudiantService=applicationContext.getBean(EtudiantService.class);
        DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
        etudiantService.create(new Etudiant("Nganwen", "Samuel vermon", dateFormat.parse("12/12/1950")));
        etudiantService.create(new Etudiant("Munchili", "Valentin", dateFormat.parse("12/12/1950")));
        etudiantService.create(new Etudiant("Mefire", "Roger", dateFormat.parse("12/12/1950")));
        
        List<Etudiant> etudiants=etudiantService.findAll();
        etudiants.forEach(e->System.out.println(e.getNom()+" "+e.getPrenom()+" "+e.getDateNaissance()));
         */
    }

}
