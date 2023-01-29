package io.github.tscholze.cmpsample.composables.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.copperleaf.ballast.navigation.vm.Router
import io.github.tscholze.cmpsample.composables.components.Banner
import io.github.tscholze.cmpsample.composables.layouts.PageLayout
import io.github.tscholze.cmpsample.model.BlogFeedItem
import io.github.tscholze.cmpsample.navigation.AppScreens
import io.github.tscholze.cmpsample.utils.RemoteImage
import io.github.tscholze.cmpsample.utils.makeHttpClient
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.launch

/**
 * Sample screen to demonstrate the kmm approach of remoted fetched resources.
 * See url `"https://tscholze.github.io/blog/posts.json"` for more information.
 *
 * Caution:
 * The http client has to be created for iOS and Android separately.
 */
@Composable
internal fun RemoteResourceScreen(router: Router<AppScreens>) {

    // MARK: - Properties -

    val scope = rememberCoroutineScope()
    val client = makeHttpClient()
    var posts by remember { mutableStateOf(emptyList<BlogFeedItem>()) }

    // MARK: - Helper -

    val uriHandler = LocalUriHandler.current

    // MARK: - LaunchedEffect -

    LaunchedEffect(true) {
        // Fetch posts on launch
        scope.launch {
            posts = client
                .get("https://tscholze.github.io/blog/posts.json")
                .body<List<BlogFeedItem>>()
                .sortedBy { it.created }
                .reversed()
        }
    }

    // MARK: - UI -

    PageLayout("Remote Resources", router) {
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            // 1. Info block
            Banner("The following posts are fetch from an url")

            // 2. List of all items
            LazyColumn {
                itemsIndexed(posts) { index, post ->
                    Column {
                        Column(
                            modifier = Modifier.padding(vertical = 8.dp)
                                .clickable {
                                    uriHandler.openUri(post.url)
                                }
                        ) {

                            // Cover image
                            RemoteImage(
                                client,
                                post.coverImageUrl,
                                modifier = Modifier.fillMaxWidth().aspectRatio(2f),
                                contentDescription = "Article cover image"
                            )

                            // Text block
                            Text(post.title, fontWeight = FontWeight.Medium)
                            Text(
                                post.created,
                                style = MaterialTheme.typography.caption,
                                fontStyle = FontStyle.Italic
                            )
                        }

                        // Show divider if current item is not the last one.
                        if (index < posts.lastIndex) {
                            Divider(
                                color = MaterialTheme.colors.secondaryVariant,
                                thickness = 0.5.dp
                            )
                        }
                    }
                }
            }
        }
    }
}