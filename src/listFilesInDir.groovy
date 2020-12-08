def dir = new File('TestDir')

def htmlFilesList = []

dir.eachFileRecurse{
    if (it.name.endsWith('html')) htmlFilesList << it.name
}
htmlFilesList.eachWithIndex{entry, i ->
    println "${i + 1} ${entry}"
}