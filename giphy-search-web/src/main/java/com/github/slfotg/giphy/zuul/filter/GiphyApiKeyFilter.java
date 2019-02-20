package com.github.slfotg.giphy.zuul.filter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.slfotg.giphy.api.config.GiphyConfigurationProperties;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * Simple ZuulFilter that adds the Giphy API key as a parameter to every request
 */
@Component
public class GiphyApiKeyFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(GiphyApiKeyFilter.class);

    @Autowired
    GiphyConfigurationProperties giphyProperties;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        log.debug("Adding Giphy API key to request");
        RequestContext ctx = RequestContext.getCurrentContext();

        Map<String, List<String>> params = (ctx.getRequestQueryParams() == null ? new HashMap<>()
                : ctx.getRequestQueryParams());

        params.put("api_key", Arrays.asList(giphyProperties.getApiKey()));
        ctx.setRequestQueryParams(params);

        return null;
    }

}
