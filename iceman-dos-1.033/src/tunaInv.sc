;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 374)
(include sci.sh)
(use Main)
(use Interface)
(use Inventory)
(use System)

(public
	tunaInv 0
)

(instance tunaInv of Code
	(properties)

	(method (init)
		(gInventory
			add:
				Fish
				Capsule
				Map
				Key
				Duct_Tape
				Tranquilizer_Gun
				Sugar_Canister
				Flour_Canister
				Coffee_Canister
				Business_Card
				Food_Platter
				Note
		)
	)

	(method (dispose)
		(gInventory
			delete:
				Fish
				Capsule
				Map
				Key
				Duct_Tape
				Tranquilizer_Gun
				Sugar_Canister
				Flour_Canister
				Coffee_Canister
				Business_Card
				Food_Platter
				Note
		)
		(DisposeScript 374)
	)
)

(instance Fish of InvI
	(properties
		said '/fish'
		view 372
		cel 1
		value 1
	)
)

(instance Capsule of InvI
	(properties
		said '/capsule'
		view 372
		cel 2
		value 1
	)
)

(instance Map of InvI
	(properties
		said '/map'
		view 372
		cel 3
		value 1
	)

	(method (showSelf)
		(if loop
			(Print 374 0 #icon view loop cel) ; "The directions to Stacy's apartment."
		else
			(Print 374 1 #icon view loop cel) ; "The directions to your disguise."
		)
	)
)

(instance Key of InvI
	(properties
		said '/key'
		view 372
		loop 1
		cel 1
		value 1
	)
)

(instance Duct_Tape of InvI
	(properties
		name {Duct Tape}
		said '/tape'
		view 372
		loop 1
		cel 2
		value 1
	)
)

(instance Tranquilizer_Gun of InvI
	(properties
		name {Tranquilizer Gun}
		said '/gun'
		view 384
		loop 3
		value 1
	)
)

(instance Sugar_Canister of InvI
	(properties
		name {Sugar Canister}
		said '/canister<sugar'
		view 384
		value 1
	)
)

(instance Flour_Canister of InvI
	(properties
		name {Flour Canister}
		said '/canister<flour'
		view 384
		cel 1
		value 1
	)
)

(instance Coffee_Canister of InvI
	(properties
		name {Coffee Canister}
		said '/canister<coffee'
		view 384
		cel 2
		value 1
	)
)

(instance Business_Card of InvI
	(properties
		name {Business Card}
		said '/card'
		view 384
		loop 1
		cel 1
		value 1
	)
)

(instance Food_Platter of InvI
	(properties
		name {Food Platter}
		said '/platter'
		view 384
		loop 1
		value 1
	)
)

(instance Note of InvI
	(properties
		said '/note'
		view 384
		loop 4
		cel 1
		value 1
	)
)

