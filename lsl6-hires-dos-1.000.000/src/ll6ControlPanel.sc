;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 94)
(include sci.sh)
(use Main)
(use Dial)
(use Array)
(use Print)
(use IconBar)
(use GameControls)
(use System)

(public
	ll6ControlPanel 0
)

(instance detailDial of Dial
	(properties
		noun 9
		modNum 94
		x 30
		y 2
		mainView 969
		helpVerb 14
		points 14
	)

	(method (update param1)
		(if argc
			(= global193 param1)
			(gGame
				detailLevel:
					(if param1
						(+ (/ (* param1 10) 28) 1)
					else
						1
					)
			)
		else
			(return global193)
		)
	)
)

(instance volumeDial of Dial
	(properties
		noun 8
		modNum 94
		x 30
		y 12
		mainView 969
		helpVerb 14
		points 14
	)

	(method (update param1)
		(if argc
			(= gMasterVolume param1)
			(gGame masterVolume: (and param1 (/ (* 1155 param1) 1000)))
		else
			(return gMasterVolume)
		)
	)
)

(instance speedDial of Dial
	(properties
		noun 10
		modNum 94
		x 30
		y 22
		mainView 969
		helpVerb 14
		points 14
	)

	(method (update param1)
		(if argc
			(gEgo setSpeed: (= global167 (- 14 param1)))
		else
			(return (- 14 global167))
		)
	)
)

(instance textDial of Dial
	(properties
		noun 11
		modNum 94
		x 30
		y 32
		mainView 969
		helpVerb 14
		points 14
	)

	(method (select &tmp temp0 temp1)
		(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
			(temp0 localize: plane)
			(= temp1 (self findClosestPoint: temp0))
			(cond
				((> curPos temp1)
					(self decrement:)
				)
				((< curPos temp1)
					(self increment:)
				)
			)
			(temp0 dispose:)
		)
		(temp0 dispose:)
		(while (!= cel 13)
			(self increment:)
		)
		(return curPos)
	)

	(method (update param1)
		(= param1 14)
	)
)

(instance question of ControlIcon
	(properties
		noun 4
		modNum 94
		x 46
		y 3
		signal 385
		mainView 969
		mainLoop 2
		cursorView 998
		cursorLoop 0
		cursorCel 6
		helpVerb 14
	)
)

(instance ok of ControlIcon
	(properties
		noun 7
		modNum 94
		x 46
		y 19
		signal 449
		mainView 969
		mainLoop 3
		helpVerb 14
	)

	(method (select)
		(return
			(if (super select: &rest)
				(gGame panelObj: 0 panelSelector: 0)
				(= gGameControls 0)
				1
			)
		)
	)
)

(instance ll6ControlPanel of GameControls
	(properties
		state 2048
	)

	(method (init &tmp temp0)
		(= gGameControls self)
		(super init: &rest)
		(plane
			setRect:
				130
				54
				(+ 129 (CelWide 969 1 0) (CelWide 969 2))
				(+ 52 (CelHigh 969 1 0))
		)
		(= temp0
			(IntArray
				with:
					3
					11
					1
					9
					0
					7
					0
					5
					0
					2
					1
					0
					3
					0
					5
					0
					8
					0
					9
					0
					11
					3
					11
					5
					11
					8
					10
					9
			)
		)
		(self
			add:
				(detailDial locations: temp0 yourself:)
				(volumeDial locations: temp0 yourself:)
				(speedDial locations: temp0 yourself:)
				(textDial locations: temp0 yourself:)
				ok
				(question theObj: question selector: #doit yourself:)
			eachElementDo: #highlightColor -1
			helpIconItem: question
			curIcon: ok
		)
		((IconI new:) mainView: 969 mainLoop: 1 init: self)
		(self show:)
		(temp0 dispose:)
		(DisposeScript 94)
	)

	(method (noClickHelp &tmp temp0 temp1 temp2 temp3)
		(= temp1 (= temp2 (= temp3 0)))
		(while (not ((= temp0 ((gUser curEvent:) new:)) type:))
			(temp0 localize: plane)
			(cond
				((= temp2 (self firstTrue: #onMe temp0))
					(if (and (!= temp2 temp1) (temp2 helpVerb:))
						(= temp1 temp2)
						(if temp3
							(temp3 dispose:)
							(= temp3 0)
							(FrameOut)
						)
						(Message msgGET 94 0 0 1 1 (global186 data:)) ; "Control Panel Help"
						(Print
							addTitle: (global186 data:)
							font: gUserFont
							width: 250
							addText:
								(temp2 noun:)
								(temp2 helpVerb:)
								0
								1
								0
								0
								(if (== (temp2 modNum:) -1)
									0
								else
									(temp2 modNum:)
								)
							modeless: 2
							init:
						)
						(= temp3 (Print dialog:))
						(FrameOut)
					)
				)
				(temp3
					(temp3 dispose:)
					(= temp3 0)
					(FrameOut)
				)
				(else
					(= temp1 0)
				)
			)
			(temp0 dispose:)
		)
		(temp0 dispose:)
		(gGame setCursor: gNormalCursor 1)
		(if temp3
			(temp3 dispose:)
			(FrameOut)
		)
	)

	(method (dispose)
		(Print modeless: 0)
		(super dispose: &rest)
	)
)

(instance cpanelHelpScr of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Message msgGET 94 0 0 1 1 (global186 data:)) ; "Control Panel Help"
				(Print
					addTitle: (global186 data:)
					addText: 31 14 0 1 0 0 94 ; "Click once to clear this message. Your cursor will change into a Question Mark. Pass the Question Mark over the Control Panel to learn what each knob does. Click again to turn off these messages.  Save, Restore, Restart and Quit are now located in the pull-down menus above the main game window."
					init: self
				)
			)
			(1
				(ll6ControlPanel noClickHelp: 1)
				(Print title: 0)
				(self dispose:)
			)
		)
	)
)

