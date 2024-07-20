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
		(proc0_10
			180
			3
			(mod (/ param1 100) 10)
			(+ param2 18)
			param3
			15
			crazy8sScoreWindow
			{score}
		)
	)
	(if (>= param1 10)
		(proc0_10
			180
			3
			(mod (/ param1 10) 10)
			(+ param2 27)
			param3
			15
			crazy8sScoreWindow
			{score}
		)
	)
	(if (>= param1 0)
		(proc0_10
			180
			3
			(mod param1 10)
			(+ param2 36)
			param3
			15
			crazy8sScoreWindow
			{score}
		)
	)
)

(procedure (localproc_1)
	(= local0 gGameControls)
	(EnableCursor)
	((= gGameControls crazy8sScore)
		plane: crazy8sScoreWindow
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
		left 66
		top 36
		right 254
		bottom 144
	)

	(method (init &tmp temp0 temp1)
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 180 0 0 0 0 15 self)
		(= temp1 (((gTheHands at: 1) owner:) view:))
		(proc0_10
			180
			(if (>= temp1 9) 2 else 1)
			(mod temp1 9)
			7
			32
			15
			self
			{score}
		)
		(localproc_0 ((gTheHands at: 1) handTotal:) 74 33)
		(localproc_0 ((gTheHands at: 1) total:) 124 33 1)
		(= temp1 (((gTheHands at: 2) owner:) view:))
		(proc0_10
			180
			(if (>= temp1 9) 2 else 1)
			(mod temp1 9)
			7
			44
			15
			self
			{score}
		)
		(localproc_0 ((gTheHands at: 2) handTotal:) 74 45)
		(localproc_0 ((gTheHands at: 2) total:) 124 45 1)
		(= temp1 (((gTheHands at: 3) owner:) view:))
		(proc0_10
			180
			(if (>= temp1 9) 2 else 1)
			(mod temp1 9)
			7
			56
			15
			self
			{score}
		)
		(localproc_0 ((gTheHands at: 3) handTotal:) 74 57)
		(localproc_0 ((gTheHands at: 3) total:) 124 57 1)
		(proc0_10 180 5 0 7 68 15 self {score})
		(localproc_0 ((gTheHands at: 0) handTotal:) 74 69)
		(localproc_0 ((gTheHands at: 0) total:) 124 69 1)
	)
)

(instance crazy8sScore of HoyleGameControls
	(properties)
)

(instance iconOK of ControlIcon
	(properties
		nsLeft 98
		nsTop 83
		x 98
		y 83
		signal 387
		mainView 180
		mainLoop 4
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
	)
)

