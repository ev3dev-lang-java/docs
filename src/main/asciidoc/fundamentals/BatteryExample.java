package ev3dev.sensors;

import lejos.utility.Delay;

public class BatteryExample {

	public static void main(String[] args) {

        final Battery battery = Battery.getInstance();

		for(int x = 0; x < 20; x++){
			System.out.println("Battery Voltage: " + battery.getVoltage());

			Delay.msDelay(1000);
		}
	}

}
