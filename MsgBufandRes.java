/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package producerconsumer;
 
/**
 *
 * @author Phani
 */
public class MsgBufandRes {
       MessageInfo bufValues = new MessageInfo();
       static volatile boolean messageBufferFull = false;
       static volatile boolean responseBufferFull = false;
       //Variables are declared as volatile as their values should be changed by concurrent threads
    public MessageInfo send(MessageInfo structure, MessageInfo producer)
    { 
       messageBufferFull = true;
       bufValues.operation = structure.operation;
       bufValues.value = structure.value;
       // bufValues.tf=true;
       while(responseBufferFull==false)
        {
            //do wait
            //Control goes to infinite loop until responseBufferFull=true
        }       
       responseBufferFull=false;
       return bufValues; //Return computed results to ProducerTask 
    }
    public MessageInfo recieve()
    {
        while(messageBufferFull==false)
        {
            //do wait
        }
        messageBufferFull=false;
        return bufValues; //Returning values to recieve() of Consumer
    }
    public void reply(MessageInfo replyValues)
    {
        
        bufValues.operation = replyValues.operation;
        bufValues.value = replyValues.value;
        //Store computed values 
        responseBufferFull = true;
        //Loop in send() brakes
    }
}

