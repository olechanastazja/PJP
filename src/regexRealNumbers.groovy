def text =  'To jest tekst, w którym występują ceny takie jak 10 PLN. ' +
            'Mogą być też mniej równe np. 14.12 PLN .' +
            '-12.225 to nie jest cena'
//pkt a)
def pattern1 = '\\-?\\b[0-9]+\\.?[0-9]+\\b'

def res = []
text.eachMatch(pattern1, {
    res << it
})
println "W tekście występują następujące liczby rzeczywiste:"
println res

//pkt b)
def pattern2 = '(\\b[0-9]+\\.?[0-9]+\\b)( PLN)'
def current_exchange_rate = 0.22
text = text.replaceAll(pattern2, {
    def price = it[1] as float
    return (price * current_exchange_rate).toString() + " EUR"
});

println "To jest powyższy tekst ze zmienionymi cenami na EUR:"
println text
