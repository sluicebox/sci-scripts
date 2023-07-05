;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20300)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use SoTwinkle)
(use CueMe)
(use foEExit)
(use Plane)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roThroneRoom 0
)

(instance foToCliffExit of ExitFeature
	(properties
		approachX 28
		approachY 419
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 8)) ; oSouthWestCursor
		(self
			setPolygon:
				((Polygon new:) init: 26 254 95 319 -1 316 -2 252 yourself:)
		)
	)

	(method (doVerb)
		(gEgo approach: self self)
	)

	(method (cue)
		(gCurRoom newRoom: 20100) ; roCliffScroller
	)
)

(instance voKingTalkerBust of View
	(properties
		x 470
		y 206
		priority 206
		fixPriority 1
		view 20302
		loop 4
	)
)

(instance toKingTalker of Talker
	(properties
		x 470
		y 206
		view 20302
		loop 5
		priority 207
	)

	(method (init)
		(poKing hide:)
		(voKingTalkerBust init:)
		(super init: &rest)
	)

	(method (dispose)
		(poKing show:)
		(voKingTalkerBust dispose:)
		(super dispose:)
	)
)

(instance toKingDiTalker of Talker
	(properties
		x 470
		y 206
		view 20302
		loop 7
		priority 207
	)

	(method (init)
		(poKing hide:)
		(voKingTalkerBust init:)
		(super init: &rest)
	)

	(method (dispose)
		(poKing show:)
		(voKingTalkerBust dispose:)
		(super dispose:)
	)
)

(instance voQueenTalkerBust of View
	(properties
		x 522
		y 206
		priority 206
		fixPriority 1
		view 20302
		loop 8
	)
)

(instance toQueenTalker of Talker
	(properties
		x 522
		y 206
		view 20302
		loop 9
		priority 207
	)

	(method (init)
		(poQueen hide:)
		(voQueenTalkerBust init:)
		(super init: &rest)
	)

	(method (dispose)
		(poQueen show:)
		(voQueenTalkerBust dispose:)
		(super dispose:)
	)
)

(instance toQueenToKingTalker of Talker
	(properties
		x 522
		y 206
		view 20302
		loop 10
		priority 207
	)

	(method (init)
		(poQueen hide:)
		(voQueenTalkerBust init:)
		(super init: &rest)
	)

	(method (dispose)
		(poQueen show:)
		(voQueenTalkerBust dispose:)
		(super dispose:)
	)
)

(instance soApproachKing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 392 300 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soKneelAtTile of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 306 329 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(= ticks 1)
			)
			(3
				(gEgo hide:)
				(poTorin
					view: 20303
					loop: 0
					cel: 0
					posn: 299 314
					init:
					setCycle: End self
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance soUnKneelAtTile of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poTorin loop: 1 cel: 0 setCycle: End self)
			)
			(1
				(poTorin dispose:)
				(gEgo show:)
				(self dispose:)
			)
		)
	)
)

(instance soHumbleBoy of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: soKneelAtTile self)
				(gMessager say: 0 0 1 1 self) ; "Well, well. What have we here?"
			)
			(1)
			(2
				(gMessager say: 0 0 1 13 self) ; "It's nice to see humilty in SOMEbody around here!"
			)
			(3
				(= gtTorin toTorin)
				(gMessager say: 0 0 1 2 self) ; "Good day, sir."
			)
			(4
				(= gtTorin 0)
				(self setScript: soUnKneelAtTile self)
				(gMessager say: 0 0 1 3 self) ; "Yes, it 'tis, isn't it? But then, every day is a good day here in paradise."
			)
			(5)
			(6
				(gMessager sayRange: 0 0 1 4 12 self) ; "A land as lovely as this SHOULD be called Paradise."
			)
			(7
				((ScriptID 64017 0) set: 68) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poKingInvite of Prop
	(properties
		x 470
		y 206
		view 20313
	)
)

