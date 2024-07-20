;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 780)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use h5Messager)
(use BScore)
(use GameControls)
(use User)
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
		(proc0_10
			780
			1
			(/ param1 10000)
			param2
			param3
			15
			bridgeScoreWindow
			{score}
		)
	)
	(if (>= param1 1000)
		(proc0_10
			780
			1
			(mod (/ param1 1000) 10)
			(+ param2 12)
			param3
			15
			bridgeScoreWindow
			{score}
		)
	)
	(if (>= param1 100)
		(proc0_10
			780
			1
			(mod (/ param1 100) 10)
			(+ param2 24)
			param3
			15
			bridgeScoreWindow
			{score}
		)
	)
	(if (>= param1 10)
		(proc0_10
			780
			1
			(mod (/ param1 10) 10)
			(+ param2 36)
			param3
			15
			bridgeScoreWindow
			{score}
		)
	)
	(if (>= param1 0)
		(proc0_10
			780
			1
			(mod param1 10)
			(+ param2 48)
			param3
			15
			bridgeScoreWindow
			{score}
		)
	)
)

(procedure (localproc_1)
	(= local0 gGameControls)
	(EnableCursor)
	((= gGameControls bridgeScore)
		plane: bridgeScoreWindow
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add: (iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
	(if (not (HaveMouse))
		(gMouseCursor
			x: (+ (/ (- gScreenWidth 338) 2) (iconOK nsLeft:) 20)
			y: (+ 113 (iconOK nsTop:))
		)
		(SetCursor (gMouseCursor x:) (gMouseCursor y:))
	)
)

(instance scoreBridge of Code
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

(instance bridgeScoreWindow of InvisibleWindow
	(properties)

	(method (init &tmp temp0)
		(= top 100)
		(= left (/ (- gScreenWidth 338) 2))
		(= bottom 345)
		(= right (+ (/ (- gScreenWidth 338) 2) 338))
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 780 0 0 0 0 15 self)
		(localproc_0 (BScore wePrevOverLine:) 175 65 1)
		(localproc_0 (BScore weGame1:) 175 92)
		(localproc_0 (BScore weGame2:) 175 119)
		(localproc_0 (BScore weGame3:) 175 146)
		(localproc_0 (BScore weTotal:) 175 173 1)
		(localproc_0 (BScore theyPrevOverLine:) 250 65 1)
		(localproc_0 (BScore theyGame1:) 250 92)
		(localproc_0 (BScore theyGame2:) 250 119)
		(localproc_0 (BScore theyGame3:) 250 146)
		(localproc_0 (BScore theyTotal:) 250 173 1)
	)
)

(instance bridgeScore of HoyleGameControls
	(properties)
)

(instance iconOK of ControlIcon
	(properties
		nsLeft 167
		nsTop 200
		x 167
		y 200
		signal 387
		mainView 780
		mainLoop 2
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
	)
)

