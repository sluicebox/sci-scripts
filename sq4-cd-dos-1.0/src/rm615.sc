;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 615)
(include sci.sh)
(use Main)
(use ulence)
(use eRS)
(use Sq4Narrator)
(use Sq4Feature)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use Motion)
(use System)

(public
	rm615 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm615 of SQRoom
	(properties
		picture 615
	)

	(method (init)
		(switch gPrevRoomNum
			(610
				(gEgo x: -5 y: 127)
				(gLongSong stop:)
				(gLongSong2 fade: 127 10 10 0)
				(self setScript: climbDOWNstairs)
			)
			(else
				(gEgo x: -5 y: 127)
				(gLongSong2 vol: 127 number: 804 loop: -1 playBed:)
				(self setScript: climbDOWNstairs)
			)
		)
		(gEgo init: show: illegalBits: 0 ignoreActors: 1)
		(theWindow init:)
		(stairs init:)
		(door init:)
		(bar init:)
		(stage init:)
		(barTender
			init:
			setPri: 14
			posn: (Random 104 210) 183
			setLoop: (Random 2 3)
			setScript: barTenderScript
		)
		(band init: setCycle: Fwd)
		(if (not (gEgo has: 13)) ; matches
			(theMatches init:)
		)
		(self setRegions: 706) ; ulence
		(daFloor init:)
		(daRoom init:)
		(writing init:)
		(super init:)
		(if (not (IsFlag 75))
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 118 21 167 8 174 74 183 86 168 232 168 242 182 299 160 269 147 259 148 218 128 203 144 121 144 105 127 77 149 63 141 39 155 28 150 0 104 0 0 319 0 319 189 0 189
						yourself:
					)
			)
			(mono1 init:)
			(mono2 init:)
			(mono3 init:)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 118 22 161 21 169 68 183 248 183 299 160 269 147 259 148 218 128 203 144 161 144 121 144 105 127 77 149 65 144 35 157 0 104 0 0 319 0 319 189 0 189
						yourself:
					)
			)
		)
		(LoadMany rsVIEW 618 620 619)
	)

	(method (doit)
		(cond
			(script 0)
			((and (not (IsFlag 75)) (gEgo inRect: 87 155 210 180))
				(self setScript: lookMonoGuys)
			)
			((& (gEgo onControl: 1) $0008)
				(HandsOff)
				(= local2 1)
				(self setScript: exitScript)
			)
		)
		(super doit: &rest)
		(if (> (gEgo y:) 176)
			(gEgo setPri: 13)
		else
			(gEgo setPri: -1)
		)
	)
)

(instance climbDOWNstairs of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo 27 159 self)
			)
			(2
				(= seconds 2)
			)
			(3
				(if (not (ulence beenInBar:))
					(gNarrator say: 1) ; "The old bar is still here. The smell of Keronian Ale stinks up the place. The aroma leads you to remember vividly your previous visit here. You break out in a cold sweat."
					(ulence beenInBar: 1)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lookMonoGuys of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(if local1
					(= local1 0)
					(self cue:)
				else
					(gEgo setMotion: PolyPath 117 159 self)
				)
			)
			(1
				(gEgo setHeading: 135 self)
			)
			(2
				(mono1 setCycle: End)
				(mono2 setCycle: End)
				(mono3 setCycle: End)
				(= seconds 4)
			)
			(3
				(gLongSong2 fade: 85 10 10 0)
				(gCurRoom newRoom: 620)
			)
		)
	)
)

(instance exitScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(if local2
					(self cue:)
				else
					(gEgo setMotion: PolyPath 34 160 self)
				)
			)
			(1
				(gEgo setMotion: MoveTo -5 127 self)
			)
			(2
				(gLongSong2 fade: 70 10 10 0)
				(gCurRoom newRoom: 610)
			)
		)
	)
)

(instance barTenderScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= seconds (Random 2 5))
			)
			(1
				(barTender
					setCycle: Walk
					setLoop: -1
					setMotion: MoveTo (Random 104 210) 183 self
				)
			)
			(2
				(if (> (Random 0 100) 80)
					(self init:)
				else
					(= cycles (Random 2 6))
				)
			)
			(3
				(if (> (Random 0 100) 50)
					(barTender setLoop: 3)
				else
					(barTender setLoop: 2)
				)
				(self init:)
			)
		)
	)
)

