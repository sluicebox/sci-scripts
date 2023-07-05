;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 535)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use DPath)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm535 0
)

(instance rm535 of SQRoom
	(properties
		picture 535
		east 540
		west 530
	)

	(method (init)
		(LoadMany rsVIEW 535 300 7)
		(LoadMany rsSOUND 131 156 104 158 535 107)
		(switch gPrevRoomNum
			(120
				(self setScript: shipScript)
				(gEgo posn: 160 110)
				(gLongSong2 hold: 0)
			)
			(east
				(HandsOff)
				(if (> (gEgo y:) 134)
					(gEgo y: 134)
				)
				(self setScript: enterScript style: 40)
			)
			(west
				(HandsOff)
				(gEgo
					y:
						(if (> (gEgo y:) 120)
							120
						else
							(gEgo y:)
						)
				)
				(self setScript: enterScript style: 41)
			)
			(else
				(gEgo x: 160 y: 140)
				(self style: 100)
				(= gPrevRoomNum west)
			)
		)
		(super init:)
		(gEgo view: 0 init:)
		(gFeatures
			add: theRailView theLeftPump theRightPump theShuttle
			eachElementDo: #init
			doit:
		)
		(self setRegions: 709) ; rgLanding
		(gCurRoom
			addObstacle:
				((Polygon new:) type: PBarredAccess init: 319 189 284 134 319 134 yourself:)
				((Polygon new:)
					type: PBarredAccess
					init: 0 129 21 129 25 120 64 120 75 129 64 136 37 136 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 52 0 0 319 0 319 57 276 54 250 54 178 54 163 76 149 55
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 79 109 139 109 139 128 106 128 90 128 79 123
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 189 109 247 109 247 128 220 128 189 128
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 242 63 274 63 274 73 242 73
					yourself:
				)
		)
		(if (== gPrevRoomNum 120)
			(HandsOff)
			(leftEngine setLoop: 0 setCycle: Fwd init:)
			(rightEngine setLoop: 0 setCycle: Fwd init:)
			(leftGear x: 145 z: 22 setCel: 3 init:)
			(rightGear x: 182 z: 22 setCel: 3 init:)
		else
			(leftEngine init: setLoop: 2 setCel: 11 stopUpd:)
			(rightEngine init: setLoop: 2 setCel: 11 stopUpd:)
			(leftGear x: 123 z: 0 setCel: 0 init: stopUpd:)
			(rightGear x: 204 z: 0 setCel: 0 init: stopUpd:)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((and (< (gEgo x:) 20) (< (gEgo y:) 144))
				(HandsOff)
				(gCurRoom newRoom: 530)
			)
			((and (> (gEgo x:) 300) (< (gEgo y:) 144))
				(HandsOff)
				(gCurRoom newRoom: 540)
			)
		)
	)
)

(instance leftEngine of Prop
	(properties
		x 150
		y 77
		description {exhaust turbine}
		lookStr {This is an exhaust turbine.}
		view 535
		priority 15
		signal 16400
	)
)

(instance rightEngine of Prop
	(properties
		x 178
		y 77
		description {exhaust turbine}
		lookStr {This is an exhaust turbine.}
		view 535
		priority 15
		signal 16400
	)
)

(instance leftGear of Actor
	(properties
		y 72
		description {landing gear}
		lookStr {This is the shuttle's landing gear.}
		view 535
		loop 3
		cel 3
		priority 8
		signal 24592
		illegalBits 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Do
				(HandsOff)
				(gCurRoom setScript: toXenon)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((> z 21))
			((> z 0)
				(-- z)
				(-- x)
			)
		)
	)
)

(instance rightGear of Actor
	(properties
		y 72
		description {landing gear}
		lookStr {This is the shuttle's landing gear.}
		view 535
		loop 4
		cel 3
		priority 8
		signal 24592
		illegalBits 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Do
				(HandsOff)
				(gCurRoom setScript: toXenon)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((> z 21))
			((> z 0)
				(if (== (-- z) 0)
					(aSound number: 156 loop: 0 play:)
				)
				(++ x)
			)
		)
	)
)

