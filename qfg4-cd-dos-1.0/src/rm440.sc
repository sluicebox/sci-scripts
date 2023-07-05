;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 440)
(include sci.sh)
(use Main)
(use GloryRm)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Grooper)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm440 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm440 of GloryRm
	(properties
		noun 1
		picture 440
		south 580
	)

	(method (init)
		(gLongSong number: 440 setLoop: -1 play:)
		(gEgo init: setScaler: Scaler 120 62 171 47)
		(water1 setCycle: Fwd setPri: 0 approachVerbs: 4 24 init:) ; Do, theFlask
		(water2 setCycle: Fwd setPri: 0 approachVerbs: 4 24 init:) ; Do, theFlask
		(water3 setCycle: Fwd setPri: 0 approachVerbs: 4 24 init:) ; Do, theFlask
		(waterfall setCycle: Fwd setPri: 0 init:)
		(if (not (IsFlag 189))
			(tree init: approachVerbs: 4 25) ; Do, theWater
		)
		(if (IsFlag 199)
			(grass init: approachVerbs: 4 25 14 setPri: 1) ; Do, theWater, theBonsai
			(bonsai init: approachVerbs: 4 25 14 setPri: 169) ; Do, theWater, theBonsai
		else
			(hole init: approachVerbs: 4 25 14) ; Do, theWater, theBonsai
			(dirtPile init: approachVerbs: 4 25 14) ; Do, theWater, theBonsai
		)
		(lanternFront init: approachVerbs: 4) ; Do
		(lanternBack init: approachVerbs: 4) ; Do
		(fruitTree init: approachVerbs: 4 25) ; Do, theWater
		(isleFlowers init: approachVerbs: 4) ; Do
		(waterfallFeat init:)
		(bridge init:)
		(nearBridge init:)
		(flowers2 init:)
		(flowers3 init:)
		(pathWay init:)
		(pond init: approachVerbs: 4 24) ; Do, theFlask
		(if (!= gPrevRoomNum 110) ; dreamer
			(self setScript: sEnter)
			(if gNight
				(= local1 1)
				(lightBack init: setCycle: Fwd approachVerbs: 4) ; Do
				(= local0 1)
				(lightFront init: setLoop: 1 1 setCycle: Fwd approachVerbs: 4) ; Do
			)
		else
			(self setScript: sFromDream)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 619 489 276 489 276 176 224 176 224 162 282 158 282 148 163 161 69 147 47 130 104 90 134 86 171 100 198 85 179 74 237 66 227 47 198 47 158 56 90 78 107 86 93 89 34 129 40 142 59 151 169 169 205 489 -300 489 -300 -300 619 -300
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 104) ; Sleep all night
				(self setScript: sSleepScr)
			)
			((== theVerb 81) ; detectMagicSpell
				(self setScript: sDetect)
			)
			((== theVerb 87) ; fetchSpell
				(gGlory handsOff:)
				(self setScript: (ScriptID 37) 0 fruitTree tulipFeat) ; castFetchScript
			)
			((== theVerb 11) ; glideSpell
				(frontBank init:)
				(backBank init:)
				(gWalkHandler add: frontBank backBank)
				(gGlory handsOff:)
				(if (> (gEgo y:) 100)
					(self setScript: sToWater 0 1)
				else
					(self setScript: sToWater 0 0)
				)
			)
			((OneOf theVerb 86 93 79 88) ; flameDartSpell, lightningBallSpell, frostSpell, forceBoltSpell
				(gMessager say: 1 86 0) ; "You don't want to disturb the calm serenity of the garden with such a violent action."
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (notify param1)
		(switch param1
			(-2
				(ClearFlag 149)
				(gMessager say: 2 6 16) ; "Your Glide subsides -- end of the ride."
				(gCurRoom setScript: sToBank)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(gLongSong fade:)
		(super newRoom: newRoomNumber)
	)
)

(instance sToBank of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(ClearFlag 149)
				(if register
					(gEgo setMotion: MoveTo 160 147 self)
				else
					(gEgo setMotion: MoveTo 172 111 self)
				)
			)
			(1
				(gWalkHandler delete: frontBank backBank)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom
					obstacles: 0
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 619 489 276 489 276 176 224 176 224 162 282 158 282 148 163 161 69 147 47 130 104 90 134 86 171 100 198 85 179 74 237 66 227 47 198 47 158 56 90 78 107 86 93 89 34 129 40 142 59 151 169 169 205 489 -300 489 -300 -300 619 -300
							yourself:
						)
				)
				(glideShadow dispose:)
				(if register
					(gEgo normalize: 2 setMotion: MoveTo 160 161 self)
				else
					(gEgo z: 0 normalize: 3 setMotion: MoveTo 171 100 self)
				)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sToWater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if register
					(gEgo setMotion: PolyPath 160 161 self)
				else
					(gEgo setMotion: PolyPath 171 100 self)
				)
			)
			(1
				(if (and (fountain script:) (== (sTulip state:) 1))
					(sTulip cue:)
				)
				(gWalkHandler add: frontBank backBank)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom
					obstacles: 0
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 114 103 135 103 157 107 165 111 489 111 206 104 226 111 243 111 243 105 255 105 270 109 293 115 266 136 168 149 139 145 86 118
							yourself:
						)
				)
				(if register
					(gEgo setMotion: MoveTo 160 147 self)
				else
					(gEgo normalize: 3 setMotion: MoveTo 172 111 self)
				)
			)
			(2
				(self setScript: (ScriptID 12) self) ; castAreaScript
			)
			(3
				(SetFlag 149)
				(gEgo
					setLoop: -1
					setLoop: Grooper
					setCycle: Walk
					view: 5
					z: 5
				)
				(gEgo loop: (if register 3 else 2))
				(glideShadow init:)
				(gGlory handsOn:)
				(gTheIconBar disable: 2 4 5 6 7)
				(self dispose:)
			)
		)
	)
)

