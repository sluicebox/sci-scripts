;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 540)
(include sci.sh)
(use Main)
(use Interface)
(use Morris)
(use n806)
(use RandCycle)
(use Polygon)
(use Feature)
(use Window)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm540 0
)

(local
	local0 = 1
	local1
	[local2 32] = [107 156 203 0 120 153 185 0 133 150 165 0 100 115 131 0 163 179 195 0 129 145 160 0 109 142 174 0 92 140 188 0]
	[local34 32] = [132 124 116 0 118 113 107 0 104 101 99 0 99 96 93 0 87 84 81 0 82 79 76 0 74 69 63 0 64 57 50 0]
	[local66 31]
	[local97 63] = [1 5 18 0 5 13 17 0 9 5 16 0 13 25 13 0 17 5 17 0 14 25 21 0 13 17 25 0 12 25 29 28 0 0 0 13 1 5 0 20 8 8 0 28 14 20 0 10 18 2 0 22 22 10 0 25 29 17 0 30 30 2 -1]
	[local160 165] = [1794 1793 1792 -1 -1 -1 -1 1794 1793 -1 -1 -1 -1 -1 1794 -1 -1 -1 -1 -1 -1 1794 1538 1537 1536 -1 -1 -1 1794 1538 1537 -1 -1 -1 -1 1794 1538 -1 -1 -1 -1 -1 1794 1538 1282 1281 1280 -1 -1 1794 1538 1282 1281 -1 -1 -1 1794 1538 1282 -1 -1 -1 -1 1794 1538 1281 1025 1024 -1 -1 1794 1538 1282 1026 1025 -1 -1 1794 1538 1281 1026 -1 -1 -1 1794 1538 1282 1027 -1 -1 -1 1794 1538 1028 -1 -1 -1 -1 1794 1029 -1 -1 -1 -1 -1 1794 1538 1027 769 768 -1 -1 1794 1538 1027 769 -1 -1 -1 1794 1538 1027 770 -1 -1 -1 1794 1538 1027 769 512 -1 -1 1794 1538 1027 770 513 -1 -1 1794 1538 1028 514 -1 -1 -1 1794 1538 1282 768 512 256 -1 1794 1538 1028 513 257 -1 -1 1794 1029 258 -1]
	[local325 16] = [167 92 154 92 141 87 131 87 87 80 83 60 195 41 205 95]
	[local341 18] = [32 65 17 56 11 47 0 43 0 47 12 57 9 76 26 91 38 84]
	[local359 12] = [258 133 270 133 284 150 277 163 259 164 250 154]
	[local371 14] = [237 46 263 47 278 41 281 46 263 51 242 63 228 59]
	[local385 8] = [71 61 208 36 228 122 91 143]
	[local393 20] = [98 54 100 17 160 0 193 0 210 17 213 46 193 46 194 33 184 19 165 46]
	[local413 239] = [189 163 100 185 77 159 81 132 101 138 96 147 107 157 126 143 189 124 0 541 0 2 4 22 31 25 23 5 1540 0 1 1 1 0 1540 3 1 0 1540 4 1 0 1540 5 2 1 0 1540 7 2 1 0 1540 9 1 0 1540 10 2 1 0 1540 12 1 2 1 2 1 0 1540 17 1 0 1540 18 1 2 2 0 1540 22 1 0 1540 23 2 1 0 1540 25 2 1 0 1540 27 1 0 1540 28 2 1 1 2 1 1 2 1 0 1540 36 2 1 0 1540 38 1 1 0 1540 40 1 1 1 0 1540 43 1 2 0 1540 45 2 1 0 1540 47 2 1 2 1 2 1 2 2 1 0 1540 56 2 1 2 1 1 1 0 1540 62 1 1 0 1540 65 1 0 1540 66 1 0 1540 67 1 0 1540 68 1 0 1540 69 1 0 1540 79 1 0 1540 80 1 0 1540 81 1 0 1540 82 1 0 1540 83 1 0 1540 84 1 0 1540 21 1 0 1540 87 1 0 1540 89 1 0 1540 91 1 0 1540 71 1 0 1534 23 1 2 1 1 0 1534 27 1 0 1534 29 1 0]
	local652
	local653
	local654
	local655
	[local656 9] = [80 87 92 96 85 99 85 78 89]
	[local665 9] = [90 81 91 109 99 122 109 75 118]
	[local674 9] = [207 202 212 207 207 218 215 196 212]
	[local683 9] = [58 68 73 95 82 99 88 56 107]
	[local692 9]
	[local701 9]
)

