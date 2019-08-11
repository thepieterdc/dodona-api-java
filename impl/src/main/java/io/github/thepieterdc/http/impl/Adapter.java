/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 */
package io.github.thepieterdc.http.impl;

import java.net.HttpURLConnection;
import java.util.function.Consumer;

/**
 * Modifies connections.
 */
@FunctionalInterface
interface Adapter extends Consumer<HttpURLConnection> {

}
