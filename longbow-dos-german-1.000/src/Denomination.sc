;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 856)
(include sci.sh)
(use Main)
(use Interface)
(use GiveOrTakeIcon)
(use System)

(class Denomination of DIcon
	(properties
		value 1
		number 0
		taken 0
		taker 0
		giver 0
		client 0
	)

	(method (dispose)
		(= taker (= giver 0))
		(super dispose: &rest)
	)

	(method (put param1)
		(if argc
			(= taken param1)
		)
		(self get: (- taken))
		(return (* value number))
	)

	(method (get param1 &tmp temp0)
		(= temp0
			(cond
				((not argc) 0)
				((not (IsObject param1)) param1)
				((== param1 taker) -1)
				(else 1)
			)
		)
		(if (and (<= 0 (- number temp0)) (<= 0 (+ taken temp0)))
			(-= number temp0)
			(+= taken temp0)
			(if (IsObject param1)
				(taker draw:)
				(giver draw:)
			)
			(client get:)
		)
		(return (* value taken))
	)
)

(instance addValue of Code
	(properties)

	(method (doit param1 param2)
		(param2
			value: (+ (param2 value:) (* (param1 value:) (param1 number:)))
			taken: (+ (param2 taken:) (* (param1 value:) (param1 taken:)))
		)
	)
)

(class Money of List
	(properties
		value 0
		taken 0
		view 0
		loop 0
		window 0
		color 4
		font 1
		cursor 0
		keepStr {KEEP}
		giveStr {GIVE}
		owner 0
		number -1
		title 0
	)

	(method (init)
		(self add: &rest eachElementDo: #client self get:)
	)

	(method (doit &tmp temp0 temp1)
		(= taken 0)
		((= temp0 (MoneyDialog new:))
			name: {MoneyD}
			text: title
			init: self
			doit:
			dispose:
		)
		(return taken)
	)

	(method (get)
		(= value (= taken 0))
		(self eachElementDo: #perform addValue self)
		(if (not (OneOf -1 owner number))
			(cond
				(value
					((gInventory at: number) owner: owner)
				)
				((== owner gEgo)
					(gEgo put: number)
				)
				(else
					((gInventory at: number) owner: 0)
				)
			)
		)
		(return taken)
	)

	(method (put)
		(self eachElementDo: #put get:)
		(return value)
	)
)

