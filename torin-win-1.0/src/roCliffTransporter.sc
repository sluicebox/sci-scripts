;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20800)
(include sci.sh)
(use Main)
(use oTPEgo)
(use oHandsOnWhenCued)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roCliffTransporter 0
)

(instance oRSDHandler of VerbHandler
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 13) ; ioEressdy
			(gEgo setScript: soGetOuttaDodge)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance foCryst of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 13)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 262 0 336 -2 344 33 349 113 362 118 373 160 370 173 390 186 399 277 317 284 249 282 245 168 262 160 257 72 265 63
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gEgo setScript: soGetOuttaDodge)
			)
			(13 ; ioEressdy
				(gEgo setScript: soGetOuttaDodge)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance poTorin of Prop
	(properties)
)

(instance soGetOuttaDodge of Script
	(properties)

	(method (changeState newState &tmp oStrMsg)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 349 301 self)
			)
			(2
				(gGame handsOff:)
				(((ScriptID 64001 0) get: 9) moveTo: -3) ; oInvHandler, ioEressdy
				(gEgo setHeading: 180 self)
			)
			(3
				(gEgo hide:)
				(poTorin
					view: 20800
					loop: 0
					cel: 0
					posn: 349 301
					init:
					setCycle: CT 13 1 self
				)
			)
			(4
				(poTorin setCycle: End self)
				(goSound1 playSound: 20801 self)
			)
			(5)
			(6
				(poTorin dispose:)
				((ScriptID 64017 0) set: 112) ; oFlags
				(gCurRoom newRoom: 30000) ; roChapter3
				(self dispose:)
			)
		)
	)
)

(instance roCliffTransporter of TPRoom
	(properties
		picture 20800
	)

	(method (init)
		(super init: &rest)
		(goMusic1 setMusic: 20700)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 1 305 2 314 630 312 628 283 316 292
					yourself:
				)
		)
		(foCryst init:)
		(gEgo init: normalize:)
		(gEgo addVerbHandler: oRSDHandler)
		(gGame handsOff:)
		(gEgo posn: 650 300)
		(gEgo setMotion: MoveTo 600 300 (ScriptID 64020 0)) ; oHandsOnWhenCued
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64001 0) get: 9)) ; oInvHandler, ioEressdy
	)
)

