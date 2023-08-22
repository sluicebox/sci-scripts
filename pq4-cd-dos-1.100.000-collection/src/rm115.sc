;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 115)
(include sci.sh)
(use Main)
(use n030)
(use n045)
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
	rm115 0
	kimTalker 1
	bildenTalker 2
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
)

(instance rm115 of Room
	(properties
		noun 13
		picture 115
		west 130
	)

	(method (doRemap)
		(gGame doRemap: 2 253 90)
		(gGame doRemap: 2 254 75)
	)

	(method (init)
		(proc45_0)
		(proc0_4 1)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 20 132 72 132 117 152 226 152 226 147 99 135 89 113 19 114
					yourself:
				)
		)
		(super init: &rest)
		(gEgo
			x: 76
			y: 114
			setHeading: 179
			setTalker: careyTalker
			setScaler: Scaler 100 75 155 109
			normalize: 9120
			init:
		)
		(kim init: signal: (| (kim signal:) $5000) approachVerbs: 2 27 29 20) ; Talk, badge, coins, wallet
		(door init: approachVerbs: 4) ; Do
		(tv init:)
		(liquor init:)
		(theWindow init:)
		(glueRack init: approachVerbs: 4 1) ; Do, Look
		(rightRack init: approachVerbs: 4 1) ; Do, Look
		(chipRack init: approachVerbs: 4 1) ; Do, Look
		(theApple init:)
		(cashRegister init:)
		(counter init:)
		(paper0 init:)
		(paper1 init:)
		(paper2 init:)
		(musicScript init:)
		(if (not (gPqFlags test: 47))
			(gGame handsOff:)
			(gPqFlags set: 47)
			(self setScript: firstTimeScr)
		else
			(gGame handsOn:)
			(self setScript: nextTimeScr)
		)
	)

	(method (cue)
		(gGame handsOn:)
	)
)

(instance tvScreen of Prop
	(properties
		x 225
		y 22
		view 1156
		loop 4
		cel 10
	)

	(method (doVerb theVerb)
		(tv doVerb: theVerb)
	)
)

(instance firstTimeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tvScreen init: hide:)
				(kim setCycle: End self)
				(gEgo
					setMotion: PolyPath (kim approachX:) (kim approachY:) self
				)
			)
			(1 0)
			(2
				(Face gEgo kim self)
			)
			(3
				(= cycles 2)
			)
			(4
				(gMessager say: 1 2 1 1 self) ; "I'm Detective Carey with the LAPD."
			)
			(5
				(gMessager say: 1 2 1 2 self) ; "Everybody know who you are. You big cop, bring big trouble."
			)
			(6
				(tvScreen show: cycleSpeed: 12 setCycle: Beg self)
			)
			(7
				(tvStinger play:)
				(tvScreen cycleSpeed: 6 setLoop: 0 cel: 0)
				(= ticks 60)
			)
			(8
				(careyTalker x: 200 y: 30)
				(tvScreen setCycle: End self)
			)
			(9
				(gMessager say: 1 2 1 3 self) ; "Detective Carey, would you care to make a comment on Officer Hickman's murder?"
			)
			(10
				(tvScreen setLoop: 1 cel: 0 setCycle: End self)
			)
			(11
				(tvScreen setCycle: CT 1 -1)
				(gMessager say: 1 2 1 4 self) ; "No comment."
			)
			(12
				(= ticks 30)
			)
			(13
				(tvScreen setLoop: 2 cel: 0 cycleSpeed: 4 setCycle: CT 9 1 self)
			)
			(14
				(tvScreen setCycle: End self)
				(gMessager say: 1 2 1 5) ; "What are you doing? Hey!"
			)
			(15
				(careyTalker x: 5 y: 15)
				(tvScreen setLoop: 3 cel: 0 cycleSpeed: 6 setCycle: End self)
			)
			(16
				(= ticks 60)
			)
			(17
				(tvScreen setLoop: 4 cel: 1)
				(= cycles 2)
			)
			(18
				(tvStinger fade: 0 2 3 1)
				(tvScreen setLoop: 6 cycleSpeed: 2 setCycle: Fwd)
				(gMessager sayRange: 1 0 1 1 2 self) ; "Not too smart, big policeman. You push girl on TV."
			)
			(19
				(tvScreen setLoop: 5 cel: 0 cycleSpeed: 12 setCycle: End self)
			)
			(20
				(tvScreen hide:)
				(gMessager say: 1 0 1 3 self) ; "Yeah, yeah, you save for others, I see TV. I see you in neighborhood. You not come but for dead cop."
			)
			(21
				(kim view: 1154 setLoop: 0 cel: 0 x: (+ (kim x:) 10))
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance nextTimeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(kim setCycle: End self)
			)
			(1
				(kim view: 1154 setLoop: 0 cel: 0 x: (+ (kim x:) 10))
				(self dispose:)
			)
		)
	)
)

