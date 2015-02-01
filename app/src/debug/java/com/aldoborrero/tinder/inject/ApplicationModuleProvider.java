/*
 * Copyright 2015 Aldo Borrero <aldo@aldoborrero.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.aldoborrero.tinder.inject;

import com.aldoborrero.tinder.inject.modules.ApplicationModule;
import com.aldoborrero.tinder.ui.TinderApplication;

public class ApplicationModuleProvider implements ModuleProvider {

    private Object[] modules;

    private ApplicationModuleProvider(TinderApplication application) {
        modules = new Object[]{
                new ApplicationModule(application),
                //new DebugApplicationModule(application)
        };
    }

    public static ApplicationModuleProvider from(TinderApplication tinderApplication) {
        return new ApplicationModuleProvider(tinderApplication);
    }

    @Override
    public Object[] getModules() {
        return modules;
    }
    
}
