class CountriesResponse : ArrayList<CountriesJSONData>()

data class CountriesJSONData(
    val capital: List<String>,
    val flag: String,
    val name: Name
)

data class Name(
    val common: String
)