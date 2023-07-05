;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 205)
(include sci.sh)
(use Main)
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
	)

	(method (init)
		(Load rsVIEW global302)
		((PV new:)
			view: global302
			loop: 0
			cel: titleCel
			x: x
			y: y
			z: 1
			priority: priority
			init:
		)
		((PV new:)
			view: global302
			loop: 0
			cel: 3
			x: x
			y: y
			z: 2
			priority: priority
			init:
		)
		(gAddToPics doit:)
		((= lineObj (Prop new:))
			ignoreActors:
			view: global302
			posn: x y 3
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

	(method (draw &tmp temp0 temp1)
		(if (< max 1)
			(= max 1)
		)
		(if (> (= temp1 value) max)
			(= temp1 max)
		)
		(= temp0 (/ (+ (= temp1 (/ (+ (* temp1 100) max -1) max)) 9) 10))
		(lineObj loop: 1 cel: temp0 posn: (+ x 2) y setPri: priority stopUpd:)
	)
)

