;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use Scaler)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm400 0
	sUseComm 20
)

(local
	[local0 2]
)

(instance rm400 of Rm
	(properties
		noun 5
		picture 81
	)

	(method (init)
		(LoadMany rsVIEW 451)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 176 301 172 301 153 193 98 168 99 157 91 144 95 113 96 79 93 81 99 95 99 119 100 99 115 63 129 33 135 0 133
					yourself:
				)
		)
		(gEgo view: 0 init:)
		(theExit init:)
		(theCanister init: setOnMeCheck: 1 4)
		(theHeatwaves init:)
		(theMoon init:)
		(theRocks init: setOnMeCheck: 1 4096)
		(switch gPrevRoomNum
			(240
				(gCurRoom style: 7 setScript: sInitRoom)
			)
			(410
				(gCurRoom style: 12 setScript: sInitRoom)
			)
			(else
				(gCurRoom style: 7 setScript: sInitRoom)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(if (and (StepOn gEgo 2) (== global131 1) (not (gCurRoom script:)))
			(ClearFlag 100)
			(gCurRoom newRoom: 410)
		)
		(if (and (StepOn gEgo 8) (not (gCurRoom script:)))
			(SetFlag 100)
			(gCurRoom newRoom: 410)
		)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance sInitRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sun init:)
				(dust init:)
				(dust2 init:)
				(dust3 init:)
				(switch global131
					(1
						(canCoverL init: stopUpd:)
						(canCoverR init: stopUpd:)
						(if (IsFlag 100)
							(NormalEgo 0 0)
							(gEgo
								init:
								x: 79
								y: 93
								setScale: Scaler 100 48 163 99
								setMotion: MoveTo 124 101 self
							)
						else
							(NormalEgo 0 0)
							(gEgo
								init:
								x: (- (gEgo x:) 320)
								y: (gEgo y:)
								setScale: Scaler 100 48 163 99
								setMotion: MoveTo 60 145 self
							)
						)
					)
					(2
						(gEgo hide: dispose:)
						(roger init: x: -40 y: 75 hide:)
						(rogblink init: hide:)
						(self setScript: sCanister self)
					)
					(else
						(= cycles 1)
					)
				)
				(= seconds 1)
			)
			(1
				(= seconds 3)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sUseComm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 14 setLoop: 0 cel: 0 setCycle: End self)
				(gSq5Music2 number: 603 loop: 1 play:)
			)
			(1
				(gMessager say: 2 32 0 0 self 401) ; "This is Eureka, go ahead, Captain Wilco."
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(NormalEgo 0)
				(gEgo loop: 2)
				(= seconds 1)
			)
			(4
				(gEgo view: 6 setLoop: 0 cel: 15 setCycle: Beg self)
				(gSq5Music2 number: 260 loop: 1 play:)
			)
			(5
				(gSq5Music1 fade:)
				(gCurRoom newRoom: 240)
			)
		)
	)
)

(instance sCanister of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(roger show: setPri: 14 setMotion: MoveTo 0 75 self)
				(rogblink show:)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roger setMotion: MoveTo -50 75 self)
			)
			(1
				(roger hide:)
				(rogblink hide:)
				(= cycles 2)
			)
			(2
				(gCurRoom newRoom: 410)
			)
		)
	)
)

(instance roger of Actor
	(properties
		y 75
		view 451
		loop 2
		signal 24576
		illegalBits 0
	)

	(method (init)
		(super init: &rest)
		(self setLoop: 2 setCel: 0)
	)
)

(instance rogblink of Prop
	(properties
		x 36
		y 112
		view 451
		loop 3
	)

	(method (init)
		(super init: &rest)
		(self setLoop: 3 cycleSpeed: 100 setPri: 15 setCycle: Fwd)
	)

	(method (doit)
		(self x: (+ (roger x:) 36) y: 112)
		(super doit: &rest)
	)
)

(instance sun of Prop
	(properties
		x 88
		y 57
		view 451
		detailLevel 2
	)

	(method (init)
		(self setLoop: 0 setCycle: Fwd cycleSpeed: 10)
		(super init: &rest)
	)
)

(instance dust of Prop
	(properties
		x 265
		y 28
		view 451
		loop 1
		detailLevel 2
	)

	(method (init)
		(self setLoop: 1 setCycle: Fwd cycleSpeed: 10)
		(super init: &rest)
	)
)

(instance dust2 of Prop
	(properties
		x 253
		y 36
		view 451
		loop 1
		detailLevel 2
	)

	(method (init)
		(self setLoop: 1 setCycle: Fwd cycleSpeed: 10)
		(super init: &rest)
	)
)

(instance dust3 of Prop
	(properties
		x 10
		y 11
		view 451
		loop 1
		detailLevel 2
	)

	(method (init)
		(self setLoop: 1 setCycle: Fwd cycleSpeed: 10)
		(super init: &rest)
	)
)

(instance canCoverL of View
	(properties
		x 191
		y 114
		view 451
		loop 4
		cel 1
		priority 15
		signal 16
	)
)

(instance canCoverR of View
	(properties
		x 4
		y 126
		view 451
		loop 4
		priority 15
		signal 16
	)
)

(instance theExit of Feature
	(properties
		x 10
		nsBottom 200
		nsRight 320
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(gCurRoom setScript: sExit)
			)
			(4 ; Do
				(gCurRoom setScript: sExit)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theCanister of Feature
	(properties
		x 200
		y 150
		noun 1
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== global131 2)
					(SetScore 222 50)
					(gMessager say: 1 1 0 0) ; "The canister bears the phrase ''Primordial Soup'' and the logo of the Genetix Research Corporation."
				else
					(gMessager say: 4 1 0 0) ; "A suspicious looking object which you can't quite discern from your present location is wedged in the rocks above you."
				)
			)
			(3 ; Walk
				(if (== global131 2)
					(gMessager say: 1 3 0 0) ; "That would not prudent at this juncture."
				)
			)
			(4 ; Do
				(if (== global131 2)
					(gMessager say: 1 4 0 0) ; "The Surgeon General warns that handling a toxic waste container may be hazardous to your health."
				)
			)
			(else
				(super doVerb: &rest)
			)
		)
	)
)

(instance theMoon of Feature
	(properties
		x 100
		y 28
		noun 3
		nsTop 9
		nsLeft 66
		nsBottom 58
		nsRight 151
	)
)

(instance theHeatwaves of Feature
	(properties
		x 100
		y 100
		noun 2
		nsTop 60
		nsLeft 91
		nsBottom 70
		nsRight 142
	)
)

(instance theRocks of Feature
	(properties
		x 160
		y 100
		noun 6
		onMeCheck 4096
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 6 1 0 (Random 1 3) 0)
			)
			(else
				(super doVerb: &rest)
			)
		)
	)
)

