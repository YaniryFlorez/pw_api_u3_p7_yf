package uce.edu.web.api.service;

import java.util.List;
import java.util.function.Function;
 
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.repository.modelo.IEstudianteRepository;
import uce.edu.web.api.service.to.EstudianteTo;

 
@ApplicationScoped
public class EstudianteServiceImpl implements IEstudianteService {
    @Inject
    private IEstudianteRepository iEstudianteRepository;

    private Function<Estudiante, EstudianteTo> mapTo = e -> {
        EstudianteTo eTo = new EstudianteTo(e.getId(), e.getNombre(), e.getApellido(), e.getFechaNacimiento(), e.getTelefono());
        return eTo;
    };

    private Function<EstudianteTo, Estudiante> mapEstudiante = eTo -> {
        Estudiante e = new Estudiante(eTo.getId(), eTo.getNombre(), eTo.getApellido(), eTo.getFechaNacimiento(), eTo.getTelefono());
        return e;
    };

    @Override
    public EstudianteTo buscarPorId(Integer id) {
        // TODO Auto-generated method stub
        Estudiante estu = this.iEstudianteRepository.buscarPorId(id);
        return this.mapTo.apply(estu);
    }

    @Override
    public void insertar(EstudianteTo estudiante) {
        // TODO Auto-generated method stub
        this.iEstudianteRepository.insertar(this.mapEstudiante.apply(estudiante));
    }

    @Override
    public void actualizar(EstudianteTo estudiante) {
        // TODO Auto-generated method stub
        Estudiante per = this.mapEstudiante.apply(estudiante);
        this.iEstudianteRepository.actualizar(per);
    }

    @Override
    public void eliminar(Integer id) {
        // TODO Auto-generated method stub
        this.iEstudianteRepository.eliminar(id);
    }
    @Override
    public List <EstudianteTo> buscarTodos() {
        List<Estudiante> estudiantes = this.iEstudianteRepository.buscarTodos();
        return estudiantes.stream().map(this.mapTo).toList();
    }
 
    @Override
    public List <EstudianteTo> buscarPorNombre(String nombre) {
        List<Estudiante> estudiantes = this.iEstudianteRepository.buscarPorNombre(nombre);
        return estudiantes.stream().map(this.mapTo).toList();
    }

    @Override
    public List<EstudianteTo> buscarPorNombreApellido(String nombre, String apellido) {
        List<Estudiante> estudiantes = this.iEstudianteRepository.buscarPorNombreApellido(nombre, apellido);
        return estudiantes.stream().map(this.mapTo).toList();
    }
    
}
