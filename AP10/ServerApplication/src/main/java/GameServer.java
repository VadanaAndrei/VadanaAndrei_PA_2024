import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    public static final int PORT = 4444;
    private boolean running = true;
    private ServerSocket serverSocket;

    public GameServer() throws IOException {
        try {
            System.out.println("Waiting for a client ...");
            serverSocket = new ServerSocket(PORT);
            while (running) {
                Socket socket = serverSocket.accept();
                new ClientThread(socket, this).start();
            }
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        } finally {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        }
    }

    public synchronized void stopServer() {
        running = false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            System.err.println("Error closing server socket: " + e);
        }
    }

    public static void main(String[] args) throws IOException {
        new GameServer();
    }
}
