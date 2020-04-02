package com.tahirmanzoor.trader.dummy

import java.util.*

object DummyContent {

    data class DummyItem(val id: String, val content: String, val details: String) {
        override fun toString(): String = content
    }

    val ITEMS: MutableList<DummyItem> = ArrayList()

    val ITEM_MAP: MutableMap<String, DummyItem> = HashMap()

    private val COUNT = 25

    init {
        for (i in 1..COUNT) {
            val dummyItem = DummyItem(i.toString(), "Item " + i, makeDetails(i))
            ITEMS.add(dummyItem)
            ITEM_MAP.put(dummyItem.id, dummyItem)
        }
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()

        builder.append("Details about Item: ").append(position)

        for (i in 0..position - 1) {
            builder.append("\nDetail Line: ").append(i)
        }
        return builder.toString()
    }

}
