;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20200)
(include sci.sh)
(use Main)
(use oBoogle)
(use oHandsOnWhenCued)
(use TPScript)
(use TPSound)
(use SoTwinkle)
(use MotionNoLoop)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use ForwardCounter)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	roBitternuts 0
)

(local
	oCurSubtitle
	nZoomAmt = 10
	nZoomStart = 1
	nZoomEnd = 128
	nIntroSaved
	mrBitterFlag
	bHideMrsBitterTalker
)

(procedure (addRoomObstacles)
	(if (gCurRoom obstacles:)
		((gCurRoom obstacles:) dispose:)
		(gCurRoom obstacles: 0)
	)
	(if (not ((ScriptID 64017 0) test: 48)) ; oFlags
		(voTrivetTile addHotspotVerb: 1)
	)
	(gCurRoom
		addObstacle:
			((Polygon new:)
				type: PContainedAccess
				init: 473 251 461 230 407 219 303 227 279 236 254 237 70 231 52 245 5 243 -3 316 361 320 359 303 537 280 633 315 632 271 598 272 560 251 512 264
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 341 231 383 240 382 262 329 282 280 274 270 242
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 253 241 253 269 196 294 134 264 133 236 181 233
				yourself:
			)
	)
)

(instance voTrivetTile of View
	(properties
		approachX 487
		approachY 337
		x 485
		y 281
		priority 325
		fixPriority 1
		view 20200
		loop 7
	)

	(method (doVerb)
		(if ((ScriptID 64017 0) test: 67) ; oFlags
			(gEgo setScript: soPickUpTrivet)
		else
			(gEgo setScript: soAttemptPickUpTrivet)
		)
	)
)

(instance soAttemptPickUpTrivet of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 487 282 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 180 self)
			)
			(2
				(gEgo
					setPri: (gEgo priority:)
					setMotion:
						MoveTo
						(voTrivetTile approachX:)
						(voTrivetTile approachY:)
						self
				)
			)
			(3
				(gEgo hide:)
				(poTorin
					setCel: 0
					setLoop: 5
					posn: 484 281
					setPri: (+ (voTrivetTile priority:) 1)
					init:
					setCycle: CT 15 1 self
				)
				(gMessager say: 4 1 11 1 self) ; "Hey! What are you doing? Put that down!"
			)
			(4)
			(5
				(poTorin setCycle: Beg self)
			)
			(6
				(poTorin dispose:)
				(gEgo show: setMotion: MoveToNoLoop 487 282 self)
			)
			(7
				(gEgo setPri: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soAwayFromTable of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 480 287 self)
			)
			(1
				(gEgo setPri: -1 setMotion: PolyPath 370 267 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soPickUpTrivet of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 487 282 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 180 self)
			)
			(2
				(gEgo
					setPri: (gEgo priority:)
					setMotion:
						MoveTo
						(voTrivetTile approachX:)
						(voTrivetTile approachY:)
						self
				)
			)
			(3
				(gEgo hide:)
				(poTorin
					setCel: 0
					setLoop: 5
					setPri: (+ (voTrivetTile priority:) 1)
					setScale: 0
					posn: 484 281
					init:
					setCycle: CT 8 1 self
				)
			)
			(4
				(voTrivetTile dispose:)
				(gMessager say: 4 1 5 1 self) ; "Hey, hey! What are you doing? Put that down! That's my best trivet!"
				(poTorin setCycle: CT 14 1 self)
			)
			(5)
			(6
				(gMessager sayRange: 4 1 5 2 3 self) ; "Ah, Mom. Let him have it. You haven't cooked since I was born!"
			)
			(7
				(gMessager say: 4 1 5 4 self) ; "The kid's right. Go on. Take it. (APPLAUSE)"
				(= ticks 80)
			)
			(8
				(if ticks
					(= ticks 1)
				)
				(poTorin setCycle: End self)
			)
			(9)
			(10
				(poTorin dispose:)
				(gEgo show: get: ((ScriptID 64001 0) get: 16)) ; oInvHandler, ioTrivetTile
				(self setScript: soAwayFromTable self)
				((ScriptID 64017 0) set: 48) ; oFlags
				(gMessager sayRange: 4 1 5 5 9 self) ; "(phony canned applause)"
			)
			(11)
			(12
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance toBobbyTalker of Talker
	(properties
		x 24
		y 301
		view 20202
		loop 9
		priority 302
	)
)

(instance poBoogleYoYo of Prop
	(properties
		x 94
		y 301
		view 20204
	)
)

(instance soBoogleToYoYo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo get: ((ScriptID 64001 1) get: 2)) ; oBoogleHandler, ioBoogleYoYo
				(gCurRoom delBoogleFeature: foYoYo)
				(poBobbyFidget setScript: 0 setCycle: Fwd)
				(poBoogleYoYo setScalePercent: 139 init: setCycle: CT 24 1 self)
				((ScriptID 64018 0) hide:) ; oBoogle
			)
			(1
				(goSound1 playSound: 60011)
				(poBoogleYoYo setCycle: End self)
			)
			(2
				(poBoogleYoYo dispose:)
				((ScriptID 64018 0) show:) ; oBoogle
				(poBobbyFidget setScript: soBobbyFidget)
				(self dispose:)
			)
		)
	)
)

