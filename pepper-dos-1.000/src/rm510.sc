;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 510)
(include sci.sh)
(use Main)
(use BalloonTalker)
(use ADRoom)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm510 0
	guyBehindWall 1
	benBoyTalker 3
)

(local
	local0
	local1
	local2
)

(instance rm510 of ADRoom
	(properties
		noun 1
		picture 510
		horizon 75
		vanishingY -60
		autoLoad 1
	)

	(method (init)
		(super init: &rest)
		(gEgo init: normalize: x: 174 y: 136)
		(gLongSong number: 510 loop: -1 flags: 1 play:)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 105 103 139 106 166 106 165 116 160 140 141 152 101 153 94 166 35 166 32 183 259 183 219 122 185 122 188 103 304 102 303 98 94 83 96 102
					yourself:
				)
		)
		(ben init: hide:)
		(barrel1 init:)
		(barrel2 init: setOnMeCheck: 1 16384 approachVerbs: 85 7 6 86 30 89) ; Talk, Do, Look, Nose, Paw, Teeth
		(barrel3 init: setOnMeCheck: 1 8192)
		(barrel4 init:)
		(bench init: setOnMeCheck: 1 4096)
		(blueBall init:)
		(books init: setOnMeCheck: 1 2048)
		(bucket init:)
		(candles_F1 init: setOnMeCheck: 1 8)
		(candles_F2 init: setOnMeCheck: 1 8)
		(candles init: setOnMeCheck: 1 1024)
		(halfDoor init: setOnMeCheck: 1 512)
		(fireGoing setCycle: RandCycle init:)
		(fork init:)
		(furniture init:)
		(inkHorn init:)
		(lamp init: setOnMeCheck: 1 256)
		(molds init: setOnMeCheck: 1 128)
		(mold_small init: setOnMeCheck: 1 4)
		(newspaper init: setOnMeCheck: 1 64)
		(oven init: setOnMeCheck: 1 32)
		(pans init: setOnMeCheck: 1 32)
		(rags init:)
		(spoon init:)
		(table init: setOnMeCheck: 1 16)
		(trivet init:)
		(trivetPan init:)
		(wastebasket init:)
		(gCurRoom setScript: sTimeWarpIn)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script)
			((& temp0 $0002)
				(gCurRoom setScript: sDontEnter)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 85 7 6 86 30 89 84) ; Talk, Do, Look, Nose, Paw, Teeth, Trivia
				(super doVerb: theVerb &rest)
			)
			(else
				(gMessager say: 1 88) ; "That won't do Pepper or the shop any good."
			)
		)
	)

	(method (dispose)
		(gLongSong fade:)
		(super dispose:)
	)
)

(instance sTimeWarpIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo x: 173 y: 111)
				(= cycles 1)
			)
			(1
				(gMessager say: 24 0 1 1 self) ; "Later that night, after dinner with Ben and his family..."
			)
			(2
				(gEgo setMotion: PolyPath 123 140 self)
				(gMessager say: 24 0 1 2 self) ; "I'm finishing up my chores, friend. I'll be out in a moment!"
			)
			(3 0)
			(4
				(gMessager say: 24 0 1 3 self) ; "Okay, Ben!"
			)
			(5
				(benTimer setReal: benTimer 60)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTimerCue of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 0)
				(= cycles 3)
			)
			(1
				(ben
					show:
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 173 112 self
				)
			)
			(2
				(ben setMotion: PolyPath 173 112 self)
			)
			(3
				(ben stopUpd:)
				(= cycles 1)
			)
			(4
				(= gDictionaryWord 63)
				(gMessager say: 24 0 1 4 5 self) ; "Thanks again for dinner, Ben. That was really...good."
			)
			(5
				(= gDictionaryWord 63)
				(gMessager say: 24 0 1 6 self) ; "Hey, |r||c0|mush|c||r| is my favorite. Don't sweat it."
			)
			(6
				(gMessager say: 24 0 1 7 13 self) ; "'Don't sweat it'? You say things strangely, friend. But speaking of sweating, I'd better start making candles."
			)
			(7
				(gMessager say: 24 0 1 14 21 self) ; "Benjamin?"
			)
			(8
				(wickTimer setReal: wickTimer 30)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDontEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gMessager say: 24 0 5 0 self) ; "It would be rude of Pepper to just go wandering around the Franklins' private rooms."
			)
			(2
				(gEgo setMotion: PolyPath 172 134 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGiveONEString of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(wickTimer dispose: delete:)
				(= local0 1)
				(ben stopUpd:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 161 119 self)
			)
			(2
				(gMessager say: 28 116 3 1 2 self) ; "Here, will this work?"
			)
			(3
				(gGame points: 419 2)
				(= cycles 1)
			)
			(4
				(gEgo put: 14) ; Ordinary_String
				(= cycles 1)
			)
			(5
				(gEgo setMotion: PolyPath 160 132 self)
			)
			(6
				(gEgo setHeading: 90)
				(= cycles 3)
			)
			(7
				(ben
					show:
					setLoop: 2
					ignoreActors: 1
					setMotion: PolyPath 138 104 self
				)
			)
			(8
				(gMessager say: 28 116 3 3 7 self) ; "Here, father! It, um, it was with my schoolbooks."
			)
			(9
				(ben setLoop: 4 setMotion: PolyPath 190 134 self)
			)
			(10
				(gMessager say: 28 116 3 8 10 self) ; "Thank you, my friend! I thought I was cat's meat! Here, take this kite as a token of my gratitude."
			)
			(11
				(gGame points: 421 1)
				(gEgo get: 13 ignoreActors: 1) ; Kite
				(ben loop: 3 posn: 184 132 setCycle: End self)
			)
			(12
				(gMessager say: 28 116 3 11 13 self) ; "Thank you, Ben."
			)
			(13
				(self setScript: sShimmerAway self)
			)
			(14
				(gCurRoom newRoom: 340)
			)
		)
	)
)

