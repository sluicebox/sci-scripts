;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use TPSound)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use CueMe)
(use soFlashCyberSniff)
(use foEExit)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro500 0
)

(local
	local0
	local1
	local2
)

(instance ro500 of L7Room
	(properties
		picture 50000
	)

	(method (init)
		(gEgo
			init:
			normalize: 0
			setScale:
			scaleX: 90
			scaleY: 90
			posn: 34 192
			setPri: 100
		)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 12 199 89 199 169 189 183 184 163 180 134 190 95 193 79 188 8 188
					yourself:
				)
		)
		(gOMusic1 setMusic: 38000)
		((ScriptID 64017 0) set: 129) ; oFlags
		(foExit init:)
		(foPinSetter init:)
		(foPinHopper init:)
		(foPelletDispenser init:)
		(foHabiTrail init:)
		(poBeaver init:)
		(aoBowlingPin init: hide:)
		(poTankPins init: hide:)
		(poCartPins init: hide:)
		(poPinCart init: hide:)
		(voHopperDoorClosed init:)
		(voLightOff init:)
		(aoPinLift1 init:)
		(aoPinLift2 init:)
		(aoPinLift3 init:)
		(aoPinLift4 init:)
		(aoPinLift5 init:)
		(proc64896_15 6)
		(gGame handsOn:)
	)

	(method (dispose)
		(gOSound1 stop:)
		(super dispose: &rest)
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64037 0) get: 7)) ; oInvHandler, ioDeodorant
	)
)

(instance soBeaver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(poBeaver cel: 0 show: setCycle: CycleCueList 19 1 self 15)
			)
			(2
				(aoBowlingPin show: setMotion: MoveTo 98 268 self)
			)
			(3
				(oSndPinDrop playSound: 50003 self)
			)
			(4
				(voLightOff hide:)
				(oSndBuzz playSound: 50009 self)
			)
			(5
				(voLightOff show:)
				(poBeaver setCycle: End self 20 9999)
				(aoBowlingPin hide: posn: 152 436)
			)
			(6
				(gOSound1 playSound: 50008)
			)
			(7
				(poBeaver hide:)
				(self setScript: soCart self)
			)
			(8
				(self changeState: 1)
			)
		)
	)
)

(instance soCart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oSndCartRoll setAmbient: 50001 setRelVol: 100)
				(= ticks 15)
			)
			(1
				(oSndCartRoll setAmbient: 50001 setRelVol: 100)
				(poPinCart show: posn: -25 500)
				(poCartPins loop: 1 cel: 0 show: posn: -25 500)
				(= ticks 15)
			)
			(2
				(poPinCart posn: -20 495)
				(poCartPins posn: -20 495)
				(= ticks 15)
			)
			(3
				(poPinCart posn: -15 490)
				(poCartPins posn: -15 490)
				(= ticks 15)
			)
			(4
				(poPinCart posn: -10 485)
				(poCartPins posn: -10 485)
				(= ticks 15)
			)
			(5
				(poPinCart posn: 0 479)
				(poCartPins posn: 0 479)
				(= ticks 15)
			)
			(6
				(poPinCart setCycle: End self)
				(poCartPins setCycle: End self)
			)
			(7 0)
			(8
				(oSndCartRoll setRelVol: 100 playSound: 50004)
				(= ticks 90)
			)
			(9
				(poTankPins loop: 0 cel: 0 show: setCycle: End self)
				(poCartPins hide:)
			)
			(10
				(oSndCartRoll setAmbient: 50001)
				(poTankPins hide:)
				(poPinCart setCycle: Beg self)
			)
			(11
				(poPinCart posn: -5 485 hide:)
				(poCartPins posn: -5 485)
				(= ticks 15)
			)
			(12
				(poPinCart posn: -15 490)
				(poCartPins posn: -15 490)
				(= ticks 15)
			)
			(13
				(poPinCart posn: -25 500)
				(poCartPins posn: -25 500)
				(= ticks 15)
			)
			(14
				(poPinCart posn: -35 510)
				(poCartPins posn: -35 510)
				(= ticks 15)
			)
			(15
				(self dispose:)
			)
		)
	)
)

