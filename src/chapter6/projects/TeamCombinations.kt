package chapter6.projects

/**
 ** Created with passion and love
 **    for project DataStructuresAndAlgorithmsInJava
 **        by Jatzuk on 25-Oct-18
 **                                            *_____*
 **                                           *_*****_*
 **                                          *_(O)_(O)_*
 **                                         **____V____**
 **                                         **_________**
 **                                         **_________**
 **                                          *_________*
 **                                           ***___***
 */

const val teamSize = 5
const val groupSize = 3

fun showTeams(teamSize: Int, groupSize: Int, sequence: String, letter: Char, evalSize: Int) {
    var seq = sequence
    var let = letter
    if (groupSize > teamSize || teamSize < 0 || groupSize < 0) return

    seq += Character.toString(let)
    let++
    showTeams(teamSize - 1, groupSize - 1, seq, let, evalSize)
    seq = seq.substring(0, seq.length - 1)

    if (seq.length == evalSize) println(seq + (let.toInt() - 1).toChar())
    showTeams(teamSize - 1, groupSize, seq, let, evalSize)
}

fun main(args: Array<String>) {
    val seq = ""
    showTeams(teamSize, groupSize, seq, 'A', groupSize - 1)
}