;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 110)
(include sci.sh)
(use Main)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm110 0
	jackTalker 1
	spiffTalker 2
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
)

(procedure (localproc_0 param1)
	(jack view: 115 setLoop: 0 posn: 106 129 setPri: 8 setSpeed: 10)
	(jacksHead
		view: 115
		loop: 1
		cel: 4
		x: (+ (jack x:) 10)
		y: (- (jack y:) 51)
		setPri: 8
		cycleSpeed: 10
	)
	(if (and argc param1)
		(param1 cue:)
	)
)

(instance rm110 of Room
	(properties
		picture 110
		west 130
	)

	(method (init)
		(proc0_4 1)
		(if (gPqFlags test: 160)
			(= global155 4)
		)
		(gCurRoom
			addObstacle:
				(if (and (< gDay 3) (not (gPqFlags test: 3)))
					((Polygon new:)
						type: PContainedAccess
						init: 0 125 19 134 198 152 268 152 319 143 319 130 311 135 273 135 208 133 196 127 186 127 179 130 136 133 103 131 95 130 38 126 32 122 0 120
						yourself:
					)
				else
					((Polygon new:)
						type: PContainedAccess
						init: 0 125 19 134 198 152 268 152 319 143 319 130 273 135 208 133 196 127 186 127 179 130 136 133 103 131 97 129 73 128 38 126 32 122 0 120
						yourself:
					)
				)
		)
		(super init: &rest)
		(switch gPrevRoomNum
			(115
				(gEgo setHeading: 180 posn: 197 138)
				(gCurRoom setScript: musicScript)
			)
			(100
				(gEgo setHeading: 270 posn: 305 139)
			)
			(west
				(gEgo setHeading: 90 posn: 14 124)
				(gCurRoom setScript: musicScript)
			)
			(else
				(gEgo setHeading: 180 posn: 170 140)
			)
		)
		(gEgo
			setTalker: careyTalker
			setScaler: Scaler 90 70 152 125
			normalize: 0
			init:
		)
		(if (< gDay 3)
			(jack
				posn: 106 129
				init:
				signal: (| (jack signal:) $4000)
				setScript: jackScr
				approachVerbs: 2 ; Talk
			)
			(jacksHead
				x: (+ (jack x:) 10)
				y: (- (jack y:) 51)
				init:
				signal: (| (jacksHead signal:) $4000)
				approachVerbs: 2 ; Talk
			)
			(if (not (gPqFlags test: 3))
				(gPqFlags set: 3)
				(spiffOnPhone
					init:
					signal: (| (spiffOnPhone signal:) $5000)
					approachVerbs: 2 27 4 ; Talk, badge, Do
				)
			)
		)
		(door init: approachVerbs: 4) ; Do
		(paperMachine init: approachVerbs: 4 1 29) ; Do, Look, coins
		(phone init:)
		(theSign init:)
		(leftWindow init:)
		(rightWindow init:)
		(awning init:)
		(fence init:)
		(lotterySign init:)
		(sidewalk init:)
		(sky init:)
		(store init:)
		(gGame handsOn:)
	)

	(method (doit)
		(super doit:)
		(if (> (gEgo x:) 307)
			(gCurRoom newRoom: 100)
		)
	)
)

(instance blastEm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 170 140 self)
			)
			(1
				(Face gEgo spiffOnPhone self)
			)
			(2
				(spiffOnPhone cycler: 0 mover: 0)
				(spiffPhoneScript1 dispose:)
				(spiffPhoneScript2 dispose:)
				(spiffPhoneScript3 dispose:)
				((ScriptID 32 0) doit: 2 22 15 1 110) ; ShootHandgun
			)
		)
	)
)

