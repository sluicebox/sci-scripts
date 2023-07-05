;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 615)
(include sci.sh)
(use Main)
(use Interface)
(use ulence)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
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
		(ulence roomVer: 22891)
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
		(self setFeatures: daFloor daRoom writing setRegions: 706) ; ulence
		(super init:)
		(if (not (IsFlag 75))
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 118 22 161 21 169 74 183 86 168 232 168 242 182 299 160 269 147 259 148 218 128 203 144 161 144 121 144 105 127 77 149 65 144 35 157 0 104 0 0 319 0 319 189 0 189
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
		(Load rsVIEW 618)
		(Load rsVIEW 620)
		(Load rsVIEW 619)
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
					(Print 615 0 #at 20 20) ; "The old bar is still here. The smell of new (and used) Kerona Ale stinks-up the place. Just the aroma leads you to vividly remember your previous drunken visit here. You break out in a cold sweat."
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
					(Print 615 1) ; "Your attempt to get the matches failed."
					(gCurRoom setScript: lookMonoGuys)
					(self dispose:)
				)
			)
			(2
				(SetScore 76 5)
				(gEgo get: 13) ; matches
				(theMatches dispose:)
				(Print 615 2) ; "You pick up the book of matches."
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
							cycleSpeed: 0
							setMotion: MoveTo 152 187 self
						)
					)
					((> (barTender x:) 169)
						(barTender
							setLoop: 1
							setCycle: Fwd
							moveSpeed: 1
							cycleSpeed: 0
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
				(Print 615 3) ; "You speak to the bartender. He looks up at you and says "Hey! Aren't you the guy who broke my slot machine? You owe me some money!""
				(Print 615 4) ; "You explain that you are really very busy and must be going."
				(NormalEgo)
				(HandsOn)
				(barTender setScript: barTenderScript)
				(self dispose:)
			)
		)
	)
)

