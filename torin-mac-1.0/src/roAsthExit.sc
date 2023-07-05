;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40900)
(include sci.sh)
(use Main)
(use oTPEgo)
(use oHandsOnWhenCued)
(use TPScript)
(use n64896)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roAsthExit 0
)

(instance soToConsole of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo approachThenFace: foConsole self)
			)
			(1
				(gGame handsOff:)
				(= cycles 2)
			)
			(2
				(gCurRoom newRoom: 43000) ; roAsthExitPuzzle
			)
		)
	)
)

(instance foConsole of Feature
	(properties
		approachX 491
		approachY 294
		x 500
		y 294
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 618 233 571 220 532 239 556 260 598 267 615 257
					yourself:
				)
		)
		(super init: &rest)
		(super addHotspotVerb: 1)
	)

	(method (doVerb)
		(gEgo setScript: soToConsole)
	)
)

(instance poPortalOpens of Prop
	(properties
		x 208
		y 195
		view 40902
		cycleSpeed 14
	)

	(method (init)
		(super init: &rest)
		(self setPri: 15)
	)
)

(instance soPortalOpens of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 1)
			)
			(1
				(= ticks 120)
				(gEgo setHeading: 315 self)
			)
			(2)
			(3
				(goSound1 playSound: 40905)
				(poPortalOpens setCycle: End self)
			)
			(4
				(goSound1 stop:)
				(gGame handsOn:)
				(gEgo addVerbHandler: oRSDHandler)
				(self dispose:)
			)
		)
	)
)

(instance foPhenocryst of Feature
	(properties
		nsLeft 262
		nsTop 28
		nsRight 374
		nsBottom 149
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 13 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gEgo setScript: soExaminePhenocryst 0 theVerb)
			)
			(13 ; ioEressdy
				(if ((ScriptID 64017 0) test: 156) ; oFlags
					(gCurRoom setScript: soTransport)
				else
					(gEgo setScript: soExaminePhenocryst 0 theVerb)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soExaminePhenocryst of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 314 236 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gGame handsOff:)
				(if ((ScriptID 64017 0) test: 156) ; oFlags
					(gMessager say: 6 1 6 0 self 15200) ; "That big crystal must be the portal to the next world."
				else
					(gMessager say: 1 register 1 0 self)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance oRSDHandler of VerbHandler
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 13) ; ioEressdy
			(gCurRoom setScript: soTransport 0 theVerb)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance poTransport of Prop
	(properties
		x 326
		y 322
		view 40903
	)
)

(instance soTransport of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 326 322 self)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(= cycles 3)
			)
			(3
				(gEgo hide:)
				(poTransport init: setCycle: CT 18 1 self)
			)
			(4
				(goSound1 playSound: 15202)
				(poTransport setCycle: End self)
			)
			(5
				(= ticks (poTransport cycleSpeed:))
			)
			(6
				(poTransport dispose:)
				(= ticks 120)
			)
			(7
				((ScriptID 64017 0) set: 159) ; oFlags
				(FadeToBlack 1 10 self)
			)
			(8
				(gEgo get: ((ScriptID 64001 0) get: 9)) ; oInvHandler, ioEressdy
				(gCurRoom newRoom: 50000) ; roChapter5
			)
		)
	)
)

(instance poLava1 of Prop
	(properties
		x 136
		y 172
		view 40200
		loop 4
	)

	(method (init)
		(super init: &rest)
		(self setPri: 1)
		(self setScript: soLava1)
	)
)

(instance soLava1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLava1 hide: setCel: 0)
				(= ticks (Random 1 240))
			)
			(1
				(poLava1 show: setCycle: End self)
			)
			(2
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance poLava2 of Prop
	(properties
		x 121
		y 201
		view 40200
		loop 4
	)

	(method (init)
		(super init: &rest)
		(self setPri: 1)
		(self setScript: soLava2)
	)
)

(instance soLava2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLava2 hide: setCel: 0)
				(= ticks (Random 1 240))
			)
			(1
				(poLava2 show: setCycle: End self)
			)
			(2
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance poLava3 of Prop
	(properties
		x 605
		y 184
		view 40200
		loop 7
	)

	(method (init)
		(super init: &rest)
		(self setPri: 1)
		(self setScript: soLava3)
	)
)

