using System;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace Ejercicio7Movil
{
    public partial class App : Application
    {
        public App()
        {
            InitializeComponent();

            MainPage = new MeuPage();
        }

        protected override void OnStart()
        {
        }

        protected override void OnSleep()
        {
        }

        protected override void OnResume()
        {
        }
    }
}
