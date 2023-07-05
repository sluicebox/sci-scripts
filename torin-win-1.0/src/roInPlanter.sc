;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50400)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use TPSound)
(use CueMe)
(use foEExit)
(use Plane)
(use Talker)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roInPlanter 0
	toMrsPlant 1
)

(local
	nShakes
	nTotShakes = 6
	nShakeDepth = 5
)

(procedure (CheckSounds)
	(if
		(or
			(== (poWorm1 nMode:) 3)
			(== (poWorm2 nMode:) 3)
			(== (poWorm3 nMode:) 3)
			(== (poWorm4 nMode:) 3)
		)
		(oMunchSound setAmbient: 50405)
	else
		(oMunchSound setAmbient: 0)
	)
	(if
		(or
			(== (poWorm1 nMode:) 2)
			(== (poWorm2 nMode:) 2)
			(== (poWorm3 nMode:) 2)
			(== (poWorm4 nMode:) 2)
		)
		(oStuckSound setAmbient: 50406)
	else
		(oStuckSound setAmbient: 0)
	)
)

(instance foSlopeExit of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 8)) ; oSouthWestCursor
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 254 24 251 24 292 505 292 479 315 0 316
					yourself:
				)
		)
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
				(gEgo setMotion: PolyPath 30 300 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: MoveTo -40 350 self)
			)
			(2
				(gCurRoom newRoom: 50600) ; roSlipperySlope
			)
		)
	)
)

(instance soComeIn of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: -40 350 doit: setMotion: MoveTo 30 300 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poMrsPlant of Prop
	(properties
		x 312
		y 190
		view 50403
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(|= signal $1000)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gEgo setScript: soGoToPlantCU)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soGoToPlantCU of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 375 232 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 315 self)
			)
			(2
				(= cycles 3)
			)
			(3
				(gCurRoom addRoomPlane: oPlantCUPlane)
				(self dispose:)
			)
		)
	)
)

(instance foBuilding of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 454 89 505 68 545 90 557 185 478 203 445 195
					yourself:
				)
		)
		(= x 505)
		(= y 220)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gEgo setScript: soLookAtBuilding)
	)
)

(instance soLookAtBuilding of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo face: foBuilding self)
			)
			(1
				(gMessager say: 7 1 0 0 self) ; "That's the courthouse and jail. I'm not going back that way!"
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance foWormPlants of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 319 215 331 195 358 193 361 169 377 166 395 186 394 194 407 206 410 215 383 215
					yourself:
				)
		)
		(self addHotspotVerb: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gEgo setScript: soGoToWormCU)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soGoToWormCU of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 375 232 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 315 self)
			)
			(2
				(gEgo hide:)
				(poTorin
					view: 50403
					loop: 6
					cel: 0
					posn: 375 232
					init:
					setCycle: End self
				)
			)
			(3
				(gCurRoom addRoomPlane: oWormCUPlane)
				(self dispose:)
			)
		)
	)
)

(instance foDawburrs of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 54 162 40 203 87 229 110 214 119 178
					yourself:
				)
		)
		(self addHotspotVerb: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gEgo setScript: soTakeDawburr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soTakeDawburr of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(goSound1 preload: 50504)
				(gEgo setMotion: PolyPath 78 232 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 0 self)
			)
			(2
				(gMessager say: 3 1 1 0 self) ; "Here's a dead long-stemmed flower on this dawburr plant. Surely no one would mind me "pruning" this."
			)
			(3
				(self setScript: (ScriptID 64007 2) self self) ; soEgoGetMed
			)
			(4
				(goSound1 playSound: 50504)
				(gEgo get: ((ScriptID 64001 0) get: 61)) ; oInvHandler, ioDawburr
				((ScriptID 64017 0) set: 177) ; oFlags
				(foDawburrs dispose:)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poTorin of Prop
	(properties)
)

(instance poBoogle of Prop
	(properties)
)

(instance poCop of Prop
	(properties)
)

(instance voFlowerbed of View
	(properties
		x 168
		y 231
		priority 1
		fixPriority 1
		view 50405
	)
)

