/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package producerconsumer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phani
 */
public class Launch 
{
    public static void main(String[] args) throws IOException
    {       
            int value=0;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //BufferedReader is used to take inputs from the user
            System.out.print("Please enter the number of times you need to perform the entire operation: ");
            int operationalTimes = Integer.parseInt(br.readLine());
            //Users enter the number of times they want to perform the operation
            for(int i=0;i<operationalTimes;i++){
            try {
            System.out.println("Select from add, subtract, multiply, divide, and exit");
            String operation = br.readLine();
            if(operation.equals("exit"))
            {break;
            } //When user choose to exit program terminates           
            if(operation.equals("add")||operation.equals("subtract")
                    ||operation.equals("multiply")||operation.equals("divide"))
            {
             System.out.println("enter value");
             value= Integer.parseInt(br.readLine());
            new ProducerTask(operation,value).start(); //Used to start ProducerTask thread
            new ConsumerTask().start(); //Used to start ConsumerTask thread
            sleep(200);           
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Launch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	System.out.println("Bug introduced");
    }    
}
