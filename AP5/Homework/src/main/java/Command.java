public abstract class Command
{
    private String directory;

    public Command(String directory)
    {
        this.directory = directory;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public abstract void executeCommand();
}
