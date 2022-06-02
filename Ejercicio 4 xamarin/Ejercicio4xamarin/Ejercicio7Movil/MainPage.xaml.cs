using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;
using System.IO;

namespace Ejercicio7Movil
{
    public partial class MainPage : ContentPage
    {
        string _filename = Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData), "notas.txt");
        public MainPage()
        {
            InitializeComponent();
        }
        private void Button_Clicked(object sender, EventArgs e)
        {
            if(File.Exists(_filename)) 
            {
                File.Delete(_filename);
            }
            entrada.Text = string.Empty;
        }
        private void Button_Clicked_1(object sender, EventArgs e)
        {
            File.WriteAllText(_filename, entrada.Text);
        }
    }
}
