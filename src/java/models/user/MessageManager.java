package models.user;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yanma
 */
public class MessageManager {
    private final UserDBManager userDBManager;

    public MessageManager() {
        this.userDBManager = new UserDBManager();
    }
    
    public boolean createMessage(String sender, String receiver, String content) {
        try {
            Message newMessage = new Message();
            newMessage.setSender(sender);
            newMessage.setReceiver(receiver);
            newMessage.setContent(content);
            newMessage.setIs_read(0);
            this.userDBManager.addMessage(newMessage);
            return true;
        } catch (Exception e) {
            Logger.getLogger(MessageManager.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    
    
    public List<Message> listAllMessage(String sender) {
        return this.userDBManager.queryAllMessages(sender);
    }
    
    public List<Message> queryAllMessagesForReceiver(String receiver) {
        return this.userDBManager.queryAllMessagesForReceiver(receiver);
    }
    
    
    
}