(instance soGetInvite of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 337 291 self)
			)
			(1
				(gEgo setMotion: MoveTo 404 282 self)
			)
			(2
				(gEgo setHeading: 45 self)
			)
			(3
				(poKing hide:)
				(poKingInvite init: setCycle: CT 9 1 self)
			)
			(4
				(gEgo hide:)
				(poTorin
					view: 60806
					cel: 0
					loop: 0
					posn: (gEgo x:) (gEgo y:)
					init:
					setCycle: End self
				)
				(poKingInvite setCycle: End self)
			)
			(5)
			(6
				(gEgo get: ((ScriptID 64001 0) get: 24)) ; oInvHandler, ioBallInvite
				((ScriptID 64017 0) set: 56) ; oFlags
				(gEgo show:)
				(poTorin dispose:)
				(poKing show:)
				(poKingInvite dispose:)
				(gEgo setLoop: setMotion: MoveTo 337 291 self)
			)
			(7
				(gEgo setLoop: -1)
				(self dispose:)
			)
		)
	)
)

(instance voRainbow of View
	(properties
		x 267
		y 136
		priority 1
		fixPriority 1
		view 20310
	)
)

(instance soGiveShardToKing of TPScript
	(properties)

	(method (init)
		(Load rsVIEW 20300 20312 20310)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self setScript: soApproachKing self)
			)
			(1
				(gMessager sayRange: 1 12 0 1 7 self) ; "Your Majesty, I can see you are a lover of crystals."
			)
			(2
				(gEgo setMotion: PolyPath 262 282 self)
			)
			(3
				(gEgo setHeading: 45 self)
			)
			(4
				(gEgo hide:)
				(poTorin
					view: 20300
					cel: 0
					loop: 0
					posn: (gEgo x:) (gEgo y:)
					init:
					setCycle: End self
				)
			)
			(5
				(poTorin view: 20312 loop: 0 cel: 0 setCycle: CT 8 1 self)
			)
			(6
				(gEgo put: ((ScriptID 64001 0) get: 8)) ; oInvHandler, ioShard
				(voRainbow init:)
				(poTorin setCycle: End self)
			)
			(7
				(poTorin dispose:)
				(gEgo posn: 276 290 show:)
				(gMessager sayRange: 1 12 0 8 20 self) ; "There. (POLITICIAN-LIKE, ORATOR) And as this one simple shard completes the connection between the formerly distinct spectra above us, so too therefore may our two worlds be connected by (UH, OH) the uh, peace and ah, understanding that (LOSES IT) uh, comes from, you know, ah, like that there."
			)
			(8
				(self setScript: soGetInvite self)
			)
			(9
				(gMessager say: 1 12 0 21 self) ; "Thank you, your Majesty."
			)
			(10
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soTalkToKing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self setScript: soApproachKing self)
			)
			(1
				(if (and (== gnKingTalk 3) ((ScriptID 64017 0) test: 63)) ; oFlags
					(++ gnKingTalk)
				)
				(switch gnKingTalk
					(0
						(gMessager say: 1 1 2 0 self) ; "King Rupert, Queen Di, I'm here seeking Lycentia, an evil sorceress who may be in this area. Have you heard of her?"
						(++ gnKingTalk)
					)
					(1
						(gMessager say: 1 1 3 0 self) ; "Thank you, your Majesty. Do you know how to get to the worlds below Escarpa?"
						(++ gnKingTalk)
					)
					(2
						(gMessager say: 1 1 4 0 self) ; "I can not stay long in Escarpa. I must find Lycentia."
						(++ gnKingTalk)
					)
					(3
						(self setScript: soThroneCUQueenSpeech self)
						(++ gnKingTalk)
					)
					(4
						(gMessager say: 1 1 13 0 self) ; "You mentioned a message for Leenah, your Majesty."
						(++ gnKingTalk)
					)
					(else
						(gMessager say: 1 1 8 0 self) ; "I can't wait to meet Leenah. I've never met a Princess before."
						((ScriptID 64017 0) set: 69) ; oFlags
					)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soSceptre of SoTwinkle
	(properties
		minCycle 16
		maxCycle 16
		minDelay 200
		maxDelay 500
	)
)

(instance poSceptre of Prop
	(properties
		x 470
		y 206
		view 20302
		loop 13
	)

	(method (init)
		(super init: &rest)
		(self setScript: soSceptre)
	)
)

(instance soKingBlink of SoTwinkle
	(properties
		minCycle 8
		maxCycle 8
		maxDelay 130
	)
)

(instance poKing of Prop
	(properties
		x 470
		y 206
		view 20302
		loop 11
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
		(self addHotspotVerb: 1 12 setScript: soKingBlink)
		(poSceptre init: setPri: (+ priority 1))
	)

	(method (dispose)
		(poSceptre dispose:)
		(super dispose:)
	)

	(method (hide)
		(poSceptre hide:)
		(super hide:)
	)

	(method (show)
		(poSceptre show:)
		(super show:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gEgo setScript: soTalkToKing)
			)
			(12 ; ioShard
				(gEgo setScript: soGiveShardToKing)
			)
		)
	)
)

