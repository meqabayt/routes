package graphql.resolvers

import com.google.inject.Inject
import models.{Route, Trip}
import org.joda.time.DateTime
import repositories.RouteRepository

import scala.concurrent.{ExecutionContext, Future}

class RouteResolver @Inject()(
                             routeRepository: RouteRepository,
                             implicit val executionContext: ExecutionContext
                             ) {

  def routes: Future[List[Route]] = routeRepository.findAll()
  def addRoute(from: String, to: String, departTime: Int, arriveTime: Int, airline: String): Future[Route] = routeRepository.create(Route(from = from, to = to, departTime = departTime, arriveTime = arriveTime, airline = airline ))
  def findRoute(id: Int): Future[Option[Route]] = routeRepository.find(id)
  def update(id: Int, from: String, to: String, departTime: Int, arriveTime: Int, airline: String): Future[Route] = routeRepository.update(Route(id = Some(id), from = from, to = to, departTime = departTime, arriveTime = arriveTime, airline = airline ))
  def delete(id: Int): Future[Boolean] = routeRepository.delete(id)

  def findShortest(from: String, to: String, meetingTime: Option[DateTime]): Future[Option[Trip]] = routeRepository.findShortest(from, to, meetingTime)
  def findCheapest(from: String, to: String, meetingTime: Option[DateTime]): Future[Option[Trip]] = routeRepository.findCheapest(from, to, meetingTime)
}
