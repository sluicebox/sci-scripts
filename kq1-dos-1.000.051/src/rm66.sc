;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 66)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm66 0
)

(instance rm66 of Rm
	(properties
		picture 66
		horizon 103
		north 19
		east 67
		south 67
	)

	(method (init)
		(Load rsVIEW 266)
		(self
			style:
				(switch gPrevRoomNum
					(north 0)
					(else 0)
				)
		)
		(super init:)
		(switch gPrevRoomNum
			(north
				(self setScript: enterMount)
			)
			(else
				(door init:)
				(gEgo posn: 303 187 loop: 3 init:)
				(proc0_1)
				(door stopUpd:)
			)
		)
		(ceiling init:)
		(arch init:)
		(wall1 init:)
		(wall2 init:)
		(wall3 init:)
		(if (IsFlag 2)
			(Print 66 0) ; "When the goat saw how dark it was in here, it decided not to stay around."
			(ClearFlag 2)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(EDGE_TOP north)
						(EDGE_RIGHT east)
						(EDGE_BOTTOM south)
						(EDGE_LEFT west)
					)
				)
				(self newRoom: temp0)
			)
			((& (gEgo onControl: 1) $4000)
				(self setScript: leaveMount)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look>')
				(if (Said '[<at,around][/room,cave]')
					(if (== gPrevRoomNum north)
						(Print 66 1) ; "There is a large cave here. It continues deeper into the mountain."
					else
						(Print 66 2) ; "You have come from deep inside the mountain. There is a door here."
					)
				)
			)
			((Said 'climb,climb/wall')
				(Print 66 3) ; "You'd cut your hands to ribbons trying to climb these rocky walls."
			)
		)
	)
)

(instance door of Prop
	(properties
		x 136
		y 106
		view 266
	)

	(method (handleEvent event)
		(cond
			((or (Said 'look,look/door') (MousedOn self event 3))
				(Print 66 4) ; "This is a heavy oaken door set into the side of the cave."
				(event claimed: 1)
			)
			((Said 'open,open,unlock,knock/door')
				(Print 66 5) ; "Try moving closer to the door."
			)
		)
	)
)

(instance doorCloses of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 0 21) number: 56 loop: 1 init: play:) ; gameSound
				(door cel: 8 setCycle: Beg self)
			)
			(1
				(door stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance leaveMount of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 0 21) number: 56 loop: 1 init: play:) ; gameSound
				(door setCycle: End self)
			)
			(1
				(door stopUpd:)
				(gEgo
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo (gEgo x:) 103 self
				)
			)
			(2
				(gCurRoom newRoom: 19)
			)
		)
	)
)

(instance enterMount of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					ignoreActors:
					illegalBits: 0
					posn: 140 113
					loop: 2
					init:
					setMotion: MoveTo 140 123 self
				)
				(door cel: 8 setScript: doorCloses init:)
			)
			(1
				(gEgo stopUpd:)
				(HandsOn)
				(proc0_1)
				(self dispose:)
			)
		)
	)
)

(instance wall1 of NewFeature
	(properties
		x 49
		y 83
		noun 'wall'
		nsTop 34
		nsLeft 19
		nsBottom 132
		nsRight 80
		description {wall}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The walls of this cave are rough and craggy.}
	)
)

(instance wall2 of NewFeature
	(properties
		x 145
		y 67
		noun 'wall'
		nsTop 27
		nsLeft 79
		nsBottom 108
		nsRight 212
		description {wall}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The walls of this cave are rough and craggy.}
	)
)

(instance wall3 of NewFeature
	(properties
		x 249
		y 81
		noun 'wall'
		nsTop 41
		nsLeft 212
		nsBottom 122
		nsRight 287
		description {wall}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The walls of this cave are rough and craggy.}
	)
)

(instance ceiling of NewFeature
	(properties
		x 162
		y 26
		noun 'ceiling'
		nsLeft 46
		nsBottom 53
		nsRight 279
		description {ceiling}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The ceiling is low and rough here.}
	)
)

(instance arch of NewFeature
	(properties
		x 272
		y 170
		noun 'arc'
		nsTop 152
		nsLeft 226
		nsBottom 189
		nsRight 318
		description {arch}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The cave appears to open up into a larger chamber that reaches deep into the mountain.}
	)
)

