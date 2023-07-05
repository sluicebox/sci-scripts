;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1050)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	rm1050 0
)

(local
	local0
)

(instance rm1050 of KQRoom
	(properties
		picture 1050
	)

	(method (init)
		(Load rsMESSAGE 1050)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 66 73 63 92 83 100 88 130 280 129 280 88 231 80 209 79 173 85 158 93 131 93 97 88 96 75 73 68 44 68
					yourself:
				)
		)
		(SetFlag 21)
		(gEgo
			init:
			normalize:
			setHeading: 135
			posn: 81 77
			setScaler: Scaler 100 52 97 66
		)
		(if (not (IsFlag 311))
			(pot1 init:)
		)
		(if (not (IsFlag 312))
			(pot2 init:)
		)
		(if (not (IsFlag 313))
			(pot3 init:)
		)
		(if (not (IsFlag 339))
			(pot4 init:)
		)
		(if (and (== gChapter 1) (not (gEgo has: 7)) (== gValOrRoz -4)) ; Basket, Val
			(basket init:)
		)
		(outCave init:)
		(gKqMusic1 number: 1050 setLoop: -1 play: setVol: 0 fade: 127 25 10 0)
		(self setScript: enterCave)
	)

	(method (dispose)
		(gKqMusic1 fade:)
		(super dispose:)
	)
)

(instance enterCave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 87 90 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance leaveCave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 62 70 self)
			)
			(1
				(gGame handsOn:)
				(gEgo setScale:)
				(gCurRoom newRoom: 1100)
			)
		)
	)
)

(instance getPot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cond
					((IsFlag 309)
						(Load 140 1053) ; WAVE
					)
					((IsFlag 308)
						(Load 140 1052) ; WAVE
					)
					(else
						(Load 140 1051) ; WAVE
					)
				)
				(gEgo view: 8072 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(1
				(cond
					((IsFlag 310)
						(gEgo get: 2) ; Clay_Pot
						(= cycles 2)
					)
					((IsFlag 309)
						(SetFlag 310)
						(gKqSound1 number: 1053 play:)
						(= local0 1)
						(gEgo
							view: 8262
							setLoop: 0
							setCel: 0
							setCycle: End self
						)
					)
					((IsFlag 308)
						(SetFlag 309)
						(gKqSound1 number: 1052 play:)
						(gEgo
							view: 8312
							setLoop: 0
							setCel: 0
							setCycle: End self
						)
					)
					(else
						(SetFlag 308)
						(gKqSound1 number: 1051 play:)
						(gEgo
							view: 8342
							setLoop: 0
							setCel: 0
							setCycle: End self
						)
					)
				)
				(if (not (gEgo has: 2)) ; Clay_Pot
					(register setCycle: End)
				)
			)
			(2
				(if (not (IsFlag 310))
					(= ticks 120)
				else
					(self cue:)
				)
			)
			(3
				(register dispose:)
				(if (not (IsFlag 310))
					(gEgo setCycle: Beg self)
				else
					(= ticks 60)
				)
			)
			(4
				(gEgo normalize: 2)
				(= cycles 3)
			)
			(5
				(if local0
					(gMessager say: 0 0 1 0 self) ; "I'm getting awfully tired of this."
				else
					(self cue:)
				)
			)
			(6
				(if local0
					(= local0 0)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getBasket of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gMessager say: 1 8 0 0 self) ; "Isn't that cute?"
			)
			(2
				(gEgo view: 8061 setLoop: 1 cel: 0 setCycle: End self)
			)
			(3
				(basket dispose:)
				(gEgo get: 7 setCycle: Beg self) ; Basket
			)
			(4
				(gEgo normalize: 1 setHeading: 180 self)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pot1 of Prop
	(properties
		sightAngle 10
		approachX 110
		approachY 118
		x 112
		y 139
		z 40
		view 1050
	)

	(method (init)
		(super init: &rest)
		(if (== gValOrRoz -4) ; Val
			(self setHotspot: 8 10) ; Do, Exit
		)
		(self setPri: 200 ignoreActors: approachVerbs: 8) ; Do
		(|= signal $1000)
	)

	(method (doVerb)
		(gCurRoom setScript: getPot 0 self)
		(SetFlag 311)
		(return 1)
	)
)

(instance pot2 of Prop
	(properties
		sightAngle 10
		approachX 127
		approachY 118
		x 129
		y 139
		z 40
		view 1050
		loop 1
	)

	(method (init)
		(super init: &rest)
		(if (== gValOrRoz -4) ; Val
			(self setHotspot: 8 10) ; Do, Exit
		)
		(self setPri: 200 ignoreActors: approachVerbs: 8) ; Do
		(|= signal $1000)
	)

	(method (doVerb)
		(gCurRoom setScript: getPot 0 self)
		(SetFlag 312)
		(return 1)
	)
)

(instance pot3 of Prop
	(properties
		sightAngle 10
		approachX 144
		approachY 118
		x 146
		y 139
		z 40
		view 1050
		loop 2
	)

	(method (init)
		(super init: &rest)
		(if (== gValOrRoz -4) ; Val
			(self setHotspot: 8 10) ; Do, Exit
		)
		(self setPri: 200 ignoreActors: approachVerbs: 8) ; Do
		(|= signal $1000)
	)

	(method (doVerb)
		(gCurRoom setScript: getPot 0 self)
		(SetFlag 313)
		(return 1)
	)
)

(instance pot4 of Prop
	(properties
		sightAngle 10
		approachX 161
		approachY 118
		x 163
		y 139
		z 40
		view 1050
		loop 2
	)

	(method (init)
		(super init: &rest)
		(if (== gValOrRoz -4) ; Val
			(self setHotspot: 8 10) ; Do, Exit
		)
		(self setPri: 200 ignoreActors: approachVerbs: 8) ; Do
		(|= signal $1000)
	)

	(method (doVerb)
		(gCurRoom setScript: getPot 0 self)
		(SetFlag 339)
		(return 1)
	)
)

(instance basket of View
	(properties
		noun 1
		sightAngle 20
		approachX 104
		approachY 110
		x 73
		y 114
		view 1050
		loop 4
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors: setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)

	(method (doVerb)
		(gCurRoom setScript: getBasket)
	)
)

(instance outCave of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			exitDir: 5
			setHotspot: 10 10 ; Exit, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 40 64 68 63 77 48 71 30 52 23 28 43 32 56
					yourself:
				)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:) 0)
			((and (& (event type:) evMOVE) (self onMe: event))
				(event claimed: 1)
				(gCurRoom setScript: leaveCave)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

