import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        new Test().testJPA();
    }

    public void testJPA() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamplePU");
        EntityManager em = emf.createEntityManager();

        AuthorRepository repository = new AuthorRepository(em);
        Author markTwain = new Author("Mark Twain");
        repository.create(markTwain);
        System.out.println();

        List<Author> authorsByName = repository.findByName("Mark Twain");
        if (!authorsByName.isEmpty()) {
            System.out.println("Author's name: " + authorsByName.get(0).getName());
        }

        if (!authorsByName.isEmpty()) {
            Author authorToUpdate = authorsByName.get(0);
            em.getTransaction().begin();
            authorToUpdate.setName("Samuel Langhorne Clemens");
            em.getTransaction().commit();
            System.out.println("New name: " + authorToUpdate.getName());
        }

        Author authorById = repository.findById(1);
        if (authorById != null)
            System.out.println("Author with id 1: " + authorById.getName());

        em.close();
        emf.close();
    }
}
