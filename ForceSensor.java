/*
 * ForceSensor.java
 * A simple program for reading values from a Phidget force sensor and integrating it with a speaker
 * Group 4
 * @Author Chaye Novak - 902037
 */

import com.phidget22.*;

public class ForceSensor {
        
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
	}
    };
        
    public static DetachListener onForceSensorInput0_Detach =
	new DetachListener() {
	@Override
	public void onDetach(DetachEvent e) {
            System.out.println("Phidget Detached!\n");
	}
    };
       
    public static void main(String[] args) throws Exception {
        VoltageRatioInput ForceSensorInput0 = new VoltageRatioInput();
        DigitalOutput greenLED = new DigitalOutput();
        //DigitalOutput redLED = new DigitalOutput();
        //greenLED.setIsHubPortDevice(true);
        //greenLED.setHubPort(0);
        //ForceSensorInput0.setDeviceSerialNumber(30701);
        ForceSensorInput0.setChannel(0);
        
        ForceSensorInput0.addSensorChangeListener(onForceSensorInput0_SensorChange);
        ForceSensorInput0.addAttachListener(onForceSensorInput0_Attach);
        ForceSensorInput0.addDetachListener(onForceSensorInput0_Detach);
        
        
        ForceSensorInput0.open(5000);
        greenLED.open(1000);
        ForceSensorInput0.setSensorType(VoltageRatioSensorType.VOLTAGE_RATIO);

        while (ForceSensorInput0.getAttached() == true) {
            System.out.println(ForceSensorInput0.getSensorValue());
            double tem = ForceSensorInput0.getSensorValue();
             if (tem > 0.2){
               System.out.println("boi");
               greenLED.setDutyCycle(1);
               //greenLED.setState(true);
            }
             else{
               greenLED.setDutyCycle(0);
             }
        }
        ForceSensorInput0.close();
        greenLED.close();
        System.in.read();
    }
}