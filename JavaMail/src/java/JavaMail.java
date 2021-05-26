import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.awt.*;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JavaMail {

    private static String USER_NAME = "javapracticeflow";
    private static String PASSWORD = "javapracticeflow001";

    static JSONObject obj = new JSONObject();
    static JSONObject list = new JSONObject();
    static JSONArray emailAddress = new JSONArray();
    static JSONArray subject = new JSONArray();
    static JSONArray body = new JSONArray();

    static Timer timer = new Timer();
    static Toolkit toolkit;

    public static void main(String[] args) throws MessagingException {
        String from = USER_NAME;
        String pass = PASSWORD;
        //jSonCreate();
        //sendFromGMail(from, pass, emailAddress, subject, body);
        schedule();
    }

    private static JSONObject jSonCreate() {

        emailAddress.add("hunyadi.janos.egyesulet@gmail.com");
        subject.add("Test 1");
        body.add("This is a test e-mail to 'Hunyadi'!");

        list.put("emailAddress", emailAddress);
        list.put("subject", subject);
        list.put("body", body);

        obj.put("emails", list);

        emailAddress.add("laszlobalint.mrm@gmail.com");
        subject.add("Test 2");
        body.add("This is a test e-mail to 'Laszlo MRM'!");

        list.put("emailAddress", emailAddress);
        list.put("subject", subject);
        list.put("body", body);

        obj.put("emails", list);

        emailAddress.add("laszlobalint1987@gmail.com");
        subject.add("Test 3");
        body.add("This is a test e-mail to 'Laszlo Balint'!");

        list.put("emailAddress", emailAddress);
        list.put("subject", subject);
        list.put("body", body);

        obj.put("emails", list);

        System.out.println(obj);

        return obj;
    }

    private static void sendFromGMail(String from, String pass, JSONArray to, JSONArray subject, JSONArray body) throws MessagingException {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        for (int i = 0; i < emailAddress.size(); i++) {
            Session session = Session.getDefaultInstance(props, null);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            InternetAddress to_address = new InternetAddress(to.get(i).toString());
            System.out.println("\nMessage was sent to " + to.get(i));
            message.addRecipient(Message.RecipientType.TO, to_address);
            message.setSubject(subject.get(i).toString());
            message.setText(body.get(i).toString());
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
    }

    private static void schedule() {
        toolkit = Toolkit.getDefaultToolkit();
        timer.schedule(new RemindTask(),
        // scheduleAtFixedRate -> repeats are based on a fixed starting date or time
                0,
                60 * 1000);
    }

    private static class RemindTask extends TimerTask {
        int numSendings = 4;

        public void run() {
            if (numSendings > 0) {
                toolkit.beep();
                try {
                    sendScheduledMail(USER_NAME, PASSWORD, "qwer.kocka@gmail.com", "Scheduled mail", "This is a disturbing repeated and scheduled test e-mail.");
                    System.out.println("E-mail was sent to 'qwer.kocka@gmail.com' e-mail address.");
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                numSendings--;
            } else {
                toolkit.beep();
                System.out.println("\nAll messages were sent!");
                System.exit(0);
            }
        }
    }

        private static void sendScheduledMail (String from, String pass, String to, String subject, String body) throws MessagingException {
            Properties props = System.getProperties();
            String host = "smtp.gmail.com";
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.user", from);
            props.put("mail.smtp.password", pass);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            Session session = Session.getDefaultInstance(props, null);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            InternetAddress to_address = new InternetAddress(to);
            System.out.println("\nMessage was sent to " + to);
            message.addRecipient(Message.RecipientType.TO, to_address);
            message.setSubject(String.valueOf(subject));
            message.setText(String.valueOf(body));
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
    }