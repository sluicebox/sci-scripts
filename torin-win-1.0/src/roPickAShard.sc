;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15500)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use n64896)
(use Talker)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)

(public
	roPickAShard 0
	toHerman 1
)

(instance foShards of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 309 191 266 119 287 83 295 89 318 57 343 86 354 34 401 1 419 2 431 44 398 95 418 92 429 141 459 149 439 194 339 231 339 201 351 194
					yourself:
				)
		)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gEgo get: ((ScriptID 64001 0) get: 12)) ; oInvHandler, ioConsoleShard
		((ScriptID 64017 0) set: 36) ; oFlags
		(gCurRoom newRoom: 15200) ; roPortalChamber
	)
)

(instance poPickAShard of Prop
	(properties
		x 391
		y 316
		view 15107
	)
)

(instance voTorin of View
	(properties
		x 391
		y 316
		view 15114
	)
)

(instance voHerman of View
	(properties
		x 391
		y 316
		view 15112
	)
)

(instance voHermanMouth of View
	(properties
		x 391
		y 316
		view 15112
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 317)
	)
)

(instance toHerman of Talker
	(properties
		x 391
		y 316
		view 15112
		loop 1
		priority 317
	)

	(method (init)
		(voHermanMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voHermanMouth show:)
		(super dispose: &rest)
	)
)

(instance soPickAShard of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poPickAShard init:)
				(FadeToBlack 0 10 self)
			)
			(1
				(poPickAShard setCycle: End self)
				(foShards init:)
				(= gnHermanTalker 0)
				(gMessager say: 0 0 4 2 self 15200) ; "Pick a shard, any shard!"
			)
			(2)
			(3
				(poPickAShard dispose:)
				(voTorin init:)
				(voHerman init:)
				(voHermanMouth init:)
				(= gnHermanTalker 7)
				(gMessager say: 0 0 4 3 self 15200) ; "Hee, hee! I been waitin' 15 years to use that line!"
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance roPickAShard of TPRoom
	(properties
		picture 15102
	)

	(method (init)
		(super init: &rest)
		(gGame handsOff:)
		(goMusic1 setMusic: 15100)
		(gCurRoom setScript: soPickAShard)
	)
)

