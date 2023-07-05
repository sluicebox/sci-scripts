;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use station)
(use eRS)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm013 0
	officerT 1
)

(instance rm013 of PQRoom
	(properties
		noun 4
		picture 13
	)

	(method (init)
		(self
			setRegions: 134 ; station
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 65 146 66 165 248 166 248 121 214 112 179 134 140 124 138 118 163 104 88 86 68 94 133 109 131 115 106 126 101 123 82 132 86 135
					yourself:
				)
		)
		(briefingRoomDoor init:)
		(officeDoor init:)
		(lockerRoomDoor init:)
		(sideCabinet init:)
		(gEgo init:)
		(switch gPrevRoomNum
			(16
				(gEgo posn: 72 117)
			)
			(15
				(gEgo posn: 156 73)
			)
			(14
				(gEgo posn: 259 112)
			)
			(else
				(gEgo posn: 102 88)
			)
		)
		(if (not (gEgo has: 2)) ; Extender
			(radio init:)
		)
		(if (not (gEgo has: 3)) ; Patrol_Car_Keys
			(patrolKey init:)
		)
		(fKeyBd init:)
		(fRadio init:)
		(fCabinetDoor init:)
		(fCabinet init:)
		(super init: &rest)
		(if (OneOf global206 124 125)
			(man1 init:)
		)
		(switch gPrevRoomNum
			(16
				(self setScript: fromOffice)
				(if (== global211 29)
					(man1 init:)
					(man2 init:)
				)
			)
			(15
				(self setScript: fromBriefingRoom)
			)
			(14
				(self setScript: fromLockerRoom)
			)
			(else
				(if (== global211 28)
					(girl1 addToPic:)
					(girl2 addToPic:)
					(man1 init:)
					(man2 init:)
					(self setScript: chickenConv)
				else
					(self posn: 134 109 setScript: (ScriptID 896 1)) ; sWI
				)
			)
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 0))
		(cond
			(script 0)
			((& temp0 $0002)
				(self posn: 95 89 setScript: (ScriptID 896 2) 0 12) ; sWO
			)
		)
		(super doit: &rest)
	)
)

(instance toBriefingRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 45 self)
			)
			(1
				(proc134_2 self)
			)
			(2
				(gLongSong2 number: 913 loop: 1 play: self)
			)
			(3
				(briefingRoomDoor startUpd: setCycle: End self)
			)
			(4
				(NormalEgo -1 6)
				(gEgo setPri: 5 setMotion: MoveTo 159 73 self)
			)
			(5
				(gCurRoom newRoom: 15)
			)
		)
	)
)

(instance getIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion:
						PolyPath
						(switch register
							(radio 178)
							(patrolKey 158)
						)
						(switch register
							(radio 140)
							(patrolKey 104)
						)
						self
				)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(proc134_3 self)
				(SetScore
					(switch register
						(radio 114)
						(patrolKey 113)
					)
					(switch register
						(radio 2)
						(patrolKey 1)
					)
				)
			)
			(3
				(NormalEgo -1 7)
				(register dispose:)
				(gEgo
					get:
						(switch register
							(radio 2)
							(patrolKey 3)
						)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance putIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion:
						PolyPath
						(switch register
							(radio 178)
							(patrolKey 158)
						)
						(switch register
							(radio 140)
							(patrolKey 104)
						)
						self
				)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(proc134_3 self)
			)
			(3
				(NormalEgo -1 7)
				(register init:)
				(gEgo
					put:
						(switch register
							(radio 2)
							(patrolKey 3)
						)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance toLockerRoom of Script
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
				(gLongSong2 number: 913 loop: 1 play: self)
			)
			(3
				(lockerRoomDoor startUpd: setCycle: End self)
			)
			(4
				(NormalEgo -1 6)
				(gEgo setMotion: MoveTo 240 103 self)
			)
			(5
				(gEgo setMotion: MoveTo 263 105 self)
			)
			(6
				(lockerRoomDoor setCycle: Beg self)
			)
			(7
				(gLongSong2 number: 914 loop: 1 play: self)
			)
			(8
				(gCurRoom newRoom: 14)
			)
		)
	)
)

(instance toOffice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 315 self)
			)
			(1
				(proc134_3 self 1)
			)
			(2
				(gLongSong2 number: 913 loop: 1 play: self)
			)
			(3
				(officeDoor startUpd: setCycle: End self)
			)
			(4
				(officeDoor hide:)
				(NormalEgo -1 7)
				(gEgo setMotion: MoveTo 71 120 self)
			)
			(5
				(officeDoor show: setCycle: Beg self)
			)
			(6
				(gLongSong2 number: 914 loop: 1 play: self)
			)
			(7
				(gCurRoom newRoom: 16)
			)
		)
	)
)

