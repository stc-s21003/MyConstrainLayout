package jp.suntech.s21003.myconstrainlayout;
import  static jp.suntech.s21003.myconstrainlayout.Global.msg;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class DialogFragment extends androidx.fragment.app.DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder =new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.dialog_title);
        builder.setMessage(R.string.dialog_msg);
        builder.setPositiveButton(R.string.dialog_btn_ok,new DialogButtonClickListener());
        builder.setNegativeButton(R.string.dialog_btn_ng,new DialogButtonClickListener());
        AlertDialog dialog= builder.create();
        return  dialog;
    }
private class DialogButtonClickListener implements DialogInterface.OnClickListener{

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which){
            case DialogInterface.BUTTON_POSITIVE:
                Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
                break;
                case DialogInterface.BUTTON_NEGATIVE:
                    break;
        }

    }
}
}
