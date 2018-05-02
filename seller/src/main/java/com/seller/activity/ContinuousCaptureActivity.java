package com.seller.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.common.base.BaseActivity;
import com.common.pojo.ContractRequest;
import com.common.pojo.result.ContractAddingResult;
import com.common.runnables.ResponseMessageToast;
import com.common.utils.GsonUtil;
import com.common.utils.HtmlUtil;
import com.common.utils.HttpApiUtil;
import com.common.utils.L;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.android.BeepManager;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.journeyapps.barcodescanner.DefaultDecoderFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * This sample performs continuous scanning, displaying the barcode and source image whenever
 * a barcode is scanned.
 */
public class ContinuousCaptureActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = ContinuousCaptureActivity.class.getSimpleName();
    private DecoratedBarcodeView barcodeView;
    private BeepManager beepManager;
    private String lastText;
    private TextView countText;

    private Long contractId;

    private Set<String> codeList;

    private BarcodeCallback callback = new BarcodeCallback() {
        @Override
        public void barcodeResult(BarcodeResult result) {
            if(result.getText() == null || result.getText().equals(lastText)) {
//                 Prevent duplicate scans
//                String html = "已扫描<big>"+ codeCount +"</big>件商品<br/><font color='#ff0000'>重复扫码<font>";
//                countText.setText(HtmlUtil.fromHtml(html));
                return;
            }
            lastText = result.getText();
            L.d(TAG, lastText);

            codeList.add(lastText);
            int count = codeList.size();
            String html = "已扫描保真<font color='#ff0000'><big>"+ count +"</big></font>件商品";
            countText.setText(HtmlUtil.fromHtml(html));

            beepManager.playBeepSoundAndVibrate();
        }

        @Override
        public void possibleResultPoints(List<ResultPoint> resultPoints) {
        }
    };

    private void showCountOfCode() {
        int count = codeList.size();
        String html = "已扫描保真<font color='#ff0000'><big>"+ count +"</big></font>件商品";
        countText.setText(HtmlUtil.fromHtml(html));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.continuous_scan);

        barcodeView = (DecoratedBarcodeView) findViewById(R.id.barcode_scanner);
        Collection<BarcodeFormat> formats = Arrays.asList(BarcodeFormat.QR_CODE, BarcodeFormat.CODE_39);
        barcodeView.getBarcodeView().setDecoderFactory(new DefaultDecoderFactory(formats));
        barcodeView.decodeContinuous(callback);

        beepManager = new BeepManager(this);

        contractId = getIntent().getLongExtra(getResources().getString(R.string.contract_id_extra), 0);

        codeList = new HashSet<>();
        countText = (TextView)findViewById(R.id.countTextView);
        showCountOfCode();

        Button subBtn = (Button) findViewById(R.id.submitButton);
        subBtn.setOnClickListener(this);

        Button canBtn = (Button) findViewById(R.id.cancelButton);
        canBtn.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.submitButton) {
            submitCodes();
        }else if(id == R.id.cancelButton){
            cancelCodes();
        }
    }

    public void submitCodes(){
        ContractRequest contractRequest = new ContractRequest();
        contractRequest.setCodeList(codeList);
        HttpApiUtil.addSellContract(getUserApplication().getUserVo().getEmployee().getId(),
                contractRequest, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
//                            不可重复调用 response.body().string()
                        String ret = response.body().string();
                        L.d(TAG, ret);
                         ContractAddingResult result = GsonUtil.fromJson(ret, ContractAddingResult.class);

                        runOnUiThread(new ResponseMessageToast(result, ContinuousCaptureActivity.this));
                    }
                });
    }
    public void cancelCodes(){
        this.codeList.clear();
        showCountOfCode();
    }
}
