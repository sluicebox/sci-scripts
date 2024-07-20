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
		(proc0_10
			380
			3
			(mod (/ param1 100) 10)
			(+ param2 18)
			param3
			15
			heartsScoreWindow
			{score}
		)
	)
	(if (>= param1 10)
		(proc0_10
			380
			3
			(mod (/ param1 10) 10)
			(+ param2 27)
			param3
			15
			heartsScoreWindow
			{score}
		)
	)
	(if (>= param1 0)
		(proc0_10
			380
			3
			(mod param1 10)
			(+ param2 36)
			param3
			15
			heartsScoreWindow
			{score}
		)
	)
)

(procedure (localproc_1)
	(= local0 gGameControls)
	(EnableCursor)
	((= gGameControls heartsScore)
		plane: heartsScoreWindow
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
		(proc0_10 380 0 0 0 0 15 self)
		(= temp1 (((gTheHands at: 1) owner:) view:))
		(proc0_10
			380
			(if (>= temp1 9) 2 else 1)
			(mod temp1 9)
			7
			30
			15
			self
			{score}
		)
		(localproc_0 ((gTheHands at: 1) tempTotal:) 76 31 1)
		(localproc_0 ((gTheHands at: 1) total:) 124 31 1)
		(= temp1 (((gTheHands at: 2) owner:) view:))
		(proc0_10
			380
			(if (>= temp1 9) 2 else 1)
			(mod temp1 9)
			7
			42
			15
			self
			{score}
		)
		(localproc_0 ((gTheHands at: 2) tempTotal:) 76 43 1)
		(localproc_0 ((gTheHands at: 2) total:) 124 43 1)
		(= temp1 (((gTheHands at: 3) owner:) view:))
		(proc0_10
			380
			(if (>= temp1 9) 2 else 1)
			(mod temp1 9)
			7
			54
			15
			self
			{score}
		)
		(localproc_0 ((gTheHands at: 3) tempTotal:) 76 55 1)
		(localproc_0 ((gTheHands at: 3) total:) 124 55 1)
		(proc0_10 380 5 0 7 66 15 self {score})
		(localproc_0 ((gTheHands at: 0) tempTotal:) 76 67 1)
		(localproc_0 ((gTheHands at: 0) total:) 124 67 1)
		(if
			(or
				(== ((gTheHands at: 0) tempTotal:) 26)
				(== ((gTheHands at: 1) tempTotal:) 26)
				(== ((gTheHands at: 2) tempTotal:) 26)
				(== ((gTheHands at: 3) tempTotal:) 26)
			)
			(proc0_10 380 6 0 5 87 15 self {score})
		)
	)
)

(instance heartsScore of HoyleGameControls
	(properties)
)

(instance iconOK of ControlIcon
	(properties
		nsLeft 98
		nsTop 83
		x 98
		y 83
		signal 387
		mainView 380
		mainLoop 4
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
	)
)

