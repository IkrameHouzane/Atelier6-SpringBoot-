package ma.fstt.atelier6.services;

import ma.fstt.atelier6.entities.Absence;
import ma.fstt.atelier6.repositories.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbsenceServiceImpl implements AbsenceService {

    @Autowired
    private AbsenceRepository absenceRepository;

    @Override
    public List<Absence> getAllAbsences() {
        return absenceRepository.findAll();
    }

    @Override
    public Absence getAbsenceById(Long id) {
        return absenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Absence non trouvée avec l'id: " + id));
    }

    @Override
    public Absence saveAbsence(Absence absence) {
        return absenceRepository.save(absence);
    }

    @Override
    public void deleteAbsence(Long id) {
        absenceRepository.deleteById(id);
    }

    @Override
    public List<Absence> getAbsencesByEtudiantId(Long etudiantId) {
        return absenceRepository.findByEtudiantId(etudiantId);
    }

    @Override
    public List<Absence> getAbsencesJustifiees() {
        return absenceRepository.findByJustifiee(true);
    }

    @Override
    public List<Absence> getAbsencesNonJustifiees() {
        return absenceRepository.findByJustifiee(false);
    }
}