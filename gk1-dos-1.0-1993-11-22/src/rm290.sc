;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 290)
(include sci.sh)
(use Main)
(use n013)
(use sHRoom8)
(use Talker)
(use Osc)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Cursor)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm290 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7 = 13
	local8
	local9
	local10
	local11
	local12
	local13
)

(instance exitCursor of Cursor
	(properties
		view 961
	)
)

(instance rm290 of Room
	(properties
		noun 11
		picture 290
		style 14
		exitStyle 13
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(if (not local3)
					(gMessager say: noun theVerb 21 0) ; "Please, remain seated within the protective circle. There are spiritual currents in this room that I can't always control."
				else
					(gMessager say: 4 theVerb 1 0) ; "It would be rude to leave now!"
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 319 145 319 116 262 110 262 105 289 105 289 94 226 97 225 107 244 108 215 109 159 109 139 116 117 115 108 115 83 118 0 118 0 148
					yourself:
				)
		)
		(= local9 gNarrator)
		(= gNarrator moonNarrator)
		(gGame handsOn:)
		(gFeatures
			add:
				vase
				africaMask
				hangLamp
				nikNak
				crystalBall
				ballTable
				chair
				throne
				lamp
				candle
				crystals
				madonna
				leftDrapes
				rightDrapes
				bottles
				cage
			eachElementDo: #init
		)
		(gTheDoits add: streetExit)
		(snake init: setCycle: Fwd)
		(if (not (gEgo has: 37)) ; snakeSkin
			(theSnakeSkin init:)
		)
		(if (== gPrevRoomNum 50) ; interrogation
			(gWalkHandler addToFront: streetExit gCurRoom)
			(= local2 1)
			(gEgo
				view: 291
				posn: 102 116
				setLoop: 0
				setCel: 7
				ignoreActors: 1
				init:
			)
			(magentia view: 2911 setLoop: 1 setCel: 0 ignoreActors: 1 init:)
			(if (IsFlag 210)
				(ClearFlag 210)
				(magentia setScript: sMagSnakeDance)
			)
		else
			(gGkMusic1
				number: 290
				loop: -1
				play:
				setVol: 0
				fade: (gGkMusic1 musicVolume:) 5 5 0
			)
			(magentia posn: 200 114 view: 295 setLoop: 0 setCycle: Walk init:)
			(gEgo normalize: posn: 285 102 ignoreHorizon: init:)
			(self setScript: sGabeEnters)
		)
		(super init:)
	)

	(method (dispose)
		(= gNarrator local9)
		(ClearFlag 210)
		(gWalkHandler delete: gCurRoom streetExit)
		(gTheDoits delete: streetExit)
		(if (!= gNewRoomNum 50) ; interrogation
			(gGkMusic1 fade:)
		)
		(super dispose:)
	)
)

