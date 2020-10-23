import javax.swing.*

def prompt = {
    JFrame jframe = new JFrame()
    String answer = JOptionPane.showInputDialog(jframe, it)
    jframe.dispose()
    answer
}
def allProductsList = []
def uniqueProductsMap = [:]
def first = prompt("Produkt 1")
def second = prompt("Produkt 2")
def third = prompt("Produkt 3")
allProductsList.addAll(first, second, third)
for(item in allProductsList){
    def splited = item.split(' = ')
    String itemName = splited[0]
    Integer price = splited[1].toInteger()
    if(itemName in uniqueProductsMap) {
        uniqueProductsMap[itemName] += price
    }
    else{
        uniqueProductsMap[itemName] = price
    }
}
System.out.println(uniqueProductsMap)
//Program pyta o trzy produkty, dane, tak jak w poleceniu, należy wprowadzić w formacie
//produkt = cena (np. chleb = 2), jeśli dany produkt pojawi się więcej niż raz cena zostanie zsumowana