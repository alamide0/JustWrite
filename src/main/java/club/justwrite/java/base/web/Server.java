package club.justwrite.java.base.web;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running!");
        for(;;){
            Socket socket = serverSocket.accept();
            System.out.println("connected from " + socket.getRemoteSocketAddress());
            Thread t = new Handler(socket);
            t.start();
        }
    }


    private static class Handler extends Thread {
        Socket socket;
        public Handler(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream is = this.socket.getInputStream()){
                try(OutputStream os = this.socket.getOutputStream()){
                    handle(is, os);
                }
            } catch (IOException e) {
                try{
                    this.socket.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                System.out.println("client disconnected");
            }
        }

        private void handle(InputStream is, OutputStream out) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8));

            boolean requestOk = false;
            String first = reader.readLine();
            if(first.startsWith("GET / HTTP/1.")){
                requestOk = true;
            }

            for(;;){
                String header = reader.readLine();
                if(header.isEmpty()){
                    break;
                }
                System.out.println(header);
            }

            System.out.println(requestOk ? "Response OK" : "Response Error");
            if(!requestOk){
                writer.write("HTTP/1.0 404 Not Found\r\n");
                writer.write("Content-Length: 0\r\n");
                writer.write("\r\n");
            }else{
                String data = "<html><body><h1>Hello, World!</h1></body></html>";
                int length = data.getBytes(StandardCharsets.UTF_8).length;
                writer.write("HTTP/1.0 200 OK\r\n");
                writer.write("Connection: close\r\n");
                writer.write("Content-Type: text/html\r\n");
                writer.write("Content-Length: " + length + "\r\n");
                writer.write("\r\n");
                writer.write(data);
            }
            writer.flush();
        }
    }
}