(instance fromBriefingRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setLoop: 5 setMotion: MoveTo 127 100 self)
			)
			(1
				(gEgo setLoop: -1)
				(briefingRoomDoor startUpd: setCycle: Beg self)
			)
			(2
				(gLongSong2 number: 914 loop: 1 play: self)
			)
			(3
				(HandsOn)
				(briefingRoomDoor stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance fromOffice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(officeDoor startUpd: hide:)
				(gEgo setLoop: 4 setMotion: MoveTo 99 130 self)
			)
			(1
				(gEgo setLoop: -1)
				(officeDoor show: setCycle: Beg self)
			)
			(2
				(gLongSong2 number: 914 loop: 1 play: self)
			)
			(3
				(officeDoor stopUpd:)
				(if (== global211 29)
					(= next invite)
				else
					(HandsOn)
				)
				(self dispose:)
			)
		)
	)
)

(instance fromLockerRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 241 106 self)
			)
			(1
				(gEgo setMotion: MoveTo 218 120 self)
			)
			(2
				(lockerRoomDoor startUpd: setCycle: Beg self)
			)
			(3
				(gLongSong2 number: 914 loop: 1 play: self)
			)
			(4
				(lockerRoomDoor stopUpd:)
				(if (OneOf global206 124 125)
					(= next dooleyMayor)
				else
					(HandsOn)
				)
				(self dispose:)
			)
		)
	)
)

(instance dooleyMayor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 10 0 5 0 self) ; "And, Mr. Mayor, this is the rest of the downstairs area of our facility. As you can see, we keep a..."
			)
			(1
				(man1 setHeading: 90 self)
				(man2 setCel: 3)
				(gEgo setHeading: 270 self)
			)
			(2)
			(3
				(gMessager say: 10 0 6 0 self) ; "BONDS, WHERE THE HELL HAVE YOU... ah.. pardon me, Mr. Mayor."
			)
			(4
				(EgoDead)
			)
		)
	)
)

(instance invite of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 10 0 4 0 self) ; "Boy, I bet Dooley's really pissed."
			)
			(1
				(man1 setMotion: MoveTo 46 174 self)
				(man2 setMotion: MoveTo 139 103 self)
			)
			(2)
			(3
				(man2 setMotion: MoveTo 87 88 self)
			)
			(4
				(man1 dispose:)
				(man2 dispose:)
				(= global211 30)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance chickenInWindow of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dooley setMotion: MoveTo 74 124 self)
				(chicken setMotion: MoveTo 84 88 self)
			)
			(1)
			(2
				(dooley setMotion: MoveTo 90 118 self)
				(chicken setMotion: MoveTo 71 93 self)
			)
			(3)
			(4
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance chickenConv of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 140 107 self)
			)
			(1
				(gEgo setHeading: 225 self)
			)
			(2
				(man2 setMotion: MoveTo 127 121 self)
			)
			(3
				(gMessager say: 10 0 3 0 self) ; "Hey, Sonny, you gotta see this! Dooley's really got his hands full! I don't know who this 'Gremlin' is but I sure am enjoying the grief he's causing Dooley."
			)
			(4
				(gEgo setMotion: MoveTo 98 128 self)
				(man2 setMotion: MoveTo 129 133 self)
			)
			(5)
			(6
				(man2 setHeading: 270)
				(= next toOffice)
				(self dispose:)
			)
		)
	)
)

(instance dooley of Officer
	(properties
		view 133
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self
			view: 133
			loop: 0
			priority: 6
			signal: 16400
			posn: 90 118
			setCycle: Fwd
		)
	)
)

(instance chicken of Actor
	(properties
		view 140
		loop 1
		priority 6
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd posn: 71 93)
	)
)

(instance man1 of Actor
	(properties
		x 104
		y 149
		heading 315
		view 0
		loop 7
	)

	(method (init)
		(super init: &rest)
		(if (OneOf global206 124 125)
			(self view: 132 loop: 6 posn: 118 138)
			(man2 init:)
		)
		(proc134_4 self)
	)
)