(instance rm540 of Rm
	(properties
		sel_20 {rm540}
		sel_399 540
		sel_28 100
		sel_403 310
	)

	(method (sel_110 &tmp temp0)
		(proc0_3)
		(gTheIconBar
			sel_178:
			sel_211: -100
			sel_214: (gTheIconBar sel_64: 2)
			sel_221: -100
		)
		(proc0_11 gWaitCursor)
		(if (== gPrevRoomNum 550)
			(= sel_28 -32762)
		)
		(super sel_110:)
		(cat1Poly sel_87: @local341)
		(cat2Poly sel_87: @local359)
		(meatPoly sel_87: @local371)
		(brdPoly sel_87: @local385)
		(harryPoly sel_87: @local393)
		(robPoly sel_87: @local413)
		(halfBoard sel_87: @local325)
		(board sel_110: sel_294: brdPoly)
		(cat1 sel_110: sel_294: cat1Poly)
		(tail sel_110: sel_162: Fwd sel_146: meow)
		(cat2 sel_110: sel_294: cat2Poly)
		(mugFloor sel_110:)
		(harry sel_110: sel_294: harryPoly)
		(rob sel_110: sel_294: robPoly)
		(fish sel_110:)
		(bones sel_110:)
		(meat sel_110: sel_294: meatPoly)
		(rHead sel_110: sel_162: RandCycle)
		(hHead sel_110: sel_162: RandCycle)
		(floor sel_110:)
		((gTheIconBar sel_64: 0) sel_37: 11)
		(for ((= temp0 0)) (<= temp0 8) ((++ temp0))
			((= [local692 temp0] (piece sel_109:))
				sel_153: [local674 temp0] [local683 temp0]
				sel_110:
			)
			((= [local701 temp0] (piece sel_109:))
				sel_153: [local656 temp0] [local665 temp0]
				sel_4: 1
				sel_110:
			)
		)
		(arm sel_110:)
		(cArm sel_110:)
		(self sel_146: offer)
	)

	(method (sel_292 param1)
		(switch param1
			(1
				(wannaQuit sel_57:)
			)
			(else 0)
		)
	)

	(method (sel_111)
		((gTheIconBar sel_64: 0) sel_37: 1)
		(super sel_111:)
		(DisposeScript 541)
	)
)

(instance board of Feature
	(properties
		sel_20 {board}
		sel_0 30
	)

	(method (sel_133 param1)
		(if
			(not
				(and
					(gCurRoom sel_142:)
					(offer sel_142:)
					(theMorris sel_133: param1)
				)
			)
			(super sel_133: param1)
		)
		(param1 sel_73:)
	)

	(method (sel_292 param1)
		(switch param1
			(1
				(wannaQuit sel_57:)
			)
			(2
				(Print 540 0 77 {Harry} 32 cluckWindow) ; "The nine men's Morris game is carved into the surface of this table."
			)
		)
		(return
			(cond
				((and (== param1 3) (not (gCurRoom sel_142:)))
					(super sel_292: param1)
				)
				((== param1 3)
					(not (offer sel_142:))
				)
			)
		)
	)
)

(instance tail of Prop
	(properties
		sel_20 {tail}
		sel_1 271
		sel_0 182
		sel_2 542
		sel_3 9
		sel_14 4096
		sel_236 60
	)

	(method (sel_292)
		(cat2 sel_292: &rest)
	)
)

(instance cat1 of Feature
	(properties
		sel_20 {cat1}
	)

	(method (sel_292 param1)
		(switch param1
			(3
				(Print 540 1 77 {You} 32 cluckWindow) ; "I'm here to play Morris, not to pet cats."
			)
			(2
				(Print 540 2) ; "Meowrrrroorrr!"
			)
			(5
				(proc13_6 32)
				(Print 540 2) ; "Meowrrrroorrr!"
				(proc13_6 0)
			)
			(else 0)
		)
	)
)