(instance toTorin of Talker
	(properties
		x 287
		y 248
		view 50402
		loop 4
		priority 250
	)

	(method (init)
		(poTorin hide:)
		(super init: &rest)
	)

	(method (dispose)
		(poTorin show:)
		(super dispose: &rest)
	)
)

(instance toTorinSafe of Talker
	(properties
		x 243
		y 210
		view 50401
		loop 4
		priority 250
	)

	(method (init)
		(poTorin hide:)
		(super init: &rest)
	)

	(method (dispose)
		(poTorin show:)
		(super dispose: &rest)
	)
)

(instance toCop of Talker
	(properties
		x 455
		y 243
		view 50402
		loop 5
		priority 251
	)

	(method (init)
		(poCop hide:)
		(super init: &rest)
	)

	(method (dispose)
		(poCop show:)
		(super dispose: &rest)
	)
)

(instance poDreep of Prop
	(properties)
)

(instance oSiren of TPSound
	(properties)
)

(instance soScreenShake of Script
	(properties)

	(method (changeState newState &tmp nX nY)
		(switch (= state newState)
			(0
				(= nShakes 0)
				(= register ((gCurRoom plane:) top:))
				(= cycles 1)
			)
			(1
				(= nX ((gCurRoom plane:) left:))
				(if (& nShakes $0001)
					((gCurRoom plane:) moveTo: nX register)
				else
					((gCurRoom plane:) moveTo: nX (+ register nShakeDepth))
				)
				(UpdatePlane (gCurRoom plane:))
				(if (== (++ nShakes) nTotShakes)
					(self dispose:)
					(return)
				)
				(-= state 1)
				(= cycles 1)
			)
		)
	)

	(method (dispose &tmp nX nY)
		(= nX ((gCurRoom plane:) left:))
		((gCurRoom plane:) moveTo: nX register)
		(UpdatePlane (gCurRoom plane:))
		(super dispose: &rest)
	)
)

