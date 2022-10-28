package com.example.business_card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.business_card.ui.theme.BusinesscardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinesscardTheme {
                // A surface container using the 'background' color from the theme
                    BusinessCardApp()
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color(red = 0, green = 62, blue = 71))) {
        LogoNameTitleSection(
            modifier = Modifier.weight(8f),
            logoPainter = painterResource(id = R.drawable.android_logo),
            ownerName = stringResource(id = R.string.owner_name),
            positionName = stringResource(id = R.string.position_name)
        )

        ContactInformationSection(
            callPainter = painterResource(id = R.drawable.ic_baseline_call_24),
            sharePainter = painterResource(id = R.drawable.ic_baseline_share_24),
            emailPainter = painterResource(id = R.drawable.ic_baseline_email_24),
            callInfo = stringResource(id = R.string.phone),
            shareInfo = stringResource(id = R.string.share_info),
            emailInfo = stringResource(id = R.string.email),
            modifier = Modifier.weight(2f)
        )
    }
}

@Composable
fun LogoNameTitleSection(
    modifier: Modifier = Modifier,
    ownerName: String,
    positionName: String,
    logoPainter: Painter,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = logoPainter, contentDescription = "logo", Modifier.size(100.dp))
        Text(text = ownerName, fontSize = 45.sp, color = Color.White, modifier = Modifier.padding(top = 14.dp, bottom = 14.dp))
        Text(text = positionName, fontSize = 20.sp, color = Color(red = 0, green = 214, blue = 150))
    }
}

@Composable
fun ContactInformationSection(
    callPainter: Painter,
    sharePainter: Painter,
    emailPainter: Painter,
    callInfo: String,
    shareInfo: String,
    emailInfo: String,
    modifier: Modifier = Modifier,
) {
    Column() {
        CardInfo(callPainter, callInfo)
        CardInfo(sharePainter, shareInfo)
        CardInfo(emailPainter, emailInfo)
        Spacer(modifier = Modifier.fillMaxWidth().padding(30.dp))
    }
}

@Composable
fun CardInfo(itemPainter: Painter, itemInfo: String) {
    Row(
        Modifier
            .drawBehind {
                val strokeWidth = 2f
                val x = size.width
                val y = size.height
                drawLine(color = Color(0xff00D696), strokeWidth = strokeWidth, start = Offset(0f, 0f), end = Offset(x = x, 0f))
            }
            .padding(10.dp)
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Icon(painter = itemPainter, contentDescription = itemInfo.toString(), modifier = Modifier.weight(2f), tint = Color(0xff00D696))
        Text(text = itemInfo, modifier = Modifier.weight(7f), color = Color.White)
    }
}

@Preview(showBackground = false)
@Composable
fun DefaultPreview() {
    BusinesscardTheme {
        BusinessCardApp()
    }
}
/*

.drawBehind {
    val strokeWidth = 2f
    val x = size.width - strokeWidth
    val y = size.height - strokeWidth

    //top line
    drawLine(
        color = Color.Green,
        start = Offset(0f, 0f), //(0,0) at top-left point of the box
        end = Offset(x, 0f), //top-right point of the box
        strokeWidth = strokeWidth
    )

    //left line
    drawLine(
        color = Color.Magenta,
        start = Offset(0f, 0f), //(0,0) at top-left point of the box
        end = Offset(0f, y),//bottom-left point of the box
        strokeWidth = strokeWidth
    )

    //right line
    drawLine(
        color = Color.Red,
        start = Offset(x, 0f),// top-right point of the box
        end = Offset(x, y),// bottom-right point of the box
        strokeWidth = strokeWidth
    )

    //bottom line
    drawLine(
        color = Color.Cyan,
        start = Offset(0f, y),// bottom-left point of the box
        end = Offset(x, y),// bottom-right point of the box
        strokeWidth = strokeWidth
    )
}) {*/