(instance musicScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gGlobalSound1 client: 0)
		(super dispose: &rest)
		(gTheDoits delete: self)
	)

	(method (cue)
		(self changeState: (+ state 1) &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound1 fade: 0 1 5 1 self)
			)
			(1
				(gGlobalSound0
					number: 110
					loop: -1
					play:
					setVol: 0
					fade: 127 1 5 0 self
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance jack of Actor
	(properties
		noun 1
		approachX 148
		approachY 139
		approachDist 1
		view 115
		cycleSpeed 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(cond
					((not local3)
						(gMessager say: 1 2 16 0) ; "I'd like to ask you a few questions."
					)
					((== local3 1)
						(gMessager say: 1 2 17 0) ; "You were in the alley last night. I thought you might be able to tell me what you know about the murders."
					)
					((== local3 2)
						(gMessager say: 1 2 2 0) ; "Can you recall any unusual activity in the neighborhood last night, any arguments, or unfamiliar people."
					)
					((> local3 2)
						(gMessager say: 1 2 24 0) ; "Sir?"
					)
				)
				(++ local3)
			)
			(1 ; Look
				(if (not local5)
					(gMessager say: 1 1 3 0) ; "This man was at the crime scene last night."
					(++ local5)
				else
					(gMessager say: 1 1 0 0) ; "It's a shame what a life of alcohol will do to a man."
				)
			)
			(27 ; badge
				(if (not local7)
					(gGame handsOff:)
					(++ local7)
					(gCurRoom setScript: badgeJackScr)
				else
					(gMessager say: 1 27 2 0) ; "You've identified yourself already."
				)
			)
			(29 ; coins
				(if (== global155 4)
					(gMessager sayRange: 1 29 19 1 2) ; "You've offered enough assistance. Any more change and he'd have enough for a cheap bottle of wine."
				else
					(gGame handsOff:)
					(gGame points: 2)
					(++ global155)
					(gCurRoom setScript: giveCoinScr)
				)
			)
			(22 ; handgun
				(cond
					((not local1)
						(gMessager say: 1 22 13) ; "An unwise, and unwarranted, tactic, Detective."
						(++ local1)
					)
					(((ScriptID 32 0) doit: 1 22 14 1 110) ; ShootHandgun
						(jack setScript: 0)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance jacksHead of Prop
	(properties
		noun 1
		approachX 148
		approachY 136
		approachDist 1
		view 115
		loop 1
		cel 4
		cycleSpeed 10
	)

	(method (doVerb theVerb)
		(jack doVerb: theVerb)
	)
)

(instance spiffOnPhone of Actor
	(properties
		noun 2
		approachX 265
		approachY 142
		approachDist 1
		x 292
		y 135
		priority 8
		fixPriority 1
		view 110
	)

	(method (init)
		(super init:)
		(self setScript: spiffPhoneScript1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if (< local0 1)
					(= local0 1)
					(self setScript: spiffPhoneScript2)
				else
					(gMessager say: 2 2 3 0 self) ; "Excuse me, I'd like to talk you."
				)
			)
			(27 ; badge
				(gCurRoom setScript: badgeSpiffScript)
			)
			(22 ; handgun
				(if (not local2)
					(Face gEgo self)
					(gMessager say: 2 22 13) ; "You have no cause to draw your firearm. Holster your weapon."
					(++ local2)
					(return 1)
				else
					(gCurRoom setScript: blastEm)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance badgeSpiffScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gPqPointFlags set: 20)
				(spiffOnPhone setSpeed: 4)
				(gEgo setHeading: 45)
				(= cycles 2)
			)
			(1
				((ScriptID 38 0) init: self) ; BadgeOut
			)
			(2
				(= seconds 4)
			)
			(3
				((ScriptID 38 1) init: self) ; BadgeIn
			)
			(4
				(if (< local0 2)
					(spiffOnPhone setScript: 0)
					(self setScript: spiffPhoneScript3 self)
				else
					(= seconds 3)
				)
			)
			(5
				(if (>= local0 2)
					(gMessager say: 2 27 5 0) ; "Five-o! What's up with that? You poppin' me?"
				else
					(= local0 2)
				)
				(if (!= (spiffOnPhone script:) spiffPhoneScript1)
					(spiffOnPhone setScript: spiffPhoneScript1)
				)
				(gGame handsOn:)
				(gEgo normalize: 0 setLoop: -1)
				(self dispose:)
			)
		)
	)
)

(instance spiffPhoneScript1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(spiffOnPhone
					view: 110
					setLoop: (Random 0 1)
					cel: 0
					setSpeed: (+ 4 (* (Random 1 3) 3))
					setCycle: End self
				)
			)
			(2
				(= seconds 4)
			)
			(3
				(spiffOnPhone setCycle: Beg self)
			)
			(4
				(= state 0)
				(= seconds (Random 3 6))
			)
		)
	)
)

