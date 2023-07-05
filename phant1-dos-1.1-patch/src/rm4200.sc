;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4200)
(include sci.sh)
(use Main)
(use movieScr)
(use ExitFeature)
(use OccCyc)
(use n1111)
(use Scaler)
(use Osc)
(use RandCycle)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm4200 0
)

(local
	local0
	local1
)

(instance rm4200 of ScaryRoom
	(properties
		stepSound 7
	)

	(method (init)
		(= picture (+ 3900 (== gChapter 5)))
		(= global115 0)
		(if (> gChapter 5)
			(SetFlag 126)
			(SetFlag 9)
		)
		(gEgo init: setScaler: Scaler 65 32 128 82 normalize:)
		(if (and (== gChapter 4) (IsFlag 193))
			(= picture 3550)
			(gCurRoom setScript: sDonArgues)
		else
			(switch gPrevRoomNum
				(900
					(if (and (== gChapter 4) (IsFlag 190))
						(SetFlag 51)
						(if (or (not (IsFlag 203)) (IsFlag 193))
							(harriet
								view: 4240
								posn: 171 90
								init:
								setHotspot: 4 3 15 ; Do, Move, invTarot
								setCycle: Fwd
							)
						)
					)
					(if
						(or
							(and
								(== gChapter 4)
								(IsFlag 203)
								(not (IsFlag 193))
							)
							(and (== gChapter 6) (not (IsFlag 200)))
						)
						(mike init: setCycle: OccCyc 0)
						(if (not (and (== gChapter 6) (IsFlag 201)))
							(mike setHotspot: 4 3) ; Do, Move
						)
					)
					(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
				)
				(2200
					(= picture 3830)
					(gCurRoom setScript: sDoor)
				)
				(3200
					(if (< global125 160)
						(gEgo posn: 215 113 normalize: 3)
						(= global125 23)
					else
						(gEgo posn: 78 113 normalize: 3)
						(= global125 19)
					)
					(if (and (== gChapter 6) (IsFlag 206))
						(= picture (+ 3640 (== gChapter 5)))
						(gCurRoom setScript: sCheckPhone)
					else
						(if (and (== gChapter 4) (IsFlag 190))
							(SetFlag 51)
							(if (or (not (IsFlag 203)) (IsFlag 193))
								(harriet
									view: 4240
									posn: 171 90
									init:
									setHotspot: 4 3 15 ; Do, Move, invTarot
									setCycle: Fwd
								)
							)
						)
						(if
							(or
								(and
									(== gChapter 4)
									(IsFlag 203)
									(not (IsFlag 193))
								)
								(and (== gChapter 6) (not (IsFlag 200)))
							)
							(mike init: setCycle: OccCyc 0)
							(if (not (and (== gChapter 6) (IsFlag 201)))
								(mike setHotspot: 4 3) ; Do, Move
							)
						)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
				)
				(3700
					(if (> global125 240)
						(gEgo posn: 215 113 normalize: 3)
						(= global125 23)
					else
						(gEgo posn: 78 113 normalize: 3)
						(= global125 19)
					)
					(if (and (== gChapter 6) (IsFlag 206))
						(= picture (+ 3640 (== gChapter 5)))
						(gCurRoom setScript: sCheckPhone)
					else
						(if (and (== gChapter 4) (IsFlag 190))
							(SetFlag 51)
							(if (or (not (IsFlag 203)) (IsFlag 193))
								(harriet
									view: 4240
									posn: 171 90
									init:
									setHotspot: 4 3 15 ; Do, Move, invTarot
									setCycle: Fwd
								)
							)
						)
						(if
							(or
								(and
									(== gChapter 4)
									(IsFlag 203)
									(not (IsFlag 193))
								)
								(and (== gChapter 6) (not (IsFlag 200)))
							)
							(mike init: setCycle: OccCyc 0)
							(if (not (and (== gChapter 6) (IsFlag 201)))
								(mike setHotspot: 4 3) ; Do, Move
							)
						)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
				)
				(13100
					(= global115 0)
					(gEgo normalize: 0 posn: 138 88)
					(= global125 20)
					(cond
						((and (== gChapter 5) (not (IsFlag 194)))
							(= picture 3941)
							(gCurRoom setScript: sCyrusTells)
						)
						(
							(and
								(== gChapter 2)
								(not (IsFlag 55))
								(not global184)
							)
							(= picture 3820)
							(gCurRoom setScript: sHearMusic)
						)
						((and (IsFlag 180) (not (IsFlag 51)) (== gChapter 4))
							(ClearFlag 180)
							(SetFlag 174)
							(= picture (+ 3560 (== gChapter 5)))
							(gCurRoom setScript: sOrderHarriet)
						)
						((and (== gChapter 6) (IsFlag 206))
							(= picture (+ 3560 (== gChapter 5)))
							(gCurRoom setScript: sCheckPhoneDwnStairs)
						)
						(else
							(= picture (+ 3560 (== gChapter 5)))
							(gCurRoom setScript: sDwnStairs)
						)
					)
				)
				(13200
					(= global115 0)
					(gEgo normalize: 0 posn: 138 88)
					(= global125 20)
					(cond
						((and (== gChapter 5) (not (IsFlag 194)))
							(= picture 3941)
							(gCurRoom setScript: sCyrusTells)
						)
						(
							(and
								(== gChapter 2)
								(not (IsFlag 55))
								(not global184)
							)
							(= picture 3820)
							(gCurRoom setScript: sHearMusic)
						)
						((and (== gChapter 6) (IsFlag 206))
							(= picture (+ 3560 (== gChapter 5)))
							(gCurRoom setScript: sCheckPhoneDwnStairs)
						)
						(else
							(= picture (+ 3560 (== gChapter 5)))
							(gCurRoom setScript: sDwnStairs)
						)
					)
				)
				(else
					(cond
						((and (IsFlag 195) (== gChapter 5) (not (IsFlag 44)))
							(= picture 3471)
							(SetFlag 376)
							(gCurRoom setScript: sHearParty)
						)
						((and (not (IsFlag 126)) (!= gChapter 4))
							(= picture 3470)
							(gCurRoom setScript: sFrontDoorPan)
						)
						((and (== gChapter 6) (IsFlag 206))
							(gCurRoom setScript: sCheckPhoneOutside)
							(= picture (+ 3470 (== gChapter 5)))
						)
						(else
							(= picture (+ 3470 (== gChapter 5)))
							(gCurRoom setScript: sInFrontDoor)
						)
					)
					(cond
						(
							(or
								(and (== gChapter 1) (IsFlag 39))
								(== gChapter 2)
							))
						((OneOf gChapter 3 4))
						((OneOf gChapter 5 6))
						(else
							(OneOf gChapter 7)
						)
					)
					(if (and (not (IsFlag 90)) (gEgo has: 0)) ; invLibKey
						(SetFlag 90)
					)
					(if (and (not (IsFlag 102)) (gEgo has: 13)) ; invDrainCln
						(SetFlag 102)
					)
					(if (and (not (IsFlag 98)) (gEgo has: 2)) ; invNail
						(SetFlag 98)
					)
					(if (and (not (IsFlag 105)) (IsFlag 189))
						(SetFlag 105)
					)
					(if (and (not (IsFlag 115)) (IsFlag 195))
						(SetFlag 115)
					)
					(if (and (not (IsFlag 413)) (IsFlag 206))
						(SetFlag 413)
					)
				)
			)
			((ScriptID 30) init:) ; FidgetCode
			(southwestExit init: 12 approachVerbs: 0)
			(southeastExit init: 11 approachVerbs: 0)
			(stairs init: 13 approachVerbs: 0)
			(if (< gChapter 7)
				(gypsy init: setHotspot: 4 3) ; Do, Move
			)
			(if (not (IsFlag 202))
				(frontDoor init: 10 approachVerbs: 0)
			)
		)
		(super init:)
		(switch gChapter
			(1
				(global114 play: 911)
			)
			(2
				(global114 play: 911)
			)
			(3
				(global114 play: 912)
			)
			(4
				(global114 play: 9120)
			)
			(5
				(global114 play: 913)
			)
			(6
				(global114 play: 914)
			)
			(7
				(global114 play: 9140)
			)
		)
		(if (not (IsFlag 376))
			(gGDacSound number: 2010 init: setVol: 25 setLoop: -1 play:)
		)
	)

	(method (newRoom newRoomNumber)
		(if (not (OneOf newRoomNumber 2200 3760 3800 3200 3700 4200 900))
			(= global125 0)
			(gGDacSound stop:)
			(if (not global184)
				(global114 endPause:)
			)
			(ClearFlag 376)
		)
		(if
			(and
				(== gChapter 4)
				(!= newRoomNumber 3200)
				(IsFlag 49)
				(not (IsFlag 51))
				(not (IsFlag 190))
			)
			(SetFlag 190)
			(ClearFlag 175)
		)
		(if
			(and
				(== gChapter 4)
				(!= newRoomNumber 3200)
				(IsFlag 51)
				(not (IsFlag 265))
				(not (IsFlag 52))
			)
			(SetFlag 52)
			(ClearFlag 190)
		)
		(if
			(and
				(== gChapter 4)
				(OneOf newRoomNumber 28100 3700)
				(IsFlag 265)
				(not (IsFlag 3))
				(not (IsFlag 247))
			)
			(SetFlag 247)
			(ClearFlag 52)
		)
		(if
			(and
				(== gChapter 4)
				(OneOf newRoomNumber 3200 3700 28100)
				(IsFlag 5)
				(not (IsFlag 325))
			)
			(SetFlag 325)
			(ClearFlag 264)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance sHearMusic of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					46
					(Load rsSOUND 3020)
					(proc1111_7 2390 43 -21 gEgo 1)
				)
				(1
					(global114 pause: 3020 0 -1)
					(global114 setVol: (= global184 63) 1)
					((ScriptID 46) init:) ; phonoReg
					(gRegions add: (ScriptID 46)) ; phonoReg
				)
				(2
					(gEgo posn: 138 88 normalize: 0)
					(= global125 20)
					(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(SetFlag 196)
					(if (not (global114 script:))
						(global114 pause: 3020 0 -1)
						(global114 setVol: (= global184 63) 1)
					)
					(if (not (gRegions contains: (ScriptID 46))) ; phonoReg
						((ScriptID 46) init:) ; phonoReg
						(gRegions add: (ScriptID 46)) ; phonoReg
					)
					(gEgo posn: 138 88 normalize: 0)
					(= global125 20)
					(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sHearParty of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(global114 pause: 3049 0 -1)
					(global114 setVol: 120 1)
					(gGDacSound number: 3051 init: setVol: 60 setLoop: -1 play:)
					(DoAudio 12 0) ; AudMixCheck
					(rDoor3470 init:)
					(if (== gChapter 5)
						(proc1111_7 433 145 -35)
					else
						(proc1111_7 432 106 -17)
					)
				)
				(1
					(rDoor3470 dispose:)
					(gEgo hide:)
					(if (gCast contains: mike)
						(mike hide:)
					)
					(if (gCast contains: harriet)
						(harriet hide:)
					)
					(SetFlag 376)
					(proc1111_7 5020 -6 -38)
					(gCurRoom drawPic: 3840)
				)
				(2
					(DoAudio 12 1) ; AudMixCheck
					(gEgo show:)
					(if (gCast contains: mike)
						(mike show:)
					)
					(if (gCast contains: harriet)
						(harriet show:)
					)
					(SetFlag 44)
					(gEgo posn: 184 89 normalize: 2)
					(= global125 22)
					(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(DoAudio 12 1) ; AudMixCheck
					(SetFlag 376)
					(if (not (global114 script:))
						(global114 pause: 3049)
						(global114 setVol: 120 1)
						(gGDacSound
							number: 3050
							init:
							setVol: 120
							setLoop: -1
							play:
						)
					)
					(if (gCast contains: rDoor3470)
						(rDoor3470 dispose:)
					)
					(gEgo show:)
					(if (gCast contains: mike)
						(mike show:)
					)
					(if (gCast contains: harriet)
						(harriet show:)
					)
					(SetFlag 44)
					(gEgo posn: 184 89 normalize: 2)
					(= global125 22)
					(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sInFrontDoor of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(if (and (== gChapter 4) (IsFlag 190))
						(SetFlag 51)
						(if (or (not (IsFlag 203)) (IsFlag 193))
							(harriet view: 438 posn: 84 118 init: setCycle: Fwd)
						)
					)
					(if
						(or
							(and
								(== gChapter 4)
								(IsFlag 203)
								(not (IsFlag 193))
							)
							(and (== gChapter 6) (not (IsFlag 200)))
						)
						(mike view: 437 posn: 85 115 init: setCycle: OccCyc 0)
						(lPhone3470 init:)
						(lToolBox3470 init:)
					)
					(rDoor3470 init:)
					(if (== gChapter 5)
						(proc1111_7 433 145 -35)
					else
						(proc1111_7 432 106 -17)
					)
				)
				(1
					(if (gCast contains: lPhone3470)
						(lPhone3470 dispose:)
						(lToolBox3470 dispose:)
					)
					(rDoor3470 dispose:)
					(if (gCast contains: mike)
						(mike view: 4580 posn: 165 87 ignoreActors: 1)
						(if (not (and (== gChapter 6) (IsFlag 201)))
							(mike setHotspot: 4 3) ; Do, Move
						)
					)
					(if (gCast contains: harriet)
						(harriet
							view: 4240
							posn: 171 90
							setHotspot: 4 3 15 ; Do, Move, invTarot
							ignoreActors: 1
						)
					)
					(gEgo posn: 184 89 normalize: 2)
					(= global125 22)
					(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(if (gCast contains: rDoor3470)
				(lPhone3470 dispose:)
				(lToolBox3470 dispose:)
				(rDoor3470 dispose:)
			)
			(if (gCast contains: mike)
				(mike view: 4580 posn: 165 87 ignoreActors: 1)
				(if (not (and (== gChapter 6) (IsFlag 201)))
					(mike setHotspot: 4 3) ; Do, Move
				)
			)
			(if (gCast contains: harriet)
				(harriet
					view: 4240
					posn: 171 90
					setHotspot: 4 3 15 ; Do, Move, invTarot
					ignoreActors: 1
				)
			)
			(gEgo posn: 184 89 normalize: 2)
			(= global125 22)
			(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sFrontDoorPan of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(if (and (== gChapter 4) (IsFlag 190))
						(SetFlag 51)
						(if (or (not (IsFlag 203)) (IsFlag 193))
							(harriet view: 438 posn: 84 118 init: setCycle: Fwd)
						)
					)
					(if
						(or
							(and
								(== gChapter 4)
								(IsFlag 203)
								(not (IsFlag 193))
							)
							(and (== gChapter 6) (not (IsFlag 200)))
						)
						(mike view: 437 posn: 85 115 init: setCycle: OccCyc 0)
						(lPhone3470 init:)
						(lToolBox3470 init:)
					)
					(rDoor3470 init:)
					(if (== gChapter 5)
						(proc1111_7 433 145 -35)
					else
						(proc1111_7 432 106 -17)
					)
				)
				(1
					(SetFlag 126)
					(gEgo posn: 184 89 normalize: 2)
					(= global125 22)
					(rDoor3470 dispose:)
					(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
					(UpdateScreenItem gEgo)
					(if (< gVideoSpeed 425)
						(PlayVMD 0 {2905.vmd} 0) ; Open
						(proc26_0 2905 self)
					else
						(PlayVMD 0 {290.vmd} 0) ; Open
						(proc26_0 290 self)
					)
				)
				(2
					(if (gCast contains: lPhone3470)
						(lPhone3470 dispose:)
						(lToolBox3470 dispose:)
					)
					(if (gCast contains: mike)
						(mike view: 4580 posn: 165 87)
						(if (not (and (== gChapter 6) (IsFlag 201)))
							(mike setHotspot: 4 3) ; Do, Move
						)
					)
					(if (gCast contains: harriet)
						(harriet view: 4240 posn: 171 90 setHotspot: 4 3 15) ; Do, Move, invTarot
					)
					(gEgo posn: 184 89 normalize: 2)
					(= global125 22)
					(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(ClearFlag 121)
			(if (gCast contains: mike)
				(mike view: 4580 posn: 165 87)
				(if (not (and (== gChapter 6) (IsFlag 201)))
					(mike setHotspot: 4 3) ; Do, Move
				)
			)
			(if (gCast contains: harriet)
				(harriet view: 4240 posn: 171 90 setHotspot: 4 3 15) ; Do, Move, invTarot
			)
			(if (gCast contains: rDoor3470)
				(rDoor3470 dispose:)
			)
			(gEgo posn: 184 89 normalize: 2)
			(= global125 22)
			(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sDwnStairs of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(proc1111_7 471 38 30)
				)
				(1
					(if (and (== gChapter 4) (IsFlag 190))
						(SetFlag 51)
						(if (or (not (IsFlag 203)) (IsFlag 193))
							(harriet
								view: 4240
								posn: 171 90
								init:
								setHotspot: 4 3 15 ; Do, Move, invTarot
								setCycle: Fwd
							)
						)
					)
					(if
						(or
							(and
								(== gChapter 4)
								(IsFlag 203)
								(not (IsFlag 193))
							)
							(and (== gChapter 6) (not (IsFlag 200)))
						)
						(mike init: setCycle: OccCyc 0)
						(if (not (and (== gChapter 6) (IsFlag 201)))
							(mike setHotspot: 4 3) ; Do, Move
						)
					)
					(gEgo
						setScaler: Scaler 65 32 128 82
						normalize: 0
						posn: 138 88
						cel: 6
						setCycle: End
					)
					(= global125 20)
					(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(if (and (== gChapter 4) (IsFlag 190))
				(SetFlag 51)
				(if (or (not (IsFlag 203)) (IsFlag 193))
					(harriet
						view: 4240
						posn: 171 90
						init:
						setHotspot: 4 3 15 ; Do, Move, invTarot
						setCycle: Fwd
					)
				)
			)
			(if
				(or
					(and (== gChapter 4) (IsFlag 203) (not (IsFlag 193)))
					(and (== gChapter 6) (not (IsFlag 200)))
				)
				(mike init: setCycle: OccCyc 0)
				(if (not (and (== gChapter 6) (IsFlag 201)))
					(mike setHotspot: 4 3) ; Do, Move
				)
			)
			(gEgo
				show:
				posn: 138 88
				setScaler: Scaler 65 32 128 82
				normalize: 0
			)
			(= global125 20)
			(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sExitOutSide of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(20
							(gEgo setHeading: 90 self)
						)
						(21
							(gEgo setHeading: 90 self)
						)
						(22
							(gEgo setHeading: 45 self 10)
						)
						(19
							(gEgo setHeading: 45 self)
						)
						(23
							(gEgo setHeading: 315 self)
						)
						(24
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(switch global125
						(19
							(if (gCast contains: mike)
								(mike hide:)
							)
							(if (gCast contains: harriet)
								(harriet hide:)
							)
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(proc1111_7 438 85 -39)
							(gCurRoom drawPic: 3640)
						)
						(23
							(if (gCast contains: mike)
								(mike hide:)
							)
							(if (gCast contains: harriet)
								(harriet hide:)
							)
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(proc1111_7 436 -5 -31)
							(gCurRoom drawPic: 3640)
						)
						(24
							(if (gCast contains: mike)
								(mike hide:)
							)
							(if (gCast contains: harriet)
								(harriet hide:)
							)
							(fire
								init:
								cycleSpeed: 8
								cycleSpeed: 8
								setCycle: RandCycle
							)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(proc1111_7 436 -10 -31)
							(gCurRoom drawPic: 3640)
						)
						(else
							(self changeState: 2)
						)
					)
				)
				(2
					(if (gCast contains: fire)
						(fire dispose:)
					)
					(if (gCast contains: theCat)
						(theCat dispose:)
					)
					(if (gCast contains: libDoor)
						(libDoor dispose:)
					)
					(gEgo hide:)
					(if (gCast contains: mike)
						(mike
							show:
							posn: 85 115
							view: 437
							loop: 0
							cel: 0
							setCycle: Osc
						)
						(lPhone3470 init:)
						(lToolBox3470 init:)
					)
					(if (gCast contains: harriet)
						(harriet
							show:
							posn: 84 118
							view: 438
							loop: 0
							cel: 0
							setCycle: Fwd
						)
					)
					(rDoor3470 init:)
					(if (== gChapter 5)
						(proc1111_7 431 98 0 gEgo -1 1)
					else
						(proc1111_7 430 133 -21 gEgo -1 1)
					)
					(gCurRoom drawPic: (+ 3470 (== gChapter 5)))
				)
				(3
					(if (and (== gChapter 1) (IsFlag 82) (not (IsFlag 181)))
						(SetFlag 181)
					)
					(= global125 0)
					(gCurRoom newRoom: 28100)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(if (and (== gChapter 1) (IsFlag 82) (not (IsFlag 181)))
				(SetFlag 181)
			)
			(= global125 0)
			(gCurRoom newRoom: 28100)
		)
	)
)

(instance sUpTheStairs of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(20
							(gEgo setHeading: 270 self 22)
						)
						(21
							(gEgo setHeading: 270 self)
						)
						(22
							(gEgo setHeading: 270 self)
						)
						(19
							(gEgo setHeading: 45 self)
						)
						(23
							(gEgo setHeading: 315 self)
						)
						(24
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(if (gCast contains: mike)
						(mike hide:)
					)
					(if (gCast contains: harriet)
						(harriet hide:)
					)
					(switch global125
						(19
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(proc1111_7 438 95 -39)
							(gCurRoom drawPic: 3640)
						)
						(23
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(proc1111_7 438 15 -39)
							(gCurRoom drawPic: 3640)
						)
						(24
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(proc1111_7 438 -10 -39)
							(gCurRoom drawPic: 3640)
						)
						(else
							(self changeState: 2)
						)
					)
				)
				(2
					(if (gCast contains: fire)
						(fire dispose:)
					)
					(if (gCast contains: theCat)
						(theCat dispose:)
					)
					(if (gCast contains: libDoor)
						(libDoor dispose:)
					)
					(gEgo hide:)
					(proc1111_7 470 57 30 gEgo -1 1)
					(gCurRoom drawPic: (+ 3560 (== gChapter 5)))
				)
				(3
					(= global125 0)
					(gCurRoom newRoom: 13100)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(= global125 0)
					(gCurRoom newRoom: 13100)
				)
			)
		)
	)
)

(instance sExitSouthWest of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(20
							(gEgo setHeading: 225 self 15)
						)
						(21
							(gEgo setHeading: 180 self 15)
						)
						(22
							(gEgo setHeading: 225 self 15)
						)
						(else
							(gEgo setHeading: 225 self)
						)
					)
				)
				(1
					(if (gCast contains: mike)
						(mike hide:)
					)
					(if (gCast contains: harriet)
						(harriet hide:)
					)
					(switch global125
						(20
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(gEgo hide:)
							(proc1111_7 439 81 -14 gEgo -1 1)
							(gCurRoom drawPic: 3640)
						)
						(21
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(gEgo hide:)
							(proc1111_7 439 40 -14 gEgo -1 1)
							(gCurRoom drawPic: 3640)
						)
						(22
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(gEgo hide:)
							(proc1111_7 439 40 -14 gEgo -1 1)
							(gCurRoom drawPic: 3640)
						)
						(else
							(self changeState: 2)
						)
					)
				)
				(2
					(gCurRoom newRoom: 3700)
				)
			)
		else
			(= global115 0)
			(gCurRoom newRoom: 3700)
		)
	)
)

(instance sExitSouthEast of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(20
							(gEgo setHeading: 135 self 15)
						)
						(21
							(gEgo setHeading: 180 self 15)
						)
						(22
							(gEgo setHeading: 135 self 15)
						)
						(else
							(gEgo setHeading: 135 self)
						)
					)
				)
				(1
					(if (gCast contains: mike)
						(mike hide:)
					)
					(if (gCast contains: harriet)
						(harriet hide:)
					)
					(switch global125
						(20
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(gEgo hide:)
							(proc1111_7 437 -40 -15 gEgo -1 1)
							(gCurRoom drawPic: 3640)
						)
						(21
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(gEgo hide:)
							(proc1111_7 437 -84 -15 gEgo -1 1)
							(gCurRoom drawPic: 3640)
						)
						(22
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(gEgo hide:)
							(proc1111_7 437 -84 -15 gEgo -1 1)
							(gCurRoom drawPic: 3640)
						)
						(else
							(self changeState: 2)
						)
					)
				)
				(2
					(gCurRoom newRoom: 3200)
				)
			)
		else
			(= global115 0)
			(gCurRoom newRoom: 3200)
		)
	)
)

(instance sOrderHarriet of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= local1 (= state newState))
				(0
					(SetFlag 248)
					(proc1111_7 471 38 30)
				)
				(1
					(gEgo hide:)
					(proc1111_7 4060 77 -8)
					(gCurRoom drawPic: 3925)
				)
				(2
					(proc1111_7 4061 -28 -24 gEgo 200)
					(gCurRoom drawPic: 3935)
				)
				(3
					(proc1111_7 4062 14 -10)
					(gCurRoom drawPic: (+ 3560 (== gChapter 5)))
				)
				(4
					(proc1111_7 4063 26 -3)
					(gCurRoom drawPic: 3925)
				)
				(5
					(gCurRoom setScript: sAnythingElse)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(if local1
				(gCurRoom setScript: sAnythingElse)
			else
				(self changeState: 1)
			)
		)
	)
)

