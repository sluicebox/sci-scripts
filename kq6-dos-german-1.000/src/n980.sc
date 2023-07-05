;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 980)
(include sci.sh)
(use Main)
(use Gauge)

(procedure (InitSurrogate e s)
	(e keep: 1)
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

(class TalkingExtra of Gauge
	(properties
		x 0
		y 0
		z 0
		heading 0
		noun 0
		modNum -1
		actions 26505
		findTalker 0
		doVerb 26505
		sightAngle 0
		onMeCheck 0
		approachX 0
		approachY 0
		yStep 2
		view -1
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
		scaleSignal 0
		scaleX 128
		scaleY 128
		maxScale 128
		motionCue 1
		script 0
		cycleSpeed 0
		timer 0
		checkDetail 0
		setScale 0
		setInset 0
		higher 0
		lower 10
		normal 30
		minimum 8
		maximum 20
		nearestDist 0
		state -1
		cycles 0
		loopIsCorrect 0
		keep 0
	)

	(method (init theSurrogate)
		(if argc
			(= loopIsCorrect theSurrogate)
		)
		(super init:)
		(self ignoreActors: 1)
	)

	(method (dispose)
		(if (and loopIsCorrect (not (gFeatures contains: loopIsCorrect)))
			(loopIsCorrect dispose:)
		)
		(super dispose:)
	)

	(method (startUpd)
		(if loopIsCorrect
			(if (not keep)
				(InitSurrogate self loopIsCorrect)
			)
			(gFeatures add: loopIsCorrect)
		)
		(super startUpd: &rest)
	)

	(method (handleEvent)
		(if loopIsCorrect
			(if (not keep)
				(InitSurrogate self loopIsCorrect)
			)
			(loopIsCorrect handleEvent: &rest)
		else
			(super handleEvent: &rest)
		)
	)
)

