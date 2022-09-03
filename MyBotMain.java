import org.jibble.pircbot.*;

public class MyBotMain {

    public static void main(String[] args) throws Exception {

    	// start bot up
        MyBot bot = new MyBot();

        // enable debugging output
        bot.setVerbose(true); // allows everything to be printed as it arrives (IRC server)
        
        // connect to IRC server
        bot.connect("irc.us.libera.chat");
        
        // join the channel
        bot.joinChannel("#weatherapi");

        bot.sendMessage("#weatherapi", "Welcome in! My name is MyBot. Happy to assist!");
	
        bot.sendMessage("#weatherapi", "Use \"weather {zipcode/location}\" to get weather info! Use \"ticker {stock ticker}\" to get stock info!");

    }

}
