;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15700)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use foEExit)
(use Feature)

(public
	roEressdyFont 0
)

(instance foExit of CUExitFeature
	(properties
		rExitTo 15200
	)
)

(instance foFont of Feature
	(properties
		nsLeft 403
		nsTop 202
		nsRight 538
		nsBottom 280
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 3 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gMessager say: 3 1 1 0 0 15200) ; "This powder MUST be important. But what if there isn't any of it in The Lands Below? I'd better find something to hold enough so I can get home again!"
			)
			(3 ; ioPouch
				(gEgo put: ((ScriptID 64001 0) get: 2)) ; oInvHandler, ioPouch
				(gEgo get: ((ScriptID 64001 0) get: 9)) ; oInvHandler, ioEressdy
				((ScriptID 64017 0) set: 9) ; oFlags
				(gCurRoom newRoom: 15200) ; roPortalChamber
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance roEressdyFont of TPRoom
	(properties
		picture 15700
		east 15200
		west 15200
	)

	(method (init)
		(super init: &rest)
		(goMusic1 setMusic: 15600)
		(gGame handsOn:)
		(foExit init:)
		(foFont init:)
		((ScriptID 64017 0) set: 38) ; oFlags
	)
)

