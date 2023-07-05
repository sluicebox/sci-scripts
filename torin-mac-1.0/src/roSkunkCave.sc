;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20500)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use TPSound)
(use CueMe)
(use foEExit)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roSkunkCave 0
)

(local
	oCurObstacle
	nTorinLoc
	bTorinInPlace
)

(instance foToCliffExit of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 4)) ; oWestCursor
		(= nsTop 0)
		(= nsBottom 314)
		(= nsLeft 0)
		(= nsRight 30)
	)

	(method (doVerb)
		(switch nTorinLoc
			(0
				(gEgo setScript: soCrawlBackOut)
			)
			(2
				(gEgo setScript: soClothespinOffAndOut)
			)
			(3
				(gEgo setScript: soWalkOutFrontDoor)
			)
			(else
				(PrintDebug {illegal postion for walkout})
			)
		)
	)

	(method (cue)
		(gCurRoom newRoom: 20100) ; roCliffScroller
	)
)

(instance soCrawlBackOut of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(voCrawlNormalMouth dispose:)
				(poTorin view: 20500 loop: 0 posn: 110 212)
				(poTorin cel: (poTorin lastCel:) doit: setCycle: Beg self)
			)
			(1
				(= gtTorin 0)
				(= gtSam 0)
				(= gtMax 0)
				((ScriptID 64017 0) clear: 88) ; oFlags
				(gCurRoom newRoom: 20100) ; roCliffScroller
				(self dispose:)
			)
		)
	)
)

(instance soClothespinOffAndOut of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(voTorinNormalMouth dispose:)
				(poTorin
					view: 20508
					loop: 0
					posn: 110 212
					cel: 0
					doit:
					setCycle: End self
				)
				((ScriptID 64017 0) clear: 89 90) ; oFlags
			)
			(1
				(= gtTorin 0)
				(= gtSam 0)
				(= gtMax 0)
				((ScriptID 64017 0) clear: 88) ; oFlags
				(gCurRoom newRoom: 20100) ; roCliffScroller
				(self dispose:)
			)
		)
	)
)

(instance soWalkOutFrontDoor of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 317 262 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 225 self)
			)
			(2
				(gEgo hide:)
				(poTorin
					view: 20510
					loop: 0
					cel: 0
					posn: 317 262
					init:
					setCycle: End self
				)
			)
			(3
				((ScriptID 64017 0) clear: 88) ; oFlags
				(gCurRoom newRoom: 20100) ; roCliffScroller
				(self dispose:)
			)
		)
	)
)

(instance foToGuruExit of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 1)) ; oNorthCursor
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 514 146 556 189 540 199 506 194 500 170
				yourself:
			)
		)
	)

	(method (doVerb)
		(cond
			(((ScriptID 64017 0) test: 87) ; oFlags
				(gEgo setScript: soLeaveBackDoor)
			)
			((== nTorinLoc 2)
				(gEgo setScript: soSneakPastSkunks)
			)
			(else
				(gMessager say: 0 0 7 0) ; "There's no way I'm going in there. That nest smells terrible! (PAUSE) Still, there IS that opening back there in the distance. It must go somewhere."
			)
		)
	)
)

(instance soCrawlIn of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(poTorin
					view: 20500
					loop: 0
					cel: 0
					posn: 110 212
					init:
					setCycle: End self
				)
				(voCrawlNormalMouth init: hide:)
				(= bTorinInPlace 0)
				(= gtTorin toCrawlTorin)
				(gCurRoom setScript: soSayOpeningMessage)
			)
			(1
				(poTorin view: 20500 loop: 1 cel: 0 doit:)
				(= bTorinInPlace 1)
				(if (toCrawlTorin mouth:)
					((toCrawlTorin mouth:) show:)
				else
					(voCrawlNormalMouth show:)
				)
				(self cue:)
			)
			(2
				(= cycles 2)
			)
			(3
				(if (gCurRoom script:)
					(self changeState: (- state 1))
				else
					(self cue:)
				)
			)
			(4
				(gGame handsOn:)
				(= nTorinLoc 0)
				(foFloor init:)
				(self dispose:)
			)
		)
	)
)

