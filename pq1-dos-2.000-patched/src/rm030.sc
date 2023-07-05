;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
(include sci.sh)
(use Main)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm030 0
)

(local
	local0
	local1
	local2
	[local3 68] = [7 4 229 213 12 7 234 209 231 214 0 0 0 0 0 0 0 8 2 222 206 12 6 227 206 246 222 0 0 0 0 0 0 0 9 2 209 204 12 6 213 204 239 235 0 0 0 0 0 0 0 8 4 209 204 12 6 213 204 239 235 0 0 0 0 0 0 0]
	[local71 68] = [208 209 302 2 207 207 6 208 209 234 209 7 4 6 229 213 12 246 222 0 0 0 0 6 246 222 227 206 8 2 8 222 206 12 239 225 0 0 0 0 6 239 225 213 204 9 2 8 209 204 12 239 225 0 0 0 0 6 239 225 213 204 8 4 8 209 204 12]
)

(instance rm030 of PQRoom
	(properties
		picture 30
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
		(super init:)
		(cond
			((OneOf global211 8 9)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 63 109 114 40 144 0 131
							yourself:
						)
				)
				(stevesCar init: ignoreActors: 1 addToPic:)
			)
			((OneOf global211 14 15 16)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 82 163 0 137 0 73 155 123 153 139
							yourself:
						)
				)
				(harleys init: ignoreActors: 1 addToPic:)
			)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 225 121 278 95 257 89 199 113 145 96 155 92 144 88 133 92 104 83 100 85 0 52 0 144 106 189 177 189 162 181 155 169 212 143 293 157 308 146
					yourself:
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
		(if (and (== local1 34) (== global206 1))
			(= local1 51)
		)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(switch gPrevRoomNum
			(32
				(gEgo init: posn: 289 86)
				(self posn: 256 97 setScript: (ScriptID 896 1)) ; sWI
			)
			(31
				(HandsOff)
				(gEgo init: posn: 169 85)
				(door cel: 6)
				(gLongSong2 pause: 0)
				(gCurRoom setScript: leaveCarols)
			)
			(else
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
				(self setScript: fromCar)
			)
		)
		(car init: ignoreActors: 1 addToPic:)
		(bankBuilding init:)
		(carolsBuilding init:)
		(street init:)
		(willySign init:)
		(carolWindow init:)
		(carolSign init:)
		(weeds init:)
		(alley init:)
		(mat init:)
		(sideWalk init:)
		(gutter init:)
		(door init:)
		(gLongSong2 fade:)
		(if (== gPrevRoomNum 31)
			(gLongSong number: 300 loop: -1)
		else
			(gLongSong number: 300 loop: -1 play: 55)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script 0)
			((gEgo inRect: 260 58 284 103)
				(gLongSong fade:)
				(cond
					((OneOf global211 14 18)
						(self setScript: bounceBack)
					)
					((== global211 15)
						(++ global211)
						(gCurRoom newRoom: 32)
					)
					(else
						(gCurRoom newRoom: 32)
					)
				)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
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

(instance leaveCarols of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: StopWalk -1 setMotion: MoveTo 150 91 self)
			)
			(1
				(door setCycle: Beg self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance bounceBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(switch global211
					(18
						(gMessager say: 17 2 4 0) ; "You should advise Carol about the bikers."
					)
					(8
						(gMessager say: 17 2 5 0) ; "You travelled all this way. You should at least talk to your friend Steve."
					)
					(14
						(gMessager say: 17 2 6 0) ; "Maybe you should go and see what Carol's complaint is all about first."
					)
				)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo 256 97 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance intoCarols of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: StopWalk -1 setMotion: PolyPath 150 95 self)
			)
			(1
				(door setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 184 84 self)
			)
			(3
				(door setCycle: Beg self)
			)
			(4
				(gLongSong2 pause: 1)
				(gCurRoom newRoom: 31)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 175
		y 86
		noun 1
		approachX 150
		approachY 95
		view 236
		priority 5
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (gCurRoom script:))
					(HandsOff)
					(gCurRoom setScript: intoCarols)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance harleys of Prop
	(properties
		x 155
		y 148
		noun 10
		approachX 138
		approachY 130
		view 235
		priority 8
		signal 16400
	)
)

