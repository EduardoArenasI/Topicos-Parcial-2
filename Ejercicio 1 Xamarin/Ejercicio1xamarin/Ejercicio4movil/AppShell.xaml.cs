using Ejercicio4movil.ViewModels;
using Ejercicio4movil.Views;
using System;
using System.Collections.Generic;
using Xamarin.Forms;

namespace Ejercicio4movil
{
    public partial class AppShell : Xamarin.Forms.Shell
    {
        public AppShell()
        {
            InitializeComponent();
            Routing.RegisterRoute(nameof(ItemDetailPage), typeof(ItemDetailPage));
            Routing.RegisterRoute(nameof(NewItemPage), typeof(NewItemPage));
        }

    }
}
