import java.util.Date;
import java.text.SimpleDateFormat;

public class AlfredQuotes {

    public String basicGreeting() {
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name) {
        return String.format("Hello, %s. Lovely to see you.", name);
    }

    public String dateAnnouncement() {
        Date now = new Date();
        return "It is currently " + now.toString() + ".";
    }

    public String respondBeforeAlexis(String conversation) {
        String lower = conversation.toLowerCase();

        if (lower.indexOf("alexis") >= 0) {
            return "Right , alexis";
        }
        return "Right.";
    }
    
}
