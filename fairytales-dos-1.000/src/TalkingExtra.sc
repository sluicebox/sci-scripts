;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 980)
(include sci.sh)
(use Main)
(use Extra)

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

(class TalkingExtra of Extra
	(properties
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

