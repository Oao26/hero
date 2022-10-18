import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {

    public Arena(int width, int height){
        this.height = height;
        this.width = width;
        hero = new Hero(10, 10);
    }
    public void draw(TextGraphics graphics) throws IOException {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#3366 99"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);
    }
    private void moveHero(Position position) {
        hero.setPosition(position);
    }

    private Hero hero;
    private int width;
    private int height;

    public void processKey(KeyStroke key) {
        if (key.getKeyType() == KeyType.ArrowUp)
            moveHero(hero.moveUp());
        if (key.getKeyType() == KeyType.ArrowDown)
            moveHero(hero.moveDown());
        if (key.getKeyType() == KeyType.ArrowRight)
            moveHero(hero.moveRight());
        if (key.getKeyType() == KeyType.ArrowLeft)
            moveHero(hero.moveLeft());
    }
}
