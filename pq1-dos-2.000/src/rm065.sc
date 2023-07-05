;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 65)
(include sci.sh)
(use Main)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm065 0
)

(local
	local0
	local1
	local2
	[local3 68] = [7 4 116 210 12 7 121 206 118 211 0 0 0 0 0 0 0 8 2 109 203 12 6 114 203 133 219 0 0 0 0 0 0 0 9 2 96 201 12 6 100 201 126 232 0 0 0 0 0 0 0 8 4 96 201 12 6 100 201 126 232 0 0 0 0 0 0 0]
	[local71 68] = [95 206 302 2 94 204 6 95 206 121 206 7 4 6 116 210 12 133 219 0 0 0 0 6 133 219 114 203 8 2 8 109 203 12 126 222 0 0 0 0 6 126 222 100 201 9 2 8 96 201 12 126 222 0 0 0 0 6 126 222 100 201 8 4 8 96 201 12]
)

(instance rm065 of PQRoom
	(properties
		noun 1
		picture 65
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
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 189 52 189 32 181 17 166 86 135 240 183 262 176 163 146 204 106 229 97 269 107 295 100 187 78 167 83 146 78 135 81 166 89 103 128 0 93
					yourself:
				)
		)
		(gLongSong2 number: 915 loop: -1 play:)
		(door init:)
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
		(super init:)
		(car addToPic:)
		(if (== gPrevRoomNum 66)
			(gLongSong number: 0 stop:)
			(self setScript: escape)
		else
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
		(bush init:)
		(pillar init:)
		(grass init:)
		(ped init:)
		(sidewalk init:)
		(steps init:)
		(street init:)
		(windows init:)
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
				(sfx number: 900 loop: 1 play:)
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
				(sfx number: 901 loop: 1 play: self)
			)
			(8
				(gLongSong2 number: 0 stop:)
				(if (== global211 58)
					(gLongSong2 number: 670 loop: -1 play:)
				)
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
				(gLongSong number: 0 stop:)
				(= local2 0)
				(sfx number: 900 loop: 1 play: self)
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
				(sfx number: 901 loop: 1 play: self)
			)
			(6
				(frontDoor stopUpd:)
				(gEgo setMotion: MoveTo 22 181 self)
			)
			(7
				(gEgo setPri: -1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance car of View
	(properties
		x 107
		y 152
		approachX 5
		approachY 179
		view 103
		cel 1
		priority 12
		signal 16400
	)

	(method (init)
		(self approachVerbs: 4) ; Do
		(switch global207
			(914
				(self view: 103 loop: 0 cel: 1 x: 107 y: 152)
				(super init: &rest)
				(frontDoor init:)
				(backDoor init:)
				(topLights init:)
				(blueLight init:)
				(redLight init:)
			)
			(105
				(self view: 107 loop: 0 cel: 1 posn: 93 143)
				(super init: &rest)
				(frontDoor init:)
			)
			(104
				(self view: 208 loop: 1 cel: 0 posn: 89 172)
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
					(gCurRoom setScript: egoGetInCar)
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
		x 101
		y 219
		z 50
		approachX 5
		approachY 179
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
				(self view: 103 loop: 2 cel: 0 x: 101 y: 219)
			)
			(105
				(self view: 107 loop: 1 cel: 0 x: 96 y: 233)
			)
			(104
				(self view: 208 loop: 2 cel: 0 x: 91 y: 223)
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
					(gCurRoom setScript: egoGetInCar)
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
		x 121
		y 174
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
		x 126
		y 162
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
		x 159
		y 178
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
		x 155
		y 179
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

(instance escape of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(door signal: 16384 cel: 7)
				(gEgo posn: 275 79 init: setMotion: MoveTo 222 90 self)
				(Load rsSOUND 111)
			)
			(1
				(sfx number: 111 loop: 1 play:)
				(door setCycle: Beg self)
			)
			(2
				(door signal: (| (door signal:) $0100) stopUpd:)
				(self dispose:)
				(HandsOn)
			)
		)
	)
)

(instance goIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 222 90 self)
				(Load rsSOUND 111)
			)
			(1
				(sfx number: 111 loop: 1 play:)
				(door
					signal: (& (door signal:) $feff)
					startUpd:
					setCycle: End self
				)
			)
			(2
				(gEgo setMotion: MoveTo 275 79 self)
			)
			(3
				(gLongSong2 number: 0 stop:)
				(gCurRoom newRoom: 66)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 243
		y 84
		noun 8
		approachX 118
		approachY 126
		view 560
		loop 1
		signal 16641
		cycleSpeed 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: goIn)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bush of Feature
	(properties
		noun 10
		onMeCheck 2048
	)
)

(instance pillar of Feature
	(properties
		noun 5
		onMeCheck 8
	)
)

(instance grass of Feature
	(properties
		noun 9
		onMeCheck 4
	)
)

(instance ped of Feature
	(properties
		noun 6
		onMeCheck 64
	)
)

(instance sidewalk of Feature
	(properties
		noun 3
		onMeCheck 48
	)
)

(instance steps of Feature
	(properties
		noun 7
		onMeCheck 128
	)
)

(instance street of Feature
	(properties
		noun 2
		onMeCheck 256
	)
)

(instance windows of Feature
	(properties
		noun 4
		onMeCheck 512
	)
)

(instance sfx of Sound
	(properties)
)

