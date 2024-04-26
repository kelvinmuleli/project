package net.ezra.ui.contact


import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_CONTACT
import net.ezra.navigation.ROUTE_HOME

// Sample data class for contacts
data class Contact(val name: String, val imageId: Int)

// Sample list of contacts
val contacts = listOf(
    Contact("John", R.drawable.yolks),
    Contact("Emma", R.drawable.klm),
    Contact("Michael", R.drawable.car),
    // Add more contacts as needed
)



@Composable
fun ContactScreen(navController: NavHostController) {
    var contacts by remember { mutableStateOf(listOf<String>()) }
    var newContact by remember { mutableStateOf(TextFieldValue()) }


    Text(
        modifier = Modifier
            .clickable {
                navController.navigate(ROUTE_HOME) {
                    popUpTo(ROUTE_CONTACT) { inclusive = true }
                }
            },
        text = "Contact"
    )
    LazyColumn (
        modifier = Modifier
            .background(Color(0xff0cb2a8))

    ){
        item {
            Text("Favorite Contacts", modifier = Modifier.padding(16.dp))
            LazyRow {
                items(contacts) { contact ->
                    ContactItem(contact = contact)
                }
            }
        }
        item {
            Text("All Contacts", modifier = Modifier.padding(16.dp))
            LazyColumn {
                items(contacts) { contact ->
                    ContactItem(contact = contact)
                }
            }
        }
    }
}

@Composable
fun ContactItem(contact: String) {
    Image(
        painter = painterResource(id = R.drawable.yolks),
        contentDescription = null,
        modifier = Modifier
            .padding(8.dp)
            .size(64.dp),
           // .align(Alignment.CenterVertically),
        contentScale = ContentScale.Crop,
       // shape = CircleShape
    )

}



@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    ContactScreen(rememberNavController())
}


