package cl.maskin.boleta;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BoletaHonorarios extends Activity {
	
	double bruto = 0.9, liquido = 1.1111111111111112, valor = 0, resultadoBruto = 0, resultadoLiquido = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.boleta_honorarios);
		
		
		final EditText et = (EditText) findViewById(R.id.editText1);   
		final Button btn1 = (Button) findViewById(R.id.button1);
		final Button btn2 = (Button) findViewById(R.id.button2);
		final TextView tvLiquidoHacer = (TextView) findViewById(R.id.textView4);
		final TextView tvLiquidoRecibir = (TextView) findViewById(R.id.textView6);
		final TextView tvBrutoHacer = (TextView) findViewById(R.id.textView9);
		final TextView tvBrutoRecibir = (TextView) findViewById(R.id.textView11);
		
		btn1.setOnClickListener(new View.OnClickListener() {
	        @SuppressWarnings("deprecation")
			public void onClick(View v) {
	        	
	        	String cambio = et.getText().toString();
	    		if (cambio.equals("")){ // detecta un string vacio y lo cambia por cero.
	    		    cambio = "0";
	    		}
	        	valor = Integer.parseInt(cambio);
	        	
	        	if (valor > 0){
	        		
	        		resultadoBruto = valor * bruto;
		        	resultadoLiquido = valor * liquido;
		        	
		        	tvLiquidoHacer.setText("$" + Math.round(resultadoLiquido));
		        	tvLiquidoRecibir.setText("$" + et.getText().toString());
		        	tvBrutoHacer.setText("$" + et.getText().toString());
		        	tvBrutoRecibir.setText("$" + Math.round(resultadoBruto));
	        		
	        	} else {
	        		AlertDialog alertDialog = new AlertDialog.Builder(
		        			BoletaHonorarios.this).create();
		 
					        // Setea el titulo del dialogo
					        alertDialog.setTitle("Información");
					 
					        // Setea el mensaje del dialogo
					        alertDialog.setMessage("El valor debe ser mayor que cero");
					 
					        // Setea un icono del dialogo
					        //alertDialog.setIcon(R.drawable.tick);
					 
					        // Setea el boton OK
					        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
					                public void onClick(DialogInterface dialog, int which) {
					                // Write your code here to execute after dialog closed
					                Toast.makeText(getApplicationContext(), "Intenta nuevamente :)", Toast.LENGTH_SHORT).show();
					                }
					        });
					 
					        // Muestra el dialogo
					        alertDialog.show();
					
				}
	        	
	        }
	    });
		
		btn2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				tvLiquidoHacer.setText("$000");
				tvLiquidoRecibir.setText("$000");
				tvBrutoHacer.setText("$000");
				tvBrutoRecibir.setText("$000");
				et.setText("");
				
				
			}
		});
		
		
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		  MenuInflater inflater = getMenuInflater();
		  inflater.inflate(R.menu.boleta_honorarios, menu);
		  return true;
		}

	@SuppressWarnings("deprecation")
	public boolean onOptionsItemSelected(MenuItem item) {
	      switch (item.getItemId()) {
	      case R.id.action_info:
	    	  AlertDialog alertDialog = new AlertDialog.Builder(
	        			BoletaHonorarios.this).create();
	 
				        // Setea el titulo del dialogo
				        alertDialog.setTitle("Información");
				 
				        // Setea el mensaje del dialogo
				        alertDialog.setMessage("Esta simple aplicación te ayuda a calcular los montos que debes ingresar " +
				        						"al momento de hacer una Boleta de Honorarios en el SII. " +
				        						"Te muestra valores líquidos y brutos, según hayas negociado con tu cliente." +
				        						"\n\nRealicé la aplicación con fines educactivos, para practicar y aprender más sobre Android. Si te gustó y te pareció útil, " +
				        						"recuerda calificar bien o escribirme un comentario en Google Play :)" +
				        						"\n\nMuchas gracias por descargar!");
				 
				        // Setea un icono del dialogo
				        //alertDialog.setIcon(R.drawable.tick);
				 
				        // Setea el boton OK
				        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
				                public void onClick(DialogInterface dialog, int which) {
				                // Lo que hace después de cerrar el dialogo
				                Toast.makeText(getApplicationContext(), "Espero que hagas muchas boletas :)", Toast.LENGTH_SHORT).show();
				                }
				        });
				 
				        // Muestra el dialogo
				        alertDialog.show();
	      return true;
		  case R.id.action_about:
			  AlertDialog alertDialog2 = new AlertDialog.Builder(
		        		BoletaHonorarios.this).create();
	 
				        // Setea el titulo del dialogo
				        alertDialog2.setTitle("Sobre el Autor");
				 
				        // Setea el mensaje del dialogo
				        alertDialog2.setMessage("Aplicación creada por Francisco Abarza, vivo en Concepción. " +
				        						"\nSoy diseñador gráfico y estudio ingeniería de software en la USM. " +
				        						"\n\nPuedes escribirme en Twitter, mi cuenta es @Maskin_" +
				        						"\nPuedes escribirme un correo a francisco@maskin.cl " +
				        						"\n\nAdemás busca PlanControl en Google Play, otra aplicación en que he trabajado\n\n");
				 
				        // Setea un icono del dialogo
				        //alertDialog.setIcon(R.drawable.tick);
				 
				        // Setea el boton OK
				        alertDialog2.setButton("OK", new DialogInterface.OnClickListener() {
				                public void onClick(DialogInterface dialog, int which) {
				                // Lo que hace despues de cerrar el dialogo
				                Toast.makeText(getApplicationContext(), "Espero que hagas muchas boletas :)", Toast.LENGTH_SHORT).show();
				                }
				        });
				 
				        // Muestra el dialogo
				        alertDialog2.show();
          return true;

	      default:
	            return super.onOptionsItemSelected(item);
	      }
	}

	

}