(instance sAnythingElse of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(proc1111_7 4070 18 -37 gEgo 200)
					(gCurRoom drawPic: 3935)
				)
				(1
					(proc1111_8)
					(= local0 1)
					(harrietStill
						init:
						setHotspot:
							4 ; Do
							3 ; Move
							0
							8 ; invLibKey
							6 ; invMoney
							7 ; invNail
							9 ; invNewspaper
							10 ; invPoker
							11 ; invHammer
							12 ; invStairKey
							13 ; invVampBook
							14 ; invMatch
							15 ; invTarot
							16 ; invBrooch
							17 ; invPhoto
							18 ; invLensPiece
							19 ; invDrainCln
							20 ; invCrucifix
							22 ; invBeads
							23 ; invSpellBook
							25 ; invXmasOrn
							26 ; invStone
							27 ; invCutter
							28 ; invDogBone
							34 ; invFigurine
					)
					(gGame handsOn: 0)
				)
				(2
					(harrietStill dispose:)
					(proc1111_9)
					(= local0 0)
					(gGame handsOff:)
					(gCurRoom setScript: sHarrietLeave)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(harrietStill dispose:)
			(if local0
				(proc1111_9)
				(= local0 0)
			)
			(gGame handsOff:)
			(gCurRoom setScript: sHarrietLeave)
		)
	)
)

