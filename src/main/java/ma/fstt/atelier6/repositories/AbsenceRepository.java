package ma.fstt.atelier6.repositories;


import ma.fstt.atelier6.entities.Absence;
import ma.fstt.atelier6.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Long> {

    // Trouver toutes les absences d'un étudiant
    List<Absence> findByEtudiant(Etudiant etudiant);

    // Trouver les absences par étudiant ID
    List<Absence> findByEtudiantId(Long etudiantId);

    // Trouver les absences justifiées
    List<Absence> findByJustifiee(Boolean justifiee);

    // Trouver les absences par date
    List<Absence> findByDate(Date date);

    // Trouver les absences d'un étudiant à une date
    List<Absence> findByEtudiantAndDate(Etudiant etudiant, Date date);
}