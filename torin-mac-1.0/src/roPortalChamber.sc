;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15200)
(include sci.sh)
(use Main)
(use oTPEgo)
(use oHandsOnWhenCued)
(use TPScript)
(use CueMe)
(use n64896)
(use Plane)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Motion)
(use Actor)
(use System)

(public
	roPortalChamber 0
	toHerman 1
)

(instance voPlatform of View
	(properties
		approachX 219
		approachY 172
		x 191
		y 204
		view 15204
	)

	(method (init)
		(super init: &rest)
		(self setPri: 199)
		(if (not ((ScriptID 64017 0) test: 44)) ; oFlags
			(self addHotspotVerb: 1)
		)
		(self addHotspotVerb: 13)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gMessager say: 6 1 5 0) ; "That podium must be important to this huge crystal or it wouldn't be protected by those giant stones."
			)
			(13 ; ioEressdy
				(gCurRoom setScript: soTransport)
			)
		)
	)
)

(instance voStonePillar1 of View
	(properties
		x 191
		y 204
		view 15204
		cel 1
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(|= signal $1000)
	)

	(method (doVerb)
		(gMessager say: 4 1 5 0) ; "These stones are much too large to lower by hand. That console MUST be the answer."
	)
)

(instance voStonePillar2 of View
	(properties
		x 191
		y 204
		view 15204
		cel 2
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(self setPri: 203)
		(|= signal $1000)
	)

	(method (doVerb)
		(gMessager say: 4 1 5 0) ; "These stones are much too large to lower by hand. That console MUST be the answer."
	)
)

(instance voStonePillar3 of View
	(properties
		x 159
		y 201
		view 15204
		cel 3
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(|= signal $1000)
	)

	(method (doVerb)
		(gMessager say: 4 1 5 0) ; "These stones are much too large to lower by hand. That console MUST be the answer."
	)
)

(instance voStonePillar4 of View
	(properties
		x 177
		y 200
		view 15204
		cel 4
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(|= signal $1000)
	)

	(method (doVerb)
		(gMessager say: 4 1 5 0) ; "These stones are much too large to lower by hand. That console MUST be the answer."
	)
)

(instance foPortal of Feature
	(properties
		nsRight 85
		nsBottom 134
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1 13)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(if ((ScriptID 64017 0) test: 44) ; oFlags
					(gMessager say: 6 1 1 0) ; "Now, how do I get through this thing?"
				else
					(gMessager say: 6 1 5 0) ; "That podium must be important to this huge crystal or it wouldn't be protected by those giant stones."
				)
			)
			(13 ; ioEressdy
				(gCurRoom setScript: soTransport)
			)
		)
	)
)

(instance oRSDHandler of VerbHandler
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 13) ; ioEressdy
			(gCurRoom setScript: soTransport)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance foFont of Feature
	(properties
		nsLeft 309
		nsTop 122
		nsRight 336
		nsBottom 187
		approachX 346
		approachY 200
		x 345
		y 199
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 3 1 15)
		(self approachVerbs: 1 2) ; Do, ioAx
	)

	(method (doVerb theVerb)
		(switch theVerb
			(15 ; ioBoogleBox
				(gMessager say: 3 theVerb 1 0) ; "Nah, Boogle would never hold still THAT long!"
			)
			(1 ; Do
				(gCurRoom setScript: soTakePowderAttempt)
			)
			(3 ; ioPouch
				(gCurRoom setScript: soTakePowder)
			)
		)
	)
)

(instance poTorinScoopsPowder of Prop
	(properties
		x 227
		y 315
		view 15203
		loop 1
	)
)

(instance poDust of Prop
	(properties
		x 474
		y 258
		view 15203
		loop 3
	)
)

(instance poTorinShrugs of Prop
	(properties
		x 347
		y 202
		view 15201
		loop 1
	)
)

(instance poTorinBagsPowder of Prop
	(properties
		x 251
		y 315
		view 15203
		loop 2
	)
)

(instance poTorinPutsAwayPouch of Prop
	(properties
		x 347
		y 202
		view 15201
	)
)

