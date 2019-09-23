package main.java.com.daria.Pattern;

public class Command {
    public static void main(String[] args) {
        Oven oven = new Oven();
        CommandForOven switchUp = new PutInOven(oven);
        CommandForOven switchDown = new PullOutOven(oven);

        Switch start = new Switch(switchUp, switchDown);

        start.flipUp();
        start.flipDown();
    }
}

class Oven {
    public void putIn() {
        System.out.println("The pie is in the oven");
    }

    public void pullOut() {
        System.out.println("The pie isn't in the oven");
    }
}

interface CommandForOven {

    void execute();

}

class PutInOven implements CommandForOven {
    private Oven oven;

    public PutInOven(Oven oven) {
        this.oven = oven;
    }

    public void execute() {
        oven.putIn();
    }
}

class PullOutOven implements CommandForOven {
    private Oven oven;

    public PullOutOven(Oven oven) {
        this.oven = oven;
    }

    public void execute() {
        oven.pullOut();
    }
}

class Switch {
    private CommandForOven flipUpCommand;
    private CommandForOven flipDownCommand;

    public Switch(CommandForOven flipUpCommand, CommandForOven flipDownCommand) {
        this.flipUpCommand = flipUpCommand;
        this.flipDownCommand = flipDownCommand;
    }

    public void flipUp() {
        flipUpCommand.execute();
    }

    public void flipDown() {
        flipDownCommand.execute();
    }
}