(instance getMatches of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(if (IsFlag 75)
					(gEgo setMotion: PolyPath 89 181 self)
				else
					(gEgo setMotion: PolyPath 102 174 self)
				)
			)
			(1
				(if (IsFlag 75)
					(gEgo setHeading: 180 self)
				else
					(= local1 1)
					(gNarrator say: 2) ; "Your attempt to get the matches failed."
					(gCurRoom setScript: lookMonoGuys)
					(self dispose:)
				)
			)
			(2
				(SetScore 76 5)
				(gEgo get: 13) ; matches
				(theMatches dispose:)
				(gNarrator say: 3) ; "You pick up the book of matches."
				(NormalEgo (gEgo loop:) 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance talkToBartender of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 152 184 self)
			)
			(1
				(gEgo setLoop: 2)
				(barTender setScript: 0)
				(cond
					((< (barTender x:) 147)
						(barTender
							setLoop: 0
							setCycle: Fwd
							moveSpeed: 1
							cycleSpeed: 6
							setMotion: MoveTo 152 187 self
						)
					)
					((> (barTender x:) 169)
						(barTender
							setLoop: 1
							setCycle: Fwd
							moveSpeed: 1
							cycleSpeed: 6
							setMotion: MoveTo 152 187 self
						)
					)
					(else
						(= seconds 1)
					)
				)
			)
			(2
				(barTender setLoop: 3 setCycle: 0 setMotion: 0)
				(= seconds 1)
			)
			(3
				(tBARTENDER tStyle: 1 say: 4 self) ; "Hey! Aren't you the guy who broke my slot machine? You owe me some money!"
			)
			(4
				(tROGER tStyle: 0 say: 5 self) ; "Well, I've gotta run. My Hog Pod's double parked. It's been swell talking to you."
			)
			(5
				(NormalEgo)
				(HandsOn)
				(barTender setScript: barTenderScript)
				(self dispose:)
			)
		)
	)
)

(instance daFloor of Sq4Feature
	(properties
		x 159
		y 112
		nsTop 36
		nsBottom 189
		nsRight 319
		onMeCheck 16
		lookStr 6 ; "You see the bar's floor."
	)
)

(instance daRoom of Sq4Feature
	(properties
		x 159
		y 112
		nsTop 36
		nsBottom 189
		nsRight 319
		onMeCheck 32
		lookStr 7 ; "This looks like the bar in Space Quest I."
	)
)

