package main.java.com.daria.Pattern;

public class State {
    public static void main(String[] args) {
        PlayContext playContext = new PlayContext();
        ChangeState seventhCh = new ChannelSeventh();
        ChangeState firstCh = new ChannelFirst();
        ChangeState threeCh = new ChannelThird();
        playContext.setState(firstCh);
        playContext.doAction();
        playContext.setState(seventhCh);
        playContext.doAction();
        playContext.setState(threeCh);
        playContext.doAction();
    }
}

interface ChangeState {
    void doAction();
}

class ChannelSeventh implements ChangeState {
    public void doAction() {
        System.out.println("7 channel is playing");
    }
}

class ChannelFirst implements ChangeState {
    public void doAction() {
        System.out.println("1 channel is playing");
    }
}

class ChannelThird implements ChangeState {
    public void doAction() {
        System.out.println("3 channel is playing");
    }
}

class PlayContext implements ChangeState {
    private ChangeState state;

    public void setState(ChangeState state) {
        this.state = state;
    }

    public void doAction() {
        this.state.doAction();
    }
}

