;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use Interface)
(use Osc)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	povGladeArchery 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7 = 1
	local8 = 1
	local9 = 1
	local10 = 1
	local11
	local12
	local13
	local14
	[local15 6]
	[local21 6]
	[local27 6]
	[local33 6]
	local39
	local40
	local41
	local42
	local43
	local44
	local45
	local46
	local47
	[local48 3] = [160 187 218]
	[local51 3] = [117 100 107]
	[local54 3] = [65 151 258]
	[local57 3] = [40 60 47]
	[local60 3] = [0 6 4]
	[local63 3] = [3 5 4]
	[local66 3] = [63 150 256]
	local69
	local70
)

(procedure (localproc_0 &tmp temp0)
	(switch local70
		(0
			(for ((= temp0 0)) (< temp0 local12) ((++ temp0))
				([local21 temp0] sel_102:)
			)
		)
		(1
			(for ((= temp0 0)) (< temp0 local13) ((++ temp0))
				([local27 temp0] sel_102:)
			)
		)
		(2
			(for ((= temp0 0)) (< temp0 local14) ((++ temp0))
				([local33 temp0] sel_102:)
			)
		)
	)
)

(procedure (localproc_1)
	(while (>= (-- local11) 0)
		([local15 local11] sel_111:)
	)
	(= local11 0)
	(while (>= (-- local12) 0)
		([local21 local12] sel_111:)
	)
	(= local12 0)
	(while (>= (-- local13) 0)
		([local27 local13] sel_111:)
	)
	(= local13 0)
	(while (>= (-- local14) 0)
		([local33 local14] sel_111:)
	)
	(= local14 0)
)

(procedure (localproc_2)
	(if (== global125 2)
		(= local45 (Random 0 20))
	else
		(= local45 (Random 21 100))
	)
	(cond
		((> local45 80)
			(= local44 (/ 120 global125))
		)
		((> local45 60)
			(= local44 (/ 160 global125))
		)
		((> local45 40)
			(= local44 (/ 200 global125))
		)
		((> local45 20)
			(= local44 (/ 320 global125))
		)
		(else
			(= local44 (/ 360 global125))
		)
	)
)

(procedure (localproc_3)
	(if (== global125 2)
		(= local46 (Random 6 8))
	else
		(= local46 (Random 4 7))
	)
	(cond
		((<= local46 5)
			(= local47 (Random 8 11))
		)
		((<= local46 7)
			(= local47 (Random 17 21))
		)
		((= local46 8)
			(= local47 (Random 65 74))
		)
	)
	(windFlags sel_110:)
)

(procedure (localproc_4)
	(proc0_3)
	(bigTarget sel_102:)
	(localproc_1)
	(flagTree sel_102:)
	(garland1 sel_102:)
	(garland2 sel_102:)
	(garland3 sel_102:)
	(windFlags sel_102:)
	(bowHand sel_102:)
	(bow sel_102:)
	(arrow sel_102:)
	(if gModelessDialog
		(gModelessDialog sel_111:)
	)
	(gCurRoom sel_408: 803)
)

(procedure (localproc_5)
	(gCurRoom sel_408: 200 sel_146: prepareArrow)
	(flagTree sel_207:)
	(garland1 sel_207:)
	(garland2 sel_207:)
	(garland3 sel_207:)
	(windFlags sel_207:)
	(bowHand sel_207:)
	(bow sel_207:)
	(arrow sel_207:)
	(= local43 0)
)

