;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15000)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use CueMe)
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
	roGuardHouseExt 0
	toGuard1 1
	toGuard2 2
	toGuardCU 3
)

(instance foMainExit of Feature
	(properties
		nsLeft 152
		nsTop 297
		nsRight 633
		nsBottom 319
		approachX 306
		approachY 315
		x 306
		y 313
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 2)) ; oSouthCursor
	)

	(method (doVerb)
		(gEgo setScript: soMainExit)
	)
)

(instance soMainExit of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo approach: foMainExit self)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 306 360 self)
			)
			(2
				(gEgo setMotion: MoveTo 306 365)
				(= cycles 2)
			)
			(3
				(gCurRoom newRoom: 10100) ; roForestScroll
			)
		)
	)
)

(instance foDoor of Feature
	(properties
		noun 1
		nsLeft 272
		nsTop 132
		nsRight 348
		nsBottom 232
		approachX 307
		approachY 241
		x 307
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(self approachVerbs: 2) ; ioAx
		(if ((ScriptID 64017 0) test: 31) ; oFlags
			(self forceCursor: (ScriptID 64006 1)) ; oNorthCursor
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(cond
					(((ScriptID 64017 0) test: 31) ; oFlags
						(gEgo setScript: soSecondEntrance)
					)
					(((ScriptID 64017 0) test: 8) ; oFlags
						(gEgo setScript: soFirstEntrance)
					)
					(else
						(gEgo setScript: soEgoTriesDoor)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance voDoor of View
	(properties
		x 331
		y 222
		view 15002
		loop 3
	)
)

(instance soEgoTriesDoor of TPScript
	(properties)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (ff)
		(goSound1 stop:)
		(poEgoTriesDoor dispose:)
		(gEgo setMotion: 0 posn: 274 241 loop: 6 stopwalk: show:)
		(gGame handsOn:)
		(self dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 315 241 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gGame handsOff:)
				(= bHasFF 1)
				(self setButtons:)
				(goSound1 preload: 15005)
				(gEgo hide:)
				(poEgoTriesDoor setCel: 0 init: setCycle: CT 3 1 self)
			)
			(3
				(= cycles 5)
			)
			(4
				(goSound1 playSound: 15005)
				(poEgoTriesDoor setCycle: End self)
			)
			(5
				(poEgoTriesDoor dispose:)
				(gEgo posn: 274 241 setLoop: 6 stopwalk: show:)
				(gMessager say: 1 1 5 0 self) ; "Hello? Anybody home?"
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poEgoTriesDoor of Prop
	(properties
		x 314
		y 244
		view 15001
		loop 1
	)
)

(instance soSecondEntrance of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 310 228 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 365 213 self)
			)
			(3
				(gCurRoom newRoom: 15100) ; roGuardHouseInt
			)
		)
	)
)

(instance soFirstEntrance of TPScript
	(properties)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (ff)
		(goSound1 stop:)
		(goMusic1 stop:)
		(= gnHermanTalker 0)
		(gCurRoom newRoom: 15100) ; roGuardHouseInt
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 310 238 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gGame handsOff:)
				(= bHasFF 1)
				(self setButtons:)
				(gEgo hide:)
				(goSound1 playSound: 15001)
				(poEgoKnocks setCel: 0 init: setCycle: End self)
			)
			(3
				(gEgo show:)
				(poEgoKnocks dispose:)
				(gEgo setLoop: 6 1)
				(gEgo setMotion: MoveTo 286 249 self)
			)
			(4
				(gMessager sayRange: 1 1 2 1 2 self) ; "Halt! Who goes there?"
			)
			(5
				(voDoor dispose:)
				(goMusic1 setMusic: 15099)
				(goSound1 playSound: 15002)
				(poGuardOpensDoor1 setCel: 0 init: setCycle: End self)
			)
			(6
				(= gnHermanTalker 1)
				(gMessager sayRange: 1 1 2 3 5 self) ; "What? You are?! Finally. It's about time. You must be 10 years late! Where've you been?"
			)
			(7
				(poGuardOpensDoor1 dispose:)
				(poGuardOpensDoor2 setCel: 0 init: setCycle: End self)
			)
			(8
				(= gnHermanTalker 2)
				(gMessager sayRange: 1 1 2 6 7 self) ; "Hurry up and git inside here. I am powerful hungry!"
			)
			(9
				(= gnHermanTalker 0)
				(poGuardOpensDoor2
					setLoop: 9
					setCel: 0
					setPri: 100
					setCycle: End self
				)
			)
			(10
				(gMessager say: 1 1 2 8 self) ; "Humph! (SARCASTICALLY, UNDER BREATH) Can't say I much care for the new uniforms!"
				(poGuardOpensDoor2 dispose:)
				(voOpenDoor init:)
				(gEgo setMotion: MoveTo 365 213 self)
			)
			(11)
			(12
				(goMusic1 fadeOut: 6 10 self)
			)
			(13
				(gCurRoom newRoom: 15100) ; roGuardHouseInt
			)
		)
	)
)