(instance soEnterFirstTime of TPScript
	(properties
		bHasFF 1
		bHasRew 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(voFlowerbed init:)
				(goSound1 preload: 50401 50410 50408 50409 50402 50403 50407)
				(= seconds 2)
			)
			(1
				(goSound1 playSound: 50401)
				(= ticks 110)
			)
			(2
				(poTorin
					view: 50401
					loop: 0
					cel: 0
					posn: 232 197
					init:
					setCycle: CT 3 1 self
				)
			)
			(3
				(poMrsPlant setCycle: CT 8 1)
				(voFlowerbed dispose:)
				(= nTotShakes 4)
				(= nShakeDepth 5)
				(poTorin setScript: soScreenShake setCycle: End self)
			)
			(4
				(= ticks 180)
			)
			(5
				(poTorin loop: 1 cel: 0 posn: 239 208 setCycle: End self)
				(poMrsPlant setCycle: CT 12 1)
				(goSound1 playSound: 50408)
			)
			(6
				(goSound1 playSound: 50402)
				(= ticks 15)
			)
			(7
				(poTorin
					view: 50401
					loop: 2
					cel: 0
					posn: 239 210
					doit:
					setCycle: CT 7 1 self
				)
			)
			(8
				(poTorin setCycle: CT 11 1 self)
				(poMrsPlant setCycle: CT 9 -1)
			)
			(9
				(= nTotShakes 6)
				(= nShakeDepth 10)
				(poTorin setScript: soScreenShake setCycle: End self)
			)
			(10
				(= ticks 120)
			)
			(11
				(poTorin
					loop: 3
					cel: 0
					posn: 243 210
					doit:
					setCycle: CT 5 1 self
				)
				(poMrsPlant setCycle: CT 12 1)
			)
			(12
				(poTorin setCycle: End self)
				(goSound1 playSound: 50403)
			)
			(13
				(= gtTorin toTorinSafe)
				(gMessager say: 0 0 9 1 self) ; "(WELL-ENUNCIATED, SLOWLY, CLEARLY) "Save us!" (PAUSE) I said, "SAVE us!" Boogle!"
			)
			(14
				(= gtTorin 0)
				(poTorin
					view: 50402
					loop: 0
					cel: 0
					posn: 239 247
					setCycle: CT 9 1 self
				)
			)
			(15
				(poTorin setCycle: CT 12 1 self)
				(poMrsPlant cycleSpeed: 10 setCycle: CT 14 1)
			)
			(16
				(poTorin setCycle: End self)
				(goSound1 playSound: 50409)
			)
			(17
				(poBoogle
					view: 50402
					loop: 2
					cel: 0
					posn: 238 247
					init:
					setCycle: CT 3 1 self
				)
				(poTorin loop: 1 cel: 0 posn: 287 248 setCycle: CT 18 1 self)
			)
			(18
				(oSiren setAmbient: 50407)
				(goMusic1 fadeIn: 50499 12 10)
				(poMrsPlant setCycle: CT 18 1)
			)
			(19
				(poCop
					view: 50402
					loop: 3
					cel: 0
					posn: 455 243
					setPri: 251
					init:
					setCycle: CT 8 1 self
				)
			)
			(20
				(oSiren fade: 0 10 9 1)
				(poMrsPlant setCycle: CT 14 -1)
				(poTorin setCycle: End self)
				(poBoogle setCycle: CT 0 -1)
				(poCop setCycle: End self)
			)
			(21)
			(22
				(= gtTorin toTorin)
				(= gtCop toCop)
				(gMessager sayRange: 0 0 9 2 5 self) ; "All right, you! You'd better come with me. You're under arrest!"
			)
			(23
				(= gtTorin 0)
				(= gtCop 0)
				(poBoogle setCycle: CT 11 1)
				(poCop loop: 6 cel: 0 posn: 424 243 setCycle: CT 16 1 self)
			)
			(24
				(poCop cel: 17)
				(poTorin dispose:)
				(goSound1 playSound: 50410)
				(poCop setCycle: End coResetCop)
				(poBoogle setCycle: CT 11 1 self)
			)
			(25
				(poMrsPlant setCycle: End coResetMrsPlant)
				(= ticks 50)
			)
			(26
				(poBoogle setCycle: CT 13 1 self)
			)
			(27
				(= ticks 180)
			)
			(28
				(goSound1 playSound: 50413)
				(= ticks 30)
			)
			(29
				(poBoogle setCycle: End self)
			)
			(30
				(poCop dispose:)
				(poBoogle dispose:)
				((ScriptID 64018 0) ; oBoogle
					posn: 219 254
					init:
					normalize:
					setScalePercent: 89
					setLoop: 5
					heading: 225
					setStep: 10 5
					setSpeed: 2
					doit:
					setWander: 0
					setMotion: MoveTo 650 250
				)
				(= ticks 70)
			)
			(31
				(goSound1 playSound: 50413)
				(= ticks 150)
				(goMusic1 fadeOut: 12 10)
			)
			(32
				(goMusic1 setMusic: 50599)
				(= ticks 120)
			)
			(33
				(poDreep
					view: 50406
					cel: 0
					posn: 384 146
					cycleSpeed: 9
					init:
					setCycle: CT 2 1 self
				)
			)
			(34
				(goSound1 playSound: 50414)
				(poDreep setCycle: End self)
			)
			(35
				(poDreep doit:)
				(FrameOut)
				(gCurRoom newRoom: 50500) ; roJailCell
			)
		)
	)

	(method (ff)
		(gCurRoom newRoom: 50500) ; roJailCell
	)

	(method (rewind)
		(gCurRoom newRoom: 50300) ; roAirDuctEnd
	)
)

(instance coResetMrsPlant of CueMe
	(properties)

	(method (cue)
		(poMrsPlant cel: 0)
	)
)

(instance coResetCop of CueMe
	(properties)

	(method (cue)
		(poCop dispose:)
	)
)

(instance soEnterSecondTime of TPScript
	(properties
		bHasRew 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 50404)
				(gEgo
					init:
					normalize:
					setScaler: Scaler 100 75 313 249
					posn: 293 249
					hide:
				)
				(= seconds 3)
			)
			(1
				(goSound1 playSound: 50404)
				(poTorin
					view: 50403
					loop: 1
					cel: 0
					posn: 289 252
					init:
					setCycle: End self
				)
			)
			(2
				(poTorin loop: 2 cel: 0 setCycle: End self)
			)
			(3
				(poTorin dispose:)
				(gEgo posn: 293 249 normalize: 1 60100 5 show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (rewind)
		(gCurRoom newRoom: 50300) ; roAirDuctEnd
	)
)

