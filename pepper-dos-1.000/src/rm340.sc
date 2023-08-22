;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 340)
(include sci.sh)
(use Main)
(use ExitFeature)
(use ADRoom)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm340 0
)

(local
	local0 = 1
	local1 = 1
	local2 = 1
	local3
	local4
	local5 = 1
	local6
)

(instance rm340 of ADRoom
	(properties
		noun 1
		picture 340
		horizon 75
		north 310
		vanishingY -60
	)

	(method (init &tmp temp0)
		(if (== gAct 5)
			(olderHouse init:)
		)
		(if (== gPrevRoomNum 530)
			(= local6 1)
		)
		(if (== gPrevRoomNum 420)
			(gGame setEgo: (ScriptID 895 0)) ; pepper
		)
		(if
			(or
				(== gPrevRoomNum 530)
				(and (== gPrevRoomNum 300) (IsFlag 72) (not (IsFlag 74)))
			)
			(olderHouse eachElementDo: #init eachElementDo: #addToPic)
		)
		(super init: &rest)
		(gEgo init: normalize: posn: 136 143 setScale: 0)
		(window_ init: setOnMeCheck: 1 16)
		(porch init: setOnMeCheck: 1 64)
		(if (not local6)
			(southEFeature init:)
		)
		(forliage init: setOnMeCheck: 1 128)
		(hills init: setOnMeCheck: 1 256)
		(steps init: setOnMeCheck: 1 64)
		(keyHole init: approachVerbs: 85 7 6 86 30 89) ; Talk, Do, Look, Nose, Paw, Teeth
		(door init: stopUpd:)
		(pediment init:)
		(gGame handsOn:)
		(if (and (IsFlag 72) (not (IsFlag 74)) (== gAct 5))
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 216 171 261 171 261 185 216 185
						yourself:
					)
					((Polygon new:)
						type: PContainedAccess
						init: 58 131 58 154 26 173 0 173 0 189 312 189 312 176 208 157 163 186 138 186 138 179 141 179 146 170 153 165 155 159 174 148 158 141 171 133 139 127 130 127 119 125 95 139 78 175 64 159 78 131
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 216 166 257 166 257 187 216 187
						yourself:
					)
					((Polygon new:)
						type: PContainedAccess
						init: 3 103 3 130 32 130 32 169 0 169 0 189 315 189 315 175 212 153 157 186 138 186 138 179 141 179 146 170 153 165 155 159 189 140 171 133 139 127 130 127 119 125 90 139 76 167 71 158 79 136 91 131 34 119 34 103
						yourself:
					)
			)
		)
		(if (and (IsFlag 72) (not (IsFlag 74)))
			(= temp0 341)
		else
			(= temp0 340)
		)
		(gLongSong
			number: temp0
			setLoop: (if (== temp0 341) -1 else 1)
			flags: 1
			play:
		)
		(switch gPrevRoomNum
			(300
				(if (and (IsFlag 72) (not (IsFlag 74)) (== gAct 5))
					(ben ignoreActors: 0 init: stopUpd:)
					(gCurRoom setScript: sBackFrom2ndTimeJump)
				)
				(if
					(and
						(gCast contains: ben)
						(not (IsFlag 73))
						(not (gEgo has: 34)) ; Stick
						(== gAct 5)
					)
					(stick init: stopUpd:)
				)
				(if
					(and
						(IsFlag 265)
						(IsFlag 266)
						(IsFlag 267)
						(IsFlag 276)
						(IsFlag 277)
						(IsFlag 441)
						(IsFlag 219)
						(IsFlag 289)
						(IsFlag 284)
					)
					(SetFlag 56)
				)
				(if (and (IsFlag 56) (not (IsFlag 71)) (== gAct 5))
					(gCurRoom setScript: s2ndTimeJump)
				else
					(gCurRoom setScript: fromTaxStileScr)
				)
			)
			(420
				(gCurRoom setScript: fromPennPassageScr)
			)
			(310
				(gCurRoom setScript: fromBenSitRoomScr)
			)
			(530
				(ben init: ignoreActors: 0 stopUpd:)
				(bottomOfDoor init:)
				(if (and (not (gEgo has: 34)) (not (IsFlag 73))) ; Stick
					(stick init: stopUpd:)
				)
				(gCurRoom setScript: sBackFrom2ndTimeJump)
			)
			(510
				(gCurRoom setScript: fromJosiahShopScr)
			)
		)
		(tree
			init:
			noun: (if (gCast contains: ben) 9 else 8)
			setOnMeCheck: 1 4
		)
		(house
			init:
			noun: (if (gCast contains: ben) 3 else 2)
			setOnMeCheck: 1 32
		)
	)

	(method (doit)
		(cond
			(script 0)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(gCurRoom setScript: exitToTaxStileScr)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(olderHouse dispose:)
		(gLongSong fade:)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (gGame script:)
			((gGame script:) dispose:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance sBackFrom2ndTimeJump of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gMessager say: 17 0 21 1 4 self) ; "Well, then, lad, I thank you for walking me home. Goodbye!"
			)
			(2
				(gMessager say: 17 0 21 5 6 self) ; "Shoot, Ben, I'll help you for free!"
			)
			(3
				(gLongSong2 number: 927 setLoop: 1 play:)
				(gMessager say: 17 0 21 7 8 self) ; "|c1|And to think I used to swim in cold water like a fish! I used to do this trick where I'd fly a kite, then get into the swimming hole and use it to pull me across!|c|"
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance exitToTaxStileScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (gCast contains: ben))
					(+= state 2)
				)
				(= cycles 2)
			)
			(1
				((ScriptID 895 0) ; pepper
					x: (+ ((ScriptID 895 0) x:) 1) ; pepper
					y: (- ((ScriptID 895 0) y:) 1) ; pepper
				)
				(gMessager say: 17 0 23 0 self) ; "Pepper would NEVER walk off and leave Ben locked out of his house!"
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
			(3
				((ScriptID 895 0) ; pepper
					setCycle: Walk
					setLoop: 5
					setMotion:
						MoveTo
						(- ((ScriptID 895 0) x:) 40) ; pepper
						(+ ((ScriptID 895 0) y:) 65) ; pepper
						self
				)
			)
			(4
				(gCurRoom newRoom: 300)
			)
		)
	)
)

