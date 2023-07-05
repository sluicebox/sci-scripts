;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 121)
(include sci.sh)
(use Main)
(use Inventory)
(use System)

(public
	inv2 0
)

(instance inv2 of Code
	(properties)

	(method (init)
		(gInventory
			add:
				sword
				shield
				lodestone
				purse
				apple
				elixir
				broom
				charcoal
				grain
				herbs
				lamb
				mirror
				relic
				veil
				felafel
		)
		(gEgo get: 0 1) ; sword
		(= global143 1)
	)

	(method (dispose)
		(gInventory
			delete:
				sword
				shield
				lodestone
				purse
				apple
				elixir
				broom
				charcoal
				grain
				herbs
				lamb
				mirror
				relic
				veil
				felafel
		)
		(DisposeScript 121)
	)
)

(instance sword of InvI
	(properties
		said '/excaliber,(blade[<!*])'
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
	)
)

(instance purse of InvI
	(properties
		said '/moneybag'
	)

	(method (showSelf)
		(self view: (if (IsFlag 133) 508 else 507))
		(super showSelf:)
	)
)

(instance apple of InvI
	(properties
		said '/apple'
		view 529
		owner 59
	)
)

(instance elixir of InvI
	(properties
		said '/elixer'
		view 515
	)
)

(instance broom of InvI
	(properties
		said '/broom'
		view 521
		owner 59
	)
)

(instance charcoal of InvI
	(properties
		view 514
		owner 59
	)

	(method (saidMe)
		(return (or (Said '/charcoal') (Said '/bag/charcoal')))
	)
)

(instance grain of InvI
	(properties
		view 526
		owner 58
	)

	(method (saidMe)
		(return (or (Said '/grain') (Said '/bag[/grain]')))
	)
)

(instance herbs of InvI
	(properties
		said '/herb'
		view 517
		owner 59
	)
)

(instance lamb of InvI
	(properties
		said '/lamb'
		view 523
		owner 62
	)
)

(instance mirror of InvI
	(properties
		said '/mirror'
		view 520
		owner 58
	)
)

(instance relic of InvI
	(properties
		said '/relic'
		view 512
		owner 62
	)
)

(instance veil of InvI
	(properties
		said '/veil'
		view 519
		owner 56
	)
)

(instance felafel of InvI
	(properties
		said '/falafel'
		view 530
		owner 57
	)
)

