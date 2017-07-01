package examples;

import ev3dev.sensors.slamtec.RPLidarA1;
import ev3dev.sensors.slamtec.RPLidarProviderListener;
import ev3dev.sensors.slamtec.model.Scan;

public class Demo3 {

    public static void main(String[] args) throws Exception {

        System.out.println("Testing RPLidar");
        final String USBPort = "/dev/ttyUSB0";
        final RPLidarA1 lidar = new RPLidarA1(USBPort);
        lidar.init();
        lidar.addListener(new RPLidarProviderListener() {
            @Override
            public void scanFinished(Scan scan) {
                System.out.println("Measures: " + scan.getDistances().size());
                scan.getDistances()
                        .stream()
                        .filter((measure) -> measure.getQuality() > 10)
                        .filter((measure) -> (measure.getAngle() >= 345 || measure.getAngle() <= 15))
                        .filter((measure) -> measure.getDistance() <= 50)
                        .forEach(System.out::println);
            }
        });
        for(int x = 0; x <= 10; x++) {
            lidar.scan();
        }
        lidar.close();
        System.out.println("End");
        System.exit(0);
    }

}
