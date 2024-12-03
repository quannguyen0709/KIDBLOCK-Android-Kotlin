package com.example.kidlock.data.local.generic

import androidx.room.RoomRawQuery
import com.example.kidlock.utils.sqlquery.AggregateFunction
import com.example.kidlock.utils.sqlquery.QueryBuilderImpl
import com.example.kidlock.utils.sqlquery.QueyBuilder
import javax.inject.Inject

abstract class QueryGeneric( val entityAbstract: EntityAbstract, val queryBuilderImpl: QueyBuilder ) {

    //SELECT colum1, colum2, ... AggregateFunction1, AggregateFunction2,.... FROM tableName WHERE ?? GROUP BY colum1, colum2, ... HAVING ?? ORDER BY ?? LIMIT
    // colum in SELECT and GROUP BY is same. Colum in GROUP BY can't different colums in SELECT
    fun queryFullCommand(select: List<String> = listOf("*"), aggregateFunctions: List<AggregateFunction>? = null, froms: List<String>  , where: String? = null, groupBy: List<String>? = null, having: String? = null, orderBy: List<String>? = null, limit: String? = null): String{
        with(queryBuilderImpl){
            setSelect(select)
            setFrom(froms)
            setWhere(where)
            setGroupBy(groupBy = groupBy, aggregateFunctions = aggregateFunctions, having = having)
            setOrderBy(orderBy)
            setLimit(limit)
        }
        return queryBuilderImpl.getResult()
    }


    //[SELECT primaryColum FROM tableName WHERE primaryCoum = 'value']
    fun queyGetIdEntity(id: String):String{
        val condition = entityAbstract.getNamePrimaryKey() + " = " + "'" + id + "'"
//        with(queryBuilderImpl){
//            reset()
//            setSelect(listOf(entityAbstract.getNamePrimaryKey()))
//            setFrom(listOf(entityAbstract.getNameTable()))
//            setWhere(condition)
//        }
        queryFullCommand(select =  listOf(entityAbstract.getNamePrimaryKey()),
            froms = listOf(entityAbstract.getNameTable()),
            where = condition)
        return queryBuilderImpl.getResult()
    }

    //[SELECT * FROM tableName WHERE primaryColum = 'value']
    fun queryGetEntity(id: String):String{
        val condition = entityAbstract.getNamePrimaryKey() + " = " + "'" + id + "'"
//        with(queryBuilderImpl){
//            reset()
//            setSelect()
//            setFrom(listOf(entityAbstract.getNameTable()))
//            setWhere(condition)
//        }
        queryFullCommand(froms = listOf(entityAbstract.getNameTable()), where = condition)
        return queryBuilderImpl.getResult()
    }

}