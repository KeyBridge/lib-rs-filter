/*
 * Copyright 2019 Key Bridge. All rights reserved. Use is subject to license
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
package ch.keybridge.rs;

/**
 * Copy of constant keys in org.glassfish.jersey.client.ClientProperties class.
 *
 * @author Key Bridge
 * @since v0.3.0 created 2019-11-19
 */
public class JerseyClientProperties {

  /**
   * Automatic redirection. A value of {@code true} declares that the client
   * will automatically redirect to the URI declared in 3xx responses.
   * <p>
   * The value MUST be an instance convertible to {@code java.lang.Boolean}.
   * <p>
   * The default value is {@code true}.
   * <p>
   * The name of the configuration property is <tt>{@value}</tt>.
   */
  public static final String FOLLOW_REDIRECTS = "jersey.config.client.followRedirects";
  /**
   * Read timeout interval, in milliseconds.
   * <p>
   * The value MUST be an instance convertible to {@code java.lang.Integer}. A
   * value of zero (0) is equivalent to an interval of infinity.
   * <p>
   * The default value is infinity (0).
   * <p>
   * The name of the configuration property is <tt>{@value}</tt>.
   */
  public static final String READ_TIMEOUT = "jersey.config.client.readTimeout";
  /**
   * Connect timeout interval, in milliseconds.
   * <p>
   * The value MUST be an instance convertible to {@code java.lang.Integer}. A
   * value of zero (0) is equivalent to an interval of infinity.
   * <p>
   * The default value is infinity (0).
   * <p>
   * The name of the configuration property is <tt>{@value}</tt>.
   */
  public static final String CONNECT_TIMEOUT = "jersey.config.client.connectTimeout";
  /**
   * The value MUST be an instance convertible to {@code java.lang.Integer}.
   * <p>
   * The property defines the size of the chunk in bytes. The property does not
   * enable chunked encoding (it is controlled by
   * {@code #REQUEST_ENTITY_PROCESSING} property).
   * <p>
   * A default value is {@value #DEFAULT_CHUNK_SIZE} (since Jersey 2.16).
   * <p>
   * The name of the configuration property is <tt>{@value}</tt>.
   */
  public static final String CHUNKED_ENCODING_SIZE = "jersey.config.client.chunkedEncodingSize";
  /**
   * Default chunk size in HTTP chunk-encoded messages.
   *
   * @since 2.16
   */
  public static final int DEFAULT_CHUNK_SIZE = 4096;
  /**
   * Asynchronous thread pool size.
   * <p>
   * The value MUST be an instance of {@code java.lang.Integer}.
   * <p>
   * If the property is absent then thread pool used for async requests will be
   * initialized as default cached thread pool, which creates new thread for
   * every new request, see {@code java.util.concurrent.Executors}. When a value
   * &gt;&nbsp;0 is provided, the created cached thread pool limited to that
   * number of threads will be utilized. Zero or negative values will be
   * ignored.
   * <p>
   * Note that the property may be ignored if a custom
   * {@code org.glassfish.jersey.spi.ExecutorServiceProvider} is configured to
   * execute asynchronous requests in the client runtime (see
   * {@code org.glassfish.jersey.client.ClientAsyncExecutor}).
   * <p>
   * A default value is not set.
   * <p>
   * The name of the configuration property is <tt>{@value}</tt>.
   */
  public static final String ASYNC_THREADPOOL_SIZE = "jersey.config.client.async.threadPoolSize";
  /**
   * If {@code org.glassfish.jersey.client.filter.EncodingFilter} is registered,
   * this property indicates the value of Content-Encoding property the filter
   * should be adding.
   * <p>
   * The value MUST be an instance of {@code String}.
   * <p>
   * The default value is {@code null}.
   * <p>
   * The name of the configuration property is <tt>{@value}</tt>.
   */
  public static final String USE_ENCODING = "jersey.config.client.useEncoding";
  /**
   * If {@code true}, the strict validation of HTTP specification compliance
   * will be suppressed.
   * <p>
   * By default, Jersey client runtime performs certain HTTP compliance checks
   * (such as which HTTP methods can facilitate non-empty request entities etc.)
   * in order to fail fast with an exception when user tries to establish a
   * communication non-compliant with HTTP specification. Users who need to
   * override these compliance checks and avoid the exceptions being thrown by
   * Jersey client runtime for some reason, can set this property to
   * {@code true}. As a result, the compliance issues will be merely reported in
   * a log and no exceptions will be thrown.
   * <p>
   * Note that the property suppresses the Jersey layer exceptions. Chances are
   * that the non-compliant behavior will cause different set of exceptions
   * being raised in the underlying I/O connector layer.
   * <p>
   * This property can be configured in a client runtime configuration or
   * directly on an individual request. In case of conflict, request-specific
   * property value takes precedence over value configured in the runtime
   * configuration.
   * <p>
   * The default value is {@code false}.
   * <p>
   * The name of the configuration property is <tt>{@value}</tt>.
   *
   * @since 2.2
   */
  public static final String SUPPRESS_HTTP_COMPLIANCE_VALIDATION = "jersey.config.client.suppressHttpComplianceValidation";
  /**
   * The property defines the size of digest cache in the
   * {@code org.glassfish.jersey.client.authentication.HttpAuthenticationFeature#digest()}
   * digest filter}. Cache contains authentication schemes for different request
   * URIs.
   * <p>
   * The value MUST be an instance of {@code java.lang.Integer} and it must be
   * higher or equal to 1.
   * <p>
   * The default value is {@code 1000}.
   * <p>
   * The name of the configuration property is <tt>{@value}</tt>.
   *
   * @since 2.3
   */
  public static final String DIGESTAUTH_URI_CACHE_SIZELIMIT = "jersey.config.client.digestAuthUriCacheSizeLimit";
  // TODO Need to implement support for PROXY-* properties in other connectors
  /**
   * The property defines a URI of a HTTP proxy the client connector should use.
   * <p>
   * If the port component of the URI is absent then a default port of
   * {@code 8080} is assumed. If the property absent then no proxy will be
   * utilized.
   *
   * @since 2.5
   */
  public static final String PROXY_URI = "jersey.config.client.proxy.uri";
  /**
   * The property defines a user name which will be used for HTTP proxy
   * authentication.
   * <p>
   * The property is ignored if no {@code #PROXY_URI HTTP proxy URI} has been
   * set. If the property absent then no proxy authentication will be utilized.
   *
   * @since 2.5
   */
  public static final String PROXY_USERNAME = "jersey.config.client.proxy.username";
  /**
   * The property defines a user password which will be used for HTTP proxy
   * authentication.
   * <p>
   * The property is ignored if no {@code #PROXY_URI HTTP proxy URI} has been
   * set. If the property absent then no proxy authentication will be utilized.
   *
   * @since 2.5
   */
  public static final String PROXY_PASSWORD = "jersey.config.client.proxy.password";
  /**
   * The property specified how the entity should be serialized to the output
   * stream by the {@code org.glassfish.jersey.client.spi.Connector connector};
   * if the buffering should be used or the entity is streamed in chunked
   * encoding.
   * <p>
   * The value MUST be an instance of {@code String} or an enum value
   * {@code RequestEntityProcessing} in the case of programmatic definition of
   * the property. Allowed values are:
   * <ul>
   * <li><b>{@code BUFFERED}</b>: the entity will be buffered and content length
   * will be send in Content-length header.</li>
   * <li><b>{@code CHUNKED}</b>: chunked encoding will be used and entity will
   * be streamed.</li>
   * </ul>
   * Default value is {@code CHUNKED}. However, due to limitations some
   * connectors can define different default value (usually if the chunked
   * encoding cannot be properly supported on the {@code Connector}). This
   * detail should be specified in the javadoc of particular connector. For
   * example, {@code HttpUrlConnector} use buffering as the default mode.
   * <p>
   * The name of the configuration property is <tt>{@value}</tt>.
   *
   * @since 2.5
   */
  public static final String REQUEST_ENTITY_PROCESSING = "jersey.config.client.request.entity.processing";

}
