package chapter6.projects

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 25.10.2018
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

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