(instance sWriteDownStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local11 1)
				(gMessager say: 8 register 20 1 self)
				(magentia view: 292 setCel: 0 setLoop: 1 setCycle: End)
			)
			(1
				(gMessager sayRange: 8 register 20 2 9 self)
			)
			(2
				(magentia setCel: 6 setLoop: 0 setCycle: CT 3 -1 self)
			)
			(3
				(gEgo view: 291 loop: 4 cel: 12 setCycle: CT 5 -1 self)
			)
			(4
				(gEgo setCycle: Beg self)
				(magentia setCycle: Beg self)
			)
			(5 0)
			(6
				(gMessager say: 8 register 20 10 self)
				(gEgo setLoop: 2 setCycle: RandCycle)
				(gGkSound1 number: 15 setLoop: -1 play:)
			)
			(7
				(= local11 0)
				(gMessager say: 8 register 20 11 self)
			)
			(8
				(gGkSound1 stop:)
				(gEgo view: 291 setLoop: 0 setCel: 7 setCycle: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFullShow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 291
					setCel: 0
					setLoop: 4
					setSpeed: 14
					setCycle: CT 5 1 self
				)
			)
			(1
				(magentia view: 292 setCel: 0 setLoop: 0 setCycle: CT 2 1 self)
			)
			(2
				(magentia setCycle: End self)
				(gEgo setCycle: End self)
			)
			(3 0)
			(4
				(= local11 1)
				(cond
					((== register 40)
						(SetFlag 248)
						(gEgo getPoints: -999 3)
						(client setScript: sWriteDownStuff self register)
					)
					((== register 48)
						(SetFlag 450)
						(gMessager say: 8 register 36 0 self) ; "Does this mean anything to you?"
					)
					((== register 24)
						(SetFlag 451)
						(gMessager say: 8 register 36 0 self) ; "Does this mean anything to you?"
					)
					((== register 16)
						(SetFlag 452)
						(gMessager say: 8 register 36 0 self) ; "Does this mean anything to you?"
					)
					((== register 23)
						(SetFlag 453)
						(gMessager say: 8 register 36 0 self) ; "Does this mean anything to you?"
					)
				)
			)
			(5
				(= local11 0)
				(magentia view: 292 setCel: 6 setLoop: 0 setCycle: CT 3 -1 self)
			)
			(6
				(gEgo view: 291 loop: 4 cel: 12 setCycle: CT 5 -1 self)
			)
			(7
				(gEgo setCycle: Beg self)
				(magentia setCycle: Beg self)
			)
			(8 0)
			(9
				(gEgo setLoop: 0 setCel: 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sHalfShow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 291
					setCel: 0
					setLoop: 4
					setSpeed: 14
					setCycle: CT 5 1 self
				)
			)
			(1
				(= local12 1)
				(cond
					((and (== register 17) (IsFlag 208))
						(gMessager say: 8 register 11 1 self)
					)
					((== register 17)
						(gMessager say: 8 register 10 1 self) ; "Could you look at this, and tell me if you recognize anything about it?"
					)
					((== register 40)
						(gMessager say: 8 register 19 1 self) ; "Can you tell me anything more about this code?"
					)
					((OneOf register 5 46 42 33)
						(gMessager say: 8 register 0 1 self)
					)
					(else
						(gMessager say: 8 0 0 1 self) ; "Does this mean anything to you?"
					)
				)
			)
			(2
				(magentia view: 2911 setCel: 0 setLoop: 2 setCycle: End self)
			)
			(3
				(= ticks 30)
			)
			(4
				(magentia setCycle: Beg self)
			)
			(5
				(cond
					((and (== register 17) (IsFlag 208))
						(gMessager say: 8 register 11 2 self)
					)
					((== register 17)
						(SetFlag 208)
						(gMessager say: 8 register 10 2 self) ; "(SCARED)That's from those Voodoo Murders, isn't it? That has nothing to do with me!"
					)
					((== register 40)
						(gMessager say: 8 register 19 2 self) ; "I gave you my translation. If it doesn't make sense, it's not my fault."
					)
					((OneOf register 5 46 42 33)
						(gMessager say: 8 register 0 2 self)
					)
					(else
						(gMessager say: 8 0 0 2 self) ; "I can be of no help to you, Seeker."
					)
				)
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(gEgo setLoop: 0 setCel: 7 setSpeed: 6)
				(= local12 0)
				(= ticks 4)
			)
			(8
				(cond
					((OneOf register 5 46)
						(gMessager sayRange: 8 register 0 3 5 self)
					)
					((== register 42)
						(gMessager sayRange: 8 register 0 3 6 self) ; "Have you ever seen anything like this before?"
					)
					((== register 33)
						(gMessager say: 8 register 0 3 self) ; "Okey dokey."
					)
					(else
						(= cycles 1)
					)
				)
			)
			(9
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGabeSits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local2 1)
				(gEgo setMotion: PolyPath 102 116 self)
			)
			(1
				(gEgo view: 291 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(2
				(gWalkHandler addToFront: streetExit gCurRoom)
				(if (and (!= (magentia script:) sStopDance) (not local3))
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sGabeAsks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 212)
					(gMessager say: 8 10 9 0 self) ; "Could I ask you a few more questions?"
				else
					(SetFlag 212)
					(gMessager say: 8 10 8 0 self) ; "Could I ask you a few questions?"
				)
			)
			(1
				(= global178 27)
				(gCurRoom newRoom: 50) ; interrogation
				(self dispose:)
			)
		)
	)
)

