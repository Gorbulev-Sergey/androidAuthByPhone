# Регистрация в firebase auth через телефон

Для работы регистации через телефон нужно выполнить несколько подготовительных действий. Они описаны 
<code>[в этой статье](https://www.geeksforgeeks.org/firebase-authentication-with-phone-number-otp-in-android/)</code>.

Кроме этого нужно:  
1. В консоли firebase, к подключенному к firebaseAuth приложению, из которого будут отсылаться смс, добавить SH1 и SH254 отпечатки приложения.
2. В консоли google cloude включить для нашего приложения api Android Device Verification,  
  - где на вкладке CREDENTIALS выбрать пункт Android key (auto created by Firebase)  
  - и внутри него: выбрать Android apps для приложения,  
  - и также указать SH1 отпечаток нашего приложения (получается, уже 2-ой раз).

Тогда всё будет работать.
