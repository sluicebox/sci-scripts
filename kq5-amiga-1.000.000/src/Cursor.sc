;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 766)
(include sci.sh)
(use System)

(class Cursor of Obj
	(properties
		view 0
		loop 0
		cel 0
		x 0
		y 0
		skipOne 0
		skipTwo 0
		skipThree 0
		skipFour 0
	)

	(method (init)
		(if view
			(SetCursor view loop cel x y skipOne skipTwo skipThree skipFour)
		)
	)

	(method (posn param1 param2 &tmp temp0 temp1 temp2)
		(= x param1)
		(= y param2)
		(= temp0 (Event new:))
		(temp0 localize:)
		(= temp1 (temp0 x:))
		(= temp2 (temp0 y:))
		(temp0 dispose:)
		(self init:)
		(return temp1)
	)

	(method (posnOrigin param1 param2)
		(= x param1)
		(= y param2)
		(self init:)
	)

	(method (setLoop param1)
		(= loop param1)
		(self init:)
	)

	(method (skipColor param1 param2 param3 param4)
		(= skipOne param1)
		(if (>= argc 1)
			(= skipTwo param2)
			(if (>= argc 2)
				(= skipThree param3)
				(if (>= argc 3)
					(= skipFour param4)
				)
			)
		)
		(self init:)
	)

	(method (setCel param1)
		(= cel param1)
		(self init:)
	)
)

