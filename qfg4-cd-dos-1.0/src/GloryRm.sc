;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
(include sci.sh)
(use Main)
(use Game)
(use System)

(class GloryRm of Room
	(properties
		style 0
		feaList 0
		exitList 0
		topX -1
		leftY -1
		bottomX -1
		rightY -1
	)

	(method (addPoly param1 &tmp temp0)
		(if (not feaList)
			(= feaList (List new:))
		)
		(for ((= temp0 0)) (< temp0 argc) ((+= temp0 2))
			(feaList
				add:
					((pObject new:)
						showSelf: [param1 temp0] [param1 (+ temp0 1)]
						yourself:
					)
			)
		)
	)

	(method (leaveRoom))

	(method (doTorch))

	(method (doVerb theVerb)
		(if (not (gTalkers size:))
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(gEgo noun: 2)
		(if obstacles
			(obstacles dispose:)
			(= obstacles 0)
		)
		(if feaList
			(feaList dispose:)
			(= feaList 0)
		)
		(if exitList
			(exitList dispose:)
			(= exitList 0)
		)
		(if (!= plane gThePlane)
			(plane dispose:)
			(= plane 0)
		)
		(gRegions delete: self)
		(if script
			(script dispose:)
		)
		(if timer
			(timer dispose: delete:)
		)
		(gSounds eachElementDo: #clean self)
		(DisposeScript number)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (init param1)
		(if
			(and
				(OneOf
					gCurRoomNum
					551
					552
					553
					554
					555
					556
					557
					558
					559
					560
					561
					562
					563
					564
					565
					566
					567
					568
					569
					570
					571
					572
					573
					574
					575
					576
					577
					578
					579
					580
					581
					582
					583
					584
					585
					586
					587
					588
					589
					590
					591
					592
					593
					250
					260
					270
					280
					290
					300
					440
					460
					480
					500
					520
					600
					790
					800
					810 ; combat
				)
				(< 2700 gClock 2801)
			)
			(PalVary 9 (+ (gCurRoom picture:) 1)) ; PalVaryMergeSource
		)
		(proc0_16)
		(proc0_13)
		(if
			(not
				(OneOf
					gCurRoomNum
					551
					552
					553
					554
					555
					556
					557
					558
					559
					560
					561
					562
					563
					564
					565
					566
					567
					568
					569
					570
					571
					572
					573
					574
					575
					576
					577
					578
					579
					580
					581
					582
					583
					584
					585
					586
					587
					588
					589
					590
					591
					592
					593
					810 ; combat
					720
					800
					632
				)
			)
			(= global470 (= gCombatMonsterNum (= global366 0)))
			(= global462 (= global463 (= global464 0)))
		)
		(= number gCurRoomNum)
		(= gPerspective picAngle)
		(if (not plane)
			(= plane gThePlane)
		)
		(self drawPic: picture style)
		(if (and argc param1)
			(Palette 2 0 255 100) ; PalIntensity
		)
		(RemapColors 2 254 50) ; ByPercent
	)
)

(class pObject of Obj
	(properties
		polyID 0
		intensity 50
		linted 0
	)

	(method (showSelf param1 param2)
		(= polyID param1)
		(= intensity param2)
		(= linted 0)
		(gTheDoits add: self)
	)

	(method (dispose)
		(polyID dispose:)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(cond
			((polyID onMe: (gEgo x:) (gEgo y:))
				(if (not linted)
					(= linted 1)
					(Palette 2 66 85 intensity) ; PalIntensity
				)
			)
			(linted
				(= linted 0)
				(Palette 2 66 85 100) ; PalIntensity
			)
		)
	)
)

