;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1380)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use h5Messager)
(use GameControls)
(use User)
(use System)

(public
	scoreBackgammon 0
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
			1380
			3
			(mod (/ param1 100) 10)
			(+ param2 24)
			param3
			15
			backgammonScoreWindow
			{score}
		)
	)
	(if (>= param1 10)
		(proc0_10
			1380
			3
			(mod (/ param1 10) 10)
			(+ param2 36)
			param3
			15
			backgammonScoreWindow
			{score}
		)
	)
	(if (>= param1 0)
		(proc0_10
			1380
			3
			(mod param1 10)
			(+ param2 48)
			param3
			15
			backgammonScoreWindow
			{score}
		)
	)
)

(procedure (localproc_1)
	(= local0 gGameControls)
	(EnableCursor)
	((= gGameControls backgammonScore)
		plane: backgammonScoreWindow
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add: (iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
	(if (not (HaveMouse))
		(gMouseCursor x: (+ 170 (iconOK nsLeft:)) y: (+ 133 (iconOK nsTop:)))
		(SetCursor (gMouseCursor x:) (gMouseCursor y:))
	)
)

(instance scoreBackgammon of Code
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

(instance backgammonScoreWindow of InvisibleWindow
	(properties
		left 150
		top 120
		right 526
		bottom 440
	)

	(method (init &tmp temp0 temp1)
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 1380 0 0 0 0 15 self)
		(= temp1 (gChar1 view:))
		(if global916
			(-= temp1 1400)
		)
		(proc0_10 1380 (if global916 2 else 1) temp1 284 35 15 self {score})
		(localproc_0 (global753 totalPts:) 181 56)
		(localproc_0 (global754 totalPts:) 259 56 1)
		(localproc_0 (global753 gamesWon:) 181 81)
		(localproc_0 (global754 gamesWon:) 259 81 1)
		(localproc_0 (global753 gammons:) 181 106)
		(localproc_0 (global754 gammons:) 259 106 1)
		(localproc_0 (global753 backgammons:) 181 132)
		(localproc_0 (global754 backgammons:) 259 132 1)
		(localproc_0 (global753 count:) 181 157)
		(localproc_0 (global754 count:) 259 157 1)
	)
)

(instance backgammonScore of HoyleGameControls
	(properties)
)

(instance iconOK of ControlIcon
	(properties
		nsLeft 186
		nsTop 198
		x 186
		y 198
		signal 387
		mainView 1380
		mainLoop 4
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
	)
)

