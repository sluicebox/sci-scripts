;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 980)
(include sci.sh)
(use Main)

(procedure (InitSurrogate e s)
	(e initialized: 1)
	(s x: (e x:) y: (e y:))
	(if (s respondsTo: #nsRight)
		(s
			nsRight: (e nsRight:)
			nsLeft: (e nsLeft:)
			nsBottom: (e nsBottom:)
			nsTop: (e nsTop:)
		)
	)
)

(class TalkingExtra
	(properties
		x 0
		y 0
		z 0
		heading 0
		noun 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		description 0
		sightAngle 26505
		actions 0
		onMeCheck 26505
		approachX 0
		approachY 0
		approachDist 0
		_approachVerbs 26505
		lookStr 0
		yStep 2
		view 0
		loop 0
		cel 0
		priority 0
		underBits 0
		signal 0
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		brTop 0
		brLeft 0
		brBottom 0
		brRight 0
		palette 0
		cycleSpeed 1
		script 0
		cycler 0
		timer 0
		detailLevel 0
		cycleType 0
		hesitation 0
		pauseCel 0
		minPause 10
		maxPause 30
		minCycles 8
		maxCycles 20
		counter 0
		state -1
		cycles 0
		surrogate 0
		initialized 0
	)

	(method (init theSurrogate)
		(if argc
			(= surrogate theSurrogate)
		)
		(super init:)
		(self isExtra: 1)
	)

	(method (dispose)
		(if (and surrogate (not (gFeatures contains: surrogate)))
			(surrogate dispose:)
		)
		(super dispose:)
	)

	(method (addToPic)
		(if surrogate
			(if (not initialized)
				(InitSurrogate self surrogate)
			)
			(gFeatures add: surrogate)
		)
		(super addToPic: &rest)
	)

	(method (handleEvent)
		(if surrogate
			(if (not initialized)
				(InitSurrogate self surrogate)
			)
			(surrogate handleEvent: &rest)
		else
			(super handleEvent: &rest)
		)
	)
)

