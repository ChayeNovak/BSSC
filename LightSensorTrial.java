/**
	Android program. Light sensor attempt
 	Author: Sa'ad Abdirizaq - 2039436
 */

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

public class MainActivity extends Activity {

 TextView textLIGHT_available, textLIGHT_reading;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textLIGHT_available 
         = (TextView)findViewById(R.id.LIGHT_available);
        textLIGHT_reading 
         = (TextView)findViewById(R.id.LIGHT_reading);

     SensorManager mySensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

     Sensor lightSensor = mySensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
     if(lightSensor != null){
      textLIGHT_available.setText("Sensor.TYPE_LIGHT Available");
      mySensorManager.registerListener(
        lightSensorListener, 
        lightSensor, 
        SensorManager.SENSOR_DELAY_NORMAL);

     } else {
      textLIGHT_available.setText("Sensor.TYPE_LIGHT NOT Available");
     }
    }

    private final SensorEventListener lightSensorListener
     = new SensorEventListener(){

   @Override
   public void onAccuracyChanged(Sensor sensor, int accuracy) {
    // TODO Auto-generated method stub

   }

   @Override
   public void onSensorChanged(SensorEvent event) {
    if(event.sensor.getType() == Sensor.TYPE_LIGHT){
     textLIGHT_reading.setText("LIGHT: " + event.values[0]);   // values array represents light change data
    }
   }

    };

}