(instance soQueenBlink of SoTwinkle
	(properties
		minCycle 8
		maxCycle 8
		maxDelay 130
	)
)

(instance poQueen of Prop
	(properties
		x 522
		y 206
		view 20302
		loop 12
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
		(self addHotspotVerb: 1 12 setScript: soQueenBlink)
	)

	(method (doVerb theVerb)
		(poKing doVerb: theVerb)
	)
)

(instance soGirl1Fanning of SoTwinkle
	(properties
		minCycle 5
		maxCycle 9
		minDelay 10
		maxDelay 100
	)
)

(instance poGirl1Fanning of Prop
	(properties
		x 378
		y 252
		view 20302
		loop 2
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
		(self addHotspotVerb: 1 setScript: soGirl1Fanning)
	)

	(method (doVerb)
		(gMessager say: 3 0 0 0) ; "Um, I'd better not. I bet the King has heard enough jokes like: "I suppose she's your biggest fan?""
	)
)

(instance soGirl2Fanning of SoTwinkle
	(properties
		minCycle 5
		maxCycle 9
		minDelay 10
		maxDelay 100
	)
)

(instance poGirl2Fanning of Prop
	(properties
		x 602
		y 276
		view 20302
		loop 3
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
		(self addHotspotVerb: 1 setScript: soGirl2Fanning)
	)

	(method (doVerb)
		(gMessager say: 4 0 0 0) ; "Is it "back, then forth," or "forth, then back?""
	)
)

(instance soEgoPickUpBeestLeg of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo hide:)
				(poTorin
					cel: 0
					loop: 0
					view: 20301
					posn: (gEgo x:) (gEgo y:)
					init:
					setCycle: CT 4 1 self
				)
			)
			(1
				(voBeestLeg dispose:)
				(poTorin setCycle: CT 17 1 self)
				(gEgo get: ((ScriptID 64001 0) get: 25)) ; oInvHandler, ioBeestLeg
			)
			(2
				(poTorin setCycle: End self)
			)
			(3
				((ScriptID 64017 0) set: 57) ; oFlags
				(poTorin dispose:)
				(gEgo posn: 117 262 loop: 8 cel: 4 show:)
				(self dispose:)
			)
		)
	)
)

(instance soPickUpBeestLeg of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 141 255 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 315 self)
			)
			(2
				(self setScript: soEgoPickUpBeestLeg self)
				(if ((ScriptID 64017 0) test: 57) ; oFlags
					(gMessager say: 6 1 11 0 self) ; "I'll be sure not to waste this one!"
				else
					(gMessager say: 6 1 5 0 self) ; "I hope this isn't one of those buffets with a "eat all you take" policy!"
				)
			)
			(3)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance voBeestLeg of View
	(properties
		x 92
		y 209
		view 20308
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gEgo setScript: soPickUpBeestLeg)
	)
)

(instance poTorin of Prop
	(properties)
)

(instance toTorin of Talker
	(properties
		x 331
		y 377
		view 60109
		loop 6
		priority 378
	)
)

