import java.text.Collator

def map = [:].withDefault { 0 }
def languageCollator = Collator.getInstance(new Locale('pl'))
new File('textFile.txt').text.split( /[\s\p{Punct}]+/ ).each { map[it]++ }
map.sort(languageCollator).each { println it }