(instance foYoYo of BoogleLearnMeClass
	(properties
		approachX 94
		approachY 301
	)
)

(instance soBoogleGarbage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom delBoogleFeature: foGarbage)
				(self dispose:)
			)
		)
	)
)

(instance foGarbage of BoogleLearnMeClass
	(properties
		approachX 559
		approachY 255
	)
)

(instance soBoogleTV of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom delBoogleFeature: foTV)
				(self dispose:)
			)
		)
	)
)

(instance foTV of BoogleLearnMeClass
	(properties
		approachX 284
		approachY 309
	)
)

(instance poBoogleShovel of Prop
	(properties
		x 255
		y 255
		view 20204
		loop 1
	)
)

(instance soBoogleToShovel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 64018 0) hide:) ; oBoogle
				(gCurRoom delBoogleFeature: foShovel)
				(gEgo get: ((ScriptID 64001 1) get: 3)) ; oBoogleHandler, ioBoogleShovel
				(poBoogleShovel setCel: 0 init: setCycle: CT 18 1 self)
			)
			(1
				(goSound1 playSound: 60011)
				(poBoogleShovel setCycle: End self)
			)
			(2
				(poBoogleShovel dispose:)
				((ScriptID 64018 0) show: setWander: 1) ; oBoogle
				(self dispose:)
			)
		)
	)
)

(instance foShovel of BoogleLearnMeClass
	(properties
		approachX 262
		approachY 242
	)
)

