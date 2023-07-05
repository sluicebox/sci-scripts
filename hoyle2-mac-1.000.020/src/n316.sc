;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 316)
(include sci.sh)
(use Main)
(use Interface)
(use Foundation)
(use Column)
(use WastePile)
(use Reserve)
(use WL)
(use PlayDealer)
(use CountCombinations)
(use CountPoker)
(use BowlingScoreSheet)
(use n317)
(use File)
(use User)
(use Menu)

(public
	proc316_0 0
	proc316_1 1
)

(local
	local0
)

(procedure (proc316_0 param1 param2 param3 &tmp temp0 temp1 [temp2 8] [temp10 37])
	(if (!= (= temp0 (ReadNumber (hoylesol_000 read: @temp2 4))) 999)
		(= temp1
			(if (== param1 gTheStock)
				gTheStock
			else
				((param2 new:) add: yourself:)
			)
		)
		(gMainKeyMouseList add: temp1)
		(if (!= param1 gTheStock)
			(param1 add: temp1)
		)
		(for ((= global301 0)) (< global301 38) ((++ global301))
			(= [temp10 global301] (ReadNumber (hoylesol_000 read: @temp2 4)))
		)
		(temp1
			active: 1
			x: temp0
			y: [temp10 0]
			dir: [temp10 1]
			whenEmpty: [temp10 3]
			stage: [temp10 4]
			dimRule: [temp10 5]
			fillEmptyWith: [temp10 6]
			playDealNumber: [temp10 7]
			wrap: [temp10 8]
			layoutRecieves: [temp10 9]
			playDealFaceUp: [temp10 10]
			growingDeck: [temp10 11]
			digDown: [temp10 12]
			growingStep: [temp10 13]
			numFaceDown: [temp10 14]
			buildManner: [temp10 15]
			buildDirection: [temp10 16]
			autoFaceUp: [temp10 17]
			autoFill: [temp10 18]
			theAutoFillSource1: [temp10 19]
			theAutoFillSource2: [temp10 20]
			maxCardsAllowed: [temp10 21]
			rankToBottom: [temp10 22]
			gatherForReDeal: [temp10 23]
			foundationWithin: [temp10 24]
			removeFoundationsWithin: [temp10 25]
			cel: [temp10 36]
		)
		(switch param1
			(gTheFoundations
				(temp1
					startingRank: [temp10 30]
					preRemoveRank: [temp10 31]
					preRemoveSuit: [temp10 32]
					firstPlayedStarts: [temp10 33]
					duringDealRemoveRank: [temp10 34]
					duringDealRemoveSuit: [temp10 35]
				)
				(if (proc0_6 122)
					(temp1 priority: 1)
				)
				(++ local0)
				(if (and (proc0_6 100) (<= local0 4))
					(gMainKeyMouseList delete: temp1)
				)
			)
			(gTheStock
				(temp1
					timesThruStock: [temp10 28]
					shuffleReDeals: [temp10 29]
					dir: 3
					cel: -1
					doRedeal: [temp10 2]
				)
			)
			(gTheColumns
				(temp1
					dontPlayAmongSelves: [temp10 26]
					dontFillBlanksAmongSelves: [temp10 27]
				)
				(if (proc0_6 122)
					(temp1 priority: (+ 2 (mod param3 13)))
				)
				(if (proc0_6 126)
					(temp1 priority: (+ 2 (/ param3 5)))
				)
				(= global336 [temp10 36])
				(++ global403)
				(temp1 name: {aColumn})
				(if (proc0_6 124)
					((global423 at: global426) add: temp1)
					(temp1 rowNumber: global426)
					(if (== (++ global425) global424)
						(++ global426)
						(++ global424)
						(= global425 0)
					)
				)
				(if (proc0_6 118)
					((global423 at: global426) add: temp1)
					(temp1 rowNumber: global426)
					(if (== (++ global425) 6)
						(++ global426)
						(= global425 0)
					)
				)
			)
		)
		(if (== temp1 gTheStock)
			(temp1 init: init2:)
		)
	)
)

