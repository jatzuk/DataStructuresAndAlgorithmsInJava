package chapter6

import chapter6.projects.showTeams
import org.junit.Test

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

class TeamCombinationsTest {
    @Test
    fun teamCombinationsTest() {
        val teamSize = 5
        val groupSize = 3
        val seq = ""
        showTeams(teamSize, groupSize, seq, 'A', groupSize - 1)
    }
}
