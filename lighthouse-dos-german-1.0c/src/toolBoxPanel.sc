;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 271)
(include sci.sh)
(use Main)
(use PanelPlane)
(use Motion)

(public
	toolBoxPanel 0
)

(instance toolBoxPanel of InsetPanelPlane
	(properties)

	(method (handleEvent event)
		(cond
			(
				(and
					(IsFlag 325)
					(& (event type:) evMOUSEBUTTON)
					(self onMe: event)
					(== (gUser curVerb:) 89)
					(toolBoxLid cel:)
				)
				(gInventory deleteItem: (ScriptID 9 81)) ; invPliers
				(ClearFlag 325)
				(pvPliers init: self 1 1)
				(gMySoundFX number: 873 setLoop: 0 play:)
			)
			(
				(and
					(IsFlag 324)
					(& (event type:) evMOUSEBUTTON)
					(self onMe: event)
					(== (gUser curVerb:) 90)
					(toolBoxLid cel:)
				)
				(gInventory deleteItem: (ScriptID 9 82)) ; invWrench
				(ClearFlag 324)
				(pvWrench init: self 1 1)
				(gMySoundFX number: 873 setLoop: 0 play:)
			)
			(
				(and
					(IsFlag 262)
					(& (event type:) evMOUSEBUTTON)
					(self onMe: event)
					(== (gUser curVerb:) 76)
					(toolBoxLid cel:)
				)
				(gInventory deleteItem: (ScriptID 9 67)) ; invRockHammer
				(ClearFlag 262)
				(pvRockHammer init: self 1 1)
				(gMySoundFX number: 873 setLoop: 0 play:)
			)
			(
				(and
					(IsFlag 261)
					(& (event type:) evMOUSEBUTTON)
					(self onMe: event)
					(== (gUser curVerb:) 88)
					(toolBoxLid cel:)
				)
				(gInventory deleteItem: (ScriptID 9 80)) ; invBoltCutter
				(ClearFlag 261)
				(pvBoltCutters init: self 1 1)
				(gMySoundFX number: 873 setLoop: 0 play:)
			)
			(else
				(super handleEvent: event &rest)
			)
		)
	)

	(method (cue)
		(gGame handsOn:)
		(self dispose:)
	)

	(method (init)
		(if (gPanels contains: (ScriptID 9 3)) ; PlCompass
			((ScriptID 9 3) dispose:) ; PlCompass
		)
		(if (gPanels contains: (ScriptID 9 4)) ; InvInset
			((ScriptID 9 4) dispose:) ; InvInset
		)
		(super init: &rest)
		(self setBitmap: 822 0 0)
		(if (not (IsFlag 325))
			(pvPliers init: self 1 1)
		)
		(if (not (IsFlag 324))
			(pvWrench init: self 1 1)
		)
		(if (not (IsFlag 261))
			(pvBoltCutters init: self 1 1)
		)
		(if (not (IsFlag 262))
			(pvRockHammer init: self 1 1)
		)
		(cond
			((IsFlag 393)
				(pvBomb init: self 1 1)
			)
			((IsFlag 263)
				(pfBomb init: self 1 1)
			)
			(else
				(pvDynamite init: self 1 1)
			)
		)
		(toolBoxLid init: self 1 1)
	)
)

(instance toolBoxLid of PanelProp
	(properties
		loop 2
		view 822
	)

	(method (init)
		(super init: &rest)
		(self setPri: 500 setCel: 0)
	)

	(method (cue)
		(super cue: &rest)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(if cel
					(self setCycle: Beg self)
					(gMySoundFX number: 820 setLoop: 0 play:)
				else
					(self setCycle: End self)
					(gMySoundFX number: 819 setLoop: 0 play:)
				)
			)
		)
	)
)

(instance pvBomb of PanelView
	(properties
		x 39
		y 90
		loop 1
		cel 6
		view 822
	)

	(method (init)
		(super init: &rest)
		(self setPri: (- (toolBoxLid priority:) 1))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (toolBoxLid cel:))
					(toolBoxLid doVerb: theVerb)
					(return)
				)
				((ScriptID 19 1) init:) ; BombInset
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pvPliers of PanelView
	(properties
		x 91
		y 91
		loop 1
		view 822
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (toolBoxLid cel:))
					(toolBoxLid doVerb: theVerb)
					(return)
				)
				(if (and (!= gCurRoomNum 810) (not (IsFlag 316)))
					(SetFlag 325)
					(gInventory addItem: (ScriptID 9 81)) ; invPliers
					(self dispose: toolBoxPanel 1 1)
					(gMySoundFX number: 873 setLoop: 0 play:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pvWrench of PanelView
	(properties
		x 88
		y 112
		loop 1
		cel 1
		view 822
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (toolBoxLid cel:))
					(toolBoxLid doVerb: theVerb)
					(return)
				)
				(if (and (!= gCurRoomNum 810) (not (IsFlag 319)))
					(SetFlag 324)
					(gInventory addItem: (ScriptID 9 82)) ; invWrench
					(self dispose: toolBoxPanel 1 1)
					(gMySoundFX number: 873 setLoop: 0 play:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pvBoltCutters of PanelView
	(properties
		x 122
		y 127
		loop 1
		cel 2
		view 822
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (toolBoxLid cel:))
					(toolBoxLid doVerb: theVerb)
					(return)
				)
				(if (IsFlag 27)
					(super doVerb: theVerb &rest)
				else
					(SetFlag 261)
					(gInventory addItem: (ScriptID 9 80)) ; invBoltCutter
					(self dispose: toolBoxPanel 1 1)
					(gMySoundFX number: 873 setLoop: 0 play:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pvRockHammer of PanelView
	(properties
		x 172
		y 102
		loop 1
		cel 3
		view 822
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (toolBoxLid cel:))
					(toolBoxLid doVerb: theVerb)
					(return)
				)
				(if (!= gCurRoomNum 810)
					(SetFlag 262)
					(gInventory addItem: (ScriptID 9 67)) ; invRockHammer
					(self dispose: toolBoxPanel 1 1)
					(gMySoundFX number: 873 setLoop: 0 play:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pvDynamite of PanelView
	(properties
		x 36
		y 122
		loop 1
		cel 4
		view 822
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (toolBoxLid cel:))
					(toolBoxLid doVerb: theVerb)
					(return)
				)
				(SetFlag 263)
				(gInventory addItem: (ScriptID 9 65)) ; invDynamite
				(pfBomb init: toolBoxPanel 1 1)
				(self dispose: toolBoxPanel 1 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pfBomb of PanelFeature
	(properties)

	(method (init)
		(self createPoly: 7 118 59 115 74 129 74 141 14 147 17 133)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (toolBoxLid cel:))
					(toolBoxLid doVerb: theVerb)
					(return)
				)
				((ScriptID 19 1) init:) ; BombInset
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