(instance povGladeArchery of Rm
	(properties
		sel_20 {povGladeArchery}
		sel_399 200
		sel_28 -32765
	)

	(method (sel_110)
		(gTheIconBar sel_225: 2 3 5 6 3)
		(super sel_110:)
		(= local69 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(gTheIconBar sel_178: sel_221: -100 sel_211: -100)
		(garland1 sel_4: 3 sel_63: 3 sel_110:)
		(garland2 sel_4: 4 sel_63: 3 sel_110:)
		(garland3 sel_4: 0 sel_63: 3 sel_110:)
		(bigTarget sel_63: 10 sel_110: sel_102:)
		(= local6 (and (== global130 8) (== global126 4)))
		(bowHand sel_63: 12 sel_110:)
		(bow sel_63: 12 sel_3: 0 sel_4: 0 sel_110:)
		(arrow sel_63: 14 sel_3: 0 sel_4: 0 sel_110:)
		(flagTree sel_110: sel_304:)
		(localproc_2)
		(localproc_3)
		(rock1 sel_110:)
		(rock2 sel_110:)
		(rock3 sel_110:)
		(leftTargetArea sel_110:)
		(midTargetArea sel_110:)
		(rightTargetArea sel_110:)
		(if (and (== gPrevRoomNum 190) (== global130 1) (not (proc0_5 76)))
			(proc0_6 76)
		)
		(gTheIconBar sel_214: (gTheIconBar sel_64: 4))
		(proc0_4)
		(User sel_229: 1 sel_339: 1)
	)

	(method (sel_111)
		(shootSound sel_111:)
		(hitSound sel_111:)
		(= gUseSortedFeatures local69)
		(super sel_111:)
	)

	(method (sel_57)
		(if (== (-- local44) 0)
			(localproc_3)
			(localproc_2)
		)
		(super sel_57:)
	)

	(method (sel_292 param1)
		(switch param1
			(2
				(Print 200 0) ; "'Tis peaceful to shoot in this quiet, light-dappled glade."
			)
			(1
				(gCurRoom sel_146: leaveGlade)
			)
			(10
				(Print 200 1) ; "You can't shoot there."
			)
			(else
				(super sel_292: param1 &rest)
			)
		)
	)
)

(instance windFlags of Prop
	(properties
		sel_20 {windFlags}
		sel_1 35
		sel_0 85
		sel_2 200
	)

	(method (sel_110)
		(super sel_110:)
		(self sel_3: local46 sel_63: 3 sel_162: Fwd sel_236: local47)
	)

	(method (sel_292 param1)
		(switch param1
			(1
				(gCurRoom sel_146: leaveGlade)
			)
			(2
				(Print 200 2) ; "The bit of cloth tied to the tree tells how strongly the wind blows, and from which direction."
			)
			(else 0)
		)
	)
)

(instance garland1 of Prop
	(properties
		sel_20 {garland1}
		sel_1 160
		sel_0 129
		sel_2 200
		sel_3 2
	)

	(method (sel_292 param1)
		(= local70 0)
		(switch param1
			(2
				(if local12
					(self sel_146: closeUpGarland)
				else
					(self sel_146: showEmptyTarget)
				)
			)
			(10
				(leftTargetArea sel_292: 10)
			)
			(1
				(gCurRoom sel_146: leaveGlade)
			)
			(else
				(super sel_292: param1 &rest)
			)
		)
	)
)

(instance garland2 of Prop
	(properties
		sel_20 {garland2}
		sel_1 186
		sel_0 110
		sel_2 200
		sel_3 2
	)

	(method (sel_292 param1)
		(= local70 1)
		(switch param1
			(2
				(if local13
					(self sel_146: closeUpGarland)
				else
					(self sel_146: showEmptyTarget)
				)
			)
			(1
				(gCurRoom sel_146: leaveGlade)
			)
			(10
				(midTargetArea sel_292: 10)
			)
			(else
				(super sel_292: param1 &rest)
			)
		)
	)
)

(instance garland3 of Prop
	(properties
		sel_20 {garland3}
		sel_1 217
		sel_0 121
		sel_2 200
		sel_3 2
	)

	(method (sel_292 param1)
		(= local70 2)
		(switch param1
			(2
				(if local14
					(self sel_146: closeUpGarland)
				else
					(self sel_146: showEmptyTarget)
				)
			)
			(1
				(gCurRoom sel_146: leaveGlade)
			)
			(10
				(rightTargetArea sel_292: 10)
			)
			(else
				(super sel_292: param1 &rest)
			)
		)
	)
)

(instance bowHand of View
	(properties
		sel_20 {bowHand}
		sel_1 137
		sel_0 239
		sel_2 201
		sel_3 1
		sel_14 20480
	)

	(method (sel_110)
		(super sel_110:)
		(self sel_156: local6)
	)

	(method (sel_57)
		(if (== (gTheIconBar sel_214:) (gTheIconBar sel_64: 4))
			(= sel_1 (- (Max 135 (Min 240 gMouseX)) 22))
			(= sel_0 (+ (Max 80 (Min 130 gMouseY)) 109))
			(if (and local10 (<= 148 gMouseX 226) (<= 82 gMouseY 132))
				(gGame sel_198: 5 0 0)
			else
				(gGame sel_198: ((gTheIconBar sel_214:) sel_33:))
			)
		)
		(super sel_57:)
	)

	(method (sel_292 param1)
		(switch param1
			(2
				(Print 200 3) ; "My arm is steady upon the bow."
			)
			(10
				(if (not local10)
					(if (< local11 6)
						(gCurRoom sel_146: prepareArrow)
					else
						(gCurRoom sel_146: newRound)
					)
				)
			)
			(1
				(gCurRoom sel_146: leaveGlade)
			)
			(else
				(super sel_292: param1 &rest)
			)
		)
	)
)

(instance bow of View
	(properties
		sel_20 {bow}
		sel_1 195
		sel_0 144
		sel_2 201
		sel_14 20480
	)

	(method (sel_57)
		(= sel_1 (+ (bowHand sel_1:) 58))
		(= sel_0 (- (bowHand sel_0:) 95))
	)

	(method (sel_292 param1)
		(switch param1
			(2
				(Print 200 4) ; "So many years have I held a longbow, it feels like a part of my own arm."
			)
			(1
				(gCurRoom sel_146: leaveGlade)
			)
			(else
				(super sel_292: param1 &rest)
			)
		)
	)
)

(instance arrow of View
	(properties
		sel_20 {arrow}
		sel_1 159
		sel_0 133
		sel_2 332
		sel_60 16
		sel_14 16400
	)

	(method (sel_57)
		(= sel_1 (+ (bowHand sel_1:) 22))
		(= sel_0 (- (bowHand sel_0:) 106))
	)

	(method (sel_292 param1)
		(switch param1
			(2
				(Print 200 5) ; "My arrow is nocked and ready to be loosed."
			)
			(1
				(gCurRoom sel_146: leaveGlade)
			)
			(else
				(super sel_292: param1 &rest)
			)
		)
	)
)

(instance smallArrow of View
	(properties
		sel_20 {smallArrow}
		sel_2 332
	)

	(method (sel_292 param1)
		(switch param1
			(2
				(Print 200 6) ; "My previous shot."
			)
			(else
				(super sel_292: param1 &rest)
			)
		)
	)
)

(instance bigTarget of View
	(properties
		sel_20 {bigTarget}
		sel_1 151
		sel_0 167
		sel_2 200
		sel_14 16392
	)

	(method (sel_209 param1)
		(return
			(and
				(<= sel_7 (param1 sel_1:) sel_9)
				(<= sel_6 (param1 sel_0:) sel_8)
			)
		)
	)

	(method (sel_292)
		(return 0)
	)
)

(instance flagTree of View
	(properties
		sel_20 {flagTree}
		sel_1 32
		sel_0 143
		sel_2 200
		sel_3 1
		sel_60 9
		sel_14 16
	)

	(method (sel_292 param1)
		(switch param1
			(1
				(gCurRoom sel_146: leaveGlade)
			)
			(2
				(Print 200 2) ; "The bit of cloth tied to the tree tells how strongly the wind blows, and from which direction."
			)
			(else
				(super sel_292: param1 &rest)
			)
		)
	)
)

(instance rock1 of Feature
	(properties
		sel_20 {rock1}
		sel_1 32
		sel_0 122
		sel_6 114
		sel_7 17
		sel_8 131
		sel_9 47
		sel_293 90
	)

	(method (sel_292 param1)
		(switch param1
			(2
				(Print 200 7) ; "I should take care not to ruin my arrow by firing upon a rock."
			)
			(1
				(gCurRoom sel_146: leaveGlade)
			)
			(else
				(super sel_292: param1 &rest)
			)
		)
	)
)

(instance rock2 of Feature
	(properties
		sel_20 {rock2}
		sel_1 124
		sel_0 137
		sel_6 129
		sel_7 113
		sel_8 145
		sel_9 136
		sel_293 90
	)

	(method (sel_292)
		(rock1 sel_292: &rest)
	)
)

(instance rock3 of Feature
	(properties
		sel_20 {rock3}
		sel_1 282
		sel_0 172
		sel_6 156
		sel_7 246
		sel_8 189
		sel_9 319
		sel_293 90
	)

	(method (sel_292)
		(rock1 sel_292: &rest)
	)
)

(instance prepareArrow of Script
	(properties
		sel_20 {prepareArrow}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(arrow
					sel_4: 0
					sel_153: (+ (bowHand sel_1:) 22) (- (bowHand sel_0:) 106)
					sel_207:
				)
				(= local10 1)
				(gGame sel_198: 5 1)
				(= sel_136 5)
			)
			(1
				(self sel_111:)
			)
		)
	)
)

