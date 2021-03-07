/*
 * ForceSensor.java
 * A simple program for reading values from a Phidget force sensor and integrating it with a speaker
 * Group 4
 * @Author Chaye Novak - 902037
 */

import com.phidget22.*;

public class ForceSensor {
    
	static boolean phidget = false;
    public static VoltageRatioInputSensorChangeListener onForceSensorInput0_SensorChange =
	new VoltageRatioInputSensorChangeListener() {
	@Override
	public void onSensorChange(VoltageRatioInputSensorChangeEvent e) {
            System.out.println("SensorValue: " + e.getSensorValue());
 	}
    };
    
    public static AttachListener onForceSensorInput0_Attach =
	new AttachListener() {
	@Override
	public void onAttach(AttachEvent e) {
            System.out.println("Phidget Attached!\n");
            phidget = true;
            
	}
    };
        
    public static DetachListener onForceSensorInput0_Detach =
	new DetachListener() {
	@Override
	public void onDetach(DetachEvent e) {
            System.out.println("Phidget Detached!\n");
            phidget = false;
	}
    };
       
    public static void main(String[] args) throws Exception {
        //Create Phidget channels
        VoltageRatioInput ForceSensorInput0 = new VoltageRatioInput();
        
        ForceSensorInput0.setChannel(0);

        //Assign event handlers need before calling open so that no events are missed.
        ForceSensorInput0.addSensorChangeListener(onForceSensorInput0_SensorChange);
        ForceSensorInput0.addAttachListener(onForceSensorInput0_Attach);
        ForceSensorInput0.addDetachListener(onForceSensorInput0_Detach);

        //Open Phidgets and wait for attachment
        ForceSensorInput0.open(5000);
       
        //Do stuff with Phidget
        //Set the sensor type to match Force Sensor after opening the Phidget
        ForceSensorInput0.setSensorType(VoltageRatioSensorType.VOLTAGE_RATIO); // Force Sensor
        
        while (ForceSensorInput0.getAttached() == true) {
            System.out.println(ForceSensorInput0.getSensorValue());
        }
       
        //Wait until Enter has been pressed before exiting
        System.in.read();

        //Close your Phidgets once the program is done.
        ForceSensorInput0.close();
    }
}