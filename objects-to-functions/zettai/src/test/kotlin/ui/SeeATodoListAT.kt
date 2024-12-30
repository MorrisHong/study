package ui

import domain.ToDoList
import org.http4k.client.JettyClient
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Status
import org.http4k.server.Jetty
import org.http4k.server.asServer
import org.junit.jupiter.api.Test
import strikt.api.expect
import strikt.assertions.isEqualTo
import webservice.Zettai
import kotlin.test.fail

class SeeATodoListAT {

    @Test
    fun `List owners can see their lists`() {
        val user = "frank"
        val listName = "shopping"
        val foodToBuy = listOf("carrots", "apples", "milk")
        startTheApplication(user, listName, foodToBuy)
        val list = getTodoList(user, listName)
        expect {
            that(list.listName.name).isEqualTo(listName)
            that(list.items.map { it.description }).isEqualTo(foodToBuy)
        }
    }

    fun getTodoList(user: String, listName: String): ToDoList {
        val client = JettyClient()
        val response = client(Request(Method.GET, "http://localhost:8081/todo/$user/$listName"))
        return if (response.status == Status.OK)
            parseResponse(response.bodyString())
        else
            fail(response.toMessage())
    }

    fun parseResponse(html: String): ToDoList = TODO("parse the response")

    private fun startTheApplication(user: String, listName: String, items: List<String>) {
        val server = Zettai().asServer(Jetty(8081))
    }
}