(instance poEgoKnocks of Prop
	(properties
		x 310
		y 238
		view 15006
	)
)

(instance foSign of Feature
	(properties
		noun 3
		nsLeft 356
		nsTop 181
		nsRight 384
		nsBottom 195
		approachX 370
		approachY 246
		x 370
		y 200
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(self approachVerbs: 1) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				((ScriptID 64017 0) set: 29) ; oFlags
				(gMessager say: noun theVerb 4) ; ""In case of emergency, break glass." What could that mean?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance poGuardOpensDoor1 of Prop
	(properties
		x 331
		y 222
		view 15002
		loop 3
	)
)

(instance voGuard1 of View
	(properties
		x 331
		y 222
		view 15002
		loop 4
	)
)

(instance toGuard1 of Talker
	(properties
		x 331
		y 222
		view 15002
		loop 5
		priority 222
	)

	(method (init)
		(poGuardOpensDoor1 hide:)
		(= frame voGuard1)
		(super init: &rest)
	)

	(method (dispose)
		(poGuardOpensDoor1 show:)
		(super dispose: &rest)
	)
)

(instance poGuardOpensDoor2 of Prop
	(properties
		x 331
		y 222
		view 15002
		loop 6
	)
)

(instance voGuard2 of View
	(properties
		x 331
		y 222
		view 15002
		loop 7
	)
)

(instance toGuard2 of Talker
	(properties
		x 331
		y 222
		view 15002
		loop 8
		priority 222
	)

	(method (init)
		(poGuardOpensDoor2 hide:)
		(= frame voGuard2)
		(super init: &rest)
	)

	(method (dispose)
		(poGuardOpensDoor2 show:)
		(super dispose: &rest)
	)
)

(instance foCrystal of Feature
	(properties
		nsLeft 133
		nsTop 184
		nsRight 230
		nsBottom 291
		approachX 258
		approachY 290
		y 290
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(if (not (gEgo has: ((ScriptID 64001 0) get: 8))) ; oInvHandler, ioShard
			(self addHotspotVerb: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gEgo setScript: soDoOnCrystal)
			)
			(2 ; ioAx
				(gCurRoom setScript: soAxOnCrystal)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soDoOnCrystal of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo approachThenFace: foCrystal self)
			)
			(1
				(gGame handsOff:)
				(if ((ScriptID 64017 0) test: 8) ; oFlags
					(+= state 2)
					(self cue:)
				else
					(goSound1 preload: 15008)
					(gEgo hide:)
					(poDoOnCrystal
						setCel: 0
						init:
						setPri: 292
						setCycle: CT 5 1 self
					)
				)
			)
			(2
				(= ticks (poDoOnCrystal cycleSpeed:))
				(goSound1 playSound: 15008)
			)
			(3
				(poDoOnCrystal setCycle: End self)
			)
			(4
				(if ((ScriptID 64017 0) test: 8) ; oFlags
					(gMessager say: 2 1 2 0 self) ; "This looks none the worse for wear."
				else
					(poDoOnCrystal dispose:)
					(gEgo posn: 318 290 setLoop: 5 stopwalk: show:)
					(gMessager say: 2 1 5 0 self) ; "(GRUNT) Ugh. There's no way I could break this off."
				)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poDoOnCrystal of Prop
	(properties
		x 258
		y 290
		view 15001
	)
)

(instance soAxOnCrystal of TPScript
	(properties
		bHasFF 1
		bHasRew 1
	)

	(method (ff)
		(if (== (gCurRoom plane:) oGuardCU)
			(gCurRoom deleteRoomPlane: oGuardCU)
		)
		(if (== (gCurRoom plane:) oTorinCU)
			(gCurRoom deleteRoomPlane: oTorinCU)
		)
		(gEgo setMotion: 0 posn: 293 289 setLoop: 3 stopwalk: show:)
		((ScriptID 64018 0) ; oBoogle
			setMotion: 0
			posn: 430 291
			setLoop: 1
			stopwalk:
			setWander: 1
			removeObstacle:
			show:
		)
		(goSound1 stop:)
		(poAxOnCrystal dispose:)
		(poBoogleRinging dispose:)
		(voCrystal dispose:)
		(gEgo get: ((ScriptID 64001 0) get: 8) ((ScriptID 64001 0) get: 0)) ; oInvHandler, ioShard, oInvHandler, ioAx
		((ScriptID 64017 0) set: 8 29) ; oFlags
		(foCrystal deleteHotspotVerb: 2 14)
		(= gnHermanTalker 0)
		(voDoor init:)
		(poGuardOpensDoor1 dispose:)
		(goMusic1 setMusic: 15800)
		(= gtTorin 0)
		(gGame handsOn:)
		(self dispose:)
	)

	(method (rewind)
		(if (== (gCurRoom plane:) oGuardCU)
			(gCurRoom deleteRoomPlane: oGuardCU)
		)
		(if (== (gCurRoom plane:) oTorinCU)
			(gCurRoom deleteRoomPlane: oTorinCU)
		)
		(gEgo setMotion: 0 posn: 328 297 setLoop: 5 stopwalk: show:)
		(gEgo put: ((ScriptID 64001 0) get: 8)) ; oInvHandler, ioShard
		(gEgo put: ((ScriptID 64001 0) get: 0)) ; oInvHandler, ioAx
		((ScriptID 64018 0) ; oBoogle
			setMotion: 0
			posn: 430 291
			setLoop: 1
			stopwalk:
			show:
			setWander: 0
		)
		(goSound1 stop:)
		(poAxOnCrystal dispose:)
		(poBoogleRinging dispose:)
		(voCrystal init:)
		((ScriptID 64017 0) unSet: 8) ; oFlags
		(voDoor init:)
		(poGuardOpensDoor1 dispose:)
		(goMusic1 setMusic: 15800)
		(= gtTorin 0)
		(gCurRoom setScript: self)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 64018 0) setWander: 0 setMotion: PolyPath 430 291) ; oBoogle
				(gEgo setMotion: PolyPath 328 297 self)
			)
			(1
				(gEgo setHeading: 225 self)
				((ScriptID 64018 0) setMotion: PolyPath 430 291 self) ; oBoogle
			)
			(2)
			(3
				((ScriptID 64018 0) setHeading: 270) ; oBoogle
				(goSound1 preload: 15006 15007)
				(gEgo hide:)
				(poAxOnCrystal setCel: 0 init: setCycle: CT 15 1 self)
			)
			(4
				((ScriptID 64018 0) hide:) ; oBoogle
				(poBoogleRinging
					setCel: 0
					init:
					setCycle: End coDisposeBoogleRinging
				)
				(poAxOnCrystal setCycle: CT 20 1 self)
			)
			(5
				(goSound1 playSound: 15006)
				(poAxOnCrystal setCycle: CT 45 1 self)
			)
			(6
				(goSound1 playSound: 15007)
				(voCrystal dispose:)
				(poAxOnCrystal setCycle: End self)
			)
			(7
				(poAxOnCrystal dispose:)
				(gEgo posn: 293 289 setLoop: 4 stopwalk: show:)
				(gMessager say: 2 2 5 1 self) ; "Nice blue color, eh, Boogle?"
			)
			(8
				(gEgo get: ((ScriptID 64001 0) get: 8)) ; oInvHandler, ioShard
				(gEgo get: ((ScriptID 64001 0) get: 0)) ; oInvHandler, ioAx
				((ScriptID 64017 0) set: 8 29) ; oFlags
				(foCrystal deleteHotspotVerb: 2 14)
				(= gnHermanTalker 0)
				(gMessager say: 2 2 5 2 self) ; "Wazzat? You rang?"
			)
			(9
				(voDoor dispose:)
				(poGuardOpensDoor1 setCel: 0 init: setCycle: End self)
				(gEgo face: poGuardOpensDoor1 self)
				(goMusic1 setMusic: 15099)
				(goSound1 playSound: 15002)
			)
			(10)
			(11
				(= gnHermanTalker 1)
				(gMessager sayRange: 2 2 5 3 4 self) ; "Huh? Who are you? Where'd ju come from? Waddaya doin' there? Ya tryin' to sneak by me? Oh, I wasn't asleep, no sir! I heard you come through."
			)
			(12
				(= gnHermanTalker 5)
				(gCurRoom addRoomPlane: oGuardCU)
				(gMessager say: 2 2 5 5 self) ; "The Lands Below? (DISGUSTED) You're one of them? Well, you can't stay up here. You go right back down where you came from. Yep. Nobody from down there gets past me! And you won't, neither."
			)
			(13
				(= gtTorin toTorinCU)
				(gCurRoom deleteRoomPlane: oGuardCU)
				(gCurRoom addRoomPlane: oTorinCU)
				(gMessager say: 2 2 5 6 self) ; "Oh, no, you misunderstand. I'm not FROM The Lands Below. I want to GO there. So you DO know how to get there?"
			)
			(14
				(gCurRoom deleteRoomPlane: oTorinCU)
				(gCurRoom addRoomPlane: oGuardCU)
				(gMessager say: 2 2 5 7 self) ; "GO there? Why, no one GOES there! That's no place for any self-respectin' citizen! Why them worlds is filled with nutsos! Malcontents! Psychos! (PAUSE A BEAT) Politicians!! (PAUSE AGAIN) No, there's no way I'd let you go down there."
			)
			(15
				(gCurRoom deleteRoomPlane: oGuardCU)
				(gCurRoom addRoomPlane: oTorinCU)
				(gMessager say: 2 2 5 8 self) ; "So you DO know! Oh, please help me, sir. I MUST get to The Lands Below. May I come inside?"
			)
			(16
				(gCurRoom deleteRoomPlane: oTorinCU)
				(= gnHermanTalker 1)
				(= gtTorin 0)
				(goSound1 preload: 15003)
				(gMessager say: 2 2 5 9 self) ; "Nope. No way. Nobody gets inside this guardhouse 'cept my replacement. Don't know where he is, either. Was supposed to be here 10, maybe 12 years ago! Never been THIS late before! No, you gotta go. Git outta here and don't come back."
			)
			(17
				(= gnHermanTalker 0)
				(poGuardOpensDoor1 setCycle: Beg self)
				(goSound1 playSound: 15003)
			)
			(18
				(goMusic1 setMusic: 15800)
				(voDoor init:)
				(poGuardOpensDoor1 dispose:)
				((ScriptID 64018 0) removeObstacle:) ; oBoogle
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance coDisposeBoogleRinging of CueMe
	(properties)

	(method (cue)
		((ScriptID 64018 0) show:) ; oBoogle
		(poBoogleRinging dispose:)
	)
)

(instance poAxOnCrystal of Prop
	(properties
		x 328
		y 297
		view 15002
	)
)

(instance poBoogleRinging of Prop
	(properties
		x 429
		y 291
		view 15002
		loop 1
	)
)

(instance voCrystal of View
	(properties
		x 208
		y 274
		view 15002
		loop 2
	)
)

(instance voOpenDoor of View
	(properties
		x 331
		y 222
		view 15002
		loop 11
	)
)

(instance soSBoogleEntrance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 64018 0) ; oBoogle
					setWander: 0
					setMotion: PolyPath 430 291 self
				)
			)
			(1
				(if (not ((ScriptID 64017 0) test: 8)) ; oFlags
					((ScriptID 64018 0) ; oBoogle
						addObstacle:
							((Polygon new:)
								type: PContainedAccess
								init: 390 280 392 298 467 298 470 280
								yourself:
							)
					)
				)
				((ScriptID 64018 0) setWander: 1) ; oBoogle
			)
		)
	)
)

