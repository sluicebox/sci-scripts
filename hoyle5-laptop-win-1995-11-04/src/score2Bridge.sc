;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 781)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use BScore)
(use GameControls)
(use System)

(public
	score2Bridge 0
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
			781
			4
			(/ param1 10000)
			param2
			param3
			15
			bridgeScore2Window
			{score}
		)
	)
	(if (>= param1 1000)
		(proc0_10
			781
			4
			(mod (/ param1 1000) 10)
			(+ param2 11)
			param3
			15
			bridgeScore2Window
			{score}
		)
	)
	(if (>= param1 100)
		(proc0_10
			781
			4
			(mod (/ param1 100) 10)
			(+ param2 22)
			param3
			15
			bridgeScore2Window
			{score}
		)
	)
	(if (>= param1 10)
		(proc0_10
			781
			4
			(mod (/ param1 10) 10)
			(+ param2 33)
			param3
			15
			bridgeScore2Window
			{score}
		)
	)
	(if (>= param1 0)
		(proc0_10
			781
			4
			(mod param1 10)
			(+ param2 44)
			param3
			15
			bridgeScore2Window
			{score}
		)
	)
)

(procedure (localproc_1)
	(= local0 gGameControls)
	(EnableCursor)
	((= gGameControls bridgeScore2)
		plane: bridgeScore2Window
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add: (iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
	(if (not (HaveMouse))
		(gMouseCursor x: (+ 125 (iconOK nsLeft:)) y: (+ 61 (iconOK nsTop:)))
		(SetCursor (gMouseCursor x:) (gMouseCursor y:))
	)
)

(instance score2Bridge of Code
	(properties)

	(method (init)
		(localproc_1)
	)
)

(instance bridgeScore2Window of InvisibleWindow
	(properties
		left 105
		top 48
		right 461
		bottom 461
	)

	(method (init &tmp temp0)
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 781 0 0 0 0 15 self)
		(proc0_10
			781
			2
			(or (BScore weRubberBonus:) (BScore theyRubberBonus:))
			7
			113
			15
			self
			{score}
		)
		(proc0_10 781 3 0 7 60 15 self {score})
		(proc0_10
			781
			1
			(if (or (BScore weUndertricks:) (BScore theyUndertricks:)) 0 else 1)
			10
			49
			15
			self
			{score}
		)
		(localproc_0 (BScore weRubberBonus:) 194 48)
		(localproc_0 (BScore weSlamBonus:) 194 75)
		(localproc_0 (BScore weMadeDoubled:) 194 102)
		(localproc_0 (BScore weHonors:) 194 129)
		(localproc_0 (BScore weOvertricks:) 194 156)
		(localproc_0 (BScore weUndertricks:) 194 156)
		(localproc_0 (BScore wePrevOverLine:) 194 183 1)
		(localproc_0 (BScore weGame1:) 194 210)
		(localproc_0 (BScore weGame2:) 194 237)
		(localproc_0 (BScore weGame3:) 194 264)
		(localproc_0 (BScore weTotal:) 194 291 1)
		(localproc_0 (BScore theyRubberBonus:) 269 48)
		(localproc_0 (BScore theySlamBonus:) 269 75)
		(localproc_0 (BScore theyMadeDoubled:) 269 102)
		(localproc_0 (BScore theyHonors:) 269 129)
		(localproc_0 (BScore theyOvertricks:) 269 156)
		(localproc_0 (BScore theyUndertricks:) 269 156)
		(localproc_0 (BScore theyPrevOverLine:) 269 183 1)
		(localproc_0 (BScore theyGame1:) 269 210)
		(localproc_0 (BScore theyGame2:) 269 237)
		(localproc_0 (BScore theyGame3:) 269 264)
		(localproc_0 (BScore theyTotal:) 269 291 1)
	)
)

(instance bridgeScore2 of HoyleGameControls
	(properties)
)

(instance iconOK of ControlIcon
	(properties
		nsLeft 186
		nsTop 316
		x 186
		y 316
		signal 387
		mainView 781
		mainLoop 6
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
		((gCurRoom script:) cue:)
	)
)

