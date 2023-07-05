;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 91)
(include sci.sh)
(use Main)
(use n011)
(use Plane)
(use Array)
(use Print)
(use Inset)
(use Sound)
(use Actor)
(use System)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	[local12 6] = [0 6 12 18 22 28]
	local18 = -999
)

(procedure (localproc_0 param1 param2)
	(if (> (local5 size:) param1)
		(return (== ((local5 at: param1) BAD_SELECTOR:) param2))
	)
	(return 0)
)

(class Walkman of Inset
	(properties
		picture 13087
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 32
		BAD_SELECTOR 30
		BAD_SELECTOR 74
		BAD_SELECTOR 131
		BAD_SELECTOR 65
		BAD_SELECTOR 131
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
	)

	(method (BAD_SELECTOR param1 param2 param3 &tmp temp0)
		(if (== BAD_SELECTOR local2)
			(if (not BAD_SELECTOR)
				(gMessager say: 0 0 11 0 self 91) ; "(TAPE RECORDER CONT'D, OVERRUN SPLICE TAPE AREA)It's gettin' a bit long-winded. I need to keep it short and sweet."
				(= BAD_SELECTOR (= BAD_SELECTOR 1))
			)
		else
			(if BAD_SELECTOR
				(= BAD_SELECTOR
					(+ ((local5 at: (- BAD_SELECTOR 1)) nsRight:) 8)
				)
			else
				(= BAD_SELECTOR 60)
			)
			(= temp0
				(spliceItem new: BAD_SELECTOR BAD_SELECTOR param1 param2 param3)
			)
			(++ BAD_SELECTOR)
			(if (> (temp0 nsRight:) 570)
				(if (!= BAD_SELECTOR 380)
					(self BAD_SELECTOR:)
					(return)
				else
					(= BAD_SELECTOR 60)
					(+= BAD_SELECTOR 20)
					(temp0 x: BAD_SELECTOR y: BAD_SELECTOR)
					(UpdateScreenItem temp0)
					(SetNowSeen temp0)
				)
			)
			(if
				(and
					(== (temp0 BAD_SELECTOR:) (- BAD_SELECTOR 1))
					(or
						(== local18 (- BAD_SELECTOR 2))
						(< (- BAD_SELECTOR 2) 0)
					)
				)
				(= local18 (- BAD_SELECTOR 1))
			)
		)
	)

	(method (BAD_SELECTOR)
		(cond
			(BAD_SELECTOR
				(if (== (- BAD_SELECTOR 1) local18)
					(if (not BAD_SELECTOR)
						(gMessager say: 0 0 31 2 self 91) ; "(TAPE RECORDER, TRY TO BACK UP OVER GOOD PART OF MSG)I like THAT part. I don't want to erase it."
						(= BAD_SELECTOR (= BAD_SELECTOR 1))
					)
				else
					((local5 at: (- BAD_SELECTOR 1)) dispose:)
					(-- BAD_SELECTOR)
					(if BAD_SELECTOR
						(= BAD_SELECTOR ((local5 at: (- BAD_SELECTOR 1)) x:))
						(= BAD_SELECTOR ((local5 at: (- BAD_SELECTOR 1)) y:))
					)
				)
			)
			((not BAD_SELECTOR)
				(gMessager say: 0 0 12 0 self 91) ; "(TAPE RECORDER CONT'D--TRY TO BACK UP SPLICE TAPE WHEN TAPE IS EMPTY)I don't have anythin' loaded YET."
				(= BAD_SELECTOR (= BAD_SELECTOR 1))
			)
		)
	)

	(method (BAD_SELECTOR)
		(local3 eachElementDo: #hide)
		(= BAD_SELECTOR 0)
		(= BAD_SELECTOR 60)
		(= BAD_SELECTOR 380)
		(advanceSpliceText init:)
		(backSpliceText init:)
		(deleteSpliceItems init:)
		(transfer init:)
		(spliceExit init:)
		(hintButton init:)
		(if (not BAD_SELECTOR)
			(= BAD_SELECTOR
				(IDArray
					with:
						(switch (gGame printLang:)
							(351
								(IntArray
									with:
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										1
										-1
										-1
										-1
										4
										5
										6
										-1
										8
										4
										5
										-1
										-1
								)
							)
							(39
								(IntArray
									with:
										-1
										-1
										-1
										-1
										-1
										-1
										7
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										1
										2
										3
										4
										-1
										2
										3
										-1
										-1
										-1
										-1
										-1
										-1
								)
							)
							(else
								(IntArray
									with:
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										1
										2
										3
										4
										1
										2
										-1
										-1
										-1
										-1
								)
							)
						)
						(switch (gGame printLang:)
							(351
								(IntArray
									with:
										-1
										-1
										3
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										2
										3
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										11
										-1
								)
							)
							(39
								(IntArray
									with:
										-1
										1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										8
										-1
								)
							)
							(else
								(IntArray
									with:
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
								)
							)
						)
						(switch (gGame printLang:)
							(351
								(IntArray
									with:
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										15
										-1
										1
										-1
										7
										-1
										-1
										0
										-1
								)
							)
							(39
								(IntArray
									with:
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										0
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										5
										6
										7
										8
										9
										-1
										-1
								)
							)
							(else
								(IntArray
									with:
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										11
										-1
										-1
										-1
										-1
										-1
										-1
										0
										-1
										-1
										5
										6
										7
										8
										-1
										-1
								)
							)
						)
						(switch (gGame printLang:)
							(351
								(IntArray
									with:
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										9
										10
										11
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
								)
							)
							(39
								(IntArray
									with:
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
								)
							)
							(else
								(IntArray
									with:
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										8
										-1
										-1
										-1
								)
							)
						)
						(switch (gGame printLang:)
							(351
								(IntArray
									with:
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										11
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
								)
							)
							(39
								(IntArray
									with:
										-1
										-1
										-1
										-1
										-1
										8
										-1
										1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										5
										-1
								)
							)
							(else
								(IntArray
									with:
										-1
										-1
										-1
										-1
										-1
										-1
										7
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
								)
							)
						)
						(switch (gGame printLang:)
							(351
								(IntArray
									with:
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										12
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										2
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										13
										14
										-1
								)
							)
							(39
								(IntArray
									with:
										-1
										1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										10
										11
								)
							)
							(else
								(IntArray
									with:
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										8
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										9
										10
								)
							)
						)
				)
			)
		)
		(if (not local6)
			(= local6 (Cast new:))
			(plane addCast: local6)
		)
		(if (not local5)
			(= local5 (Cast new:))
			(plane addCast: local5)
		)
		(= picture 13089)
		(plane drawPic: picture)
		(self BAD_SELECTOR: (= local11 0))
	)

	(method (BAD_SELECTOR param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(cond
			((>= param1 6)
				(= local11 0)
			)
			((< param1 0)
				(= local11 5)
			)
			(else
				(= local11 param1)
			)
		)
		(local6 eachElementDo: #dispose)
		(= BAD_SELECTOR 65)
		(= BAD_SELECTOR 131)
		(= temp0 (BAD_SELECTOR at: local11))
		(= temp3 [local12 local11])
		(= temp4 0)
		(for ((= temp2 0)) (< temp2 (temp0 size:)) ((++ temp2))
			(= temp1
				(spliceText
					new: BAD_SELECTOR BAD_SELECTOR temp3 temp4 (temp0 at: temp2)
				)
			)
			(if (> (++ temp4) (temp1 lastCel:))
				(= BAD_SELECTOR 65)
				(+= BAD_SELECTOR 20)
				(= temp4 0)
				(+= temp3 2)
			else
				(= BAD_SELECTOR (+ (temp1 nsRight:) 8))
			)
		)
	)

	(method (init)
		(if (== (gGame printLang:) 39)
			(= local2 12)
			(= [local12 3] 22)
			(= [local12 4] 28)
			(= [local12 5] 34)
		else
			(= local2 11)
			(= [local12 4] 22)
			(= [local12 5] 28)
		)
		(gGame handsOff:)
		(= plane (Plane new:))
		(plane setRect: 0 0 640 480)
		(= x (- 0 ((gCurRoom plane:) left:)))
		(= y (- 0 ((gCurRoom plane:) top:)))
		(super init: &rest)
		(if (gUser BAD_SELECTOR:)
			(= BAD_SELECTOR ((gUser BAD_SELECTOR:) BAD_SELECTOR:))
			((gUser BAD_SELECTOR:) BAD_SELECTOR: (Set new:))
		)
		(if (not gPanels)
			(= gPanels (List new:))
		)
		(Load rsVIEW 13088 13087 9940)
		(Load rsPIC 13088 13087)
		(gPanels addToFront: self)
		(self BAD_SELECTOR:)
	)

	(method (BAD_SELECTOR &tmp temp0 temp1 temp2)
		(cond
			((== picture 13089)
				(if (and local5 (local5 size:))
					(local5 eachElementDo: #dispose)
				)
				(if (and local6 (local6 size:))
					(local6 eachElementDo: #dispose)
				)
				(advanceSpliceText dispose:)
				(backSpliceText dispose:)
				(deleteSpliceItems dispose:)
				(transfer dispose:)
				(spliceExit dispose:)
			)
			((and local4 (local4 size:))
				(local4 eachElementDo: #dispose)
			)
		)
		(= picture 13087)
		(plane drawPic: picture)
		(messageSound stop:)
		(if (not BAD_SELECTOR)
			(= BAD_SELECTOR
				(IDArray
					with:
						(IntArray
							with:
								(IsFlag 101)
								(IsFlag 102)
								(IsFlag 104)
								(IsFlag 105)
								(IsFlag 106)
								(IsFlag 107)
								(IsFlag 108)
								(IsFlag 103)
						)
						(IntArray
							with:
								(IsFlag 109)
								(IsFlag 110)
								(IsFlag 111)
								(IsFlag 112)
								(IsFlag 113)
								(IsFlag 114)
								(IsFlag 116)
								(IsFlag 115)
								(IsFlag 241)
								(IsFlag 242)
								(IsFlag 243)
								(IsFlag 245)
								(IsFlag 321)
								(IsFlag 322)
						)
						(IntArray
							with:
								(IsFlag 117)
								(IsFlag 118)
								(IsFlag 119)
								(IsFlag 120)
								(IsFlag 121)
								(IsFlag 123)
								(IsFlag 124)
								(IsFlag 125)
								(IsFlag 126)
						)
						(IntArray
							with:
								(or
									(IsFlag 201)
									(IsFlag 204)
									(IsFlag 208)
									(IsFlag 205)
								)
								(IsFlag 204)
								(IsFlag 208)
								(IsFlag 205)
								(IsFlag 202)
								(IsFlag 206)
								(IsFlag 207)
								(IsFlag 209)
								(IsFlag 210)
								(IsFlag 211)
								(IsFlag 212)
								(IsFlag 213)
						)
						(IntArray
							with:
								(IsFlag 214)
								(or
									(IsFlag 358)
									(IsFlag 228)
									(IsFlag 25)
									(IsFlag 215)
									(IsFlag 220)
									(IsFlag 221)
									(IsFlag 222)
								)
								(IsFlag 228)
								(IsFlag 25)
								(IsFlag 215)
								(IsFlag 220)
								(IsFlag 221)
								(IsFlag 222)
								(IsFlag 217)
								(IsFlag 224)
								(IsFlag 225)
								(IsFlag 226)
								(IsFlag 227)
								(IsFlag 218)
								(IsFlag 219)
								(IsFlag 354)
								(IsFlag 355)
								(IsFlag 356)
								(IsFlag 357)
						)
						(IntArray
							with:
								(or
									(IsFlag 234)
									(IsFlag 236)
									(IsFlag 237)
									(IsFlag 239)
									(IsFlag 238)
									(IsFlag 235)
								)
								(IsFlag 236)
								(IsFlag 237)
								(IsFlag 239)
								(IsFlag 238)
								(IsFlag 235)
								(IsFlag 240)
						)
						(IntArray
							with:
								(IsFlag 246)
								(IsFlag 247)
								(IsFlag 248)
								(IsFlag 249)
								(IsFlag 250)
								(IsFlag 251)
								(IsFlag 252)
								(IsFlag 253)
						)
						(IntArray
							with:
								(IsFlag 254)
								(IsFlag 255)
								(IsFlag 256)
								(IsFlag 257)
								(IsFlag 258)
								(IsFlag 259)
								(IsFlag 260)
								(IsFlag 261)
								(IsFlag 262)
						)
						(IntArray
							with:
								(IsFlag 329)
								(IsFlag 330)
								(IsFlag 331)
								(IsFlag 332)
								(IsFlag 333)
								(IsFlag 334)
								(IsFlag 335)
						)
						(IntArray
							with:
								(IsFlag 323)
								(IsFlag 324)
								(IsFlag 325)
								(IsFlag 326)
								(IsFlag 327)
								(IsFlag 328)
						)
						(IntArray
							with:
								(IsFlag 342)
								(IsFlag 344)
								(IsFlag 346)
								(IsFlag 347)
								(IsFlag 348)
								(IsFlag 349)
								(IsFlag 345)
								(IsFlag 350)
						)
				)
			)
			(if 0
				(SetFlag 117)
				(SetFlag 118)
				(SetFlag 119)
				(SetFlag 120)
				(SetFlag 121)
				(SetFlag 123)
				(SetFlag 124)
				(SetFlag 125)
				(SetFlag 126)
				(for ((= temp0 0)) (< temp0 (BAD_SELECTOR size:)) ((++ temp0))
					(= temp2 (BAD_SELECTOR at: temp0))
					(for ((= temp1 0)) (< temp1 (temp2 size:)) ((++ temp1))
						(temp2 at: temp1 1)
					)
				)
			)
		)
		(if (not BAD_SELECTOR)
			(= BAD_SELECTOR
				(IDArray
					with:
						(IntArray with: 340 350 360 370 380 390 400 410)
						(IntArray
							with:
								740
								750
								760
								780
								790
								800
								840
								810
								2460
								2470
								2480
								2490
								5580
								5590
						)
						(IntArray with: 500 510 520 530 540 550 560 570 580)
						(IntArray
							with:
								-1
								3980
								3990
								4010
								4020
								4040
								4050
								4060
								4070
								4080
								4090
								4100
						)
						(IntArray
							with:
								3500
								-1
								3630
								3640
								3510
								3520
								3530
								3550
								-1
								3570
								3590
								3600
								3610
								3660
								3670
								5730
								5740
								5750
								5760
						)
						(IntArray with: 2640 2650 2660 2670 2680 2690 2700)
						(IntArray with: 2800 2810 2820 2830 2850 2860 2870 2880)
						(IntArray
							with: 2920 2930 2950 2970 3010 2980 2990 3000 3040
						)
						(IntArray with: 6140 6150 6160 6170 6200 6210 6220)
						(IntArray with: 5940 5950 5970 5980 5990 6000)
						(IntArray with: 6560 6570 6580 6590 6600 6610 6640 6650)
				)
			)
		)
		(if (or (not local3) (not (local3 size:)))
			(= BAD_SELECTOR 32)
			(= BAD_SELECTOR 30)
			(if (and local4 (local4 size:))
				(local4 eachElementDo: #dispose)
			)
			(if (not local3)
				(= local3 (Cast new:))
				(plane addCast: local3)
			)
			(for ((= temp0 0)) (< temp0 (BAD_SELECTOR size:)) ((++ temp0))
				(= temp2 (BAD_SELECTOR at: temp0))
				(for ((= temp1 0)) (< temp1 (temp2 size:)) ((++ temp1))
					(if (temp2 at: temp1)
						(self BAD_SELECTOR: temp0)
						(break)
					)
				)
			)
			(for ((= temp0 (local3 size:))) (< temp0 12) ((++ temp0))
				(self BAD_SELECTOR: -1)
			)
			(loadA init:)
			(playTape init:)
			(loadB init:)
			(spliceTape init:)
			(tapeExit init:)
			(gGame handsOn:)
		else
			(local3 eachElementDo: #show)
		)
	)

	(method (BAD_SELECTOR param1)
		(tapeButton new: param1 BAD_SELECTOR BAD_SELECTOR)
		(+= BAD_SELECTOR 164)
		(if (> BAD_SELECTOR 500)
			(= BAD_SELECTOR 32)
			(+= BAD_SELECTOR 108)
		)
	)

	(method (handleEvent event)
		(event localize: plane)
		(if (not (event type:))
			(if (gUser BAD_SELECTOR:)
				((gUser BAD_SELECTOR:) handleEvent: event)
			)
			(if (and (== picture 13089) local6)
				(local6 handleEvent: event)
			)
			(event claimed: 1)
			(return)
		)
		(if (& (event type:) $000a) ; evKEYUP | evMOUSERELEASE
			(event claimed: 1)
			(return)
		)
		(event type: (| (event type:) evVERB))
		(if plane
			(event
				claimed: ((plane casts:) eachElementDo: #handleEvent event)
			)
		)
		(if (not (event claimed:))
			(gFeatures handleEvent: event)
		)
		(if local7
			(messageSound stop:)
			(= local7 0)
			(gCurRoom setInset: 0)
		)
		(event claimed: 1)
	)

	(method (drawInset)
		(if (!= picture -1)
			(plane drawPic: picture)
		)
		(plane posn: x y priority: (+ (GetHighPlanePri) 1))
		(UpdatePlane plane)
	)

	(method (BAD_SELECTOR param1 &tmp temp0 temp1 temp2)
		(local3 eachElementDo: #hide)
		(= picture 13088)
		(plane drawPic: picture)
		(= BAD_SELECTOR 74)
		(= BAD_SELECTOR 131)
		(if (not local4)
			(= local4 (Cast new:))
			(plane addCast: local4)
		)
		(backup init:)
		(stopPlayback init:)
		(topicExit init:)
		(topicHeader init: param1)
		(= temp1 (BAD_SELECTOR at: param1))
		(= temp2 (temp1 size:))
		(for ((= temp0 0)) (< temp0 temp2) ((++ temp0))
			(if (temp1 at: temp0)
				(self BAD_SELECTOR: param1 temp0)
			)
		)
	)

	(method (cue)
		(if BAD_SELECTOR
			(= BAD_SELECTOR 1)
			(= BAD_SELECTOR 0)
		else
			(self BAD_SELECTOR: BAD_SELECTOR)
		)
	)

	(method (BAD_SELECTOR param1 param2)
		(topicButton new: param1 param2 BAD_SELECTOR BAD_SELECTOR)
		(+= BAD_SELECTOR 20)
		(if (> BAD_SELECTOR 350)
			(= BAD_SELECTOR 131)
			(+= BAD_SELECTOR 200)
		)
	)

	(method (dispose &tmp temp0)
		(messageSound stop:)
		(if BAD_SELECTOR
			(((gUser BAD_SELECTOR:) BAD_SELECTOR:) release: dispose:)
			((gUser BAD_SELECTOR:) BAD_SELECTOR: BAD_SELECTOR)
			(= BAD_SELECTOR 0)
		)
		(if BAD_SELECTOR
			(for ((= temp0 0)) (< temp0 (BAD_SELECTOR size:)) ((++ temp0))
				((BAD_SELECTOR at: temp0) dispose:)
			)
			(BAD_SELECTOR dispose:)
			(= BAD_SELECTOR 0)
		)
		(if BAD_SELECTOR
			(for ((= temp0 0)) (< temp0 (BAD_SELECTOR size:)) ((++ temp0))
				((BAD_SELECTOR at: temp0) dispose:)
			)
			(BAD_SELECTOR dispose:)
			(= BAD_SELECTOR 0)
		)
		(if BAD_SELECTOR
			(for ((= temp0 0)) (< temp0 (BAD_SELECTOR size:)) ((++ temp0))
				((BAD_SELECTOR at: temp0) dispose:)
			)
			(BAD_SELECTOR dispose:)
			(= BAD_SELECTOR 0)
		)
		(gPanels delete: self)
		(super dispose: &rest)
		(= local7 0)
		(= local8 0)
		(= local9 0)
		(= local10 0)
		(= local6 0)
		(= local5 0)
		(= local4 0)
		(= local3 0)
		(if global249
			(Palette 1 global249) ; PalLoad
		)
	)

	(method (BAD_SELECTOR param1 param2 &tmp temp0)
		(= BAD_SELECTOR param1)
		(messageSound stop:)
		(= temp0 ((BAD_SELECTOR at: param1) at: param2))
		(gMessager sayRange: (proc11_20 temp0) 0 0 1 25 0 (proc11_19 temp0))
		(return 1)
	)
)

(instance messageSound of Sound
	(properties)

	(method (stop)
		(super stop: &rest)
		(if gMessager
			(gMessager dispose:)
		)
	)

	(method (play)
		(if (not (ResCheck 140 number)) ; WAVE
			(Prints {DEBUG! That message wave file does not exist!})
			(return)
		)
		(super play: &rest)
	)
)

(class topicButton of View
	(properties
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
	)

	(method (new param1 param2 param3 param4 &tmp temp0 temp1)
		(= temp0 (super new:))
		(if (>= param2 (((Walkman BAD_SELECTOR:) at: param1) size:))
			(= temp1 -1)
		else
			(= temp1 (((Walkman BAD_SELECTOR:) at: param1) at: param2))
		)
		(temp0
			view: 13087
			loop: param1
			cel: (+ param2 1)
			BAD_SELECTOR: param1
			BAD_SELECTOR: param2
			BAD_SELECTOR: temp1
			x: param3
			y: param4
			init: local4
			signal: (& (temp0 signal:) $efff)
		)
	)

	(method (handleEvent event)
		(if (and (not (event claimed:)) (self onMe: event))
			(super handleEvent: event)
			(event claimed: 1)
			(return)
		else
			(return 0)
		)
	)

	(method (doVerb)
		(Walkman BAD_SELECTOR: BAD_SELECTOR BAD_SELECTOR)
	)

	(method (dispose)
		(local4 delete: self)
		(super dispose:)
	)

	(method (onMe)
		(if (!= BAD_SELECTOR -1)
			(return (super onMe: &rest))
		else
			(return 0)
		)
	)
)

(class tapeButton of View
	(properties
		BAD_SELECTOR 0
	)

	(method (onMe param1)
		(if
			(and
				(!= local9 self)
				(!= local10 self)
				(self isNotHidden:)
				(<= (param1 x:) (+ x 150))
				(<= (param1 y:) (+ y 100))
				(>= (param1 x:) x)
				(>= (param1 y:) y)
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (new param1 param2 param3 &tmp temp0)
		(= temp0 (super new:))
		(if (< param1 0)
			(temp0
				view: 13086
				loop: 3
				cel: 0
				BAD_SELECTOR: param1
				x: param2
				y: param3
				init: local3
			)
		else
			(temp0
				view: 13086
				cel: param1
				BAD_SELECTOR: param1
				x: param2
				y: param3
				init: local3
			)
		)
	)

	(method (handleEvent event)
		(if (and (not (event claimed:)) (self onMe: event))
			(super handleEvent: event)
			(event claimed: 1)
			(return)
		else
			(return 0)
		)
	)

	(method (doVerb)
		(= local8 self)
		(tapeHilite init: self)
	)

	(method (dispose)
		(local3 delete: self)
		(super dispose:)
	)
)

(class spliceText of View
	(properties
		BAD_SELECTOR -1
		BAD_SELECTOR 0
	)

	(method (handleEvent event)
		(cond
			((event type:)
				(super handleEvent: event &rest)
				(return)
			)
			((self onMe: event)
				(if (not BAD_SELECTOR)
					(= BAD_SELECTOR 1)
					(++ loop)
					(UpdateScreenItem self)
				)
			)
			(BAD_SELECTOR
				(= BAD_SELECTOR 0)
				(-- loop)
				(UpdateScreenItem self)
			)
		)
	)

	(method (doVerb)
		(Walkman BAD_SELECTOR: (& loop $fffe) cel BAD_SELECTOR)
	)

	(method (new param1 param2 param3 param4 param5 &tmp temp0)
		(= temp0 (Clone self))
		(temp0
			view: 13088
			loop: param3
			cel: param4
			BAD_SELECTOR: param5
			x: param1
			y: param2
			init: local6
			signal: (& (temp0 signal:) $efff)
		)
		(return temp0)
	)

	(method (dispose)
		(local6 delete: self)
		(super dispose:)
	)
)

(instance spliceItem of spliceText
	(properties)

	(method (new param1 param2 param3 param4 param5 &tmp temp0)
		(= temp0 (Clone self))
		(temp0
			view: 13088
			loop: param3
			cel: param4
			BAD_SELECTOR: param5
			x: param1
			y: param2
			init: local5
		)
		(return temp0)
	)

	(method (onMe)
		(return 0)
	)

	(method (handleEvent)
		(return 0)
	)

	(method (dispose)
		(local5 delete: self)
		(super dispose:)
	)
)

(instance transfer of Prop
	(properties
		x 285
		y 322
		view 13088
		loop 44
		cel 2
	)

	(method (cue)
		(if local1
			(= local1 0)
		)
		(if local0
			(Walkman BAD_SELECTOR:)
		)
	)

	(method (doVerb &tmp temp0)
		(cond
			((== (local5 size:) local2)
				(= local0 1)
				(for ((= temp0 0)) (< temp0 local2) ((++ temp0))
					(if (!= temp0 ((local5 at: temp0) BAD_SELECTOR:))
						(= local0 0)
					)
				)
				(cond
					(local0
						(hintButton dispose:)
						(gGame changeScore: 864)
						(gEgo get: 15) ; invSpliceTape
						(if (not local1)
							(= local1 1)
							(messageSound number: 50000 setLoop: 1 play: self)
						)
					)
					((not local1)
						(gMessager say: 0 0 13 0 self 91) ; "(TAPE RECORDER, TRY TO TRANSFER WRONG MSG, DRY)I DON'T think that's what I need."
						(= local1 1)
					)
				)
			)
			((not local1)
				(gMessager say: 0 0 13 0 self 91) ; "(TAPE RECORDER, TRY TO TRANSFER WRONG MSG, DRY)I DON'T think that's what I need."
				(= local1 1)
			)
		)
	)
)

(instance spliceExit of View
	(properties
		x 405
		y 323
		view 13088
		loop 44
		cel 3
	)

	(method (doVerb)
		(hintButton dispose:)
		(Walkman BAD_SELECTOR:)
	)
)

(instance deleteSpliceItems of View
	(properties
		x 187
		y 322
		view 13088
		loop 44
		cel 1
	)

	(method (doVerb)
		(Walkman BAD_SELECTOR:)
	)
)

(instance backSpliceText of View
	(properties
		x 67
		y 321
		view 13088
		loop 44
	)

	(method (doVerb)
		(Walkman BAD_SELECTOR: (- local11 1))
	)
)

(instance advanceSpliceText of View
	(properties
		x 517
		y 320
		view 13088
		loop 44
		cel 4
	)

	(method (doVerb)
		(Walkman BAD_SELECTOR: (+ local11 1))
	)
)

(instance loadA of View
	(properties
		x 559
		y 99
		view 13086
		loop 4
	)

	(method (init)
		(super init: local3)
	)

	(method (dispose)
		(local3 delete: self)
		(super dispose:)
	)

	(method (doVerb)
		(cond
			(local8
				(if (>= (local8 BAD_SELECTOR:) 0)
					(tapeHilite dispose:)
					(local8 loop: 1)
					(UpdateScreenItem local8)
					(if local9
						(local9 loop: 0 cel: (local9 BAD_SELECTOR:))
						(UpdateScreenItem local9)
					)
					(= local9 local8)
					(= local8 0)
				else
					(gMessager say: 0 0 1 0 0 91) ; "(TAPE RECORDER CONT'D)There's no point in listenin' to a blank tape."
				)
			)
			(local9
				(gMessager say: 0 0 2 0 0 91) ; "(TAPE RECORDER INTERFACE THIS AND FOLLOWING)I already have a tape loaded in deck A."
			)
			(else
				(gMessager say: 0 0 3 0 0 91) ; "(TAPE RECORDER CONT'D, HIT LOAD WITH NO TAPE SELECTED)I need to pick a tape first."
			)
		)
	)
)

(instance playTape of View
	(properties
		x 561
		y 169
		view 13086
		loop 4
		cel 1
	)

	(method (init)
		(super init: local3)
	)

	(method (dispose)
		(local3 delete: self)
		(super dispose:)
	)

	(method (doVerb)
		(if local9
			(Walkman BAD_SELECTOR: (local9 BAD_SELECTOR:))
		else
			(gMessager say: 0 0 4 0 0 91) ; "(TAPE RECORDER CONT'D)I have to load a tape first."
		)
	)
)

(instance loadB of View
	(properties
		x 558
		y 239
		view 13086
		loop 4
		cel 2
	)

	(method (init)
		(super init: local3)
	)

	(method (dispose)
		(local3 delete: self)
		(super dispose:)
	)

	(method (doVerb)
		(cond
			(local10
				(gMessager say: 0 0 5 0 0 91) ; "(TAPE RECORDER CONT'D)There's already a blank tape in deck B."
			)
			(local8
				(if (>= (local8 BAD_SELECTOR:) 0)
					(gMessager say: 0 0 6 0 0 91) ; "(TAPE RECORDER CONT'D)I don't want to overwrite what's on that tape."
				else
					(tapeHilite dispose:)
					(= local10 local8)
					(local8 loop: 1)
					(local8 cel: (local8 lastCel:))
					(UpdateScreenItem local8)
					(= local8 0)
				)
			)
			(else
				(gMessager say: 0 0 3 0 0 91) ; "(TAPE RECORDER CONT'D, HIT LOAD WITH NO TAPE SELECTED)I need to pick a tape first."
			)
		)
	)
)

(instance spliceTape of View
	(properties
		x 558
		y 308
		view 13086
		loop 4
		cel 3
	)

	(method (init)
		(= local18 -999)
		(super init: local3)
	)

	(method (dispose)
		(local3 delete: self)
		(super dispose:)
	)

	(method (doVerb)
		(if local9
			(if local10
				(if (== (local9 BAD_SELECTOR:) 2)
					(cond
						((IsFlag 864)
							(gMessager say: 0 0 7 0 0 91) ; "(TAPE RECORDER CONT'D)I've done enough splicin' off Klingmann's tape."
						)
						(
							(and
								(IsFlag 117)
								(IsFlag 118)
								(IsFlag 119)
								(IsFlag 120)
								(IsFlag 121)
								(IsFlag 123)
								(IsFlag 124)
								(IsFlag 125)
								(IsFlag 126)
							)
							(if
								(not
									(OneOf
										gCurRoomNum
										210 ; farmIntRm
										220 ; farmFldRm
										2103 ; farmIntRm2
										2145 ; farmIntRm3
										2114
										2140
										2142
										2143
										2202
										2211
										2212
										2213
										2241
										2242
										2244
									)
								)
								(gMessager say: 0 0 32 0 0 91) ; "(TAPE RECORDER, TRY TO DO SPLICE ANYWHERE BUT FARM)Not a bad idea, but I should go somewhere more private first."
							else
								(Walkman BAD_SELECTOR:)
							)
						)
						(else
							(gMessager say: 0 0 14 0 0 91) ; "(TAPE RECORDER CONT'D, TRY TO MAKE KLINGMANN SPLICE BUT DON'T HAVE ALL DIALGOUE YET)There's an idea. But I don't think I have quite enough source material from Klingmann yet."
						)
					)
				else
					(gMessager say: 0 0 8 0 0 91) ; "(TAPE RECORDER CONT'D, TRY TO MAKE SPLICE OFF TAPE OTHER THAN KLINGMANN'S)I can't see any reason to make a splice off THAT tape."
				)
			else
				(gMessager say: 0 0 9 0 0 91) ; "(TAPE RECORDER CONT'D, THOUGHTFUL)If I'm gonna do a splice, I'll need TWO tapes loaded."
			)
		else
			(gMessager say: 0 0 10 0 0 91) ; "(TAPE RECORDER CONT'D, THOUGHTFUL)If I'm gonna do a splice, I'll need a source tape in deck A."
		)
	)
)

(instance tapeExit of View
	(properties
		x 556
		y 379
		view 13086
		loop 4
		cel 4
	)

	(method (init)
		(super init: local3)
	)

	(method (dispose)
		(local3 delete: self)
		(super dispose:)
	)

	(method (doVerb)
		(= local7 1)
	)
)

(instance backup of View
	(properties
		x 554
		y 140
		view 13087
		loop 11
	)

	(method (init)
		(super init: local4)
	)

	(method (dispose)
		(local4 delete: self)
		(super dispose:)
	)

	(method (doVerb)
		(Walkman BAD_SELECTOR:)
	)
)

(instance stopPlayback of View
	(properties
		x 554
		y 215
		view 13087
		loop 11
		cel 1
	)

	(method (init)
		(super init: local4)
	)

	(method (dispose)
		(local4 delete: self)
		(super dispose:)
	)

	(method (doVerb)
		(messageSound stop:)
	)
)

(instance topicExit of View
	(properties
		x 556
		y 280
		view 13087
		loop 11
		cel 2
	)

	(method (init)
		(super init: local4)
	)

	(method (dispose)
		(local4 delete: self)
		(super dispose:)
	)

	(method (doVerb)
		(= local7 1)
	)
)

(instance tapeHilite of View
	(properties
		view 13086
		loop 2
	)

	(method (init param1)
		(self x: (param1 x:) y: (+ (param1 y:) 1))
		(if (local3 contains: self)
			(UpdateScreenItem self)
		else
			(super init: local3)
		)
	)

	(method (onMe)
		(return 0)
	)

	(method (dispose)
		(local3 delete: self)
		(super dispose:)
	)
)

(instance topicHeader of View
	(properties
		x 45
		y 87
		view 13087
	)

	(method (init param1)
		(= loop param1)
		(super init: local4)
	)

	(method (onMe)
		(return 0)
	)
)

(instance hintButton of Prop
	(properties
		x 258
		y 40
		view 13071
		loop 47
	)

	(method (cue)
		(if local1
			(= local1 0)
		)
		(super cue: &rest)
	)

	(method (doVerb)
		(cond
			((not (local5 size:))
				(if (not local1)
					(= local1 1)
					(gMessager say: 0 0 15 0 self 91) ; "(SPLICE TAPE HINTS)First things first--I need to address my audience."
				)
			)
			((< local18 0)
				(if (not local1)
					(= local1 1)
					(cond
						((localproc_0 0 3)
							(gMessager say: 0 0 16 0 self 91) ; "(SPLICE TAPE HINTS)I don't think Klingmann would believe a splice message from himself."
						)
						((localproc_0 0 10)
							(gMessager say: 0 0 17 0 self 91) ; "(SPLICE TAPE HINTS)I'm not sendin' the splice to myself."
						)
						((localproc_0 0 11)
							(gMessager say: 0 0 18 0 self 91) ; "(SPLICE TAPE HINTS)I'm not sure who GREG is. I wouldn't know how to get in touch with him if I did."
						)
						(else
							(gMessager say: 0 0 15 0 self 91) ; "(SPLICE TAPE HINTS)First things first--I need to address my audience."
						)
					)
				)
			)
			((< local18 4)
				(if (not local1)
					(= local1 1)
					(cond
						(
							(and
								(not (localproc_0 1 3))
								(not (localproc_0 2 3))
								(not (localproc_0 3 3))
								(not (localproc_0 4 3))
							)
							(gMessager say: 0 0 19 0 self 91) ; "(SPLICE TAPE HINTS, SLY)I think I'll need to voice some authority here."
						)
						(
							(or
								(localproc_0 1 10)
								(localproc_0 2 10)
								(localproc_0 3 10)
								(localproc_0 4 10)
							)
							(gMessager say: 0 0 20 0 self 91) ; "(SPLICE TAPE HINTS, SLY)*I* have much authority at the zoo. I'll have to try somethin' else."
						)
						(
							(or
								(== local18 3)
								(and
									(localproc_0 2 1)
									(localproc_0 3 2)
									(localproc_0 4 3)
								)
							)
							(gMessager say: 0 0 22 0 self 91) ; "(SPLICE TAPE HINTS, SLY)Close. But I need to work on the syntax."
						)
						(
							(or
								(and (localproc_0 1 2) (localproc_0 2 3))
								(and (localproc_0 2 2) (localproc_0 3 3))
								(and (localproc_0 3 2) (localproc_0 4 3))
								(and
									(localproc_0 1 3)
									(localproc_0 2 3)
									(localproc_0 3 3)
									(localproc_0 4 3)
								)
							)
							(gMessager say: 0 0 21 0 self 91) ; "(SPLICE TAPE HINTS, SLY)It's gettin' there, but the man IS a bit uptight about formal address."
						)
						(else
							(gMessager say: 0 0 19 0 self 91) ; "(SPLICE TAPE HINTS, SLY)I think I'll need to voice some authority here."
						)
					)
				)
			)
			((< local18 7)
				(if (not local1)
					(= local1 1)
					(cond
						(
							(and
								(not (localproc_0 5 7))
								(not (localproc_0 6 7))
								(not (localproc_0 7 7))
							)
							(gMessager say: 0 0 24 0 self 91) ; "(SPLICE TAPE HINTS, SLY)Now it's time to shoot for the grand prize."
						)
						(
							(and
								(or
									(localproc_0 5 7)
									(localproc_0 6 7)
									(localproc_0 7 7)
								)
								(not (localproc_0 5 5))
								(not (localproc_0 6 5))
								(not (localproc_0 7 5))
							)
							(gMessager say: 0 0 25 0 self 91) ; "(SPLICE TAPE HINTS)That's a start, but I need to be more specific about what I want."
						)
						(
							(and
								(or
									(localproc_0 5 7)
									(localproc_0 6 7)
									(localproc_0 7 7)
								)
								(or
									(localproc_0 5 5)
									(localproc_0 6 5)
									(localproc_0 7 5)
								)
							)
							(gMessager say: 0 0 26 0 self 91) ; "(SPLICE TAPE HINTS)That last part is close, but I need to reword it somehow."
						)
						(else
							(gMessager say: 0 0 24 0 self 91) ; "(SPLICE TAPE HINTS, SLY)Now it's time to shoot for the grand prize."
						)
					)
				)
			)
			((and (< local18 10) (not local1))
				(= local1 1)
				(cond
					(
						(and
							(not (localproc_0 8 10))
							(not (localproc_0 9 10))
							(not (localproc_0 10 10))
						)
						(gMessager say: 0 0 27 0 self 91) ; "(SPLICE TAPE HINTS)Okay. The only missin'is the intented recipient of this fine hospitality."
					)
					(
						(or
							(localproc_0 8 10)
							(localproc_0 9 10)
							(localproc_0 10 10)
						)
						(gMessager say: 0 0 28 0 self 91) ; "(SPLICE TAPE HINTS, SYNTAX OFF IN SPLICE MSG)It's almost there, but the wordin' leave somethin' to be desired."
					)
					(else
						(gMessager say: 0 0 27 0 self 91) ; "(SPLICE TAPE HINTS)Okay. The only missin'is the intented recipient of this fine hospitality."
					)
				)
			)
		)
	)
)

