package com.business.service;

import com.business.constant.sort.SortField;
import com.business.dto.PageResponse;
import com.business.dto.request.HelloRequest;
import com.business.dto.response.HelloResponse;

public interface IHelloService {

    /**
     * Fetch Java Version
     */
    String fetchJavaVersion();

    /**
     *
     * Fetch Java Home
     */
    String fetchJavaHome();

    /**
     * Hello World
     */
    String helloWorld();

    /**
     * Get All Hello World With Page
     */
    PageResponse<HelloResponse> getAllHelloWorld(
            int page, int size,
            SortField sortBy, boolean asc
    );

    /**
     * Get Hello World By Id
     */
    HelloResponse getHelloWorldById(String id);

    /**
     *
     * Create HelloWorld
     *
     * @param helloRequest
     */
    void createHelloWorld(HelloRequest helloRequest);
}
