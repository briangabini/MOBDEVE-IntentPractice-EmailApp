package com.mobdeve.tighee.emailapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.mobdeve.tighee.emailapplication.databinding.ActivityEmailDetailsBinding
import kotlin.math.E

class EmailDetailsActivity : AppCompatActivity() {

    // Static keys for email intent data
    companion object {
        const val RECEIVER_KEY = "RECEIVER_KEY"
        const val SUBJECT_KEY = "SUBJECT_KEY"
        const val BODY_KEY = "BODY_KEY"
        const val POSITION_KEY = "POSITION_KEY"
    }

    // No class-level variables for views since we're using ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize ViewBinding for the EmailDetailsActivity
        val viewBinding : ActivityEmailDetailsBinding = ActivityEmailDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        /*  TODO:
         *      1. Get intent coming from the launcher via the Adapter
         *      2. Extract information (receiver, subject, body) + position from Intent
         *      3. Set TextViews with the appropriate data received
         *      NOTE: Make sure to store the position in case we need to send it back for deletion.
         *            For the sender, you can hard code it as "From: me"
         * */

        // 1. Get intent coming from the launcher via the Adapter
        val intent: Intent = intent

        // 2. Extract information (receiver, subject, body) + position from Intent
        val receiver: String = intent.getStringExtra(EmailDetailsActivity.RECEIVER_KEY)!!
        val subject: String = intent.getStringExtra(EmailDetailsActivity.SUBJECT_KEY)!!
        val body: String = intent.getStringExtra(EmailDetailsActivity.BODY_KEY)!!

        // 3. Set TextViews with the appropriate data received
        viewBinding.emailSenderTv.text = "From: me"
        viewBinding.emailReceiverTv.text = "To: " + receiver
        viewBinding.emailSubjectTv.text = subject
        viewBinding.emailBodyTv.text = body

        // store position
        val position = intent.getIntExtra(EmailDetailsActivity.POSITION_KEY, 0)

        // Set logic of delete button
        viewBinding.deleteIbtn.setOnClickListener(View.OnClickListener {
                /*  TODO:
                 *      1. Declare a new Intent
                 *      2. Place the position into the Intent
                 *      3. Set the result as OK passing the intent
                 *      4. Properly finish the activity
                 *      NOTE: We're passing back the position as we need to know what to delete in
                 *            our data / ArrayList
                 * */

            // 1. Declare a new Intent
            val intent : Intent = Intent()

            // 2. Place the position into the Intent
            intent.apply {
                putExtra(EmailDetailsActivity.POSITION_KEY, position)
            }

            // 3. Set the result as OK passing the intent
            setResult(RESULT_OK, intent)

            // 4. Properly finish the activity
            finish()

        })
    }
}