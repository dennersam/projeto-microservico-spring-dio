package one.digitalinnovation.experts.shopprojects.controller;

import one.digitalinnovation.experts.shopprojects.model.Cart;
import one.digitalinnovation.experts.shopprojects.model.Item;
import one.digitalinnovation.experts.shopprojects.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

 @RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Cart addItem(@PathVariable("id") Integer id, @RequestBody Item item){
        Optional<Cart> savedCard = cartRepository.findById(id);
        Cart cart;
        if (savedCard.equals(Optional.empty())){
            cart = new Cart(id);
        }
        else{
            cart = savedCard.get();
        }
        cart.getItems().add(item);
        return cartRepository.save(cart);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
     public Optional<Cart> findById(@PathVariable("id") Integer id){
        return cartRepository.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
     public void clear(@PathVariable("id") Integer id){
        cartRepository.deleteById(id);
    }
}
