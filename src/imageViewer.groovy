import javax.swing.JOptionPane
import groovy.swing.SwingBuilder;
import java.awt.FlowLayout;

def message = 'Podaj pełną nazwę katalogu, np. /home/user/dir'
def input = JOptionPane.showInputDialog(null, message, "")
def dir = new File(input)
imagesList = []
dir.eachFileRecurse{
    if (it.name.endsWith('png') || it.name.endsWith('jpg')) imagesList << it.absolutePath
}
int i = 0
swing = new SwingBuilder();
swing.edt{
    f = frame(title: 'Image Viewer',
            size: [400, 200],
            pack: true,
            visible: true,
            defaultCloseOperation: javax.swing.WindowConstants.EXIT_ON_CLOSE) {
            panel(layout: new FlowLayout()) {
                def myLabel = label(icon:imageIcon(file:new File(imagesList.get(i) )))
                button(text: 'next',
                        actionPerformed:  { e ->
                            i == imagesList.size() - 1 ? (i = 0) : (i += 1)
                            myLabel.setIcon(imageIcon(file:new File(imagesList.get(i) )))
                        }
                )
        }
    }
}