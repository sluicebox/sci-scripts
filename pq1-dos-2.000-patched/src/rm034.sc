;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34)
(include sci.sh)
(use Main)
(use station)
(use eRS)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use DPath)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm034 0
	suspectTalker 1
)

(local
	local0
	local1
	local2
	[local3 68] = [7 4 105 163 9 7 110 159 107 164 0 0 0 0 0 0 0 8 2 98 156 9 6 103 156 122 172 0 0 0 0 0 0 0 9 2 85 154 9 6 89 154 115 185 0 0 0 0 0 0 0 8 4 85 154 9 6 89 154 115 185 0 0 0 0 0 0 0]
	[local71 68] = [84 159 302 2 83 157 6 84 159 110 159 7 4 6 105 163 9 122 172 0 0 0 0 6 122 172 103 156 8 2 8 98 156 9 115 175 0 0 0 0 6 115 175 89 154 9 2 8 85 154 9 115 175 0 0 0 0 6 115 175 89 154 8 4 8 85 154 9]
	[local139 30] = [363 2 9 128 145 0 0 297 7 121 153 122 171 0 0 280 3 9 118 155 0 0 342 7 116 155 122 171 0 0]
)

(instance rm034 of PQRoom
	(properties
		noun 11
		picture 34
	)

	(method (handleEvent event &tmp temp0)
		(if (User controls:)
			(if
				(and
					local2
					(not (gCurRoom script:))
					(!= (event type:) evVERB)
					(not
						(OneOf
							(event message:)
							KEY_TAB
							KEY_CONTROL
							KEY_F1
							KEY_F2
							KEY_F5
							KEY_F7
							KEY_F9
						)
					)
					(not (event modifiers:))
					(OneOf
						(gTheIconBar curIcon:)
						(gTheIconBar at: 0)
						(gTheIconBar at: 2)
					)
				)
				(event claimed: 1)
				(frontDoor doVerb: 4)
			else
				(super handleEvent: event &rest)
			)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (init)
		(gCurRoom
			setRegions: 134 ; station
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 23 173 83 189 319 189 319 158 233 130 297 99 253 86 190 116 0 72 0 131
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 94 107 198 131 237 144 242 154 205 179 179 179 23 132 24 121 70 105
					yourself:
				)
		)
		(super init:)
		(if (OneOf global211 24 47 58 70)
			(++ global211)
		)
		(LoadMany rsSOUND 341 111 900 901)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(LoadMany rsVIEW 287 279)
		(switch global211
			(25
				(= local0 15)
				(LoadMany rsVIEW 280 342)
			)
			(48
				(= local0 0)
				(LoadMany rsVIEW 363 297)
			)
			(71
				(= local0 30)
				(LoadMany rsVIEW 281 282 398 394 13 12)
			)
			(else
				(= local0 -1)
			)
		)
		(switch global207
			(914
				(= local1 0)
				(LoadMany rsVIEW 103)
			)
			(105
				(= local1 17)
				(LoadMany rsVIEW 107)
			)
			(104
				(= local1 34)
				(LoadMany rsVIEW 208)
			)
		)
		(switch global206
			(0
				(LoadMany rsVIEW 7)
			)
			(1
				(LoadMany rsVIEW 8)
			)
			(2
				(LoadMany rsVIEW 9)
			)
		)
		(if (and (== local1 34) (== global206 1))
			(= local1 51)
		)
		(fDriveway init:)
		(fWindow init:)
		(fSidewalk init:)
		(fLockers init:)
		(fButton init:)
		(fBushes init:)
		(fFence init:)
		(fColumns init:)
		(fColumn2 init:)
		(car addToPic:)
		(door init:)
		(if (!= gPrevRoomNum 35)
			(= local2 1)
			(gEgo
				init:
				setCycle: 0
				view: [local3 (+ local1 0)]
				loop: [local3 (+ local1 1)]
				cel: 0
				posn: [local3 (+ local1 2)] [local3 (+ local1 3)]
				setPri: [local3 (+ local1 4)]
			)
			(if (== global211 71)
				(suspect init:)
				(self setScript: dealerBust)
			else
				(self setScript: fromCar)
			)
		else
			(= local2 0)
			(gEgo init: posn: 316 74)
			(self setScript: fromJail)
		)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(DisposeScript 930)
		(super dispose:)
	)
)