(instance spiffPhoneScript2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 2 2 3 0 self) ; "Excuse me, I'd like to talk you."
			)
			(1
				(spiffOnPhone
					view: 111
					setLoop: 0
					cel: 0
					setSpeed: 4
					setCycle: End self
				)
			)
			(2
				(spiffOnPhone setLoop: 1 cel: 0 setCycle: End self)
			)
			(3
				(spiffOnPhone view: 112 setLoop: 0 cel: 0 setCycle: End self)
			)
			(4
				(spiffOnPhone setLoop: 1 cel: 0 setCycle: End self)
			)
			(5
				(gGame handsOn:)
				(spiffOnPhone setScript: spiffPhoneScript1)
			)
		)
	)
)

(instance spiffPhoneScript3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 2 27 5 0) ; "Five-o! What's up with that? You poppin' me?"
				(spiffOnPhone
					view: 113
					setLoop: 0
					cel: 0
					setSpeed: 4
					setCycle: End self
				)
			)
			(1
				(spiffOnPhone setLoop: 1 cel: 0 setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance jackScr of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and local8 (not (gEgo inRect: 136 126 156 150)))
			(= local8 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(cond
					((gCurRoom script:)
						(self start: 0 init:)
					)
					(local8
						(self start: 0 init:)
					)
					((gEgo inRect: 136 126 156 150)
						(gGame handsOff:)
						(self setScript: begScr self)
					)
					((> (Random 0 99) 97)
						(self setScript: drinkScr self)
					)
					(else
						(self start: 0 init:)
					)
				)
			)
			(2
				(= state -1)
				(= cycles 2)
			)
		)
	)
)

(instance drinkScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 self)
			)
			(1
				(jack view: 116 setLoop: 0 x: (- (jack x:) 1))
				(jacksHead
					view: 116
					setLoop: 1
					cel: 0
					x: (- (jacksHead x:) 4)
					y: (+ (jacksHead y:) 27)
					setCycle: End self
				)
			)
			(2
				(= seconds (Random 1 3))
			)
			(3
				(jacksHead setCycle: Beg self)
			)
			(4
				(localproc_0 self)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance begScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 self)
			)
			(1
				(jack view: 117 setLoop: 0 x: (+ (jack x:) 7))
				(jacksHead
					view: 117
					setLoop: 1
					cel: 0
					x: (+ (jacksHead x:) 1)
					y: (+ (jacksHead y:) 27)
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(2
				(if (gTalkers size:)
					(-- state)
					(= seconds 2)
				else
					(gMessager say: 1 27 16 2 self) ; "Ya got som' spare change a fellow could have?"
				)
			)
			(3
				(gGame handsOn:)
				(= start 0)
				(= seconds (Random 3 6))
			)
			(4
				(if (gEgo inRect: 136 126 156 150)
					(self start: 2 init:)
				else
					(= cycles 1)
				)
			)
			(5
				(jacksHead setCycle: Beg self)
			)
			(6
				(localproc_0 self)
			)
			(7
				(self start: 0 dispose:)
			)
		)
	)
)