(instance foFloorTileExit of CUExitFeature
	(properties)

	(method (doVerb)
		(gGame handsOff:)
		(gCurRoom deleteRoomPlane: oFloorTile)
		(= gtTorin 0)
		(= gtKing toKingTalker)
		(= gtKingDi toKingDiTalker)
		(= gtQueen toQueenTalker)
		(= gtQueenToKing toQueenToKingTalker)
		(if
			(and
				(gEgo has: ((ScriptID 64001 0) get: 22)) ; oInvHandler, ioFloorTile
				(not ((ScriptID 64017 0) test: 63)) ; oFlags
			)
			(gCurRoom setScript: soUnKneelAtTile coGetLocket)
		else
			(gCurRoom setScript: soUnKneelAtTile (ScriptID 64020 0)) ; oHandsOnWhenCued
		)
	)
)

(instance oFloorTile of Plane
	(properties
		picture 20302
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
		(foFloorTileExit init:)
		(voFloorTileCU init:)
		(= gtTorin 0)
		(= gtKing 0)
		(= gtKingDi 0)
		(= gtQueen 0)
		(= gtQueenToKing 0)
	)
)

(instance toTorinKneelTalker of Talker
	(properties
		x 348
		y 205
		view 20309
		loop 1
		priority 206
	)
)

(instance soAttemptPickUpFloorTile of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self setScript: soKneelAtTile self)
			)
			(1
				(gCurRoom addRoomPlane: oFloorTile)
				(= gtTorin toTorinKneelTalker)
				(toTorinKneelTalker loop: 1)
				(poTorinCU
					view: 20309
					loop: 0
					cel: 0
					posn: 348 205
					init:
					setCycle: CT 20 1 self
				)
			)
			(2
				(gMessager sayRange: 5 1 10 1 2 self) ; "Your Majesty, this tile seems similar to others I've seen around Escarpa."
			)
			(3
				(poTorinCU setCycle: CT 30 1 self)
			)
			(4
				(toTorinKneelTalker loop: 2)
				(gMessager sayRange: 5 1 10 3 4 self) ; "May I have it for my collection?"
			)
			(5
				(= gtTorin 0)
				(poTorinCU setCycle: End self)
				(gMessager sayRange: 5 1 10 5 6 self) ; "Oh, nothing, I guess. I just kinda liked it."
			)
			(6)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soPickUpFloorTile of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self setScript: soKneelAtTile self)
			)
			(1
				(gCurRoom addRoomPlane: oFloorTile)
				(= gtTorin toTorinKneelTalker)
				(toTorinKneelTalker view: 20306 loop: 1 cel: 0)
				(poTorinCU cel: 0 loop: 0 view: 20306 posn: 348 205 init:)
				(gMessager say: 5 1 9 0 self) ; "Your Majesty, I think this tile is part of something important."
			)
			(2
				(poTorinCU setCycle: CT 7 1 self)
			)
			(3
				(voFloorTileCU dispose:)
				(gEgo get: ((ScriptID 64001 0) get: 22)) ; oInvHandler, ioFloorTile
				(poTorinCU setCycle: End self)
			)
			(4
				(voFloorTile dispose:)
				(= gtTorin 0)
				((ScriptID 64017 0) set: 54) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance voFloorTileCU of View
	(properties
		x 315
		y 256
		priority 1
		fixPriority 1
		view 20311
		loop 1
	)
)

(instance voFloorTile of View
	(properties
		x 351
		y 301
		priority 1
		fixPriority 1
		view 20311
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		((ScriptID 64017 0) set: 70) ; oFlags
		(if ((ScriptID 64017 0) test: 110) ; oFlags
			(gEgo setScript: soPickUpFloorTile)
		else
			(gEgo setScript: soAttemptPickUpFloorTile)
		)
	)
)

(instance soShardTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo face: poKing self)
			)
			(1
				(if (gEgo has: ((ScriptID 64001 0) get: 8)) ; oInvHandler, ioShard
					(gMessager say: 8 1 6 0) ; "I love the artwork over your throne, your Majesty."
				else
					(gMessager say: 8 1 12 0) ; "Your crystal array looks beautiful, King Rupert."
				)
				(self dispose:)
			)
		)
	)
)

(instance foCeilingTile of Feature
	(properties
		x 280
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 192 103 224 110 230 146 272 148 284 124 300 148 314 127 330 136 340 134 340 96 370 81 302 55
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 396 154 459 168 472 139 501 111 549 106 593 125 616 160 629 150 630 71 605 44 541 33 477 46 435 87
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 1 12)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Do
			(gEgo setScript: soShardTalk)
		else
			(gEgo setScript: soGiveShardToKing)
		)
	)
)

