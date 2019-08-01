// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/elnurmemmedov/code/3rd/travelseekr/routes/conf/routes
// @DATE:Thu Aug 01 12:37:35 AZT 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