(instance soTalkToMrBitter of TPScript
	(properties)

	(method (changeState newState &tmp rand)
		(switch (= state newState)
			(0
				(gEgo approachThenFace: poMrBitter self)
			)
			(1
				(gMessager say: 2 1 0 0 self) ; "How do you do, sir? My name is Torin."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance poMrBitter of Prop
	(properties
		approachX 457
		approachY 243
		x 510
		y 246
		view 20203
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gEgo setScript: soTalkToMrBitter)
	)
)

(instance soBobbyFidget of Script
	(properties)

	(method (changeState newState &tmp rand)
		(switch (= state newState)
			(0
				(if (< (= rand (Random 1 100)) 20)
					(poBobbyFidget
						setCel: 0
						setLoop: 6
						setCycle: ForwardCounter (Random 2 7) self
					)
				else
					(= ticks (Random 40 180))
				)
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance soBobbyRunAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poBobby
					setCel: 0
					setLoop: 3
					posn: 84 249
					setPri: 301
					setCycle: End self
				)
				(poBobbyFidget init: hide:)
			)
			(1
				(poBobbyFidget show:)
				(poBobby dispose:)
			)
		)
	)
)

(instance soMrBitterLookMa of Script
	(properties)

	(method (changeState newState &tmp rand)
		(switch (= state newState)
			(0
				(poMrBitter setCel: 0 setLoop: 0 setCycle: CT 9 1 self)
			)
			(1
				(= ticks 180)
			)
			(2
				(poMrBitter setCycle: End self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soMrBitterLookCamera of Script
	(properties)

	(method (changeState newState &tmp rand)
		(switch (= state newState)
			(0
				(poMrBitter setCel: 0 setLoop: 3 setCycle: CT 18 1 self)
			)
			(1
				(= ticks 80)
			)
			(2
				(poMrBitter setCycle: End self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance oMrBitterSound of TPSound
	(properties)
)

(instance soMrBitterPan of Script
	(properties)

	(method (changeState newState &tmp rand)
		(switch (= state newState)
			(0
				(poMrBitter setCel: 0 setLoop: 1 setCycle: CT 7 1 self)
			)
			(1
				(oMrBitterSound playSound: 20211)
				(poMrBitter setCycle: CT 13 1 self)
			)
			(2
				(poMrBitter setCycle: End self)
				(oMrBitterSound stop:)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soMrBitterToss of Script
	(properties)

	(method (changeState newState &tmp rand)
		(switch (= state newState)
			(0
				(poMrBitter setCel: 0 setLoop: 2 setCycle: CT 15 1 self)
			)
			(1
				(oMrBitterSound playSound: 20212)
				(poMrBitter setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soMrBitterFidget of Script
	(properties)

	(method (changeState newState &tmp rand)
		(switch (= state newState)
			(0
				(switch mrBitterFlag
					(1
						(self setScript: soMrBitterLookMa self)
						(= mrBitterFlag 0)
					)
					(2
						(self setScript: soMrBitterLookCamera self)
						(= mrBitterFlag 0)
					)
					(else
						(cond
							((< (= rand (Random 1 100)) 15)
								(self setScript: soMrBitterPan self)
							)
							((< rand 30)
								(self setScript: soMrBitterToss self)
							)
							(else
								(= ticks (Random 40 180))
							)
						)
					)
				)
			)
			(1
				(= state -1)
				(= ticks 1)
			)
		)
	)
)

(instance soApproachMrsBitternut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (gEgo x:) 208)
					(gEgo setMotion: PolyPath 269 289 self)
				else
					(gEgo setMotion: PolyPath 128 301 self)
				)
			)
			(1
				(if (> (gEgo x:) 208)
					(gEgo setHeading: 315 self)
				else
					(gEgo setHeading: 45 self)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soTalk4MrsBitter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager sayRange: 1 1 7 1 2 self) ; "I'm sure King Rupert means to be nice to you. Perhaps he's just busy?"
			)
			(1
				(gMessager say: 1 1 7 3 self) ; "Di?"
			)
			(2
				(gMessager sayRange: 1 1 7 4 7 self) ; "Yeah, she should!"
			)
		)
	)
)

(instance soTalkMrsBitternut of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: soApproachMrsBitternut self)
			)
			(1
				(switch gnMrsBitterTalk
					(2
						(gMessager say: 1 1 6 0 self) ; "Mrs. Bitternut, I was wondering..."
					)
					(3
						(self setScript: soTalk4MrsBitter self)
						((ScriptID 64017 0) set: 66) ; oFlags
					)
					(4
						(gMessager say: 1 1 8 0 self) ; "What about their daughter?"
					)
					(else
						(gMessager say: 1 1 9 0 self) ; "How would you describe Leenah?"
					)
				)
				(if (< gnMrsBitterTalk 9)
					(++ gnMrsBitterTalk)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soPointAtBag of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poMrsBitter setCel: 0 setLoop: 3 setCycle: CT 3 1 self)
			)
			(1
				(= ticks 70)
			)
			(2
				(poMrsBitter setCycle: CT 0 -1 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance poTorinNoBag of Prop
	(properties
		view 20206
		loop 1
	)
)

(instance poBooglePeek of Prop
	(properties
		view 20206
	)
)

(instance soBooglePeek of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo hide:)
				(poTorinNoBag
					posn: (gEgo x:) (gEgo y:)
					setScale:
					scaleX: (gEgo scaleX:)
					scaleY: (gEgo scaleY:)
					setPri: (gEgo priority:)
					init:
				)
				(poBooglePeek
					posn: (gEgo x:) (gEgo y:)
					setScale:
					scaleX: (gEgo scaleX:)
					scaleY: (gEgo scaleY:)
					setPri: (gEgo priority:)
					init:
					setCycle: End self
				)
			)
			(1
				(poTorinNoBag dispose:)
				(poBooglePeek dispose:)
				(gEgo show:)
				(self dispose:)
			)
		)
	)
)

(instance soMrsBitterPoint of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poMrsBitter setCel: 0 setLoop: 6 setCycle: CT 4 1 self)
			)
			(1
				(= ticks 60)
				(self setScript: soBooglePeek self)
			)
			(2)
			(3
				(poMrsBitter setCycle: End self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance soMrsBitterToChair of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poMrsBitter
					setCel: 8
					setLoop: 4
					setPri: 258
					setCycle: CT 35 1 self
				)
				(poDoor setLoop: 8 show:)
			)
			(1
				(goSound1 playSound: 20213)
				(poMrsBitter setCycle: End self)
			)
			(2
				(poMrsBitter dispose:)
				(poMrsBitterChair init:)
				(self dispose:)
			)
		)
	)
)

(instance soFirstTalk of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 60011)
				(gEgo setHeading: 180 self)
			)
			(1
				(gMessager say: 1 1 3 1 self) ; "My name is Torin. From The Lands Above."
			)
			(2
				(= gtMrsBitter poMrsBitterDoorTalker)
				(gMessager say: 1 1 3 2 self) ; "I'm Mrs. Bitternut. And this is what's left of my husband, Mr. Bitternut."
				(= ticks 70)
			)
			(3
				(= gtMrsBitter 0)
				(if (poMrsBitterDoorTalker mouth:)
					((poMrsBitterDoorTalker mouth:) hide:)
				)
				(poMrsBitter setCel: 0 setLoop: 3 setCycle: CT 5 1 self)
				(= mrBitterFlag 1)
				(if (> (soMrBitterFidget ticks:) 1)
					(soMrBitterFidget ticks: 1)
				)
			)
			(4)
			(5
				(gMessager say: 1 1 3 3 self) ; "(phony laugh track)"
				(poMrsBitter setCycle: End self)
			)
			(6)
			(7
				(gMessager sayRange: 1 1 3 4 5 self) ; "And that's Bobby, our son."
				(self setScript: soMrsBitterPoint self)
			)
			(8)
			(9
				(gMessager sayRange: 1 1 3 6 7 self) ; "So, ah, what's that thing in your purse?"
				(self setScript: soPointAtBag self)
			)
			(10)
			(11
				(gMessager sayRange: 1 1 4 1 2 self) ; "Why, that's my little buddy...Boogle!"
			)
			(12
				(addRoomObstacles)
				(gMessager say: 1 1 4 3 self) ; "(phony canned applause)"
				(self setScript: (ScriptID 64018 2) self) ; soBoogleOutOfPouch
				(poBobby setScript: soBobbyRunAway self)
			)
			(13)
			(14)
			(15
				(= gtMrsBitter poMrsBitterDoorTalker)
				(gMessager sayRange: 1 1 4 4 6 self) ; "He won't hurt you. He likes people."
			)
			(16
				(= gtMrsBitter 0)
				(gMessager sayRange: 1 1 4 7 8 self) ; "If he's smart, he'll stay off my furniture!"
				(self setScript: soMrsBitterToChair self)
			)
			(17)
			(18
				(gEgo setMotion: MoveTo 94 257 self)
			)
			(19
				(gGame handsOn:)
				(= gnMrsBitterTalk 2)
				(self dispose:)
			)
		)
	)
)

