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

public class EmojiFragment extends Fragment implements EmojiAdapter.OnEmojiClick {

    private final String[] EMOJIS = new String[]{
            "😌","😎","😡",
            "😂","😍","😜",
            "😱","😴","🙂"
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_emoji, container, false);
        RecyclerView rv = v.findViewById(R.id.rvEmoji);
        rv.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rv.setAdapter(new EmojiAdapter(EMOJIS, this));
        return v;
    }

    @Override
    public void onClick(String emoji) {
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).showEmojiToast(emoji);
        }
    }
}
