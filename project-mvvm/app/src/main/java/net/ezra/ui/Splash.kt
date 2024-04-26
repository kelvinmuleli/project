package net.ezra.ui


import android.content.res.Configuration
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_SERVICES
import net.ezra.navigation.ROUTE_SPLASH


@Composable
fun SplashScreen(navController: NavHostController) {
    Box {
        Image(painter = painterResource(id = R.drawable.splash), contentDescription = "null",
       modifier = Modifier
           .fillMaxSize(),
            contentScale = ContentScale.Crop
        )


        val scale = remember {
            androidx.compose.animation.core.Animatable(0f)
        }

        // Animation
        LaunchedEffect(key1 = true) {
            scale.animateTo(
                targetValue = 0.7f,
                // tween Animation
                animationSpec = tween(
                    durationMillis = 800,
                    easing = {
                        OvershootInterpolator(4f).getInterpolation(it)
                    }))
            // Customize the delay time
            delay(2000L)
            navController.navigate(ROUTE_SERVICES)
        }

        // Image

        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Image(painter = painterResource(id = R.drawable.splash),
                contentDescription = "Logo",
                modifier = Modifier.scale(scale.value)
            )

            Text("Muleli Softwares", textAlign = TextAlign.Center, )
            Spacer(modifier = Modifier.height(110.dp))

            Text(text = "Ready to help you have a safe journey",)



        }

        Button(onClick = {
            navController.navigate(ROUTE_SERVICES) {
                popUpTo(ROUTE_SPLASH) { inclusive = true }
            }
        }, shape = CutCornerShape(10)) {
            Text(text = "This is a transport app")
        }




    }

}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    SplashScreen(rememberNavController())
}