(instance oGuardCU of Plane
	(properties
		picture 15001
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
		(voGuardBodyCU init:)
		(poGuardEyesCU init:)
		(voGuardMouthCU init:)
	)
)

(instance toGuardCU of Talker
	(properties
		x 273
		y 212
		view 15003
		loop 1
		priority 212
	)

	(method (init)
		(voGuardMouthCU hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voGuardMouthCU show:)
		(super dispose: &rest)
	)
)

(instance voGuardBodyCU of View
	(properties
		x 273
		y 212
		view 15003
	)

	(method (init)
		(super init: &rest)
		(self setPri: 211)
	)
)

(instance voGuardMouthCU of View
	(properties
		x 273
		y 212
		view 15003
		loop 1
	)
)

(instance poGuardEyesCU of Prop
	(properties
		x 273
		y 212
		view 15003
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Blink 300)
	)
)

(instance oTorinCU of Plane
	(properties
		picture 15002
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
		(voTorinBodyCU init:)
		(voTorinMouthCU init:)
		(poTorinEyesCU init:)
	)
)

(instance toTorinCU of Talker
	(properties
		x 238
		y 114
		view 15005
		loop 1
		priority 114
	)

	(method (init)
		(voTorinMouthCU hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voTorinMouthCU show:)
		(super dispose: &rest)
	)
)