(instance soOpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo normalize: 3 1)
				(= local0 0)
				(gMessager say: 7 61 0 1 coEndTalk) ; "It IS unlocked. But what would you do inside a hopper full of bowling pins?"
				(poHopperDoor init: setCycle: End self)
				(oShortSound playSound: 50006)
				(voHopperDoorClosed hide:)
				(foOpening init:)
			)
			(1
				(if (not local0)
					(-= state 1)
				)
				(= cycles 1)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soSprayPins of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 64017 0) set: 128) ; oFlags
				(= local0 0)
				(gMessager say: 1 32 0 1 coEndTalk) ; "Good idea. You slyly open the hopper door, and spray the entire can of deodorant all over the bowling pins."
				(poALarry
					view: 50025
					loop: 0
					cel: 0
					posn: 32 207
					init:
					setCycle: End self
				)
				(gEgo hide:)
			)
			(1
				(poALarry
					view: 50025
					loop: 1
					cel: 0
					show:
					setCycle: End self 9 12
				)
			)
			(2
				(poALarry setPri: 4)
			)
			(3
				(oShortSound playSound: 50005)
				(poSmoke init: setCycle: End self 5 24 9999)
			)
			(4
				(poSmoke setPri: 5)
			)
			(5
				(poSmoke setPri: 100)
			)
			(6
				(proc64896_15 3 0)
				(poALarry
					view: 50035
					loop: 0
					cel: 0
					posn: 78 194
					show:
					setCycle: End self 8 9999
				)
				(poSmoke hide:)
			)
			(7
				(oShortSound stop:)
				(poALarry setPri: 60)
			)
			(8
				(poSmoke dispose:)
				(poHopperDoor setCycle: Beg self)
				(oShortSound playSound: 50007)
			)
			(9
				(if (not local0)
					(-= state 1)
				)
				(= cycles 1)
			)
			(10
				(voHopperDoorClosed show:)
				(poHopperDoor dispose:)
				(foOpening dispose:)
				(gEgo posn: 77 197 normalize: 5 1 show:)
				(poALarry dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soOpenAndSpray of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 64017 0) set: 128) ; oFlags
				(= local0 0)
				(gMessager say: 1 32 0 1 coEndTalk) ; "Good idea. You slyly open the hopper door, and spray the entire can of deodorant all over the bowling pins."
				(poHopperDoor init: setCycle: End self)
				(oShortSound playSound: 50006)
				(voHopperDoorClosed hide:)
				(foOpening init:)
			)
			(1
				(poALarry
					view: 50025
					loop: 0
					cel: 0
					posn: 32 207
					init:
					setCycle: End self
				)
				(gEgo hide:)
			)
			(2
				(poALarry
					view: 50025
					loop: 1
					cel: 0
					show:
					setCycle: End self 9 12
				)
			)
			(3
				(poALarry setPri: 4)
			)
			(4
				(oShortSound playSound: 50005)
				(poSmoke init: setCycle: End self 5 24 9999)
			)
			(5
				(poSmoke setPri: 5)
			)
			(6
				(poSmoke setPri: 100)
			)
			(7
				(proc64896_15 3)
				(poALarry
					view: 50035
					loop: 0
					cel: 0
					posn: 78 194
					show:
					setCycle: End self 8 9999
				)
				(poSmoke hide:)
			)
			(8
				(oShortSound stop:)
				(poALarry setPri: 60)
			)
			(9
				(poSmoke dispose:)
				(poHopperDoor setCycle: Beg self)
				(oShortSound playSound: 50007)
			)
			(10
				(if (not local0)
					(-= state 1)
				)
				(= cycles 1)
			)
			(11
				(voHopperDoorClosed show:)
				(poHopperDoor dispose:)
				(foOpening dispose:)
				(gEgo posn: 77 197 normalize: 5 1 show:)
				(poALarry dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soPinLift1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(aoPinLift1 setMotion: MoveTo (aoPinLift1 x:) 550 self)
			)
			(2
				(aoPinLift1 view: 50040 loop: 0 cel: 0)
				(= cycles 1)
			)
			(3
				(aoPinLift1 setMotion: MoveTo (aoPinLift1 x:) 479 self)
			)
			(4
				(aoPinLift1 view: 50045 loop: 0 cel: 0)
				(= ticks (Random 90 720))
			)
			(5
				(self changeState: 1)
			)
		)
	)
)

