package iv_builders

import util.TODO
import java.util.*

fun buildString(build: StringBuilder.() -> Unit): String {
    val stringBuilder = StringBuilder()
    stringBuilder.build()
    return stringBuilder.toString()
}

fun buildStringExample(): String {
    return buildString {
        this.append("Numbers: ")
        for (i in 1..10) {
            // 'this' can be omitted
            append(i)
        }
    }
}

fun todoTask23() = TODO(
    """
        Task 23.
        Uncomment the commented code and make it compile.
        Add and implement function 'buildMap' with one parameter (of type extension function) creating a new HashMap,
        building it and returning it as a result.
        Use MutableMap, look through syntax/javaCollections for details.
    """,
    references = { syntax.javaCollections.useMutableSet(HashSet())}
)

fun <K, V> buildMap(build: HashMap<K, V>.()->Unit): HashMap<K, V> {
    val map = HashMap<K, V>();
    map.build()
    return map;
}

fun task23(): Map<Int, String> {
    return buildMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}