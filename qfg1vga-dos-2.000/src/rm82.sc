;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 82)
(include sci.sh)
(use Main)
(use dartScript)
(use n105)
(use n106)
(use n814)
(use Print)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm82 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	[local15 44] = [0 0 130 126 0 1 130 123 0 2 130 119 0 3 130 116 0 4 131 112 0 5 130 109 0 6 130 106 0 7 131 103 0 1 129 100 0 2 129 98 99 99 99 99]
	[local59 44] = [0 2 129 98 0 1 129 100 0 7 131 103 0 6 130 106 0 5 130 109 0 4 131 112 0 3 130 116 0 2 130 119 0 1 130 123 0 0 130 126 99 99 99 99]
)

(procedure (localproc_0 param1)
	(if (IsFlag 272)
		(gMessager say: 9 0 6) ; "You'll have to climb down if you want to get water."
	else
		(gCurRoom setScript: getWater 0 param1)
	)
)

(instance rm82 of Rm
	(properties
		noun 9
		picture 82
		style 8
	)

	(method (init)
		(LoadMany rsVIEW 82 510 81 537 517)
		(LoadMany rsSCRIPT 991 103)
		(LoadMany rsSOUND 78 9 10 84 104 (if gNight 72 else 71))
		(if (IsFlag 241)
			(Load rsVIEW 531)
		)
		(super init: &rest)
		(self setFeatures: onWater cliff ground ledge onFall theCliff)
		(rocks init: approachVerbs: 4) ; Do
		(gLongSong stop:)
		(smlSplash1 init: setCycle: Fwd)
		(smlSplash2 init: setCycle: Fwd)
		(smlSplash3 init: setCycle: Fwd)
		(smlSplash4 init: setCycle: Fwd)
		(smlSplash5 init: setCycle: Fwd)
		(smlSplash6 init: setCycle: Fwd)
		(bottomSplash init: setCycle: Fwd)
		(splashSound number: (if gNight 72 else 71) init: play:)
		(rm82Sound number: 78 init:)
		(ladder setPri: 1 ignoreActors: init: stopUpd:)
		(NormalEgo)
		(if (== gPrevRoomNum 83)
			(cond
				((IsFlag 240)
					(hermitDoor setCel: 0 stopUpd:)
					(self setScript: deadlyTP)
				)
				((IsFlag 241)
					(gCurRoom
						addObstacle:
							(bottomPoly
								init: 214 149 214 146 190 151 162 153 79 156 52 171 0 160 0 0 319 0 319 189 83 189 113 178 124 167 198 152
								yourself:
							)
					)
					(hermitDoor setCel: 0 stopUpd:)
					(gEgo init: posn: 75 165 loop: 2 cel: 1 hide:)
					(self setScript: safeTP)
				)
				(else
					(hermitDoor setLoop: 2 setCel: 5)
					(gEgo init: posn: 128 69)
					(self
						addObstacle:
							(topPoly
								init: 105 74 67 85 95 82 108 86 141 85 147 82 185 83 137 74
								yourself:
							)
						setScript: fromHermit
					)
				)
			)
		else
			(gCurRoom
				addObstacle:
					(bottomPoly
						init: 214 149 214 146 190 151 162 153 79 156 52 171 0 160 0 0 319 0 319 189 83 189 113 178 124 167 198 152
						yourself:
					)
			)
			(self setScript: sEnterFromWest)
		)
		(hermitDoor init: stopUpd:)
	)

	(method (dispose)
		(ClearFlag 352)
		(= global425 0)
		(SetFlag 72)
		(super dispose:)
	)

	(method (cue)
		(switch local12
			(1
				(if (not local6)
					(= local6 1)
					(gMessager say: 4 1 2) ; "It's a large door. It must open pretty wide."
				)
			)
		)
	)

	(method (doit)
		(if (and (not (IsFlag 360)) (> (Abs (- gGameTime local0)) 2))
			(= local0 gGameTime)
			(Palette palANIMATE 232 239 -1 240 247 -1 248 254 -1)
		)
		(cond
			(script)
			((gEgo script:) 0)
			(
				(and
					(IsFlag 272)
					(& (gEgo onControl:) $0002)
					(not (gEgo script:))
					(not (== (gEgo script:) goodClimb))
					(not (IsFlag 276))
				)
				(gCurRoom setScript: sFallDown)
			)
			((== (gEgo edgeHit:) EDGE_LEFT)
				(gCurRoom setScript: walkOut)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(50 ; detectMagicSpell
				(if (CastSpell 18)
					(self setScript: detectLadder)
				else
					(gMessager say: 9 0 19) ; "That spell doesn't seem to work at this time."
				)
			)
			(77 ; triggerSpell or Pickup Inventory
				(if (CastSpell 19)
					(SetFlag 236)
					(ladder setCycle: End)
				else
					(gMessager say: 9 0 19) ; "That spell doesn't seem to work at this time."
				)
			)
			(78 ; dazzleSpell
				(if (CastSpell 20)
					(gCurRoom setScript: dazzleIt)
				else
					(gMessager say: 9 0 19) ; "That spell doesn't seem to work at this time."
				)
			)
			(51 ; openSpell
				(cond
					((IsFlag 352)
						(gMessager say: 9 51 26) ; "The door is already open."
					)
					((CastSpell 17)
						(cond
							((and (IsFlag 272) (> [gEgoStats 17] 5)) ; openSpell
								(gMessager say: 9 51 28) ; "As you prepare your spell..."
								(gEgo setMotion: MoveTo (gEgo x:) 60)
								(hermitDoor setScript: openFromBelow)
							)
							((TrySkill 12 45) ; magic
								(hermitDoor setScript: openFromBelow)
							)
						)
					)
					(else
						(gMessager say: 9 51 27) ; "The only thing you can open here is the door, and you're not skilled enough to do that."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onFall of Feature
	(properties
		x 248
		y 70
		noun 7
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 7 1) ; "The water seems to be trying to fly as it leaps from the mountain above."
			)
			(else
				(onWater doVerb: theVerb &rest)
			)
		)
	)
)

(instance ledge of Feature
	(properties
		x 113
		y 145
		z 72
		noun 6
		nsTop 67
		nsLeft 58
		nsBottom 80
		nsRight 168
	)
)

(instance cliff of Feature
	(properties
		x 112
		y 112
		noun 2
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((IsFlag 272)
						(gEgo setScript: climbDown)
					)
					((IsFlag 236)
						(gEgo setScript: goodClimb)
					)
					((TrySkill 11 30) ; climbing
						(gEgo setScript: goodClimb)
					)
					(else
						(gEgo setScript: badClimb)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onWater of Feature
	(properties
		x 242
		y 173
		noun 8
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(localproc_0 0)
			)
			(21 ; flask
				(if (gEgo has: 29) ; flyingWater
					(gMessager say: 8 21 0) ; "You already have some. Don't be greedy."
				else
					(localproc_0 1)
				)
			)
			(else
				(if
					(OneOf
						theVerb
						34 ; acorn
						42 ; candelabra
						44 ; candleSticks
						46 ; cheetaurClaw
						16 ; dagger
						38 ; fairyDust
						21 ; flask
						36 ; flowers
						39 ; flyingWater
						32 ; fruit
						29 ; ghostOil
						37 ; greenFur
						22 ; healingPotion
						26 ; brassKey
						14 ; leather
						17 ; lockPick
						27 ; magicGem
						23 ; manaPotion
						31 ; mandrake
						30 ; magicMirror
						40 ; mushroom
						43 ; musicBox
						45 ; pearls
						53 ; paper
						11 ; rations
						28 ; ring
						20 ; rock
						35 ; seed
						15 ; shield
						10 ; silver
						24 ; staminaPotion
						12 ; sword
						18 ; thiefKit
						19 ; thiefLicense
						47 ; trollBeard
						41 ; vase
						33 ; vegetables
					)
					(gMessager say: 8 0 4) ; "You don't have an empty flask."
				else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance ground of Feature
	(properties
		x 100
		y 160
		noun 3
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gEgo setScript: getRock)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance rocks of Feature
	(properties
		x 150
		y 180
		noun 10
		onMeCheck 8
		approachX 149
		approachY 159
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gEgo setScript: getRock)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance theCliff of Feature
	(properties
		x 50
		y 10
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(cliff doVerb: theVerb)
	)
)

(instance hermitHead of View
	(properties
		view 81
		loop 4
	)
)

(instance bottomSplash of Prop
	(properties
		x 267
		y 149
		noun 1
		view 82
		cel 1
		priority 14
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 1 1) ; "The water seems to be trying to fly as it leaps from the mountain above."
			)
			(else
				(onWater doVerb: theVerb &rest)
			)
		)
	)
)

(instance smlSplash1 of Prop
	(properties
		x 249
		y 83
		noun 11
		view 82
		loop 1
		priority 14
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 11 1) ; "The water seems to be trying to fly as it leaps from the mountain above."
			)
			(else
				(onWater doVerb: theVerb &rest)
			)
		)
	)
)

(instance smlSplash2 of Prop
	(properties
		x 261
		y 54
		noun 12
		view 82
		loop 1
		cel 3
		priority 14
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 12 1) ; "The water seems to be trying to fly as it leaps from the mountain above."
			)
			(else
				(onWater doVerb: theVerb &rest)
			)
		)
	)
)

