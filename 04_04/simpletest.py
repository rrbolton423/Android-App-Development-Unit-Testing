# Imports the monkeyrunner modules
from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice, MonkeyImage

# Alert the user a MonkeyRunner script is about to execute
MonkeyRunner.alert("Monkeyrunner about to execute","Monkeyrunner","OK")

# Connects to the current emulator
emulator= MonkeyRunner.waitForConnection()

# Install the Android app package and test package
emulator.installPackage('C:\\Users\\James White\\Desktop\\Exercise Files\\04_02\\04_02_end\\app\\build\\outputs\\apk\\app-debug-unaligned.apk')
emulator.installPackage('C:\\Users\\James White\\Desktop\\Exercise Files\\04_02\\04_02_end\\app\\build\\outputs\\apk\\app-debug-androidTest-unaligned.apk')

# sets a variable with the package's internal name
package = 'com.mycompany.example.myapplication'

# sets a variable with the name of an Activity in the package
activity = 'com.mycompany.example.myapplication.MainActivity'

# sets the name of the component to start
runComponent = package + '/' + activity

# Runs the component
emulator.startActivity(runComponent)

# wait for the screen to fully come up
MonkeyRunner.sleep(2.0)

# Takes a screenshot
snapshot = emulator.takeSnapshot()

# Writes the screenshot to a file
snapshot.writeToFile('mainactivity.png','png')

# Alert the user a testing is about to be run by MonkeyRunner
MonkeyRunner.alert("Instrumented test about to execute","Monkeyrunner","OK")

#kick off the instrumented test
emulator.shell('am instrument -w com.mycompany.example.myapplication.test/android.support.test.runner.AndroidJUnitRunner')

# return to the emulator home screen
emulator.press('KEYCODE_HOME','DOWN_AND_UP')


