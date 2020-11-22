import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat

def text = "To jest tekst. Występują w nim różne daty, takie jak: 2020-05-15" +
        "Zdarzają się niepoprawne 2015-25-12 lub 1020-12-58"

def pattern = '[0-9]{4}-[0-9]{2}-[0-9]{2}'
def res = []
text.eachMatch(pattern, {
    res << it
})
println 'Wszystkie znalezione potencjalne daty:'
println res

res.each{strDate ->
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    df.setLenient(false)
    try {
        Date date = df.parse(strDate);
        println date
    } catch (ParseException pe) {
        println "Nieprawidłowa data"
    }
}