(instance cat2 of Feature
	(properties
		sel_20 {cat2}
	)

	(method (sel_292 param1)
		(switch param1
			(3
				(Print 540 1 77 {Harry} 32 cluckWindow) ; "I'm here to play Morris, not to pet cats."
			)
			(2
				(Print 540 3) ; "prrrrrrrrrrr...."
			)
			(5
				(proc13_6 32)
				(Print 540 3) ; "prrrrrrrrrrr...."
				(proc13_6 0)
			)
			(else 0)
		)
	)
)

(instance mugFloor of Feature
	(properties
		sel_20 {mugFloor}
		sel_294 4096
	)

	(method (sel_292 param1)
		(switch param1
			(3
				(Print 540 4) ; "I don't need that."
			)
			(2
				(Print 540 5) ; "Wasn't me who spilled it."
			)
			(else
				(super sel_292: param1 &rest)
			)
		)
	)
)

(instance bones of Feature
	(properties
		sel_20 {bones}
		sel_294 16
	)

	(method (sel_292 param1)
		(switch param1
			(3
				(Print 540 6) ; "That bone is only fit for these tavern cats."
			)
			(2
				(Print 540 7) ; "Cleanliness is not one of this innkeeper's virtues."
			)
			(else
				(super sel_292: param1 &rest)
			)
		)
	)
)

(instance fish of Feature
	(properties
		sel_20 {fish}
		sel_294 256
	)

	(method (sel_292 param1)
		(switch param1
			(2
				(Print 540 7) ; "Cleanliness is not one of this innkeeper's virtues."
			)
			(5
				(proc13_6 32)
				(Message 540 8 1)
				(proc13_6 0)
			)
			(3
				(Print 540 6) ; "That bone is only fit for these tavern cats."
			)
			(else
				(super sel_292: param1 &rest)
			)
		)
	)
)

(instance harry of Feature
	(properties
		sel_20 {harry}
	)

	(method (sel_292 param1 param2)
		(switch param1
			(5
				(if (not (gCurRoom sel_142:))
				)
			)
			(4
				(switch param2
					(0
						(if
							(or
								(not (theMorris sel_568:))
								(and
									(not (proc0_5 186))
									(<= (theMorris sel_568:) 2)
								)
							)
							(if (global152 sel_57:)
								(= local653 (global135 sel_593:))
								(= local654 (global134 sel_593:))
								(= local655 (global133 sel_593:))
								(global152 sel_343:)
							else
								(return)
							)
						)
						(cond
							((not (gCurRoom sel_142:)))
							((offer sel_142:)
								(cond
									((proc0_5 186))
									((< (theMorris sel_568:) 2)
										(proc0_6 186)
										(proc806_6 2)
										(gGame
											sel_198:
												((gTheIconBar sel_214:) sel_33:)
										)
									)
								)
							)
							((!= gPrevRoomNum 550)
								(proc0_6 186)
								(offer sel_29: 0 sel_137: 0)
							)
							((proc0_5 186)
								(offer sel_29: (+ (offer sel_29:) 1) sel_137: 0)
							)
							(else
								(proc0_6 186)
								(offer sel_29: (+ (offer sel_29:) 1) sel_137: 0)
							)
						)
					)
					(18
						(gCurRoom sel_146: pissOff)
					)
					(2
						(if local652
							(= local652 1)
						)
					)
					(11)
					(14)
					(13)
					(else
						(super sel_292: param1 param2)
					)
				)
			)
			(3
				(Print 540 9 77 {You} 32 cluckWindow) ; "Whatever I take from him, I'll do by wagering and playing a fair game, not by force."
			)
			(2
				(Print 540 10 77 {You} 32 cluckWindow) ; "I've seen such men before, whose love of a game has driven all else from their lives."
			)
			(else
				(super sel_292: param1 param2)
			)
		)
	)
)

(instance pissOff of Script
	(properties
		sel_20 {pissOff}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(proc0_3)
				(= sel_136 1)
			)
			(1
				(proc0_6 124)
				(proc0_4)
				(gCurRoom sel_390: 530)
			)
		)
	)
)

(instance meat of Feature
	(properties
		sel_20 {meat}
	)

	(method (sel_292 param1)
		(switch param1
			(5
				(proc13_6 32)
				(Message 540 11 1)
				(proc13_6 0)
			)
			(2
				(Print 540 12) ; "A leg of mutton that's seen better days."
			)
			(3
				(Print 540 6) ; "That bone is only fit for these tavern cats."
			)
			(else
				(super sel_292: param1 &rest)
			)
		)
	)
)