(instance fireArrow of Script
	(properties
		sel_20 {fireArrow}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(arrow sel_4: 1)
				(= sel_136 1)
			)
			(1
				(shootSound sel_39:)
				(arrow sel_4: 2)
				(= sel_136 1)
			)
			(2
				(arrow sel_102:)
				(= local39 (arrow sel_1:))
				(= local40 (arrow sel_0:))
				(= local10 0)
				(= sel_139
					(switch local70
						(0 5)
						(1 20)
						(2 15)
					)
				)
			)
			(3
				(+=
					local39
					(switch local46
						(4
							(-
								(switch local70
									(0
										(Random 3 7)
									)
									(1
										(Random 1 5)
									)
									(2
										(Random 2 6)
									)
								)
							)
						)
						(5
							(switch local70
								(0
									(Random 3 7)
								)
								(1
									(Random 1 5)
								)
								(2
									(Random 2 6)
								)
							)
						)
						(6
							(-
								(switch local70
									(0
										(Random 2 6)
									)
									(1
										(Random 1 4)
									)
									(2
										(Random 1 5)
									)
								)
							)
						)
						(7
							(switch local70
								(0
									(Random 2 6)
								)
								(1
									(Random 1 4)
								)
								(2
									(Random 1 5)
								)
							)
						)
					)
				)
				(+= local40 [local60 local70])
				(arrow sel_4: [local63 local70])
				((= [local15 local11] (smallArrow sel_109:))
					sel_2: 332
					sel_3: 0
					sel_4: [local63 local70]
					sel_153: local39 local40
					sel_307:
					sel_63: 5
					sel_110:
					sel_304:
				)
				(if
					(or
						(> 280 local39 230)
						(> 137 local39 35)
						(and (> 179 local39 172) (> 103 local40 71))
						(and (> 205 local39 194) (> 115 local40 78))
					)
					(= local41 999)
					(= local42 999)
				else
					(= local41
						(+
							(/
								(*
									(- local39 [local48 local70])
									[local57 local70]
								)
								10
							)
							[local54 local70]
						)
					)
					(if (== local39 local43)
						(-= local41 1)
					)
					(= local42
						(+
							(/
								(*
									(- local40 [local51 local70])
									[local57 local70]
								)
								10
							)
							122
						)
					)
				)
				(= local43 local39)
				(switch local70
					(0
						((= [local21 local12] (Prop sel_109:))
							sel_2: 200
							sel_3: 3
							sel_4: 0
							sel_153: local41 local42
							sel_63: 11
							sel_307:
							sel_110:
							sel_102:
						)
						(++ local12)
						(= local0 0)
					)
					(1
						((= [local27 local13] (Prop sel_109:))
							sel_2: 200
							sel_3: 3
							sel_4: 0
							sel_153: local41 local42
							sel_63: 11
							sel_307:
							sel_110:
							sel_102:
						)
						(++ local13)
						(= local1 0)
					)
					(2
						((= [local33 local14] (Prop sel_109:))
							sel_2: 200
							sel_3: 3
							sel_4: 0
							sel_153: local41 local42
							sel_63: 11
							sel_307:
							sel_110:
							sel_102:
						)
						(++ local14)
						(= local2 0)
					)
				)
				(if
					(or
						(> 280 local39 230)
						(> 137 local39 35)
						(and (> 179 local39 172) (> 103 local40 71))
						(and (> 205 local39 194) (> 115 local40 78))
					)
					([local15 local11] sel_102:)
					(hitSound sel_40: 357)
				else
					(hitSound sel_40: 908)
				)
				(if (== global130 1)
					(proc0_6 41)
				)
				(++ local11)
				(gGame
					sel_198:
						gTheCursor
						1
						(+ gMouseX (Random 0 8) -4)
						(+ gMouseY (Random 0 8) -4)
				)
				(= sel_136 (if (== local41 999) 10 else 1))
			)
			(4
				(User sel_339: 1)
				(hitSound sel_39:)
				(if (proc0_5 43)
					(cond
						(
							(and
								(or
									(> 280 local39 230)
									(> 137 local39 35)
									(and (> 179 local39 172) (> 103 local40 71))
									(and (> 205 local39 194) (> 115 local40 78))
								)
								local9
							)
							(sel_42 sel_146: saySomethingWill self 2)
						)
						(
							(and
								(switch local70
									(0
										(== local39 160)
									)
									(1
										(== local39 187)
									)
									(2
										(== local39 218)
									)
								)
								(switch local70
									(0
										(or (== local40 117) (== local40 118))
									)
									(1
										(or (== local40 99) (== local40 100))
									)
									(2
										(== local40 107)
									)
								)
								local7
							)
							(sel_42 sel_146: saySomethingWill self 0)
						)
						(
							(and
								(switch local70
									(0
										(or
											(>= 179 local39 168)
											(>= 154 local39 138)
											(and
												(>= 179 local39 138)
												(or
													(> 110 local40 64)
													(> 151 local40 125)
												)
											)
										)
									)
									(1
										(or
											(>= 193 local39 191)
											(>= 183 local39 180)
											(and
												(>= 193 local39 180)
												(or
													(>= 92 local40 56)
													(>= 114 local40 102)
												)
											)
										)
									)
									(2
										(or
											(>= 228 local39 222)
											(>= 213 local39 206)
											(and
												(>= 228 local39 206)
												(or
													(> 100 local40 82)
													(> 124 local40 113)
												)
											)
										)
									)
								)
								local8
							)
							(sel_42 sel_146: saySomethingWill self 1)
						)
						(else
							(= sel_136 1)
						)
					)
				else
					(= sel_136 1)
				)
			)
			(5
				(if (not (proc0_6 166))
					(gCurRoom sel_146: showCloseUpGarland)
				else
					(= sel_136 1)
				)
			)
			(6
				(self sel_111:)
			)
		)
	)
)

