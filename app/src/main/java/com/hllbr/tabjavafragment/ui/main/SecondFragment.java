package com.hllbr.tabjavafragment.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hllbr.tabjavafragment.R;

import org.w3c.dom.Text;


public class SecondFragment extends Fragment {
    //Burada onCreate çapırmam gerekiyor.Fragment bir içerisinde gerçekleştirilen işlemleri tekrarlıyor olacağım
    PageViewModel pageViewModel;
    public  static SecondFragment newInstance(){
        //aynı Singleton yapısında kullandığımız gibi
        return  new SecondFragment();
    }//SecondFragment.newwInstance kullanıldığında yeni bir secondFragment oluştur diyorum


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //pageViewModel is need initialize
        pageViewModel = new ViewModelProvider(requireActivity()).get(PageViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Bu alanda tasarım aşamasında oluşturduğum textView getirmek istiyorum
        TextView textView = view.findViewById(R.id.textView);
        //bir önceki stringi almak için pageView üzerinden alt satırda bulunan Yapıyı Kullanıyorum

        pageViewModel.getName().observe(requireActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                //Burada bize değiştirilmiş Stringi verecektir.
                textView.setText(s);
            }
        });//observe bir değşiklik varsa bunu gözlemle demek FirstFragment içersine tanımladığımız pageView üzerinde bir değişiklik olursa bu değişiklik buraya hemen yansıtılacak
        //observe() kullanım amacı yapımız içinde bu şekilde ifade edilebilir.
        //Bizim burada observe içerisine vereceğimiz yapımız requireActivitydir.ikinci oalrak birden bir observer soracak bunuda new Observer yazarak gerçekleştirebiliriz.

    }
}