package ma.fstt.atelier6.services;

import ma.fstt.atelier6.entities.Etudiant;
import ma.fstt.atelier6.repositories.EtudiantRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EtudiantServiceImpl implements EtudiantService {

    private final EtudiantRepository etudiantRepository;

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getEtudiantById(Long id) {
        return etudiantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé avec l'id: " + id));
    }

    @Override
    public Etudiant saveEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public List<Etudiant> searchByNom(String nom) {
        return etudiantRepository.findByNomContainingIgnoreCase(nom);
    }

    @Override
    public List<Etudiant> getEtudiantsByClasse(String classe) {
        return etudiantRepository.findByClasse(classe);
    }
}
