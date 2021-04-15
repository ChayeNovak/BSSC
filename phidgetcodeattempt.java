/**

**/

//Phicon
onOffSwitch:

//Force-Sensor; Motor, Speaker, LED (Ambient)
	while (ForceSensorInput0.getAttached() == true) {
	    //System.out.println(ForceSensorInput0.getSensorValue());
	    double tem = ForceSensorInput0.getSensorValue();
       
        //Motor how tf do you make is reverse?
        if (fSwitchInput.getAttached() == true){

	        if (tem > 0.8){
	           motor.setState(true);
	           Thread.currentThread().sleep(1);
	           motor.setState(false);
	           Thread.currentThread().sleep(1);
	        }
	        if (tem > 0.5 && tem<0.79){
	           motor.setState(true);
	           Thread.currentThread().sleep(25);
	           motor.setState(false);
	           Thread.currentThread().sleep(25);
	        }
	        if (tem > 0.1 && tem<0.49){
	           motor.setState(true);
	           Thread.currentThread().sleep(50);
	           motor.setState(false);
	           Thread.currentThread().sleep(50);
	        }
	        if (tem == 0 ){
	           motor.setState(true);
	           Thread.currentThread().sleep(100);
	           motor.setState(false);
	           Thread.currentThread().sleep(100);
	        }
    	}

        //Speaker
        if (tem > 0.8){
           speaker.setState(true);
           Thread.currentThread().sleep(1);
           speaker.setState(false);
           Thread.currentThread().sleep(1);
        }
        if (tem > 0.5 && tem<0.79){
           speaker.setState(true);
           Thread.currentThread().sleep(25);
           speaker.setState(false);
           Thread.currentThread().sleep(25);
        }
        if (tem > 0.1 && tem<0.49){
           speaker.setState(true);
           Thread.currentThread().sleep(50);
           speaker.setState(false);
           Thread.currentThread().sleep(50);
        }
        if (tem == 0 ){
           speaker.setState(true);
           Thread.currentThread().sleep(100);
           speaker.setState(false);
           Thread.currentThread().sleep(100);
        }
	    
	    //Blinking Light (Ambient Media)
        if (tem > 0.8){
           redLED.setState(true);
           Thread.currentThread().sleep(1);
           redLED.setState(false);
           Thread.currentThread().sleep(1);
        }
        if (tem == 0 ){
           redLED.setState(true);
           Thread.currentThread().sleep(100);
           redLED.setState(false);
           Thread.currentThread().sleep(100);
        }


//UtraSonic-Sensor
	while (UltraSonicSensorInput0.getAttached() == true) {
	    //System.out.println(UltraSonicSensorInput0.getSensorValue());
	    double usIn = UltraSonicSensorInput0.getSensorValue();

	    if (usIn > 0.8){
           speaker2.setState(true);
           Thread.currentThread().sleep(1);
           speaker2.setState(false);
           Thread.currentThread().sleep(1);
        }
        if (usIn == 0 ){
           speaker2.setState(true);
           Thread.currentThread().sleep(100);
           speaker2.setState(false);
           Thread.currentThread().sleep(100);
        }
    }


// *attempt* Rumble Steering

      while (tem > 0.5 && (gyro < 45 || gyro > 135)){
        	rumble.setState(true);
        }


// *attempt* light sensor