(instance poPlantCU of Prop
	(properties
		x 304
		y 314
		priority 50
		fixPriority 1
		view 50403
		loop 7
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(|= signal $1000)
		(self setScript: soMrsPlantBlink)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				((ScriptID 64017 0) set: 183) ; oFlags
				(if ((ScriptID 64017 0) test: 160) ; oFlags
					(gMessager say: 1 1 8 0) ; "I did it. The silkworms are no longer a problem. But, aren't they kinda funny colored?"
				else
					(switch gnPlantTalk
						(0
							(gCurRoom setScript: soMrsPlantTalk1)
							(++ gnPlantTalk)
						)
						(1
							(gMessager say: 1 1 4 0) ; "I've searched this entire planet looking for an evil sorceress named Lycentia. Have you heard of her?"
							(++ gnPlantTalk)
						)
						(2
							(gMessager say: 1 1 5 0) ; "Is there anyone here in Tenebrous that could help me?"
							(++ gnPlantTalk)
						)
						(3
							(gMessager say: 1 1 6 0) ; "But this theater...which way is it?"
							(++ gnPlantTalk)
						)
						(4
							(gMessager say: 1 1 7 0) ; "So, it's silkworms I seek?"
						)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soMrsPlantBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 50 150))
			)
			(1
				(client cel: 1)
				(= ticks (Random 6 12))
			)
			(2
				(client cel: 0)
				(self changeState: 0)
			)
		)
	)
)

(instance soStartTalking of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(gGame handsOn:)
				(poPlantCU doVerb: 1)
				(self dispose:)
			)
		)
	)
)

(instance soMrsPlantTalk1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 1 1 3 1 self) ; "Excuse me."
			)
			(1
				(gMessager say: 1 1 3 2 self) ; "Yea-us? (PAUSE; DISGUSTED:) Oh, it's you."
				(= ticks 100)
			)
			(2
				(poPlantCU loop: 9)
			)
			(3
				(poPlantCU loop: 7)
				(gMessager sayRange: 1 1 3 3 8 self) ; "Could you help me?"
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance voMrsPlantFace of View
	(properties
		x 304
		y 314
		priority 60
		fixPriority 1
		view 50403
		loop 8
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(|= signal $1000)
	)

	(method (doVerb)
		(poPlantCU doVerb: &rest)
	)
)

(instance toMrsPlant of Talker
	(properties
		x 304
		y 314
		view 50403
		loop 8
		priority 70
	)

	(method (init)
		(voMrsPlantFace hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voMrsPlantFace show:)
		(super dispose: &rest)
	)
)

(instance foPlantCUExit of CUExitFeature
	(properties)

	(method (doVerb)
		(gCurRoom deleteRoomPlane: oPlantCUPlane)
	)
)

(instance oPlantCUPlane of Plane
	(properties
		picture 50401
	)

	(method (init &tmp nPriTmp)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
		(gGame handsOff:)
		(goMusic1 setMusic: 50411)
		(poPlantCU init:)
		(voMrsPlantFace init:)
		(foPlantCUExit init:)
		(poPlantCU setScript: soStartTalking)
	)

	(method (dispose)
		(goMusic1 setMusic: 50400)
		(super dispose: &rest)
	)
)

(instance foWormCUExit of CUExitFeature
	(properties)

	(method (doVerb)
		(gCurRoom setScript: soExitWormCU)
	)
)

