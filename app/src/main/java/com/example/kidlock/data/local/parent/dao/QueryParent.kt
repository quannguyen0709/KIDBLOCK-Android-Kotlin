package com.example.kidlock.data.local.parent.dao

import com.example.kidlock.data.local.generic.EntityAbstract
import com.example.kidlock.data.local.generic.QueryGeneric
import com.example.kidlock.utils.sqlquery.QueyBuilder

class QueryParent constructor ( entityAbstract: EntityAbstract,
                               queryBuilderImpl: QueyBuilder) : QueryGeneric(entityAbstract, queryBuilderImpl) {
}