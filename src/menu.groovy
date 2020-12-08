def menuPl = new File('MenuPl.txt')
def current_exchange_rate = 0.22
def menuEur = new File('MenuEur.txt')

def lines = menuPl.readLines()

lines.eachWithIndex{ String entry, int i ->
    def lineList = entry.split("\t")
    def priceInEur = lineList[1] as float * current_exchange_rate
    menuEur.append("${lineList[0]}\t${priceInEur.toString()}\tEUR\n")
}

