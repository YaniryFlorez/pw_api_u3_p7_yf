package uce.edu.web.api.repository.modelo;

import java.util.List;

public interface IEstudianteRepository {

    public Estudiante buscarPorId(Integer id);
 
    public void insertar(Estudiante estudiante);
 
    public void actualizar(Estudiante estudiante);
 
    public void eliminar(Integer id);

    public List<Estudiante> buscarTodos();

    public  List<Estudiante> buscarPorNombre(String nombre);

     public List<Estudiante> buscarPorNombreApellido(String nombre, String apellido);

    
}
