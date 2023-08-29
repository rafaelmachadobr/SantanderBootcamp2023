package excecoes

class IllegalVoterException(message: String) : Throwable(message)

@Throws(IllegalVoterException::class)
fun vote(nome: String, idade: Int) {
    if (idade < 16) {
        throw IllegalVoterException("O eleitor $nome não pode votar, pois tem apenas $idade anos")
    } else {
        println("O eleitor $nome pode votar")
    }
}

fun main() {
    var quantidadeVotos = 0

    quantidadeVotos += try { vote("Rafael", 19); 1 } catch (e: IllegalVoterException) { 0 }
    quantidadeVotos += try { vote("Maria", 15); 1 } catch (e: IllegalVoterException) { 0 }
    quantidadeVotos += try { vote("José", 18); 1 } catch (e: IllegalVoterException) { 0 }

    println("Quantidade de votos: $quantidadeVotos")
}