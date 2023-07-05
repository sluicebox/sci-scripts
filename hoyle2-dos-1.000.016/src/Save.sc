;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 990)
(include sci.sh)
(use System)

(class SysWindow of Obj
	(properties
		top 0
		left 0
		bottom 0
		right 0
		color 0
		back 15
		priority -1
		window 0
		type 0
		title 0
		brTop 0
		brLeft 0
		brBottom 190
		brRight 320
	)

	(method (open)
		(= window
			(NewWindow top left bottom right title type priority color back)
		)
	)

	(method (dispose)
		(DisposeWindow window)
		(super dispose:)
	)

	(method (setColor param1)
		(= color (if (>= (Graph grGET_COLOURS) 16) param1 else 0))
	)

	(method (setBack param1)
		(= back (if (>= (Graph grGET_COLOURS) 16) param1 else 15))
	)
)

