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

TextoFinal = '\nEjecución Prueba Mantenedor Subcategoría\n'

TextoFinal = (TextoFinal + '************************************\n')

TextoFinal = ((TextoFinal + 'Inicio: ') + Ahora)

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('http://crmiis:8085/')

WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('Page_MisSSSPendientes - Mesa de Servicios/a_settings                                 _5df4e9'))

TextoFinal = (TextoFinal + '\nSeleccionamos opción Gestionar Subcategorías')

WebUI.click(findTestObject('Object Repository/Page_MisSSSPendientes - Mesa de Servicios/a_Gestionar Subcategoras'))

TextoFinal = (TextoFinal + '\nBuscamos en la tabla dinámica que no exista ninguna Subcategoría que contenga el texto "katalon"')

WebUI.click(findTestObject('Object Repository/Page_GestionarSubCategorias - Mesa de Servicios/input'))

WebUI.setText(findTestObject('Object Repository/Page_GestionarSubCategorias - Mesa de Servicios/input'), 'katalon')

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

TextoFinal = (TextoFinal + '\nIngresamos una nueva Subcategoría')

WebUI.click(findTestObject('Object Repository/Page_GestionarSubCategorias - Mesa de Servicios/a_playlist_add Nueva SubCategora'))

TextoFinal = (TextoFinal + '\nIngresamos el nombre de la Subcategoría: "subcategoria prueba katalon"')

WebUI.click(findTestObject('Object Repository/Page_CrearEditarSubCategoria - Mesa de Servicios/input_Subcategora_subCategoriaDescr'))

WebUI.setText(findTestObject('Object Repository/Page_CrearEditarSubCategoria - Mesa de Servicios/input_Subcategora_subCategoriaDescr'), 
    'subcategoria prueba katalon')

TextoFinal = (TextoFinal + '\nSeleccionamos una categoría asociada"')