(instance useLocker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 315 self)
			)
			(1
				(gEgo
					view: 287
					loop:
						(switch global206
							(0 1)
							(else 0)
						)
					cel: 0
					setCycle: End self
				)
			)
			(2
				(self setScript: (ScriptID 341 0) self) ; lookAtLocker
			)
			(3
				(NormalEgo -1 7)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fromCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance toJail of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(LoadMany rsSOUND 111 341)
				(gEgo setHeading: 315 self)
			)
			(1
				(gEgo
					view: 287
					loop:
						(switch global206
							(0 1)
							(else 0)
						)
					cel: 0
					setCycle: End self
				)
				(gLongSong2 number: 341 loop: 1 play:)
			)
			(2
				(NormalEgo -1 7)
				(gMessager say: 8 4 0 0 self) ; "You press the entry buzzer alerting the guard inside that you wish to enter."
			)
			(3
				(gEgo setMotion: PolyPath 268 91 self)
			)
			(4
				(gLongSong2 number: 111 loop: 1 play: self)
			)
			(5
				(gLongSong2 client: 0)
				(gEgo setHeading: 45)
				(door startUpd: setCycle: End self)
			)
			(6
				(if (gCast contains: suspect)
					(gMessager say: (suspect noun:) 2 9 0 self)
				else
					(= cycles 1)
				)
			)
			(7
				(if (gCast contains: suspect)
					(suspect ignoreActors: 1 setMotion: MoveTo 316 74 self)
				else
					(= cycles 1)
				)
			)
			(8
				(gEgo setMotion: MoveTo 316 74 self)
			)
			(9
				(gCurRoom newRoom: 35)
			)
		)
	)
)

(instance fromJail of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 268 91 self)
			)
			(1
				(gEgo setMotion: MoveTo 254 105 self)
			)
			(2
				(gLongSong2 number: 111 loop: 1 play: self)
			)
			(3
				(gLongSong2 client: 0)
				(door startUpd: setCycle: Beg self)
			)
			(4
				(door stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoGetInCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local2 1)
				(gEgo
					setMotion:
						PolyPath
						[local71 (+ local1 0)]
						[local71 (+ local1 1)]
						self
				)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(gLongSong2 number: 900 loop: 1 play:)
				(frontDoor startUpd: setCycle: End self)
			)
			(3
				(NormalEgo -1 [local71 (+ local1 6)])
				(gEgo
					posn: [local71 (+ local1 7)] [local71 (+ local1 8)]
					setMotion:
						MoveTo
						[local71 (+ local1 9)]
						[local71 (+ local1 10)]
						self
				)
			)
			(4
				(gEgo setHeading: 45 self)
			)
			(5
				(gEgo
					view: [local71 (+ local1 11)]
					loop: [local71 (+ local1 12)]
					cel: [local71 (+ local1 13)]
					posn: [local71 (+ local1 14)] [local71 (+ local1 15)]
					setCycle: Beg self
				)
			)
			(6
				(gEgo setPri: [local71 (+ local1 16)])
				(frontDoor setCycle: Beg self)
			)
			(7
				(gLongSong2 number: 901 loop: 1 play: self)
			)
			(8
				(cond
					((== global211 60)
						(= global211 62)
						(gCurRoom newRoom: 11)
					)
					((OneOf global211 83 26 49)
						(++ global211)
						(gCurRoom newRoom: 500)
					)
					((== global211 72)
						(= global211 74)
						(gCurRoom newRoom: 500)
					)
					(else
						(gCurRoom newRoom: 500)
					)
				)
			)
		)
	)
)

(instance egoGetOutOfCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local2 0)
				(gLongSong2 number: 900 loop: 1 play: self)
			)
			(1
				(frontDoor startUpd: setCycle: End self)
			)
			(2
				(gEgo setPri: -1 setCycle: End self)
			)
			(3
				(NormalEgo -1 [local3 (+ local1 5)])
				(gEgo
					posn: [local3 (+ local1 6)] [local3 (+ local1 7)]
					setMotion:
						MoveTo
						[local3 (+ local1 8)]
						[local3 (+ local1 9)]
						self
				)
			)
			(4
				(if (== global211 71)
					(= cycles 1)
				else
					(frontDoor setCycle: Beg self)
				)
			)
			(5
				(if (== global211 71)
					(= cycles 1)
				else
					(gLongSong2 number: 901 loop: 1 play: self)
				)
			)
			(6
				(frontDoor stopUpd:)
				(gEgo setHeading: 45 self)
			)
			(7
				(cond
					((== global211 71)
						(self dispose:)
					)
					((not (OneOf global211 25 48))
						(HandsOn)
						(self dispose:)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(8
				(gLongSong2 number: 900 loop: 1 play: self)
			)
			(9
				(backDoor startUpd: setCycle: End self)
			)
			(10
				(NormalEgo -1 6)
				(gEgo posn: 110 164 setMotion: MoveTo 89 174 self)
			)
			(11
				(gEgo setHeading: 45 self)
			)
			(12
				(if (OneOf local0 0 15)
					(= next suspectGetOut)
				else
					(HandsOn)
				)
				(self dispose:)
			)
		)
	)
)

