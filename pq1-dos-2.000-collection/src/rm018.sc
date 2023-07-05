;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use station)
(use eRS)
(use Polygon)
(use Feature)
(use DPath)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm018 0
)

(instance rm018 of PQRoom
	(properties
		noun 3
		picture 18
	)

	(method (init)
		(self
			setRegions: 134 ; station
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 67 107 67 144 248 152 248 124 148 80
					yourself:
				)
		)
		(gEgo init:)
		(NormalEgo -1)
		(switch gPrevRoomNum
			(20
				(gEgo posn: 69 85)
			)
			(19
				(gEgo posn: 259 162)
			)
			(else
				(gEgo posn: 219 85)
			)
		)
		(elevatorDoor init:)
		(officeDoor init:)
		(lights init:)
		(elevatorButton init:)
		(EXT init:)
		(SENSOR init:)
		(super init:)
		(switch gPrevRoomNum
			(20
				(self setScript: fromOffice)
			)
			(19
				(self posn: 186 135 setScript: (ScriptID 896 1)) ; sWI
			)
			(else
				(self setScript: fromElevator)
			)
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 0))
		(cond
			(script 0)
			((& temp0 $0002)
				(self posn: 259 162 setScript: (ScriptID 896 2) 0 19) ; sWO
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 964)
		(super dispose: &rest)
	)
)

(instance fromElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(elevatorDoor startUpd:)
				(gEgo setLoop: 5)
				(self setScript: cycleLights self -1)
			)
			(1
				(= seconds 4)
			)
			(2
				(lights stopUpd:)
				(gLongSong2 number: 920 loop: 1 play:)
				(elevatorDoor startUpd: setCycle: End self)
			)
			(3
				(gEgo setLoop: 5 setMotion: MoveTo 186 100 self)
			)
			(4
				(gEgo setLoop: -1)
				(gLongSong2 number: 921 loop: 1 play:)
				(elevatorDoor setCycle: Beg self)
				(self setScript: cycleLights self 1)
			)
			(5)
			(6
				(elevatorDoor stopUpd:)
				(HandsOn)
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
				(gEgo setLoop: 4 setMotion: MoveTo 90 105 self)
			)
			(1
				(gEgo setLoop: -1)
				(officeDoor show: setCycle: Beg self)
			)
			(2
				(sfx number: 914 play:)
				(officeDoor stopUpd:)
				(HandsOn)
				(self dispose:)
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
				(proc134_3 self)
			)
			(2
				(sfx number: 913 play:)
				(officeDoor startUpd: setCycle: End self)
			)
			(3
				(officeDoor hide:)
				(NormalEgo -1 7)
				(gEgo setLoop: 7 setMotion: MoveTo 69 85 self)
			)
			(4
				(gCurRoom newRoom: 20)
			)
		)
	)
)

(instance useElevator of Script
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
				(self setScript: cycleLights self -1)
			)
			(3
				(= seconds 4)
			)
			(4
				(gLongSong2 number: 920 loop: 1 play:)
				(NormalEgo -1 6)
				(elevatorDoor startUpd: setCycle: End self)
			)
			(5
				(gEgo setMotion: DPath 192 105 218 84 226 93 218 84 self)
			)
			(6
				(gEgo setHeading: 225 self)
			)
			(7
				(gLongSong2 number: 921 loop: 1 play:)
				(elevatorDoor setCycle: Beg self)
			)
			(8
				(self setScript: cycleLights self 1)
			)
			(9
				(gCurRoom newRoom: 12)
			)
		)
	)
)

(instance cycleLights of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lights startUpd: setLoop: (if (== register 1) 3 else 4))
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
				(if (<= 3 (lights loop:) 4)
					(-= state 3)
				else
					(lights setLoop: 3)
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

(instance officeDoor of Prop
	(properties
		x 70
		y 96
		noun 1
		approachX 87
		approachY 101
		view 160
		cel 5
		priority 5
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self
			approachVerbs: 4 ; Do
			setCel:
				(if (== gPrevRoomNum 20)
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
					(gCurRoom setScript: toOffice)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance elevatorDoor of Prop
	(properties
		x 227
		y 103
		noun 2
		approachX 195
		approachY 105
		view 160
		loop 1
		priority 5
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 stopUpd:) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 2 4) ; "Don't whack the elevator. Just push the button."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lights of Prop
	(properties
		x 207
		y 45
		noun 7
		view 160
		loop 3
		priority 15
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)
)

(instance elevatorButton of Feature
	(properties
		x 236
		y 84
		noun 4
		nsTop 79
		nsLeft 233
		nsBottom 89
		nsRight 240
		sightAngle 40
		approachX 213
		approachY 115
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (gCurRoom script:))
					(gCurRoom setScript: useElevator)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance EXT of Feature
	(properties
		x 137
		y 52
		noun 6
		nsTop 43
		nsLeft 131
		nsBottom 61
		nsRight 144
		sightAngle 40
	)
)

(instance SENSOR of Feature
	(properties
		x 106
		y 39
		noun 5
		nsTop 37
		nsLeft 103
		nsBottom 42
		nsRight 109
		sightAngle 40
	)
)

(instance sfx of Sound
	(properties)
)

