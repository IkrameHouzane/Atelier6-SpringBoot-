package ma.fstt.atelier6.controllers;

import ma.fstt.atelier6.entities.Absence;
import ma.fstt.atelier6.services.AbsenceService;
import ma.fstt.atelier6.services.EtudiantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/absences")
@RequiredArgsConstructor
public class AbsenceController {

    private final AbsenceService absenceService;
    private final EtudiantService etudiantService;

    // Afficher la liste des absences
    @GetMapping
    public String listAbsences(Model model) {
        model.addAttribute("absences", absenceService.getAllAbsences());
        return "absences/list";
    }

    // Afficher le formulaire d'ajout
    @GetMapping("/nouveau")
    public String showAddForm(Model model) {
        model.addAttribute("absence", new Absence());
        model.addAttribute("etudiants", etudiantService.getAllEtudiants());
        return "absences/form";
    }

    // Afficher le formulaire de modification
    @GetMapping("/modifier/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Absence absence = absenceService.getAbsenceById(id);
        model.addAttribute("absence", absence);
        model.addAttribute("etudiants", etudiantService.getAllEtudiants());
        return "absences/form";
    }

    // Enregistrer une absence
    @PostMapping("/sauvegarder")
    public String saveAbsence(@ModelAttribute Absence absence) {
        absenceService.saveAbsence(absence);
        return "redirect:/absences";
    }

    // Supprimer une absence
    @GetMapping("/supprimer/{id}")
    public String deleteAbsence(@PathVariable Long id) {
        absenceService.deleteAbsence(id);
        return "redirect:/absences";
    }

    // Voir les absences d'un étudiant
    @GetMapping("/etudiant/{id}")
    public String listAbsencesByEtudiant(@PathVariable Long id, Model model) {
        model.addAttribute("absences", absenceService.getAbsencesByEtudiantId(id));
        model.addAttribute("etudiant", etudiantService.getEtudiantById(id));
        return "absences/list";
    }
}