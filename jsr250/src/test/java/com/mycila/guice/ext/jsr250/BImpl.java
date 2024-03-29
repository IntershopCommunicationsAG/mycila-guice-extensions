/**
 * Copyright (C) 2010 Mycila (mathieu.carbou@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mycila.guice.ext.jsr250;

import jakarta.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Provider;

public class BImpl implements B {
    @Inject
    private Provider<A> a;

    private boolean called = false;

    @PostConstruct
    public void init() {
        a.get().callA();
    }

    @Override
    public void callB() {
        called = true;
    }

    public boolean hasBeenCalled() {
        return called;
    }
}
