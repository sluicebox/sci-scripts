;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 889)
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
		curPosnX 0
		curPosnY 0
	)

	(method (init)
		(SetCursor view loop cel)
		(if (or curPosnX curPosnY)
			(SetCursor curPosnX curPosnY)
			(= curPosnX (= curPosnY 0))
		)
	)

	(method (posn param1 param2 &tmp [temp0 3])
		(= curPosnX param1)
		(= curPosnY param2)
		(self init:)
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

	(method (setCel param1)
		(= cel param1)
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
)

