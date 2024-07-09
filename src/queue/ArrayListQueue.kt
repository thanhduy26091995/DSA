package queue


/*
Operations  -   Best case   -   Worst Case
enqueue     -       O(1)    -       O(1)
dequeue      -      O(1)    -       O(n)
Space Complexity    O(n)    -       O(n)
 */

/*
Removing (dequeue) an item from the front of the queue can be inefficient, as removal causes all elements to shift up by once
 */
class ArrayListQueue<T> : Queue<T> {
    private val list = ArrayList<T>()

    override fun enqueue(t: T): Boolean {
        return list.add(t)
    }

    override fun dequeue(): T? {
        if (list.isEmpty()) {
            return null
        }
        return list.removeAt(0)
    }

    override val count: Int
        get() = list.size

    override fun peek(): T? {
        return list.firstOrNull()
    }

    override fun toString(): String {
        return list.toString()
    }
}