(instance smlSplash3 of Prop
	(properties
		x 264
		y 86
		noun 13
		view 82
		loop 1
		cel 3
		priority 14
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 13 1) ; "The water seems to be trying to fly as it leaps from the mountain above."
			)
			(else
				(onWater doVerb: theVerb &rest)
			)
		)
	)
)

(instance smlSplash4 of Prop
	(properties
		x 296
		y 53
		noun 14
		view 82
		loop 1
		cel 2
		priority 14
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 14 1) ; "The water seems to be trying to fly as it leaps from the mountain above."
			)
			(else
				(onWater doVerb: theVerb &rest)
			)
		)
	)
)

(instance smlSplash5 of Prop
	(properties
		x 266
		y 112
		noun 15
		view 82
		loop 1
		cel 3
		priority 14
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 15 1) ; "The water seems to be trying to fly as it leaps from the mountain above."
			)
			(else
				(onWater doVerb: theVerb &rest)
			)
		)
	)
)

(instance smlSplash6 of Prop
	(properties
		x 277
		y 112
		noun 16
		view 82
		loop 1
		cel 3
		priority 14
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 16 1) ; "The water seems to be trying to fly as it leaps from the mountain above."
			)
			(else
				(onWater doVerb: theVerb &rest)
			)
		)
	)
)