(instance stevesCar of View
	(properties
		x -36
		y 75
		noun 11
		view 103
		cel 1
		priority 9
		signal 16400
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
					setPri: 15
					setMotion:
						MoveTo
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
					setPri: 15
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
				(gLongSong2 number: 901 loop: 1 play:)
				(if (OneOf global211 9 19)
					(++ global211)
				)
				(= seconds 2)
			)
			(8
				(gCurRoom newRoom: 500)
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
				(gEgo setCycle: 0)
			)
			(2
				(gEgo setPri: 15 setCycle: End self)
			)
			(3
				(NormalEgo -1 [local3 (+ local1 5)])
				(gEgo
					setPri: 15
					posn: [local3 (+ local1 6)] [local3 (+ local1 7)]
					setMotion:
						MoveTo
						[local3 (+ local1 8)]
						[local3 (+ local1 9)]
						self
				)
			)
			(4
				(frontDoor setCycle: Beg self)
			)
			(5
				(gLongSong2 number: 901 loop: 1 play: self)
			)
			(6
				(frontDoor stopUpd:)
				(gEgo setMotion: MoveTo 158 189 self)
			)
			(7
				(gEgo setPri: -1 setMotion: MoveTo 114 171 self)
			)
			(8
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance car of View
	(properties
		x 220
		y 155
		approachX 141
		approachY 184
		view 103
		cel 1
		priority 12
		signal 16400
	)

	(method (init)
		(self approachVerbs: 4) ; Do
		(switch global207
			(914
				(self view: 103 loop: 0 cel: 1 noun: 9 x 220 y: 155)
				(super init: &rest)
				(frontDoor init:)
				(backDoor init:)
				(topLights init:)
				(blueLight init:)
				(redLight init:)
			)
			(105
				(self view: 107 loop: 0 cel: 1 noun: 9 posn: 206 146)
				(super init: &rest)
				(frontDoor init:)
			)
			(104
				(self view: 208 loop: 1 cel: 0 noun: 9 posn: 202 175)
				(super init: &rest)
				(frontDoor init:)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if local2
					(gCurRoom setScript: egoGetOutOfCar)
				else
					(switch global211
						(18
							(gMessager say: 17 2 4 0) ; "You should advise Carol about the bikers."
						)
						(8
							(gMessager say: 17 2 5 0) ; "You travelled all this way. You should at least talk to your friend Steve."
						)
						(14
							(gMessager say: 17 2 6 0) ; "Maybe you should go and see what Carol's complaint is all about first."
						)
						(15
							(gMessager say: 17 2 7 0) ; "You'ld better check out those bikers. Carol's counting on you."
						)
						(16
							(gMessager say: 17 2 7 0) ; "You'ld better check out those bikers. Carol's counting on you."
						)
						(else
							(gCurRoom setScript: egoGetInCar)
						)
					)
				)
			)
			(1 ; Look
				(switch global207
					(1
						(gMessager say: 9 1 3) ; "It's your sleek, sexy personal auto."
					)
					(2
						(gMessager say: 9 1 1) ; "It's your unmarked police car."
					)
					(else
						(gMessager say: 9 1 2) ; "It's your aging departmental-issue patrol car."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance frontDoor of Prop
	(properties
		x 214
		y 222
		z 50
		approachX 141
		approachY 184
		view 103
		loop 2
		priority 14
		signal 16400
	)

	(method (init)
		(self approachVerbs: 4) ; Do
		(super init: &rest)
		(switch global207
			(914
				(self view: 103 loop: 2 cel: 0 noun: 9 x: 214 y: 222)
			)
			(105
				(self view: 107 loop: 1 cel: 0 noun: 9 x: 209 y: 236)
			)
			(104
				(self view: 208 loop: 2 cel: 0 noun: 9 x: 204 y: 226)
			)
		)
		(super init: &rest)
		(self stopUpd:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if local2
					(gCurRoom setScript: egoGetOutOfCar)
				else
					(switch global211
						(18
							(gMessager say: 17 2 4 0) ; "You should advise Carol about the bikers."
						)
						(8
							(gMessager say: 17 2 5 0) ; "You travelled all this way. You should at least talk to your friend Steve."
						)
						(14
							(gMessager say: 17 2 6 0) ; "Maybe you should go and see what Carol's complaint is all about first."
						)
						(15
							(gMessager say: 17 2 7 0) ; "You'ld better check out those bikers. Carol's counting on you."
						)
						(16
							(gMessager say: 17 2 7 0) ; "You'ld better check out those bikers. Carol's counting on you."
						)
						(else
							(gCurRoom setScript: egoGetInCar)
						)
					)
				)
			)
			(1 ; Look
				(switch global207
					(1
						(gMessager say: 9 1 3) ; "It's your sleek, sexy personal auto."
					)
					(2
						(gMessager say: 9 1 1) ; "It's your unmarked police car."
					)
					(else
						(gMessager say: 9 1 2) ; "It's your aging departmental-issue patrol car."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance backDoor of Prop
	(properties
		x 234
		y 177
		approachX 141
		approachY 184
		view 103
		loop 3
		priority 14
		signal 16400
	)

	(method (init)
		(self approachVerbs: 4) ; Do
		(super init: &rest)
		(self stopUpd:)
	)
)

(instance topLights of Prop
	(properties
		x 239
		y 165
		view 103
		loop 4
		priority 13
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
		x 272
		y 181
		view 103
		loop 5
		cel 3
		priority 13
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
		x 268
		y 182
		view 103
		loop 6
		priority 13
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

(instance willySign of Feature
	(properties
		noun 14
		sightAngle 40
		onMeCheck 8
		approachX 237
		approachY 104
	)
)

(instance carolWindow of Feature
	(properties
		noun 2
		sightAngle 40
		onMeCheck 128
		approachX 55
		approachY 80
	)
)

(instance carolSign of Feature
	(properties
		noun 5
		sightAngle 40
		onMeCheck 16
		approachX 121
		approachY 102
	)
)

(instance weeds of Feature
	(properties
		noun 13
		sightAngle 40
		onMeCheck 4
		approachX 223
		approachY 115
	)
)

(instance alley of Feature
	(properties
		noun 4
		sightAngle 40
		onMeCheck 256
		approachX 239
		approachY 104
	)
)

(instance mat of Feature
	(properties
		noun 15
		sightAngle 40
		onMeCheck 32
		approachX 152
		approachY 92
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4) ; Do
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sideWalk of Feature
	(properties
		noun 3
		sightAngle 40
		onMeCheck 64
	)
)

(instance bankBuilding of Feature
	(properties
		noun 16
		sightAngle 40
		onMeCheck 2
	)
)

(instance carolsBuilding of Feature
	(properties
		noun 8
		sightAngle 40
		onMeCheck 8192
	)
)

(instance street of Feature
	(properties
		noun 7
		sightAngle 40
		onMeCheck 512
	)
)

(instance gutter of Feature
	(properties
		noun 12
		sightAngle 40
		onMeCheck 1024
	)
)