(instance rob of Feature
	(properties
		sel_20 {rob}
	)

	(method (sel_292)
		(gEgo sel_292: &rest)
	)
)

(instance rHead of Prop
	(properties
		sel_20 {rHead}
		sel_1 168
		sel_0 20
		sel_82 -150
		sel_2 542
		sel_60 14
		sel_14 16400
		sel_236 540
	)

	(method (sel_209)
		(return 0)
	)
)

(instance hHead of Prop
	(properties
		sel_20 {hHead}
		sel_1 139
		sel_0 8
		sel_2 543
		sel_60 13
		sel_14 16400
		sel_236 200
	)

	(method (sel_292)
		(harry sel_292: &rest)
	)
)

(instance floor of Feature
	(properties
		sel_20 {floor}
		sel_294 1
	)

	(method (sel_133 param1)
		(if (not (param1 sel_73:))
			(if (== ((gTheIconBar sel_214:) sel_37:) 11)
				(param1 sel_73: 1)
				((gTheIconBar sel_64: 0) sel_37: 1)
				(if (offer sel_142:)
				)
				(self sel_292: &rest)
			else
				(super sel_133: param1)
			)
		)
	)

	(method (sel_292 param1)
		(switch param1
			(2
				(Print 540 7) ; "Cleanliness is not one of this innkeeper's virtues."
			)
			(1
				(switch (Print 540 13 78 {Yes} 1 78 {No} 2) ; "Are you sure you wish to leave the game?"
					(1
						(gCurRoom sel_390: 100)
					)
					(2
						((gTheIconBar sel_64: 0) sel_37: 11)
					)
				)
			)
			(else
				(super sel_292: param1 &rest)
			)
		)
	)
)

(instance meow of Script
	(properties
		sel_20 {meow}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(= sel_139 (Random 520 720))
			)
			(1
				(catSound sel_40: (Random 354 355) sel_39:)
				(= sel_29 -1)
				(= sel_136 1)
			)
		)
	)
)

(instance brdPoly of Polygon
	(properties
		sel_20 {brdPoly}
		sel_86 4
	)
)

(instance cat1Poly of Polygon
	(properties
		sel_20 {cat1Poly}
		sel_86 9
	)
)

(instance cat2Poly of Polygon
	(properties
		sel_20 {cat2Poly}
		sel_86 6
	)
)

(instance meatPoly of Polygon
	(properties
		sel_20 {meatPoly}
		sel_86 7
	)
)

(instance harryPoly of Polygon
	(properties
		sel_20 {harryPoly}
		sel_86 10
	)
)

(instance robPoly of Polygon
	(properties
		sel_20 {robPoly}
		sel_86 9
	)
)

(instance halfBoard of Polygon
	(properties
		sel_20 {halfBoard}
		sel_86 8
	)
)

(instance offer of Script
	(properties
		sel_20 {offer}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(if (!= gPrevRoomNum 550)
					(+= sel_29 3)
				)
				(= sel_136 1)
			)
			(1
				(= sel_136 1)
			)
			(2
				(self sel_146: theMorris self)
			)
			(3
				(theMorris sel_568: 0)
				(cond
					((proc0_5 186)
						(if local0
							(+= sel_29 4)
							(= sel_136 1)
						else
							(= sel_136 1)
							(global135 sel_342: local653)
							(global134 sel_342: local654)
							(global133 sel_342: local655)
						)
					)
					(local0
						(= sel_136 1)
					)
					(else
						(= sel_136 1)
					)
				)
				(= gPrevRoomNum 550)
			)
			(4
				(cond
					((proc0_5 186)
						(= sel_136 1)
					)
					((== gPrevRoomNum 550)
						(= sel_136 1)
					)
					((proc0_5 221)
						(= sel_136 1)
					)
					(else
						(proc0_6 221)
						(= sel_136 1)
					)
				)
			)
			(5
				(proc0_4)
				(proc806_6 2)
				(gGame sel_198: ((gTheIconBar sel_214:) sel_33:))
				(= sel_137 1)
			)
			(6
				(proc0_3)
				(cond
					((proc0_5 186)
						(-= sel_29 2)
						(= sel_136 1)
					)
					((== gPrevRoomNum 550)
						(= sel_136 1)
					)
					(else
						(= sel_136 1)
						(= sel_29 0)
					)
				)
			)
			(7
				(= gCurRoomNum 550)
			)
			(8
				(cArm sel_162: ATo (+ @local160 154) self)
			)
			(9
				(gEgo sel_342: 14)
				(proc13_0 {} 79 771 0 9 111)
				(= sel_137 4)
			)
			(10
				(cArm sel_162: ATo (+ @local160 154) -1 self)
			)
			(11
				(= sel_136 1)
			)
			(12
				(self sel_111:)
				(proc0_4)
			)
		)
	)
)

