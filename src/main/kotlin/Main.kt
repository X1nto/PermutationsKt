fun main() {
    print("input a word: ")

    val inputWord = readLine()!!

    if (inputWord.isEmpty()) {
        println("No word was provided")
        return
    }

    val permutations = getPermutations(inputWord).mapIndexed { index, anagram ->
        "${index + 1}. $anagram"
    }

    println(permutations.joinToString("\n"))
    println("Total words: ${permutations.size}")
}

//TODO needs optimization
private fun getPermutations(
    inputWord: String
): List<String> {
    val inputCharacters = inputWord.toCharArray()

    val words = arrayListOf(inputWord)
    val counter = IntArray(inputCharacters.size) { 0 }

    var i = 0
    while (i < inputCharacters.size) {
        if (counter[i] < i) {
            inputCharacters.swap(if (i % 2 == 1) counter[i] else 0, i)
            counter[i]++
            i = 0
            words.add(inputCharacters.joinToString(""))
        } else {
            counter[i] = 0
            i++
        }
    }

    return words.distinct()
}

private fun CharArray.swap(i: Int, j: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}