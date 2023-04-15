/**
 * @author Mike Quist
 * @date 04/12/2023
 */

public class CurrentConditions implements Display {
    private float temperature;
    private float humidity;
    private float pressure;
    private WeatherStation weatherStation;

    public CurrentConditions(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        this.weatherStation.registerDisplay(this);
    }

    @Override
    public void update() {
        this.temperature = this.weatherStation.getTemperature();
        this.humidity = this.weatherStation.getHumidity();
        this.pressure = this.weatherStation.getPressure();
        display();
    }
    @Override
    public void display() {
        System.out.println("Current Conditions:");
        System.out.printf("Temperature: %.1f F\n", temperature);
        System.out.printf("Humidity: %.1f %%\n", humidity);
        System.out.printf("Pressure: %.2f inHg\n", pressure);
        System.out.println();
    }
}
