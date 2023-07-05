;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 372)
(include sci.sh)
(use Main)
(use Interface)
(use subMarine_314)
(use Inventory)
(use System)

(public
	subInv 0
)

(instance subInv of Code
	(properties)

	(method (init)
		(gInventory
			add:
				Explosive
				Rum_Bottle
				Storage_Compartment_Key
				DV_3X
				Flare
				Device
				Cotter_pin
				Washer
				Nut
				Metal_Cylinder
				Vernier_Caliper
				Code_Book
				Hammer
				Open_End_Wrench
		)
	)

	(method (dispose)
		(gInventory
			delete:
				Explosive
				Rum_Bottle
				Storage_Compartment_Key
				DV_3X
				Flare
				Device
				Cotter_pin
				Washer
				Nut
				Metal_Cylinder
				Vernier_Caliper
				Code_Book
				Hammer
				Open_End_Wrench
		)
		(DisposeScript 372)
	)
)

(instance Explosive of InvI
	(properties
		said '/bomb'
		view 330
		value 1
	)
)

(instance Rum_Bottle of InvI
	(properties
		name {Rum Bottle}
		said '/bottle[<rum]'
		view 330
		cel 1
		value 1
	)
)

(instance Storage_Compartment_Key of InvI
	(properties
		name {Storage Compartment Key}
		said '/key'
		view 330
		cel 2
		value 1
	)
)

(instance DV_3X of InvI
	(properties
		name {DV-3X}
		said '/diver'
		view 337
		loop 1
		value 1
	)
)

(instance Flare of InvI
	(properties
		said '/flare'
		view 330
		cel 3
		value 1
	)
)

(instance Device of InvI
	(properties
		said '/device'
		view 339
		value 1
	)
)

(instance Cotter_pin of InvI
	(properties
		name {Cotter pin}
		said '/pin[<cotter]'
		view 337
		loop 2
		value 1
	)
)

(instance Washer of InvI
	(properties
		said '/washer'
		view 337
		loop 1
		cel 3
		value 1
	)

	(method (showSelf)
		(switch (subMarine invStatus4:)
			(1
				(Print 372 0 #icon view loop cel) ; "A 1/4" washer."
			)
			(2
				(Print 372 1 #icon view loop cel) ; "A 1/2" washer."
			)
			(3
				(Print 372 2 #icon view loop cel) ; "A 3/4" washer."
			)
			(4
				(Print 372 3 #icon view loop cel) ; "A 1" washer."
			)
		)
	)
)

(instance Nut of InvI
	(properties
		said '/nut'
		view 337
		loop 1
		cel 2
		value 1
	)

	(method (showSelf)
		(switch (subMarine invStatus3:)
			(1
				(Print 372 4 #icon view loop cel) ; "A 1/4" nut."
			)
			(2
				(Print 372 5 #icon view loop cel) ; "A 1/2" nut."
			)
			(3
				(Print 372 6 #icon view loop cel) ; "A 3/4" nut."
			)
			(4
				(Print 372 7 #icon view loop cel) ; "A 1" nut."
			)
		)
	)
)

(instance Metal_Cylinder of InvI
	(properties
		name {Metal Cylinder}
		said '/cylinder[<metal]'
		view 337
		loop 1
		cel 1
		value 1
	)

	(method (showSelf)
		(switch (subMarine invStatus1:)
			(0
				(Print 372 8 #icon view loop cel) ; "A sheared-off metal cylinder."
			)
			(1
				(Print 372 9 #icon view loop cel) ; "A 3" metal cylinder."
			)
			(2
				(Print 372 10 #icon view loop cel) ; "A 4" metal cylinder."
			)
			(3
				(Print 372 11 #icon view loop cel) ; "A 6" metal cylinder."
			)
		)
	)
)

(instance Vernier_Caliper of InvI
	(properties
		name {Vernier Caliper}
		said '/caliper'
		view 337
		cel 3
		value 1
	)
)

(instance Code_Book of InvI
	(properties
		name {Code Book}
		said '/book[<code]'
		view 431
		value 1
	)
)

(instance Hammer of InvI
	(properties
		said '/hammer'
		view 337
		value 1
	)
)

(instance Open_End_Wrench of InvI
	(properties
		name {Open End Wrench}
		said '/wrench'
		view 337
		cel 2
		value 1
	)

	(method (showSelf)
		(switch (subMarine invStatus2:)
			(1
				(Print 372 12 #icon view loop cel) ; "A 1/4" wrench."
			)
			(2
				(Print 372 13 #icon view loop cel) ; "A 1/2" wrench."
			)
			(3
				(Print 372 14 #icon view loop cel) ; "A 3/4" wrench."
			)
			(4
				(Print 372 15 #icon view loop cel) ; "A 1" wrench."
			)
		)
	)
)

