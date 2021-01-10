import groovy.swing.SwingBuilder
import static java.awt.Color.*
import java.awt.*;
import javax.swing.JOptionPane

flowMap = [
        "flow": new FlowLayout(),
        "border": new BorderLayout(),
        "grid": new GridLayout(),
]
dest = [ 'West', 'North', 'East', 'South', 'Center']
def message = "Podaj nazwę menedżera rozkładu.Dostępne możlwości: flow, border lub grid"
def displayButtons(message) {
    def input = JOptionPane.showInputDialog(null, message, "")
    try {
        new SwingBuilder().edt {
            lookAndFeel('metal')
            f = frame(title: 'Layouts',
                    pack: true,
                    visible: true,
                    defaultCloseOperation: javax.swing.WindowConstants.EXIT_ON_CLOSE) {
                    if(!flowMap.containsKey(input)){
                        throw new IllegalArgumentException()
                    }
                    panel(layout:flowMap[input],
                        border: lineBorder(color: BLUE)) {
                        '12345'.each {
                        button(text: "Przycisk ${it}",
                                constraints:input == 'border' ? dest.get(it.toInteger() - 1) : null)
                    }
                }
            }
        }
    } catch (IllegalArgumentException) {
        displayButtons('Podano nieprawidłowy menadżer rozkładu. Możliwości: flow, border, grid.')
    }
}
displayButtons(message)
