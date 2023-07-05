;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 205)
(include sci.sh)
(use Actor)
(use System)

(class StatusBar of Obj
	(properties
		value 0
		max 1000
		x 1000
		y 1000
		priority 15
		titleCel 0
		lineObj 0
		theLoop 0
	)

	(method (init)
		(Load rsVIEW 803)
		(super init: &rest)
		((= lineObj (View new:))
			ignoreActors:
			view: 803
			posn: x y 3
			stopUpd:
			init:
		)
		(self draw:)
	)

	(method (dispose)
		(if (IsObject lineObj)
			(lineObj dispose:)
		)
		(super dispose:)
	)

	(method (draw &tmp temp0 temp1 temp2)
		(if (< max 1)
			(= max 1)
		)
		(if (> (= temp1 value) max)
			(= temp1 max)
		)
		(= temp2 (/ max 2))
		(= temp0 (/ (+ (= temp1 (/ (* temp1 50) temp2)) 9) 10))
		(lineObj loop: 1 cel: temp0 posn: (+ x 2) y forceUpd: stopUpd:)
	)
)

