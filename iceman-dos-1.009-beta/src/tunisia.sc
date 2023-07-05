;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 310)
(include sci.sh)
(use Main)
(use Interface)
(use n954)
(use Game)
(use Actor)
(use System)

(public
	tunisia 0
	proc310_1 1
	proc310_2 2
	agent 3
	bagdad 4
	plate 5
	eClothes 6
	bClothes 7
)

(procedure (proc310_1 param1 &tmp temp0)
	(arabicBubbleView init:)
	(switch (param1 loop:)
		(1
			(if (< (= temp0 (- (param1 x:) 10)) 48)
				(= temp0 48)
			)
			(if (> temp0 285)
				(= temp0 285)
			)
			(arabicBubbleView posn: temp0 (param1 y:) 41 show: cel: 0)
		)
		(0
			(if (< (= temp0 (+ (param1 x:) 12)) 18)
				(= temp0 18)
			)
			(if (> temp0 271)
				(= temp0 271)
			)
			(arabicBubbleView posn: temp0 (param1 y:) 41 show: cel: 1)
		)
		(3
			(if (< (= temp0 (- (param1 x:) 10)) 48)
				(= temp0 48)
			)
			(if (> temp0 285)
				(= temp0 285)
			)
			(arabicBubbleView posn: temp0 (param1 y:) 41 show: cel: 0)
		)
		(else
			(if (< (= temp0 (+ (param1 x:) 12)) 18)
				(= temp0 18)
			)
			(if (> temp0 271)
				(= temp0 271)
			)
			(arabicBubbleView posn: temp0 (param1 y:) 41 show: cel: 1)
		)
	)
)

(procedure (proc310_2)
	(arabicBubbleView dispose:)
)

(class tunisia of Rgn
	(properties
		milkIs 0
		cheezIs 0
		fridgeIs 0
		vanWas 0
		removedHook 0
		sugarStat 0
		flourStat 0
		coffeeStat 0
		bagBound 0
		madeCall 0
		flags 0
		bagTimer 0
		pointFlag 0
	)

	(method (newRoom newRoomNumber)
		(= keep
			(OneOf
				newRoomNumber
				70 ; fishermanBeachRm
				71 ; tunaBeachRm1
				72 ; tunaBeachRm2
				73 ; cliffsRm
				74 ; pathToRoadRm
				75 ; abandonedShacksRm
				76 ; oasisRm
				77 ; roadToTownRm
				78 ; townRm1
				79 ; townRm2
				80 ; agentsBuildingRm
				81 ; outsideCompoundRm
				82 ; townRm3
				83 ; townRm4
				84 ; agentApartmentRm
				85 ; apartmentWindowRm
				86 ; compoundHallwayRm
			)
		)
		(= initialized 0)
		(super newRoom: &rest)
	)

	(method (init)
		(super init: &rest)
		(if (== gPrevRoomNum 45) ; netBeachRm
			(self fridgeIs: 0)
			(self milkIs: 1)
			(self cheezIs: 1)
			(self vanWas: 0)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at]>')
				(cond
					((Said '/line')
						(cond
							((gEgo has: 3) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
								(Print 310 0) ; "More than likely it's attached to a hook inside the mouth."
							)
							(removedHook
								(Print 310 1) ; "A piece of fishing line attached to a hook."
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((Said '/hook')
						(cond
							((not (gEgo has: 3)) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
								(event claimed: 0)
							)
							(removedHook
								(Print 310 2) ; "It's a typical Tunisian fish hook."
							)
							(else
								(Print 310 3) ; "You need to remove it first."
							)
						)
					)
					((Said '/weight')
						(cond
							((not (gEgo has: 3)) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
								(event claimed: 0)
							)
							(removedHook
								(Print 310 4) ; "Taking a closer look, you see that it's not a weight but rather a small capsule."
								(gEgo get: 4) ; Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule
							)
							(else
								(Print 310 5) ; "You need to remove the hook first."
							)
						)
					)
					((Said '/road')
						(Print 310 6) ; "The drab roadway bakes in the searing Tunisian sun."
					)
				)
			)
			((Said 'remove/hook')
				(cond
					((not (gEgo has: 3)) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
						(event claimed: 0)
					)
					(removedHook
						(Print 310 7) ; "You already did that."
					)
					(else
						(= removedHook 1)
						(Print 310 8) ; "After removing the hook, you notice something attached to the line just above the hook."
						(Print 310 9) ; "You think to yourself, "What is this, the weight?""
						(gGame changeScore: 1)
					)
				)
			)
			((Said 'open/capsule')
				(cond
					((not (gEgo has: 4)) ; Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule
						(event claimed: 0)
					)
					((and (gEgo has: 5) (not ((gInventory at: 5) loop:))) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map, Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
						(Print 310 7) ; "You already did that."
					)
					(else
						(Print 310 10) ; "You open the capsule and pull out a small map."
						(gEgo get: 5) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
						(gGame changeScore: 1)
					)
				)
			)
			((Said 'look/sidewalk')
				(if (OneOf gCurRoomNum 77 78 79 80 81 82 83) ; roadToTownRm, townRm1, townRm2, agentsBuildingRm, outsideCompoundRm, townRm3, townRm4
					(Print 310 11) ; "The sidewalk lines the road."
				else
					(event claimed: 0)
				)
			)
		)
	)
)

(instance arabicBubbleView of View
	(properties
		view 270
		cel 1
	)

	(method (init)
		(super init:)
		(self hide:)
	)
)

(instance agent of Act
	(properties
		y 200
		x 126
		view 250
		loop 3
	)
)

(instance bagdad of Act
	(properties
		y 200
		x 126
		view 184
		loop 3
	)
)

(instance plate of View
	(properties
		y 118
		x 224
		z 28
		view 584
		loop 1
		cel 2
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((TurnIfSaid self event 'look[<at]/platter,food'))
			((Said 'look[<at][/platter,food]')
				(Print 310 12) ; "A platter of food."
			)
			((Said 'get,(pick<up)/platter,food')
				(proc0_39) ; "You don't need to do that."
			)
		)
	)
)

(instance eClothes of View
	(properties
		view 584
		loop 1
	)
)

(instance bClothes of View
	(properties
		view 584
		loop 1
		cel 1
	)
)

