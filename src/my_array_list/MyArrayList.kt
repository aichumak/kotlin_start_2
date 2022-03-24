package my_array_list

class MyArrayList<T> : MyList<T> {

    var array = arrayOfNulls<Any>(10)
    var size = 0

    companion object {
        fun<E> myListOf(vararg elements: E): MyArrayList<E> {
            val myArrayList = MyArrayList<E>()
            for (element in elements) {
                myArrayList.add(element)
            }
            return myArrayList
        }
    }

    override fun get(index: Int): T {
        if (index in array.indices) {
            array[index]?.let {
                return it as T
            }
        }
        throw IndexOutOfBoundsException()
    }

    override fun add(value: T) {
        if (size >= array.size) {
            array = array.copyOf(array.size * 2)
        }
        array[size] = value
        size++
    }

    override fun remove(value: T) {
        if (array.contains(value)) {
            for ((index, i) in array.withIndex()) {
                if (i == value) {
                    removeAt(index)
                    return
                }
            }
        } else {
            throw Exception("The value is not found")
        }
    }

    override fun removeAt(index: Int) {
        if (index in array.indices) {
            for (i in index until array.size - 1) {
                array[index] = array[index + 1]
            }
        } else {
            throw IndexOutOfBoundsException()
        }
        size--
    }

    override fun size(): Int = size
}