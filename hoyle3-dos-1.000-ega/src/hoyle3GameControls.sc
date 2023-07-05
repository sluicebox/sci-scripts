;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 700)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use Interface)
(use GameControls)
(use System)

(public
	proc700_0 0
	hoyle3GameControls 1
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(if (or (!= global199 local0) (!= (DoSound sndMASTER_VOLUME) local1))
		(gGame_opt doit: 3)
	)
)

(procedure (proc700_0)
	(= local0 global199)
	(= local1 (DoSound sndMASTER_VOLUME))
	((= gGameControls hoyle3GameControls)
		window: gcWindow
		add:
			(speedSlider
				theObj: speedCode
				selector: #doit
				topValue: 1
				bottomValue: 15
				yourself:
			)
			(volumeSlider
				theObj: gGame
				selector: #masterVolume
				topValue: (if (> (DoSound sndGET_POLYPHONY) 1) 15 else 1)
				bottomValue: 0
				yourself:
			)
			(iconRestart theObj: iconRestart selector: #doit yourself:)
			(iconQuit theObj: iconQuit selector: #doit yourself:)
			(iconReplay theObj: iconReplay selector: #doit yourself:)
			(iconAbout theObj: iconAbout selector: #doit yourself:)
			iconHelp
			(iconOK theObj: iconOK selector: #doit yourself:)
		helpIconItem: iconHelp
		curIcon: (if (not (HaveMouse)) iconOK else 0)
	)
)

(instance hoyle3GameControls of GameControls
	(properties)
)

(instance gcWindow of InvisibleWindow
	(properties)

	(method (open &tmp temp0 temp1 temp2 temp3 temp4)
		(self top: 30 left: 72 bottom: 170 right: 251)
		(super open:)
		(DrawCel 701 0 0 0 0 15)
		(Graph grUPDATE_BOX temp0 temp1 (+ temp3 1) (+ temp2 1) 1) ; UNINIT, UNINIT, UNINIT, UNINIT
	)
)

(instance volumeSlider of Slider
	(properties
		view 701
		loop 1
		cel 1
		nsLeft 134
		nsTop 62
		signal 128
		helpStr {This slider will adjust the sound volume.}
		sliderView 701
		sliderLoop 1
		yStep 2
		topValue 15
	)
)

(instance speedSlider of Slider
	(properties
		view 701
		loop 1
		cel 1
		nsLeft 84
		nsTop 62
		signal 128
		helpStr {This slider will adjust the speed of the game's Text.}
		sliderView 701
		sliderLoop 1
		yStep 2
		bottomValue 15
	)
)

(instance iconRestart of ControlIcon
	(properties
		view 701
		loop 2
		cel 0
		nsLeft 12
		nsTop 13
		signal 387
		helpStr {GAMES BUTTON -\nThis Button will restart HOYLE 3 (after verification) so that you can select a new game to play.}
		highlightColor -1
	)

	(method (doit)
		(if (Print 700 0 #button {Yes} 1 #button {No} 0) ; "Select a game to play?"
			(= gNewRoomNum 975) ; chooseGame
			(gGameControls hide:)
			(= global107 1)
			(localproc_0)
		)
	)
)

(instance iconQuit of ControlIcon
	(properties
		view 701
		loop 3
		cel 0
		nsLeft 12
		nsTop 33
		signal 387
		helpStr {QUIT BUTTON -\nThis button will allow you to quit HOYLE 3 after first verifying that you really, really, reeeealy do indeed want to quit.}
		highlightColor -1
	)

	(method (doit)
		(gGame quitGame:)
		(if gQuit
			(gGameControls hide:)
			(localproc_0)
		)
	)
)

(instance iconReplay of ControlIcon
	(properties
		view 701
		loop 4
		cel 0
		nsLeft 12
		nsTop 53
		signal 387
		helpStr {REPLAY BUTTON -\nThis button will allow you to replay the same particular game that you are playing now, over again from the start.}
		highlightColor -1
	)

	(method (doit)
		(if
			(or
				(== gCurRoomNum 100) ; domino1
				(== gCurRoomNum 300) ; backgam
				(== gCurRoomNum 200) ; checkers
				(== gCurRoomNum 400) ; pachisi
				(== gCurRoomNum 500) ; yacht
				(== gCurRoomNum 600) ; snakes
			)
			(if (Print 700 1 #button {Yes} 1 #button {No} 0) ; "Replay the current game?"
				(= gNewRoomNum gCurRoomNum)
				(= gCurRoomNum 0)
				(gCurRoom style: -32768)
				(gGameControls hide:)
				(= global198 1)
				(Animate (gCast elements:) 0)
				(localproc_0)
			)
		else
			(Print 700 2) ; "This button has no function except while in a game."
		)
	)
)

(instance iconAbout of ControlIcon
	(properties
		view 701
		loop 5
		cel 0
		nsLeft 12
		nsTop 73
		signal 387
		helpStr {ABOUT BUTTON -\nBy pressing this button you can determine which version of HOYLE 3 that you are playing, and see who the many people are who created HOYLE 3.}
		highlightColor -1
	)

	(method (doit)
		(ScriptID 4 0) ; aboutCode
		(gGameControls hide:)
		((ScriptID 4 0) doit:) ; aboutCode
	)
)

(instance iconHelp of ControlIcon
	(properties
		view 701
		loop 6
		cel 0
		nsLeft 12
		nsTop 93
		cursor 29
		message 6
		signal 387
		helpStr {HELP BUTTON -\nThis is the button that you pressed to get help on other things. By placing this cursor on an item on the Control Panel and pressing the button, you will get a brief explanation of what each button or slider is for.}
		highlightColor -1
	)
)

(instance iconOK of ControlIcon
	(properties
		view 701
		loop 7
		cel 0
		nsLeft 12
		nsTop 113
		signal 387
		helpStr {OK BUTTON -\nPressing this button will put away the Game Control Panel and return you to whatever you were doing.}
		highlightColor -1
	)

	(method (doit)
		(gGameControls hide:)
		(localproc_0)
	)
)

(instance speedCode of Code
	(properties)

	(method (doit param1)
		(return
			(if argc
				(= global199 param1)
			else
				global199
			)
		)
	)
)