(instance poKingCU of Prop
	(properties
		x 283
		y 177
		priority 10
		fixPriority 1
		view 20307
		loop 1
	)
)

(instance voKingCUTalkerBust of View
	(properties
		x 283
		y 177
		priority 10
		fixPriority 1
		view 20307
		loop 8
	)
)

(instance toKingCUTalker of Talker
	(properties
		x 283
		y 177
		view 20307
		loop 9
		priority 11
	)

	(method (init)
		(poKingCU hide:)
		(voKingCUTalkerBust init:)
		(super init: &rest)
	)

	(method (dispose)
		(voKingCUTalkerBust dispose:)
		(poKingCU show:)
		(super dispose:)
	)
)

(instance toKingCUDiTalker of Talker
	(properties
		x 283
		y 177
		view 20307
		loop 10
		priority 11
	)

	(method (init)
		(poKingCU hide:)
		(voKingCUTalkerBust init:)
		(super init: &rest)
	)

	(method (dispose)
		(poKingCU show:)
		(voKingCUTalkerBust dispose:)
		(super dispose:)
	)
)

(instance soQueenCUBlink of SoTwinkle
	(properties
		minCycle 8
		maxCycle 8
		maxDelay 130
	)
)

(instance poQueenCU of Prop
	(properties
		x 410
		y 178
		priority 178
		fixPriority 1
		view 20307
	)
)

(instance voQueenCUTalkerBust of View
	(properties
		x 410
		y 178
		priority 178
		fixPriority 1
		view 20307
		loop 5
	)
)

(instance toQueenCUTalker of Talker
	(properties
		x 410
		y 178
		view 20307
		loop 6
		priority 179
	)

	(method (init)
		(poQueenCU hide:)
		(voQueenCUTalkerBust init:)
		(super init: &rest)
	)

	(method (dispose)
		(poQueenCU show:)
		(voQueenCUTalkerBust dispose:)
		(super dispose:)
	)
)

(instance toQueenCUToKingTalker of Talker
	(properties
		x 427
		y 175
		view 20307
		loop 7
		priority 179
	)

	(method (init)
		(poQueenCU hide:)
		(voQueenCUTalkerBust init:)
		(super init: &rest)
	)

	(method (dispose)
		(poQueenCU show:)
		(voQueenCUTalkerBust dispose:)
		(super dispose:)
	)
)

(instance toQueenCULocketTalker of Talker
	(properties
		x 315
		y 153
		view 20305
		loop 1
		priority 179
	)
)

(instance toTorinCUTalker of Talker
	(properties
		x 87
		y 173
		view 20314
		loop 2
		priority 151
	)
)

(instance voTorinCU of View
	(properties
		x 60
		y 315
		priority 150
		fixPriority 1
		view 20314
	)
)

(instance poTorinCU of Prop
	(properties)
)

(instance soGirl1CUFanning of SoTwinkle
	(properties
		minCycle 5
		maxCycle 9
		minDelay 10
		maxDelay 100
	)
)

(instance poGirl1CU of Prop
	(properties
		y 128
		priority 9
		fixPriority 1
		view 20307
		loop 3
	)
)

(instance soGirl2CUFanning of SoTwinkle
	(properties
		minCycle 5
		maxCycle 9
		minDelay 10
		maxDelay 100
	)
)

(instance poGirl2CU of Prop
	(properties
		x 631
		y 1
		priority 9
		fixPriority 1
		view 20307
		loop 4
	)
)

(instance coGetLocket of CueMe
	(properties)

	(method (cue)
		(gCurRoom setScript: soThroneCUQueenSpeech)
	)
)

(instance soGetLocket of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poQueenCU setCycle: CT 58 1 self)
			)
			(1
				(poTorinCU setCycle: End self)
				(poQueenCU setCycle: End self)
			)
			(2)
			(3
				(gEgo get: ((ScriptID 64001 0) get: 31)) ; oInvHandler, ioLocket
				((ScriptID 64017 0) set: 63) ; oFlags
				(self dispose:)
			)
		)
	)
)

