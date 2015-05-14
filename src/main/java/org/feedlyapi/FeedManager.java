package org.feedlyapi;

import org.feedlyapi.model.Category;
import org.feedlyapi.model.Feed;
import org.feedlyapi.model.Stream;
import org.feedlyapi.model.Subscription;
import org.feedlyapi.retrofit.FeedlyInterface;

@SuppressWarnings("WeakerAccess")
/**
 * This class is used for wrapping the API calls of the FeedlyInterface to provide easier access to its functions.
 *
 * @author Dennis Effing
 * @author Sebastian Schiller
 */
public class FeedManager {

    private final FeedlyInterface api;

    public FeedManager(FeedlyInterface api) {
        this.api = api;
    }

    /**
     * Returns the API interface used by this FeedManager instance.
     *
     * @return API Interface
     * @see FeedlyInterface
     */
    public FeedlyInterface getApiInterface() {
        return api;
    }

    //region Get articles from global categories
    /**
     * Gets the latest articles of the global.all category.
     *
     * @param count Number of articles. Default is 20 (when null), max is 10,000.
     * @return Stream object containing article entries and other information about the Stream.
     * @see Stream
     */
    public Stream getLatestArticles(Integer count) {
        return this.getLatestArticles(count, null);
    }

    /**
     * Works like {@link #getLatestArticles(Integer)} but considers a continuation string when fetching articles.
     *
     * @param count        Number of articles. Default is 20 (when null), max is 10,000.
     * @param continuation Continuation String of the last call. This ID guarantees that no entry will be duplicated
     *                     in a stream.
     * @return Stream object containing article entries and other information about the Stream.
     * @see Stream
     */
    public Stream getLatestArticles(Integer count, String continuation) {
        String globalAllCategoryId = "user/" + api.getProfile().getId() + "/category/global.all";

        return api.getStreamContent(globalAllCategoryId, count, null, null, null, continuation);
    }

    /**
     * Gets the latest articles of the global.read category.
     *
     * @param count Number of articles. Default is 20 (when null), max is 10,000.
     * @return Stream object containing article entries and other information about the Stream.
     * @see Stream
     */
    public Stream getLatestReadArticles(Integer count) {
        return getLatestReadArticles(count, null);
    }

    /**
     * Works like {@link #getLatestReadArticles(Integer)} but considers a continuation string when fetching articles.
     *
     * @param count        Number of articles. Default is 20 (when null), max is 10,000.
     * @param continuation Continuation String of the last call. This ID guarantees that no entry will be duplicated
     *                     in a stream.
     * @return Stream object containing article entries and other information about the Stream.
     * @see Stream
     */
    public Stream getLatestReadArticles(Integer count, String continuation) {
        String globalReadCategoryId = "user/" + api.getProfile().getId() + "/category/global.read";

        return api.getStreamContent(globalReadCategoryId, count, null, null, null, continuation);
    }

    /**
     * Gets the latest articles of the global.saved category.
     *
     * @param count Number of articles. Default is 20 (when null), max is 10,000.
     * @return Stream object containing article entries and other information about the Stream.
     * @see Stream
     */
    public Stream getLatestSavedArticles(Integer count) {
        return getLatestSavedArticles(count, null);
    }

    /**
     * Works like {@link #getLatestSavedArticles(Integer)} but considers a continuation string when fetching articles.
     *
     * @param count        Number of articles. Default is 20 (when null), max is 10,000.
     * @param continuation Continuation String of the last call. This ID guarantees that no entry will be duplicated
     *                     in a stream.
     * @return Stream object containing article entries and other information about the Stream.
     * @see Stream
     */
    public Stream getLatestSavedArticles(Integer count, String continuation) {
        String globalSavedCategoryId = "user/" + api.getProfile().getId() + "/category/global.saved";

        return api.getStreamContent(globalSavedCategoryId, count, null, null, null, continuation);
    }

    /**
     * Gets the latest uncategorized articles (global.uncategorized category).
     *
     * @param count Number of articles. Default is 20 (when null), max is 10,000.
     * @return Stream object containing article entries and other information about the Stream.
     * @see Stream
     */
    public Stream getLatestUncategorizedArticles(Integer count) {
        return getLatestUncategorizedArticles(count, null);
    }

    /**
     * Works like {@link #getLatestUncategorizedArticles(Integer)} but considers a continuation string when fetching articles.
     *
     * @param count        Number of articles. Default is 20 (when null), max is 10,000.
     * @param continuation Continuation String of the last call. This ID guarantees that no entry will be duplicated
     *                     in a stream.
     * @return Stream object containing article entries and other information about the Stream.
     * @see Stream
     */
    public Stream getLatestUncategorizedArticles(Integer count, String continuation) {
        String globalUncategorizedCategoryId = "user/" + api.getProfile().getId() + "/category/global.uncategorized";

        return api.getStreamContent(globalUncategorizedCategoryId, count, null, null, null, continuation);
    }

