;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 71)
(include sci.sh)
(use Main)
(use fileScr)
(use ego_90)
(use SpeedTest)
(use Plane)
(use Str)
(use Array)
(use Print)
(use Flags)
(use User)
(use System)

(public
	initCode 0
)

(instance initCode of Code
	(properties)

	(method (init &tmp temp0)
		(= global100 (ResCheck rsSCRIPT 911))
		(for ((= temp0 0)) (<= temp0 20) ((++ temp0))
			(= [global216 temp0] 0)
			(= [global237 temp0] 0)
		)
		(= global101 1234)
		(= global171 1)
		(= global176 -1)
		(gGame setCursor: gWaitCursor)
		(SetFontRes 640 480)
		((= gFlags (Flags new:)) name: {gameFlags} setSize: 300)
		(SetFlag 105)
		(gThePlane setRect: 0 15 319 154)
		(= global110 (== (Platform 4) 2))
		(= global105 (Graph 1))
		(= global136 200)
		((ScriptID 81) init:) ; ColorInit
		(DisposeScript 81)
		(User alterEgo: (= gEgo ego) canControl: 0 canInput: 0)
		(= gUseSortedFeatures 1)
		((= gGlobalSound1 (ScriptID 0 15)) owner: gGame init:) ; globalSound1
		((= gGlobalSound2 (ScriptID 0 16)) owner: gGame init:) ; globalSound2
		(= global167 1)
		((= gControlPlane (Plane new:))
			name: {controlPlane}
			back: 0
			init: 0 0 319 14
			priority: (+ (GetHighPlanePri) 1)
			addCast: (ScriptID 0 1) ; controlSet
		)
		((= gTalkerPlane (Plane new:))
			name: {talkerPlane}
			back: 0
			init: 0 155 319 199
			priority: (+ (GetHighPlanePri) 1)
			addCast: (ScriptID 0 13) ; talkerSet
		)
		((ScriptID 92 3) setPri: 200 init: (ScriptID 0 13) yourself:) ; larryTBust, talkerSet
		((ScriptID 914 0) init:) ; hiResMenu
		(Print back: 7 fore: 0 font: 2306)
		(gEgo setSpeed: global167)
		(= global104 (DoSound sndGET_POLYPHONY))
		((ScriptID 85) init:) ; LL6Inv
		(gTimers
			add:
				((ScriptID 85 1) client: (ScriptID 85 1) yourself:) ; mTimer, mTimer
				((ScriptID 85 2) client: (ScriptID 85 2) yourself:) ; cTimer, cTimer
				((ScriptID 85 4) client: (ScriptID 85 4) yourself:) ; wTimer, wTimer
				((ScriptID 0 12) client: (ScriptID 0 12) yourself:) ; sTimer, sTimer
		)
		(= global186 (ByteArray new: 200))
		(= global177 (Str new: 200))
		(= global190 (Str new: 200))
		(SetFlag 9)
		((ScriptID 88 0) init:) ; PointGauge
		((ScriptID 0 12) setReal: gGame 0 (= global183 10)) ; sTimer
		(gGame masterVolume: 12)
		(= gMasterVolume 11)
		(= global166 0)
		(= gHowFast (/ (* (- 10 (SpeedTest)) 15) 10))
		(gGame
			detailLevel:
				(cond
					((< gHowFast 3) 0)
					((< gHowFast 10) 2)
					(else 3)
				)
		)
		(= global193 (/ (* (gGame detailLevel:) 26) 10))
		(= global260 (MemoryInfo 0))
		(if (not gTextScroller)
			(= gTextScroller
				((ScriptID 0 20) ; textScroller
					nsLeft: 40
					nsTop: 157
					nsRight: 269
					nsBottom: 195
					init: (ScriptID 0 17) (ScriptID 0 18) (ScriptID 0 19) ; scrollBar, scrollBarUpIcon, scrollBarDownIcon
					yourself:
				)
			)
		)
	)
)

