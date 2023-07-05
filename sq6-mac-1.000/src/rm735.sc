;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 735)
(include sci.sh)
(use Main)
(use SQRoom)
(use ExitFeature)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm735 0
)

(local
	local0
)

(instance rm735 of SQRoom
	(properties
		noun 1
		picture 735
	)

	(method (init)
		(if (!= (gGSound1 number:) 640)
			(gGSound1 number: 640 setLoop: -1 play:)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 79 46 38 58 19 50 15 52 38 61 80 48
					yourself:
				)
		)
		(super init:)
		(gEgo
			init:
			normalize:
			setScale: 0
			setPri: 55
			enterRoom: 99 43 79 46 self
		)
		(exit730 init: gTheExitECursor approachVerbs: 7) ; ExitRight
		(fillingF init: approachVerbs: 4) ; Do
		(if (not (IsFlag 426))
			(fillingV init: ignoreActors: approachVerbs: 4) ; Do
		)
		(nailF init: approachVerbs: 4) ; Do
		(if (not (IsFlag 428))
			(nailV init: setPri: 65 ignoreActors: approachVerbs: 4) ; Do
		)
		(clipF init: approachVerbs: 4) ; Do
		(if (not (IsFlag 427))
			(clipV init: setPri: 100 ignoreActors: approachVerbs: 4) ; Do
		)
		(buckazoidF init:)
		(sludgeF init:)
		(screwF init:)
		(colonF init:)
		(gWalkHandler addToEnd: colonF)
	)

	(method (cue)
		(gGame handsOn:)
	)

	(method (dispose)
		(gEgo setScale: 0 normalize:)
		(gWalkHandler delete: colonF)
		(super dispose:)
	)
)

(instance fillingV of View
	(properties
		sightAngle 40
		approachX 50
		approachY 65
		x 51
		y 68
		view 730
		signal 16384
	)

	(method (doVerb theVerb)
		(fillingF doVerb: theVerb &rest)
	)
)

(instance nailV of View
	(properties
		sightAngle 40
		approachX 50
		approachY 68
		x 70
		y 70
		view 730
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(nailF doVerb: theVerb &rest)
	)
)

(instance clipV of View
	(properties
		noun 2
		sightAngle 40
		approachX 50
		approachY 68
		x 45
		y 81
		z 16
		view 730
		loop 2
		signal 16384
	)

	(method (doVerb theVerb)
		(clipF doVerb: theVerb &rest)
	)
)

