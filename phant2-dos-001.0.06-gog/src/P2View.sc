;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63012)
(include sci.sh)
(use P2Feature)
(use PolyEdit)
(use TextField)

(class P2View of P2Feature
	(properties
		x 0
		y 0
		view 0
		loop 0
		cel 0
	)

	(method (init param1 &tmp temp0)
		(= temp0 priority)
		(if (super init:)
			(if target
				(target dispose:)
				(= target 0)
			)
			(if argc
				(= x [param1 0])
				(= y [param1 1])
				(if (> 2 argc)
					(= cel [param1 2])
					(if (> 3 argc)
						(= loop [param1 3])
						(if (> 4 argc)
							(= view [param1 4])
						)
					)
				)
			)
			(if view
				(= target (View new:))
				(if (!= temp0 -1)
					(target setPri: temp0)
				)
				(self set: view loop cel)
				(self posn: x y)
				(target init:)
				(((target plane:) cast:) delete: target)
			else
				(self priority: 2)
				((= target (TextView new:))
					borderColor: 3
					setText: name
					setSize:
					init:
					setPri: 1
					posn: x y
				)
			)
			(return self)
		else
			(return 0)
		)
	)

	(method (dispose)
		(if (not view)
			(target hide:)
			(= target 0)
		)
		(super dispose:)
	)

	(method (posn param1 param2)
		(if argc
			(= x param1)
			(if (> argc 1)
				(= y param2)
			)
		)
		(if target
			(target posn: x y)
		)
	)

	(method (set param1 param2 param3 param4)
		(if argc
			(= view param1)
			(if (> argc 1)
				(= loop param2)
				(if (> argc 2)
					(= cel param3)
				)
			)
		)
		(target view: view setLoop: loop setCel: cel)
		(if (and (>= argc 4) param4)
			(target update:)
		)
	)

	(method (addTarget param1 param2)
		(if (or (and (> argc 1) param2) (not (target isMemberOf: View)))
			(super addTarget: param1)
		else
			(target addTarget: param1)
			(if (target isMemberOf: View)
				(target responder: (target target:))
			)
		)
	)
)

