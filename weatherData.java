
public class weatherData {

    private String location;
    private String weather;
    private double temp;
    private double temp_max;
    private double temp_min;

    //constructors 
    public weatherData(String location, String weather, double temp, double temp_min, double temp_max)
    {
        setLocation(location);
        setWeather(weather);
        setTemp(temp);
        setMin(temp_min);
        setMax(temp_max);
    }

    // formatting information 
    public String dataString() {
        return String.format("The weather in %s is %s. The temperature is %.1f°F, with a high of %.1f°F, and a low of %.1f°F.", location, weather, temp, temp_max, temp_min);
    }

    //convert tempreture 
    private double kelvinToFahren(double kelvin) {
        return (1.8 * (kelvin - 273)) + 32;
    }

    public String getLocation() {
        return location;
    }

    public String getWeather() {
        return weather;
    }

    public double getTemp() {
        return temp;
    }

    public double getMax() {
        return temp_max;
    } 

    public double getMin() {
        return temp_min;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
    public void setMin(double temp_min) {
        this.temp_min = kelvinToFahren(temp_min);
    }
    public void setTemp(double temp) {
        this.temp = kelvinToFahren(temp);
    }

    public void setMax(double temp_max) {
        this.temp_max = kelvinToFahren(temp_max);
    }
	
}
