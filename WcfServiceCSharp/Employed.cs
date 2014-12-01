using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
//mongo ref
using MongoDB.Bson;
using MongoDB.Driver;

namespace WcfServiceCSharp
{
    public class Employed
    {
        public ObjectId Id { get; set; }

        public string Nombre { get; set; }

        public string Depto { get; set; }

        public string Rut { get; set; }
    }
}
