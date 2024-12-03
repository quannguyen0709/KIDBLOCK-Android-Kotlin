package com.example.kidlock.utils.sqlquery

object CommandQuery {
    const val SELECT = "SELECT"
    const val FROM = "FROM"
    const val WHERE = "WHERE"
    const val GROUP_BY = "GROUP BY"
    const val HAVING = "HAVING"
    const val ORDER_BY = "ORDER BY"
    const val LIMIT = "LIMIT"
    const val JOIN = "JOIN"

}

final class Join constructor (val on: String, val tableName: String, val joinType: JoinType) {
    final fun right() = joinType.name + " " + tableName + " ON " + on
    final fun left() = joinType.name + " " + tableName + " ON " + on
    final fun inner() = joinType.name + " " + tableName + " ON " + on
    final fun full() = joinType.name + " " + tableName + " ON " + on

    fun command(): String {
        when(joinType){
            JoinType.RIGHT -> return right()
            JoinType.LEFT -> return left()
            JoinType.INNER -> return inner()
            JoinType.FULL -> return full()
        }
    }
}

sealed class AggregateFunction{
     data class MIN(val nameColum: String):AggregateFunction(){
         override fun toString(): String {
             return "MIN( ${nameColum} )"
         }
     }
    data class MAX(val nameColum: String):AggregateFunction(){
        override fun toString(): String {
            return "MAX( ${nameColum} )"
        }
    }
    data class COUNT(val nameColum: String):AggregateFunction(){
        override fun toString(): String {
            return "COUNT( ${nameColum} )"
        }
    }
    data class SUM(val nameColum: String):AggregateFunction(){
        override fun toString(): String {
            return "SUM( ${nameColum} )"
        }
    }
    data class AVG(val nameColum: String):AggregateFunction(){
        override fun toString(): String {
            return "AVG( ${nameColum} )"
        }
    }
}

enum class JoinType{
    RIGHT,
    LEFT,
    INNER,
    FULL
}

enum class OrderByType{
    DESC,
    ASC
}


enum class OperatorsInTheWhere{
    BETWEEN,
    LIKE,
    IN,
    AND,
    OR,
    NOT,
    EXISTS,
    ALL,
    ANY,
    SOME
}