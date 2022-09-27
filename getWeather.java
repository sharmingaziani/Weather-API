public class getWeather {

    private static final String api_key = "d2c2922b24b604de14ac6f6f23b76393"; 
    private static final String location_endpoint = "http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=d2c2922b24b604de14ac6f6f23b76393";
    private static final String zipcode_endpoint = "http://api.openweathermap.org/data/2.5/weather?zip=%s&APPID=%s";
    
   
    // get data from REST to convert to string and output to user 
    public static String getInfoLocation(String location) {
      
        try {
            // combine endpoint and api key
            URL url = new URL(String.format(location_endpoint,location,api_key));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // read in http request
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            // store info from reader in input 
            String input;
            StringBuffer content = new StringBuffer();

            // append info from input 
            while ((input = in.readLine()) != null) {
                content.append(input);
            }
        
            in.close();
            // reformat output before sending 
            return handleJSON(content.toString());

          // if error occurs, output failure message 
        } catch (Exception e) {
            System.out.println("Failed to get weather data!");
        }
        return "Failed to get data for this location. Make sure location is correctly spelled. Abbreivations are not allowed";
    }
    
    public static String getInfoZipCode(String zipcode) {
      
        try {
          // combine api key and input 
            URL url = new URL(String.format(zipcode_endpoint,zipcode,api_key));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            
            // read http request 
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            // temporarily store reader info in input 
            String input;
            StringBuffer content = new StringBuffer();

            // append info in input 
            while ((input = in.readLine()) != null) {
                content.append(input);
            }
          
            in.close();
            return handleJSON(content.toString());

         // catch statement to output failure message from bot
        } catch (Exception e) {
            System.out.println("Failed to get weather data!");
        }
      
        return "Failed to get data for this zipcode. Only USA zipcodes are supported for now";
    }

    // format string to ouptut 
    public static String handleJSON(String json) {
        // object to parse
        JsonObject obj = new JsonParser().parse(json).getAsJsonObject();

        JsonObject main = obj.getAsJsonObject("main");
        // get info
        double temp = main.get("temp").getAsDouble();
        double temp_max = main.get("temp_max").getAsDouble();
        double temp_min = main.get("temp_min").getAsDouble();
        String weather = obj.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString();
        String location = obj.get("name").getAsString();
        // convert temp and print out formatted string 
        weatherData data = new weatherData(location, weather, temp, temp_min, temp_max);
      
        // formatted string returned to user
        return data.dataString();
    }
