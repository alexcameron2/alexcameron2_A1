Don't read me yet, im not finished!

Given Requirement: Input the player's hands in the form on an ID followed by 5 cards...
	Derived requirement: A card can be input into the system
		Test methods:
			CardObjectTest.java
					 	create_card_and_return_rank
						create_card_and_return_suit
						create_card_with_bad_rank
						create_card_with_bad_suit
						create_card_with_bad_format
						create_card_with_bad_input
						create_card_with_lowercase
						create_card_with_uppercase
						create_card_with_empty
						
	Derived requirement: A hand of cards can be input into the system
		Test methods:
			HandObjectTest.java:
						create_hand_and_return_cards
						create_hand_and_return_owner
						create_hand_too_few_arguments
						create_hand_empty
						create_hand_too_many_arguments
						create_hand_with_invalid_card
			RoundManagerObjectTest.java:			
						create_hand_with_invalid_id
						create_hand_with_duplicate_id
						create_hand_with_duplicate_cards
						create_hand_with_a_duplicate_card
						
Given Requirement: Determine how many players are participating each round(which defines valid IDs)
		Test methods:
						can_get_player_ids
						can_get_number_of_players
						