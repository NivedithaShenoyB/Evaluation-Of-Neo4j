import java.util.concurrent.TimeUnit;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.schema.IndexDefinition;
import org.neo4j.graphdb.schema.Schema;

public class Create_data extends Main_class{
	public Create_data(GraphDatabaseService db) {
		super(db);
		
	}
	 void create_posts()
	{
		IndexDefinition indexDefinition;
		try ( Transaction tx = db.beginTx() )
		{
		    Schema schema = db.schema();
		    indexDefinition = schema.indexFor( DynamicLabel.label( "posts1" ) )
		            .on( "post_name" )
		            .create();
		    tx.success();
		}
		try ( Transaction tx = db.beginTx() )
		{
		    Schema schema = db.schema();
		    schema.awaitIndexOnline( indexDefinition, 10, TimeUnit.SECONDS );
		}
		try ( Transaction tx = db.beginTx() )
		{
		    Label label = DynamicLabel.label( "posts1" );

		    // Create some users
		    for ( int id = 0; id < 100000; id++ )
		    {
		        Node userNode = db.createNode( label );
		        userNode.setProperty( "post_name", "post" + id + "post" );
		    }
		    System.out.println( "posts created" );
		    tx.success();
		}
		
	}
	void create_email()
	{
		IndexDefinition indexDefinition;
		try ( Transaction tx = db.beginTx() )
		{
		    Schema schema = db.schema();
		    indexDefinition = schema.indexFor( DynamicLabel.label( "email" ) )
		            .on( "email_id" )
		            .create();
		    tx.success();
		}
		try ( Transaction tx = db.beginTx() )
		{
		    Schema schema = db.schema();
		    schema.awaitIndexOnline( indexDefinition, 10, TimeUnit.SECONDS );
		}
		try ( Transaction tx = db.beginTx() )
		{
		    Label label = DynamicLabel.label( "email" );

		    // Create some users
		    for ( int id = 0; id < 100000; id++ )
		    {
		        Node userNode = db.createNode( label );
		        userNode.setProperty( "email_id", "user" + id + "@neo4j.org" );
		    }
		    System.out.println( "email ids created" );
		    tx.success();
		}
	}
	void create_buyer()
	{
		IndexDefinition indexDefinition;
		try ( Transaction tx = db.beginTx() )
		{
		    Schema schema = db.schema();
		    indexDefinition = schema.indexFor( DynamicLabel.label( "Buyer" ) )
		            .on( "name" )
		            .create();
		    tx.success();
		}
		try ( Transaction tx = db.beginTx() )
		{
		    Schema schema = db.schema();
		    schema.awaitIndexOnline( indexDefinition, 10, TimeUnit.SECONDS );
		}
		try ( Transaction tx = db.beginTx() )
		{
		    Label label = DynamicLabel.label( "Buyer" );

		    // Create some users
		    for ( int id = 0; id < 100000; id++ )
		    {
		        Node userNode = db.createNode( label );
		        userNode.setProperty( "name", "user" + id + "@neo4j.org" );
		    }
		    System.out.println( "Users created" );
		    tx.success();
		}
	}
	
void create_address()
{
	IndexDefinition indexDefinition;
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    indexDefinition = schema.indexFor( DynamicLabel.label( "address" ) )
	            .on( "address_name" )
	            .create();
	    tx.success();
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    schema.awaitIndexOnline( indexDefinition, 10, TimeUnit.SECONDS );
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Label label = DynamicLabel.label( "address" );

	    // Create some users
	    for ( int id = 0; id < 100000; id++ )
	    {
	        Node userNode = db.createNode( label );
	        userNode.setProperty( "address_name", "address" + id + "Town" );
	    }
	    System.out.println( "Addresses created" );
	    tx.success();
	}
}
void create_device_fp()
{
	IndexDefinition indexDefinition;
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    indexDefinition = schema.indexFor( DynamicLabel.label( "device_fp" ) )
	            .on( "device_name" )
	            .create();
	    tx.success();
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    schema.awaitIndexOnline( indexDefinition, 10, TimeUnit.SECONDS );
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Label label = DynamicLabel.label( "device_fp" );

	    // Create some users
	    for ( int id = 0; id < 100000; id++ )
	    {
	        Node userNode = db.createNode( label );
	        userNode.setProperty( "device_name", "device" + id + "finger_print" );
	    }
	    System.out.println( "Device Finger prints created" );
	    tx.success();
	}	
}
void create_phone()
{
	IndexDefinition indexDefinition;
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    indexDefinition = schema.indexFor( DynamicLabel.label( "phone" ) )
	            .on( "phone_name" )
	            .create();
	    tx.success();
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    schema.awaitIndexOnline( indexDefinition, 10, TimeUnit.SECONDS );
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Label label = DynamicLabel.label( "phone" );

	    // Create some users
	    for ( int id = 0; id < 100000; id++ )
	    {
	        Node userNode = db.createNode( label );
	        userNode.setProperty( "phone_name", "phone" + id + "number" );
	    }
	    System.out.println( "phone information created" );
	    tx.success();
	}	
	
}
void create_order()
{
	IndexDefinition indexDefinition;
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    indexDefinition = schema.indexFor( DynamicLabel.label( "order" ) )
	            .on( "order_id" )
	            .create();
	    tx.success();
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    schema.awaitIndexOnline( indexDefinition, 10, TimeUnit.SECONDS );
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Label label = DynamicLabel.label( "order" );

	    // Create some users
	    for ( int id = 0; id < 100000; id++ )
	    {
	        Node userNode = db.createNode( label );
	        userNode.setProperty( "order_id", "order" + id + "order_name" );
	    }
	    System.out.println( "Orders created" );
	    tx.success();
	}	
}
void create_suborder()
{
	IndexDefinition indexDefinition;
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    indexDefinition = schema.indexFor( DynamicLabel.label( "sub_order" ) )
	            .on( "sub_order_name" )
	            .create();
	    tx.success();
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    schema.awaitIndexOnline( indexDefinition, 10, TimeUnit.SECONDS );
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Label label = DynamicLabel.label( "sub_order" );

	    // Create some users
	    for ( int id = 0; id < 100000; id++ )
	    {
	        Node userNode = db.createNode( label );
	        userNode.setProperty( "sub_order_name", "sub_order" + id + "name" );
	    }
	    System.out.println( "Suborders created" );
	    tx.success();
	}	
}
void create_seller()
{
	IndexDefinition indexDefinition;
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    indexDefinition = schema.indexFor( DynamicLabel.label( "seller" ) )
	            .on( "seller_name" )
	            .create();
	    tx.success();
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    schema.awaitIndexOnline( indexDefinition, 10, TimeUnit.SECONDS );
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Label label = DynamicLabel.label( "seller" );

	    // Create some users
	    for ( int id = 0; id < 10000; id++ )
	    {
	        Node userNode = db.createNode( label );
	        userNode.setProperty( "seller_name", "seller" + id + "name" );
	    }
	    System.out.println( "Sellers created" );
	    tx.success();
	}	
}
void create_city()
{
	IndexDefinition indexDefinition;
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    indexDefinition = schema.indexFor( DynamicLabel.label( "city" ) )
	            .on( "city_name" )
	            .create();
	    tx.success();
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    schema.awaitIndexOnline( indexDefinition, 10, TimeUnit.SECONDS );
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Label label = DynamicLabel.label( "city" );

	    // Create some users
	    for ( int id = 0; id < 100000; id++ )
	    {
	        Node userNode = db.createNode( label );
	        userNode.setProperty( "city_name", "user" + id + "@neo4j.org" );
	    }
	    System.out.println( "Cities created" );
	    tx.success();
	}	
}
void create_pin()
{
	IndexDefinition indexDefinition;
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    indexDefinition = schema.indexFor( DynamicLabel.label( "pin" ) )
	            .on( "pin_id" )
	            .create();
	    tx.success();
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    schema.awaitIndexOnline( indexDefinition, 10, TimeUnit.SECONDS );
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Label label = DynamicLabel.label( "pin" );

	    // Create some users
	    for ( int id = 0; id < 100000; id++ )
	    {
	        Node userNode = db.createNode( label );
	        userNode.setProperty( "pin_id", "pincode" + id + "pin" );
	    }
	    System.out.println( "Pincodes created" );
	    tx.success();
	}	
}
void create_state()
{
	IndexDefinition indexDefinition;
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    indexDefinition = schema.indexFor( DynamicLabel.label( "state" ) )
	            .on( "state_name" )
	            .create();
	    tx.success();
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    schema.awaitIndexOnline( indexDefinition, 10, TimeUnit.SECONDS );
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Label label = DynamicLabel.label( "state" );

	    // Create some users
	    for ( int id = 0; id < 28; id++ )
	    {
	        Node userNode = db.createNode( label );
	        userNode.setProperty( "state_name", "state" + id + "name" );
	    }
	    System.out.println( "States created" );
	    tx.success();
	}		
}
void create_supc()
{
	IndexDefinition indexDefinition;
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    indexDefinition = schema.indexFor( DynamicLabel.label( "supc" ) )
	            .on( "supc_name" )
	            .create();
	    tx.success();
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    schema.awaitIndexOnline( indexDefinition, 10, TimeUnit.SECONDS );
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Label label = DynamicLabel.label( "supc" );

	    // Create some users
	    for ( int id = 0; id < 100000; id++ )
	    {
	        Node userNode = db.createNode( label );
	        userNode.setProperty( "supc_name", "supc" + id + "supc_name" );
	    }
	    System.out.println( "SUPC's created" );
	    tx.success();
	}	
}
void create_cost()
{
	IndexDefinition indexDefinition;
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    indexDefinition = schema.indexFor( DynamicLabel.label( "cost" ) )
	            .on( "cost_id" )
	            .create();
	    tx.success();
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    schema.awaitIndexOnline( indexDefinition, 10, TimeUnit.SECONDS );
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Label label = DynamicLabel.label( "cost" );

	    // Create some users
	    for ( int id = 0; id < 100000; id++ )
	    {
	        Node userNode = db.createNode( label );
	        userNode.setProperty( "cost_id", id );
	    }
	    System.out.println( "Costs created" );
	    tx.success();
	}		
}
void create_fulfillment_system()
{
	IndexDefinition indexDefinition;
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    indexDefinition = schema.indexFor( DynamicLabel.label( "fulfillment_system" ) )
	            .on( "fs_name" )
	            .create();
	    tx.success();
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    schema.awaitIndexOnline( indexDefinition, 10, TimeUnit.SECONDS );
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Label label = DynamicLabel.label( "fulfillment_system" );

	    // Create some users
	    for ( int id = 0; id < 100000; id++ )
	    {
	        Node userNode = db.createNode( label );
	        userNode.setProperty( "fs_name", "fs" + id + "name" );
	    }
	    System.out.println( "Fulfillment systems created" );
	    tx.success();
	}	
}
void create_current()
{
	IndexDefinition indexDefinition;
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    indexDefinition = schema.indexFor( DynamicLabel.label( "current" ) )
	            .on( "current_name" )
	            .create();
	    tx.success();
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    schema.awaitIndexOnline( indexDefinition, 10, TimeUnit.SECONDS );
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Label label = DynamicLabel.label( "current" );

	    // Create some users
	    for ( int id = 0; id < 100000; id++ )
	    {
	        Node userNode = db.createNode( label );
	        userNode.setProperty( "current_name", "current" + id + "name" );
	    }
	    System.out.println( "Current created" );
	    tx.success();
	}	
}
void create_delivered()
{
	IndexDefinition indexDefinition;
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    indexDefinition = schema.indexFor( DynamicLabel.label( "delivered" ) )
	            .on( "delivered_name" )
	            .create();
	    tx.success();
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    schema.awaitIndexOnline( indexDefinition, 10, TimeUnit.SECONDS );
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Label label = DynamicLabel.label( "delivered" );

	    // Create some users
	    for ( int id = 0; id < 100000; id++ )
	    {
	        Node userNode = db.createNode( label );
	        userNode.setProperty( "delivered_name", "delivered" + id + "name" );
	    }
	    System.out.println( "Delivered created" );
	    tx.success();
	}		
}
void create_shipped()
{
	IndexDefinition indexDefinition;
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    indexDefinition = schema.indexFor( DynamicLabel.label( "shipped" ) )
	            .on( "shipped_name" )
	            .create();
	    tx.success();
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    schema.awaitIndexOnline( indexDefinition, 10, TimeUnit.SECONDS );
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Label label = DynamicLabel.label( "shipped" );

	    // Create some users
	    for ( int id = 0; id < 100000; id++ )
	    {
	        Node userNode = db.createNode( label );
	        userNode.setProperty( "shipped_name", "shipped" + id + "name" );
	    }
	    System.out.println( "shipped created" );
	    tx.success();
	}		
}
void create_created()
{
	IndexDefinition indexDefinition;
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    indexDefinition = schema.indexFor( DynamicLabel.label( "created" ) )
	            .on( "created_name" )
	            .create();
	    tx.success();
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Schema schema = db.schema();
	    schema.awaitIndexOnline( indexDefinition, 10, TimeUnit.SECONDS );
	}
	try ( Transaction tx = db.beginTx() )
	{
	    Label label = DynamicLabel.label( "created" );

	    // Create some users
	    for ( int id = 0; id < 100000; id++ )
	    {
	        Node userNode = db.createNode( label );
	        userNode.setProperty( "created_name", "created" + id + "name" );
	    }
	    System.out.println( "created" );
	    tx.success();
	}		
}
}
