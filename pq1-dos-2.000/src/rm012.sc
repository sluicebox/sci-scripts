;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use station)
(use RangeOsc)
(use eRS)
(use Inset)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm012 0
)

(instance rm012 of PQRoom
	(properties
		noun 3
		picture 12
	)

	(method (init)
		(self
			setRegions: 134 ; station
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 167 124 123 146 99 138 1 182 150 189 319 89 307 63 235 87 231 92 158 119
					yourself:
				)
		)
		(AIRVENT init:)
		(BOARD init:)
		(CABINET init:)
		(FORMS init:)
		(MEMO init:)
		(fbulletin_1 init:)
		(fbulletin_2 init:)
		(fbulletin_3 init:)
		(fbulletin_4 init:)
		(fbulletin_5 init:)
		(fbulletin_6 init:)
		(fbulletin_7 init:)
		(evidenceDoor init: stopUpd:)
		(elevatorDoor init: stopUpd:)
		(lights init: stopUpd:)
		(elevatorbutton init:)
		(gEgo init:)
		(switch gPrevRoomNum
			(18
				(gEgo posn: 193 81)
			)
			(17
				(gEgo posn: 64 119)
			)
			(13
				(gEgo posn: 260 82)
			)
			(else
				(gEgo posn: 68 164)
			)
		)
		(super init:)
		(switch gPrevRoomNum
			(18
				(self setScript: fromElevator)
			)
			(17
				(self setScript: fromEvidenceRoom)
			)
			(13
				(if
					(and
						(== global211 40)
						(not (IsFlag 4))
						(not (IsFlag 22))
					)
					(self setScript: memoReminder)
				else
					(self posn: 238 103 setScript: (ScriptID 896 1)) ; sWI
				)
			)
			(else
				(self posn: 133 140 setScript: (ScriptID 896 1)) ; sWI
			)
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 0))
		(cond
			(script 0)
			((& temp0 $0004)
				(cond
					((< global211 2)
						(self setScript: bounceFromDoor 0 7)
					)
					((and (== global211 40) (not (IsFlag 4)) (IsFlag 22))
						(self setScript: bounceFromDoor 0 1)
					)
					((and (gEgo has: 3) (== global211 31)) ; Patrol_Car_Keys
						(self setScript: bounceFromDoor 0 2)
					)
					((and (gEgo has: 3) (>= global211 52)) ; Patrol_Car_Keys
						(self setScript: bounceFromDoor 0 3)
					)
					((and (gEgo has: 2) (== global211 31)) ; Extender
						(self setScript: bounceFromDoor 0 4)
					)
					((and (gEgo has: 2) (>= global211 91)) ; Extender
						(self setScript: bounceFromDoor 0 5)
					)
					(
						(and
							(not (gEgo has: 2)) ; Extender
							(< global211 91)
							(!= global211 31)
						)
						(self setScript: bounceFromDoor 0 6)
					)
					(else
						(gCurRoom posn: 80 189 setScript: (ScriptID 896 2) 0 11) ; sWO
					)
				)
			)
			((& temp0 $0008)
				(gCurRoom posn: 255 88 setScript: (ScriptID 896 2) 0 13) ; sWO
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance fromEvidenceRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 73 124 self)
			)
			(1
				(gLongSong2 number: 913 loop: 1 play: self)
			)
			(2
				(evidenceDoor startUpd: setCycle: End self)
			)
			(3
				(gEgo setMotion: MoveTo 89 145 self)
			)
			(4
				(evidenceDoor setCycle: Beg self)
			)
			(5
				(gLongSong2 number: 914 loop: 1 play: self)
			)
			(6
				(evidenceDoor stopUpd:)
				(gEgo setLoop: -1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance toEvidenceRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 315 self)
			)
			(1
				(gLongSong2 number: 913 loop: 1 play: self)
			)
			(2
				(proc134_3 self)
			)
			(3
				(evidenceDoor startUpd: setCycle: End self)
			)
			(4
				(NormalEgo -1 7)
				(gEgo setMotion: MoveTo 73 124 self)
			)
			(5
				(evidenceDoor setCycle: Beg self)
			)
			(6
				(gLongSong2 number: 914 loop: 1 play: self)
			)
			(7
				(gEgo setMotion: MoveTo 64 119 self)
			)
			(8
				(gCurRoom newRoom: 17)
			)
		)
	)
)