(instance soLava3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLava3 hide: setCel: 0)
				(= ticks (Random 1 240))
			)
			(1
				(poLava3 show: setCycle: End self)
			)
			(2
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance poLava4 of Prop
	(properties
		x 479
		y 147
		view 40200
		loop 3
	)

	(method (init)
		(super init: &rest)
		(self setPri: 1)
		(self setScript: soLava4)
	)
)

(instance soLava4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLava4 hide: setCel: 0)
				(= ticks (Random 1 240))
			)
			(1
				(poLava4 show: setCycle: End self)
			)
			(2
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance poLava5 of Prop
	(properties
		x 629
		y 131
		view 40200
		loop 7
	)

	(method (init)
		(super init: &rest)
		(self setPri: 1)
		(self setScript: soLava5)
	)
)

(instance soLava5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLava5 hide: setCel: 0)
				(= ticks (Random 1 240))
			)
			(1
				(poLava5 show: setCycle: End self)
			)
			(2
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance poLavaFlow1 of Prop
	(properties
		x 41
		y 26
		view 40904
		cycleSpeed 10
	)

	(method (init)
		(super init: &rest)
		(self setPri: 0)
		(self setCycle: RandCycle)
	)
)

(instance poLavaFlow2 of Prop
	(properties
		x 142
		y 118
		view 40904
		loop 1
		cycleSpeed 10
	)

	(method (init)
		(super init: &rest)
		(self setPri: 0)
		(self setCycle: RandCycle)
	)
)

(instance poLavaFlow3 of Prop
	(properties
		x 136
		y 166
		view 40904
		loop 2
		cycleSpeed 10
	)

	(method (init)
		(super init: &rest)
		(self setPri: 0)
		(self setCycle: RandCycle)
	)
)

(instance poLavaFlow4 of Prop
	(properties
		x 105
		y 250
		view 40904
		loop 3
		cycleSpeed 10
	)

	(method (init)
		(super init: &rest)
		(self setPri: 280)
		(self setCycle: RandCycle)
	)
)

(instance poLavaFlow5 of Prop
	(properties
		x 453
		y 143
		view 40904
		loop 4
		cycleSpeed 10
	)

	(method (init)
		(super init: &rest)
		(self setPri: 0)
		(self setCycle: RandCycle)
	)
)

(instance poLavaFlow6 of Prop
	(properties
		x 596
		y 172
		view 40904
		loop 5
		cycleSpeed 10
	)

	(method (init)
		(super init: &rest)
		(self setPri: 0)
		(self setCycle: RandCycle)
	)
)

(instance roAsthExit of TPRoom
	(properties
		picture 40900
	)

	(method (init)
		(super init: &rest)
		((ScriptID 64017 0) set: 157) ; oFlags
		(goMusic1 setMusic: 40900)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 388 205 290 198 285 222 191 238 71 236 64 249 182 267 186 294 38 309 3 359 630 355 623 307 498 309 499 282 623 284 623 264 482 264 432 237 434 216
					yourself:
				)
		)
		(gGame handsOn:)
		(foPhenocryst init:)
		(poPortalOpens init:)
		(poLava1 init:)
		(poLava2 init:)
		(poLava3 init:)
		(poLava4 init:)
		(poLava5 init:)
		(poLavaFlow1 init:)
		(poLavaFlow2 init:)
		(poLavaFlow3 init:)
		(poLavaFlow4 init:)
		(poLavaFlow5 init:)
		(poLavaFlow6 init:)
		(switch gPrevRoomNum
			(43000 ; roAsthExitPuzzle
				(gEgo
					posn: (foConsole approachX:) (foConsole approachY:)
					init:
					normalize:
					loop: 0
					stopwalk:
				)
				(if ((ScriptID 64017 0) test: 156) ; oFlags
					(gEgo setScript: soPortalOpens)
				else
					(foConsole init:)
				)
			)
			(else
				(gGame handsOff:)
				(foConsole init:)
				(gEgo
					posn: 313 456
					init:
					normalize:
					setMotion: PolyPath 412 322 (ScriptID 64020 0) ; oHandsOnWhenCued
				)
			)
		)
		(gEgo setScaler: Scaler 100 86 291 201)
	)
)

