;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 457)
(include sci.sh)
(use Main)
(use n013)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm457 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm457 of Room
	(properties
		noun 1
		picture 99
		style 14
		exitStyle 13
	)

	(method (init)
		(= local1 (ScriptID 0 1)) ; globeCursor
		(local1 view: 968)
		(super init:)
		(gGkMusic1 fade: (gGkMusic1 musicVolume:) 25 10 0)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 186 127 176 117 138 117 128 127
					yourself:
				)
		)
		(self setScript: sGabeEnters)
		(gWalkHandler add: self gEgo)
		(readyRoom init:)
		(box init:)
		(shelves init:)
		(bench init:)
		(candles init:)
		(christPic init:)
		(mirror init:)
		(cross init:)
		(books init:)
		(table init:)
		(wallCandles init:)
		(vase init:)
		(robes init:)
		(if (not (IsFlag 284))
			(shirt init:)
		)
	)

	(method (dispose)
		(GK setCursor: local2)
		(gWalkHandler delete: self gEgo)
		(gGkMusic1 fade:)
		(super dispose:)
	)

	(method (doVerb)
		(if (readyRoom onMe: gMouseX (- gMouseY 10))
			(return 0)
		else
			(gCurRoom setScript: sExitRoom)
			(return 1)
		)
	)
)

(instance sGabeEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					normalize: 3
					posn: 160 129
					init:
					setMotion: MoveTo 160 119 self
				)
			)
			(1
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
				(gEgo setMotion: MoveTo 160 127 self)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 450)
			)
		)
	)
)

(instance sLookInMirror of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 185 119 self)
			)
			(1
				(Face gEgo mirror self)
			)
			(2
				(gEgo
					view: 458
					setCel: 0
					setLoop: 2
					setSpeed: 12
					setCycle: End self
				)
			)
			(3
				(gEgo normalize: 0)
				(= cycles 1)
			)
			(4
				(if (not local0)
					(= local0 1)
					(gMessager say: 2 7 0 0 self) ; "(VAINLY--LOOKING IN MIRROR)I love my hair."
				else
					(= cycles 1)
				)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetShirt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 128 119 self)
			)
			(1
				(Face gEgo shirt self)
			)
			(2
				(if (gEgo has: 39) ; collar
					(gEgo put: 39 get: 48) ; collar, disguise
				else
					(gEgo get: 47) ; shirt
				)
				(shirt dispose:)
				(gEgo
					view: 458
					setCel: 0
					setLoop: 1
					setSpeed: 12
					setCycle: End self
				)
			)
			(3
				(gEgo getPoints: -999 1)
				(gEgo normalize: 3)
				(= cycles 1)
			)
			(4
				(gMessager say: 13 12 3 0 self) ; "(TO HIMSELF. STEALING BLACK SHIRT)I can't resist black."
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetCollar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 154 119 self)
			)
			(1
				(Face gEgo box self)
			)
			(2
				(if (gEgo has: 47) ; shirt
					(gEgo put: 47 get: 48) ; shirt, disguise
				else
					(gEgo get: 39) ; collar
				)
				(gEgo
					view: 458
					setCel: 0
					setLoop: 0
					setSpeed: 12
					setCycle: End self
				)
			)
			(3
				(gEgo getPoints: -999 1)
				(gEgo normalize: 3)
				(= cycles 1)
			)
			(4
				(gMessager say: 12 12 1 0 self) ; "(TO HIMSELF)You never know when a priest's collar will come in handy."
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance readyRoom of View
	(properties
		noun 1
		x 71
		y 35
		view 457
		signal 16384
	)

	(method (doit)
		(FrameOut)
		(super doit:)
		(if (gUser canControl:)
			(if (self onMe: gMouseX (- gMouseY 10))
				(if local3
					(= local3 0)
					(gGame setCursor: local2 1)
				)
			else
				(if (!= gTheCursor local1)
					(= local2 gTheCursor)
					(gGame setCursor: local1 1)
				)
				(= local3 1)
			)
		)
	)
)

(instance bench of Feature
	(properties
		noun 4
		nsTop 62
		nsRight 9
		nsBottom 88
		sightAngle 20
		approachX 248
		approachY 124
		x 100
		y 101
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 80 90 106 88 109 95 107 100 122 104 123 116 104 128 84 126
					yourself:
				)
		)
		(super init:)
	)
)

