package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Velocity
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.bluetooth.BluetoothControllerTEST
import com.example.myapplication.bluetooth.XboxJoystickSender
import com.example.myapplication.databinding.MainWindowBinding

private const val DEBUG_TAG = "Gestures"

@SuppressLint("MissingPermission", "ClickableViewAccessibility")
@RequiresApi(Build.VERSION_CODES.P)
class MainActivity : ComponentActivity(){
    lateinit var binding: MainWindowBinding

    private var sender : XboxJoystickSender? = null

    private lateinit var mDetector: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainWindowBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        binding.imageButtonA.setOnTouchListener { v, event ->
            when (event?.action) {
                MotionEvent.ACTION_DOWN -> {
                    sender?.JoystickReport?.setButtonState(1, true)
                    sender?.JoystickReport?.setButtonState(5, true)
                    sender?.JoystickReport?.setButtonState(7, true)
                }

                MotionEvent.ACTION_UP -> {
                    sender?.JoystickReport?.setButtonState(1, false)
                    sender?.JoystickReport?.setButtonState(5, false)
                    sender?.JoystickReport?.setButtonState(7, false)
                }
            }


            sender?.sendReport()
            v?.onTouchEvent(event) ?: true
        }

        binding.SettingsButton.setOnClickListener {
            openSettings()
        }

        mDetector = GestureDetector(this, GestureListener())
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (mDetector.onTouchEvent(event)) {
            true
        } else {
            super.onTouchEvent(event)
        }
    }

    public override fun onStart() {
        super.onStart()
        BluetoothControllerTEST.init(this)

        BluetoothControllerTEST.getSender { hidd, device ->
            val mainHandler = Handler(this.mainLooper)

            mainHandler.post(object : Runnable{
                override fun run() {
                    sender = XboxJoystickSender(hidd,device)



                }
            })
        }
    }

    public override fun onPause() {
        super.onPause()
    }

    public override fun onStop() {
        super.onStop()
        BluetoothControllerTEST.btHid?.unregisterApp()

        BluetoothControllerTEST.hostDevice=null
        BluetoothControllerTEST.btHid=null
    }

    fun openSettings() {
        startActivity(Intent(this,SettingsActivity::class.java))
    }

    inner class GestureListener : GestureDetector.SimpleOnGestureListener() {

        override fun onSingleTapUp(e: MotionEvent): Boolean {
            Log.i("GestureStatus","onSingleTapUp")
            return true
        }

        override fun onLongPress(e: MotionEvent) {
            Log.i("GestureStatus","onLongPress")
            finish()
        }

        override fun onDoubleTap(e: MotionEvent): Boolean {
            Log.i("GestureStatus","onDoubleTap")
            return true
        }

        override fun onDoubleTapEvent(e: MotionEvent): Boolean {
            Log.i("GestureStatus","onDoubleTapEvent")
            return true
        }

        override fun onDown(e: MotionEvent): Boolean {
            Log.i("GestureStatus","onDown")
            return true
        }

        override fun onShowPress(e: MotionEvent) {
            Log.i("GestureStatus","onShowPress")
        }

        override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
            Log.i("GestureStatus","onSingleTapConfirmed")
            return true
        }

        override fun onFling(
            e1: MotionEvent?,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            Log.i("GestureStatus_onFling","onFling velocityX:$velocityX velocityY:$velocityY")
            if(velocityY > 2000 && (velocityX < 1000 && velocityX > -1000))
            {
                openSettings()
            }
            return true
        }

        override fun onScroll(
            e1: MotionEvent?,
            e2: MotionEvent,
            distanceX: Float,
            distanceY: Float
        ): Boolean {
            Log.i("GestureStatus","onScroll")
            return true
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}