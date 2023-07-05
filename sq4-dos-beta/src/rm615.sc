;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 615)
(include sci.sh)
(use Main)
(use Interface)
(use ulence)
(use SQRoom)
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
)

(instance rm615 of SQRoom
	(properties
		picture 615
	)

	(method (init)
		(ulence roomVer: 11691)
		(switch gPrevRoomNum
			(620
				(gEgo x: 117 y: 159)
			)
			(610
				(gEgo x: -5 y: 127)
				(self setScript: climbDOWNstairs)
			)
			(else
				(gEgo x: -5 y: 127)
				(gLongSong
					vol: 5
					number: 804
					loop: -1
					playBed:
					fade: 127 20 20 0
				)
				(self setScript: climbDOWNstairs)
			)
		)
		(gEgo init: show: illegalBits: 0 ignoreActors: 1)
		(stairs init:)
		(door init:)
		(bar init:)
		(stage init:)
		(theWindow init:)
		(barTender
			init:
			setPri: 15
			posn: (Random 104 210) 183
			setLoop: (Random 2 3)
			setScript: barTenderScript
		)
		(band init: setCycle: Fwd)
		(if (not (gEgo has: 14)) ; matches
			(theMatches init:)
		)
		(self setRegions: 706) ; ulence
		(super init:)
		(if (not (IsFlag 15))
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
						init: 0 118 22 161 21 169 66 189 86 184 229 184 242 187 299 160 269 147 259 148 218 128 203 144 161 144 121 144 105 127 77 149 65 144 35 157 0 104 0 0 319 0 319 189 0 189
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
			((and (not (IsFlag 15)) (gEgo inRect: 87 155 210 180))
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

(instance mono1 of Prop
	(properties
		x 193
		y 180
		z 10
		description {mono1}
		view 620
		loop 1
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(gCurRoom setScript: lookMonoGuys)
			)
			(4 ; Do
				(gCurRoom setScript: lookMonoGuys)
			)
			(1 ; Look
				(Print 615 1) ; "Some rather drab looking individuals hog space at the bar."
				(Print 615 2) ; "*** That one's really ugly!"
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
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: lookMonoGuys)
			)
			(5 ; Talk
				(gCurRoom setScript: lookMonoGuys)
			)
			(1 ; Look
				(Print 615 1) ; "Some rather drab looking individuals hog space at the bar."
				(Print 615 2) ; "*** That one's really ugly!"
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
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: lookMonoGuys)
			)
			(5 ; Talk
				(gCurRoom setScript: lookMonoGuys)
			)
			(1 ; Look
				(Print 615 1) ; "Some rather drab looking individuals hog space at the bar."
				(Print 615 2) ; "*** That one's really ugly!"
			)
			(else
				(super doVerb: theVerb &rest)
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
				(gLongSong fade: 80 20 20 0)
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
				(gLongSong fade:)
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
				(gEgo setMotion: PolyPath 102 174 self)
			)
			(1
				(if (IsFlag 15)
					(gEgo get: 14) ; matches
					(theMatches dispose:)
					(proc706_1)
					(HandsOn)
				else
					(= local1 1)
					(Print 615 3) ; "*** Your attempt to get the matches failed."
					(gCurRoom setScript: lookMonoGuys)
				)
				(self dispose:)
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
		lookStr {*** There is a stage here with two guys singing.}
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
		lookStr {*** There's the bar just as you remember it.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(++ local0)
				(if (not (IsFlag 16))
					(Print 615 4) ; "You step over to talk to the bartender. As you do you attract the attention of the crude fellows at the bar."
					(gCurRoom setScript: lookMonoGuys)
				else
					(switch local0
						(1
							(gCurRoom setScript: talkToBartender)
						)
						(else
							(Print 615 5) ; "You don't want to get into that mess again."
						)
					)
				)
			)
			(else
				(super doVerb: theVerb)
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

	(method (doVerb theVerb)
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

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(Print 615 6) ; "*** You see a book of matches on the bar counter top."
			)
			(4 ; Do
				(gCurRoom setScript: getMatches)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance barTender of Actor
	(properties
		description {barTender}
		lookStr {The bartender is a plain man nearly devoid of features.}
		view 618
		illegalBits 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(Print 615 7) ; "*** You see a man behind the bar serving drinks."
			)
			(4 ; Do
				(Print 615 8) ; "*** You have no time for a drink."
			)
			(5 ; Talk
				(++ local0)
				(if (not (IsFlag 16))
					(Print 615 4) ; "You step over to talk to the bartender. As you do you attract the attention of the crude fellows at the bar."
					(gCurRoom setScript: lookMonoGuys)
				else
					(switch local0
						(1
							(gCurRoom setScript: talkToBartender)
						)
						(else
							(Print 615 5) ; "You don't want to get into that mess again."
						)
					)
				)
			)
			(else
				(super doVerb: theVerb)
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

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(Print 615 9) ; "*** You see two guys singing."
			)
			(4 ; Do
				(Print 615 10) ; "*** The band members have nothing of interesting."
			)
			(2 ; Smell
				(Print 615 11) ; "*** They smell bad."
			)
			(else
				(super doVerb: theVerb)
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
		lookStr {From your position in the bar you can only see sky through the window.}
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

	(method (doVerb theVerb)
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
				(barTender setScript: 0 setCycle: Fwd)
				(cond
					((< (barTender x:) 147)
						(barTender setLoop: 0 setMotion: MoveTo 152 187 self)
					)
					((> (barTender x:) 169)
						(barTender setMotion: MoveTo 152 187 self)
					)
					(else
						(= seconds 1)
					)
				)
			)
			(2
				(barTender setLoop: 3)
				(= seconds 1)
			)
			(3
				(Print 615 12) ; "You speak to the bartender. He looks up at you and says "Hey! Aren't you the guy who broke my slot machine? You owe me some money!""
				(Print 615 13) ; "You explain that you are really very busy and must be going."
				(NormalEgo)
				(HandsOn)
				(barTender setScript: barTenderScript)
				(self dispose:)
			)
		)
	)
)