(instance soSayOpeningMessage of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not ((ScriptID 64017 0) test: 91)) ; oFlags
					((ScriptID 64017 0) set: 91) ; oFlags
					(gMessager say: 0 0 6 0 self) ; "(WHO FARTED?) Boogle! Is that you?"
				else
					(self cue:)
				)
			)
			(1
				(if (not ((ScriptID 64017 0) test: 87)) ; oFlags
					(poTorin addHotspotVerb: 33)
					(self setScript: soSkunksEnter self)
				else
					(self cue:)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soSkunksEnter of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poSkunks
					view: 20501
					loop: 0
					cel: 0
					posn: 581 283
					init:
					setCycle: End self
				)
			)
			(1
				(poSkunks loop: 2)
				(voSamNormalMouth init:)
				(voMaxNormalMouth init:)
				(= gtSam toSam)
				(= gtMax toMax)
				(self dispose:)
			)
		)
	)
)

(instance soClimbOutOfTunnel of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(voCrawlNormalMouth dispose:)
				(poTorin
					view: 20509
					loop: 0
					cel: 0
					doit:
					setCycle: CT 19 1 self
				)
				(= gtTorin 0)
				(= gtSam 0)
				(= gtMax 0)
			)
			(1
				(poTorin dispose:)
				(gEgo posn: 360 264 normalize: 1 60100 6 show:)
				(foFloor dispose:)
				(= nTorinLoc 3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soEnterBackDoor of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setLoop: 4 1
					setPri: 1
					posn: 494 208
					setScaler: 0
					setScalePercent: 30
					show:
					setMotion: MoveTo 522 200 self
				)
			)
			(1
				(gEgo
					setPri: -1
					setLoop: -1
					setScaler: Scaler 100 25 262 200
					setMotion: MoveTo 520 205 self
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soLeaveBackDoor of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== nTorinLoc 0)
					(self setScript: soClimbOutOfTunnel self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setMotion: PolyPath 540 199 self)
			)
			(2
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 522 200 self)
			)
			(3
				(gEgo setHeading: 315 self)
			)
			(4
				(gEgo
					setLoop: 7 1
					setPri: 1
					setScaler: 0
					setScalePercent: 25
					setMotion: MoveTo 491 209 self
				)
			)
			(5
				((ScriptID 64017 0) set: 88) ; oFlags
				(gCurRoom newRoom: 20100) ; roCliffScroller
				(self dispose:)
			)
		)
	)
)

(instance voCrawlNormalMouth of View
	(properties
		x 110
		y 212
		priority 213
		fixPriority 1
		view 20500
		loop 2
	)
)

(instance toCrawlTorin of Talker
	(properties
		x 110
		y 212
		view 20500
		loop 2
		priority 213
	)

	(method (init)
		(voCrawlNormalMouth hide:)
		(super init: &rest)
		(if (not bTorinInPlace)
			(mouth hide:)
		)
	)

	(method (dispose)
		(if bTorinInPlace
			(voCrawlNormalMouth show:)
		)
		(super dispose: &rest)
	)
)

(instance voTorinNormalMouth of View
	(properties
		x 110
		y 212
		priority 213
		fixPriority 1
		view 20507
		loop 2
	)
)

(instance toTorin of Talker
	(properties
		x 110
		y 212
		view 20507
		loop 2
		priority 213
	)

	(method (init)
		(voTorinNormalMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voTorinNormalMouth show:)
		(super dispose: &rest)
	)
)

(instance poTorin of Prop
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 38)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(33 ; ioClothespin
				(gCurRoom setScript: soClothespinSelf)
			)
			(38 ; ioRedCarpet
				(if ((ScriptID 64017 0) test: 89) ; oFlags
					(gEgo setScript: soCarpetSkunks)
				else
					(gMessager say: 2 47 2 0) ; "No way. I'll never get close enough. That smell is a killer!"
				)
			)
		)
	)
)

