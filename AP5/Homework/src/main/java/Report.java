import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;

public class Report extends Command
{
    public Report(String name)
    {
        super(name);
    }

    //Metoda care executa comanda report (comanda report creeaza un fisier HTML care contine folderele si file-urile dintr-un director)
    public void executeCommand()
    {
        Repository rep = new Repository(getDirectory());
        rep.loadDocuments();
        StringBuilder res = new StringBuilder();
        for (Map.Entry<Person, java.util.List<Document>> entry : rep.getDocuments().entrySet())
        {
            Person person = entry.getKey();
            List<Document> personDocuments = entry.getValue();

            res.append("Person: " + person.name()).append("<br>");
            res.append("Documents:").append("<br>");
            for (Document document : personDocuments) {
                res.append("- " + document.name() + "." + document.extension()).append("<br>");
            }
            res.append("<br>");
        }

        String htmlContent = new String(res.toString());

        Velocity.init();
        VelocityContext context = new VelocityContext();
        context.put("content", htmlContent);

        try
        {
            Template template = Velocity.getTemplate("template.vm");
            Writer writer = new FileWriter("output.html");
            template.merge(context, writer);
            writer.close();
            System.out.println("The HTML document has been generated.");
            Desktop.getDesktop().browse(new File("output.html").toURI());
        }
        catch (Exception e) {
            System.err.println("Error while trying to open the HTML document: " + e.getMessage());
        }
    }
}

