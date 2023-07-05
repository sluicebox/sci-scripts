;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 850)
(include sci.sh)
(use Main)
(use TellerIcon)
(use Talker)
(use Scaler)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm850 0
	girlFriend 1
)

(local
	local0
	local1 = 1
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
)

(instance rm850 of Room
	(properties
		picture 850
	)

	(method (init)
		(gGame handsOff:)
		(gPqFlags clear: 28)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 44 82 162 127 212 132 204 125 166 123 156 120 48 79
					yourself:
				)
		)
		(window850 init:)
		(table init:)
		(couch init:)
		(record2 init:)
		(record1 init:)
		(tv init:)
		(ashtray init: approachVerbs: 4) ; Do
		(gEgo
			setHeading: 135
			normalize: 0
			x: 40
			y: 89
			setScaler: Scaler 106 68 135 77
			init:
		)
		(legs init: hide:)
		(gGlobalSound1 number: 840 setLoop: -1 play:)
		(gGlobalSound0 fade: 0 4 1 1)
		(door init: approachVerbs: 4) ; Do
		(girlie init:)
		(danny init:)
		(yoBaby init:)
		(self setScript: sEnter)
	)

	(method (doit)
		(super doit:)
		(if (and local10 (< (gEgo x:) 50))
			(gCurRoom newRoom: 860)
		)
	)
)

(instance tv of Feature
	(properties
		noun 10
		nsLeft 255
		nsTop 61
		nsRight 263
		nsBottom 70
		sightAngle 40
		approachX 259
		approachY 65
		approachDist 0
		x 259
		y 65
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 249 49 265 49 273 57 273 85 248 81
					yourself:
				)
		)
		(super init:)
	)
)

(instance record1 of Feature
	(properties
		noun 8
		nsLeft 103
		nsTop 19
		nsRight 116
		nsBottom 39
		sightAngle 40
		approachX 109
		approachY 29
		approachDist 0
		x 109
		y 29
	)
)

(instance record2 of Feature
	(properties
		noun 9
		nsLeft 118
		nsTop 28
		nsRight 129
		nsBottom 48
		sightAngle 40
		approachX 123
		approachY 38
		approachDist 0
		x 123
		y 38
	)
)

(instance couch of Feature
	(properties
		noun 12
		nsLeft 80
		nsTop 113
		nsRight 94
		nsBottom 123
		sightAngle 40
		approachX 87
		approachY 118
		approachDist 0
		x 87
		y 118
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 26 90 31 90 42 81 50 82 53 81 59 84 59 76 69 79 72 79 73 75 85 76 94 71 96 77 103 77 107 90 133 95 134 101 140 102 140 128 128 136 25 136
					yourself:
				)
		)
		(super init:)
	)
)

(instance table of Feature
	(properties
		noun 13
		nsLeft 178
		nsTop 120
		nsRight 195
		nsBottom 129
		sightAngle 40
		approachX 186
		approachY 124
		approachDist 0
		x 186
		y 124
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 138 135 138 130 166 106 232 115 231 135
					yourself:
				)
		)
		(super init:)
	)
)

(instance window850 of Feature
	(properties
		noun 11
		nsLeft 181
		nsTop 37
		nsRight 188
		nsBottom 51
		sightAngle 40
		approachX 184
		approachY 44
		approachDist 0
		x 184
		y 44
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 135 11 140 7 235 7 240 13 240 81 135 75
					yourself:
				)
		)
		(super init:)
	)
)

(instance girlFriend of Narrator
	(properties
		x 130
		y 10
		talkWidth 150
	)
)

(instance door of Feature
	(properties
		noun 1
		nsLeft 31
		nsTop 17
		nsRight 72
		nsBottom 78
		sightAngle 40
		approachX 30
		approachY 48
		approachDist 52
		x 30
		y 48
	)
)

