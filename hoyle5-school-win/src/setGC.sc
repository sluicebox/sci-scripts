;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
(include sci.sh)
(use Main)
(use Print)
(use GameControls)
(use System)

(public
	setGC 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0))

(procedure (localproc_1)
	(= local0 global386)
	(= local1 (DoSound sndMASTER_VOLUME))
	(= local2 global386)
	(gGameControls
		plane: gGcWindow
		add:
			(volumeSlider theObj: gGame selector: #masterVolume yourself:)
			(detailSlider theObj: detailCode selector: #doit yourself:)
			(paceSlider theObj: paceCode selector: #doit yourself:)
			(iconRestart theObj: iconRestart selector: #doit yourself:)
			(iconQuit theObj: iconQuit selector: #doit yourself:)
			(iconReplay theObj: iconReplay selector: #doit yourself:)
			(iconTime theObj: iconTime selector: #doit yourself:)
			(iconMusic theObj: iconMusic selector: #doit yourself:)
			(iconHelp theObj: iconHelp selector: #doit yourself:)
			(iconOK theObj: iconOK selector: #doit yourself:)
		helpIconItem: iconHelp
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
	)
)

(procedure (localproc_2 param1 param2 param3)
	(if (< param2 param1)
		(= param2 param1)
	)
	(if (> param2 param3)
		(= param2 param3)
	)
	(return param2)
)

(procedure (localproc_3 param1)
	(return (>> param1 $000c))
)

(procedure (localproc_4 param1)
	(return (& (>> param1 $0006) $003f))
)

(procedure (localproc_5 param1)
	(return (+ 80 (>> param1 $0009)))
)

(procedure (localproc_6 param1)
	(return (& (>> param1 $0005) $000f))
)

(procedure (localproc_7 param1)
	(return (& param1 $001f))
)

(instance setGC of Code
	(properties)

	(method (doit)
		(localproc_1)
	)
)

(instance volumeSlider of ControlIcon
	(properties
		noun 10
		modNum 14
		nsLeft 78
		nsTop 19
		x 93
		y 29
		signal 128
		mainView 901
		mainLoop 8
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(self setPri: 255)
		(super init: &rest)
	)

	(method (select &tmp temp0 temp1 temp2)
		(= temp2 temp1) ; UNINIT
		(self setPri: 255)
		(self y: (* (+ 29 (gGame masterVolume:)) 5))
		(UpdateScreenItem self)
		(FrameOut)
		(repeat
			(= temp0 (Event new:))
			(temp0 localize: plane)
			(= temp1 (temp0 y:))
			(self y: (localproc_2 29 temp1 94))
			(if (!= temp2 (self y:))
				(gGame masterVolume: (- 13 (/ (- (self y:) 29) 5)))
				(= temp2 (self y:))
				(UpdateScreenItem self)
				(FrameOut)
			)
			(if (== (temp0 type:) evMOUSERELEASE)
				(break)
			)
			(temp0 dispose:)
		)
		(temp0 dispose:)
	)
)

(instance detailSlider of ControlIcon
	(properties
		noun 9
		modNum 14
		nsLeft 121
		nsTop 19
		x 136
		y 29
		signal 128
		mainView 901
		mainLoop 8
		mainCel 1
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(self setPri: 255)
		(super init: &rest)
	)

	(method (select &tmp temp0 temp1 temp2)
		(= temp2 temp1) ; UNINIT
		(self setPri: 255)
		(UpdateScreenItem self)
		(FrameOut)
		(repeat
			(= temp0 (Event new:))
			(temp0 localize: plane)
			(= temp1 (temp0 y:))
			(self y: (localproc_2 29 temp1 94))
			(if (!= temp2 (self y:))
				(= temp2 (self y:))
				(UpdateScreenItem self)
				(FrameOut)
			)
			(if (== (temp0 type:) evMOUSERELEASE)
				(break)
			)
			(temp0 dispose:)
		)
		(temp0 dispose:)
		(cond
			((< (self y:) 50)
				(= global387 2)
			)
			((< (self y:) 68)
				(= global387 1)
			)
			((< (self y:) 95)
				(= global387 0)
			)
		)
	)
)

(instance paceSlider of ControlIcon
	(properties
		noun 8
		modNum 14
		nsLeft 158
		nsTop 19
		x 173
		y 29
		signal 128
		mainView 901
		mainLoop 8
		mainCel 2
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(self setPri: 255)
		(super init: &rest)
	)

	(method (select &tmp temp0 temp1 temp2)
		(= temp2 temp1) ; UNINIT
		(self setPri: 255)
		(UpdateScreenItem self)
		(FrameOut)
		(repeat
			(= temp0 (Event new:))
			(temp0 localize: plane)
			(= temp1 (temp0 y:))
			(self y: (localproc_2 29 temp1 94))
			(if (!= temp2 (self y:))
				(= temp2 (self y:))
				(UpdateScreenItem self)
				(FrameOut)
			)
			(if (== (temp0 type:) evMOUSERELEASE)
				(break)
			)
			(temp0 dispose:)
		)
		(temp0 dispose:)
		(cond
			((< (self y:) 35)
				(= global386 10)
			)
			((< (self y:) 41)
				(= global386 9)
			)
			((< (self y:) 47)
				(= global386 8)
			)
			((< (self y:) 53)
				(= global386 7)
			)
			((< (self y:) 60)
				(= global386 6)
			)
			((< (self y:) 67)
				(= global386 5)
			)
			((< (self y:) 74)
				(= global386 4)
			)
			((< (self y:) 81)
				(= global386 3)
			)
			((< (self y:) 88)
				(= global386 2)
			)
			((< (self y:) 95)
				(= global386 1)
			)
		)
	)
)

(instance iconRestart of ControlIcon
	(properties
		noun 7
		modNum 14
		nsLeft 5
		nsTop 4
		x 5
		y 4
		priority 150
		signal 387
		mainView 901
		mainLoop 1
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(self setPri: 150)
		(super init: &rest)
	)

	(method (doit &tmp [temp0 21])
		(cond
			((== gCurRoomNum 975) ; chooseGame
				(Print
					addText: {You pressed the reset buttom in Choose Room}
					init:
				)
			)
			(
				(or
					(== gCurRoomNum 3) ; selectPlayers
					(== gCurRoomNum 2) ; intro
					(== gCurRoomNum 21)
					(== gCurRoomNum 19) ; credits
				)
				(= gNewRoomNum 975) ; chooseGame
				(= global107 1)
				(localproc_0)
				(gGameControls hide:)
			)
			(else
				((ScriptID 930 0) init: 913 2 gCurRoomNum) ; yesNo
				(DisposeScript 930)
				(if global748
					(EnableCursor)
					(= gNewRoomNum 975) ; chooseGame
					(= global107 1)
					(localproc_0)
					(gGameControls hide:)
					(PlaySong play: 0)
				)
			)
		)
	)
)

(instance iconQuit of ControlIcon
	(properties
		noun 6
		modNum 14
		nsLeft 5
		nsTop 19
		x 5
		y 19
		signal 387
		mainView 901
		mainLoop 2
		highlightColor -1
		helpVerb 4
	)

	(method (doit)
		((ScriptID 930 0) init: 913 0 900) ; yesNo
		(DisposeScript 930)
		(if global748
			(gGame quitGame:)
			(gGameControls hide:)
			(proc0_8 0)
			(localproc_0)
		)
	)
)

(instance iconReplay of ControlIcon
	(properties
		noun 5
		modNum 14
		nsLeft 5
		nsTop 33
		x 5
		y 33
		signal 387
		mainView 901
		mainLoop 3
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp [temp0 21])
		(if
			(or
				(== gCurRoomNum 100) ; crazy8s
				(== gCurRoomNum 200) ; oldMaid
				(== gCurRoomNum 300) ; heartsGame
				(== gCurRoomNum 400) ; ginRummy
				(== gCurRoomNum 500) ; cribbage
				(== gCurRoomNum 600) ; klondike
				(== gCurRoomNum 700)
				(== gCurRoomNum 800)
			)
			((ScriptID 930 0) init: 913 1 gCurRoomNum) ; yesNo
			(DisposeScript 930)
			(if global748
				(= gNewRoomNum gCurRoomNum)
				(= gCurRoomNum 0)
				(gCurRoom style: 256)
				(gGameControls hide:)
				(proc0_8 0)
				(= global199 1)
				(proc0_9 (gCast elements:) 0)
				(localproc_0)
			)
		else
			(Print
				addText:
					{you pressed the replay buttom and there is no game to replay}
				init:
			)
		)
	)
)

(instance iconTime of ControlIcon
	(properties
		noun 4
		modNum 14
		nsLeft 5
		nsTop 47
		x 5
		y 47
		signal 387
		mainView 901
		mainLoop 4
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp5 (GetTime 1)) ; SysTime12
		(= temp6 (GetTime 3)) ; SysDate
		(= temp0 (localproc_3 temp5))
		(= temp1 (localproc_4 temp5))
		(for ((= temp2 (localproc_5 temp6))) (> temp2 99) ((-= temp2 100))
		)
		(= temp3 (localproc_6 temp6))
		(= temp4 (localproc_7 temp6))
		((ScriptID 911 0) init: temp0 temp1 temp3 temp4 temp2) ; giveTimeCode
		(DisposeScript 911)
	)
)

(instance iconMusic of ControlIcon
	(properties
		noun 12
		modNum 14
		nsLeft 5
		nsTop 61
		x 5
		y 61
		signal 387
		mainView 901
		mainLoop 5
		highlightColor -1
		helpVerb 4
	)

	(method (doit)
		((ScriptID 914 0) init:) ; doMusicControls
		(DisposeScript 914)
	)
)

(instance iconHelp of ControlIcon
	(properties
		noun 2
		modNum 14
		nsLeft 5
		nsTop 75
		x 5
		y 75
		signal 387
		message 0
		mainView 901
		mainLoop 6
		cursorView 995
		highlightColor -1
		helpVerb 4
	)

	(method (doit)
		(super doit: &rest)
	)
)

(instance iconOK of ControlIcon
	(properties
		noun 1
		modNum 14
		nsLeft 5
		nsTop 89
		x 5
		y 89
		signal 387
		mainView 901
		mainLoop 7
		highlightColor -1
		helpVerb 4
	)

	(method (doit)
		(gGameControls hide:)
		(proc0_8 0)
		(localproc_0)
	)
)

(instance detailCode of Code
	(properties)

	(method (doit param1)
		(return
			(if argc
				(= global387 param1)
			else
				global387
			)
		)
	)
)

(instance paceCode of Code
	(properties)

	(method (doit param1)
		(return
			(if argc
				(= global386 param1)
			else
				global386
			)
		)
	)
)