(instance soGiveInvite of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 158 296 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 45 self)
			)
			(2
				(gMessager say: 1 34 0 1 self) ; "Mrs. B, I just came from King Rupert and he asked me to give you this."
			)
			(3
				(gEgo hide:)
				(poTorin
					loop: 4
					cel: 0
					setPri: -1
					posn: (gEgo x:) (gEgo y:)
					setScale:
					scaleX: (gEgo scaleX:)
					scaleY: (gEgo scaleY:)
					init:
					doit:
					setCycle: CT 19 1 self
				)
				(gMessager say: 1 34 0 2 self) ; "What is it?"
			)
			(4)
			(5
				(gMessager sayRange: 1 34 0 3 7 self) ; "An invitation to the Royal Ball!"
			)
			(6
				(gMessager say: 1 34 0 8 self) ; "Toring, if there's anything we own that you need for your journey, why just help yourself. It's yours!"
				(poTorin setCycle: End self)
			)
			(7)
			(8
				(poTorin setScale: 0 dispose:)
				(gEgo put: ((ScriptID 64001 0) get: 24) show:) ; oInvHandler, ioBallInvite
				((ScriptID 64017 0) set: 67 66) ; oFlags
				(gMessager sayRange: 1 34 0 9 12 self) ; "(phony canned applause)"
			)
			(9
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poMrsBitterBust of View
	(properties
		x 203
		y 243
		priority 258
		fixPriority 1
		view 20207
	)
)

(instance poMrsBitterArms of Prop
	(properties
		x 203
		y 243
		priority 259
		fixPriority 1
		view 20207
		loop 2
		cycleSpeed 12
	)
)

(instance poMrsBitterDoorTalker of Talker
	(properties
		x 29
		y 247
		view 20201
		loop 8
		priority 248
	)

	(method (init)
		(super init:)
		(if bHideMrsBitterTalker
			(mouth hide:)
		)
	)
)

(instance toMrsBitterTalker of Talker
	(properties
		x 206
		y 254
		view 20207
		loop 1
		priority 259
	)

	(method (init)
		(if (poMrsBitterChair scratch:)
			(poMrsBitterChair hide:)
		)
		(if (poMrsBitter scratch:)
			(poMrsBitter hide:)
		)
		(poMrsBitterBust init:)
		(= eyes poMrsBitterArms)
		(super init:)
		(if bHideMrsBitterTalker
			(mouth hide:)
		)
	)

	(method (dispose)
		(if (poMrsBitterChair scratch:)
			(poMrsBitterChair show:)
		)
		(if (poMrsBitter scratch:)
			(poMrsBitter show:)
		)
		(poMrsBitterBust dispose:)
		(super dispose:)
	)
)

(instance poMrsBitter of Prop
	(properties
		approachX 69
		approachY 235
		x 202
		y 259
		view 20201
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(if (== gnMrsBitterTalk 3)
			(gEgo setScript: soFirstTalk)
		else
			(gEgo setScript: soTalkMrsBitternut)
		)
	)
)

(instance poMrsBitterChair of Prop
	(properties
		x 202
		y 258
		view 20201
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
		(self addHotspotVerb: 1 34)
		(= gtMrsBitter toMrsBitterTalker)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gEgo setScript: soTalkMrsBitternut)
			)
			(34 ; ioBallInvite
				(gEgo setScript: soGiveInvite)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(= gtMrsBitter 0)
	)
)

(instance soTouchBobby of TPScript
	(properties)

	(method (changeState newState &tmp rand)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 135 self)
			)
			(1
				(self setScript: (ScriptID 64007 1) self self) ; soEgoGetLow
			)
			(2
				(gMessager say: 3 1 0 1 self) ; "Hello, young man."
			)
			(3)
			(4
				(poBobby deleteHotspotVerb: 1)
				(gMessager sayRange: 3 1 0 2 4 self) ; "Did he touch you, boy?"
			)
			(5
				(gMessager sayRange: 3 1 0 5 6 self) ; "What do you mean, not really? (TO TORIN) You touch that boy again, I'll have you arrested! We don't need no uppity strangers from some other land touching our kids!"
				(gEgo setHeading: 180 self)
			)
			(6)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poBobby of Prop
	(properties
		approachX 69
		approachY 235
		x 276
		y 240
		view 20202
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gEgo setScript: soTouchBobby)
	)
)

(instance poBobbyTVLookAtDoor of Prop
	(properties
		x 298
		y 262
		view 20202
		loop 5
	)
)

(instance toBobbyTvTalker of Talker
	(properties
		x 298
		y 262
		view 20202
		loop 10
		priority 262
	)

	(method (init)
		(poBobbyTV hide:)
		(super init: &rest)
	)

	(method (dispose)
		(poBobbyTV show:)
		(super dispose: &rest)
	)
)

