package com.example.kidlock.utils.sqlquery

class QueryBuilderImpl  constructor(): QueyBuilder{

//    companion object{
//        private var instance: QueryBuilderImpl? = null
//
//        fun getInstance() = instance ?: synchronized(this){
//            instance ?: QueryBuilderImpl().also { instance = it }
//        }
//    }

    private val queryString = mutableMapOf<String, String>()

    override fun setSelect( nameColum: List<String> ) {
        nameColum?.let {
            queryString.put(CommandQuery.SELECT, toString(nameColum))
        }
    }

    override fun setFrom(nameTable: List<String>) {
        queryString.put(CommandQuery.FROM, toString(nameTable))
    }

    override fun setWhere(condition: String?) {
        condition?.let {
            queryString.put(CommandQuery.WHERE, it)
        }
    }

    override fun setJoin(joinCommand: Join?) {
        joinCommand?.let {
            queryString.set(joinCommand.joinType.name, joinCommand.command())
        }
    }

    override fun setGroupBy(groupBy: List<String>?, aggregateFunctions: List<AggregateFunction>?, having: String?) {
        groupBy?.let {
            queryString.put(CommandQuery.GROUP_BY, toString(groupBy))
        }
        aggregateFunctions?.let {
            for (aggregateFunction: AggregateFunction in it){
                queryString[CommandQuery.SELECT] + aggregateFunction
            }
        }
        having?.let {
            setHaving(having)
        }
    }

    override fun setHaving(condition: String?) {
        condition?.let {
            queryString.put(CommandQuery.HAVING, condition)
        }
    }

    override fun setOrderBy(orderBy: List<String>?) {
        orderBy?.let { queryString.put(CommandQuery.ORDER_BY, toString(orderBy)) }
    }

    override fun setLimit(limit: String?) {
        limit?.let {
            queryString.put(CommandQuery.LIMIT, limit)
        }
    }

    override fun getResult(): String {
        var result = ""
        for (entry in queryString){
            result += " " + entry.key + " " + entry.value + " "
        }
        return result
    }

    override fun reset() {
        queryString.clear()
    }

    fun toString(list: List<String>):String{
        return  list.joinToString()
    }
}