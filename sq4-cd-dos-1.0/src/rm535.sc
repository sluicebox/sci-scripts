;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 535)
(include sci.sh)
(use Main)
(use eRS)
(use Sq4Feature)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use DPath)
(use Sound)
(use Motion)
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
				(self setScript: enterScript style: 11)
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
				(self setScript: enterScript style: 12)
			)
			(else
				(gEgo x: 160 y: 140)
				(self style: 100)
				(= gPrevRoomNum west)
			)
		)
		(super init:)
		(gEgo view: 0 init:)
		(theRailView init:)
		(theLeftPump init:)
		(theRightPump init:)
		(theShuttle init:)
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
			(rightEngine init: setLoop: 2 setCel: 10 stopUpd:)
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

(instance leftEngine of Sq4Prop
	(properties
		x 150
		y 77
		view 535
		priority 15
		signal 16400
		lookStr 1 ; "This is an exhaust turbine."
	)
)

(instance rightEngine of Sq4Prop
	(properties
		x 178
		y 77
		view 535
		priority 15
		signal 16400
		lookStr 1 ; "This is an exhaust turbine."
	)
)

(instance leftGear of Sq4Actor
	(properties
		y 72
		view 535
		loop 3
		cel 3
		priority 8
		signal 24592
		illegalBits 0
		lookStr 2 ; "This is the shuttle's landing gear."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
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

(instance rightGear of Sq4Actor
	(properties
		y 72
		view 535
		loop 4
		cel 3
		priority 8
		signal 24592
		illegalBits 0
		lookStr 2 ; "This is the shuttle's landing gear."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
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
				(++ x)
				(-- z)
			)
		)
	)
)

(instance sp of Sq4Actor
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

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(if (!= (gLongSong2 prevSignal:) -1)
					(gLongSong2 fade: self)
				else
					(= seconds 3)
				)
			)
			(2
				(= seconds 0)
				(gLongSong stop:)
				(gLongSong2 number: 104 loop: 0 play:)
				(leftEngine setLoop: 2 setCel: 0 setCycle: End self)
				(rightEngine setLoop: 2 setCel: 0 setCycle: End)
			)
			(3
				(leftEngine setLoop: 2 setCel: 0 cycleSpeed: 12 setCycle: End)
				(rightEngine setLoop: 2 setCel: 0 setCycle: CT 9 1)
				(= ticks 60)
			)
			(4
				(aSound number: 158 loop: -1 play:)
				(leftGear z: 21 setCycle: CT 1 -1)
				(rightGear z: 21 setCycle: CT 1 -1 self)
			)
			(5
				(= ticks 60)
			)
			(6
				(aSound number: 156 loop: 0 play:)
				(leftGear setCel: 0)
				(rightGear setCel: 0)
				(leftEngine setLoop: 1)
				(rightEngine setLoop: 1)
				(= ticks 30)
			)
			(7
				(= seconds 0)
				(gLongSong2 stop: number: 535 vol: 127 loop: -1 flags: 1 play:)
				(sp init: setCycle: Walk setMotion: DPath 139 69 -5 80 self)
			)
			(8
				(leftGear stopUpd:)
				(rightGear stopUpd:)
				(leftEngine stopUpd:)
				(rightEngine stopUpd:)
				(gEgo
					setSpeed: gGameSpeed
					x: 160
					y: 100
					setMotion: PolyPath 210 145 self
				)
			)
			(9
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
				(gNarrator say: 3 self) ; "You climb up into the landing gear housing. How clever you are."
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
				(= seconds 3)
			)
			(4
				(leftEngine cycleSpeed: 6 setLoop: 0 setCycle: Fwd)
				(rightEngine cycleSpeed: 6 setLoop: 0 setCycle: Fwd)
				(aSound number: 107 loop: 1 play:)
				(= seconds 4)
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
				(aSound number: 109 loop: -1 play:)
				(= seconds 2)
			)
			(10
				(gLongSong2 fade:)
				(leftGear hide:)
				(rightGear hide:)
				(= cycles 2)
			)
			(11
				(sp dispose:)
				(= cycles 2)
			)
			(12
				(gLongSong2 fade:)
				(client setScript: 0)
				(gCurRoom newRoom: 119)
			)
		)
	)
)

(instance theLeftPump of Sq4Feature
	(properties
		x 53
		y 110
		nsBottom 189
		nsRight 319
		onMeCheck 16
		lookStr 4 ; "This is a fueling unit for the patrol shuttle."
	)
)

(instance theRightPump of Sq4Feature
	(properties
		x 264
		y 58
		nsBottom 189
		nsRight 319
		onMeCheck 32
		lookStr 5 ; "This is a maintenance unit for the shuttle. It's of no interest."
	)
)

(instance theShuttle of Sq4Feature
	(properties
		x 170
		y 90
		nsBottom 189
		nsRight 319
		onMeCheck 64
		lookStr 6 ; "This is the patrol shuttle you hitched a ride on."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(HandsOff)
				(gCurRoom setScript: toXenon)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theRailView of Sq4Feature
	(properties
		x 161
		y 32
		nsTop 15
		nsLeft 37
		nsBottom 49
		nsRight 285
		sightAngle 90
		lookStr 7 ; "Hundreds of pipes and beams litter the view here."
	)
)

(instance aSound of Sound
	(properties)
)

