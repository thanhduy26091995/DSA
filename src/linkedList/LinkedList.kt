package linkedList

/*
A linked list is a collection of values arranged in a linear
LinkedList is a chain of Nodes. Nodes have two responsibilities
1. Hold a value
2. Hold a references to the next Node. The absence of a reference to the next node, null mark of end of a list
 */
class LinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty list"
        } else {
            head.toString()
        }
    }

    fun push(value: T) {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
    }

    fun append(value: T) {
        if (size == 0) {
            push(value)
            return
        }

        tail?.next = Node(value)
        tail = tail?.next
        size++
    }

    fun nodeAt(index: Int): Node<T>? {
        if (index < 0 || index >= size) {
            return null
        }

        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode
    }

    fun insert(value: T, afterNode: Node<T>): Node<T> {
        if (tail == afterNode) {
            append(value)
            return tail!!
        }

        val newNode = Node(value = value, next = afterNode.next)
        afterNode.next = newNode
        size++
        return newNode
    }

    // Remove value at the front
    fun pop(): T? {
        if (!isEmpty()) {
            size--
        }

        val value = head?.value
        head = head?.next
        if (isEmpty()) {
            tail = null
        }
        return value
    }

    fun removeLast(): T? {
        // Empty list
        val head = head ?: return null

        // Only have 1 item
        if (head.next == null) {
            return pop()
        }

        size--
        // Loop to find last tail
        var prev = head
        var current = head

        var next = current.next
        while (next != null) {
            prev = current
            current = next
            next = current.next
        }

        prev.next = null
        tail = prev
        return current.value
    }

    fun removeAfter(node: Node<T>): T? {
        val result = node.next?.value
        if (node.next == tail) {
            tail = node
        }

        if (node.next != null) {
            size--
        }
        node.next = node.next?.next
        return result
    }
}

fun <T> LinkedList<T>.printReverse() {
    this.nodeAt(0)?.printReverse()
}

fun <T> LinkedList<T>.getMiddle(): Node<T>? {
    var slow = nodeAt(0)
    var fast = nodeAt(0)

    while (fast != null) {
        fast = fast.next
        if (fast != null) {
            slow = slow?.next
            fast = fast.next
        }
    }
    return slow
}

fun <T> LinkedList<T>.reverse(): LinkedList<T> {
    val result = LinkedList<T>()
    val head = this.nodeAt(0)
    if (head != null) {
        addInReverse(result, head)
    }
    return result
}

private fun <T> addInReverse(list: LinkedList<T>, node: Node<T>) {
    val next = node.next
    if (next != null) {
        addInReverse(list, next)
    }
    list.append(node.value)
}

fun <T : Comparable<T>> LinkedList<T>.mergeSorted(otherList: LinkedList<T>): LinkedList<T> {
    if (this.isEmpty()) {
        return otherList
    }

    if (otherList.isEmpty()) {
        return this
    }

    val result = LinkedList<T>()

    var left = this.nodeAt(0)
    var right = otherList.nodeAt(0)

    while (left != null && right != null) {
        if (left.value < right.value) {
            left = append(result, left)
        } else {
            right = append(result, right)
        }
    }

    while (left != null) {
        left = append(result, left)
    }

    while (right != null) {
        right = append(result, right)
    }

    return result
}

private fun <T> append(result: LinkedList<T>, node: Node<T>): Node<T>? {
    result.append(node.value)
    return node.next
}