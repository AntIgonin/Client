package com.company;

import java.net.*;
import java.io.*;

public class Main {
    public static void main(String[] ar)    {
        int serverPort = 6666;
        String address = "127.0.0.1";

        try {
            InetAddress ipAddress = InetAddress.getByName(address); // создаем объект который отображает вышеописанный IP-адрес.
            Socket socket = new Socket(ipAddress, serverPort); // создаем сокет используя IP-адрес и порт сервера.



            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();


            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);


            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line = null;

            while (true) {

                line = in.readUTF();
                System.out.println(line);

                line = keyboard.readLine();
                out.writeUTF(line);
                out.flush();


            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

}
