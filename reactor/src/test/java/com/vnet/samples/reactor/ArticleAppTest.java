package com.vnet.samples.reactor;

import com.vnet.common.VException;
import org.testng.annotations.Test;

public class ArticleAppTest {
    @Test
    public void testFrArticleApp() {
        final ArticleApp app = new ArticleApp();
        app.analyzeArticle("fr");
    }

    @Test
    public void testItArticleApp() {
        final ArticleApp app = new ArticleApp();
        app.analyzeArticle("it");
    }

    @Test(expectedExceptions = VException.class)
    public void testUkArticleApp() {
        final ArticleApp app = new ArticleApp();
        app.analyzeArticle("uk");
    }
}
