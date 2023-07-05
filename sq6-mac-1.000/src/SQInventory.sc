;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use SQIconbar)
(use DText)
(use Plane)
(use Str)
(use Array)
(use Print)
(use Tutorial)
(use Sound)
(use Inventory)
(use System)

(public
	SQInventory 0
)

(class SQInvItem of InvI
	(properties)

	(method (highlight param1)
		(= cel (* 1 (if argc param1)))
		(UpdateScreenItem self)
	)

	(method (select param1 param2 &tmp [temp0 2])
		(if (or (super select: &rest) (and (> argc 1) param2))
			(if (not (gTheIconBar curInvIcon:))
				(gTheIconBar enableIcon: (gTheIconBar useIconItem:))
			)
			(gTheIconBar
				curIcon:
					((gTheIconBar useIconItem:)
						cursorView: cursorView
						cursorLoop: cursorLoop
						cursorCel: cursorCel
						yourself:
					)
				curInvIcon: self
				clearInvItem:
				showInvItem: 1
			)
			(if (not (and (gUser controls:) (gUser input:)))
				(= global121 (gTheIconBar curIcon:))
			)
			(gInventory curIcon: self selectedInvIcon: self)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 1) ; Look
				(if (Message msgSIZE 15 noun theVerb 0 1)
					(gMessager say: noun 1 0 0 0 15)
				else
					(gMessager say: 0 1 0 (proc0_8 1 3) 0 15)
				)
			)
			((== theVerb 4) ; Do
				(if (Message msgSIZE 15 noun theVerb 0 1)
					(gMessager say: noun 4 0 0 0 15)
				else
					(gMessager say: 0 4 0 (proc0_8 1 3) 0 15)
				)
			)
			((not (OneOf theVerb 3 4 2 17)) ; Walk, Do, Talk, ???
				(if (Message msgSIZE 15 noun theVerb 0 1)
					(gMessager say: noun theVerb 0 0 0 15)
				else
					(gMessager say: 0 26 0 (proc0_8 1 3) 0 15)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gInventory highlightedIcon: 0 eraseItems: drawInvItems:)
		(if (< (gInventory numInv:) 9)
			(sliderIcon y: -15)
			(UpdateScreenItem sliderIcon)
			(gInventory disableIcon: upIcon disableIcon: downIcon)
			(upIcon mask:)
			(downIcon mask:)
		else
			(sliderIcon y: 14)
			(UpdateScreenItem sliderIcon)
			(gInventory enableIcon: upIcon enableIcon: downIcon)
			(upIcon show:)
			(downIcon show:)
		)
	)
)

