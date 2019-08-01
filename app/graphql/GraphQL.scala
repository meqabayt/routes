package graphql

import com.google.inject.Inject
import graphql.schema.RouteSchema
import sangria.schema.{ObjectType, fields}

class GraphQL @Inject()(routeSchema: RouteSchema) {

  val Schema = sangria.schema.Schema (
    query = ObjectType("Query",
      fields(
        routeSchema.Queries: _*
      )
    ),
    mutation = Some(
      ObjectType("Mutation",
        fields(
          routeSchema.Mutations: _*
        )
      )
    )
  )

}
