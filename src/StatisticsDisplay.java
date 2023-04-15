/**
 * @author Mike Quist
 * @date 04/12/2023
 */

public class StatisticsDisplay implements Display {
    private float temperatureMin = Float.MAX_VALUE;
    private float temperatureMax = Float.MIN_VALUE;
    private float tempRunningTotal = 0;
    private int numReadings = 0;
    private WeatherStation weatherStation;

    public StatisticsDisplay(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        this.weatherStation.registerDisplay(this);
    }

    @Override
    public void update() {
        float temperature = this.weatherStation.getTemperature();

        if (temperature < temperatureMin) {
            temperatureMin = temperature;
        }

        if (temperature > temperatureMax) {
            temperatureMax = temperature;
        }

        tempRunningTotal += temperature;
        numReadings++;
        display();
    }
    @Override
    public void display() {
        float averageTemperature = tempRunningTotal / numReadings;

        System.out.println("Temperature Statistics:");
        System.out.printf("Min: %.1f F\n", temperatureMin);
        System.out.printf("Max: %.1f F\n", temperatureMax);
        System.out.printf("Average: %.1f F\n", averageTemperature);
        System.out.println();
    }
}
