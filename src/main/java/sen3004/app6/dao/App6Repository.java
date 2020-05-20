package sen3004.app6.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import sen3004.app6.model.Person;
import sen3004.app6.service.IPerson;

@Repository
public class App6Repository implements IPerson {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Person> findAll(){
		return entityManager.createQuery("from Person", Person.class).getResultList();
	}
	
	public Person findById(long id){
		return entityManager.find(Person.class, id);
	}

	@Override
	public void update(Person person) {
		entityManager.merge(person);

	}

	@Override
	public void create(Person person) {
		entityManager.persist(person); 
	}

	@Override
	public void delete(long id) {
		entityManager.remove(entityManager.getReference(Person.class, id));
	} 
}