(instance giveCoinScr of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 2) (!= (jackScr script:) drinkScr))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 148 139 self)
			)
			(1
				(gEgo setHeading: 330 self)
			)
			(2 0)
			(3
				(jackScr setScript: 0)
				(gEgo view: 9032 setLoop: 1 1 cel: 0 setCycle: End self)
			)
			(4
				(if (!= (jack view:) 117)
					(jack view: 117 setLoop: 0 x: (+ (jack x:) 7))
					(jacksHead
						view: 117
						setLoop: 1
						cel: 0
						x: (+ (jacksHead x:) 1)
						y: (+ (jacksHead y:) 27)
						cycleSpeed: 3
						setCycle: End self
					)
				else
					(= cycles 1)
				)
			)
			(5
				(jacksHead setCycle: Beg self)
				(gEgo setCycle: Beg self)
			)
			(6 0)
			(7
				(switch global155
					(1
						(gMessager say: 1 29 16 0 self) ; "God bless you..."
					)
					(2
						(gMessager say: 1 29 2 0 self) ; "You're very kind."
					)
					(3
						(= global155 4)
						(gPqFlags set: 160)
						(gMessager say: 1 29 18 0 self) ; "Ya know, that kid was gonna be a ball player, the big leagues, he was."
					)
				)
			)
			(8
				(= local8 1)
				(localproc_0)
				(gEgo normalize: 0 loop: 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance badgeJackScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 148 136 self)
			)
			(1
				(gEgo setHeading: 330 self)
			)
			(2
				((ScriptID 38 0) init: self) ; BadgeOut
			)
			(3
				(= seconds 2)
			)
			(4
				(gMessager say: 1 27 16 0 self) ; "I'm Detective Carey, LAPD. I saw you last night in the alley."
			)
			(5
				((ScriptID 38 1) init: self) ; BadgeIn
			)
			(6
				(gEgo normalize: 0 loop: 7)
				(= cycles 4)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance phone of Feature
	(properties
		noun 3
		nsLeft 272
		nsTop 81
		nsRight 290
		nsBottom 121
		sightAngle 90
		x 281
		y 130
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (gCast contains: spiffOnPhone)
					(gMessager
						say:
							3
							4
							(switch local6
								(0 6)
								(1 9)
								(else 10)
							)
							0
					)
					(++ local6)
				else
					(gCurRoom setScript: doPhoneScr)
				)
			)
			(1 ; Look
				(gMessager
					say: 3 1 (if (gCast contains: spiffOnPhone) 6 else 11) 0
				)
			)
			(29 ; coins
				(if (gCast contains: spiffOnPhone)
					(super doVerb: theVerb)
				else
					(gCurRoom setScript: doPhoneScr 0 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doPhoneScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (or (!= (gEgo x:) 297) (!= (gEgo y:) 135))
					(gEgo setMotion: PolyPath 297 135 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(if register
					(sFx number: 1005 loop: 1 play:)
				)
				(= cycles 2)
			)
			(3
				(if (not register)
					(gEgo z: 1000)
					(altEgo
						setScaler: Scaler 90 72 152 125
						init:
						signal: (| (altEgo signal:) $4000)
						x: (- (gEgo x:) 6)
						y: (gEgo y:)
						loop: 0
						cel: 0
						setCycle: CT 12 1 self
					)
				else
					(gMessager say: 3 29 11 0 self) ; "Clink, clink"
				)
			)
			(4
				(if (not register)
					(= ticks 120)
				else
					(= register 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(5
				(altEgo setCycle: End self)
			)
			(6
				(altEgo loop: 1 cel: 0 setCycle: CT 9 1 self)
			)
			(7
				(= ticks 120)
			)
			(8
				(altEgo setCycle: End self)
			)
			(9
				(altEgo loop: 2 cel: 0 setCycle: End self)
			)
			(10
				(gEgo z: 0)
				(altEgo dispose:)
				(= cycles 2)
			)
			(11
				(gMessager say: 3 4 11 0 self) ; "There's no dial tone, and no change in the coin return! Useless!"
			)
			(12
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance altEgo of Actor
	(properties
		view 9117
	)
)

(instance paperMachine of Feature
	(properties
		heading 225
		noun 4
		nsLeft 217
		nsTop 99
		nsRight 238
		nsBottom 129
		sightAngle 45
		approachX 217
		approachY 137
		approachDist 20
		x 227
		y 129
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if (== gDay 2)
				(gMessager say: 4 1 (if (gPqPointFlags test: 6) 8 else 7) 0)
			else
				(gMessager
					say:
						4
						1
						(switch gDay
							(3 20)
							(4 21)
							(5 22)
							(else 23)
						)
						0
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance door of Feature
	(properties
		noun 5
		nsLeft 174
		nsTop 59
		nsRight 202
		nsBottom 128
		sightAngle 90
		approachX 202
		approachY 132
		approachDist 10
		x 189
		y 125
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 1 2 27) ; Look, Talk, badge
				(super doVerb: theVerb)
			)
			((== theVerb 4) ; Do
				(gCurRoom setScript: openDoorScript)
			)
			(else
				(gMessager say: 0 theVerb 0 0 0 0)
			)
		)
	)
)

(instance openDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom newRoom: 115)
			)
		)
	)
)

(instance theSign of Feature
	(properties
		noun 6
		nsLeft 134
		nsTop 81
		nsRight 158
		nsBottom 123
		sightAngle 40
		x 146
		y 102
	)
)

(instance leftWindow of Feature
	(properties
		noun 7
		nsLeft 37
		nsTop 62
		nsRight 93
		nsBottom 102
		sightAngle 40
		x 65
		y 82
	)
)

(instance rightWindow of Feature
	(properties
		noun 8
		nsLeft 213
		nsTop 61
		nsRight 243
		nsBottom 104
		sightAngle 90
		x 228
		y 84
	)
)

(instance awning of Feature
	(properties
		noun 14
		sightAngle 40
		x 162
		y 38
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 1 4 2) ; Look, Do, Talk
			(super doVerb: theVerb)
		else
			(gMessager say: 0 theVerb 0 0 0 0)
		)
	)

	(method (init)
		(self
			createPoly:
				91
				35
				248
				24
				248
				38
				236
				38
				231
				41
				148
				48
				132
				48
				80
				49
				77
				52
				65
				53
				71
				45
		)
		(super init:)
	)
)

