;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10702)
(include sci.sh)
(use Main)
(use Trigger)
(use n1111)
(use n10700)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm10702 0
)

(local
	local0
	local1
	local2
)

(instance rm10702 of ScaryRoom
	(properties
		picture 10705
	)

	(method (init &tmp temp0)
		(= temp0 0)
		(proc1111_6)
		(gEgo init: normalize:)
		(if (not (IsFlag 339))
			(= temp0 sScene108)
		else
			(= picture 10700)
			(gEgo
				view: 10702
				heading: 360
				x: 131
				y: 129
				z: 0
				init:
				setScaler: Scaler 65 31 130 99
			)
			(shelves setHotspot: 4 1 3 2 21 init: approachVerbs: 0) ; Do, ???, Move, ???, Exit
			(southExit init:)
			(sink setHotspot: 4 1 3 2 21 init: approachVerbs: 0) ; Do, ???, Move, ???, Exit
			(don
				view: 1013
				x: 136
				y: 108
				z: 0
				setHotspot: 4 1 3 2 21 ; Do, ???, Move, ???, Exit
				approachVerbs: 0
				init:
				setScaler: Scaler 92 90 111 110
				setCycle: Fwd
			)
			(gGame handsOn:)
		)
		(if (== gPrevRoomNum 900)
			(= global115 1)
		)
		(= local2 0)
		(super init:)
		(= local2 1)
		(proc10700_0 -1)
		(if temp0
			(self setScript: temp0 0 0)
		)
	)

	(method (drawPic)
		(if (and (== gPrevRoomNum 900) (not local2))
			(return)
		else
			(super drawPic: &rest)
		)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 900)
			(if (and (IsFlag 339) (not (IsFlag 340)))
				(SetFlag 340)
				(SetFlag 344)
			)
			(SetFlag 339)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance don of Actor
	(properties
		approachX 209
		approachY 113
		z 1000
		view 1011
		signal 26657
		cycleSpeed 10
	)

	(method (init)
		(super init: &rest)
		(= cycleSpeed 10)
	)

	(method (doVerb theVerb)
		(if (not (IsFlag 340))
			(shelves dispose:)
			(gCurRoom setScript: sScene109)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southExit of Trigger
	(properties
		approachX 158
		approachY 189
		exitDir 3
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 118 125 108 141 135 142 135 135 160 135 159 143 224 137 218 125
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom setScript: sExitScr 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sink of Feature
	(properties
		sightAngle 360
		approachX 199
		approachY 108
		x 217
		y 78
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 203 76 203 85 235 104 235 72
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sScene110 0 self)
		(self dispose:)
	)
)

(instance shelves of Feature
	(properties
		sightAngle 360
		approachX 155
		approachY 106
		x 92
		y 26
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 105 10 146 33 146 53 128 53 71 33 63 34 57 49 18 38 23 1 82 1
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sScene109 0 0)
		(self dispose:)
	)
)

(instance sScene109 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(don dispose:)
					(proc1111_7 1091 -7 -2 gEgo 40 1)
					(proc10700_0 10715)
				)
				(1
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(if global115
			(proc1111_6)
			(= global115 0)
		)
		(proc1111_0 0)
		(= local1 1)
		(sCleanUp register: self)
		(= next sCleanUp)
		(super dispose: &rest)
	)
)

