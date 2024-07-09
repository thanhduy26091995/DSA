package stack

import java.util.Stack

class Stack<T> : Stack<T?>() {
    private val storage = arrayListOf<T>()

    override fun toString(): String {
        return buildString {
            appendLine("----top----")
            storage.asReversed().forEach {
                appendLine("  $it")
            }
            appendLine("------------")
        }
    }

    override fun push(item: T?): T? {
        item?.let {
            storage.add(item)
        }
        return item
    }

    override fun pop(): T? {
        if (storage.isEmpty()) {
            return null
        }

        return storage.removeLast()
    }

    override fun peek(): T? {
        return storage.lastOrNull()
    }

    override fun isEmpty(): Boolean {
        return storage.isEmpty()
    }
}