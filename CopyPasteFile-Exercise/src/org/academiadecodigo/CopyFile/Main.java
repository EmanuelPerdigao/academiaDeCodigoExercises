package org.academiadecodigo.CopyFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        int b;

        //create a buffer of 1024 bytes
        byte[] buffer = new byte[1024];

        //create an input stream and a output stream to read/write from/to the file url
        FileInputStream inputStream = new FileInputStream("resources/image.jpeg");
        FileOutputStream outputStream = new FileOutputStream("resources/imageCopy.jpeg");

        //read the file while theres data to be read
        while ((b = inputStream.read(buffer)) != -1)
        {
            //if the buffer is full
            if (b == buffer.length)
            {
                //write the buffer to the file
                outputStream.write(buffer);
            }
            else
            {
                //if the buffer isnt full
                for(int i = 0; i < b ; i++)
                {
                    //write the last bytes to the file
                    int bytevalue = buffer[i];
                    outputStream.write(bytevalue);
                }
            }
        }

        System.out.println("Done");

        //close the streams
        inputStream.close();
        outputStream.close();
    }
}
