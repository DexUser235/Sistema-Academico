package universidad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import universidad.model.Area;
import universidad.service.AlumnoService;
import universidad.service.DocenteService;

@Controller
public class WebController {

    private final AlumnoService alumnoService;
    private final DocenteService docenteService;

    public WebController(AlumnoService alumnoService, DocenteService docenteService) {
        this.alumnoService = alumnoService;
        this.docenteService = docenteService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/alumnos")
    public String alumnos(@RequestParam(required = false) String q, Model model) {
        model.addAttribute("alumnos", alumnoService.listar(q));
        model.addAttribute("areas", Area.values());
        model.addAttribute("q", q);
        return "alumno";
    }

    @PostMapping("/alumnos")
    public String registrar(@RequestParam String nombre,
                            @RequestParam Area area,
                            @RequestParam byte ciclo,
                            RedirectAttributes redirect) {
        try {
            alumnoService.registrar(nombre, area, ciclo);
            redirect.addFlashAttribute("mensaje", "Alumno registrado");
        } catch (IllegalArgumentException e) {
            redirect.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/alumnos";
    }

    @GetMapping("/calificaciones")
    public String calificaciones() { return "Calificaciones"; }

    @GetMapping("/cursos")
    public String cursos() { return "Cursos"; }

    @GetMapping("/docentes")
    public String docentes(@RequestParam(required = false) String q, Model model) {
        model.addAttribute("docentes", docenteService.listar(q));
        model.addAttribute("q", q);
        return "Docentes";
    }

    @GetMapping("/matricula")
    public String matricula() { return "Matricula"; }
}