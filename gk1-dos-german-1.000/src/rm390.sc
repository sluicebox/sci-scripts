;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 390)
(include sci.sh)
(use Main)
(use n013)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm390 0
)

(local
	local0 = 1
	local1
)

(instance rm390 of Room
	(properties
		noun 1
		picture 390
		style 14
		exitStyle 13
	)

	(method (init)
		(super init:)
		(Load rsMESSAGE 390)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 169 121 163 131 152 134 98 134 60 144 183 145 174 137 173 123
					yourself:
				)
		)
		(= local1 (gGame currentSpeed:))
		(gEgo
			view: 900
			setCel: 0
			setLoop: 0
			setCycle: StopWalk -1
			signal: (| (gEgo signal:) $1000)
			init:
			state: 2
			ignoreActors: 1
			posn: 185 128
		)
		(bedFrame init:)
		(coveredChair init:)
		(redCurtain init:)
		(bigHat init:)
		(racket init:)
		(boxOLights init:)
		(frames init:)
		(golfBag init:)
		(metalPot init:)
		(sewForm init:)
		(smallTable init:)
		(stairs init:)
		(bikeTire init:)
		(deerHorns init:)
		(bigWindow init:)
		(trunk init:)
		(boxOnChair init:)
		(clock init:)
		(if (IsFlag 242)
			(trunkLid init:)
		)
		(if (not (gEgo has: 6)) ; sketchBook
			(sketchBook init:)
		)
		(gWalkHandler add: stairs)
		(if (== gPrevRoomNum 391)
			(gEgo setScript: backFromClock)
		else
			(gEgo setSpeed: 6 setScript: enterTheRoom)
		)
		(SetFlag 204)
	)

	(method (dispose)
		(gWalkHandler delete: stairs)
		(DisposeScript 64939)
		(super dispose:)
	)
)

(instance leaveTheRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local1 (gGame currentSpeed:))
				(gEgo setSpeed: 6 setMotion: PolyPath 171 126 self)
			)
			(1
				(gEgo
					view: 393
					setCel: 0
					setLoop: 0
					posn: 187 125
					setCycle: End self
				)
			)
			(2
				(gEgo setSpeed: local1)
				(gCurRoom newRoom: 380)
				(self dispose:)
			)
		)
	)
)

(instance enterTheRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 390
					setCel: 0
					setLoop: 0
					posn: 187 122
					setCycle: End self
				)
			)
			(1
				(gEgo normalize: 1 900 setMotion: MoveTo 171 126 self)
			)
			(2
				(gEgo
					view: 390
					setCel: 1
					setLoop: 1
					posn: 165 126
					setCycle: End self
				)
			)
			(3
				(gEgo posn: 171 126 normalize: 5 900 setSpeed: local1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance clockPuzzle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 90 138 self)
			)
			(1
				(gEgo
					view: 3901
					setCel: 0
					setLoop: (if (IsFlag 218) 4 else 3)
					setCycle: End self
				)
			)
			(2
				(gCurRoom newRoom: 391)
			)
		)
	)
)

(instance rummage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 158 129 self)
			)
			(1
				(gEgo view: 3900 setCel: 0 setLoop: 0 setCycle: Osc 1 self)
			)
			(2
				(gMessager say: 31 12 0 0) ; "There's nothing I want in there."
				(gGame handsOn:)
				(gEgo normalize: 1 900)
				(self dispose:)
			)
		)
	)
)

