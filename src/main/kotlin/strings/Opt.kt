package strings

/**
 * s.orEmpty() returns the original string if it's not null, or the empty string otherwise.
 *
 * val t = s.orElseEmpty()
 */
fun String?.orElseEmpty(): String = this ?: ""
