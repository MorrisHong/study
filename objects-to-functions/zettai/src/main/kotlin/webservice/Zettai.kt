package webservice

import org.http4k.core.*
import org.http4k.routing.bind
import org.http4k.routing.path
import org.http4k.routing.routes

class Zettai: HttpHandler {
    val routes = routes(
        "/todo/{user}/{list}" bind  Method.GET to ::showList
    )

    override fun invoke(request: Request): Response = routes(request)

    private fun showList(request: Request): Response {
        val user = request.path("user").orEmpty()
        val list = request.path("list").orEmpty()
        val htmlPage = """
            <html>
                <body>
                    <h1>Zettai</h1>
                    <p>Here is the list <b>$list</b> of user <b>$user</b></p>
                </body>
            </html>
        """.trimIndent()

        return Response(Status.OK).body(htmlPage)
    }
}