import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

Ahora = new Date()

TextoFinal = '\nEjecución Prueba Mantenedor Categoría\n'

TextoFinal = (TextoFinal + '************************************\n')

TextoFinal = ((TextoFinal + 'Inicio: ') + Ahora)

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('Object Repository/Page_MisSSSPendientes - Mesa de Servicios/a_settings                                 _5df4e9'))

TextoFinal = (TextoFinal + '\nSeleccionamos opción Gestionar Categorías')

WebUI.click(findTestObject('Object Repository/Page_MisSSSPendientes - Mesa de Servicios/a_Gestionar Categoras'))

TextoFinal = (TextoFinal + '\nBuscamos en la tabla dinámica que no exista ninguna categoría que inicie con el texto: "categoria prueba"')

WebUI.click(findTestObject('Object Repository/Page_GestionarCategorias - Mesa de Servicios/input'))

WebUI.setText(findTestObject('Object Repository/Page_GestionarCategorias - Mesa de Servicios/input'), 'categoria prueba')

if (WebUI.verifyTextPresent('No se encontraron registros', true)) {
    TextoFinal = (TextoFinal + '\nLa tabla muestra que no se encontraron registros que coincidan con ese nombre')
} else {
    TextoFinal = (TextoFinal + '\nla tabla indica un mensaje diferente al esperado, significa que hay otro elemento con el nombre de la categoría de prueba')

    throw StepErrorException('Error: Elimine el registro con el nombre del que se utilizará en la prueba y reinicie la prueba')
    
    Ahora = new Date()

    TextoFinal = ((TextoFinal + '\nTérmino: ') + Ahora)

    println(TextoFinal)

    WebUI.closeBrowser()
}

TextoFinal = (TextoFinal + '\nIngresamos una nueva categoría')

WebUI.click(findTestObject('Object Repository/Page_GestionarCategorias - Mesa de Servicios/a_playlist_add Nueva Categora'))

TextoFinal = (TextoFinal + '\nIngresamos el nombre de la categoría: "categoria prueba katalon"')

WebUI.click(findTestObject('Object Repository/Page_CrearEditarCategoria - Mesa de Servicios/input_Categora_categoriaSolicitudDescr'))

WebUI.setText(findTestObject('Object Repository/Page_CrearEditarCategoria - Mesa de Servicios/input_Categora_categoriaSolicitudDescr'), 
    'categoria prueba katalon')

TextoFinal = (TextoFinal + '\nGuardamos')

WebUI.click(findTestObject('Object Repository/Page_CrearEditarCategoria - Mesa de Servicios/button_save Guardar'))

textoTabla = WebUI.getText(findTestObject('Object Repository/Page_CrearEditarCategoria - Mesa de Servicios/div_Categora Solicitud Agregada Correctamente'))

if (textoTabla.contains('Solicitud Agregada Correctamente')) {
    TextoFinal = (TextoFinal + '\nEl mensaje de Categoría Solicitud Agregada Correctamente se muestra de acuerdo a lo esperado')
} else {
    TextoFinal = (TextoFinal + '\nNo se despliega el mensaje esperado de que la categoría fue agregada correctamente')

    throw StepErrorException('Error: Revisar por qué no se despliega el mensaje esperado')
    
    Ahora = new Date()

    TextoFinal = ((TextoFinal + '\nTérmino: ') + Ahora)

    println(TextoFinal)

    WebUI.closeBrowser()
}

TextoFinal = (TextoFinal + '\nLuego de la inserción, corroboramos que la Categoría se haya guardado correctamente en la BD')

CustomKeywords.'mantenedorCategoria.corroborarInsersion.connectDB'('svsticket', 'SoporteICSA_prd', '1433', 'consulta', 'Socovesa.2011')

GlobalVariable.query = 'select CategoriaSolicitudId from CategoriaSolicitud where Descr = \'categoria prueba katalon\''

CustomKeywords.'mantenedorCategoria.corroborarInsersion.GetID'()

if (Integer.valueOf(GlobalVariable.id) > 0) {
    TextoFinal = ((TextoFinal + '\nEl ID de la categoría es el: ') + GlobalVariable.id.toString())
} else {
    throw StepErrorException('Error: La categoría no se insertó en la BD')
    
    Ahora = new Date()

    TextoFinal = ((TextoFinal + '\nTérmino: ') + Ahora)

    println(TextoFinal)

    WebUI.closeBrowser()
}

TextoFinal = (TextoFinal + '\nModificamos el nombre de la categoría por "modificacion categoria katalon"')

WebUI.click(findTestObject('Object Repository/Page_CrearEditarCategoria - Mesa de Servicios/input_Categora_categoriaSolicitudDescr'))

WebUI.setText(findTestObject('Object Repository/Page_CrearEditarCategoria - Mesa de Servicios/input_Categora_categoriaSolicitudDescr'), 
    'modificacion categoria katalon')

TextoFinal = (TextoFinal + '\nGuardamos')

