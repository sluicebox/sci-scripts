;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 996)
(include sci.sh)
(use Main)
(use Menu)
(use System)

(class User of Obj
	(properties
		alterEgo 0
		x -1
		y -1
	)

	(method (doit &tmp temp0 temp1)
		(if (= global855 ((= temp0 (Event new:)) type:))
			(= gLastEvent temp0)
			(MapKeyToDir temp0)
			(= global854 (temp0 message:))
			(if (!= global855 4)
				(= global854 $ffff)
			)
			(if (and (!= gTheCursor 997) MenuBar)
				(gIntroSong pause: 0)
				(MenuBar handleEvent: temp0)
			)
			(if (and (== global855 4) (<= JOY_NULL global854 JOY_UPLEFT) (global517 size:))
				(global517 handleEvent: temp0)
			)
			(GlobalToLocal temp0)
			(if (not (temp0 claimed:))
				(gGame handleEvent: temp0)
			)
		)
		(temp0 dispose:)
		(= gLastEvent 0)
	)
)

