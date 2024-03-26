public class Main {
    public static void main(String[] args)
    {
        Repository rep = new Repository("MasterDirectory");
        rep.loadDocuments();
        rep.printDocuments();
    }
}