(instance fromElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(self setScript: cycleLights self -1)
			)
			(1
				(gLongSong2 number: 920 loop: 1 play:)
				(elevatorDoor startUpd: setCycle: End self)
			)
			(2
				(gEgo setLoop: 4 setMotion: MoveTo 206 103 self)
			)
			(3
				(gEgo setLoop: -1)
				(gLongSong2 number: 921 loop: 1 play:)
				(elevatorDoor setCycle: Beg self)
			)
			(4
				(self setScript: cycleLights self 1)
			)
			(5
				(elevatorDoor stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 315 self)
			)
			(1
				(proc134_3 self)
			)
			(2
				(NormalEgo -1 7)
				(gEgo setMotion: MoveTo 206 103 self)
			)
			(3
				(gEgo setHeading: 315)
				(self setScript: cycleLights self -1)
			)
			(4
				(gLongSong2 number: 920 loop: 1 play:)
				(elevatorDoor startUpd: setCycle: End self)
			)
			(5
				(gEgo setMotion: MoveTo 193 81 self)
			)
			(6
				(gEgo setHeading: 45 self)
			)
			(7
				(proc134_2 self)
			)
			(8
				(NormalEgo -1 6)
				(gEgo posn: 193 81 setHeading: 135 self)
			)
			(9
				(gLongSong2 number: 921 loop: 1 play:)
				(elevatorDoor setCycle: Beg self)
			)
			(10
				(self setScript: cycleLights self 1)
			)
			(11
				(gCurRoom newRoom: 18)
			)
		)
	)
)

