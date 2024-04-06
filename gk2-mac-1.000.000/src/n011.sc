;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Main)
(use GK2Ego)
(use n051)
(use n052)
(use n053)
(use n054)
(use n055)
(use n056)
(use Str)
(use Print)
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
)

(local
	[local0 2]
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
	(if (!= (gCurInvView itemNumber:) 5)
		(gUser curVerb: 62)
		((gUser hotCursor:) show: update:)
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
		(gEgo normalize:)
		(if (gEgo scaler:)
			((gEgo scaler:) doit:)
		)
	)
	(if (gEgo has: 73) ; invPitcher
		(gGame disableInventory: 1)
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

(procedure (PlayVMDFile param1 &tmp temp0 temp1 temp2 temp3)
	(if (ResCheck 151 param1) ; VMD
		(if (or (gSoundManager pauseAll:) (< (gGame detailLevel:) 5))
			(gSounds pause:)
			(= temp3 1)
		)
		(= temp1 (Str newWith: 10 {}))
		(temp1 format: {%d.VMD} param1)
		(gTopMessage toggleText: param1)
		(PlayVMD 0 (temp1 data:)) ; Open
		(PlayVMD 23 16 256) ; RestrictPalette
		(if (IsFlag 34)
			(PlayVMD 1 165 98 128 25 16 256) ; Put
		else
			(PlayVMD 1 12 15 149 25 16 256) ; Put
		)
		(PlayVMD 21 12 15 627 349) ; Black
		(PlayVMD 14 32 10) ; WaitEvent
		(PlayVMD 14 7) ; WaitEvent
		(gTopMessage toggleText:)
		(PlayVMD 6) ; Close
		(temp1 dispose:)
	else
		(Printf {*** %d.vmd Not Found! ***} param1)
	)
	(if temp3
		(gSoundManager pauseAll: 0)
		(gSounds pause: 0)
		(gSounds eachElementDo: #check)
	)
	(while ((= temp2 (Event new: 3)) type:)
		(temp2 dispose:)
	)
	(temp2 dispose:)
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
	(gGame updateFrames:)
	(gThePlane setRect: 9 12 630 351 priority: 202)
	(gInterfacePlane hide:)
	(gCurRoom drawPic: (+ 10 gChapter))
	((= temp1 (View new:)) view: (+ 100 gChapter) x: 120 y: 122 init:)
	(proc11_13)
	((Print new:) y: 420 addButtonBM: (+ 100 gChapter) 1 0 0 {} 0 0 init:)
	(gThePlane setRect: 12 15 627 349 priority: 1)
	(= gNumCD gChapter)
	(gUser curVerb: 62)
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
			(gTopMessage newText: {Chapter One: Opening Movie})
			(= gEgo GabeEgo)
			(gEgo get: 5 get: 0 get: 6 get: 79 get: 86) ; invTalisman, invGabeCards, invTapeRecorder, invGabeNotebook, invManuscript
			(PlayScene 2 0 -1)
			(PlayScene 4 0 2103) ; farmIntRm2
		)
		(2
			(gTopMessage newText: {Chapter Two: Opening Movie})
			(= gEgo GraceEgo)
			(gEgo get: 17 get: 19 get: 20 get: 18) ; invBarclayCard, invGraceWallet, invGabeLetter1, invNotebookPen
			(PlayScene 117 0 140) ; srGabeRoom
		)
		(3
			(gTopMessage newText: {Chapter Three: Opening Movie})
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
			(SetFlag 412) ; enable "Die K\94niglich-Bayrische Hofjagdloge" in rm4220
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
			(gTopMessage newText: {Chapter Four: Opening Movie})
			(= gEgo GraceEgo)
			(gEgo get: 20 get: 17 get: 19 get: 21 get: 26 get: 18) ; invGabeLetter1, invBarclayCard, invGraceWallet, invScrewdriver, invLudwigLetter, invNotebookPen
			(PlayScene 412 0 140) ; srGabeRoom
		)
		(5
			(gTopMessage newText: {Chapter Five: Opening Movie})
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
			(gTopMessage newText: {Chapter Six: Opening Movie})
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
	(gTopMessage newText: 0)
	(gUser alterEgo: gEgo curVerb: 62)
	((gUser hotCursor:) update: set: 999 0 0 show:)
	(if (!= gChapter 6)
		((ScriptID 0 5) highlight: 0) ; recButton
	)
)

(procedure (proc11_15 param1)
	((ScriptID param1 0) knock:)
)

(procedure (proc11_17)
	(gMessager say: 27 62 0 1 0 120) ; "(PICKUP, GENERIC RESPONSE FOR USING INVENTORY ON SOMEONE)I don't think he'd be interested in that."
)

(procedure (proc11_18)
	(gMessager say: 26 62 0 1 0 120) ; "(PICKUP, GENERIC RESPONSE FOR USING INVENTORY ON SOMEONE)I'm not sure why she'd want to see THAT."
)

(instance doUpdateCode of Code ; UNUSED
	(properties)

	(method (doit param1)
		(if (not (& (param1 signal:) $0008))
			(UpdateScreenItem param1)
		)
	)
)

