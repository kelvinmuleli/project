package net.ezra.ui.evening

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_PRODUCTS

@Composable
fun EveningScreen(navController: NavHostController) {


    Text(
        modifier = Modifier
            .clickable {
                navController.navigate(ROUTE_HOME) {
                    popUpTo(ROUTE_PRODUCTS) { inclusive = true }
                }
            },
        text = "Go home"
    )




    LazyColumn(
     modifier = Modifier
         .fillMaxSize()
         .background(Color(0xff16b882))

 ) {

     item {
         Text(text = "Details")

         Row {

             Text(text = "Tessia Roadster")
             Spacer(modifier = Modifier.height(12.dp))


             Image(painter = painterResource(id =R.drawable.splash ),
                 contentDescription ="null" )

         }

         Row {

        Text(text = "Specifications")

             Card {

                 Text(text = "5500kw")
                 
                 Spacer(modifier = Modifier.height(7.dp))
                 
                 Text(text = "Out put")
                 
             }

             Card {
                 Text(text = "350km/h")


                 Spacer(modifier = Modifier.height(7.dp))
                 
                 
                 Text(text = "Top speed")


            }

             
         }

         LazyRow(
             modifier = Modifier
                 .fillMaxWidth()
                 .background(Color(0xff16b8ae))
         ) {
             item {

                 Column {
                     Card {
                         Image(painter = painterResource(id = R.drawable.splash) ,
                             contentDescription ="" )
                     }

                     Card {
                         Image(painter = painterResource(id = R.drawable.splash) ,
                             contentDescription ="" )
                     }

                     Card {
                         Image(painter = painterResource(id = R.drawable.splash) ,
                             contentDescription ="" )
                     }


                 }




             }

         }








     }

 }


}

@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    EveningScreen(rememberNavController())
}




