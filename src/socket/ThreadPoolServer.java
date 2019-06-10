package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: shiyunkai
 * @Date: 2019/06/10 14:56
 * @Description:
 */
public class ThreadPoolServer {

    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        RequestHandler requestHandler = new RequestHandler();

        try(ServerSocket serverSocket = new ServerSocket(7777)){
            System.out.println("Listening on "+serverSocket.getLocalSocketAddress());

            while(true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("Incoming connection from "+ clientSocket.getRemoteSocketAddress());
                executor.submit(
                        new ClientHandler(clientSocket,requestHandler)
                );
            }
        }

    }
}
