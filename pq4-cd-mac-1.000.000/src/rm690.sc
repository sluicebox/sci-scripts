;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 690)
(include sci.sh)
(use Main)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm690 0
)

(local
	local0
)

(instance rm690 of Room
	(properties
		picture 690
	)

	(method (doRemap)
		(gGame doRemap: 2 243 85)
		(gGame doRemap: 2 244 75)
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 144 135 127 148 149 148 157 134 165 130 163 108 151 107 152 129
					yourself:
				)
		)
		(super init: &rest)
		(Load rsVIEW 0)
		(if (== gPrevRoomNum 775)
			(gGame intensity: 100)
		)
		(if (and (!= gPrevRoomNum 680) (== gDay 6))
			(gGlobalSound0 number: 150 loop: -1 play:)
			(gPqFlags set: 101)
			(= local0 1)
			(gGame handsOff:)
			(gurn
				view: 9690
				loop: 0
				cel: 0
				x: 131
				y: 147
				init:
				signal: (| (gurn signal:) $4000)
			)
			(self setScript: downLadderScript)
		else
			(gEgo
				posn: 152 114
				setHeading: 180
				setScaler: Scaler 107 63 147 106
				init:
				normalize: 0
			)
			(gGame handsOn:)
		)
		(ladder init: approachVerbs: 4) ; Do
		(redlight init:)
		(items1 init:)
		(items2 init:)
	)

	(method (doit)
		(super doit:)
		(cond
			((self script:) 0)
			((< (gEgo y:) 114)
				(gGlobalSound0 fade: 0 3 2 1)
				(gCurRoom newRoom: 675)
			)
		)
	)
)

(instance exitScr of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound0 fade: 0 3 2 1)
				(= ticks 240)
			)
			(1
				(gCurRoom newRoom: 675)
			)
		)
	)
)

(instance downLadderScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gurn setCycle: End self)
			)
			(2
				(gurn loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gEgo
					setScaler: Scaler 107 63 147 106
					setHeading: 0
					x: 133
					y: 147
					z: 0
					init:
					normalize: 0
				)
				(gurn dispose:)
				(= cycles 2)
			)
			(4
				(gEgo setMotion: PolyPath 159 132 self)
			)
			(5
				(gEgo setHeading: 0 self)
			)
			(6
				(= cycles 2)
			)
			(7
				(= local0 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance upLadderScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gurn
					loop: 1
					x: 131
					y: 147
					cel: 8
					init:
					signal: (| (gurn signal:) $4000)
					setCycle: Beg self
				)
				(gEgo y: 1000)
			)
			(4
				(gurn loop: 0)
				(gurn setCel: (gurn lastCel:) setCycle: Beg self)
			)
			(5
				(gMessager say: 1 0 1 0 self) ; "The trapdoor has locked, or been locked, behind you!"
			)
			(6
				(= cycles 2)
			)
			(7
				(self setScript: downLadderScript self)
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance ladder of Feature
	(properties
		noun 1
		nsLeft 164
		nsRight 182
		nsBottom 149
		sightAngle 40
		approachX 133
		approachY 147
		approachDist 0
		x 167
		y 148
	)

	(method (init)
		(self createPoly: 174 10 185 10 171 150 165 149 164 134)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: upLadderScript)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gurn of Actor
	(properties
		view 9690
	)
)

(instance redlight of Feature
	(properties
		noun 2
		nsLeft 153
		nsTop 32
		nsRight 170
		nsBottom 44
		sightAngle 40
		approachX 161
		approachY 38
		approachDist 0
		x 161
		y 38
	)
)

(instance items1 of Feature
	(properties
		noun 3
		nsLeft 108
		nsTop 34
		nsRight 143
		nsBottom 149
		sightAngle 40
		approachX 158
		approachY 129
		approachDist 0
		x 115
		y 128
	)
)

(instance items2 of Feature
	(properties
		noun 4
		nsLeft 185
		nsTop 37
		nsRight 209
		nsBottom 149
		sightAngle 40
		approachX 161
		approachY 129
		approachDist 0
		x 207
		y 128
	)
)