(instance soPinLift2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(aoPinLift2 setMotion: MoveTo (aoPinLift2 x:) 560 self)
			)
			(2
				(aoPinLift2 view: 50040 loop: 0 cel: 1)
				(= cycles 1)
			)
			(3
				(aoPinLift2 setMotion: MoveTo (aoPinLift2 x:) 479 self)
				(oSteamSpurt playSound: 50002)
			)
			(4
				(aoPinLift2 view: 50045 loop: 0 cel: 1)
				(= ticks (Random 90 720))
			)
			(5
				(self changeState: 1)
			)
		)
	)
)

(instance soPinLift3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(aoPinLift3 setMotion: MoveTo (aoPinLift3 x:) 560 self)
			)
			(2
				(aoPinLift3 view: 50040 loop: 0 cel: 2)
				(= cycles 1)
			)
			(3
				(aoPinLift3 setMotion: MoveTo (aoPinLift3 x:) 479 self)
			)
			(4
				(aoPinLift3 view: 50045 loop: 0 cel: 2)
				(= ticks (Random 90 720))
			)
			(5
				(self changeState: 1)
			)
		)
	)
)

(instance soPinLift4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(aoPinLift4 setMotion: MoveTo (aoPinLift4 x:) 570 self)
			)
			(2
				(aoPinLift4 view: 50040 loop: 0 cel: 3)
				(= cycles 1)
			)
			(3
				(aoPinLift4 setMotion: MoveTo (aoPinLift4 x:) 479 self)
			)
			(4
				(aoPinLift4 view: 50045 loop: 0 cel: 3)
				(= ticks (Random 90 720))
			)
			(5
				(self changeState: 1)
			)
		)
	)
)

(instance soPinLift5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(aoPinLift5 setMotion: MoveTo (aoPinLift5 x:) 580 self)
			)
			(2
				(aoPinLift5 view: 50040 loop: 0 cel: 4)
				(= cycles 1)
			)
			(3
				(aoPinLift5 setMotion: MoveTo (aoPinLift5 x:) 479 self)
			)
			(4
				(aoPinLift5 view: 50045 loop: 0 cel: 4)
				(= ticks (Random 90 720))
			)
			(5
				(self changeState: 1)
			)
		)
	)
)

(instance poALarry of Prop
	(properties
		x 27
		y 200
		priority 100
		fixPriority 1
		view 50025
	)
)

(instance aoBowlingPin of Actor
	(properties
		x 152
		y 436
		priority 260
		fixPriority 1
		view 50000
		loop 1
		yStep 5
	)
)

(instance poBeaver of Prop
	(properties
		x 150
		y 432
		priority 200
		fixPriority 1
		view 50000
	)

	(method (init)
		(super init: &rest)
		(self setScript: soBeaver)
	)
)

(instance poPinCart of Prop
	(properties
		x -35
		y 510
		priority 476
		fixPriority 1
		view 50010
		cycleSpeed 12
	)
)

(instance poCartPins of Prop
	(properties
		x -35
		y 510
		priority 478
		fixPriority 1
		view 50010
		loop 1
		cycleSpeed 12
	)
)

(instance poTankPins of Prop
	(properties
		x 377
		y 347
		priority 478
		fixPriority 1
		view 50015
	)
)

(instance poHopperDoor of Prop
	(properties
		approachX 60
		approachY 202
		x 29
		y 190
		priority 50
		fixPriority 1
		view 50025
		loop 2
	)
)

(instance poSmoke of Prop
	(properties
		x 2
		y 172
		priority 5
		fixPriority 1
		view 50030
	)
)

(instance aoPinLift1 of Actor
	(properties
		y 479
		priority 10
		fixPriority 1
		view 50040
		moveSpeed 6
	)

	(method (init)
		(super init: &rest)
		(self setScript: soPinLift1)
	)
)

(instance aoPinLift2 of Actor
	(properties
		y 479
		priority 10
		fixPriority 1
		view 50040
		cel 1
		moveSpeed 6
	)

	(method (init)
		(super init: &rest)
		(self setScript: soPinLift2)
	)
)

(instance aoPinLift3 of Actor
	(properties
		y 479
		priority 10
		fixPriority 1
		view 50040
		cel 2
		moveSpeed 6
	)

	(method (init)
		(super init: &rest)
		(self setScript: soPinLift3)
	)
)

