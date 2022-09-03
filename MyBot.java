import org.jibble.pircbot.*;

public class MyBot extends PircBot {
	
    public MyBot() {
        this.setName("MyBot");
    }
    
    
    public void onMessage(String channel, String sender,
            String login, String hostname, String message) {
    	
    	message = message.toLowerCase();
    	
    	// if the sender asks for a time, bot replies 
    	if (message.equalsIgnoreCase("time")) {
    		String time = new java.util.Date().toString();
    		sendMessage(channel, sender + ": The time is now " + time);
		}
    	
    	// if sender says hey, hi, or hello
        if (message.equalsIgnoreCase("Hello") || (message.equalsIgnoreCase("Hey") ||
        		(message.equalsIgnoreCase("Hi")))) {
        	sendMessage(channel, "Hey! What are you looking for today " + sender + "? ");
        }
        
        // if sender says weather
        if (message.contains("weather")) {
        	// splits message to 1)weather and 2) else
        	String [] split = message.split(" ", 2);
        	
        	// if else is a number, get zipcode 
        	if (isNumber(split[1])) {
        		String messageToSend = getWeather.getInfoZipCode(split[1]); 
        		sendMessage("#weatherapi", messageToSend);
        	}
        	// else go straight to location 
        	else {
        		String messageToSend = getWeather.getInfoLocation(split[1]);
        		sendMessage("#weatherapi", messageToSend);
        	}
        } // if message contains weather 
        
        
    } // onMessage 
    
    
    // if string is a number, returns true 
    public static boolean isNumber(String strNumber) {
    	if (strNumber == null) {
    		return false;
    	}
    	try {
    		double d = Double.parseDouble(strNumber);
    	} catch (NumberFormatException numberFormatE) {
    		return false;
    	}
    	return true;
    } // isNumber

} // MyBot 