(instance soTakePowderAttempt of TPScript
	(properties
		bHasFF 1
	)

	(method (ff)
		(if (== (gCurRoom plane:) oFontAttemptCU)
			(gCurRoom deleteRoomPlane: oFontAttemptCU)
		)
		(poTorinShrugs dispose:)
		(gEgo show:)
		(goSound1 stop:)
		(gGame handsOn:)
		(self dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 64017 0) set: 38) ; oFlags
				(gCurRoom addRoomPlane: oFontAttemptCU)
				(poTorinScoopsPowder setCel: 0 init:)
				(= ticks 100)
			)
			(1
				(poTorinScoopsPowder setCycle: CT 5 1 self)
			)
			(2
				(gMessager say: 3 1 1 0 self) ; "This powder MUST be important. But what if there isn't any of it in The Lands Below? I'd better find something to hold enough so I can get home again!"
				(self setScript: soDustActions self)
			)
			(3)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soDustActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poDust setCel: 0 init: setCycle: ForwardCounter 6 self)
				(goSound1 playSound: 15206)
			)
			(1
				(gCurRoom deleteRoomPlane: oFontAttemptCU)
				(gEgo hide:)
				(poTorinShrugs setCel: 0 init:)
				(= ticks 90)
			)
			(2
				(poTorinShrugs setCycle: End self)
			)
			(3
				(poTorinShrugs dispose:)
				(gEgo show:)
				(self dispose:)
			)
		)
	)
)

(instance soTakePowder of TPScript
	(properties
		bHasFF 1
		bHasRew 1
	)

	(method (ff)
		(if (== (gCurRoom plane:) oFontCU)
			(gCurRoom deleteRoomPlane: oFontCU)
		)
		(poTorinPutsAwayPouch dispose:)
		(foFont deleteHotspotVerb: 1 3 15)
		(gEgo put: ((ScriptID 64001 0) get: 2)) ; oInvHandler, ioPouch
		(gEgo get: ((ScriptID 64001 0) get: 9)) ; oInvHandler, ioEressdy
		((ScriptID 64017 0) set: 9) ; oFlags
		(gGame handsOn:)
		(self dispose:)
	)

	(method (rewind)
		(if (== (gCurRoom plane:) oFontCU)
			(gCurRoom deleteRoomPlane: oFontCU)
		)
		(poTorinPutsAwayPouch dispose:)
		(gEgo get: ((ScriptID 64001 0) get: 2)) ; oInvHandler, ioPouch
		(gEgo put: ((ScriptID 64001 0) get: 9)) ; oInvHandler, ioEressdy
		((ScriptID 64017 0) unSet: 9) ; oFlags
		(gCurRoom setScript: self)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 64017 0) set: 38) ; oFlags
				(gCurRoom addRoomPlane: oFontCU)
				(poTorinBagsPowder setCel: 0 init:)
				(= ticks 100)
			)
			(1
				(gMessager say: 3 3 1 0 self) ; "I'd better get enough of this powder to last. If it does take me to The Lands Below, I'll need enough to get home again!"
				(self setScript: soBagActions self)
			)
			(2)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soBagActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poTorinBagsPowder setCycle: End self)
			)
			(1
				(poTorinBagsPowder cel: 4 setCycle: End self)
			)
			(2
				(poTorinBagsPowder cel: 4 setCycle: End self)
			)
			(3
				(= ticks 30)
			)
			(4
				(gCurRoom deleteRoomPlane: oFontCU)
				(gEgo hide:)
				(poTorinPutsAwayPouch setCel: 0 init:)
				(= ticks 90)
			)
			(5
				(poTorinPutsAwayPouch setCycle: End self)
			)
			(6
				(foFont deleteHotspotVerb: 1 3 15)
				(gEgo put: ((ScriptID 64001 0) get: 2)) ; oInvHandler, ioPouch
				(gEgo get: ((ScriptID 64001 0) get: 9)) ; oInvHandler, ioEressdy
				((ScriptID 64017 0) set: 9) ; oFlags
				(poTorinPutsAwayPouch setCycle: Beg self)
			)
			(7
				(poTorinPutsAwayPouch dispose:)
				(gEgo show:)
				(self dispose:)
			)
		)
	)
)

