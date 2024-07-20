;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 380)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use h5Messager)
(use GameControls)
(use User)
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
			(+ param2 36)
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
			(+ param2 54)
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
			(+ param2 72)
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
		(gMouseCursor x: (+ 140 (iconOK nsLeft:)) y: (+ 93 (iconOK nsTop:)))
		(SetCursor (gMouseCursor x:) (gMouseCursor y:))
	)
)

(instance scoreHearts of Code
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

(instance heartsScoreWindow of InvisibleWindow
	(properties
		left 120
		top 80
		right 496
		bottom 415
	)

	(method (init &tmp temp0 temp1)
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 380 0 0 0 0 15 self)
		(= temp1 (((global117 at: 1) owner:) view:))
		(if global916
			(-= temp1 1400)
		)
		(proc0_10 380 (if global916 2 else 1) temp1 170 87 15 self {score})
		(localproc_0 ((global117 at: 1) tempTotal:) 152 70 1)
		(localproc_0 ((global117 at: 1) total:) 248 70 1)
		(= temp1 (((global117 at: 2) owner:) view:))
		(if global916
			(-= temp1 1400)
		)
		(proc0_10 380 (if global916 2 else 1) temp1 170 117 15 self {score})
		(localproc_0 ((global117 at: 2) tempTotal:) 152 100 1)
		(localproc_0 ((global117 at: 2) total:) 248 100 1)
		(= temp1 (((global117 at: 3) owner:) view:))
		(if global916
			(-= temp1 1400)
		)
		(proc0_10 380 (if global916 2 else 1) temp1 170 147 15 self {score})
		(localproc_0 ((global117 at: 3) tempTotal:) 152 130 1)
		(localproc_0 ((global117 at: 3) total:) 248 130 1)
		(proc0_10 380 5 0 170 177 15 self {score})
		(localproc_0 ((global117 at: 0) tempTotal:) 152 160 1)
		(localproc_0 ((global117 at: 0) total:) 248 160 1)
	)
)

(instance heartsScore of HoyleGameControls
	(properties)
)

(instance iconOK of ControlIcon
	(properties
		nsLeft 189
		nsTop 199
		x 189
		y 199
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

