package blackbox.verbdrill;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class ActivityReferences extends AppCompatActivity {

    TextView arYo, arTu, arUsted, arNosotros, arUstedes,
            erYo, erTu, erUsted, erNosotros, erUstedes,
            irYo, irTu, irUsted, irNosotros, irUstedes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_references);

        // SET UP TEXTVIEWS
        arYo = (TextView) findViewById(R.id.ar_yo_tv);
        arTu = (TextView) findViewById(R.id.ar_tu_tv);
        arUsted = (TextView) findViewById(R.id.ar_usted_tv);
        arNosotros = (TextView) findViewById(R.id.ar_nosotros_tv);
        arUstedes = (TextView) findViewById(R.id.ar_ustedes_tv);
        erYo = (TextView) findViewById(R.id.er_yo_tv);
        erTu = (TextView) findViewById(R.id.er_tu_tv);
        erUsted = (TextView) findViewById(R.id.er_usted_tv);
        erNosotros = (TextView) findViewById(R.id.er_nosotros_tv);
        erUstedes = (TextView) findViewById(R.id.er_ustedes_tv);
        irYo = (TextView) findViewById(R.id.ir_yo_tv);
        irTu = (TextView) findViewById(R.id.ir_tu_tv);
        irUsted = (TextView) findViewById(R.id.ir_usted_tv);
        irNosotros = (TextView) findViewById(R.id.ir_nosotros_tv);
        irUstedes = (TextView) findViewById(R.id.ir_ustedes_tv);

        // SET UP SPINNER
        String[] tensesArray = getResources().getStringArray(R.array.tenses_array);
        ArrayAdapter<String> tensesArrayAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, tensesArray);
        Spinner tensesSpinner = (Spinner) findViewById(R.id.references_spinner);
        tensesSpinner.setAdapter(tensesArrayAdapter);
        tensesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        setToPresentIndic();
                        break;
                    case 1:
                        setToPreteriteIndic();
                        break;
                    case 2:
                        setToImperfectIndic();
                        break;
                    case 3:
                        setToFutureIndic();
                        break;
                    case 4:
                        setToPresentSubj();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
    }

    public void setToPresentIndic() {
        arYo.setText(R.string.present_indic_ar_yo);
        arTu.setText(R.string.present_indic_ar_tu);
        arUsted.setText(R.string.present_indic_ar_usted);
        arNosotros.setText(R.string.present_indic_ar_nosotros);
        arUstedes.setText(R.string.present_indic_ar_ustedes);
        erYo.setText(R.string.present_indic_er_yo);
        erTu.setText(R.string.present_indic_er_tu);
        erUsted.setText(R.string.present_indic_er_usted);
        erNosotros.setText(R.string.present_indic_er_nosotros);
        erUstedes.setText(R.string.present_indic_er_ustedes);
        irYo.setText(R.string.present_indic_ir_yo);
        irTu.setText(R.string.present_indic_ir_tu);
        irUsted.setText(R.string.present_indic_ir_usted);
        irNosotros.setText(R.string.present_indic_ir_nosotros);
        irUstedes.setText(R.string.present_indic_ir_ustedes);
    }

    public void setToPreteriteIndic() {
        arYo.setText(R.string.preterite_indic_ar_yo);
        arTu.setText(R.string.preterite_indic_ar_tu);
        arUsted.setText(R.string.preterite_indic_ar_usted);
        arNosotros.setText(R.string.preterite_indic_ar_nosotros);
        arUstedes.setText(R.string.preterite_indic_ar_ustedes);
        erYo.setText(R.string.preterite_indic_er_yo);
        erTu.setText(R.string.preterite_indic_er_tu);
        erUsted.setText(R.string.preterite_indic_er_usted);
        erNosotros.setText(R.string.preterite_indic_er_nosotros);
        erUstedes.setText(R.string.preterite_indic_er_ustedes);
        irYo.setText(R.string.preterite_indic_ir_yo);
        irTu.setText(R.string.preterite_indic_ir_tu);
        irUsted.setText(R.string.preterite_indic_ir_usted);
        irNosotros.setText(R.string.preterite_indic_ir_nosotros);
        irUstedes.setText(R.string.preterite_indic_ir_ustedes);
    }

    public void setToImperfectIndic() {
        arYo.setText(R.string.imperfect_indic_ar_yo);
        arTu.setText(R.string.imperfect_indic_ar_tu);
        arUsted.setText(R.string.imperfect_indic_ar_usted);
        arNosotros.setText(R.string.imperfect_indic_ar_nosotros);
        arUstedes.setText(R.string.imperfect_indic_ar_ustedes);
        erYo.setText(R.string.imperfect_indic_er_yo);
        erTu.setText(R.string.imperfect_indic_er_tu);
        erUsted.setText(R.string.imperfect_indic_er_usted);
        erNosotros.setText(R.string.imperfect_indic_er_nosotros);
        erUstedes.setText(R.string.imperfect_indic_er_ustedes);
        irYo.setText(R.string.imperfect_indic_ir_yo);
        irTu.setText(R.string.imperfect_indic_ir_tu);
        irUsted.setText(R.string.imperfect_indic_ir_usted);
        irNosotros.setText(R.string.imperfect_indic_ir_nosotros);
        irUstedes.setText(R.string.imperfect_indic_ir_ustedes);
    }

    public void setToFutureIndic() {
        arYo.setText(R.string.future_indic_arErIr_yo);
        arTu.setText(R.string.future_indic_arErIr_tu);
        arUsted.setText(R.string.future_indic_arErIr_usted);
        arNosotros.setText(R.string.future_indic_arErIr_nosotros);
        arUstedes.setText(R.string.future_indic_arErIr_ustedes);
        erYo.setText(R.string.future_indic_arErIr_yo);
        erTu.setText(R.string.future_indic_arErIr_tu);
        erUsted.setText(R.string.future_indic_arErIr_usted);
        erNosotros.setText(R.string.future_indic_arErIr_nosotros);
        erUstedes.setText(R.string.future_indic_arErIr_ustedes);
        irYo.setText(R.string.future_indic_arErIr_yo);
        irTu.setText(R.string.future_indic_arErIr_tu);
        irUsted.setText(R.string.future_indic_arErIr_usted);
        irNosotros.setText(R.string.future_indic_arErIr_nosotros);
        irUstedes.setText(R.string.future_indic_arErIr_ustedes);
    }

    public void setToPresentSubj() {
        arYo.setText(R.string.present_subj_ar_yo);
        arTu.setText(R.string.present_subj_ar_tu);
        arUsted.setText(R.string.present_subj_ar_usted);
        arNosotros.setText(R.string.present_subj_ar_nosotros);
        arUstedes.setText(R.string.present_subj_ar_ustedes);
        erYo.setText(R.string.present_subj_erIr_yo);
        erTu.setText(R.string.present_subj_erIr_tu);
        erUsted.setText(R.string.present_subj_erIr_usted);
        erNosotros.setText(R.string.present_subj_erIr_nosotros);
        erUstedes.setText(R.string.present_subj_erIr_ustedes);
        irYo.setText(R.string.present_subj_erIr_yo);
        irTu.setText(R.string.present_subj_erIr_tu);
        irUsted.setText(R.string.present_subj_erIr_usted);
        irNosotros.setText(R.string.present_subj_erIr_nosotros);
        irUstedes.setText(R.string.present_subj_erIr_ustedes);
    }
}
