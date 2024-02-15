package com.idm.config;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class GateWay {
	

	public static void main(String[] args) {
		
		 try
	        {
	            //Variables to find out the Default Gateway IP(s)
	            String canonicalHostName = InetAddress.getLocalHost().getCanonicalHostName();
	            String hostName = InetAddress.getLocalHost().getHostName();

	            //"subtract" the hostName from the canonicalHostName, +1 due to the "." in there
	            String defaultGatewayLeftover = canonicalHostName.substring(hostName.length() + 1);

	            //Info printouts
	            System.out.println("Info:\nCanonical Host Name: " + canonicalHostName + "\nHost Name: " + hostName + "\nDefault Gateway Leftover: " + defaultGatewayLeftover + "\n");
	            System.out.println("Default Gateway Addresses:\n" + printAddresses(InetAddress.getAllByName(defaultGatewayLeftover)));
	        } catch (UnknownHostException e)
	        {
	            e.printStackTrace();
	        }
	    }
	    //simple combined string out the address array
	    private static String printAddresses(InetAddress[] allByName)
	    {
	        if (allByName.length == 0)
	        {
	            return "";
	        } else
	        {
	            String str = "";
	            int i = 0;
	            while (i < allByName.length - 1)
	            {
	                str += allByName[i] + "\n";
	                i++;
	            }
	            return str + allByName[i];
	        }
	    }

	}

