import { AppLanguage } from '@capacitor-trancee/app-language';

window.testEcho = () => {
    const inputValue = document.getElementById("echoInput").value;
    AppLanguage.echo({ value: inputValue })
}