(instance funkyEgo of Prop
	(properties
		priority 14
		signal 16
	)
)

(instance ladder of Prop
	(properties
		x 129
		y 150
		noun 5
		view 82
		loop 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 236)
					(gMessager say: 5 1 0) ; "It's an iridescently shimmering magical ladder!"
				else
					(gMessager say: 5 1 3) ; "You don't see a ladder here."
				)
			)
			(4 ; Do
				(cond
					((IsFlag 272)
						(gEgo setScript: climbDown)
					)
					((IsFlag 236)
						(gEgo setScript: goodClimb)
					)
					(else
						(gMessager say: 5 4 0) ; "You don't see a ladder here."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hermitDoor of Prop
	(properties
		x 96
		y 42
		z -25
		noun 4
		view 82
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 4 1 0 1 gCurRoom) ; "The door is built into the face of the mountainside. You suspect that the person who lives behind it treasures privacy."
				(= local12 1)
			)
			(4 ; Do
				(if (IsFlag 272)
					(hermitDoor setScript: knockScript)
					(SolvePuzzle 697 1)
				else
					(gMessager say: 4 4 0) ; "It's a little hard to knock on the door from where you're standing."
				)
			)
			(20 ; rock
				(if (IsFlag 272)
					(gMessager say: 4 20 0) ; "You're too close to throw a rock."
				else
					(gEgo setScript: throwIt)
				)
			)
			(17 ; lockPick
				(if (IsFlag 272)
					(gMessager say: 4 17 0) ; "The door is so securely locked that it defies your abilities to unlock it. (You might have had an easier time if it had a keyhole.)"
				else
					(gMessager say: 4 17 1) ; "You can't do that from here."
				)
			)
			(18 ; thiefKit
				(if (IsFlag 272)
					(gMessager say: 4 18 1) ; "You can't do that from here."
				else
					(gMessager say: 4 18 1) ; "You can't do that from here."
				)
			)
			(81 ; flameDartSpell
				(gCurRoom setScript: dartIt)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rock of Actor
	(properties
		view 510
		illegalBits 0
	)
)

(instance hermit of Actor
	(properties
		x 94
		y 60
		view 81
		illegalBits 0
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(gMessager say: 9 2 29) ; "The hermit doesn't seem to hear you."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance getWater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(if (< (gEgo x:) 90)
					(gEgo setMotion: PolyPath 95 150 self)
				else
					(self cue:)
				)
			)
			(2
				(gEgo setMotion: MoveTo 212 152 self)
			)
			(3
				(gEgo view: 510 loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(if (not (gEgo has: 11)) ; flask
					(switch local1
						(0
							(gMessager say: 9 0 25 1 self) ; "You take a drink of water from the icy mountain river. It refreshes you."
						)
						(1
							(gMessager say: 9 0 22 1 self) ; "You take another drink of water. You were thirsty!"
						)
						(else
							(gMessager say: 9 0 8 1 self) ; "BOY! You must have really been thirsty!"
						)
					)
					(++ local1)
				else
					(SetFlag 329)
					(SolvePuzzle 698 3)
					(gMessager say: 9 0 10 1 self) ; "You fill an empty flask with crystal-clear water from the waterfall."
				)
			)
			(5
				(if (not (gEgo has: 11)) ; flask
					0
				else
					(gEgo get: 29 use: 11 1) ; flyingWater, flask
				)
				(gEgo setCycle: Beg self)
			)
			(6
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance walkOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(gEgo setMotion: MoveTo -20 (gEgo y:) self)
			)
			(2
				(gCurRoom newRoom: 81)
			)
		)
	)
)

(instance badClimb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(gEgo illegalBits: 0 setMotion: MoveTo 131 152 self)
			)
			(2
				(gEgo
					view: 517
					setLoop: 0
					cel: 0
					posn: 129 121
					setCycle: Fwd
					setMotion: MoveTo 129 106 self
				)
			)
			(3
				(gEgo setCel: 0 setCycle: 0 setMotion: MoveTo 129 121 self)
			)
			(4
				(gMessager say: 9 0 0 1 self) ; "The rocks are too slick from the spray of the waterfall for your limited climbing skill."
				(gEgo setLoop: 3 view: 0 posn: 131 152)
				(NormalEgo)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance climbDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 130 86 self)
			)
			(1
				(topPoly dispose:)
				((gCurRoom obstacles:) delete: topPoly)
				(gEgo setHeading: 90 self)
			)
			(2
				(gEgo
					view: 517
					setLoop: 1
					setCel: -1
					cel: (gEgo lastCel:)
					setCycle: Beg self
				)
				(= local11 0)
			)
			(3
				(if (== [local59 local11] 99)
					(self changeState: 5)
				else
					(gEgo
						setLoop: [local59 local11]
						cel: [local59 (++ local11)]
						posn: [local59 (++ local11)] [local59 (++ local11)]
					)
					(++ local11)
					(= cycles 3)
				)
			)
			(4
				(self changeState: 3)
			)
			(5
				(gEgo view: 0 posn: 129 155 setCycle: Walk loop: 3)
				(ClearFlag 272)
				(= global425 0)
				(if (not (IsFlag 236))
					(gMessager say: 9 0 18 1 self) ; "That was as easy... as climbing up a ladder."
				else
					(self cue:)
				)
			)
			(6
				(gCurRoom
					addObstacle:
						(bottomPoly
							init: 214 149 214 146 190 151 162 153 79 156 52 171 0 160 0 0 319 0 319 189 83 189 113 178 124 167 198 152
							yourself:
						)
				)
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance knockScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(SetFlag 275)
				(rm82Sound number: 78 loop: 1 play:)
				(= cycles 5)
			)
			(2
				(rm82Sound play:)
				(= cycles 5)
			)
			(3
				(rm82Sound play:)
				(= cycles 5)
			)
			(4
				(gMessager say: 9 0 17 0 self) ; "You knock three times."
			)
			(5
				(HandsOn)
				(gEgo observeControl: 16 2 -32768 illegalBits: -32768)
				(= seconds 3)
			)
			(6
				(= seconds 3)
			)
			(7
				(hermitDoor setScript: hermitHits)
			)
		)
	)
)

