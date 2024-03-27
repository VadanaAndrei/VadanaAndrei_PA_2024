import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Stream;

public class Repository {
    private String directory;
    private Map<Person, List<Document>> documents = new LinkedHashMap<>();

    public Repository(String directory)
    {
        this.directory = directory;
    }

    //Metoda care parcurge MasterDirectory-ul si creeaza map-ul
    public void loadDocuments() {
        Path start = Paths.get(directory);
        try (Stream<Path> paths = Files.walk(start, 1))
        {
            paths.filter(path -> !start.equals(path)).forEach(path ->
            {
                String dirName = path.getFileName().toString();
                String[] parts = dirName.split(" ");
                try
                {
                    if (parts.length == 2 && parts[0].matches("\\d+") && parts[1].matches("[a-zA-Z]+"))
                    {
                        Person person = new Person(Integer.parseInt(parts[0]), parts[1]);
                        List<Document> docs = new ArrayList<>();
                        try (Stream<Path> files = Files.list(path))
                        {
                            files.forEach(file ->
                            {
                                String fileName = file.getFileName().toString();
                                if (fileName.contains("."))
                                {
                                    String[] fileNameParts = fileName.split("\\.");
                                    if (fileNameParts.length == 2)
                                    {
                                        docs.add(new Document(person, fileNameParts[0], fileNameParts[1]));
                                    }
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        documents.put(person, docs);
                    }
                    else
                        throw new InvalidRepositoryException();
                } catch (InvalidRepositoryException e) {
                    System.err.println("Directory has incorrect name");
                }
            });
        } catch (IOException e) {
            System.err.println("An error occurred while loading documents.");
        }
    }

    //Metoda care afiseaza map-ul
    public void printDocuments() {
        for (Map.Entry<Person, List<Document>> entry : documents.entrySet()) {
            Person person = entry.getKey();
            List<Document> personDocuments = entry.getValue();

            System.out.println("Person: " + person.name());
            System.out.println("Documents:");
            for (Document document : personDocuments) {
                System.out.println("- " + document.name() + "." + document.extension());
            }
            System.out.println();
        }
    }

    public Map<Person, List<Document>> getDocuments() {
        return documents;
    }

    public void setDocuments(Map<Person, List<Document>> documents) {
        this.documents = documents;
    }
}