(instance girlie of Prop
	(properties
		noun 5
		sightAngle 10
		x 241
		y 133
		priority 12
		view 856
	)

	(method (init)
		(|= signal $5000)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(switch local4
					(0
						(++ local4)
						(gMessager say: 5 2 6) ; "Please, calm down, Miss. I'm here to discuss the situation."
					)
					(1
						(++ local4)
						(gMessager say: 5 2 13) ; "I'd like to start by asking a few questions..."
					)
					(2
						(gMessager say: 5 2 14) ; "I'd like to ask..."
					)
					(else
						(= local4 2)
						(gMessager say: 5 2 18) ; "I couldn't help but notice the unwanted phone call..."
					)
				)
			)
			(31 ; shoe
				(gGame points: 3 94)
				(gPqFlags set: 92)
				(super doVerb: theVerb)
			)
			(22 ; handgun
				(if local8
					((ScriptID 32 0) doit:) ; ShootHandgun
				else
					(super doVerb: theVerb)
					(= local8 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance moneyTell of Teller
	(properties)

	(method (showCases)
		(super showCases: 10 (== gDay 3))
	)

	(method (sayMessage)
		(if (== iconValue 10)
			(gGame points: 3 96)
			(gPqFlags set: 139)
		)
		(if (== iconValue 11)
			(gGame points: 3 97)
			(gPqFlags set: 161)
		)
		(super sayMessage:)
	)

	(method (doVerb theVerb)
		(cond
			((!= theVerb 2) ; Talk
				(client doVerb: theVerb)
			)
			(local11
				(= local11 0)
				(gMessager say: 4 theVerb 18 0)
			)
			((gPqFlags test: 161)
				(gMessager say: 4 theVerb 23 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance yoBaby of Prop
	(properties
		noun 4
		sightAngle 10
		x 143
		y 119
		priority 150
		fixPriority 1
		view 8514
	)

	(method (init)
		(|= signal $5000)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(gMessager say: 4 2 7) ; "I'm Detective John Carey, LAPD, Homicide."
				(moneyTell init: self 850 7 5)
			)
			(22 ; handgun
				(if local7
					((ScriptID 32 0) doit:) ; ShootHandgun
				else
					(super doVerb: theVerb)
					(= local7 1)
				)
			)
			(31 ; shoe
				(gGame points: 3 95)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance danny of Actor
	(properties
		noun 3
		sightAngle 10
		x 31
		y 81
		view 850
		origStep 257
	)

	(method (init)
		(|= signal $4000)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(22 ; handgun
				(if local6
					((ScriptID 32 0) doit:) ; ShootHandgun
				else
					(super doVerb: theVerb)
					(= local6 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ashtray of Feature
	(properties
		noun 2
		nsLeft 205
		nsTop 113
		nsRight 217
		nsBottom 118
		sightAngle 40
		approachX 212
		approachY 132
		approachDist 0
		x 211
		y 140
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (or local1 (gEgo has: 19)) ; cigarette
					(super doVerb: theVerb)
				else
					(gEgo setScript: getButt)
				)
			)
			(1 ; Look
				(if local2
					(gMessager say: 2 1 1) ; MISSING MESSAGE
				else
					(gMessager say: 2 1 2) ; "The ashtray is full of half-smoked, lipstick"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance caught of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(danny
					view: 851
					loop: 0
					setMotion: MoveTo (+ (danny x:) 40) (danny y:) self
				)
			)
			(1
				(gMessager say: 3 2 3 0 self) ; "Hey! What the hell are ya doing!"
			)
			(2
				(gPqFlags set: 28)
				(gCurRoom newRoom: 860)
			)
		)
	)
)

(instance forcedLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 3 2 4 0 self) ; "Hey! Ya heard the man, it's time to leave! Let's go!"
			)
			(1
				(danny
					view: 851
					loop: 0
					setMotion: MoveTo (+ (danny x:) 40) (danny y:) self
				)
			)
			(2
				(gPqFlags set: 28)
				(gCurRoom newRoom: 860)
			)
		)
	)
)

(instance getButt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGame handsOff:)
				(gEgo
					view: 9850
					x: (- (gEgo x:) 2)
					y: (+ (gEgo y:) 2)
					setLoop: 1 1
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(1
				1
				(gGame points: 4 93)
				(butt dispose:)
				(gEgo get: 19 setCycle: End self) ; cigarette
			)
			(2
				2
				(gEgo loop: 0 cel: 0 setCycle: End self)
			)
			(3
				3
				(gEgo setCycle: Beg self)
			)
			(4
				4
				(gEgo
					x: (+ (gEgo x:) 2)
					y: (- (gEgo y:) 2)
					normalize: 0
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and local1 (< state 3))
			(danny setScript: caught)
			(self dispose:)
		)
	)
)

(instance yell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(girlFriend modeless: 2)
				(if (gPqFlags test: 37)
					(self setScript: yak 0 25)
				else
					(gPqFlags set: 37)
					(self setScript: yak 0 12)
				)
				(girlie loop: 1 cel: 0 setCycle: End self)
			)
			(1
				(girlie view: 857 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(girlie loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(girlie view: 8503 loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(if script
					(script caller: self)
				else
					(self cue:)
				)
			)
			(5
				(girlie view: 858 loop: 0 cel: 0 y: 132 setCycle: End self)
			)
			(6
				(butt init:)
				(girlie loop: 1 cel: 0 setCycle: End self)
			)
			(7
				(girlFriend modeless: 1)
				(sEnter seconds: 25)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance legs of View
	(properties
		x 200
		y 114
		view 8501
		loop 3
	)

	(method (init)
		(|= signal $4000)
		(super init:)
	)
)

(instance butt of View
	(properties
		x 213
		y 114
		priority 200
		fixPriority 1
		view 858
		loop 2
	)

	(method (init)
		(|= signal $4000)
		(super init:)
	)

	(method (onMe)
		(return 0)
	)
)

(instance ringer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sFx1 number: 937 setLoop: 1 1 play: self)
			)
			(1
				(= ticks 200)
			)
			(2
				(self init:)
			)
		)
	)

	(method (dispose)
		(sFx1 stop:)
		(super dispose:)
	)
)

(instance badLoc of Feature
	(properties
		nsLeft 121
		nsTop 91
		nsRight 152
		nsBottom 124
		sightAngle 40
		approachX 136
		approachY 107
		x 136
		y 107
	)
)

(instance moveEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 179 123 self)
			)
			(1
				(gGame handsOn:)
			)
		)
	)
)

