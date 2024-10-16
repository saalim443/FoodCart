package com.example.navigationapplication.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.navigationapplication.R
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState

@SuppressLint("UnrememberedMutableInteractionSource")
@Composable
fun signinScreen(navController: NavHostController) {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Text(text = "This is Screen 2")
//        Button(onClick = { navController.navigate("screen3") }) {
//            Text(text = "Go to Screen 3")
//        }
//    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.appicon), // Replace with your actual image resource
            contentDescription = "App Icon",
            modifier = Modifier
                .width(70.dp) // Width for the icon
                .height(70.dp) // Height for the icon
                .padding(start = 5.dp, end = 5.dp), // Add left and right margins of 5dp
            contentScale = ContentScale.Fit // Fit the image without cropping or distortion
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Sign In",
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp), // Set the text size to 50.sp
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "welcome to myMalla !! ,Have nice day",
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 14.sp), // Set the text size to 50.sp
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Spacer for spacing between Sign In and Email
        Spacer(modifier = Modifier.height(10.dp))

        // Email Label and Input Field
        Text(
            text = "Email",
            style = MaterialTheme.typography.bodyLarge, // Style for the label
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        var email by remember { mutableStateOf("") }
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Enter Email") }, // Label inside the field
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp), // Spacing between fields
            singleLine = true,
            shape = RoundedCornerShape(280.dp)
        )

        // Password Label and Input Field
        Text(
            text = "Password",
            style = MaterialTheme.typography.bodyLarge, // Style for the label
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        var password by remember { mutableStateOf("") }
        var passwordVisible by remember { mutableStateOf(false) }
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Enter Password") }, // Label inside the field
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp), // Spacing between fields
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val icon =
                    if (passwordVisible) painterResource(R.drawable.ic_eye) else painterResource(
                        R.drawable.ic_eye
                    )
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(painter = icon, contentDescription = null)
                }
            },
            shape = RoundedCornerShape(280.dp)
        )

        Text(
            text = "Forgot Password?",
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 14.sp), // Set the text size to 14.sp
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth() // Fill the maximum width available
                .wrapContentWidth(Alignment.End) // Align the text to the end (right)
                .padding(bottom = 8.dp) // Add padding at the bottom
                .clickable { // Handle sign-in logic when clicked
                    navController.navigate("screen3")
                }
        )



        // Sign In Button
        // Sign In Button with custom colors
        Button(
            onClick = { /* Handle sign-in logic */

                navController.navigate("screen2")

                      },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(1280.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.orange), // Change this to your desired color
                contentColor = Color.White // Change this to the color of the text/icon on the button
            )
        ) {
            Text("Sign In")
        }
        Spacer(modifier = Modifier.height(10.dp))


        SocialIcon()



        Row(
            modifier = Modifier
                .fillMaxWidth() // Fill the maximum width available
                .padding(16.dp), // Optional padding around the Row
            horizontalArrangement = Arrangement.Center // Center the icons horizontally
        ) {

            Text(
                text = "Don't have an account yet ?",
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 10.sp),  // Style for the label
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = " Create an account",
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 10.sp),  // Style for the label
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 8.dp)
            )


        }

    }

}

@SuppressLint("UnrememberedMutableInteractionSource")
@Composable
fun forgotScreen(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.appicon), // Replace with your actual image resource
            contentDescription = "App Icon",
            modifier = Modifier
                .width(70.dp) // Width for the icon
                .height(70.dp) // Height for the icon
                .padding(start = 5.dp, end = 5.dp), // Add left and right margins of 5dp
            contentScale = ContentScale.Fit // Fit the image without cropping or distortion
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Sign Up",
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp), // Set the text size to 50.sp
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "welcome to myMalla !! ,Have nice day",
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 14.sp), // Set the text size to 50.sp
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Email Label and Input Field
        Text(
            text = "Email your register email",
            style = MaterialTheme.typography.bodyLarge, // Style for the label
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        var email by remember { mutableStateOf("") }
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Enter Email") }, // Label inside the field
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp), // Spacing between fields
            singleLine = true,
            shape = RoundedCornerShape(280.dp)
        )





        // Sign In Button
        // Sign In Button with custom colors
        Button(
            onClick = { /* Handle sign-in logic */

                // navController.navigate("screen2")

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(1280.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.orange), // Change this to your desired color
                contentColor = Color.White // Change this to the color of the text/icon on the button
            )
        ) {
            Text("Create an account In")
        }
        Spacer(modifier = Modifier.height(30.dp))



        AlreadyRegisteredText("Remember Password? Log in")


    }
}

