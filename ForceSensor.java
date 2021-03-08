/**
 * ForceSensor.java
 * A simple program for reading values from a Phidget force sensor and integrating it with a speaker
 * Group 4: Chaye, Moritz, Hei, Liu, Saad
 * @Author Chaye Novak - 902037
 * Contributions: 
 * Chaye (Main focus: software, assisted with hardware + setting up of group software environments and github integration) + co-project management + coursework proposal writeup + assist with demo proposal
 * Moritz (Main focus: hardware, project diagrams) + co-project management + demo 1 proposal write up + demo speech write up
 * Hei (Main focus: hardware + assisted with software) + physical demonstration + 
 * Liu (idea contributions for project proposal + demo)
 * Saad (idea contributions for project demo)
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
        
        // Force Sensor
        ForceSensorInput0.addSensorChangeListener(onForceSensorInput0_SensorChange);
        ForceSensorInput0.addAttachListener(onForceSensorInput0_Attach);
        ForceSensorInput0.addDetachListener(onForceSensorInput0_Detach);
     
        ForceSensorInput0.open(5000);
        greenLED.open(1000);
        ForceSensorInput0.setSensorType(VoltageRatioSensorType.VOLTAGE_RATIO);

        while (ForceSensorInput0.getAttached() == true) {
            System.out.println(ForceSensorInput0.getSensorValue());
            double tem = ForceSensorInput0.getSensorValue();
            if (tem > 0.5){
                   greenLED.setState(true);
                   Thread.currentThread().sleep(1);
                   greenLED.setState(false);
                   Thread.currentThread().sleep(1);
               //greenLED.setState(true);
            }
            if (tem > 0.1&& tem<0.49){
                    greenLED.setState(true);
                    Thread.currentThread().sleep(25);
                    greenLED.setState(false);
                    Thread.currentThread().sleep(25);
             }
            if (tem == 0 ){
                    greenLED.setState(true);
                    Thread.currentThread().sleep(100);
                    greenLED.setState(false);
                    Thread.currentThread().sleep(100);
             }
        }
        
        ForceSensorInput0.close();
        greenLED.close();
        System.in.read();
    }
}