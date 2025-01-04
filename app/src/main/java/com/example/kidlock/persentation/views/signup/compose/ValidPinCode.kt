package com.example.kidlock.persentation.views.signup.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.MutableLiveData
import com.example.kidlock.R
import com.example.kidlock.persentation.utils.SizeScreen.wp
import com.example.kidlock.persentation.views.statekeyboard.Keyboard
import com.example.kidlock.persentation.views.statekeyboard.keyboardAsStateWithoutApi

@Composable
fun textInputPinCode(input: MutableLiveData<String>, lengthPin : Int) {
    val localFocus = LocalFocusManager.current
    var valuePin by remember{ mutableStateOf("") }
    BasicTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.0.wp()),
        value = valuePin,
        onValueChange = {value->
            if(value.length <= lengthPin){
                valuePin = value
                input.value = valuePin
            }
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.NumberPassword
        ),
        keyboardActions = KeyboardActions(onDone = { localFocus.clearFocus() }),
        decorationBox = {
            CodePinList(valuePin, lengthPin, Modifier)
        }
    )
}

@Composable
fun CodePinList(input:String, lengthPin: Int, modifier: Modifier) {
    Row(
        modifier = modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(5.0.wp()),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(lengthPin){
                index ->
            val char = when{
                index >= input.length -> ""
                else -> input.get(index).toString()
            }
            val regex = "-?[0-9]+(\\.[0-9]+)?".toRegex()
            val isError = !char.matches(regex)
            val isValid = char.isNotBlank()
            val isFocus = index == input.length && (keyboardAsStateWithoutApi().value== Keyboard.Opened)
            Dot(isError = isError, isFocus = isFocus, isValid=  isValid,   valuePin = char, modifier = Modifier.weight(1f))
        }
    }


}

@Composable
fun Dot(isError : Boolean ,isFocus: Boolean,isValid : Boolean,  valuePin: String,  modifier: Modifier) {
    val rememberConroutine = rememberCoroutineScope()
    val colorCheck = if (isFocus) {
        Color(0XFF2092FA).copy(alpha = 0.3f)
    } else if(isValid) {
        if(isError){
            Color.Red.copy(alpha = 0.3f)
        }else{
            Color(0XFF2092FA).copy(alpha = 0.3f)
        }
    }
    else{
        Color(0XFFD9D9D9)
    }
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .background(shape = MaterialTheme.shapes.medium, color = colorCheck),
        contentAlignment = Alignment.Center,
    ) {

        if(isValid){
            Box {
                Text(
                    text = if (isFocus) {
                        valuePin
                    } else {
                        ""
                    }, style = MaterialTheme.typography.titleLarge.copy(color = Color.Black)
                )
            }

            Icon(
                modifier = Modifier
                    .padding(1.5.wp()),
                painter = painterResource(id = R.drawable.ellipse_16),
                contentDescription = "",
                tint = colorCheck

            )
        }
    }
}