(instance hermitHits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(if (IsFlag 275)
					(ClearFlag 275)
					(= cycles 15)
				else
					(self cue:)
				)
			)
			(2
				(if (not (gEgo script:))
					(HandsOff)
				)
				(self cue:)
			)
			(3
				(SetFlag 352)
				(gEgo illegalBits: 0 ignoreActors: setMotion: 0)
				(client view: 81 loop: 2 cel: 0 setCycle: CT 2 1 self)
			)
			(4
				(HandsOff)
				(cond
					((gEgo inRect: 100 62 145 84)
						(rm82Sound number: 104 loop: 1 play:)
						(SetFlag 274)
						(gEgo setScript: sFallDown)
						(= seconds 4)
					)
					((gEgo inRect: 62 62 100 88)
						(SetFlag 276)
						(gEgo setPri: 0)
						(= ticks 60)
					)
					(else
						(= ticks 60)
					)
				)
			)
			(5
				(HandsOff)
				(client setCycle: End self)
			)
			(6
				(if (IsFlag 276)
					(rm82Sound number: 104 loop: 1 play:)
					(hermitDoor setPri: (+ (gEgo priority:) 1))
					(gEgo view: 82 setLoop: 6 setCel: 0 posn: 86 81)
				)
				(= cycles 5)
			)
			(7
				(= cycles 10)
			)
			(8
				(if (and (IsFlag 272) (not (IsFlag 274)) (not (IsFlag 276)))
					(gMessager say: 9 0 7 1 self) ; "Oh. 'ello!  Go on in."
					(gEgo setScript: goOnIn)
					(self dispose:)
				else
					(gMessager say: 9 0 12 1 self) ; "Mpfph.. grumble.. nobody 'ere, I guess."
				)
			)
			(9
				(client setLoop: 3 cel: 0 setCycle: End)
				(= ticks 15)
			)
			(10
				(if (IsFlag 276)
					(gEgo
						view: 82
						setLoop: 6
						setPri: (+ (hermitDoor priority:) 1)
						cel: 0
					)
				)
				(self cue:)
			)
			(11
				(ClearFlag 352)
				(if (IsFlag 276)
					(gEgo setScript: squashed)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goOnIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(hermit setPri: 15)
				(gEgo
					illegalBits: 0
					setPri: (- (hermitDoor priority:) 1)
					setMotion: MoveTo 133 81 self
				)
			)
			(2
				(gEgo setMotion: MoveTo 125 71 self)
			)
			(3
				(hermitHead dispose:)
				(hermitDoor setLoop: 3 cel: 0 setCycle: CT 4 1 self)
			)
			(4
				(gEgo hide:)
				(hermitDoor setCycle: CT 5 1 self)
			)
			(5
				(rm82Sound number: 84 loop: 1 play:)
				(gCurRoom newRoom: 83)
			)
		)
	)
)