(instance soBobbyTvBlink of SoTwinkle
	(properties
		minCycle 8
		maxCycle 8
		minDelay 50
		maxDelay 150
	)
)

(instance poBobbyTV of Prop
	(properties
		x 298
		y 262
		view 20202
		loop 4
	)

	(method (init)
		(super init: &rest)
		(= gtBobbyBitter toBobbyTvTalker)
		(self setScript: soBobbyTvBlink)
	)

	(method (dispose)
		(super dispose: &rest)
		(= gtBobbyBitter 0)
	)
)

(instance soTouchBobbyFidget of TPScript
	(properties)

	(method (changeState newState &tmp rand)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 122 305 self)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(self setScript: (ScriptID 64007 1) self self) ; soEgoGetLow
			)
			(3
				(gMessager say: 3 1 0 1 self) ; "Hello, young man."
			)
			(4)
			(5
				(gMessager sayRange: 3 1 0 2 4 self) ; "Did he touch you, boy?"
			)
			(6
				(gMessager sayRange: 3 1 0 5 6 self) ; "What do you mean, not really? (TO TORIN) You touch that boy again, I'll have you arrested! We don't need no uppity strangers from some other land touching our kids!"
				(gEgo setHeading: 45 self)
			)
			(7)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poBobbyFidget of Prop
	(properties
		approachX 41
		approachY 267
		x 24
		y 301
		view 20202
		loop 6
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(= gtBobbyBitter toBobbyTalker)
	)

	(method (dispose)
		(super dispose:)
		(= gtBobbyBitter 0)
	)

	(method (doVerb)
		(gEgo setScript: soTouchBobbyFidget)
	)
)

(instance soExitTorin of Script
	(properties)

	(method (changeState newState &tmp rand)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 70 231 self)
			)
			(1
				(gEgo setMotion: MoveTo 61 231 self)
			)
			(2
				(gEgo setHeading: 315 self)
			)
			(3
				(gEgo hide:)
				(poTorin
					setPri: (gEgo priority:)
					loop: 6
					cel: 0
					posn: (gEgo x:) (gEgo y:)
					setScale: 0
					init:
					setCycle: CT 7 1 self
				)
			)
			(4
				(poTorin setPri: 200 setCycle: End self)
			)
			(5
				(gEgo
					posn: (- (poTorin x:) 19) (- (poTorin y:) 10)
					setPri: (poTorin priority:)
					setHeading: 270 self
				)
				(poTorin dispose:)
			)
			(6
				(gEgo
					setMotion: MoveTo (- (gEgo x:) 20) (gEgo y:) self
				)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance soExitMessage of Script
	(properties)

	(method (changeState newState &tmp rand)
		(switch (= state newState)
			(0
				(gMessager say: 0 0 2 1 self) ; "Be sure to join us next time, when we hear Bobby Bitternut ask..."
			)
			(1
				(gMessager say: 0 0 2 (Random 2 6) self)
			)
			(2
				(gMessager sayRange: 0 0 2 7 9 self) ; "(phony laugh track)"
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soExit of TPScript
	(properties)

	(method (changeState newState &tmp rand)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self setScript: (ScriptID 64018 1) self) ; soBoogleIntoPouch
			)
			(1
				(self setScript: soExitMessage self)
				(gEgo setScript: soExitTorin self)
			)
			(2)
			(3
				(self dispose:)
				(gCurRoom newRoom: 20100) ; roCliffScroller
			)
		)
	)
)

(instance poDoor of Prop
	(properties
		x 8
		y 140
		priority 235
		fixPriority 1
		view 20200
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 7 218 7 137 62 137 61 218
					yourself:
				)
		)
		(self forceCursor: (ScriptID 64006 1)) ; oNorthCursor
	)

	(method (doVerb)
		(gCurRoom setScript: soExit)
	)
)

(instance poTorin of Prop
	(properties
		x 47
		y 214
		view 20200
		loop 1
	)
)

(instance soWalkToDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poMrsBitter setCycle: CT 40 1 self)
			)
			(1
				(poMrsBitter
					posn: (+ (poMrsBitter x:) 1) (+ (poMrsBitter y:) 1)
					setCycle: CT 45 1 self
				)
			)
			(2
				(poMrsBitter
					posn: (+ (poMrsBitter x:) 1) (+ (poMrsBitter y:) 1)
					setCycle: CT 50 1 self
				)
			)
			(3
				(poMrsBitter
					posn: (poMrsBitter x:) (+ (poMrsBitter y:) 1)
					setCycle: CT 58 1 self
				)
			)
			(4
				(poDoor hide:)
				(self dispose:)
			)
		)
	)
)

(instance soWhoIsIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poMrsBitter setCycle: CT 8 1 self)
			)
			(1
				(= ticks 45)
			)
			(2
				(= gtMrsBitter toMrsBitterTalker)
				(gMessager say: 0 0 1 6 self) ; "(LOUDLY) Just a minute... (SOFTER) Harley, can you get that? (PAUSE THEN DISGUSTED) Oh, never mind. Do I have to do everything around here? (LOUDER) Coming."
				(= ticks 170)
			)
			(3
				(= gtMrsBitter 0)
				(if (toMrsBitterTalker mouth:)
					((toMrsBitterTalker mouth:) hide:)
					(poMrsBitterArms hide:)
					(poMrsBitterBust hide:)
					(poMrsBitter show:)
				)
				(self setScript: soWalkToDoor self)
			)
			(4)
			(5
				(self dispose:)
			)
		)
	)
)