(instance piece of Prop
	(properties
		sel_20 {piece}
		sel_2 542
		sel_3 10
		sel_60 3
		sel_14 20752
	)

	(method (sel_292 param1 param2)
		(switch param1
			(2
				(cond
					((offer sel_142:)
						(Print 540 14 77 {You} 32 cluckWindow) ; "I'm using the black pieces on the right side of the board."
					)
					((!= (theMorris sel_29:) -1)
						(Print 540 15 77 {Harry} 32 cluckWindow) ; "The piece remains where it was placed."
					)
					(else
						(Print 540 16 77 {Harry} 32 cluckWindow) ; "I'll use the white pieces on the right side of the board."
					)
				)
			)
			(3
				(if (and (offer sel_142:) sel_204)
					(theMorris
						sel_133:
							((User sel_338:)
								sel_1: sel_1
								sel_0: sel_0
								sel_73: 0
							)
					)
				)
			)
			(else
				(super sel_292: param1 param2)
			)
		)
	)
)

(instance arm of Prop
	(properties
		sel_20 {arm}
		sel_1 196
		sel_0 20
		sel_82 -121
		sel_2 542
		sel_3 8
		sel_60 10
		sel_14 20496
		sel_236 0
	)

	(method (sel_292)
		(gEgo sel_292: &rest)
	)
)

(instance cArm of Prop
	(properties
		sel_20 {cArm}
		sel_1 102
		sel_0 8
		sel_82 -32
		sel_2 543
		sel_3 8
		sel_60 10
		sel_14 20496
		sel_236 0
	)

	(method (sel_292)
		(harry sel_292: &rest)
	)
)

