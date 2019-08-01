// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/elnurmemmedov/code/3rd/travelseekr/routes/conf/routes
// @DATE:Thu Aug 01 12:37:35 AZT 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def graphiql(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:9
    def graphqlBody(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "graphql")
    }
  
  }

  // @LINE:12
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
