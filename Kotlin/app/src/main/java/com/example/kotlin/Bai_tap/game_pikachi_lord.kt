package com.example.kotlin.Bai_tap

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlin.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.MainScope

data class PikachuCard(
    val id: Int,
    val imageResource: Int,
    var isMatched: MutableState<Boolean> = mutableStateOf(false),
    var isSelected: MutableState<Boolean> = mutableStateOf(false)
)

@Composable
fun game_pikachu() {
    val list = remember {
        mutableStateListOf(
            PikachuCard(1, R.drawable.pikachu),
            PikachuCard(1, R.drawable.pikachu),
            PikachuCard(2, R.drawable.ech_ki_dieu),
            PikachuCard(2, R.drawable.ech_ki_dieu),
            PikachuCard(3, R.drawable.chameleon),
            PikachuCard(3, R.drawable.chameleon),
            PikachuCard(4, R.drawable.rua),
            PikachuCard(4, R.drawable.rua)
        ).shuffled()
    }


    var selectedCards = remember { mutableStateListOf<PikachuCard>() }
    var canSelectCard = remember { mutableStateOf(true) }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier
            .fillMaxSize()
    ) {
        itemsIndexed(list) { index, card ->

            Card(
                modifier = Modifier
                    .width(90.dp)
                    .height(100.dp)
                    .padding(10.dp)
                    .border(
                        width = if (card.isSelected.value) 2.dp else 0.dp,
                        color = if (card.isSelected.value) Color.Red else Color.Transparent
                    )
                    .clickable {

                        if (selectedCards.size < 2 && !card.isMatched.value && canSelectCard.value && !selectedCards.contains(card)) {
                            card.isSelected.value = true
                            selectedCards.add(card)

                            if (selectedCards.size == 2) {
                                canSelectCard.value = false

                                MainScope().launch {
                                    delay(1000)

                                    if (selectedCards[0].id == selectedCards[1].id) {
                                        selectedCards[0].isMatched.value = true
                                        selectedCards[1].isMatched.value = true
                                    }

                                    selectedCards[0].isSelected.value = false
                                    selectedCards[1].isSelected.value = false
                                    selectedCards.clear()
                                    canSelectCard.value = true
                                }
                            }
                        }
                    }
            ) {
                Column {
                    if (card.isMatched.value) {
                        Image(painter = painterResource(R.drawable.th), contentDescription = null
                            )
                    } else {
                        Image(painter = painterResource(card.imageResource), contentDescription = null
                            , contentScale = ContentScale.Crop )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun preview_game() {
    Surface(modifier = Modifier.fillMaxSize()) {
        game_pikachu()
    }
}
