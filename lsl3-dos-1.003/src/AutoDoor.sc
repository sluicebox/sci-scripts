;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 51)
(include sci.sh)
(use Main)
(use Door)
(use Motion)

(class AutoDoor of Door
	(properties)

	(method (init)
		(super init:)
	)

	(method (doit)
		(super doit:)
		(cond
			(code
				(if (code doit: self)
					(self open:)
				else
					(self close:)
				)
			)
			((& (gEgo onControl:) doorCtrl)
				(self open:)
			)
			(else
				(self close:)
			)
		)
	)

	(method (open)
		(if (and (not locked) (!= doorState 1) (!= doorState 2))
			(= doorState 1)
			(self setCycle: End self)
			(if openSnd
				(openSnd play:)
			)
		)
	)

	(method (close)
		(if (and (!= doorState 3) (!= doorState 0))
			(= doorState 3)
			(self setCycle: Beg self)
			(if closeSnd
				(closeSnd play:)
			)
		)
	)
)

