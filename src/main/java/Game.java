import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    public Screen screen;
    public Game() throws IOException {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            Screen screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if necessary
            this.screen = screen;
        } catch (IOException e) {
            e.printStackTrace();
        }
        TerminalSize terminalSize = new TerminalSize(40, 20);
        DefaultTerminalFactory terminalFactory = new
                DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();

    }
    private void draw() throws IOException {
        screen.clear();
        hero.draw(screen);
        screen.refresh();
        KeyStroke key = screen.readInput();
        if (key.getKeyType() == KeyType.ArrowUp)
            moveHero(hero.moveUp());
        if (key.getKeyType() == KeyType.ArrowDown)
            moveHero(hero.moveDown());
        if (key.getKeyType() == KeyType.ArrowRight)
            moveHero(hero.moveRight());
        if (key.getKeyType() == KeyType.ArrowLeft)
            moveHero(hero.moveLeft());
    }


    public void run() throws IOException {
        while(true) {
            draw();
        }
    }

    private void moveHero(Position position) {
        hero.setPosition(position);
    }
    private Hero hero=new Hero(10,10);
}
