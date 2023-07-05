;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 980)
(include sci.sh)
(use System)

(class SysWindow of Obj
	(properties
		top 0
		left 0
		bottom 0
		right 0
		color 0
		back 255
		priority -1
		window 0
		type 0
		title 0
		hMargin 4
		vMargin 4
		brTop 0
		brLeft 0
		brBottom 190
		brRight 320
		eraseOnly 0
	)

	(method (open)
		(= window
			(NewWindow top left bottom right title type priority color back)
		)
	)

	(method (dispose)
		(DisposeWindow window (self eraseOnly:))
		(super dispose:)
	)
)

