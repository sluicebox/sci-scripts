;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 205)
(include sci.sh)
(use Main)
(use room5)

(public
	passToCrib 0
)

(instance passToCrib of GO
	(properties
		x 193
		y 143
		view 167
		cursorX 221
		cursorY 173
	)

	(method (init param1)
		(if (!= status0 param1)
			(= status0 param1)
			(proc0_2 view 2 status0 x y)
			(if param1
				(global517 add: self)
			else
				(global517 delete: self)
			)
		)
	)

	(method (doit param1)
		(if (and status0 (not global184) global180)
			(if
				(and
					argc
					(or (== global855 2) (== global854 13) (== global854 20992))
				)
				(= global321 param1)
				(if (proc5_7 x (+ x 35) y (+ y 43))
					(param1 claimed: 1)
					(if (== status0 1)
						(gSndEffect number: 36 play:)
						((gPlayer2 altrEgo:) say: 6)
					else
						(self init: 0)
						(proc0_5)
						(= global180 0)
						((ScriptID 206) init: gPlayer0) ; cribToss
					)
				)
			)
			(if status0
				(if (== (gPlayer0 howManyCardsDim:) 2)
					(self init: 2)
				else
					(self init: 1)
				)
			)
		)
	)
)

