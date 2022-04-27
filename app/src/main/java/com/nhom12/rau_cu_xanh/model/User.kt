package com.nhom12.rau_cu_xanh.model

class User {
    private val id = 0
    private val author: String? = null
    private val name: String? = null
    private val publisher: String? = null
    private val type: String? = null
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (id != other.id) return false
        if (author != other.author) return false
        if (name != other.name) return false
        if (publisher != other.publisher) return false
        if (type != other.type) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + (author?.hashCode() ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (publisher?.hashCode() ?: 0)
        result = 31 * result + (type?.hashCode() ?: 0)
        return result
    }

}