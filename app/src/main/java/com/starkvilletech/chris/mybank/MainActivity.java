package com.starkvilletech.chris.mybank;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.starkvilletech.chris.accounts.BankAccount;
import com.starkvilletech.chris.accounts.SavingsAccount;


public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    EditText mAmountInput;
    Button mWithdrawButton;
    Button mDepositButton;
    TextView mAmountDisplay;
    BankAccount mCurrentAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mCurrentAccount = new SavingsAccount();

        mAmountInput = (EditText)findViewById(R.id.amount_input);
        mWithdrawButton = (Button)findViewById(R.id.withdraw_button);
        mDepositButton = (Button)findViewById(R.id.deposit_button);
        mAmountDisplay = (TextView)findViewById(R.id.balance_display);

        mWithdrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = mAmountInput.getText().toString();
                mCurrentAccount.withdraw(Double.parseDouble(amount));
                mAmountDisplay.setText("Balance is " + mCurrentAccount.getBalance());
            }
        });

        mDepositButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = mAmountInput.getText().toString();
                mCurrentAccount.deposit(Double.parseDouble(amount));
                mAmountDisplay.setText("Balance is " + mCurrentAccount.getBalance());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
