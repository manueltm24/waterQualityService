#include <SPI.h>
#include <WiFi101.h>
#define SensorPin     0  //pH meter Analog output to Arduino Analog Input 0

char ssid[] = "CLAROHK0G0_1"; //  your network SSID (name)
char pass[] = "4857544341257F44";  ;   // your network password
//char ssid[] = "AndroidAP"; //  your network SSID (name)
//char pass[] = "12345678910";  ;   // your network password

int status = WL_IDLE_STATUS;
//IPAddress server(192,168,43,232);  // Google
char server[] = "servicewaterquality.herokuapp.com";

unsigned long lastConnectionTime = 0;            // last time you connected to the server, in milliseconds
const unsigned long postingInterval = 10L * 1000L;
int contador=0;

unsigned long int avgValue;  //Store the average value of the sensor feedback
int buf[10],temp; //VARIBLES 

// Initialize the client library
WiFiClient client;

void setup() {
  Serial.begin(9600);
  Serial.println("Attempting to connect to WPA network...");
  Serial.print("SSID: ");
  Serial.println(ssid);

  status = WiFi.begin(ssid, pass);
  if ( status != WL_CONNECTED) { 
    Serial.println("Couldn't get a wifi connection");
    // don't do anything else:
    while(true);
  } 
  else {
    //httpRequest();

  }
}

void loop() {
  float ph = sensorPH();
  float turbiedad= sensorTurbiedad();

  //Serial.println("\n");
  Serial.println("PH:");
  Serial.println(ph);
  Serial.println("Turbiedad:");
  Serial.println(turbiedad);


  if (millis() - lastConnectionTime > postingInterval) {
  //  httpRequest(ph,contador);
    contador++;
  }
}


void httpRequest(float ph, int contador){
   /*
   Serial.println("Connected to wifi");
    Serial.println("\nStarting connection...");
    // if you get a connection, report back via serial:
    if (client.connect(server, 80)) {
      Serial.println("connected");
      // Make a HTTP request:
      client.println("GET /parametros?param1=55 HTTP/1.0");
      client.print( "Host: " );
      client.println(server);
      client.println("Connection: close");
      client.println();
      client.stop();
      lastConnectionTime = millis();
    }else{
       Serial.println("connection failed");
    }
    */

    Serial.println("Connected to wifi");
    Serial.println("\nStarting connection...");

    WiFi.begin(ssid, pass);
    if ( client.connect(server, 80)) {
    Serial.println("Connected");
    client.print("GET /parametros?"); // This
    client.print("param1="); // This
    client.print(ph); // And this is what we did in the testing section above. We are making a GET request just like we would from our browser but now with live data from the sensor
     client.print("&param2="); // This
    client.print(contador);
    client.println(" HTTP/1.1"); // Part of the GET request
    client.print( "Host: " );
    client.println(server);
    client.println("Connection: close"); // Part of the GET request telling the server that we are over transmitting the message
    client.println(); // Empty line
    client.println(); // Empty line
    client.stop();    // Closing connection to server
    lastConnectionTime = millis();
  }
  else{
       Serial.println("connection failed");
    }

}


//FUNCIONES PARAMETROS
float sensorPH()
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

float sensorTurbiedad(){
  int sensorValue = analogRead(A1);// read the input on analog pin 0:
  float voltage = sensorValue * (5.0 / 1024.0); // Convert the analog reading (which goes from 0 - 1023) to a voltage (0 - 5V):
  Serial.println(voltage); // print out the value you read:
  delay(1000);

  return voltage;



}



