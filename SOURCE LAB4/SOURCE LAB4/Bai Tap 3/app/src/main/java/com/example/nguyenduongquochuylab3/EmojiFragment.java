package com.example.nguyenduongquochuylab3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmojiFragment extends Fragment implements EmojiAdapter.OnEmojiClick {

    private final String[] SOURCE = new String[]{
            "😌","😎","😡","😂","😍",
            "😜","😱","😴","🙂","😢"
    };

    private EmojiAdapter adapter;
    private String[] current = new String[9];

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_emoji, container, false);
        RecyclerView rv = v.findViewById(R.id.rvEmoji);
        rv.setLayoutManager(new GridLayoutManager(getContext(), 3));
        current = pick9();
        adapter = new EmojiAdapter(current, this);
        rv.setAdapter(adapter);
        return v;
    }

    public void randomize() {
        current = pick9();
        adapter.setData(current);
    }

    private String[] pick9() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, SOURCE);
        Collections.shuffle(list);
        String[] out = new String[9];
        for (int i = 0; i < 9; i++) out[i] = list.get(i);
        return out;
    }

    @Override
    public void onClick(String emoji) {
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).showEmojiToast(emoji);
        }
    }
}
