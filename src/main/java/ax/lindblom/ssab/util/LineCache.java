package ax.lindblom.ssab.util;

import ax.lindblom.ssab.model.Line;

import java.time.LocalDateTime;
import java.util.List;

public class LineCache {
    private final long cacheLengthInSeconds;
    private LocalDateTime lastCacheUpdate;
    private List<Line> cache;

    /**
     * Caches the Lines for specified amount of time in seconds. The cache will be cleared
     * and return null when trying to get the cached lines after expiration.
     * @param cacheLength How long in seconds the cache are valid after it has been set.
     */
    public LineCache(long cacheLength){
        this.cacheLengthInSeconds = cacheLength;
    }

    /**
     * Stores the lines in the cache and resets the timer for cache clearance.
     * @param lines The lines that will be cached.
     */
    public void setCache(List<Line> lines) {
        lastCacheUpdate = LocalDateTime.now();
        this.cache = lines;
    }

    /**
     *
     * @return The cached lines unless the cache has expired in that case null is returned.
     */
    public List<Line> getCache() {
        if(hasCacheExpired()){
            return null;
        } else {
            return cache;
        }
    }

    private boolean hasCacheExpired() {
        return lastCacheUpdate == null || LocalDateTime.now().minusSeconds(cacheLengthInSeconds).isAfter(lastCacheUpdate);
    }
}
