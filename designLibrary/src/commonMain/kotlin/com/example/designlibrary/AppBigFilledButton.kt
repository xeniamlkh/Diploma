package com.example.designlibrary

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designlibrary.resources.Res
import com.example.designlibrary.resources.ic_arrow_back
import org.jetbrains.compose.resources.painterResource

@Composable
fun AppBigFilledButton(
    onAddTopicClick: () -> Unit
) {
    Button(
        onClick = onAddTopicClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryBlue,
            contentColor = Color.White
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp
        )
    ) {
        Icon(
            painter = painterResource(Res.drawable.ic_arrow_back),
            contentDescription = null,
            modifier = Modifier.size(28.dp)
        )
//        Icon(
//            imageVector = Icons.Default.Add,
//            contentDescription = null,
//            modifier = Modifier.size(28.dp)
//        )
        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = "Добавить тему",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
    }

}

@Preview
@Composable
private fun TempAppBigFilledButtonPreview() {
    AppBigFilledButton(
        onAddTopicClick = {}
    )
}