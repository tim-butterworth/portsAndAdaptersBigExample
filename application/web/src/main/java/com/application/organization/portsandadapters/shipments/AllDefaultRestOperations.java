package com.application.organization.portsandadapters.shipments;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;

import java.net.URI;
import java.util.Map;
import java.util.Set;

public interface AllDefaultRestOperations extends RestOperations {
    @Override
    default <T> T getForObject(String url, Class<T> responseType, Object... uriVariables) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default <T> T getForObject(String url, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default <T> T getForObject(URI url, Class<T> responseType) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default <T> ResponseEntity<T> getForEntity(String url, Class<T> responseType, Object... uriVariables) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default <T> ResponseEntity<T> getForEntity(String url, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default <T> ResponseEntity<T> getForEntity(URI url, Class<T> responseType) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default HttpHeaders headForHeaders(String url, Object... uriVariables) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default HttpHeaders headForHeaders(String url, Map<String, ?> uriVariables) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default HttpHeaders headForHeaders(URI url) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default URI postForLocation(String url, Object request, Object... uriVariables) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default URI postForLocation(String url, Object request, Map<String, ?> uriVariables) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default URI postForLocation(URI url, Object request) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default <T> T postForObject(String url, Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default <T> T postForObject(String url, Object request, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default <T> T postForObject(URI url, Object request, Class<T> responseType) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default <T> ResponseEntity<T> postForEntity(String url, Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default <T> ResponseEntity<T> postForEntity(String url, Object request, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default <T> ResponseEntity<T> postForEntity(URI url, Object request, Class<T> responseType) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default void put(String url, Object request, Object... uriVariables) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default void put(String url, Object request, Map<String, ?> uriVariables) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default void put(URI url, Object request) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default <T> T patchForObject(String url, Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default <T> T patchForObject(String url, Object request, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default <T> T patchForObject(URI url, Object request, Class<T> responseType) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default void delete(String url, Object... uriVariables) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default void delete(String url, Map<String, ?> uriVariables) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default void delete(URI url) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default Set<HttpMethod> optionsForAllow(String url, Object... uriVariables) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default Set<HttpMethod> optionsForAllow(String url, Map<String, ?> uriVariables) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default Set<HttpMethod> optionsForAllow(URI url) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType, Object... uriVariables) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default <T> ResponseEntity<T> exchange(URI url, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity, ParameterizedTypeReference<T> responseType, Object... uriVariables) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity, ParameterizedTypeReference<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default <T> ResponseEntity<T> exchange(URI url, HttpMethod method, HttpEntity<?> requestEntity, ParameterizedTypeReference<T> responseType) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default <T> ResponseEntity<T> exchange(RequestEntity<?> requestEntity, Class<T> responseType) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default <T> ResponseEntity<T> exchange(RequestEntity<?> requestEntity, ParameterizedTypeReference<T> responseType) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default <T> T execute(String url, HttpMethod method, RequestCallback requestCallback, ResponseExtractor<T> responseExtractor, Object... uriVariables) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default <T> T execute(String url, HttpMethod method, RequestCallback requestCallback, ResponseExtractor<T> responseExtractor, Map<String, ?> uriVariables) throws RestClientException {
        throw new RuntimeException();
    }

    @Override
    default <T> T execute(URI url, HttpMethod method, RequestCallback requestCallback, ResponseExtractor<T> responseExtractor) throws RestClientException {
        throw new RuntimeException();
    }
}