(instance soExitWormCU of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(oMunchSound stop:)
				(oStuckSound stop:)
				(gCurRoom deleteRoomPlane: oWormCUPlane)
				(poTorin
					view: 50403
					loop: 6
					cel: 11
					posn: 375 232
					doit:
					setCycle: Beg self
				)
			)
			(1
				(poTorin dispose:)
				(gEgo show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(class Leaf of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1 53)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gMessager say: 6 1 0 0) ; "Hey! Come back here!!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance foLeaf1 of Leaf
	(properties)

	(method (init)
		(super init: &rest)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 62 273 104 265 161 234 190 226 231 236 273 258 283 272 238 286 199 301 140 301
					yourself:
				)
		)
	)

	(method (testHotspotVerb)
		(if ((ScriptID 64017 0) test: 184) ; oFlags
			(return 0)
		else
			(return (super testHotspotVerb: &rest))
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(53 ; ioSappyDawburr
				(voSap1 init:)
				((ScriptID 64017 0) set: 184 188) ; oFlags
				(poWorm1 sappify:)
				(if
					(and
						((ScriptID 64017 0) test: 184) ; oFlags
						((ScriptID 64017 0) test: 185) ; oFlags
						((ScriptID 64017 0) test: 186) ; oFlags
						((ScriptID 64017 0) test: 187) ; oFlags
					)
					(gEgo put: ((ScriptID 64001 0) get: 62)) ; oInvHandler, ioSappyDawburr
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance foLeaf2 of Leaf
	(properties)

	(method (init)
		(super init: &rest)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 22 84 90 59 138 50 194 77 210 101 174 101 120 118 75 113
					yourself:
				)
		)
	)

	(method (testHotspotVerb)
		(if ((ScriptID 64017 0) test: 185) ; oFlags
			(return 0)
		else
			(return (super testHotspotVerb: &rest))
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(53 ; ioSappyDawburr
				(voSap2 init:)
				((ScriptID 64017 0) set: 185 188) ; oFlags
				(poWorm2 sappify:)
				(if
					(and
						((ScriptID 64017 0) test: 184) ; oFlags
						((ScriptID 64017 0) test: 185) ; oFlags
						((ScriptID 64017 0) test: 186) ; oFlags
						((ScriptID 64017 0) test: 187) ; oFlags
					)
					(gEgo put: ((ScriptID 64001 0) get: 62)) ; oInvHandler, ioSappyDawburr
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance foLeaf3 of Leaf
	(properties)

	(method (init)
		(super init: &rest)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 315 71 375 33 412 37 463 68 509 70 462 99 411 108 364 100 338 77
					yourself:
				)
		)
	)

	(method (testHotspotVerb)
		(if ((ScriptID 64017 0) test: 186) ; oFlags
			(return 0)
		else
			(return (super testHotspotVerb: &rest))
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(53 ; ioSappyDawburr
				(voSap3 init:)
				((ScriptID 64017 0) set: 186 188) ; oFlags
				(poWorm3 sappify:)
				(if
					(and
						((ScriptID 64017 0) test: 184) ; oFlags
						((ScriptID 64017 0) test: 185) ; oFlags
						((ScriptID 64017 0) test: 186) ; oFlags
						((ScriptID 64017 0) test: 187) ; oFlags
					)
					(gEgo put: ((ScriptID 64001 0) get: 62)) ; oInvHandler, ioSappyDawburr
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance foLeaf4 of Leaf
	(properties)

	(method (init)
		(super init: &rest)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 410 201 446 154 480 142 567 172 600 173 626 158 597 204 549 228 500 229 458 210 426 203
					yourself:
				)
		)
	)

	(method (testHotspotVerb)
		(if ((ScriptID 64017 0) test: 187) ; oFlags
			(return 0)
		else
			(return (super testHotspotVerb: &rest))
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(53 ; ioSappyDawburr
				(voSap4 init:)
				((ScriptID 64017 0) set: 187 188) ; oFlags
				(poWorm4 sappify:)
				(if
					(and
						((ScriptID 64017 0) test: 184) ; oFlags
						((ScriptID 64017 0) test: 185) ; oFlags
						((ScriptID 64017 0) test: 186) ; oFlags
						((ScriptID 64017 0) test: 187) ; oFlags
					)
					(gEgo put: ((ScriptID 64001 0) get: 62)) ; oInvHandler, ioSappyDawburr
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(class Sap of View
	(properties
		view 50404
		loop 6
	)
)

(instance voSap1 of Sap
	(properties
		x 185
		y 280
	)
)

(instance voSap2 of Sap
	(properties
		x 117
		y 97
	)
)

(instance voSap3 of Sap
	(properties
		x 405
		y 86
		loop 7
	)
)

(instance voSap4 of Sap
	(properties
		x 507
		y 204
		loop 7
	)
)

(instance oStuckSound of TPSound
	(properties)
)

(instance oMunchSound of TPSound
	(properties)
)

(class Worm of Prop
	(properties
		priority 500
		fixPriority 1
		view 50404
		bSapped 0
		nEatLoop 0
		nHideLoop 2
		nReturnLoop 4
		nStuckLoop 8
		nMode 3
		nMyFlag 0
	)

	(method (init)
		(if ((ScriptID 64017 0) test: nMyFlag) ; oFlags
			(return)
		)
		(super init: &rest)
		(|= signal $1000)
		(if bSapped
			(self stick:)
		else
			(self eat:)
		)
	)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (doit &tmp localX localY)
		(super doit: &rest)
		(= localX (- gMouseX (plane left:)))
		(= localY (- gMouseY (plane top:)))
		(cond
			(
				(and
					(< (- nsLeft 50) localX (+ nsRight 50))
					(< (- nsTop 50) localY (+ nsBottom 50))
				)
				(if (and (!= nMode 0) (!= nMode 2))
					(= nMode 0)
					(CheckSounds)
					(self setScript: (soWormHide new:))
				)
			)
			((== nMode 0)
				(self setScript: (soWormComeBack new:))
			)
		)
	)

	(method (sappify)
		(= bSapped 1)
		(if (== nMode 3)
			(self stick:)
		)
	)

	(method (eat)
		(= loop nEatLoop)
		(= cycleSpeed 6)
		(self setCycle: Fwd)
		(= nMode 3)
		(CheckSounds)
	)

	(method (stick)
		(self addHotspotVerb: 1)
		(= loop nStuckLoop)
		(= cycleSpeed 6)
		(self setCycle: Osc)
		(= nMode 2)
		(CheckSounds)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(if bSapped
					(gEgo get: ((ScriptID 64001 0) get: 44)) ; oInvHandler, ioSilkWorms
					((ScriptID 64017 0) set: nMyFlag) ; oFlags
					(= nMode 4)
					(CheckSounds)
					(if (not ((ScriptID 64017 0) test: 194)) ; oFlags
						((ScriptID 64017 0) set: 194) ; oFlags
						(gMessager say: 6 1 2 0) ; "Gotcha."
					)
					(if
						(and
							((ScriptID 64017 0) test: 190) ; oFlags
							((ScriptID 64017 0) test: 191) ; oFlags
							((ScriptID 64017 0) test: 192) ; oFlags
							((ScriptID 64017 0) test: 193) ; oFlags
						)
						((ScriptID 64017 0) set: 160 183) ; oFlags
						(foWormPlants dispose:)
					)
					(self dispose:)
				else
					(gMessager say: 6 1 0 0) ; "Hey! Come back here!!"
				)
			)
		)
	)
)

(instance soWormHide of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client nMode: 0)
				(if
					(and
						(or (== (client loop:) 4) (== (client loop:) 5))
						(<= (client cel:) 21)
					)
					(client setCycle: 0)
					(client hide:)
					(return)
				)
				(client loop: (client nHideLoop:))
				(client cel: 0)
				(client cycleSpeed: 2)
				(client setCycle: End)
				(self cue:)
			)
			(1
				(= cycles 2)
			)
			(2
				(if (== (client cel:) (client lastCel:))
					(self cue:)
				else
					(self changeState: (- state 1))
				)
			)
			(3
				(client hide:)
			)
		)
	)
)

(instance soWormComeBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client nMode: 1)
				(client loop: (client nReturnLoop:))
				(client cel: 0)
				(client cycleSpeed: 6)
				(client show:)
				(client doit:)
				(client setCycle: End)
				(self cue:)
			)
			(1
				(= cycles 2)
			)
			(2
				(if (== (client cel:) (client lastCel:))
					(self cue:)
				else
					(self changeState: (- state 1))
				)
			)
			(3
				(if (client bSapped:)
					(client stick:)
				else
					(client eat:)
				)
			)
		)
	)
)