(instance theApple of Feature
	(properties
		noun 11
		x 148
		y 110
	)

	(method (init)
		(self
			createPoly: 143 78 151 78 156 71 153 71 151 70 144 70 144 71 140 71 140 73
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 1) ; Do, Look
			(gCurRoom setScript: appleScr 0 theVerb)
		else
			(super doVerb: theVerb)
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
		(gGlobalSound0 client: 0)
		(super dispose: &rest)
		(gTheDoits delete: self)
	)

	(method (cue)
		(self changeState: (+ state 1) &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound0 fade: 0 3 5 1 self)
			)
			(1
				(gGlobalSound1 number: 520 loop: -1 play: setVol: 95)
				(self dispose:)
			)
		)
	)
)

(instance badgeKimScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion:
						PolyPath
						(- (kim approachX:) 20)
						(kim approachY:)
						self
				)
			)
			(1
				(gEgo setHeading: 5 self)
			)
			(2
				(gEgo view: 9126 setLoop: 3 cel: 0 setCycle: End self)
			)
			(3
				(gMessager say: 1 27 0 1 self) ; "I know you a cop."
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo normalize: 9120)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance door of Feature
	(properties
		noun 7
		nsLeft 57
		nsTop 10
		nsRight 101
		nsBottom 109
		sightAngle 40
		approachX 81
		approachY 114
		approachDist 56
		x 79
		y 59
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: exitScript)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 81 114 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(if
					(or
						(and (gEgo has: 9) (not (gPqFlags test: 49))) ; apple
						(and (gEgo has: 7) (not (gPqFlags test: 48))) ; glue
					)
					(switch (++ local0)
						(1
							(kim view: 1154 setLoop: 0 cel: 0 setCycle: CT 4 1)
							(gMessager say: 1 0 7 1) ; "You steal from me? You pay!"
							(gGame handsOn:)
							(self dispose:)
						)
						(2
							(gGame handsOff:)
							(kim setScript: stealScr)
						)
						(3
							(if (== (kim script:) stealScr)
								(stealScr cue:)
							else
								(kim setScript: stealScr)
							)
						)
					)
				else
					(gCurRoom newRoom: 110)
				)
			)
		)
	)
)

(instance tvStinger of Sound
	(properties
		number 505
		loop -1
	)
)

(instance stealStinger of Sound
	(properties
		number 111
	)
)

(instance sfx of Sound
	(properties)
)

