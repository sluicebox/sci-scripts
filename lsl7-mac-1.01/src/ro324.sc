;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 324)
(include sci.sh)
(use Main)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use soFlashCyberSniff)
(use foEExit)
(use Polygon)
(use Feature)
(use Actor)

(public
	ro324 0
)

(instance ro324 of L7Room
	(properties
		picture 32400
	)

	(method (init)
		(super init:)
		(gOMusic1 setMusic: 38000)
		(if (not ((ScriptID 64017 0) test: 67)) ; oFlags
			(voPolicy init:)
		)
		(foChairBottom init:)
		(foCUExit init:)
		(gGame handsOn:)
		(proc64896_15 4 1)
	)
)

(instance voPolicy of View
	(properties
		noun 2
		x 409
		y 404
		view 32450
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(self dispose:)
				(gEgo get: ((ScriptID 64037 0) get: 20)) ; oInvHandler, ioInsurance
				((ScriptID 64017 0) set: 67) ; oFlags
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foChairBottom of Feature
	(properties
		noun 1
		x 421
		y 210
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 593 246 602 242 606 228 602 216 440 100 246 139 237 150 237 158 350 313 362 321 374 321 456 290 511 273
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foCUExit of CUExitFeature
	(properties)

	(method (doVerb)
		(gCurRoom newRoom: 323) ; ro323
	)
)

