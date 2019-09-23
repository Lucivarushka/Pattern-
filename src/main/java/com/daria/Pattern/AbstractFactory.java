package main.java.com.daria.Pattern;

public class AbstractFactory {
    public static void main(String[] args) {
        AbstractFactoryForSkills lightHero = new LightRaceFactory();
        AbstractFactoryForSkills darkHero = new DarkRaceFactory();

        ElfOnion heroElf = lightHero.getElfOnion();
        SpeedRun heroOrk = darkHero.getSpeedRun();

        heroElf.shoot();
        heroOrk.express();
    }
}

interface AbstractFactoryForSkills {
    SpeedRun getSpeedRun();

    MagicPower getMagicPower();

    ElfOnion getElfOnion();
}

class LightRaceFactory implements AbstractFactoryForSkills {
    public SpeedRun getSpeedRun() {
        return new Fairy();
    }

    public MagicPower getMagicPower() {
        return new Human();
    }

    public ElfOnion getElfOnion() {
        return new Elf();
    }
}

class DarkRaceFactory implements AbstractFactoryForSkills {
    public SpeedRun getSpeedRun() {
        return new Ork();
    }

    public MagicPower getMagicPower() {
        return new Dwarf();
    }

    public ElfOnion getElfOnion() {
        return null;
    }
}

interface SpeedRun {
    void express();
}

interface MagicPower {
    void fireball();
}

interface ElfOnion {
    void shoot();
}

class Ork implements SpeedRun {
    public void express() {
        System.out.println("slow vzhuh");
    }
}

class Fairy implements SpeedRun {
    public void express() {
        System.out.println("vzhuh");
    }
}

class Human implements MagicPower {
    public void fireball() {
        System.out.println("kaboom");
    }
}

class Dwarf implements MagicPower {
    public void fireball() {
        System.out.println("shch-shch");
    }
}

class Elf implements ElfOnion {
    public void shoot() {
        System.out.println("Shhhhhhhhhh");
    }
}
