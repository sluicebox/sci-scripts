;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 760)
(include sci.sh)
(use Main)
(use SQRoom)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm760 0
)

(instance rm760 of SQRoom
	(properties
		noun 1
		picture 760
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 23 138 302 138 302 128 234 122 222 133 193 133 65 121
					yourself:
				)
		)
		(gEgo init: normalize: posn: 68 124 loop: 4 hide:)
		(if (!= (gGSound1 number:) 760)
			(gGSound1 number: 760 setLoop: -1 play:)
		)
		(super init:)
		(if (IsFlag 201)
			(pile init: approachVerbs: 4 1) ; Do, Look
			(hole init: approachVerbs: 4 1) ; Do, Look
		else
			(blockage init:)
			(hole init:)
		)
		(elevator init: hide: approachVerbs: 4) ; Do
		(spark1 init: hide: setScript: (sFlashProps new:))
		(spark2 init: hide: setScript: (sFlashProps new:))
		(spark3 init: hide: setScript: (sFlashProps new:))
		(gCurRoom setScript: sEnterRoom)
	)

	(method (dispose)
		(if (!= gNewRoomNum 750)
			(gGSound1 fade:)
		)
		(super dispose:)
	)
)

(instance sBigFall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 762
					loop: 0
					cel: 0
					setSpeed: 8
					setCycle: End self
				)
			)
			(2
				(gEgo hide:)
				(gCurRoom newRoom: 770)
				(self dispose:)
			)
		)
	)
)

(instance sFlashProps of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (proc0_8 30 500))
			)
			(1
				(client show: setCycle: End self)
			)
			(2
				(client cel: 0 hide:)
				(self changeState: 0)
			)
		)
	)
)

(instance sEnterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(elevator show: setCycle: End self)
			)
			(2
				(gEgo show:)
				(elevator loop: 1 cel: 1 show:)
				(gGSound2 stop:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 135 self)
			)
			(1
				(gEgo hide:)
				(gGSound2 number: 493 play: setVol: 100)
				(elevator
					setLoop: 0 1
					setCel: 12
					setCycle: Beg self
					setStep: 3 10
				)
			)
			(2
				(elevator
					setMotion: MoveTo (elevator x:) (- (elevator y:) 30) self
				)
			)
			(3
				(gCurRoom newRoom: 750)
				(self dispose:)
			)
		)
	)
)

(instance spark1 of Prop
	(properties
		noun 1
		x 224
		y 50
		view 760
		loop 1
		cel 2
		signal 20513
	)
)

(instance spark2 of Prop
	(properties
		noun 1
		x 147
		y 36
		view 760
		loop 2
		cel 1
		signal 20513
	)
)

(instance spark3 of Prop
	(properties
		noun 1
		x 261
		y 90
		view 760
		loop 3
		cel 3
		signal 20513
	)
)

(instance elevator of Actor
	(properties
		noun 4
		approachX 68
		approachY 124
		x 29
		y 57
		priority 120
		fixPriority 1
		view 761
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(self setScript: sExitRoom)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance blockage of View
	(properties
		noun 2
		approachX 234
		approachY 125
		x 118
		y 72
		view 760
		signal 20513
	)
)

(instance pile of Feature
	(properties
		noun 2
		sightAngle 40
		approachX 234
		approachY 125
		x 166
		y 72
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 103 115 105 112 109 113 115 104 120 106 119 100 125 98 129 101 128 96 129 90 137 89 117 79 120 76 140 85 150 83 154 78 154 68 169 67 168 63 159 60 173 59 177 62 172 63 172 67 179 67 182 76 188 75 197 79 233 120 228 126 225 128 213 124 212 126 206 127 204 130 191 132 188 130 190 126 183 127 179 125 176 123 168 126 157 125 150 127 139 125 131 123 118 124 114 121 107 120 100 118
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sBigFall)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hole of Feature
	(properties
		noun 3
		sightAngle 40
		approachX 234
		approachY 125
		x 150
		y 70
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 194 84 206 71 206 66 221 59 230 59 237 69 245 96 226 110 232 115 226 115 209 93
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 201)
					(gCurRoom setScript: sBigFall)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

