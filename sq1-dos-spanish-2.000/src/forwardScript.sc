;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 302)
(include sci.sh)
(use Interface)
(use Motion)
(use Actor)
(use System)

(public
	forwardScript 0
	drum 1
	ZZTop 2
	ZZTop2 3
	ZZTop3 4
)

(instance forwardScript of Script
	(properties)
)

(class FROR of Cycle
	(properties
		firstStaticCel 0
		lastStaticCel 0
		minCyclesToGo 100
		maxCyclesToGo 250
		cyclesToGo 1
	)

	(method (init param1 param2 param3 param4 param5)
		(super init: param1)
		(if (> argc 1)
			(= minCyclesToGo param2)
			(if (> argc 2)
				(= maxCyclesToGo param3)
				(if (> argc 3)
					(= firstStaticCel param4)
					(if (> argc 4)
						(= lastStaticCel param5)
					)
				)
			)
		)
	)

	(method (doit &tmp temp0)
		(if (not (-- cyclesToGo))
			(= cyclesToGo (Random minCyclesToGo maxCyclesToGo))
			(= cycleDir (- 1 (Random 0 2)))
			(if (not cycleDir)
				(client cel: (Random firstStaticCel lastStaticCel))
			)
		)
		(= temp0 (self nextCel:))
		(if cycleDir
			(cond
				((== cycleDir 1)
					(client cel: temp0)
				)
				((< temp0 0)
					(client cel: (client lastCel:))
				)
				(else
					(client cel: temp0)
				)
			)
		)
	)
)

(instance drum of View
	(properties
		x 112
		y 67
		description {drum}
		lookStr {On stage are two heavily-bearded gents and a relatively clean-shaven drummer. They're one of the hottest bands in the quadrant.}
		view 533
	)
)

(instance ZZTop of Prop
	(properties
		x 112
		y 49
		description {drummer}
		lookStr {On stage are two heavily-bearded gents and a relatively clean-shaven drummer. They're one of the hottest bands in the quadrant.}
		view 433
		cel 5
		cycleSpeed 4
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 302 0) ; "Don't touch."
			)
			(11 ; Taste
				(Print 302 1) ; "Get real!"
			)
			(12 ; Smell
				(Print 302 2) ; "I guess having a long beard means not having to take a bath."
			)
			(5 ; Talk
				(Print 302 3) ; "They don't have the time to talk to you."
			)
			(4 ; Inventory
				(switch invItem
					(10 ; buckazoid
						(Print 302 4) ; "Unlike any bar band you've ever seen, these guys aren't interested in tips."
					)
					(0 ; Cartridge
						(Print 302 5) ; "He isn't interested in the data cartridge."
					)
					(15 ; Widget
						(Print 302 6) ; "He doesn't seem interested in the widget."
					)
					(2 ; Gadget
						(Print 302 7) ; "The lyrics of this song are gibberish, even translated."
					)
					(4 ; Knife
						(Print 302 8) ; "You could wind up outside with a microphone stand wrapped around your neck."
					)
					(5 ; Dehydrated_Water
						(Print 302 9) ; "They look like they get plenty to drink."
					)
					(11 ; Jetpack
						(Print 302 10) ; "You decide not to offer him your jet pack - he's already flying."
					)
					(17 ; Bar_Coupon
						(Print 302 11) ; "There's no discount on the band. Sorry."
					)
					(18 ; Droids-B-Us_coupon
						(Print 302 11) ; "There's no discount on the band. Sorry."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ZZTop2 of Prop
	(properties
		x 133
		y 93
		description {guitar}
		lookStr {On stage are two heavily-bearded gents and a relatively clean-shaven drummer. They're one of the hottest bands in the quadrant.}
		view 433
		loop 1
		cel 5
		priority 6
		signal 16
		cycleSpeed 4
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 302 0) ; "Don't touch."
			)
			(11 ; Taste
				(Print 302 1) ; "Get real!"
			)
			(12 ; Smell
				(Print 302 2) ; "I guess having a long beard means not having to take a bath."
			)
			(5 ; Talk
				(Print 302 3) ; "They don't have the time to talk to you."
			)
			(4 ; Inventory
				(switch invItem
					(10 ; buckazoid
						(Print 302 12) ; "Unlike any bar band you've ever seen, these guys aren't interested in tips."
					)
					(0 ; Cartridge
						(Print 302 5) ; "He isn't interested in the data cartridge."
					)
					(15 ; Widget
						(Print 302 6) ; "He doesn't seem interested in the widget."
					)
					(2 ; Gadget
						(Print 302 7) ; "The lyrics of this song are gibberish, even translated."
					)
					(4 ; Knife
						(Print 302 8) ; "You could wind up outside with a microphone stand wrapped around your neck."
					)
					(5 ; Dehydrated_Water
						(Print 302 9) ; "They look like they get plenty to drink."
					)
					(11 ; Jetpack
						(Print 302 10) ; "You decide not to offer him your jet pack - he's already flying."
					)
					(17 ; Bar_Coupon
						(Print 302 11) ; "There's no discount on the band. Sorry."
					)
					(18 ; Droids-B-Us_coupon
						(Print 302 11) ; "There's no discount on the band. Sorry."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ZZTop3 of Prop
	(properties
		x 161
		y 88
		description {guitar}
		lookStr {On stage are two heavily-bearded gents and a relatively clean-shaven drummer. They're one of the hottest bands in the quadrant.}
		view 433
		loop 1
		cel 3
		priority 6
		signal 16
		cycleSpeed 4
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 302 0) ; "Don't touch."
			)
			(11 ; Taste
				(Print 302 1) ; "Get real!"
			)
			(12 ; Smell
				(Print 302 2) ; "I guess having a long beard means not having to take a bath."
			)
			(5 ; Talk
				(Print 302 3) ; "They don't have the time to talk to you."
			)
			(4 ; Inventory
				(switch invItem
					(10 ; buckazoid
						(Print 302 12) ; "Unlike any bar band you've ever seen, these guys aren't interested in tips."
					)
					(0 ; Cartridge
						(Print 302 5) ; "He isn't interested in the data cartridge."
					)
					(15 ; Widget
						(Print 302 6) ; "He doesn't seem interested in the widget."
					)
					(2 ; Gadget
						(Print 302 7) ; "The lyrics of this song are gibberish, even translated."
					)
					(4 ; Knife
						(Print 302 8) ; "You could wind up outside with a microphone stand wrapped around your neck."
					)
					(5 ; Dehydrated_Water
						(Print 302 9) ; "They look like they get plenty to drink."
					)
					(11 ; Jetpack
						(Print 302 10) ; "You decide not to offer him your jet pack - he's already flying."
					)
					(17 ; Bar_Coupon
						(Print 302 11) ; "There's no discount on the band. Sorry."
					)
					(18 ; Droids-B-Us_coupon
						(Print 302 11) ; "There's no discount on the band. Sorry."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

