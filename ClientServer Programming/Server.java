import java.io.*;
import java.net.*;
class Server
{
	private static Socket socket;
	public static void main(String[] args)
   	{
        	try
        	{
 			int port = 25000;
            		ServerSocket ss = new ServerSocket(port);
            		System.out.println("Server Started and listening to the port 25000");	
           		while(true)
            		{
                		socket=ss.accept();
                		InputStream is = socket.getInputStream();
                		InputStreamReader isr = new InputStreamReader(is);
                		BufferedReader br = new BufferedReader(isr);
                		String number = br.readLine();
                		System.out.println("Message received from client is "+number);
                		String returnMessage;
                		try
                		{
                    			int num = Integer.parseInt(number);
                    			int returnValue = num*2;
                    			returnMessage = String.valueOf(returnValue) + "\n";
                		}
                		catch(NumberFormatException e)
                		{
                    			returnMessage = "Please send a proper number\n";
                		}
 
                		OutputStream os = socket.getOutputStream();
                		OutputStreamWriter osw = new OutputStreamWriter(os);
                		BufferedWriter bw = new BufferedWriter(osw);
                		bw.write(returnMessage);
                		System.out.println("Message sent to the client is "+returnMessage);
                		bw.flush();
            		}
        	}
        	catch (Exception e)
        	{
            		e.printStackTrace();
        	}
        	finally
        	{
            		try
            		{
                		socket.close();
            		}
            		catch(Exception e){}
        	}
    	}
}