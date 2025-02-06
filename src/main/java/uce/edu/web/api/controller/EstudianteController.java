package uce.edu.web.api.controller;

import uce.edu.web.api.service.IEstudianteService;
import uce.edu.web.api.service.to.EstudianteTo;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;

@Path("/estudiantes")
public class EstudianteController {

    @Inject
    private IEstudianteService iEstudianteService;

    @GET
    @Path("/buscar")
    public EstudianteTo buscarPorId() {
        Integer id=22;
        return this.iEstudianteService.buscarPorId(id);
    }

    @POST
    @Path("/guardar")
    public void guardar(EstudianteTo estudiante) {
        this.iEstudianteService.insertar(estudiante);
    }

    @PUT
    @Path("/actualizar")
    public void actualizar(EstudianteTo estudiante) {
        this.iEstudianteService.actualizar(estudiante);
    }

    @PATCH
    @Path("/actualizar/parcial")
    public void actualizarParcial(EstudianteTo estudiante) {
        EstudianteTo tmp= this.iEstudianteService.buscarPorId(estudiante.getId());
        tmp.setNombre(estudiante.getNombre());
        this.iEstudianteService.actualizar(tmp);
    }
    
    @DELETE
    @Path("/borrar")
    public void borrar() {
        Integer id=22;
        this.iEstudianteService.eliminar(id);
    }

}
