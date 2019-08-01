package graphql.schema

import com.google.inject.Inject
import graphql.resolvers.RouteResolver
import models.Route
import sangria.macros.derive.{ObjectTypeName, deriveObjectType}
import sangria.schema._


class RouteSchema @Inject()(routeResolver: RouteResolver) {

  implicit val RouteType: ObjectType[Unit, Route] = deriveObjectType[Unit, Route](ObjectTypeName("Route"))

  val Queries: List[Field[Unit, Unit]] = List(
    Field(
      name = "routes",
      fieldType = ListType(RouteType),
      resolve = _ => routeResolver.routes
    ),
    Field(
      name = "findRoute",
      fieldType = OptionType(RouteType),
      arguments = List (
        Argument("id", IntType)
      ),
      resolve =
        sangriaContext =>
          routeResolver.findRoute(sangriaContext.args.arg[Int]("id"))
    )
  )

  val Mutations: List[Field[Unit, Unit]] = List(
    Field(
      name = "addRoute",
      fieldType = RouteType,
      arguments = List(
        Argument("from", StringType),
        Argument("to", StringType),
        Argument("departTime", IntType),
        Argument("arriveTime", IntType),
        Argument("airline", StringType),
      ),
      resolve = sangriaContext =>
        routeResolver.addRoute(
          sangriaContext.args.arg[String]("from"),
          sangriaContext.args.arg[String]("to"),
          sangriaContext.args.arg[Int]("departTime"),
          sangriaContext.args.arg[Int]("arriveTime"),
          sangriaContext.args.arg[String]("airline")
        )
    ),
    Field(
      name = "updateRoute",
      fieldType = RouteType,
      arguments = List(
        Argument("id", IntType),
        Argument("from", StringType),
        Argument("to", StringType),
        Argument("departTime", IntType),
        Argument("arriveTime", IntType),
        Argument("airline", StringType),
      ),
      resolve = sangriaContext =>
        routeResolver.update(
          sangriaContext.args.arg[Int]("id"),
          sangriaContext.args.arg[String]("from"),
          sangriaContext.args.arg[String]("to"),
          sangriaContext.args.arg[Int]("departTime"),
          sangriaContext.args.arg[Int]("arriveTime"),
          sangriaContext.args.arg[String]("airline")
        )
    ),
    Field(
      name = "deleteRoute",
      fieldType = BooleanType,
      arguments = List(
        Argument("id", IntType)
      ),
      resolve = sangriaContext =>
        routeResolver.delete(
          sangriaContext.args.arg[Int]("id")
        )
    )
  )

}
