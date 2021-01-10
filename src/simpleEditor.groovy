import groovy.swing.SwingBuilder
import java.awt.*
import static javax.swing.WindowConstants.*

//tutaj ustawiamy opcje - kolory, czcionkę
backgroundColor = Color.CYAN
fontColor = Color.GRAY
fontType = new Font('Dialog', Font.ITALIC, 18)


swing = new SwingBuilder()
swing.edt {
    lookAndFeel('metal')
    frame(title: 'Prosty edytor',
            pack: true,
            visible: true,
            defaultCloseOperation: EXIT_ON_CLOSE) {
        textArea(preferredSize: new Dimension(600, 600),
                foreground: fontColor,
                background: backgroundColor,
                font: fontType
        )
    }
}