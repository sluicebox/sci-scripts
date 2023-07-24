;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use ScrollerWindow)
(use DText)
(use Str)
(use Array)
(use Print)
(use IconBar)
(use Tutorial)
(use Sound)
(use Actor)
(use System)

(public
	SQIconbar 0
	SQIconItem 1
)

(class SQIconItem of IconI
	(properties)

	(method (highlight param1)
		(if (not (& signal $0020))
			(return)
		)
		(= cel (* 1 (if argc param1)))
		(UpdateScreenItem self)
	)

	(method (select param1 &tmp temp0 temp1 temp2)
		(return
			(cond
				((& signal $0004) 0)
				((and argc param1 (& signal $0001))
					(= cel (= temp1 1))
					(UpdateScreenItem self)
					(FrameOut)
					(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
						(temp0 localize: plane)
						(cond
							((self onMe: temp0)
								(if (not temp1)
									(= cel (= temp1 1))
									(UpdateScreenItem self)
									(FrameOut)
								)
							)
							(temp1
								(= cel (= temp1 0))
								(gInventory highlightedIcon: 0)
								(UpdateScreenItem self)
								(FrameOut)
							)
						)
						(temp0 dispose:)
					)
					(temp0 dispose:)
					(if
						(and
							(= temp2 (gGame script:))
							(temp2 isKindOf: Tutorial)
						)
						(cond
							(
								(and
									(== (temp2 nextItem:) self)
									(!=
										(temp2 nextAction:)
										((gTheIconBar helpIconItem:) message:)
									)
								)
								(temp2 cue:)
							)
							((not temp1)
								(return 0)
							)
							(else
								(temp2 report:)
								(return 0)
							)
						)
					)
					temp1
				)
				(else
					(if
						(and
							(= temp2 (gGame script:))
							(temp2 isKindOf: Tutorial)
						)
						(if
							(and
								(== (temp2 nextItem:) self)
								(!=
									(temp2 nextAction:)
									((gTheIconBar helpIconItem:) message:)
								)
							)
							(temp2 cue:)
						else
							(temp2 report:)
							(return 0)
						)
					)
					1
				)
			)
		)
	)
)

