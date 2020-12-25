import java.text.Collator
import static javax.swing.JOptionPane.*

def wordsList = new URL('https://www.fuw.edu.pl/~werner/files/englishWords.txt').readLines()
def languageCollator = Collator.getInstance(new Locale('en'))

def groupedWords = wordsList.groupBy {
    it.toList().sort(false,languageCollator) }

def anagramsMap = [:].withDefault { [] }
groupedWords.each { k, v -> anagramsMap[k].add(v) }

anagramsMap = anagramsMap.findAll { it.value.first().size() > 6 }

println anagramsMap.sort { o1, o2 -> o1.value.first().size() <=> o2.value.first().size() }
        .collect{ it.value }.collect{ it.join(' ') }.join('\n')

//część odpowiedzialna za wyświetlenie anagramu dla podanego słowa
while (word = showInputDialog 'Podaj słowo:' ) {
    def anagramsList = anagramsMap[word.toList().sort()].first()
    showMessageDialog null, "Dla słowa $word istnieją następujące anagramy:\n" + anagramsList
}