(instance suspectGetOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: (if (== local0 0) 14 else 13) 2 5 0 self)
			)
			(1
				(suspect setPri: 11 setCycle: End self)
			)
			(2
				(proc134_4
					suspect
					[local139 (+ local0 7)]
					[local139 (+ local0 8)]
					[local139 (+ local0 9)]
					[local139 (+ local0 10)]
				)
				(suspect
					setPri: -1
					setMotion:
						MoveTo
						[local139 (+ local0 11)]
						[local139 (+ local0 12)]
						self
				)
			)
			(3
				(backDoor setCycle: Beg self)
			)
			(4
				(gLongSong2 number: 901 loop: 1 play: self)
			)
			(5
				(Face suspect gEgo self)
			)
			(6
				(gMessager say: (if (== local0 0) 14 else 13) 2 4 0 self)
			)
			(7
				(backDoor addToPic:)
				(suspect setScript: suspectMove)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance dealerBust of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(self setScript: egoGetOutOfCar self)
			)
			(1
				(gLongSong2 number: 900 loop: 1 play:)
				(laura setCycle: Beg self)
			)
			(2
				(proc134_4 laura 12 5 151 130)
				(laura setMotion: MoveTo 132 105 self)
			)
			(3
				(laura setHeading: 135)
				(suspect setCycle: End self)
				(suspect2 setCycle: End self)
			)
			(4)
			(5
				(proc134_4 suspect 398 7 105 157)
				(proc134_4 suspect2 394 5 142 130)
				(suspect2 setMotion: MoveTo 176 122 self)
				(suspect setMotion: DPath 125 183 227 188 219 134 self)
			)
			(6
				(gLongSong2 number: 901 loop: 1 play:)
				(frontDoor setCycle: Beg)
			)
			(7
				(Face laura gEgo self)
			)
			(8
				(frontDoor stopUpd:)
				(gMessager say: 12 2 6 0 self) ; "Hey, Sonny. I'll take Laurel and Hardy inside while you take care of the car and your gun."
			)
			(9
				(laura setHeading: 90 self)
			)
			(10
				(gMessager say: 12 2 4 0 self) ; "C'mon gentlemen. You don't want to keep a lady waiting, do you? Your castle awaits."
			)
			(11
				(suspect setMotion: MoveTo 254 92 self)
				(suspect2 setMotion: MoveTo 272 96 self)
				(laura setMotion: PolyPath 246 104 self)
			)
			(12)
			(13)
			(14
				(gLongSong2 number: 341 loop: 1 play: self)
			)
			(15
				(gLongSong2 number: 111 loop: 1 play:)
				(door startUpd: setCycle: End self)
			)
			(16
				(suspect ignoreActors: 1 setMotion: MoveTo 319 72 self)
				(suspect2 ignoreActors: 1 setMotion: MoveTo 319 72 self)
				(laura ignoreActors: 1 setMotion: MoveTo 319 72 self)
			)
			(17)
			(18)
			(19
				(gLongSong2 number: 111 loop: 1 play:)
				(suspect dispose:)
				(suspect2 dispose:)
				(laura dispose:)
				(door setCycle: Beg self)
			)
			(20
				(HandsOn)
				(door stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance suspectMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(suspect setPri: -1 setMotion: PolyPath 257 116 self)
			)
			(1
				(suspect setHeading: 225)
				(self dispose:)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 304
		y 92
		noun 10
		approachX 268
		approachY 91
		view 279
		priority 1
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self
			approachVerbs: 4 ; Do
			setCel:
				(if (== gPrevRoomNum 35)
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
				(if local2
					(car doVerb: 4)
				else
					(gMessager say: noun 4 0 0) ; "You can't open it yourself."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance car of View
	(properties
		x 96
		y 105
		view 103
		cel 1
		priority 9
		signal 16400
	)

	(method (init)
		(switch global207
			(914
				(self view: 103 loop: 0 cel: 1 noun: 9 x: 96 y: 105)
				(super init: &rest)
				(frontDoor init:)
				(backDoor init:)
				(topLights init:)
				(blueLight init:)
				(redLight init:)
				(if (and (!= gPrevRoomNum 35) (OneOf global211 25 48))
					(suspect init:)
				)
			)
			(105
				(self view: 107 loop: 0 cel: 1 noun: 9 x: 78 y: 96)
				(super init: &rest)
				(frontDoor init:)
			)
			(104
				(self view: 208 loop: 1 cel: 0 noun: 9 x: 78 y: 125)
				(super init: &rest)
				(frontDoor init:)
			)
		)
	)
)

(instance frontDoor of Prop
	(properties
		x 90
		y 172
		z 50
		view 103
		loop 2
		priority 11
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(switch global207
			(914
				(self view: 103 loop: 2 cel: 0 noun: 9 x: 90 y: 172)
			)
			(105
				(self view: 107 loop: 1 cel: 0 noun: 9 x: 85 y: 186)
			)
			(104
				(self view: 208 loop: 2 cel: 0 noun: 9 x: 80 y: 176)
			)
		)
		(super init: &rest)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					(local2
						(gCurRoom setScript: egoGetOutOfCar)
					)
					((OneOf global211 25 48 71)
						(gMessager say: 23 0 7 0) ; "Don't leave without booking your prisoner. It kind of defeats the purpose of the arrest."
					)
					((and (not (IsFlag 85)) (not (gEgo has: 0))) ; Service_Revolver
						(gMessager say: 23 0 8 0) ; "Aren't you forgetting something? Those police service revolvers are expensive. You shouldn't leave it behind in the locker."
					)
					(else
						(gCurRoom setScript: egoGetInCar)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance backDoor of Prop
	(properties
		x 110
		y 127
		view 103
		loop 3
		priority 11
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)
)

(instance topLights of Prop
	(properties
		x 115
		y 115
		view 103
		loop 4
		priority 10
		signal 16400
		detailLevel 2
	)

	(method (init)
		(super init: &rest)
		(if (OneOf global211 25 48 49 26)
			(self setCycle: Fwd)
		else
			(self stopUpd:)
		)
	)
)

(instance blueLight of Prop
	(properties
		x 148
		y 131
		view 103
		loop 5
		cel 3
		priority 10
		signal 16400
		detailLevel 2
	)

	(method (init)
		(super init: &rest)
		(if (OneOf global211 25 48 49 26)
			(self setCycle: Fwd)
		else
			(self stopUpd:)
		)
	)
)

(instance redLight of Prop
	(properties
		x 144
		y 132
		view 103
		loop 6
		priority 10
		signal 16400
		detailLevel 2
	)

	(method (init)
		(super init: &rest)
		(if (OneOf global211 25 48 49 26)
			(self setCycle: Fwd)
		else
			(self stopUpd:)
		)
	)
)

(instance suspect of Actor
	(properties
		view 0
		signal 16384
	)

	(method (init)
		(= noun
			(switch local0
				(15 13)
				(0 14)
				(30 21)
			)
		)
		(if (!= global211 71)
			(self
				view: [local139 (+ local0 0)]
				loop: [local139 (+ local0 1)]
				cel: 0
				setPri: [local139 (+ local0 2)]
				posn: [local139 (+ local0 3)] [local139 (+ local0 4)]
			)
			(super init: &rest)
		else
			(self view: 281 loop: 1 cel: 0 posn: 109 155 setPri: 9)
			(super init: &rest)
			(suspect2 init:)
			(laura init:)
		)
	)
)

(instance suspect2 of Actor
	(properties
		x 148
		y 133
		view 282
		loop 1
		priority 8
		signal 16400
	)
)

(instance laura of Actor
	(properties
		x 135
		y 130
		noun 12
		view 13
		cel 8
		priority 8
		signal 16400
	)
)

(instance suspectTalker of Narrator
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

(instance fColumns of Feature
	(properties
		x 188
		y 61
		noun 18
		nsTop 39
		nsLeft 184
		nsBottom 84
		nsRight 192
		sightAngle 40
		approachX 213
		approachY 121
		approachDist 111
	)
)

(instance fColumn2 of Feature
	(properties
		x 262
		y 132
		z -50
		noun 18
		nsTop 56
		nsLeft 258
		nsBottom 109
		nsRight 266
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fFence of Feature
	(properties
		x 6
		y 39
		noun 1
		nsTop 10
		nsBottom 69
		nsRight 12
		sightAngle 40
		approachX 18
		approachY 86
		approachDist 106
	)
)

(instance fDriveway of Feature
	(properties
		noun 4
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fBushes of Feature
	(properties
		noun 3
		onMeCheck 16384
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(== (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(= x (event x:))
				(= y (event y:))
				(super handleEvent: event &rest)
			)
		)
	)
)

(instance fButton of Feature
	(properties
		noun 8
		onMeCheck 8192
		approachX 255
		approachY 93
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(== (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(= x (event x:))
				(= y (event y:))
				(super handleEvent: event &rest)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local2
					(car doVerb: 4)
				else
					(gCurRoom setScript: toJail)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fLockers of Feature
	(properties
		noun 6
		onMeCheck 1024
		approachX 216
		approachY 112
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(== (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(= x (event x:))
				(= y (event y:))
				(super handleEvent: event &rest)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local2
					(car doVerb: 4)
				else
					(gCurRoom setScript: useLocker)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fSidewalk of Feature
	(properties
		noun 5
		onMeCheck 2048
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(== (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(= x (event x:))
				(= y (event y:))
				(super handleEvent: event &rest)
			)
		)
	)
)

(instance fWindow of Feature
	(properties
		noun 2
		onMeCheck 4096
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(== (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(= x (event x:))
				(= y (event y:))
				(super handleEvent: event &rest)
			)
		)
	)
)

