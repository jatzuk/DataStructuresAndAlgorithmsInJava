package chapter8.projects.haffmanCoding

import org.junit.Test

/*
 * Created with passion and love
 *    for project DataStructuresAndAlgorithmsInJava
 *        by Jatzuk on 23.02.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

class HaffmanEncodingTest {
    @Test
    fun haffmanEncodingTest() {
        with(HaffmanEncoding("susie says it is easy")) {
            buildTree()
//            displayTree()
        }
    }
}
