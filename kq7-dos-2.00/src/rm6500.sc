;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6500)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Scaler)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	rm6500 0
)

(instance rm6500 of KQRoom
	(properties
		picture 6500
	)

	(method (init)
		(SetFlag 21)
		(Load rsVIEW 6501)
		(gKqMusic1 number: 6450 loop: 1 play:)
		(super init:)
		(gGame handsOff:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 320 0 320 86 303 77 249 105 218 103 210 111 135 98 116 72 52 84 0 100
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 109 92 115 212 120 280 117 320 110 320 136 0 136
					yourself:
				)
		)
		(switch gPrevRoomNum
			(6550
				(gCurRoom setScript: sLeaveCastle)
			)
			(else
				(if (IsFlag 213)
					(Load rsVIEW 6503)
					(gCurRoom setScript: sAwake)
				else
					(Load rsVIEW 6502)
					(gCurRoom setScript: sAsleep)
				)
			)
		)
	)

	(method (newRoom)
		(gKqMusic1 fade:)
		(super newRoom: &rest)
	)

	(method (notify)
		(self setScript: sTapestryOut)
	)
)

(instance asleepSparkles of Prop
	(properties)
)

(instance waves of Prop
	(properties)
)

(instance castle of ExitFeature
	(properties
		nsLeft 126
		nsTop 14
		nsRight 277
		nsBottom 90
		sightAngle 370
		y 140
		exitDir 6
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)

	(method (onMe param1 &tmp temp0)
		(if (and (= temp0 (super onMe: param1)) (param1 type:))
			(= approachX (gEgo x:))
			(= approachY (gEgo y:))
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: sEnterCastle)
			)
		)
	)
)

(instance sAsleep of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(gEgo
					view: 6501
					loop: 0
					cycleSpeed: 10
					cel: 0
					posn: 41 115
					init:
				)
				(asleepSparkles
					view: 6502
					loop: 0
					cel: 0
					posn: 30 123
					cycleSpeed: 10
					init:
				)
				(gEgo setCycle: End self)
				(asleepSparkles setCycle: End self)
			)
			(2
				(gKqSound1 stop:)
			)
			(3
				(asleepSparkles dispose:)
				(gEgo normalize: setScaler: Scaler 47 32 113 78)
				(= cycles 1)
			)
			(4
				(client setScript: sEnterCastle)
			)
		)
	)
)

(instance sAwake of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(gKqSound1 number: 6453 play:)
				(gEgo
					view: 6501
					loop: 0
					cycleSpeed: 10
					cel: 0
					posn: 41 115
					init:
				)
				(waves
					view: 6503
					loop: 0
					cel: 0
					posn: 14 124
					cycleSpeed: 10
					init:
				)
				(gEgo setCycle: End self)
				(waves setCycle: End self)
			)
			(2)
			(3
				(waves dispose:)
				(gKqSound1 stop:)
				(gKqMusic1 number: 6500 loop: -1 play:)
				(castle init:)
				(gEgo
					normalize:
					setScaler: Scaler 47 32 113 78
					setMotion: MoveTo 73 100 self
				)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterCastle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 166 100 self)
			)
			(1
				(gEgo setMotion: MoveTo 180 81 self)
			)
			(2
				(gCurRoom newRoom: 6550)
			)
		)
	)
)

(instance sLeaveCastle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					init:
					posn: 175 89
					normalize:
					setScaler: Scaler 48 70 116 93
					setMotion: MoveTo 157 99 self
				)
			)
			(1
				(castle init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTapestryOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 816) ; WAVE
				(Load rsVIEW 6155)
				(gEgo normalize: setMotion: MoveTo 157 99 self)
			)
			(1
				(gEgo normalize: 5)
				(= cycles 1)
			)
			(2
				(gEgo view: 6155 setLoop: 0 cel: 0 setCycle: CT 40 1 self)
			)
			(3
				(gEgo setCycle: End self)
				(gKqSound1 number: 816 loop: 1 play:)
			)
			(4
				(gEgo dispose:)
				(= seconds 2)
			)
			(5
				(gGame handsOn:)
				(if (IsFlag 213)
					(gCurRoom newRoom: 6200)
				else
					(gCurRoom newRoom: 4200)
				)
			)
		)
	)
)

