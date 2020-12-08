def projectFile = new File('Projekty.txt')
def bigProjectsFile = new File('ProjektyDuze.txt')
def devsFile = new File('Programisci.txt')

def lines = projectFile.readLines()

def projectsList = [:]
lines.eachWithIndex{ String entry, int i ->
    def lineList = entry.split("\t")
    projectsList.put(lineList.head(), lineList.tail())
}

projectsList.each{k, v ->
    if(v.size() > 2){
        bigProjectsFile.append(k+'\n')
    }
}
def devs = []

projectsList.values().each{
    devs.addAll(it)
}
devs = devs.unique()

devs.each{ dev ->
    def devsProjects = projectsList.findAll({
        it.value.contains(dev)}).collect {it.key}
    devsFile.append("${dev}\t${devsProjects.join("\t")}\n")
}