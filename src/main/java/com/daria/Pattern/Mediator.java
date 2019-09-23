package main.java.com.daria.Pattern;

public class Mediator {
    public static void main(String[] args) {
        TextChat textChat = new TextChat();
        User user1 = new User("Piter", textChat);
        User user2 = new User("Tom", textChat);
        user1.sendMessage("Haha");
        user2.sendMessage("Hello");
    }
}

class User {
    private Chat chat;
    private String name;

    public User(String name, Chat chat) {
        this.name = name;
        this.chat = chat;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String msg) {
        chat.sendMessage(this, msg);
    }
}

interface Chat {

    void sendMessage(User user, String message);

}

class TextChat implements Chat {
    public void sendMessage(User user, String message) {
        System.out.println(user.getName() + " say: " + message);
    }
}
