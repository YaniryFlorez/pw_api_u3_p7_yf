package uce.edu.web.api.service;

import java.util.List;

import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.repository.modelo.Persona;
import uce.edu.web.api.service.to.EstudianteTo;

public interface IEstudianteService {

     public EstudianteTo buscarPorId(Integer id);
 
    public void insertar(EstudianteTo estudiante);
 
    public void actualizar(EstudianteTo estudiante);
 
    public void eliminar(Integer id);
}

 