    /**
     * Gets the latest must read articles (global.must category).
     *
     * @param count Number of articles. Default is 20 (when null), max is 10,000.
     * @return Stream object containing article entries and other information about the Stream.
     * @see Stream
     */
    public Stream getLatestMustReadArticles(Integer count) {
        return getLatestMustReadArticles(count, null);
    }

    /**
     * Works like {@link #getLatestMustReadArticles(Integer)} but considers a continuation string when fetching articles.
     *
     * @param count        Number of articles. Default is 20 (when null), max is 10,000.
     * @param continuation Continuation String of the last call. This ID guarantees that no entry will be duplicated
     *                     in a stream.
     * @return Stream object containing article entries and other information about the Stream.
     * @see Stream
     */
    public Stream getLatestMustReadArticles(Integer count, String continuation) {
        String globalMustReadCategoryId = "user/" + api.getProfile().getId() + "/category/global.must";

        return api.getStreamContent(globalMustReadCategoryId, count, null, null, null, continuation);
    }
    //endregion

    //region Get articles from Feeds, Subscriptions and user categories
    /**
     * Gets the latest articles of the specified category.
     *
     * @param category Category object containing the category ID.
     * @param count    Number of articles. Default is 20 (when null), max is 10,000.
     * @return Stream object containing article entries and other information about the Stream.
     * @see Stream
     */
    public Stream getLatestArticlesOfCategory(Category category, Integer count) {
        return getLatestArticlesOfCategory(category, count, null);
    }

    /**
     * Works like {@link #getLatestArticlesOfCategory(Category, Integer)} but considers a continuation string when
     * fetching articles.
     *
     * @param category     Category object containing information about the specified category.
     * @param count        Number of articles. Default is 20 (when null), max is 10,000.
     * @param continuation Continuation String of the last call. This ID guarantees that no entry will be duplicated
     *                     in a stream.
     * @return Stream object containing article entries and other information about the Stream.
     * @see Stream
     */
    public Stream getLatestArticlesOfCategory(Category category, Integer count, String continuation) {
        return api.getStreamContent(category.getId(), count, null, null, null, continuation);
    }

    /**
     * Gets the latest articles of the specified subscription.
     *
     * @param subscription Subscription object containing the feed ID.
     * @param count        Number of articles. Default is 20 (when null), max is 10,000.
     * @return Stream object containing article entries and other information about the stream.
     * @see Stream
     */
    public Stream getLatestArticlesOfSubscription(Subscription subscription, Integer count) {
        return getLatestArticlesOfSubscription(subscription, count, null);
    }

    /**
     * Works like {@link #getLatestArticlesOfSubscription(Subscription, Integer)} but considers a continuation
     * String when fetching articles.
     *
     * @param subscription Subscription object containing the feed ID.
     * @param count        Number of articles. Default is 20 (when null), max is 10,000.
     * @param continuation Continuation String of the last call. This ID guarantees that no entry will be duplicated
     *                     in a stream.
     * @return Stream object containing article entries and other information about the stream.
     * @see Stream
     */
    public Stream getLatestArticlesOfSubscription(Subscription subscription, Integer count, String continuation) {
        return api.getStreamContent(subscription.getFeedId(), count, null, null, null, continuation);
    }

    /**
     * Gets the latest articles of the specified feed.
     *
     * @param feed  Feed object containing the feed ID.
     * @param count Number of articles. Default is 20 (when null), max is 10,000.
     * @return Stream object containing article entries and other information about the stream.
     * @see Stream
     */
    public Stream getLatestArticlesOfFeed(Feed feed, Integer count) {
        return getLatestArticlesOfFeed(feed, count, null);
    }

    /**
     * Works like {@link #getLatestArticlesOfFeed(Feed, Integer)} but considers a continuation String when fetching
     * articles.
     *
     * @param feed         Feed object containing the feed ID.
     * @param count        Number of articles. Default is 20 (when null), max is 10,000.
     * @param continuation Continuation String of the last call. This ID guarantees that no entry will be duplicated
     *                     in a stream.
     * @return Stream object containing article entries and other information about the stream.
     * @see Stream
     */
    public Stream getLatestArticlesOfFeed(Feed feed, Integer count, String continuation) {
        return api.getStreamContent(feed.getFeedId(), count, null, null, null, continuation);
    }
    //endregion
}