(instance soWhoIsIt2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poMrsBitter setCycle: CT 8 1 self)
			)
			(1
				(= ticks 45)
			)
			(2
				(= gtMrsBitter toMrsBitterTalker)
				(gMessager say: 0 0 12 1 self) ; "(LOUDLY) Just a minute..."
			)
			(3
				(poMrsBitter setCycle: CT 22 1 self)
			)
			(4
				(gMessager say: 0 0 12 2 self) ; "(LOUDLY) Coming!"
			)
			(5
				(if (toMrsBitterTalker mouth:)
					((toMrsBitterTalker mouth:) hide:)
					(poMrsBitterArms hide:)
					(poMrsBitterBust hide:)
					(poMrsBitter show:)
				)
				(self setScript: soWalkToDoor self)
				(= ticks (* 18 (poMrsBitter cycleSpeed:)))
			)
			(6
				(= gtMrsBitter 0)
				(gMessager say: 0 0 12 3 self) ; "Do I have to do everything around here?"
			)
			(7)
			(8
				(self dispose:)
			)
		)
	)
)

(instance soKnockDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(goSound1 preload: 20210)
				(poDoor setCel: 0 setCycle: CT 1 1 self)
			)
			(1
				(goSound1 playSound: 20210)
				(poDoor setCycle: CT 4 1 self)
			)
			(2
				(goSound1 playSound: 20210)
				(poDoor setCycle: CT 7 1 self)
			)
			(3
				(goSound1 playSound: 20210)
				(poDoor setCycle: End self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance soTorinEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not ((ScriptID 64017 0) test: 65)) ; oFlags
					(gMessager say: 0 0 1 17 self) ; "Why, thank you. I will."
				else
					(= ticks 1)
				)
			)
			(1
				(poTorin setCycle: CT 5 1 self)
			)
			(2
				(poTorin setPri: 217 setCycle: End self)
			)
			(3
				(if (not ((ScriptID 64017 0) test: 65)) ; oFlags
					(gMessager say: 0 0 1 18 self) ; "(phony laugh track)"
				else
					(= ticks 1)
				)
			)
			(4
				(poTorin dispose:)
				(gEgo
					posn: 50 234
					loop: 4
					show:
					setMotion: MoveTo 69 235 self
				)
			)
			(5
				(gEgo setHeading: 180 self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance voLogo of View
	(properties
		x 302
		y 144
		priority 500
		fixPriority 1
		view 20205
	)
)

(instance soZoomLogo of Script
	(properties)

	(method (init)
		(= nZoomStart 1)
		(= nZoomEnd 128)
		(voLogo setScale: maxScale: 128 scaleX: nZoomStart scaleY: nZoomStart init:)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 8)
			)
			(1
				(+= nZoomStart nZoomAmt)
				(if
					(or
						(and (> nZoomAmt 0) (>= nZoomStart nZoomEnd))
						(and (< nZoomAmt 0) (<= nZoomStart nZoomEnd))
					)
					(self cue:)
					(return)
				)
				(voLogo scaleX: nZoomStart scaleY: nZoomStart)
				(= ticks 8)
				(-- state)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soIntroSubtitles of Script
	(properties)

	(method (dispose)
		(if oCurSubtitle
			(oCurSubtitle dispose:)
		)
		(if (< nIntroSaved 1)
			((gMessager oTextSaver:) rememberMessage: gCurRoomNum 0 0 1 1)
		)
		(if (< nIntroSaved 2)
			((gMessager oTextSaver:) rememberMessage: gCurRoomNum 0 0 1 2)
		)
		(if (< nIntroSaved 3)
			((gMessager oTextSaver:) rememberMessage: gCurRoomNum 0 0 1 3)
		)
		(if (< nIntroSaved 4)
			((gMessager oTextSaver:) rememberMessage: gCurRoomNum 0 0 1 4)
		)
		(if (< nIntroSaved 5)
			((gMessager oTextSaver:) rememberMessage: gCurRoomNum 0 0 1 5)
		)
		(voLogo dispose:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 60)
				(= nIntroSaved 0)
			)
			(1
				(if (& gMsgType $0001)
					(= oCurSubtitle (MakeMessageSubTitle gCurRoomNum 0 0 1 1))
				else
					(= oCurSubtitle 0)
				)
				((gMessager oTextSaver:) rememberMessage: gCurRoomNum 0 0 1 1)
				(= nIntroSaved 1)
				(= ticks 395)
			)
			(2
				(= ticks 90)
			)
			(3
				(if oCurSubtitle
					(oCurSubtitle dispose:)
					(= oCurSubtitle (MakeMessageSubTitle gCurRoomNum 0 0 1 2))
				)
				((gMessager oTextSaver:) rememberMessage: gCurRoomNum 0 0 1 2)
				(= nIntroSaved 2)
				(= ticks 189)
			)
			(4
				(= ticks 126)
			)
			(5
				(if oCurSubtitle
					(oCurSubtitle dispose:)
					(= oCurSubtitle (MakeMessageSubTitle gCurRoomNum 0 0 1 3))
				)
				((gMessager oTextSaver:) rememberMessage: gCurRoomNum 0 0 1 3)
				(= nIntroSaved 3)
				(= ticks 262)
			)
			(6
				(= ticks 116)
			)
			(7
				(if oCurSubtitle
					(oCurSubtitle dispose:)
					(= oCurSubtitle (MakeMessageSubTitle gCurRoomNum 0 0 1 4))
				)
				((gMessager oTextSaver:) rememberMessage: gCurRoomNum 0 0 1 4)
				(= nIntroSaved 4)
				(= ticks 225)
			)
			(8
				(if oCurSubtitle
					(oCurSubtitle dispose:)
					(= oCurSubtitle 0)
				)
				(= ticks 1110)
			)
			(9
				(if (& gMsgType $0001)
					(= oCurSubtitle (MakeMessageSubTitle gCurRoomNum 0 0 1 5))
				)
				((gMessager oTextSaver:) rememberMessage: gCurRoomNum 0 0 1 5)
				(= nIntroSaved 5)
			)
		)
	)
)

