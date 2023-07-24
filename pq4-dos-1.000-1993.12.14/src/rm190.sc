;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 190)
(include sci.sh)
(use Main)
(use TellerIcon)
(use Talker)
(use Scaler)
(use RandCycle)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm190 0
	lasondraTalker 1
	momTalker 2
)

(local
	local0
	[local1 2]
	local3
	local4
	local5
	local6
	local7
)

(instance rm190 of Room
	(properties
		picture 190
	)

	(method (init)
		(proc0_4 1)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 1 152 222 152 225 148 219 138 163 138 155 141 125 141 109 144 62 142 51 131 26 131 1 134 0 143
					yourself:
				)
		)
		(super init: &rest)
		(switch gPrevRoomNum
			(180
				(gEgo setHeading: 90 posn: 20 140)
			)
			(else
				(gEgo setHeading: 90 posn: 20 140)
			)
		)
		(gEgo setTalker: careyTalker setScaler: Scaler 70 56 140 112 init:)
		(if (and (< gDay 4) (gPqPointFlags test: 11))
			(if (gPqFlags test: 38)
				(lasondra
					init:
					setCycle: Fwd
					signal: (| (lasondra signal:) $4000)
				)
				(lasondra init: approachVerbs: 2) ; Talk
				(lasondraTeller init: lasondra 190)
			)
			(momHead
				init:
				signal: (| (momHead signal:) $4000)
				approachVerbs: 2 5 27 11 ; Talk, ???, badge, washStuff
			)
			(if (== gDay 2)
				(momTeller init: momHead 190)
			)
			(momBody
				init:
				actions: (momHead actions:)
				signal: (| (momBody signal:) $4000)
				approachVerbs: 2 5 27 11 ; Talk, ???, badge, washStuff
			)
		)
		(musicScript init:)
		(gEgo normalize: 0)
		(if (and (== gDay 2) (not global142))
			(= global142 1)
			(exSpiff
				setCycle: Walk
				init:
				signal: (| (exSpiff signal:) $0800)
				setScript: spiffOutScript
			)
		else
			(gGame handsOn:)
		)
		(door init:)
		(house init:)
		(car init:)
		(fence init:)
		(yard init:)
		(tree init:)
		(pole init:)
	)

	(method (doit)
		(super doit:)
		(cond
			((self script:) 0)
			((< (gEgo x:) 20)
				(gGlobalSound0 stop:)
				(self newRoom: 180)
			)
			((> (gEgo x:) 221)
				(gEgo x: 220 setMotion: 0)
				(gMessager say: 0 76 0) ; "Don't wander off. You're on assignment."
			)
			((> (gEgo y:) 151)
				(gEgo y: 150 setMotion: 0)
				(gMessager say: 0 77 0) ; "Walking out in traffic can produce one flat detective!"
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
		(gTheDoits delete: self)
		(super dispose: &rest)
	)

	(method (cue)
		(self changeState: (+ state 1) &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 120)
			)
			(1
				(if (== (gGlobalSound0 prevSignal:) 1)
					(= cycles 2)
				else
					(gGlobalSound1
						number: (if (Random 0 1) 906 else 907)
						loop: 1
						play: self
					)
				)
			)
			(2
				(= state 0)
				(= seconds (Random 5 10))
			)
		)
	)
)

(instance altEgo of Actor
	(properties)
)

(instance spiffOutScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(exSpiff setMotion: MoveTo 347 156 self)
			)
			(1
				(gGame handsOn:)
				(exSpiff dispose:)
			)
		)
	)
)

(instance exSpiff of Actor
	(properties
		x 233
		y 156
		view 195
		loop 1
	)
)

