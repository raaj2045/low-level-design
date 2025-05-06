package solid;// 5. Dependency Inversion Principle - Class should depend on interfaces
// rather than concrete classes.

interface Keyboard {
    void type();
}

interface Mouse {
    void click();
}

class WiredKeyboard implements Keyboard {
    @Override
    public void type() {
        System.out.println("Typing using wired keyboard");
    }
}

class WiredMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("Clicking using wired mouse");
    }
}

class MacBook {
    private final Keyboard keyboard;
    private final Mouse mouse;

    public MacBook(Keyboard keyboard, Mouse mouse) {
        this.keyboard = keyboard;
        this.mouse = mouse;
    }
}

class MacBookFactory {
    public MacBook createMacBook() {
        return new MacBook(new WiredKeyboard(), new WiredMouse());
    }
}