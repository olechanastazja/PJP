def apply(List l, Closure c) {
    return l.collect(c)
}

println apply([1, 2, 3, 4], {it+2})
println apply([1, 2, 3, 4], {it*2})