(instance oIntro of Sound
	(properties
		number 20299
	)
)

(instance soTheBitternutsIntro of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: soZoomLogo)
				(oIntro play: (Min 127 (MulDiv 130 gMusicVol 100)) self)
				(= ticks 1)
			)
			(1
				(poMrsBitter setScript: soIntroSubtitles)
			)
			(2
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(oIntro stop:)
		(poMrsBitter setScript: 0)
		(super dispose:)
	)
)

(instance soBobbyEnterAndSpin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poBobby show: setCycle: CT 9 1 self)
			)
			(1
				(poBobby setLoop: 8 setCel: 0 setCycle: Fwd self)
				(self dispose:)
			)
		)
	)
)

(instance soMrsBitterLeanForward of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= bHideMrsBitterTalker 1)
				(if (poMrsBitterDoorTalker mouth:)
					((poMrsBitterDoorTalker mouth:) hide:)
				)
				(poMrsBitter setCycle: End self)
			)
			(1
				(= bHideMrsBitterTalker 0)
				(if (poMrsBitterDoorTalker mouth:)
					((poMrsBitterDoorTalker mouth:) show:)
				)
				(self dispose:)
			)
		)
	)
)

(instance soBobbyEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 0 1 19 self) ; "Hey Mom, I..."
				(self setScript: soBobbyEnterAndSpin)
			)
			(1
				(gMessager say: 0 0 1 20 soBobbyEnter) ; "(phony canned applause)"
			)
			(2
				(poBobby setCycle: 0 setLoop: 0 setCel: 7 setCycle: End self)
				(gMessager sayRange: 0 0 1 21 22 self) ; "(STARTING AGAIN) Hey Mom, I... Whoa! Who's the big guy?"
			)
			(3)
			(4
				(self dispose:)
			)
		)
	)
)

(instance soTheBitternuts of TPScript
	(properties
		bHasFF 1
		bHasRew 1
	)

	(method (ff)
		(self setScript: 0)
		(voLogo dispose:)
		(gGame handsOn:)
		(gEgo posn: 69 235 setHeading: 180 setPri: -1 setScript: 0 show:)
		(poTorin setPri: -1 dispose:)
		(poMrsBitter
			setScript: 0
			setCycle: 0
			setLoop: 2
			setCel: (CelHigh (poMrsBitter view:) 2 0)
			posn: 29 247
		)
		(poBobby
			setScript: 0
			setCycle: 0
			setLoop: 1
			setCel: (CelHigh (poBobby view:) 1 0)
			posn: 85 242
			show:
		)
		(poDoor setCycle: 0 hide:)
		((ScriptID 64017 0) set: 65) ; oFlags
		(= gtMrsBitter 0)
		(self dispose:)
	)

	(method (rewind)
		(gCurRoom setScript: soTheBitternuts)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo hide:)
				(if (gCurRoom obstacles:)
					((gCurRoom obstacles:) dispose:)
					(gCurRoom obstacles: 0)
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 68 234 68 236 70 236 70 234
							yourself:
						)
				)
				(poDoor setCycle: 0 show:)
				(poTorin
					setScript: 0
					setCycle: 0
					posn: 47 214
					setCel: 0
					setLoop: 1
					setPri: 215
					init:
					hide:
				)
				(poMrsBitter
					setScript: 0
					setCycle: 0
					setCel: 0
					setLoop: 0
					posn: 202 259
				)
				(poBobby
					setScript: 0
					setCycle: 0
					posn: 276 240
					setCel: 0
					setLoop: 0
					init:
					hide:
				)
				(= ticks 1)
			)
			(1
				(self setScript: soTheBitternutsIntro self)
			)
			(2
				(poTorin show:)
				(self setScript: soKnockDoor self)
				(poMrsBitter setScript: soWhoIsIt self)
			)
			(3)
			(4
				(poMrsBitter setCycle: End self)
			)
			(5
				(= gtMrsBitter poMrsBitterDoorTalker)
				(poMrsBitter posn: 29 247 setCel: 0 setLoop: 2)
				(gMessager sayRange: 0 0 1 7 10 self) ; "Yeow! Aren't you the giant, economy-sized visitor?!"
			)
			(6
				(gMessager sayRange: 0 0 1 11 12 self) ; "Harley? Take a look at this guy! This is what a REAL man looks like!"
				(= mrBitterFlag 1)
				(if (> (soMrBitterFidget ticks:) 1)
					(soMrBitterFidget ticks: 1)
				)
			)
			(7
				(gMessager sayRange: 0 0 1 13 16 self) ; "Harley? Oh, honey, don't mind him! He's just acting his IQ!"
				(= mrBitterFlag 2)
				(if (> (soMrBitterFidget ticks:) 1)
					(soMrBitterFidget ticks: 1)
				)
			)
			(8
				(self setScript: soTorinEnter self)
			)
			(9
				(self setScript: soBobbyEnter self)
			)
			(10
				(poBobby setCel: 0 setLoop: 1 posn: 85 242 setCycle: End self)
				(self setScript: soMrsBitterLeanForward self)
				(gMessager sayRange: 0 0 1 23 26 self) ; "We don't know, honey."
			)
			(11)
			(12)
			(13
				(self ff:)
				(self dispose:)
			)
		)
	)
)

