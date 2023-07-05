;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 240)
(include sci.sh)
(use Main)
(use eRS)
(use Conversation)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm240 0
	local_Steve 12
)

(local
	[local0 57] = [-1 10 6 19 1 0 0 0 -1 10 6 19 2 0 0 0 -1 10 6 19 3 0 0 0 -1 10 6 19 4 0 0 0 -1 10 6 19 5 0 0 0 -1 10 6 19 6 0 0 0 -1 10 6 19 7 0 0 0 0]
	local57
	local58
	local59
)

(instance rm240 of LBRoom
	(properties
		picture 120
		style 10
		east 250
		vanishingX 187
		vanishingY 135
	)

	(method (init)
		(LoadMany rsVIEW 852 284 1125 125 830 121)
		(LoadMany rsSOUND 40 120 121)
		(gEgo init: setScale: Scaler 145 20 187 135 normalize: 830)
		(switch gPrevRoomNum
			(east
				(if (IsFlag 9)
					(gCurRoom setScript: sEnterEastN)
				else
					(steve init: setScale: Scaler 197 10 187 135)
					(self
						addObstacle:
							(= local59
								((Polygon new:)
									type: PBarredAccess
									init: 199 159 199 171 160 171 160 159
									yourself:
								)
							)
					)
					(gCurRoom setScript: sEnterEast1)
				)
			)
			(else
				(gEgo posn: 160 160)
				(gGame handsOn:)
			)
		)
		(super init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 84 154 83 176 183 176 243 176 243 164 212 164 212 154 242 154 242 142 162 142 91 154
					yourself:
				)
		)
		(gGameMusic1 number: 121 loop: -1 flags: 1 play:)
		(gGameMusic2 fade:)
		(person1 init: setStep: 1 1)
		(person2 init: setStep: 1 1)
		(person3 init: setStep: 1 1)
		(taxiSign init:)
		(ship init:)
		(crate init:)
		(warehouses init:)
		(city init:)
		(city1 init:)
		(cityLeft init:)
		(sky init:)
		(skyleft init:)
		(water init:)
		(pilingRt init:)
		(pilingL init:)
		(docks init:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((StepOn gEgo 256)
				(gCurRoom setScript: sHitEdgeScreen)
			)
		)
	)

	(method (dispose)
		(gGameMusic1 fade:)
		(noConvTimer dispose: delete:)
		(super dispose:)
	)
)

(instance sEnterEast1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 22 0) doit: $0002) ; triggerAndClock
				(gGame points: 1 130)
				((ScriptID 1881 2) x: 203 y: 17 textX: -180 textY: 0) ; Laura
				(gEgo
					edgeHit: EDGE_NONE
					posn: 250 159
					setHeading: 270
					setMotion: MoveFwd 38 self
				)
				(steve setLoop: 5 setCycle: Walk setMotion: MoveTo 180 166 self)
			)
			(1 0)
			(2
				(steve
					setLoop: 8
					cel: 0
					posn: 180 165
					cycleSpeed: 12
					setScript: sSteveAnimates
				)
				(gGame handsOn:)
				(SetFlag 9)
				(person1 setScript: moveItAround)
				(= seconds 1)
			)
			(3
				(gMessager say: 14 0 0 1) ; "Hi."
				(person3 setScript: (moveItAround new:))
				(= seconds 1)
			)
			(4
				(person2 setScript: (moveItAround new:))
				(= seconds 1)
			)
			(5
				(noConvTimer setReal: noConvTimer 15)
				(self dispose:)
			)
		)
	)
)

