import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Path;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.schema.IndexDefinition;
import org.neo4j.graphdb.schema.Schema;
import org.neo4j.graphdb.traversal.Evaluators;
import org.neo4j.graphdb.traversal.TraversalDescription;
import org.neo4j.graphdb.traversal.Traverser;
import org.neo4j.graphdb.traversal.Uniqueness;
import org.neo4j.io.fs.FileUtils;

public class Main_class {
	public GraphDatabaseService db;
    private TraversalDescription friendsTraversal;
    private long Id=11;

    private static final String DB_PATH = "/home/niveditha/neo4j2/data/graph.db";
	public static void main(String[] args)throws IOException
	{
		 //FileUtils.deleteRecursively( new File( DB_PATH ) );
		GraphDatabaseService database = new GraphDatabaseFactory().newEmbeddedDatabase( DB_PATH );
		Main_class obj1=new Main_class(database);
		 //obj1.createData();
		 obj1.run();
		
		
	}
	public Main_class( GraphDatabaseService db )
	{
		this.db=db;
	}
	private void run() {
		//Run all queries here
		//Finding all posts by a person with a given Id
		
            System.out.println("Function Run");
          createdata();
            find_node();//find a person given his email id
            print_posts_by_buyer();//print the posts by a particular person
            //Find the city a particular user is from
            find_city();
            max_traversal();
            buyer_orders();
            buyer_to_seller();
           
            
        
	}
	private void find_city()
	{
		long initial_time=System.currentTimeMillis();
		try ( Transaction tx = db.beginTx() )
		{
		String output = "";
		Node tmp_node=db.getNodeById(19);
        // START SNIPPET: depth4
		
		TraversalDescription td = db.traversalDescription()
                .depthFirst()
                .relationships(Rels.buyer_address,Direction.OUTGOING)
                .relationships( Rels.address_city, Direction.OUTGOING )
                .evaluator( Evaluators.excludeStartPosition() );
		Traverser t=td.traverse(tmp_node);
        for ( Path path : td
                .evaluator( Evaluators.fromDepth( 1 ) )
                .evaluator( Evaluators.toDepth( 2) )
                .traverse(tmp_node ) )
        {
            output += path + "\n";
        }
        long final_time=System.currentTimeMillis();
        System.out.println(output);
        long diff=final_time-initial_time;
        System.out.println("Time required to find the city of a particular user (depth 2) is "+diff+" ms");
		}
	}
	private void buyer_orders()
	{
		long initial_time=System.currentTimeMillis();
		 try ( Transaction tx = db.beginTx() )
		 {
			 long id=19;
		Node tmp_node=db.getNodeById(id);
		Traverser t;
		String output="";
		int number_of_orders=0;
		TraversalDescription td = db.traversalDescription()
               .breadthFirst()
               .relationships( Rels.orders, Direction.OUTGOING )
               .evaluator( Evaluators.excludeStartPosition() );
		t=td.traverse(tmp_node);
		 for ( Path friendPath : t )
        {
			 
            output += "At depth " + friendPath.length() + " => "
                      + friendPath.endNode()
                              .getProperty( "order_id" ) + "\n";
            
        
            number_of_orders++;
			 
			 
        }
       // output += "Number of friends found: " + number_of_posts+ "\n";
       
        long final_time=System.currentTimeMillis();
        long diff=final_time-initial_time;
       
        //System.out.println(output);
        System.out.println("Number of orders by the user with Id "+Id+" is "+number_of_orders);
        System.out.println("time for execution= "+diff+" ms ");
       
		 }
	}
	private void buyer_to_seller()
	{
		long initial_time=System.currentTimeMillis();
		try ( Transaction tx = db.beginTx() )
		{
		String output = "";
		Node tmp_node=db.getNodeById(11);
       
		
		TraversalDescription td = db.traversalDescription()
                .depthFirst()
                .relationships(Rels.orders,Direction.OUTGOING)
                .relationships( Rels.order_suborder, Direction.OUTGOING )
                .relationships( Rels.suborder_supc, Direction.OUTGOING )
                .relationships( Rels.seller_supc, Direction.INCOMING)
                
                .evaluator( Evaluators.excludeStartPosition() );
		Traverser t=td.traverse(tmp_node);
        for ( Path path : td
                .evaluator( Evaluators.fromDepth( 3 ) )
                .evaluator( Evaluators.toDepth( 4) )
                .traverse(tmp_node ) )
        {
            output += path + "\n";
        }
        long final_time=System.currentTimeMillis();
        System.out.println(output);
        long diff=final_time-initial_time;
        System.out.println("Time required to find which seller the buyer bought from is  "+diff+" ms");
		}	
	}
	private void max_traversal()
	{
		long initial_time=System.currentTimeMillis();
		try ( Transaction tx = db.beginTx() )
		{
		String output = "";
		Node tmp_node=db.getNodeById(11);
        // START SNIPPET: depth4
		
		TraversalDescription td = db.traversalDescription()
                .depthFirst()
                .relationships(Rels.orders,Direction.OUTGOING)
                .relationships( Rels.order_suborder, Direction.OUTGOING )
                .relationships( Rels.suborder_current, Direction.OUTGOING )
                .relationships( Rels.current_delivered, Direction.OUTGOING )
                .relationships( Rels.delivered_shipped, Direction.OUTGOING )
                .relationships( Rels.shipped_created, Direction.OUTGOING )
                .evaluator( Evaluators.excludeStartPosition() );
		Traverser t=td.traverse(tmp_node);
        for ( Path path : td
                .evaluator( Evaluators.fromDepth( 6 ) )
                .evaluator( Evaluators.toDepth( 7) )
                .traverse(tmp_node ) )
        {
            output += path + "\n";
        }
        long final_time=System.currentTimeMillis();
        System.out.println(output);
        long diff=final_time-initial_time;
        System.out.println("Time required to find the created of a particular order (depth 7) is "+diff+" ms");
		}
	}
	
