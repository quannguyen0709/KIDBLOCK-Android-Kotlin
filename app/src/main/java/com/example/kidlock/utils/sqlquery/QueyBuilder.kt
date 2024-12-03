package com.example.kidlock.utils.sqlquery

interface QueyBuilder {
    fun setSelect(nameColum: List<String> = listOf("*"))
    fun setFrom(nameTable: List<String>)
    fun setWhere(condition: String? = null)
    fun setJoin(joinCommand: Join? = null)
    fun setGroupBy(groupBy: List<String>? = null, aggregateFunctions: List<AggregateFunction>? = null, having:String? = null)
    fun setHaving(condition: String?= null)
    fun setOrderBy(orderBy: List<String>?= null)
    fun setLimit(limit: String?= null)
    fun getResult(): String
    fun reset()
}