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
        screen.setCharacter(x, y, TextCharacter.fromCharacter('X')
                [0]);
        screen.refresh();
        KeyStroke key = screen.readInput();
        processKey(key);
        screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
        screen.refresh();
    }


    public void run() throws IOException {
        System.out.println("run was called");
        while(true) {
            this.draw();
        }
    }

    private int x=10;
    private int y=10;

    private void processKey(KeyStroke key) {
        if (key.getKeyType() == KeyType.ArrowUp || (key.getKeyType() == KeyType.Character && key.getCharacter() == 'w')){
            this.y-=1;
        }
        if (key.getKeyType() == KeyType.ArrowDown || (key.getKeyType() == KeyType.Character && key.getCharacter() == 's')){
            this.y+=1;
        }
        if (key.getKeyType() == KeyType.ArrowLeft || (key.getKeyType() == KeyType.Character && key.getCharacter() == 'a')){
            this.x-=1;
        }
        if (key.getKeyType() == KeyType.ArrowRight || (key.getKeyType() == KeyType.Character && key.getCharacter() == 'd')){
            this.x+=1;
        }

    }


}
