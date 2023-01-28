package io.github.tscholze.cmpsample.model

import kotlinx.serialization.Serializable

/**
 * Defines a content snippet which will be used for generating
 * the Json feed.
 *
 * @property title Title of the post
 * @property created: Markdown created timestamp
 * @property url Url to the post
 * @property coverImageUrl Url to the cover image
 */
@Serializable
class BlogFeedItem(
    val title: String,
    val created: String,
    val url: String,
    val coverImageUrl: String
)


