import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // TCP, UDP

        try (Socket socket = new Socket("localhost", 7050); // socket - розетка
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream())); // InputStreamReader - перевод байт в символы
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
        ) {
             while (true) {
             Scanner scanner = new Scanner(System.in);
             String message = scanner.nextLine();
             bufferedWriter.write(message + "\n");
             bufferedWriter.flush();
             String messageFromServer = bufferedReader.readLine();
             System.out.println(messageFromServer);

         }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
