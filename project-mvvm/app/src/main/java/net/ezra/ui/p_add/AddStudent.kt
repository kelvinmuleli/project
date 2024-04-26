package net.ezra.ui.students


import android.content.ClipData.Item
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.FirebaseStorage
import net.ezra.navigation.ROUTE_ADD_STUDENTS
import net.ezra.navigation.ROUTE_HOME

import java.util.UUID


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddStudents(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff81f109))
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column ( modifier = Modifier
                    .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    val context = LocalContext.current.applicationContext
                    TopAppBar(
                        title = { Text(text = "Transport") },
                        navigationIcon = {
                            IconButton(onClick = {

                                navController.navigate(ROUTE_HOME) {
                                    popUpTo(ROUTE_ADD_STUDENTS) { inclusive = true }
                                }

                            }) {
                                Icon(imageVector = Icons.Filled.Home, contentDescription = "home")
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color.Gray,
                            titleContentColor = Color.Red,
                            navigationIconContentColor = Color.Blue
                        ),
                        actions = {
                            IconButton(onClick = {Toast.makeText(context, "You have clicked on the search Icon", Toast.LENGTH_SHORT).show()}) {
                                Icon(imageVector = Icons.Filled.Search, contentDescription = "search", tint = Color.White)
                            }
                            IconButton(onClick = {Toast.makeText(context, "You have clicked on the share Icon", Toast.LENGTH_SHORT).show()}) {
                                Icon(imageVector = Icons.Filled.Share, contentDescription = "share", tint = Color.White)

                            }
                            IconButton(onClick = {Toast.makeText(context, "You have clicked on the menu Icon", Toast.LENGTH_SHORT).show() }) {
                                Icon(imageVector = Icons.Filled.Menu, contentDescription = "menu", tint= Color.White)
                            }
                            IconButton(onClick = {Toast.makeText(context,"You have clicked on the person Icon", Toast.LENGTH_SHORT).show()}) {
                                Icon(imageVector = Icons.Filled.Person, contentDescription = "person", tint= Color.White)

                            }
                        })
                }
//                Image(
//                    painter = painterResource(id = net.ezra.R.drawable.logo),
//                    contentDescription = "Logo",
//                    modifier = Modifier
//                        .size(50.dp)
//
//                )
            }
            Column(

                modifier = Modifier.padding(15.dp),

                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Text( "Register ", fontSize = 30.sp)

                var photoUri: Uri? by remember { mutableStateOf(null) }
                val launcher = rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
                    photoUri = uri
                }

                var studentName by rememberSaveable {
                    mutableStateOf("")
                }

                var studentClass by rememberSaveable {
                    mutableStateOf("")
                }

                var email by rememberSaveable {
                    mutableStateOf("")
                }

                var phone by rememberSaveable {
                    mutableStateOf("")
                }

                var comments by rememberSaveable {
                    mutableStateOf("")
                }

                OutlinedTextField(
                    value = studentName,
                    onValueChange = { studentName = it },
                    leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "emailIcon") },
                    label = { Text(text = "Name") },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )

                OutlinedTextField(
                    value = studentClass,
                    onValueChange = { studentClass= it },
                    leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
                    label = { Text(text = "Email") },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )

                OutlinedTextField(
                    value = email,
                    onValueChange = { email= it },
                    leadingIcon = { Icon(imageVector = Icons.Default.Phone, contentDescription = "emailIcon") },
                    label = { Text(text = "Phone-number") },

                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )

                OutlinedTextField(
                    value = phone,
                    onValueChange = { phone= it },
                    leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "emailIcon") },
                    label = { Text(text = "Password") },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )


                OutlinedTextField(
                    value = comments,
                    onValueChange = { comments= it },
                    leadingIcon = { Icon(imageVector = Icons.Default.Check, contentDescription = "emailIcon") },
                    label = { Text(text = "comment on your desired journey") },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .height(200.dp)
                )

                OutlinedButton(
                    onClick = {
                        launcher.launch(
                            PickVisualMediaRequest(
                                //Here we request only photos. Change this to .ImageAndVideo if you want videos too.
                                //Or use .VideoOnly if you only want videos.
                                mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly
                            )
                        )
                    }
                ) {
                    Text("Select Image")
                }


                if (photoUri != null) {
                    //Use Coil to display the selected image
                    val painter = rememberAsyncImagePainter(
                        ImageRequest
                            .Builder(LocalContext.current)
                            .data(data = photoUri)
                            .build()
                    )

                    Image(
                        painter = painter,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(5.dp)
                            .size(150.dp)
                            .fillMaxWidth()
                            .border(1.dp, Color.Gray),
                        contentScale = ContentScale.Crop,

                        )
                }


                OutlinedButton(onClick = {
                    photoUri?.let { uploadImageToFirebaseStorage(it, studentName, studentClass, email, phone, comments) }

                }) {

                    Text(text = "Register")


                }











            }

        }
    }
}










fun uploadImageToFirebaseStorage(imageUri: Uri, studentName: String, studentClass: String, email:String, phone:String, comments:String) {
    val storageRef = FirebaseStorage.getInstance().reference
    val imageRef = storageRef.child("images/${UUID.randomUUID()}")

    val uploadTask = imageRef.putFile(imageUri)
    uploadTask.continueWithTask { task ->
        if (!task.isSuccessful) {
            task.exception?.let {
                throw it
            }
        }
        imageRef.downloadUrl
    }.addOnCompleteListener { task ->
        if (task.isSuccessful) {
            val downloadUri = task.result
            saveToFirestore(downloadUri.toString(), studentName, studentClass, email, phone, comments)
        } else {


        }
    }
}

fun saveToFirestore(imageUrl: String, studentName: String, studentClass: String, email:String, phone:String, comments: String) {
    val db = Firebase.firestore
    val imageInfo = hashMapOf(
        "imageUrl" to imageUrl,
        "studentName" to studentName,
        "studentClass" to studentClass,
        "email" to email,
        "phone" to phone,
        "comments" to comments

    )




    db.collection("Students")
        .add(imageInfo)
        .addOnSuccessListener {



        }
        .addOnFailureListener {
            // Handle error
        }
}







@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    AddStudents(rememberNavController())
}