(instance sHarrietLeave of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 175)
					(if (gEgo has: 3) ; invNewspaper
						(gEgo put: 3) ; invNewspaper
						(proc1111_7 4130 -12 -41 gEgo -1 1)
					else
						(proc1111_7 4080 -4 -38 gEgo -1 1)
					)
					(gCurRoom drawPic: 3925)
				)
				(1
					(gGame fade: 100 0 1)
					(= cycles 100)
				)
				(2
					(proc1111_6)
					(gEgo show: posn: 138 88 normalize: 0)
					(= global125 20)
					(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
					(= cycles 50)
				)
				(3
					(gGame fade: 0 100 1)
					(= cycles 100)
				)
				(4
					(ClearFlag 248)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(ClearFlag 248)
			(if (gEgo has: 3) ; invNewspaper
				(gEgo put: 3) ; invNewspaper
			)
			(SetFlag 175)
			(gEgo show: posn: 138 88 normalize: 0)
			(= global125 20)
			(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
			(gGame fade: 99 100 1)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sWaste of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(harrietStill dispose:)
					(gEgo hide:)
					(proc1111_7 4100 101 13)
					(gCurRoom drawPic: 3925)
				)
				(1
					(gCurRoom setScript: sAnythingElse)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(gCurRoom setScript: sAnythingElse)
		)
	)
)

