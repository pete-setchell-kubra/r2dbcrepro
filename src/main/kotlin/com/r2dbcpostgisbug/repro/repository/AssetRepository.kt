package com.r2dbcpostgisbug.repro.repository

import com.r2dbcpostgisbug.repro.repository.model.Asset
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.nio.ByteBuffer

interface AssetRepository : CoroutineCrudRepository<Asset, Long> {
    override suspend fun findById(id: Long): Asset?

    @Query("SELECT '\\xDEADBEEF'::bytea")
    suspend fun getDeadBeef(): ByteBuffer
}