package br.com.cesar.removeduplicatesonemailthread.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.cesar.removeduplicatesonemailthread.R;

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.ViewHolder> {

    private final Context context;
    private final List<String> words;

    private int positionSelected = -1;

    public EmailAdapter(Context context, List<String> words) {
        this.context = context;
        this.words = words;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final String word = words.get(position);

        holder.textViewWord.setText(word);
        holder.textViewWord.setTextColor(ContextCompat.getColor(context, positionSelected == position ? android.R.color.white : android.R.color.black));
        holder.constraintLayoutBackground.setBackgroundColor(ContextCompat.getColor(context, positionSelected == position ? android.R.color.black : android.R.color.white));

        holder.constraintLayoutBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                positionSelected = position;
                notifyDataSetChanged();
            }
        });

        holder.textViewWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                positionSelected = position;
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    public int getPositionSelected() {
        return positionSelected;
    }

    public void clearPositionSelected() {
        this.positionSelected = -1;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout constraintLayoutBackground;
        TextView textViewWord;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            constraintLayoutBackground = itemView.findViewById(R.id.constraint_layout_background);
            textViewWord = itemView.findViewById(R.id.text_view_email);
        }
    }

}