(instance soBobbyLookAtDoor of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poBobbyTV hide:)
			)
		)
	)
)

(instance soTheBitternuts2 of TPScript
	(properties)

	(method (ff)
		(gEgo posn: 69 235 setHeading: 180 setPri: -1 show:)
		(poBobbyTV show:)
		(poBobbyTVLookAtDoor dispose:)
		(poDoor hide:)
		(poTorin setPri: -1 dispose:)
		(poMrsBitter dispose:)
		(poMrsBitterChair init:)
		((ScriptID 64018 0) setWander: 1) ; oBoogle
		(gGame handsOn:)
		(self dispose:)
	)

	(method (rewind)
		(gGame handsOff:)
		(gEgo hide:)
		(if (gCurRoom obstacles:)
			((gCurRoom obstacles:) dispose:)
			(gCurRoom obstacles: 0)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 68 234 68 236 70 236 70 234
					yourself:
				)
		)
		(poDoor show:)
		(poTorin setCel: 0 setLoop: 1 setPri: 215 init: hide:)
		(poMrsBitter setCel: 0 setLoop: 0 posn: 202 258)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self rewind:)
				(poTorin show:)
				(goSound1 playSound: 20215 self)
			)
			(1
				(self setScript: soKnockDoor self)
				(poMrsBitter setScript: soWhoIsIt2 self)
				(poBobbyTV hide:)
				(poBobbyTVLookAtDoor init: setCycle: CT 3 1)
			)
			(2)
			(3
				(poMrsBitter setCycle: End self)
			)
			(4
				(poMrsBitter posn: 29 247 setCel: 0 setLoop: 2)
				(self setScript: soTorinEnter self)
			)
			(5
				(self setScript: (ScriptID 64018 2) self) ; soBoogleOutOfPouch
			)
			(6
				(poMrsBitter
					setCel: 8
					setLoop: 4
					setPri: 258
					setCycle: End self
				)
				(poDoor setLoop: 8 show:)
				(poBobbyTVLookAtDoor init: setCycle: End self)
				(addRoomObstacles)
			)
			(7)
			(8
				(poBobbyTVLookAtDoor dispose:)
				(poBobbyTV show:)
				(poMrsBitter dispose:)
				(poMrsBitterChair init:)
				(gEgo setMotion: MoveTo 94 257 self)
			)
			(9
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance roBitternuts of TPRoom
	(properties
		picture 20200
	)

	(method (init)
		(super init: &rest)
		(poDoor init:)
		(poMrsBitter init:)
		(poMrBitter init: setScript: soMrBitterFidget)
		(if (not ((ScriptID 64017 0) test: 48)) ; oFlags
			(voTrivetTile init:)
		)
		(if (not (gEgo has: ((ScriptID 64001 1) get: 2))) ; oBoogleHandler, ioBoogleYoYo
			(foYoYo init: soBoogleToYoYo)
			(self addBoogleFeature: foYoYo)
		)
		(if (not (gEgo has: ((ScriptID 64001 1) get: 3))) ; oBoogleHandler, ioBoogleShovel
			(foShovel init: soBoogleToShovel)
			(self addBoogleFeature: foShovel)
		)
		(foGarbage init: soBoogleGarbage)
		(self addBoogleFeature: foGarbage)
		(gEgo
			normalize:
			setScaler: Scaler 140 85 301 236
			posn: 50 234
			setHeading: 135
			init:
			hide:
		)
		(gGame handsOff:)
		(if (not ((ScriptID 64017 0) test: 65)) ; oFlags
			(= gnMrsBitterTalk 3)
			(foTV init: soBoogleTV)
			(self addBoogleFeature: foTV)
			(gCurRoom setScript: soTheBitternuts)
		else
			(poBobbyTV init:)
			(gCurRoom setScript: soTheBitternuts2)
		)
	)
)

