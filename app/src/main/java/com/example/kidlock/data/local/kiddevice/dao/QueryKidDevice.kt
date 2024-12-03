package com.example.kidlock.data.local.kiddevice.dao

import com.example.kidlock.data.local.generic.EntityAbstract
import com.example.kidlock.data.local.generic.QueryGeneric
import com.example.kidlock.utils.sqlquery.QueyBuilder

class QueryKidDevice(
    entityAbstract: EntityAbstract,
    queryBuilderImpl: QueyBuilder
) : QueryGeneric(entityAbstract, queryBuilderImpl) {
}