(instance man2 of Actor
	(properties
		x 125
		y 141
		heading 270
		view 110
		loop 1
	)

	(method (init)
		(super init: &rest)
		(if (OneOf global206 124 125)
			(self view: 115 loop: 6 cel: 2 posn: 137 126)
		else
			(proc134_4 self)
		)
	)
)

(instance girl1 of View
	(properties
		x 75
		y 155
		view 115
		loop 6
		cel 1
	)
)

(instance girl2 of View
	(properties
		x 93
		y 158
		view 115
		loop 6
	)
)

(instance radio of View
	(properties
		x 173
		y 107
		view 114
		loop 3
		priority 9
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((gEgo has: 2) ; Extender
						(gMessager say: 5 4 8 0) ; "One radio extender is plenty."
					)
					((== global206 2)
						(gMessager say: 5 4 10 0) ; "Don't take a police radio extender undercover! If the find it on you, you're dead meat."
					)
					(else
						(gCurRoom setScript: getIt 0 self)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance patrolKey of View
	(properties
		x 153
		y 68
		noun 6
		view 114
		loop 3
		cel 1
		priority 6
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((gEgo has: 3) ; Patrol_Car_Keys
						(gMessager say: noun 4 7 0) ; "You already have the key to the squad car."
					)
					((>= global211 52)
						(gMessager say: noun 4 10 0) ; "You're a narcotics officer now. You don't need those squad car keys anymore."
					)
					(else
						(gCurRoom setScript: getIt 0 self)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance officerT of Narrator
	(properties
		x 150
		y 100
		talkWidth 130
	)

	(method (init)
		(= font gUserFont)
		(super init: &rest)
	)
)

(instance fKeyBd of Feature
	(properties
		x 160
		y 63
		noun 6
		sightAngle 40
		onMeCheck 16384
		approachX 142
		approachY 106
		approachDist 70
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Patrol_Car_Keys
				(gCurRoom setScript: putIt 0 patrolKey)
			)
			(4 ; Do
				(patrolKey doVerb: 4)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fRadio of Feature
	(properties
		x 169
		y 98
		noun 5
		sightAngle 40
		onMeCheck 2048
		approachX 155
		approachY 131
		approachDist 65
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(radio doVerb: 4)
			)
			(11 ; Extender
				(gCurRoom setScript: putIt 0 radio)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fCabinetDoor of Feature
	(properties
		x 164
		y 115
		noun 8
		nsTop 107
		nsLeft 154
		nsBottom 124
		nsRight 175
		sightAngle 40
		approachX 157
		approachY 129
		approachDist 25
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sideCabinet of Feature
	(properties
		x 182
		y 115
		noun 9
		nsTop 107
		nsLeft 177
		nsBottom 123
		nsRight 188
		sightAngle 40
		approachX 191
		approachY 127
		approachDist 27
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fCabinet of Feature
	(properties
		x 171
		y 111
		noun 7
		sightAngle 40
		onMeCheck 8192
		approachX 155
		approachY 131
		approachDist 57
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(radio doVerb: 4)
			)
			(11 ; Extender
				(gCurRoom setScript: putIt 0 radio)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance briefingRoomDoor of Prop
	(properties
		x 123
		y 87
		noun 1
		approachX 120
		approachY 99
		view 114
		loop 1
		priority 4
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self
			approachVerbs: 4 ; Do
			setCel:
				(if (== gPrevRoomNum 15)
					(self lastCel:)
				else
					0
				)
			stopUpd:
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== global206 0)
					(gCurRoom setScript: toBriefingRoom)
				else
					(gMessager say: 10 4 9 0) ; "Only uniformed officers are allowed in the briefing room."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance officeDoor of Prop
	(properties
		x 78
		y 126
		noun 3
		approachX 98
		approachY 128
		view 114
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self
			approachVerbs: 4 ; Do
			setCel:
				(if (== gPrevRoomNum 16)
					(self lastCel:)
				else
					0
				)
			stopUpd:
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (OneOf global211 52 29))
					(gCurRoom setScript: toOffice)
				else
					(gMessager say: 10 4 4 0) ; "You don't want to interrupt Dooley and his new friend, do you? They make such a fun couple."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lockerRoomDoor of Prop
	(properties
		x 223
		y 106
		noun 2
		approachX 237
		approachY 125
		view 114
		loop 2
		priority 6
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self
			approachVerbs: 4 ; Do
			setCel:
				(if (== gPrevRoomNum 14)
					(self lastCel:)
				else
					0
				)
			stopUpd:
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (gCurRoom script:))
					(gCurRoom setScript: toLockerRoom)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

