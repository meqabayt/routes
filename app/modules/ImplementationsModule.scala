package modules

import com.google.inject._
import repositories.{RouteRepositoryImpl, RouteRepository}

class ImplementationsModule extends AbstractModule {
  override def configure(): Unit = {
    bind(classOf[RouteRepository]).to(classOf[RouteRepositoryImpl]).in(Scopes.SINGLETON)
  }
}