(instance writing of Sq4Feature
	(properties
		x 30
		y 117
		nsTop 97
		nsLeft 26
		nsBottom 138
		nsRight 34
		sightAngle 90
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(if (!= (++ local3) 6)
					(gNarrator say: 8) ; "There's some writing on the wall above the stairs. Perhaps it says: Watch Your Step."
				else
					(gNarrator say: 8) ; "There's some writing on the wall above the stairs. Perhaps it says: Watch Your Step."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mono1 of Sq4Prop
	(properties
		x 193
		y 180
		z 10
		view 620
		loop 1
		priority 14
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Talk
				(gCurRoom setScript: lookMonoGuys)
			)
			(4 ; Do
				(gCurRoom setScript: lookMonoGuys)
			)
			(6 ; Smell
				(gNarrator modNum: 702 say: 18) ; "You're too far away to do that."
				(gCurRoom setScript: lookMonoGuys)
			)
			(7 ; Taste
				(gNarrator modNum: 702 say: 18) ; "You're too far away to do that."
				(gCurRoom setScript: lookMonoGuys)
			)
			(1 ; Look
				(gNarrator say: 10) ; "Some rather drab-looking individuals are hogging the bar. This guy's really ugly!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mono2 of Sq4Prop
	(properties
		x 118
		y 180
		z 10
		view 620
		loop 2
		priority 14
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: lookMonoGuys)
			)
			(2 ; Talk
				(gCurRoom setScript: lookMonoGuys)
			)
			(1 ; Look
				(gNarrator say: 11) ; "Some rather drab-looking individuals are hogging the bar. This guy's too ugly to describe!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mono3 of Sq4Prop
	(properties
		x 157
		y 182
		z 10
		view 620
		loop 3
		priority 14
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: lookMonoGuys)
			)
			(2 ; Talk
				(gCurRoom setScript: lookMonoGuys)
			)
			(1 ; Look
				(gNarrator say: 12) ; "Some rather drab-looking individuals are hogging the bar. This guy's the ugliest of all!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stage of Sq4Feature
	(properties
		x 163
		y 118
		nsTop 99
		nsLeft 117
		nsBottom 138
		nsRight 210
		sightAngle 180
		onMeCheck 4
		lookStr 13 ; "There is a stage here with two guys singing."
	)
)

(instance bar of Sq4Feature
	(properties
		x 158
		y 176
		nsTop 164
		nsLeft 73
		nsBottom 188
		nsRight 243
		sightAngle 180
		onMeCheck 2
		lookStr 14 ; "There's the bar just as you remember it."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Talk
				(++ local0)
				(if (not (IsFlag 15))
					(gNarrator say: 19) ; "You step over to talk to the bartender. As you do, you attract the attention of the crude fellows at the bar."
					(gCurRoom setScript: lookMonoGuys)
				else
					(switch local0
						(1
							(gCurRoom setScript: talkToBartender)
						)
						(else
							(gNarrator say: 20) ; "You don't want to get into that mess again."
						)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance door of Sq4Feature
	(properties
		x 29
		y 127
		nsTop 94
		nsLeft 6
		nsBottom 160
		nsRight 53
		sightAngle 180
		onMeCheck 16384
		lookStr 29 ; "It's an incremental elevation adjustment device."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: exitScript)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theMatches of Sq4View
	(properties
		x 90
		y 193
		z 20
		nsTop 170
		nsLeft 87
		nsBottom 176
		nsRight 94
		view 620
		priority 14
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 15) ; "You see a book of matches on the bar countertop."
			)
			(4 ; Do
				(gCurRoom setScript: getMatches)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance barTender of Sq4Actor
	(properties
		view 618
		signal 16384
		illegalBits 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 17) ; "You see a man behind the bar serving drinks."
			)
			(4 ; Do
				(gNarrator say: 18) ; "You have no time for a drink."
			)
			(2 ; Talk
				(++ local0)
				(if (not (IsFlag 15))
					(gNarrator say: 19) ; "You step over to talk to the bartender. As you do, you attract the attention of the crude fellows at the bar."
					(gCurRoom setScript: lookMonoGuys)
				else
					(switch local0
						(1
							(gCurRoom setScript: talkToBartender)
						)
						(else
							(gNarrator say: 20) ; "You don't want to get into that mess again."
						)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance band of Sq4Prop
	(properties
		x 160
		y 115
		view 619
		signal 24576
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 22) ; "You see two guys singing."
			)
			(4 ; Do
				(gNarrator say: 23) ; "The band members have nothing of interest."
			)
			(2 ; Talk
				(gNarrator say: 24) ; "They don't have time to talk right now."
			)
			(6 ; Smell
				(gNarrator say: 25) ; "Fortunately, they play much better than they smell."
			)
			(8 ; buckazoid
				(if gBuckazoidCount
					(gNarrator say: 26) ; "They are not interested in that."
				else
					(gNarrator say: 27) ; "You don't have enough to afford their services."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theWindow of Sq4Feature
	(properties
		x 164
		y 61
		nsTop 52
		nsLeft 154
		nsBottom 70
		nsRight 175
		sightAngle 180
		lookStr 28 ; "From your position in the bar, you can only see sky through the window."
	)
)

(instance stairs of Sq4Feature
	(properties
		x 26
		y 128
		nsTop 91
		nsLeft 6
		nsBottom 165
		nsRight 46
		sightAngle 180
		onMeCheck 8
		lookStr 29 ; "It's an incremental elevation adjustment device."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: exitScript)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tROGER of Sq4Talker
	(properties
		z 400
		noun 7
		view 1008
		talkerNum 7
		mouthOffsetX 21
		mouthOffsetY 32
		eyeOffsetX 27
		eyeOffsetY 21
	)
)

(instance tBARTENDER of Sq4Talker
	(properties
		z 400
		noun 1
		view 1618
		talkerNum 1
		mouthOffsetX 28
		mouthOffsetY 15
		eyeOffsetX 28
		eyeOffsetY 9
	)
)

