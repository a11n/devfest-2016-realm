package gdg.devfest.passwordmanager.view;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import gdg.devfest.passwordmanager.R;

public class CustomFieldDialog extends DialogFragment {
  private static final String TITLE = "TITLE";
  private static final String NAME = "NAME";
  private static final String VALUE = "VALUE";

  private OnCustomFieldSubmitListener customFieldSubmitListener;
  private OnCustomFieldDeleteListener customFieldDeleteListener;

  public static CustomFieldDialog newInstance(String title, String name, String value,
      OnCustomFieldSubmitListener customFieldSubmitListener,
      OnCustomFieldDeleteListener customFieldDeleteListener) {
    CustomFieldDialog fragment = new CustomFieldDialog();

    //TODO: Pass via bundle
    fragment.customFieldSubmitListener = customFieldSubmitListener;
    fragment.customFieldDeleteListener = customFieldDeleteListener;

    Bundle arguments = new Bundle();
    arguments.putString(TITLE, title);
    arguments.putString(NAME, name);
    arguments.putString(VALUE, value);
    fragment.setArguments(arguments);

    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setRetainInstance(true);
  }

  @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
    String title = getArguments().getString(TITLE);
    String name = getArguments().getString(NAME);
    String value = getArguments().getString(VALUE);

    View view = LayoutInflater.from(getContext()).inflate(R.layout.custom_field_dialog, null);
    EditText etName = ((EditText) view.findViewById(R.id.etName));
    EditText etValue = ((EditText) view.findViewById(R.id.etValue));

    etName.setText(name);
    etValue.setText(value);

    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity()).setTitle(title)
        .setView(view)
        .setPositiveButton("OK",
            (dialog1, which) -> handleOk(etName.getText().toString(), etValue.getText().toString()))
        .setNegativeButton("Cancel", null)
        .setCancelable(true);

    if (customFieldDeleteListener != null) {
      builder.setNeutralButton("Delete", (dialog1, which) -> handleDelete());
    }

    return builder.create();
  }

  private void handleOk(String name, String value) {
    if (customFieldSubmitListener != null) customFieldSubmitListener.submit(name, value);
  }

  private void handleDelete() {
    customFieldDeleteListener.delete();
  }

  public interface OnCustomFieldSubmitListener {
    void submit(String name, String value);
  }

  public interface OnCustomFieldDeleteListener {
    void delete();
  }
}
