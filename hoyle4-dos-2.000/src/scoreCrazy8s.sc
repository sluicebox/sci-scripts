;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 180)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	scoreCrazy8s 0
)

(local
	local0
)

(procedure (localproc_0 param1 param2 param3)
	(if (and (!= argc 4) (not param1))
		(return)
	)
	(if (>= param1 100)
		(DrawCel 180 3 (mod (/ param1 100) 10) (+ param2 18) param3 15)
	)
	(if (>= param1 10)
		(DrawCel 180 3 (mod (/ param1 10) 10) (+ param2 27) param3 15)
	)
	(if (>= param1 0)
		(DrawCel 180 3 (mod param1 10) (+ param2 36) param3 15)
	)
)

(procedure (localproc_1)
	(= local0 gGameControls)
	(proc0_3)
	((= gGameControls crazy8sScore)
		window: crazy8sScoreWindow
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

(instance scoreCrazy8s of Code
	(properties)

	(method (init)
		(localproc_1)
	)
)

(instance crazy8sScoreWindow of InvisibleWindow
	(properties
		top 36
		left 66
		bottom 144
		right 254
	)

	(method (open &tmp temp0 temp1)
		(super open:)
		(DrawCel 180 0 0 0 0 15)
		(= temp1 (((global117 at: 1) owner:) view:))
		(DrawCel 180 (if (>= temp1 9) 2 else 1) (mod temp1 9) 3 32 15)
		(localproc_0 ((global117 at: 1) handTotal:) 74 33)
		(localproc_0 ((global117 at: 1) total:) 128 33 1)
		(= temp1 (((global117 at: 2) owner:) view:))
		(DrawCel 180 (if (>= temp1 9) 2 else 1) (mod temp1 9) 3 44 15)
		(localproc_0 ((global117 at: 2) handTotal:) 74 45)
		(localproc_0 ((global117 at: 2) total:) 128 45 1)
		(= temp1 (((global117 at: 3) owner:) view:))
		(DrawCel 180 (if (>= temp1 9) 2 else 1) (mod temp1 9) 3 56 15)
		(localproc_0 ((global117 at: 3) handTotal:) 74 57)
		(localproc_0 ((global117 at: 3) total:) 128 57 1)
		(DrawCel 180 5 0 3 68 15)
		(localproc_0 ((global117 at: 0) handTotal:) 74 69)
		(localproc_0 ((global117 at: 0) total:) 128 69 1)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance crazy8sScore of HoyleGameControls
	(properties)
)

(instance iconOK of ControlIcon
	(properties
		view 180
		loop 4
		cel 0
		nsLeft 127
		nsTop 86
		signal 387
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide: dispose:)
		(proc0_1)
		(= gGameControls local0)
	)
)

