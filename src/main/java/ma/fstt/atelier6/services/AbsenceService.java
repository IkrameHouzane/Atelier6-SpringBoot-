package ma.fstt.atelier6.services;


import ma.fstt.atelier6.entities.Absence;
import java.util.List;

public interface AbsenceService {

    // CRUD de base
    List<Absence> getAllAbsences();
    Absence getAbsenceById(Long id);
    Absence saveAbsence(Absence absence);
    void deleteAbsence(Long id);

    // Méthodes spécifiques
    List<Absence> getAbsencesByEtudiantId(Long etudiantId);
    List<Absence> getAbsencesJustifiees();
    List<Absence> getAbsencesNonJustifiees();
}