(instance squashed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(self cue:)
			)
			(3
				(gMessager say: 9 0 0 2 self) ; "Flat... you feel very, very flat."
			)
			(4
				(if (TakeDamage 10)
					(= cycles 5)
				else
					(EgoDead 94 95 0 0 538) ; "And dead... You feel dead, too. In your weakened condition, you succumbed to a mild-mannered hermit's propensity for Tarzan imitations. Back up and play it again, Sam."
				)
			)
			(5
				(ClearFlag 276)
				(gEgo
					setLoop: 8
					setCel: 3
					ignoreActors: 0
					posn: 100 78
					setCycle: End self
				)
			)
			(6
				(NormalEgo)
				(HandsOn)
				(= ticks 30)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance throwIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(if (< (gEgo x:) 90)
					(gEgo illegalBits: 0 setMotion: MoveTo 60 183 self)
				else
					(gEgo illegalBits: 0 setMotion: MoveTo 178 155 self)
				)
			)
			(2
				(gEgo
					view: 510
					setLoop: (if (< (gEgo x:) 90) 3 else 2)
					cel: 0
				)
				(= cycles 2)
			)
			(3
				(gEgo setCycle: CT 3 1 self)
			)
			(4
				(rock
					setLoop: 4
					setPri: 15
					setStep: 35 20
					ignoreActors:
					ignoreHorizon:
					setCycle: Fwd
					posn:
						(if (< (gEgo x:) 90)
							(+ (gEgo x:) 12)
						else
							(- (gEgo x:) 12)
						)
						(- (gEgo y:) 37)
					init:
				)
				(gEgo setCycle: End self)
			)
			(5
				(if (and (TrySkill 10 25) (not (IsFlag 352))) ; throwing
					(++ local5)
					(= local2 1)
					(rock
						setMotion:
							MoveTo
							(+ (hermitDoor x:) (Random 20 30))
							(+ (hermitDoor y:) (Random 20 30))
							self
					)
				else
					(rock
						setMotion:
							MoveTo
							(if (< (gEgo x:) 90)
								(+ (hermitDoor x:) (Random 60 85))
							else
								(- (hermitDoor x:) (Random 25 50))
							)
							(- (hermitDoor y:) (Random 20 30))
							self
					)
				)
			)
			(6
				(NormalEgo)
				(gEgo loop: (if (< (gEgo x:) 90) 0 else 1))
				(self cue:)
			)
			(7
				(rm82Sound number: 78 loop: 1 play:)
				(rock
					setMotion:
						JumpTo
						(cond
							((< (gEgo x:) 90)
								(if local2 40 else 225)
							)
							(local2 140)
							(else 0)
						)
						(if (< (gEgo x:) 90) 145 else 140)
						self
				)
			)
			(8
				(rock dispose:)
				(= cycles 2)
			)
			(9
				(if local2
					(if local3
						(gMessager say: 9 0 15 1 self) ; "RAP!"
					else
						(= local3 1)
						(gMessager say: 9 0 14 1 self) ; "The rock makes a sharp sound as it hits the door."
					)
				else
					(self cue:)
				)
			)
			(10
				(if (not local2)
					(gMessager say: 9 0 24 1 self) ; "Missed."
				else
					(= local2 0)
					(self cue:)
				)
			)
			(11
				(if (== local5 3)
					(= local5 0)
					(if local4
						(gMessager say: 9 0 13) ; "All right, already!"
					else
						(gMessager say: 9 0 20) ; "Is someone there?"
					)
					(hermitDoor setScript: answerKnock)
				else
					(HandsOn)
				)
				(gEgo use: 10 1 setScript: 0) ; rock
			)
		)
	)
)

