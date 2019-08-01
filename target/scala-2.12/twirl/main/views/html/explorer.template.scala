
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object explorer extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<!--
 * LICENSE AGREEMENT For GraphiQL software
 *
 * Facebook, Inc. (“Facebook”) owns all right, title and interest, including all
 * intellectual property and other proprietary rights, in and to the GraphiQL
 * software. Subject to your compliance with these terms, you are hereby granted a
 * non-exclusive, worldwide, royalty-free copyright license to (1) use and copy the
 * GraphiQL software; and (2) reproduce and distribute the GraphiQL software as
 * part of your own software (“Your Software”). Facebook reserves all rights not
 * expressly granted to you in this license agreement.
 *
 * THE SOFTWARE AND DOCUMENTATION, IF ANY, ARE PROVIDED "AS IS" AND ANY EXPRESS OR
 * IMPLIED WARRANTIES (INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE) ARE DISCLAIMED. IN NO
 * EVENT SHALL FACEBOOK OR ITS AFFILIATES, OFFICES, DIRECTORS OR EMPLOYEES BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF
 * THE USE OF THE SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * You will include in Your Software (e.g., in the file(s), documentation or other
 * materials accompanying your software): (1) the disclaimer set forth above; (2)
 * this sentence; and (3) the following copyright notice:
 *
 * Copyright (c) 2015, Facebook, Inc. All rights reserved.
