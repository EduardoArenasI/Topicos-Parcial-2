using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace Ejercicio5Movil
{
    public partial class MainPage : ContentPage
    {
        public MainPage()
        {
            InitializeComponent();
        }
        int contador = 0;
        private void Button_Clicked(object sender, EventArgs e)
        {
            contador ++;
            ((Button)sender).Text = "Presioado "+  contador+" veces";
            
            
        }

        private void Button_Clicked_1(object sender, EventArgs e)
        {

        }
    }
}