(instance sOpenTulip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(Face gEgo (tulip x:) (tulip y:) self)
			)
			(1
				(= local2 1)
				(tulip setCel: 0 setLoop: 4 1 setCycle: End self)
			)
			(2
				(tulip setLoop: 5 1 setCycle: Fwd)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDetect of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager say: 1 81 0 0 self) ; "A soft magical aura permeates the entire garden. Strong magic emanates from the fruit tree and the center of the pool in the stream. The lanterns are also magical."
			)
			(1
				(frontSpark init: setCycle: Fwd)
				(backSpark init: setCycle: Fwd)
				(treeSpark init: setPri: 45 setCycle: Fwd)
				(waterSpark init: setCycle: Fwd)
				(= seconds 6)
			)
			(2
				(frontSpark dispose:)
				(backSpark dispose:)
				(treeSpark dispose:)
				(waterSpark dispose:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTrigger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(Face gEgo (register x:) (register y:) self)
			)
			(1
				(cond
					((== register pond)
						(if (and (not (fountain script:)) (not [gEgoStats 38])) ; protectionSpell
							(if (not (gCast contains: fountain))
								(fountain init:)
							)
							(fountain setScript: sTulip)
							(self dispose:)
						else
							(gMessager say: 2 6 18) ; "After making its offering, the tulip has returned to the watery depths."
							(gGlory handsOn:)
							(self dispose:)
						)
					)
					((== register lanternFront)
						(if local0
							(= local0 0)
							(lightFront loop: 0 setCycle: 0 dispose:)
							(gGlory handsOn:)
							(self dispose:)
						else
							(= local0 1)
							(lightFront init: setCycle: End self)
						)
					)
					(else
						(if local1
							(= local1 0)
							(lightBack setCycle: 0 dispose:)
						else
							(= local1 1)
							(lightBack init: setCycle: Fwd)
						)
						(gGlory handsOn:)
						(self dispose:)
					)
				)
			)
			(2
				(lightFront setLoop: 1 1 setCycle: Fwd)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTulip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fountain setLoop: 0 1 setCycle: End self)
			)
			(1
				(gGlory handsOn:)
				(if (not (gFeatures contains: tulipFeat))
					(tulipFeat init:)
				)
				(fountain setLoop: 1 1 setCycle: Fwd)
				(tulip init: setLoop: 2 1 setCel: 0 setCycle: Fwd)
				(= seconds 20)
			)
			(2
				(if local2
					(= local2 0)
					(tulip
						setLoop: (if [gEgoStats 38] 3 else 4) 1 ; protectionSpell
						setCel: 4
						setCycle: Beg self
					)
				else
					(self cue:)
				)
			)
			(3
				(tulip dispose:)
				(fountain setLoop: 0 1 setCel: 10 setCycle: Beg fountain)
				(self dispose:)
			)
		)
	)
)

