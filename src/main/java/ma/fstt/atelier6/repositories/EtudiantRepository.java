package ma.fstt.atelier6.repositories;


import ma.fstt.atelier6.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    // Méthodes personnalisées (Spring les génère automatiquement)

    // Chercher par nom (ignore la casse)
    List<Etudiant> findByNomContainingIgnoreCase(String nom);

    // Chercher par classe
    List<Etudiant> findByClasse(String classe);

    // Chercher par nom et prénom
    List<Etudiant> findByNomAndPrenom(String nom, String prenom);
}
