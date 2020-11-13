import javax.swing.JOptionPane

def getData(firstArg=null, secondArg=null) {
    def message = "Podaj dane oddzielone białymi znakami"
    def input = JOptionPane.showInputDialog(null, message, "")
    def lst = input.tokenize()
    if (firstArg instanceof Class) {
        try {
            typeChanged = lst.collect{el -> el.asType(firstArg)}
            if(secondArg instanceof Closure && !typeChanged.every(secondArg)){
                getData(firstArg, secondArg)
            }
        }
        catch (err) {
            getData(firstArg, secondArg)
        }
    }
    if(firstArg instanceof Closure && !lst.every(firstArg)){
        getData(firstArg, secondArg)
    }
    return "Wszystkie dane wejściowe są poprawne"
}

//Zgodnie z poleceniem, wprowadzane dane powinny być oddzielone białymi znakami, np. 1 2 3 4
//W przypadku błędu, nieprawidłowych danych, funkcja wywoływana jest ponownie, w celu poprawy błędu,
//dzieje się tak do momentu, w którym wszytskie dane będą prawidłowe, tj, będą spełniały podane warunki
println getData(Integer) { it > 0 }
println getData() { it.size() > 3 }
println getData()
println getData(BigDecimal)