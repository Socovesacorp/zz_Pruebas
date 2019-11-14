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

WebUI.openBrowser('')

WebUI.maximizeWindow()

Ahora = new Date()
TextoFinal = '\nEjecución Creación Solicitud Rápida\n'
TextoFinal = TextoFinal + '************************************\n'
TextoFinal = TextoFinal + 'Inicio: ' + Ahora

WebUI.navigateToUrl('http://crmiis:8085')

//WebUI.click(findTestObject('Page_MisSSSPendientes - Mesa de Servicios/button_Toggle navigation'))
WebUI.waitForPageLoad(11)

TextoFinal = TextoFinal + '\nSeleccionamos opción Crear Solicitud Rápida'
WebUI.click(findTestObject('Object Repository/Page_MisSSSPendientes - Mesa de Servicios/p_Crear SSS Rpido'))

TextoFinal = TextoFinal + '\nSe llenan los campos del formulario'

WebUI.click(findTestObject('Object Repository/Page_CrearSSS - Mesa de Servicios/input_Solicitante (email)_SolicitanteEmail'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/Page_CrearSSS - Mesa de Servicios/input_Solicitante (email)_SolicitanteEmail'), 'eherreral@socovesa.cl')

WebUI.sendKeys(findTestObject('Object Repository/Page_CrearSSS - Mesa de Servicios/input_Solicitante (email)_SolicitanteEmail'), Keys.chord(Keys.DOWN, Keys.ENTER))

if (GlobalVariable.ErrorCorreoExterno) {
	TextoFinal = TextoFinal + '\nIngresamos el correo de técnico: ' + GlobalVariable.CorreoAsignado + ', que no pertenece al Sistema'
}else{
	TextoFinal = TextoFinal + '\nIngresamos el correo de técnico: ' + GlobalVariable.CorreoAsignado + ', que es un usuario del Sistema'
}


WebUI.click(findTestObject('Object Repository/Page_CrearSSS - Mesa de Servicios/input_Tcnico (email)_AsignadoAEmail'))

WebUI.sendKeys(findTestObject('Object Repository/Page_CrearSSS - Mesa de Servicios/input_Tcnico (email)_AsignadoAEmail'), 
    Keys.chord(Keys.DELETE))

WebUI.setText(findTestObject('Object Repository/Page_CrearSSS - Mesa de Servicios/input_Tcnico (email)_AsignadoAEmail'), 
    GlobalVariable.CorreoAsignado)

WebUI.click(findTestObject('Object Repository/Page_CrearSSS - Mesa de Servicios/select_AgendadaAsignadaEn ProcesoEscaladaEs_7eeecf'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_CrearSSS - Mesa de Servicios/select_AgendadaAsignadaEn ProcesoEscaladaEs_7eeecf'), '10', true)

WebUI.click(findTestObject('Object Repository/Page_CrearSSS - Mesa de Servicios/select_Seleccione TipoApoyo TcnicoCadaCada _05c53f'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_CrearSSS - Mesa de Servicios/select_Seleccione TipoApoyo TcnicoCadaCada _05c53f'), '21', true)

WebUI.click(findTestObject('Object Repository/Page_CrearSSS - Mesa de Servicios/textarea_Descripcin_Descripcion'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/Page_CrearSSS - Mesa de Servicios/textarea_Descripcin_Descripcion'), 'desc')

TextoFinal = TextoFinal + '\nSe presiona botón Crear Solicitud'
WebUI.click(findTestObject('Object Repository/Page_CrearSSS - Mesa de Servicios/button_Crear Solicitud'))

if (GlobalVariable.ErrorCorreoExterno) {
    WebUI.click(findTestObject('Object Repository/Page_CrearSSS - Mesa de Servicios/span_El correo debe pertenecer a un usuario'))

    ErrorUsrAsignado = WebUI.getText(findTestObject('Object Repository/Page_CrearSSS - Mesa de Servicios/span_El correo debe pertenecer a un usuario'))

    if (ErrorUsrAsignado.equalsIgnoreCase('El correo debe pertenecer a un usuario')) {
		TextoFinal = TextoFinal + '\nError: El correo debe pertenecer a un usuario.'
		TextoFinal = TextoFinal + '\nSolicitud no creada.'
		Ahora = new Date()
		TextoFinal = TextoFinal + '\nTérmino: ' + Ahora
		println(TextoFinal)
		WebUI.closeBrowser()
        throw StepErrorException('Error: ' + ErrorUsrAsignado)
    }
}

if (!(GlobalVariable.ErrorCorreoExterno)) {
    if (WebUI.waitForElementVisible(findTestObject('Page_ModificarSSS - Mesa de Servicios/div_Mostrando 1 a 1 de 1 registros'), 
        20)) {
        TextoFinal = TextoFinal + '\nSolicitud creada correctamente'
    } else {
		Ahora = new Date()
		TextoFinal = TextoFinal + '\nError: Solicitud no creada'
		println(TextoFinal)
		WebUI.closeBrowser()
        throw StepErrorException('Error: Solicitud no creada')
    }
}

WebUI.closeBrowser()
Ahora = new Date()
TextoFinal = TextoFinal + '\nTérmino: ' + Ahora + '\n'
println(TextoFinal)