(instance sOther of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(harrietStill dispose:)
					(proc1111_7 4090 79 8)
					(gCurRoom drawPic: 3925)
				)
				(1
					(if (IsFlag 190)
						(gEgo show:)
						(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
						(gGame handsOn:)
						(self dispose:)
					else
						(gCurRoom setScript: sAnythingElse)
					)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(if (IsFlag 190)
				(gEgo show:)
				(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
				(gGame handsOn:)
				(self dispose:)
			else
				(gCurRoom setScript: sAnythingElse)
			)
		)
	)
)

(instance sBuilding of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(SetFlag 153)
					(gGame handsOff:)
					(harrietStill dispose:)
					(proc1111_7 4110 27 -50)
					(gCurRoom drawPic: 3560)
				)
				(1
					(proc1111_7 4111 59 -15 gEgo 200)
					(gCurRoom drawPic: 3935)
				)
				(2
					(proc1111_7 4112 102 23 gEgo 200 1)
					(gCurRoom drawPic: 3925)
				)
				(3
					(gCurRoom setScript: sAnythingElse)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(SetFlag 153)
			(gCurRoom setScript: sAnythingElse)
		)
	)
)

(instance sGiveCards of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(harrietStill dispose:)
					(proc1111_7 4120 -8 -10 gEgo 200)
					(gCurRoom drawPic: 3560)
				)
				(1
					(proc1111_7 4121 -8 -26)
					(gCurRoom drawPic: 3950)
				)
				(2
					(gEgo put: 9) ; invTarot
					(gCurRoom setScript: sAnythingElse)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(gEgo put: 9) ; invTarot
			(gCurRoom setScript: sAnythingElse)
		)
	)
)

