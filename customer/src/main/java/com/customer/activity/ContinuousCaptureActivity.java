package com.customer.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.common.pojo.ContractRequest;
import com.common.pojo.params.ResultModel;
import com.common.pojo.result.ContractAddingResult;
import com.common.runnables.MessageToast;
import com.common.runnables.ResponseMessageToast;
import com.common.utils.GsonUtil;
import com.common.utils.HtmlUtil;
import com.common.utils.HttpApiUtil;
import com.common.utils.L;
import com.customer.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.android.BeepManager;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.journeyapps.barcodescanner.DefaultDecoderFactory;
import com.common.base.BaseActivity;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static com.customer.R.id.textView;

/**
 * This sample performs continuous scanning, displaying the barcode and source image whenever
 * a barcode is scanned.
 */
public class ContinuousCaptureActivity extends BaseActivity {
    private static final String TAG = ContinuousCaptureActivity.class.getSimpleName();
    private DecoratedBarcodeView barcodeView;
    private BeepManager beepManager;
    private TextView textView;
    private String lastText;

    private BarcodeCallback callback = new BarcodeCallback() {
        @Override
        public void barcodeResult(BarcodeResult result) {
            if (result.getText() == null || result.getText().equals(lastText)) {
                return;
            }
            lastText = result.getText();
            L.d(TAG, lastText);

//                验真
            HttpApiUtil.productCodeVerify(lastText,
                    getUserApplication().getUserVo().getIndividual().getId(),
                    new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {

                    try{
                        final ResultModel resultResponseModel =
                                GsonUtil.fromResponse(response, ResultModel.class);
                        if (resultResponseModel.getCode().compareTo("200") == 0) {

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    textView.setText(resultResponseModel.getMessage());
                                }
                            });

                        } else {
                            runOnUiThread(new MessageToast(ContinuousCaptureActivity.this,
                                    resultResponseModel.getMessage()));
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

            });
            beepManager.playBeepSoundAndVibrate();
        }

        @Override
        public void possibleResultPoints(List<ResultPoint> resultPoints) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.continuous_scan);

        barcodeView = (DecoratedBarcodeView) findViewById(R.id.barcode_scanner);
        Collection<BarcodeFormat> formats = Arrays.asList(BarcodeFormat.QR_CODE, BarcodeFormat.CODE_39);
        barcodeView.getBarcodeView().setDecoderFactory(new DefaultDecoderFactory(formats));
        barcodeView.decodeContinuous(callback);

        textView = (TextView) findViewById(R.id.countTextView);

        beepManager = new BeepManager(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

        barcodeView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();

        barcodeView.pause();
    }

    public void pause(View view) {
        barcodeView.pause();
    }

    public void resume(View view) {
        barcodeView.resume();
    }

    public void triggerScan(View view) {
        barcodeView.decodeSingle(callback);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return barcodeView.onKeyDown(keyCode, event) || super.onKeyDown(keyCode, event);
    }

}