(instance aoPinLift4 of Actor
	(properties
		y 479
		priority 10
		fixPriority 1
		view 50040
		cel 3
		moveSpeed 6
	)

	(method (init)
		(super init: &rest)
		(self setScript: soPinLift4)
	)
)

(instance aoPinLift5 of Actor
	(properties
		y 479
		priority 10
		fixPriority 1
		view 50040
		cel 4
		moveSpeed 6
	)

	(method (init)
		(super init: &rest)
		(self setScript: soPinLift5)
	)
)

(instance voHopperDoorClosed of View
	(properties
		noun 7
		approachX 60
		approachY 202
		y 79
		z -400
		priority 90
		fixPriority 1
		view 50040
		loop 1
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 61)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(61 ; Open
				(gCurRoom setScript: soOpenDoor)
			)
			(32 ; Deodorant Spray
				(if ((ScriptID 64017 0) test: 128) ; oFlags
					(gMessager say: 1 32 1 1) ; "Oh, once is more than enough."
				else
					(gCurRoom setScript: soOpenAndSpray)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance voLightOff of View
	(properties
		y 479
		priority 30
		fixPriority 1
		view 50040
		loop 2
	)
)

(instance foPinSetter of Feature
	(properties
		noun 2
		x 345
		y 215
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 549 389 588 383 600 373 628 229 565 148 582 85 562 48 537 42 519 47 498 89 502 95 519 146 502 167 477 209 441 161 457 110 440 77 424 73 409 73 399 77 386 112 400 165 389 180 368 210 337 170 349 124 335 97 319 93 302 95 286 129 302 170 274 213 249 178 260 140 248 112 233 108 217 113 203 142 214 182 192 214 171 185 182 149 167 126 158 125 145 129 144 187 130 227 150 237 156 263 144 271 132 266 130 258 118 255 63 266 73 312 101 313 123 311 127 294 133 318 157 328 188 320 195 293 204 330 224 338 246 341 270 328 277 297 288 344 313 352 329 353 362 344 373 303 384 358 420 371 447 366 470 354 482 302 499 377 528 388
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foPinHopper of Feature
	(properties
		noun 1
		approachX 60
		approachY 202
		x 68
		y 90
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 58 1 136 83 136 88 126 95 120 249 99 258 47 267 23 267 0 267 2 1
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(32 ; Deodorant Spray
				(if ((ScriptID 64017 0) test: 128) ; oFlags
					(gMessager say: 1 32 1 1) ; "Oh, once is more than enough."
				else
					(gCurRoom setScript: soOpenAndSpray)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foOpening of Feature
	(properties
		noun 7
		approachX 60
		approachY 202
		x 39
		y 92
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 10 163 40 167 66 167 68 130 67 100 38 95 10 95
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(32 ; Deodorant Spray
				(if ((ScriptID 64017 0) test: 128) ; oFlags
					(gMessager say: 1 32 1 1) ; "Oh, once is more than enough."
				else
					(self y: 1)
					(gCurRoom setScript: soSprayPins)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foPelletDispenser of Feature
	(properties
		noun 5
		x 114
		y 80
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 124 242 133 237 123 227 122 220 126 219 124 214 131 210 142 201 146 109 114 102 92 104 83 111 83 161 83 181 87 196 102 209 112 217 113 219 114 224
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foHabiTrail of Feature
	(properties
		noun 4
		x 164
		y 80
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 196 430 208 422 208 390 201 382 167 377 146 377 127 383 121 389 126 428 149 433 173 433
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foExit of ExitFeature
	(properties
		x 613
		y 187
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 25 266 14 207 15 69 60 17 2 17 2 266
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 13)) ; oMapCursor
	)

	(method (doVerb)
		((ScriptID 90 0) init:) ; oTravelScreen
	)
)

(instance coEndTalk of CueMe
	(properties)

	(method (cue)
		(= local0 1)
	)
)

(instance oShortSound of TPSound
	(properties)
)

(instance oSndCartRoll of TPSound
	(properties)
)

(instance oSndBuzz of TPSound
	(properties)
)

(instance oSndPinDrop of TPSound
	(properties)
)

(instance oSteamSpurt of TPSound
	(properties)
)

(instance coCatchCue of CueMe ; UNUSED
	(properties)

	(method (cue)
		(= local2 1)
	)
)

