import kotlin.random.Random
import kotlin.random.nextUInt

fun main() {
    fun arrayOfArrays(n: UInt): Array<Array<Int>> {
        var resultArray: Array<Array<Int>> = arrayOf()
        val list: MutableList<Array<Int>> = resultArray.toMutableList()
        val setOfSizes = mutableSetOf<UInt>()
        var size: UInt
        while (setOfSizes.size < n.toInt()) {
            size = Random.nextUInt(n * 2u)
            setOfSizes.add(size)
        }
        setOfSizes.forEach {
            val randomArray = Array(it.toInt()) {Random.nextInt(100)}
            list.add(randomArray)
        }
        list.forEachIndexed {index, ints ->
            if (index % 2 == 0) ints.sort()
            else
                ints.sortDescending()
        }
        resultArray = list.toTypedArray()
        return resultArray
    }
    println(arrayOfArrays(5u).contentDeepToString())
}