(instance sBenGetsWhipped of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local2 1)
				(= cycles 1)
			)
			(1
				(gEgo stopUpd:)
				(= cycles 1)
			)
			(2
				(gMessager say: 24 0 4 1 2 self) ; "Ben, come here RIGHT NOW!"
			)
			(3
				(ben show: setLoop: 2 setMotion: PolyPath 138 102 self)
			)
			(4
				(ben stopUpd:)
				(sFX number: 926 play:)
				(gMessager say: 24 0 4 3 self) ; "OW!"
			)
			(5
				(sFX number: 926 play:)
				(gMessager say: 24 0 4 4 self) ; "OW!"
			)
			(6
				(sFX number: 926 play:)
				(gMessager say: 24 0 4 5 self) ; "OW!"
			)
			(7
				(sFX number: 926 play:)
				(gMessager say: 24 0 4 6 self) ; "OW!"
			)
			(8
				(sFX number: 926 play:)
				(gMessager say: 24 0 4 7 self) ; "OW!"
			)
			(9
				(gEgo ignoreActors: 1 setMotion: PolyPath 160 132 self)
			)
			(10
				(gEgo setHeading: 90)
				(= cycles 3)
			)
			(11
				(gMessager say: 24 0 4 8 9 self) ; "Don't ever forget such a thing again, boy. This could lose me the contract with the Night Watch."
			)
			(12
				(ben setLoop: 4 setMotion: PolyPath 190 134 self)
			)
			(13
				(gEgo get: 13) ; Kite
				(ben posn: 184 132 setLoop: 3)
				(gMessager say: 24 0 4 10 14 self) ; "Oh, geez, Ben. I'm really sorry."
			)
			(14
				(ben setCycle: End self)
			)
			(15
				(gMessager say: 24 0 4 15 18 self) ; "Thank you."
			)
			(16
				(self setScript: sShimmerAway self)
			)
			(17
				(gCurRoom newRoom: 340)
			)
		)
	)
)

(instance sShimmerAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sFX number: 929 play:)
				(gEgo
					view: 803
					loop: 2
					cel: 12
					x: (+ (gEgo x:) 6)
					setCycle: Beg self
				)
			)
			(1
				(cond
					(local0
						(gMessager say: 28 116 3 14 self) ; "By my father's whiskers! It's TOO HOT in this shop!"
					)
					(local2
						(gMessager say: 24 0 4 19 self) ; "Good heavens! That boy is quick!"
					)
					(local1
						(gMessager say: 28 116 2 12 self) ; MISSING MESSAGE
					)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sTalkBen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gMessager say: 28 85 0 0 self) ; "Please, friend, help me if you can!"
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance ben of Actor
	(properties
		x 138
		y 104
		noun 28
		view 513
		loop 1
		signal 6144
	)

	(method (doVerb theVerb)
		(switch theVerb
			(85 ; Talk
				(gCurRoom setScript: sTalkBen)
			)
			(45 ; Ordinary_String
				(gCurRoom setScript: sGiveONEString)
			)
			(84 ; Trivia
				(gMessager say: 28 84) ; "|c1|TRUE. Young Ben Franklin was apprenticed to his father for a short time, in the trades of candle making and soap making.|c|"
				(sFX number: 927 play:)
			)
			((OneOf theVerb 85 7 6 86 30 89) ; Talk, Do, Look, Nose, Paw, Teeth
				(super doVerb: theVerb &rest)
			)
			(else
				(gMessager say: 28 88) ; "That won't help me at all, I fear."
			)
		)
	)
)

(instance barrel1 of Feature
	(properties
		x 11
		y 170
		noun 3
		nsTop 60
		nsBottom 146
		nsRight 23
		sightAngle 40
	)

	(method (doVerb theVerb)
		(= gDictionaryWord 94)
		(super doVerb: theVerb)
	)
)

(instance barrel2 of Feature
	(properties
		x 44
		y 167
		noun 4
		nsTop 145
		nsBottom 189
		nsRight 89
		sightAngle 40
		approachX 87
		approachY 182
		approachDist 10
	)
)