(instance candles of Feature
	(properties
		noun 5
		nsTop 62
		nsRight 9
		nsBottom 88
		sightAngle 20
		approachX 248
		approachY 124
		x 79
		y 119
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 70 74 74 76 75 95 81 97 74 103 75 113 79 115 78 126 84 124 83 112 77 110 82 104 82 91 89 94 88 108 91 110 88 113 88 127 95 126 94 109 105 110 105 130 70 128
					yourself:
				)
		)
		(super init:)
	)
)

(instance christPic of Feature
	(properties
		noun 7
		nsTop 62
		nsRight 9
		nsBottom 88
		sightAngle 20
		approachX 248
		approachY 124
		x 93
		y 119
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 106 52 103 86 86 85 88 47
					yourself:
				)
		)
		(super init:)
	)
)

(instance mirror of Feature
	(properties
		noun 2
		nsTop 62
		nsRight 9
		nsBottom 88
		sightAngle 20
		approachX 248
		approachY 124
		x 221
		y 119
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 233 38 233 99 214 95 213 54
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(gCurRoom setScript: sLookInMirror)
			)
			(8 ; Operate
				(gCurRoom setScript: sLookInMirror)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cross of Feature
	(properties
		noun 8
		nsTop 62
		nsRight 9
		nsBottom 88
		sightAngle 20
		approachX 248
		approachY 124
		x 111
		y 115
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 113 78 109 78 107 68 109 65 111 64 114 69
					yourself:
				)
		)
		(super init:)
	)
)

(instance books of Feature
	(properties
		noun 6
		nsTop 62
		nsRight 9
		nsBottom 88
		sightAngle 20
		approachX 248
		approachY 124
		x 224
		y 126
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 213 96 233 99 239 111 224 111 212 105
					yourself:
				)
		)
		(super init:)
	)
)

(instance table of Feature
	(properties
		noun 3
		nsTop 62
		nsRight 9
		nsBottom 88
		sightAngle 20
		approachX 248
		approachY 124
		x 213
		y 109
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 211 97 247 115 248 128 239 128 238 121 226 121 224 127 211 127 211 124 206 120 196 108 195 121 189 100 188 96
					yourself:
				)
		)
		(super init:)
	)
)

(instance wallCandles of Feature
	(properties
		noun 5
		nsTop 62
		nsRight 9
		nsBottom 88
		sightAngle 20
		approachX 248
		approachY 124
		x 185
		y 71
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 180 79 177 73 178 64 183 59 188 65 190 72 184 80
					yourself:
				)
		)
		(super init:)
	)
)

(instance vase of Feature
	(properties
		noun 9
		nsTop 62
		nsRight 9
		nsBottom 88
		sightAngle 20
		approachX 248
		approachY 124
		x 200
		y 122
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 197 99 198 95 195 92 195 87 198 83 197 80 207 80 206 83 209 87 207 94 210 98 203 100
					yourself:
				)
		)
		(super init:)
	)
)

(instance shelves of Feature
	(properties
		noun 11
		nsLeft 123
		nsTop 58
		nsRight 171
		nsBottom 114
		sightAngle 40
		approachX 147
		approachY 86
		x 147
		y 83
	)
)

(instance box of Feature
	(properties
		noun 12
		nsLeft 124
		nsTop 91
		nsRight 140
		nsBottom 101
		sightAngle 40
		approachX 132
		approachY 96
		x 132
		y 115
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(if (IsFlag 283)
					(gMessager say: noun theVerb 2) ; "One collar is plenty."
				else
					(SetFlag 283)
					(gCurRoom setScript: sGetCollar)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shirt of View
	(properties
		noun 13
		x 149
		y 85
		view 457
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(if (IsFlag 284)
					(gMessager say: noun theVerb 4) ; "Gabriel doesn't need another shirt."
				else
					(SetFlag 284)
					(gCurRoom setScript: sGetShirt)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance robes of Feature
	(properties
		noun 10
		nsLeft 148
		nsTop 69
		nsRight 171
		nsBottom 114
		sightAngle 40
		approachX 156
		approachY 91
		x 156
		y 84
	)
)

