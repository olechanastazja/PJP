def maximum(lst){
    def maxInList = lst.max()
    List indexes = []
    lst.eachWithIndex{ def entry, int i ->
        if(entry == maxInList){
            indexes.push(i)
        }
    }
    return [maxInList, indexes]
}

(maxVal, indList) = maximum( [5, 3, 5, 5, 1, 5] )
println "Maximum: $maxVal"
println "Indexes: $indList"

(maxVal, indList) = maximum(['a', 'c', 'c', 'c', 'b'])
println "Maximum: $maxVal"
println "Indexes: $indList"