WebUI.click(findTestObject('Object Repository/Page_CrearEditarCategoria - Mesa de Servicios/button_save Guardar'))

textoTabla = WebUI.getText(findTestObject('Object Repository/Page_CrearEditarCategoria - Mesa de Servicios/div_Categora Solicitud Actualizada Correctamente'))

if (textoTabla.contains('Solicitud Actualizada Correctamente')) {
    TextoFinal = (TextoFinal + '\nEl mensaje de Categoría Solicitud Actualizada Correctamente se muestra de acuerdo a lo esperado')
} else {
    TextoFinal = (TextoFinal + '\nNo se despliega el mensaje esperado de que la categoría fue actualizada correctamente')

    throw StepErrorException('Error: Revisar por qué no se despliega el mensaje esperado')
    
    Ahora = new Date()

    TextoFinal = ((TextoFinal + '\nTérmino: ') + Ahora)

    println(TextoFinal)

    WebUI.closeBrowser()
}

TextoFinal = (((TextoFinal + '\nLuego de guardar, corroboramos que la categoría de ID: ') + GlobalVariable.id) + ' tenga el nombre actualizado en la BD')

GlobalVariable.query = ('select Descr from CategoriaSolicitud where CategoriaSolicitudId = ' + GlobalVariable.id)

CustomKeywords.'mantenedorCategoria.corroborarInsersion.GetNombre'()

if (GlobalVariable.nombreResultado.equals('modificacion categoria katalon')) {
    TextoFinal = (TextoFinal + '\nEl nombre de la categoría en la BD coincide con el nombre que modificamos: "modificacion categoria katalon"')
} else {
    throw StepErrorException('Error: No se encuentran coincidencias con el nombre modificado de la categoría')
    
    Ahora = new Date()

    TextoFinal = ((TextoFinal + '\nTérmino: ') + Ahora)

    println(TextoFinal)

    WebUI.closeBrowser()
}

TextoFinal = (TextoFinal + '\nEliminamos la categoría creada')

WebUI.click(findTestObject('Object Repository/Page_CrearEditarCategoria - Mesa de Servicios/a_delete_forever Eliminar'))

textoTabla = WebUI.getText(findTestObject('Object Repository/Page_GestionarCategorias - Mesa de Servicios/div_Categora con ID 52 eliminada correctamente'))

if (textoTabla.contains('eliminada correctamente')) {
    TextoFinal = (TextoFinal + '\nEl mensaje de Categoría Solicitud Eliminada Correctamente se muestra de acuerdo a lo esperado')
} else {
    TextoFinal = (TextoFinal + '\nNo se despliega el mensaje esperado de que la categoría fue eliminada correctamente')

    throw StepErrorException('Error: Revisar por qué no se despliega el mensaje esperado')
    
    Ahora = new Date()

    TextoFinal = ((TextoFinal + '\nTérmino: ') + Ahora)

    println(TextoFinal)

    WebUI.closeBrowser()
}

TextoFinal = (TextoFinal + '\nBuscamos en la tabla la categoría que acabamos de eliminar')

WebUI.setText(findTestObject('Object Repository/Page_GestionarCategorias - Mesa de Servicios/input'), 'katalon')

textoTabla = WebUI.getText(findTestObject('Object Repository/Page_GestionarCategorias - Mesa de Servicios/div_Mostrando 0 a 0 de 0 registros (de un t_c12fec'))

if (textoTabla.contains('Mostrando 0 a 0 de 0 registros')) {
    TextoFinal = (TextoFinal + '\nEl mensaje de que existen 0 registros que coinciden con parte del nombre aparece según lo esperado')
} else {
    TextoFinal = (TextoFinal + '\nNo se despliega el mensaje esperado que indica que no existen registros que coincidan con el nombre')

    throw StepErrorException('Error: Revisar si el registro aparece de todas formas')
    
    Ahora = new Date()

    TextoFinal = ((TextoFinal + '\nTérmino: ') + Ahora)

    println(TextoFinal)

    WebUI.closeBrowser()
}

TextoFinal = (TextoFinal + '\nRevisamos en la BD para corroborar que la categoría haya sido eliminada')

GlobalVariable.query = ('select Descr from CategoriaSolicitud where CategoriaSolicitudId = ' + GlobalVariable.id)

CustomKeywords.'mantenedorCategoria.corroborarInsersion.GetNombre'()

if (GlobalVariable.nombreResultado.equals('')) {
    TextoFinal = (TextoFinal + '\nLa categoría fue eliminada con éxito')
} else {
    throw StepErrorException('Error: La categoría no fue eliminada')
    
    Ahora = new Date()

    TextoFinal = ((TextoFinal + '\nTérmino: ') + Ahora)

    println(TextoFinal)

    WebUI.closeBrowser()
}

Ahora = new Date()

TextoFinal = (((TextoFinal + '\nTérmino: ') + Ahora) + '\n')

println(TextoFinal)

WebUI.closeBrowser()

