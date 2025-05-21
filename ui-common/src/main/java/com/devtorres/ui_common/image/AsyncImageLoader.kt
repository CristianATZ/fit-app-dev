package com.devtorres.ui_common.image

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.devtorres.finager.core.presentation.components.typo.BodySmall
import com.devtorres.ui_common.R

@Composable
fun AsyncImageLoader(
    modifier: Modifier = Modifier,
    folderPath: String = "",              // p. ej. "exercises" o "supplements"
    contentScale: ContentScale = ContentScale.Crop,
    placeholderRatio: Float = 1f
) {
    val imageUri = remember(folderPath) {
        "file:///android_asset/$folderPath"
    }

    var state by remember { mutableStateOf<AsyncImagePainter.State>(AsyncImagePainter.State.Empty) }

    Box(
        modifier = modifier
            .height(200.dp)
            .background(colorScheme.surfaceVariant),
        contentAlignment = Alignment.Center
    ) {
        when (state) {
            is AsyncImagePainter.State.Error -> {
                BodySmall(
                    text = stringResource(R.string.lblImageNotFound),
                    color = colorScheme.onSurfaceVariant
                )
            }

            else -> {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imageUri)
                        .size(Size.ORIGINAL)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    contentScale = contentScale,
                    onState = { painterState -> state = painterState },
                    modifier = Modifier
                        .matchParentSize()
                        .then(
                            if (state is AsyncImagePainter.State.Loading)
                                Modifier.aspectRatio(placeholderRatio)
                            else Modifier
                        )
                )

                if (state is AsyncImagePainter.State.Loading) {
                    CircularProgressIndicator(modifier = Modifier.size(24.dp))
                }
            }
        }
    }
}