(instance goToPhone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(= local0 0)
				(if (badLoc onMe: gEgo)
					(self setScript: moveEgo)
				)
				(yoBaby setCycle: End self)
			)
			(2
				(= local1 0)
				(yoBaby view: 8515 loop: 0 cel: 0 setPri: 100 1)
				(if register
					(yoBaby setCycle: End self)
				else
					(yoBaby setCycle: End)
				)
			)
			(3
				(= local1 1)
				(yoBaby
					view: 8516
					loop: 0
					cel: 0
					x: 155
					y: 120
					setCycle: End self
				)
			)
			(4
				(yoBaby view: 8517 loop: 0 cel: 0 setPri: 99 setCycle: End self)
			)
			(5
				(= local0 1)
				(self dispose:)
			)
		)
	)
)

(instance yak of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(girlFriend modeless: 2)
				(gMessager say: 5 2 register 0 self)
			)
			(1
				(girlFriend modeless: 1)
				(= local9 1)
				(self dispose:)
			)
		)
	)
)

(instance doPhone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(yoBaby setScript: goToPhone)
				(self setScript: ringer)
				(= local3 1)
				(= ticks 60)
			)
			(1
				1
				(girlie
					view: 859
					loop: 0
					cel: 0
					x: 220
					y: 133
					fixPriority: 1
					priority: 112
					setCycle: End self
				)
			)
			(2
				2
				(girlie loop: 1 cel: 0 setCycle: End self)
			)
			(3
				3
				(self setScript: 0)
				(girlie loop: 2 cel: 0 setCycle: End self)
				(= register 5)
			)
			(4
				4
				(if (== register 5)
					(self setScript: yak 0 15)
					(= local11 1)
				)
				(legs show:)
				(girlie
					view: 8501
					loop: 0
					cel: 0
					x: 200
					y: 114
					setCycle: End self
				)
				(if local9
					(= state 6)
				)
			)
			(5
				5
				(if (not local9)
					(-- register)
					(= state 3)
				)
				(girlie setCycle: Beg self)
			)
			(6
				6
				(girlie setCycle: End self)
			)
			(7
				7
				(= local9 0)
				(girlie loop: 1 cel: 0 setCycle: End self)
			)
			(8
				8
				(if (== (goToPhone state:) 2)
					(goToPhone cue:)
				else
					(goToPhone register: 1)
				)
				(girlie view: 8502 loop: 0 cel: 0 setCycle: End self)
				(legs hide:)
			)
			(9
				9
				(girlie loop: 1 cel: 0 setCycle: End self)
			)
			(10
				10
				(girlie loop: 2 cel: 0 setCycle: End self)
			)
			(11
				11
				(if (== local3 3)
					(gMessager say: 4 2 5) ; "Later man... I got business to tend to..."
				)
				(= local4 10)
				(= seconds 30)
			)
			(12
				12
				(if (< local3 3)
					(++ local3)
					(self setScript: ringer)
					(= ticks 240)
				else
					(self setScript: forcedLeave)
					(gPqFlags set: 103)
				)
			)
			(13
				13
				(girlie setCycle: Beg self)
			)
			(14
				14
				(girlie loop: 1)
				(girlie cel: (girlie lastCel:) setCycle: Beg self)
				(self setScript: 0)
			)
			(15
				(girlie loop: 0)
				(girlie cel: (girlie lastCel:) setCycle: Beg self)
				(legs show:)
			)
			(16
				(girlie view: 8501 loop: 0)
				(girlie cel: (girlie lastCel:) setCycle: Beg self)
			)
			(17
				(switch local3
					(2
						(= local11 1)
						(self setScript: yak 0 16)
					)
					(3
						(= local11 1)
						(self setScript: yak 0 17)
					)
				)
				(= local9 0)
				(= cycles 1)
				(= register 3)
				(= state 3)
			)
		)
	)
)

