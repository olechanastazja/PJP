import javax.swing.JOptionPane

def getInts(){
    def message = "Podaj liczby po przecinku"
    def input = JOptionPane.showInputDialog(null, message, "")
    def lst = input.tokenize(',')
    return lst.each {it ->
        if(input.matches(/[0-9,\s]*/)){
            it.toInteger()
        }else{
            getInts()
        }
    }
}
println getInts()