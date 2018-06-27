import java.util.Scanner;
import java.io.*;
import java.net.*;
class Client
{
 	private static Socket socket;
 	public static void main(String args[])
    	{
        	try
        	{
			Scanner sc=new Scanner(System.in);
            		String host = "localhost";
            		int port = 25000;
            		InetAddress address = InetAddress.getByName(host);
            		socket = new Socket(address, port);

            		OutputStream os = socket.getOutputStream();
            		OutputStreamWriter osw = new OutputStreamWriter(os);
            		BufferedWriter bw = new BufferedWriter(osw);
 			
			System.out.print("Enter a number: ");
			String number= sc.next();
            		//String number = "5";
 			String sendMessage = number + "\n";
            		bw.write(sendMessage);
            		bw.flush();
            		System.out.println("Message sent to the server : "+sendMessage);
 
            		InputStream is = socket.getInputStream();
            		InputStreamReader isr = new InputStreamReader(is);
            		BufferedReader br = new BufferedReader(isr);
            		String message = br.readLine();
            		System.out.println("Message received from the server : " +message);
        	}
        	catch (Exception exception)
        	{
            		exception.printStackTrace();
        	}
        	finally
        	{
            		try
            		{
                		socket.close();
            		}
            		catch(Exception e)
            		{
                		e.printStackTrace();
            		}
        	}
    	}
}