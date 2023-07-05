;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2206)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm2206 0
)

(instance mechSound of Sound
	(properties)
)

(instance rm2206 of KQRoom
	(properties
		picture 2200
	)

	(method (init)
		(super init: &rest)
		(SetFlag 570)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 306 130 319 114 318 99 282 109 263 108 272 121 216 130 171 119 157 102 132 99 116 103 94 97 63 93 51 96 93 99 120 108 62 123 28 126 32 130 254 137
					yourself:
				)
		)
		(Load rsMESSAGE 2200)
		(if (IsFlag 258)
			(theDevice init:)
			(if (IsFlag 259)
				(theDevice loop: 1 setCycle: Fwd setCycle: Fwd)
			else
				(theDevice cel: 5)
			)
		)
		(myEastExit init:)
		(= gValOrRoz -3) ; Roz
		(gEgo
			posn: 319 108
			normalize: 1
			setScaler: Scaler 90 90 145 101
			init:
		)
		(gKqMusic1 stop: number: 2206 setLoop: -1 play:)
		(mechSound number: 2201 setLoop: -1 play: setVol: 0 fade: 127 25 10 0)
		(king init:)
		(plug init:)
		(gauge cel: (- (NumCels gauge) 1) init:)
		(self setScript: backHere)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(plugTimer client: 0 delete: dispose:)
		(ClearFlag 570)
		(super dispose: &rest)
	)
)

(instance theEnd of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 225 self)
				(king setHotspot: 0)
			)
			(1
				(gEgo
					posn: 87 98
					view: 2249
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(= register (gEgo cycleSpeed:))
				(gEgo
					setScale: 0
					posn: 84 114
					view: 2212
					setPri: 109
					setLoop: 1
					setCel: 0
					setCycle: CT 8 1 self
				)
			)
			(3
				(king hide:)
				((ScriptID 0 9) client: 0 dispose: delete:) ; volcanoDeathTimer
				(gEgo cycleSpeed: 14 setCycle: End self)
				(UpdateScreenItem gEgo)
			)
			(4
				(gEgo
					posn: 91 98
					view: 2213
					setLoop: 4
					setCel: 0
					cycleSpeed: register
					setCycle: End self
				)
				(gKqSound1 number: 2263 setLoop: 1 play:)
				(king
					show:
					posn: 83 116
					view: 2212
					setLoop: 2
					setCel: 0
					setPri: 120
					setCycle: End self
				)
			)
			(5 0)
			(6
				(gEgo
					setScale:
					scaleX: 115
					scaleY: 115
					normalize: 2
					posn: 86 100
				)
				(king
					posn: 73 129
					view: 2213
					cycleSpeed: 14
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
				(gKqSound1 number: 22630 setLoop: 1 play:)
			)
			(7
				(gGame handsOn:)
				(gEgo setHeading: 135)
				(king
					posn: 210 111
					setPri: 200
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(8
				(king setLoop: 2 setCel: 0 setCycle: End self)
			)
			(9
				(gCurRoom newRoom: 2150)
			)
		)
	)
)

(instance shakeKing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 225 self)
			)
			(1
				(gEgo
					posn: 87 98
					view: 8534
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(king hide:)
				(gEgo
					setScale: 0
					posn: 85 113
					view: 2212
					setLoop: 0
					setCel: 0
					setCycle: Osc 5 self
				)
				(gKqSound1 number: 2262 setLoop: 1 play:)
			)
			(3
				(king show:)
				(gEgo
					posn: 87 98
					view: 8534
					setScaler: Scaler 90 90 145 101
					setLoop: 1
					setCel: -1
					setCycle: Beg self
				)
			)
			(4
				(gEgo normalize: 5 posn: 87 101)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance backHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 266 124 self)
			)
			(1
				(if (not (IsFlag 259))
					(plugTimer setReal: plugTimer 18)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance plugDevice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 2243 setLoop: 1 setCel: 0 setCycle: CT 4 1 self)
			)
			(1
				(SetFlag 258)
				(theDevice init: setScript: deviceGlows)
				(gEgo setCycle: Beg self put: 62) ; Device
			)
			(2
				(gEgo normalize:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance unplugDevice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 2243 setLoop: 1 setCel: 0 setCycle: CT 4 1 self)
			)
			(1
				(ClearFlag 258)
				(theDevice hide: dispose:)
				(= cycles 2)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo normalize: get: 62) ; Device
				(= cycles 2)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance deviceGlows of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (plugTimer seconds:) 0)
					(SetFlag 259)
					(client setCycle: End self)
				else
					(client setCycle: CT 5 1 self)
				)
			)
			(1
				(if (IsFlag 259)
					(client loop: 1 cel: 0 cycleSpeed: 6 setCycle: Fwd)
				)
				(= ticks 1)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance king of Actor
	(properties
		x 141
		y 124
		priority 110
		fixPriority 1
		view 2206
		loop 2
		cel 18
		signal 4129
	)

	(method (init)
		(super init: &rest)
		(self
			approachVerbs: 8 10 80 ; Do, Exit, Fragrant_Flower
			approachX: 87
			approachY: 101
			setHotspot: 8 10 80 ; Do, Exit, Fragrant_Flower
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(80 ; Fragrant_Flower
				(gCurRoom setScript: theEnd)
			)
			(8 ; Do
				(gCurRoom setScript: shakeKing)
			)
		)
	)
)

(instance theDevice of Prop
	(properties
		approachX 82
		approachY 96
		x 55
		y 80
		view 2210
		cycleSpeed 48
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
	)

	(method (cue)
		(self setCel: 0 setCycle: 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gEgo setScript: unplugDevice)
			)
		)
	)
)

(instance gauge of Prop
	(properties
		x 148
		y 72
		priority 97
		fixPriority 1
		view 2239
		loop 2
		cycleSpeed 22
	)
)

(instance plug of Feature
	(properties
		nsLeft 62
		nsTop 65
		nsRight 75
		nsBottom 75
		approachX 82
		approachY 96
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 85 setHotspot: 0 85) ; Device, Device
	)

	(method (doVerb theVerb)
		(switch theVerb
			(85 ; Device
				(gEgo setScript: plugDevice)
			)
		)
	)
)

(instance myEastExit of ExitFeature
	(properties
		nsLeft 310
		nsRight 320
		nsBottom 136
		sightAngle 360
		approachX 318
		approachY 103
		exitDir 2
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
	)

	(method (doVerb)
		(gCurRoom newRoom: 2350)
	)
)

(instance plugTimer of Timer
	(properties)

	(method (cue))
)

