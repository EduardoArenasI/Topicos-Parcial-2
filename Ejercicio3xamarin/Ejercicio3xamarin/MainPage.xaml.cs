using System;
using System.Collections.Generic;
using System.ComponentModel;
using Ejercicio6.Interface;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace Ejercicio6
{
    public partial class MainPage : ContentPage
    {
        public MainPage()
        {
            InitializeComponent();
        }

        private async void btn_guardar_Clicked (object sender, EventArgs e)
        {

            if(String.IsNullOrWhiteSpace(txt_entrada.Text))
            {
                await DisplayAlert("Alerta", "No puedes guardar notas vacias", "OK");
            }
            else
            {
                var contenido = txt_entrada.Text;
                var result = await DisplayPromptAsync("Nombre", "Como se va a llamar tu nota?");

                if (String.IsNullOrWhiteSpace(result))
                {
                    await DisplayAlert("Alerta", "No puedes guardar notas sin nombre", "OK");
                }
                else
                {
                    if (DependencyService.Get<ServicioArchivo>().CrearArchivo(contenido, result) == true)
                    {
                        await DisplayAlert("Alerta", "Archivo guardado correctamente", "OK");
                        txt_entrada.Text = "";
                    }
                    else
                    {
                        await DisplayAlert("Alerta", "Ya existe una nota con ese nombre", "OK");
                    }
                }        
            }
        }

        private async void btn_borrar_Clicked(object sender, EventArgs e)
        {

            var nombreBorrar = await DisplayPromptAsync("Nombre", "Como se llama la nota que quieres borrar?");

            if(DependencyService.Get<ServicioArchivo>().BorrarArchivo(nombreBorrar) == true)
            {
                await DisplayAlert("Alerta", "El archivo " + nombreBorrar + ".txt se borró correctamente", "OK");
            }
            else
            {
                await DisplayAlert("Alerta", "No existe un archivo con ese nombre", "OK");
            }

        }
    }
}