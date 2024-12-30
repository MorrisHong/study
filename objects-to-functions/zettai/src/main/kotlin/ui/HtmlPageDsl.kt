package ui

import org.http4k.core.*
import org.http4k.routing.bind
import org.http4k.routing.path
import org.http4k.routing.routes
import org.http4k.server.Jetty
import org.http4k.server.asServer

val htmlPage = """
    <html>
        <body>
            <h1 style="text-align:center; font-size:3em;" >Hello Functional World!</h1>
        </body>
    </html>
""".trimIndent()

val app: HttpHandler = routes(
    "/greetings" bind Method.GET to ::greetings,
    "/data" bind Method.POST to ::receiveData,
    "/todo/{user}/{list}" bind Method.GET to ::showList,
)

fun greetings(req: Request): Response = Response(Status.OK).body(htmlPage)

fun receiveData(req: Request): Response = Response(Status.CREATED).body("Received ${req.bodyString()}")

fun showList(req: Request): Response {
    val user: String? = req.path("user")
    val list: String? = req.path("list")
    val htmlPage = """
        <html>
            <body>
                <h1 style="text-align:center; font-size:3em;" >Hello Functional World!</h1>
                <h2>User: $user</h2>
                <h2>List: $list</h2>
            </body>
        </html>
    """.trimIndent()

    return Response(Status.OK).body(htmlPage)
}

fun main() {
    app.asServer(Jetty(8080)).start()
}