(instance daFloor of Feature
	(properties
		x 159
		y 112
		nsTop 36
		nsBottom 189
		nsRight 319
		description {floor.}
		onMeCheck 16
		lookStr {You see the bar's floor.}
	)
)

(instance daRoom of Feature
	(properties
		x 159
		y 112
		nsTop 36
		nsBottom 189
		nsRight 319
		description {room.}
		onMeCheck 32
		lookStr {This looks like the bar in Space Quest I.}
	)
)

(instance writing of Feature
	(properties
		x 30
		y 117
		nsTop 97
		nsLeft 26
		nsBottom 138
		nsRight 34
		description {writing}
		sightAngle 90
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(if (!= (++ local3) 6)
					(Print 615 5) ; "There's some writing on the wall above the stairs. Maybe it says: Watch Your Step."
				else
					(Print 615 6) ; "There's some writing on the wall above the stairs. It says..."
					(Print 615 7) ; "Quality Assurance by:    Mike Harian   Dan Scott   Tate Deloach   Keri Cooper   Bill Shockley   Neil Matz   Gordon Owens   Dave Fleming   Danny Woolard   Chris Carr   John Ratcliffe   Robin Bradley   Joe Perry   Mike Pickhinke   Sharon Smith   Sharon Simmons   Kevin Ray"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mono1 of Prop
	(properties
		x 193
		y 180
		z 10
		description {mono1}
		view 620
		loop 1
		priority 14
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Talk
				(gCurRoom setScript: lookMonoGuys)
			)
			(2 ; Do
				(gCurRoom setScript: lookMonoGuys)
			)
			(11 ; Smell
				(Print 615 8) ; "You try to get closer to do that..."
				(gCurRoom setScript: lookMonoGuys)
			)
			(10 ; Taste
				(Print 615 8) ; "You try to get closer to do that..."
				(gCurRoom setScript: lookMonoGuys)
			)
			(1 ; Look
				(Print 615 9) ; "Some rather drab looking individuals hog space at the bar. This guy's really ugly!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mono2 of Prop
	(properties
		x 118
		y 180
		z 10
		description {mono2}
		view 620
		loop 2
		priority 14
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Do
				(gCurRoom setScript: lookMonoGuys)
			)
			(4 ; Talk
				(gCurRoom setScript: lookMonoGuys)
			)
			(1 ; Look
				(Print 615 10) ; "Some rather drab looking individuals hog space at the bar. This guy's too ugly to describe!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mono3 of Prop
	(properties
		x 157
		y 182
		z 10
		description {mono3}
		view 620
		loop 3
		priority 14
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Do
				(gCurRoom setScript: lookMonoGuys)
			)
			(4 ; Talk
				(gCurRoom setScript: lookMonoGuys)
			)
			(1 ; Look
				(Print 615 11) ; "Some rather drab looking individuals hog space at the bar. This guy's the ugliest of all!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stage of Feature
	(properties
		x 163
		y 118
		nsTop 99
		nsLeft 117
		nsBottom 138
		nsRight 210
		description {stage}
		sightAngle 180
		onMeCheck 4
		lookStr {There is a stage here with two guys singing.}
	)
)

(instance bar of Feature
	(properties
		x 158
		y 176
		nsTop 164
		nsLeft 73
		nsBottom 188
		nsRight 243
		description {bar}
		sightAngle 180
		onMeCheck 2
		lookStr {There's the bar just as you remember it.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Talk
				(++ local0)
				(if (not (IsFlag 15))
					(Print 615 12) ; "You step over to talk to the bartender. As you do you attract the attention of the crude fellows at the bar."
					(gCurRoom setScript: lookMonoGuys)
				else
					(switch local0
						(1
							(gCurRoom setScript: talkToBartender)
						)
						(else
							(Print 615 13) ; "You don't want to get into that mess again."
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

(instance door of Feature
	(properties
		x 29
		y 127
		nsTop 94
		nsLeft 6
		nsBottom 160
		nsRight 53
		description {door}
		sightAngle 180
		onMeCheck 16384
		lookStr {It's an incremental elevation adjustment device.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Do
				(gCurRoom setScript: exitScript)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theMatches of View
	(properties
		x 90
		y 183
		z 10
		nsTop 170
		nsLeft 87
		nsBottom 176
		nsRight 94
		description {matches}
		view 620
		priority 14
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(Print 615 14) ; "You see a book of matches on the bar counter top."
			)
			(2 ; Do
				(gCurRoom setScript: getMatches)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance barTender of Actor
	(properties
		description {bartender}
		lookStr {The bartender is a plain man nearly devoid of features.}
		view 618
		signal 16384
		illegalBits 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(Print 615 15) ; "You see a man behind the bar serving drinks."
			)
			(2 ; Do
				(Print 615 16) ; "You have no time for a drink."
			)
			(4 ; Talk
				(++ local0)
				(if (not (IsFlag 15))
					(Print 615 12) ; "You step over to talk to the bartender. As you do you attract the attention of the crude fellows at the bar."
					(gCurRoom setScript: lookMonoGuys)
				else
					(switch local0
						(1
							(gCurRoom setScript: talkToBartender)
						)
						(else
							(Print 615 13) ; "You don't want to get into that mess again."
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

(instance band of Prop
	(properties
		x 160
		y 115
		description {singers}
		lookStr {A truly groovy band cranks out tired old tunes.}
		view 619
		signal 24576
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(Print 615 17) ; "You see two guys singing."
			)
			(2 ; Do
				(Print 615 18) ; "The band members have nothing of interest."
			)
			(4 ; Talk
				(Print 615 19) ; "They don't have time to talk right now."
			)
			(11 ; Smell
				(Print 615 20) ; "Fortunately, they play much better than they smell."
			)
			(3 ; Inventory
				(if (!= invItem 0) ; buckazoid
					(Print 615 21) ; "They are not interested in that."
				else
					(Print 615 22) ; "You don't have enough to afford their services."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theWindow of Feature
	(properties
		x 164
		y 61
		nsTop 52
		nsLeft 154
		nsBottom 70
		nsRight 175
		description {window}
		sightAngle 180
		lookStr {From your position in the bar, you can only see sky through the window.}
	)
)

(instance stairs of Feature
	(properties
		x 26
		y 128
		nsTop 91
		nsLeft 6
		nsBottom 165
		nsRight 46
		description {stairs}
		sightAngle 180
		onMeCheck 8
		lookStr {It's an incremental elevation adjustment device.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Do
				(gCurRoom setScript: exitScript)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

