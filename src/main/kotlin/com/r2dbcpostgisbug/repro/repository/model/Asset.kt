package com.r2dbcpostgisbug.repro.repository.model

import org.locationtech.jts.geom.Geometry
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("asset")
data class Asset constructor(
    @Id val id: Long?,
    @Column val geom: Geometry
)