(instance showCloseUpGarland of Script
	(properties
		sel_20 {showCloseUpGarland}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(proc0_3)
				(gTheIconBar sel_179: (gTheIconBar sel_64: 1))
				(gGame sel_198: 1 1)
				(= sel_139 60)
			)
			(1
				(proc0_4 1)
				(sel_42 sel_146: closeUpGarland)
			)
		)
	)
)

(instance closeUpGarland of Script
	(properties
		sel_20 {closeUpGarland}
	)

	(method (sel_144 param1 &tmp temp0 temp1)
		(switch (= sel_29 param1)
			(0
				(proc0_3)
				(arrow sel_102:)
				(bow sel_102:)
				(bowHand sel_102:)
				(bigTarget sel_1: [local66 local70])
				(= sel_136 1)
			)
			(1
				(bigTarget sel_207:)
				(SetNowSeen bigTarget)
				(switch local70
					(0
						(for ((= temp0 0)) (< temp0 local12) ((++ temp0))
							(= temp1 [local21 temp0])
							(if (bigTarget sel_209: temp1)
								(temp1 sel_207:)
							)
						)
						(if (not local0)
							(temp1 sel_162: Osc 1)
						)
						(= local0 1)
					)
					(1
						(for ((= temp0 0)) (< temp0 local13) ((++ temp0))
							(= temp1 [local27 temp0])
							(if (bigTarget sel_209: temp1)
								(temp1 sel_207:)
							)
						)
						(if (not local1)
							(temp1 sel_162: Osc 1)
						)
						(= local1 1)
					)
					(2
						(for ((= temp0 0)) (< temp0 local14) ((++ temp0))
							(= temp1 [local33 temp0])
							(if (bigTarget sel_209: temp1)
								(temp1 sel_207:)
							)
						)
						(if (not local2)
							(temp1 sel_162: Osc 1)
						)
						(= local2 1)
					)
				)
				(= sel_139 150)
			)
			(2
				(localproc_0)
				(bigTarget sel_102:)
				(= sel_136 5)
			)
			(3
				(bow sel_207:)
				(bowHand sel_207:)
				(if (== local10 1)
					(arrow sel_207:)
				)
				(= sel_136 2)
			)
			(4
				(proc0_4 1)
				(self sel_111:)
			)
		)
	)
)