(instance sSleepScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath 118 83 self)
			)
			(1
				(gEgo
					view: 35
					setLoop: 0 1
					setCel: 0
					posn: (+ (gEgo x:) 30) (- (gEgo y:) 2)
					setCycle: End self
				)
			)
			(2
				(= seconds 5)
			)
			(3
				(if (<= global345 10)
					(++ global345)
					(gCurRoom newRoom: 110) ; dreamer
				else
					(gCurRoom setScript: sFromDream)
				)
			)
		)
	)
)

(instance sFromDream of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(Palette 2 0 255 100) ; PalIntensity
				(gEgo
					view: 35
					setLoop: 4 1
					setCel: 0
					x: 148
					y: 81
					setCycle: 0
				)
				(= [gEgoStats 19] (gEgo maxMana:)) ; mana
				(= [gEgoStats 18] (gEgo maxStamina:)) ; stamina
				(= [gEgoStats 17] (gEgo maxHealth:)) ; health
				(= cycles 1)
			)
			(1
				((ScriptID 7 7) init: 6) ; egoSleeps
				(= seconds 5)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(gEgo posn: (gEgo x:) (- (gEgo y:) 2) normalize:)
				(cond
					((OneOf global345 1 2 3 4 5 7 8 9 10)
						(gMessager say: 2 6 2 1 self) ; "You wake in a cold sweat. You remember every detail of the nightmare as though it had really happened to you."
					)
					((<= global345 11)
						(gMessager say: 2 6 1 1 self) ; "You gradually wake, feeling relaxed and rested from the night's dream."
					)
					(else
						(self cue:)
					)
				)
			)
			(4
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo
					posn: 239 225
					normalize: 7
					setMotion: MoveTo 189 175 self
				)
			)
			(1
				(= cycles (+ (gEgo cycleSpeed:) 2))
			)
			(2
				(if (IsFlag 188)
					(self cue:)
				else
					(SetFlag 188)
					(gMessager say: 2 6 3 0 self) ; "You have come to a beautiful garden deep within the forest. A stream flows gently in a loop around the central island. Feelings of peace and harmony permeate the area."
				)
			)
			(3
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetWater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: MoveTo 158 152 self)
			)
			(1
				(= register (gEgo cycleSpeed:))
				(gEgo
					view: 4
					setLoop: 0 1
					setCel: 0
					setSpeed: global433
					setCycle: End self
				)
			)
			(2
				(gEgo drop: 9 1 get: 10 1) ; theFlask, theWater
				(gTheIconBar disable: 6)
				(gMessager say: 2 6 20 0 self) ; "You fill your flask to the top with fresh, sparkling water."
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize: 3 setSpeed: register setHeading: 180 self)
			)
			(5
				(gEgo setMotion: MoveTo 160 161 self)
			)
			(6
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetFlowers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= register (gEgo cycleSpeed:))
				(gEgo
					view: 4
					setLoop: 2 1
					setCel: 0
					setSpeed: global433
					setCycle: End self
				)
			)
			(1
				(gEgo get: 40) ; theFlowers
				(gMessager say: 7 4 0 0 self) ; "You pick a few of the beautiful flowers."
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo setSpeed: register normalize: 2)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBonsai of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo drop: 48 1) ; theBonsai
				(gGlory handsOff:)
				(gEgo setHeading: 135 self)
			)
			(1
				(= register (gEgo cycleSpeed:))
				(gEgo
					view: 4
					setCel: 0
					setLoop: 2 1
					cycleSpeed: global433
					setCycle: End self
				)
			)
			(2
				(= ticks 120)
			)
			(3
				(hole dispose:)
				(dirtPile dispose:)
				(grass approachVerbs: 4 25 14 init:) ; Do, theWater, theBonsai
				(bonsai init: approachVerbs: 4 25 14 setPri: 169 setCel: 0) ; Do, theWater, theBonsai
				(gEgo solvePuzzle: 417 6)
				(dirt
					signal: (| (dirt signal:) $0001)
					init:
					cycleSpeed: (* 2 global433)
					setCycle: End self
				)
			)
			(4
				(dirt dispose:)
				(= ticks 120)
				(gMessager say: 13 14 0 0 self) ; "You plant the bonsai in the hole and scrape some of the rich soil around it. In moments the bush begins to grow and blossom before your eyes!"
			)
			(5
				(= ticks 120)
			)
			(6
				(bonsai
					signal: (| (bonsai signal:) $0001)
					cycleSpeed: (* 2 global433)
					setCycle: End self
				)
				(SetFlag 257)
				(SetFlag 199)
			)
			(7
				(bonsai signal: (& (bonsai signal:) $fffe))
				(gEgo setCycle: Beg self)
			)
			(8
				(gEgo setSpeed: register normalize: 4)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance water1 of Prop
	(properties
		noun 10
		approachX 160
		approachY 161
		x 128
		y 119
		view 440
		cel 3
		signal 16385
		detailLevel 2
	)

	(method (doVerb theVerb)
		(pond doVerb: theVerb)
	)
)

