package queue

import linkedList.LinkedList

/*
Operations  -   Best case   -   Worst Case
enqueue     -       O(1)    -       O(1)
dequeue      -      O(1)    -       O(1)
Space Complexity    O(n)    -       O(n)
 */

/*
THe main weakness with LinkedListQueue is not apparent from the table. Despite O(1) performance, it suffers from high overload.
Each element has to have extra storage for the forward and back reference. Moreover, every time you create a new element, it require
a relatively expensive dynamic allocation
 */
class LinkedListQueue<T> : Queue<T> {
    private val list = LinkedList<T>()

    private var size = 0

    override fun enqueue(t: T): Boolean {
        list.append(t)
        size++
        return true
    }

    override fun dequeue(): T? {
        if (list.isEmpty()) {
            return null
        }
        size--
        return list.pop()
    }

    override val count: Int
        get() = size

    override fun peek(): T? {
        val firstItem = list.nodeAt(0)
        return firstItem?.value
    }

    override fun toString(): String {
        return list.toString()
    }
}