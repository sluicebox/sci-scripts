;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 106)
(include sci.sh)
(use System)

(class Goods of Obj
	(properties
		quantity 1
		attributes 1
		pricePaid 0
		indexNum 0
	)
)

(class Consumable of Goods
	(properties
		attributes 129
	)

	(method (doit)
		(if quantity
			(-- quantity)
		)
	)
)

(class Durable of Goods
	(properties
		attributes 69
		redemptionPrice 0
	)
)

(class Educational of Goods
	(properties
		unitsToGraduate 10
	)
)

(class ListOfGoods of List
	(properties)

	(method (newGoods))

	(method (recieve param1 param2 &tmp temp0 temp1)
		(= temp1 (if (>= argc 2) param2 else 1))
		(if (not (= temp0 (self hasType: param1 temp1)))
			(self
				add:
					(= temp0
						((self newGoods:)
							indexNum: param1
							quantity: temp1
							yourself:
						)
					)
			)
		)
		(return temp0)
	)

	(method (hasType param1 param2 &tmp temp0)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if (== ((self at: temp0) indexNum:) param1)
				((self at: temp0)
					quantity: (+ ((self at: temp0) quantity:) param2)
				)
				(return (self at: temp0))
			)
		)
		(return 0)
	)

	(method (pack &tmp temp0 temp1 temp2)
		(= temp1 (ScriptID 1 1)) ; tempList
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if (& ((self at: temp0) attributes:) $0001)
				(= temp2 ((self at: temp0) new:))
				(temp2 attributes: (& (temp2 attributes:) $fffe))
				(temp1 add: temp2)
			)
		)
		(for ((= temp0 (- size 1))) (>= temp0 0) ((-- temp0))
			(if (& ((self at: temp0) attributes:) $0001)
				(self delete: (= temp2 (self at: temp0)))
				(temp2 dispose:)
			)
		)
		(if (temp1 size:)
			(for ((= temp0 0)) (< temp0 (temp1 size:)) ((++ temp0))
				(self add: (temp1 at: temp0))
			)
		)
		(temp1 release:)
	)

	(method (objectAtIndex param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if (== ((self at: temp0) indexNum:) param1)
				(return (self at: temp0))
			)
		)
		(return 0)
	)

	(method (objectAtIndexQuan param1 &tmp temp0)
		(if (= temp0 (self objectAtIndex: param1))
			(temp0 quantity:)
			(return)
		)
	)
)

(class Consumables of ListOfGoods
	(properties)

	(method (newGoods)
		(Consumable new:)
	)
)

(class Durables of ListOfGoods
	(properties)

	(method (newGoods)
		(Durable new:)
	)
)

(class Education of ListOfGoods
	(properties)

	(method (newGoods)
		(Educational new:)
	)
)

