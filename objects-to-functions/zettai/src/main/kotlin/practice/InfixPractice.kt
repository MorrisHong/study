package practice

import domain.ListName
import domain.ToDoItem
import domain.ToDoList
import domain.User
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.routing.path
import ui.HtmlPage

class Before(
    val lists: Map<User, List<ToDoList>>
) {
    fun showList(request: Request) =
        request.let(::extractListData)
            .let(::fetchListContent)
            .let(::renderHtml)
            .let(::createResponse)

    fun extractListData(request: Request): Pair<User, ListName> {
        val user = request.path("user").orEmpty()
        val list = request.path("list").orEmpty()
        return User(user) to ListName(list)
    }

    fun fetchListContent(listId: Pair<User, ListName>): ToDoList =
        lists[listId.first]
            ?.firstOrNull { it.listName == listId.second }
            ?: error("List unknown")

    fun renderHtml(todoList: ToDoList): HtmlPage =
        HtmlPage(
            """
                <html>
                    <body>
                        <h1>Zettai</h1>
                        <h2>${todoList.listName.name}</h2>
                        <table>
                            <tbody>${renderItems(todoList.items)}</tbody>
                        </table>
                    </body>
                </html>
            """.trimIndent()
        )

    fun renderItems(items: List<ToDoItem>) =
        items.map {
            """<tr><td>${it.description}</td></tr>""".trimIndent()
        }.joinToString("")

    fun createResponse(html: HtmlPage): Response = Response(Status.OK).body(html.raw)
}

// f andThen g 는 g(f()) 와 같다.
typealias FUN<A, B> = (A) -> B
infix fun <A, B, C> FUN<A, B>.andThen(other: FUN<B, C>): FUN<A, C> = { a: A -> other(this(a)) }

class After(
    val lists: Map<User, List<ToDoList>>
) {


    val processFun = ::extractListData andThen
            ::fetchListContent andThen
            ::renderHtml andThen
            ::createResponse

    fun showList(request: Request) =
        request.let(::extractListData)
            .let(::fetchListContent)
            .let(::renderHtml)
            .let(::createResponse)

    fun extractListData(request: Request): Pair<User, ListName> {
        val user = request.path("user").orEmpty()
        val list = request.path("list").orEmpty()
        return User(user) to ListName(list)
    }

    fun fetchListContent(listId: Pair<User, ListName>): ToDoList =
        lists[listId.first]
            ?.firstOrNull { it.listName == listId.second }
            ?: error("List unknown")

    fun renderHtml(todoList: ToDoList): HtmlPage =
        HtmlPage(
            """
                <html>
                    <body>
                        <h1>Zettai</h1>
                        <h2>${todoList.listName.name}</h2>
                        <table>
                            <tbody>${renderItems(todoList.items)}</tbody>
                        </table>
                    </body>
                </html>
            """.trimIndent()
        )

    fun renderItems(items: List<ToDoItem>) =
        items.map {
            """<tr><td>${it.description}</td></tr>""".trimIndent()
        }.joinToString("")

    fun createResponse(html: HtmlPage): Response = Response(Status.OK).body(html.raw)


}