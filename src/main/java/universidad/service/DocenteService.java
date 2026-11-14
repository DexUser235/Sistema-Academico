package universidad.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import universidad.model.Area;
import universidad.model.Docente;
import universidad.model.Strategy.Decorator.ConPlanosDecorator;
import universidad.model.Strategy.Decorator.ConTeoriaDecartor;
import universidad.model.Strategy.dictadoClases.EstrategiaCivil;
import universidad.model.Strategy.dictadoClases.EstrategiaSistemas;

@Service
public class DocenteService {

    private final List<Docente> docentes = new ArrayList<>();

    public DocenteService() {
        docentes.add(new Docente(
                new EstrategiaSistemas(),
                Area.Sistemas,
                "Juan Pérez"));

        docentes.add(new Docente(
                new ConTeoriaDecartor(new EstrategiaSistemas()),
                Area.Sistemas,
                "Carlos Ramírez"));

        docentes.add(new Docente(
                new ConPlanosDecorator(new EstrategiaCivil()),
                Area.Civil,
                "María López"));

        docentes.add(new Docente(
                new ConTeoriaDecartor(new ConPlanosDecorator(new EstrategiaCivil())),
                Area.Civil,
                "Ana Torres"));
    }

    public List<Docente> listar(String q) {
        if (q == null || q.isBlank()) {
            return docentes;
        }
        String filtro = q.toLowerCase();
        return docentes.stream()
                .filter(d -> d.getNombre().toLowerCase().contains(filtro))
                .toList();
    }

    public void registrar(Docente docente) {
        docentes.add(docente);
    }
}