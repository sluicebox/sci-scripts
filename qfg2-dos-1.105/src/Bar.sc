;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Main)
(use Actor)

(class Bar of View
	(properties
		x 1000
		y 1000
		view 810
		priority 15
		signal 30737
		value 0
		max 1000
		lineObj 0
	)

	(method (init)
		(= view gStatusBarView)
		(super init: &rest)
		((= lineObj (Prop new:))
			ignoreActors:
			view: gStatusBarView
			posn: (+ x 2) y
			priority: priority
			signal: 26640
			init:
		)
		(self draw:)
	)

	(method (dispose)
		(if (IsObject lineObj)
			(lineObj dispose:)
		)
		(= lineObj 0)
		(super dispose:)
	)

	(method (draw &tmp valCel scaledValue)
		(if (< max 1)
			(= max 1)
		)
		(if (> (= scaledValue value) max)
			(= scaledValue max)
		)
		(= valCel (/ (+ (* scaledValue 10) max -1) max))
		(lineObj loop: 1 cel: valCel posn: (+ x 2) y setPri: priority)
	)
)