(instance doConDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 895 0) setHeading: 0 self) ; pepper
			)
			(1
				(= cycles 2)
			)
			(2
				(gMessager say: 4 7 1 0 self) ; "Yeah, it's locked, all right."
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fromTaxStileScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 38 210)
				(= cycles 1)
			)
			(1
				(if (IsFlag 30)
					(= register 1)
				else
					(SetFlag 30)
				)
				(= cycles 1)
			)
			(2
				((ScriptID 895 0) setCycle: Walk setMotion: MoveTo 81 180 self) ; pepper
			)
			(3
				((ScriptID 895 0) normalize:) ; pepper
				(if register
					(gGame handsOn:)
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(4
				(if (and (not (IsFlag 146)) (== gAct 2))
					(SetFlag 146)
					(gMessager say: 17 0 6 0 self) ; "Oh, wow! Here I am, standing in front of Benjamin Franklin's house..."
				else
					(= cycles 1)
				)
			)
			(5
				(gGame handsOn:)
				(gCurRoom newRoom: 410)
				(self dispose:)
			)
		)
	)
)

(instance fromPennPassageScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(= ticks 30)
			)
			(1
				(SetCursor 100 -5)
				(= cycles 1)
			)
			(2
				(gGame handsOff:)
				(gGame setEgo: (ScriptID 895 0)) ; pepper
				((ScriptID 895 1) hide:) ; lockjaw
				(= cycles 2)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fromBenSitRoomScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(if
					(and
						(IsFlag 17)
						(IsFlag 18)
						(not (IsFlag 49))
						(== gAct 3)
					)
					(SetFlag 49)
					(= cycles 1)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(2
				(= ticks 30)
			)
			(3
				(gMessager say: 17 0 17 0 self) ; "Whoa! What's going on! I feel funnyyyyyy..."
			)
			(4
				(= ticks 65)
			)
			(5
				(self setScript: shimmerOutScr self 1)
			)
			(6
				(= ticks 30)
			)
			(7
				(gCurRoom newRoom: 140)
				(self dispose:)
			)
		)
	)
)

