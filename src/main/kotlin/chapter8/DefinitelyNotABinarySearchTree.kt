package chapter8

/*
 * Created with passion and love 
 *    for project DataStructuresAndAlgorithmsInJava(Lafore)
 *        by Jatzuk on 24.02.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

abstract class DefinitelyNotABinarySearchTree<T> : BinaryTree<T>() {
    override fun find(key: T): BinaryTree<T>.Node? {
        throw NotImplementedError("operation is not supported")
    }

    override fun delete(key: T): Node? {
        throw NotImplementedError("operation is not supported")
    }

    override fun insert(value: T) {
        throw NotImplementedError("operation is not supported")
    }
}
