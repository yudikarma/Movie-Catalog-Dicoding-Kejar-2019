package com.yudikarma.moviecatalogsubmision2.di.module;

import androidx.lifecycle.ViewModel;
import dagger.MapKey;
import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@MapKey
@interface ViewModelKey {
    Class<? extends ViewModel> value();
}