(instance smoke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(girlie setCycle: End self)
			)
			(1
				(if register
					(self cue:)
				else
					(= ticks (Random 30 180))
				)
			)
			(2
				(girlie setCycle: Beg self)
			)
			(3
				(if register
					(self cue:)
				else
					(= ticks (Random 240 480))
				)
			)
			(4
				(if register
					(client setScript: yell)
				else
					(self init:)
				)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState &tmp [temp0 3])
		(switch (= state newState)
			(0
				(danny setCycle: End)
				(girlie setScript: smoke)
				(gEgo setMotion: MoveTo 179 123 self)
			)
			(1
				(danny setSpeed: 9 setCycle: Walk)
				(danny setScript: pace)
				(if (or (gPqFlags test: 103) (gEgo has: 19)) ; cigarette
					(= local4 2)
					(= local0 1)
					(gGame handsOn:)
					(self dispose:)
				else
					(if (smoke ticks:)
						(smoke ticks: 1)
					)
					(smoke register: 1)
				)
				(= local10 1)
			)
			(2
				(girlie setScript: doPhone)
				(self dispose:)
			)
		)
	)
)

(instance pace of Script
	(properties)

	(method (init param1 param2)
		(= lastTicks gGameTime)
		(if (>= argc 1)
			((= client param1) script: self)
			(if (>= argc 2)
				(= caller param2)
			)
		)
		(= state (- start 1))
		(if (not register)
			(= register 1)
		else
			(= register (Random 1 2))
			(if (== register 1)
				(danny x: 8 y: 83)
			else
				(danny x: 4 y: 103)
			)
		)
		(self cue:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (yoBaby script:) (== ((yoBaby script:) state:) 1))
					(= local1 1)
				)
				(if (== register 1)
					(danny
						view: 851
						setLoop: 0 1
						cel: 0
						setMotion: MoveTo 44 88 self
					)
				else
					(danny
						view: 853
						setLoop: 1 1
						cel: 0
						setMotion: MoveTo 44 88 self
					)
				)
			)
			(1
				(if (and (yoBaby script:) (== ((yoBaby script:) state:) 1))
					(= local1 0)
				)
				(if (== register 1)
					(danny
						view: 853
						setLoop: 0 1
						cel: 0
						setMotion: MoveTo 4 103 self
					)
				else
					(danny
						view: 851
						setLoop: 1 1
						cel: 0
						setMotion: MoveTo 8 83 self
					)
				)
			)
			(2
				(= seconds (Random 10 20))
			)
			(3
				(self init:)
			)
		)
	)
)

(instance sFx1 of Sound
	(properties)
)

