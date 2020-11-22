def pmap = [ Groovy: [ 'Asia', 'Jan' ],
             Grails: [ 'Asia', 'Jan', 'Stefan', 'Mirek' ],
             Java: [ 'Asia', 'Stefan', 'Mirek' ],
             JEE: [ 'Slawek', 'Stefan', 'Janusz' ]
]

//pkt a)
pmap.each{k, v ->
    println "W projekcie ${k} pracuje ${v.size()} osoby"
}

//pkt b)
println "Projekty, które mają więcej niż 2 programistów to:"
pmap.each{k, v ->
    if(v.size() > 2){
        println k
    }
}

//pkt c)
def devs = []

pmap.values().each{
    devs.addAll(it)
}
devs = devs.unique()

devs.each{ dev ->
    def projectsList = pmap.findAll({it.value.contains(dev)}).collect {it.key}
    println "${dev} prcuje w projektach: ${projectsList}"
}



