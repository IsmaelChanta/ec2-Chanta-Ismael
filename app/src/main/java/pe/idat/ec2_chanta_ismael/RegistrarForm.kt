package pe.idat.ec2_chanta_ismael

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

import androidx.compose.ui.text.input.KeyboardType

import androidx.compose.ui.unit.dp

@Composable
fun RegistrationForm(onAccederClick: () -> Unit) {
    var dni by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var sexo by remember { mutableStateOf("Hombre") }
    var deporte by remember { mutableStateOf(false) }
    var pintura by remember { mutableStateOf(false) }
    var otroHobby by remember { mutableStateOf(false) }
    var otroHobbyText by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = dni, onValueChange = { dni = it }, label = { Text("DNI") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = apellidos, onValueChange = { apellidos = it }, label = { Text("Apellidos") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = password, onValueChange = { password = it },
            label = { Text("Password") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Text("Sexo: ")
            RadioButton(selected = sexo == "Hombre", onClick = { sexo = "Hombre" })
            Text("Hombre")
            RadioButton(selected = sexo == "Mujer", onClick = { sexo = "Mujer" })
            Text("Mujer")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text("Hobbies")
        Row {
            Checkbox(checked = deporte, onCheckedChange = { deporte = it })
            Text("Deporte")
        }
        Row {
            Checkbox(checked = pintura, onCheckedChange = { pintura = it })
            Text("Pintura")
        }
        Row {
            Checkbox(checked = otroHobby, onCheckedChange = { otroHobby = it })
            Text("Otro")
            if (otroHobby) {
                Spacer(modifier = Modifier.width(8.dp))
                TextField(
                    value = otroHobbyText,
                    onValueChange = { otroHobbyText = it },
                    label = { Text("Ingrese otro hobby") }
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onAccederClick) {
            Text("Acceder")
        }
    }
}