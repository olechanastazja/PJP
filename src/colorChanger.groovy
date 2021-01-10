import groovy.swing.SwingBuilder
import java.awt.*

//tutaj ustawiamy opcje - kolory, czcionkę
backgroundColors = [Color.CYAN, Color.GRAY, Color.BLACK, Color.GREEN, Color.RED]
int i = 0

swing = new SwingBuilder()
new SwingBuilder().edt {
    f = frame(title: 'Events', pack: true, visible: true) {
        button(text: "Click me",
                actionPerformed: { e ->
                    i == backgroundColors.size() - 1 ? (i = 0) : (i += 1)
                    e.source.background = backgroundColors.get(i)
                })
    }
}
