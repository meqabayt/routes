package models

import play.api.libs.json.{Json, OFormat}
import slick.jdbc.H2Profile.api.{Table => SlickTable, _}
import slick.lifted.{Tag => SlickTag}


/**
  * The main entity over which we will carry out the CRUD operations.
  *
  * @param id               id of the entity
  * @param from             departure airport
  * @param to               arrival airport
  * @param departTime       departure time
  * @param arriveTime       arrival time
  * @param airline          airline of the flight
  */

case class Route (
                   id: Option[Int] = None,
                   from: String,
                   to: String,
                   departTime: Int,
                   arriveTime: Int,
                   airline: String
                 )

object Route extends ((Option[Int], String, String, Int, Int, String) => Route) {

  /**
    * Defined slick table for entity 'Route'
    */

  class Table(slickTag: SlickTag) extends SlickTable[Route](slickTag, "routes") {
    def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
    def from = column[String]("from")
    def to = column[String]("to")
    def departTime = column[Int]("depart_time")
    def arriveTime = column[Int]("arrive_time")
    def airline = column[String]("airline")

    def * = (id.?, from, to, departTime, arriveTime, airline).mapTo[Route]
  }

  implicit val jsonFormat: OFormat[Route] = Json.format[Route]

}

