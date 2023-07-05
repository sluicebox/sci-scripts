;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 575)
(include sci.sh)
(use Main)
(use GloryRm)
(use forest)
(use Polygon)

(public
	rm575 0
)

(instance rm575 of GloryRm
	(properties
		picture 410
		horizon 70
		north 574
		topX 180
	)

	(method (init)
		(if gDebugging
			(= gNight 1)
		)
		(if
			(or
				(and gNight (not (IsFlag 62)))
				(and (IsFlag 62) (not (IsFlag 57)))
				(and (== gCombatMonsterNum 850) (== gPrevRoomNum 810)) ; wraith, combat
			)
			(if (IsFlag 62)
				(SetFlag 66)
			)
			(if (IsFlag 57)
				(SetFlag 65)
			)
			(self setRegions: 53) ; barrows
		)
		(self setRegions: 50) ; forest
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 619 189 -300 189 -300 0 125 0 125 72 159 90 100 108 111 131 37 131 37 145 70 145 70 158 34 158 34 162 55 162 88 179 185 179 214 145 258 145 258 128 151 115 151 101 250 72 250 0 619 0
					yourself:
				)
		)
		(gCurRoom
			addPoly:
				((Polygon new:)
					init: 70 42 155 49 158 71 181 73 202 54 319 48 230 95 119 113 163 126 132 137 95 128
					yourself:
				)
				60
				((Polygon new:)
					init: 60 189 97 151 138 143 163 152 188 138 212 189
					yourself:
				)
				130
		)
		(atp2 init: setPri: 106)
		(atp3 init: setPri: 116)
		(atp4 init: setPri: 148)
		(atp5 init:)
		(atp7 init: setPri: 169)
		(if gNight
			(atp6 view: 418 loop: 1 cel: 2 x: 87 y: 189)
			(atp1 view: 418 loop: 1 cel: 1 x: 258 y: 189)
		)
		(atp6 init: setPri: 180)
		(atp1 init: setPri: 180)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)
)

(instance atp1 of ForestView
	(properties
		x 144
		y 146
		view 412
		cel 1
	)
)

(instance atp2 of ForestView
	(properties
		x 154
		y 56
		view 411
		cel 1
	)
)

(instance atp3 of ForestView
	(properties
		x 292
		y 110
		view 411
		cel 2
	)
)

(instance atp4 of ForestView
	(properties
		y 107
		view 413
	)
)

(instance atp5 of ForestView
	(properties
		x 94
		y 49
		view 413
		cel 1
	)
)

(instance atp6 of ForestView
	(properties
		x 3
		y 170
		view 412
	)
)

(instance atp7 of ForestView
	(properties
		x 210
		y 119
		view 414
		cel 6
	)
)

