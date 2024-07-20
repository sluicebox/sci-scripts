;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1280)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use h5Messager)
(use GameControls)
(use User)
(use System)

(public
	scoreCheckers 0
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
			1280
			3
			(mod (/ param1 100) 10)
			param2
			param3
			15
			checkersScoreWindow
			{score}
		)
	)
	(if (>= param1 10)
		(proc0_10
			1280
			3
			(mod (/ param1 10) 10)
			(+ param2 14)
			param3
			15
			checkersScoreWindow
			{score}
		)
	)
	(if (>= param1 0)
		(proc0_10
			1280
			3
			(mod param1 10)
			(+ param2 28)
			param3
			15
			checkersScoreWindow
			{score}
		)
	)
)

(procedure (localproc_1)
	(= local0 gGameControls)
	(EnableCursor)
	((= gGameControls checkersScore)
		plane: checkersScoreWindow
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add: (iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
	(if (not (HaveMouse))
		(gMouseCursor x: (+ 152 (iconOK nsLeft:)) y: (+ 99 (iconOK nsTop:)))
		(SetCursor (gMouseCursor x:) (gMouseCursor y:))
	)
)

(instance scoreCheckers of Code
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

(instance checkersScoreWindow of InvisibleWindow
	(properties
		left 132
		top 86
		right 508
		bottom 406
	)

	(method (init &tmp temp0 temp1)
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 1280 0 0 0 0 15 self)
		(= temp1 (gChar1 view:))
		(if global916
			(-= temp1 1400)
			(proc0_10 1280 2 temp1 279 52 15 self {score})
		else
			(proc0_10 1280 1 temp1 279 52 15 self {score})
		)
		(localproc_0 ((ScriptID 1200 6) wins:) 267 64 1) ; player1
		(localproc_0 ((ScriptID 1200 7) wins:) 192 64 1) ; player2
		(localproc_0 ((ScriptID 1200 6) losses:) 267 91 1) ; player1
		(localproc_0 ((ScriptID 1200 7) losses:) 192 91 1) ; player2
		(localproc_0 ((ScriptID 1200 6) draws:) 267 118 1) ; player1
		(localproc_0 ((ScriptID 1200 7) draws:) 192 118 1) ; player2
	)
)

(instance checkersScore of HoyleGameControls
	(properties)
)

(instance iconOK of ControlIcon
	(properties
		nsLeft 167
		nsTop 141
		x 167
		y 141
		signal 387
		mainView 1280
		mainLoop 4
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
	)
)

