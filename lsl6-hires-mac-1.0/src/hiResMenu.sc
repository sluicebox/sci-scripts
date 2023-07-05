;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 914)
(include sci.sh)
(use Main)
(use n076)
(use n078)
(use fileScr)
(use GraphMenuBar)
(use Str)
(use Print)
(use System)

(public
	hiResMenu 0
)

(instance tFile of MenuTitle
	(properties
		mainView 968
		winY 14
		winView 965
	)

	(method (init)
		(self add: iNew iOpen iSave iSaveAs iQuit)
		(super init: &rest)
	)
)

(instance tGame of MenuTitle
	(properties
		mainView 968
		mainLoop 1
		x 23
		winX 23
		winY 14
		winView 966
	)

	(method (init)
		(self add: iSaveOMatic iAutoSave iMusic iControls iMessage)
		(super init: &rest)
	)
)

(instance tHelp of MenuTitle
	(properties
		mainView 968
		mainLoop 2
		x 47
		winX 47
		winY 14
		winView 967
	)

	(method (init)
		(self
			add:
				iInterface
				iKeyboard
				iCustomerService
				iHints
				iYouMayEnjoy
				iAboutLarry
		)
		(super init: &rest)
	)
)

(instance iNew of MenuItem
	(properties
		y 1
		view 965
		loop 1
	)

	(method (select)
		(gGame restart:)
	)
)

(instance iOpen of MenuItem
	(properties
		y 11
		view 965
		loop 2
	)

	(method (select)
		(gGame restore:)
	)
)

(instance iSave of MenuItem
	(properties
		y 21
		view 965
		loop 3
	)

	(method (select)
		(gGame save: 0)
	)
)

(instance iSaveAs of MenuItem
	(properties
		y 31
		view 965
		loop 4
	)

	(method (select)
		(gGame save: 0)
	)
)

(instance iQuit of MenuItem
	(properties
		y 41
		view 965
		loop 5
	)

	(method (select)
		(gGame quitGame:)
	)
)

(instance iSaveOMatic of MenuItem
	(properties
		y 1
		view 966
		loop 1
	)

	(method (select)
		(proc78_1)
	)
)

(instance iAutoSave of MenuItem
	(properties
		y 11
		view 966
		loop 2
	)

	(method (select)
		(proc76_0)
	)
)

(instance iMusic of MenuItem
	(properties
		y 21
		view 966
		loop 3
	)

	(method (select)
		(cond
			((gGame masterVolume:)
				(gGame masterVolume: 0)
				(= gMasterVolume 0)
			)
			((>= global104 1)
				(gGame masterVolume: 5)
				(= gMasterVolume 5)
			)
			(else
				(gGame masterVolume: 5)
				(= gMasterVolume 5)
			)
		)
	)
)

(instance iMessage of MenuItem
	(properties
		y 41
		view 966
		loop 5
	)

	(method (select)
		(if (IsFlag 105)
			(gTextScroller show:)
			(ClearFlag 105)
		else
			(gTextScroller hide:)
			(SetFlag 105)
		)
	)
)

(instance iControls of MenuItem
	(properties
		y 31
		view 966
		loop 4
	)

	(method (select &tmp temp0)
		(= temp0 gTheCursor)
		(gGame setCursor: gNormalCursor)
		((ScriptID 94) init:) ; ll6ControlPanel
		(gGame setCursor: temp0)
	)
)

(instance iInterface of MenuItem
	(properties
		y 1
		view 9671
	)

	(method (select)
		(gGame setScript: interfaceHelpScr)
	)
)

(instance iKeyboard of MenuItem
	(properties
		y 11
		view 9671
		loop 1
	)

	(method (select)
		(Message msgGET 93 2 0 2 1 (global186 data:)) ; "Keyboard Fun"
		(Print addTitle: (global186 data:) addText: 2 0 0 1 0 0 93 init:) ; "Press Ctrl-F any time you feel like fidgeting. Press any number key for a surprise."
	)
)

(instance iCustomerService of MenuItem
	(properties
		y 21
		view 9671
		loop 2
	)

	(method (select)
		(gGame setScript: custSupScript)
	)
)

(instance iHints of MenuItem
	(properties
		y 31
		view 9671
		loop 3
	)

	(method (select)
		(gGame setScript: hintScript2)
	)
)

(instance iYouMayEnjoy of MenuItem
	(properties
		y 41
		view 9671
		loop 4
	)

	(method (select)
		(gGame setScript: youLikeScript)
	)
)

(instance iAboutLarry of MenuItem
	(properties
		y 51
		view 9671
		loop 5
	)

	(method (select)
		(gGame setScript: (ScriptID 73)) ; aboutScr
	)
)

(instance hiResMenu of GraphMenuBar
	(properties
		x 3
		y 2
	)

	(method (init)
		(self add: tFile tGame tHelp)
		(super init: &rest)
	)
)

(instance custSupScript of Script
	(properties)

	(method (doit &tmp temp0)
		(super doit:)
		(= temp0 ((gUser curEvent:) new:))
		(if (and (== (temp0 type:) 4) (== (temp0 message:) 27))
			(= register 2)
		)
		(if (& (temp0 modifiers:) $000b)
			(= register 2)
		)
		(temp0 dispose:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= global211 (gUser controls:))
				(= global212 (gUser input:))
				(= global213 (gTheIconBar getCursor:))
				(gGame handsOff:)
				(SetCursor 98 0 0)
				(= global214 (Str new:))
				(Message msgGET 93 3 0 2 1 (global214 data:)) ; "Customer Service"
				(= register 0)
				(= cycles 2)
			)
			(1
				(cond
					((or (gTalkers size:) (Print dialog:))
						(-- state)
						(= ticks 90)
					)
					((<= (++ register) 2)
						(= global215 (Str new:))
						(Message msgGET 93 3 0 0 register (global215 data:))
						(Print
							font: gUserFont
							addTitle: (global214 data:)
							addText: (global215 data:) 2 1
						)
						((Print dialog:) setSize:)
						(Print init: self)
						(global215 dispose:)
						(= global215 0)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(if (< register 2)
					(-= state 2)
				)
				(= cycles 2)
			)
			(3
				(global214 dispose:)
				(= global214 0)
				(gGame handsOn:)
				(if (not global211)
					(gTheIconBar disableIcon: (ScriptID 0 3) show:) ; icon0
				)
				(gGame setCursor: global213)
				(gUser canInput: global212 canControl: global211)
				(self dispose:)
			)
		)
	)
)