(instance poWorm1 of Worm
	(properties
		x 197
		y 285
		nMyFlag 190
	)

	(method (init)
		(if ((ScriptID 64017 0) test: 184) ; oFlags
			(= bSapped 1)
			(voSap1 init:)
		)
		(super init: &rest)
	)
)

(instance poWorm2 of Worm
	(properties
		x 129
		y 104
		nMyFlag 191
	)

	(method (init)
		(if ((ScriptID 64017 0) test: 185) ; oFlags
			(= bSapped 1)
			(voSap2 init:)
		)
		(super init: &rest)
	)
)

(instance poWorm3 of Worm
	(properties
		x 393
		y 104
		nEatLoop 1
		nHideLoop 3
		nReturnLoop 5
		nStuckLoop 9
		nMyFlag 192
	)

	(method (init)
		(if ((ScriptID 64017 0) test: 186) ; oFlags
			(= bSapped 1)
			(voSap3 init:)
		)
		(super init: &rest)
	)
)

(instance poWorm4 of Worm
	(properties
		x 495
		y 221
		nEatLoop 1
		nHideLoop 3
		nReturnLoop 5
		nStuckLoop 9
		nMyFlag 193
	)

	(method (init)
		(if ((ScriptID 64017 0) test: 187) ; oFlags
			(= bSapped 1)
			(voSap4 init:)
		)
		(super init: &rest)
	)
)

