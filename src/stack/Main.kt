package stack

import linkedList.LinkedList

fun main() {
    val stack = Stack<Int>()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)

    println(stack.toString())
    val pop = stack.pop()
    println("POP: ${pop}")
    println(stack.toString())
    // Print stack reverse

    val linkedList = LinkedList<Int>()
    linkedList.append(1)
    linkedList.append(2)
    linkedList.append(3)
    linkedList.append(4)

    println(linkedList.toString())     
//    linkedList.printReverse()
    linkedList.printReverse()

    val word = "h((e))llo(world)()"

    println(parenthesesValidation(word))
}

private fun parenthesesValidation(word: String): Boolean {
    val stackResult = Stack<String>()
    for (character in word) {
        when (character.toString()) {
            "(" -> {
                stackResult.push(character.toString())
            }

            ")" -> {
                if (stackResult.isEmpty()) {
                    return false
                }
                stackResult.pop()
            }
        }
    }
    return stackResult.isEmpty()
}

fun <T> LinkedList<T>.printReverse() {
    val stack = Stack<T>()

    var head = this.nodeAt(0)
    while (head != null) {
        stack.push(head.value)
        head = head.next
    }

    var node = stack.pop()
    while (node != null) {
        print("$node -> ")
        node = stack.pop()
    }
}