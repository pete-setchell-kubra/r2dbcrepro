package com.r2dbcpostgisbug.repro.repository
import com.r2dbcpostgisbug.repro.repository.model.Asset
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel


@SpringBootTest
class AssetRepositoryTest @Autowired constructor(val assetRepository: AssetRepository) {

    @Test
    fun testInsert() {
        val longitude = 37.7434579544699
        val latitude = -122.44437070120628
        val factory4326 = GeometryFactory(PrecisionModel(PrecisionModel.FLOATING), 4326)
        val p: Geometry = factory4326.createPoint(Coordinate(longitude, latitude)) as Geometry

        runBlocking {
            val a = assetRepository.save(Asset(id=null, geom = p))
            assertNotNull(a.id)
            val aid = a.id!!
            val b = assetRepository.findById(aid)
            assertEquals(a, b)
            assertNotNull(b?.geom)
        }
    }

    @Test
    fun testRead() {
        runBlocking {
            val aid = 1L
            val a = assetRepository.findById(aid)
            assertNotNull(a?.geom)
        }
    }
}