(class SQInventory of Inv
	(properties
		normalHeading 9
		empty 27
		iconRight 160
		numRow 2
		numCol 4
		itemWide 41
		itemHigh 40
		selectedInvIcon 0
		numInv 0
		numBuckStr 0
		bucksDisplay 0
		bucksShowing 0
	)

	(method (init)
		(= gInventory self)
		(self
			add:
				Actuator
				Alarm_Key
				Alien_ID
				Alveoli
				Attach_Caps
				Baguettes
				Beleaux_Record
				Belt_Da
				Belt_Da_Pga
				Belt_Pga
				Board
				Bobbit_Kabobs
				Brandy
				Buckazoids
				Burlesque_Moddie_1
				Burlesque_Moddie_4
				Callahan_Moddie
				Celery
				Cheat_Sheet
				Ch_Label
				Churlish_Moddie_1
				Coin
				Crap_O_Matic
				Crystal
				Crystal_With_Glue
				Cyber_Jack
				Data_Cart
				Datacorder
				Dead_Fish
				Dead_Fish2
				Dead_Fish3
				Donut
				Donut_Morph
				Duct_Tape
				dummy1
				dummy2
				dummy3
				dummy4
				dummy5
				dummy6
				Elmo_Gluzall
				Eulogy
				Eva_Full
				Eva_Full_Both
				Eva_Full_Enz
				Eva_Helmet
				Eva_Suit
				Finger_Nail
				First_Negative
				First_Photo
				First_Positive
				Gallstone
				Gragh
				Hand_Cuffs
				Hand_Pump
				Holozine
				Grappling_Hook
				Hookah_Connected
				Hookah_Hose
				Hotel_Keycard
				Empty_Tray
				Full_Tray
				Icky_Record
				Jumper_Cables
				Keyring
				M_M
				M_M_Green
				M_M_Yellow
				Magnet
				Melon
				Morphin
				Morphing
				Nail
				Nerve_Fibers
				Nigel_Record
				Number_3_Cord
				Paperclip
				Pga
				Pga_Hair
				Pinfeather
				Pipe
				Belleaux_s_Record_Printout
				Nigel_s_Record_Printout
				Project_Immortality_Record_Printout
				Sharpei_s_Record_Printout
				Stellar_s_Record_Printout
				Incriminating_Printouts
				Project_Record
				Pump_With_Hose
				Rack_Of_Orat
				Rag
				Recall_Notice
				Roger_ID
				Roger_Photos
				Sape_Record
				Screwdriver
				Second_Negative
				Second_Photo
				Second_Positive
				Separated_Caps
				Sidney_Arm
				Sidney_Eye
				Silver_Chunk
				Subroutine_Card
				Staple
				Time_Pills
				Trans_Signaler
				Tubers
				Wad_Of_Hair
				Wall_Hanging
				Whisk_Broom
				Whisk_Broom_Full
				Windshield_Sign
				Yoda_Ears
				chooseIcon
				eyesIcon
				handsIcon
				sqHelpIcon
				playIcon
				upIcon
				downIcon
				sliderIcon
			selectIcon: chooseIcon
			helpIconItem: sqHelpIcon
			okButton: playIcon
			eachElementDo: #modNum 15
			state: 2048
		)
		(super init:)
		(invPlane init: 68 22 234 99)
		(plane setBitmap: 952 8 0 setRect: 61 16 258 123)
	)

	(method (showSelf param1)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
		(if (not okButton)
			(= okButton (KList 8 (self first:))) ; NodeValue
		)
		(= curIcon 0)
		(= owner (if argc param1 else gEgo))
		(if (not (self ownedBy: owner))
			(self carryingNothing:)
			(return 0)
		)
		(return (self show: doit: hide:))
	)

	(method (show &tmp temp0 temp1)
		(|= state $0020)
		(= curIcon chooseIcon)
		(gGame setCursor: (self getCursor:))
		(= curIndex 0)
		(for ((= temp1 (self first:))) temp1 ((= temp1 (self next: temp1)))
			(if (not ((= temp0 (KList 8 temp1)) isKindOf: InvI)) ; NodeValue
				(temp0 signal: (| (temp0 signal:) $0020))
			)
		)
		(self drawInvItems:)
		(if (< numInv 9)
			(sliderIcon y: -15)
			(UpdateScreenItem sliderIcon)
			(gInventory disableIcon: upIcon disableIcon: downIcon)
			(upIcon mask:)
			(downIcon mask:)
		else
			(sliderIcon y: 14)
			(UpdateScreenItem sliderIcon)
			(gInventory enableIcon: upIcon enableIcon: downIcon)
			(upIcon show:)
			(downIcon show:)
		)
		(plane priority: (+ (GetHighPlanePri) 1))
		(UpdatePlane plane)
		(invPlane priority: (+ (GetHighPlanePri) 1))
		(UpdatePlane invPlane)
		(return 1)
	)

	(method (hide &tmp temp0 temp1 temp2)
		(if (& state $0020)
			(&= state $ffdf)
		)
		(for ((= temp1 (KList 3 elements))) temp1 ((= temp1 nextNode)) ; FirstNode
			(= nextNode (KList 6 temp1)) ; NextNode
			(= temp2 (KList 8 temp1)) ; NodeValue
			(temp2 signal: (& (temp2 signal:) $ffdf))
			(if (and (temp2 isKindOf: InvI) (not (& (temp2 signal:) $0004)))
				(temp2 signal: (| (temp2 signal:) $0004))
				(DeleteScreenItem temp2)
			)
		)
		(if bucksShowing
			(gInventory delete: bucksDisplay)
			(DeleteScreenItem bucksDisplay)
			(bucksDisplay dispose:)
			(= bucksDisplay 0)
			(numBuckStr dispose:)
			(= bucksShowing 0)
		)
		(invPlane priority: -1)
		(UpdatePlane invPlane)
		(plane priority: -1)
		(UpdatePlane plane)
		(if (IsFlag 65)
			(if (or (IsFlag 66) (IsFlag 72))
				(gTheIconBar enable: 0)
			)
			(if (IsFlag 67)
				(gTheIconBar enable: 1)
			)
			(if (IsFlag 68)
				(gTheIconBar enable: 2)
			)
			(if (IsFlag 69)
				(gTheIconBar enable: 3)
			)
			(if (IsFlag 70)
				(gTheIconBar enable: 5)
			)
			(if (IsFlag 71)
				(gTheIconBar enable: 6)
			)
			(ClearFlag 66)
			(ClearFlag 67)
			(ClearFlag 68)
			(ClearFlag 69)
			(ClearFlag 70)
			(ClearFlag 71)
			(ClearFlag 72)
			(if (or (not selectedInvIcon) (not (curIcon isKindOf: InvI)))
				(gTheIconBar curIcon: global169)
			)
		)
		(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
	)

	(method (eraseItems &tmp temp0 temp1)
		(for ((= temp0 (self first:))) temp0 ((= temp0 (self next: temp0)))
			(if ((= temp1 (KList 8 temp0)) isKindOf: InvI) ; NodeValue
				(DeleteScreenItem temp1)
				(temp1 signal: (| (temp1 signal:) $0004))
			)
		)
		(if bucksShowing
			(gInventory delete: bucksDisplay)
			(DeleteScreenItem bucksDisplay)
			(bucksDisplay dispose:)
			(= bucksDisplay 0)
			(numBuckStr dispose:)
			(= bucksShowing 0)
		)
	)

	(method (drawIcons &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 (= temp2 (= temp0 (= temp3 (= temp4 0)))))
		(for ((= temp2 (self first:))) temp2 ((= temp2 (self next: temp2)))
			(if (not ((= temp0 (KList 8 temp2)) isKindOf: InvI)) ; NodeValue
				(= temp4 (CelWide (temp0 view:) (temp0 loop:) (temp0 cel:)))
				(if
					(>
						(= temp3
							(CelHigh (temp0 view:) (temp0 loop:) (temp0 cel:))
						)
						iconBottom
					)
					(= iconBottom temp3)
				)
				(if (not (& (temp0 signal:) $0080))
					(temp0
						x: temp1
						y: 0
						nsLeft: temp1
						nsTop: 0
						nsRight: (+ temp1 temp4)
						nsBottom: temp3
					)
				)
				(= temp1 (+ (temp0 x:) temp4))
				(UpdateScreenItem temp0)
			)
		)
	)

	(method (drawInvItems &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 0)
		(= temp1 -4)
		(= curIndex (= numInv 0))
		(for ((= temp3 (self first:))) temp3 ((= temp3 (self next: temp3)))
			(if
				(and
					((= temp2 (KList 8 temp3)) isKindOf: InvI) ; NodeValue
					(== (temp2 owner:) owner)
				)
				(++ numInv)
				(temp2
					x: temp0
					y: temp1
					nsLeft: temp0
					nsTop: temp1
					nsRight: (+ temp0 itemWide)
					nsBottom: (+ temp1 itemHigh)
					plane: invPlane
				)
				(if (and (not bucksShowing) (== (temp2 mainView:) 9551))
					(= numBuckStr (Str format: {%d} global150))
					(= temp4 (IntArray newWith: 4 {}))
					(Text 0 (temp4 data:) (numBuckStr data:) 70 30)
					(= temp5
						(/
							(-
								(- (temp2 nsRight:) (temp2 nsLeft:))
								(- (temp4 at: 2) (temp4 at: 0))
							)
							2
						)
					)
					((= bucksDisplay (DText new:))
						font: 70
						text: (KString 8 (numBuckStr data:)) ; StrDup
						fore: 37
						back: 0
						x: (+ temp5 (temp2 nsLeft:) 3)
						y: (- (temp2 nsBottom:) 7)
						setSize: 30
						setPri: (+ (GetHighPlanePri) 1)
						signal: 2
						init: gInventory
						plane: invPlane
					)
					(AddScreenItem bucksDisplay)
					(= bucksShowing 1)
					(temp4 dispose:)
				)
				(if (& (temp2 signal:) $0004)
					(temp2 signal: (& (temp2 signal:) $fffb))
					(AddScreenItem temp2)
				else
					(UpdateScreenItem temp2)
				)
				(if (> (+= temp0 (+ itemWide colMargin)) iconRight)
					(= temp0 0)
					(+= temp1 (+ itemHigh rowMargin))
				)
			)
		)
		(if temp3
			(for
				((= temp3 (self next: temp3)))
				temp3
				((= temp3 (self next: temp3)))
				
				(if
					(and
						((= temp2 (KList 8 temp3)) isKindOf: InvI) ; NodeValue
						(not (& (temp2 signal:) $0004))
					)
					(DeleteScreenItem temp2)
					(temp2 signal: (| (temp2 signal:) $0004))
				)
			)
		)
	)

	(method (advanceCurIcon &tmp temp0 temp1 temp2)
		(if (& state $0004)
			(return)
		)
		(= temp0 curIcon)
		(= temp1 0)
		(while
			(&
				((= temp0 (self at: (mod (+ (self indexOf: temp0) 1) size)))
					signal:
				)
				$0006
			)
			(if (> temp1 (+ 1 size))
				(return)
			else
				(++ temp1)
			)
		)
		(= curIcon temp0)
		(self highlight: curIcon)
		(gGame setCursor: (self getCursor:))
	)

	(procedure (localproc_0 param1 param2 param3 &tmp temp0 temp1 temp2) ; UNUSED
		(= temp2 (+ (/ (- (param1 nsRight:) (param1 x:)) 2) (param1 x:)))
		(= temp1 param2)
		(while (>= (Abs (- temp1 param3)) 4)
			(if
				(= temp0
					(self
						firstTrue:
							#onMe
							(((gUser curEvent:) new:)
								x: temp2
								y: temp1
								yourself:
							)
					)
				)
				(return)
			)
			(if (< param2 param3)
				(+= temp1 4)
			else
				(-= temp1 4)
			)
		)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= temp7 (Str newWith: 100 {}))
		(while ((= temp1 ((gUser curEvent:) new:)) type:)
			(temp1 dispose:)
		)
		(= temp5 0)
		(while (& state $0020)
			(= temp1 ((gUser curEvent:) new:))
			(= gMouseX (temp1 x:))
			(= gMouseY (temp1 y:))
			(= temp2 (temp1 type:))
			(= temp3 (temp1 message:))
			(= temp4 (temp1 modifiers:))
			(= temp6 0)
			(= gGameTime (+ gTickOffset (GetTime)))
			(FrameOut)
			(temp1 localize: plane)
			(cond
				((gNarrator initialized:)
					(gNarrator doit:)
					(gNarrator handleEvent: temp1)
				)
				(((ScriptID 20 1) initialized:) ; Roger
					((ScriptID 20 1) doit:) ; Roger
					((ScriptID 20 1) handleEvent: temp1) ; Roger
				)
				(else
					(if
						(and
							curIcon
							(not temp4)
							(!= curIcon selectIcon)
							(or
								(== temp2 1)
								(and (== temp2 4) (== temp3 13) (= temp6 1))
							)
							(or
								(!= curIcon helpIconItem)
								(& (helpIconItem signal:) $0010)
							)
						)
						(temp1 type: 16384 message: (curIcon message:))
					)
					(= temp2 (temp1 type:))
					(= temp3 (temp1 message:))
					(if gCuees
						(gCuees eachElementDo: #doit)
					)
					(if
						(and
							(= temp8 (gGame script:))
							(temp8 isKindOf: Tutorial)
						)
						(temp8 doit:)
					)
					(cond
						((and (== temp2 1) temp4)
							(self advanceCurIcon:)
							(temp1 claimed: 1)
						)
						(
							(and
								(== temp2 0)
								(= temp0 (self firstTrue: #onMe temp1))
								(!= temp0 highlightedIcon)
							)
							(self highlight: temp0)
						)
						((or (== temp2 1) (and (== temp2 4) (== temp3 13)))
							(if
								(and
									highlightedIcon
									(self select: highlightedIcon (== temp2 1))
								)
								(cond
									((== highlightedIcon okButton)
										(temp1 claimed: 1)
										(break)
									)
									((== highlightedIcon helpIconItem)
										(= curIcon highlightedIcon)
										(gGame setCursor: (self getCursor:))
										(cond
											((& state $0800)
												(self noClickHelp:)
											)
											(helpIconItem
												(helpIconItem
													signal:
														(|
															(helpIconItem
																signal:
															)
															$0010
														)
												)
											)
										)
									)
									(else
										(= curIcon highlightedIcon)
										(if
											(not
												(OneOf
													curIcon
													upIcon
													downIcon
													sliderIcon
												)
											)
											(gGame
												setCursor: (self getCursor:)
											)
										)
									)
								)
							)
						)
						((== temp2 4)
							(switch temp3
								(27
									(break)
								)
							)
						)
						(
							(and
								(& temp2 $4000)
								(= temp0 (self firstTrue: #onMe temp1))
							)
							(cond
								((& temp2 $2000)
									(if
										(and
											temp0
											(temp0 noun:)
											(Message
												msgGET
												(temp0 modNum:)
												(temp0 noun:)
												(temp0 helpVerb:)
												0
												1
												(temp7 data:)
											)
										)
										(Prints temp7)
									)
									(helpIconItem
										signal: (& (helpIconItem signal:) $ffef)
									)
									(gGame setCursor: gNormalCursor)
								)
								((== temp0 okButton)
									(temp1 claimed: 1)
									(break)
								)
								(
									(and
										(not (temp0 isKindOf: InvI))
										(not (temp0 isKindOf: DText))
									)
									(if (self select: temp0 (not temp6))
										(= curIcon temp0)
										(if
											(not
												(OneOf
													curIcon
													upIcon
													downIcon
													sliderIcon
												)
											)
											(gGame
												setCursor: (self getCursor:)
											)
										)
										(if (== temp0 helpIconItem)
											(if (& state $0800)
												(self noClickHelp:)
											else
												(helpIconItem
													signal:
														(|
															(helpIconItem
																signal:
															)
															$0010
														)
												)
											)
										)
									)
								)
								(curIcon
									(cond
										((curIcon isKindOf: InvI)
											(temp0 doVerb: (curIcon message:))
										)
										(
											(and
												(!= curIcon upIcon)
												(!= curIcon downIcon)
											)
											(temp0 doVerb: (temp1 message:))
										)
									)
								)
							)
						)
					)
					(cond
						(
							(or
								(and (< 2 (temp1 y:) 85) (< 178 (temp1 x:) 195))
								(and
									(temp1 localize: (gTheIconBar plane:))
									(>= (temp1 y:) 17)
									(< (temp1 x:) 267)
								)
							)
							(if (!= gTheCursor gNormalCursor)
								(if highlightedIcon
									(highlightedIcon highlight: 0)
									(= highlightedIcon 0)
								)
								(= temp5 curIcon)
								(= curIcon (gInventory selectIcon:))
								(gGame setCursor: gNormalCursor)
							)
						)
						((and temp5 (!= gTheCursor (temp5 getCursor:)))
							(= curIcon temp5)
							(= temp5 0)
							(gGame setCursor: (curIcon getCursor:))
						)
					)
					(gTextScroller handleEvent: temp1)
					(temp1 dispose:)
				)
			)
		)
		(temp7 dispose:)
	)

	(method (carryingNothing)
		(gMessager say: 0 59 0 0 0 15) ; "Don't even bother looking in your pockets. You are carrying nothing, nada, zip, zero, zilch."
		(return 0)
	)
)

(instance chooseIcon of SQIconItem
	(properties
		noun 6
		x 7
		y 93
		signal 129
		mainView 952
		maskView 952
		maskCel 2
		cursorView 999
		cursorLoop 0
		cursorCel 0
		helpVerb 17
	)
)

(instance eyesIcon of SQIconItem
	(properties
		noun 7
		x 44
		y 93
		signal 129
		message 1
		mainView 952
		mainLoop 1
		maskView 952
		maskLoop 1
		maskCel 2
		cursorView 953
		cursorLoop 1
		cursorCel 0
		helpVerb 17
	)
)

(instance handsIcon of SQIconItem
	(properties
		noun 8
		x 82
		y 93
		signal 129
		message 4
		mainView 952
		mainLoop 2
		maskView 952
		maskLoop 2
		maskCel 2
		cursorView 953
		cursorLoop 0
		cursorCel 0
		helpVerb 17
	)
)

(instance sqHelpIcon of SQIconItem
	(properties
		noun 11
		x 119
		y 93
		signal 131
		type 8192
		mainView 952
		mainLoop 3
		maskView 952
		maskLoop 3
		maskCel 2
		cursorView 953
		cursorLoop 4
		cursorCel 0
		helpVerb 17
	)
)

(instance playIcon of SQIconItem
	(properties
		noun 10
		x 156
		y 93
		signal 131
		mainView 952
		mainLoop 4
		maskView 952
		maskLoop 4
		maskCel 2
		cursorView 999
		cursorLoop 0
		cursorCel 0
		helpVerb 17
	)

	(method (select)
		(= cel 0)
		(super select: &rest)
	)
)

(instance upIcon of SQIconItem
	(properties
		noun 19
		x 182
		y 5
		signal 131
		mainView 952
		mainLoop 5
		maskView 952
		maskLoop 5
		maskCel 2
		cursorView 999
		cursorLoop 0
		cursorCel 0
		helpVerb 17
	)

	(method (select &tmp temp0)
		(if (and (super select: &rest) (gInventory curIndex:))
			(for ((= temp0 0)) (< temp0 40) ((++ temp0))
				(MovePlaneItems invPlane 0 1 0)
				(FrameOut)
			)
			(gInventory curIndex: (- (gInventory curIndex:) 1))
			(sliderIcon
				y: (- (sliderIcon y:) (/ 55 (/ (- (gInventory numInv:) 5) 4)))
			)
			(UpdateScreenItem sliderIcon)
		)
	)
)

(instance downIcon of SQIconItem
	(properties
		noun 20
		x 182
		y 77
		signal 131
		mainView 952
		mainLoop 6
		maskView 952
		maskLoop 6
		maskCel 2
		cursorView 999
		cursorLoop 0
		cursorCel 0
		helpVerb 17
	)

	(method (select &tmp temp0)
		(if
			(and
				(super select: &rest)
				(/ (- (gInventory numInv:) 1) (* (+ (gInventory curIndex:) 2) 4))
			)
			(for ((= temp0 0)) (< temp0 40) ((++ temp0))
				(MovePlaneItems invPlane 0 -1 0)
				(FrameOut)
			)
			(gInventory curIndex: (+ (gInventory curIndex:) 1))
			(sliderIcon
				y: (+ (sliderIcon y:) (/ 55 (/ (- (gInventory numInv:) 5) 4)))
			)
			(UpdateScreenItem sliderIcon)
		)
	)
)

(instance sliderIcon of SQIconItem
	(properties
		noun 21
		x 183
		y 19
		signal 131
		mainView 952
		mainLoop 7
		maskView 952
		maskLoop 7
		maskCel 2
		cursorView 999
		cursorLoop 0
		cursorCel 0
		helpVerb 17
	)
)

(instance Cheat_Sheet of SQInvItem
	(properties
		name {Cheat Sheet}
		noun 27
		signal 2
		message 63
		mainView 9550
	)

	(method (init)
		(self setCursor: 9550 0 2)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (not (IsFlag 207))
					(gGame points: 5)
					(SetFlag 207)
				)
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Buckazoids of SQInvItem
	(properties
		noun 28
		signal 2
		message 64
		mainView 9551
	)

	(method (init)
		(self setCursor: 9551 0 2)
		(super init:)
	)

	(method (highlight param1)
		(if (and argc param1)
			((gInventory bucksDisplay:) fore: 28)
		else
			((gInventory bucksDisplay:) fore: 37)
		)
		((gInventory bucksDisplay:) draw:)
		(super highlight: param1)
	)
)

(instance Datacorder of SQInvItem
	(properties
		noun 23
		signal 2
		message 6
		mainView 9552
	)

	(method (init)
		(self setCursor: 9552 0 2)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((== (gCurRoom inset:) (ScriptID 900 0)) ; dataCorderInset
						(gMessager say: noun theVerb 1 0 0 15) ; "You're already using it!"
					)
					((and (== gCurRoomNum 260) (not (IsFlag 410)))
						(gMessager say: noun theVerb 2 0 0 15) ; "Sorry, you can't bring up the datacorder at this time."
					)
					((OneOf gCurRoomNum 250 470 490 460 410)
						(gMessager say: noun theVerb 2 0 0 15) ; "Sorry, you can't bring up the datacorder at this time."
					)
					((gCurRoom inset:)
						(gMessager say: noun theVerb 2 0 0 15) ; "Sorry, you can't bring up the datacorder at this time."
					)
					(else
						(ClearFlag 65)
						(gInventory hide:)
						(gGame setCursor: gWaitCursor)
						(FrameOut)
						(gCurRoom setInset: (ScriptID 900 0) 0 0 1) ; dataCorderInset
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Empty_Tray of SQInvItem
	(properties
		name {Empty Tray}
		noun 2
		signal 2
		message 13
		mainView 9553
	)

	(method (init)
		(self setCursor: 9553 0 2)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(156 ; Whisk_Broom_Full
				(gEgo put: 111 put: 60 get: 61 110) ; Whisk_Broom_Full, Empty_Tray, Full_Tray
				(Whisk_Broom select: 0 1)
				(gInventory curIcon: Whisk_Broom)
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:) 1)
				(self cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(super cue:)
		(gGame points: 3)
		(gMessager say: 2 156 3 0 0 15) ; "Very good. He'll be much more transportable this way. However, you'd better hope it doesn't thaw."
	)
)

(instance Full_Tray of SQInvItem
	(properties
		name {Full Tray}
		noun 29
		signal 2
		message 65
		mainView 9554
	)

	(method (init)
		(self setCursor: 9554 0 2)
		(super init:)
	)
)

(instance Brandy of SQInvItem
	(properties
		noun 5
		signal 2
		message 16
		mainView 9555
	)

	(method (init)
		(self setCursor: 9555 0 2)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 29)
					(super doVerb: theVerb)
				else
					(gMessager say: 5 1 11 0 0 15) ; "It's that Coldsorian brandy. Yuck! It has a fish floating in the bottom. Oh well, to each their own."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Roger_Photos of SQInvItem
	(properties
		name {Roger Photos}
		noun 30
		signal 2
		message 66
		mainView 9556
	)

	(method (doVerb theVerb)
		(switch theVerb
			(67 ; Alien_ID
				(gEgo put: 93 put: 2 get: 92) ; Roger_Photos, Alien_ID, Roger_ID
				(Roger_ID select: 0 1)
				(gGame
					points: 5
					setCursor: ((gTheIconBar curIcon:) getCursor:) 1
				)
				(gMessager say: noun theVerb 0 0 self 15) ; "You quite cleverly paste your picture over the old one on the ID card."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(self setCursor: 9556 0 2)
		(super init:)
	)
)

(instance Alien_ID of SQInvItem
	(properties
		name {Alien ID}
		noun 31
		signal 2
		message 67
		mainView 9557
	)

	(method (doVerb theVerb)
		(switch theVerb
			(66 ; Roger_Photos
				(gEgo put: 93 put: 2 get: 92) ; Roger_Photos, Alien_ID, Roger_ID
				(Roger_ID select: 0 1)
				(gGame
					points: 5
					setCursor: ((gTheIconBar curIcon:) getCursor:) 1
				)
				(gMessager say: noun theVerb 0 0 self 15) ; "You quite cleverly paste your picture over the old one on the ID card."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(self setCursor: 9557 0 2)
		(super init:)
	)
)

(instance Roger_ID of SQInvItem
	(properties
		name {Roger ID}
		noun 32
		signal 2
		message 68
		mainView 9558
	)

	(method (init)
		(self setCursor: 9558 0 2)
		(super init:)
	)
)

(instance Coin of SQInvItem
	(properties
		noun 33
		signal 2
		message 69
		mainView 9559
	)

	(method (init)
		(self setCursor: 9559 0 2)
		(super init:)
	)
)

(instance Whisk_Broom of SQInvItem
	(properties
		name {Whisk Broom}
		noun 34
		signal 2
		message 70
		mainView 9560
	)

	(method (init)
		(self setCursor: 9560 0 2)
		(super init:)
	)
)

(instance Whisk_Broom_Full of SQInvItem
	(properties
		name {Whisk Broom Full}
		noun 117
		signal 2
		message 156
		mainView 9650
	)

	(method (init)
		(self setCursor: 9650 0 2)
		(super init:)
	)
)

(instance Hotel_Keycard of SQInvItem
	(properties
		name {Hotel Keycard}
		noun 35
		signal 2
		message 71
		mainView 9561
	)

	(method (init)
		(self setCursor: 9561 0 2)
		(super init:)
	)
)

(instance Hookah_Hose of SQInvItem
	(properties
		name {Hookah Hose}
		noun 36
		signal 2
		message 72
		mainView 9562
	)

	(method (init)
		(self setCursor: 9562 0 2)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: noun theVerb 0 0 self 15) ; "You carefully untangle the twisted mass of hookah hoses, and then rehook the hoses to create one long hose. It reminds you of Christmas time back home when you enjoyed untangling the Christmas lights and saying to yourself, "I get so much satisfaction from cleaning and straightening. One day I'll be the best janitor ever!""
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(if
			(and
				(== (gTheIconBar curIcon:) (gTheIconBar at: 7))
				(== (gTheIconBar curInvIcon:) self)
			)
			(= scratch 1)
		else
			(= scratch 0)
		)
		(gEgo get: 57 put: 58) ; Hookah_Connected, Hookah_Hose
		(super cue:)
		(if scratch
			(gTheIconBar
				curIcon: (gTheIconBar at: 7)
				curInvIcon: Hookah_Connected
				enableIcon: (gTheIconBar useIconItem:)
			)
			(= global121 (gTheIconBar curIcon:))
			(Hookah_Connected select:)
			(gInventory
				selectedInvIcon: Hookah_Connected
				curIcon: Hookah_Connected
			)
		)
		(gGame points: 2)
	)
)

(instance Hookah_Connected of SQInvItem
	(properties
		name {Hookah Connected}
		noun 37
		signal 2
		message 73
		mainView 9563
	)

	(method (init)
		(self setCursor: 9563 0 2)
		(super init:)
	)
)

(instance Dead_Fish of SQInvItem
	(properties
		name {Dead Fish}
		noun 38
		signal 2
		message 74
		mainView 9564
	)

	(method (init)
		(self setCursor: 9564 0 2)
		(super init:)
	)
)

(instance Dead_Fish2 of SQInvItem
	(properties
		name {Dead Fish2}
		noun 131
		signal 2
		message 74
		mainView 9661
	)

	(method (init)
		(self setCursor: 9564 0 2)
		(super init:)
	)
)

(instance Dead_Fish3 of SQInvItem
	(properties
		name {Dead Fish3}
		noun 132
		signal 2
		message 74
		mainView 9662
	)

	(method (init)
		(self setCursor: 9564 0 2)
		(super init:)
	)
)

(instance Holozine of SQInvItem
	(properties
		noun 39
		signal 2
		message 89
		mainView 9565
	)

	(method (init)
		(self setCursor: 9565 0 2)
		(super init:)
	)
)

(instance Nail of SQInvItem
	(properties
		noun 40
		signal 2
		message 88
		mainView 9566
	)

	(method (init)
		(self setCursor: 9566 0 2)
		(super init:)
	)
)

(instance Keyring of SQInvItem
	(properties
		noun 41
		signal 2
		message 87
		mainView 9567
	)

	(method (init)
		(self setCursor: 9567 0 2)
		(super init:)
	)
)

(instance Hand_Cuffs of SQInvItem
	(properties
		name {Hand Cuffs}
		noun 46
		signal 2
		message 86
		mainView 9568
	)

	(method (init)
		(self setCursor: 9568 0 2)
		(super init:)
	)
)

(instance Wall_Hanging of SQInvItem
	(properties
		name {Wall Hanging}
		noun 47
		signal 2
		message 85
		mainView 9569
	)

	(method (init)
		(self setCursor: 9569 0 2)
		(super init:)
	)
)

(instance Churlish_Moddie_1 of SQInvItem
	(properties
		name {Churlish Moddie 1}
		noun 42
		signal 2
		message 81
		mainView 9570
	)

	(method (init)
		(self setCursor: 9570 0 2)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 42 4 0 0 self 15) ; "The corner of the label on this moddie seems to be loose."
				(gEgo get: 19 put: 20) ; Ch_Label, Churlish_Moddie_1
				(Ch_Label select: 0 1)
				(gInventory curIcon: Ch_Label)
				(gGame
					points: 3 438
					setCursor: ((gTheIconBar curIcon:) getCursor:) 1
				)
				(self cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Burlesque_Moddie_1 of SQInvItem
	(properties
		name {Burlesque Moddie 1}
		noun 48
		signal 2
		message 80
		mainView 9574
	)

	(method (init)
		(self setCursor: 9574 0 2)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(76 ; Ch_Label
				(gEgo get: 15 put: 14 put: 19) ; Burlesque_Moddie_4, Burlesque_Moddie_1, Ch_Label
				(Burlesque_Moddie_4 select: 0 1)
				(gInventory curIcon: Burlesque_Moddie_4)
				(gGame
					points: 3 439
					setCursor: ((gTheIconBar curIcon:) getCursor:) 1
				)
				(self cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Burlesque_Moddie_4 of SQInvItem
	(properties
		name {Burlesque Moddie 4}
		noun 51
		signal 2
		message 77
		mainView 9577
	)

	(method (init)
		(self setCursor: 9577 0 2)
		(super init:)
	)
)

(instance Ch_Label of SQInvItem
	(properties
		name {Ch Label}
		noun 52
		signal 2
		message 76
		mainView 9578
	)

	(method (init)
		(self setCursor: 9578 0 2)
		(super init:)
	)
)

(instance Belt_Da_Pga of SQInvItem
	(properties
		name {Belt Da Pga}
		noun 54
		signal 2
		message 90
		mainView 9580
	)

	(method (init)
		(self setCursor: 9580 0 2)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(ClearFlag 65)
				(gInventory hide:)
				(if (gCurRoom inset:)
					((gCurRoom inset:) setInset: (ScriptID 45 0)) ; forceFieldBelt
				else
					(gCurRoom setInset: (ScriptID 45 0)) ; forceFieldBelt
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Belt_Da of SQInvItem
	(properties
		name {Belt Da}
		noun 55
		signal 2
		message 91
		mainView 9581
	)

	(method (init)
		(self setCursor: 9581 0 2)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(ClearFlag 65)
				(gInventory hide:)
				(if (gCurRoom inset:)
					((gCurRoom inset:) setInset: (ScriptID 45 0)) ; forceFieldBelt
				else
					(gCurRoom setInset: (ScriptID 45 0)) ; forceFieldBelt
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Belt_Pga of SQInvItem
	(properties
		name {Belt Pga}
		noun 56
		signal 2
		message 92
		mainView 9582
	)

	(method (init)
		(self setCursor: 9582 0 2)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(ClearFlag 65)
				(gInventory hide:)
				(if (gCurRoom inset:)
					((gCurRoom inset:) setInset: (ScriptID 45 0)) ; forceFieldBelt
				else
					(gCurRoom setInset: (ScriptID 45 0)) ; forceFieldBelt
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Actuator of SQInvItem
	(properties
		noun 57
		signal 2
		message 93
		mainView 9583
	)

	(method (init)
		(self setCursor: 9583 0 2)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((IsFlag 80)
						(gMessager say: 57 4 0 0 0 15) ; "While that's an interesting idea, it won't help."
					)
					((and (== gCurRoomNum 270) (not (IsFlag 80)))
						(gInventory hide:)
						(gGame setCursor: gWaitCursor)
						(if (== (gCurRoom inset:) (ScriptID 900 0)) ; dataCorderInset
							((gCurRoom inset:) dispose:)
							(DisposeScript 900)
						)
						(FrameOut)
						(gCurRoom setScript: (ScriptID 270 2)) ; sForceFieldDeactvtd
					)
					((!= gCurRoomNum 270)
						(gInventory hide:)
						(gMessager say: 22 0 8 0 0 270) ; "Hmm. Doesn't seem to work here."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Pga_Hair of SQInvItem
	(properties
		name {Pga Hair}
		noun 58
		signal 2
		message 94
		mainView 9584
	)

	(method (init)
		(self setCursor: 9584 0 2)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 159)
					(gEgo put: 78 get: 108) ; Pga_Hair, Wad_Of_Hair
					(Wad_Of_Hair select: 0 1)
					(gInventory curIcon: Wad_Of_Hair)
					(gGame setCursor: ((gTheIconBar curIcon:) getCursor:) 1)
					(self cue:)
				else
					(gMessager say: 58 4 5 0 0 15) ; "No, that's just not a good idea now."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(super cue:)
		(gGame points: 5 429)
	)
)

(instance Pga of SQInvItem
	(properties
		noun 59
		signal 2
		message 95
		mainView 9585
	)

	(method (init)
		(self setCursor: 9585 0 2)
		(super init:)
	)
)

(instance Wad_Of_Hair of SQInvItem
	(properties
		name {Wad Of Hair}
		noun 68
		signal 2
		message 104
		mainView 9586
	)

	(method (init)
		(self setCursor: 9586 0 2)
		(super init:)
	)
)

(instance Donut of SQInvItem
	(properties
		noun 1
		signal 2
		message 12
		mainView 9587
	)

	(method (doVerb theVerb)
		(switch theVerb
			(60 ; Morphin
				(gEgo put: 70 get: 71 put: 31 get: 32) ; Morphin, Morphing, Donut, Donut_Morph
				(Donut_Morph select: 0 1)
				(gInventory curIcon: Donut_Morph)
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:) 1)
				(self cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(super cue:)
		(gGame points: 3 443)
		(gMessager say: 0 4 0 2 0 98) ; "Good thinking!"
	)

	(method (init)
		(self setCursor: 9587 0 2)
		(super init:)
	)
)

(instance Donut_Morph of SQInvItem
	(properties
		name {Donut Morph}
		noun 60
		signal 2
		message 96
		mainView 9588
	)

	(method (init)
		(self setCursor: 9588 0 2)
		(super init:)
	)
)

(instance dummy1 of SQInvItem
	(properties
		noun 43
		signal 2
		message 75
		mainView 9651
	)

	(method (doVerb theVerb)
		(switch theVerb
			(100 ; Rack_Of_Orat
				(gEgo put: 89 put: 34 get: 35) ; Rack_Of_Orat, dummy1, dummy2
				(dummy2 select: 0 1)
				(gInventory curIcon: dummy2)
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:) 1)
				(self cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gMessager say: 43 100 0 0 0 15) ; "The Rack of Orat adds a nice touch."
		(super cue:)
	)

	(method (init)
		(self setCursor: 9651 0 2)
		(super init:)
	)
)

(instance dummy2 of SQInvItem
	(properties
		noun 44
		signal 2
		message 78
		mainView 9652
	)

	(method (doVerb theVerb)
		(switch theVerb
			(98 ; Baguettes
				(gEgo put: 5 put: 35 get: 36) ; Baguettes, dummy2, dummy3
				(dummy3 select: 0 1)
				(gInventory curIcon: dummy3)
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:) 1)
				(self cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gMessager say: 44 98 0 0 0 15) ; "An interesting idea. Something's starting to take shape. What are you up to, Roger?"
		(super cue:)
	)

	(method (init)
		(self setCursor: 9652 0 2)
		(super init:)
	)
)

(instance dummy3 of SQInvItem
	(properties
		noun 45
		signal 2
		message 79
		mainView 9653
	)

	(method (doVerb theVerb)
		(switch theVerb
			(99 ; Tubers
				(gEgo put: 107 put: 36 get: 37) ; Tubers, dummy3, dummy4
				(dummy4 select: 0 1)
				(gInventory curIcon: dummy4)
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:) 1)
				(self cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gMessager say: 45 99 0 0 0 15) ; "Attachment of that adds something more to your work in progress."
		(super cue:)
	)

	(method (init)
		(self setCursor: 9653 0 2)
		(super init:)
	)
)

(instance dummy4 of SQInvItem
	(properties
		noun 49
		signal 2
		message 82
		mainView 9654
	)

	(method (doVerb theVerb)
		(switch theVerb
			(97 ; Melon
				(gEgo put: 69 put: 37 get: 38) ; Melon, dummy4, dummy5
				(dummy5 select: 0 1)
				(gInventory curIcon: dummy5)
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:) 1)
				(self cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gMessager say: 49 97 0 0 0 15) ; "How creative!"
		(super cue:)
	)

	(method (init)
		(self setCursor: 9654 0 2)
		(super init:)
	)
)

(instance dummy5 of SQInvItem
	(properties
		noun 50
		signal 2
		message 83
		mainView 9655
	)

	(method (doVerb theVerb)
		(switch theVerb
			(103 ; Gragh
				(gEgo put: 52 put: 38 get: 39) ; Gragh, dummy5, dummy6
				(dummy6 select: 0 1)
				(gInventory curIcon: dummy6)
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:) 1)
				(gGame points: 1)
				(self cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gMessager say: 50 103 0 0 0 15) ; "That's a nice touch."
		(super cue:)
	)

	(method (init)
		(self setCursor: 9655 0 2)
		(super init:)
	)
)

(instance dummy6 of SQInvItem
	(properties
		noun 53
		signal 2
		message 84
		mainView 9656
	)

	(method (init)
		(self setCursor: 9656 0 2)
		(super init:)
	)
)

(instance Yoda_Ears of SQInvItem
	(properties
		name {Yoda Ears}
		noun 66
		signal 2
		message 102
		mainView 9594
	)

	(method (doVerb theVerb)
		(switch theVerb
			(101 ; Bobbit_Kabobs
				(gEgo put: 113 put: 11 get: 34) ; Yoda_Ears, Bobbit_Kabobs, dummy1
				(dummy1 select: 0 1)
				(gInventory curIcon: dummy1)
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:) 1)
				(gGame points: 1)
				(self cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gMessager say: 66 101 0 0 0 15) ; "Now it has some cool ears."
		(super cue:)
	)

	(method (init)
		(self setCursor: 9594 0 2)
		(super init:)
	)
)

(instance Bobbit_Kabobs of SQInvItem
	(properties
		name {Bobbit Kabobs}
		noun 65
		signal 2
		message 101
		mainView 9593
	)

	(method (doVerb theVerb)
		(switch theVerb
			(102 ; Yoda_Ears
				(gEgo put: 113 put: 11 get: 34) ; Yoda_Ears, Bobbit_Kabobs, dummy1
				(dummy1 select: 0 1)
				(gInventory curIcon: dummy1)
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:) 1)
				(gGame points: 1)
				(self cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gMessager say: 65 102 0 0 0 15) ; "Now it has some cool ears."
		(super cue:)
	)

	(method (init)
		(self setCursor: 9593 0 2)
		(super init:)
	)
)

(instance Rack_Of_Orat of SQInvItem
	(properties
		name {Rack Of Orat}
		noun 64
		signal 2
		message 100
		mainView 9592
	)

	(method (doVerb theVerb)
		(switch theVerb
			(75 ; dummy1
				(gEgo put: 89 put: 34 get: 35) ; Rack_Of_Orat, dummy1, dummy2
				(dummy2 select: 0 1)
				(gInventory curIcon: dummy2)
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:) 1)
				(self cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gMessager say: 64 75 0 0 0 15) ; "The Rack of Orat adds a nice touch."
		(super cue:)
	)

	(method (init)
		(self setCursor: 9592 0 2)
		(super init:)
	)
)

(instance Baguettes of SQInvItem
	(properties
		noun 62
		signal 2
		message 98
		mainView 9590
	)

	(method (doVerb theVerb)
		(switch theVerb
			(78 ; dummy2
				(gEgo put: 5 put: 35 get: 36) ; Baguettes, dummy2, dummy3
				(dummy3 select: 0 1)
				(gInventory curIcon: dummy3)
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:) 1)
				(self cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gMessager say: 62 78 0 0 0 15) ; "An interesting idea. Something's starting to take shape. What are you up to, Roger?"
		(super cue:)
	)

	(method (init)
		(self setCursor: 9590 0 2)
		(super init:)
	)
)

(instance Tubers of SQInvItem
	(properties
		noun 63
		signal 2
		message 99
		mainView 9591
	)

	(method (doVerb theVerb)
		(switch theVerb
			(79 ; dummy3
				(gEgo put: 107 put: 36 get: 37) ; Tubers, dummy3, dummy4
				(dummy4 select: 0 1)
				(gInventory curIcon: dummy4)
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:) 1)
				(self cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gMessager say: 63 79 0 0 0 15) ; "Attachment of that adds something more to your work in progress."
		(super cue:)
	)

	(method (init)
		(self setCursor: 9591 0 2)
		(super init:)
	)
)

(instance Melon of SQInvItem
	(properties
		noun 61
		signal 2
		message 97
		mainView 9589
	)

	(method (doVerb theVerb)
		(switch theVerb
			(82 ; dummy4
				(gEgo put: 69 put: 37 get: 38) ; Melon, dummy4, dummy5
				(dummy5 select: 0 1)
				(gInventory curIcon: dummy5)
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:) 1)
				(self cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gMessager say: 61 82 0 0 0 15) ; "How creative!"
		(super cue:)
	)

	(method (init)
		(self setCursor: 9589 0 2)
		(super init:)
	)
)

(instance Gragh of SQInvItem
	(properties
		noun 67
		signal 2
		message 103
		mainView 9595
	)

	(method (doVerb theVerb)
		(switch theVerb
			(83 ; dummy5
				(gEgo put: 52 put: 38 get: 39) ; Gragh, dummy5, dummy6
				(dummy6 select: 0 1)
				(gInventory curIcon: dummy6)
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:) 1)
				(gGame points: 1)
				(self cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gMessager say: 67 83 0 0 0 15) ; "That's a nice touch."
		(super cue:)
	)

	(method (init)
		(self setCursor: 9595 0 2)
		(super init:)
	)
)

(instance Morphin of SQInvItem
	(properties
		noun 24
		signal 2
		message 60
		mainView 9596
	)

	(method (init)
		(self setCursor: 9596 0 2)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 24 1 12 0 0 15) ; "It's a bottle of Morphin."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Morphing of SQInvItem
	(properties
		noun 25
		signal 2
		message 61
		mainView 9597
	)

	(method (init)
		(self setCursor: 9597 0 2)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 24 1 0 0 0 15) ; "It's a bottle of Morphin, which you thought was actually Morphine. DOI!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Data_Cart of SQInvItem
	(properties
		name {Data Cart}
		noun 69
		signal 2
		message 105
		mainView 9598
	)

	(method (init)
		(self setCursor: 9598 0 2)
		(super init:)
	)
)

(instance Eulogy of SQInvItem
	(properties
		noun 70
		signal 2
		message 106
		mainView 9599
	)

	(method (init)
		(self setCursor: 9599 0 2)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (not (IsFlag 41))
					(gInventory hide:)
					(gEgo cue:)
				else
					(super doVerb: 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Sidney_Arm of SQInvItem
	(properties
		name {Sidney Arm}
		noun 71
		signal 2
		message 107
		mainView 9600
	)

	(method (init)
		(self setCursor: 9600 0 2)
		(super init:)
	)
)

(instance Sidney_Eye of SQInvItem
	(properties
		name {Sidney Eye}
		noun 72
		signal 2
		message 108
		mainView 9601
	)

	(method (init)
		(self setCursor: 9601 0 2)
		(super init:)
	)
)

(instance Alarm_Key of SQInvItem
	(properties
		name {Alarm Key}
		noun 73
		signal 2
		message 109
		mainView 9602
	)

	(method (init)
		(self setCursor: 9602 0 2)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 157)
					(gMessager say: noun 0 13 0 0 15) ; "I probably don't need to set the alarm."
				else
					(gGame points: 3 413)
					(if (== gCurRoomNum 450)
						(gInventory hide:)
						(gCurRoom notify:)
					else
						(gCurRoom setScript: sHandleAlarm)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Jumper_Cables of SQInvItem
	(properties
		name {Jumper Cables}
		noun 74
		signal 2
		message 110
		mainView 9603
	)

	(method (init)
		(self setCursor: 9603 0 2)
		(super init:)
	)
)

(instance Windshield_Sign of SQInvItem
	(properties
		name {Windshield Sign}
		noun 75
		signal 2
		message 111
		mainView 9604
	)

	(method (init)
		(self setCursor: 9604 0 2)
		(super init:)
	)
)

(instance Crystal of SQInvItem
	(properties
		noun 22
		signal 2
		message 27
		mainView 9605
	)

	(method (init)
		(self setCursor: 9605 0 2)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(112 ; Elmo_Gluzall
				(gMessager say: noun 112 0 0 0 15) ; "You pour glue all over the crystal."
				(self cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gEgo put: 23 get: 24) ; Crystal, Crystal_With_Glue
		(gGame points: 1 setCursor: ((gTheIconBar curIcon:) getCursor:) 1)
		(super cue:)
	)
)

(instance Crystal_With_Glue of SQInvItem
	(properties
		name {Crystal With Glue}
		noun 95
		signal 2
		message 151
		mainView 9626
	)

	(method (init)
		(self setCursor: 9626 0 2)
		(super init:)
	)
)

(instance Elmo_Gluzall of SQInvItem
	(properties
		name {Elmo Gluzall}
		noun 76
		signal 2
		message 112
		mainView 9606
	)

	(method (init)
		(self setCursor: 9606 0 2)
		(super init:)
	)
)

(instance Eva_Suit of SQInvItem
	(properties
		name {Eva Suit}
		noun 77
		signal 2
		message 113
		mainView 9607
	)

	(method (init)
		(self setCursor: 9607 0 2)
		(super init:)
	)
)

(instance Eva_Helmet of SQInvItem
	(properties
		name {Eva Helmet}
		noun 78
		signal 2
		message 114
		mainView 9608
	)

	(method (init)
		(self setCursor: 9608 0 2)
		(super init:)
	)
)

(instance Eva_Full of SQInvItem
	(properties
		name {Eva Full}
		noun 79
		signal 2
		message 115
		mainView 9609
	)

	(method (init)
		(self setCursor: 9609 0 2)
		(super init:)
	)
)

(instance Eva_Full_Enz of SQInvItem
	(properties
		name {Eva Full Enz}
		noun 79
		signal 2
		message 115
		mainView 9657
	)

	(method (init)
		(self setCursor: 9657 0 2)
		(super init:)
	)
)

(instance Eva_Full_Both of SQInvItem
	(properties
		name {Eva Full Both}
		noun 79
		signal 2
		message 115
		mainView 9658
	)

	(method (init)
		(self setCursor: 9658 0 2)
		(super init:)
	)
)

(instance Trans_Signaler of SQInvItem
	(properties
		name {Trans Signaler}
		noun 3
		signal 2
		message 14
		mainView 9610
	)

	(method (init)
		(self setCursor: 9610 0 2)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== gCurRoomNum 340)
					(gInventory hide:)
					(gCurRoom notify: 33)
				else
					(gMessager say: 0 0 4 0 0 20) ; "As Manuel told you, you can only use it from the area you transported to originally."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Recall_Notice of SQInvItem
	(properties
		name {Recall Notice}
		noun 80
		signal 2
		message 116
		mainView 9611
	)

	(method (init)
		(self setCursor: 9611 0 2)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setScript: sLookAtRecall)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Duct_Tape of SQInvItem
	(properties
		name {Duct Tape}
		noun 15
		signal 2
		message 22
		mainView 9616
	)

	(method (doVerb theVerb)
		(switch theVerb
			(137 ; Separated_Caps
				(gEgo put: 33 put: 99 get: 4) ; Duct_Tape, Separated_Caps, Attach_Caps
				(Attach_Caps select: 0 1)
				(gInventory curIcon: Attach_Caps)
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:) 1)
				(gGame points: 3)
				(gMessager say: noun theVerb 0 0 self 15) ; "You cleverly tape the capillaries together."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(self setCursor: 9616 0 2)
		(super init:)
	)
)

(instance Hand_Pump of SQInvItem
	(properties
		name {Hand Pump}
		noun 85
		signal 2
		message 121
		mainView 9617
	)

	(method (doVerb theVerb)
		(switch theVerb
			(138 ; Attach_Caps
				(gEgo put: 4 put: 54 get: 88) ; Attach_Caps, Hand_Pump, Pump_With_Hose
				(Pump_With_Hose select: 0 1)
				(gInventory curIcon: Pump_With_Hose)
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:) 1)
				(self cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gMessager say: 85 138 0 0 0 15) ; "Nice work. You've hooked up your makeshift hose to the pump."
		(super cue:)
	)

	(method (init)
		(self setCursor: 9617 0 2)
		(super init:)
	)
)

(instance Pump_With_Hose of SQInvItem
	(properties
		name {Pump With Hose}
		noun 119
		signal 2
		message 159
		mainView 9630
	)

	(method (init)
		(self setCursor: 9630 0 2)
		(super init:)
	)
)

(instance Callahan_Moddie of SQInvItem
	(properties
		name {Callahan Moddie}
		noun 87
		signal 2
		message 122
		mainView 9618
	)

	(method (init)
		(self setCursor: 9618 0 2)
		(super init:)
	)
)

(instance Cyber_Jack of SQInvItem
	(properties
		name {Cyber Jack}
		noun 93
		signal 2
		message 128
		mainView 9624
	)

	(method (init)
		(self setCursor: 9624 0 2)
		(super init:)
	)
)

(instance Crap_O_Matic of SQInvItem
	(properties
		name {Crap O Matic}
		noun 115
		signal 2
		message 149
		mainView 9629
	)

	(method (init)
		(self setCursor: 9629 0 2)
		(super init:)
	)
)

(instance Rag of SQInvItem
	(properties
		noun 86
		signal 2
		message 131
		mainView 9630
	)

	(method (init)
		(self setCursor: 9630 0 2)
		(super init:)
	)
)

(instance Number_3_Cord of SQInvItem
	(properties
		name {Number 3 Cord}
		noun 97
		signal 2
		message 133
		mainView 9632
	)

	(method (init)
		(self setCursor: 9632 0 2)
		(super init:)
	)
)

(instance Silver_Chunk of SQInvItem
	(properties
		name {Silver Chunk}
		noun 98
		signal 2
		message 134
		mainView 9633
	)

	(method (init)
		(self setCursor: 9633 0 2)
		(super init:)
	)
)

(instance Finger_Nail of SQInvItem
	(properties
		name {Finger Nail}
		noun 99
		signal 2
		message 135
		mainView 9634
	)

	(method (init)
		(self setCursor: 9634 0 2)
		(super init:)
	)
)

(instance Alveoli of SQInvItem
	(properties
		noun 100
		signal 2
		message 136
		mainView 9635
	)

	(method (init)
		(self setCursor: 9635 0 2)
		(super init:)
	)
)

(instance Separated_Caps of SQInvItem
	(properties
		name {Separated Caps}
		noun 101
		signal 2
		message 137
		mainView 9636
	)

	(method (doVerb theVerb)
		(switch theVerb
			(22 ; Duct_Tape
				(gEgo put: 33 put: 99 get: 4) ; Duct_Tape, Separated_Caps, Attach_Caps
				(Attach_Caps select: 0 1)
				(gInventory curIcon: Attach_Caps)
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:) 1)
				(gGame points: 3)
				(gMessager say: noun theVerb 0 0 self 15) ; "You cleverly tape the capillaries together."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(self setCursor: 9636 0 2)
		(super init:)
	)
)

(instance Attach_Caps of SQInvItem
	(properties
		name {Attach Caps}
		noun 102
		signal 2
		message 138
		mainView 9637
	)

	(method (doVerb theVerb)
		(switch theVerb
			(121 ; Hand_Pump
				(gEgo put: 4 put: 54 get: 88) ; Attach_Caps, Hand_Pump, Pump_With_Hose
				(Pump_With_Hose select: 0 1)
				(gInventory curIcon: Pump_With_Hose)
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:) 1)
				(self cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gMessager say: 85 138 0 0 0 15) ; "Nice work. You've hooked up your makeshift hose to the pump."
		(super cue:)
	)

	(method (init)
		(self setCursor: 9637 0 2)
		(super init:)
	)
)

(instance Gallstone of SQInvItem
	(properties
		noun 103
		signal 2
		message 139
		mainView 9638
	)

	(method (init)
		(self setCursor: 9638 0 2)
		(super init:)
	)
)

(instance Paperclip of SQInvItem
	(properties
		noun 104
		signal 2
		message 140
		mainView 9639
	)

	(method (init)
		(self setCursor: 9639 0 2)
		(super init:)
	)
)

(instance M_M of SQInvItem
	(properties
		name {M&M}
		noun 105
		signal 2
		message 141
		mainView 9640
	)

	(method (init)
		(self setCursor: 9640 0 2)
		(super init:)
	)
)

(instance M_M_Green of SQInvItem
	(properties
		name {M&M Green}
		noun 105
		signal 2
		message 141
		mainView 9664
	)

	(method (init)
		(self setCursor: 9664 0 2)
		(super init:)
	)
)

(instance M_M_Yellow of SQInvItem
	(properties
		name {M&M Yellow}
		noun 105
		signal 2
		message 141
		mainView 9663
	)

	(method (init)
		(self setCursor: 9663 0 2)
		(super init:)
	)
)

(instance Staple of SQInvItem
	(properties
		noun 106
		signal 2
		message 142
		mainView 9641
	)

	(method (init)
		(self setCursor: 9641 0 2)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(143 ; Celery
				(gEgo get: 56 put: 17 put: 104) ; Grappling_Hook, Celery, Staple
				(Grappling_Hook select: 0 1)
				(gInventory curIcon: Grappling_Hook)
				(gGame
					points: 2
					setCursor: ((gTheIconBar curIcon:) getCursor:) 1
				)
				(self cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Celery of SQInvItem
	(properties
		noun 107
		signal 2
		message 143
		mainView 9642
	)

	(method (init)
		(self setCursor: 9642 0 2)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(142 ; Staple
				(gEgo get: 56 put: 17 put: 104) ; Grappling_Hook, Celery, Staple
				(Grappling_Hook select: 0 1)
				(gInventory curIcon: Grappling_Hook)
				(gGame
					points: 2
					setCursor: ((gTheIconBar curIcon:) getCursor:) 1
				)
				(self cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Time_Pills of SQInvItem
	(properties
		name {Time Pills}
		noun 108
		signal 2
		message 144
		mainView 9643
	)

	(method (init)
		(self setCursor: 9643 0 2)
		(super init:)
	)
)

(instance Grappling_Hook of SQInvItem
	(properties
		name {Grappling Hook}
		noun 109
		signal 2
		message 145
		mainView 9644
	)

	(method (init)
		(self setCursor: 9644 0 2)
		(super init:)
	)
)

(instance Pinfeather of SQInvItem
	(properties
		noun 110
		signal 2
		message 146
		mainView 9645
	)

	(method (init)
		(self setCursor: 9645 0 2)
		(super init:)
	)
)

(instance Nerve_Fibers of SQInvItem
	(properties
		name {Nerve Fibers}
		noun 111
		signal 2
		message 147
		mainView 9646
	)

	(method (init)
		(self setCursor: 9646 0 2)
		(super init:)
	)
)

(instance Magnet of SQInvItem
	(properties
		noun 112
		signal 2
		message 148
		mainView 9647
	)

	(method (init)
		(self setCursor: 9647 0 2)
		(super init:)
	)
)

(instance Pipe of SQInvItem
	(properties
		noun 116
		signal 2
		message 154
		mainView 9649
	)

	(method (init)
		(self setCursor: 9649 0 2)
		(super init:)
	)
)

(instance Subroutine_Card of SQInvItem
	(properties
		name {Subroutine Card}
		noun 113
		signal 2
		message 130
		mainView 9628
	)

	(method (init)
		(self setCursor: 9628 0 2)
		(super init:)
	)
)

(instance First_Photo of SQInvItem
	(properties
		name {First Photo}
		noun 81
		signal 2
		message 117
		mainView 9625
	)

	(method (init)
		(self setCursor: 9625 0 2)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(SetFlag 83)
				(gEgo put: 49 get: 50 48) ; First_Photo, First_Positive
				(gGame points: 1 513)
				(gMessager say: noun 4 7 0 self 15) ; "You peel apart the photo and negative from your first PTS image."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance First_Positive of SQInvItem
	(properties
		name {First Positive}
		noun 114
		signal 2
		message 157
		mainView 9612
	)

	(method (init)
		(self setCursor: 9612 0 2)
		(super init:)
	)
)

(instance First_Negative of SQInvItem
	(properties
		name {First Negative}
		noun 83
		signal 2
		message 119
		mainView 9614
	)

	(method (init)
		(self setCursor: 9614 0 2)
		(super init:)
	)
)

(instance Second_Photo of SQInvItem
	(properties
		name {Second Photo}
		noun 82
		signal 2
		message 118
		mainView 9625
	)

	(method (init)
		(self setCursor: 9625 0 2)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(SetFlag 84)
				(gEgo put: 97 get: 98 96) ; Second_Photo, Second_Positive
				(gGame points: 1 514)
				(gMessager say: noun 4 7 0 self 15) ; "You peel apart the photo and negative from the second PTS image."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Second_Positive of SQInvItem
	(properties
		name {Second Positive}
		noun 118
		signal 2
		message 158
		mainView 9613
	)

	(method (init)
		(self setCursor: 9613 0 2)
		(super init:)
	)
)

(instance Second_Negative of SQInvItem
	(properties
		name {Second Negative}
		noun 84
		signal 2
		message 120
		mainView 9615
	)

	(method (init)
		(self setCursor: 9615 0 2)
		(super init:)
	)
)

(instance Board of SQInvItem
	(properties
		noun 120
		signal 2
		message 160
		mainView 9627
	)

	(method (init)
		(self setCursor: 9627 0 2)
		(super init:)
	)
)

(instance Belleaux_s_Record_Printout of SQInvItem
	(properties
		name {Belleaux's Record Printout}
		noun 124
		signal 2
		message 162
		mainView 9659
	)

	(method (init)
		(self setCursor: 9659 0 2)
		(super init:)
	)
)

(instance Nigel_s_Record_Printout of SQInvItem
	(properties
		name {Nigel's Record Printout}
		noun 126
		signal 2
		message 163
		mainView 9659
	)

	(method (init)
		(self setCursor: 9659 0 2)
		(super init:)
	)
)

(instance Project_Immortality_Record_Printout of SQInvItem
	(properties
		name {Project Immortality Record Printout}
		noun 127
		signal 2
		message 164
		mainView 9659
	)

	(method (init)
		(self setCursor: 9659 0 2)
		(super init:)
	)
)

(instance Sharpei_s_Record_Printout of SQInvItem
	(properties
		name {Sharpei's Record Printout}
		noun 128
		signal 2
		message 165
		mainView 9659
	)

	(method (init)
		(self setCursor: 9659 0 2)
		(super init:)
	)
)

(instance Stellar_s_Record_Printout of SQInvItem
	(properties
		name {Stellar's Record Printout}
		noun 130
		signal 2
		message 166
		mainView 9659
	)

	(method (init)
		(self setCursor: 9659 0 2)
		(super init:)
	)
)

(instance Incriminating_Printouts of SQInvItem
	(properties
		name {Incriminating Printouts}
		noun 125
		signal 2
		message 161
		mainView 9660
	)

	(method (init)
		(self setCursor: 9660 0 2)
		(super init:)
	)
)

(instance Screwdriver of SQInvItem
	(properties
		noun 123
		signal 2
		message 132
		mainView 9631
	)

	(method (init)
		(self setCursor: 9631 0 2)
		(super init:)
	)
)

(class FileRecord of SQInvItem
	(properties
		textNoun 0
		readFlag -1
	)

	(method (init)
		(self setCursor: 9622 0 2)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (or (== theVerb 4) (== theVerb 1)) ; Do, Look
			(ClearFlag 65)
			(self haveRead:)
			(gInventory hide:)
			(gCurRoom setInset: (ScriptID 50 0) 0 textNoun) ; lookFiles
		else
			(super doVerb: theVerb)
		)
	)

	(method (haveRead)
		(if (and (!= readFlag -1) (not (IsFlag readFlag)))
			(SetFlag readFlag)
		)
	)
)

(instance Sape_Record of FileRecord
	(properties
		name {Sape Record}
		noun 88
		signal 2
		message 123
		mainView 9619
		textNoun 3
		readFlag 137
	)

	(method (init)
		(self setCursor: 9619 0 2)
		(super init:)
	)
)

(instance Nigel_Record of FileRecord
	(properties
		name {Nigel Record}
		noun 89
		signal 2
		message 124
		mainView 9620
		textNoun 4
		readFlag 134
	)

	(method (init)
		(self setCursor: 9620 0 2)
		(super init:)
	)
)

(instance Project_Record of FileRecord
	(properties
		name {Project Record}
		noun 90
		signal 2
		message 125
		mainView 9621
		textNoun 5
		readFlag 135
	)

	(method (init)
		(self setCursor: 9621 0 2)
		(super init:)
	)
)

(instance Beleaux_Record of FileRecord
	(properties
		name {Beleaux Record}
		noun 91
		signal 2
		message 126
		mainView 9622
		textNoun 2
		readFlag 133
	)

	(method (init)
		(self setCursor: 9622 0 2)
		(super init:)
	)
)

(instance Icky_Record of FileRecord
	(properties
		name {Icky Record}
		noun 92
		signal 2
		message 127
		mainView 9623
		textNoun 6
		readFlag 136
	)

	(method (init)
		(self setCursor: 9623 0 2)
		(super init:)
	)
)

(instance invPlane of Plane
	(properties)
)

(instance sLookAtRecall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager sayRange: 80 1 0 1 2 self 15) ; "It's the recall notice for the owner's manual."
			)
			(1
				((Print new:)
					fore: 0
					back: -1
					addText: 80 1 0 3 10 20 15
					addText: 80 1 0 4 10 60 15
					addIcon: 4891
					init:
				)
				(self dispose:)
			)
		)
	)
)

(instance sHandleAlarm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(invSound number: 453 play:)
				(while (invSound handle:)
					(invSound check:)
				)
				(self cue:)
			)
			(1
				(if (IsFlag 49)
					(ClearFlag 49)
					(gMessager say: 73 0 16 0 self 15) ; "The shuttle's alarm is now activated."
				else
					(SetFlag 49)
					(gMessager say: 73 0 6 0 self 15) ; "The shuttle's alarm is now deactivated."
				)
				(self dispose:)
			)
		)
	)
)

(instance invSound of Sound
	(properties)
)

