package com.r2dbcpostgisbug.repro.repository

import com.r2dbcpostgisbug.repro.repository.model.Asset
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface AssetRepository : CoroutineCrudRepository<Asset, Long> {
    override suspend fun findById(id: Long): Asset?
}