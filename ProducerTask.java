/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package producerconsumer;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/**
 *
 * @author Phani
 */
public class ProducerTask extends Thread
{
            //Scanner scanner = new Scanner(System.in);
            String operation;
            int value;
            MessageInfo producer = new MessageInfo();
            MessageInfo structure = new MessageInfo();
            ProducerTask(String operator, int number)
            {
                this.operation = operator;
                this.value = number;
            }
            //Creating producer and structure named storages of type MessageInfo
            public void run()
            {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //BufferedReader is used to take inputs from the user
       /*
            System.out.println("Please enter the value");
            value=Integer.parseInt(br.readLine());
*/          structure.operation=operation;
            structure.value = value;
            //Storing user input into variable structure
            MsgBufandRes producerBuffer = new MsgBufandRes();
            producer= producerBuffer.send(structure,producer);
            //Sending input to send method of MsgBufandRes class
            System.out.print("result for ("+operation+","+value+") is:");
            System.out.println("("+producer.operation+","+producer.value+")");
//            System.out.println(producer.value);
            //Displaying values after computation
            }catch (Exception ex) {
            Logger.getLogger(ProducerTask.class.getName()).log(Level.SEVERE, null, ex);
            }      /* catch (InterruptedException ex) {
                    Logger.getLogger(ProducerTask.class.getName()).log(Level.SEVERE, null, ex);
                }*/
  }
}