package com.example.hitungvolume

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hitungvolume.ui.theme.HitungVolumeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HitungVolumeTheme {
                VolumeApp()
            }
        }
    }
}

@Composable
fun VolumeApp() {

    var sisi by remember { mutableStateOf("") }
    var hasilKubus by remember { mutableStateOf("") }

    var jariTabung by remember { mutableStateOf("") }
    var tinggiTabung by remember { mutableStateOf("") }
    var hasilTabung by remember { mutableStateOf("") }

    var jariKerucut by remember { mutableStateOf("") }
    var tinggiKerucut by remember { mutableStateOf("") }
    var hasilKerucut by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        Text(
            text = "Aplikasi Hitung Volume",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        //KUBUS

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {

                Text("Volume Kubus", style = MaterialTheme.typography.titleLarge)

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = sisi,
                    onValueChange = { sisi = it },
                    label = { Text("Masukkan Sisi") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {
                        val s = sisi.toDoubleOrNull()
                        if (s != null) {
                            hasilKubus = "Volume: ${s * s * s}"
                        } else {
                            hasilKubus = "Masukkan angka yang valid"
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Hitung")
                }

                Spacer(modifier = Modifier.height(8.dp))
                Text(hasilKubus)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        //TABUNG

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {

                Text("Volume Tabung", style = MaterialTheme.typography.titleLarge)

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = jariTabung,
                    onValueChange = { jariTabung = it },
                    label = { Text("Jari-jari") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = tinggiTabung,
                    onValueChange = { tinggiTabung = it },
                    label = { Text("Tinggi") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {
                        val r = jariTabung.toDoubleOrNull()
                        val t = tinggiTabung.toDoubleOrNull()
                        if (r != null && t != null) {
                            hasilTabung = "Volume: ${3.14 * r * r * t}"
                        } else {
                            hasilTabung = "Masukkan angka yang valid"
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Hitung")
                }

                Spacer(modifier = Modifier.height(8.dp))
                Text(hasilTabung)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        //KERUCUT

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {

                Text("Volume Kerucut", style = MaterialTheme.typography.titleLarge)

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = jariKerucut,
                    onValueChange = { jariKerucut = it },
                    label = { Text("Jari-jari") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = tinggiKerucut,
                    onValueChange = { tinggiKerucut = it },
                    label = { Text("Tinggi") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {
                        val r = jariKerucut.toDoubleOrNull()
                        val t = tinggiKerucut.toDoubleOrNull()
                        if (r != null && t != null) {
                            hasilKerucut = "Volume: ${(1.0 / 3.0) * 3.14 * r * r * t}"
                        } else {
                            hasilKerucut = "Masukkan angka yang valid"
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Hitung")
                }

                Spacer(modifier = Modifier.height(8.dp))
                Text(hasilKerucut)
            }
        }
    }
}
