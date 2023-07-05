;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use Array)
(use Sound)
(use Motion)
(use System)

(public
	castAreaScript 0
)

(local
	local0
	local1
	local2
	local3
)

(instance castAreaScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2 (IntArray with: 2 3 0 3 0 1 2 3))
				(= local3 (IntArray with: 0 0 0 1 0 0 2 3))
				(gGlory handsOff:)
				(= local0 (gEgo loop:))
				(switch register
					(83
						(soundFX number: 940 play:)
					)
					(85
						(soundFX number: 936 play:)
					)
					(81
						(soundFX number: 942 play:)
					)
					(else
						(soundFX number: 934 play:)
					)
				)
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(= local1 (gEgo cel:))
					(gEgo view: 19 loop: (local3 at: local0))
				else
					(gEgo view: 15 loop: (local2 at: local0))
				)
				(gEgo setMotion: 0 setCycle: End self)
			)
			(1
				(if
					(and
						(== register 85)
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
						)
					)
					(if (== gCurRoomNum 580)
						(gCurRoom doVerb: 85)
					else
						((ScriptID 50) doVerb: 85) ; forest
					)
				)
				(gEgo setCycle: Beg self)
			)
			(2
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(gEgo view: 20 loop: local0 cel: local1)
				else
					(gEgo normalize: local0)
				)
				(if (and (== register 85) (== gCurRoomNum 580))
					(gCurRoom cue:)
				else
					(gGlory handsOn:)
				)
				(switch register
					(83
						(Palette 2 0 255 500) ; PalIntensity
						(Palette 2 0 255 100) ; PalIntensity
					)
					(85
						(cond
							(
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
								))
							(
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
									270
									340
									460
									545
									710
									750
									730
									632
								)
								(gCurRoom doVerb: register)
							)
							(else
								(gMessager say: 0 0 4 0 0 12) ; "A feeling of peace and tranquility fills the area."
							)
						)
					)
					(81
						(if
							(OneOf
								gCurRoomNum
								250
								270
								290
								300
								320
								340
								360
								780
								440
								480
								510
								545
								579
								580
								593
								600
								800
								720
								740
								750
								770
								730
								530
								535
								541 ; swamp1
								542 ; swamp2
								543 ; swamp3
								545
							)
							(gCurRoom doVerb: register)
						else
							(gMessager say: 0 0 1 0 0 12) ; "You sense no magic in this area."
						)
					)
					(82
						(if
							(OneOf
								gCurRoomNum
								270
								290
								340
								440
								460
								520
								580
								593
								600
								641
								643
								650
								750
								800
							)
							(gCurRoom doVerb: register)
						else
							(gMessager say: 0 0 2 0 0 12) ; "Nothing seems to have been triggered."
						)
					)
				)
				(= register 0)
				(local2 dispose:)
				(local3 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soundFX of Sound
	(properties)
)

