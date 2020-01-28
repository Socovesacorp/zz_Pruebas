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
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

Ahora = new Date()

TextoFinal = '\nEjecución Prueba Buscar Solicitudes del Solicitante\n'

TextoFinal = (TextoFinal + '************************************\n')

TextoFinal = ((TextoFinal + 'Inicio: ') + Ahora)

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.waitForPageLoad(10)

TextoFinal = (TextoFinal + '\nIngresamos correo del solicitante a filtrar')

WebUI.click(findTestObject('Object Repository/Page_- Mesa de Servicios/input_Toggle navigation_buscarsss'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/Page_- Mesa de Servicios/input_Toggle navigation_buscarsss'), GlobalVariable.CorreoAsignado)

WebUI.sendKeys(findTestObject('Object Repository/Page_- Mesa de Servicios/input_Toggle navigation_buscarsss'), Keys.chord(
        Keys.DOWN, Keys.ENTER))

TextoFinal = (TextoFinal + '\nPresionamos el botón buscar')

WebUI.click(findTestObject('Object Repository/Page_- Mesa de Servicios/i_search'))

TextoFinal = (TextoFinal + '\nValidamos el mensaje')

WebUI.click(findTestObject('Object Repository/Page_- Mesa de Servicios/p_Listado de Solicitudes totales del usuari_4f9414'))

//WebUI.click(findTestObject('Object Repository/Page_- Mesa de Servicios/div_Mostrando 1 a 24 de 24 registros'))

//WebUI.getText(findTestObject('Object Repository/Page_- Mesa de Servicios/div_Mostrando 1 a 24 de 24 registros'))

//numero = (texto.split(' ')[3])

//println('EL TEXTO ESSSS!!!!! : ' + WebUI.getText(findTestObject('Object Repository/Page_- Mesa de Servicios/div_Mostrando 1 a 24 de 24 registros')))

WebDriver driver = DriverFactory.getWebDriver()
WebElement Table = driver.findElement(By.xpath('//*[@id="tableSSS"]'))
List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
int rows_count = (rows_table.size() - 1)
TextoFinal = (TextoFinal + '\nSe muestra la siguiente cantidad de registros: '+rows_count)


TextoFinal = (TextoFinal + '\nLas solicitudes del solicitante ingresado se muestran correctamente')

TextoFinal = (TextoFinal + '\nAhora validamos que el número de solicitudes mostradas coincidan con las de la BD')

CustomKeywords.'mantenedorCategoria.corroborarInsersion.connectDB'('BdsGen2017Qa', 'Soporte_Ticket_SSS', '1433', 'UI_TICKET_SSS', 
    'Ticket.2019')
Date fechaAhora = new Date()
GlobalVariable.query = "select count(*) from Solicitud s left join EstadoSolicitud es on s.EstadoSolicitudId = es.EstadoSolicitudId left join Solicitante sol on sol.Id = s.SolicitanteId where ((es.tipo = 'final' and s.fecha_creacion > DATEADD(day, -60, Convert(date, getdate()))) or(es.tipo = 'inicial')) and sol.Email = '"+GlobalVariable.CorreoAsignado+"'"
CustomKeywords.'mantenedorCategoria.corroborarInsersion.GetID'()

if (Integer.valueOf(GlobalVariable.id) == rows_count) {
	TextoFinal = ((TextoFinal + '\nLa cantidad de registros de la tabla, coincide con la Base de Datos: ') + rows_count)
} else {
	throw StepErrorException('Los registros desplegados no coinciden con la búsqueda en la BD')
	
	Ahora = new Date()

	TextoFinal = ((TextoFinal + '\nTérmino: ') + Ahora)

	println(TextoFinal)

	WebUI.closeBrowser()
}


Ahora = new Date()

TextoFinal = (((TextoFinal + '\nTérmino: ') + Ahora) + '\n')

println(TextoFinal)

//WebUI.closeBrowser()

