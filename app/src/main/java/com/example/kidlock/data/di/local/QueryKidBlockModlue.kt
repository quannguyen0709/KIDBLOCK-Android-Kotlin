package com.example.kidlock.data.di.local

import com.example.kidlock.data.local.generic.QueryGeneric
import com.example.kidlock.data.local.historyaction.dao.QueryHistoryActionOfKid
import com.example.kidlock.data.local.historyaction.entity.HistoryActionOfKidEntity
import com.example.kidlock.data.local.kiddevice.dao.QueryKidDevice
import com.example.kidlock.data.local.kiddevice.entity.KidDeviceEntity
import com.example.kidlock.data.local.kidinfor.dao.QueryKidInfor
import com.example.kidlock.data.local.kidinfor.entity.KidInforEntity
import com.example.kidlock.data.local.parent.dao.QueryParent
import com.example.kidlock.data.local.parent.entity.ParentUserEntity
import com.example.kidlock.data.local.restrictionblock.dao.QueryRestrictionBlock
import com.example.kidlock.data.local.restrictionblock.entity.RestrictionBlockEntity
import com.example.kidlock.utils.sqlquery.QueryBuilderImpl
import com.example.kidlock.utils.sqlquery.QueyBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

//@Qualifier
//@Retention(AnnotationRetention.BINARY)
//annotation class QueryParentUserEntity
//
//@Qualifier
//@Retention(AnnotationRetention.BINARY)
//annotation class QueryKidInforEntity
//
//@Qualifier
//@Retention(AnnotationRetention.BINARY)
//annotation class QueryKidDeviceEntity
//
//@Qualifier
//@Retention(AnnotationRetention.BINARY)
//annotation class QueryHistoryActionOfKidEntity

@Module
@InstallIn(SingletonComponent::class)
class QueryKidBlockModlue {

    @Provides
    fun bindsQueryBuilder(): QueryBuilderImpl{
        return QueryBuilderImpl()
    }

    @Singleton
    @Provides
    fun bindsQueryParentUserEntity(queryBuilderImpl: QueryBuilderImpl): QueryParent{
        return QueryParent(ParentUserEntity(), queryBuilderImpl)
    }

    @Singleton
    @Provides
    fun bindsQueryKidInforEntity(queryBuilderImpl: QueryBuilderImpl): QueryKidInfor{
        return QueryKidInfor(KidInforEntity(), queryBuilderImpl)
    }

    @Singleton
    @Provides
    fun bindsQueryKidDeviceEntity(queryBuilderImpl: QueryBuilderImpl): QueryKidDevice{
        return QueryKidDevice(KidDeviceEntity(), queryBuilderImpl)
    }

    @Singleton
    @Provides
    fun bindsQueryHistoryActionOfKidEntity(queryBuilderImpl: QueryBuilderImpl): QueryHistoryActionOfKid{
        return QueryHistoryActionOfKid(HistoryActionOfKidEntity(), queryBuilderImpl)
    }

    @Singleton
    @Provides
    fun binsQueryRestrictionBlockEntity(queryBuilderImpl: QueryBuilderImpl): QueryRestrictionBlock{
        return QueryRestrictionBlock(RestrictionBlockEntity(), queryBuilderImpl)
    }


}