(instance barrel3 of Feature
	(properties
		x 160
		y 188
		noun 5
	)

	(method (doVerb theVerb)
		(= gDictionaryWord 60)
		(super doVerb: theVerb)
	)
)

(instance barrel4 of Feature
	(properties
		x 288
		y 115
		noun 6
		nsTop 77
		nsLeft 258
		nsBottom 154
		nsRight 319
		sightAngle 40
	)
)

(instance bench of Feature
	(properties
		noun 8
	)
)

(instance blueBall of Feature
	(properties
		x 236
		y 43
		noun 23
		nsTop 37
		nsLeft 229
		nsBottom 49
		nsRight 244
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(gMessager say: 23 84) ; "|c1|TRUE. The Blue Ball was the sign Josiah Franklin used for his shop. It was like his trademark. If you said "I'm going to the Blue Ball for some soap", it meant you were going to Josiah's shop.|c|"
				(sFX number: 927 play:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance books of Feature
	(properties
		y 103
		noun 20
	)
)

(instance bucket of Feature
	(properties
		x 143
		y 126
		noun 12
		nsTop 115
		nsLeft 132
		nsBottom 138
		nsRight 154
		sightAngle 40
	)
)

(instance candles of Feature
	(properties
		x 160
		y 188
		noun 14
	)
)

(instance candles_F1 of Feature
	(properties
		x 62
		y 70
		noun 14
	)
)

(instance candles_F2 of Feature
	(properties
		x 147
		y 39
		noun 14
	)
)

(instance halfDoor of Feature
	(properties
		noun 22
	)
)

(instance fireGoing of Prop
	(properties
		x 117
		y 102
		noun 11
		view 513
		priority 9
		signal 16400
	)
)

(instance fork of Feature
	(properties
		x 88
		y 104
		noun 25
		nsTop 79
		nsLeft 83
		nsBottom 107
		nsRight 94
		sightAngle 40
	)
)

(instance furniture of Feature
	(properties
		x 175
		y 77
		noun 15
		nsTop 42
		nsLeft 156
		nsBottom 112
		nsRight 194
		sightAngle 40
	)
)

(instance inkHorn of Feature
	(properties
		x 59
		y 123
		noun 21
		nsTop 119
		nsLeft 52
		nsBottom 127
		nsRight 67
		sightAngle 40
	)
)

(instance lamp of Feature
	(properties
		x 160
		y 188
		noun 2
	)
)

(instance molds of Feature
	(properties
		x 160
		y 188
		noun 16
	)
)

(instance mold_small of Feature
	(properties
		x 49
		y 170
		noun 16
	)
)

(instance newspaper of Feature
	(properties
		noun 19
	)

	(method (doVerb theVerb)
		(= gDictionaryWord 24)
		(super doVerb: theVerb)
	)
)

(instance oven of Feature
	(properties
		x 115
		y 94
		noun 11
		nsTop 12
		nsLeft 49
		nsBottom 142
		nsRight 167
		sightAngle 40
	)
)

(instance pans of Feature
	(properties
		noun 10
	)
)

(instance rags of Feature
	(properties
		x 125
		y 139
		noun 26
		nsTop 135
		nsLeft 104
		nsBottom 144
		nsRight 147
		sightAngle 40
	)
)

(instance spoon of Feature
	(properties
		x 97
		y 104
		noun 13
		nsTop 72
		nsLeft 91
		nsBottom 102
		nsRight 104
		sightAngle 40
	)
)

(instance table of Feature
	(properties
		noun 9
	)
)

(instance trivet of Feature
	(properties
		x 56
		y 114
		noun 18
		nsTop 111
		nsLeft 47
		nsBottom 117
		nsRight 65
		sightAngle 40
	)
)

(instance trivetPan of Feature
	(properties
		x 55
		y 103
		noun 17
		nsTop 97
		nsLeft 47
		nsBottom 110
		nsRight 64
		sightAngle 40
	)

	(method (doVerb theVerb)
		(= gDictionaryWord 105)
		(super doVerb: theVerb)
	)
)

(instance wastebasket of Feature
	(properties
		x 212
		y 107
		noun 27
		nsTop 95
		nsLeft 203
		nsBottom 119
		nsRight 222
		sightAngle 40
	)
)

(instance wickTimer of Timer
	(properties)

	(method (cue)
		(gCurRoom setScript: sBenGetsWhipped)
	)
)

(instance guyBehindWall of BalloonTalker
	(properties
		x 90
		y 60
		talkWidth 160
		color 20
		tailPosn 3
	)
)

(instance benBoyTalker of BalloonTalker
	(properties
		talkWidth 155
	)

	(method (init)
		(= tailPosn 1)
		(= x (- (ben x:) 163))
		(= y (- (ben y:) 30))
		(super init: &rest)
	)
)

(instance benTimer of Timer
	(properties)

	(method (cue)
		(gCurRoom setScript: sTimerCue)
	)
)

(instance sFX of Sound
	(properties)
)