(procedure (proc316_1 &tmp [temp0 3] temp3 temp4)
	(Load rsSOUND 35)
	(Load rsSOUND (if (>= (DoSound sndCHECK_DRIVER) 3) 100 else 212))
	(Load rsSOUND (if (>= (DoSound sndCHECK_DRIVER) 3) 41 else 41))
	(Load rsVIEW 199)
	(Load rsVIEW 13)
	(Load rsVIEW 200)
	(Load rsVIEW (+ 220 global679))
	(Load rsVIEW 0)
	(Load rsVIEW 1)
	(Load rsVIEW 2)
	(Load rsVIEW 3)
	(Load rsVIEW (+ 400 global679))
	(Load rsVIEW 100)
	(Load rsVIEW 101)
	(Load rsVIEW 102)
	(Load rsVIEW 103)
	(Load rsVIEW 196)
	(Load rsFONT 0)
	(= global638 7)
	(= global639 2)
	(KeyMouse allowance: 17)
	(= local0 0)
	(if (proc0_6 119)
		(Load rsVIEW 11)
	)
	(if (proc0_6 124)
		(Load rsSCRIPT 315)
	)
	(if (proc0_6 117)
		(Load rsSCRIPT 324)
	)
	(if (proc0_6 126)
		(= global301 CountPoker)
	)
	(if (proc0_6 127)
		(= global301 CountCombinations)
	)
	(= global301 Column)
	(= global301 WastePile)
	(= global301 Reserve)
	(= global301 Foundation)
	(if (proc0_6 122)
		(DisposeScript 305)
		(DisposeScript 307)
		(DisposeScript 303)
	)
	(if (proc0_6 118)
		(DisposeScript 303)
	)
	(= global301 PlayDealer)
	(= global324 (= global325 (= global323 (= global404 (= global413 0)))))
	(gATempList add:)
	(gTheDeck add:)
	(gTheFoundations add:)
	(gTheColumns add:)
	(gTheWastePiles add:)
	(gTheReserves add:)
	(gTheDealer add:)
	(gTheTransferList add:)
	(gTheTransferList2 add:)
	(gTheInputList add:)
	(gTheWorkingDeck add:)
	(gTheStock add:)
	(gTheDeck init:)
	(= global403 0)
	(cond
		((proc0_6 118)
			(= global412 25)
		)
		((proc0_6 122)
			(= global412 52)
		)
		((proc0_6 126)
			(= global412 25)
		)
	)
	(hoylesol_000 init: global337 open: 1 read: @global375 25)
	(gGameName text: @global375)
	(MenuBar draw:)
	(gGameName cursor: (ReadNumber (hoylesol_000 read: @temp0 3)))
	(for ((= temp3 0)) (< temp3 1) ((++ temp3))
		(proc316_0 gTheStock)
	)
	(for ((= temp3 0)) (< temp3 8) ((++ temp3))
		(proc316_0 gTheFoundations Foundation)
	)
	(if (or (proc0_6 122) (proc0_6 118))
		(DisposeScript 303)
	)
	(= global424 1)
	(= global426 (= global425 0))
	(for ((= temp3 0)) (< temp3 global412) ((++ temp3))
		(proc316_0 gTheColumns Column temp3)
	)
	(for ((= temp3 0)) (< temp3 3) ((++ temp3))
		(proc316_0 gTheWastePiles WastePile)
	)
	(if (proc0_6 122)
		(DisposeScript 305)
	)
	(for ((= temp3 0)) (< temp3 10) ((++ temp3))
		(proc316_0 gTheReserves Reserve)
	)
	(if (proc0_6 122)
		(DisposeScript 307)
	)
	(hoylesol_000 close:)
	(if (proc0_6 123)
		(proc317_0)
		(gTheFoundations eachElementDo: #init 0)
	)
	(= global317
		(if (gTheFoundations size:)
			(gTheFoundations at: 0)
		else
			0
		)
	)
	(= global335 0)
	(if
		(and
			global317
			global336
			(global317 active:)
			(not (global317 firstPlayedStarts:))
		)
		(= global335 (global317 startingRank:))
	)
	(= global303 (= global402 0))
	(= global400 (gTheFoundations doit:))
	(gGame setCursor: 999)
	(cond
		((proc0_6 100)
			(= global400 4)
			(gMainKeyMouseList delete: gTheStock)
		)
		((proc0_6 101)
			(= global400 4)
			(gTheFoundations eachElementDo: #dontBuildFoundationsYet 1)
			(gMainKeyMouseList delete: gTheStock (gTheWastePiles at: 0))
		)
		((proc0_6 102)
			(= global336 1)
		)
		((proc0_6 103)
			(= global400 4)
			(= global638 2)
			(= global639 12)
			(gMainKeyMouseList delete: gTheStock)
		)
		((proc0_6 107)
			(= global638 5)
			(= global639 5)
			(gMainKeyMouseList delete: gTheStock)
		)
		((proc0_6 110)
			(= global400 4)
		)
		((proc0_6 108)
			(= global311 0)
			(Load rsSCRIPT 318)
		)
		((proc0_6 109)
			(= global311 0)
			(Load rsSCRIPT 318)
		)
		((proc0_6 111)
			(= global638 2)
			(= global639 12)
			(gMainKeyMouseList delete: gTheStock)
		)
		((proc0_6 112)
			(gMainKeyMouseList delete: gTheStock)
		)
		((proc0_6 114)
			(gMainKeyMouseList delete: gTheStock)
		)
		((proc0_6 115)
			(= global336 0)
			(= global335 0)
			(= global638 2)
			(= global639 12)
			(gMainKeyMouseList delete: gTheStock)
		)
		((proc0_6 116)
			(gMainKeyMouseList delete: gTheStock)
		)
		((proc0_6 117)
			(= global400 -3)
			(= global311 gTheReserves)
			(gMainKeyMouseList delete: gTheStock)
		)
		((proc0_6 118)
			(gMainKeyMouseList
				delete:
					gTheStock
					(gTheWastePiles at: 0)
					(gTheReserves at: 0)
					(gTheReserves at: 1)
			)
			(= global311 0)
			((ScriptID 323 0) init:) ; theSliders
		)
		((proc0_6 119)
			(gMainKeyMouseList delete: gTheStock)
			(= global638 21)
			(= global639 2)
			(= global311 0)
			(if
				(or
					(<
						(= global422
							(Print ; "How Many Bowlers?"
								316
								0
								#button
								{1}
								1
								#button
								{2}
								2
								#button
								{3}
								3
								#button
								{4}
								4
								#button
								{5}
								5
							)
						)
						1
					)
					(> global422 5)
				)
				(= global422 1)
			)
			((= global418 (WL new:)) add:)
			(global418 name: {scoreSheets})
			(for ((= temp3 0)) (< temp3 global422) ((++ temp3))
				(global418
					add:
						((BowlingScoreSheet new:)
							view: 197
							loop: 1
							x: 160
							y: (+ 89 (* temp3 19))
							init:
							yourself:
						)
				)
				(proc0_1
					197
					4
					temp3
					149
					(+ (if temp3 89 else 78) (* temp3 19))
					8
				)
			)
			(proc0_1 197 0 0 160 78 8)
		)
		((proc0_6 120)
			(= global407 2)
			(= global311 0)
			(gMainKeyMouseList delete: gTheStock)
		)
		((proc0_6 123)
			(= global400 3)
			(= global336 1)
			(gMainKeyMouseList delete: gTheStock)
		)
		((proc0_6 122)
			(= global311 0)
			(= global400 4)
			(= global638 2)
			(= global639 12)
			(if (< global337 400)
				(gMainKeyMouseList delete: gTheStock)
			)
		)
		((proc0_6 121)
			(= global400 4)
			(Load rsSCRIPT 320)
		)
		((proc0_6 124)
			(= global407 2)
			(= global335 0)
			(= global311 0)
		)
		((proc0_6 125)
			(= global400 -12)
			(= global407 3)
			(= global311 0)
			(Load rsSCRIPT 321)
			(gMainKeyMouseList delete: gTheStock)
		)
		((proc0_6 126)
			(= global311 0)
			(gMainKeyMouseList delete: gTheStock (gTheWastePiles at: 0))
		)
		((proc0_6 127)
			(= global311 0)
			(gMainKeyMouseList delete: gTheStock (gTheWastePiles at: 0))
		)
	)
	(proc0_4)
	(DisposeScript 316)
)

(instance hoylesol_000 of gamefile_sh
	(properties
		name {hoylesol.000}
	)

	(method (init param1 &tmp [temp0 25])
		(= name (Format @temp0 316 1 param1)) ; "hoylesol.%d"
	)

	(method (doit)
		(self open: 1)
	)
)