(instance sp of Actor
	(properties
		x 157
		y 83
		view 7
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gPrevRoomNum (gCurRoom west:))
					(gEgo init: x: 5 setMotion: MoveTo 40 (gEgo y:) self)
				else
					(gEgo
						init:
						x: 310
						setMotion: MoveTo 280 (gEgo y:) self
					)
				)
			)
			(1
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance shipScript of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (== state 0) (== (gLongSong2 prevSignal:) -1))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(gLongSong stop:)
				(gLongSong2 number: 104 loop: 0 play: self)
				(= cycles 10)
			)
			(2
				(aSound init: number: 158 loop: -1 play:)
				(leftGear z: 21)
				(rightGear z: 21)
				(= cycles 12)
			)
			(3
				(leftGear setCycle: Beg)
				(rightGear setCycle: Beg self)
			)
			(4
				(leftEngine setLoop: 1)
				(rightEngine setLoop: 1)
				(if (== (gLongSong2 prevSignal:) -1)
					(= seconds 2)
				else
					(= seconds 4)
				)
			)
			(5
				(= seconds 0)
				(gLongSong2
					stop:
					number: 535
					vol: 127
					loop: -1
					flags: 1
					playBed:
				)
				(sp init: setCycle: Walk setMotion: DPath 139 69 -5 80)
				(leftEngine setLoop: 2 setCel: 0 setCycle: End self)
				(rightEngine setLoop: 2 setCel: 0 setCycle: End)
			)
			(6
				(leftGear stopUpd:)
				(rightGear stopUpd:)
				(leftEngine stopUpd:)
				(rightEngine stopUpd:)
				(gEgo x: 160 y: 100 setMotion: PolyPath 205 155 self)
			)
			(7
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance toXenon of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (== state 10) (== (gLongSong2 prevSignal:) -1))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 160 110 self)
			)
			(1
				(Print 535 0) ; "You climb into the landing gear bay hoping it's still spacious with the landing gear stowed."
				(= seconds 5)
			)
			(2
				(sp
					init:
					x: -5
					y: 80
					setCycle: Walk
					setMotion: PolyPath 140 85 self
				)
			)
			(3
				(= seconds 4)
			)
			(4
				(leftEngine setLoop: 0 setCycle: Fwd)
				(rightEngine setLoop: 0 setCycle: Fwd)
				(aSound number: 107 loop: 1 play: self)
			)
			(5
				(aSound init: number: 158 loop: -1 play:)
				(leftGear setCel: 0 setLoop: 3 setMotion: MoveTo 145 51 self)
				(rightGear setCel: 0 setLoop: 4 setMotion: MoveTo 182 51 self)
			)
			(6 0)
			(7
				(leftGear setCycle: End self)
				(rightGear setCycle: End self)
			)
			(8 0)
			(9
				(aSound stop: loop: 0)
				(gLongSong2 fade:)
				(leftGear hide:)
				(rightGear hide:)
				(= cycles 2)
			)
			(10
				(sp dispose:)
			)
			(11
				(client setScript: 0)
				(gCurRoom newRoom: 119)
			)
		)
	)
)

(instance theLeftPump of Feature
	(properties
		x 53
		y 110
		nsBottom 189
		nsRight 319
		description {left pump}
		onMeCheck 16
		lookStr {This is a fueling unit for the patrol shuttle.}
	)
)

(instance theRightPump of Feature
	(properties
		x 264
		y 58
		nsBottom 189
		nsRight 319
		description {back pump}
		onMeCheck 32
		lookStr {This is a maintenance unit for the shuttle. It's of no interest.}
	)
)

(instance theShuttle of Feature
	(properties
		x 170
		y 90
		nsBottom 189
		nsRight 319
		description {patrol shuttle}
		onMeCheck 64
		lookStr {This is the patrol shuttle you hitched a ride on.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Do
				(HandsOff)
				(gCurRoom setScript: toXenon)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theRailView of Feature
	(properties
		x 161
		y 32
		nsTop 15
		nsLeft 37
		nsBottom 49
		nsRight 285
		description {rail}
		sightAngle 90
		lookStr {Hundreds of pipes and beams litter the view here.}
	)
)

(instance aSound of Sound
	(properties)
)

