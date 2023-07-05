;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64937)
(include sci.sh)
(use Main)
(use Print)
(use Cursor)
(use Actor)
(use System)

(class IconI of View
	(properties
		signal 1
		type 16384
		message -1
		modifiers 0
		mainView 0
		mainLoop 0
		mainCel 0
		maskView 0
		maskLoop 0
		maskCel 0
		cursorView -1
		cursorLoop -1
		cursorCel -1
		highlightColor 0
		lowlightColor 0
		helpVerb 0
		object 0
		selector 0
	)

	(method (init)
		(= view mainView)
		(= loop mainLoop)
		(= cel mainCel)
		(super init: &rest)
	)

	(method (show iX iY &tmp [temp0 7])
		(|= signal $0020)
		(if argc
			(self posn: iX iY)
			(SetNowSeen self)
		)
		(if (& signal $0004)
			(self mask:)
		else
			(= view mainView)
			(= loop mainLoop)
			(= cel mainCel)
			(UpdateScreenItem self)
		)
	)

	(method (mask)
		(= view maskView)
		(= loop maskLoop)
		(= cel maskCel)
		(UpdateScreenItem self)
	)

	(method (highlight tOrF &tmp [temp0 5])
		(if (or (not (& signal $0020)) (== highlightColor -1))
			(return)
		)
		(= cel (* 2 (if argc tOrF)))
		(UpdateScreenItem self)
	)

	(method (select relVer &tmp event whichCel tut)
		(return
			(cond
				((& signal $0004) 0)
				((and argc relVer (& signal $0001))
					(= cel (= whichCel 1))
					(UpdateScreenItem self)
					(FrameOut)
					(while (!= ((= event (Event new:)) type:) evMOUSERELEASE)
						(event localize: plane)
						(cond
							((self onMe: event)
								(if (not whichCel)
									(= cel (= whichCel 1))
									(UpdateScreenItem self)
									(FrameOut)
								)
							)
							(whichCel
								(= cel (= whichCel 0))
								(UpdateScreenItem self)
								(FrameOut)
							)
						)
						(event dispose:)
					)
					(event dispose:)
					(if (== whichCel 1)
						(= cel 0)
						(UpdateScreenItem self)
						(FrameOut)
					)
					(if
						(and
							(= tut (gGlory script:))
							(tut isKindOf: Unknown_Class_18)
						)
						(cond
							(
								(and
									(== (tut nextItem:) self)
									(!=
										(tut nextAction:)
										((gTheIconBar helpIconItem:) message:)
									)
								)
								(tut cue:)
							)
							((not whichCel)
								(return 0)
							)
							(else
								(tut report:)
								(return 0)
							)
						)
					)
					whichCel
				)
				(else
					(if
						(and
							(= tut (gGlory script:))
							(tut isKindOf: Unknown_Class_18)
						)
						(if
							(and
								(== (tut nextItem:) self)
								(!=
									(tut nextAction:)
									((gTheIconBar helpIconItem:) message:)
								)
							)
							(tut cue:)
						else
							(tut report:)
							(return 0)
						)
					)
					1
				)
			)
		)
	)

	(method (setCursor viewOrObj theLoop theCel)
		(if (== argc 1)
			(= cursorView viewOrObj)
			(= cursorCel (= cursorLoop -1))
		else
			(= cursorView viewOrObj)
			(= cursorLoop theLoop)
			(= cursorCel theCel)
		)
	)

	(method (getCursor)
		(return
			(if (== cursorLoop -1)
				cursorView
			else
				(IconBarCursor initialize: self yourself:)
			)
		)
	)
)

