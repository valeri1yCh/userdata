package org.bloodwyn.userdata.data


/**
 * Transform DTO clases between data layers
 */
interface Transformer<T, R> {

    /**
     * Transform DTO t to r
     */
    fun transform(t: T): R
}