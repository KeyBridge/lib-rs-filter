/*
 * Copyright 2020 Key Bridge. All rights reserved. Use is subject to license
 * terms.
 *
 * This software code is protected by Copyrights and remains the property of
 * Key Bridge and its suppliers, if any. Key Bridge reserves all rights in and to
 * Copyrights and no license is granted under Copyrights in this Software
 * License Agreement.
 *
 * Key Bridge generally licenses Copyrights for commercialization pursuant to
 * the terms of either a Standard Software Source Code License Agreement or a
 * Standard Product License Agreement. A copy of either Agreement can be
 * obtained upon request by sending an email to info@keybridgewireless.com.
 *
 * All information contained herein is the property of Key Bridge and its
 * suppliers, if any. The intellectual and technical concepts contained herein
 * are proprietary.
 */
package ch.keybridge.rs.security;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import javax.ws.rs.core.SecurityContext;

/**
 * The OAuth 2.0 Authorization Framework: Bearer Token Usage for OAuth 2.0
 * Client Authentication and Authorization Grants
 * <p>
 * HTTP BEARER {@link SecurityContext} implementation for opaque Token based
 * bearer authentication. An opaque token reveals no details other than the
 * value itself (like a random string).
 *
 * @see <a href="https://tools.ietf.org/html/rfc6750">Oauth bearer profile</a>
 * @author Key Bridge
 * @since v0.8.0 created 2020-08-12
 */
public class OauthSecurityContext extends AbstractTokenSecurityContext {

  public OauthSecurityContext(OauthPrincipal principal, Collection<String> scope, boolean secure) {
    super(principal, scope, secure);
  }

  /**
   * Security context builder class. Helps to assemble the security context
   * using fluent setter methods.
   */
  public static class Builder {

    /**
     * A boolean indicating whether the instant request was made using a secure
     * channel, such as HTTPS.
     */
    private boolean secure;
    /**
     * The token owner's group privileges.
     */
    private Collection<String> scope;  // required

    /**
     * The name of the key (i.e. the key id), which is an identifier generated
     * by the resource server.
     */
    private String kid;
    /**
     * The access token string as issued by the authorization server. This
     * represents the {@code consumer_key} portion of the token response.
     */
    private String accessToken;
    /**
     * The session key generated by the authorization server. This is the
     * {@code shared secret} portion of the token response, while the
     * `access_token` field represents the {@code consumer_key} portion of the
     * token response.
     */
    private String macKey;

    public Builder withSecure(boolean secure) {
      this.secure = secure;
      return this;
    }

    public Builder withScope(Collection<String> scope) {
      this.scope = Collections.unmodifiableCollection(scope == null ? new HashSet<>() : scope);
      return this;
    }

    public Builder withKid(String kid) {
      this.kid = kid;
      return this;
    }

    public Builder withAccessToken(String accessToken) {
      this.accessToken = accessToken;
      return this;
    }

    public Builder withMacKey(String macKey) {
      this.macKey = macKey;
      return this;
    }

    /**
     * Build a complete OauthSecurityContext instance.
     *
     * @return a complete OauthSecurityContext instance
     */
    public OauthSecurityContext build() {
      if (kid == null) {
        throw new IllegalArgumentException("kid is required");
      }
      if (accessToken == null) {
        throw new IllegalArgumentException("accessToken is required");
      }
      if (macKey == null) {
        throw new IllegalArgumentException("macKey is required");
      }
      return new OauthSecurityContext(new OauthPrincipal(kid, accessToken, macKey), scope, secure);
    }
  }
}