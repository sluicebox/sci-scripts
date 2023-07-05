;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 535)
(include sci.sh)
(use Main)
(use SQRoom)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
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
		(LoadMany rsSOUND 131)
		(switch gPrevRoomNum
			(120
				(self setScript: shipScript)
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
		(gEgo view: 0 init:)
		(super init:)
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
					init: 0 52 0 0 319 0 319 57 273 57 268 73 247 73 232 52 179 52 163 76 147 52
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 79 109 139 109 139 122 106 126 79 123
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 186 109 247 109 247 123 220 126 186 123
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
			(leftEngine setLoop: 2 init: stopUpd:)
			(rightEngine setLoop: 2 init: stopUpd:)
			(leftGear x: 123 z: 0 setCel: 0 init: stopUpd:)
			(rightGear x: 204 z: 0 setCel: 0 init: stopUpd:)
		)
		(theLeftPump init:)
		(theRightPump init:)
		(theShuttle init:)
		(theCityView init:)
		(theRailView init:)
	)

	(method (doit)
		(super doit:)
		(cond
			((StepOn gEgo 4)
				(HandsOff)
				(gCurRoom setScript: fallScript)
			)
			(script)
			((and (< (gEgo x:) 20) (< (gEgo y:) 144))
				(HandsOff)
				(gCurRoom setScript: exitScript)
			)
			((and (> (gEgo x:) 300) (< (gEgo y:) 144))
				(HandsOff)
				(gCurRoom setScript: exitScript 0 1)
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
		signal 16384
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
		signal 16384
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
				(++ x)
			)
		)
	)
)

(instance sp of Actor
	(properties
		x 160
		y 60
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

(instance exitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom newRoom: (if register 540 else 530))
			)
		)
	)
)

(instance shipScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 160 110)
				(= cycles 10)
			)
			(1
				(leftGear z: 21)
				(rightGear z: 21)
				(= cycles 12)
			)
			(2
				(leftGear setCycle: Beg)
				(rightGear setCycle: Beg self)
			)
			(3
				(leftEngine setLoop: 1)
				(rightEngine setLoop: 1)
				(= seconds 5)
			)
			(4
				(sp init: setCycle: Walk setMotion: PolyPath -5 80)
				(leftEngine setLoop: 2 setCel: 0 setCycle: End self)
				(rightEngine setLoop: 2 setCel: 0 setCycle: End)
			)
			(5
				(leftGear stopUpd:)
				(rightGear stopUpd:)
				(leftEngine stopUpd:)
				(rightEngine stopUpd:)
				(gEgo x: 160 y: 100 setMotion: PolyPath 205 155 self)
			)
			(6
				(sp dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance toXenon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 160 110 self)
			)
			(1
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
				(leftEngine setLoop: 0 setPri: 15 setCycle: Fwd)
				(rightEngine setLoop: 0 setPri: 15 setCycle: Fwd)
				(= seconds 3)
			)
			(5
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
				(leftGear hide:)
				(rightGear hide:)
				(= cycles 1)
			)
			(10
				(sp dispose:)
				(HandsOn)
				(client setScript: 0)
				(gCurRoom newRoom: 119)
			)
		)
	)
)

(instance fallScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aSound number: 131 vol: 127 loop: 1 play:)
				(gEgo
					view: 300
					setLoop:
					setCycle: 0
					setStep: 3 20
					setPri:
					illegalBits: 0
					setMotion: MoveTo (gEgo x:) 250 self
				)
			)
			(1
				(= seconds 2)
			)
			(2
				(aSound fade: 0 1 2 1)
				(= seconds 1)
			)
			(3
				(EgoDead 535 0)
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

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
			(5) ; Talk
			(else
				(super doVerb: theVerb)
			)
		)
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
		lookStr {This is a maintenence unit for the shuttle. It's of no interest.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
			(5) ; Talk
			(else
				(super doVerb: theVerb)
			)
		)
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
			(4 ; Do
				(HandsOff)
				(gCurRoom setScript: toXenon)
			)
			(5) ; Talk
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theCityView of Feature
	(properties
		x 159
		y 188
		nsTop 164
		nsBottom 189
		nsRight 319
		description {city view}
		lookStr {Wasted and semi-wasted buildings fill the view of Xenon from up here. The battles waged here were fierce and all-encompassing.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
			(5) ; Talk
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theRailView of Feature
	(properties
		x 168
		y 30
		nsTop 16
		nsLeft 43
		nsBottom 49
		nsRight 282
		lookStr {Hundreds of pipes and beams litter the view here.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
			(5) ; Talk
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance aSound of Sound
	(properties)
)

