import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.ui.tooling.preview.Preview as Preview1

data class TransportOption(val name: String, val description: String, val price: String)

val transportOptions = listOf(
    TransportOption("Taxi", "Get a taxi to your destination", "$10"),
    TransportOption("Bus", "Travel by bus with multiple stops", "$5"),
    TransportOption("Train", "Fastest way to travel", "$15"),
    TransportOption("Bike", "Eco-friendly option", "$2")
)

@Composable
fun ServicesScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Transport App")
                }
            )
        },
        content = {}
            TransportList(transportOptions))
        }

private infix fun <R> Function<R>.TransportList(transportOptions: List<TransportOption>): @Composable (PaddingValues) -> R {
    TODO("Not yet implemented")
}


@Composable
fun TransportList(transportOptions: List<TransportOption>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(transportOptions) { option ->
            TransportItem(option)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun TransportItem(option: TransportOption) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = option.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = option.description,
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 4.dp, bottom = 8.dp)
            )
            Text(
                text = "Price: ${option.price}",
                fontSize = 18.sp,
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}

@Composable
fun SearchScreen(
    items: List<String>,
    onItemClicked: (String) -> Unit
) {
    var searchText by remember { mutableStateOf("") }

    Column {
        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            label = { Text("Search") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        LazyColumn {
            items(items.filter { it.contains(searchText, ignoreCase = true) }) { item ->
                Text(
                    text = item,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onItemClicked(item) }
                        .padding(16.dp)
                )
            }
        }
    }
}


@Preview1
@Composable
fun PreviewTransportApp(navController: NavHostController) {
    ServicesScreen(navController)



}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SearchScreenpreview() {
    SearchScreen()


}

fun SearchScreen() {
    TODO("Not yet implemented")
}