(instance sCleanUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc1111_6)
				(if (== register sScene110)
					(gEgo x: 197 y: 131)
				else
					(gEgo x: 131 y: 129)
				)
				(gEgo
					view: 10702
					heading: 360
					z: 0
					show:
					setScaler: Scaler 65 31 130 99
				)
				(don
					view: 1013
					x: 136
					y: 108
					z: 0
					setHotspot: 0
					approachVerbs: 0
					init:
					setScaler: Scaler 92 90 111 110
					setScript: sDonWorks
				)
				(if (not local1)
					(shelves setHotspot: 4 1 3 2 21 init: approachVerbs: 0) ; Do, ???, Move, ???, Exit
					(don
						view: 1013
						x: 136
						y: 108
						z: 0
						setHotspot: 4 1 3 2 21 ; Do, ???, Move, ???, Exit
						approachVerbs: 0
						init:
						setScaler: Scaler 92 90 111 110
						setScript: sDonWorks
					)
				)
				(if (not local0)
					(sink setHotspot: 4 1 3 2 21 init: approachVerbs: 0) ; Do, ???, Move, ???, Exit
				)
				(southExit init:)
				(if (not (gCast contains: gEgo))
					(gEgo init:)
				)
				(proc10700_0 10700)
				(UpdatePlane (gCast plane:))
				(= cycles 2)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitScr of Script
	(properties)

	(method (dispose)
		(gCurRoom newRoom: 13400)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo view: 10703 cel: 0 setCycle: End self)
				)
				(1
					(self dispose:)
				)
			)
		)
	)
)

(instance sScene108 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load 140 10610) ; WAVE
					(Lock 140 10610 1) ; WAVE
					(gEgo hide:)
					(proc1111_7 1080 144 31 gEgo 40)
				)
				(1
					(don
						view: 1085
						setLoop: 0 1
						cel: 0
						x: 141
						y: 96
						z: 0
						setCycle: 0
					)
					(if (not (gCast contains: don))
						(don init:)
					)
					(proc10700_0 10700)
					(gGDacSound number: 10610 setLoop: -1 play:)
					(= cycles 2)
				)
				(2
					(don setCycle: End self)
				)
				(3
					(gGDacSound stop:)
					(don dispose:)
					(proc1111_7 1084 -5 -20 gEgo -1 1)
					(proc10700_0 10705)
				)
				(4
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(Lock 140 10610 0) ; WAVE
		(proc1111_6)
		(gGDacSound stop:)
		(= global115 0)
		(proc1111_0 0)
		(if (not (gCast contains: gEgo))
			(gEgo init:)
		)
		(if (not (gCast contains: don))
			(don init:)
		)
		(don
			view: 1013
			x: 136
			y: 108
			z: 0
			setHotspot: 4 1 3 2 21 ; Do, ???, Move, ???, Exit
			approachVerbs: 0
			setScaler: Scaler 92 90 111 110
			setScript: sDonWorks
		)
		(gEgo
			view: 10702
			heading: 360
			x: 193
			y: 132
			z: 0
			setScaler: Scaler 65 31 130 99
			cel: (gEgo lastCel:)
			show:
		)
		(shelves setHotspot: 4 1 3 2 21 init: approachVerbs: 0) ; Do, ???, Move, ???, Exit
		(southExit init:)
		(sink setHotspot: 4 1 3 2 21 init: approachVerbs: 0) ; Do, ???, Move, ???, Exit
		(proc10700_0 10700)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sDonWorks of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(don cycleSpeed: (Random 4 8))
					(switch (Random 1 6)
						(1
							(don
								cel: (Random 0 (- (don lastCel:) 1))
								setCycle: End self
							)
						)
						(2
							(don
								cel: (Random 1 (don lastCel:))
								setCycle: Beg self
							)
						)
						(3
							(don cel: 0 setCycle: End self)
						)
						(4
							(don cel: (don lastCel:) setCycle: Beg self)
						)
						(5
							(don cel: 0 setCycle: CT 15 1 self)
						)
						(6
							(don cel: 15 setCycle: Beg self)
						)
					)
					(switch (Random 1 2)
						(1
							(proc1111_1 10611)
						)
						(2
							(proc1111_1 10612)
						)
					)
				)
				(1
					(if (not (Random 0 1))
						(self init:)
					else
						(= ticks (Random 30 90))
					)
				)
				(2
					(self init:)
				)
			)
		)
	)
)

(instance sScene110 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_13 register self)
				)
				(1
					(don dispose:)
					(proc1111_7 1101 -4 -12 gEgo 40 1)
					(proc10700_0 10715)
				)
				(2
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(if global115
			(proc1111_6)
			(= global115 0)
		)
		(proc1111_0 0)
		(= local0 1)
		(sCleanUp register: self)
		(= next sCleanUp)
		(super dispose: &rest)
	)
)

