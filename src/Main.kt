fun main() {
//    val startTime = System.currentTimeMillis()
//    println(sumForOne(1000000000))
//    val endTime = System.currentTimeMillis()
//    println("TIME_SPEND_ONE: ${endTime - startTime}")
//
//    val startTime1 = System.currentTimeMillis()
//    println(sumForOne1(1000000000))
//    val endTime1 = System.currentTimeMillis()
//    println("TIME_SPEND_ONE1: ${endTime1 - startTime1}")

//    val originalList = listOf(432, 432, 3432, 43221, 23432432, 5231, 1324, 14324, 432, 234, 4, 2332, 23, 432, 32)
//    printSorted(originalList)

//    val result = twoSum(intArrayOf(2, 7, 11, 15), target = 9)
//    result
}

fun sumForOne(n: Long): Long {
    var sum = 0L
    for (i in 1..n) {
        sum += i
    }
    return sum
}

fun sumForOne1(n: Long): Long {
    return n * (n + 1) / 2
}

fun printSorted(numbers: List<Int>) {
    val sortedList = numbers.sorted()
    for (number in sortedList) {
        println(number)
    }
}

fun printSorted1(numbers: List<Int>) {
    if (numbers.isEmpty()) {
        return
    }
}