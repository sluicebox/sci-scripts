;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
(include sci.sh)
(use Main)
(use Print)
(use Slider)
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

(procedure (localproc_0)
	(gGame_opt doit: 3)
)

(procedure (localproc_1)
	(= local0 global386)
	(= local1 (DoSound sndMASTER_VOLUME))
	(= local2 global386)
	(gGameControls
		window: gGcWindow
		add:
			(volumeSlider
				theObj: gGame
				selector: #masterVolume
				topValue: 15
				bottomValue: 0
				yourself:
			)
			(detailSlider
				theObj: detailCode
				selector: #doit
				topValue: 2
				bottomValue: 0
				yourself:
			)
			(paceSlider
				theObj: paceCode
				selector: #doit
				topValue: 1
				bottomValue: 15
				yourself:
			)
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

(procedure (localproc_2 param1)
	(return (>> param1 $000c))
)

(procedure (localproc_3 param1)
	(return (& (>> param1 $0006) $003f))
)

(procedure (localproc_4 param1)
	(return (>> param1 $0009))
)

(procedure (localproc_5 param1)
	(return (& (>> param1 $0005) $000f))
)

(procedure (localproc_6 param1)
	(return (& param1 $001f))
)

(instance setGC of Code
	(properties)

	(method (doit)
		(localproc_1)
	)
)

(instance volumeSlider of Slider
	(properties
		view 901
		loop 8
		cel 4
		nsLeft 78
		nsTop 19
		signal 128
		noun 10
		modNum 14
		helpVerb 4
		sliderView 901
		sliderLoop 8
		yStep 2
	)
)

(instance detailSlider of Slider
	(properties
		view 901
		loop 8
		cel 5
		nsLeft 121
		nsTop 19
		signal 128
		noun 9
		modNum 14
		helpVerb 4
		sliderView 901
		sliderLoop 8
		sliderCel 1
		yStep 2
	)
)

(instance paceSlider of Slider
	(properties
		view 901
		loop 8
		cel 6
		nsLeft 158
		nsTop 19
		signal 128
		noun 8
		modNum 14
		helpVerb 4
		sliderView 901
		sliderLoop 8
		sliderCel 2
		yStep 2
	)
)

(instance iconRestart of ControlIcon
	(properties
		view 901
		loop 1
		cel 0
		nsLeft 5
		nsTop 4
		signal 387
		highlightColor -1
		noun 7
		modNum 14
		helpVerb 4
	)

	(method (doit &tmp [temp0 20])
		(cond
			((== gCurRoomNum 975) ; chooseGame
				(= local3 (GetPort))
				(Message msgGET 14 7 44 0 1 @global550) ; "The Games Button is used for getting to this screen from anywhere else in the game."
				(Print addText: @global550 init:)
				(SetPort local3)
			)
			(
				(or
					(== gCurRoomNum 3) ; selectPlayers
					(== gCurRoomNum 2) ; intro
					(== gCurRoomNum 21) ; gameIntros
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
				(if global461
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
		view 901
		loop 2
		cel 0
		nsLeft 5
		nsTop 19
		signal 387
		highlightColor -1
		noun 6
		modNum 14
		helpVerb 4
	)

	(method (doit)
		((ScriptID 930 0) init: 913 0 900) ; yesNo
		(DisposeScript 930)
		(if global461
			(gGame quitGame:)
			(gGameControls hide:)
			(proc0_8 0)
			(localproc_0)
		)
	)
)

(instance iconReplay of ControlIcon
	(properties
		view 901
		loop 3
		cel 0
		nsLeft 5
		nsTop 33
		signal 387
		highlightColor -1
		noun 5
		modNum 14
		helpVerb 4
	)

	(method (doit &tmp [temp0 20])
		(if
			(or
				(== gCurRoomNum 100) ; crazy8s
				(== gCurRoomNum 200) ; oldMaid
				(== gCurRoomNum 300) ; heartsGame
				(== gCurRoomNum 400) ; ginRummy
				(== gCurRoomNum 500) ; cribbage
				(== gCurRoomNum 600) ; klondike
				(== gCurRoomNum 700) ; bridge
				(== gCurRoomNum 800) ; euchre
			)
			((ScriptID 930 0) init: 913 1 gCurRoomNum) ; yesNo
			(DisposeScript 930)
			(if global461
				(= gNewRoomNum gCurRoomNum)
				(= gCurRoomNum 0)
				(gCurRoom style: -32768)
				(gGameControls hide:)
				(proc0_8 0)
				(= global199 1)
				(Animate (gCast elements:) 0)
				(localproc_0)
			)
		else
			(= local3 (GetPort))
			(Message msgGET 14 5 45 0 1 @global550) ; "The Replay Button will allow you to replay one of the card games when you are in a game."
			(Print addText: @global550 init:)
			(SetPort local3)
		)
	)
)

(instance iconTime of ControlIcon
	(properties
		view 901
		loop 4
		cel 0
		nsLeft 5
		nsTop 47
		signal 387
		highlightColor -1
		noun 4
		modNum 14
		helpVerb 4
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= local3 (GetPort))
		(= temp5 (GetTime 1)) ; SysTime12
		(= temp6 (GetTime 3)) ; SysDate
		(= temp0 (localproc_2 temp5))
		(= temp1 (localproc_3 temp5))
		(for ((= temp2 (localproc_4 temp6))) (> temp2 99) ((-= temp2 100))
		)
		(= temp3 (localproc_5 temp6))
		(= temp4 (localproc_6 temp6))
		((ScriptID 911 0) init: temp0 temp1 temp3 temp4 temp2) ; MISSING SCRIPT
		(DisposeScript 911)
		(SetPort local3)
	)
)

(instance iconMusic of ControlIcon
	(properties
		view 901
		loop 5
		cel 0
		nsLeft 5
		nsTop 61
		signal 387
		highlightColor -1
		noun 12
		modNum 14
		helpVerb 4
	)

	(method (doit)
		((ScriptID 914 0) init:) ; doMusicControls
		(DisposeScript 914)
	)
)

(instance iconHelp of ControlIcon
	(properties
		view 901
		loop 6
		cel 0
		nsLeft 5
		nsTop 75
		cursor 995
		message 0
		signal 387
		highlightColor -1
		noun 2
		modNum 14
		helpVerb 4
	)

	(method (doit)
		(super doit: &rest)
	)
)

(instance iconOK of ControlIcon
	(properties
		view 901
		loop 7
		cel 0
		nsLeft 5
		nsTop 89
		signal 387
		highlightColor -1
		noun 1
		modNum 14
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

