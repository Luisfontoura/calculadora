package com.example.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculadora.ui.theme.CalculadoraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Calculadora(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Calculadora(modifier: Modifier = Modifier) {
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(modifier = modifier.padding(16.dp)) {
        TextField(
            value = num1,
            onValueChange = { num1 = it },
            label = { Text("Número 1") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = num2,
            onValueChange = { num2 = it },
            label = { Text("Número 2") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { resultado = try { (num1.toDouble() + num2.toDouble()).toString() } catch (e: Exception) { "Erro" } }) { Text("+") }
            Button(onClick = { resultado = try { (num1.toDouble() - num2.toDouble()).toString() } catch (e: Exception) { "Erro" } }) { Text("-") }
            Button(onClick = { resultado = try { (num1.toDouble() * num2.toDouble()).toString() } catch (e: Exception) { "Erro" } }) { Text("×") }
            Button(onClick = {
                resultado = try {
                    if (num2.toDouble() == 0.0) "Erro: divisão por zero"
                    else (num1.toDouble() / num2.toDouble()).toString()
                } catch (e: Exception) { "Erro" }
            }) { Text("÷") }
            Button(onClick = { num1 = ""; num2 = ""; resultado = "" }) { Text("Limpar") }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Resultado: $resultado")
    }
}

@Preview(showBackground = true)
@Composable
fun CalculadoraPreview() {
    CalculadoraTheme {
        Calculadora()
    }
}
