package repositories

import com.google.inject.{Inject, Singleton}
import models.{Route, Trip}
import modules.AppDatabase
import errors.{AlreadyExists, AmbigousResult, NotFound}
import org.joda.time.DateTime

import scala.concurrent.{ExecutionContext, Future}

trait RouteRepository {
  def create(route: Route): Future[Route]
  def find(id: Int): Future[Option[Route]]
  def findAll(): Future[List[Route]]
  def update(route: Route): Future[Route]
  def delete(id: Int): Future[Boolean]
  def findCheapest(from: String, to: String, meetingTime: Option[DateTime]): Future[Option[Trip]]
  def findShortest(from: String, to: String, meetingTime: Option[DateTime]): Future[Option[Trip]]
}

@Singleton
class RouteRepositoryImpl @Inject()(val database: AppDatabase,
                                    implicit val executionContext: ExecutionContext) extends RouteRepository {
  val db = database.db
  val profile = database.profile

  import profile.api._

  def routeQuery = TableQuery[Route.Table]

  def create(route: Route) = db.run { Actions.create(route) }
  def find(id: Int) = db.run { Actions.find(id) }
  def findAll() = db.run { Actions.findAll() }
  def update(route: Route) = db.run { Actions.update(route) }
  def delete(id: Int) = db.run { Actions.delete(id) }

  override def findCheapest(from: String, to: String, meetingTime: Option[DateTime]) = ???
  override def findShortest(from: String, to: String, meetingTime: Option[DateTime]) = ???

  /**
    * Provides implementation for CRUD operations with 'Route' entity.
    */
  object Actions {

    def create(route: Route): DBIO[Route] =
      for {
        maybeRoute <- if (route.id.isEmpty) DBIO.successful(None) else find(route.id.get)
        maybeRouteId <- maybeRoute match {
          case Some(value) => DBIO.failed(AlreadyExists(s"Already exists route with id = ${route.id}"))
          case _ => routeQuery returning routeQuery.map(_.id) += route
        }
        maybeRoute <- find(maybeRouteId)
        route <- maybeRoute match {
          case Some(value)=> DBIO.successful(value)
          case _ => DBIO.failed(AmbigousResult(s"Failed to save route [route=$route]"))
        }
      } yield route


    def find(id: Int): DBIO[Option[Route]] = for {
      maybeRoute <- routeQuery.filter(_.id === id).result
      route <- if (maybeRoute.lengthCompare(2) < 0) DBIO.successful(maybeRoute.headOption) else DBIO.failed(AmbigousResult(s"Several routes with the same id = $id"))
    } yield route


    def findAll(): DBIO[List[Route]] = for {
      routes <- routeQuery.result
    } yield routes.toList

    def update(route: Route): DBIO[Route] = for {
      maybeId <- if (route.id.isDefined) DBIO.successful(route.id.get) else DBIO.failed(NotFound(s"Not found 'id' in the [route=$route]"))
      count <- routeQuery.filter(_.id === maybeId).update(route)
      _ <- count match {
        case 0 => DBIO.failed(NotFound(s"Not found route with id=${route.id.get}"))
        case _ => DBIO.successful(())
      }
    } yield route

    def delete(id: Int): DBIO[Boolean] = for {
      maybeDelete <- routeQuery.filter(_.id === id).delete
      isDelete = if (maybeDelete == 1) true else false
    } yield isDelete

//    def findCheapest(from: String, to: String, meetingTime: Option[DateTime]): Future[Option[Trip]] = {
//      ???
//    }
//    def findShortest(from: String, to: String, meetingTime: Option[DateTime]): Future[Option[Trip]] = {
//      ???
//    }
  }

}