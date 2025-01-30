package uce.edu.web.api.repository;
 
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.PersistenceContext;
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
        this.entityManager.persist(id);
    }
 
}
 

