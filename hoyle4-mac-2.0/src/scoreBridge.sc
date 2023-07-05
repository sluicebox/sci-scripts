;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 780)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use BScore)
(use GameControls)
(use System)

(public
	scoreBridge 0
)

(local
	local0
)

(procedure (localproc_0 param1 param2 param3)
	(if (and (!= argc 4) (not param1))
		(return)
	)
	(if (>= param1 10000)
		(DrawCel 780 4 (/ param1 10000) param2 param3 15)
	)
	(if (>= param1 1000)
		(DrawCel 780 4 (mod (/ param1 1000) 10) (+ param2 6) param3 15)
	)
	(if (>= param1 100)
		(DrawCel 780 4 (mod (/ param1 100) 10) (+ param2 12) param3 15)
	)
	(if (>= param1 10)
		(DrawCel 780 4 (mod (/ param1 10) 10) (+ param2 18) param3 15)
	)
	(if (>= param1 0)
		(DrawCel 780 4 (mod param1 10) (+ param2 24) param3 15)
	)
)

(procedure (localproc_1)
	(= local0 gGameControls)
	(proc0_3)
	((= gGameControls bridgeScore)
		window: bridgeScoreWindow
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add: (iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
	(if (not (HaveMouse))
		(gMouseCursor x: (+ 125 (iconOK nsLeft:)) y: (+ 61 (iconOK nsTop:)))
		(SetCursor (gMouseCursor x:) (gMouseCursor y:))
	)
)

(instance scoreBridge of Code
	(properties)

	(method (init)
		(localproc_1)
	)
)

(instance bridgeScoreWindow of InvisibleWindow
	(properties
		top 48
		left 105
		bottom 129
		right 297
	)

	(method (open &tmp temp0)
		(super open:)
		(DrawCel 780 0 0 0 0 15)
		(DrawCel
			780
			2
			(if (or (BScore weRubberBonus:) (BScore theyRubberBonus:)) 1 else 0)
			7
			62
			15
		)
		(DrawCel 780 3 0 7 14 15)
		(localproc_0 (BScore wePrevOverLine:) 100 16 1)
		(localproc_0 (BScore weGame1:) 100 29)
		(localproc_0 (BScore weGame2:) 100 40)
		(localproc_0 (BScore weGame3:) 100 51)
		(localproc_0 (BScore weTotal:) 100 64 1)
		(localproc_0 (BScore theyPrevOverLine:) 151 16 1)
		(localproc_0 (BScore theyGame1:) 151 29)
		(localproc_0 (BScore theyGame2:) 151 40)
		(localproc_0 (BScore theyGame3:) 151 51)
		(localproc_0 (BScore theyTotal:) 151 64 1)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance bridgeScore of HoyleGameControls
	(properties)
)

(instance iconOK of ControlIcon
	(properties
		view 780
		loop 6
		cel 0
		nsLeft 9
		nsTop 34
		signal 387
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide: dispose:)
		(proc0_1)
		(= gGameControls local0)
	)
)

