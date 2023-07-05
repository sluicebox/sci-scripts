;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 94)
(include sci.sh)
(use Main)
(use CPanelItem)
(use Print)
(use System)

(public
	ll6ControlPanel 0
)

(local
	[local0 28] = [8 17 6 15 4 13 4 10 5 8 6 5 9 4 12 4 15 4 16 5 18 7 20 10 19 13 17 16]
)

(instance detailDial of RadialDial
	(properties
		view 969
		x 173
		y 32
		noClickNoun 9
		noClickVerb 14
		noClickModNum 94
		points 14
	)

	(method (doit param1)
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

(instance volumeDial of RadialDial
	(properties
		view 969
		x 173
		y 56
		noClickNoun 8
		noClickVerb 14
		noClickModNum 94
		points 14
	)

	(method (doit param1)
		(if argc
			(= gMasterVolume param1)
			(gGame masterVolume: (and param1 (/ (* 1155 param1) 1000)))
		else
			(return gMasterVolume)
		)
	)
)

(instance speedDial of RadialDial
	(properties
		view 969
		x 173
		y 80
		noClickNoun 10
		noClickVerb 14
		noClickModNum 94
		points 14
	)

	(method (doit param1)
		(if argc
			(gEgo setSpeed: (= global167 (- 14 param1)))
		else
			(return (- 14 global167))
		)
	)
)

(instance textDial of RadialDial
	(properties
		view 969
		x 173
		y 104
		noClickNoun 11
		noClickVerb 14
		noClickModNum 94
		points 14
	)

	(method (select &tmp temp0 temp1)
		(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
			(temp0 localize:)
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

	(method (doit param1)
		(= param1 14)
	)
)

(instance question of CButton
	(properties
		view 969
		loop 2
		x 199
		y 29
		noClickNoun 4
		noClickVerb 14
		noClickModNum 94
	)

	(method (doit)
		(if (and argc 1)
			(gGame setScript: cpanelHelpScr)
		)
	)
)

(instance ok of CButton
	(properties
		view 969
		loop 3
		x 199
		y 72
		noClickNoun 7
		noClickVerb 14
		noClickModNum 94
	)

	(method (doit param1)
		(if (and argc param1)
			(ll6ControlPanel done: 1)
		)
	)
)

(instance ll6ControlPanel of ControlPanel
	(properties
		view 969
		loop 1
		x 113
		y 29
	)

	(method (init)
		(super init: &rest)
		(self
			done: 0
			add:
				(detailDial init: @local0 yourself:)
				(volumeDial init: @local0 yourself:)
				(speedDial init: @local0 yourself:)
				(textDial init: @local0 yourself:)
				question
				ok
			show:
			eachElementDo: #show 1
			doit:
			hide:
			dispose:
		)
		(DisposeScript 94)
	)

	(method (noClickMessage)
		((ScriptID 1821 32) x: 10 y: 130 talkWidth: 295) ; talkTitleNar
		(super noClickMessage: &rest)
		((ScriptID 1821 32) x: -1 y: -1) ; talkTitleNar
	)
)

(instance noClickHelpCursor of Cursor
	(properties
		view 998
		cel 6
	)
)

(instance cpanelHelpScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Message msgGET 94 0 0 1 1 global186) ; "Control Panel Help"
				(Print
					addTitle: 0 0 1 1 94
					addText: 31 14 0 1 0 0 94 ; "Click once to clear this message. Your cursor will change into a Question Mark. Pass the Question Mark over the Control Panel to learn what each knob does. Click again to turn off these messages.  Save, Restore, Restart and Quit are now located in the pull-down menus above the main game window."
					init: self
				)
			)
			(1
				(gGame setCursor: noClickHelpCursor)
				(ll6ControlPanel noClickHelp: 1)
				(self dispose:)
			)
		)
	)
)

