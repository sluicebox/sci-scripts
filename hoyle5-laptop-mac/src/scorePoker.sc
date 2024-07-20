;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1180)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use h5Messager)
(use GameControls)
(use User)
(use System)

(public
	scorePoker 0
)

(local
	local0
)

(procedure (localproc_0 param1 param2 param3)
	(cond
		((>= param1 1000)
			(drawSigns doit: param2 param3)
			(proc0_10
				1180
				3
				(mod (/ param1 1000) 10)
				(+ param2 -10)
				param3
				15
				pokerScoreWindow
				{score}
			)
			(proc0_10
				1180
				3
				(mod (/ param1 100) 10)
				(+ param2 1)
				param3
				15
				pokerScoreWindow
				{score}
			)
			(proc0_10
				1180
				3
				(mod (/ param1 10) 10)
				(+ param2 12)
				param3
				15
				pokerScoreWindow
				{score}
			)
			(proc0_10
				1180
				3
				(mod param1 10)
				(+ param2 23)
				param3
				15
				pokerScoreWindow
				{score}
			)
		)
		((>= param1 100)
			(drawSigns doit: (+ param2 11) param3)
			(proc0_10
				1180
				3
				(mod (/ param1 100) 10)
				(+ param2 1)
				param3
				15
				pokerScoreWindow
				{score}
			)
			(proc0_10
				1180
				3
				(mod (/ param1 10) 10)
				(+ param2 12)
				param3
				15
				pokerScoreWindow
				{score}
			)
			(proc0_10
				1180
				3
				(mod param1 10)
				(+ param2 23)
				param3
				15
				pokerScoreWindow
				{score}
			)
		)
		((>= param1 10)
			(drawSigns doit: (+ param2 22) param3)
			(proc0_10
				1180
				3
				(mod (/ param1 10) 10)
				(+ param2 12)
				param3
				15
				pokerScoreWindow
				{score}
			)
			(proc0_10
				1180
				3
				(mod param1 10)
				(+ param2 23)
				param3
				15
				pokerScoreWindow
				{score}
			)
		)
		((>= param1 0)
			(drawSigns doit: (+ param2 33) param3)
			(proc0_10
				1180
				3
				(mod param1 10)
				(+ param2 23)
				param3
				15
				pokerScoreWindow
				{score}
			)
		)
	)
)

(procedure (localproc_1)
	(= local0 gGameControls)
	(gGame setCursor: 999)
	((= gGameControls pokerScore)
		plane: pokerScoreWindow
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add: (iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
	(if (not (HaveMouse))
		(gMouseCursor
			x: (+ (/ (- gScreenWidth 310) 2) (iconOK nsLeft:) 20)
			y: (+ (/ (- gScreenHeight 280) 2) (iconOK nsTop:) 13)
		)
		(SetCursor (gMouseCursor x:) (gMouseCursor y:))
	)
)

(instance scorePoker of Code
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
		(proc64996_0)
		(PlaySong play: 0)
	)
)

(instance drawSigns of Code
	(properties)

	(method (doit param1 param2)
		(proc0_10
			1180
			6
			0
			(- param1 25)
			(- param2 0)
			15
			pokerScoreWindow
			{score}
		)
	)
)

(instance pokerScoreWindow of InvisibleWindow
	(properties)

	(method (init &tmp temp0)
		(= top (/ (- gScreenHeight 280) 2))
		(= left (/ (- gScreenWidth 310) 2))
		(= bottom (+ (/ (- gScreenHeight 280) 2) 280))
		(= right (+ (/ (- gScreenWidth 310) 2) 310))
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 1180 0 0 0 0 15 self)
		(= temp0 (((global117 at: 1) owner:) view:))
		(if global916
			(-= temp0 1400)
		)
		(proc0_10 1180 (if global916 2 else 1) temp0 160 80 15 self {score})
		(localproc_0 ((global117 at: 1) total:) 219 65)
		(= temp0 (((global117 at: 2) owner:) view:))
		(if global916
			(-= temp0 1400)
		)
		(proc0_10 1180 (if global916 2 else 1) temp0 160 110 15 self {score})
		(localproc_0 ((global117 at: 2) total:) 219 95)
		(= temp0 (((global117 at: 3) owner:) view:))
		(if global916
			(-= temp0 1400)
		)
		(proc0_10 1180 (if global916 2 else 1) temp0 160 140 15 self {score})
		(localproc_0 ((global117 at: 3) total:) 219 125)
		(proc0_10 1180 5 0 160 170 15 self {score})
		(localproc_0 ((global117 at: 0) total:) 219 155)
	)
)

(instance pokerScore of HoyleGameControls
	(properties)
)

(instance iconOK of ControlIcon
	(properties
		nsLeft 179
		nsTop 201
		x 179
		y 201
		signal 387
		mainView 1180
		mainLoop 4
		highlightColor -1
	)

	(method (doit)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
	)
)

