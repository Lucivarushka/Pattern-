package main.java.com.daria.Pattern;

public class Proxy {
    public static void main(String[] args) {
        Connection con = new ProxyConnection("# 7653");
        con.connect();
    }
}

interface Connection {

    void connect();

}

class Channel implements Connection {
    private String numberOfChannel;

    public Channel(String numberOfChannel) {
        this.numberOfChannel = numberOfChannel;
        load(numberOfChannel);
    }

    private void load(String numberOfChannel) {
        System.out.println("Connection is established " + numberOfChannel);
    }

    public void connect() {
        System.out.println("Channel connected " + numberOfChannel);
    }
}

class ProxyConnection implements Connection {
    private String numberOfChannelForProxy;
    private Channel channel;

    public ProxyConnection(String numberOfChannelForProxy) {
        this.numberOfChannelForProxy = numberOfChannelForProxy;
    }

    public void connect() {
        if (channel == null) {
            channel = new Channel(numberOfChannelForProxy);
        }
        channel.connect();
    }
}