(instance hintScript2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Message msgGET 93 5 0 2 1 (global186 data:)) ; "Hint Book"
				(Print
					addTitle: (global186 data:)
					addText: 5 0 0 1 0 0 93 ; "Completely erase everything on this hard disk?   Press Cancel to prevent catastrophe or   Press OK to lose everything..."
					addButton: 100 5 0 1 1 0 35 93 ; "OK"
					init: self
				)
			)
			(1
				(gGame setScript: hintScript)
				(self dispose:)
			)
		)
	)
)

(instance hintScript of Script
	(properties)

	(method (doit &tmp temp0)
		(super doit:)
		(= temp0 ((gUser curEvent:) new:))
		(if (and (== (temp0 type:) 4) (== (temp0 message:) 27))
			(= register 7)
		)
		(if (& (temp0 modifiers:) $000b)
			(= register 7)
		)
		(temp0 dispose:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= global211 (gUser controls:))
				(= global212 (gUser input:))
				(= global213 (gTheIconBar getCursor:))
				(gGame handsOff:)
				(SetCursor 98 0 0)
				(= global214 (Str new:))
				(Message msgGET 93 5 0 2 1 (global214 data:)) ; "Hint Book"
				(= register 1)
				(= cycles 2)
			)
			(1
				(cond
					((or (gTalkers size:) (Print dialog:))
						(-- state)
						(= ticks 90)
					)
					((<= (++ register) 7)
						(= global215 (Str new:))
						(Message msgGET 93 5 0 0 register (global215 data:))
						(Print
							font: gUserFont
							addTitle: (global214 data:)
							addText: (global215 data:) 2 1
						)
						((Print dialog:) setSize:)
						(Print init: self)
						(global215 dispose:)
						(= global215 0)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(if (< register 7)
					(-= state 2)
				)
				(= cycles 2)
			)
			(3
				(global214 dispose:)
				(= global214 0)
				(gGame handsOn:)
				(if (not global211)
					(gTheIconBar disableIcon: (ScriptID 0 3) show:) ; icon0
				)
				(gGame setCursor: global213)
				(gUser canInput: global212 canControl: global211)
				(self dispose:)
			)
		)
	)
)

(instance youLikeScript of Script
	(properties)

	(method (doit &tmp temp0)
		(super doit:)
		(= temp0 ((gUser curEvent:) new:))
		(if (and (== (temp0 type:) 4) (== (temp0 message:) 27))
			(= register 7)
		)
		(if (& (temp0 modifiers:) $000b)
			(= register 7)
		)
		(temp0 dispose:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= global211 (gUser controls:))
				(= global212 (gUser input:))
				(= global213 (gTheIconBar getCursor:))
				(gGame handsOff:)
				(SetCursor 98 0 0)
				(= global214 (Str new:))
				(Message msgGET 93 6 0 2 1 (global214 data:)) ; "Other Al Lowe Games"
				(= register 0)
				(= cycles 2)
			)
			(1
				(cond
					((or (gTalkers size:) (Print dialog:))
						(-- state)
						(= ticks 90)
					)
					((<= (++ register) 7)
						(= global215 (Str new:))
						(Message msgGET 93 6 0 0 register (global215 data:))
						(Print
							font: gUserFont
							addTitle: (global214 data:)
							addText: (global215 data:) 2 1
						)
						((Print dialog:) setSize:)
						(Print init: self)
						(global215 dispose:)
						(= global215 0)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(if (< register 7)
					(-= state 2)
				)
				(= cycles 2)
			)
			(3
				(global214 dispose:)
				(= global214 0)
				(gGame handsOn:)
				(if (not global211)
					(gTheIconBar disableIcon: (ScriptID 0 3) show:) ; icon0
				)
				(gGame setCursor: global213)
				(gUser canInput: global212 canControl: global211)
				(self dispose:)
			)
		)
	)
)

(instance interfaceHelpScr of Script
	(properties)

	(method (doit &tmp temp0)
		(super doit:)
		(= temp0 ((gUser curEvent:) new:))
		(temp0 dispose:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= global214 (Str new:))
				(Message msgGET 93 4 0 2 1 (global214 data:)) ; "Interface Help"
				(= register 0)
				(= cycles 2)
			)
			(1
				(cond
					((or (gTalkers size:) (Print dialog:))
						(-- state)
						(= ticks 90)
					)
					((<= (++ register) 1)
						(= global215 (Str new:))
						(Message msgGET 93 4 0 0 register (global215 data:))
						(Print
							font: gUserFont
							addTitle: (global214 data:)
							addText: (global215 data:) 2 1
						)
						((Print dialog:) setSize:)
						(Print init: self)
						(global215 dispose:)
						(= global215 0)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(global214 dispose:)
				(= ticks 1)
			)
			(3
				((ScriptID 75 0) init: doit: dispose:) ; nClickHelp
				(self dispose:)
			)
		)
	)
)