(class SQIconbar of IconBar
	(properties
		iconCast 0
		iconSettings 0
		numBuckStr 0
		bucksDisplay 0
		bucksShowing 0
	)

	(method (init)
		(if (== gTheIconBar self)
			(return)
		)
		((= gTheIconBar self)
			add:
				walkIcon0
				lookIcon1
				doIcon2
				talkIcon3
				invIcon4
				helpIcon5
				controlIcon6
				useIcon7
			curIcon: walkIcon0
			walkIconItem: walkIcon0
			helpIconItem: helpIcon5
			useIconItem: useIcon7
			state: (| (SQIconbar state:) $0801)
		)
		(useIcon7 signal: (| (useIcon7 signal:) $0004))
		(super init:)
		(= iconCast (Cast new:))
		(plane
			addCast: iconCast
			setBitmap: 951 10 0
			priority: 10
			setRect: 0 139 320 200
		)
		(curInvView init: iconCast hide:)
		(LED1 init: iconCast setCel: (/ gScore 100))
		(LED2 init: iconCast setCel: (/ gScore 10))
		(LED3 init: iconCast setCel: (mod gScore 10))
		(= gTextScroller
			(textScroller
				init: scrollBar scrollBarUpIcon scrollBarDownIcon
				yourself:
			)
		)
	)

	(method (showTextScroller param1)
		(if (or (not argc) (and argc param1))
			(scrollBarUpIcon
				mainView: 9511
				mainLoop: 1
				x: 0
				y: 0
				priority: 15
				fixPriority: 1
			)
			(scrollBarDownIcon
				mainView: 9511
				mainLoop: 2
				x: 0
				y: 37
				priority: 15
				fixPriority: 1
			)
			(scrollBar
				view: 9511
				thumbView: 9511
				thumbCel: 1
				x: 1
				y: 5
				minPosn: 5
				maxPosn: 34
				priority: 14
				fixPriority: 1
			)
			(= gTextScroller
				(textScroller
					fore: 82
					back: 0
					borderColor: 0
					nsLeft: 6
					nsTop: 157
					nsRight: 254
					nsBottom: 197
					maxItems: 50
					font: 70
					init: scrollBar scrollBarUpIcon scrollBarDownIcon
					show:
					yourself:
				)
			)
		else
			(gTextScroller dispose:)
			(= gTextScroller 0)
		)
	)

	(method (updateScore param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 0)) (< temp0 param1) ((++ temp0))
			(LED3 setCel: (mod (+ (LED3 cel:) 1) 10))
			(UpdateScreenItem LED3)
			(if (== (LED3 cel:) 0)
				(LED2 setCel: (mod (+ (LED2 cel:) 1) 10))
				(UpdateScreenItem LED2)
				(if (== (LED2 cel:) 0)
					(LED1 setCel: (mod (+ (LED1 cel:) 1) 10))
					(UpdateScreenItem LED1)
				)
			)
			(sPointsSnd play:)
			(FrameOut)
			(cond
				((< gHowFast 3)
					(= temp2 12000)
				)
				((< gHowFast 4)
					(= temp2 8000)
				)
				((< gHowFast 5)
					(= temp2 5000)
				)
				((< gHowFast 6)
					(= temp2 3000)
				)
				(else
					(= temp2 2000)
				)
			)
			(for ((= temp1 0)) (< temp1 temp2) ((++ temp1))
			)
		)
	)

	(method (trickScore param1 &tmp temp0 temp1 temp2)
		(if (> param1 gScore)
			(= param1 gScore)
		)
		(for ((= temp0 0)) (< temp0 param1) ((++ temp0))
			(if (!= (LED3 cel:) 0)
				(LED3 setCel: (- (LED3 cel:) 1))
				(UpdateScreenItem LED3)
			else
				(LED3 setCel: 9)
				(UpdateScreenItem LED3)
				(if (!= (LED2 cel:) 0)
					(LED2 setCel: (- (LED2 cel:) 1))
					(UpdateScreenItem LED2)
				else
					(LED2 setCel: 9)
					(UpdateScreenItem LED2)
					(if (!= (LED1 cel:) 0)
						(LED1 setCel: (- (LED1 cel:) 1))
						(UpdateScreenItem LED1)
					)
				)
			)
			(sPointsSnd play:)
			(FrameOut)
			(cond
				((< gHowFast 3)
					(= temp2 12000)
				)
				((< gHowFast 4)
					(= temp2 8000)
				)
				((< gHowFast 5)
					(= temp2 5000)
				)
				((< gHowFast 6)
					(= temp2 3000)
				)
				(else
					(= temp2 2000)
				)
			)
			(for ((= temp1 0)) (< temp1 temp2) ((++ temp1))
			)
		)
	)

	(method (setupExit param1)
		(if param1
			(gTheIconBar
				delete: walkIcon0
				addToFront: exitIcon8
				highlightedIcon: 0
			)
			(DeleteScreenItem walkIcon0)
			(exitIcon8 init: self)
			(gTheIconBar show:)
		else
			(gTheIconBar
				delete: exitIcon8
				addToFront: walkIcon0
				highlightedIcon: 0
			)
			(DeleteScreenItem exitIcon8)
			(walkIcon0 init: self)
			(gTheIconBar enable: 0)
			(gTheIconBar show:)
		)
	)

	(method (shouldOpen param1)
		(if (== (param1 type:) 0)
			(plane onMe: param1)
		)
	)

	(method (shouldClose param1)
		(param1 globalize:)
		(return (and (== (param1 type:) 0) (not (plane onMe: param1))))
	)

	(method (show &tmp temp0 temp1 temp2 temp3)
		(|= state $0020)
		(plane priority: 10)
		(UpdatePlane plane)
		(= temp0 0)
		(= temp1 y)
		(for ((= temp2 (KList 3 elements))) temp2 ((= temp2 nextNode)) ; FirstNode
			(= nextNode (KList 6 temp2)) ; NextNode
			(= temp3 (KList 8 temp2)) ; NodeValue
			(if (<= (temp3 nsRight:) 0)
				(temp3 show: temp0 temp1)
				(= temp0 (temp3 nsRight:))
			else
				(temp3 show:)
			)
		)
		(if curInvIcon
			(self showInvItem:)
		)
		(self highlight: curIcon)
		(gTextScroller show:)
	)

	(method (hide param1 &tmp temp0 temp1)
		(if (& state $0020)
			(if (and argc param1)
				(gSounds pause: 0)
				(&= state $ffdf)
			)
			(self highlight: curIcon)
			(for ((= temp0 (KList 3 elements))) temp0 ((= temp0 nextNode)) ; FirstNode
				(= nextNode (KList 6 temp0)) ; NextNode
				(= temp1 (KList 8 temp0)) ; NodeValue
				(temp1 signal: (& (temp1 signal:) $ffdf))
			)
			(if
				(and
					(not (& state $0800))
					helpIconItem
					(& (helpIconItem signal:) $0010)
				)
				(helpIconItem signal: (& (helpIconItem signal:) $ffef))
			)
			(if (and argc param1)
				(plane priority: -1)
				(gTextScroller hide:)
			)
			(UpdatePlane plane)
		)
	)

	(method (showInvItem param1 &tmp temp0 temp1 temp2 temp3)
		(= temp0
			(+
				(/
					(-
						(- (useIconItem nsRight:) (useIconItem nsLeft:))
						(CelWide
							(curInvIcon view:)
							(curInvIcon loop:)
							(curInvIcon cel:)
						)
					)
					2
				)
				(useIconItem nsLeft:)
			)
		)
		(= temp1
			(+
				y
				(/
					(-
						(- (useIconItem nsBottom:) (useIconItem nsTop:))
						(CelHigh
							(curInvIcon view:)
							(curInvIcon loop:)
							(curInvIcon cel:)
						)
					)
					2
				)
				(useIconItem nsTop:)
			)
		)
		(self clearInvItem:)
		(curInvView
			view: (curInvIcon mainView:)
			loop: (curInvIcon mainLoop:)
			cel:
				(if (and argc param1)
					(+ (curInvIcon mainCel:) 1)
				else
					(curInvIcon mainCel:)
				)
			x: temp0
			y: temp1
			show:
		)
		(UpdateScreenItem curInvView)
		(if (and (== (curInvView view:) 9551) (not bucksDisplay))
			(= numBuckStr (Str format: {%d} gBuckazoidCount))
			(= temp2 (IntArray newWith: 4 {}))
			(Text 0 (temp2 data:) (numBuckStr data:) 70 30) ; TextSize
			(= temp3
				(/
					(-
						(- (useIconItem nsRight:) (useIconItem nsLeft:))
						(- (temp2 at: 2) (temp2 at: 0))
					)
					2
				)
			)
			((= bucksDisplay (DText new:))
				font: 70
				text: (KString 8 (numBuckStr data:)) ; StrDup
				fore:
					(if (and (== curIcon useIcon7) (gUser canInput:))
						28
					else
						37
					)
				back: 0
				x: (+ temp3 (useIconItem nsLeft:))
				y: (- (useIconItem nsBottom:) 10)
				setSize: 30
				setPri: (+ (GetHighPlanePri) 1)
				signal: 2
				init: iconCast
				plane: plane
			)
			(AddScreenItem bucksDisplay)
			(= bucksShowing 1)
			(temp2 dispose:)
		)
	)

	(method (clearInvItem)
		(curInvView view: 951 loop: 9 cel: 0 x: 268 y: 16 show:)
		(UpdateScreenItem curInvView)
		(if (and bucksShowing bucksDisplay)
			(iconCast delete: bucksDisplay)
			(DeleteScreenItem bucksDisplay)
			(bucksDisplay dispose:)
			(= bucksDisplay 0)
			(numBuckStr dispose:)
			(= bucksShowing 0)
		)
	)

	(method (disableIcon param1 &tmp temp0 temp1)
		(if argc
			(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
				(= temp1 [param1 temp0])
				(temp1 signal: (| (temp1 signal:) $0004))
				(cond
					((== temp1 curIcon)
						(self advanceCurIcon:)
					)
					((== temp1 highlightedIcon)
						(self advance:)
					)
				)
			)
			(self show:)
		else
			(|= state $0004)
		)
	)

	(method (enableIcon param1 &tmp temp0 temp1)
		(if argc
			(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
				(= temp1 [param1 temp0])
				(temp1 signal: (& (temp1 signal:) $fffb))
			)
		else
			(&= state $fffb)
		)
		(self show:)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp1 (event type:))
		(cond
			((& state $0004))
			((and (not temp1) (& state $0400) (self shouldOpen: event))
				(= temp4 gTheCursor)
				(= temp5 curIcon)
				(= temp6 curInvIcon)
				(self show:)
				(self doit:)
				(if (and (< (event y:) 17) (>= (event x:) 267))
					(= temp3
						(if (or (gUser canControl:) (gUser canInput:))
							(self getCursor:)
						else
							gWaitCursor
						)
					)
				)
				(if (and (< (event y:) 17) (>= (event x:) 267))
					(gGame setCursor: temp3 1)
				)
				(self hide:)
			)
			((& temp1 evMOUSEBUTTON)
				(cond
					((& (event modifiers:) emSHIFT)
						(self advanceCurIcon: show: highlight: curIcon hide:)
						(event claimed: 1)
					)
					((& (event modifiers:) emCTRL)
						(if (gUser canControl:)
							(self swapCurIcon: show: highlight: curIcon hide:)
						)
						(event claimed: 1)
					)
					(curIcon
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
				)
			)
		)
	)

	(method (swapCurIcon &tmp temp0)
		(cond
			((& state $0004)
				(return)
			)
			((gTheIconBar contains: exitIcon8)
				(return)
			)
			(
				(and
					(!= curIcon (= temp0 (KList 8 (self first:)))) ; NodeValue
					(not (& (temp0 signal:) $0004))
				)
				(= prevIcon curIcon)
				(= curIcon (KList 8 (self first:))) ; NodeValue
			)
			((and prevIcon (not (& (prevIcon signal:) $0004)))
				(= curIcon prevIcon)
			)
		)
		(gGame setCursor: (self getCursor:))
	)

	(method (advance &tmp temp0 temp1)
		(for ((= temp1 1)) (<= temp1 size) ((= temp1 (mod (+ temp1 1) size)))
			(= temp0
				(self at: (mod (+ temp1 (self indexOf: highlightedIcon)) size))
			)
			(breakif (not (& (temp0 signal:) $0004)))
		)
		(self highlight: temp0)
	)

	(method (retreat &tmp temp0 temp1)
		(for ((= temp1 1)) (<= temp1 size) ((= temp1 (mod (+ temp1 1) size)))
			(= temp0
				(self at: (mod (- (self indexOf: highlightedIcon) temp1) size))
			)
			(breakif (not (& (temp0 signal:) $0004)))
		)
		(self highlight: temp0)
	)

	(method (highlight param1)
		(if (not (& (param1 signal:) $0004))
			(if highlightedIcon
				(highlightedIcon highlight: 0)
			)
			(= highlightedIcon param1)
			(highlightedIcon highlight: 1)
		)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 [temp4 2] temp6 temp7)
		(while (and (& state $0020) (= temp0 ((gUser curEvent:) new:)))
			(= temp1 (temp0 type:))
			(= temp2 (temp0 message:))
			(= temp3 (temp0 modifiers:))
			(= gGameTime (+ gTickOffset (GetTime)))
			(if gCuees
				(gCuees eachElementDo: #doit)
				(if (gCuees isEmpty:)
					(gCuees dispose:)
					(= gCuees 0)
				)
			)
			(if (not (gTalkers isEmpty:))
				(repeat
					(= gGameTime (+ gTickOffset (GetTime)))
					(gTalkers
						eachElementDo: #doit
						firstTrue: #handleEvent temp0
					)
					(gSounds eachElementDo: #check)
					(FrameOut)
					(breakif (gTalkers allTrue: #isModeless 2))
					(= temp0 ((gUser curEvent:) new:))
				)
			)
			(if (gGame panelObj:)
				(= temp6 (gGame panelObj:))
				(= temp7 (gGame panelSelector:))
				(gGame panelObj: 0 panelSelector: 0)
				(Eval temp6 temp7)
			)
			(gSounds eachElementDo: #check)
			(gTimers eachElementDo: #doit)
			(if gAutoRobot
				(gAutoRobot doit:)
			)
			(gCast doit:)
			(FrameOut)
			(if gDoMotionCue
				(= gDoMotionCue 0)
				(gCast eachElementDo: #motionCue)
			)
			(if (gGame script:)
				((gGame script:) doit:)
			)
			(gRegions eachElementDo: #doit)
			(if (and (== gNewRoomNum gCurRoomNum) (& temp1 $0004) gKeyDownHandler)
				(gKeyDownHandler handleEvent: temp0)
			)
			(if (!= gNewRoomNum gCurRoomNum)
				(gGame newRoom: gNewRoomNum)
			)
			(gTheDoits doit:)
			(gTimers eachElementDo: #delete)
			(Save 8 0) ; GameIsRestarting
			(temp0 localize: plane)
			(if (== (gUser canInput:) 1)
				(cond
					((and (>= (temp0 y:) 17) (< (temp0 x:) 267))
						(if (!= gTheCursor gNormalCursor)
							(self highlight: curIcon)
							(gGame setCursor: gNormalCursor)
						)
					)
					((!= gTheCursor (self getCursor:))
						(gGame setCursor: (self getCursor:))
					)
				)
			)
			(breakif (self dispatchEvent: temp0))
			(gTextScroller handleEvent: temp0)
			(temp0 dispose:)
		)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= temp1 (event x:))
		(= temp0 (event y:))
		(= temp2 (event type:))
		(= temp3 (event message:))
		(= temp5 (event claimed:))
		(if (= temp4 (self firstTrue: #onMe event))
			(= temp6 (temp4 signal:))
			(= temp7 (== temp4 helpIconItem))
		)
		(if (& temp2 $0010) ; direction
			(switch temp3
				(JOY_RIGHT
					(self advance:)
				)
				(JOY_LEFT
					(self retreat:)
				)
			)
		else
			(switch temp2
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
								(= temp5 1)
							)
						)
						((and temp4 (!= temp4 highlightedIcon))
							(= oldMouseY 0)
							(self highlight: temp4)
						)
					)
				)
				(evMOUSEBUTTON
					(if (and temp4 (self select: temp4 1))
						(if temp7
							(gGame setCursor: (temp4 getCursor:) 1)
							(if (& state $0800)
								(self noClickHelp:)
							else
								(helpIconItem
									signal: (| (helpIconItem signal:) $0010)
								)
							)
						else
							(= temp5 (& temp6 $0040))
						)
						(if (temp4 object:)
							(gGame
								panelObj: (temp4 object:)
								panelSelector: (temp4 selector:)
							)
						)
						(temp4 doit:)
					)
				)
				($6000 ; evVERB | evHELP
					(if (and temp4 (temp4 helpVerb:))
						(Print
							font: gUserFont
							width: 250
							addText:
								(temp4 noun:)
								(temp4 helpVerb:)
								0
								1
								0
								0
								(temp4 modNum:)
							init:
						)
						(if (not (HaveMouse))
							(gGame setCursor: temp8) ; UNINIT
						)
					)
					(if helpIconItem
						(helpIconItem signal: (& (helpIconItem signal:) $ffef))
					)
					(gGame setCursor: gNormalCursor)
				)
			)
		)
		(return temp5)
	)

	(method (updateSettings &tmp temp0)
		(for ((= temp0 (= iconSettings 0))) (<= temp0 7) ((++ temp0))
			(if (& ((gTheIconBar at: temp0) signal:) $0004)
				(|= iconSettings (>> $0080 temp0))
			)
		)
	)

	(method (returnFirstAvail param1 &tmp temp0)
		(if (not argc)
			(= param1 0)
		)
		(for ((= temp0 param1)) (<= temp0 7) ((++ temp0))
			(if (not (& iconSettings (>> $0080 temp0)))
				(gTheIconBar at: temp0)
				(return)
			)
		)
		(gTheIconBar at: 1)
	)

	(method (dispose)
		(super dispose:)
		(gTextScroller dispose:)
	)
)

(instance talkerSet of Cast ; UNUSED
	(properties)
)

(instance walkIcon0 of SQIconItem
	(properties
		noun 19
		x 4
		y 5
		type 20480
		message 3
		mainView 951
		maskView 951
		maskCel 2
		helpVerb 17
	)

	(method (init)
		(self setCursor: gWalkCursor)
		(super init: &rest)
	)
)

(instance lookIcon1 of SQIconItem
	(properties
		noun 20
		x 42
		y 5
		message 1
		mainView 951
		mainLoop 1
		maskView 951
		maskLoop 1
		maskCel 2
		helpVerb 17
	)

	(method (init)
		(self setCursor: gLookCursor)
		(super init: &rest)
	)
)

(instance doIcon2 of SQIconItem
	(properties
		noun 21
		x 79
		y 5
		message 4
		mainView 951
		mainLoop 3
		maskView 951
		maskLoop 3
		maskCel 2
		helpVerb 17
	)

	(method (init)
		(self setCursor: gDoCursor)
		(super init: &rest)
	)
)

(instance talkIcon3 of SQIconItem
	(properties
		noun 22
		x 117
		y 5
		message 2
		mainView 951
		mainLoop 2
		maskView 951
		maskLoop 2
		maskCel 2
		helpVerb 17
	)

	(method (init)
		(self setCursor: gTalkCursor)
		(super init: &rest)
	)
)

(instance invIcon4 of SQIconItem
	(properties
		noun 26
		x 154
		y 5
		signal 3
		message 0
		mainView 951
		mainLoop 4
		maskView 951
		maskLoop 4
		maskCel 2
		helpVerb 17
	)

	(method (init)
		(self setCursor: gNormalCursor)
		(super init: &rest)
	)

	(method (select &tmp [temp0 5])
		(if (super select: &rest)
			(if (not (gInventory ownedBy: gEgo))
				(gInventory carryingNothing:)
				(gGame doit:)
				(return 1)
			)
			(= global169 (gTheIconBar curIcon:))
			(ClearFlag 66)
			(ClearFlag 67)
			(ClearFlag 68)
			(ClearFlag 69)
			(ClearFlag 70)
			(ClearFlag 71)
			(ClearFlag 72)
			(if
				(and
					(gTheIconBar contains: walkIcon0)
					(not (& (walkIcon0 signal:) $0004))
				)
				(SetFlag 66)
				(walkIcon0 signal: (| (walkIcon0 signal:) $0004) show:)
			)
			(if (not (& (lookIcon1 signal:) $0004))
				(SetFlag 67)
				(lookIcon1 signal: (| (lookIcon1 signal:) $0004) show:)
			)
			(if (not (& (doIcon2 signal:) $0004))
				(SetFlag 68)
				(doIcon2 signal: (| (doIcon2 signal:) $0004) show:)
			)
			(if (not (& (talkIcon3 signal:) $0004))
				(SetFlag 69)
				(talkIcon3 signal: (| (talkIcon3 signal:) $0004) show:)
			)
			(if (not (& (helpIcon5 signal:) $0004))
				(SetFlag 70)
				(helpIcon5 signal: (| (helpIcon5 signal:) $0004) show:)
			)
			(if (not (& (controlIcon6 signal:) $0004))
				(SetFlag 71)
				(controlIcon6 signal: (| (controlIcon6 signal:) $0004) show:)
			)
			(if
				(and
					(gTheIconBar contains: exitIcon8)
					(not (& (exitIcon8 signal:) $0004))
				)
				(SetFlag 72)
				(exitIcon8 signal: (| (exitIcon8 signal:) $0004) show:)
			)
			(SetFlag 65)
			(gInventory showSelf:)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance helpIcon5 of SQIconItem
	(properties
		noun 23
		x 192
		y 5
		signal 3
		message 0
		mainView 951
		mainLoop 5
		maskView 951
		maskLoop 5
		maskCel 2
		helpVerb 17
	)

	(method (init)
		(self setCursor: gHelpCursor)
		(super init: &rest)
	)
)

(instance controlIcon6 of SQIconItem
	(properties
		noun 24
		x 229
		y 5
		signal 3
		message 0
		mainView 951
		mainLoop 6
		maskView 951
		maskLoop 6
		maskCel 2
		helpVerb 17
	)

	(method (init)
		(self setCursor: gNormalCursor)
		(super init: &rest)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(gGame showControls:)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance useIcon7 of SQIconItem
	(properties
		noun 25
		x 268
		y 16
		message 0
		mainView 951
		mainLoop 9
		maskView 951
		maskLoop 9
		helpVerb 17
	)

	(method (init)
		(self setCursor: gNormalCursor)
		(super init: &rest)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(if (gTheIconBar curInvIcon:)
				(curInvView cel: 1)
				(UpdateScreenItem curInvView)
				(if (gTheIconBar bucksShowing:)
					((gTheIconBar bucksDisplay:) fore: 28)
					((gTheIconBar bucksDisplay:) draw:)
				)
				(return 1)
			else
				(return 0)
			)
		else
			(return 0)
		)
	)

	(method (highlight param1)
		(if (not (& signal $0020))
			(return)
		)
		(if (and (gTheIconBar bucksShowing:) argc (not param1))
			((gTheIconBar bucksDisplay:) fore: 37)
			((gTheIconBar bucksDisplay:) draw:)
		)
		(if (== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
			(curInvView cel: (* 1 (if argc param1)))
			(UpdateScreenItem curInvView)
			(if (gTheIconBar bucksShowing:)
				(if (and argc param1)
					((gTheIconBar bucksDisplay:) fore: 28)
				else
					((gTheIconBar bucksDisplay:) fore: 37)
				)
				((gTheIconBar bucksDisplay:) draw:)
			)
		else
			(return)
		)
	)
)

(instance exitIcon8 of SQIconItem
	(properties
		noun 28
		x 4
		y 5
		signal 3
		message 5
		mainView 951
		mainLoop 7
		maskView 951
		maskLoop 7
		maskCel 2
		helpVerb 17
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar setupExit: 0)
			(cond
				((== (gCurRoom inset:) (ScriptID 45 0)) ; forceFieldBelt
					((gCurRoom inset:) dispose:)
				)
				((== (gCurRoom inset:) (ScriptID 900 0)) ; dataCorderInset
					((gCurRoom inset:) dispose:)
					(DisposeScript 900)
				)
				((== gCurRoomNum 210)
					(gTheIconBar enable: 6)
					(gGame handsOff:)
					(SetFlag 192)
					(gCurRoom newRoom: 200)
				)
				((== gCurRoomNum 250)
					(gTheIconBar enable: 6)
					(gGame handsOff:)
					(gCurRoom newRoom: 320)
				)
				((== gCurRoomNum 460)
					(gTheIconBar enable: 6)
					(gGame handsOff:)
					(gCurRoom doVerb:)
				)
				((== gCurRoomNum 490)
					(gTheIconBar enable: 6)
					(gGame handsOff:)
					(gCurRoom newRoom: 480)
				)
				((gCurRoom inset:)
					((gCurRoom inset:) dispose:)
				)
			)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance scrollBarUpIcon of IconI
	(properties
		priority 15
		fixPriority 1
		mainView 9511
		mainLoop 1
	)
)

(instance scrollBarDownIcon of IconI
	(properties
		y 37
		priority 15
		fixPriority 1
		mainView 9511
		mainLoop 2
	)
)

(instance scrollBar of WindowScrollBar
	(properties
		x 1
		y 5
		priority 14
		fixPriority 1
		view 9511
		thumbView 9511
		thumbCel 1
		minPosn 5
		maxPosn 34
	)
)

(instance textScroller of ScrollerWindow
	(properties
		fore 82
		font 70
		borderColor 0
		nsLeft 6
		nsTop 157
		nsRight 254
		nsBottom 197
		maxItems 50
	)

	(method (init)
		(super init: &rest)
		(UpdateScreenItem ((scroller thumb:) setPri: 15 yourself:))
	)
)

(instance curInvView of View
	(properties
		view 951
		loop 9
	)
)

(instance LED1 of View
	(properties
		x 295
		y 5
		view 951
		loop 8
	)
)

(instance LED2 of View
	(properties
		x 303
		y 5
		view 951
		loop 8
	)
)

(instance LED3 of View
	(properties
		x 311
		y 5
		view 951
		loop 8
	)
)

(instance sPointsSnd of Sound
	(properties
		number 991
	)
)

