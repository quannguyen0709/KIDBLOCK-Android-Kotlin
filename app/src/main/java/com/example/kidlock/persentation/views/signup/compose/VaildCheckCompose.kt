package com.example.kidlock.persentation.views.signup.compose

import android.annotation.SuppressLint
import android.util.Patterns
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.kidlock.R
import com.example.kidlock.persentation.utils.SizeScreen.wp
import com.example.kidlock.theme.KidlockTheme
import com.example.kidlock.theme.KidlockTheme.color
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


abstract class TypeTextInputVaild {
    abstract val nameInput: String
    abstract val description: String
    abstract val errorDescription: String
    abstract val vaildCheck: MutableLiveData<Boolean>
    val input: MutableLiveData<String> = MutableLiveData<String>("")
    abstract val keyboardOptions: KeyboardOptions
    abstract val keyboardActions: KeyboardActions
    abstract val focusManager: FocusManager
    private var visible: Boolean = true
    abstract val icon: Int
    val visiblePassword: MutableLiveData<VisualTransformation> = MutableLiveData(
        if (visible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )

    fun updateVisible() {
        visible = !visible
        if (visible) {
            visiblePassword.value = VisualTransformation.None
        } else {
            visiblePassword.value = PasswordVisualTransformation()
        }
    }

    abstract fun checkVaild()
}

class NameUser(
    override val nameInput: String = "Name",
    override val description: String = "John Doe",
    override val focusManager: FocusManager,
    override val keyboardOptions: KeyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
    override val keyboardActions: KeyboardActions = KeyboardActions(
        onGo = {
            focusManager.moveFocus(FocusDirection.Down)
        }
    ),
    override val icon: Int = 0,
    override val errorDescription: String = "Name user is empty"
) : TypeTextInputVaild() {
    override val vaildCheck: MutableLiveData<Boolean> = MutableLiveData(true)
    override fun checkVaild() {
        vaildCheck.value = super.input.value!!.isNotEmpty()
    }
}

data class EmailUser(
    override val nameInput: String = "Email",
    override val description: String = "johndoe@example.com",
    override val keyboardOptions: KeyboardOptions = KeyboardOptions(
        imeAction = ImeAction.Next
    ),
    override val focusManager: FocusManager,
    override val keyboardActions: KeyboardActions = KeyboardActions(
        onGo = {
            focusManager.moveFocus(FocusDirection.Down)
        }
    ),
    override val icon: Int = 0,
    override val errorDescription: String = "Email address is not correct"

) : TypeTextInputVaild() {
    override val vaildCheck: MutableLiveData<Boolean> = MutableLiveData(true)
    override fun checkVaild() {
        vaildCheck.value = Patterns.EMAIL_ADDRESS.matcher(super.input.value!!).matches()
    }
}

data class PasswordUser(
    override val nameInput: String = "Password",
    override val description: String = "******",
    override val icon: Int = R.drawable.eye_off_1,
    override val focusManager: FocusManager,
    override val keyboardOptions: KeyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
    override val keyboardActions: KeyboardActions = KeyboardActions(
        onGo = {
            focusManager.moveFocus(FocusDirection.Down)
        }
    ),
    override val errorDescription: String = "",
) : TypeTextInputVaild() {
    init {
        super.updateVisible()
    }

    override val vaildCheck: MutableLiveData<Boolean> = MutableLiveData(true)
    override fun checkVaild() {
        vaildCheck.value = true
    }
}

data class RepeatPasswordUser(
    override val nameInput: String = "Repeat Password",
    override val description: String = "******",
    var passwordUser: String = "",
    override val icon: Int = R.drawable.eye_off_1,
    override val focusManager: FocusManager,
    override val keyboardOptions: KeyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
    override val keyboardActions: KeyboardActions = KeyboardActions(
        onDone = {
            focusManager.clearFocus()
        }
    ),
    override val errorDescription: String = "Repeat password is not correct"
) : TypeTextInputVaild() {
    init {
        super.updateVisible()
    }

    override val vaildCheck: MutableLiveData<Boolean> = MutableLiveData(true)
    override fun checkVaild() {
        vaildCheck.value = passwordUser == super.input.value!!
    }
}


@Composable
fun shapeInputCompose(typeInput: TypeTextInputVaild) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (typeInput.input.value!!.isEmpty()) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = typeInput.description,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.labelMedium.copy(
                    color = MaterialTheme.color.SealBrown.copy(alpha = 0.3f)
                )
            )
        }
        if (typeInput is PasswordUser || typeInput is RepeatPasswordUser) {
            IconButton(
                modifier = Modifier.focusProperties { canFocus = false },
                onClick = {
                    typeInput.updateVisible()
                }) {
                Icon(
                    modifier = Modifier
                        .height(Dp.Unspecified)
                        .width(Dp.Unspecified),
                    painter = painterResource(id = typeInput.icon),
                    contentDescription = "",
                    tint = MaterialTheme.color.Jade
                )
            }
        }
    }
}


@Composable
fun textInput(typeInput: TypeTextInputVaild) {
    var textValue by rememberSaveable {
        mutableStateOf("")
    }
    var checkFocus = false
    val stateVisible = typeInput.visiblePassword.observeAsState()
    val checkVaildObserver = typeInput.vaildCheck.observeAsState()
    return Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dp.Unspecified),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = typeInput.nameInput,
            style = MaterialTheme.typography.labelMedium,
        )
        Row(
            modifier = Modifier
                .height(12.0.wp())
                .fillMaxWidth()
                .background(
                    Color(0XFFA0A0A0).copy(0.1f),
                    shape = MaterialTheme.shapes.medium
                ), verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                textStyle = MaterialTheme.typography.labelSmall,
                modifier = Modifier
                    .onFocusChanged { focusState ->
                        if (!focusState.isFocused) {
                            typeInput.checkVaild()
                        }
                    },
                value = textValue,
                keyboardActions = typeInput.keyboardActions,
                keyboardOptions = typeInput.keyboardOptions,
                singleLine = true,
                onValueChange = {
                    textValue = it
                    typeInput.input.value = it
                },
                visualTransformation = stateVisible.value!!,
                decorationBox = { innerTextField ->
                    shapeInputCompose(typeInput = typeInput)
                    innerTextField()
                }
            )
        }
        if (!checkVaildObserver.value!!) {
            Text(
                text = typeInput.errorDescription,
                style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.color.red)
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true, device = "spec:width=1079.9px,height=2340px,dpi=440")
fun Test(){
    KidlockTheme {
        textInput(typeInput = NameUser(focusManager = LocalFocusManager.current))
    }
}