(instance oWormCUPlane of Plane
	(properties
		picture 53300
	)

	(method (init)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
		(gGame handsOff:)
		((ScriptID 64017 0) set: 189) ; oFlags
		(goMusic1 setMusic: 50412)
		(foWormCUExit init:)
		(foLeaf1 init:)
		(poWorm1 init:)
		(foLeaf2 init:)
		(poWorm2 init:)
		(foLeaf3 init:)
		(poWorm3 init:)
		(foLeaf4 init:)
		(poWorm4 init:)
		(gGame handsOn:)
	)

	(method (dispose)
		(goMusic1 setMusic: 50400)
		(super dispose: &rest)
	)
)

(instance roInPlanter of TPRoom
	(properties
		picture 50400
	)

	(method (init)
		(super init: &rest)
		(goMusic1 setMusic: 50400)
		(if (and (!= gPrevRoomNum 50300) (!= gPrevRoomNum 50500)) ; roAirDuctEnd, roJailCell
			((ScriptID 64017 0) set: 181) ; oFlags
			((ScriptID 64017 0) set: 182) ; oFlags
		)
		(if (== gPrevRoomNum 50300) ; roAirDuctEnd
			((ScriptID 64017 0) clear: 181) ; oFlags
			((ScriptID 64017 0) clear: 182) ; oFlags
		)
		(if (== gPrevRoomNum 50500) ; roJailCell
			((ScriptID 64017 0) set: 181) ; oFlags
			((ScriptID 64017 0) clear: 182) ; oFlags
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 4 257 4 310 465 311 561 276 547 238 445 221 292 241
					yourself:
				)
		)
		(poMrsPlant init:)
		(foBuilding init:)
		(if (not ((ScriptID 64017 0) test: 177)) ; oFlags
			(foDawburrs init:)
		)
		(if (not ((ScriptID 64017 0) test: 160)) ; oFlags
			(foWormPlants init:)
		)
		(foSlopeExit init:)
		(if (not ((ScriptID 64017 0) test: 181)) ; oFlags
			((ScriptID 64017 0) set: 181) ; oFlags
			(gCurRoom setScript: soEnterFirstTime)
			(return)
		)
		(if (not ((ScriptID 64017 0) test: 182)) ; oFlags
			((ScriptID 64017 0) set: 182) ; oFlags
			(gCurRoom setScript: soEnterSecondTime)
			(return)
		)
		(gEgo init: normalize: setScaler: Scaler 100 75 313 249)
		(gGame handsOn:)
		(switch gPrevRoomNum
			(50600 ; roSlipperySlope
				(gEgo setScript: soComeIn)
			)
			(else
				(gEgo posn: 316 300)
			)
		)
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64001 0) get: 62)) ; oInvHandler, ioSappyDawburr
	)
)

