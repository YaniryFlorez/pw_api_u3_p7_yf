package uce.edu.web.api.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.repository.modelo.IEstudianteRepository;
import jakarta.transaction.Transactional;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

@Transactional
@ApplicationScoped
public class EstufianteRepositoryImpl implements IEstudianteRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Estudiante buscarPorId(Integer id) {
        // TODO Auto-generated method stub
        return this.entityManager.find(Estudiante.class, id);
    }

    @Override
    public void insertar(Estudiante estudiante) {
        // TODO Auto-generated method stub
        this.entityManager.persist(estudiante);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        // TODO Auto-generated method stub
        this.entityManager.merge(estudiante);
    }

    @Override
    public void eliminar(Integer id) {
        // TODO Auto-generated method stub
        this.entityManager.remove(this.buscarPorId(id));
    }

    @Override
    public List<Estudiante> buscarTodos() {
        TypedQuery<Estudiante> myQuery =this.entityManager.createQuery("SELECT e from Estudiante e", Estudiante.class);
        return myQuery.getResultList();
    }

    @Override
    public List<Estudiante> buscarPorNombre(String nombre) {
        TypedQuery<Estudiante> myQuery =this.entityManager.createQuery("SELECT p from Estudiante p WHERE p.nombre =:nombre", Estudiante.class);
        myQuery.setParameter("nombre", nombre);
        return myQuery.getResultList();
    }

    @Override
    public List<Estudiante> buscarPorNombreApellido(String nombre, String apellido) {
        TypedQuery<Estudiante> myQuery=this.entityManager.createQuery("SELECT p from Estudiante p WHERE p.nombre =:nombre AND p.apellido =:apellido", Estudiante.class);
        myQuery.setParameter("nombre", nombre);
        myQuery.setParameter("apellido", apellido);
        return myQuery.getResultList();
     }
    
}