(instance s2ndTimeJump of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 71)
				(gEgo posn: 38 210)
				(= cycles 1)
			)
			(1
				((ScriptID 895 0) setCycle: Walk setMotion: MoveTo 81 180 self) ; pepper
			)
			(2
				(= ticks 30)
			)
			(3
				(gMessager say: 17 0 19 0 self) ; "Oh, no! Here we go again! Beam me up, Scotteeeeeee..."
			)
			(4
				(= ticks 65)
			)
			(5
				(self setScript: shimmerOutScr self 1)
			)
			(6
				(= ticks 30)
			)
			(7
				(gLongSong fade:)
				(gCurRoom newRoom: 140)
				(self dispose:)
			)
		)
	)
)

(instance sPushKeyOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo put: 34 gCurRoomNum) ; Stick
				(SetFlag 65)
				(gGame points: 342 2)
				(= cycles 1)
			)
			(1
				(gMessager say: 11 73 1 1 self) ; "Okay, let's see if this works..."
			)
			(2
				(= ticks 30)
			)
			(3
				((ScriptID 895 0) setCycle: Walk setMotion: MoveTo 133 123 self) ; pepper
			)
			(4
				(gLongSong2 number: 930 setLoop: 1 play:)
				((ScriptID 895 0) ; pepper
					view: 341
					setLoop: 0
					cel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(5
				(= ticks 20)
			)
			(6
				(gMessager say: 11 73 1 2 3 self) ; "Bingo! We got it!"
			)
			(7
				((ScriptID 895 0) ; pepper
					normalize:
					setCycle: Walk
					setLoop: 4
					setMotion: MoveTo 147 136 self
				)
			)
			(8
				((ScriptID 895 0) normalize:) ; pepper
				(= cycles 2)
			)
			(9
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 159
		y 126
		noun 4
		approachX 142
		approachY 88
		approachDist 10
		view 340
		loop 2
	)

	(method (handleEvent event)
		(cond
			(
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
					(not (IsFlag 53))
					(not (gCurRoom script:))
					(not (gGame script:))
					(== gAct 2)
				)
				(event claimed: 1)
				(gCurRoom setScript: knockAtDoorScr)
			)
			(
				(and
					(not (event claimed:))
					(not (gCurRoom script:))
					(not (gGame script:))
				)
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(cond
					(
						(or
							(OneOf gAct 3 4 6)
							(and
								(== gAct 5)
								(IsFlag 65)
								(IsFlag 86)
								(IsFlag 74)
								(not (gCast contains: ben))
							)
						)
						(gCurRoom setScript: goInsideScr)
					)
					(
						(and
							(== gAct 5)
							(gCast contains: ben)
							(or (not (IsFlag 65)) (not (IsFlag 86)))
						)
						(gCurRoom setScript: doConDoor)
						(return 1)
					)
					(
						(and
							(not (gCast contains: ben))
							(not (IsFlag 72))
							(== gAct 5)
						)
						(gCurRoom setScript: goInsideScr 0 1)
					)
				)
			)
			(73 ; Stick
				(if (not (IsFlag 65))
					(gCurRoom setScript: sPushKeyOut)
				)
			)
			(71 ; Magnet
				(if (not (IsFlag 86))
					(gCurRoom setScript: sUseMagnetOnDoor)
				)
			)
			(124 ; Bens_Key
				(SetFlag 67)
				(SetFlag 74)
				(gCurRoom setScript: sUnlockDoor 0 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sUseMagnetOnDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 343 2)
				(= cycles 1)
			)
			(1
				(cond
					((not (IsFlag 65))
						(gMessager say: 16 71 4) ; "That would be a really good idea... if the key were down there."
						(gGame handsOn:)
						(self dispose:)
					)
					((and (IsFlag 65) (not (IsFlag 66)))
						(gMessager say: 16 71 5 1 self) ; "Hey, I've got an idea! Now, let's see..."
					)
					((and (IsFlag 65) (IsFlag 66))
						(gMessager say: 16 71 22) ; MISSING MESSAGE
						(gGame handsOn:)
						(self dispose:)
					)
				)
			)
			(2
				((ScriptID 895 0) setMotion: MoveTo 156 132 self) ; pepper
			)
			(3
				(= seconds 1)
			)
			(4
				(gLongSong2 number: 931 setLoop: 1 play:)
				((ScriptID 895 0) ; pepper
					view: 341
					setLoop: 5
					cel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(5
				(gMessager say: 16 71 5 2 3 self) ; "Yeah! Got it!"
			)
			(6
				(gEgo get: 40) ; Bens_Key
				(SetFlag 66)
				(SetFlag 86)
				(= cycles 1)
			)
			(7
				(= seconds 1)
			)
			(8
				(gGame handsOn:)
				((ScriptID 895 0) normalize:) ; pepper
				(SetFlag 86)
				(self dispose:)
			)
		)
	)
)

(instance sUnlockDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(if register
					(gMessager say: 20 124 1 0 self) ; "Here's your key, Ben."
				else
					(= cycles 1)
				)
			)
			(2
				(gMessager say: 11 124 1 1 3 self) ; "Okay, here we go!"
			)
			(3
				((ScriptID 895 0) ; pepper
					setCycle: Walk
					setMotion: PolyPath 141 133 self
				)
			)
			(4
				((ScriptID 895 0) setHeading: 90 normalize:) ; pepper
				(gGame points: 493 1)
				(= ticks 60)
			)
			(5
				(ben view: 341 loop: 4 cel: 0 posn: 171 143 setCycle: End self)
			)
			(6
				((ScriptID 895 0) ; pepper
					view: 805
					loop: 2
					cel: 0
					posn: 141 133
					setCycle: CT 5 1 self
				)
			)
			(7
				(ben setCycle: Beg self)
			)
			(8
				((ScriptID 895 0) cel: 5 setCycle: End self) ; pepper
			)
			(9
				(gMessager say: 11 124 1 4 5 self) ; "Thanks, Ben!"
			)
			(10
				(gGame points: 344 1)
				(gEgo get: 35) ; Chocolate
				(SetFlag 59)
				(SetFlag 67)
				(SetFlag 74)
				(= cycles 1)
			)
			(11
				(= seconds 2)
			)
			(12
				(self setScript: shimmerOutScr self 1)
			)
			(13
				(gMessager say: 11 124 1 6 self) ; "Lad? Lad? Oh, dear, I think I've been on my feet too long!"
			)
			(14
				(= seconds 1)
			)
			(15
				(olderHouse eachElementDo: #delete)
				(olderHouse eachElementDo: #dispose)
				(ben dispose:)
				(gCurRoom drawPic: 340 10)
				(= ticks 180)
			)
			(16
				(self setScript: shimmerOutScr self 0)
			)
			(17
				(gMessager say: 17 0 20 0 self) ; "Ben? Ben? He's gone! I must be back in 1764!"
			)
			(18
				(gEgo put: 40) ; Bens_Key
				(= cycles 1)
			)
			(19
				(self setScript: goQuizScr)
			)
		)
	)
)

(instance talkDeb of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame points: 337 1)
				(= cycles 2)
			)
			(1
				(if (< local0 4)
					(= temp0
						(switch local0
							(1 10)
							(2 13)
							(3 16)
						)
					)
					(++ local0)
					(gMessager say: 18 85 temp0 0 self)
				else
					(gMessager say: 18 85 16 0 self) ; "Please, Mrs. Franklin, if you'll just let me--"
				)
			)
			(2
				(= local2 1)
				(gCurRoom setScript: restofscr self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance shimmerOutScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 895 0) view: 803 setLoop: 2) ; pepper
				(= local3 ((ScriptID 895 0) cycleSpeed:)) ; pepper
				(= cycles 1)
			)
			(1
				(gLongSong2 number: 929 setLoop: 1 play:)
				(switch register
					(1
						((ScriptID 895 0) ; pepper
							cel: 12
							setSpeed: 7
							setCycle: Beg self
						)
					)
					(0
						((ScriptID 895 0) ; pepper
							show:
							cel: 0
							setSpeed: 7
							setCycle: End self
						)
					)
				)
			)
			(2
				(if register
					((ScriptID 895 0) hide:) ; pepper
				)
				(= seconds 2)
			)
			(3
				((ScriptID 895 0) normalize: setSpeed: local3) ; pepper
				(gLongSong fade:)
				(self dispose:)
			)
		)
	)
)

