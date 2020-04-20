package com.boring.center.auth.config;

import com.boring.common.auth.userdetails.AuthUser;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;
import com.boring.common.core.constant.SecurityConstants;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yorkehan
 * @Date: 2020/4/4 5:38 下午
 */
@Component
public class BoringTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        final Map<String, Object> map = new HashMap<>(8);
        final AuthUser authUser = (AuthUser) authentication.getPrincipal();
        map.put(SecurityConstants.DETAILS_USER_ID,authUser.getUserId());
        map.put(SecurityConstants.DETAILS_USERNAME,authUser.getUsername());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(map);
        return accessToken;
    }
}
