using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
//mongo ref
using MongoDB.Bson;
using MongoDB.Driver;
//more mongo ref
using MongoDB.Driver.Builders;
using MongoDB.Driver.GridFS;
using MongoDB.Driver.Linq;  

namespace WcfServiceCSharp
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "Service1" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select Service1.svc or Service1.svc.cs at the Solution Explorer and start debugging.
    public class Service1 : IService1
    {
        private MongoClient client;
        private MongoServer server;
        private MongoDatabase database;
        private MongoCollection collection;


        public bool dropDB ()
        {
            try
            {
                conectionDB();
                database.DropCollection("entities");
                return true;
            }
            catch
            {
                return false;
            }
        }

        public bool addDB(string name, string depto, string rut)
        {
            try
            {
                conectionDB();
                collection.Insert(new Employed { Nombre = name, Depto = depto, Rut = rut });
                return true;
            }
            catch
            {
                return false;
            }

        }

        public string queryDB(string search)
        {
            conectionDB();

            var retorno = collection.FindAs<Employed>(Query<Employed>.EQ(el => el.Rut, search));

            return jsoned(retorno);

        }

        public string queryTypeDB(string search, int type)
        {
            conectionDB();

            MongoCursor<Employed> retorno = null;

            switch (type)
            {
                case 0:
                    retorno = collection.FindAs<Employed>(Query<Employed>.EQ(el => el.Nombre, search));
                    break;
                case 1:
                    retorno = collection.FindAs<Employed>(Query<Employed>.EQ(el => el.Rut, search));
                    break;
                case 2:
                    retorno = collection.FindAs<Employed>(Query<Employed>.EQ(el => el.Depto, search));
                    break;
                default:
                    return null;
                    break;
            }

            return jsoned(retorno);

        }

        private void conectionDB()
        {
            if (client == null)
            {
                client = new MongoClient("mongodb://localhost");
                server = client.GetServer();
                database = server.GetDatabase("local");
                collection = database.GetCollection<Employed>("entities");
            }
        }

        private string jsoned(MongoCursor<Employed> retorno)
        {
            string jsoned = "[";
            foreach (var aux in retorno)
            {
                jsoned += "{\"Rut\" : \"" + aux.Rut + "\" , \"Nombre\" : \"" + aux.Nombre + "\" , \"Depto\" : \"" + aux.Depto + "\" }, ";
            }
            jsoned += "]";

            return jsoned;
        }
    }
    
    
}




/*if (database.CollectionExists("entities"))
    database.DropCollection("entities");*/

/*var entity = new Employed { Name = "Tom", Depto = "Finanzas" };
collection.Insert(entity);
entity = new Employed { Name = "Matias", Depto = "Recursos Humanos" };
collection.Insert(entity);
entity = new Employed { Name = "Ana", Depto = "Recursos Humanos" };
collection.Insert(entity);*/