(instance answerKnock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(hermitDoor view: 82 loop: 2 cel: 0 setCycle: CT 2 1 self)
			)
			(2
				(hermitDoor setCycle: End self)
				(hermit
					setLoop: 0
					init:
					posn: 120 74
					ignoreActors:
					setCycle: Walk
					setMotion: MoveTo 128 80
				)
			)
			(3
				(if local4
					(gMessager say: 9 0 5 1 self) ; "You again? Either come up, or go away. I really doesn't cares which."
				else
					(gMessager say: 9 0 21) ; "Oh, 'ello. Come right up."
					(= local4 1)
					(ladder setCycle: End self)
					(SetFlag 236)
				)
			)
			(4
				(hermit setLoop: 1 setMotion: MoveTo 118 65 self)
			)
			(5
				(ladder setCycle: Beg self)
				(hermit setPri: (- (hermitDoor priority:) 1))
				(hermitDoor setCycle: CT 4 -1 self)
			)
			(6
				(hermitDoor setCycle: Beg self)
			)
			(7
				(HandsOn)
				(hermit dispose:)
				(self dispose:)
			)
		)
	)
)

(instance getRock of Script
	(properties)

	(method (changeState newState &tmp [temp0 40])
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(= local8 (gEgo signal:))
				(= local9 (gEgo priority:))
				(= local10 (gEgo illegalBits:))
				(gEgo
					view: 510
					setLoop: (if (== (gEgo loop:) 0) 0 else 1)
					cel: 0
					setCycle: End self
				)
			)
			(2
				(Message msgGET 82 9 0 0 3 @temp0) ; "You pick up a few small rocks."
				(Print addText: @temp0 init:)
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo get: 10 10) ; rock
				(NormalEgo)
				(HandsOn)
				(gEgo priority: local9 illegalBits: local10 signal: local8)
				(client setScript: 0)
			)
		)
	)
)