(instance sGabeStands of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 900)
				(= local4 gMouseX)
				(= local5 (- gMouseY 10))
				(= gNarrator local9)
				(gGame handsOff:)
				(gEgo view: 291 setLoop: 3 setCel: 0 setCycle: End self)
			)
			(1
				(= local2 0)
				(gEgo posn: 117 116 normalize: 4)
				(= cycles 1)
			)
			(2
				(if register
					(gEgo setMotion: PolyPath local4 local5)
				)
				(gWalkHandler delete: gCurRoom)
				(if (!= (gCurRoom script:) sGabeExits)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sGabeGetsScale of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local2
					(gEgo setCel: 0 setLoop: 1 view: 294 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(1
				(if local2
					(gEgo cel: 0 normalize: 4 posn: 117 116)
				)
				(= cycles 1)
			)
			(2
				(gEgo setMotion: MoveTo 199 112 self)
			)
			(3
				(gEgo view: 294 setCel: 0 setLoop: 2 setCycle: End self)
			)
			(4
				(theSnakeSkin dispose:)
				(gMessager say: 13 12 25) ; "Gabriel grabs the shed snake skin while Magentia is otherwise occupied."
				(gEgo setLoop: 3 setCel: 0 setCycle: End self)
			)
			(5
				(gEgo
					posn: 188 112
					normalize: 1
					setMotion: PolyPath 102 116 self
				)
			)
			(6
				(= local2 1)
				(gWalkHandler addToFront: streetExit gCurRoom)
				(gEgo view: 291 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(7
				(gEgo view: 294 setLoop: 0 setCel: 3)
				(= cycles 1)
			)
			(8
				(magentia setScript: sStopDance)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sMagSnakeDance of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(RemapColors 2 254 70) ; ByPercent
				(= ticks 120)
			)
			(1
				(= temp0
					(if (IsFlag 169)
						27
					else
						(gEgo getPoints: 169 1)
						26
					)
				)
				(gMessager say: 15 0 temp0 0 self)
			)
			(2
				(= local3 1)
				(magentia view: 2911 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(3
				(magentia
					view: 295
					setLoop: 0
					setCycle: Walk
					setMotion: PolyPath 207 121 self
				)
			)
			(4
				(magentia view: 293 setLoop: 0 setCel: 0 setCycle: End self)
				(gGkSound2 number: 291 loop: 1 play:)
			)
			(5
				(= ticks 10)
			)
			(6
				(gGkSound2 number: 292 loop: 1 play:)
				(snake dispose:)
				(magentia setLoop: 1 setCel: 0 setCycle: End self)
			)
			(7
				(magentia view: 2931 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(8
				(magentia setLoop: 1 setCel: 0 setCycle: End self)
			)
			(9
				(magentia setLoop: 2 setCel: 0 setCycle: End self)
			)
			(10
				(magentia view: 2932 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(11
				(magentia posn: 183 125 setCel: 0 setCycle: End self)
			)
			(12
				(gEgo
					setSpeed: 24
					view: 294
					setLoop: 0
					setCel: 0
					setCycle: End
				)
				(magentia posn: 159 130 setCel: 0 setCycle: End self)
			)
			(13
				(gEgo setSpeed: (gGame currentSpeed:))
				(magentia posn: 135 130 setCel: 0 setCycle: End self)
			)
			(14
				(magentia setLoop: 2 setCel: 0 setCycle: End self)
			)
			(15
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(= seconds 15)
				(magentia setLoop: 3 setCel: 0 setCycle: Fwd)
			)
			(16
				(client setScript: sStopDance)
				(self dispose:)
			)
		)
	)
)

(instance sGabeEntersFirst of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register 28)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 253 113 self)
			)
			(2
				(Face gEgo magentia)
				(gMessager sayRange: 15 0 register 1 3 self)
			)
			(3
				(gMessager say: 15 0 register 4 self)
				(magentia
					ignoreActors: 1
					view: 295
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 172 113 self
				)
			)
			(4 0)
			(5
				(gEgo setMotion: MoveTo 220 120 self)
			)
			(6
				(gEgo setScript: sGabeSits self)
				(magentia
					ignoreActors: 0
					view: 2911
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
				(= local13 0)
			)
			(7 0)
			(8
				(gMessager say: 15 0 register 5 self)
			)
			(9
				(SetFlag 205)
				(self dispose:)
			)
		)
	)
)

(instance sGabeEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(magentia setMotion: MoveTo 227 114 self)
			)
			(1
				(= local13 1)
				(magentia setCel: 4)
				(if (not (IsFlag 205))
					(client setScript: sGabeEntersFirst)
				else
					(switch (Random 1 3)
						(1
							(= register 29)
						)
						(2
							(= register 31)
						)
						(3
							(= register 32)
						)
					)
				)
				(= cycles 1)
			)
			(2
				(gEgo setMotion: MoveTo 253 113 self)
			)
			(3
				(Face gEgo magentia)
				(gMessager sayRange: 15 0 register 1 2 self)
			)
			(4
				(magentia
					ignoreActors: 1
					view: 295
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 172 113 self
				)
			)
			(5
				(magentia
					ignoreActors: 0
					view: 2911
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
				(= local13 0)
			)
			(6
				(gEgo setMotion: MoveTo 220 120 self)
			)
			(7
				(gEgo setScript: sGabeSits self)
				(gMessager say: 15 0 register 3 self)
			)
			(8 0)
			(9
				(self dispose:)
			)
		)
	)
)

(instance sGabeExits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not register)
					(= register (Random 3 7))
				)
				(if local2
					(gEgo setScript: sGabeStands self)
				else
					(= cycles 1)
				)
			)
			(1
				(gMessager say: 4 13 register 1 self)
			)
			(2
				(gEgo setMotion: MoveTo 255 114 self)
			)
			(3
				(Face gEgo magentia)
				(magentia view: 2911 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(4
				(magentia
					view: 295
					setLoop: 0
					setCycle: Walk
					setMotion: PolyPath 207 121
				)
				(if (== register 2)
					(gMessager say: 4 13 register 2 self) ; "As you wish."
				else
					(gMessager sayRange: 4 13 register 2 3 self)
				)
			)
			(5
				(gEgo setMotion: PolyPath 285 102 self)
			)
			(6
				(gEgo ignoreActors: 1)
				(gGame handsOn:)
				(ClearFlag 212)
				(ClearFlag 211)
				(gCurRoom newRoom: 200)
				(self dispose:)
			)
		)
	)
)

