;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 180)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use h5Messager)
(use GameControls)
(use User)
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
			(+ param2 36)
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
			(+ param2 54)
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
		(gMouseCursor x: (+ 140 (iconOK nsLeft:)) y: (+ 98 (iconOK nsTop:)))
		(SetCursor (gMouseCursor x:) (gMouseCursor y:))
	)
)

(instance scoreCrazy8s of Code
	(properties)

	(method (init)
		(proc17_2)
		(gSong stop:)
		(if global878
			(PlaySong play: (+ 60 global878))
		else
			(PlaySong play: 61)
		)
		(localproc_1)
		(PlaySong play: 0)
		(proc64996_0)
	)
)

(instance crazy8sScoreWindow of InvisibleWindow
	(properties
		left 120
		top 85
		right 571
		bottom 425
	)

	(method (init &tmp temp0 temp1)
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 180 0 0 0 0 15 self)
		(= temp1 (((global117 at: 1) owner:) view:))
		(if global916
			(-= temp1 1400)
		)
		(proc0_10 180 (if global916 2 else 1) temp1 170 87 15 self {score})
		(localproc_0 ((global117 at: 1) handTotal:) 180 70)
		(localproc_0 ((global117 at: 1) total:) 270 70 1)
		(= temp1 (((global117 at: 2) owner:) view:))
		(if global916
			(-= temp1 1400)
		)
		(proc0_10 180 (if global916 2 else 1) temp1 170 117 15 self {score})
		(localproc_0 ((global117 at: 2) handTotal:) 180 100)
		(localproc_0 ((global117 at: 2) total:) 270 100 1)
		(= temp1 (((global117 at: 3) owner:) view:))
		(if global916
			(-= temp1 1400)
		)
		(proc0_10 180 (if global916 2 else 1) temp1 170 147 15 self {score})
		(localproc_0 ((global117 at: 3) handTotal:) 180 130)
		(localproc_0 ((global117 at: 3) total:) 270 130 1)
		(proc0_10 180 5 0 170 177 15 self {score})
		(localproc_0 ((global117 at: 0) handTotal:) 180 160)
		(localproc_0 ((global117 at: 0) total:) 270 160 1)
	)
)

(instance crazy8sScore of HoyleGameControls
	(properties)
)

(instance iconOK of ControlIcon
	(properties
		nsLeft 189
		nsTop 199
		x 189
		y 199
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

