package ma.fstt.atelier6.services;

import ma.fstt.atelier6.entities.Etudiant;
import java.util.List;

public interface EtudiantService {

    // CRUD de base
    List<Etudiant> getAllEtudiants();
    Etudiant getEtudiantById(Long id);
    Etudiant saveEtudiant(Etudiant etudiant);
    void deleteEtudiant(Long id);

    // Méthodes de recherche
    List<Etudiant> searchByNom(String nom);
    List<Etudiant> getEtudiantsByClasse(String classe);
}