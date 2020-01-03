import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

Ahora = new Date()

TextoFinal = '\nEjecución Creación Solicitud Completa\n'

TextoFinal = (TextoFinal + '************************************\n')

TextoFinal = ((TextoFinal + 'Inicio: ') + Ahora)

WebUI.openBrowser(GlobalVariable.URL)

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.waitForPageLoad(10)

//WebUI.click(findTestObject('Object Repository/Page_MisSSSPendientes - Mesa de Servicios/button_Toggle navigation'))
TextoFinal = (TextoFinal + '\nSeleccionamos opción Crear Solicitud Completa')

WebUI.click(findTestObject('Page_MisSSSPendientes - Mesa de Servicios/p_Crear SSS Completa'))

TextoFinal = (TextoFinal + '\nSe llenan los campos del formulario')

WebUI.click(findTestObject('Page_CrearSSSComp - Mesa de Servicios/input_Solicitante (email)_SolicitanteEmail'))

WebUI.setText(findTestObject('Page_CrearSSSComp - Mesa de Servicios/input_Solicitante (email)_SolicitanteEmail'), 'eherreral@socovesa.cl')

WebUI.sendKeys(findTestObject('Page_CrearSSSComp - Mesa de Servicios/input_Solicitante (email)_SolicitanteEmail'), Keys.chord(
        Keys.DOWN, Keys.ENTER))

WebUI.selectOptionByValue(findTestObject('Page_CrearSSSComp - Mesa de Servicios/select_Seleccione EmpresaAlmagroCSCICSAICSA_768436'), 
    '13', true)

if (GlobalVariable.ErrorCorreoExterno) {
    TextoFinal = (((TextoFinal + '\nIngresamos el correo de técnico: ') + GlobalVariable.CorreoAsignado) + ', que no pertenece al Sistema')
} else {
    TextoFinal = (((TextoFinal + '\nIngresamos el correo de técnico: ') + GlobalVariable.CorreoAsignado) + ', que es un usuario del Sistema')
}

WebUI.click(findTestObject('Page_CrearSSSComp - Mesa de Servicios/input_Tcnico (email)_AsignadoAEmail'))

WebUI.sendKeys(findTestObject('Page_CrearSSSComp - Mesa de Servicios/input_Tcnico (email)_AsignadoAEmail'), Keys.chord(Keys.DELETE))

WebUI.setText(findTestObject('Page_CrearSSSComp - Mesa de Servicios/input_Tcnico (email)_AsignadoAEmail'), GlobalVariable.CorreoAsignado)

WebUI.click(findTestObject('Page_CrearSSSComp - Mesa de Servicios/select_AgendadaAsignadaEn ProcesoEscaladaEs_419e8d'))

WebUI.selectOptionByValue(findTestObject('Page_CrearSSSComp - Mesa de Servicios/select_AgendadaAsignadaEn ProcesoEscaladaEs_419e8d'), 
    '8', true)

WebUI.click(findTestObject('Page_CrearSSSComp - Mesa de Servicios/select_Seleccione TipoApoyo TcnicoCadaCada _05c53f'))

WebUI.selectOptionByValue(findTestObject('Page_CrearSSSComp - Mesa de Servicios/select_Seleccione TipoApoyo TcnicoCadaCada _05c53f'), 
    '4', true)

WebUI.click(findTestObject('Page_CrearSSSComp - Mesa de Servicios/select_Seleccione CategoraAntivirusAplicaci_c5a911'))

WebUI.selectOptionByValue(findTestObject('Page_CrearSSSComp - Mesa de Servicios/select_Seleccione CategoraAntivirusAplicaci_c5a911'), 
    '26', true)

WebUI.click(findTestObject('Page_CrearSSSComp - Mesa de Servicios/textarea_Descripcin_Descripcion'))

WebUI.setText(findTestObject('Page_CrearSSSComp - Mesa de Servicios/textarea_Descripcin_Descripcion'), 'descrip')

TextoFinal = (TextoFinal + '\nSe presiona botón Crear Solicitud')

WebUI.click(findTestObject('Page_CrearSSSComp - Mesa de Servicios/button_Crear Solicitud'))

if (GlobalVariable.ErrorCorreoExterno) {
    WebUI.click(findTestObject('Page_CrearSSSComp - Mesa de Servicios/span_El correo debe pertenecer a un usuario'))

    ErrorUsrAsignado = WebUI.getText(findTestObject('Object Repository/Page_CrearSSSComp - Mesa de Servicios/span_El correo debe pertenecer a un usuario'))

    if (ErrorUsrAsignado.equalsIgnoreCase('El correo debe pertenecer a un usuario')) {
        TextoFinal = (TextoFinal + '\nError: El correo debe pertenecer a un usuario.')

        TextoFinal = (TextoFinal + '\nSolicitud no creada.')

        Ahora = new Date()

        TextoFinal = ((TextoFinal + '\nTérmino: ') + Ahora)

        println(TextoFinal)

        WebUI.closeBrowser()

        throw StepErrorException('Error: ' + ErrorUsrAsignado)
    }
}

if (!(GlobalVariable.ErrorCorreoExterno)) {
    if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_ModificarSSS - Mesa de Servicios/div_Mostrando 1 a 1 de 1 registros'), 
        20)) {
        TextoFinal = (TextoFinal + '\nSolicitud creada correctamente')
    } else {
        Ahora = new Date()

        TextoFinal = (TextoFinal + '\nError: Solicitud no creada')

        println(TextoFinal)

        WebUI.closeBrowser()

        throw StepErrorException('Error: Solicitud no creada')
    }
}

WebUI.closeBrowser()

Ahora = new Date()

TextoFinal = (((TextoFinal + '\nTérmino: ') + Ahora) + '\n')

println(TextoFinal)

