import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class View extends Command
{
    public View(String directory)
    {
        super(directory);
    }

    //Metoda care executa comanda view (comanda view permite parcurgerea unui folder si deschiderea unui fisier)
    public void executeCommand()
    {
        Path start = Paths.get(getDirectory());
        try (Stream<Path> paths = Files.walk(start, 1))
        {
            paths.filter(path -> !path.equals(start))
                    .forEach(path -> System.out.println(path.getFileName()));
            System.out.print("Enter the directory name: ");
            Scanner scan = new Scanner(System.in);
            String folderName = scan.nextLine();
            Path start2 = Paths.get(getDirectory(), folderName);
            try (Stream<Path> paths2 = Files.walk(start2, 1))
            {
                paths2.filter(path -> !path.equals(start2))
                        .forEach(path -> System.out.println(path.getFileName()));
                System.out.print("Enter the file name: ");
                Scanner scan2 = new Scanner(System.in);
                String fileName = scan.nextLine();
                Path filePath = Paths.get(start2.toString(), fileName);
                if (Files.exists(filePath) && Files.isRegularFile(filePath))
                {
                    Desktop desktop = Desktop.getDesktop();
                    desktop.open(filePath.toFile());
                }
                else
                    System.err.println("File does not exist: " + fileName);
            }
            catch (IOException e)
            {
                System.err.println("An error occurred while loading documents: " + e.getMessage());
            }
        }

        catch (IOException e)
        {
            System.err.println("An error occurred while loading documents.");
        }
    }
}