(instance sStopDance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gCurRoom script:)
					(-- state)
				)
				(= cycles 1)
			)
			(1
				(gGame handsOff:)
				(if (not local2)
					(gEgo setScript: sGabeSits)
				)
				(magentia
					view: 2933
					setCel: 0
					setLoop: 0
					setCycle: Fwd
					setMotion: MoveTo 207 121 self
				)
			)
			(2
				(magentia setCel: 0 setLoop: 1 setCycle: End self)
			)
			(3
				(= ticks 160)
			)
			(4
				(magentia setCel: 0 setLoop: 2 setCycle: End self)
			)
			(5
				(if local2
					(gEgo
						setSpeed: 24
						view: 294
						setCel: 3
						setLoop: 0
						setCycle: Beg self
					)
				)
				(magentia view: 293 setLoop: 0 setCel: 9 setCycle: Beg self)
				(snake init:)
			)
			(6
				(magentia
					view: 295
					setCel: 0
					setLoop: 1
					setCycle: Walk
					setMotion: PolyPath 172 113 self
				)
			)
			(7
				(gMessager say: 15 0 33 0 self) ; "There. Truly inspiring, isn't it?"
				(magentia view: 2911 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(8 0)
			(9
				(= local3 0)
				(gEgo setSpeed: (gGame currentSpeed:))
				(gGame handsOn:)
				(gTheIconBar enable: 0)
				(RemapColors 0) ; Off
				(self dispose:)
			)
		)
	)
)

