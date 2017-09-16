import java.io.File
import java.util.SortedSet

fun main(args: Array<String>) {
    var lines = File("input.txt").readLines()

    var A = lines[1].split(" ").map { it.toDouble() }
    val B = A.toSortedSet()

    var sums: Array<Double> = Array<Double>(3, {0.0})

    sums[0] = B.elementAt(0)
    sums[1] = B.elementAt(B.size / 2)
    sums[2] = B.elementAt(B.size-1)

    val result = findIndexes(A, sums)

    File("output.txt").createNewFile()
    File("output.txt").writeText(result.joinToString(" "))
}

fun findIndexes(B: List<Double>, sums: Array<Double>): Array<Int?> {
    var result: Array<Int?> = Array<Int?>(3, {null})

    B.forEachIndexed { index, s ->
        when (s) {
            sums[0] -> result[0] = index + 1
            sums[1] -> result[1] = index + 1
            sums[2] -> result[2] = index + 1
        }

       if (result[0] != null && result[1] != null && result[2] != null) {
           return result
       }
    }

    return result
}