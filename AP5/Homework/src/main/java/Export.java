import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Export extends Command
{
    public Export(String name)
    {
        super(name);
    }

    //Metoda care executa comanda export (comanda export creeaza un fisier.json care contine datele dintr-un obiect de tip Repository)
    public void executeCommand()
    {
        Repository rep = new Repository("MasterDirectory");
        rep.loadDocuments();
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            mapper.writeValue(new File("repository.json"), rep);
            System.out.println("JSON file created successfully.");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
