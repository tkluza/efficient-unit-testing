package com.tkluza.spring.efficientunittests.business.place.domain

import com.tkluza.spring.efficientunittests.business.place.domain.model.PlaceEntity
import com.tkluza.spring.efficientunittests.business.place.test.PlaceTestFactory
import com.tkluza.spring.efficientunittests.common.BaseTest
import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import javax.persistence.EntityNotFoundException

class PlaceFacadeTest : BaseTest() {

    @Autowired
    private lateinit var placeFacade: PlaceFacade

    @Nested
    inner class PlaceTests {

        @Test
        fun `should find place by id`() {
            // given
            val placeName = "Allianz Arena"

            // when
            val placeQuery = placeFacade.findPlaceByName(placeName)

            // then
            assertSoftly(placeQuery) {
                name shouldBe placeName
                address shouldBe "Werner-Heisenberg-Allee 25, 80939 München"
            }
        }

        @Test
        fun `should find place by id - other possibility`() {
            // given
            val place = testDataContext["P-1", PlaceEntity::class.java]!!

            // when
            val placeQuery = placeFacade.findPlaceByName(name = place.name)

            // then
            assertSoftly(placeQuery) {
                id shouldBe place.id
                name shouldBe place.name
                address shouldBe place.address
            }
        }

        @Test
        fun `should find another place by id`() {
            // given
            PlaceTestFactory.savePlaces(
                placeRows = arrayOf(
                    "| KEY | Name                  | Address                                  |",
                    "| P-3 | Madison Square Garden | 4 Pennsylvania Plaza, New York, NY 10001 |",
                ),
                testDataContext = testDataContext
            )
            val place = testDataContext["P-3", PlaceEntity::class.java]!!

            // when
            val placeQuery = placeFacade.findPlaceByName(name = place.name)

            // then
            assertSoftly(placeQuery) {
                id shouldBe place.id
                name shouldBe place.name
                address shouldBe place.address
            }
        }

        @Test
        fun `should throw exception if place with a given name was not found`() {
            // given
            val placeName = "Helm's Deep"

            // when & then
            shouldThrow<EntityNotFoundException> {
                placeFacade.findPlaceByName(placeName)
            }
        }
    }
}