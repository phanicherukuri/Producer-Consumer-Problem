#DOCUMENTATION

The project mainly consists of five classes: Launch.java, ProducerTask.java, ConsumerTask.java, MsgBufandRes.java, and MessageInfo.java.

##How project executes:
In this project the control starts from Launch.java. The user can selects the number of times he want to perform the entire operations. From Launch class ProducerTask and ConsumerTask threads are started and run concurrently. Basically, the user gives operation and values through ProducerTask.java file.
Here, in this project, the entire operations are done via MsgBufandRes.java class which contains send(), receive() and reply() and result is send back to producer task and where he can perform other operation or exit.
I am sending messages from one class to another using serialization concept. MessageInfo.java class is made serializable and variables are created of MessageInfo class type. 
