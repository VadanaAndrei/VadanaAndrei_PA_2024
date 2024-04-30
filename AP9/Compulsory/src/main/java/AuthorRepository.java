import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AuthorRepository {
    private EntityManager em;

    public AuthorRepository(EntityManager em) {
        this.em = em;
    }

    public void create(Author author) {
        em.getTransaction().begin();
        em.persist(author);
        em.getTransaction().commit();
    }

    public Author findById(Integer id) {
        return em.find(Author.class, id);
    }

    public List<Author> findByName(String name) {
        TypedQuery<Author> query = em.createNamedQuery("Author.findByName", Author.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
}
