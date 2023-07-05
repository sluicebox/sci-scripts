;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40600)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use foEExit)
(use Feature)

(public
	roWaterCannon 0
)

(instance foCannonExit of CUExitFeature
	(properties
		rExitTo 40500
	)
)

(instance foControls of Feature
	(properties
		noun 1
		nsLeft 277
		nsTop 81
		nsRight 307
		nsBottom 110
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1 74)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gMessager say: noun theVerb 0 0) ; "Hmmm. This looks like a valve...but I can't turn it with my bare hands!"
			)
			(74 ; ioWrench
				(gCurRoom setScript: soLeaveCU)
			)
		)
	)
)

(instance soLeaveCU of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo put: ((ScriptID 64001 0) get: 37)) ; oInvHandler, ioWrench
				((ScriptID 64017 0) set: 153) ; oFlags
				(= ticks 60)
			)
			(1
				(gCurRoom newRoom: 40500) ; roLavaCrossing
			)
		)
	)
)

(instance roWaterCannon of TPRoom
	(properties
		picture 40600
	)

	(method (init)
		(super init: &rest)
		((ScriptID 64017 0) set: 154) ; oFlags
		(goMusic1 setMusic: 40300)
		(foControls init:)
		(foCannonExit init:)
		(gGame handsOn:)
	)

	(method (gimme))
)

