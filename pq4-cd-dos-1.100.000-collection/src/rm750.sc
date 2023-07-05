;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 750)
(include sci.sh)
(use Main)
(use Scaler)
(use Polygon)
(use Feature)
(use Rev)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm750 0
)

(instance rm750 of Room
	(properties
		noun 1
		picture 750
	)

	(method (doRemap)
		(gGame doRemap: 2 253 85)
		(gGame doRemap: 2 254 75)
	)

	(method (init)
		(super init: &rest)
		(if (gPqFlags test: 123)
			(self
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 132 94 123 111 101 111 101 117 124 117 104 153 181 153 165 97 174 97 174 94
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 132 94 123 111 101 111 101 117 124 117 165 121 165 129 117 143 104 153 181 153 165 97 174 97 174 94
						yourself:
					)
			)
			(if (gPqFlags test: 142)
				(dog ignoreActors: loop: 1 cel: 11 init:)
			else
				(dog init:)
				(gWalkHandler addToFront: self)
			)
		)
		(carpet init:)
		(wall1 init:)
		(wall2 init:)
		(vent init:)
		(farLite init:)
		(closeLite init:)
		(switch gPrevRoomNum
			(735
				(gEgo posn: 120 115)
			)
			(755
				(gEgo posn: 165 95)
			)
			(else
				(gEgo posn: 161 151)
			)
		)
		(gEgo
			view: 9120
			origStep: 2052
			heading:
				(switch gPrevRoomNum
					(735 90)
					(755 270)
					(else 0)
				)
			normalize: 9120
			setScaler: Scaler 111 35 153 81
			init:
		)
		(gGame handsOn:)
	)

	(method (handleEvent event)
		(if (& (event type:) evMOVE)
			(if (< (event y:) 151)
				(self setScript: stepBack)
				(event claimed: 1)
				(return)
			else
				(event claimed: 0)
				(return)
			)
		else
			(super handleEvent: event)
			(return)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			((InRect 101 111 118 117 gEgo)
				(self newRoom: 735)
			)
			((InRect 167 93 174 97 gEgo)
				(self newRoom: 755)
			)
			((> (gEgo y:) 152)
				(if (and (gCast contains: dog) (not (gPqFlags test: 142)))
					(gWalkHandler delete: self)
				)
				(self newRoom: 745)
			)
		)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance stepBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 9120
					setLoop: 3 1
					setMotion: MoveTo (gEgo x:) 144 self
				)
			)
			(1
				(dogSound number: 991 loop: 1 play:)
				(= ticks 30)
			)
			(2
				(gEgo
					view: 9120
					setLoop: 3 1
					setCycle: Rev
					setMotion: MoveTo (gEgo x:) 151 self
				)
			)
			(3
				(gEgo heading: 0 setLoop: -1 setCycle: 0 normalize: 9120)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance dogFallAsleep of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 0 self)
			)
			(1
				(gEgo view: 9126 loop: 3 cel: 0 setCycle: End self)
				(dog view: 750 loop: 0 cel: 1)
			)
			(2
				(gMessager say: 5 39 0 1 self) ; "Here you go, boy, ... Good dog.."
			)
			(3
				(= ticks 120)
			)
			(4
				(gEgo put: 26 setCycle: Beg self) ; pills
			)
			(5
				(gEgo view: 9120 loop: 3 normalize: 9120)
				(= ticks 180)
			)
			(6
				(dog cycleSpeed: 8 setCycle: End self)
			)
			(7
				(dog ignoreActors: loop: 1 setCycle: End self)
			)
			(8
				(gPqFlags set: 142)
				(gWalkHandler delete: gCurRoom)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance dog of Prop
	(properties
		noun 5
		sightAngle 360
		x 146
		y 134
		scaleX 103
		scaleY 103
		priority 121
		fixPriority 1
		view 750
		scaleSignal 1
	)

	(method (doVerb theVerb)
		(if (not (gPqFlags test: 142))
			(gEgo setHeading: 0)
		else
			(Face gEgo dog)
		)
		(if (gPqFlags test: 142)
			(if
				(OneOf
					theVerb
					74 ; candyBar
					38 ; caseChalk
					30 ; cigarette
					29 ; coins
					4 ; Do
					12 ; evidenceCase
					43 ; caseFlashlight
					24 ; fullClip
					17 ; glue
					22 ; handgun
					46 ; keys
					1 ; Look
					18 ; mirror
					28 ; newspaper
					32 ; pretzels
					61 ; casePuttyKnife
					31 ; shoe
					2 ; Talk
					20 ; wallet
				)
				(gMessager say: noun theVerb 1 0)
			else
				(gMessager say: 5 4 1) ; "Leave the dog alone, Carey. You don't want to wake him."
			)
		else
			(switch theVerb
				(39 ; pills
					(gGame points: 5)
					(gCurRoom setScript: dogFallAsleep)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance carpet of Feature
	(properties
		noun 2
		x 146
		y 97
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 127 93 168 93 190 147 105 147
					yourself:
				)
		)
	)
)

(instance farLite of Feature
	(properties
		noun 7
		x 150
		y 98
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 128 29 127 93 168 93 168 27 171 26 171 96 123 98 122 23
					yourself:
				)
		)
	)
)

(instance closeLite of Feature
	(properties
		noun 6
		x 150
		y 120
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 175 18 180 12 180 120 114 120 114 17 120 22 120 111 174 111
					yourself:
				)
		)
	)
)

(instance wall1 of Feature
	(properties
		noun 3
		nsLeft 37
		nsRight 102
		nsBottom 148
		x 65
		y 147
	)
)

(instance wall2 of Feature
	(properties
		noun 3
		nsLeft 198
		nsRight 283
		nsBottom 148
		x 240
		y 147
	)
)

(instance vent of Feature
	(properties
		noun 4
		nsLeft 216
		nsTop 137
		nsRight 273
		nsBottom 148
		x 250
		y 148
	)
)

(instance dogSound of Sound
	(properties)
)

