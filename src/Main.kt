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

    val result = letterCombinations("23")
    println(result)
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

fun twoSum(nums: IntArray, target: Int): IntArray {
    val numWithHash = hashMapOf<Int, Int>()

    for ((index, num) in nums.withIndex()) {
        val pending = target - num
        if (numWithHash.containsKey(pending)) {
            return intArrayOf(numWithHash[pending]!!, index)
        }
        numWithHash[num] = index
    }
    return intArrayOf()
}

fun intToRoman(num: Int): String {
    val romanMap = listOf(
        1000 to "M",
        900 to "CM",
        500 to "D",
        400 to "CD",
        100 to "C",
        90 to "XC",
        50 to "L",
        40 to "XL",
        10 to "X",
        9 to "IX",
        5 to "V",
        4 to "IV",
        1 to "I"
    )

    var number = num
    val romanNumeral = StringBuilder()

    for ((key, value) in romanMap) {
        while (number >= key) {
            number -= key
            romanNumeral.append(value)
        }
    }
    return romanNumeral.toString()
}

fun romanToInt(s: String): Int {
    val romanMap = mapOf(
        "IV" to 4,
        "I" to 1,
        "V" to 5,
        "X" to 10,
        "L" to 50,
        "C" to 100,
        "D" to 500,
        "M" to 1000,
    )

    var result = 0
    var prevValue = 0

    for (charAt in s) {
        val romanMapAt = romanMap[charAt.toString()] ?: 0
        result += if (romanMapAt > prevValue) {
            romanMapAt - 2 * prevValue
        } else {
            romanMapAt
        }

        prevValue = romanMapAt
    }
    return result
}

fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty()) {
        return listOf()
    }

    val phoneMap = mapOf(
        "2" to "abc",
        "3" to "def",
        "4" to "ghi",
        "5" to "jkl",
        "6" to "mno",
        "7" to "mno",
        "8" to "mno",
        "9" to "mno",
    )

    val result = arrayListOf<String>()
    val combination = StringBuilder()

    fun backtrack(index: Int) {
        if (index == digits.length) {
            result.add(combination.toString())
            return
        }

        val letters = phoneMap[digits[index].toString()] ?: return
        for (letter in letters) {
            combination.append(letter)
            backtrack(index + 1)
            combination.deleteCharAt(combination.length - 1)
        }
    }

    backtrack(0)
    return result
}