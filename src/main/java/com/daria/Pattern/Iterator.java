package main.java.com.daria.Pattern;

public class Iterator {
    public static void main(String[] args) {
        Proverb proverb = new Proverb();
        IteratorForProverb iteator = proverb.getIIteratorForProverb();

        while (iteator.hasNext()) {
            System.out.print((String) iteator.next());
        }
    }
}

class Proverb implements Aggregate {
    String[] englishProveb = {"When in Rome, ", "do as ", "the Romans."};

    @Override
    public IteratorForProverb getIIteratorForProverb() {
        return new TaskProverb();
    }

    private class TaskProverb implements IteratorForProverb {
        private int index = 0;

        @Override
        public boolean hasNext() {
            if (index < englishProveb.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            return englishProveb[index++];
        }
    }
}

interface IteratorForProverb {
    boolean hasNext();

    Object next();
}

interface Aggregate {
    IteratorForProverb getIIteratorForProverb();
}