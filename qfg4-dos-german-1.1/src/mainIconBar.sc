;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 36)
(include sci.sh)
(use Main)
(use Print)
(use IconBar)
(use Inventory)
(use Actor)
(use System)

(public
	mainIconBar 0
	invItem 1
	iconUseIt 2
)

(instance mainIconBar of IconBar
	(properties)

	(method (init &tmp temp0 temp1)
		(self
			add:
				iconWalk
				iconLook
				iconDo
				iconTalk
				iconActions
				iconCast
				iconUseIt
				iconInventory
				iconControlPanel
				iconHelp
		)
		(if (not plane)
			(= plane (gSystemPlane new:))
		)
		(plane back: 0 priority: -1 init: 0 0 320 28 0 0 320 28 addCast: self)
		(self eachElementDo: #init self)
		(plane addCast: (= temp1 (Cast new:)))
		(skipIcon1 init: temp1)
		(skipIcon2 init: temp1)
		(invItem init: temp1)
		(self
			eachElementDo: #highlightColor -1
			eachElementDo: #lowlightColor -1
			useIconItem: iconUseIt
			helpIconItem: iconHelp
			walkIconItem: iconWalk
			state: 3072
			disable: 6
			curIcon: iconWalk
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if (& state $0020)
			(event localize: plane)
		)
		(= temp1 (event type:))
		(cond
			((& state $0004))
			(
				(and
					(not temp1)
					(& state $0400)
					(self shouldOpen: event)
					(not (= temp0 0))
				)
				(= oldMouseX (event x:))
				(= oldMouseY (event y:))
				(= temp4 gTheCursor)
				(= temp5 curIcon)
				(= temp6 curInvIcon)
				(self show:)
				(gGlory setCursor: gNormalCursor)
				(if temp0
					(gGlory
						setCursor:
							gTheCursor
							1
							(+
								(curIcon nsLeft:)
								(/ (- (curIcon nsRight:) (curIcon nsLeft:)) 2)
							)
							(- (curIcon nsBottom:) 3)
					)
				)
				(self doit:)
				(= temp3
					(if (or (gUser canControl:) (gUser canInput:))
						(self getCursor:)
					else
						gWaitCursor
					)
				)
				(if temp0
					(gGlory setCursor: temp3 1 oldMouseX oldMouseY)
				else
					(gGlory
						setCursor:
							temp3
							1
							((event new:) x:)
							(Max (event y:) (+ 1 (plane bottom:)))
					)
				)
				(self hide:)
			)
			((& temp1 evKEYBOARD)
				(switch (event message:)
					(KEY_RETURN
						(cond
							((not curIcon))
							((or (!= curIcon useIconItem) curInvIcon)
								(event
									type: (curIcon type:)
									message:
										(if (== curIcon useIconItem)
											(curInvIcon message:)
										else
											(curIcon message:)
										)
								)
							)
							(else
								(event type: evNULL)
							)
						)
					)
					(KEY_INSERT
						(if (gUser canControl:)
							(self swapCurIcon:)
						)
						(event claimed: 1)
					)
					(JOY_NULL
						(if (& (event type:) $0010) ; direction
							(self advanceCurIcon:)
							(event claimed: 1)
						)
					)
				)
			)
			((& temp1 evMOUSEBUTTON)
				(cond
					((& (event modifiers:) emSHIFT)
						(self advanceCurIcon:)
						(event claimed: 1)
					)
					((& (event modifiers:) emCTRL)
						(if (gUser canControl:)
							(self swapCurIcon:)
						)
						(event claimed: 1)
					)
					(curIcon
						(event
							type: (curIcon type:)
							message:
								(if (and curInvIcon (== curIcon useIconItem))
									(curInvIcon message:)
								else
									(curIcon message:)
								)
						)
					)
				)
			)
		)
	)

	(method (shouldOpen param1)
		(return
			(if (IsFlag 50)
				0
			else
				(if (& (iconUseIt signal:) $0004)
					(iconUseIt setPri: 100)
				else
					(iconUseIt setPri: 0)
				)
				(if
					(or
						(and (== (param1 type:) 0) (<= (param1 y:) 10))
						(and
							(== (param1 type:) 4)
							(OneOf (param1 message:) 27 21248)
						)
					)
					1
				)
			)
		)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3)
		(= temp1 (event claimed:))
		(if (= temp0 (self firstTrue: #onMe event))
			(= temp2 (temp0 signal:))
			(= temp3 (== temp0 helpIconItem))
		)
		(switch (event type:)
			(evNULL
				(cond
					((self shouldClose: event)
						(if
							(and
								(& state $0400)
								(or
									(not helpIconItem)
									(not (& (helpIconItem signal:) $0010))
								)
							)
							(= oldMouseY 0)
							(= temp1 1)
						)
					)
					((and temp0 (!= temp0 highlightedIcon))
						(= oldMouseY 0)
						(self highlight: temp0)
					)
				)
			)
			(evMOUSEBUTTON
				(if (and temp0 (self select: temp0 1))
					(if temp3
						(gGlory setCursor: (temp0 getCursor:) 1)
						(if (& state $0800)
							(self noClickHelp:)
						else
							(helpIconItem
								signal: (| (helpIconItem signal:) $0010)
							)
						)
					else
						(= temp1 (& temp2 $0040))
					)
					(if (temp0 object:)
						(gGlory
							panelObj: (temp0 object:)
							panelSelector: (temp0 selector:)
						)
					)
					(temp0 doit:)
				)
			)
			($6000 ; evVERB | evHELP
				(if (and temp0 (temp0 helpVerb:))
					(Print
						font: gUserFont
						width: 250
						addText:
							(temp0 noun:)
							(temp0 helpVerb:)
							0
							1
							0
							0
							(temp0 modNum:)
						init:
					)
				)
				(if helpIconItem
					(helpIconItem signal: (& (helpIconItem signal:) $ffef))
				)
				(gGlory setCursor: gNormalCursor)
			)
		)
		(return temp1)
	)
)

(instance skipIcon1 of View
	(properties
		view 930
		loop 12
	)
)

(instance skipIcon2 of View
	(properties
		x 306
		view 930
		loop 13
	)
)

(instance invItem of View
	(properties
		x 203
		y 15
		view 905
	)

	(method (init)
		(super init: &rest)
		(self hide:)
	)
)

(instance iconWalk of IconI
	(properties
		noun 14
		modNum 0
		signal 65
		type 20480
		message 3
		mainView 930
		maskView 930
		maskLoop 14
		helpVerb 9
	)

	(method (init)
		(self setCursor: 940 0 0)
		(= x (CelWide 930 13 0))
		(super init: &rest)
	)

	(method (highlight param1)
		(if (not (& signal $0004))
			(= cel param1)
			(UpdateScreenItem self)
		)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(gEgo changeGait: 0 1) ; walking
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconLook of IconI
	(properties
		noun 15
		modNum 0
		signal 65
		message 1
		mainView 930
		mainLoop 1
		maskView 930
		maskLoop 14
		maskCel 1
		helpVerb 9
	)

	(method (init)
		(self setCursor: 941 0 0)
		(= x
			(+
				(iconWalk x:)
				(CelWide (iconWalk view:) (iconWalk loop:) (iconWalk cel:))
			)
		)
		(super init: &rest)
	)

	(method (highlight param1)
		(if (not (& signal $0004))
			(= cel param1)
			(UpdateScreenItem self)
		)
	)
)

(instance iconDo of IconI
	(properties
		noun 16
		modNum 0
		signal 65
		message 4
		mainView 930
		mainLoop 2
		maskView 930
		maskLoop 14
		maskCel 2
		helpVerb 9
	)

	(method (init)
		(self setCursor: 942 0 0)
		(= x
			(+
				(iconLook x:)
				(CelWide (iconLook view:) (iconLook loop:) (iconLook cel:))
			)
		)
		(super init: &rest)
	)

	(method (highlight param1)
		(if (not (& signal $0004))
			(= cel param1)
			(UpdateScreenItem self)
		)
	)
)

(instance iconTalk of IconI
	(properties
		noun 17
		modNum 0
		signal 65
		message 2
		mainView 930
		mainLoop 3
		maskView 930
		maskLoop 14
		maskCel 3
		helpVerb 9
	)

	(method (init)
		(self setCursor: 943 0 0)
		(= x
			(+
				(iconDo x:)
				(CelWide (iconDo view:) (iconDo loop:) (iconDo cel:))
			)
		)
		(super init: &rest)
	)

	(method (highlight param1)
		(if (not (& signal $0004))
			(= cel param1)
			(UpdateScreenItem self)
		)
	)
)

(instance iconActions of IconI
	(properties
		noun 18
		modNum 0
		signal 66
		message 7
		mainView 930
		mainLoop 10
		maskView 930
		maskLoop 14
		maskCel 8
		helpVerb 9
	)

	(method (init)
		(self setCursor: 942 0 0)
		(= x
			(+
				(iconTalk x:)
				(CelWide (iconTalk view:) (iconTalk loop:) (iconTalk cel:))
			)
		)
		(super init: &rest)
	)

	(method (highlight param1)
		(if (not (& signal $0004))
			(= cel param1)
			(UpdateScreenItem self)
		)
	)

	(method (select)
		(if (super select: &rest)
			(proc0_7)
			(gTheIconBar hide:)
			((ScriptID 20) init: show: doit:) ; actionBar
			(DisposeScript 20)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconCast of IconI
	(properties
		noun 19
		modNum 0
		signal 67
		message 8
		mainView 930
		mainLoop 11
		maskView 930
		maskLoop 14
		maskCel 9
		helpVerb 9
	)

	(method (init)
		(self setCursor: 999 0 0)
		(= x
			(+
				(iconActions x:)
				(CelWide
					(iconActions view:)
					(iconActions loop:)
					(iconActions cel:)
				)
			)
		)
		(super init: &rest)
	)

	(method (highlight param1)
		(if (not (& signal $0004))
			(= cel param1)
			(UpdateScreenItem self)
		)
	)

	(method (select &tmp temp0 temp1)
		(if (super select: &rest)
			(if (!= (gTheIconBar getCursor:) 948)
				(proc0_7)
			)
			(gTheIconBar hide:)
			(cond
				((not [gEgoStats 12]) ; magic
					(gMessager say: 26 6 27 0 0 0) ; "You do not have any magical ability."
				)
				(
					(and
						(OneOf gCurRoomNum 240 250 300 310 320 370 380)
						(not gNight)
					)
					(gMessager say: 26 6 24 0 0 0) ; "It's too dangerous to use magic in town during the day. The townspeople are very suspicious of magic users."
				)
				(else
					(for ((= temp1 0)) (< temp1 22) ((++ temp1))
						(if (= temp0 [gEgoStats (+ 20 temp1)])
							(break)
						)
					)
					(if (not temp0)
						(gMessager say: 26 6 26 0 0 0) ; "You do not know any spells."
					else
						((ScriptID 21) showSelf: gEgo) ; glorySpells
					)
				)
			)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconUseIt of IconI
	(properties
		noun 20
		modNum 0
		signal 65
		message 0
		mainView 930
		mainLoop 4
		maskView 930
		maskLoop 14
		maskCel 4
		helpVerb 9
	)

	(method (init)
		(self setCursor: 999 0 0)
		(= x
			(+
				(iconCast x:)
				(CelWide (iconCast view:) (iconCast loop:) (iconCast cel:))
			)
		)
		(super init: &rest)
	)
)

(instance iconInventory of IconI
	(properties
		noun 21
		modNum 0
		signal 67
		type 0
		message 0
		mainView 930
		mainLoop 5
		maskView 930
		maskLoop 14
		maskCel 5
		helpVerb 9
	)

	(method (init)
		(self setCursor: 999 0 0)
		(= x
			(+
				(iconUseIt x:)
				(CelWide (iconUseIt view:) (iconUseIt loop:) (iconUseIt cel:))
			)
		)
		(super init: &rest)
	)

	(method (highlight param1)
		(if (not (& signal $0004))
			(= cel param1)
			(UpdateScreenItem self)
		)
	)

	(method (select &tmp temp0 temp1 temp2 temp3)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(gInventory showSelf: gEgo)
			(if (and (= temp0 (gInventory curIcon:)) (temp0 isKindOf: InvI))
				(= temp1 (temp0 view:))
				(= temp2 (temp0 loop:))
				(= temp3 (temp0 cel:))
				(iconUseIt cursorView: temp1)
				(iconUseIt cursorLoop: temp2)
				(iconUseIt cursorCel: temp3)
				(invItem view: temp1 loop: temp2 cel: temp3 show:)
				(UpdateScreenItem invItem)
			)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconControlPanel of IconI
	(properties
		noun 22
		modNum 0
		signal 67
		message 8
		mainView 930
		mainLoop 7
		maskView 930
		maskLoop 14
		maskCel 6
		helpVerb 9
	)

	(method (init)
		(self setCursor: 999 0 0)
		(= x
			(+
				(iconInventory x:)
				(CelWide
					(iconInventory view:)
					(iconInventory loop:)
					(iconInventory cel:)
				)
			)
		)
		(super init: &rest)
	)

	(method (highlight param1)
		(if (not (& signal $0004))
			(= cel param1)
			(UpdateScreenItem self)
		)
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar hide:)
			((ScriptID 25) init: show: dispose:) ; controlPanel
			(DisposeScript 25)
			(DisposeScript 19)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconHelp of IconI
	(properties
		noun 23
		modNum 0
		signal 3
		message 9
		mainView 930
		mainLoop 9
		maskView 930
		maskLoop 14
		maskCel 7
		cursorView 949
		cursorLoop 0
		cursorCel 0
		helpVerb 9
	)

	(method (init)
		(= x
			(+
				(iconControlPanel x:)
				(CelWide
					(iconControlPanel view:)
					(iconControlPanel loop:)
					(iconControlPanel cel:)
				)
			)
		)
		(super init: &rest)
	)

	(method (highlight param1)
		(if (not (& signal $0004))
			(= cel param1)
			(UpdateScreenItem self)
		)
	)
)

