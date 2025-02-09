package com.mobdeve.tighee.emailapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mobdeve.tighee.emailapplication.databinding.ActivityNewEmailBinding

class NewEmailActivity : AppCompatActivity() {

    // Keys for new email intent data
    companion object {
        const val NEW_RECEIVER_KEY = "NEW_RECEIVER_KEY"
        const val NEW_SUBJECT_KEY = "NEW_SUBJECT_KEY"
        const val NEW_BODY_KEY = "NEW_BODY_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize ViewBinding for NewEmailActivity
        val viewBinding : ActivityNewEmailBinding = ActivityNewEmailBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // When discarding an email, basically exit the activity by finishing the activity.
        viewBinding.discardBtn.setOnClickListener(View.OnClickListener {
                /* TODO:
                 *  1. Finish the activity
                 * */
            finish()
        })

        // Logic for "sending" an email
        viewBinding.sendBtn.setOnClickListener(View.OnClickListener {
            if (viewBinding.toEt.text.toString().isNotEmpty() && viewBinding.subjectEt.text.toString().isNotEmpty() && viewBinding.bodyEt.text.toString().isNotEmpty()) {
                /* TODO:
                 *  1. Extract information from views,
                 *  2. Place info into intent,
                 *  3. Set result and include intent, and
                 *  4. Finish the activity
                 * */
                // extract info
                val receiver = viewBinding.toEt.text.toString()
                val subject = viewBinding.subjectEt.text.toString()
                val body = viewBinding.bodyEt.text.toString()

                // Place info into intent
                val intent = Intent()
                intent.apply {
                    putExtra(NewEmailActivity.NEW_RECEIVER_KEY, receiver)
                    putExtra(NewEmailActivity.NEW_SUBJECT_KEY, subject)
                    putExtra(NewEmailActivity.NEW_BODY_KEY, body)
                }

                //  3. Set result and include intent, and
                setResult(RESULT_OK, intent)

                //  4. Finish the activity
                finish()
            } else {
                Toast.makeText(
                    this@NewEmailActivity,
                    "Please make sure all entries have text.",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
    }
}