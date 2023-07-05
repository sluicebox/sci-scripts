;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 887)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	klondikeRules 0
)

(instance klondikeRules of Obj
	(properties)

	(method (doit &tmp [temp0 200])
		(gGame setCursor: 999)
		(gSysWindow setColor: 14 setBack: 1)
		(Print 887 0) ; "OBJECT: Play as many cards as possible into the four Foundation piles at left. Original Klondike allows playing only once through the deck. You can play unlimited times through the deck in the other variations."
		(Print 887 1) ; "PLAY: Flip cards from the deck and place them in a Foundation or Column if possible and desired, or in the waste pile. Foundations must be ascending sequences in rank of the same suit beginning with Aces, Columns must be descending sequences in rank of alternating color. All face-up cards in a Column can be moved as a group to another Column as long as the colors continue to alternate and the cards descend in the correct ranking. Only Kings can be used to start an empty column."
		(Print 887 2) ; "SCORING: Score five points for each card in the Foundations, or 500 if all the cards are in the Foundations. Each hand deducts an automatic 50 points."
		(Print 887 3) ; "VARIATIONS: Original Klondike: Play once through the deck, flipping one card at a time. Flip 3: Unlimited times through the deck, flipping three cards at a time. Flip 1 Easy: Unlimited times through the deck, flip only one card at a time."
		(gSysWindow setColor: 12 setBack: 14)
	)
)

