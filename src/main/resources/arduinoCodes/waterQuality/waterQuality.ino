/*
  Web client

 This sketch connects to a website (http://www.google.com)
 using a WiFi shield.

 This example is written for a network using WPA encryption. For
 WEP or WPA, change the WiFi.begin() call accordingly.

 This example is written for a network using WPA encryption. For
 WEP or WPA, change the WiFi.begin() call accordingly.

 Circuit:
 * WiFi shield attached

 created 13 July 2010
 by dlf (Metodo2 srl)
 modified 31 May 2012
 by Tom Igoe
 */
#include<NewPing.h>
#include <SoftwareSerial.h>     //add the soft serial libray
#include <OneWire.h>                
#include <DallasTemperature.h>

  
#define SensorPin     0  //pH meter Analog output to Arduino Analog Input 0

#include <SPI.h>
#include <WiFi101.h>

unsigned long int avgValue;  //Store the average value of the sensor feedback
int buf[10],temp; //VARIBLES 
 int contador=1;

char ssid[] = "CLAROHK0G0_1"; //  your network SSID (name)
char pass[] = "4857544341257F44";    // your network password (use for WPA, or use as key for WEP)
int keyIndex = 0;            // your network key Index number (needed only for WEP)

int status = WL_IDLE_STATUS;
// if you don't want to use DNS (and reduce your sketch size)
// use the numeric IP instead of the name for the server:
//IPAddress server(10,0,0,10);  // numeric IP for Google (no DNS)
char server[] = "servicewaterquality.herokuapp.com";    // name address for Google (using DNS)

// Initialize the Ethernet client library
// with the IP address and port of the server
// that you want to connect to (port 80 is default for HTTP):
WiFiClient client;

void setup() {
  //Initialize serial and wait for port to open:
  Serial.begin(9600);
  while (!Serial) {
    ; // wait for serial port to connect. Needed for native USB port only
  }

  // check for the presence of the shield:
  if (WiFi.status() == WL_NO_SHIELD) {
    Serial.println("WiFi shield not present");
    // don't continue:
    while (true);
  }

  // attempt to connect to WiFi network:
  while (status != WL_CONNECTED) {
    Serial.print("Attempting to connect to SSID: ");
    Serial.println(ssid);
    // Connect to WPA/WPA2 network. Change this line if using open or WEP network:
    status = WiFi.begin(ssid, pass);

    // wait 10 seconds for connection:
    delay(10000);
  }
  Serial.println("Connected to wifi");
  printWiFiStatus();

}

void loop() {

  float ph = PHsensor();
  //float temp =Temperatura();
  float temp =0;
  

  Serial.print("Datos:");
  Serial.print(contador);
  sendParametros(ph,temp,contador);
  // if there are incoming bytes available
  // from the server, read them and print them:
  //while (client.available()) {
    //char c = client.read();
    //Serial.write(c);
  //}

  // if the server's disconnected, stop the client:
 // if (!client.connected()) {
    

    // do nothing forevermore:
   // while (true);
  //}
  contador++;
  //delay(31000); // CADA 10 SEGUNDOS
  
}


void printWiFiStatus() {
  // print the SSID of the network you're attached to:
  Serial.print("SSID: ");
  Serial.println(WiFi.SSID());

  // print your WiFi shield's IP address:
  IPAddress ip = WiFi.localIP();
  Serial.print("IP Address: ");
  Serial.println(ip);

  // print the received signal strength:
  long rssi = WiFi.RSSI();
  Serial.print("signal strength (RSSI):");
  Serial.print(rssi);
  Serial.println(" dBm");
}

//FUNCION QUE ENVIA LOS DATOS AL SERVIDOR
void sendParametros(float ph, float temp,int contador){
    Serial.println("\nStarting connection to server...");
  // if you get a connection, report back via serial:
  if (client.connect(server, 80)) {
    //Serial.println("connected to server");
    // Make a HTTP request:
    //client.println("GET /parametros?param1=100 HTTP/1.1");
    //client.println("Host: ");
    //client.println(server);
    //client.println("Connection: close");
    //client.println();

    client.print("GET /parametros?"); // This
    client.print("param1="); // This
    client.print(ph); // And this is what we did in the testing section above. We are making a GET request just like we would from our browser but now with live data from the sensor
    //client.print("&param2="); // This is Jeen Camilo meter id
    //client.print(temp);
    //client.print(p);
    //client.print("&recharge=");
    //client.print(r);
    client.println(" HTTP/1.1"); // Part of the GET request
    client.print( "Host: " );
    client.println(server);
    client.println("Connection: close"); // Part of the GET request telling the server that we are over transmitting the message
    client.println(); // Empty line
    client.println(); // Empty line
    Serial.println();

      // PH   
     Serial.print(ph,2);
     Serial.print(",");
     
     // Temp
    Serial.print(temp);
    Serial.println(",");

    
    Serial.println("disconnecting from server.");
    client.stop(); // Closing connection to server
  }
  
}




//FUNCIONES PARAMETROS
float PHsensor()
{
  for(int i=0;i<10;i++)       //Get 10 sample value from the sensor for smooth the value
  { 
    buf[i]=analogRead(SensorPin);
    delay(1000);
  }
  for(int i=0;i<9;i++)        //sort the analog from small to large
  {
    for(int j=i+1;j<10;j++)
    {
      if(buf[i]>buf[j])
      {
        temp=buf[i];
        buf[i]=buf[j];
        buf[j]=temp;
      }
    }
  }
  avgValue=0;
  for(int i=2;i<8;i++)                      //take the average value of 6 center sample
    avgValue+=buf[i];
  float phValue=(float)avgValue*5.0/1024/6; //convert the analog into millivolt
  phValue=3.5*phValue;                      //convert the millivolt into pH value
  //digitalWrite(13, HIGH);       
  //delay(800);
  //digitalWrite(13, LOW); 
  return phValue;
}