(instance saySomethingWill of Script
	(properties
		sel_20 {saySomethingWill}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(proc0_3)
				(switch sel_141
					(0
						(= local7 0)
					)
					(1
						(= local8 0)
					)
					(2
						(= local9 0)
					)
				)
			)
			(1
				(proc0_4 1)
				(self sel_111:)
			)
		)
	)
)

(instance leaveGlade of Script
	(properties
		sel_20 {leaveGlade}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(switch (Print 200 8 78 {Yes} 1 78 {No} 2) ; "Are you sure you wish to leave the glade?"
					(1
						(if local11
							(Print 200 9) ; "I'll collect what I've fired before I leave."
						)
						(gCurRoom sel_390: 100)
						(self sel_111:)
					)
					(else
						(self sel_111:)
					)
				)
			)
		)
	)
)

(instance newRound of Script
	(properties
		sel_20 {newRound}
	)

	(method (sel_144 param1 &tmp temp0)
		(switch (= sel_29 param1)
			(0
				(proc0_3)
				(= sel_139 18)
			)
			(1
				(Print 200 10) ; "I'll collect my arrows before I fire again."
				(= sel_136 1)
			)
			(2
				(proc0_4 1)
				(gTheIconBar sel_225: 0 4 sel_179: (gTheIconBar sel_64: 1))
				(= sel_139 300)
			)
			(3
				(if (bigTarget sel_301:)
					(-- sel_29)
				)
				(= sel_139 10)
			)
			(4
				(localproc_4)
				(= sel_139 60)
			)
			(5
				(localproc_5)
				(proc0_4 1)
				(gTheIconBar sel_178: 0 4 sel_214: (gTheIconBar sel_64: 4))
				(gGame sel_606: 4)
				(= sel_139 30)
			)
			(6
				(self sel_111:)
			)
		)
	)
)

