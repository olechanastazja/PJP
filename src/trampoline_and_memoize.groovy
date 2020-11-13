import groovy.transform.Memoized

import groovy.transform.TailRecursive

//Przykładem zastosowania trampoliny i memoize może być rozwiązanie problemu wieży hannoi
@TailRecursive
@Memoized
def towerOfHanoi(n,  from_rod, to_rod, aux_rod) {
    if (n == 1) {
        println("Move disk 1 from rod " + from_rod + " to rod " + to_rod);
        return;
    }
    println "Move disk " + n + " from rod " + from_rod + " to rod " + to_rod
    towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
}
println towerOfHanoi(10000, 'A', 'C', 'B');