(instance foConsole of Feature
	(properties
		nsLeft 251
		nsTop 63
		nsRight 295
		nsBottom 110
		approachX 282
		approachY 97
		x 270
		y 109
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1 22)
		(self approachVerbs: 1 2) ; Do, ioAx
	)

	(method (doVerb theVerb)
		(switch theVerb
			(22 ; ioConsoleShard
				(gCurRoom newRoom: 15600) ; roCrystalConsole
			)
			(1 ; Do
				(gCurRoom newRoom: 15600) ; roCrystalConsole
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soTransport of TPScript
	(properties
		bHasFF 1
	)

	(method (ff)
		(goSound1 stop:)
		((ScriptID 64017 0) set: 45) ; oFlags
		(gCurRoom newRoom: 20000) ; roChapter2
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo approach: voPlatform self)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(self setScript: (ScriptID 64018 1) self) ; soBoogleIntoPouch
			)
			(3
				(voPlatform setPri: 154)
				(gEgo setMotion: MoveTo 219 174 self)
			)
			(4
				(gEgo setHeading: 135 self)
			)
			(5
				(gMessager say: 4 13 0 0 self) ; "Hang on, Boogle! I hope I'm right about this."
			)
			(6
				(gCurRoom addRoomPlane: oCrystalCU)
				(poTransport setCel: 0 init:)
				(= ticks 180)
			)
			(7
				(goSound1 playSound: 15202)
				(poTransport setCycle: End self)
			)
			(8
				(= ticks (poTransport cycleSpeed:))
			)
			(9
				(poTransport dispose:)
				(= ticks 300)
			)
			(10
				((ScriptID 64017 0) set: 45) ; oFlags
				(FadeToBlack 1 10 self)
			)
			(11
				(gEgo put: ((ScriptID 64001 0) get: 0)) ; oInvHandler, ioAx
				(gCurRoom newRoom: 20000) ; roChapter2
			)
		)
	)
)

(instance poTransport of Prop
	(properties
		x 161
		y 270
		view 15200
	)
)

(instance oCrystalCU of Plane
	(properties
		picture 15201
		priority 20
	)

	(method (init)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
	)
)

(instance oFontCU of Plane
	(properties
		picture 15700
		priority 20
	)

	(method (init)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
	)
)

(instance oFontAttemptCU of Plane
	(properties
		picture 15701
		priority 20
	)

	(method (init)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
	)
)

(instance soBoogleEntrance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 64018 0) ; oBoogle
					setWander: 0
					posn: 655 285
					loop: 7
					setMotion: MoveTo 575 245 self
				)
			)
			(1
				((ScriptID 64018 0) setMotion: MoveTo 434 156 self) ; oBoogle
			)
			(2
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(self dispose:)
			)
		)
	)
)

(instance foExit of Feature
	(properties
		nsLeft 529
		nsTop 220
		nsRight 630
		nsBottom 314
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 7)) ; oSouthEastCursor
	)

	(method (doVerb)
		(gEgo setScript: soExit)
	)
)

(instance soExit of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 630 314 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 660 338 self)
			)
			(2
				(gEgo setMotion: MoveTo 670 348)
				(= cycles 2)
			)
			(3
				(gCurRoom newRoom: 15100) ; roGuardHouseInt
			)
		)
	)
)

(instance oDoneEntering of CueMe
	(properties)

	(method (cue)
		(if ((ScriptID 64017 0) test: 37) ; oFlags
			(gGame handsOn:)
		else
			(gEgo setScript: soTalkToGuard)
		)
	)
)

(instance poHerman of Prop
	(properties
		x 608
		y 308
		view 15205
		loop 2
	)
)

