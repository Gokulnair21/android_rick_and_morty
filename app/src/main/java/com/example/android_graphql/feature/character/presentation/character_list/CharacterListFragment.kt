package com.example.android_graphql.feature.character.presentation.character_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.viewModels
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.android_graphql.feature.character.domain.entity.CharacterEntity
import com.example.android_graphql.R
import com.example.android_graphql.base.BaseComposeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterListFragment : BaseComposeFragment() {


    private val viewModel: CharacterListViewModel by viewModels()


    @Composable
    override fun SetMainUI() {
        val characterList = viewModel.dataList.collectAsState()
        LazyColumn(modifier = Modifier.padding(horizontal = 10.dp)) {

            item {
                Text(text = "Character List")
                Spacer(modifier = Modifier.height(10.dp))
            }

            items(characterList.value.size) {
                CharacterCard(characterList.value[it])
            }
        }
    }


    @Composable
    fun CharacterCard(characterEntity: CharacterEntity) {
        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .padding(bottom = 5.dp)
                .fillMaxWidth()
        ) {
            Row(modifier = Modifier.padding(10.dp)) {
                AsyncImage(
                    model = ImageRequest.Builder(requireContext())
                        .data(characterEntity.image)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = "Character Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape),
                    error = painterResource(id = R.drawable.ic_launcher_background)
                )

                Column(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(characterEntity.name, fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(characterEntity.gender, fontSize = 15.sp)
                }

            }
        }
    }

}