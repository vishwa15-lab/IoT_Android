package com.benito.udpterminal;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TerminalUDPActivity extends Activity implements OnClickListener{
	EditText edIP ;
    EditText edPorta ;
    EditText edPayload;
    Button red,blue,green,yellow,orange,pink;
	private int sendPacket(int lPorta,String ipHost, int port, String payload) throws IOException {
		
		
		
		InetAddress address = InetAddress.getByName(ipHost);
		//InetAddress address = new InetAddress(192.168.43.72);
				
		//DatagramSocket socket = new DatagramSocket(lPorta);
		DatagramSocket socket = new DatagramSocket(2390);
		
		DatagramPacket packet = new DatagramPacket(payload.getBytes(),payload.length(),address,port);
		
		socket.send(packet);
		socket.disconnect();
		socket.close();
		
		return 0;
	}
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //final EditText edLporta = (EditText) findViewById(R.id.editTextLocalPort);
         edIP = (EditText) findViewById(R.id.editTextIp);
         edPorta = (EditText) findViewById(R.id.editTextPorta);
       //  edPayload = (EditText) findViewById(R.id.editTextPayload);
         red=(Button)findViewById(R.id.buttonRed);
         blue=(Button)findViewById(R.id.buttonBlue);
         green=(Button)findViewById(R.id.buttonGreen);
         yellow=(Button)findViewById(R.id.buttonYellow);
         pink=(Button)findViewById(R.id.buttonPink);
         orange=(Button)findViewById(R.id.buttonOrange);
         red.setOnClickListener(this);
         blue.setOnClickListener(this);
         green.setOnClickListener(this);
         yellow.setOnClickListener(this);
         pink.setOnClickListener(this);
         orange.setOnClickListener(this);
         
    } 
public void onClick(View v) {
	Toast.makeText(getApplication(), "button clicked", Toast.LENGTH_LONG).show();
String data="";
        		 switch (v.getId()) {

        	    case R.id.buttonRed:data="r";
        	        // do your code
        	        break;

        	    case R.id.buttonGreen:data="g";
        	        // do your code
        	        break;

        	    case R.id.buttonBlue:data="b";
        	        // do your code
        	        break;
        	    case R.id.buttonOrange:data="o";
        	        // do your code
        	        break;

        	    case R.id.buttonYellow:data="y";
        	        // do your code
        	        break;

        	    case R.id.buttonPink:data="p";
        	        // do your code
        	        break;     

        	    default:
        	        break;
        	    }
        		String texto = edIP.getText()+":"+edPorta.getText()+
        		             " - Payload: "+data;
        		Toast.makeText(TerminalUDPActivity.this, "Details:\n"+texto ,Toast.LENGTH_LONG).show();
        		
        		int port = Integer.parseInt(edPorta.getText().toString());
        		//int lport = Integer.parseInt(edLporta.getText().toString());
        		try {
					sendPacket(port,edIP.getText().toString(), port, data);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        

}
