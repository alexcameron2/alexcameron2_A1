Comp4004 Assignment 1
Alex Cameron
100861937

INSTRUCTIONS
- Download/unzip repository to folder called: PokerGame
- import the project into java

-gitHub repository: https://github.com/alexcameron2/alexcameron2_A1.git
-Email used(no contact, I know): OnBoardRope@gmail.com
-Student Email: alex.cameron2@carleton.ca

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
Requirement: Hands need to be evaluated and ranked by the system
	Derived requirement: The system can identify and associate rank to various hands						
						can_display_hands
					
					//	can_rank_two_hands
					//	can_rank_four_hands
					//	can_rank_pair
					//	can_rank_two_pair
					//	can_rank_three_of_a_kind
					//	can_rank_four_of_a_kind
					//	can_rank_straight
					//	can_rank_flush
					//	can_rank_straight_flush
					//	can_rank_high_card
						
	Derived requirement: The system can rank and sort these hands
					//	can_find_winning_order
					//	can_display_winning_order					
Given Requirement: Determine how many players are participating each round(which defines valid IDs)
		Test methods:
						can_get_player_ids
						can_get_number_of_players
						