(instance soThroneCUQueenSpeech of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom addRoomPlane: oThroneCUPlane)
				(poQueenCU setScript: soQueenCUBlink)
				(gMessager sayRange: 1 1 7 1 10 self) ; "Is Leenah from Escarpa?"
			)
			(1
				(poQueenCU
					setScript: 0
					view: 20305
					loop: 0
					cel: 0
					posn: 429 221
					setCycle: CT 53 1 self
				)
			)
			(2
				(= gtQueen toQueenCULocketTalker)
				(self setScript: soGetLocket self)
				(gMessager say: 1 1 7 11 self) ; "Here, Torin. Take this one. See? It has a picture of Rupert and me on the inside."
			)
			(3)
			(4
				(gMessager say: 1 1 7 12 self) ; "I promise to keep it safe until I find her."
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance foThroneCUExit of CUExitFeature
	(properties)

	(method (doVerb)
		(= gtTorin 0)
		(= gtKing toKingTalker)
		(= gtKingDi toKingDiTalker)
		(= gtQueen toQueenTalker)
		(= gtQueenToKing toQueenToKingTalker)
		(gCurRoom deleteRoomPlane: oThroneCUPlane)
	)
)

(instance oThroneCUPlane of Plane
	(properties
		priority 20
	)

	(method (init)
		(if ((ScriptID 64017 0) test: 56) ; oFlags
			(= picture 20301)
		else
			(= picture 20303)
		)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
		(poKingCU init: self)
		(poQueenCU init: self)
		(voTorinCU init: self)
		(poTorinCU
			view: 20314
			loop: 1
			cel: 0
			posn: 114 214
			init: self
			setPri: 151
		)
		(poGirl1CU init: self setScript: soGirl1CUFanning)
		(poGirl2CU init: self setScript: soGirl2CUFanning)
		(foThroneCUExit init:)
		(= gtKing toKingCUTalker)
		(= gtKingDi toKingCUDiTalker)
		(= gtQueen toQueenCUTalker)
		(= gtQueenToKing toQueenCUToKingTalker)
		(= gtTorin toTorinCUTalker)
	)
)

(instance soKen of SoTwinkle
	(properties
		minCycle 10
		maxCycle 15
		minDelay 1
		maxDelay 13
	)
)

(instance poKen of Prop
	(properties
		x 310
		y 188
		priority 1
		fixPriority 1
		view 20320
		cycleSpeed 10
	)

	(method (init)
		(super init: &rest)
		(self setScript: soKen)
	)
)

(instance roThroneRoom of TPRoom
	(properties
		picture 20300
	)

	(method (init)
		(super init: &rest)
		(goMusic1 setMusic: 20300)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 309 273 211 276 146 247 -20 259 -20 372 446 316
					yourself:
				)
		)
		(poKing init:)
		(poQueen init:)
		(poGirl1Fanning init:)
		(poGirl2Fanning init:)
		(poKen init:)
		(foCeilingTile init:)
		(if
			(and
				(not ((ScriptID 64017 0) test: 76)) ; oFlags
				(not (gEgo has: ((ScriptID 64001 0) get: 25))) ; oInvHandler, ioBeestLeg
			)
			(voBeestLeg init:)
		)
		(= gtTorin 0)
		(= gtKing toKingTalker)
		(= gtKingDi toKingDiTalker)
		(= gtQueen toQueenTalker)
		(= gtQueenToKing toQueenToKingTalker)
		(if (not ((ScriptID 64017 0) test: 54)) ; oFlags
			(voFloorTile init:)
		)
		(foToCliffExit init:)
		(gGame handsOff:)
		(gEgo normalize: posn: 28 419 setScaler: Scaler 100 85 300 249 init:)
		(if ((ScriptID 64017 0) test: 56) ; oFlags
			(voRainbow init:)
		)
		(if (not ((ScriptID 64017 0) test: 68)) ; oFlags
			(gEgo setScript: soHumbleBoy)
		else
			(gEgo setMotion: MoveTo 278 311 (ScriptID 64020 0)) ; oHandsOnWhenCued
		)
	)
)

