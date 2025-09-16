package org.sismo.infogram.views.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.sismo.infogram.R;
import org.sismo.infogram.adapters.CardViewAdapter;
import org.sismo.infogram.models.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //toolbar
        showToolbar(getString(R.string.title_home_fragment), false, view);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        CardViewAdapter cardViewAdapter = new CardViewAdapter(buildImages(), R.layout.cardview_image, getActivity());
        recyclerView.setAdapter(cardViewAdapter);

        return view;
    }
    public void showToolbar(String titulo, boolean botonSubir, View view) {
        Toolbar toolbar = view.findViewById(R.id.toolbar); //vincula clase con el toolbar definido en xml
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(titulo);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(botonSubir); // ver anotacion
    }

    public List<Image> buildImages() {
        List<Image> images = new ArrayList<>();
        images.add(new Image("https://boliviatravelsite.com/Images/Attractionphotos/samaipata-001.jpg", "Carlos Valdivia", "2 días", "1 me gusta"));
        images.add(new Image("https://www.exoticca.com/_next/image?url=https%3A%2F%2Fuploads.exoticca.com%2Fglobal%2Fdestination%2Fpoi%2Fsalar-uyuni.png&w=1080&q=75", "Carlo Valdez", "3 días", "3 me gusta"));
        images.add(new Image("file:///android_asset/images_cv/chochis.jpg", "Carla Valverde", "1 días", "4 me gusta"));
        images.add(new Image("file:///android_asset/images_cv/cholet.jpg", "Carola Valdiviezo", "4 días", "3 me gusta"));
        images.add(new Image("file:///android_asset/images_cv/lp2.jpg", "Carl Valderás", "3 días", "2 me gusta"));
        images.add(new Image("file:///android_asset/images_cv/sorata_.jpg", "Carmin Valentín", "7 días", "4 me gusta"));
        images.add(new Image("file:///android_asset/images_cv/vallegrande.jpg", "Caleb Vaude", "2 días", "1 me gusta"));
        images.add(new Image("file:///android_asset/images_cv/viaje_lp.jpeg", "Cartola Valerio", "1 días", "6 me gusta"));
        images.add(new Image("file:///android_asset/images_cv/en_lp.jpg", "Carina Vals", "2 días", "8 me gusta"));

        return images;
    }
}