WebUI.click(findTestObject('Object Repository/Page_CrearEditarSubCategoria - Mesa de Servicios/select_Seleccione CategoraRedTerminal Serve_4e78b2'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_CrearEditarSubCategoria - Mesa de Servicios/select_Seleccione CategoraRedTerminal Serve_4e78b2'), 
    '1', true)

TextoFinal = (TextoFinal + '\nGuardamos')

WebUI.click(findTestObject('Object Repository/Page_CrearEditarSubCategoria - Mesa de Servicios/button_save Guardar'))

textoTabla = WebUI.getText(findTestObject('Object Repository/Page_CrearEditarSubCategoria - Mesa de Servicios/div_Subcategora Solicitud Agregada Correctamente'))

if (textoTabla.contains('Solicitud Agregada Correctamente')) {
    TextoFinal = (TextoFinal + '\nEl mensaje de Subcategoría Solicitud Agregada Correctamente se muestra de acuerdo a lo esperado')
} else {
    TextoFinal = (TextoFinal + '\nNo se despliega el mensaje esperado de que la subcategoría fue agregada correctamente')

    throw StepErrorException('Error: Revisar por qué no se despliega el mensaje esperado')
    
    Ahora = new Date()

    TextoFinal = ((TextoFinal + '\nTérmino: ') + Ahora)

    println(TextoFinal)

    WebUI.closeBrowser()
}

TextoFinal = (TextoFinal + '\nLuego de la inserción, corroboramos que la SubCategoría se haya guardado correctamente en la BD')

CustomKeywords.'mantenedorCategoria.corroborarInsersion.connectDB'('SQL2008JT', 'SoporteICSA_qa', '1433', 'tickets', 'Socovesa.2011')
GlobalVariable.query = "select SubCategoriaId from SubCategoria where Descr = 'subcategoria prueba katalon'";
CustomKeywords.'mantenedorCategoria.corroborarInsersion.GetID'()

if( Integer.valueOf(GlobalVariable.id) > 0){
	TextoFinal = ((TextoFinal + '\nEl ID de la subcategoría es el: ') + GlobalVariable.id.toString())
}else{
	throw StepErrorException('Error: La subcategoría no se insertó en la BD')
	Ahora = new Date()
	TextoFinal = ((TextoFinal + '\nTérmino: ') + Ahora)
	println(TextoFinal)
	WebUI.closeBrowser()
}



TextoFinal = (TextoFinal + '\nModificamos el nombre de la subcategoría por "modificacion subcategoria katalon"')

WebUI.click(findTestObject('Object Repository/Page_CrearEditarSubCategoria - Mesa de Servicios/input_Subcategora_subCategoriaDescr'))

WebUI.setText(findTestObject('Object Repository/Page_CrearEditarSubCategoria - Mesa de Servicios/input_Subcategora_subCategoriaDescr'), 
    'modificacion subcategoria katalon')

TextoFinal = (TextoFinal + '\nCambiamos la categoría asociada a la subcategoría')

WebUI.click(findTestObject('Object Repository/Page_CrearEditarSubCategoria - Mesa de Servicios/select_Seleccione CategoraRedTerminal Serve_4e78b2'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_CrearEditarSubCategoria - Mesa de Servicios/select_Seleccione CategoraRedTerminal Serve_4e78b2'), 
    '2', true)

TextoFinal = (TextoFinal + '\nGuardamos')

WebUI.click(findTestObject('Object Repository/Page_CrearEditarSubCategoria - Mesa de Servicios/button_save Guardar'))

textoTabla = WebUI.getText(findTestObject('Object Repository/Page_CrearEditarSubCategoria - Mesa de Servicios/div_Subcategora Solicitud Actualizada Corre_c4338a'))

if (textoTabla.contains('Solicitud Actualizada Correctamente')) {
    TextoFinal = (TextoFinal + '\nEl mensaje de Subcategoría Solicitud Actualizada Correctamente se muestra de acuerdo a lo esperado')
} else {
    TextoFinal = (TextoFinal + '\nNo se despliega el mensaje esperado de que la subcategoría fue actualizada correctamente')

    throw StepErrorException('Error: Revisar por qué no se despliega el mensaje esperado')
    
    Ahora = new Date()

    TextoFinal = ((TextoFinal + '\nTérmino: ') + Ahora)

    println(TextoFinal)

    WebUI.closeBrowser()
}

TextoFinal = (((TextoFinal + '\nLuego de guardar, corroboramos que la subcategoría de ID: ') + GlobalVariable.id) + ' tenga el nombre actualizado en la BD')

GlobalVariable.query = "select Descr from SubCategoria where SubCategoriaId = "+GlobalVariable.id;
CustomKeywords.'mantenedorCategoria.corroborarInsersion.GetNombre'()

if (GlobalVariable.nombreResultado.equals('modificacion subcategoria katalon')) {
	TextoFinal = (TextoFinal + '\nEl nombre de la subcategoría en la BD coincide con el nombre que modificamos: "modificacion subcategoria katalon"')
}else{
	throw StepErrorException('Error: No se encuentran coincidencias con el nombre modificado de la subcategoría')
	Ahora = new Date()
	TextoFinal = ((TextoFinal + '\nTérmino: ') + Ahora)
	println(TextoFinal)
	WebUI.closeBrowser()
}


TextoFinal = (TextoFinal + '\nEliminamos la subcategoría creada')

WebUI.click(findTestObject('Object Repository/Page_CrearEditarSubCategoria - Mesa de Servicios/a_delete_forever Eliminar'))

textoTabla = WebUI.getText(findTestObject('Object Repository/Page_CrearEditarCategoria - Mesa de Servicios/div_Subcategora con ID 635 eliminada correctamente'))

if (textoTabla.contains('eliminada correctamente')) {
    TextoFinal = (TextoFinal + '\nEl mensaje de Subcategoría Solicitud Eliminada Correctamente se muestra de acuerdo a lo esperado')
} else {
    TextoFinal = (TextoFinal + '\nNo se despliega el mensaje esperado de que la subcategoría fue eliminada correctamente')

    throw StepErrorException('Error: Revisar por qué no se despliega el mensaje esperado')
    
    Ahora = new Date()

    TextoFinal = ((TextoFinal + '\nTérmino: ') + Ahora)

    println(TextoFinal)

    WebUI.closeBrowser()
}

TextoFinal = (TextoFinal + '\nBuscamos en la tabla dinámica que no exista la subcategoría que acabamos de crear')

WebUI.click(findTestObject('Page_MisSSSPendientes - Mesa de Servicios/a_settings                                 _5df4e9'))

WebUI.click(findTestObject('Object Repository/Page_MisSSSPendientes - Mesa de Servicios/a_Gestionar Subcategoras'))

WebUI.click(findTestObject('Object Repository/Page_GestionarSubCategorias - Mesa de Servicios/input'))

WebUI.setText(findTestObject('Object Repository/Page_GestionarSubCategorias - Mesa de Servicios/input'), 'katalon')

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

TextoFinal = (TextoFinal + '\nRevisamos en la BD para corroborar que la subcategoría haya sido eliminada')
GlobalVariable.query = "select Descr from SubCategoria where SubCategoriaId = "+GlobalVariable.id;
CustomKeywords.'mantenedorCategoria.corroborarInsersion.GetNombre'()

if (GlobalVariable.nombreResultado.equals('')) {
	TextoFinal = (TextoFinal + '\nLa subcategoría fue eliminada con éxito')
}else{
	
	throw StepErrorException('Error: La subcategoría no fue eliminada')
	
	Ahora = new Date()

	TextoFinal = ((TextoFinal + '\nTérmino: ') + Ahora)

	println(TextoFinal)

	WebUI.closeBrowser()
}

Ahora = new Date()

TextoFinal = (((TextoFinal + '\nTérmino: ') + Ahora) + '\n')

println(TextoFinal)

WebUI.closeBrowser()