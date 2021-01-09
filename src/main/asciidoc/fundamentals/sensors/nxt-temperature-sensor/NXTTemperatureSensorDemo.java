import ev3dev.sensors.nxt.NXTTemperatureSensor;
import java.util.stream.IntStream;
import lejos.hardware.port.SensorPort;
import lejos.robotics.SampleProvider;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NXTTemperatureSensorDemo {

    public static void main(String[] args) {

        NXTTemperatureSensor temp1 = new NXTTemperatureSensor(SensorPort.S1);

        final SampleProvider sp = temp1.getCelsiusMode();
        float [] sample = new float[sp.sampleSize()];

        IntStream.range(1,10).boxed()
            .map(i -> {
                sp.fetchSample(sample, 0);
                return sample[0];
            })
            .forEach(temp -> LOGGER.info("Temperature: {}", temp));
    }

}