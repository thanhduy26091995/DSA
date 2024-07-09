package queue

fun main() {
    val queue = ArrayListQueue<Int>()
    queue.apply {
        enqueue(1)
        enqueue(2)
        enqueue(3)
    }
    println(queue)
    queue.dequeue()
    println(queue)

    val queue2 = LinkedListQueue<Int>()
    queue2.apply {
        enqueue(4)
        enqueue(5)
        enqueue(6)
    }
    println(queue2.toString())
    queue2.dequeue()
    queue2.dequeue()
    println(queue2.toString())

    println("------- RingBufferQueue-----")
    val queue3 = RingBufferQueue<Int>(4)
    queue3.apply {
        enqueue(7)
        enqueue(8)
    }
    println(queue3.toString())
    queue3.dequeue()
    println(queue3.toString())
}