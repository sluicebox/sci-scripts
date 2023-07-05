;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 371)
(include sci.sh)
(use Main)
(use Inventory)
(use System)

(public
	tahitiInv 0
)

(instance tahitiInv of Code
	(properties)

	(method (init)
		(gInventory add: Black_Book Change Key Earring)
	)

	(method (dispose)
		(gInventory delete: Black_Book Change Key Earring)
		(DisposeScript 371)
	)
)

(instance Black_Book of InvI
	(properties
		name {Black Book}
		said '/book[<black,talk,call]'
		view 300
		loop 1
		value 1
	)
)

(instance Change of InvI
	(properties
		said '/change,coin'
		view 310
		loop 2
		value 1
	)
)

(instance Key of InvI
	(properties
		said '/key'
		view 310
		loop 1
		value 1
	)
)

(instance Earring of InvI
	(properties
		said '/earring'
		view 313
		value 1
	)
)

