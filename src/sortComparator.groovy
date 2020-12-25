def comp = [compare: {o1, o2 -> o2 - o1}] as Comparator

def numbers = [2, 1, 8, 5, 6, 4, 7]

//a
numbers.sort(comp)
println numbers

//b
//można tak
numbers.reverse()
println numbers
//albo tak
numbers.sort(Comparator.reverseOrder())
println numbers