(instance tv of Feature
	(properties
		noun 6
		nsLeft 209
		nsRight 246
		nsBottom 23
		sightAngle 40
		x 227
		y 24
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(if (= gDay 2)
				(if (not local1)
					(++ local1)
					(gMessager say: noun theVerb 1) ; "That Kristy Bilden is a real thorn in my side..."
				else
					(gMessager say: noun theVerb 2) ; "TV work with clicker, not clapper. Voice no good to turn on."
				)
			else
				(gMessager say: noun theVerb 2) ; "TV work with clicker, not clapper. Voice no good to turn on."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance liquor of Feature
	(properties
		noun 5
		nsLeft 135
		nsTop 15
		nsRight 319
		nsBottom 72
		sightAngle 40
		x 227
		y 24
	)
)

(instance theWindow of Feature
	(properties
		noun 4
		nsTop 14
		nsRight 28
		nsBottom 50
		sightAngle 40
		x 14
		y 32
	)
)

(instance glueRack of Feature
	(properties
		noun 3
		nsLeft 262
		nsTop 56
		nsRight 297
		nsBottom 153
		sightAngle 40
		approachX 232
		approachY 151
		approachDist 31
		x 279
		y 150
		z 46
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((not (gEgo has: 7)) ; glue
						(gGame handsOff:)
						(gCurRoom setScript: getGlueScr)
					)
					((not local7)
						(++ local7)
						(gMessager say: noun theVerb 4 0) ; "You drug addict?! I monitor glue... I want no police trouble. You troubled policeman! No more glue!"
					)
					(else
						(gMessager say: noun theVerb 2 0) ; "You have drug problem? You leave glue alone!"
					)
				)
			)
			(13 ; caseBaggies
				(if (not (gEgo has: 7)) ; glue
					(gMessager say: noun theVerb 3) ; "You want to buy? You bring your own bag? You one of those yuppie peoples. You drive Volvo?"
				else
					(super doVerb: theVerb &rest)
				)
			)
			(29 ; coins
				(if (not (gEgo has: 7)) ; glue
					(gMessager say: noun theVerb 3) ; "You want purchase?"
				else
					(super doVerb: theVerb &rest)
				)
			)
			(20 ; wallet
				(if (not (gEgo has: 7)) ; glue
					(gMessager say: noun theVerb 3) ; "You want, you give me money."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance getGlueScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 90 self)
			)
			(1
				(gEgo view: 9126 setLoop: 0 cel: 0 setCycle: End self)
			)
			(2
				(= seconds 2)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gGame points: 2 110)
				(gEgo normalize: 9120 get: 7) ; glue
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rightRack of Feature
	(properties
		noun 2
		nsLeft 300
		nsTop 72
		nsRight 319
		nsBottom 152
		sightAngle 40
		approachX 233
		approachY 151
		approachDist 91
		x 309
		y 112
	)
)

(instance chipRack of Feature
	(properties
		noun 8
		sightAngle 40
		approachX 120
		approachY 149
		approachDist 90
		x 47
		y 152
	)

	(method (init)
		(self createPoly: 1 54 70 49 96 114 88 120 94 132 94 151 1 152)
		(super init:)
	)
)

(instance cashRegister of Feature
	(properties
		noun 9
		x 198
		y 80
	)

	(method (init)
		(self createPoly: 183 43 216 43 217 80 185 79)
		(super init:)
	)
)

(instance counter of Feature
	(properties
		noun 10
		x 174
		y 109
	)

	(method (init)
		(self createPoly: 252 144 113 132 102 112 109 79 122 73 257 75)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if (not local5)
				(++ local5)
				(super doVerb: theVerb &rest)
			else
				(gMessager say: noun theVerb 2 0) ; "Ah... lottery tickets... Fools' gold."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance paper0 of Feature
	(properties
		noun 12
		x 116
		y 111
	)

	(method (init)
		(self createPoly: 117 104 129 106 118 114 103 112)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(switch gDay
				(2
					(if (gPqPointFlags test: 6)
						(gMessager say: noun theVerb 25 0) ; "LAPD Officer and Unidentified Youth    Found Slain in Alley!"
					else
						(gMessager say: noun theVerb 24 0) ; "Police Officer of the Year   Found Slain in Alley!"
					)
				)
				(3
					(gMessager say: noun theVerb 27 0) ; "LAPD Sting Operation Goes Down in Hail of Bullets!"
				)
				(4
					(gMessager say: noun theVerb 28 0) ; "Body Count Up to Three! Two LAPD Officers and One Unidentified Female  Found Tortured! Mutilated!"
				)
				(5
					(gMessager say: noun theVerb 26 0) ; "Serial Killer Stalks City!   Gun Sales Brisk!"
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance paper1 of Feature
	(properties
		noun 12
		x 142
		y 111
	)

	(method (init)
		(self createPoly: 141 104 157 105 157 112 146 119 126 115 128 107)
		(super init:)
	)

	(method (doVerb theVerb)
		(paper0 doVerb: theVerb &rest)
	)
)

(instance paper2 of Feature
	(properties
		noun 12
		x 186
		y 111
	)

	(method (init)
		(self createPoly: 184 109 200 111 199 116 189 123 171 120 172 114)
		(super init:)
	)

	(method (doVerb theVerb)
		(paper0 doVerb: theVerb &rest)
	)
)

(instance careyTalker of Narrator
	(properties
		x 5
		y 15
		modeless 2
	)
)

(instance kimTalker of Narrator
	(properties
		x 120
		y 5
		modeless 2
	)
)

(instance bildenTalker of Narrator
	(properties
		x 180
		y 30
		modeless 2
	)
)

(instance appleScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (or (!= (gEgo x:) 132) (!= (gEgo y:) 139))
					(gEgo setMotion: PolyPath 132 139 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(cond
					((== register 4)
						(if (or (gEgo has: 9) (gPqFlags test: 49)) ; apple
							(gMessager say: 11 register 2 0 self) ; "That apple for my friend, not for sale!"
						else
							(gEgo get: 9) ; apple
							(gGame points: 2 111)
							(gMessager say: 11 1 0 0 self) ; "Fresh fruit is a rarity in these small convenience stores."
						)
					)
					((== register 19)
						(if (not (gPqFlags test: 49))
							(gMessager say: 11 register 16 0 self) ; "You handle fruit rough! Watch out, you bruise my fruit!"
						else
							(gMessager say: 11 register 17 0 self) ; "You don't like, you put back? You buy - you keep, no refund!"
						)
					)
					(else
						(gMessager say: 11 register 0 0 self)
					)
				)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance stealScr of Script
	(properties)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((& (event type:) evMOUSERELEASE)
				(return)
			)
			((door handleEvent: event) 0)
			((event modifiers:)
				(event claimed: 0)
				(return)
			)
			(else
				(event claimed: 0)
				(return)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(stealStinger play:)
				(kim view: 1154 setLoop: 0 cel: 0 setCycle: CT 13 1 self)
			)
			(1
				(if (> local0 2)
					(= cycles 2)
				else
					(gMessager say: 1 0 7 2 self) ; "No steal!"
				)
			)
			(2
				(gEgo setHeading: 90 self)
			)
			(3
				(gMouseDownHandler addToFront: self)
				(gGame handsOn:)
			)
			(4
				(gMouseDownHandler delete: self)
				(if (>= local0 2)
					(gGame handsOff:)
					(gCurRoom setScript: 0)
					(stealStinger pause: 1)
					(kim cycleSpeed: 1 setCycle: End)
					(sfx number: 928 loop: 1 play: self)
				else
					(++ state)
					(kim setCycle: Beg self)
				)
			)
			(5
				(stealStinger pause: 0)
				(EgoDead 1 22 6 1 115) ; "The consequences of your actions are evident."
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance shootOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 90)
			)
			(1
				(gEgo
					setCycle: 0
					setLoop: 0 1
					view: 9020
					x: (- (gEgo x:) 7)
					y: (- (gEgo y:) 2)
					scaleY: (/ (* (gEgo scaleY:) 130) 100)
					scaleX: (/ (* (gEgo scaleX:) 130) 100)
					setScaler: 0
					scaleSignal: 1
				)
				(= ticks 30)
			)
			(2
				(gEgo cycleSpeed: 8 cel: 0 setCycle: CT 5 1 self)
			)
			(3
				(stealScr cue:)
				(self dispose:)
			)
		)
	)
)

(instance kim of Prop
	(properties
		noun 1
		approachX 135
		approachY 143
		approachDist 40
		x 156
		y 108
		z 28
		view 1150
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					(local0
						(gMessager say: noun theVerb 7 0) ; "She looks mad, Carey."
					)
					((== local6 0)
						(++ local6)
						(gMessager say: noun theVerb 1) ; "She doesn't look very friendly."
					)
					((== local6 1)
						(++ local6)
						(gMessager say: noun theVerb 2) ; "This woman appears quite confident and capable."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(2 ; Talk
				(cond
					(local0
						(gGame handsOff:)
						(kim setScript: 0 setCycle: Beg)
						(= local0 0)
						(gMessager say: 1 0 7 2 gCurRoom) ; "No steal!"
					)
					((== gDay 2)
						(switch local4
							(0
								(++ local4)
								(gMessager say: noun theVerb 14 0) ; "I'd like to ask you a few questions."
							)
							(1
								(++ local4)
								(gMessager say: noun theVerb 2 0) ; "You said you saw me last night... did you happen to see anything else, anything out of the ordinary, such as different people or cars in the neighborhood?"
							)
							(2
								(if (gPqFlags test: 8)
									(++ local4)
									(gMessager say: noun theVerb 18 0) ; "By the way, Ms. Chee, did you know Bobby Washington?"
								else
									(gMessager say: noun theVerb 20 0) ; "I was wondering if you'd remembered anything more about last night's events?"
								)
							)
							(3
								(++ local4)
								(gMessager say: noun theVerb 19 0) ; "Is there anything else you could tell me about Bobby, Ms. Chee?"
							)
							(else
								(gMessager say: noun theVerb 20) ; "I was wondering if you'd remembered anything more about last night's events?"
							)
						)
					)
					((== gDay 3)
						(if (not local4)
							(++ local4)
							(gMessager say: noun theVerb 10) ; "Hello. How are you today?"
						else
							(gMessager say: noun theVerb 21) ; "I'd like to ask you..."
						)
					)
					((== gDay 4)
						(if (not local4)
							(++ local4)
							(gMessager say: noun theVerb 11) ; "Good day. How are you?"
						else
							(gMessager say: noun theVerb 22) ; "Sorry to..."
						)
					)
					((== gDay 5)
						(if (not local4)
							(++ local4)
							(gMessager say: noun theVerb 12) ; "Hello..."
						else
							(gMessager say: noun theVerb 23) ; "How's business today?"
						)
					)
				)
			)
			(22 ; handgun
				(if (== script stealScr)
					(gCurRoom setScript: shootOut)
				else
					(gGame handsOff:)
					(if local0
						(kim setScript: 0 setCycle: Beg)
						(= local0 0)
					)
					(gMessager say: 1 22 0 0 gCurRoom) ; "This is an innocent citizen, Carey. Put the piece away."
				)
			)
			(57 ; photo
				(if (not local2)
					(gGame handsOff:)
					(if local0
						(kim setScript: 0 setCycle: Beg)
						(= local0 0)
					)
					(++ local2)
					(gMessager say: 1 57 1 0 gCurRoom) ; "Do you recognize the man in this picture?"
				else
					(super doVerb: theVerb &rest)
				)
			)
			(27 ; badge
				(gGame handsOff:)
				(gCurRoom setScript: badgeKimScr)
			)
			(19 ; apple
				(gGame handsOff:)
				(if local0
					(kim setScript: 0 setCycle: Beg)
					(= local0 0)
				)
				(if (gPqFlags test: 49)
					(gMessager say: noun theVerb 17 0 gCurRoom) ; "No exchange!"
				else
					(gMessager say: noun theVerb 16 0 gCurRoom) ; "You want? You pay."
				)
			)
			(17 ; glue
				(gGame handsOff:)
				(if local0
					(kim setScript: 0 setCycle: Beg)
					(= local0 0)
				)
				(if (gPqFlags test: 48)
					(gMessager say: noun theVerb 17 0 gCurRoom) ; "No return, no cash back!"
				else
					(gMessager say: noun theVerb 16 0 gCurRoom) ; "You want? You pay."
				)
			)
			(52 ; notebook
				(gGame handsOff:)
				(if local0
					(kim setScript: 0 setCycle: Beg)
					(= local0 0)
				)
				(if (not local3)
					(++ local3)
					(gGame points: 2 109)
					(gMessager say: 1 52 1 0 gCurRoom) ; "Can you tell me your name, and what your position is here?"
				else
					(gMessager say: 1 52 2 0 gCurRoom) ; "You've already recorded the information."
				)
			)
			(29 ; coins
				(cond
					(
						(or
							(and (not (gEgo has: 9)) (not (gEgo has: 7))) ; apple, glue
							(and
								(not (gEgo has: 9)) ; apple
								(gEgo has: 7) ; glue
								(gPqFlags test: 48)
							)
							(and
								(not (gEgo has: 7)) ; glue
								(gEgo has: 9) ; apple
								(gPqFlags test: 49)
							)
							(and
								(gEgo has: 9) ; apple
								(gPqFlags test: 49)
								(gEgo has: 7) ; glue
								(gPqFlags test: 48)
							)
						)
						(gMessager say: 1 29 3) ; "What you buy?"
					)
					((and (gEgo has: 7) (not (gPqFlags test: 48))) ; glue
						(gGame handsOff:)
						(if local0
							(kim setScript: 0 setCycle: Beg)
							(= local0 0)
						)
						(gMessager say: 1 29 4 0 gCurRoom) ; "You try cheat me? You pay more."
					)
					((and (gEgo has: 9) (not (gPqFlags test: 49))) ; apple
						(gGame handsOff:)
						(if local0
							(kim setScript: 0 setCycle: Beg)
							(= local0 0)
						)
						(gPqFlags set: 49)
						(gGame points: 2 112)
						(gCurRoom setScript: buySomethingScr 0 9)
					)
				)
			)
			(20 ; wallet
				(cond
					(
						(or
							(and (not (gEgo has: 9)) (not (gEgo has: 7))) ; apple, glue
							(and
								(not (gEgo has: 9)) ; apple
								(gEgo has: 7) ; glue
								(gPqFlags test: 48)
							)
							(and
								(not (gEgo has: 7)) ; glue
								(gEgo has: 9) ; apple
								(gPqFlags test: 49)
							)
							(and
								(gEgo has: 9) ; apple
								(gPqFlags test: 49)
								(gEgo has: 7) ; glue
								(gPqFlags test: 48)
							)
						)
						(gMessager say: 1 20 3) ; "No make change! What you buy?"
					)
					((and (gEgo has: 7) (not (gPqFlags test: 48))) ; glue
						(gGame handsOff:)
						(if local0
							(kim setScript: 0 setCycle: Beg)
							(= local0 0)
						)
						(gEgo get: 7) ; glue
						(gPqFlags set: 48)
						(if (and (gEgo has: 9) (not (gPqFlags test: 49))) ; apple
							(gPqFlags set: 49)
							(gGame points: 2 112)
						)
						(gGame points: 2 113)
						(gCurRoom setScript: buySomethingScr 0 7)
					)
					((and (gEgo has: 9) (not (gPqFlags test: 49))) ; apple
						(gGame handsOff:)
						(if local0
							(kim setScript: 0 setCycle: Beg)
							(= local0 0)
						)
						(gMessager say: 1 20 5 0 gCurRoom) ; "That too much, apple old, costs you less."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance buySomethingScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (gEgo distanceTo: kim) (kim approachDist:))
					(gEgo
						setMotion:
							PolyPath
							(kim approachX:)
							(kim approachY:)
							self
					)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setHeading: 5 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(if (== register 7)
					(gMessager say: 1 20 4 0 self) ; "You smart, you know a good buy when you see it. You shop here again."
				else
					(gMessager say: 1 29 5 0 self) ; "You pay fair price, fruit is good."
				)
			)
			(4
				(kim
					view: 1152
					setLoop: 0
					cel: 0
					x: (- (kim x:) 2)
					y: (- (kim y:) 2)
					setCycle: End self
				)
			)
			(5
				(kim setLoop: 1 cel: 0 x: (- (kim x:) 1) setCycle: End self)
			)
			(6
				(kim setLoop: 2 cel: 0 setCycle: End self)
			)
			(7
				(kim
					view: 1153
					setLoop: 0
					cel: 0
					x: (+ (kim x:) 1)
					y: (+ (kim y:) 1)
					setCycle: End self
				)
			)
			(8
				(kim
					view: 1154
					setLoop: 0
					cel: 0
					x: (+ (kim x:) 2)
					y: (+ (kim y:) 1)
				)
				(= local0 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

