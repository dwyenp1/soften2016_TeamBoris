<div class='mainContent'>
    <p>Welcome to the admin page</p>
    <form name="makePizza" action="/soften2016/addPizza" method="POST">
    
    	<label for='pizzaName'>Pizza Name</label>
		<input id='pizzaName' type='int' name='pizzaName' value=''>
		
		<br>
		<br>
		
		
			<button type='submit' name='submit' value='Submit Your Pizza'>Submit Your Pizza</button>
		
    </form>
    
			<label>Please Select Your Toppings<br><br></label>
			<br>
			<input type='checkbox' name='toppings[]' value='Cheese'>Cheese<br>
			<input type='checkbox' name='toppings[]' value='Chicken'>Chicken<br>
			<input type='checkbox' name='toppings[]' value='Beef'>Beef<br>
			<input type='checkbox' name='toppings[]' value='Italian Sausage'>Italian Sausage<br>
			<input type='checkbox' name='toppings[]' value='Pineapple'>Pineapple
			<br>
			<br>
    
</div>