(instance stick of View
	(properties
		x 156
		y 152
		noun 15
		approachX 123
		approachY 139
		approachDist 10
		view 340
	)

	(method (doVerb theVerb)
		(Face (ScriptID 895 0) stick) ; pepper
		(switch theVerb
			(7 ; Do
				(gCurRoom setScript: getStickScr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ben of Prop
	(properties
		x 171
		y 143
		noun 20
		view 341
		loop 4
		cel 5
		signal 4096
	)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 7 6 85) ; Do, Look, Talk
				(gMessager say: 20 theVerb 1)
				(return 1)
			)
			(124 ; Bens_Key
				(gMessager say: 20 124 1) ; "Here's your key, Ben."
				(return 1)
			)
			((OneOf theVerb 85 7 6 86 30 89 84) ; Talk, Do, Look, Nose, Paw, Teeth, Trivia
				(super doVerb: theVerb)
			)
			(else
				(gMessager say: 20 19 1) ; "That's very kind, lad, but what I really need is to get into my house."
				(return 1)
			)
		)
	)
)

(instance deborah of Actor
	(properties
		x 161
		y 127
		noun 18
		view 340
		loop 2
		cel 9
	)

	(method (cue)
		(= local2 1)
		(deborahAtDoorScr cue:)
	)

	(method (doVerb theVerb &tmp temp0)
		(= local2 0)
		(if (OneOf theVerb 37 38 36) ; ???, ???, Package
			(if (IsFlag 8)
				(gGame setScript: satisfiedDeborahScr 0 1)
			else
				(gGame setScript: satisfiedDeborahScr 0 0)
			)
		)
		(switch theVerb
			(85 ; Talk
				(gCurRoom setScript: talkDeb)
			)
			((OneOf theVerb 37 38) ; ???, ???
				(gGame points: 339 3)
			)
			(36 ; Package
				(gGame points: 338 1)
			)
			(else
				(if (not (OneOf theVerb 84 7 6)) ; Trivia, Do, Look
					(gMessager say: 18 88) ; "I've no need for that, lad."
				else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance tree of Feature
	(properties
		x 243
		y 114
		sightAngle 40
		approachX 215
		approachY 177
	)

	(method (init)
		(self approachVerbs: 7) ; Do
		(super init: &rest)
	)
)

(instance bottomOfDoor of Feature
	(properties
		x 160
		y 140
		noun 16
		nsTop 107
		nsLeft 139
		nsBottom 134
		nsRight 182
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(71 ; Magnet
				(if (not (IsFlag 86))
					(gCurRoom setScript: sUseMagnetOnDoor)
				)
			)
			(else
				(if (not (OneOf theVerb 7 6)) ; Do, Look
					(super doVerb: theVerb &rest)
				)
			)
		)
		(if (OneOf theVerb 7 6) ; Do, Look
			(cond
				((not (IsFlag 65))
					(gMessager say: (self noun:) theVerb 4)
				)
				((and (IsFlag 65) (not (IsFlag 66)))
					(gMessager say: (self noun:) theVerb 5)
				)
				((and (IsFlag 65) (IsFlag 66))
					(gMessager say: (self noun:) theVerb 22)
				)
			)
		)
	)
)

(instance pediment of Feature
	(properties
		x 169
		y 125
		noun 12
		nsTop 4
		nsLeft 120
		nsBottom 47
		nsRight 219
		sightAngle 40
		approachX 169
		approachY 25
	)

	(method (doVerb theVerb)
		(= global215 110)
		(super doVerb: theVerb &rest)
	)
)

(instance window_ of Feature
	(properties
		x 87
		y 69
		noun 6
		sightAngle 40
		approachX 78
		approachY 123
	)
)

(instance porch of Feature
	(properties
		x 131
		y 151
		sightAngle 40
		approachX 138
		approachY 138
	)
)

(instance house of Feature
	(properties
		x 186
		y 84
		sightAngle 40
		approachX 97
		approachY 175
	)
)

(instance forliage of Feature
	(properties
		noun 7
	)
)

(instance hills of Feature
	(properties
		noun 14
	)
)

(instance steps of Feature
	(properties
		noun 5
	)
)

(instance knocker of Feature ; UNUSED
	(properties
		x 164
		y 150
		noun 10
		nsTop 69
		nsLeft 157
		nsBottom 87
		nsRight 171
		sightAngle 40
		approachX 147
		approachY 136
		approachDist 10
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 6) ; Look
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(switch theVerb
			(7 ; Do
				(if (!= ((ScriptID 895 0) heading:) 360) ; pepper
					((ScriptID 895 0) setHeading: 360) ; pepper
				)
				(cond
					((== gAct 3)
						(gCurRoom newRoom: 310)
						(= temp1 0)
					)
					((IsFlag 72)
						(= temp0 1)
						(= temp1 1)
					)
					((not (IsFlag 53))
						(= temp1 1)
						(switch local1
							(1
								(= temp0 7)
							)
							(2
								(if (not (IsFlag 89))
									(= temp0 8)
									(-- local1)
								else
									(= temp0 11)
								)
							)
							(3
								(= temp0 14)
							)
						)
					)
					(else
						(= temp1 0)
						(gCurRoom newRoom: 310)
					)
				)
				(++ local1)
			)
			(else
				(if local6
					(gMessager say: 10 theVerb 1)
				else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance knockAtDoorScr of Script
	(properties)

	(method (init)
		(= next deborahAtDoorScr)
		(super init: &rest)
	)

	(method (doit)
		(if
			(and
				(not (gLongSong2 handle:))
				(== ((ScriptID 895 0) view:) 340) ; pepper
				(== ((ScriptID 895 0) loop:) 3) ; pepper
				(OneOf ((ScriptID 895 0) cel:) 3 5 7) ; pepper
			)
			(gLongSong2 number: 921 setLoop: 1 play:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 336 1)
				(= cycles 1)
			)
			(1
				(= local3 ((ScriptID 895 0) cycleSpeed:)) ; pepper
				(= cycles 4)
			)
			(2
				((ScriptID 895 0) ; pepper
					normalize:
					setCycle: Walk
					setMotion: PolyPath 154 130 self
				)
			)
			(3
				((ScriptID 895 0) ; pepper
					view: 340
					setSpeed: 10
					setLoop: 3
					cel: 0
					setCycle: End self
				)
			)
			(4
				(= ticks 30)
			)
			(5
				((ScriptID 895 0) ; pepper
					normalize:
					setCycle: Walk
					setMotion: MoveTo 137 142 self
				)
			)
			(6
				((ScriptID 895 0) normalize: setHeading: 35 self) ; pepper
			)
			(7
				(= cycles 2)
			)
			(8
				(gGame handsOn:)
				((ScriptID 895 0) setSpeed: local3) ; pepper
				(= cycles 1)
			)
			(9
				(self dispose:)
			)
		)
	)
)

(instance deborahAtDoorScr of Script
	(properties)

	(method (doit)
		(if (and local4 (== state 4) (> ((ScriptID 895 0) y:) 153)) ; pepper
			(= local4 0)
			(self cue:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(= ticks 75)
			)
			(2
				(gLongSong2 number: 922 setLoop: 1 play:)
				(deborah
					init:
					view: 340
					setLoop: 2
					cel: 0
					posn: 159 126
					setCycle: End self
				)
				(door dispose:)
			)
			(3
				(gGame handsOn:)
				(deborah stopUpd:)
				(= cycles 1)
			)
			(4
				(= local4 1)
			)
			(5
				(gCurRoom setScript: restofscr)
			)
		)
	)
)

(instance restofscr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 4)
			)
			(1
				(deborah cycleSpeed: 12 setCycle: Beg self)
			)
			(2
				(gLongSong2 number: 926 setLoop: 1 play: self)
			)
			(3
				(door init: stopUpd:)
				(= cycles 10)
			)
			(4
				(deborah dispose:)
				((ScriptID 895 0) normalize:) ; pepper
				(= cycles 10)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance satisfiedDeborahScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local2 0)
				(= cycles 1)
			)
			(1
				(if (not register)
					(gMessager say: 18 112 0 0 self) ; "Here, Mrs. Franklin, I picked up this package for Mr. Franklin at the post office!"
					(SetFlag 141)
				else
					(gMessager say: 18 37 0 0 self) ; "I'll bet Mr. Franklin would like to see this book on electricity, hmm?"
					(SetFlag 53)
				)
			)
			(2
				(if (not register)
					(gCurRoom setScript: restofscr)
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(3
				(if (not register)
					(self dispose:)
				else
					(gCurRoom newRoom: 310)
				)
			)
		)
	)
)

(instance southEFeature of ExitFeature
	(properties
		nsTop 181
		nsLeft 17
		nsBottom 189
		nsRight 140
		cursor 910
		exitDir 3
		noun 21
	)
)

(instance olderHouse of List
	(properties)

	(method (init)
		(super init:)
		(self
			add:
				shutter
				whitePiller
				smWhitePiller
				spottedPorch
				doorStain
				stainedSteps
				extraGrass
				crackedSidewalk
		)
	)
)

(instance shutter of View
	(properties
		x 55
		y 43
		view 342
		cel 1
		priority 1
		signal 26640
	)
)

(instance whitePiller of View
	(properties
		x 121
		y 63
		view 342
		cel 2
		priority 1
		signal 26640
	)
)

(instance smWhitePiller of View
	(properties
		x 186
		y 120
		view 342
		cel 3
		priority 1
		signal 26640
	)
)

(instance spottedPorch of View
	(properties
		x 119
		y 139
		view 342
		cel 4
		priority 1
		signal 26640
	)
)

(instance doorStain of View
	(properties
		x 149
		y 65
		view 342
		cel 5
		priority 1
		signal 26640
	)
)

(instance stainedSteps of View
	(properties
		x 91
		y 153
		view 342
		cel 6
		priority 1
		signal 26640
	)
)

(instance extraGrass of View
	(properties
		x 42
		y 110
		view 342
		cel 7
		priority 1
		signal 26640
	)
)

(instance crackedSidewalk of View
	(properties
		x -2
		y 96
		view 342
		loop 1
		cel 1
		priority 2
		signal 26640
	)
)

(instance keyHole of Feature
	(properties
		x 142
		y 210
		z 100
		noun 11
		nsTop 75
		nsLeft 134
		nsBottom 100
		nsRight 151
		sightAngle 360
		approachX 139
		approachY 127
		approachDist 5
	)

	(method (doVerb theVerb &tmp temp0)
		(if (!= ((ScriptID 895 0) heading:) 360) ; pepper
			((ScriptID 895 0) setHeading: 360) ; pepper
		)
		(switch theVerb
			(7 ; Do
				(cond
					((and (not (IsFlag 53)) (not (IsFlag 72)))
						(gMessager say: 11 7 3) ; "The door is locked."
					)
					((and (IsFlag 53) (not (IsFlag 72)))
						(gCurRoom setScript: goInsideScr 0 1)
					)
					((== gAct 6)
						(gCurRoom setScript: goInsideScr 0 1)
					)
					(else
						(gMessager say: 11 7 1) ; "The door is firmly locked."
					)
				)
			)
			(6 ; Look
				(gCurRoom setScript: lookKeyHole)
			)
			(73 ; Stick
				(if (not (IsFlag 65))
					(gCurRoom setScript: sPushKeyOut)
				)
			)
			(124 ; Bens_Key
				(gCurRoom setScript: sUnlockDoor)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lookKeyHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 340 2)
				(= cycles 2)
			)
			(1
				(if (IsFlag 72)
					(gMessager say: 11 6 1 0 self) ; "There's a key in the lock on the other side of the door, Ben."
				else
					(gMessager say: 11 6 0 0 self) ; "It's the doorknob--a nice, shiny brass one."
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance goInsideScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 895 0) setHeading: 0 self) ; pepper
			)
			(1
				(= cycles 2)
			)
			(2
				(if register
					(gMessager say: 11 7 2 0 self) ; "I guess I'll just pop in on the Franklins."
				else
					(= cycles 1)
				)
			)
			(3
				((ScriptID 895 0) ; pepper
					setCycle: Walk
					setMotion: PolyPath 134 126 self
				)
			)
			(4
				((ScriptID 895 0) setPri: 15 view: 340 setLoop: 6 cel: 0) ; pepper
				(= ticks 10)
			)
			(5
				(door dispose:)
				(= ticks 15)
			)
			(6
				(gLongSong2 number: 922 setLoop: 1 play:)
				((ScriptID 895 0) setCycle: End self) ; pepper
			)
			(7
				((ScriptID 895 0) normalize: posn: 134 126) ; pepper
				(= cycles 1)
			)
			(8
				((ScriptID 895 0) setMotion: MoveTo 169 108 self) ; pepper
			)
			(9
				(gGame handsOn:)
				(gCurRoom newRoom: 310)
				(self dispose:)
			)
		)
	)
)

