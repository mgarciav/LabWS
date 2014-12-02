using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Threading;
using Newtonsoft.Json;  


namespace WindowsFormsApplication1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            comboBox1.SelectedIndex = 0;
            /*0 nombre
             *1 rut
             *2 departamento
             */
        }
        
        private async void buttonMongoUpdate_Click_1(object sender, EventArgs e)
        {
            try
            {
                ServiceReferenceAsync.Service1Client wsNet = new ServiceReferenceAsync.Service1Client();

                var resultado = JsonConvert.DeserializeObject<List<Employed>>(await wsNet.queryTypeDBAsync(textBox1.Text, comboBox1.SelectedIndex));

                dataGridView1.Rows.Clear();
                foreach (var elemento in resultado)
                    dataGridView1.Rows.Add(elemento.Rut, elemento.Nombre, elemento.Depto);

                textBox1.Clear();
            }
            catch (Exception exc)
            {
                MessageBox.Show("Error en consulta: Base de datos no inicializada.\n" + exc);
            }


            Console.WriteLine("hola mundo!");
        }

        private async void button2_Click(object sender, EventArgs e)
        {
            button2.Enabled = false;
            button3.Enabled = false;
            ServiceReferenceAsync.Service1Client wsNet = new ServiceReferenceAsync.Service1Client();
            if (/*textBox3.Text.Length > 0 &&
                textBox4.Text.Length > 0 &&
                textBox5.Text.Length > 0 && */
                await wsNet.addDBAsync(textBox3.Text, textBox5.Text, textBox4.Text))
                MessageBox.Show("Empleado agregado");
            else
                MessageBox.Show("Error en el guardado");
            button2.Enabled = true;
            button3.Enabled = true;
            textBox3.Clear();
            textBox4.Clear();
            textBox5.Clear();
        }

        private async void button3_Click(object sender, EventArgs e)
        {
            button2.Enabled = false;
            button3.Enabled = false;
            ServiceReferenceAsync.Service1Client wsNet = new ServiceReferenceAsync.Service1Client();
            if(await wsNet.dropDBAsync())
                MessageBox.Show("DB borrada");
            else
                MessageBox.Show("Error en la liberación");
            button2.Enabled = true;
            button3.Enabled = true;
        }

    }

    public class Employed
    {
        public string Nombre { get; set; }

        public string Depto { get; set; }

        public string Rut { get; set; }
    }
}
