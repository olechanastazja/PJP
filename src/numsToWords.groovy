def map = [1: 'jeden', 2: 'dwa', 3: 'trzy', 4:'cztery', 5: 'pięć',
       6:'sześć', 7:'siedem', 8: 'osiem', 9:'dziewieć']

def numsToWords(number){
    str = number.toString().split('')
    str.each {
        println map[it.toInteger()]
    }

}
numsToWords(147)
numsToWords(199)
numsToWords(235)