(instance fence of Feature
	(properties
		noun 12
		nsTop 63
		nsRight 11
		nsBottom 117
		sightAngle 40
		x 5
		y 90
	)
)

(instance lotterySign of Feature
	(properties
		noun 13
		nsLeft 201
		nsTop 56
		nsRight 278
		nsBottom 71
		sightAngle 40
		x 235
		y 65
	)
)

(instance sidewalk of Feature
	(properties
		noun 11
		sightAngle 359
		x 19
		y 120
	)

	(method (init)
		(self
			createPoly:
				0
				118
				194
				128
				289
				130
				319
				126
				319
				142
				269
				152
				170
				152
				1
				136
		)
		(super init:)
	)
)

(instance sky of Feature
	(properties
		noun 15
		sightAngle 359
		x 160
		y 2
	)

	(method (init)
		(self createPoly: 1 10 319 10 319 22 270 20 41 36 2 24)
		(super init:)
	)
)

(instance store of Feature
	(properties
		noun 9
		sightAngle 40
		x 265
		y 25
	)

	(method (init)
		(self
			createPoly:
				13
				39
				88
				35
				69
				44
				63
				54
				79
				53
				81
				50
				157
				49
				234
				42
				238
				39
				251
				38
				251
				23
				280
				22
				319
				24
				319
				125
				272
				129
				200
				126
				157
				125
				12
				116
		)
		(super init:)
	)
)

(instance careyTalker of Narrator
	(properties
		x 100
		y 10
	)
)

(instance spiffTalker of Narrator
	(properties
		x 160
		y 10
	)
)

(instance jackTalker of Narrator
	(properties
		x 20
		y 10
	)
)

(instance sFx of Sound
	(properties)
)

