;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 139)
(include sci.sh)
(use Main)
(use Inventory)
(use System)

(public
	inv3 0
)

(instance inv3 of Code
	(properties)

	(method (init)
		(gInventory
			add:
				sword
				shield
				lodestone
				purse
				green_apple
				elixir
				grail
				helm
				medallion
				bone
				dove
				golden_apple
		)
		(gEgo get: 0 1) ; sword
		(= global143 2)
	)

	(method (dispose)
		(gInventory
			delete:
				sword
				shield
				lodestone
				purse
				green_apple
				elixir
				grail
				helm
				medallion
				bone
				dove
				golden_apple
		)
		(DisposeScript 139)
	)
)

(instance sword of InvI
	(properties
		said '/excaliber,(blade[<!*])'
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
	)
)

(instance purse of InvI
	(properties
		said '/moneybag'
		view 507
	)
)

(instance green_apple of InvI
	(properties
		name {green apple}
		said '/apple[<green]'
		view 529
		owner 59
	)

	(method (saidMe)
		(cond
			((and (gEgo has: 4) (Said said)) ; rose | apple | green_apple
				(return 1)
			)
			((gEgo has: 11) ; mirror | golden_apple
				(return 0)
			)
			(else
				(return (Said said))
			)
		)
	)
)

(instance elixir of InvI
	(properties
		said '/elixer'
		view 515
	)
)

(instance grail of InvI
	(properties
		said '/grail'
		view 513
		owner 62
	)
)

(instance helm of InvI
	(properties
		said '/crest'
		view 505
		owner 72
	)
)

(instance medallion of InvI
	(properties
		said '/medal'
		view 522
		owner 67
	)
)

(instance bone of InvI
	(properties
		said '/bone'
		view 524
	)
)

(instance dove of InvI
	(properties
		said '/dove'
		view 525
		owner 74
	)
)

(instance golden_apple of InvI
	(properties
		name {golden apple}
		said '/apple[<golden]'
		view 516
		owner 71
	)
)