(instance voTorinBodyCU of View
	(properties
		x 238
		y 114
		view 15005
	)

	(method (init)
		(super init: &rest)
		(self setPri: 113)
	)
)

(instance voTorinMouthCU of View
	(properties
		x 238
		y 114
		view 15005
		loop 1
	)
)

(instance poTorinEyesCU of Prop
	(properties
		x 238
		y 114
		view 15005
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Blink 300)
	)
)

(instance soBoogleEntersFromGuardHouse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 64018 0) setMotion: MoveTo 309 232 self) ; oBoogle
			)
			(1
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(self dispose:)
			)
		)
	)
)

(instance roGuardHouseExt of TPRoom
	(properties
		picture 15000
		south 15800
	)

	(method (init)
		(super init: &rest)
		(gEgo init: normalize: setScaler: Scaler 100 64 290 228)
		((ScriptID 64017 0) set: 28) ; oFlags
		(gGame handsOn:)
		(switch gPrevRoomNum
			(south
				(gGame handsOff:)
				(gEgo posn: 310 340 setLoop: 3)
				(gEgo setMotion: MoveTo 310 292 (ScriptID 64020 0)) ; oHandsOnWhenCued
				((ScriptID 64018 0) ; oBoogle
					init:
					posn: 374 299
					normalize:
					setScaler: Scaler 100 64 290 228
					setScript: soSBoogleEntrance
				)
			)
			(10100 ; roForestScroll
				(gGame handsOff:)
				(gEgo posn: 310 340 setLoop: 3)
				(gEgo setMotion: MoveTo 310 292 (ScriptID 64020 0)) ; oHandsOnWhenCued
				((ScriptID 64018 0) ; oBoogle
					init:
					posn: 374 299
					normalize:
					setScaler: Scaler 100 64 290 228
					setScript: soSBoogleEntrance
				)
			)
			(15100 ; roGuardHouseInt
				(gEgo
					posn: (foDoor approachX:) (foDoor approachY:)
					setLoop: 2
					setMotion: PolyPath (foDoor approachX:) 260
				)
				((ScriptID 64018 0) ; oBoogle
					init:
					posn: 342 209
					normalize:
					setWander: 0
					setLoop: 5
					setScaler: Scaler 100 64 290 228
					setScript: soBoogleEntersFromGuardHouse
				)
			)
			(else
				(gGame handsOff:)
				(gEgo posn: 310 340 setLoop: 3)
				(gEgo setMotion: MoveTo 310 292 (ScriptID 64020 0)) ; oHandsOnWhenCued
				((ScriptID 64018 0) ; oBoogle
					init:
					posn: 362 243
					normalize:
					setLoop: 2
					setScaler: Scaler 100 64 290 228
				)
			)
		)
		(foMainExit init:)
		(foDoor init:)
		(foSign init:)
		(foCrystal init:)
		(if (not ((ScriptID 64017 0) test: 8)) ; oFlags
			(voCrystal init: setPri: 291)
		)
		(if ((ScriptID 64017 0) test: 31) ; oFlags
			(voOpenDoor init:)
		else
			(voDoor init:)
			(Load rsVIEW 15002 15001)
		)
		(goMusic1 setMusic: 15800)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 598 319 451 267 451 245 494 232 28 232 100 319
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 120 295 121 270 240 270 239 297
					yourself:
				)
		)
	)

	(method (gimme)
		(gCurRoom newRoom: 15100) ; roGuardHouseInt
	)
)