(instance theMorris of Morris
	(properties
		sel_20 {theMorris}
	)

	(method (sel_144 param1 &tmp [temp0 100] temp100 temp101 temp102 temp103)
		(switch (= sel_29 param1)
			(0
				(arm sel_110: sel_156: 0)
				(= sel_573 (= sel_576 9))
				(gMouseDownHandler sel_118: self)
				(gKeyDownHandler sel_118: self)
				(gGame sel_198: gNormalCursor)
				(= sel_136 1)
			)
			(1
				(if (< sel_568 18)
					(= sel_141 [local692 (/ sel_568 2)])
					(arm sel_156: 0)
				)
				(= sel_570 (= sel_571 (= sel_572 -20)))
				(= sel_136 1)
			)
			(2
				(proc0_4)
				(proc806_6 2)
				(= sel_137 50)
			)
			(3
				(if sel_137
					(= sel_137 0)
				else
					(proc0_3)
					(= sel_136 1)
					(-= sel_29 2)
					(return)
				)
				(if (< sel_568 18)
					(sel_141 sel_102:)
					(arm
						sel_162:
							ATo
							(+ @local160 (* 14 (/ (* 3 (+ 1 sel_571)) 4)))
							self
					)
				else
					(arm
						sel_162:
							ATo
							(+ @local160 (* 14 (/ (* 3 (+ 1 sel_570)) 4)))
							self
					)
				)
			)
			(4
				(if (< sel_568 18)
					(clickSound sel_39:)
				)
				(arm
					sel_162:
						ATo
						(+ @local160 (* 14 (/ (* 3 (+ 1 sel_571)) 4)))
						-1
						self
				)
				(= sel_139 (+ 1 (arm sel_236:)))
				(if (>= sel_568 18)
					(sel_141 sel_102:)
				)
			)
			(5
				(if (>= sel_568 18)
					(clickSound sel_39:)
				)
				(sel_141
					sel_207:
					sel_153: [local2 sel_571] [local34 sel_571]
					sel_204: 1
					sel_63: -1
				)
				(= sel_141 0)
			)
			(6
				(= temp100 sel_574)
				(= temp101 sel_575)
				(= temp102 sel_577)
				(= temp103 sel_578)
				(= sel_572 -20)
				(self sel_589: 16 1)
				(if (not (self sel_588: sel_571))
					(+= sel_29 3)
				)
				(self sel_590: 16 1)
				(= sel_574 temp100)
				(= sel_575 temp101)
				(= sel_577 temp102)
				(= sel_578 temp103)
				(arm sel_156: 0 sel_155: 8)
				(= sel_136 1)
			)
			(7
				(proc0_4)
				(gTheIconBar sel_214: (gTheIconBar sel_64: 2))
				(= sel_137 30)
			)
			(8
				(if sel_137
					(= sel_137 0)
					(arm
						sel_162:
							ATo
							(+ @local160 (* 14 (/ (* 3 (+ 1 sel_572)) 4)))
							self
					)
				else
					(proc0_3)
					(= sel_136 1)
					(-= sel_29 2)
				)
			)
			(9
				([local66 sel_572] sel_111:)
				(= [local66 sel_572] 0)
				(arm
					sel_162:
						ATo
						(+ @local160 (* 14 (/ (* 3 (+ 1 sel_572)) 4)))
						-1
						self
				)
			)
			(10
				(arm sel_156: 0 sel_155: 8)
				(= sel_136 2)
			)
			(11
				(self sel_589: 16 1)
				(if (<= sel_573 2)
					(self sel_111:)
					(return)
				)
				(if (>= sel_568 18)
					(= sel_569 3)
				)
				(if (== sel_568 1)
					(= sel_571 [local97 (+ sel_571 (* 31 (Random 0 1)))])
				else
					(= local0 (self sel_579: sel_569 0 1 16 32767))
				)
				(if (== sel_571 -20)
					(self sel_111:)
					(return)
				)
				(self sel_589: 1 16)
				(= sel_570 (self sel_592: sel_570))
				(= sel_571 (self sel_592: sel_571))
				(= sel_572 (self sel_592: sel_572))
				(if (<= sel_568 18)
					((= sel_141 [local701 (- (/ sel_568 2) 1)]) sel_102:)
					(cArm
						sel_162:
							ATo
							(+ @local160 (* 14 (- 23 (/ (* 3 (+ 1 sel_571)) 4))))
							self
					)
				else
					(cArm
						sel_162:
							ATo
							(+ @local160 (* 14 (- 23 (/ (* 3 (+ 1 sel_570)) 4))))
							self
					)
				)
			)
			(12
				(if (<= sel_568 18)
					(clickSound sel_39:)
				)
				(cArm
					sel_162:
						ATo
						(+ @local160 (* 14 (- 23 (/ (* 3 (+ 1 sel_571)) 4))))
						-1
						self
				)
				(= sel_136 (+ 1 (cArm sel_236:)))
			)
			(13
				(if (<= sel_568 18)
					((= [local66 sel_571] sel_141) sel_204: 1 sel_207:)
				else
					(clickSound sel_39:)
					(= [local66 sel_571] [local66 sel_570])
					(= [local66 sel_570] 0)
				)
				([local66 sel_571] sel_153: [local2 sel_571] [local34 sel_571])
			)
			(14
				(if (== sel_572 -20)
					(++ sel_29)
					(= sel_136 1)
				else
					(cArm
						sel_162:
							ATo
							(+ @local160 (* 14 (- 23 (/ (* 3 (+ 1 sel_572)) 4))))
							self
					)
				)
			)
			(15
				([local66 sel_572] sel_111:)
				(= [local66 sel_572] 0)
				(cArm
					sel_162:
						ATo
						(+ @local160 (* 14 (- 23 (/ (* 3 (+ 1 sel_572)) 4))))
						-1
						self
				)
			)
			(16
				(cArm sel_156: 0 sel_155: 8)
				(if (and (> sel_576 2) (!= local0 32767))
					(= sel_29 0)
					(= sel_136 1)
				else
					(self sel_111:)
				)
			)
		)
	)

	(method (sel_111)
		(gMouseDownHandler sel_81: self)
		(gKeyDownHandler sel_81: self)
		(if (= local0 (or (== local0 -32768) (<= sel_573 2)))
			(Print 540 17 77 {Harry} 32 cluckWindow) ; "Congratulations, Squire, thou played as a noble knight."
		else
			(Print 540 18 77 {Harry} 32 cluckWindow) ; "Perhaps thou would be better suited for grubbing out the stable."
		)
		(super sel_111: &rest)
	)

	(method (sel_133 param1 &tmp temp0 temp1 [temp2 3])
		(if (param1 sel_73:)
			(return)
		)
		(if
			(and
				(or (== sel_29 2) (== sel_29 7))
				(!= (param1 sel_31:) 16384)
				(not (param1 sel_61:))
				(&
					(= temp0 (OnControl CONTROL (param1 sel_1:) (param1 sel_0:)))
					$eeee
				)
				(== (gTheIconBar sel_214:) (gTheIconBar sel_64: 2))
			)
			(param1 sel_73: 1)
			(= temp1 -1)
			(while (and (not (& temp0 $0001)) (< temp1 16))
				(++ temp1)
				(>>= temp0 $0001)
			)
			(= temp0 temp1)
			(if (AvoidPath (param1 sel_1:) (param1 sel_0:) halfBoard)
				(+= temp0 16)
			)
			(cond
				((or (< sel_568 18) (!= sel_570 -20))
					(cond
						((!= sel_571 -20)
							(cond
								((not (IsObject [local66 temp0])))
								((not ([local66 temp0] sel_4:)))
								((not (self sel_591: sel_570 sel_571 temp0)))
								(else
									(= sel_572 temp0)
									(= sel_136 1)
									(proc0_3)
								)
							)
						)
						((IsObject [local66 temp0]))
						(
							(or
								(self sel_591: sel_570 temp0 -20)
								(== temp0 sel_570)
							)
							(= [local66 temp0] sel_141)
							(sel_141
								sel_14: (| (sel_141 sel_14:) $0100)
								sel_162: 0
								sel_156: 0
							)
							(if (== temp0 sel_570)
								(= sel_570 -20)
							else
								(= sel_571 temp0)
								(= sel_136 1)
								(proc0_3)
							)
						)
						(1)
					)
				)
				((not (IsObject [local66 temp0])))
				(([local66 temp0] sel_4:))
				(else
					(= sel_570 temp0)
					(= sel_141 [local66 sel_570])
					(= [local66 sel_570] 0)
					(sel_141 sel_14: (& (sel_141 sel_14:) $feff) sel_162: Fwd)
				)
			)
		)
		(param1 sel_73:)
	)
)