(instance exit730 of ExitFeature
	(properties
		sightAngle 40
		approachX 79
		approachY 46
		x 250
		y 10
		nextRoom 730
		message 7
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 77 0 82 2 94 17 101 31 107 59 119 44 123 33 128 24 156 6 169 4 169 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance fillingF of Feature
	(properties
		noun 3
		sightAngle 40
		approachX 50
		approachY 65
		x 80
		y 48
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 53 63 54 57 59 51 63 49 68 48 71 44 79 39 78 37 82 34 83 34 88 20 94 18 102 38 104 48 97 58 79 65 66 65
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 426)
					(gMessager say: noun theVerb 1) ; "You've got as much of that as you can carry."
				else
					(gCurRoom setScript: sGetFilling)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance nailF of Feature
	(properties
		noun 6
		sightAngle 40
		approachX 50
		approachY 68
		x 78
		y 88
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 29 56 45 55 56 65 68 67 79 66 81 68 73 73 59 72 45 69 31 62
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 428)
					(gMessager say: noun theVerb 1) ; "You've got as much of that as you can carry."
				else
					(gCurRoom setScript: sGetNail)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance clipF of Feature
	(properties
		noun 2
		sightAngle 40
		approachX 50
		approachY 68
		x 50
		y 81
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 54 81 46 61 46 27 42 27 42 62 51 81
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 427)
					(gMessager say: noun theVerb 1) ; "You've got as much of that as you can carry."
				else
					(gCurRoom setScript: sGetClip)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance buckazoidF of Feature
	(properties
		noun 4
		sightAngle 40
		x 70
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 96 115 74 104 70 96 72 88 79 85 88 85 105 92 109 95 108 102 102 110
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance sludgeF of Feature
	(properties
		noun 8
		sightAngle 360
		x 70
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 42 68 68 74 82 70 105 55 110 90 109 98 97 113 90 117 70 118 59 113 51 104 45 84
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance screwF of Feature
	(properties
		noun 5
		sightAngle 40
		x 70
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 71 79 79 84 89 84 97 87 104 84 101 70 95 67 90 67 87 75
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance colonF of Feature
	(properties
		noun 7
		sightAngle 40
		approachX 19
		approachY 50
		y 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(gCurRoom setScript: checkOutColon)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 52 18 56 18 0 0 0 yourself:)
		)
		(super init: &rest)
	)
)

(instance checkOutColon of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 9 49 self)
			)
			(1
				(= ticks 45)
			)
			(2
				(gMessager say: 7 3 0 0 self) ; "No, I think I've already done things above and beyond the call of duty. Hey, a guy has to draw the line somewhere, and gosh darn it, this guy's drawing the line right at the ... right at, er ... at, at the colon."
			)
			(3
				(gEgo setMotion: MoveTo 19 50 self)
			)
			(4
				(gEgo normalize: 0 setPri: 55)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetFilling of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 738) ; WAVE
				(= local0 (gEgo cycleSpeed:))
				(fillingV dispose:)
				(gEgo
					view: 731
					setLoop: 0 1
					setCel: 0
					setPri: 100
					x: 51
					y: 68
					setSpeed: 6
					setCycle: CT 15 1 self
				)
			)
			(1
				(gEgo setCycle: End self)
				(sfx number: 738 setLoop: 1 play:)
				(sfx number: 738 setLoop: 1 play:)
			)
			(2
				(gEgo get: 102) ; Silver_Chunk
				(gGame points: 1 426)
				(gMessager say: 3 4 0 0 self) ; "You pull away a cracked piece of the filling."
			)
			(3
				(gEgo posn: 47 58 normalize: 4 setPri: 55 setSpeed: local0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetNail of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 736) ; WAVE
				(Load 140 737) ; WAVE
				(= local0 (gEgo cycleSpeed:))
				(gEgo setSpeed: 6 setPri: 60 setMotion: MoveTo 50 68 self)
			)
			(1
				(gEgo
					view: 736
					setLoop: 0 1
					setCel: 0
					setPri: 70
					setCycle: End self
				)
			)
			(2
				(gEgo
					posn: 48 69
					normalize: 2
					setSpeed: 6
					setMotion: MoveTo 78 88 self
				)
			)
			(3
				(gEgo setHeading: 315 self)
			)
			(4
				(gEgo
					view: 732
					setLoop: 0 1
					setCel: 0
					setPri: 100
					posn: 78 88
					setCycle: CT 6 1 self
				)
			)
			(5
				(gEgo setCycle: CT 20 1 self)
				(sfx number: 736 setLoop: -1 play:)
			)
			(6
				(sfx number: 737 setLoop: 1 play:)
				(nailV dispose:)
				(gEgo setCycle: End self)
			)
			(7
				(gEgo get: 47) ; Finger_Nail
				(gGame points: 1 428)
				(gMessager say: 6 4 0 0 self) ; "You snap off a shard of fingernail and gingerly introduce it into your pocket."
			)
			(8
				(gEgo normalize: 7 setSpeed: 6 setMotion: MoveTo 48 69 self)
			)
			(9
				(gEgo view: 736 setLoop: 1 1 setCel: 0 setCycle: End self)
			)
			(10
				(gEgo
					posn: 51 67
					normalize: 3
					setSpeed: 6
					setPri: 55
					setMotion: MoveTo 50 57 self
				)
			)
			(11
				(gEgo setSpeed: local0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetClip of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 735) ; WAVE
				(= local0 (gEgo cycleSpeed:))
				(gEgo setSpeed: 6 setMotion: MoveTo 50 68 self)
			)
			(1
				(gEgo
					view: 736
					setLoop: 0 1
					setCel: 0
					setPri: 80
					setCycle: End self
				)
			)
			(2
				(gEgo
					posn: 48 69
					normalize: 2
					setSpeed: 6
					setMotion: MoveTo 54 78 self
				)
			)
			(3
				(gEgo setHeading: 225 self)
			)
			(4
				(clipV dispose:)
				(gEgo
					view: 733
					setLoop: 0 1
					setCel: 0
					setPri: 80
					setCycle: CT 26 1 self
				)
			)
			(5
				(gEgo setCycle: End self)
				(sfx number: 735 setLoop: 1 play:)
			)
			(6
				(gEgo get: 76) ; Paperclip
				(gGame points: 1 427)
				(gMessager say: 2 4 0 0 self) ; "You carefully -- VERY carefully -- stow the paper clip in your pocket."
			)
			(7
				(gEgo normalize: 7 setSpeed: 6 setMotion: MoveTo 48 69 self)
			)
			(8
				(gEgo view: 736 setLoop: 1 1 setCel: 0 setCycle: End self)
			)
			(9
				(gEgo
					posn: 51 67
					normalize: 3
					setSpeed: 6
					setPri: 55
					setMotion: MoveTo 50 57 self
				)
			)
			(10
				(gEgo setSpeed: local0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sfx of Sound
	(properties)
)