@SuppressLint("UnrememberedMutableInteractionSource")
@Composable
fun sugnUpScreen(navController: NavHostController)
    {


        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()) // Makes the entire UI scrollable
                .padding(10.dp)
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.appicon), // Replace with your actual image resource
                    contentDescription = "App Icon",
                    modifier = Modifier
                        .width(70.dp) // Width for the icon
                        .height(70.dp) // Height for the icon
                        .padding(start = 5.dp, end = 5.dp), // Add left and right margins of 5dp
                    contentScale = ContentScale.Fit // Fit the image without cropping or distortion
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Sign Up",
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp), // Set the text size to 50.sp
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "welcome to myMalla !! ,Have nice day",
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 14.sp), // Set the text size to 50.sp
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // Spacer for spacing between Sign In and Email
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Firstname and lastname",
                    style = MaterialTheme.typography.bodyLarge, // Style for the label
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                var name by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Enter Firstname and lastname") }, // Label inside the field
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp), // Spacing between fields
                    singleLine = true,
                    shape = RoundedCornerShape(280.dp)
                )
                // Email Label and Input Field
                Text(
                    text = "Email",
                    style = MaterialTheme.typography.bodyLarge, // Style for the label
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                var email by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Enter Email") }, // Label inside the field
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp), // Spacing between fields
                    singleLine = true,
                    shape = RoundedCornerShape(280.dp)
                )
                Text(
                    text = "Phone",
                    style = MaterialTheme.typography.bodyLarge, // Style for the label
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                var phone by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = phone,
                    onValueChange = { phone = it },
                    label = { Text("Enter Phone") }, // Label inside the field
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp), // Spacing between fields
                    singleLine = true,
                    shape = RoundedCornerShape(280.dp)
                )

                // Password Label and Input Field
                Text(
                    text = "Password",
                    style = MaterialTheme.typography.bodyLarge, // Style for the label
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                var password by remember { mutableStateOf("") }
                var passwordVisible by remember { mutableStateOf(false) }
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Enter Password") }, // Label inside the field
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp), // Spacing between fields
                    singleLine = true,
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val icon =
                            if (passwordVisible) painterResource(R.drawable.ic_eye) else painterResource(
                                R.drawable.ic_eye
                            )
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(painter = icon, contentDescription = null)
                        }
                    },
                    shape = RoundedCornerShape(280.dp)
                )

                TermsAndConditionsCheckBox()


                // Sign In Button
                // Sign In Button with custom colors
                Button(
                    onClick = { /* Handle sign-in logic */

                        navController.navigate("screen3")

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(1280.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.orange), // Change this to your desired color
                        contentColor = Color.White // Change this to the color of the text/icon on the button
                    )
                ) {
                    Text("Create an account In")
                }
                Spacer(modifier = Modifier.height(5.dp))

                SocialIcon()

                AlreadyRegisteredText("Alredy Register")


            }
        }

    }


@Composable
fun TermsAndConditionsCheckBox() {
    // State to keep track of checkbox selection
    var isChecked by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentWidth()
            .padding(0.dp)
    ) {
        // CheckBox
        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it }
        )

        Spacer(modifier = Modifier.width(0.dp))

        // Clickable Text with Terms & Conditions and Privacy Policy
        val annotatedText = AnnotatedString.Builder("I agree to the Terms & Conditions and Privacy Policy")
            .apply {
                addStyle(SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline), 14, 33) // Terms & Conditions
                addStyle(SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline), 37, 52) // Privacy Policy
            }.toAnnotatedString()

        ClickableText(
            text = annotatedText,
            onClick = { offset ->
                when {
                    offset in 14..33 -> {

                    }
                    offset in 37..52 -> {

                    }
                }
            },
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight(),
            style = TextStyle(
                fontSize = 9.sp // Set the desired text size here
            )
        )

    }
}



