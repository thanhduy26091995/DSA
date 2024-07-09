package queue

/*
Operations  -   Best case   -   Worst Case
enqueue     -       O(1)    -       O(1)
dequeue      -      O(1)    -       O(1)
Space Complexity    O(n)    -       O(n)
 */

class RingBufferQueue<T>(size: Int) : Queue<T> {
    private val ringBuffer: RingBuffer<T> = RingBuffer(size)

    override fun enqueue(t: T): Boolean {
       return ringBuffer.write(t)
    }

    override fun dequeue(): T? {
        return ringBuffer.read()
    }

    override val count: Int
        get() = ringBuffer.count

    override fun peek(): T? {
       return ringBuffer.first
    }

    override fun toString(): String {
        return ringBuffer.toString()
    }
}