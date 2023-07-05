;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 613)
(include sci.sh)
(use Main)
(use Interface)
(use ulence)
(use SQRoom)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm613 0
)

(instance rm613 of SQRoom
	(properties
		picture 613
		east 614
		south 610
		west 612
	)

	(method (init)
		(ulence roomVer: 11591)
		(Load rsVIEW 305)
		(Load rsVIEW 378)
		(Load rsVIEW 617)
		(Load rsSOUND 124)
		(Load rsSOUND 125)
		(switch gPrevRoomNum
			(610)
			(612
				(if (< (gEgo y:) 146)
					(gEgo y: 134)
				)
			)
			(614
				(if (> (gEgo y:) 171)
					(gEgo y: 171)
				)
			)
			(else
				(gEgo setLoop: 0 setCel: 0 posn: 1000 1000)
				(if (IsFlag 15)
					(ulence status: 1)
				)
				(self setScript: landShip)
			)
		)
		(door init: setCel: 0)
		(ship init:)
		(gEgo init: illegalBits: 0 ignoreActors: 1)
		(super init:)
		(self
			setFeatures: building
			setRegions: 706 ; ulence
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 165 256 156 194 137 197 133 236 133 235 127 205 127 190 122 149 121 144 140 104 140 59 154 38 146 40 124 0 124
					yourself:
				)
		)
		(if (and (not (Random 0 3)) (== (ulence status:) 1))
			(ulence status: 2)
			(Load rsVIEW 633)
			(Load rsVIEW 635)
			(Load rsSOUND 50)
		)
	)

	(method (doit)
		(if
			(and
				(== (ulence status:) 4)
				(< ((ScriptID 706 2) distanceTo: gEgo) 15) ; theBiker
			)
			(HandsOff)
			(ulence status: 6)
			(gEgo setScript: 0)
			(ulence deathLoop: 1)
			(self setScript: (ScriptID 706 4)) ; theDeathScript
		)
		(cond
			(script 0)
			((and (== (ulence status:) 2) (gEgo inRect: 220 170 259 182))
				(HandsOff)
				(ulence status: 3)
				((ScriptID 706 2) ; theBiker
					view: 633
					init:
					hide:
					posn: 0 (- (gEgo y:) 5)
					setLoop: 0
					setScript: bikerScript
				)
				(gEgo setScript: (ScriptID 706 6)) ; theDodgeL
			)
		)
		(super doit: &rest)
	)
)

(instance landShip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(door setPri: 14)
				(gEgo
					view: 378
					posn: 106 143
					illegalBits: 0
					ignoreActors: 1
					normal: 0
				)
				(= cycles 1)
			)
			(1
				(gEgo show:)
				(= seconds 2)
			)
			(2
				(gLongSong2 number: 124 loop: 1 play:)
				(= seconds 2)
			)
			(3
				(door setCycle: End self)
			)
			(4
				(= seconds (Random 2 4))
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(proc706_1)
				(ship priority: -1 stopUpd:)
				(= cycles 1)
			)
			(7
				(gEgo setHeading: 135 self)
			)
			(8
				(gEgo setLoop: 4 heading: 135 setMotion: MoveTo 110 142 self)
			)
			(9
				(gLongSong2 number: 125 play:)
				(door setPri: 5 setCycle: Beg self)
			)
			(10
				(proc706_1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterPod of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setMotion: PolyPath 111 147 self
				)
			)
			(1
				(gLongSong2 number: 124 loop: 1 play:)
				(= cycles 3)
			)
			(2
				(door setCycle: End self)
			)
			(3
				(door setPri: 14)
				(gEgo
					setPri: 5
					posn: 110 121
					setCel: 0
					view: 378
					setLoop: 1
					cycleSpeed: 1
				)
				(= cycles 1)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(gLongSong2 number: 125 play:)
				(door setCycle: Beg self)
			)
			(6
				(proc0_14 { } global146)
				(gCurRoom newRoom: 531)
			)
		)
	)
)

(instance ship of Prop
	(properties
		x 93
		y 146
		description {Time Pod}
		view 617
		signal 24576
	)

	(method (init)
		(super init:)
		(self setPri: 4 addToPic:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(Print 613 0) ; "You give the Time Pod a long glance. It's not the most attractive vehicle you've ever seen. It resembles an overgrown titanium tennis shoe. A gold-tinted glass shield seals the top."
			)
			(4 ; Do
				(HandsOff)
				(gCurRoom setScript: enterPod)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 80
		y 107
		view 617
		loop 1
		priority 5
		signal 24592
	)
)

(instance building of Feature
	(properties
		x 256
		y 92
		nsTop 29
		nsLeft 194
		nsBottom 155
		nsRight 319
		description {building}
		sightAngle 45
		onMeCheck 2
		lookStr {This closely resembles the left side of Droids-B-Us.}
	)
)

(instance bikerScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gLongSong vol: 5 number: 50 loop: -1 play: fade: 127 10 10 0)
				(= seconds 3)
			)
			(1
				((ScriptID 706 2) ; theBiker
					show:
					setMotion: MoveTo 65 (- (gEgo y:) 5) self
				)
			)
			(2
				(ulence status: 4)
				(HandsOn)
				((ScriptID 706 2) ; theBiker
					setPri: (+ (gEgo priority:) 1)
					setMotion: MoveTo 338 (- (gEgo y:) 5) self
				)
			)
			(3
				(gLongSong fade:)
				((ScriptID 706 2) hide:) ; theBiker
				(= seconds 3)
			)
			(4
				(if (== (ulence status:) 5)
					(ulence status: 1)
					(proc706_1)
					(HandsOn)
					(gEgo setScript: 0)
				else
					(EgoDead 613 1)
				)
				(self dispose:)
			)
		)
	)
)

