;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 120)
(include sci.sh)
(use Main)
(use Inventory)
(use System)

(public
	inv1 0
)

(instance inv1 of Code
	(properties)

	(method (init)
		(gInventory
			add:
				sword
				shield
				lodestone
				purse
				rose
				sleeve
				iron_key
				crystal_heart
				boar_spear
		)
		(= global143 0)
	)

	(method (dispose)
		(gInventory
			delete:
				sword
				shield
				lodestone
				purse
				rose
				sleeve
				iron_key
				crystal_heart
				boar_spear
		)
		(DisposeScript 120)
	)
)

(instance sword of InvI
	(properties
		said '/blade,excaliber'
		view 503
	)
)

(instance shield of InvI
	(properties
		said '/shield'
	)
)

(instance lodestone of InvI
	(properties
		said '/lodestone'
		view 504
		cel 1
		owner 2
	)
)

(instance purse of InvI
	(properties
		said '/moneybag'
		view 507
		owner 4
	)
)

(instance rose of InvI
	(properties
		said '/rose'
		view 506
		owner 6
	)
)

(instance sleeve of InvI
	(properties
		said '/bolt,silk,sleeve[<woman]'
		view 510
		owner 13
	)
)

(instance iron_key of InvI
	(properties
		name {iron key}
		said '/key[<aluminum]'
		view 511
	)
)

(instance crystal_heart of InvI
	(properties
		name {crystal heart}
		said '/heart[<crystal]'
		view 500
		owner 20
	)
)

(instance boar_spear of InvI
	(properties
		name {boar spear}
		said '/spear[<boar]'
		view 509
		owner 11
	)
)

