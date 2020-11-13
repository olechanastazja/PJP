
def eachTuple(iterable, Closure c){
    def batchSize = c.maximumNumberOfParameters
    def batch = []
    iterable.each{
        println iterable
        batch.add(it)
        println batch
        if (batch.size() == batchSize){
            c(batch)
            batch.clear()
        }
    }
}
//Przykłady użycia z polecenia
def list = (1..40)
eachTuple(list) { e1, e2, e3, e4 ->
    println "$e1 $e2 $e3 $e4"
}

def s = 'asia ma kota i psa'
def out = new StringBuffer()
eachTuple(s) { a,b ->
    out << b << a
}
println out