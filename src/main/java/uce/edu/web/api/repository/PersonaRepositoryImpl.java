package uce.edu.web.api.repository;
 
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import uce.edu.web.api.repository.modelo.IPersonaRepository;
import uce.edu.web.api.repository.modelo.Persona;
 
@Transactional
@ApplicationScoped
public class PersonaRepositoryImpl implements IPersonaRepository{
 
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Persona buscarPorId(Integer id) {
        if (id == null) {
            return null;  
        }
        return this.entityManager.find(Persona.class, id);
    }
    
 
    @Override
    public void insertar(Persona persona) {
        this.entityManager.persist(persona);
       
    }
 
    @Override
    public void actualizar(Persona persona) {
        // TODO Auto-generated method stub
        this.entityManager.merge(persona);
    }
 
    @Override
    public void eliminar(Integer id) {
        // TODO Auto-generated method stub
        this.entityManager.remove(this.buscarPorId(id));
    }

    @Override
    public List<Persona> buscarTodos() {
         TypedQuery<Persona> myQuery=this.entityManager.createQuery("", Persona.class) ;
        return myQuery.getResultList();
    }

    @Override
    public List<Persona> buscarPorNombre(String nombre) {
        TypedQuery<Persona> myQuery =this.entityManager.createQuery("SELECT p from Persona p WHERE p.nombre =:nombre", Persona.class);
        myQuery.setParameter("nombre", nombre);
        return myQuery.getResultList();
    }

    @Override
    public List<Persona> buscarPorNombreApellido(String nombre, String apellido) {
        TypedQuery<Persona> myQuery=this.entityManager.createQuery("SELECT p from Persona p WHERE p.nombre =:nombre AND p.apellido =:apellido", Persona.class);
        myQuery.setParameter("nombre", nombre);
        myQuery.setParameter("apellido", apellido);
        return myQuery.getResultList();
     }
}
 

