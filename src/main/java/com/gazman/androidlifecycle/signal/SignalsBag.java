// =================================================================================================
//	Life Cycle Framework for native android
//	Copyright 2014 Ilya Gazman. All Rights Reserved.
//
//	This is not free software. You can redistribute and/or modify it
//	in accordance with the terms of the accompanying license agreement.
//  http://gazman-sdk.com/license/
// =================================================================================================
package com.gazman.androidlifecycle.signal;

import java.util.HashMap;

/**
 * Created by Ilya Gazman on 2/24/2015.
 */
public final class SignalsBag {

    static HashMap<Class<?>, Signal> map = new HashMap<>();

    private SignalsBag() {}

    /**
     * Will get you a signal from the given interface type, there will be only one instance of it in the system
     * @param type the signal type
     * @return Signal from given type
     */
    public static <T> Signal<T> inject(Class<T> type) {
        @SuppressWarnings("unchecked")
        Signal<T> signal = map.get(type);
        if (signal == null) {
            signal = new Signal<T>(type);
            map.put(type, signal);
        }
        return signal;
    }

    /**
     * Create new signal from given type
     * @param type the interface type
     * @return Signal from given type
     */
    public static <T> Signal<T> create(Class<T> type) {
        //noinspection unchecked
        return new Signal(type);
    }

}