(instance sGiveTarot of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(20
							(gEgo setHeading: 90 self 15)
						)
						(21
							(gEgo setHeading: 90 self 10)
						)
						(22
							(gEgo setHeading: 45 self 10)
						)
						(19
							(gEgo setHeading: 45 self)
						)
						(23
							(gEgo setHeading: 315 self)
						)
						(24
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(switch global125
						(19
							(if (gCast contains: mike)
								(mike hide:)
							)
							(if (gCast contains: harriet)
								(harriet hide:)
							)
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(proc1111_7 438 85 -39)
							(gCurRoom drawPic: 3640)
						)
						(23
							(if (gCast contains: mike)
								(mike hide:)
							)
							(if (gCast contains: harriet)
								(harriet hide:)
							)
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(proc1111_7 436 -5 -31)
							(gCurRoom drawPic: 3640)
						)
						(24
							(if (gCast contains: mike)
								(mike hide:)
							)
							(if (gCast contains: harriet)
								(harriet hide:)
							)
							(fire
								init:
								cycleSpeed: 8
								cycleSpeed: 8
								setCycle: RandCycle
							)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(proc1111_7 436 -10 -31)
							(gCurRoom drawPic: 3640)
						)
						(else
							(self changeState: 2)
						)
					)
				)
				(2
					(if (gCast contains: fire)
						(fire dispose:)
					)
					(if (gCast contains: theCat)
						(theCat dispose:)
					)
					(if (gCast contains: libDoor)
						(libDoor dispose:)
					)
					(harriet hide:)
					(proc1111_7 4241 -77 0)
					(gCurRoom drawPic: 3920)
				)
				(3
					(harriet show:)
					(gEgo
						show:
						posn: 138 88
						normalize: 6
						setScaler: Scaler 65 32 128 82
						put: 9 ; invTarot
					)
					(= global125 20)
					(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(if (gCast contains: fire)
				(fire dispose:)
			)
			(if (gCast contains: theCat)
				(theCat dispose:)
			)
			(if (gCast contains: libDoor)
				(libDoor dispose:)
			)
			(harriet show:)
			(gEgo
				show:
				posn: 138 88
				normalize: 6
				setScaler: Scaler 65 32 128 82
				put: 9 ; invTarot
			)
			(= global125 20)
			(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sCleans of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(SetFlag 153)
					(harriet hide:)
					(proc1111_7 4110 -42 -50 gEgo 200)
					(gCurRoom drawPic: 3560)
				)
				(1
					(proc1111_7 4111 59 -15 gEgo 200)
					(gCurRoom drawPic: 3935)
				)
				(2
					(proc1111_7 4112 102 23 gEgo 200)
					(gCurRoom drawPic: 3925)
				)
				(3
					(harriet show:)
					(gEgo
						show:
						posn: 138 88
						setScaler: Scaler 65 32 128 82
						normalize: 6
					)
					(= global125 20)
					(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(SetFlag 153)
			(harriet show:)
			(gEgo
				normalize: 6
				posn: 138 88
				setScaler: Scaler 65 32 128 82
				show:
			)
			(= global125 20)
			(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sHowsItGoing of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(20
							(gEgo setHeading: 45 self 5)
						)
						(21
							(gEgo setHeading: 270 self 5)
						)
						(22
							(gEgo setHeading: 270 self)
						)
						(19
							(gEgo setHeading: 45 self)
						)
						(23
							(gEgo setHeading: 315 self)
						)
						(24
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(if (gCast contains: mike)
						(mike hide:)
					)
					(if (gCast contains: harriet)
						(harriet hide:)
					)
					(switch global125
						(19
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(proc1111_7 438 95 -39)
							(gCurRoom drawPic: 3640)
						)
						(23
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(proc1111_7 438 15 -39)
							(gCurRoom drawPic: 3640)
						)
						(24
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(proc1111_7 438 -10 -39)
							(gCurRoom drawPic: 3640)
						)
						(else
							(self changeState: 2)
						)
					)
				)
				(2
					(if (gCast contains: fire)
						(fire dispose:)
					)
					(if (gCast contains: theCat)
						(theCat dispose:)
					)
					(if (gCast contains: libDoor)
						(libDoor dispose:)
					)
					(gEgo hide:)
					(proc1111_7 4290 175 30)
					(gCurRoom drawPic: 3970)
				)
				(3
					(if (gCast contains: harriet)
						(harriet show:)
					)
					(gEgo
						normalize: 6
						posn: 138 88
						setScaler: Scaler 65 32 128 82
						show:
					)
					(= global125 20)
					(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(gEgo
						setScaler: Scaler 65 32 128 82
						normalize: 6
						posn: 138 88
						show:
					)
					(if (gCast contains: harriet)
						(harriet show:)
					)
					(= global125 20)
					(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sFirstMeeting of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(20
							(gEgo setHeading: 90 self 15)
						)
						(21
							(gEgo setHeading: 0 self 15)
						)
						(22
							(gEgo setHeading: 270 self 15)
						)
						(19
							(gEgo setHeading: 45 self)
						)
						(23
							(gEgo setHeading: 315 self)
						)
						(24
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(mike hide:)
					(switch global125
						(19
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(proc1111_7 438 85 -39)
							(gCurRoom drawPic: 3640)
						)
						(23
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(proc1111_7 436 -5 -31)
							(gCurRoom drawPic: 3640)
						)
						(24
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(proc1111_7 436 -10 -31)
							(gCurRoom drawPic: 3640)
						)
						(else
							(self changeState: 2)
						)
					)
				)
				(2
					(if (gCast contains: fire)
						(fire dispose:)
					)
					(if (gCast contains: theCat)
						(theCat dispose:)
					)
					(if (gCast contains: libDoor)
						(libDoor dispose:)
					)
					(lPhone3970 init:)
					(lToolBox3970 init:)
					(proc1111_7 4580 111 -8)
					(gCurRoom drawPic: 3970)
				)
				(3
					(lPhone3970 hide:)
					(lToolBox3970 hide:)
					(proc1111_7 4581 45 -27)
					(gCurRoom drawPic: 3980)
				)
				(4
					(proc1111_7 4582 -16 -44)
					(gCurRoom drawPic: 3990)
				)
				(5
					(lPhone3970 show:)
					(lToolBox3970 show:)
					(proc1111_7 4583 120 9)
					(gCurRoom drawPic: 3970)
				)
				(6
					(lPhone3970 dispose:)
					(lToolBox3970 dispose:)
					(mike show:)
					(gEgo posn: 170 89 normalize: 1)
					(= global125 21)
					(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(if (gCast contains: lPhone3970)
				(lPhone3970 dispose:)
				(lToolBox3970 dispose:)
			)
			(if (gCast contains: fire)
				(fire dispose:)
			)
			(if (gCast contains: theCat)
				(theCat dispose:)
			)
			(if (gCast contains: libDoor)
				(libDoor dispose:)
			)
			(mike show:)
			(gEgo posn: 170 89 normalize: 1)
			(= global125 21)
			(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sDonArgues of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(if (gCast contains: mike)
						(mike dispose:)
					)
					(proc1111_7 4831 46 -31)
				)
				(1
					(proc1111_7 4832 79 37)
					(gCurRoom drawPic: (+ 3560 (== gChapter 5)))
				)
				(2
					(gEgo hide:)
					(proc1111_7 4833 1 0 gEgo -1 1)
					(gCurRoom drawPic: 3570)
				)
				(3
					(gGame fade: 100 0 2)
					(= cycles 50)
				)
				(4
					(global114 stop: 0)
					(gGame fadeSpeed: 4)
					(gCurRoom newRoom: 44) ; chapEndRm
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(global114 stop: 0)
			(gEgo hide:)
			(gGame fadeSpeed: 4)
			(gCurRoom newRoom: 44) ; chapEndRm
		)
	)
)

(instance sApologize of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(20
							(gEgo setHeading: 90 self 15)
						)
						(21
							(gEgo setHeading: 0 self 15)
						)
						(22
							(gEgo setHeading: 270 self 15)
						)
						(19
							(gEgo setHeading: 45 self)
						)
						(23
							(gEgo setHeading: 315 self)
						)
						(24
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(mike hide:)
					(switch global125
						(19
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(proc1111_7 438 85 -39)
							(gCurRoom drawPic: 3640)
						)
						(23
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(proc1111_7 436 -5 -31)
							(gCurRoom drawPic: 3640)
						)
						(24
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(proc1111_7 436 -10 -31)
							(gCurRoom drawPic: 3640)
						)
						(else
							(self changeState: 2)
						)
					)
				)
				(2
					(if (gCast contains: fire)
						(fire dispose:)
					)
					(if (gCast contains: theCat)
						(theCat dispose:)
					)
					(if (gCast contains: libDoor)
						(libDoor dispose:)
					)
					(lDoor3470 init:)
					(rDoor3470 init:)
					(global114 pause:)
					(proc1111_7 5430 -17 -33)
					(lPhone3470 init:)
					(lToolBox3470 init:)
					(gCurRoom drawPic: 3470)
				)
				(3
					(lPhone3470 hide:)
					(lToolBox3470 hide:)
					(lDoor3470 hide:)
					(rDoor3470 hide:)
					(proc1111_7 5431 66 -43)
					(gCurRoom drawPic: 3980)
				)
				(4
					(proc1111_7 5432 58 -42)
					(gCurRoom drawPic: 3990)
				)
				(5
					(proc1111_7 5433 5 -42)
					(gCurRoom drawPic: 3980)
				)
				(6
					(lDoor3470 show:)
					(rDoor3470 show:)
					(lPhone3470 show:)
					(lToolBox3470 show:)
					(proc1111_7 5434 -16 -35)
					(gCurRoom drawPic: (+ 3470 (== gChapter 5)))
				)
				(7
					(lDoor3470 dispose:)
					(rDoor3470 dispose:)
					(lPhone3470 dispose:)
					(lToolBox3470 dispose:)
					(mike show:)
					(global114 endPause:)
					(gEgo posn: 170 89 normalize: 2)
					(= global125 21)
					(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(if (gCast contains: fire)
				(fire dispose:)
			)
			(if (gCast contains: theCat)
				(theCat dispose:)
			)
			(if (gCast contains: libDoor)
				(libDoor dispose:)
			)
			(if (gCast contains: lDoor3470)
				(lDoor3470 dispose:)
				(rDoor3470 dispose:)
				(lPhone3470 dispose:)
				(lToolBox3470 dispose:)
			)
			(mike show:)
			(global114 endPause: 1)
			(gEgo posn: 170 89 normalize: 2)
			(= global125 21)
			(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sOK of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(20
							(gEgo setHeading: 90 self 15)
						)
						(21
							(gEgo setHeading: 0 self 15)
						)
						(22
							(gEgo setHeading: 270 self 15)
						)
						(19
							(gEgo setHeading: 45 self)
						)
						(23
							(gEgo setHeading: 315 self)
						)
						(24
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(mike hide:)
					(switch global125
						(19
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(proc1111_7 438 85 -39)
							(gCurRoom drawPic: 3640)
						)
						(23
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(proc1111_7 436 -5 -31)
							(gCurRoom drawPic: 3640)
						)
						(24
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(proc1111_7 436 -10 -31)
							(gCurRoom drawPic: 3640)
						)
						(else
							(self changeState: 2)
						)
					)
				)
				(2
					(if (gCast contains: fire)
						(fire dispose:)
					)
					(if (gCast contains: theCat)
						(theCat dispose:)
					)
					(if (gCast contains: libDoor)
						(libDoor dispose:)
					)
					(lPhone3970 init:)
					(lToolBox3970 init:)
					(proc1111_7 4590 104 5)
					(gCurRoom drawPic: 3970)
				)
				(3
					(lPhone3970 dispose:)
					(lToolBox3970 dispose:)
					(mike show:)
					(gEgo posn: 170 89 normalize: 2)
					(= global125 21)
					(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(if (gCast contains: fire)
				(fire dispose:)
			)
			(if (gCast contains: theCat)
				(theCat dispose:)
			)
			(if (gCast contains: libDoor)
				(libDoor dispose:)
			)
			(if (gCast contains: lPhone3970)
				(lPhone3970 dispose:)
				(lToolBox3970 dispose:)
			)
			(mike show:)
			(gEgo posn: 170 89 normalize: 2)
			(= global125 21)
			(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sCheckPhone of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(mike dispose:)
					(switch global125
						(19
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(proc1111_7 438 85 -39)
						)
						(23
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(proc1111_7 436 -5 -31)
						)
					)
				)
				(1
					(if (gCast contains: fire)
						(fire dispose:)
					)
					(if (gCast contains: theCat)
						(theCat dispose:)
					)
					(if (gCast contains: libDoor)
						(libDoor dispose:)
					)
					(lDoor3470 init:)
					(rDoor3470 init:)
					(lPhone3470 init:)
					(proc1111_7 5840 -4 -27)
					(gCurRoom drawPic: 3470)
				)
				(2
					(lPhone3470 hide:)
				)
				(3
					(lPhone3470 show:)
				)
				(4
					(lPhone3470 hide:)
					(lDoor3470 hide:)
					(rDoor3470 hide:)
					(proc1111_7 5841 24 -43)
					(gCurRoom drawPic: 3990)
				)
				(5
					(lDoor3470 show:)
					(rDoor3470 show:)
					(lPhone3470 show:)
					(lToolBoxClosed3470 init:)
					(proc1111_7 5842 46 -16)
					(gCurRoom drawPic: 3470)
				)
				(6
					(lToolBoxClosed3470 dispose:)
				)
				(7
					(lPhone3470 dispose:)
					(lDoor3470 dispose:)
					(rDoor3470 dispose:)
					(lDoor3590 init:)
					(proc1111_7 5843 -122 -11)
					(gCurRoom drawPic: 3590)
				)
				(8
					(lDoor3590 dispose:)
					(proc1111_7 5844 2 -44)
					(gCurRoom drawPic: 3980)
				)
				(9
					(gEgo hide:)
					(proc1111_7 5845 0 0 gEgo -1 1)
					(gCurRoom drawPic: 3590)
				)
				(10
					(SetFlag 200)
					(= global125 0)
					(gCurRoom newRoom: 28700)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(SetFlag 200)
			(= global125 0)
			(gCurRoom newRoom: 28700)
		)
	)
)

(instance sCheckPhoneOutside of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(mike view: 437 posn: 78 111 init: setCycle: Fwd)
					(lPhone3470 init:)
					(rDoor3470 init:)
					(if (== gChapter 5)
						(proc1111_7 433 145 -35)
					else
						(proc1111_7 432 106 -17)
					)
				)
				(1
					(mike view: 4580 posn: 165 87)
					(lPhone3470 hide:)
					(rDoor3470 hide:)
					(gEgo posn: 184 89 normalize: 2)
					(gCurRoom drawPic: 3900)
					(= seconds 2)
				)
				(2
					(mike dispose:)
					(rDoor3470 show:)
					(lDoor3470 init:)
					(lPhone3470 show:)
					(proc1111_7 5840 -4 -27)
					(gCurRoom drawPic: 3470)
				)
				(3
					(lPhone3470 hide:)
				)
				(4
					(lPhone3470 show:)
				)
				(5
					(lDoor3470 hide:)
					(rDoor3470 hide:)
					(lPhone3470 hide:)
					(proc1111_7 5841 24 -43)
					(gCurRoom drawPic: 3990)
				)
				(6
					(lDoor3470 show:)
					(rDoor3470 show:)
					(lPhone3470 show:)
					(lToolBoxClosed3470 init:)
					(proc1111_7 5842 46 -16)
					(gCurRoom drawPic: 3470)
				)
				(7
					(lToolBoxClosed3470 dispose:)
				)
				(8
					(lPhone3470 dispose:)
					(lDoor3470 dispose:)
					(rDoor3470 dispose:)
					(lDoor3590 init:)
					(proc1111_7 5843 -122 -11)
					(gCurRoom drawPic: 3590)
				)
				(9
					(lDoor3590 dispose:)
					(proc1111_7 5844 2 -44)
					(gCurRoom drawPic: 3980)
				)
				(10
					(gEgo hide:)
					(proc1111_7 5845 0 0 gEgo -1 1)
					(gCurRoom drawPic: 3590)
				)
				(11
					(SetFlag 200)
					(= global125 0)
					(gCurRoom newRoom: 28700)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(SetFlag 200)
			(= global125 0)
			(gCurRoom newRoom: 28700)
		)
	)
)

(instance sCheckPhoneDwnStairs of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= local1 (= state newState))
				(0
					(proc1111_7 471 38 30)
				)
				(1
					(lDoor3470 init:)
					(rDoor3470 init:)
					(lPhone3470 init:)
					(proc1111_7 5840 -4 -27)
					(gCurRoom drawPic: 3470)
				)
				(2
					(lPhone3470 hide:)
				)
				(3
					(lPhone3470 show:)
				)
				(4
					(lDoor3470 hide:)
					(rDoor3470 hide:)
					(lPhone3470 hide:)
					(proc1111_7 5841 24 -43)
					(gCurRoom drawPic: 3990)
				)
				(5
					(lDoor3470 show:)
					(rDoor3470 show:)
					(lPhone3470 show:)
					(lToolBoxClosed3470 init:)
					(proc1111_7 5842 46 -16)
					(gCurRoom drawPic: 3470)
				)
				(6
					(lToolBoxClosed3470 dispose:)
				)
				(7
					(lPhone3470 dispose:)
					(lDoor3470 dispose:)
					(rDoor3470 dispose:)
					(lDoor3590 init:)
					(proc1111_7 5843 -122 -11)
					(gCurRoom drawPic: 3590)
				)
				(8
					(lDoor3590 dispose:)
					(proc1111_7 5844 2 -44)
					(gCurRoom drawPic: 3980)
				)
				(9
					(gEgo hide:)
					(proc1111_7 5845 0 0 gEgo -1 1)
					(gCurRoom drawPic: 3590)
				)
				(10
					(SetFlag 200)
					(= global125 0)
					(gCurRoom newRoom: 28700)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(if local1
				(SetFlag 200)
				(= global125 0)
				(gCurRoom newRoom: 28700)
			else
				(self changeState: 1)
			)
		)
	)
)

(instance sCyrusTells of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 194)
					(proc1111_7 4920 0 0)
				)
				(1
					(lDoor3951 init:)
					(proc1111_7 4921 27 -44)
					(gCurRoom drawPic: 3951)
				)
				(2
					(lDoor3951 hide:)
					(proc1111_7 4922 -5 -27 gEgo 200)
					(gCurRoom drawPic: 3561)
				)
				(3
					(lDoor3951 show:)
					(proc1111_7 4923 -41 -32)
					(gCurRoom drawPic: 3951)
				)
				(4
					(lDoor3951 dispose:)
					(global114 pause:)
					(if (gEgo has: 9) ; invTarot
						(proc1111_7 4925 97 1)
						(gEgo put: 9) ; invTarot
					else
						(proc1111_7 4924 76 -23)
					)
					(gCurRoom drawPic: 3941)
				)
				(5
					(global114 endPause:)
					(gEgo posn: 170 89 normalize: 0)
					(= global125 21)
					(gCurRoom drawPic: 3901)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(if (gCast contains: lDoor3951)
				(lDoor3951 dispose:)
			)
			(global114 endPause: 1)
			(gEgo put: 9 posn: 170 89 normalize: 0) ; invTarot
			(= global125 21)
			(gCurRoom drawPic: 3901)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sDoorsSlam of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(20
							(gEgo setHeading: 90 self 15)
						)
						(21
							(gEgo setHeading: 90 self)
						)
						(22
							(gEgo setHeading: 45 self 10)
						)
						(19
							(gEgo setHeading: 45 self)
						)
						(23
							(gEgo setHeading: 315 self)
						)
						(24
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(switch global125
						(19
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(proc1111_7 438 85 -39)
							(gCurRoom drawPic: 3640)
						)
						(23
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(proc1111_7 436 -5 -31)
							(gCurRoom drawPic: 3640)
						)
						(24
							(fire init: cycleSpeed: 8 setCycle: RandCycle)
							(theCat init: cycleSpeed: 60 setCycle: RandCycle)
							(libDoor init:)
							(proc1111_7 436 -10 -31)
							(gCurRoom drawPic: 3640)
						)
						(else
							(self changeState: 2)
						)
					)
				)
				(2
					(if (gCast contains: fire)
						(fire dispose:)
					)
					(if (gCast contains: theCat)
						(theCat dispose:)
					)
					(if (gCast contains: libDoor)
						(libDoor dispose:)
					)
					(gEgo hide:)
					(global114 pause:)
					(= register 1)
					(proc1111_7 5931 0 0 gEgo -1 1)
					(gCurRoom drawPic: 3830)
				)
				(3
					(SetFlag 202)
					(gCurRoom newRoom: 2200)
				)
			)
		else
			(if (not register)
				(global114 pause:)
			)
			(proc1111_6)
			(= global115 0)
			(SetFlag 202)
			(gCurRoom newRoom: 2200)
		)
	)
)

(instance sDoor of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo hide:)
					(lDoor3830 init:)
					(proc1111_7 5941 79 17)
				)
				(1
					(lDoor3830 dispose:)
					(SetFlag 202)
					(frontDoor dispose:)
					(gEgo
						posn: 184 89
						normalize: 2
						setScaler: Scaler 65 32 128 82
						show:
					)
					(= global125 22)
					(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
					(gGame handsOn:)
					(global114 endPause:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(global114 endPause:)
			(if (gCast contains: lDoor3830)
				(lDoor3830 dispose:)
			)
			(if (gCast contains: frontDoor)
				(frontDoor dispose:)
			)
			(SetFlag 202)
			(gEgo
				posn: 184 89
				normalize: 2
				setScaler: Scaler 65 32 128 82
				show:
			)
			(= global125 22)
			(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sDoGypsy of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= local1 (= state newState))
				(0
					(switch global125
						(19
							(gEgo setHeading: 90 self)
						)
						(20
							(gEgo setHeading: 90 self 15)
						)
						(21
							(gEgo setHeading: 90 self 15)
						)
						(22
							(gEgo setHeading: 135 self 15)
						)
						(23
							(gEgo setHeading: 45 self)
						)
						(24
							(gEgo setHeading: 0 self 10)
						)
					)
				)
				(1
					(if (gCast contains: mike)
						(mike hide:)
					)
					(if (gCast contains: harriet)
						(harriet hide:)
					)
					(switch gChapter
						(1
							(proc1111_7 500 12 -10)
						)
						(2
							(proc1111_7 505 41 16)
						)
						(else
							(proc1111_7 507 104 30)
						)
					)
					(gCurRoom drawPic: 3780)
				)
				(2
					(if (> gChapter 2)
						(self changeState: 4)
					else
						(gEgo hide:)
						(coin init:)
						(gCurRoom drawPic: 3810)
						(= seconds 5)
					)
				)
				(3
					(coin dispose:)
					(switch gChapter
						(1
							(proc1111_7 501 23 18)
						)
						(2
							(proc1111_7 506 60 21)
						)
					)
					(gCurRoom drawPic: 3780)
				)
				(4
					(gGDacSound pause: 1)
					(if (== gChapter 7)
						(proc1111_7 50405 98 0)
					else
						(proc1111_7 (+ 50399 gChapter) 98 0)
					)
					(gCurRoom drawPic: 3790)
				)
				(5
					(gGDacSound pause: 0)
					(proc1111_7 502 74 26)
					(gCurRoom drawPic: 3780)
				)
				(6
					(gEgo hide:)
					(gCurRoom drawPic: 3810)
					(switch gChapter
						(1
							(fortuneView view: 500 posn: -13 130 init:)
							(voiceOfAdrienne number: 3017 setLoop: 1 play: self)
							(SetFlag 19)
						)
						(2
							(fortuneView view: 2350 posn: 151 72 init:)
							(voiceOfAdrienne number: 3021 setLoop: 1 play: self)
							(SetFlag 20)
						)
						(3
							(fortuneView view: 3150 posn: 142 129 init:)
							(sfx number: 3032 setLoop: 1 play:)
							(voiceOfAdrienne number: 3033 setLoop: 1 play: self)
							(SetFlag 21)
						)
						(4
							(fortuneView view: 4170 posn: 0 130 init:)
							(voiceOfAdrienne number: 3042 setLoop: 1 play: self)
							(SetFlag 22)
						)
						(5
							(fortuneView view: 4940 posn: 147 109 init:)
							(voiceOfAdrienne number: 3052 setLoop: 1 play: self)
							(SetFlag 23)
						)
						(6
							(fortuneView view: 5420 posn: 0 145 init:)
							(voiceOfAdrienne number: 3063 setLoop: 1 play: self)
							(SetFlag 24)
						)
					)
				)
				(7
					(voiceOfAdrienne dispose:)
					(= seconds 3)
				)
				(8
					(fortuneView dispose:)
					(proc1111_7 503 55 16)
					(gCurRoom drawPic: 3780)
				)
				(9
					(if (gCast contains: mike)
						(mike show:)
					)
					(if (gCast contains: harriet)
						(harriet show:)
					)
					(gEgo
						posn: 240 99
						normalize: 2
						setScaler: Scaler 65 32 128 82
						show:
					)
					(= global125 24)
					(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(if local1
						(switch gChapter
							(1
								(SetFlag 19)
							)
							(2
								(SetFlag 20)
							)
							(3
								(SetFlag 21)
							)
							(4
								(SetFlag 22)
							)
							(5
								(SetFlag 23)
							)
							(6
								(SetFlag 24)
							)
						)
						(if (gCast contains: coin)
							(coin dispose:)
						)
						(if (gCast contains: fortuneView)
							(fortuneView dispose:)
						)
						(if (gCast contains: mike)
							(mike show:)
						)
						(if (gCast contains: harriet)
							(harriet show:)
						)
						(if (Sounds contains: voiceOfAdrienne)
							(voiceOfAdrienne dispose:)
						)
						(gEgo
							posn: 240 99
							normalize: 2
							setScaler: Scaler 65 32 128 82
							show:
						)
						(= global125 24)
						(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
						(gGame handsOn:)
						(self dispose:)
					else
						(gEgo setCycle: 0)
						(self changeState: 1)
					)
				)
			)
		)
	)
)

(instance sNoToken of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(19
							(gEgo setHeading: 90 self)
						)
						(20
							(gEgo setHeading: 90 self 15)
						)
						(21
							(gEgo setHeading: 90 self 15)
						)
						(22
							(gEgo setHeading: 135 self 15)
						)
						(23
							(gEgo setHeading: 45 self)
						)
						(24
							(gEgo setHeading: 0 self 10)
						)
					)
				)
				(1
					(if (gCast contains: mike)
						(mike hide:)
					)
					(if (gCast contains: harriet)
						(harriet hide:)
					)
					(proc1111_7 510 6 16)
					(gCurRoom drawPic: 3780)
				)
				(2
					(if (gCast contains: mike)
						(mike show:)
					)
					(if (gCast contains: harriet)
						(harriet show:)
					)
					(gEgo
						posn: 240 99
						normalize: 2
						setScaler: Scaler 65 32 128 82
					)
					(= global125 24)
					(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(if (gCast contains: mike)
						(mike show:)
					)
					(if (gCast contains: harriet)
						(harriet show:)
					)
					(gEgo
						posn: 240 99
						normalize: 4
						setScaler: Scaler 65 32 128 82
					)
					(= global125 24)
					(gCurRoom drawPic: (+ 3900 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance fire of Prop
	(properties
		x 86
		y 80
		view 3640
	)
)

(instance theCat of Prop
	(properties
		x 115
		y 79
		view 3640
		loop 1
	)

	(method (init)
		(if (OneOf gChapter 1 4)
			(super init: &rest)
		)
	)
)

(instance harriet of Prop
	(properties
		x 37
		y 98
		view 0
	)

	(method (init)
		(super init: &rest)
		(self cycleSpeed: 6)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (IsFlag 190) (IsFlag 176) (not (IsFlag 153)))
					(gGame handsOff:)
					(gCurRoom setScript: sCleans)
				else
					(gGame handsOff:)
					(gCurRoom setScript: sHowsItGoing)
				)
			)
			(15 ; invTarot
				(gGame handsOff:)
				(SetFlag 179)
				(gGame handsOff:)
				(gCurRoom setScript: sGiveTarot)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mike of Prop
	(properties
		x 165
		y 87
		view 4580
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and (== gChapter 6) (not (IsFlag 201)))
						(SetFlag 201)
						(gGame handsOff:)
						(gCurRoom setScript: sApologize)
						(mike setHotspot: 0)
					)
					((and (== gChapter 4) (not (IsFlag 192)))
						(SetFlag 192)
						(gGame handsOff:)
						(gCurRoom setScript: sFirstMeeting)
					)
					(else
						(gGame handsOff:)
						(gCurRoom setScript: sOK)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sfx of Sound
	(properties)
)

(instance voiceOfAdrienne of Sound
	(properties)
)

(instance fortuneView of View
	(properties)
)

(instance libDoor of View
	(properties
		x 149
		y 63
		view 3640
		loop 2
	)

	(method (init)
		(if (not (IsFlag 14))
			(super init: &rest)
		)
	)
)

(instance coin of View
	(properties
		x 109
		y 99
		view 3810
	)
)

(instance lPhone3970 of View
	(properties
		x 125
		y 102
		priority 10
		fixPriority 1
		view 3970
	)
)

(instance lToolBox3970 of View
	(properties
		x 130
		y 114
		priority 10
		fixPriority 1
		view 3970
		cel 1
	)
)

(instance lPhone3570 of View ; UNUSED
	(properties
		x 16
		y 91
		priority 10
		fixPriority 1
		view 3571
	)
)

(instance lToolBox3470 of View
	(properties
		x 43
		y 117
		priority 10
		fixPriority 1
		view 3470
		cel 1
	)
)

(instance lToolBoxClosed3470 of View
	(properties
		x 64
		y 120
		priority 10
		fixPriority 1
		view 3470
		cel 2
	)
)

(instance lPhone3470 of View
	(properties
		x 37
		y 108
		priority 10
		fixPriority 1
		view 3470
	)
)

(instance lDoor3951 of View
	(properties
		x 125
		y 130
		priority 10
		fixPriority 1
		view 3951
	)
)

(instance lDoor3590 of View
	(properties
		x 20
		priority 10
		fixPriority 1
		view 3590
	)
)

(instance lDoor3830 of View
	(properties
		x 157
		y 44
		view 3831
	)
)

(instance lDoor3470 of View
	(properties
		x 232
		y 111
		loop 1
	)

	(method (init)
		(self view: (+ 3470 (== gChapter 5)))
		(super init: &rest)
	)
)

(instance rDoor3470 of View
	(properties
		x 232
		y 111
		loop 1
		cel 1
	)

	(method (init)
		(self view: (+ 3470 (== gChapter 5)))
		(super init: &rest)
	)
)

(instance harrietStill of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 221 14 214 14 191 19 185 21 175 27 168 36 166 42 132 69 95 80 80 89 74 112 80 130 268 131 266 117 254 104 230 89 211 78 208 69 221 48 224 37 223 32 225 26
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if local0
			(proc1111_9)
			(= local0 0)
		)
		(switch theVerb
			(4 ; Do
				(cond
					((IsFlag 371)
						((gCurRoom script:) cue:)
					)
					((or (not (IsFlag 176)) (IsFlag 153))
						(SetFlag 371)
						(gGame handsOff:)
						(gCurRoom setScript: sWaste)
					)
					((IsFlag 176)
						(SetFlag 153)
						(gGame handsOff:)
						(gCurRoom setScript: sBuilding)
					)
				)
			)
			(15 ; invTarot
				(gGame handsOff:)
				(SetFlag 179)
				(gGame handsOff:)
				(gCurRoom setScript: sGiveCards)
			)
			(else
				(gGame handsOff:)
				(gCurRoom setScript: sOther)
			)
		)
	)
)

(instance gypsy of Feature
	(properties
		nsLeft 227
		nsTop 65
		nsRight 247
		nsBottom 94
		x 240
		y 86
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(if
				(or
					(and (== gChapter 1) (IsFlag 19))
					(and (== gChapter 2) (IsFlag 20))
					(and (== gChapter 3) (IsFlag 21))
					(and (== gChapter 4) (IsFlag 22))
					(and (== gChapter 5) (IsFlag 23))
					(and (== gChapter 6) (IsFlag 24))
					(== gChapter 7)
				)
				(gGame handsOff:)
				(gCurRoom setScript: sNoToken)
			else
				(gGame handsOff:)
				(gCurRoom setScript: sDoGypsy)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance frontDoor of ExitFeature
	(properties
		nsLeft 174
		nsTop 49
		nsRight 203
		nsBottom 89
		x 190
		y 87
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(if (== gChapter 7)
				(if (IsFlag 202)
					(gGame handsOff:)
					(gCurRoom drawPic: 3830 setScript: sDoor)
				else
					(gGame handsOff:)
					(gCurRoom setScript: sDoorsSlam)
				)
			else
				(gGame handsOff:)
				(gCurRoom setScript: sExitOutSide)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance stairs of ExitFeature
	(properties
		nsLeft 69
		nsRight 138
		nsBottom 82
		x 101
		y 69
	)

	(method (doVerb theVerb)
		(switch theVerb
			(21 ; Exit
				(gGame handsOff:)
				(gCurRoom setScript: sUpTheStairs)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance southwestExit of ExitFeature
	(properties
		nsLeft 0
		nsTop 119
		nsRight 138
		nsBottom 130
		x 69
		y 124
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sExitSouthWest)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southeastExit of ExitFeature
	(properties
		nsLeft 138
		nsTop 119
		nsRight 293
		nsBottom 130
		x 215
		y 124
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sExitSouthEast)
		else
			(super doVerb: theVerb)
		)
	)
)

