/**
 * @author Mike Quist
 * @date 04/12/2023
 */

public class ForecastDisplay implements Display {
    private float lastPressure;
    private float currentPressure;
    private WeatherStation weatherStation;

    public ForecastDisplay(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        this.lastPressure = weatherStation.getPressure();
        this.currentPressure = weatherStation.getPressure();
        this.weatherStation.registerDisplay(this);
    }

    @Override
    public void update() {
        lastPressure = currentPressure;
        currentPressure = weatherStation.getPressure();
        display();
    }

    @Override
    public void display() {
        System.out.print("Forecast: ");
        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            System.out.println("More of the same");
        } else if (currentPressure < lastPressure) {
            System.out.println("Watch out for cooler, rainy weather");
        }
    }
}
