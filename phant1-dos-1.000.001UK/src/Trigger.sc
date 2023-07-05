;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35)
(include sci.sh)
(use Main)
(use Feature)

(public
	Trigger 0
)

(class Trigger of Feature
	(properties
		sightAngle 360
		state 8
		exitDir 0
		nextRoom 0
		interRoom 0
		appXOffset 0
		appYOffset 0
	)

	(method (init)
		(self approachVerbs: 0 setHotspot: 21 3 4) ; Exit, Move, Do
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (and nextRoom (== theVerb 21)) ; Exit
			(gGame handsOff:)
			(CueObj client: 0)
			(= global125 interRoom)
			(gCurRoom newRoom: nextRoom)
		else
			(super doVerb: theVerb)
		)
	)

	(method (handleEvent event)
		(if (!= appXOffset 0)
			(= approachX (+ (event x:) appXOffset))
		)
		(if (!= appYOffset 0)
			(= approachY (+ (event y:) appYOffset))
		)
		(super handleEvent: event)
	)
)