(instance lasondra of Actor
	(properties
		heading 225
		noun 3
		sightAngle 40
		approachX 121
		approachY 145
		approachDist 9
		x 143
		y 139
		view 194
	)

	(method (doVerb theVerb)
		(switch theVerb
			(52 ; notebook
				(if (gPqPointFlags test: 32)
					(gMessager say: noun theVerb 5) ; "The information about the woman in red might"
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lasondraTeller of Teller
	(properties
		sayNoun 5
		verb 5
	)

	(method (doVerb theVerb)
		(cond
			((and (or (== theVerb 2) (== theVerb 5)) (not (gPqPointFlags test: 16))) ; Talk, ???
				(gMessager say: 3 2 1) ; "Hello..."
			)
			((and (or (== theVerb 2) (== theVerb 5)) (not local6)) ; Talk, ???
				(= local6 1)
				(gMessager say: 3 2 5) ; "Hello LaSondra."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (sayMessage)
		(switch iconValue
			(5
				(if (not (gPqPointFlags test: 42))
					(gGame points: 2 42)
				)
				(gPqPointFlags set: 32)
			)
			(8
				(if (not (gPqPointFlags test: 43))
					(gGame points: 2 43)
				)
			)
			(9
				(if (not (gPqPointFlags test: 44))
					(gGame points: 2 44)
				)
			)
		)
		(super sayMessage:)
	)
)

(instance egoLegs of Prop
	(properties
		view 9007
		loop 2
	)
)

(instance momBody of Prop
	(properties
		noun 2
		approachX 73
		approachY 145
		approachDist 10
		x 102
		y 130
		priority 5
		view 190
	)

	(method (doVerb theVerb)
		(momHead doVerb: theVerb &rest)
	)

	(method (dispose)
		(self actions: 0)
		(super dispose:)
	)
)

(instance raiseHeadScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 120)
			)
			(1
				(momHead setCycle: End self)
			)
			(2
				(= local0 1)
				(momHead view: 191 loop: 1 cel: 0 x: 95 y: 112)
				(momBody view: 191 loop: 0 cel: 0)
				(= ticks 90)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance showBadgeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 38 0) init: self) ; BadgeOut
			)
			(1
				(gPqPointFlags set: 16)
				(if (< local0 1)
					(self setScript: raiseHeadScript self)
				else
					(= ticks 90)
				)
			)
			(2
				((ScriptID 38 1) init: self) ; BadgeIn
			)
			(3
				(gMessager say: 2 27 4 0 self) ; "I'm Detective Carey, LAPD, Homicide. May I have a moment of your time?"
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance effectsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 45 self)
			)
			(1
				(if (< local0 1)
					(self setScript: raiseHeadScript self 1)
				else
					(= cycles 2)
				)
			)
			(2
				(gEgo view: 9033 setLoop: 1 cel: 0 setCycle: CT 6 1 self)
			)
			(3
				(= cycles 2)
			)
			(4
				(momHead setCycle: CT 7 1 self)
			)
			(5
				(if (not (gPqPointFlags test: 16))
					(gMessager say: 2 11 1 0 self) ; "Are you from the Coroner's office?"
				else
					(gMessager say: 2 11 3 0 self) ; "Mrs. Washington, these are the items found on Bobby's person the night he was killed. I'm so sorry, ma'am."
				)
			)
			(6
				(= cycles 2)
			)
			(7
				(gEgo put: 40) ; washStuff
				((gInventory at: 40) owner: gCurRoomNum) ; washStuff
				(gPqPointFlags set: 12)
				(= local0 2)
				(momHead setCycle: End)
				(gEgo setCycle: Beg self)
			)
			(8
				(gEgo normalize: 0)
				(= cycles 10)
			)
			(9
				(momHead loop: 2 cel: 0 setCycle: End self)
			)
			(10
				(= ticks 120)
			)
			(11
				(momHead loop: 3 cel: 0 setCycle: End self)
			)
			(12
				(momHead loop: 4 cel: 0 setCycle: End self)
			)
			(13
				(momHead loop: 5 cel: 0 setCycle: RandCycle 12 self)
			)
			(14
				(momHead loop: 4 cel: 0)
				(momHead cel: (momHead lastCel:) setCycle: Beg self)
			)
			(15
				(= ticks 90)
			)
			(16
				(momHead loop: 4 cel: 0 setCycle: End self)
			)
			(17
				(momHead loop: 5 cel: 0 setCycle: RandCycle 18 self)
			)
			(18
				(= ticks 90)
			)
			(19
				(momHead loop: 5 cel: 0 setCycle: ForwardCounter 3 self)
			)
			(20
				(= ticks 120)
			)
			(21
				(momHead loop: 4)
				(momHead cel: (momHead lastCel:) setCycle: Beg self)
			)
			(22
				(= ticks 45)
			)
			(23
				(momHead view: 190 loop: 0 cel: 1 x: 102 y: 130)
				(momBody dispose:)
				(gGame handsOn:)
				(= local3 0)
				(self dispose:)
			)
		)
	)
)