(instance soClothespinSelf of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(((ScriptID 64001 0) get: 23) moveTo: -3) ; oInvHandler, ioClothespin
				(if (not ((ScriptID 64017 0) test: 92)) ; oFlags
					((ScriptID 64017 0) set: 92) ; oFlags
					(gMessager say: 4 33 2 0 self) ; "Boog, I've got it! I'll just put this clothespin on my nose. Then I won't be able to smell the skunks!"
				else
					(self cue:)
				)
			)
			(1
				(voCrawlNormalMouth dispose:)
				(poTorin
					view: 20507
					loop: 0
					cel: 0
					doit:
					setCycle: CT 15 1 self
				)
			)
			(2
				(poTorin setCycle: End self)
				(voSamNormalMouth hide:)
				(voMaxNormalMouth hide:)
				(poSkunks loop: 1 cel: 0 doit: setCycle: End self)
			)
			(3)
			(4
				(poSkunks loop: 5 doit:)
				(voSamNormalMouth loop: 6 show:)
				(voMaxNormalMouth loop: 7 cel: 0 show:)
				(poTorin view: 20507 loop: 1 cel: 0 doit:)
				(voTorinNormalMouth init:)
				(= gtTorin toTorin)
				(toSam loop: 6)
				(toMax loop: 7)
				(poSamTail init:)
				(poMaxTail init:)
				(gGame handsOn:)
				(poTorin deleteHotspotVerb: 33)
				(foFloor dispose:)
				((ScriptID 64017 0) set: 89) ; oFlags
				((ScriptID 64017 0) set: 90) ; oFlags
				(poSkunks deleteHotspotVerb: 40)
				(= nTorinLoc 2)
			)
		)
	)
)

(instance foFloor of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(self
			setPolygon:
				((Polygon new:)
					type: PContainedAccess
					init: 295 250 299 267 366 280 430 264 555 216 525 211 532 198 502 198 426 201 346 225
					yourself:
				)
		)
	)

	(method (doVerb)
		(if ((ScriptID 64017 0) test: 87) ; oFlags
			(gCurRoom setScript: soClimbOutOfTunnel)
		else
			(gMessager say: 0 0 7 0) ; "There's no way I'm going in there. That nest smells terrible! (PAUSE) Still, there IS that opening back there in the distance. It must go somewhere."
		)
	)
)

(instance voSamNormalMouth of View
	(properties
		x 581
		y 283
		priority 300
		fixPriority 1
		view 20501
		loop 3
	)

	(method (testHotspotVerb)
		(poSkunks testHotspotVerb: &rest)
	)

	(method (doVerb)
		(poSkunks doVerb: &rest)
	)
)

(instance toSam of Talker
	(properties
		x 581
		y 283
		view 20501
		loop 3
		priority 300
	)

	(method (init)
		(voSamNormalMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voSamNormalMouth show:)
		(super dispose: &rest)
	)
)

(instance voMaxNormalMouth of View
	(properties
		x 581
		y 283
		priority 300
		fixPriority 1
		view 20501
		loop 4
		cel 2
	)

	(method (testHotspotVerb)
		(poSkunks testHotspotVerb: &rest)
	)

	(method (doVerb)
		(poSkunks doVerb: &rest)
	)
)

(instance toMax of Talker
	(properties
		x 581
		y 283
		view 20501
		loop 4
		cel 2
		priority 300
	)

	(method (init)
		(voMaxNormalMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voMaxNormalMouth show:)
		(super dispose: &rest)
	)
)

(instance poSamTail of Prop
	(properties
		x 581
		y 283
		priority 200
		fixPriority 1
		view 20501
		loop 8
	)

	(method (init)
		(super init: &rest)
		(self setScript: (soTailFlick new:))
	)

	(method (testHotspotVerb)
		(poSkunks testHotspotVerb: &rest)
	)

	(method (doVerb)
		(poSkunks doVerb: &rest)
	)
)

(instance poMaxTail of Prop
	(properties
		x 581
		y 283
		priority 190
		fixPriority 1
		view 20501
		loop 9
	)

	(method (init)
		(super init: &rest)
		(self setScript: (soTailFlick new:))
	)

	(method (testHotspotVerb)
		(poSkunks testHotspotVerb: &rest)
	)

	(method (doVerb)
		(poSkunks doVerb: &rest)
	)
)

(instance soTailFlick of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 200 300))
			)
			(1
				(client setCycle: End self)
			)
			(2
				(client cel: 0)
				(self changeState: 0)
			)
		)
	)

	(method (dispose)
		(client setCycle: 0)
		(super dispose: &rest)
	)
)