(instance magentia of Actor
	(properties
		noun 8
		x 172
		y 113
		view 2911
		loop 1
		cycleSpeed 16
		xStep 5
		moveSpeed 16
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(if (not local3)
				(cond
					(
						(or
							(and (== theVerb 48) (IsFlag 450)) ; policeVeve_
							(and (== theVerb 24) (IsFlag 451)) ; veveCopy
							(and (== theVerb 16) (IsFlag 452)) ; reconVeve_
							(and (== theVerb 23) (IsFlag 453)) ; sLakePatter
						)
						(gMessager say: noun theVerb 37 0)
					)
					((OneOf theVerb 32 22 20 21 31 26 51) ; hundred, fortScale_, lakeScale, snakeSkin_, crocMask, musScale, twoScales
						(gMessager say: noun theVerb 0 0)
					)
					((and (== theVerb 40) (IsFlag 248)) ; VoodooCode1
						(gCurRoom setScript: sHalfShow 0 theVerb)
					)
					((OneOf theVerb 5 46 42 33 17) ; giftCert, oil, braceRep_, luckyDog_, murderPhoto
						(gCurRoom setScript: sHalfShow 0 theVerb)
					)
					((OneOf theVerb 23 48 24 16 40) ; sLakePatter, policeVeve_, veveCopy, reconVeve_, VoodooCode1
						(gCurRoom setScript: sFullShow 0 theVerb)
					)
					(
						(OneOf
							theVerb
							116 ; BoarMask
							104 ; chamPot
							31 ; crocMask
							129 ; lit_flash
							115 ; lotsCash
							33 ; luckyDog_
							4 ; magGlass
							121 ; BoarGuise
							120 ; WolfGuise
							64 ; collar_
							122 ; BoarRobe or WolfRobe
							73 ; disguise
							74 ; shirt
							114 ; WolfMask
						)
						(gMessager say: noun 0 35 0) ; MISSING MESSAGE
					)
					(else
						(gCurRoom setScript: sHalfShow 0 theVerb)
					)
				)
			else
				(gMessager say: noun 0 1) ; "She's a bit busy at the moment."
			)
			(return 1)
		else
			(switch theVerb
				(7 ; Look
					(if local3
						(gMessager say: noun theVerb 1) ; "Magentia's movements are as liquid and sinuous as those of the snake."
					else
						(gMessager say: noun theVerb 2) ; "Magentia Moonbeam is wrapped in gauze and silks. She looks vaguely mysterious and mysteriously vague."
					)
				)
				(10 ; Ask
					(if (not local3)
						(gCurRoom setScript: sGabeAsks)
					else
						(gMessager say: noun theVerb 1) ; "She's a bit busy at the moment."
					)
				)
				(11 ; Talk
					(if (not local3)
						(if (not (IsFlag 211))
							(SetFlag 211)
							(gMessager say: noun theVerb 12) ; "Dr. John tells me you're a Voodoo practitioner of some kind."
						else
							(= local7
								(if
									(or
										local6
										(and (== (++ local7) 19) (= local6 1))
									)
									(Random 13 18)
								else
									local7
								)
							)
							(gMessager say: noun theVerb local7)
						)
					else
						(gMessager say: noun theVerb 1) ; "She's a bit busy at the moment."
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance snake of Prop
	(properties
		x 209
		y 78
		view 290
		loop 4
		cycleSpeed 24
	)

	(method (doVerb)
		(cage doVerb: &rest)
	)
)

(instance theSnakeSkin of View
	(properties
		x 209
		y 85
		view 290
		loop 3
	)

	(method (doVerb)
		(cage doVerb: &rest)
	)
)

(instance streetExit of Feature
	(properties
		noun 4
		nsLeft 233
		nsTop 37
		nsRight 282
		nsBottom 109
		x 257
		y 73
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(if (not local3)
					(if (IsFlag 169)
						(gCurRoom setScript: sGabeExits)
					else
						(gCurRoom setScript: sGabeExits 0 2)
					)
				else
					(gMessager say: noun theVerb 1) ; "It would be rude to leave now!"
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (self onMe: gMouseX gMouseY))
		(cond
			((and local8 (not temp0))
				(ClearFlag 220)
				(if (gGame isHandsOn:)
					(gGame setCursor: ((gTheIconBar curIcon:) getCursor:) 1)
				else
					(gGame setCursor: gWaitCursor 1)
				)
				(= local8 0)
			)
			(
				(and
					temp0
					(not local8)
					(== gTheCursor ((gTheIconBar at: 0) cursorView:))
				)
				(gGame setCursor: exitCursor 1)
				(SetFlag 220)
				(= local8 1)
			)
		)
	)
)

(instance cage of Feature
	(properties
		noun 13
		sightAngle 355
		x 165
		y 136
	)

	(method (init)
		(self
			createPoly: 201 77 201 57 208 51 208 49 212 49 212 51 219 57 219 79 201 79
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(cond
					((and (gEgo has: 37) (not local3)) ; snakeSkin
						(gMessager say: noun theVerb 22) ; "A large, sluggish snake rests on the floor of the fancy bird cage."
					)
					((and (gEgo has: 37) local3) ; snakeSkin
						(gMessager say: noun theVerb 24) ; "The cage is currently empty."
					)
					((and (not (gEgo has: 37)) local3) ; snakeSkin
						(gMessager say: noun theVerb 25) ; "Except for a shed snake skin, the cage is currently empty."
					)
					((and (not (gEgo has: 37)) (not local3)) ; snakeSkin
						(gMessager say: noun theVerb 23) ; "A large, sluggish snake rests on the floor of the fancy bird cage."
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(6 ; Open
				(cond
					((not local3)
						(gMessager say: noun theVerb 2) ; "If Gabriel opened the cage now, he'd have to get close to that snake."
					)
					(local3
						(gMessager say: noun theVerb 1) ; "The cage is already open, and Gabriel doesn't feel it's his place to close it."
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(12 ; Pickup
				(cond
					((and (gEgo has: 37) (not local3)) ; snakeSkin
						(gMessager say: noun theVerb 23) ; "Magentia's snake looks a little sickly, but Gabriel would still rather NOT stick his hand in the cage."
					)
					((and (gEgo has: 37) local3) ; snakeSkin
						(gMessager say: noun theVerb 24) ; "Gabriel has no reason to stick his hand in that cage again."
					)
					((and (not (gEgo has: 37)) local3) ; snakeSkin
						(gEgo get: 37) ; snakeSkin
						(gEgo getPoints: -999 2)
						(gCurRoom setScript: sGabeGetsScale)
					)
					((and (not (gEgo has: 37)) (not local3)) ; snakeSkin
						(gMessager say: noun theVerb 23) ; "Magentia's snake looks a little sickly, but Gabriel would still rather NOT stick his hand in the cage."
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vase of Feature
	(properties
		x 153
		y 106
	)

	(method (init)
		(self
			createPoly: 154 64 159 64 157 68 156 76 161 76 160 78 155 80 155 100 151 100 151 81 143 78 149 76 149 70 146 64
		)
		(super init:)
	)
)

(instance africaMask of Feature
	(properties
		noun 16
		x 102
		y 100
	)

	(method (init)
		(self
			createPoly: 90 58 80 52 84 33 103 16 120 26 124 38 110 52 107 60 100 71
		)
		(super init:)
	)
)

(instance hangLamp of Feature
	(properties
		noun 9
		x 138
		y 111
	)

	(method (init)
		(self
			createPoly: 141 14 140 45 151 53 151 59 126 59 126 53 137 45 138 14
		)
		(super init:)
	)
)

(instance nikNak of Feature
	(properties
		noun 1
		x 102
		y 111
	)

	(method (init)
		(self
			createPoly: 97 81 87 72 77 81 58 80 78 55 80 66 84 58 89 71 96 75 104 69 112 69 117 63 124 69 137 73 143 72 143 79
		)
		(super init:)
	)
)

(instance crystalBall of Feature
	(properties
		noun 3
		x 134
		y 114
	)

	(method (init)
		(self createPoly: 128 81 132 78 138 82 137 87 138 89 129 89)
		(super init:)
	)
)

(instance ballTable of Feature
	(properties
		noun 12
		x 134
		y 113
	)

	(method (init)
		(self
			createPoly: 124 107 128 105 125 101 116 106 116 90 124 87 146 87 150 89 151 98 143 109 132 106 125 109
		)
		(super init:)
	)
)

(instance chair of Feature
	(properties
		noun 2
		x 93
		y 110
	)

	(method (init)
		(self
			createPoly: 104 112 104 100 105 94 109 93 108 85 95 83 96 77 95 70 86 66 80 68 76 75 76 81 78 92 81 94 79 97 78 110 81 111 83 101 83 112 88 113 88 103 90 103 92 109 95 109 86 111 100 103 101 111
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(cond
					((not local2)
						(gCurRoom setScript: sGabeSits)
					)
					(local3
						(gMessager say: noun theVerb 1) ; "Gabriel doesn't want to look bored during the snake dance."
					)
					(else
						(gMessager say: noun theVerb 21) ; "Gabriel is already seated."
					)
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance throne of Feature
	(properties
		noun 10
		x 177
		y 110
	)

	(method (init)
		(self
			createPoly: 157 104 155 88 155 84 166 80 161 65 163 58 172 57 179 53 187 55 198 58 194 81 197 103 192 105
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(cond
					((not local3)
						(gMessager say: noun theVerb 2) ; "That chair is occupied."
					)
					(local3
						(gMessager say: noun theVerb 1) ; "Gabriel doesn't want Magentia's chair."
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lamp of Feature
	(properties
		noun 7
		x 305
		y 250
	)

	(method (init)
		(self
			createPoly: 319 99 303 100 291 90 287 85 291 83 290 81 288 73 285 68 283 80 280 68 276 79 273 71 270 78 268 62 275 50 288 39 290 32 294 33 294 23 308 23 309 32 311 32 319 44 319 70 315 71 312 81 319 91
		)
		(super init:)
	)
)

(instance candle of Feature
	(properties
		x 260
		y 250
	)

	(method (init)
		(self
			createPoly: 274 135 240 136 240 120 238 118 251 109 255 111 261 106 270 106 274 115
		)
		(super init:)
	)
)

(instance crystals of Feature
	(properties
		noun 6
		x 235
		y 250
	)

	(method (init)
		(self
			createPoly: 214 136 217 133 216 130 218 127 219 114 224 117 227 109 232 115 234 101 241 97 246 103 242 113 238 108 239 135
		)
		(super init:)
	)
)

(instance madonna of Feature
	(properties
		x 295
		y 250
	)

	(method (init)
		(self
			createPoly: 273 136 276 114 271 105 273 99 278 98 272 92 276 85 286 85 291 92 306 105 315 126 314 135
		)
		(super init:)
	)
)

(instance leftDrapes of Feature
	(properties
		x 27
		y 189
	)

	(method (init)
		(self createPoly: 98 14 99 20 47 89 0 117 0 14)
		(super init:)
	)
)

(instance rightDrapes of Feature
	(properties
		x 257
		y 112
	)

	(method (init)
		(self
			createPoly: 270 67 252 34 233 69 241 96 235 103 225 102 222 62 224 46 218 35 218 18 288 18 283 79 283 83 278 84 273 91 277 26 272 102 269 102
		)
		(super init:)
	)
)

(instance bottles of Feature
	(properties
		noun 5
		x 35
		y 250
	)

	(method (init)
		(self
			createPoly: 8 136 0 127 0 117 18 102 18 70 16 67 25 64 34 69 31 72 31 101 44 111 54 104 51 100 60 97 66 100 68 106 77 114 76 135
		)
		(super init:)
	)
)

(instance moonNarrator of Narrator
	(properties
		modeless 2
	)

	(method (init)
		(self
			fore: global220
			back: global214
			font: gUserFont
			talkWidth: 314
			x: 0
			y: 157
		)
		(super init: &rest)
	)

	(method (display param1 &tmp temp0)
		(= fore
			(switch global180
				(1 54)
				(27 10)
				(99 7)
				(else global220)
			)
		)
		(switch global180
			(1
				(cond
					(local13
						(if (or (== (gEgo cel:) 4) (== (gEgo cel:) 5))
							(= temp0 (+ (gEgo view:) 1000))
						else
							(if (== (gEgo view:) 900)
								(= temp0
									(+ (gEgo view:) 1010 (gEgo cel:))
								)
							else
								(= temp0
									(+ (gEgo view:) 1039 (gEgo cel:))
								)
							)
							(switch (Random 0 2)
								(0 1)
								(1
									(+= temp0 10)
								)
								(2
									(= temp0 (+ (gEgo view:) 1000))
								)
							)
						)
						(= local0 (gEgo cel:))
						(= local1 (gEgo cycleSpeed:))
						(gEgo
							talking: 1
							oldView: (gEgo view:)
							oldLoop: (gEgo loop:)
							oldCel: (gEgo cel:)
							oldSig: (gEgo signal:)
							setCel: 0
							view: temp0
							setLoop: local0
							ignoreActors:
							cycleSpeed: 14
						)
						(if (or (< 1919 temp0 1930) (< 1949 temp0 1960))
							(gEgo setCycle: ForRepeat)
						else
							(gEgo setCycle: Fwd)
						)
					)
					((not local12)
						(gEgo
							talking: 1
							view: 291
							loop: 5
							cel: 0
							setSpeed: 12
							setCycle: Osc 2
						)
					)
				)
			)
			(27
				(cond
					(local13
						(magHead init: setCycle: Fwd)
					)
					(local11
						(magentia
							setCel: 0
							setLoop: 2
							cycleSpeed: 12
							setCycle: Fwd
						)
					)
					(local3
						(= global180 -1)
					)
					(local10
						(= local10 0)
						(magentia view: 297 loop: 2 cel: 0 setCycle: Osc 3)
					)
					(else
						(= local10 1)
						(magentia
							view: 2911
							loop: 3
							cel: 0
							setSpeed: 16
							setCycle: Osc 3
						)
					)
				)
			)
		)
		(if (& gMsgType $0001)
			(super display: param1)
		)
	)

	(method (dispose)
		(switch global180
			(1
				(if (gEgo talking:)
					(if local13
						(gEgo
							view: (gEgo oldView:)
							setCel: 0
							setLoop: (gEgo oldLoop:)
							setCel: (gEgo oldCel:)
							signal: (gEgo oldSig:)
							setCycle: StopWalk -1
							setSpeed: local1
							talking: 0
						)
					else
						(gEgo talking: 0 loop: 0 cel: 7 setCycle: 0)
					)
				)
			)
			(27
				(cond
					(local13
						(magHead dispose:)
					)
					(local11
						(magentia setCycle: Beg)
					)
					(else
						(magentia
							view: 2911
							loop: 0
							cel: 5
							setCycle: 0
							setSpeed: 8
						)
					)
				)
			)
		)
		(super dispose:)
	)
)

(instance magHead of Prop
	(properties
		view 2950
	)

	(method (init)
		(self
			setPri: (+ (magentia priority:) 1)
			posn: (- (magentia x:) 2) (- (magentia y:) 45)
		)
		(super init: &rest)
	)
)

