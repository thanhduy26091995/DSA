package hashTable

fun main() {
    val result = twoSum(intArrayOf(2, 7, 11, 15), 9)
    println(result)

    val str = "abcabcbb"
    println(lengthOfLongestSubstring(str))
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
        "7" to "pqrs",
        "8" to "tuv",
        "9" to "wxyz",
    )

    val result = arrayListOf<String>()
    val combination = CharArray(digits.length)

    fun backtrack(index: Int) {
        if (index == digits.length) {
            result.add(String(combination))
            return
        }

        val letters = phoneMap[digits[index].toString()] ?: return
        for (letter in letters) {
            combination[index] = letter
            backtrack(index + 1)
        }
    }

    backtrack(0)
    return result
}

fun lengthOfLongestSubstring(s: String): Int {
    val charIndexMap = HashMap<Char, Int>()
    var maxLength = 0
    var start = 0

    for ((index, char) in s.withIndex()) {
        if (charIndexMap.containsKey(char) && charIndexMap[char]!! >= start) {
            start = charIndexMap[char]!! + 1
        }

        charIndexMap[char] = index
        maxLength = maxOf(maxLength, index - start + 1)
    }
    return maxLength
}