(instance poSkunks of Prop
	(properties)

	(method (init)
		(super init: &rest)
		(self setPri: 250)
	)

	(method (testHotspotVerb)
		(return 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(switch gnSkunkTalk
					(0
						(++ gnSkunkTalk)
						(if ((ScriptID 64017 0) test: 89) ; oFlags
							(gEgo setScript: soSkunkTalk1)
						else
							(gMessager say: 2 1 8 0) ; "Hey. Skunks? Are you there?"
						)
					)
					(1
						(++ gnSkunkTalk)
						(if ((ScriptID 64017 0) test: 89) ; oFlags
							(gEgo setScript: soSkunkTalk2)
						else
							(gMessager say: 2 1 9 0) ; "Please, fellas. Let me pass. I'm a stranger in a strange land!"
						)
					)
					(2
						(if ((ScriptID 64017 0) test: 89) ; oFlags
							(gEgo setScript: soSkunkTalk3)
						else
							(gMessager say: 2 1 10 0) ; "Could I persuade you with a gift? A present? A peace offering? An appeasement?"
						)
					)
				)
			)
			(38 ; ioRedCarpet
				(if ((ScriptID 64017 0) test: 89) ; oFlags
					(gEgo setScript: soCarpetSkunks)
				else
					(gMessager say: 2 47 2 0) ; "No way. I'll never get close enough. That smell is a killer!"
				)
			)
			(40 ; ioFan
				(if (not ((ScriptID 64017 0) test: 89)) ; oFlags
					(gEgo setScript: soFanSkunks)
				else
					(gMessager say: 2 47 1 0) ; "There's no way I could hide behind THAT without getting soaked!"
				)
			)
			(else
				(if ((ScriptID 64017 0) test: 89) ; oFlags
					(gMessager say: 2 47 1 0) ; "There's no way I could hide behind THAT without getting soaked!"
				else
					(gMessager say: 2 47 2 0) ; "No way. I'll never get close enough. That smell is a killer!"
				)
			)
		)
	)
)

(instance soSkunkTalk1 of TPScript
	(properties
		bHasFF 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 0 1 1 self) ; "Hey. Skunks? Are you there?"
			)
			(1
				(gMessager sayRange: 2 1 8 2 3 self) ; "I'm here. Are you, Max?"
			)
			(2
				(gMessager say: 0 0 1 2 self) ; "Oh, well, I was ah, just wondering: could I pass through your cave?"
			)
			(3
				(gMessager sayRange: 2 1 8 5 7 self) ; "Well, you could TRY."
			)
			(4
				(self dispose:)
			)
		)
	)

	(method (ff)
		(self dispose:)
	)
)

(instance soSkunkTalk2 of TPScript
	(properties
		bHasFF 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 0 1 3 self) ; "Please, fellas. Let me pass. I'm a stranger in a strange land!"
			)
			(1
				(gMessager sayRange: 2 1 9 2 6 self) ; "You got that right!"
			)
			(2
				(gMessager say: 0 0 1 4 self) ; "Aye!"
			)
			(3
				(gMessager sayRange: 2 1 9 8 12 self) ; "(AYE!) Brawk!"
			)
			(4
				(self dispose:)
			)
		)
	)

	(method (ff)
		(self dispose:)
	)
)

(instance soSkunkTalk3 of TPScript
	(properties
		bHasFF 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 0 1 5 self) ; "Could I persuade you with a gift? A present? A peace offering? An appeasement?"
			)
			(1
				(gMessager sayRange: 2 1 10 2 5 self) ; "Nope."
			)
			(2
				(self dispose:)
			)
		)
	)

	(method (ff)
		(self dispose:)
	)
)

(instance oSkunkSound of TPSound
	(properties)
)

(instance oSkunkSound2 of TPSound
	(properties)
)

(instance oTorinSound of TPSound
	(properties)
)

