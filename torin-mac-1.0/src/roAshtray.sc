;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11300)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use foEExit)
(use Polygon)
(use Actor)

(public
	roAshtray 0
)

(instance voPouch of View
	(properties
		x 510
		y 124
		view 11300
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 420 32 438 60 498 97 514 99 519 130 525 136 560 123 562 109 555 93 541 83 547 55 521 26 479 5 424 15
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(self dispose:)
		(gEgo get: ((ScriptID 64001 0) get: 2)) ; oInvHandler, ioPouch
		((ScriptID 64017 0) set: 2) ; oFlags
		(if ((ScriptID 64017 0) test: 38) ; oFlags
			(gMessager say: 1 1 1 0) ; "Hey, Dad's old tobacco pouch would be perfect for carrying the erresdy powder."
		else
			(gMessager say: 1 1 0 0) ; "I might need this empty pouch for something."
		)
	)
)

(instance foExit of CUExitFeature
	(properties
		rExitTo 11100
	)
)

(instance roAshtray of TPRoom
	(properties
		picture 11301
	)

	(method (init)
		(super init: &rest)
		(if (not ((ScriptID 64017 0) test: 2)) ; oFlags
			(voPouch init:)
		)
		(foExit init:)
		(gGame handsOn:)
	)
)

