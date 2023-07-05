;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 415)
(include sci.sh)
(use Main)
(use Inset)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm415 0
)

(instance rm415 of Room
	(properties
		noun 1
		picture 415
	)

	(method (init)
		(proc0_4 1)
		(gGame handsOff:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 7 148 108 148 108 139 207 133 195 123 47 145 29 135 29 119 0 100 0 134 8 134
					yourself:
				)
		)
		(super init: &rest)
		(if (gPqFlags test: 95)
			(gPqFlags clear: 95)
			(recept
				setScaler: Scaler 94 94 138 108
				signal: (| (recept signal:) $4000)
				init:
			)
			(self setScript: enterReceptScr)
		else
			(self setScript: enterScr)
		)
		(gEgo
			heading: 117
			normalize: 9120
			posn: 0 127 0
			setScaler: Scaler 94 82 146 131
			init:
		)
		(artwork init:)
		(leftFile init:)
		(books init:)
		(board init:)
		(desk init: approachVerbs: 1) ; Look
		(computer init:)
		(chair init:)
		(bookShelf init:)
		(otherRoom init:)
		(hall init:)
		(rightFile init:)
		(clock init:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			((and (< (gEgo y:) 128) (< (gEgo x:) 100))
				(gCurRoom newRoom: 410)
			)
		)
	)
)

(instance recept of Actor
	(properties
		x 12
		y 119
		view 418
		loop 2
	)
)

(instance enterReceptScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gEgo setMotion: PolyPath 28 147 self)
			)
			(2
				(gMessager say: 16 0 0 0 self) ; "I'll be at my desk, Detective, if you need anything."
			)
			(3
				(recept cel: 1)
				(= cycles (recept cycleSpeed:))
			)
			(4
				(recept cel: 2)
				(= cycles (recept cycleSpeed:))
			)
			(5
				(recept
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo -15 (recept y:) self
				)
			)
			(6
				(gGame handsOn:)
				(recept dispose:)
				(self dispose:)
			)
		)
	)
)

(instance enterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gEgo setMotion: PolyPath 28 147 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance artwork of Feature
	(properties
		noun 2
		nsLeft 60
		nsTop 33
		nsRight 92
		nsBottom 68
		x 76
		y 68
	)
)

(instance leftFile of Feature
	(properties
		noun 4
		x 88
		y 90
	)

	(method (init)
		(self createPoly: 53 94 97 89 115 93 115 132 61 139 53 133)
		(super init: &rest)
	)
)

(instance books of Feature
	(properties
		noun 9
		x 88
		y 91
	)

	(method (init)
		(self createPoly: 72 80 90 76 102 79 102 93 77 94 71 92)
		(super init: &rest)
	)
)

(instance board of Feature
	(properties
		noun 8
		x 254
		y 75
	)

	(method (init)
		(self createPoly: 225 31 288 26 288 85 226 80)
		(super init: &rest)
	)
)