(instance showEmptyTarget of Script
	(properties
		sel_20 {showEmptyTarget}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(proc0_3)
				(arrow sel_102:)
				(bow sel_102:)
				(bowHand sel_102:)
				(= sel_136 1)
			)
			(1
				(bigTarget sel_1: [local66 local70] sel_207:)
				(= sel_136 2)
			)
			(2
				(switch local70
					(0
						(if local3
							(= local3 0)
							(Print 200 11) ; "This garland is the closest of the three."
						)
					)
					(1
						(if local4
							(= local4 0)
							(Print 200 12) ; "This garland is the most difficult of the three."
						)
					)
					(2
						(if local5
							(= local5 0)
							(Print 200 13) ; "This garland is placed at a challenging, but not overly difficult, distance."
						)
					)
				)
				(= sel_136 5)
			)
			(3
				(bigTarget sel_1: [local66 local70] sel_102:)
				(= sel_136 3)
			)
			(4
				(bow sel_207:)
				(bowHand sel_207:)
				(if (== local10 1)
					(arrow sel_207:)
				)
				(proc0_4 1)
				(self sel_111:)
			)
		)
	)
)

(instance shootSound of Sound
	(properties
		sel_20 {shootSound}
		sel_99 1
		sel_40 906
	)
)

(instance hitSound of Sound
	(properties
		sel_20 {hitSound}
		sel_99 1
	)
)

(instance leftTargetArea of Feature
	(properties
		sel_20 {leftTargetArea}
		sel_1 161
		sel_0 130
		sel_6 80
		sel_7 140
		sel_8 134
		sel_9 174
		sel_293 90
	)

	(method (sel_292 param1)
		(switch param1
			(10
				(if (and local10 (< local11 6))
					(= local70 0)
					(gCurRoom sel_146: fireArrow)
				)
			)
			(else
				(super sel_292: param1 &rest)
			)
		)
	)
)

(instance midTargetArea of Feature
	(properties
		sel_20 {midTargetArea}
		sel_1 188
		sel_0 101
		sel_6 70
		sel_7 175
		sel_8 122
		sel_9 200
		sel_293 90
	)

	(method (sel_292 param1)
		(switch param1
			(10
				(if (and local10 (< local11 6))
					(= local70 1)
					(gCurRoom sel_146: fireArrow)
				)
			)
			(else
				(super sel_292: param1 &rest)
			)
		)
	)
)

(instance rightTargetArea of Feature
	(properties
		sel_20 {rightTargetArea}
		sel_1 218
		sel_0 105
		sel_6 75
		sel_7 201
		sel_8 125
		sel_9 234
		sel_293 90
	)

	(method (sel_292 param1)
		(switch param1
			(10
				(if (and local10 (< local11 6))
					(= local70 2)
					(gCurRoom sel_146: fireArrow)
				)
			)
			(else
				(super sel_292: param1 &rest)
			)
		)
	)
)