@Composable
fun AlreadyRegisteredText(s : String) {
    Box(
        modifier = Modifier
            .fillMaxWidth() // Fill the maximum width available
            .padding(bottom = 0.dp) // Add padding at the bottom
    ) {
        // Annotated text for "Already Register? Log in" with clickable "Log in"
        val annotatedText = AnnotatedString.Builder(s)
            .apply {
                // Making "Log in" blue, underlined, and clickable
                addStyle(SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline), 18, 24)
            }.toAnnotatedString()

        // ClickableText for the whole sentence
        ClickableText(
            text = annotatedText,
            onClick = { offset ->
                if (offset in 18..24) {
                    // Handle the Log in click action here
                    // TODO: Add navigation or logic for login
                    println("Log in clicked") // Replace with your action
                }
            },
            modifier = Modifier.align(Alignment.Center),
            style = TextStyle(
                fontSize = 12.sp, // Set the font size for the text
                color = Color.Black // Set the default text color
            )
        )
    }
}

@SuppressLint("UnrememberedMutableInteractionSource")
@Composable
fun SocialIcon(){
    Box(
        modifier = Modifier
            .fillMaxWidth() // Fill the maximum width available
            .padding(bottom = 8.dp) // Add padding at the bottom
    ) {
        Text(
            text = "- or -",
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp), // Set the text size to 14.sp
            color = Color.Black,
            modifier = Modifier.align(Alignment.Center) // Center align the text in the Box
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth() // Fill the maximum width available
            .padding(16.dp), // Optional padding around the Row
        horizontalArrangement = Arrangement.Center // Center the icons horizontally
    ) {
        // Facebook Icon
        Image(
            painter = painterResource(id = R.drawable.fbb), // Replace with your actual image resource
            contentDescription = "Facebook Icon",
            modifier = Modifier
                .width(50.dp) // Width for the icon
                .height(50.dp) // Height for the icon
                .padding(start = 5.dp, end = 5.dp) // Add left and right margins of 5dp
                .clickable( // Handle the click event
                    onClick = {
                        // Handle Facebook icon click event here
                    },
                    indication = rememberRipple(bounded = true), // Ripple effect
                    interactionSource = MutableInteractionSource()
                ),
            contentScale = ContentScale.Fit // Fit the image without cropping or distortion
        )

        // Google Icon
        Image(
            painter = painterResource(id = R.drawable.google), // Replace with your actual image resource
            contentDescription = "Google Icon",
            modifier = Modifier
                .width(50.dp) // Width for the icon
                .height(50.dp) // Height for the icon
                .padding(start = 5.dp, end = 5.dp) // Add left and right margins of 5dp
                .clickable( // Handle the click event
                    onClick = {
                        // Handle Google icon click event here
                    },
                    indication = rememberRipple(bounded = true), // Ripple effect
                    interactionSource = MutableInteractionSource()
                ),
            contentScale = ContentScale.Fit // Fit the image without cropping or distortion
        )

        // LinkedIn Icon
        Image(
            painter = painterResource(id = R.drawable.linkdin), // Replace with your actual image resource
            contentDescription = "LinkedIn Icon",
            modifier = Modifier
                .width(50.dp) // Width for the icon
                .height(50.dp) // Height for the icon
                .padding(start = 5.dp, end = 5.dp) // Add left and right margins of 5dp
                .clickable( // Handle the click event
                    onClick = {
                        // Handle LinkedIn icon click event here
                    },
                    indication = rememberRipple(bounded = true), // Ripple effect
                    interactionSource = MutableInteractionSource()
                ),
            contentScale = ContentScale.Fit // Fit the image without cropping or distortion
        )
    }
}






