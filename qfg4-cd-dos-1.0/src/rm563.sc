;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 563)
(include sci.sh)
(use Main)
(use GloryRm)
(use forest)
(use PChase)
(use Polygon)
(use Motion)

(public
	rm563 0
)

(instance rm563 of GloryRm
	(properties
		picture 420
		style 1024
		horizon 70
		north 290
		south 564
		west 557
		topX 145
		leftY 138
		bottomX 224
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 128 0 128 84 153 106 105 98 83 107 100 115 23 131 0 131
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 46 145 66 159 117 159 135 167 158 167 210 189 0 189 0 142
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 267 95 228 95 207 102 167 102 144 83 162 72 162 0 619 0 619 189 237 189 258 178 266 156 224 156 224 147 280 114 267 110
					yourself:
				)
		)
		(self setRegions: 50) ; forest
		(if (IsFlag 35)
			(self setRegions: 51) ; theHunt
			(= south 0)
			((ScriptID 51 1) ; nec1
				init:
				posn: 220 160
				setHeading: 315
				setMotion: PChase gEgo 25
			)
		)
		(if (and gNight (== gPrevRoomNum 290) (IsFlag 164))
			(self setRegions: 51) ; theHunt
			(ClearFlag 164)
			(gGlory handsOff:)
			((ScriptID 51 1) posn: -30 100 init: setMotion: PChase gEgo 25) ; nec1
			((ScriptID 51 2) posn: 160 250 init: setMotion: PChase gEgo 25) ; nec2
			(= west (= south 0))
		)
		(super init: &rest)
		(gCurRoom
			addPoly:
				((Polygon new:)
					init: 31 155 145 124 181 124 220 111 241 109 319 149 319 189 25 189
					yourself:
				)
				60
				((Polygon new:) init: 152 84 187 102 41 104 31 88 yourself:)
				130
		)
		(atp1 init:)
		(atp2 init:)
		(atp3 init: setPri: 42)
		(atp4 init:)
		(if gNight
			(atp5 view: 428 loop: 0 cel: 2 x: 171 y: 189 setPri: 189)
			(if (== gPrevRoomNum 564)
				(gEgo posn: 221 210)
			)
		else
			(atp5 setPri: 85)
		)
		(atp5 init:)
		(bridge init: setPri: 53)
		(town init:)
		(stream1 setPri: 42 setCycle: Fwd init:)
		(stream2 setPri: 42 setCycle: Fwd init:)
		(stream3 setPri: 42 setCycle: Fwd init:)
		(streamMat init:)
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(IsFlag 35)
				(not (gCast contains: (ScriptID 51 2))) ; nec2
				(!= (gCurRoom script:) (ScriptID 50 1)) ; enterRoomScr
				(< (gEgo x:) 7)
			)
			((ScriptID 51 2) ; nec2
				posn: (- (- (gEgo x:) 25) 15) (gEgo y:)
				init:
				setMotion: PChase gEgo 25
			)
		)
		(if
			(and
				(IsFlag 35)
				(> (gEgo y:) 160)
				(not ((ScriptID 51 1) mover:)) ; nec1
			)
			((ScriptID 51 1) setMotion: PChase gEgo 25) ; nec1
		)
	)

	(method (notify param1)
		(if (and (== param1 1) (!= (gCurRoom script:) (ScriptID 51 4))) ; sBlackOut
			(if (not (gCast contains: (ScriptID 51 2))) ; nec2
				((ScriptID 51 2) ; nec2
					posn: -40 100
					init:
					setMotion: PChase gEgo 25
				)
			)
			(gCurRoom setScript: (ScriptID 51 4)) ; sBlackOut
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; glideSpell
				(if (streamMat onMe: (gEgo x:) (gEgo y:))
					(gMessager say: 12 6 10 0 0 50) ; "The water is too shallow for this spell to work."
				else
					(gMessager say: 30 0 18 0 0 50) ; "The Glide spell only works on liquid; you can't cast it here."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (IsFlag 35) (== newRoomNumber 290))
			(ClearFlag 35)
			(SetFlag 80)
			(SetFlag 164)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(streamMat dispose:)
		(super dispose:)
	)
)

(instance atp1 of ForestView
	(properties
		x 317
		y 164
		view 424
		loop 3
		cel 2
	)
)

(instance atp2 of ForestView
	(properties
		x 316
		y 50
		view 423
		loop 1
	)
)

(instance atp3 of ForestView
	(properties
		x 197
		y 132
		view 424
		loop 1
		cel 3
	)
)

(instance atp4 of ForestView
	(properties
		x 280
		y 14
		view 424
		loop 3
		cel 4
	)
)

(instance atp5 of ForestView
	(properties
		x 78
		y 5
		view 424
		loop 3
	)
)

(instance bridge of ForestView
	(properties
		x 13
		y 198
		z 50
		view 424
		loop 1
		cel 4
	)
)

(instance town of ForestView
	(properties
		x 173
		y 63
		view 421
		loop 2
	)
)

(instance stream1 of ForestView
	(properties
		x 187
		y 102
		view 420
		loop 5
		signal 16385
		detailLevel 2
	)
)

(instance stream2 of ForestView
	(properties
		x 30
		y 126
		view 420
		loop 7
		signal 16385
		detailLevel 2
	)
)

(instance stream3 of ForestView
	(properties
		x 56
		y 188
		view 424
		loop 5
		signal 16385
		detailLevel 2
	)
)

(instance streamMat of Polygon
	(properties)

	(method (init)
		(super init: 171 101 141 101 139 97 149 98 151 94 164 95)
	)
)

