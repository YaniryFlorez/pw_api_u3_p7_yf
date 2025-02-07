package uce.edu.web.api.repository.modelo;

import java.util.List;

import com.arjuna.ats.internal.jdbc.drivers.modifiers.list;

public interface IPersonaRepository {
    public Persona buscarPorId(Integer id);
 
    public void insertar(Persona persona);
 
    public void actualizar(Persona persona);
 
    public void eliminar(Integer id);

    public List <Persona> buscarTodos();

    public  List<Persona> buscarPorNombre(String nombre);
 
}
