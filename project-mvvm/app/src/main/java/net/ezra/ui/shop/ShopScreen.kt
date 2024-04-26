package net.ezra.ui.shop


import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_SERVICES
import net.ezra.navigation.ROUTE_SHOP
import net.ezra.ui.theme.AppTheme



@Composable
fun ShopScreen(navController: NavHostController) {

 LazyColumn(
     modifier = Modifier
         .fillMaxSize()
         .background(Color.Transparent)
 ) {
     item {

         Row(
             modifier = Modifier
                 .fillMaxWidth()
                 .background(
                     Color.Cyan
                 )
         ) {
             Text(text = "Tessia")

             Spacer(modifier = Modifier.width(7.dp))

             Spacer(modifier = Modifier.height(27.dp))

             Text(text = "Mazda")

             Spacer(modifier = Modifier.width(7.dp))

             Text(text = "BMW")

             Spacer(modifier = Modifier.width(7.dp))

             Text(text = "Ferari")



         }

         Row (
             modifier = Modifier
                 .fillMaxWidth()
                 .background(Color(0xff1b7ce4))
         ){

             Text(text = "Available cars")
             Card {


                 Image(painter = painterResource(id = R.drawable.splash),
                     contentDescription = "")

             }

             Card {
                 Text(text = "Tesia Roadster")

                 Spacer(modifier = Modifier.height(7.dp))

                 Text(text = "Drive smmothly through a journey")


             }


             Button(onClick = {
                 navController.navigate(ROUTE_SERVICES) {
                     popUpTo(ROUTE_SHOP) { inclusive = true }
                 }
                 //your onclick code here
             }) {
                 Text(text = "$200/1 day ", color = Color.Blue)
                 Text(text = "Details", color = Color.Green)
             }



         }





         Row (
             modifier = Modifier
                 .fillMaxWidth()
                 .background(Color.Blue)
         ){

             Text(text = "Available cars")
             Card {


                 Image(painter = painterResource(id = R.drawable.splash),
                     contentDescription = "")

             }

             Card {
                 Text(text = "Tesia Roadster")

                 Spacer(modifier = Modifier.height(7.dp))

                 Text(text = "Drive smmothly through a journey")


             }


             Button(onClick = {
                 //your onclick code here
             }) {
                 Text(text = "$200/1 day ", color = Color.Blue)
                 Text(text = "Details", color = Color.Green)
             }



         }






         Row (
             modifier = Modifier
                 .fillMaxWidth()
                 .background(Color(0xff1b64e4))
         ){

             Text(text = "Available cars")
             Card {


                 Image(painter = painterResource(id = R.drawable.splash),
                     contentDescription = "")

             }

             Card {
                 Text(text = "Tesia Roadster")

                 Spacer(modifier = Modifier.height(7.dp))

                 Text(text = "Drive smmothly through a journey")


             }


             Button(onClick = {
                 //your onclick code here
             }) {
                 Text(text = "$200/1 day ", color = Color.Blue)
                 Text(text = "Details", color = Color.Green)
             }



         }


         



     }
 }








}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    ShopScreen(rememberNavController())
}