	private void find_node()
	{
		System.out.println("entered find node");
		Label label = DynamicLabel.label( "email" );
		int idToFind = 45;
		String nameToFind = "user" + idToFind + "@neo4j.org";
		long initial_time=System.currentTimeMillis();
		try ( Transaction tx = db.beginTx() )
		{
		    try ( ResourceIterator<Node> users =
		            db.findNodes( label, "email_id", nameToFind ) )
		    {
		        ArrayList<Node> userNodes = new ArrayList<>();
		        while ( users.hasNext() )
		        {
		            userNodes.add( users.next() );
		        }

		        for ( Node node : userNodes )
		        {
		            System.out.println( "Found email id of user " + idToFind + " is " + node.getProperty( "email_id" ) );
		        }
		    }
		}
		long final_time=System.currentTimeMillis();
		long diff=final_time-initial_time;
		System.out.println("Time for execution= "+diff);
	}
	private void createdata()
	{
		Create_data c1=new Create_data(db);
		//c1.create_buyer();
		//c1.create_email();
		//c1.create_posts();
		//c1.create_address();
		//c1.create_city();
		//c1.create_device_fp();
		//c1.create_cost();
		//c1.create_created();
		//c1.create_current();
		//c1.create_delivered();
		//c1.create_device_fp();
		//c1.create_email();
		//c1.create_fulfillment_system();
		//c1.create_order();
		//c1.create_phone();
		//c1.create_pin();
		//c1.create_posts();
		//c1.create_seller();
		//c1.create_state();
		//c1.create_shipped();
		//c1.create_suborder();
		//c1.create_supc();
		
		
		
	}
	
	
	private void print_posts_by_buyer()
	{
		long initial_time=System.currentTimeMillis();
		 try ( Transaction tx = db.beginTx() )
		 {
		Node tmp_node=db.getNodeById(Id);
		Traverser t;
		String output="";
		int number_of_posts=0;
		TraversalDescription td = db.traversalDescription()
                .breadthFirst()
                .relationships( Rels.POSTS, Direction.OUTGOING )
                .evaluator( Evaluators.excludeStartPosition() );
		t=td.traverse(tmp_node);
		 for ( Path friendPath : t )
         {
			 
             output += "At depth " + friendPath.length() + " => "
                       + friendPath.endNode()
                               .getProperty( "post_name" ) + "\n";
             
         
             number_of_posts++;
			 
			 
         }
        // output += "Number of friends found: " + number_of_posts+ "\n";
        
         long final_time=System.currentTimeMillis();
         long diff=final_time-initial_time;
        
         //System.out.println(output);
         System.out.println("Number of posts by the user with Id "+Id+" is "+number_of_posts);
         System.out.println("time for execution= "+diff+" ms ");
        
		 }
	}
	private enum Rels implements RelationshipType
    {
        POSTS,address_city,seller_supc,buyer_address,orders,order_suborder,suborder_current,current_delivered,delivered_shipped,shipped_created,suborder_supc;
    }
	
}
