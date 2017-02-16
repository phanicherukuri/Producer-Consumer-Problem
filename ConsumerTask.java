/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package producerconsumer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phani
 */
public class ConsumerTask extends Thread
{
        MessageInfo message = new MessageInfo(); //Creating message of MessageInfo class
        String operation;
        String add="add";
        String subtract="subtract";
        String multiply="multiply";
        String divide="divide";
        int value;
        boolean tf = false;
        int result;
    public void run()
    {
            try {
                //sleep(10000);
                MsgBufandRes consumerBuffer = new MsgBufandRes();
                message = consumerBuffer.recieve();
                //Retrieving user entered values from recieve operation
                operation=message.operation;
                value=message.value;
                if(operation.equals(add))
                {
                    AddCal addcal = new AddCal();
                    result=addcal.add(value);
                    message.value = result;
                }
                else if(operation.equals(subtract))
                {
                    SubtractCal subtractcal = new SubtractCal();
                    result=subtractcal.subract(value);
                    message.value = result;
                }
                else if(operation.equals(multiply))
                {
                    MultiplyCal multiplycal = new MultiplyCal();
                    result=multiplycal.multiply(value);
                    message.value = result;
                }
                else
                {
                    DivideCal dividecal = new DivideCal();
                    result=dividecal.divide(value);
                    message.value = result;
                }
                
                //Sending computed values to reply method of MsgBufandRes class
                consumerBuffer.reply(message);
            } catch (Exception ex) {
                Logger.getLogger(ConsumerTask.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
class AddCal{
public int add(int x){
    int result = 10+x;
    return result;
}
}
class SubtractCal{
public int subract(int x){
    int result = x-10;
    return result;
}
}
class MultiplyCal
{
    public int multiply(int x)
    {
        int result = x*10;
        return result;
    }
 }
class DivideCal
{
    public int divide(int x)
    {
        int result = x/2;
        return result;
    }
 }