(instance soSneakPastSkunks of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(oSkunkSound preload: 20501 20506 20508 20503)
				(poSkunks hide:)
				(voSamNormalMouth hide:)
				(voMaxNormalMouth hide:)
				(poSamTail hide:)
				(poMaxTail hide:)
				(voTorinNormalMouth hide:)
				(poTorin
					view: 20502
					posn: 359 270
					loop: 0
					cel: 0
					doit:
					setCycle: CT 19 1 self
				)
			)
			(1
				(oTorinSound playSound: 20508)
				(oSkunkSound playSound: 20501)
				(poTorin setCycle: CT 23 1 self)
			)
			(2
				(oSkunkSound stop:)
				(poTorin setCycle: CT 45 1 self)
			)
			(3
				(oTorinSound playSound: 20506)
				(oSkunkSound playSound: 20501)
				(poTorin setCycle: CT 49 1 self)
			)
			(4
				(oSkunkSound stop:)
				(poTorin setCycle: CT 77 1 self)
			)
			(5
				(oSkunkSound playSound: 20503)
				(poTorin setCycle: End self)
			)
			(6
				(poTorin view: 20507 loop: 1 cel: 0 posn: 110 212 doit:)
				(voTorinNormalMouth show:)
				(poSkunks
					view: 20512
					loop: 0
					cel: 0
					posn: 362 268
					show:
					setCycle: End self
				)
			)
			(7
				(poSkunks view: 20501 loop: 5 cel: 0 posn: 581 283 doit:)
				(voSamNormalMouth show:)
				(voMaxNormalMouth show:)
				(poSamTail show:)
				(poMaxTail show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soFanSkunks of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= nTorinLoc 0)
					(PrintDebug {illegal call of soFanSkunks})
				)
				(gGame handsOff:)
				(gMessager say: 2 40 2 1 self) ; "What if I blow their smell away with this fan!"
			)
			(1
				(voCrawlNormalMouth hide:)
				(poTorin
					view: 20506
					loop: 0
					cel: 0
					doit:
					setCycle: CT 22 1 self
				)
			)
			(2
				(gMessager say: 2 40 2 2 self) ; "(OFF IN DISTANCE, LOTS OF ECHO) Yeow! What's that smell! Cut it out down there, will ya? Some of us are trying to breathe up here!!"
				(self setScript: soKeepFanning)
			)
			(3
				(soKeepFanning dispose:)
				(gMessager say: 2 40 2 3 self) ; "That didn't work! It still smells just as bad in here!"
				(poTorin setCycle: End coResetTorin)
			)
			(4)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soKeepFanning of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poTorin cel: 15 doit: setCycle: CT 22 1 self)
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance coResetTorin of CueMe
	(properties)

	(method (cue)
		(poTorin view: 20500 loop: 1 cel: 0 doit:)
		(voCrawlNormalMouth show:)
		(soFanSkunks cue:)
	)
)