(instance water2 of Prop
	(properties
		noun 10
		approachX 160
		approachY 161
		x 178
		y 131
		view 440
		loop 1
		cel 2
		signal 16385
		detailLevel 2
	)

	(method (doVerb theVerb)
		(pond doVerb: theVerb)
	)
)

(instance water3 of Prop
	(properties
		noun 10
		approachX 160
		approachY 161
		x 236
		y 127
		view 440
		loop 2
		cel 1
		signal 16385
		detailLevel 2
	)

	(method (doVerb theVerb)
		(pond doVerb: theVerb)
	)
)

(instance waterfall of Prop
	(properties
		noun 8
		x 251
		y 108
		view 440
		loop 3
		signal 16385
		detailLevel 1
	)

	(method (doVerb theVerb)
		(waterfallFeat doVerb: theVerb)
	)
)

(instance fountain of Prop
	(properties
		noun 15
		x 150
		y 120
		view 442
		signal 16385
		detailLevel 1
	)

	(method (doVerb theVerb)
		(tulipFeat doVerb: theVerb)
	)

	(method (cue)
		(tulipFeat dispose:)
		(if local3
			(gEgo learn: 38 100) ; protectionSpell
			(gEgo solvePuzzle: 499 6 2)
			(gMessager say: 15 87 12) ; "You capture the scroll with your Fetch spell."
		)
		(self dispose:)
	)
)

(instance tulip of Prop
	(properties
		noun 15
		x 150
		y 120
		view 442
		loop 2
		signal 16385
	)

	(method (doVerb theVerb)
		(tulipFeat doVerb: theVerb)
	)
)

(instance lightFront of Prop
	(properties
		noun 3
		x 52
		y 87
		view 443
		signal 16385
	)

	(method (doVerb theVerb)
		(lanternFront doVerb: theVerb)
	)
)

(instance lightBack of Prop
	(properties
		noun 4
		x 137
		y 45
		view 443
		loop 2
		signal 16385
	)

	(method (doVerb theVerb)
		(lanternBack doVerb: theVerb)
	)
)

(instance frontSpark of Prop
	(properties
		x 40
		y 62
		view 440
		loop 5
		signal 16385
	)
)

(instance backSpark of Prop
	(properties
		x 124
		y 24
		view 440
		loop 5
		signal 16385
	)
)

(instance treeSpark of Prop
	(properties
		x 208
		y 1
		view 440
		loop 6
		signal 16385
	)
)

(instance waterSpark of Prop
	(properties
		x 139
		y 113
		view 440
		loop 4
		signal 16385
	)
)

(instance tree of View
	(properties
		approachX 208
		approachY 49
		x 188
		y 7
		view 440
		loop 7
		cel 11
		signal 16384
	)

	(method (doVerb theVerb)
		(fruitTree doVerb: theVerb)
	)
)

(instance glideShadow of View
	(properties
		view 5
		loop 8
		signal 16385
	)

	(method (doit)
		(= x (gEgo x:))
		(= y (gEgo y:))
		(super doit: &rest)
	)
)

(instance grass of View
	(properties
		approachX 258
		approachY 165
		x 246
		y 143
		view 443
		loop 3
		signal 16384
	)

	(method (doVerb)
		(bonsai doVerb: &rest)
	)
)

(instance dirt of Prop
	(properties
		approachX 258
		approachY 165
		x 274
		y 175
		view 443
		loop 4
		signal 16384
	)
)

