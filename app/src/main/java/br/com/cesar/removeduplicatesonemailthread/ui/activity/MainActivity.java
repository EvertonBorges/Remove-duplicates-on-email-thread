package br.com.cesar.removeduplicatesonemailthread.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import br.com.cesar.removeduplicatesonemailthread.R;
import br.com.cesar.removeduplicatesonemailthread.ui.adapter.EmailAdapter;
import br.com.cesar.removeduplicatesonemailthread.util.Utils;

public class MainActivity extends AppCompatActivity {

    private final List<String> emails = new ArrayList<>();
    private final List<String> emailsNonDuplicated = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextEmail = findViewById(R.id.edit_text_email);
        Button buttonRemoveEmail = findViewById(R.id.button_remove);
        Button buttonInsertEmail = findViewById(R.id.button_insert);
        RecyclerView recyclerViewEmails = findViewById(R.id.recycler_view_emails);

        Button buttonRemoveDuplicates = findViewById(R.id.button_remove_duplicates);
        RecyclerView recyclerViewEmailsNonDuplicated = findViewById(R.id.recycler_view_emails_without_duplicates);

        final EmailAdapter adapterEmail = new EmailAdapter(this, emails);
        final EmailAdapter adapterEmailDuplicatesRemoved = new EmailAdapter(this, emailsNonDuplicated);

        recyclerViewEmails.setAdapter(adapterEmail);
        recyclerViewEmailsNonDuplicated.setAdapter(adapterEmailDuplicatesRemoved);

        buttonInsertEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = editTextEmail.getText().toString();
                emails.add(email);
                adapterEmail.notifyDataSetChanged();
            }
        });

        buttonRemoveEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emails.remove(adapterEmail.getPositionSelected());
                adapterEmail.clearPositionSelected();
                adapterEmail.notifyDataSetChanged();
            }
        });

        buttonRemoveDuplicates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailsNonDuplicated.clear();
                emailsNonDuplicated.addAll(emails);
                Utils.removeDuplicates(emailsNonDuplicated);
                adapterEmailDuplicatesRemoved.notifyDataSetChanged();
            }
        });
    }
}
