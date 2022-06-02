using Ejercicio4movil.ViewModels;
using System.ComponentModel;
using Xamarin.Forms;

namespace Ejercicio4movil.Views
{
    public partial class ItemDetailPage : ContentPage
    {
        public ItemDetailPage()
        {
            InitializeComponent();
            BindingContext = new ItemDetailViewModel();
        }
    }
}