package models

import org.joda.time.DateTime
import play.api.libs.json._
import slick.jdbc.H2Profile.api.{Table => SlickTable, _}
import slick.lifted.{Tag => SlickTag}

case class DBTrip (
                id: Int,
                originAirport: String,
                destinationAirport: String,
                meetingStart: DateTime,
                meetingEnd: DateTime,
                shortest: JsValue,
                cheapest: JsValue
                )

object DBTrip extends ((Int, String, String, DateTime, DateTime, JsValue, JsValue) => DBTrip) {
  import modules.MyPostgresProfile.api._
  import com.github.tototoshi.slick.PostgresJodaSupport._

  class Table(slickTag: SlickTag) extends SlickTable[DBTrip](slickTag, "proposals") {
    def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
    def originAirport = column[String]("origin_airport")
    def destinationAirport = column[String]("destination_airport")
    def meetingStart = column[DateTime]("meeting_start")
    def meetingEnd = column[DateTime]("meeting_end")
    def shortest = column[JsValue]("shortest")
    def cheapest = column[JsValue]("cheapest")

    def * = (id, originAirport, destinationAirport, meetingStart, meetingEnd, shortest, cheapest).mapTo[DBTrip]
  }

  implicit val yourJodaDateReads = Reads.jodaDateReads("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
  implicit val yourJodaDateWrites = Writes.jodaDateWrites("yyyy-MM-dd'T'HH:mm:ss.SSSZ'")

  implicit val jsonFormat: OFormat[DBTrip] = Json.format[DBTrip]

}

case class Trip (
                  id: Int,
                  originAirport: String,
                  destinationAirport: String,
                  meetingStart: DateTime,
                  meetingEnd: DateTime,
                  shortest: List[Route],
                  cheapest: List[Route]
                )

object Trip {


  implicit val yourJodaDateReads = Reads.jodaDateReads("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
  implicit val yourJodaDateWrites = Writes.jodaDateWrites("yyyy-MM-dd'T'HH:mm:ss.SSSZ'")

  implicit val jsonFormat: OFormat[Trip] = Json.format[Trip]
}