;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 380)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	scoreHearts 0
)

(local
	local0
)

(procedure (localproc_0 param1 param2 param3)
	(if (and (!= argc 4) (not param1))
		(return)
	)
	(if (>= param1 100)
		(DrawCel 380 3 (mod (/ param1 100) 10) (+ param2 18) param3 15)
	)
	(if (>= param1 10)
		(DrawCel 380 3 (mod (/ param1 10) 10) (+ param2 27) param3 15)
	)
	(if (>= param1 0)
		(DrawCel 380 3 (mod param1 10) (+ param2 36) param3 15)
	)
)

(procedure (localproc_1)
	(= local0 gGameControls)
	(HandsOn)
	((= gGameControls heartsScore)
		window: heartsScoreWindow
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add: (iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
	(if (not (HaveMouse))
		(gMouseCursor x: (+ 86 (iconOK nsLeft:)) y: (+ 49 (iconOK nsTop:)))
		(SetCursor (gMouseCursor x:) (gMouseCursor y:))
	)
)

(instance scoreHearts of Code
	(properties)

	(method (init)
		(localproc_1)
	)
)

(instance heartsScoreWindow of InvisibleWindow
	(properties
		top 36
		left 66
		bottom 144
		right 254
	)

	(method (open &tmp temp0 temp1)
		(super open:)
		(DrawCel 380 0 0 0 0 15)
		(= temp1 (((global117 at: 1) owner:) view:))
		(DrawCel 380 (if (>= temp1 9) 2 else 1) (mod temp1 9) 8 32 15)
		(localproc_0 ((global117 at: 1) tempTotal:) 74 33 1)
		(localproc_0 ((global117 at: 1) total:) 128 33 1)
		(= temp1 (((global117 at: 2) owner:) view:))
		(DrawCel 380 (if (>= temp1 9) 2 else 1) (mod temp1 9) 8 44 15)
		(localproc_0 ((global117 at: 2) tempTotal:) 74 45 1)
		(localproc_0 ((global117 at: 2) total:) 128 45 1)
		(= temp1 (((global117 at: 3) owner:) view:))
		(DrawCel 380 (if (>= temp1 9) 2 else 1) (mod temp1 9) 8 56 15)
		(localproc_0 ((global117 at: 3) tempTotal:) 74 57 1)
		(localproc_0 ((global117 at: 3) total:) 128 57 1)
		(DrawCel 380 5 0 8 68 15)
		(localproc_0 ((global117 at: 0) tempTotal:) 74 69 1)
		(localproc_0 ((global117 at: 0) total:) 128 69 1)
		(if
			(or
				(== ((global117 at: 0) tempTotal:) 26)
				(== ((global117 at: 1) tempTotal:) 26)
				(== ((global117 at: 2) tempTotal:) 26)
				(== ((global117 at: 3) tempTotal:) 26)
			)
			(DrawCel 380 6 0 5 87 15)
		)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance heartsScore of HoyleGameControls
	(properties)
)

(instance iconOK of ControlIcon
	(properties
		view 380
		loop 4
		cel 0
		nsLeft 127
		nsTop 86
		signal 387
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide: dispose:)
		(RedrawCast)
		(= gGameControls local0)
	)
)

