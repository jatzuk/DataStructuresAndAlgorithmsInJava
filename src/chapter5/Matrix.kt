package chapter5

/**
 * Created by Jatzuk on 23.09.2018
 */

class Matrix<T>(private val rows: Int, private val cols: Int) {
    private var first = MatrixLink<T>(null)
    private var current: MatrixLink<T>? = first

    init {
        for (i in 0 until rows) {
            var tmp = current
            for (j in 1 until cols) {
                tmp?.nextCol = MatrixLink(null)
                tmp = tmp?.nextCol
            }

            if (i < rows - 1) {
                current?.nextRow = MatrixLink(null)
                current = current?.nextRow
            }
        }
    }

    @Throws(IllegalArgumentException::class)
    fun insert(value: T, row: Int, col: Int): Boolean {
        if (row > rows || col > cols || row < 0 || col < 0) {
            throw IllegalArgumentException("values must be in range: [$rows, $cols], got: [$row] x [$col]")
        } else {
            current = first
            for (i in 0 until row) current = current?.nextRow
            for (i in 0 until col) current = current?.nextCol
            current?.data = value
            println("inserted $value at [$row] x [$col]")
            return true
        }
    }

    fun displayMatrix() {
        current = first
        while (current != null) {
            var tmp = current
            while (tmp != null) {
                tmp.displayMatrixLink()
                tmp = tmp.nextCol
            }
            println()
            current = current?.nextRow
        }
    }

    inner class MatrixLink<T>(var data: T?) {
        var nextRow: MatrixLink<T>? = null
        var nextCol: MatrixLink<T>? = null

        fun displayMatrixLink() {
            print("{$data} ")
        }
    }
}