(instance putClockOnTable of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 90 138 self)
			)
			(1
				(clock hide:)
				(gEgo view: 3901 setCel: 0 setLoop: 0 setCycle: CT 8 1 self)
			)
			(2
				(clock setCel: 1 posn: 109 115 show:)
				(gEgo view: 3901 setCel: 9 setLoop: 0 setCycle: End self)
				(SetFlag 218)
			)
			(3
				(gEgo normalize: 1 900)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance putClockOnTrunk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 242)
					(self setScript: closeTheTrunk self)
				else
					(self cue:)
				)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 90 138 self)
			)
			(2
				(gEgo
					view: 3901
					setCel: 11
					setLoop: 0
					setCycle: CT 9 -1 self
				)
			)
			(3
				(clock hide:)
				(gEgo view: 3901 setCel: 8 setLoop: 0 setCycle: Beg self)
			)
			(4
				(clock setCel: 0 posn: 74 111 show:)
				(ClearFlag 218)
				(gEgo normalize: 1 900)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openTheTrunk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 86 139 self)
			)
			(1
				(gEgo view: 3901 setCel: 0 setLoop: 1 setCycle: End self)
			)
			(2
				(trunkLid init:)
				(SetFlag 242)
				(gEgo normalize:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance closeTheTrunk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 86 139 self)
			)
			(1
				(trunkLid dispose:)
				(gEgo view: 3901 setCel: 5 setLoop: 1 setCycle: Beg self)
			)
			(2
				(ClearFlag 242)
				(gEgo normalize:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getTheSketchBook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 173 127 self)
			)
			(1
				(gEgo view: 394 setCel: 0 setLoop: 0 setCycle: CT 5 1 self)
			)
			(2
				(gMessager say: 18 12 0 0) ; "(ARCC)I think I'll take Daddy's sketchbook with me."
				(sketchBook dispose:)
				(gEgo getPoints: -999 1 get: 6 setCycle: End self) ; sketchBook
			)
			(3
				(gEgo normalize: 1 900)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance backFromClock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 3901
					setCel: 5
					setLoop: (if (IsFlag 218) 4 else 3)
					posn: 90 138
					setCycle: Beg self
				)
			)
			(1
				(gEgo normalize: 6 900)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance clock of Prop
	(properties
		noun 6
		sightAngle 30
		x 74
		y 111
		view 3901
		loop 2
	)

	(method (init)
		(super init:)
		(if (IsFlag 218)
			(self cel: 1 posn: 109 115)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (IsFlag 206)
					(gMessager say: noun theVerb 10 0) ; "Grandad's clock still isn't running, but Gabriel's learned a thing or two from it anyway."
				else
					(gMessager say: noun theVerb 9 0) ; "An elaborate mechanical clock--probably of German origin--is among the discarded treasures of the attic."
				)
			)
			(8 ; Operate
				(gEgo setScript: clockPuzzle)
			)
			(9 ; Move
				(if (IsFlag 218)
					(gEgo setScript: putClockOnTrunk)
				else
					(gEgo setScript: putClockOnTable)
				)
			)
			(12 ; Pickup
				(if (IsFlag 206)
					(gMessager say: noun theVerb 10 0) ; "Gabriel doesn't want to take the clock."
				else
					(gMessager say: noun theVerb 9 0) ; "Gabriel doesn't want to take the clock."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance trunkLid of View
	(properties
		noun 5
		x 68
		y 114
		view 3901
		loop 2
		cel 2
	)

	(method (doVerb theVerb)
		(trunk doVerb: theVerb)
	)
)

(instance sketchBook of View
	(properties
		noun 18
		x 149
		y 130
		view 394
		loop 1
	)

	(method (init)
		(super init:)
		(self ignoreActors: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(gEgo setScript: getTheSketchBook)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bedFrame of Feature
	(properties
		noun 12
		sightAngle 20
		x 41
		y 97
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 60 112 60 109 42 108 22 87 38 84 49 85 54 91 61 91 63 87 68 88 64 113
					yourself:
				)
		)
		(super init:)
	)
)

(instance coveredChair of Feature
	(properties
		noun 16
		sightAngle 20
		x 132
		y 113
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 117 113 124 99 134 99 153 116 153 129 118 130
					yourself:
				)
		)
		(super init:)
	)
)

(instance boxOnChair of Feature
	(properties
		noun 31
		nsLeft 124
		nsTop 104
		nsRight 142
		nsBottom 118
		sightAngle 20
		x 132
		y 114
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(gEgo setScript: rummage)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance redCurtain of Feature
	(properties
		noun 4
		sightAngle 20
		x 29
		y 190
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 60 22 68 40 61 46 63 55 50 58 49 78 43 82 39 78 40 67 39 63 27 65 19 71 20 82 15 82 1 69 0 22
					yourself:
				)
		)
		(super init:)
	)
)

(instance bigHat of Feature
	(properties
		noun 8
		sightAngle 20
		x 262
		y 190
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 229 114 250 89 268 86 293 91 306 100 309 113 293 113 276 117 255 131 246 145 224 145 213 136 213 132 208 125 208 116
					yourself:
				)
		)
		(super init:)
	)
)