(instance toHerman of Talker
	(properties
		x 608
		y 308
		view 15205
		loop 1
		priority 309
	)

	(method (init)
		(voHermanBody init:)
		(poHerman hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voHermanBody dispose:)
		(poHerman show:)
		(super dispose: &rest)
	)
)

(instance voHermanBody of View
	(properties
		x 608
		y 308
		view 15205
	)
)

(instance soTalkToGuard of TPScript
	(properties
		bHasFF 1
		bHasRew 1
	)

	(method (ff)
		(gEgo setMotion: 0 posn: 503 281 loop: 4 stopwalk: show:)
		(poHerman dispose:)
		((ScriptID 64017 0) set: 37) ; oFlags
		(gGame handsOn:)
		(self dispose:)
	)

	(method (rewind)
		(gEgo setMotion: 0 posn: 503 281 loop: 4 stopwalk: show:)
		(poHerman setCel: 0 init:)
		((ScriptID 64017 0) unSet: 37) ; oFlags
		(gGame handsOff:)
		(gEgo setScript: self)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 503 281 self)
			)
			(1
				(gEgo setHeading: 135 self)
			)
			(2
				(= gnHermanTalker 8)
				(gMessager sayRange: 0 0 4 4 8 self) ; "There ya go, boy. The joint's all yours. I'm gonna grab my pie and hit the road. Gotta get on home, ya know. That is, if I can remember where home is..."
			)
			(3
				(poHerman setCycle: End self)
			)
			(4
				((ScriptID 64017 0) set: 37) ; oFlags
				(poHerman dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance roPortalChamber of TPRoom
	(properties
		picture 15200
	)

	(method (init)
		(if ((ScriptID 64017 0) test: 44) ; oFlags
			(= picture 15202)
		)
		(super init: &rest)
		(gGame handsOn:)
		(gEgo init: normalize: setScaler: Scaler 115 50 281 103)
		(gEgo addVerbHandler: oRSDHandler)
		((ScriptID 64018 0) init: normalize: setScaler: Scaler 115 50 281 103) ; oBoogle
		(switch gPrevRoomNum
			(15600 ; roCrystalConsole
				(gEgo
					posn: (foConsole approachX:) (foConsole approachY:)
					loop: 5
				)
			)
			(else
				(gGame handsOff:)
				(gEgo
					posn: 650 310
					loop: 7
					setMotion: MoveTo 575 270 oDoneEntering
				)
				((ScriptID 64018 0) setScript: soBoogleEntrance) ; oBoogle
			)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 633 318 614 245 542 183 398 130 319 120 317 103 276 96 312 104 294 117 245 113 245 105 169 116 135 120 107 122 0 140 0 322
					yourself:
				)
		)
		(if (not ((ScriptID 64017 0) test: 37)) ; oFlags
			(poHerman setCel: 0 init:)
		)
		(if
			(and
				(not (gEgo has: ((ScriptID 64001 0) get: 9))) ; oInvHandler, ioEressdy
				((ScriptID 64017 0) test: 44) ; oFlags
			)
			(foFont init:)
		)
		(if ((ScriptID 64017 0) test: 44) ; oFlags
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 136 202 136 170 205 146 288 148 296 168 354 181 354 189 315 194 294 197 256 216 185 219
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 119 203 136 170 204 147 272 147 298 156 303 197 260 214 187 221
						yourself:
					)
			)
		)
		(if (not ((ScriptID 64017 0) test: 44)) ; oFlags
			(foConsole init:)
		)
		(if (not ((ScriptID 64017 0) test: 40)) ; oFlags
			(voStonePillar1 init:)
		)
		(if (not ((ScriptID 64017 0) test: 41)) ; oFlags
			(voStonePillar2 init:)
		)
		(if (not ((ScriptID 64017 0) test: 42)) ; oFlags
			(voStonePillar3 init:)
		)
		(if (not ((ScriptID 64017 0) test: 43)) ; oFlags
			(voStonePillar4 init:)
		)
		(voPlatform init:)
		(foPortal init:)
		(foExit init:)
		(goMusic1 setMusic: 15200)
	)
)