(class IconBar of Set
	(properties
		underBits 0
		oldMouseX 0
		oldMouseY 0
		curIcon 0
		highlightedIcon 0
		prevIcon 0
		curInvIcon 0
		useIconItem 0
		helpIconItem 0
		walkIconItem 0
		plane 0
		state 1024
		y 0
	)

	(method (init &tmp obj)
		(if (not plane)
			(= plane (gSystemPlane new:))
		)
		(plane back: 0 priority: -1 init: 0 0 210 100 addCast: self)
		(self eachElementDo: #init self)
		(plane setSize:)
	)

	(method (dispose)
		(plane deleteCast: self dispose:)
		(= plane 0)
	)

	(method (findIcon theVerb &tmp i thisIcon)
		(for ((= i 0)) (< i size) ((++ i))
			(= thisIcon (self at: i))
			(if (== (thisIcon message:) theVerb)
				(return thisIcon)
			)
		)
		(return 0)
	)

	(method (noClickHelp &tmp event lastIcon thisIcon dlg)
		(= lastIcon (= thisIcon (= dlg 0)))
		(while (not ((= event ((gUser curEvent:) new:)) type:))
			(event localize: plane)
			(cond
				((= thisIcon (self firstTrue: #onMe event))
					(if (and (!= thisIcon lastIcon) (thisIcon helpVerb:))
						(= lastIcon thisIcon)
						(if dlg
							(dlg dispose:)
							(= dlg 0)
							(FrameOut)
						)
						(Print
							font: gUserFont
							width: 250
							addText:
								(thisIcon noun:)
								(thisIcon helpVerb:)
								0
								1
								0
								0
								(if (== (thisIcon modNum:) -1)
									0
								else
									(thisIcon modNum:)
								)
							modeless: 2
							init:
						)
						(= dlg (Print dialog:))
						(FrameOut)
					)
				)
				(dlg
					(dlg dispose:)
					(= dlg 0)
					(FrameOut)
				)
				(else
					(= lastIcon 0)
				)
			)
			(event dispose:)
		)
		(event dispose:)
		(gGlory setCursor: gNormalCursor 1)
		(if dlg
			(dlg dispose:)
			(FrameOut)
		)
	)

	(method (handleEvent event &tmp keyInvoked eType newEvent newCursor oldCursor oldCurIcon oldInvIcon)
		(if (& state $0020)
			(event localize: plane)
		)
		(= eType (event type:))
		(cond
			((& state $0004))
			(
				(or
					(and
						(not eType)
						(& state $0400)
						(self shouldOpen: event)
						(not (= keyInvoked 0))
					)
					(and
						(== eType evKEYBOARD)
						(or
							(== (event message:) KEY_ESCAPE)
							(== (event message:) KEY_DELETE)
						)
						(= keyInvoked 1)
					)
				)
				(= oldMouseX (event x:))
				(= oldMouseY (event y:))
				(= oldCursor gTheCursor)
				(= oldCurIcon curIcon)
				(= oldInvIcon curInvIcon)
				(self show:)
				(gGlory setCursor: gNormalCursor)
				(if keyInvoked
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
				(= newCursor
					(if (or (gUser canControl:) (gUser canInput:))
						(self getCursor:)
					else
						gWaitCursor
					)
				)
				(if keyInvoked
					(gGlory setCursor: newCursor 1 oldMouseX oldMouseY)
				else
					(gGlory
						setCursor:
							newCursor
							1
							((event new:) x:)
							(Max (event y:) (+ 1 (plane bottom:)))
					)
				)
				(self hide:)
			)
			((& eType evKEYBOARD)
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
			((& eType evMOUSEBUTTON)
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

	(method (disable theIconNumber &tmp i)
		(if argc
			(for ((= i 0)) (< i argc) ((++ i))
				(= [theIconNumber i] (self at: [theIconNumber i]))
			)
			(self disableIcon: theIconNumber &rest)
		else
			(self disableIcon:)
		)
	)

	(method (disableIcon theIcon &tmp i thisIcon)
		(if argc
			(for ((= i 0)) (< i argc) ((++ i))
				(= thisIcon [theIcon i])
				(thisIcon signal: (| (thisIcon signal:) $0004))
				(cond
					((== thisIcon curIcon)
						(self advanceCurIcon:)
					)
					((== thisIcon highlightedIcon)
						(self advance:)
					)
				)
			)
		else
			(|= state $0004)
		)
	)

	(method (enable theIconNumber &tmp i)
		(if argc
			(for ((= i 0)) (< i argc) ((++ i))
				(= [theIconNumber i] (self at: [theIconNumber i]))
			)
			(self enableIcon: theIconNumber &rest)
		else
			(self enableIcon:)
		)
	)

	(method (enableIcon theIcon &tmp i thisIcon)
		(if argc
			(for ((= i 0)) (< i argc) ((++ i))
				(= thisIcon [theIcon i])
				(thisIcon signal: (& (thisIcon signal:) $fffb))
			)
		else
			(&= state $fffb)
		)
	)

	(method (show &tmp [temp0 3] temp3 temp4 temp5 temp6)
		(gSounds pause:)
		(|= state $0020)
		(gGlory setCursor: gNormalCursor 1)
		(plane priority: (+ (GetHighPlanePri) 1))
		(UpdatePlane plane)
		(= temp3 0)
		(= temp4 y)
		(for ((= temp5 (FirstNode elements))) temp5 ((= temp5 nextNode))
			(= nextNode (NextNode temp5))
			(= temp6 (NodeValue temp5))
			(if (<= (temp6 nsRight:) 0)
				(temp6 show: temp3 temp4)
				(= temp3 (temp6 nsRight:))
			else
				(temp6 show:)
			)
		)
		(self highlight: curIcon)
	)

	(method (hide &tmp node obj)
		(if (& state $0020)
			(gSounds pause: 0)
			(&= state $ffdf)
			(for ((= node (FirstNode elements))) node ((= node nextNode))
				(= nextNode (NextNode node))
				(= obj (NodeValue node))
				(obj signal: (& (obj signal:) $ffdf))
			)
			(if
				(and
					(not (& state $0800))
					helpIconItem
					(& (helpIconItem signal:) $0010)
				)
				(helpIconItem signal: (& (helpIconItem signal:) $ffef))
			)
			(plane priority: -1)
			(UpdatePlane plane)
		)
	)

	(method (doit &tmp event eType eMsg eMod tut)
		(while (and (& state $0020) (= event ((gUser curEvent:) new:)))
			(= eType (event type:))
			(= eMsg (event message:))
			(= eMod (event modifiers:))
			(= gGameTime (+ gTickOffset (GetTime)))
			(FrameOut)
			(if gCuees
				(gCuees eachElementDo: #doit)
			)
			(if
				(and
					(= tut (gGlory script:))
					(tut isKindOf: Unknown_Class_18)
				)
				(tut doit:)
			)
			(if (== eType 32)
				(= eType 4)
				(= eMsg (if (& eMod $0003) 27 else 13))
				(= eMod 0)
				(event type: eType message: eMsg modifiers: 0)
			)
			(event localize: plane)
			(if
				(and
					(or (== eType 1) (and (== eType 4) (== eMsg 13)))
					helpIconItem
					(& (helpIconItem signal:) $0010)
				)
				(event type: 24576 message: (helpIconItem message:))
			)
			(MapKeyToDir event)
			(breakif (self dispatchEvent: event))
		)
	)

	(method (dispatchEvent event &tmp evtY evtX evtType evtMsg thisIcon evtClaimed theSignal isHelp oldCur)
		(= evtX (event x:))
		(= evtY (event y:))
		(= evtType (event type:))
		(= evtMsg (event message:))
		(= evtClaimed (event claimed:))
		(if (= thisIcon (self firstTrue: #onMe event))
			(= theSignal (thisIcon signal:))
			(= isHelp (== thisIcon helpIconItem))
		)
		(if (& evtType $0010) ; direction
			(switch evtMsg
				(JOY_RIGHT
					(self advance:)
				)
				(JOY_LEFT
					(self retreat:)
				)
			)
		else
			(switch evtType
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
								(= evtClaimed 1)
							)
						)
						((and thisIcon (!= thisIcon highlightedIcon))
							(= oldMouseY 0)
							(self highlight: thisIcon)
						)
					)
				)
				(evMOUSEBUTTON
					(if (and thisIcon (self select: thisIcon 1))
						(if isHelp
							(gGlory setCursor: (thisIcon getCursor:) 1)
							(if (& state $0800)
								(self noClickHelp:)
							else
								(helpIconItem
									signal: (| (helpIconItem signal:) $0010)
								)
							)
						else
							(= evtClaimed (& theSignal $0040))
						)
						(if (thisIcon object:)
							(gGlory
								panelObj: (thisIcon object:)
								panelSelector: (thisIcon selector:)
							)
						)
						(thisIcon doit:)
					)
				)
				(evKEYBOARD
					(switch evtMsg
						(KEY_ESCAPE
							(= evtClaimed 1)
						)
						(KEY_DELETE
							(= evtClaimed 1)
						)
						(KEY_RETURN
							(if (not thisIcon)
								(= thisIcon highlightedIcon)
							)
							(cond
								((and thisIcon (== thisIcon helpIconItem))
									(gGlory setCursor: (self getCursor:))
									(if helpIconItem
										(helpIconItem
											signal:
												(| (helpIconItem signal:) $0010)
										)
									)
								)
								((and thisIcon (self select: thisIcon))
									(if (thisIcon object:)
										(gGlory
											panelObj: (thisIcon object:)
											panelSelector: (thisIcon selector:)
										)
									)
									(thisIcon doit:)
									(= evtClaimed (& theSignal $0040))
								)
							)
						)
						(KEY_SHIFTTAB
							(self retreat:)
						)
						(KEY_TAB
							(self advance:)
						)
					)
				)
				($6000 ; evVERB | evHELP
					(if (and thisIcon (thisIcon helpVerb:))
						(Print
							font: gUserFont
							width: 250
							addText:
								(thisIcon noun:)
								(thisIcon helpVerb:)
								0
								1
								0
								0
								(thisIcon modNum:)
							init:
						)
						(if (not (HaveMouse))
							(gGlory setCursor: oldCur) ; UNINIT
						)
					)
					(if helpIconItem
						(helpIconItem signal: (& (helpIconItem signal:) $ffef))
					)
					(gGlory setCursor: gNormalCursor)
				)
			)
		)
		(return evtClaimed)
	)

	(method (advance &tmp theIcon i)
		(for ((= i 1)) (<= i size) ((= i (mod (+ i 1) size)))
			(= theIcon
				(self at: (mod (+ i (self indexOf: highlightedIcon)) size))
			)
			(breakif (not (& (theIcon signal:) $0004)))
		)
		(self highlight: theIcon (& state $0020))
	)

	(method (retreat &tmp theIcon i)
		(for ((= i 1)) (<= i size) ((= i (mod (+ i 1) size)))
			(= theIcon
				(self at: (mod (- (self indexOf: highlightedIcon) i) size))
			)
			(breakif (not (& (theIcon signal:) $0004)))
		)
		(self highlight: theIcon (& state $0020))
	)

	(method (select theIcon relVer)
		(return
			(if (theIcon select: (and (>= argc 2) relVer))
				(if (not (& (theIcon signal:) $0002))
					(= curIcon theIcon)
				)
				1
			)
		)
	)

	(method (highlight theIcon posnCursor &tmp sColor)
		(if (not (& (theIcon signal:) $0004))
			(if highlightedIcon
				(highlightedIcon highlight: 0)
			)
			(= highlightedIcon theIcon)
			(highlightedIcon highlight: 1)
		)
		(if (and (>= argc 2) posnCursor)
			(gGlory
				setCursor:
					gTheCursor
					1
					(+
						(theIcon nsLeft:)
						(/ (- (theIcon nsRight:) (theIcon nsLeft:)) 2)
					)
					(- (theIcon nsBottom:) 3)
			)
		)
	)

	(method (advanceCurIcon &tmp theIcon i newIcon)
		(if (& state $0004)
			(return)
		)
		(= theIcon curIcon)
		(= i 0)
		(while
			(&
				((= theIcon (self at: (mod (+ (self indexOf: theIcon) 1) size)))
					signal:
				)
				$0006
			)
			(if (> i (+ 1 size))
				(return)
			else
				(++ i)
			)
		)
		(= curIcon theIcon)
		(gGlory setCursor: (self getCursor:))
	)

	(method (swapCurIcon &tmp firstIcon)
		(cond
			((& state $0004)
				(return)
			)
			(
				(and
					(!= curIcon (= firstIcon (NodeValue (self first:))))
					(not (& (firstIcon signal:) $0004))
				)
				(= prevIcon curIcon)
				(= curIcon (NodeValue (self first:)))
			)
			((and prevIcon (not (& (prevIcon signal:) $0004)))
				(= curIcon prevIcon)
			)
		)
		(gGlory setCursor: (self getCursor:))
	)

	(method (shouldOpen event)
		(return
			(or
				(and (== (event type:) 0) (<= (event y:) 0))
				(and
					(== (event type:) 4)
					(OneOf (event message:) 27 21248)
				)
			)
		)
	)

	(method (shouldClose event)
		(return
			(or
				(and (== (event type:) 0) (> (event y:) (plane bottom:)))
				(and
					(== (event type:) 4)
					(OneOf (event message:) 27 21248)
				)
			)
		)
	)

	(method (getCursor)
		(return
			(if curIcon
				(curIcon getCursor:)
			else
				gNormalCursor
			)
		)
	)
)

(class IconBarCursor of Cursor
	(properties)

	(method (initialize theIcon)
		(= view (theIcon cursorView:))
		(= loop (theIcon cursorLoop:))
		(= cel (theIcon cursorCel:))
	)
)

