package com.resellme.resellme.repository.projection;

import java.time.LocalDateTime;

public interface BrandCatalogProjection {
    String getName();
    String getId();
    String getCatalogTitle();
    LocalDateTime getCatalogPostDate();
}
