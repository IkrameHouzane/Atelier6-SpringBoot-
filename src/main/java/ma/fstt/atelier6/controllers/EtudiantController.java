package ma.fstt.atelier6.controllers;

import ma.fstt.atelier6.entities.Etudiant;
import ma.fstt.atelier6.services.EtudiantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/etudiants")
@RequiredArgsConstructor
public class EtudiantController {

    private final EtudiantService etudiantService;

    // Afficher la liste des étudiants
    @GetMapping
    public String listEtudiants(Model model) {
        model.addAttribute("etudiants", etudiantService.getAllEtudiants());
        return "etudiants/list";
    }

    // Afficher le formulaire d'ajout
    @GetMapping("/nouveau")
    public String showAddForm(Model model) {
        model.addAttribute("etudiant", new Etudiant());
        return "etudiants/form";
    }

    // Afficher le formulaire de modification
    @GetMapping("/modifier/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        model.addAttribute("etudiant", etudiant);
        return "etudiants/form";
    }

    // Enregistrer un étudiant (ajout ou modification)
    @PostMapping("/sauvegarder")
    public String saveEtudiant(@ModelAttribute Etudiant etudiant) {
        etudiantService.saveEtudiant(etudiant);
        return "redirect:/etudiants";
    }

    // Supprimer un étudiant
    @GetMapping("/supprimer/{id}")
    public String deleteEtudiant(@PathVariable Long id) {
        etudiantService.deleteEtudiant(id);
        return "redirect:/etudiants";
    }

    // Rechercher des étudiants
    @GetMapping("/rechercher")
    public String searchEtudiants(@RequestParam(required = false) String nom, Model model) {
        if (nom != null && !nom.isEmpty()) {
            model.addAttribute("etudiants", etudiantService.searchByNom(nom));
        } else {
            model.addAttribute("etudiants", etudiantService.getAllEtudiants());
        }
        return "etudiants/list";
    }
}