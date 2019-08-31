package com.jieandata.utils.common;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.*;

import com.jieandata.utils.constant.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.util.CollectionUtils;
import com.yunrich.monster.common.constants.WebConstants;

/**
 * created by yangyebo 2018/4/26 下午2:06
 */
@Slf4j
@SuppressWarnings("deprecation")
public abstract class HttpClientUtils {
	
	private static final int DEFAULT_TIME_OUT_MILLISECONDS = 5000;
	
	private static SSLConnectionSocketFactory sslsf = null;
    private static PoolingHttpClientConnectionManager cm = null;
    private static SSLContextBuilder builder = null;
    static {
        try {
            builder = new SSLContextBuilder();
            // 全部信任 不做身份鉴定
            builder.loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    return true;
                }
            });
            sslsf = new SSLConnectionSocketFactory(builder.build(), new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.2"}, null, NoopHostnameVerifier.INSTANCE);
            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register(WebConstants.HTTP_PROTOCOL_SCHEME, new PlainConnectionSocketFactory())
                    .register(WebConstants.HTTPS_PROTOCOL_SCHEME, sslsf)
                    .build();
            cm = new PoolingHttpClientConnectionManager(registry);
            cm.setMaxTotal(200);//max connection
        } catch (Exception e) {
        	log.error("", e);
        }
    }

	public static byte[] doHttpPhotoContent(String photoUrl) {
		try {
			HttpClient client = new DefaultHttpClient();

			HttpGet request = new HttpGet(photoUrl);

			HttpResponse response = client.execute(request);

			/** 请求发送成功，并得到响应 **/
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				return EntityUtils.toByteArray(response.getEntity());
			}
		} catch (IOException ex) {
			log.error("获取图片信息失败", ex);
		}

		return null;
	}
	
	public static String doHttpPostJsonApplication(String postUrl, String jsonParam, String charset) {
		Map<String, String> header = new HashMap<String, String>();
		header.put("idsp-protocol-version", "2.0.0");
		return doHttpPostJsonApplication(postUrl, jsonParam, charset, header);
	}
	
	public static String doHttpPostJsonApplication(String postUrl, String jsonParam, String charset, Map<String, String> header) {
		log.info(" json:" + jsonParam + " 地址:" + postUrl);
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpPost httpPost = new HttpPost(postUrl);
			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(DEFAULT_TIME_OUT_MILLISECONDS).build();
			httpPost.setConfig(requestConfig);
			httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");//默认的Header
			
			if (header != null && !header.isEmpty()) {
				for (String key : header.keySet()) {
					httpPost.setHeader(key, header.get(key));
				}
			}
			httpPost.setEntity(new StringEntity(jsonParam, charset));
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
				public String handleResponse(final HttpResponse response) throws IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= HttpStatus.SC_OK && status < HttpStatus.SC_MULTIPLE_CHOICES) {
						HttpEntity entity = response.getEntity();
						return entity != null ? EntityUtils.toString(entity) : null;
					} else {
						throw new ClientProtocolException("Unexpected response status: " + status);
					}
				}
			};
			return httpclient.execute(httpPost, responseHandler);
		} catch (Exception ex) {
			log.error("请求发生异常", ex);
			throw new RuntimeException("Post请求发生系统异常");
		} finally {
			try {
				httpclient.close();
			} catch (Exception ex) {
				log.error("关闭httpclient发生异常", ex);
			}
		}
	}
	
	public static String doHttpsPostJsonApplication(String postUrl, String jsonParam, String charset) {
		return doHttpsPostJsonApplication(postUrl, jsonParam, charset, null);
	}
	
	public static String doHttpsPostJsonApplication(String postUrl, String jsonParam, String charset, Map<String, String> header) {
		log.info(" json:" + jsonParam + " 地址:" + postUrl);
		HttpClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try {
			httpClient = acceptsUntrustedCertsHttpClient();
			httpPost = new HttpPost(postUrl);
			StringEntity entity = new StringEntity(jsonParam, charset);
			httpPost.setEntity(entity);
			httpPost.setConfig(RequestConfig.custom().setConnectTimeout(DEFAULT_TIME_OUT_MILLISECONDS).build());
			if (!CollectionUtils.isEmpty(header)) {
				for (String key : header.keySet()) {
					httpPost.setHeader(key, header.get(key));
				}
			}
			HttpResponse response = httpClient.execute(httpPost);
			if (response != null) {
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					result = EntityUtils.toString(resEntity, charset);
				}
			}
		} catch (Exception e) {
			log.error("https post json请求时异常", e);
		}
		return result;
	}
	
	private static CloseableHttpClient acceptsUntrustedCertsHttpClient() throws Exception {
		HttpClientBuilder b = HttpClientBuilder.create();
		SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
			@Override
			public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
				return true;
			}
		}).build();
		b.setSslcontext(sslContext);
		HostnameVerifier hostnameVerifier = NoopHostnameVerifier.INSTANCE;
		SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext, hostnameVerifier);
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
				.register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", sslSocketFactory).build();
		PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
		b.setConnectionManager(connMgr);
		CloseableHttpClient client = b.build();
		return client;
	}
	
	/**
	 * 请求Http协议地址
	 * @param postUrl 地址
	 * @param requestParams 请求参数
	 * @param charset 字符编码集
	 * @param timeout 超时时间
	 * @return
	 * @throws RuntimeException
	 */
	@SuppressWarnings("resource")
	public static String doHttpPost(String postUrl, Map<String, String> requestParams, String charset, int timeout) throws RuntimeException {
		StringBuilder sb = new StringBuilder();
		for (String key : requestParams.keySet()) {
			sb.append(key + "=" + requestParams.get(key) + " ");
		}
		log.info("参数：" + sb + "地址：" + postUrl);
		HttpClient httpClient = new DefaultHttpClient();
		try {
			HttpPost httpPost = new HttpPost(postUrl);
			List<NameValuePair> formParams = convert2NameValuePair(requestParams);
			if (!CollectionUtils.isEmpty(formParams)) {
				httpPost.setEntity(new UrlEncodedFormEntity(formParams, charset));
			}
			httpClient.getParams().setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, timeout);
			HttpEntity entity = httpClient.execute(httpPost).getEntity();
			String responseContent = null;
			if (entity != null) {
				responseContent = EntityUtils.toString(entity, charset);
				entity.consumeContent();
			}
			return responseContent;
		} catch (UnsupportedEncodingException unsuEx) {
			log.error("请求http发生UnsupportedEncodingException异常", postUrl, unsuEx);
			throw new RuntimeException("发生异常：UnsupportedEncodingException");
		} catch (ClientProtocolException clPrEx) {
			log.error("请求http发生ClientProtocolException异常", postUrl, clPrEx);
			throw new RuntimeException("发生异常：ClientProtocolException");
		} catch (IOException ioEx) {
			log.error("请求http发生IOException异常", postUrl, ioEx);
			throw new RuntimeException("发生异常：IOException");
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
	}
	
	/**
	* 请求Https协议地址
	* 
	* <a href="http://blog.csdn.net/jadyer/article/details/7802139">使用HttpClient向HTTPS地址发送POST请求</a>
	* 
	* @param postUrl 地址
	* @param requestParams 请求参数
	* @param charset 字符编码集
	* @param timeout 超时时间
	* @return
	* @throws RuntimeException
	*/
	@SuppressWarnings("resource")
	public static String doHttpsPost(String postUrl, Map<String, String> requestParams, String charset, int timeout, String spi) throws RuntimeException {
		StringBuilder sb = new StringBuilder();
		for (String key : requestParams.keySet()) {
			sb.append(key + "=" + requestParams.get(key) + " ");
		}
		log.info("参数：" + sb + "地址：" + postUrl);
		HttpClient httpClient = new DefaultHttpClient();
		try {
			SSLContext ctx = SSLContext.getInstance(spi);
			ctx.init(null, new TrustManager[] { new HttpsX509TrustManager() }, null);
			SSLSocketFactory sslSocketFactory = new SSLSocketFactory(ctx);
			httpClient.getConnectionManager().getSchemeRegistry()
					.register(new Scheme(WebConstants.HTTPS_PROTOCOL_SCHEME, sslSocketFactory, WebConstants.DEFAULT_PORT_NUMBER_FOR_HTTPS));
			HttpPost httpPost = new HttpPost(postUrl);
			List<NameValuePair> formParams = convert2NameValuePair(requestParams);
			if (!CollectionUtils.isEmpty(formParams)) {
				httpPost.setEntity(new UrlEncodedFormEntity(formParams, charset));
			}
			httpClient.getParams().setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, timeout);
			//HttpEntity entity = null;
			HttpEntity entity = httpClient.execute(httpPost).getEntity();
			String responseContent = null;
			if (entity != null) {
				responseContent = EntityUtils.toString(entity, charset);
				entity.consumeContent();
			}
			return responseContent;
		} catch (NoSuchAlgorithmException noSuex) {
			log.error("请求https发生NoSuchAlgorithmException异常", postUrl, noSuex);
			throw new RuntimeException("发生异常：NoSuchAlgorithmException");
		} catch (KeyManagementException keyMaEx) {
			log.error("请求https发生KeyManagementException异常", postUrl, keyMaEx);
			throw new RuntimeException("发生异常：NoSuchAlgorithmException");
		} catch (UnsupportedEncodingException unsuEx) {
			log.error("请求https发生UnsupportedEncodingException异常", postUrl, unsuEx);
			throw new RuntimeException("发生异常：UnsupportedEncodingException");
		} catch (ClientProtocolException clPrEx) {
			log.error("请求https发生ClientProtocolException异常", postUrl, clPrEx);
			throw new RuntimeException("发生异常：ClientProtocolException");
		} catch (IOException ioEx) {
			log.error("请求https发生IOException异常", postUrl, ioEx);
			throw new RuntimeException("发生异常：IOException");
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
	}
	
	private static class HttpsX509TrustManager implements X509TrustManager {
		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			//不校验服务器端证书，什么都不做，视为通过检查
		}
		
		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			//不校验服务器端证书，什么都不做，视为通过检查
		}
		
		public X509Certificate[] getAcceptedIssuers() {
			return new X509Certificate[] {};
		}
	}
	
	private static List<NameValuePair> convert2NameValuePair(Map<String, String> requestParams) {
		if (requestParams == null || requestParams.isEmpty()) {
			return null;
		}
		List<NameValuePair> formParams = new ArrayList<NameValuePair>();
		for (Map.Entry<String, String> entry : requestParams.entrySet()) {
			formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		return formParams;
	}
	
	public static String doPost(String postUrl, Map<String, String> requestParams) throws RuntimeException {
		if (postUrl.startsWith(WebConstants.HTTPS_PROTOCOL_SCHEME)) {
			return doHttpsPost(postUrl, requestParams);
		}
		if (postUrl.startsWith(WebConstants.HTTP_PROTOCOL_SCHEME)) {
			return doHttpPost(postUrl, requestParams);
		}
		log.warn("系统不支持的网络访问协议: ", postUrl);
		throw new RuntimeException("不支持的协议类型: " + postUrl);
	}
	
	public static String doHttpPost(String postUrl, Map<String, String> requestParams) throws RuntimeException {
		return doHttpPost(postUrl, requestParams, Constants.UTF8, DEFAULT_TIME_OUT_MILLISECONDS);
	}
	
	public static String doHttpsPost(String postUrl, Map<String, String> requestParams) throws RuntimeException {
		return doHttpsPost(postUrl, requestParams, Constants.UTF8, DEFAULT_TIME_OUT_MILLISECONDS,SSLSocketFactory.TLS);
	}
	
	public static String doHttpGet(String url, Map<String, String> args) {
		String ret = StringUtils.EMPTY;
		BufferedReader in = null;
		try {
			StringBuilder sb = new StringBuilder(url + "?");
			for (String s : args.keySet()) {
				sb.append(s + "=" + args.get(s) + "&");
			}
			URL realUrl = new URL(sb.deleteCharAt(sb.length() - 1).toString());
			URLConnection connection = realUrl.openConnection();
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.connect();
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				ret += line;
			}
		} catch (Exception e) {
			log.error("发送get请求出错！", e);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e) {
				log.error("关闭BufferedReader出错", e);
			}
		}
		return ret;
	}

	public static String doHttpGet(String url, Map<String, String> args, Map<String, String> header) {
		String ret = StringUtils.EMPTY;
		BufferedReader in = null;
		try {
			StringBuilder sb = new StringBuilder(url + "?");
			for (String s : args.keySet()) {
				sb.append(s + "=" + args.get(s) + "&");
			}
			URL realUrl = new URL(sb.deleteCharAt(sb.length() - 1).toString());
			URLConnection connection = realUrl.openConnection();
			for (String s : header.keySet()) {
				connection.setRequestProperty(s, header.get(s));
			}
			connection.connect();
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				ret += line;
			}
		} catch (Exception e) {
			log.error("发送get请求出错！", e);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e) {
				log.error("关闭BufferedReader出错", e);
			}
		}
		return ret;
	}


	public static String doHttpsGet(String url, Map<String, String> args, Map<String, String> header){
		String ret = StringUtils.EMPTY;
		BufferedReader in = null;
		try {
			StringBuilder sb = new StringBuilder(url + "?");
			for (String s : args.keySet()) {
				sb.append(s + "=" + args.get(s) + "&");
			}
			URL serverUrl = new URL(sb.deleteCharAt(sb.length() - 1).toString());

			SSLContext sslcontext = SSLContext.getInstance("SSL","SunJSSE");
			sslcontext.init(null, new TrustManager[]{new HttpsX509TrustManager()}, new java.security.SecureRandom());
			HttpsURLConnection conn = (HttpsURLConnection) serverUrl.openConnection();
			conn.setSSLSocketFactory(sslcontext.getSocketFactory());
			conn.setRequestMethod("GET");
			for (String s : header.keySet()) {
				conn.setRequestProperty(s, header.get(s));
			}
			//必须设置false，否则会自动redirect到重定向后的地址
			conn.setInstanceFollowRedirects(false);
			conn.connect();
			StringBuffer buffer = new StringBuffer();
			//将返回的输入流转换成字符串
			InputStream inputStream = conn.getInputStream();
			in = new BufferedReader(new InputStreamReader(inputStream, Constants.UTF8));
			String str = null;
			while ((str = in.readLine()) != null) {
				buffer.append(str);
			}
			ret = buffer.toString();
		} catch (Exception e) {
			log.error("发送https get请求出错！", e);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e) {
				log.error("关闭BufferedReader出错", e);
			}
		}
		return ret;
	}

	//HttpPost带参数的发文件的方法
	public static String postFile(String url, Map<String, String> files, Map<String, String> str, Map<String, String> header, String boundary) {
		MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create().setCharset(Consts.UTF_8).setLaxMode();
		if (StringUtils.isNotBlank(boundary)) {
			multipartEntityBuilder.setBoundary(boundary);
		}
		ContentType contextType = ContentType.create("text/plain", Consts.UTF_8);
		if (!CollectionUtils.isEmpty(files)) {
			for (String fileName : files.keySet()) {
				multipartEntityBuilder.addBinaryBody(fileName, new File(files.get(fileName)));
			}
		}
		if (!CollectionUtils.isEmpty(str)) {
			for (String key : str.keySet()) {
				multipartEntityBuilder.addTextBody(key, StringUtils.trimToEmpty(str.get(key)), contextType);
			}
		}
		HttpPost httpPost = new HttpPost(url);
		if (!CollectionUtils.isEmpty(header)) {
			for (String key : header.keySet()) {
				httpPost.addHeader(key, header.get(key));
			}
		}
		httpPost.setEntity(multipartEntityBuilder.build());
		HttpEntity httpEntity = null;
		String ret = null;
		try {
			httpEntity = HttpClients.createDefault().execute(httpPost).getEntity();
			ret = EntityUtils.toString(httpEntity);
			EntityUtils.consume(httpEntity);
		} catch (IOException e) {
			log.error("IO出错！", e);
		}
		return ret;
	}
	//---------------lianrun
	/**
	 * 
	 * @param postUrl
	 * @param requestParams
	 * @param charset
	 * @param timeout
	 * @param spi
	 * @return
	 * @throws RuntimeException
	 */
	@SuppressWarnings("resource")
	public static String doHttpsPost2(String postUrl, Map<String, String> requestParams, String charset, int timeout, String spi) throws RuntimeException {
		StringBuilder sb = new StringBuilder();
		for (String key : requestParams.keySet()) {
			sb.append(key + "=" + requestParams.get(key) + " ");
		}
		log.info("参数：" + sb + "地址：" + postUrl);
		HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
		try {
			httpClient = new DefaultHttpClient();
			SSLContext ctx = SSLContext.getInstance(spi);
			ctx.init(null, new TrustManager[]{ new HttpsX509TrustManager() }, null);
	        SSLSocketFactory ssf = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
	        ClientConnectionManager ccm = httpClient.getConnectionManager();
	        SchemeRegistry sr = ccm.getSchemeRegistry();
	        sr.register(new Scheme(WebConstants.HTTPS_PROTOCOL_SCHEME, 443, ssf));
            httpPost = new HttpPost(postUrl);
            List<NameValuePair> formParams = convert2NameValuePair(requestParams);
			if (!CollectionUtils.isEmpty(formParams)) {
				httpPost.setEntity(new UrlEncodedFormEntity(formParams, charset));
			}
			httpClient.getParams().setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, timeout);
            HttpResponse response = httpClient.execute(httpPost);
            if(response != null){
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    result = EntityUtils.toString(resEntity,charset);
                }
            }
    		return result;
		} catch (NoSuchAlgorithmException noSuex) {
			log.error("请求https发生NoSuchAlgorithmException异常", postUrl, noSuex);
			throw new RuntimeException("发生异常：NoSuchAlgorithmException");
		} catch (KeyManagementException keyMaEx) {
			log.error("请求https发生KeyManagementException异常", postUrl, keyMaEx);
			throw new RuntimeException("发生异常：NoSuchAlgorithmException");
		} catch (UnsupportedEncodingException unsuEx) {
			log.error( "请求https发生UnsupportedEncodingException异常", postUrl, unsuEx);
			throw new RuntimeException("发生异常：UnsupportedEncodingException");
		} catch (ClientProtocolException clPrEx) {
			log.error("请求https发生ClientProtocolException异常", postUrl, clPrEx);
			throw new RuntimeException("发生异常：ClientProtocolException");
		} catch (IOException ioEx) {
			log.error("请求https发生IOException异常", postUrl, ioEx);
			throw new RuntimeException("发生异常：IOException");
		} catch (Exception e) {
			log.error("请求https发生Exception异常", postUrl, e);
			throw new RuntimeException("发生异常：Exception");
		} finally {
			if(null != httpClient){
				httpClient.getConnectionManager().shutdown();
			}
		}
	}
	
	public static CloseableHttpClient getCloseableHttpClient() throws Exception {
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .setConnectionManager(cm)
                .setConnectionManagerShared(true)
                .build();
        return httpClient;
    }
}