(instance deadlyTP of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(gEgo
					init:
					view: 537
					illegalBits: 0
					posn: 247 44
					setLoop: 0
					hide:
				)
				(rm82Sound number: 28 loop: 1 init: play:)
				(funkyEgo
					view: 81
					setLoop: 5
					cel: 2
					posn: 248 42
					init:
					setCycle: CT 9 1 self
				)
			)
			(2
				(gEgo init: show:)
				(= cycles 5)
			)
			(3
				(funkyEgo setCycle: End self)
			)
			(4
				(funkyEgo dispose:)
				(gEgo setCycle: CT 2 1 self)
			)
			(5
				(gEgo
					ignoreActors:
					illegalBits: 0
					yStep: 10
					setPri: (- (bottomSplash priority:) 2)
					setMotion: MoveTo 270 156 self
				)
			)
			(6
				(EgoDead 164 165 0 2 537) ; "That hermit seems to know his "Trigger" spells pretty well. He sure pulled the trigger on you (not to mention the plug) by teleporting you to the top of the falls without a barrel."
			)
		)
	)
)

(instance fromHermit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: PolyPath 144 77 self
				)
			)
			(2
				(hermitDoor setCycle: Beg self)
			)
			(3
				(rm82Sound number: 84 loop: 1 play:)
				(SetFlag 272)
				(gEgo illegalBits: -32768)
				(= ticks 3)
			)
			(4
				(hermitDoor stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance openFromBelow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: PolyPath (gEgo x:) (+ (gEgo y:) 2) self
				)
			)
			(1
				(CastOpen gEgo)
				(= seconds 5)
			)
			(2
				(HandsOff)
				(SetFlag 352)
				(hermitDoor view: 82 loop: 2 cel: 0 setCycle: End self)
			)
			(3
				(cond
					((gEgo inRect: 100 62 145 84)
						(rm82Sound number: 104 loop: 1 play:)
						(SetFlag 274)
						(gEgo setScript: sFallDown)
						(= seconds 4)
					)
					((gEgo inRect: 62 62 100 88)
						(SetFlag 276)
						(gEgo setPri: 0)
						(= ticks 60)
					)
					(else
						(self cue:)
					)
				)
			)
			(4
				(gMessager say: 9 0 0 4 self) ; "'ello?"
			)
			(5
				(client setCycle: Beg self)
			)
			(6
				(ClearFlag 352)
				(HandsOn)
				(hermitDoor stopUpd: setScript: 0)
			)
		)
	)
)

(instance dazzleIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(CastDazzle gEgo self)
			)
			(2
				(gMessager say: 9 0 0 5 self) ; "Wow!"
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance dartIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(CastDart 0 self)
			)
			(1
				(gMessager say: 9 0 0 6 self) ; "Wheeee!"
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance detectLadder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(if (not (IsFlag 236))
					(SetFlag 236)
					(ladder setCycle: End self)
				else
					(HandsOn)
					(self dispose:)
				)
			)
			(2
				(ladder setCycle: Beg self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance rm82Sound of Sound
	(properties
		number 28
	)
)

(instance splashSound of Sound
	(properties
		flags -1
		loop -1
	)
)

(instance goodClimb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not (IsFlag 236))
					(gMessager say: 9 0 11) ; "You look for a good place to climb."
				)
				(NormalEgo)
				(gEgo illegalBits: 0 ignoreActors:)
				(gGame setCursor: gWaitCursor)
				(gEgo view: 0 setMotion: PolyPath 129 155 self)
				(= local11 0)
			)
			(1
				(if (== [local15 local11] 99)
					(self changeState: 3)
				else
					(gEgo
						view: 517
						setLoop: [local15 local11]
						cel: [local15 (++ local11)]
						posn: [local15 (++ local11)] [local15 (++ local11)]
						setCycle: 0
					)
					(++ local11)
					(= ticks 10)
				)
			)
			(2
				(self changeState: 1)
			)
			(3
				(bottomPoly dispose:)
				((gCurRoom obstacles:) delete: bottomPoly)
				(gCurRoom
					addObstacle:
						(topPoly
							init: 105 74 67 85 95 82 108 86 141 85 147 82 185 83 137 74
							yourself:
						)
				)
				(gEgo
					setLoop: 1
					posn: 130 80
					setCel: -1
					cel: 0
					setCycle: End self
				)
			)
			(4
				(if (not (IsFlag 236))
					(gMessager say: 9 0 23 1 self) ; "That was almost too easy... just like climbing a ladder."
				else
					(self cue:)
				)
			)
			(5
				(= global425 (| (|= global425 $0002) $0004))
				(if (not (== (gEgo view:) 0))
					(EgoGait 0 0) ; walking
				)
				(= ticks 60)
			)
			(6
				(HandsOn)
				(NormalEgo)
				(gGame setCursor: 942)
				(SetFlag 272)
				(= cycles 2)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance bottomPoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance topPoly of Polygon
	(properties
		type PContainedAccess
	)
)

