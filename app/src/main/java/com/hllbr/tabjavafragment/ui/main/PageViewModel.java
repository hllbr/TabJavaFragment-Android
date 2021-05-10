package com.hllbr.tabjavafragment.ui.main;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class PageViewModel extends ViewModel {
private MutableLiveData<String> nameInput = new MutableLiveData<>();
/**
 * Burada tek yapmama gereken bir setter bir getter metodları inşa etme
 */
public void setName(String name) {
    nameInput.setValue(name);
}

public LiveData<String> getName(){
    return nameInput ;
}
/**MutableLiveData objesinin nasıl oluşrutulduğunu bilmemiz gerekiyor.
 *
 */

}