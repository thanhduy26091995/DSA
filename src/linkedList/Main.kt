package linkedList

fun main() {
    val list = LinkedList<Int>()
    list.push(4)
    list.push(3)
    list.push(2)
    list.push(1)

    println(list)
    list.printReverse()
    println()
    println("Middle is ${list.getMiddle()?.value}")
    println(list.reverse())

    val listOriginal = LinkedList<Int>()
    listOriginal.append(1)
    listOriginal.append(2)
    listOriginal.append(3)
    listOriginal.append(4)
    listOriginal.append(5)

    val other = LinkedList<Int>()
    other.append(-1)
    other.append(0)
    other.append(2)
    other.append(2)
    other.append(7)

    println("Left: $listOriginal")
    println("Right: $other")
    println("Merged: ${listOriginal.mergeSorted(other)}")
}