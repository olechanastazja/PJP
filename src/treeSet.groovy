def file = new File('textFile.txt')

def words = []
def lines = file.readLines()
lines.each { String entry ->
    def lineList = entry.split()
    words.addAll(lineList)
}

println words
def set1 = words as TreeSet
def list2 = set1.sort{ a, b -> a.size() - b.size() }
println list2