(instance soCarpetSkunks of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(oSkunkSound preload: 20501 20509)
				(gMessager say: 2 38 1 1 self) ; "Hang on, Boogle. We're goin' in!"
			)
			(1
				(voTorinNormalMouth dispose:)
				(poTorin
					view: 20503
					loop: 0
					cel: 0
					posn: 336 277
					setPri: 400
					doit:
					setCycle: End self
				)
			)
			(2
				(voSamNormalMouth dispose:)
				(voMaxNormalMouth dispose:)
				(poSamTail dispose:)
				(poMaxTail dispose:)
				(poSkunks view: 20512 loop: 0)
				(poSkunks
					cel: (poSkunks lastCel:)
					posn: 365 261
					setPri: 350
					doit:
					setCycle: Beg self
				)
			)
			(3
				(poSkunks
					view: 20503
					loop: 2
					cel: 0
					posn: 512 253
					doit:
					setCycle: CT 9 1 self
				)
			)
			(4
				(poTorin view: 20503 loop: 3 cel: 0 doit: setCycle: End)
				(oSkunkSound playSound: 20501)
				(poSkunks setCycle: CT 11 1 self)
			)
			(5
				(oSkunkSound2 playSound: 20501)
				(poSkunks setCycle: CT 13 1 self)
			)
			(6
				(oSkunkSound playSound: 20501)
				(poSkunks setCycle: CT 15 1 self)
			)
			(7
				(oSkunkSound2 playSound: 20501)
				(poSkunks setCycle: CT 17 1 self)
			)
			(8
				(oSkunkSound playSound: 20501)
				(poSkunks setCycle: CT 19 1 self)
			)
			(9
				(oSkunkSound2 playSound: 20501)
				(poSkunks setCycle: CT 21 1 self)
			)
			(10
				(oSkunkSound playSound: 20501)
				(poSkunks setCycle: CT 27 1 self)
			)
			(11
				(oSkunkSound stop:)
				(oSkunkSound2 stop:)
				(poTorin view: 20503 loop: 1 cel: 0 doit: setCycle: End)
				(poSkunks setCycle: CT 30 1 self)
			)
			(12
				(oSkunkSound playSound: 20509)
				(goMusic1 fadeOut:)
				(poSkunks setCycle: End self)
			)
			(13
				(goMusic1 fadeIn: 20100)
				(poSkunks dispose:)
				(poTorin view: 20511 loop: 0 cel: 0 doit: setCycle: End self)
			)
			(14
				(poTorin dispose:)
				(gEgo
					posn: 367 272
					normalize: 1 60100 6
					setScaler: Scaler 100 25 262 200
					doit:
					show:
				)
				(= nTorinLoc 3)
				(= gtTorin 0)
				(= gtSam 0)
				(= gtMax 0)
				((ScriptID 64017 0) clear: 89) ; oFlags
				(gEgo put: ((ScriptID 64001 0) get: 23)) ; oInvHandler, ioClothespin
				(gEgo put: ((ScriptID 64001 0) get: 28)) ; oInvHandler, ioRedCarpet
				(gEgo get: ((ScriptID 64001 0) get: 29)) ; oInvHandler, ioStinkyCarpet
				((ScriptID 64017 0) set: 61) ; oFlags
				((ScriptID 64017 0) set: 87) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(poTorin dispose:)
		(voSamNormalMouth dispose:)
		(voMaxNormalMouth dispose:)
		(poSamTail dispose:)
		(poMaxTail dispose:)
		(voTorinNormalMouth dispose:)
		(oSkunkSound stop:)
		(gEgo
			posn: 367 272
			normalize: 1 60100 6
			setScaler: Scaler 100 25 262 200
			doit:
			show:
		)
		(= nTorinLoc 3)
		(= gtTorin 0)
		(= gtSam 0)
		(= gtMax 0)
		((ScriptID 64017 0) clear: 89) ; oFlags
		(gEgo put: ((ScriptID 64001 0) get: 23)) ; oInvHandler, ioClothespin
		(gEgo put: ((ScriptID 64001 0) get: 28)) ; oInvHandler, ioRedCarpet
		(gEgo get: ((ScriptID 64001 0) get: 29)) ; oInvHandler, ioStinkyCarpet
		((ScriptID 64017 0) set: 61) ; oFlags
		((ScriptID 64017 0) set: 87) ; oFlags
		(gGame handsOn:)
		(self dispose:)
	)

	(method (rewind)
		(voTorinNormalMouth init:)
		(poTorin dispose:)
		(poTorin view: 20507 loop: 1 cel: 0 posn: 110 212 init:)
		(= gtTorin toTorin)
		(poSkunks dispose:)
		(poSkunks view: 20502 loop: 1)
		(poSkunks cel: (poSkunks lastCel:) posn: 365 261 setPri: 350 init:)
		(gEgo setScript: self)
	)
)

(instance roSkunkCave of TPRoom
	(properties
		picture 20500
	)

	(method (init)
		(super init: &rest)
		(if ((ScriptID 64017 0) test: 87) ; oFlags
			(goMusic1 setMusic: 20100)
		else
			(goMusic1 setMusic: 20500)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 295 250 299 267 366 280 430 264 555 216 525 211 532 198 502 198 426 201 346 225
					yourself:
				)
		)
		(foToCliffExit init:)
		(foToGuruExit init:)
		(gEgo init: normalize: setScaler: Scaler 100 25 262 200 hide:)
		(gGame handsOn:)
		(if ((ScriptID 64017 0) test: 88) ; oFlags
			(= nTorinLoc 3)
			(gEgo setScript: soEnterBackDoor)
		else
			(= nTorinLoc 0)
			(gEgo posn: 356 280)
			(gEgo setScript: soCrawlIn)
		)
	)

	(method (dispose)
		(= gtMax 0)
		(= gtSam 0)
		(= gtTorin 0)
		(super dispose: &rest)
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64001 0) get: 28)) ; oInvHandler, ioRedCarpet
		(gEgo get: ((ScriptID 64001 0) get: 30)) ; oInvHandler, ioFan
		(gEgo get: ((ScriptID 64001 0) get: 27)) ; oInvHandler, ioHaremPillow
		(gEgo get: ((ScriptID 64001 0) get: 23)) ; oInvHandler, ioClothespin
	)
)

