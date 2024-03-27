import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        //Repository rep = new Repository("MasterDirectory");
        while(true)
        {
            System.out.print("Enter your command: ");
            Scanner scan = new Scanner(System.in);
            String command = scan.nextLine();
            if(command.equals("exit"))
                break;
            else if(command.equals("view"))
            {
                Command view = new View("MasterDirectory");
                view.executeCommand();
            }
            else if(command.equals("report"))
            {
                Command report = new Report("MasterDirectory");
                report.executeCommand();
            }
            else if(command.equals("export"))
            {
                Command export = new Export("MasterDirectory");
                export.executeCommand();
            }
            else
                System.out.println("This is not a command!");
            try
            {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //rep.loadDocuments();
        //rep.printDocuments();
    }
}