(instance bonsai of Prop
	(properties
		noun 16
		approachX 258
		approachY 165
		x 258
		y 167
		view 443
		loop 5
		cel 9
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25 ; theWater
				(gEgo drop: 10 1) ; theWater
				(gEgo get: 9 1) ; theFlask
				(if (not local4)
					(= local4 1)
					(gEgo addHonor: 5)
				)
				(gMessager say: noun theVerb 0) ; "You water the bonsai bush."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lanternFront of Feature
	(properties
		noun 3
		nsLeft 40
		nsTop 62
		nsRight 62
		nsBottom 102
		sightAngle 44
		x 51
		y 82
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (gCast contains: lightFront)
					(gMessager say: noun theVerb 4) ; "Beautiful music streams forth from the illuminated lantern."
				else
					(gMessager say: noun theVerb 5) ; "It's an ornate oriental lantern."
				)
			)
			(82 ; triggerSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 11) 0 self) ; castTriggerScript
			)
			(-82 ; triggerSpell (part 2)
				(gCurRoom setScript: sTrigger 0 self)
			)
			(4 ; Do
				(if (not (IsFlag 337))
					(SetFlag 337)
					(gEgo get: 0 30) ; thePurse
					(gMessager say: noun theVerb 0) ; "You discover 30 Crowns hidden there. You accept it as a gift from Erana."
				else
					(gMessager say: noun theVerb 19) ; "There is nothing left to take."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lanternBack of Feature
	(properties
		noun 4
		nsLeft 131
		nsTop 31
		nsRight 142
		nsBottom 52
		sightAngle 44
		x 136
		y 41
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (gCast contains: lightBack)
					(gMessager say: noun theVerb 4) ; "Beautiful music streams forth from the illuminated lantern."
				else
					(gMessager say: noun theVerb 5) ; "It's an ornate oriental lantern."
				)
			)
			(82 ; triggerSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 11) 0 self) ; castTriggerScript
			)
			(-82 ; triggerSpell (part 2)
				(gCurRoom setScript: sTrigger 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fruitTree of Feature
	(properties
		noun 5
		nsLeft 192
		nsRight 254
		nsBottom 33
		sightAngle 44
		approachX 208
		approachY 49
		x 223
		y 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (gCast contains: tree)
					(gMessager say: 5 1 6) ; "The fruit tree is laden with luscious-looking fruits of many kinds. It must be one of the rare mixed-fruit trees."
				else
					(gMessager say: 5 1 7) ; "It seems to be an out-of-season (or perhaps just out-of-sorts) fruit tree. No munchables adorn its branches."
				)
			)
			(4 ; Do
				(if (gCast contains: tree)
					(gMessager say: 5 4 6) ; "As you approach the tree, the fruit vanishes. Must be that low-calorie kind."
					(tree dispose:)
				else
					(gMessager say: 5 4 7) ; "The tree is barren (and on its way to being a duke) and devoid (not to mention quite out) of fruit."
				)
			)
			(25 ; theWater
				(gEgo drop: 10 1) ; theWater
				(gEgo get: 9 1) ; theFlask
				(gMessager say: noun theVerb 0) ; "You pour the water into the ground at the base of the tree. The small flask of water quickly soaks into the ground, but it was a nice thought."
			)
			(87 ; fetchSpell
				(gCurRoom doVerb: theVerb)
			)
			(-87 ; fetchSpell (part 2)
				(if (gCast contains: tree)
					(SetFlag 189)
					(gEgo get: 1 1) ; theManas
					(gMessager say: 5 87 6) ; "Your magical lasso floats towards the tree and plucks a single ripe fruit from its branches."
					(tree dispose:)
				else
					(gMessager say: 5 87 7) ; "You've fetched the first fruit and basically bagged your limit for the day. Since you really don't know when the fruit warden might come around, you'll have to try again another day."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance isleFlowers of Feature
	(properties
		noun 7
		nsLeft 198
		nsTop 62
		nsRight 245
		nsBottom 82
		sightAngle 44
		approachX 210
		approachY 72
		x 221
		y 72
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sGetFlowers)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PBarredAccess
					init: 186 70 214 64 229 57 245 62 249 68 239 77 217 81 187 76
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance waterfallFeat of Feature
	(properties
		noun 8
		nsLeft 234
		nsTop 70
		nsRight 289
		nsBottom 106
		sightAngle 44
		x 261
		y 88
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 227 104 252 80 270 74 291 75 276 85 271 93 267 109
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance bridge of Feature
	(properties
		noun 9
		nsLeft 64
		nsTop 84
		nsRight 123
		nsBottom 115
		sightAngle 44
		x 93
		y 99
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 64 105 84 90 99 85 125 90 124 96 118 95 82 111
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance nearBridge of Feature
	(properties
		noun 11
		nsLeft 89
		nsTop 95
		nsRight 135
		nsBottom 127
		sightAngle 44
		x 112
		y 111
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 89 109 114 98 131 100 106 118 101 113
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance hole of Feature
	(properties
		noun 13
		nsLeft 248
		nsTop 163
		nsRight 298
		nsBottom 176
		sightAngle 44
		approachX 258
		approachY 165
		x 273
		y 169
	)

	(method (doVerb theVerb)
		(switch theVerb
			(14 ; theBonsai
				(gCurRoom setScript: sBonsai)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dirtPile of Feature
	(properties
		noun 14
		nsLeft 269
		nsTop 149
		nsRight 309
		nsBottom 164
		sightAngle 44
		x 289
		y 156
	)

	(method (doVerb theVerb)
		(switch theVerb
			(14 ; theBonsai
				(gCurRoom setScript: sBonsai)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tulipFeat of Feature
	(properties
		noun 15
		nsLeft 135
		nsTop 85
		nsRight 163
		nsBottom 121
		sightAngle 44
		x 160
		y 124
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((== (tulip loop:) 2)
						(gMessager say: noun theVerb 11) ; "A magical fountain has sprung up from the water! At the top is a huge tulip, its flower tightly closed."
					)
					((or (== (tulip loop:) 4) (== (tulip loop:) 5))
						(gMessager say: noun theVerb 12) ; "Your spell has opened the "tulip." Resting within the flower is a scroll."
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(-87 ; fetchSpell (part 2)
				(if (and (gCast contains: tulip) (not local2))
					(gMessager say: 2 6 21) ; "The tulip is closed; your spell cannot reach inside."
				else
					(= local3 1)
					(sTulip seconds: 0 cue:)
				)
			)
			(87 ; fetchSpell
				(sTulip seconds: 100)
				(gCurRoom doVerb: theVerb)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(-80 ; openSpell (part 2)
				(if (and (gCast contains: tulip) (not local2))
					(gCurRoom setScript: sOpenTulip)
				else
					(gMessager say: 2 6 17) ; "You don't see anything to open there at the moment."
					(if (== ((ScriptID 13) state:) 4) ; castOpenScript
						((ScriptID 13) dispose:) ; castOpenScript
						(gGlory handsOn:)
					)
				)
			)
			(22 ; theCandle
				(if (== ((ScriptID 11) state:) 4) ; castTriggerScript
					((ScriptID 11) cue:) ; castTriggerScript
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance flowers2 of Feature
	(properties
		noun 6
		nsLeft 18
		nsTop 44
		nsRight 73
		nsBottom 77
		sightAngle 44
		x 45
		y 60
	)
)

(instance flowers3 of Feature
	(properties
		noun 6
		nsLeft 289
		nsTop 86
		nsRight 319
		nsBottom 114
		sightAngle 44
		x 304
		y 100
	)
)

(instance pathWay of Feature
	(properties
		noun 12
		nsLeft 21
		nsTop 107
		nsRight 252
		nsBottom 189
		sightAngle 44
		x 136
		y 148
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 188 189 175 180 146 172 107 162 84 152 71 158 34 150 24 139 24 130 65 106 84 112 60 125 58 129 59 134 71 141 91 147 143 154 191 161 226 172 243 184 250 189
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance pond of Feature
	(properties
		noun 10
		nsLeft 95
		nsTop 91
		nsRight 298
		nsBottom 149
		sightAngle 44
		approachX 160
		approachY 161
		x 196
		y 120
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PBarredAccess
					init: 108 119 132 101 183 110 202 100 228 105 291 111 297 115 265 125 249 127 239 140 205 136 199 144 168 149 140 143
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(82 ; triggerSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 11) 0 self) ; castTriggerScript
			)
			(-82 ; triggerSpell (part 2)
				(cond
					((not (fountain script:))
						(gCurRoom setScript: sTrigger 0 self)
					)
					((== ((ScriptID 11) state:) 4) ; castTriggerScript
						((ScriptID 11) cue:) ; castTriggerScript
					)
				)
			)
			(24 ; theFlask
				(gCurRoom setScript: sGetWater)
			)
			(4 ; Do
				(ClearFlag 14)
				(= global479 0)
				((ScriptID 0 21) doit: 440) ; statusCode
				(gMessager say: noun theVerb 0) ; "You take a drink of the cool water. It tastes like wild strawberries."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance frontBank of Feature
	(properties
		nsTop 155
		nsRight 319
		nsBottom 189
		sightAngle 44
		approachX 160
		approachY 147
		x 159
		z -172
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(gCurRoom setScript: sToBank 0 1)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance backBank of Feature
	(properties
		nsLeft 130
		nsTop 53
		nsRight 217
		nsBottom 95
		sightAngle 44
		approachX 172
		approachY 111
		x 173
		z -74
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(gCurRoom setScript: sToBank 0 0)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

