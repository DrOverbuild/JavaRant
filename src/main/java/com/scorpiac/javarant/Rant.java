package com.scorpiac.javarant;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.scorpiac.javarant.services.RequestHandler;

import java.net.URI;
import java.util.Collections;
import java.util.List;

public class Rant extends RantContent {
    private List<String> tags;
    @JsonProperty("num_comments")
    private int commentCount;
    private List<Comment> comments;

    /**
     * Get the comments on this rant. If they are not yet retrieved, this will also fetch them.
     *
     * @return The comments.
     */
    public List<Comment> getComments() {
        fetchComments();
        return Collections.unmodifiableList(comments);
    }

    /**
     * Fetch the comments on this rant. If the comments are already fetched, they will not be fetched again.
     *
     * @return Whether the data was fetched successfully.
     */
    public boolean fetchComments() {
        return fetchComments(false);
    }

    /**
     * Fetch the comments on this rant.
     *
     * @param force Whether to fetch the comments even if it they are already fetched.
     * @return Whether the data was fetched successfully.
     */
    public boolean fetchComments(boolean force) {
        return true;
    }

    /**
     * Get the link to the rant.
     */
    public URI link() {
        return RequestHandler.BASE_URI.resolve(DevRant.RANT_URL).resolve(String.valueOf(getId()));
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && obj instanceof Rant;
    }

    /**
     * Get the tags.
     */
    public List<String> getTags() {
        return Collections.unmodifiableList(tags);
    }

    /**
     * Get the amount of comments.
     */
    public int getCommentCount() {
        return commentCount;
    }
}