(instance goQuizScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(if register
					(gMessager say: 11 7 2 0 self) ; "I guess I'll just pop in on the Franklins."
				else
					(= cycles 1)
				)
			)
			(2
				((ScriptID 895 0) setCycle: Walk setMotion: MoveTo 134 126 self) ; pepper
			)
			(3
				((ScriptID 895 0) setPri: 15 view: 340 setLoop: 6 cel: 0) ; pepper
				(= ticks 10)
			)
			(4
				(door dispose:)
				(= ticks 15)
			)
			(5
				(gLongSong2 number: 922 setLoop: 1 play:)
				((ScriptID 895 0) setCycle: End self) ; pepper
			)
			(6
				((ScriptID 895 0) normalize: posn: 134 126) ; pepper
				(= cycles 1)
			)
			(7
				((ScriptID 895 0) setMotion: MoveTo 169 108 self) ; pepper
			)
			(8
				(gGame handsOn:)
				(gCurRoom newRoom: 600)
				(self dispose:)
			)
		)
	)
)

(instance fromJosiahShopScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 895 0) hide:) ; pepper
				(= cycles 1)
			)
			(1
				(= ticks 30)
			)
			(2
				(self setScript: shimmerOutScr self 0)
			)
			(3
				(= ticks 40)
			)
			(4
				(gMessager say: 17 0 18 0 self) ; "Oh, wow! THAT was bizarre! Geez, I hope I'm all here!"
			)
			(5
				(= ticks 20)
			)
			(6
				(gGame handsOn:)
				((ScriptID 895 0) normalize:) ; pepper
				(self dispose:)
			)
		)
	)
)

(instance getStickScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 341 1)
				(= local3 ((ScriptID 895 0) cycleSpeed:)) ; pepper
				(= cycles 1)
			)
			(1
				((ScriptID 895 0) ; pepper
					setSpeed: 6
					setCycle: Walk
					setMotion: PolyPath 130 149 self
				)
			)
			(2
				((ScriptID 895 0) normalize:) ; pepper
				(= cycles 5)
			)
			(3
				(gMessager say: 15 7 0 0 self) ; "Hmm, I wonder if I could use this to get into the house somehow...?"
			)
			(4
				((ScriptID 895 0) view: 805 loop: 0 cel: 0 setCycle: End self) ; pepper
			)
			(5
				(stick dispose:)
				(gEgo get: 34) ; Stick
				(SetFlag 73)
				(= cycles 2)
			)
			(6
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(7
				((ScriptID 895 0) normalize: setSpeed: local3) ; pepper
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