(instance sEnterFromWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(gEgo init: posn: -15 170 setMotion: MoveTo 40 175 self)
			)
			(2
				(NormalEgo)
				(= cycles 2)
			)
			(3
				(if (not (IsFlag 72))
					(gMessager say: 9 0 9 1 self) ; "The roar of the waterfall fills your ears, and the cold spray dampens your face as you approach."
				else
					(= cycles 2)
				)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sFallDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(topPoly dispose:)
				((gCurRoom obstacles:) delete: topPoly)
				(= local13 (gEgo cycleSpeed:))
				(= local14 (gEgo moveSpeed:))
				(gEgo setLoop: 2 setMotion: 0 setCycle: 0)
				(= ticks 10)
			)
			(2
				(gCurRoom
					addObstacle:
						(bottomPoly
							init: 214 149 214 146 190 151 162 153 79 156 52 171 0 160 0 0 319 0 319 189 83 189 113 178 124 167 198 152
							yourself:
						)
				)
				(rm82Sound number: 9 loop: 1 play:)
				(gEgo view: 82 setLoop: 7 setCel: 0 setCycle: 0)
				(= ticks 20)
			)
			(3
				(gEgo
					view: 82
					setLoop: 7
					setCel: 1
					posn: (gEgo x:) (+ (gEgo y:) 23)
				)
				(= ticks 10)
			)
			(4
				(gEgo
					view: 82
					setLoop: 7
					setCel: 2
					posn: (gEgo x:) (+ (gEgo y:) 21)
				)
				(= ticks 10)
			)
			(5
				(gEgo
					view: 82
					setLoop: 7
					setCel: 2
					posn: (gEgo x:) (+ (gEgo y:) 21)
				)
				(= ticks 10)
			)
			(6
				(gEgo
					view: 82
					setLoop: 7
					posn: (gEgo x:) (+ (gEgo y:) 5)
				)
				(rm82Sound number: 10 loop: 1 play: self)
				(ShakeScreen 2)
				(= ticks 30)
			)
			(7
				(gEgo setLoop: 8 setCel: 2)
				(= ticks 30)
			)
			(8
				(if (not (TakeDamage 10))
					(EgoDead 68 69 2 5 517) ; "Had you been healthier, you probably could have survived that fall. In your weakened condition, however, you succumbed to your injuries."
				else
					(gEgo
						view: 82
						setCel: 3
						posn: (+ (gEgo x:) 5) (gEgo y:)
					)
					(= ticks 20)
				)
			)
			(9
				(gEgo setCycle: End self)
			)
			(10
				(NormalEgo)
				(gEgo posn: (- (gEgo x:) 2) (+ (gEgo y:) 4) loop: 2)
				(= ticks 20)
			)
			(11
				(= global425 0)
				(if (IsFlag 274)
					(ClearFlag 274)
				else
					(gMessager say: 9 0 16) ; "Man, that's a narrow ledge up there!"
				)
				(= cycles 2)
			)
			(12
				(if (not (hermitDoor script:))
					(HandsOn)
				)
				(ClearFlag 272)
				(ClearFlag 276)
				(self dispose:)
			)
		)
	)
)

(instance safeTP of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(funkyEgo
					view: 81
					setLoop: 5
					cel: 2
					posn: (gEgo x:) (gEgo y:)
					setPri: (+ (gEgo priority:) 1)
					ignoreActors:
					init:
					setCycle: CT 9 1 self
				)
			)
			(2
				(gEgo init: show:)
				(funkyEgo setCycle: End self)
			)
			(3
				(funkyEgo dispose:)
				(ClearFlag 272)
				(ClearFlag 241)
				(self dispose:)
				(HandsOn)
			)
		)
	)
)