(instance desk of Feature
	(properties
		noun 7
		approachX 194
		approachY 131
		x 268
		y 204
	)

	(method (init)
		(self
			createPoly:
				302
				152
				147
				153
				115
				140
				114
				106
				145
				100
				185
				107
				261
				97
				303
				106
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gCurRoom setInset: deskInset)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance computer of Feature
	(properties
		noun 10
		x 156
		y 205
	)

	(method (init)
		(self createPoly: 177 77 183 100 157 106 143 106 135 91 157 76)
		(super init: &rest)
	)
)

(instance chair of Feature
	(properties
		noun 11
		x 193
		y 104
	)

	(method (init)
		(self createPoly: 182 107 181 104 182 96 193 93 206 95 208 103)
		(super init: &rest)
	)
)

(instance bookShelf of Feature
	(properties
		noun 12
		x 136
		y 86
	)

	(method (init)
		(self
			createPoly:
				103
				50
				170
				50
				171
				77
				156
				76
				135
				91
				139
				101
				115
				106
				115
				93
				102
				89
		)
		(super init: &rest)
	)
)

(instance otherRoom of Feature
	(properties
		noun 13
		nsLeft 18
		nsTop 35
		nsRight 46
		nsBottom 106
		x 32
		y 106
	)
)

(instance hall of Feature
	(properties
		noun 14
		x 21
		y 105
	)

	(method (init)
		(self createPoly: 0 22 46 23 46 133 0 140)
		(super init: &rest)
	)
)

(instance rightFile of Feature
	(properties
		noun 4
		nsLeft 303
		nsTop 78
		nsRight 319
		nsBottom 154
		x 311
		y 154
	)
)

(instance clock of Feature
	(properties
		noun 15
		x 287
		y 11
	)

	(method (init)
		(self createPoly: 291 0 301 11 287 25 275 11 286 0)
		(super init: &rest)
	)
)

(instance deskInset of Inset
	(properties
		picture 417
		y 0
		disposeNotOnMe 1
		modNum 417
		noun 1
	)

	(method (init)
		(gGame fade: 100 0 10)
		(gTheIconBar disable: 3 7 6 show: 0)
		(gGlobalSound1 fade: 0 10 10 0)
		(super init: &rest)
		(gGlobalSound0 number: 755 loop: -1 play:)
		(if (not (gEgo has: 25)) ; tape
			(theTape init:)
		)
		(if (not (gEgo has: 22)) ; folders
			(folder init:)
		)
		(insetPhone init:)
		(insetBooks init:)
		(insetPlant init:)
		(insetCalendar init:)
		(insetPostit init:)
		(insetStapler init:)
		(insetScotchTape init:)
		(insetMessages init:)
		(insetBlotter init:)
		(insetComputer init:)
		(insetKeyboard init:)
		(insetDesk init:)
		(FrameOut)
		(gGame fade: 0 100 10)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (onMe param1)
		(return (and (<= 109 (param1 x:) 211) (<= 0 (param1 y:) 145)))
	)

	(method (dispose)
		(gGame fade: 100 0 10)
		(gTheIconBar enable: 0 3 7)
		(gGlobalSound0 fade: 0 10 10 1)
		(super dispose:)
		(FrameOut)
		(gGame fade: 0 100 10)
		(gGlobalSound1 fade: 100 10 10 0)
	)
)

(instance theTape of Prop
	(properties
		noun 15
		modNum 417
		x 213
		y 74
		view 417
		loop 1
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gEgo get: 25) ; tape
			(gGame points: 2)
			(self dispose:)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance folder of Prop
	(properties
		noun 14
		modNum 417
		x 172
		y 105
		view 417
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame points: 2)
			(gEgo get: 22) ; folders
			(self dispose:)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance insetPhone of Feature
	(properties
		noun 2
		modNum 417
		y 90
	)

	(method (init)
		(self createPoly: 36 69 40 67 46 76 42 81 50 91 36 101)
		(super init: &rest)
	)
)

(instance insetBooks of Feature
	(properties
		noun 17
		modNum 417
		y 77
	)

	(method (init)
		(self
			createPoly:
				36
				13
				43
				13
				47
				23
				61
				19
				61
				12
				71
				10
				82
				26
				81
				35
				87
				42
				88
				47
				93
				52
				94
				76
				49
				85
				36
				38
		)
		(super init: &rest)
	)
)

(instance insetPlant of Feature
	(properties
		noun 4
		modNum 417
		y 58
	)

	(method (init)
		(self createPoly: 84 36 93 26 100 25 113 35 108 58 94 61)
		(super init: &rest)
	)
)

(instance insetCalendar of Feature
	(properties
		noun 5
		modNum 417
		y 59
	)

	(method (init)
		(self createPoly: 115 47 149 41 160 53 160 58 124 65 115 54)
		(super init: &rest)
	)
)

(instance insetPostit of Feature
	(properties
		noun 6
		modNum 417
		y 53
	)

	(method (init)
		(self createPoly: 163 46 179 43 185 50 184 53 169 56 163 50)
		(super init: &rest)
	)
)

(instance insetStapler of Feature
	(properties
		noun 7
		modNum 417
		y 54
	)

	(method (init)
		(self createPoly: 214 39 218 39 219 44 217 58 209 57 209 46)
		(super init: &rest)
	)
)

(instance insetScotchTape of Feature
	(properties
		noun 8
		modNum 417
		y 54
	)

	(method (init)
		(self createPoly: 229 38 237 38 236 57 227 57 226 43)
		(super init: &rest)
	)
)

(instance insetMessages of Feature
	(properties
		noun 9
		modNum 417
		y 126
	)

	(method (init)
		(self createPoly: 51 92 80 88 92 125 54 133 47 130 43 97)
		(super init: &rest)
	)
)

(instance insetBlotter of Feature
	(properties
		noun 10
		modNum 417
		y 104
	)

	(method (init)
		(self createPoly: 77 82 182 60 228 102 99 135)
		(super init: &rest)
	)
)

(instance insetComputer of Feature
	(properties
		noun 16
		modNum 417
		y 93
	)

	(method (init)
		(self createPoly: 285 18 285 111 271 93 245 78 267 16 282 16)
		(super init: &rest)
	)
)

(instance insetKeyboard of Feature
	(properties
		noun 12
		modNum 417
		y 142
	)

	(method (init)
		(self createPoly: 285 130 285 148 260 148 233 121 258 109)
		(super init: &rest)
	)
)

(instance insetDesk of Feature
	(properties
		noun 18
		modNum 417
		y 31
	)

	(method (init)
		(self createPoly: 36 63 225 27 286 67 284 148 35 148)
		(super init: &rest)
	)
)

