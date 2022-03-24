package my_array_list

interface MyList<T> {
    fun get(index: Int): T
    fun add(value: T)
    fun remove(value: T)
    fun removeAt(index: Int)
    fun size(): Int
}