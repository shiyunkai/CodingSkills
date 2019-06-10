package socket;

import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Auther: shiyunkai
 * @Date: 2019/06/10 14:33
 * @Description:
 */
public class ClientHandler implements Runnable{

    private final Socket clientSocket;
    private final RequestHandler requestHandler;


    public ClientHandler(Socket clientSocket, RequestHandler requestHandler) {
        this.clientSocket = clientSocket;
        this.requestHandler = requestHandler;
    }

    @Override
    public void run(){
        try {
            Scanner input = new Scanner(clientSocket.getInputStream());
            while(true){
                String request = input.nextLine();
                if(request.equals("q")){
                    break;
                }
                System.out.println(String.format("Request from %s: %s",
                        clientSocket.getRemoteSocketAddress(),
                        request));
                String response = requestHandler.handle(request);
                clientSocket.getOutputStream().write(response.getBytes());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