(instance sEnterEastN of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					edgeHit: EDGE_NONE
					posn: 250 150
					setHeading: 270
					setMotion: MoveFwd 35 self
				)
			)
			(1
				(gGame handsOn:)
				(person1 setScript: moveItAround)
				(= seconds 2)
			)
			(2
				(person3 setScript: (moveItAround new:))
				(= cycles 5)
			)
			(3
				(person2 setScript: (moveItAround new:))
				(= seconds 6)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sSteveAnimates of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds (Random 4 8))
			)
			(1
				(switch (= temp0 (Random 0 3))
					(0
						(steve loop: 8 setCycle: End self)
					)
					(1
						(if (== (Random 0 3) 0)
							(steve loop: 9 setCycle: End self)
						else
							(= temp0 3)
							(= cycles 1)
						)
					)
					(2
						(steve loop: 10 setCycle: End self)
					)
					(3
						(= seconds (Random 2 4))
					)
				)
			)
			(2
				(= seconds (Random 4 8))
			)
			(3
				(if (!= temp0 3) ; UNINIT
					(steve setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(4
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance moveItAround of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setMotion: MoveTo 194 127 self)
			)
			(1
				(client posn: 234 137 setMotion: MoveTo 191 138 self)
			)
			(2
				(switch (Random 0 1)
					(0
						(client
							setMotion:
								MoveTo
								(Random 138 174)
								(Random 136 140)
								self
						)
					)
					(1
						(= seconds 2)
					)
				)
			)
			(3
				(client setMotion: MoveTo 191 138 self)
			)
			(4
				(client setMotion: MoveTo 234 137 self)
			)
			(5
				(client loop: (Random 0 4) posn: 169 121)
				(= seconds 2)
			)
			(6
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sTalkSteve of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(noConvTimer setReal: noConvTimer 15)
				(= cycles 1)
			)
			(1
				((ScriptID 21 0) doit: 263) ; addCluesCode, Steve Dorian
				(if (< (gEgo x:) 181)
					(gEgo setMotion: PolyPath 162 165 self)
				else
					(gEgo setMotion: PolyPath 204 169 self)
				)
			)
			(2
				(Face gEgo steve self)
			)
			(3
				(= cycles 4)
			)
			(4
				(switch (++ local57)
					(1
						(gMessager say: 10 2 1 0 self) ; "Good morning, miss. I'm Steve Dorian."
						((ScriptID 21 0) doit: 263) ; addCluesCode, Steve Dorian
					)
					(2
						(gMessager say: 10 2 2 0 self) ; "Nice weather we're having."
					)
					(3
						(gMessager say: 10 2 3 0 self) ; "Hey, did you hear about Admiral Byrd? He just made the first successful flight over the North Pole. What a guy."
					)
					(4
						(gMessager say: 10 2 4 0 self) ; "I think the Cardinals are going to win the World Series this year."
					)
					(5
						(gMessager say: 10 2 5 0 self) ; "I hear Henry Ford just introduced the forty hour work week at his auto plant. I think that's ridiculous. What are his employees going to do with all that free time?"
					)
					(else
						(gMessager say: 10 2 6 0 self) ; "Do you always have this much trouble holding up your end of the conversation?"
					)
				)
				(= seconds 1)
			)
			(5
				(= cycles 4)
			)
			(6
				(noConvTimer setReal: noConvTimer 15)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sAskSteve of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(noConvTimer setReal: noConvTimer 15)
				(= cycles 1)
			)
			(1
				((ScriptID 21 0) doit: 263) ; addCluesCode, Steve Dorian
				(if (< (gEgo x:) 181)
					(gEgo setMotion: PolyPath 162 165 self)
				else
					(gEgo setMotion: PolyPath 204 169 self)
				)
			)
			(2
				(Face gEgo steve self)
			)
			(3
				(gGame handsOff:)
				(= cycles 4)
			)
			(4
				(switch (gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
					(262
						(gMessager say: 10 6 7 0 self) ; "I do my own laundry."
					)
					(261
						(gMessager say: 10 6 8 0 self) ; "Did you just sneeze or something?"
					)
					(264
						(gMessager say: 10 6 9 0 self) ; "He's some kind of a cheap hood. He used to hang around here sometimes."
					)
					(260
						(gMessager say: 10 6 10 0 self) ; "Sounds like an Irish name."
					)
					(259
						((ScriptID 21 0) doit: 269) ; addCluesCode, Countess W-C
						(gMessager say: 10 6 11 0 self) ; "Mr. Carrington came in on the Andrea Doria. I remember because he had the heaviest steamer trunk I've ever lifted...and it smelled funny, too. Gave me a big tip. Then that rich lady picked him up in a taxi. He called her the Countess Waldorf-Carlton."
					)
					(269
						(gMessager say: 10 6 12 0 self) ; "She's the rich lady that picked up Mr. Carrington."
					)
					(258
						(switch (++ local58)
							(1
								(gMessager say: 10 6 13 0 self) ; "Boy, do I remember that guy. He supervised the unloading of the Egyptian crates from the ship. It was a bunch of stuff for the museum and he was real protective about it."
							)
							(else
								(gMessager say: 10 6 14 0 self) ; "I also remember a fat Egyptian guy in a funny hat who kept pestering Mr. Carter. I think his name was Tut."
							)
						)
					)
					(263
						(gMessager say: 10 6 26 0 self) ; "Steve Dorian? That's me, Miss Bow."
					)
					(780
						((ScriptID 21 0) doit: 258) ; addCluesCode, Dr. Pippin Carter
						(gMessager say: 10 6 15 0 self) ; "I think it was in one of those crates Mr. Carter brought from Egypt. I thought he was going to faint when one of the boys almost dropped that crate in the water."
					)
					(518
						(gMessager say: 10 6 16 0 self) ; "I've heard about one speakeasy called The Harlem Swinger, but that's all. They're illegal, so I don't go to those places."
					)
					(516
						(gMessager say: 10 6 17 0 self) ; "This is where I work."
					)
					(514
						(gMessager say: 10 6 18 0 self) ; "I don't know where it is. Never been there."
					)
					(519
						(gMessager say: 10 6 27 0 self) ; "It's my kind of town."
					)
					(517
						(self setScript: sAskMuseum self)
					)
					(1026
						(gMessager say: 10 6 28 0 self) ; "So far, it's a pretty good year for me, and things are looking up."
					)
					(773
						(gMessager say: 10 6 20 0 self) ; "I think the Cardinals are going to win the World Series this year."
					)
					(772
						(gMessager say: 10 6 22 0 self) ; "I hate corned beef sandwiches. They make me itch."
					)
					(769
						(gMessager say: 10 6 21 0 self) ; "I hate corned beef sandwiches. They make me itch."
					)
					(771
						(gMessager say: 10 6 23 0 self) ; "Nice notebook."
					)
					(-1
						(= cycles 1)
					)
					(else
						(gMessager say: 10 6 25 0 self) ; "I don't know anything about that. Sorry."
					)
				)
			)
			(5
				(= cycles 4)
			)
			(6
				(if (gCast contains: steve)
					(noConvTimer setReal: noConvTimer 15)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sAskMuseum of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(noConvTimer dispose: delete:)
				((ScriptID 21 0) doit: 258) ; addCluesCode, Dr. Pippin Carter
				(myConv load: @local0 init: self) ; "That's where Mr. Carter's Egyptian crates were going. Nice place. Ever been there?"
				(steve setScript: 0)
			)
			(1
				(steve
					setLoop: 6
					posn: (- (steve x:) 2) (+ (steve y:) 3)
					ignoreActors: 1
					setCycle: End self
				)
			)
			(2
				(steve
					setLoop: 7
					posn: (+ (steve x:) 2) (- (steve y:) 1)
					setHeading: 0
					setStep: 1 1
					moveSpeed: 9
					setCycle: Walk
					setMotion: MoveTo (steve x:) 140 self
				)
				(= seconds 5)
			)
			(3
				(if seconds
					(= seconds 0)
				)
				(gGame handsOn:)
				(steve dispose:)
				((gCurRoom obstacles:) delete: local59)
				(local59 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sHailCab of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(if (gCast contains: steve)
					(steve setScript: 0)
				)
				(gEgo setMotion: PolyPath 213 152 self)
			)
			(2
				(gEgo
					view: 852
					loop: 0
					cel: 0
					setScale: Scaler 170 20 187 135
					setCycle: End self
				)
				(if (gCast contains: steve)
					(steve
						setLoop: 7
						setHeading: 0
						setStep: 1 1
						moveSpeed: 9
						setMotion: MoveTo (steve x:) 140
					)
				)
				(noise number: 97 flags: 1 play:)
			)
			(3
				(taxi
					init:
					setPri: 11
					setScale: Scaler 187 70 187 135
					setLoop: 4
				)
				(= cycles 1)
			)
			(4
				(gGameMusic2 play:)
				(taxi setMotion: MoveTo 281 154 self)
			)
			(5
				(taxi setMotion: MoveTo 293 163 self)
			)
			(6
				(gEgo
					normalize: 830
					setHeading: 90
					setScale: Scaler 145 20 187 135
					setMotion: MoveFwd 32 self
				)
			)
			(7
				(noise number: 40 flags: 5 play: self)
			)
			(8
				(gCurRoom newRoom: 250)
			)
		)
	)
)

(instance sHitEdgeScreen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gMessager say: 4 3 0 0 self 91) ; "Don't stray too far in The Big Apple. It's a big city, and you're not familiar with it yet."
			)
			(2
				(if (> (gEgo heading:) 180)
					(gEgo setHeading: 90)
				else
					(gEgo setHeading: 270)
				)
				(gEgo setMotion: MoveFwd 25 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance person1 of Actor
	(properties
		x 169
		y 121
		view 121
		priority 3
		signal 18448
		scaleSignal 1
		moveSpeed 25
	)
)

(instance person2 of Actor
	(properties
		x 169
		y 121
		view 121
		loop 1
		priority 3
		signal 18448
		scaleSignal 1
		moveSpeed 27
	)
)

(instance person3 of Actor
	(properties
		x 169
		y 121
		view 121
		loop 2
		priority 3
		signal 18448
		scaleSignal 1
		moveSpeed 24
	)
)

(instance steve of Actor
	(properties
		x 184
		y 140
		noun 9
		view 121
		loop 5
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(gCurRoom setScript: sTalkSteve)
			)
			(6 ; Ask
				(gCurRoom setScript: sAskSteve)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance taxiSign of View
	(properties
		x 225
		y 160
		noun 13
		view 284
		cel 2
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sHailCab)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance taxi of Actor
	(properties
		x 290
		y 146
		view 852
		loop 4
	)
)

(instance ship of Feature
	(properties
		y 100
		noun 1
		onMeCheck 16384
	)
)

(instance crate of Feature
	(properties
		x 113
		y 189
		noun 5
		nsTop 164
		nsLeft 88
		nsBottom 179
		nsRight 139
		sightAngle 40
	)
)

(instance warehouses of Feature
	(properties
		x 209
		y 128
		noun 4
		nsTop 121
		nsLeft 189
		nsBottom 136
		nsRight 230
		sightAngle 40
	)
)

(instance city of Feature
	(properties
		x 199
		y 82
		noun 3
		nsTop 46
		nsLeft 188
		nsBottom 119
		nsRight 210
		sightAngle 40
	)
)

(instance city1 of Feature
	(properties
		x 204
		y 93
		noun 3
		nsTop 67
		nsLeft 177
		nsBottom 120
		nsRight 231
		sightAngle 40
	)
)

(instance cityLeft of Feature
	(properties
		x 95
		y 100
		noun 3
		nsTop 72
		nsLeft 88
		nsBottom 128
		nsRight 103
		sightAngle 40
	)
)

(instance sky of Feature
	(properties
		x 199
		y 26
		noun 2
		nsTop 8
		nsLeft 168
		nsBottom 45
		nsRight 231
		sightAngle 40
	)
)

(instance skyleft of Feature
	(properties
		x 107
		y 20
		noun 2
		nsTop 6
		nsLeft 89
		nsBottom 35
		nsRight 126
		sightAngle 40
	)
)

(instance water of Feature
	(properties
		x 99
		y 139
		noun 7
		nsTop 135
		nsLeft 87
		nsBottom 144
		nsRight 112
		sightAngle 40
	)
)

(instance pilingRt of Feature
	(properties
		x 214
		y 168
		noun 8
		nsTop 151
		nsLeft 198
		nsBottom 185
		nsRight 230
		sightAngle 40
	)
)

(instance pilingL of Feature
	(properties
		x 171
		y 176
		noun 8
		nsTop 169
		nsLeft 150
		nsBottom 183
		nsRight 193
		sightAngle 40
	)
)

(instance docks of Feature
	(properties
		y 160
		noun 6
		onMeCheck 8192
	)
)

(instance myConv of Conversation
	(properties)
)

(instance local_Steve of Talker
	(properties
		name {local Steve}
		x 9
		y 85
		view 125
		loop 3
		priority 15
		signal 16
		disposeWhenDone 0
		talkWidth 130
		back 15
		textX 130
		textY -75
	)

	(method (init)
		(= font gUserFont)
		(super init: 0 tSteveEyes tSteveMouth &rest)
	)
)

(instance tSteveMouth of Prop
	(properties
		nsTop 34
		nsLeft 57
		view 1125
		priority 15
		signal 16400
	)
)

(instance tSteveEyes of Prop
	(properties
		nsTop 29
		nsLeft 58
		view 1125
		loop 2
		priority 15
		signal 16400
	)
)

(instance noConvTimer of Timer
	(properties)

	(method (cue)
		(cond
			((and (not (gCurRoom script:)) (gCast contains: steve))
				(gMessager say: 14 0 0 2) ; "Umm..."
				(noConvTimer setReal: noConvTimer 15)
			)
			((not (gCast contains: steve))
				(noConvTimer dispose: delete:)
			)
			(else
				(self setReal: self 5)
			)
		)
	)
)

(instance noise of Sound
	(properties
		flags 1
	)
)