(instance racket of Feature
	(properties
		noun 7
		sightAngle 20
		x 298
		y 191
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 247 145 255 130 269 120 295 113 308 113 319 117 319 145
					yourself:
				)
		)
		(super init:)
	)
)

(instance boxOLights of Feature
	(properties
		noun 9
		sightAngle 20
		x 306
		y 189
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 264 71 257 70 262 62 258 55 261 52 298 23 319 22 319 118 308 113 309 105 300 94 287 88 265 86
					yourself:
				)
		)
		(super init:)
	)
)

(instance frames of Feature
	(properties
		noun 26
		sightAngle 20
		x 224
		y 69
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 223 51 225 61 237 70 233 85 215 83 217 75 210 70 219 51
					yourself:
				)
		)
		(super init:)
	)
)

(instance golfBag of Feature
	(properties
		noun 3
		sightAngle 20
		x 181
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 178 84 190 90 178 120 166 116
					yourself:
				)
		)
		(super init:)
	)
)

(instance metalPot of Feature
	(properties
		noun 17
		sightAngle 20
		x 191
		y 131
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 178 127 186 123 202 125 203 133 187 137 178 133
					yourself:
				)
		)
		(super init:)
	)
)

(instance sewForm of Feature
	(properties
		noun 14
		sightAngle 20
		x 157
		y 105
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 153 94 165 94 162 123 156 123
					yourself:
				)
		)
		(super init:)
	)
)

(instance smallTable of Feature
	(properties
		noun 13
		sightAngle 20
		x 106
		y 123
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 114 116 116 127 109 132 93 127 102 116
					yourself:
				)
		)
		(super init:)
	)
)

(instance stairs of Feature
	(properties
		noun 2
		nsLeft 188
		nsTop 106
		nsRight 231
		nsBottom 128
		sightAngle 20
		x 203
		y 117
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(gEgo setScript: leaveTheRoom)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bikeTire of Feature
	(properties
		noun 15
		sightAngle 20
		x 169
		y 74
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 156 72 161 66 172 66 178 72 177 79 171 83 162 82 156 78
					yourself:
				)
		)
		(super init:)
	)
)

(instance deerHorns of Feature
	(properties
		noun 10
		sightAngle 20
		x 193
		y 68
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 180 64 184 54 188 66 198 64 197 56 200 50 205 64 197 72 189 72
					yourself:
				)
		)
		(super init:)
	)
)

(instance bigWindow of Feature
	(properties
		noun 11
		sightAngle 20
		x 89
		y 56
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 42 71 97 42 122 52 76 76
					yourself:
				)
		)
		(super init:)
	)
)

(instance trunk of Feature
	(properties
		noun 5
		sightAngle 30
		x 71
		y 131
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 50 117 80 111 87 112 92 117 93 132 70 137
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (IsFlag 242)
					(if local0
						(gMessager say: noun theVerb 3 0) ; "The trunk contains...."
						(= local0 0)
					else
						(gMessager say: noun theVerb 6 0) ; "The trunk contains lederhosen, hiking boots, German books, and a bundle of Grandad and Gran's love letters."
					)
				else
					(gMessager say: noun theVerb 5 0) ; "The old trunk looks like it's gone to hell and back."
				)
			)
			(6 ; Open
				(cond
					((IsFlag 242)
						(gEgo setScript: closeTheTrunk)
					)
					((IsFlag 218)
						(gEgo setScript: openTheTrunk)
					)
					(else
						(gMessager say: noun theVerb 1 0) ; "The lid is blocked by the clock."
					)
				)
			)
			(12 ; Pickup
				(if (IsFlag 242)
					(if local0
						(gMessager say: noun theVerb 8 0) ; "(ARCC)I don't think there's anything in that trunk that would interest anybody but my Gran."
					else
						(gMessager say: noun theVerb 7 0) ; "(ARCC)I don't think there's anything in that trunk that would interest anybody but my Gran."
					)
				else
					(gMessager say: noun theVerb 5 0) ; "It looks pretty heavy."
				)
			)
			(else
				(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
					(if (IsFlag 242)
						(gMessager say: noun 0 4 0) ; "There's no reason to put that in the trunk."
					else
						(gMessager say: noun 0 5 0) ; "Using that on the trunk won't help."
					)
				else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