-->
<!DOCTYPE html>
<html>
    <head>
        <style>
      html, body """),format.raw/*35.18*/("""{"""),format.raw/*35.19*/("""
          """),format.raw/*36.11*/("""height: 100%;
          margin: 0;
          width: 100%;
          overflow: hidden;
      """),format.raw/*40.7*/("""}"""),format.raw/*40.8*/("""

      """),format.raw/*42.7*/("""#graphiql """),format.raw/*42.17*/("""{"""),format.raw/*42.18*/("""
          """),format.raw/*43.11*/("""height: 100vh;
      """),format.raw/*44.7*/("""}"""),format.raw/*44.8*/("""
    """),format.raw/*45.5*/("""</style>

        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*47.59*/routes/*47.65*/.Assets.versioned("images/graphql.ico")),format.raw/*47.104*/("""">

        <title>GraphiQL</title>

        <link rel="stylesheet" href="//cdn.jsdelivr.net/graphiql/0.7.8/graphiql.css" />
        <script src="//cdn.jsdelivr.net/fetch/0.9.0/fetch.min.js"></script>
        <script src="//cdn.jsdelivr.net/react/0.14.7/react.min.js"></script>
        <script src="//cdn.jsdelivr.net/react/0.14.7/react-dom.min.js"></script>
        <script src="//cdn.jsdelivr.net/graphiql/0.7.8/graphiql.min.js"></script>
    </head>
    <body>
        <div id="graphiql">Loading...</div>

        <script>

      /**
       * This GraphiQL example illustrates how to use some of GraphiQL's props
       * in order to enable reading and updating the URL parameters, making
       * link sharing of queries a little bit easier.
       *
       * This is only one example of this kind of feature, GraphiQL exposes
       * various React params to enable interesting integrations.
       */

              // Parse the search string to get url parameters.
      var search = window.location.search;
      var parameters = """),format.raw/*73.24*/("""{"""),format.raw/*73.25*/("""}"""),format.raw/*73.26*/(""";
      search.substr(1).split('&').forEach(function (entry) """),format.raw/*74.60*/("""{"""),format.raw/*74.61*/("""
          """),format.raw/*75.11*/("""var eq = entry.indexOf('=');
          if (eq >= 0) """),format.raw/*76.24*/("""{"""),format.raw/*76.25*/("""
              """),format.raw/*77.15*/("""parameters[decodeURIComponent(entry.slice(0, eq))] =
                      decodeURIComponent(entry.slice(eq + 1));
          """),format.raw/*79.11*/("""}"""),format.raw/*79.12*/("""
      """),format.raw/*80.7*/("""}"""),format.raw/*80.8*/(""");

      // if variables was provided, try to format it.
      if (parameters.variables) """),format.raw/*83.33*/("""{"""),format.raw/*83.34*/("""
          """),format.raw/*84.11*/("""try """),format.raw/*84.15*/("""{"""),format.raw/*84.16*/("""
              """),format.raw/*85.15*/("""parameters.variables =
                      JSON.stringify(JSON.parse(parameters.variables));
          """),format.raw/*87.11*/("""}"""),format.raw/*87.12*/(""" """),format.raw/*87.13*/("""catch (e) """),format.raw/*87.23*/("""{"""),format.raw/*87.24*/("""
              """),format.raw/*88.15*/("""// Do nothing, we want to display the invalid JSON as a string, rather
              // than present an error.
          """),format.raw/*90.11*/("""}"""),format.raw/*90.12*/("""
      """),format.raw/*91.7*/("""}"""),format.raw/*91.8*/("""
      """),format.raw/*92.7*/("""else """),format.raw/*92.12*/("""{"""),format.raw/*92.13*/("""
          """),format.raw/*93.11*/("""parameters.variables = null
      """),format.raw/*94.7*/("""}"""),format.raw/*94.8*/("""

      """),format.raw/*96.7*/("""// When the query and variables string is edited, update the URL bar so
      // that it can be easily shared
      function onEditQuery(newQuery) """),format.raw/*98.38*/("""{"""),format.raw/*98.39*/("""
          """),format.raw/*99.11*/("""parameters.query = newQuery;
          updateURL();
      """),format.raw/*101.7*/("""}"""),format.raw/*101.8*/("""

      """),format.raw/*103.7*/("""function onEditVariables(newVariables) """),format.raw/*103.46*/("""{"""),format.raw/*103.47*/("""
          """),format.raw/*104.11*/("""parameters.variables = newVariables;
          updateURL();
      """),format.raw/*106.7*/("""}"""),format.raw/*106.8*/("""

      """),format.raw/*108.7*/("""function updateURL() """),format.raw/*108.28*/("""{"""),format.raw/*108.29*/("""
          """),format.raw/*109.11*/("""var newSearch = '?' + Object.keys(parameters).map(function (key) """),format.raw/*109.76*/("""{"""),format.raw/*109.77*/("""
              """),format.raw/*110.15*/("""return encodeURIComponent(key) + '=' +
                      encodeURIComponent(parameters[key]);
          """),format.raw/*112.11*/("""}"""),format.raw/*112.12*/(""").join('&');
          history.replaceState(null, null, newSearch);
      """),format.raw/*114.7*/("""}"""),format.raw/*114.8*/("""

      """),format.raw/*116.7*/("""// Defines a GraphQL fetcher using the fetch API.
      function graphQLFetcher(graphQLParams) """),format.raw/*117.46*/("""{"""),format.raw/*117.47*/("""
          """),format.raw/*118.11*/("""return fetch(window.location.origin + '/graphql', """),format.raw/*118.61*/("""{"""),format.raw/*118.62*/("""
              """),format.raw/*119.15*/("""method: 'post',
              headers: """),format.raw/*120.24*/("""{"""),format.raw/*120.25*/("""
                  """),format.raw/*121.19*/("""'Accept': 'application/json',
                  'Content-Type': 'application/json',
              """),format.raw/*123.15*/("""}"""),format.raw/*123.16*/(""",
              body: JSON.stringify(graphQLParams),
              credentials: 'include',
          """),format.raw/*126.11*/("""}"""),format.raw/*126.12*/(""").then(function (response) """),format.raw/*126.39*/("""{"""),format.raw/*126.40*/("""
              """),format.raw/*127.15*/("""return response.text();
          """),format.raw/*128.11*/("""}"""),format.raw/*128.12*/(""").then(function (responseBody) """),format.raw/*128.43*/("""{"""),format.raw/*128.44*/("""
              """),format.raw/*129.15*/("""try """),format.raw/*129.19*/("""{"""),format.raw/*129.20*/("""
                  """),format.raw/*130.19*/("""return JSON.parse(responseBody);
              """),format.raw/*131.15*/("""}"""),format.raw/*131.16*/(""" """),format.raw/*131.17*/("""catch (error) """),format.raw/*131.31*/("""{"""),format.raw/*131.32*/("""
                  """),format.raw/*132.19*/("""return responseBody;
              """),format.raw/*133.15*/("""}"""),format.raw/*133.16*/("""
          """),format.raw/*134.11*/("""}"""),format.raw/*134.12*/(""");
      """),format.raw/*135.7*/("""}"""),format.raw/*135.8*/("""

      """),format.raw/*137.7*/("""// Render <GraphiQL /> into the body.
      ReactDOM.render(
              React.createElement(GraphiQL, """),format.raw/*139.45*/("""{"""),format.raw/*139.46*/("""
                  """),format.raw/*140.19*/("""fetcher: graphQLFetcher,
                  query: parameters.query,
                  variables: parameters.variables,
                  onEditQuery: onEditQuery,
                  onEditVariables: onEditVariables
              """),format.raw/*145.15*/("""}"""),format.raw/*145.16*/("""),
              document.getElementById('graphiql')
      );
    </script>
    </body>
</html>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2019-08-01T11:02:44.669
                  SOURCE: /Users/elnurmemmedov/code/3rd/travelseekr/routes/app/views/explorer.scala.html
                  HASH: d06e3b3f9ef4f626b3a6a6e5a7a522a520cdf11b
                  MATRIX: 725->1|821->4|848->5|2625->1754|2654->1755|2693->1766|2812->1858|2840->1859|2875->1867|2913->1877|2942->1878|2981->1889|3029->1910|3057->1911|3089->1916|3184->1984|3199->1990|3260->2029|4326->3067|4355->3068|4384->3069|4473->3130|4502->3131|4541->3142|4621->3194|4650->3195|4693->3210|4847->3336|4876->3337|4910->3344|4938->3345|5056->3435|5085->3436|5124->3447|5156->3451|5185->3452|5228->3467|5361->3572|5390->3573|5419->3574|5457->3584|5486->3585|5529->3600|5678->3721|5707->3722|5741->3729|5769->3730|5803->3737|5836->3742|5865->3743|5904->3754|5965->3788|5993->3789|6028->3797|6203->3944|6232->3945|6271->3956|6357->4014|6386->4015|6422->4023|6490->4062|6520->4063|6560->4074|6654->4140|6683->4141|6719->4149|6769->4170|6799->4171|6839->4182|6933->4247|6963->4248|7007->4263|7144->4371|7174->4372|7276->4446|7305->4447|7341->4455|7465->4550|7495->4551|7535->4562|7614->4612|7644->4613|7688->4628|7756->4667|7786->4668|7834->4687|7961->4785|7991->4786|8121->4887|8151->4888|8207->4915|8237->4916|8281->4931|8344->4965|8374->4966|8434->4997|8464->4998|8508->5013|8541->5017|8571->5018|8619->5037|8695->5084|8725->5085|8755->5086|8798->5100|8828->5101|8876->5120|8940->5155|8970->5156|9010->5167|9040->5168|9077->5177|9106->5178|9142->5186|9276->5291|9306->5292|9354->5311|9611->5539|9641->5540
                  LINES: 21->1|26->2|27->3|59->35|59->35|60->36|64->40|64->40|66->42|66->42|66->42|67->43|68->44|68->44|69->45|71->47|71->47|71->47|97->73|97->73|97->73|98->74|98->74|99->75|100->76|100->76|101->77|103->79|103->79|104->80|104->80|107->83|107->83|108->84|108->84|108->84|109->85|111->87|111->87|111->87|111->87|111->87|112->88|114->90|114->90|115->91|115->91|116->92|116->92|116->92|117->93|118->94|118->94|120->96|122->98|122->98|123->99|125->101|125->101|127->103|127->103|127->103|128->104|130->106|130->106|132->108|132->108|132->108|133->109|133->109|133->109|134->110|136->112|136->112|138->114|138->114|140->116|141->117|141->117|142->118|142->118|142->118|143->119|144->120|144->120|145->121|147->123|147->123|150->126|150->126|150->126|150->126|151->127|152->128|152->128|152->128|152->128|153->129|153->129|153->129|154->130|155->131|155->131|155->131|155->131|155->131|156->132|157->133|157->133|158->134|158->134|159->135|159->135|161->137|163->139|163->139|164->140|169->145|169->145
                  -- GENERATED --
              */
          