(class ATo of CT
	(properties
		sel_20 {ATo}
		sel_240 -1
		sel_594 0
	)

	(method (sel_110 param1 param2 param3 param4 &tmp temp0)
		(= sel_42 param1)
		(= sel_594 param2)
		(if (>= argc 3)
			(if (IsObject param3)
				(= sel_143 param3)
			else
				(if (< (= sel_231 param3) 0)
					(while (!= (WordAt sel_594 (++ sel_240)) -1)
					)
				)
				(if (>= argc 4)
					(= sel_143 param4)
				)
			)
		)
	)

	(method (sel_57 &tmp temp0)
		(if (== (sel_42 sel_4:) (self sel_233:))
			(return)
		)
		(if (== (= temp0 (WordAt sel_594 (+= sel_240 sel_231))) -1)
			(self sel_234:)
		else
			(sel_42 sel_4: (& temp0 $00ff))
			(sel_42 sel_3: (& (>> temp0 $0008) $00ff))
		)
	)
)

(instance clickSound of Sound
	(properties
		sel_20 {clickSound}
		sel_99 1
		sel_40 533
	)
)

(instance catSound of Sound
	(properties
		sel_20 {catSound}
		sel_99 1
	)
)

(instance wannaQuit of Code
	(properties
		sel_20 {wannaQuit}
	)

	(method (sel_57)
		(switch (Print 540 13 78 {Yes} 1 78 {No} 2) ; "Are you sure you wish to leave the game?"
			(1
				(gCurRoom sel_390: 100)
			)
		)
	)
)

(instance cluckWindow of SysWindow
	(properties
		sel_20 {cluckWindow}
		sel_26 42
	)
)

