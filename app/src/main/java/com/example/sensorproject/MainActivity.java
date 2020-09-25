package com.example.sensorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
      SensorManager sensorManager;
      Sensor proximitySensor;
      TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.textView1);
        t2=findViewById(R.id.textView2);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);
        proximitySensor=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if(proximitySensor==null)
        {
            t1.setText("There is no Proximity Sensor present");
        }
        else {
            sensorManager.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
        }

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
//        if(sensorEvent.sensor.getType()==Sensor.TYPE_PROXIMITY){
//            if(sensorEvent.values[0]==0)
//            {
//                t2.setText("Near");
//            }
//            else
//            {
//                t2.setText("Away");
//            }
//        }
    float [] value=sensorEvent.values;
    t2.setText(""+value[0]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}