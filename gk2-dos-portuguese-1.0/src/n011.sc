;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Main)
(use GabeEgo)
(use n051)
(use n052)
(use n053)
(use n054)
(use n055)
(use n056)
(use Str)
(use Print)
(use Sync)
(use WalkieTalkie)
(use Actor)
(use System)

(public
	IsFlag 0
	SetFlag 1
	ClearFlag 2
	proc11_3 3
	proc11_4 4
	StopRobot 5
	PlayRobot 6
	PlayScene 7
	proc11_8 8
	proc11_9 9
	PlayVMDFile 10
	PrintDebugSceneText 11
	proc11_12 12
	proc11_13 13
	InitChapter 14
	proc11_15 15
	proc11_17 17
	proc11_18 18
	proc11_19 19
	proc11_20 20
	proc11_21 21
)

(local
	[local0 2]
	local2
	local3
	local4
	local5
	local6
	local7
)

(procedure (IsFlag param1 &tmp temp0)
	(return (& [global150 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (proc11_8 param1 &tmp temp0) ; UNUSED
	(for ((= temp0 0)) (> temp0 argc) ((++ temp0))
		(if (IsFlag [param1 temp0])
			(return 1)
		)
	)
	(return 0)
)

(procedure (proc11_9 param1 &tmp temp0) ; UNUSED
	(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
		(if (not (IsFlag [param1 temp0]))
			(return 0)
		)
	)
	(return 1)
)

(procedure (SetFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1 1))
	(|= [global150 (/ param1 16)] (>> $8000 (mod param1 16)))
	(return temp0)
)

(procedure (ClearFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(&= [global150 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	(return temp0)
)

(procedure (proc11_3 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3) ; UNUSED
	(= temp3 0)
	(if (not (> argc 3))
		(= temp1 (param2 x:))
		(= temp2 (param2 y:))
		(if (== argc 3)
			(= temp3 param3)
		)
	else
		(= temp1 param2)
		(= temp2 param3)
		(if (== argc 4)
			(= temp3 param4)
		)
	)
	(= temp0 (GetAngle (param1 x:) (param1 y:) temp1 temp2))
	(param1 setHeading: temp0 temp3)
)

(procedure (proc11_4) ; UNUSED
	(Prints {Ego's dead. What do we do now?})
)

(procedure (StopRobot param1 param2 &tmp temp0 temp1 temp2)
	(if (and argc param1)
		(= temp1 param1)
	else
		(= temp1 0)
	)
	(if (> argc 1)
		(= temp2 param2)
	else
		(= temp2 gEgo)
	)
	(WalkieTalkie killRobot: temp1 temp2)
)

(procedure (PlayRobot param1 param2 param3 param4 param5)
	(WalkieTalkie
		doRobot:
			param1
			param2
			param3
			(if (> argc 3) param4 else 0)
			0
			(if (> argc 4) param5 else -1)
			(if (> argc 5) 1 else 0)
			1
	)
)

(procedure (PlayScene param1 param2 param3 &tmp temp0)
	(if (== param1 -1)
		(return)
	)
	(gGame handsOff:)
	(if (and (== argc 3) (!= param3 -1))
		(gCast eachElementDo: #dispose)
		(gCurRoom drawPic: -1)
	else
		(gCast eachElementDo: #hide)
		(gCurRoom drawPic: -1)
	)
	(switch gChapter
		(1
			(PlayChapter1Scene param1 &rest)
		)
		(2
			(PlayChapter2Scene param1 &rest)
		)
		(3
			(PlayChapter3Scene param1 &rest)
		)
		(4
			(PlayChapter4Scene param1 &rest)
		)
		(5
			(PlayChapter5Scene param1 &rest)
		)
		(6
			(PlayChapter6Scene param1 &rest)
		)
	)
	(if (!= (gCurInvView sel_716:) 5)
		(gUser sel_712: 62)
		((gUser sel_715:) show: update:)
	)
	(if
		(and
			(gCast contains: gEgo)
			(not
				(OneOf
					gCurRoomNum
					700 ; sqRm
					400 ; marienRm
					840 ; starnSeeRm
					10102
					420 ; uberRm
					42201 ; rm4220b
					320 ; leberRm
					3210
					4020
					330 ; vgHouseRm
					10102
					300 ; labRm
					542 ; klingRm
					5211
					700 ; sqRm
					400 ; marienRm
					10102
					840 ; starnSeeRm
					1160 ; dressingRm
					1300 ; endGameRm
				)
			)
		)
		(gEgo sel_737:)
		(if (gEgo scaler:)
			((gEgo scaler:) doit:)
		)
	)
	(if (gEgo has: 73) ; invPitcher
		(gGame sel_849: 1)
		(gCurInvView select: 73 update:)
	)
	(if (and (>= argc 2) param2)
		(param2 cue:)
	)
	(if (and (== argc 3) param3)
		(if (!= param3 -1)
			(gCurRoom newRoom: param3)
		)
	else
		(gCurRoom drawPic: (gCurRoom picture:))
		(gCast eachElementDo: #show)
		(if global249
			(Palette 1 global249) ; PalLoad
		)
		(gGame handsOn: (OneOf gCurRoomNum 700 400 10102 840)) ; sqRm, marienRm, starnSeeRm
	)
)

(procedure (PrintDebugSceneText param1 param2 &tmp temp0)
	(= temp0 (Str format: {Scene: %d} param1))
	((Print new:)
		addTitle: (KString 8 (temp0 data:)) ; StrDup
		addText: param2
		mode: 1
		init:
	)
	(FrameOut)
	(temp0 dispose:)
)

(procedure (PlayVMDFile param1 &tmp temp0 temp1)
	(if (ResCheck 151 param1) ; VMD
		(if
			(or
				(gSoundManager sel_702:)
				(< (gGame detailLevel:) 5)
				(< (MemoryInfo 0) 1100)
			)
			(gSounds pause:)
			(= temp1 1)
		)
		(proc11_21 param1)
	else
		(Printf {*** %d.vmd Not Found! ***} param1)
	)
	(if temp1
		(gSoundManager sel_702: 0)
		(gSounds pause: 0)
		(gSounds eachElementDo: #check)
	)
	(while ((= temp0 (Event new: 3)) type:)
		(temp0 dispose:)
	)
	(temp0 dispose:)
)

(procedure (proc11_12 &tmp temp0)
	(for ((= temp0 100)) (> temp0 0) ((-= temp0 1))
		(Palette 2 0 255 temp0) ; PalIntensity
		(FrameOut)
	)
)

(procedure (proc11_13 &tmp temp0)
	(for ((= temp0 0)) (< temp0 100) ((+= temp0 1))
		(Palette 2 0 255 temp0) ; PalIntensity
		(FrameOut)
	)
)

(procedure (InitChapter &tmp temp0 temp1)
	(gCurRoom picture: -1)
	(if (not (OneOf gCurRoomNum 34 1 2 3)) ; demoRm, logoRm
		(proc11_12)
	)
	(gCast eachElementDo: #dispose)
	(gGame sel_858:)
	(gThePlane setRect: 9 12 630 351 priority: 202)
	(gInterfacePlane hide:)
	(gCurRoom drawPic: (+ 10 gChapter))
	((= temp1 (View new:)) view: (+ 100 gChapter) x: 120 y: 122 init:)
	(proc11_13)
	((Print new:) y: 420 addButtonBM: (+ 100 gChapter) 1 0 0 {} 0 0 init:)
	(gThePlane setRect: 12 15 627 349 priority: 1)
	(= gNumCD gChapter)
	(gUser sel_712: 62)
	(if (> gChapter 1)
		(for ((= temp0 100)) (< temp0 128) ((++ temp0))
			(SetFlag temp0)
		)
		(for ((= temp0 410)) (< temp0 449) ((++ temp0))
			(SetFlag temp0)
		)
		(SetFlag 40)
		(SetFlag 41)
		(SetFlag 42)
		(SetFlag 43)
		(if (> gChapter 2)
			(for ((= temp0 149)) (< temp0 191) ((++ temp0))
				(SetFlag temp0)
			)
			(for ((= temp0 451)) (< temp0 495) ((++ temp0))
				(SetFlag temp0)
			)
			(SetFlag 44)
			(SetFlag 45)
			(ClearFlag 46)
			(if (> gChapter 3)
				(for ((= temp0 200)) (< temp0 272) ((++ temp0))
					(SetFlag temp0)
				)
				(for ((= temp0 498)) (< temp0 552) ((++ temp0))
					(SetFlag temp0)
				)
				(SetFlag 49)
				(SetFlag 50)
				(SetFlag 51)
				(SetFlag 52)
				(SetFlag 53)
				(SetFlag 54)
				(SetFlag 55)
				(SetFlag 56)
				(if (> gChapter 4)
					(for ((= temp0 275)) (< temp0 313) ((++ temp0))
						(SetFlag temp0)
					)
					(for ((= temp0 573)) (< temp0 649) ((++ temp0))
						(SetFlag temp0)
					)
					(SetFlag 64)
					(SetFlag 65)
					(SetFlag 67)
					(if (> gChapter 5)
						(for ((= temp0 320)) (< temp0 360) ((++ temp0))
							(SetFlag temp0)
						)
						(for ((= temp0 650)) (< temp0 691) ((++ temp0))
							(SetFlag temp0)
						)
					)
				)
			)
		)
	)
	(for ((= temp0 0)) (< temp0 85) ((++ temp0))
		(GraceEgo put: temp0)
		(GabeEgo put: temp0)
	)
	(switch gChapter
		(1
			(switch (gGame printLang:)
				(351
					(gTopMessage sel_749: {Cap\a1tulo 1: Filme de Abertura})
				)
				(else
					(gTopMessage sel_749: {Chapter One: Opening Movie})
				)
			)
			(= gEgo GabeEgo)
			(gEgo get: 5 get: 0 get: 6 get: 79 get: 86) ; invTalisman, invGabeCards, invTapeRecorder, invGabeNotebook, invManuscript
			(PlayScene 2 0 -1)
			(PlayScene 4 0 2103) ; farmIntRm2
		)
		(2
			(switch (gGame printLang:)
				(351
					(gTopMessage sel_749: {Cap\a1tulo 2: Filme de Abertura})
				)
				(else
					(gTopMessage sel_749: {Chapter Two: Opening Movie})
				)
			)
			(= gEgo GraceEgo)
			(gEgo get: 17 get: 19 get: 20 get: 18) ; invBarclayCard, invGraceWallet, invGabeLetter1, invNotebookPen
			(PlayScene 117 0 140) ; srGabeRoom
		)
		(3
			(switch (gGame printLang:)
				(351
					(gTopMessage sel_749: {Cap\a1tulo 3: Filme de Abertura})
				)
				(else
					(gTopMessage sel_749: {Chapter Three: Opening Movie})
				)
			)
			(= gEgo GabeEgo)
			(gEgo
				get: 5 ; invTalisman
				get: 6 ; invTapeRecorder
				get: 15 ; invSpliceTape
				get: 0 ; invGabeCards
				get: 4 ; invGabeWallet
				get: 3 ; invRitterDagger
				get: 30 ; invVonGlowerCard
				get: 8 ; invHuberKeys
				get: 1 ; invGraceLetter1
				get: 2 ; invUbergrauLetter
				get: 13 ; invKlingmannReceipt
				get: 16 ; invEvidenceReport
				get: 79 ; invGabeNotebook
				get: 86 ; invManuscript
			)
			(SetFlag 412)
			(SetFlag 606)
			(SetFlag 446)
			(SetFlag 426)
			(ClearFlag 427)
			(ClearFlag 411)
			(ClearFlag 416)
			(gGame getDisc: 2)
			(PlayScene 223 0 2103) ; farmIntRm2
		)
		(4
			(switch (gGame printLang:)
				(351
					(gTopMessage sel_749: {Cap\a1tulo 4: Filme de Abertura})
				)
				(else
					(gTopMessage sel_749: {Chapter Four: Opening Movie})
				)
			)
			(= gEgo GraceEgo)
			(gEgo get: 20 get: 17 get: 19 get: 21 get: 26 get: 18) ; invGabeLetter1, invBarclayCard, invGraceWallet, invScrewdriver, invLudwigLetter, invNotebookPen
			(PlayScene 412 0 140) ; srGabeRoom
		)
		(5
			(switch (gGame printLang:)
				(351
					(gTopMessage sel_749: {Cap\a1tulo 5: Filme de Abertura})
				)
				(else
					(gTopMessage sel_749: {Chapter Five: Opening Movie})
				)
			)
			(= gEgo GabeEgo)
			(gEgo
				get: 5 ; invTalisman
				get: 15 ; invSpliceTape
				get: 0 ; invGabeCards
				get: 3 ; invRitterDagger
				get: 30 ; invVonGlowerCard
				get: 8 ; invHuberKeys
				get: 1 ; invGraceLetter1
				get: 2 ; invUbergrauLetter
				get: 13 ; invKlingmannReceipt
				get: 4 ; invGabeWallet
				get: 23 ; invWerewolfBook
				get: 24 ; invVictorJournal
				get: 25 ; invChristianJournal
				get: 79 ; invGabeNotebook
				get: 86 ; invManuscript
			)
			((ScriptID 0 5) loop: 2 cel: 4 active: 0) ; recButton
			(SetFlag 606)
			(SetFlag 446)
			(SetFlag 426)
			(ClearFlag 411)
			(ClearFlag 427)
			(ClearFlag 416)
			(PlayScene 544 0 -1)
			(PlayScene 547 0 200) ; MunichMapRm
		)
		(6
			(switch (gGame printLang:)
				(351
					(gTopMessage sel_749: {Cap\a1tulo 6: Filme de Abertura})
				)
				(else
					(gTopMessage sel_749: {Chapter Six: Opening Movie})
				)
			)
			(= gEgo GraceEgo)
			(gEgo get: 72 get: 19 get: 20 get: 37 put: 74) ; invCarKeys, invGraceWallet, invGabeLetter1, invGabeLetter2, invCastleTicket
			(GabeEgo get: 0 get: 4 get: 3)
			((ScriptID 0 5) loop: 2 cel: 4 active: 0) ; recButton
			(SetFlag 19)
			(SetFlag 20)
			(SetFlag 21)
			(SetFlag 735)
			(PlayScene 718 0 720) ; dungeonRm
		)
	)
	(if (== gChapter 3)
		(gGame getDisc: gChapter)
	)
	(gInterfacePlane show:)
	(gTopMessage sel_749: 0)
	(gUser alterEgo: gEgo sel_712: 62)
	((gUser sel_715:) update: set: 999 0 0 show:)
	(if (!= gChapter 6)
		((ScriptID 0 5) highlight: 0) ; recButton
	)
)

(procedure (proc11_15 param1)
	((ScriptID param1 0) sel_847:)
)

(procedure (proc11_17)
	(gMessager say: 27 62 0 1 0 120) ; "(PICKUP, GENERIC RESPONSE FOR USING INVENTORY ON SOMEONE)I don't think he'd be interested in that."
)

(procedure (proc11_18)
	(gMessager say: 26 62 0 1 0 120) ; "(PICKUP, GENERIC RESPONSE FOR USING INVENTORY ON SOMEONE)I'm not sure why she'd want to see THAT."
)

(procedure (proc11_19 param1)
	(return
		(cond
			((OneOf param1 5470) 13)
			((OneOf param1 7870 7871) 1000)
			(
				(OneOf
					param1
					6500
					6510
					6530
					6550
					6560
					6570
					6580
					6590
					6600
					6610
					6640
					6650
				)
				560
			)
			((OneOf param1 6470 6480) 555)
			(
				(OneOf
					param1
					8790
					8830
					8840
					8860
					8880
					8890
					8930
					8940
					8950
					8960
				)
				1160
			)
			((OneOf param1 3310) 460)
			((OneOf param1 2410 660) 410)
			((OneOf param1 3370 3380 3390 3400) 470)
			((OneOf param1 1190 1250 1280) 140)
			(
				(OneOf
					param1
					850
					851
					852
					870
					890
					891
					900
					901
					910
					920
					930
					950
					960
					970
					980
					990
					991
				)
				300
			)
			(
				(OneOf
					param1
					1340
					1350
					1360
					1370
					1380
					1390
					1400
					1410
					1420
					1430
					1440
					1450
					4140
					4150
					4160
					4170
					4180
					4190
					7580
					7590
				)
				120
			)
			((OneOf param1 4960 4970) 830)
			(
				(OneOf
					param1
					4980
					4990
					5010
					5020
					5040
					5050
					5060
					5070
					5100
					5110
					5120
					5130
					5150
					5160
					5170
					5180
				)
				840
			)
			(
				(OneOf
					param1
					1550
					1560
					1570
					1571
					1580
					1581
					1590
					1600
					4191
					4210
					4220
					4230
					4240
					4250
				)
				130
			)
			((OneOf param1 1460 1490) 160)
			((OneOf param1 8610 8690 8700 8720) 1170)
			((OneOf param1 4280 4290 4300 4310 4320 4330 4340 7610) 700)
			((OneOf param1 2170 2180 2190 4610 4620 7720) 730)
			((OneOf param1 7840) 970)
			(
				(OneOf
					param1
					2750
					2760
					2780
					2790
					2800
					2810
					2820
					2830
					2850
					2860
					2870
					2880
					2890
					2900
					2910
					2920
					2930
					2950
					2970
					2980
					2990
					3000
					3010
					3040
					3050
					3060
					3070
					3080
					3090
					3100
					3110
					3120
					3130
					3140
					3150
					3160
					3170
					3180
					3190
					3200
					3210
					3220
					5620
				)
				440
			)
			((OneOf param1 8500 8510 8530 8540 8550) 1140)
			((OneOf param1 6840 6900 6901 6910 6920 6940 6980 6990) 600)
			((OneOf param1 6730 6770) 570)
			((OneOf param1 7890 7891 7910 7930 7940 7950 7960 7970) 1020)
			(
				(OneOf
					param1
					420
					430
					440
					450
					451
					460
					490
					500
					510
					520
					530
					540
					550
					560
					570
					580
				)
				240
			)
			((OneOf param1 7030 7050) 670)
			((OneOf param1 9160 9180 9200 9240) 1185)
			((OneOf param1 9300 9310 9311 9312 9380 9400 9410) 1190)
			((OneOf param1 100 130 2320 2330 40 50 5480) 210)
			((OneOf param1 3280) 450)
			(
				(OneOf
					param1
					3410
					3420
					3430
					3440
					3461
					3470
					3490
					3500
					3510
					3520
					3530
					3550
					3560
					3570
					3590
					3600
					3610
					3630
					3640
					3660
					3670
					5670
					5680
					5681
					5690
					5700
					5730
					5740
					5750
					5760
				)
				320
			)
			((OneOf param1 6310 6311 6350) 545)
			((OneOf param1 191 210) 220)
			(
				(OneOf
					param1
					3910
					3920
					3930
					3940
					3950
					3960
					3970
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
				330
			)
			(
				(OneOf
					param1
					280
					290
					291
					300
					310
					320
					330
					340
					350
					360
					370
					380
					390
					400
					410
				)
				230
			)
			((OneOf param1 8000 8001 8020 8030 8040) 1010)
			((OneOf param1 7790) 950)
			(
				(OneOf
					param1
					1730
					1740
					1750
					1760
					1770
					1780
					1790
					1800
					1810
					1820
					1830
					1831
					1832
					1840
					1850
					1860
					1870
					1880
					1890
					4390
					4400
					4410
					4450
					4460
					4470
					4490
					4500
					4510
					4530
					4540
					4570
					7640
					7650
					7660
					7670
					7690
					7700
					7710
				)
				740
			)
			(
				(OneOf
					param1
					1000
					1010
					1020
					1030
					1050
					1060
					1070
					1080
					1090
					1100
					1110
					1120
					1150
					2500
					2520
					2530
					2540
					2560
					2620
					2630
					2640
					2650
					2660
					2670
					2680
					2690
					2700
					5600
					5610
				)
				430
			)
			((OneOf param1 5940 5950 5970 5980 5990 6000) 260)
			(
				(OneOf
					param1
					5190
					5210
					5230
					5240
					5250
					5260
					5280
					5290
					5320
					5330
				)
				850
			)
			((OneOf param1 2110 2120 2140 7510 7541 7550 7570) 720)
			((OneOf param1 1640 1650 1660 1670 1680 1690) 7030)
			((OneOf param1 2350 2360 2370 2380 2390 5520 5530 592) 400)
			((OneOf param1 8770 8780) 1150)
			(
				(OneOf
					param1
					10010
					10100
					1130
					1170
					20
					2200
					5370
					5440
					5480
					6970
					7180
				)
				12
			)
			((OneOf param1 4950) 820)
			((OneOf param1 5800 5810 5820 5840 5850 5860 5870) 250)
			(
				(OneOf
					param1
					1910
					1930
					1940
					1950
					1960
					1970
					1980
					1990
					2000
					2010
					2020
					2030
					2040
					2050
					2060
					2070
					2080
					2090
					4590
				)
				710
			)
			((OneOf param1 8310 8330 8340 8350 8360) 1110)
			((OneOf param1 8230 8300) 1100)
			((OneOf param1 8380 8390 8402 8403 8420 8430 8440 8450) 1120)
			(
				(OneOf
					param1
					6060
					6120
					6121
					6140
					6150
					6160
					6170
					6200
					6210
					6220
				)
				520
			)
			((OneOf param1 6250) 530)
			((OneOf param1 4890 4900 4910 4920 4930 4940) 810)
			(
				(OneOf
					param1
					2420
					2430
					2440
					2460
					2470
					2480
					2490
					5540
					5560
					5580
					5590
					690
					700
					710
					720
					740
					750
					760
					780
					790
					800
					810
					820
					830
					840
				)
				420
			)
			(else 21)
		)
	)
)

(procedure (proc11_20 param1)
	(return
		(cond
			((OneOf param1 1170 5470) 1)
			((OneOf param1 6500 6470 2200) 2)
			((OneOf param1 6480 6510) 3)
			((OneOf param1 5800 5370 6530) 4)
			((OneOf param1 6730 5810 5440 6550) 5)
			((OneOf param1 5820 6770 6560 5480) 6)
			((OneOf param1 3310 6570 7030 7890 20 5840) 7)
			((OneOf param1 3910 5850 7891 6580 7050 850 8380) 8)
			(
				(OneOf
					param1
					3920
					8390
					1130
					6590
					8790
					851
					9160
					5860
					7870
					7871
					7910
					8310
				)
				9
			)
			(
				(OneOf
					param1
					7930
					8830
					852
					9180
					8330
					5870
					6600
					1640
					8402
					8403
					10100
				)
				10
			)
			(
				(OneOf
					param1
					10010
					9200
					8420
					6610
					870
					2410
					8340
					1650
					8840
					8230
					7940
				)
				11
			)
			(
				(OneOf
					param1
					890
					6250
					1460
					3280
					8350
					9240
					6640
					660
					8430
					8860
					7950
					8300
					1660
				)
				12
			)
			(
				(OneOf
					param1
					1490
					8440
					7180
					8880
					3370
					4280
					1670
					6310
					891
					6650
					8360
					7960
				)
				13
			)
			(
				(OneOf
					param1
					3380
					8450
					7970
					4290
					900
					8890
					1680
					6311
					4960
					6970
				)
				14
			)
			(
				(OneOf
					param1
					6060
					8930
					5190
					4300
					2110
					8770
					6350
					3390
					1690
					901
					4970
				)
				15
			)
			((OneOf param1 6120 910 2120 3400 4310 8940 8780 5210) 16)
			((OneOf param1 5230 2140 4320 6121 8950 920) 17)
			((OneOf param1 8960 7510 6140 930 5240 4330) 18)
			((OneOf param1 6150 5250 7541 4340 950) 19)
			((OneOf param1 5260 7550 7840 9300 8000 6160 7610 960) 20)
			(
				(OneOf
					param1
					420
					6170
					6840
					970
					1930
					9310
					8001
					5280
					5940
					7570
				)
				21
			)
			(
				(OneOf
					param1
					8020
					980
					6200
					191
					5950
					5290
					1940
					430
					6900
					3930
					9311
				)
				22
			)
			(
				(OneOf
					param1
					8030
					440
					5320
					9312
					3940
					6210
					1950
					4980
					6901
					5970
					990
					210
				)
				23
			)
			(
				(OneOf
					param1
					690
					8040
					5980
					7790
					450
					6910
					991
					6220
					4990
					3950
					5330
					9380
					1960
					8610
				)
				24
			)
			(
				(OneOf
					param1
					700
					8690
					9410
					3960
					6920
					2170
					5010
					1970
					451
					5990
				)
				25
			)
			((OneOf param1 710 460 6000 6940 2180 3970 9400 1980 5020) 26)
			(
				(OneOf
					param1
					720
					8500
					5040
					1990
					8720
					490
					2190
					3980
					6980
					4950
				)
				27
			)
			(
				(OneOf
					param1
					740
					1000
					6990
					500
					8510
					1340
					2000
					3990
					5050
					4610
					280
					8700
				)
				28
			)
			(
				(OneOf
					param1
					750
					290
					1350
					4010
					4620
					5060
					1550
					1010
					50
					510
					2010
					8530
				)
				29
			)
			(
				(OneOf
					param1
					760
					520
					8540
					1020
					5070
					2020
					7720
					40
					291
					4020
					1360
					1560
				)
				30
			)
			(
				(OneOf
					param1
					780
					1030
					1370
					1190
					2030
					8550
					4040
					5100
					300
					530
					1570
				)
				31
			)
			((OneOf param1 790 540 5110 1571 2040 310 1050 4050 1380 1250) 32)
			((OneOf param1 800 1280 550 1060 5120 320 4060 1390 1580 2050) 33)
			((OneOf param1 810 4070 1400 1070 1581 2060 330 5130 560) 34)
			(
				(OneOf
					param1
					820
					340
					100
					5150
					2070
					1590
					570
					4890
					1080
					1410
					4080
				)
				35
			)
			(
				(OneOf
					param1
					830
					2320
					580
					5160
					1420
					4090
					2080
					1090
					4900
					1600
					350
				)
				36
			)
			(
				(OneOf
					param1
					840
					2330
					4100
					360
					1100
					5170
					4191
					2090
					4910
					1430
				)
				37
			)
			(
				(OneOf
					param1
					2420
					1430
					360
					1100
					1440
					4920
					4590
					1110
					5180
					5480
					4210
					370
				)
				38
			)
			((OneOf param1 2430 4930 2350 380 1120 130 1910 1450 4220) 39)
			((OneOf param1 2440 2360 4940 4140 390 2750 1150 4230) 40)
			((OneOf param1 2460 4240 2760 400 2370 4150) 41)
			((OneOf param1 2470 4250 2780 410 2500 4160 2380) 42)
			((OneOf param1 2480 3410 2790 2390 2520 4170) 43)
			((OneOf param1 2490 4180 5520 2800 2530 3420) 44)
			((OneOf param1 5540 2810 4190 5530 2540 3430) 45)
			((OneOf param1 5560 2560 830 3440 2820 7580 592) 46)
			((OneOf param1 7590 3461 2830 2620) 47)
			((OneOf param1 5580 3470 2850 2630) 48)
			((OneOf param1 5590 3490 2860 2640) 49)
			((OneOf param1 2870 2650 3500) 50)
			((OneOf param1 3510 2880 2660) 51)
			((OneOf param1 3520 2670 2890 1730) 52)
			((OneOf param1 3530 1740 2680 2900) 53)
			((OneOf param1 2910 3550 2690 1750) 54)
			((OneOf param1 2920 1760 3560 2700) 55)
			((OneOf param1 5600 1770 3570 2930) 56)
			((OneOf param1 2950 5610 3590 1780) 57)
			((OneOf param1 1790 3600 2970) 58)
			((OneOf param1 1800 2980 3610) 59)
			((OneOf param1 1810 3630 2990) 60)
			((OneOf param1 3640 1820 3000) 61)
			((OneOf param1 3660 3010 1830) 62)
			((OneOf param1 3670 1831 3040) 63)
			((OneOf param1 5670 3050 1832) 64)
			((OneOf param1 5680 1840 3060) 65)
			((OneOf param1 3070 1850 5681) 66)
			((OneOf param1 1860 5690 3080) 67)
			((OneOf param1 3090 1870 5700) 68)
			((OneOf param1 5730 1880 3100) 69)
			((OneOf param1 5740 3110 1890) 70)
			((OneOf param1 5750 4390 3120) 71)
			((OneOf param1 5760 3130 4400) 72)
			((OneOf param1 3140 4410) 73)
			((OneOf param1 4450 3150) 74)
			((OneOf param1 4460 3160) 75)
			((OneOf param1 4470 3170) 76)
			((OneOf param1 4490 3180) 77)
			((OneOf param1 4500 3190) 78)
			((OneOf param1 3200 4510) 79)
			((OneOf param1 4530 3210) 80)
			((OneOf param1 3220 4540) 81)
			((OneOf param1 4570 5620) 82)
			((OneOf param1 7640) 83)
			((OneOf param1 7650) 84)
			((OneOf param1 7660) 85)
			((OneOf param1 7670) 86)
			((OneOf param1 7690) 87)
			((OneOf param1 7700) 88)
			((OneOf param1 7710) 89)
			(else 2)
		)
	)
)

(procedure (proc11_21 param1 &tmp temp0 temp1 temp2 temp3)
	(= local2 0)
	(if (and (== (gGame printLang:) 351) (ResCheck rsSYNC param1))
		(= local2 1)
		(= local3 (Sync new:))
		(DoSync syncSTART local3 param1)
		(DoSync syncNEXT local3)
		(= local6 (local3 syncTime:))
		(= local7 (local3 syncCue:))
		(Load rsMESSAGE (proc11_19 param1))
		(Load rsSCRIPT 64922 64918)
	)
	(= temp0 (Str newWith: 10 {}))
	(temp0 format: {%d.VMD} param1)
	(if (!= param1 10010)
		(gTopMessage sel_867: param1)
	)
	(PlayVMD 0 (temp0 data:)) ; Open
	(PlayVMD 23 16 256) ; RestrictPalette
	(if (IsFlag 34)
		(PlayVMD 1 165 98 128 25 16 256) ; Put
	else
		(PlayVMD 1 12 15 149 25 16 256) ; Put
	)
	(PlayVMD 21 12 15 627 349) ; Black
	(if local2
		(while (== (PlayVMD 14 23 local6) 1) ; WaitEvent
			(if (== local6 -1)
				(PlayVMD 14 7) ; WaitEvent
				(break)
			else
				(if local5
					(local5 dispose:)
					(= local5 0)
				)
				(if (!= local7 999)
					(= temp1 (proc11_19 param1))
					(= temp2 (proc11_20 param1))
					(if (> (= temp3 local7) 34)
						(-= temp3 34)
						(+= temp2 1)
					)
					(= local4 (Print new:))
					(if gDebugging
						(local4
							font: 51
							back: (if (== 10010 param1) 1 else 4)
							fore: 14
							x: 60
							y: 360
							modeless: 2
							addTextF:
								{VMD = %d, msg file = %d, noun = %d, sequence = %d}
								param1
								temp1
								temp2
								temp3
							addText: temp2 0 0 temp3 0 12 temp1
							init:
						)
					else
						(local4
							font: 51
							back: (if (== 10010 param1) 1 else 4)
							fore: 14
							x: 60
							y: 360
							modeless: 2
							addText: temp2 0 0 temp3 0 0 temp1
							init:
						)
					)
					(= local5 (local4 dialog:))
				else
					(FrameOut)
				)
				(DoSync syncNEXT local3)
				(= local6 (local3 syncTime:))
				(= local7 (local3 syncCue:))
			)
		)
	else
		(PlayVMD 14 7) ; WaitEvent
	)
	(if (!= param1 10010)
		(gTopMessage sel_867:)
	)
	(PlayVMD 6) ; Close
	(temp0 dispose:)
	(if local2
		(if local5
			(local5 dispose:)
			(= local5 0)
		)
		(if local3
			(DoSync syncSTOP)
			(local3 dispose:)
			(= local3 0)
		)
	)
)

(instance doUpdateCode of Code ; UNUSED
	(properties)

	(method (doit param1)
		(if (not (& (param1 signal:) $0008))
			(UpdateScreenItem param1)
		)
	)
)

