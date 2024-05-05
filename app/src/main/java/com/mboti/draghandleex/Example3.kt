package com.mboti.draghandleex

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalIconToggleButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp


@Composable
fun Example3() {
    var showModal by remember { mutableStateOf(false) }

    Column {

        Row (Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End){
            FilledTonalIconToggleButton(
                checked = showModal,
                onCheckedChange = { showModal = it },
                modifier = Modifier.size(60.dp),
            )
            {
                if (showModal) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.settings_mixer_off),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                } else {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.settings_mixer),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }


        if (showModal) {
            MyBottomSheet(
                onDismissRequest = { /* Ne rien faire ici pour empêcher la fermeture */ },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBottomSheet(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    BottomSheetScaffold(
        scaffoldState = rememberBottomSheetScaffoldState(),
        sheetContent = {
            // Contenu de votre BottomSheet
            Column(modifier = Modifier.fillMaxWidth()) {
                Text("Contenu du bas de page")
            }
        },
        sheetPeekHeight = 0.dp,
        modifier = modifier
    ) {
        Text(text = "Mounir")
    }
}