(instance cycleLights of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lights startUpd: setLoop: (if (== register 1) 2 else 3))
				(= cycles 1)
			)
			(1
				(lights setCycle: End self)
			)
			(2
				(lights setCycle: Beg self)
			)
			(3
				(lights setLoop: (+ (lights loop:) register))
				(if (<= 2 (lights loop:) 3)
					(-= state 3)
				else
					(lights setLoop: 2)
				)
				(= cycles 1)
			)
			(4
				(if (== register -1)
					(gLongSong2 number: 922 loop: 1 play:)
				)
				(lights stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance bounceFromDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 10 0 10 register self)
			)
			(1
				(gEgo setMotion: MoveTo 144 148 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fillOutMemo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 4)
				(gEgo setHeading: 315 self)
			)
			(1
				(gEgo
					view: 113
					loop: 1
					cel: 7
					posn: 162 123
					setCycle: CT 3 -1 self
				)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(NormalEgo -1 7)
				(gEgo posn: 158 123 setMotion: MoveTo 138 141 self)
			)
			(4
				(gEgo setHeading: 315 self)
			)
			(5
				(gEgo
					view: 113
					loop: 0
					cel: 0
					posn: 140 140
					setCycle: CT 6 1 self
				)
			)
			(6
				(gMessager say: 15 4 1 0 self) ; "Summoning up your best grammar, you write a memo to Lt. Morgan requesting a transfer to Narcotics."
			)
			(7
				(gEgo setCycle: RangeOsc 5 6 8 self)
			)
			(8
				(gEgo setCycle: CT 4 -1)
				(= seconds 3)
			)
			(9
				(gEgo setCycle: CT 6 1 self)
			)
			(10
				(gEgo setCycle: RangeOsc 5 6 8 self)
			)
			(11
				(gEgo setCycle: Beg self)
			)
			(12
				(NormalEgo -1 7)
				(gEgo posn: 138 141 setMotion: MoveTo 158 123 self)
			)
			(13
				(gEgo setHeading: 315 self)
			)
			(14
				(gEgo
					view: 113
					loop: 1
					cel: 7
					posn: 162 123
					setCycle: CT 3 -1 self
				)
			)
			(15
				(gEgo setCycle: End self)
			)
			(16
				(NormalEgo -1 7)
				(gEgo posn: 160 123 setMotion: MoveTo 168 135 self)
			)
			(17
				(SetScore 115 2)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lookAtMemo of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 315 self)
			)
			(1
				(HandsOn)
				(gTheIconBar disable: 5 0 3 4 2)
				(gCurRoom setInset: memoInset self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance memoReminder of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(laura init:)
				(SetFlag 22)
				(gEgo setMotion: MoveTo 221 100 self)
			)
			(1
				(elevatorDoor startUpd: setCycle: End self)
			)
			(2
				(gEgo setHeading: 315 self)
			)
			(3
				(laura setMotion: MoveTo 191 113 self)
			)
			(4
				(gEgo setHeading: 270 self)
				(laura setHeading: 90 self)
				(elevatorDoor setCycle: Beg self)
			)
			(5)
			(6)
			(7
				(elevatorDoor stopUpd:)
				(gMessager say: 10 0 7 0 self) ; "Hi, Sonny. Did you fill out that request form yet? Morgan wants to make a decision soon."
			)
			(8
				(laura setMotion: MoveTo 263 97 self)
			)
			(9
				(laura dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance elevatorDoor of Prop
	(properties
		x 169
		y 33
		noun 2
		view 112
		loop 1
		priority 6
		signal 16400
	)
)

(instance evidenceDoor of Prop
	(properties
		x 71
		y 83
		noun 1
		approachX 89
		approachY 145
		view 112
		priority 9
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 1) ; Do, Look
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (gCurRoom script:))
					(gCurRoom setScript: toEvidenceRoom)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lights of Prop
	(properties
		x 197
		y 38
		noun 8
		view 112
		loop 2
		priority 7
		signal 16
	)
)

(instance AIRVENT of Feature
	(properties
		x 126
		y 53
		noun 9
		sightAngle 40
		onMeCheck 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance BOARD of Feature
	(properties
		x 118
		z -87
		noun 4
		sightAngle 40
		onMeCheck 8192
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance CABINET of Feature
	(properties
		x 127
		y 122
		noun 7
		sightAngle 40
		onMeCheck 4096
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance FORMS of Feature
	(properties
		x 154
		y 78
		noun 15
		sightAngle 40
		onMeCheck 2048
		approachX 158
		approachY 123
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 1 4) ; Look, Do
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(cond
					((OneOf global211 0 31 38)
						(gMessager say: 15 4 11 0) ; "Paperwork?! NOW?! You're off duty. Who wants to do paperwork when they're off duty? Do it on Police time."
					)
					((IsFlag 4)
						(gMessager say: 15 4 12 0) ; "You've already submitted one transfer request; there's no point in filling out another. If you did, they'd probably transfer you back again."
					)
					(else
						(gCurRoom setScript: fillOutMemo)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance MEMO of Feature
	(properties
		x 125
		y 92
		noun 5
		sightAngle 40
		onMeCheck 1024
		approachX 145
		approachY 138
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 1 4) ; Look, Do
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(if (not (gCurRoom script:))
					(gCurRoom setScript: lookAtMemo)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance elevatorbutton of Feature
	(properties
		noun 6
		onMeCheck 2
		approachX 230
		approachY 90
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 1) ; Do, Look
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (gCurRoom script:))
					(gCurRoom setScript: enterElevator)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fbulletin_1 of Feature
	(properties
		x 112
		y 86
		noun 16
		nsTop 85
		nsLeft 127
		nsBottom 87
		nsRight 129
		sightAngle 40
		approachX 145
		approachY 138
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 1) ; Do, Look
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fbulletin_2 of Feature
	(properties
		x 109
		y 81
		noun 17
		nsTop 79
		nsLeft 108
		nsBottom 84
		nsRight 110
		sightAngle 40
		approachX 145
		approachY 138
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 1) ; Do, Look
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fbulletin_3 of Feature
	(properties
		x 124
		y 85
		noun 18
		nsTop 84
		nsLeft 123
		nsBottom 86
		nsRight 125
		sightAngle 40
		approachX 145
		approachY 138
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 1) ; Do, Look
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fbulletin_4 of Feature
	(properties
		x 116
		y 94
		noun 19
		nsTop 90
		nsLeft 114
		nsBottom 98
		nsRight 119
		sightAngle 40
		approachX 145
		approachY 138
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 1) ; Do, Look
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fbulletin_5 of Feature
	(properties
		x 112
		y 105
		noun 20
		nsTop 102
		nsLeft 110
		nsBottom 108
		nsRight 114
		sightAngle 40
		approachX 145
		approachY 138
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 1) ; Do, Look
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fbulletin_6 of Feature
	(properties
		x 128
		y 86
		noun 21
		nsTop 84
		nsLeft 111
		nsBottom 89
		nsRight 114
		sightAngle 40
		approachX 145
		approachY 138
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 1) ; Do, Look
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fbulletin_7 of Feature
	(properties
		x 125
		y 77
		noun 22
		nsTop 74
		nsLeft 123
		nsBottom 81
		nsRight 128
		sightAngle 40
		approachX 145
		approachY 138
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance memoInset of Inset
	(properties
		view 887
		x 182
		y 75
		priority 15
		disposeNotOnMe 1
		noun 5
	)
)

(instance laura of Actor
	(properties
		x 180
		y 88
		heading 135
		view 12
		loop 4
	)

	(method (init)
		(super init: &rest)
		(proc134_4 self)
	)
)