(instance momHead of Prop
	(properties
		noun 2
		approachX 73
		approachY 145
		approachDist 10
		x 101
		y 95
		priority 6
		view 190
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; ammoBaggie
				(if (not (gPqPointFlags test: 16))
					(gMessager say: noun theVerb 1) ; "Are you some kind of sick-o? Get going before I call the police!"
				else
					(gMessager say: noun theVerb 0) ; "I've seen enough violence, I don't need to see any more bullets!"
				)
			)
			(19 ; apple
				(if (not (gPqPointFlags test: 16))
					(gMessager say: noun theVerb 1) ; "Are you from some church or something? I don't recognize you."
				else
					(super doVerb: theVerb)
				)
			)
			(74 ; candyBar
				(if (not (gPqPointFlags test: 16))
					(gMessager say: noun theVerb 1) ; "I'm not buying any candy today. I don't care what it's for."
				else
					(gMessager say: noun theVerb 3) ; "My childre.., my child, does not need your special treatment. We're doing just fine without charity."
				)
			)
			(29 ; coins
				(if (not (gPqPointFlags test: 16))
					(gMessager say: noun theVerb 1) ; "I'm telling you, mister, get lost!"
				else
					(gMessager say: noun theVerb 3) ; "Don't insult me, Detective. I work hard, and my family doesn't need any handouts."
				)
			)
			(73 ; crimeSceneReport
				(if (not (gPqPointFlags test: 16))
					(gMessager say: noun theVerb 1) ; "I don't want to look at your literature...get going, move on before I call the cops!"
				else
					(gMessager say: noun theVerb 3) ; "You must have me confused with your secretary."
				)
			)
			(4 ; Do
				(if (not (gPqPointFlags test: 16))
					(gMessager say: noun theVerb 1) ; "Hey mister! Knock that off! I'll call the cops!"
				else
					(gMessager say: noun theVerb 3) ; "I don't need your comfort, sir!"
				)
			)
			(12 ; evidenceCase
				(if (not (gPqPointFlags test: 16))
					(gMessager say: noun theVerb 1) ; "I don't care what you're selling, I don't want any."
				else
					(gMessager say: noun theVerb 3) ; "You'll be needing your kit on this case, Carey. Don't give it away."
				)
			)
			(67 ; actionReports
				(if (not (gPqPointFlags test: 16))
					(gMessager say: noun theVerb 1) ; "I don't want to read your literature. I have my own faith and beliefs... go on now, git!""
				else
					(gMessager say: noun theVerb 3) ; "What do you want me to do, fill those out or something?"
				)
			)
			(17 ; glue
				(if (not (gPqPointFlags test: 16))
					(gMessager say: noun theVerb 1) ; "Drug pusher! Git on out of here. I'll call the cops... We don't need any glue sniffing on this block! Go on now, git!"
				else
					(gMessager say: noun theVerb 3) ; "I don't need anything fixed but a broken heart, Detective. You can keep your glue."
				)
			)
			(66 ; parkerID
				(if (not (gPqPointFlags test: 16))
					(gMessager say: noun theVerb 1) ; "Look, mister, I'm not interested in what you've got there... go on, git!"
				else
					(gMessager say: noun theVerb 3) ; "You take a nice picture, Detective."
				)
			)
			(15 ; vest
				(if (not (gPqPointFlags test: 16))
					(gMessager say: noun theVerb 1) ; "This is life insurance, Carey. Don't give it away!"
				else
					(gMessager say: noun theVerb 3) ; "You officers need those nowadays. You need to protect yourselves."
				)
			)
			(20 ; wallet
				(if (not (gPqPointFlags test: 16))
					(gMessager say: noun theVerb 1) ; "Look, mister, I'm a churchgoing woman! Get lost before I call the police!"
				else
					(super doVerb: theVerb)
				)
			)
			(2 ; Talk
				(cond
					((and (not (gPqPointFlags test: 16)) (not (gPqPointFlags test: 12)))
						(gMessager say: 2 2 1 0) ; "Hello, I'm..."
					)
					(
						(and
							(== gDay 2)
							(gPqFlags test: 45)
							(gPqFlags test: 162)
						)
						(= local7 1)
						(gMessager say: noun theVerb 11 0) ; "Mrs. Washington, if there's anything the department, or I, can do, please call."
					)
					(
						(and
							(== gDay 2)
							(gPqFlags test: 45)
							(not (gPqFlags test: 162))
						)
						(gPqFlags set: 162)
						(gMessager say: noun theVerb 10 0) ; "Mrs. Washington, I have reason to believe that a young man by the name of Ragtopp Spiff might be involved with your son's murder. Does his name sound familiar?"
					)
					((and (== gDay 3) (gPqPointFlags test: 12) (== local5 1))
						(gMessager say: noun theVerb 19 0) ; "How are you today, Mrs. Washington?"
					)
					((and (== gDay 3) (gPqPointFlags test: 12))
						(= local5 1)
						(gMessager say: 2 2 2 0) ; "Hello, Mrs. Washington."
					)
					((and (== gDay 2) (gPqPointFlags test: 16) (not local4))
						(= local4 1)
						(gMessager say: 2 2 12 0) ; "I'm here investigating the murder of your son and Officer Hickman. I'd like to ask you a few questions."
					)
					((not (gPqPointFlags test: 16))
						(gMessager say: 2 2 14 0) ; "I'm Detective John Carey, Mrs. Washington. I'm sorry about your boy."
					)
					((== gDay 3)
						(gMessager say: noun theVerb 19 0) ; "How are you today, Mrs. Washington?"
					)
					(else
						(gMessager say: 2 2 15 0) ; "What is it you need to know, Detective?"
					)
				)
			)
			(27 ; badge
				(if (not (gPqPointFlags test: 16))
					(gGame points: 2 16)
					(gCurRoom setScript: showBadgeScript)
				else
					(gMessager say: 2 27 3 0) ; "She's an intelligent woman, Carey. She remembers who you are."
				)
			)
			(11 ; washStuff
				(= local3 1)
				(gGlobalSound1 stop:)
				(gGlobalSound0 prevSignal: 1)
				(gGlobalSound0 number: 790 loop: 1 play: musicScript)
				(gGame points: 3)
				(gCurRoom setScript: effectsScript)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance momTeller of Teller
	(properties
		sayNoun 4
		verb 5
	)

	(method (doVerb)
		(if
			(and
				(gPqPointFlags test: 16)
				(or (and (== gDay 2) local7) local4 local5)
			)
			(super doVerb: &rest)
		else
			(client doVerb: &rest)
		)
	)
)

(instance door of Feature
	(properties
		noun 13
		nsLeft 128
		nsTop 63
		nsRight 150
		nsBottom 110
		sightAngle 40
		x 139
		y 86
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (or (gCast contains: momHead) (gCast contains: momBody))
					(gMessager say: 13 4 0 0) ; "Why knock on the door when the resident is right in front of you?"
				else
					(gCurRoom setScript: knockScr)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance knockScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
				(gGame handsOff:)
			)
			(1
				(gEgo setMotion: MoveTo 71 142 self)
			)
			(2
				(altEgo
					view: 9210
					setLoop: 1
					cel: 0
					x: 101
					y: 128
					scaleSignal: 1
					scaleX: 87
					scaleY: 87
					init:
					signal: (| (altEgo signal:) $4800)
					setCycle: End self
				)
				(gEgo z: 1000)
			)
			(3
				(altEgo setLoop: 3 cel: 0 setCycle: End self)
			)
			(4
				(altEgo
					setLoop: 3
					cel: 0
					x: 117
					y: 115
					scaleSignal: 1
					scaleX: 80
					scaleY: 80
					setCycle: CT 8 1 self
				)
			)
			(5
				(altEgo
					setScaler: Scaler 70 56 140 112
					view: 0
					setLoop: 6
					cel: 12
					setCycle: Walk
					x: 115
					y: 117
					setMotion: MoveTo 133 116 self
				)
			)
			(6
				(altEgo view: 9008 x: 137 y: 117 setLoop: 0 cel: 0)
				(egoLegs
					setScaler: Scaler 70 56 140 112
					view: 9008
					setLoop: 1
					cel: 0
					x: (altEgo x:)
					y: (altEgo y:)
					init:
					signal: (| (egoLegs signal:) $4000)
				)
				(= ticks 30)
			)
			(7
				(altEgo
					scaleSignal: 1
					scaleX: 80
					scaleY: 80
					setCycle: CT 5 1 self
				)
			)
			(8
				(knockSnd play:)
				(altEgo setCycle: CT 8 1 self)
			)
			(9
				(knockSnd play:)
				(altEgo setCycle: CT 10 1 self)
			)
			(10
				(knockSnd play:)
				(altEgo cel: 3 setCycle: Beg self)
			)
			(11
				(= ticks 180)
			)
			(12
				(gMessager say: 13 4 17 0 self) ; "There is no answer to your knocking."
			)
			(13
				(= cycles 2)
			)
			(14
				(egoLegs dispose:)
				(altEgo
					view: 0
					setLoop: 5
					cel: 0
					x: 133
					y: 115
					setCycle: Walk
					setMotion: MoveTo 106 111 self
				)
			)
			(15
				(altEgo
					scaleSignal: 1
					scaleX: 80
					scaleY: 80
					view: 9211
					setLoop: 1
					cel: 0
					x: 106
					y: 118
					setCycle: End self
				)
			)
			(16
				(altEgo
					scaleSignal: 1
					scaleX: 87
					scaleY: 87
					setLoop: 3
					cel: 0
					x: 107
					y: 119
					setCycle: End self
				)
			)
			(17
				(gEgo x: 71 y: 142 normalize: 0 setHeading: 225 z: 1000)
				(altEgo cel: 0 x: 98 y: 132 setCycle: End self)
			)
			(18
				(gEgo z: 0)
				(altEgo dispose:)
				(= cycles 2)
			)
			(19
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance careyTalker of Narrator
	(properties
		x 5
		y 10
	)
)

(instance lasondraTalker of Narrator
	(properties
		x 160
		y 10
	)
)

(instance momTalker of Narrator
	(properties
		x 100
		y 10
	)
)

(instance house of Feature
	(properties
		noun 1
		sightAngle 40
		x 164
		y 20
	)

	(method (init)
		(self
			createPoly: 143 0 319 74 307 74 307 98 262 98 243 114 234 117 231 127 231 133 125 134 96 140 62 138 65 129 44 128 44 69 18 65 15 60 77 21 106 28
		)
		(super init:)
	)
)

(instance car of Feature
	(properties
		noun 6
		sightAngle 40
		x 276
		y 124
	)

	(method (init)
		(self
			createPoly: 263 99 314 99 319 105 319 144 314 145 313 152 298 152 293 144 262 144 253 150 244 149 233 137 235 118
		)
		(super init:)
	)
)

(instance fence of Feature
	(properties
		noun 10
		sightAngle 40
		x 23
		y 97
	)

	(method (init)
		(self createPoly: 2 74 43 76 43 113 24 115 14 122 0 122)
		(super init:)
	)
)

(instance yard of Feature
	(properties
		noun 7
		sightAngle 40
		x 122
		y 137
	)

	(method (init)
		(self
			createPoly: 1 123 17 122 30 115 43 115 45 128 64 130 61 138 99 141 128 135 231 134 243 152 1 152
		)
		(super init:)
	)
)

(instance tree of Feature
	(properties
		noun 8
		sightAngle 40
		x 70
		y 10
	)

	(method (init)
		(self createPoly: 1 0 149 0 108 28 75 22 14 61 15 69 43 70 43 75 1 73)
		(super init:)
	)
)

(instance pole of Feature
	(properties
		noun 12
		sightAngle 40
		x 264
		y 5
	)

	(method (init)
		(self createPoly: 260 0 272 0 272 53 257 46)
		(super init:)
	)
)

(instance knockSnd of Sound
	(properties
		number 980
	)
)

