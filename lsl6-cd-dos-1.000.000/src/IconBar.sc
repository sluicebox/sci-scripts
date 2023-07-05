;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 937)
(include sci.sh)
(use Main)
(use Print)
(use Tutorial)
(use System)

(class IconI of Obj
	(properties
		view -1
		loop -1
		cel -1
		nsLeft 0
		nsTop -1
		nsRight 0
		nsBottom 0
		state 0
		cursor -1
		type 16384
		message -1
		modifiers 0
		signal 1
		maskView 0
		maskLoop 0
		maskCel 0
		highlightColor 0
		lowlightColor 0
		noun 0
		modNum 0
		helpVerb 0
	)

	(method (show iX iY &tmp [temp0 7])
		(|= signal $0020)
		(if argc
			(= nsRight (+ (= nsLeft iX) (CelWide view loop cel)))
			(= nsBottom (+ (= nsTop iY) (CelHigh view loop cel)))
		else
			(= nsRight (+ nsLeft (CelWide view loop cel)))
			(= nsBottom (+ nsTop (CelHigh view loop cel)))
		)
		(DrawCel view loop cel nsLeft nsTop -1)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (mask)
		(DrawCel
			maskView
			maskLoop
			maskCel
			(+
				nsLeft
				(/
					(-
						(CelWide view loop cel)
						(CelWide maskView maskLoop maskCel)
					)
					2
				)
			)
			(+
				nsTop
				(/
					(-
						(CelHigh view loop cel)
						(CelHigh maskView maskLoop maskCel)
					)
					2
				)
			)
			-1
		)
	)

	(method (onMe obj)
		(return
			(and
				(>= (obj x:) nsLeft)
				(>= (obj y:) nsTop)
				(<= (obj x:) nsRight)
				(<= (obj y:) nsBottom)
			)
		)
	)

	(method (highlight tOrF &tmp t l b r sColor)
		(if (or (not (& signal $0020)) (== highlightColor -1))
			(return)
		)
		(= sColor (if (and argc tOrF) highlightColor else lowlightColor))
		(= t (+ nsTop 2))
		(= l (+ nsLeft 2))
		(= b (- nsBottom 3))
		(= r (- nsRight 4))
		(Graph grDRAW_LINE t l t r sColor -1 -1)
		(Graph grDRAW_LINE t r b r sColor -1 -1)
		(Graph grDRAW_LINE b r b l sColor -1 -1)
		(Graph grDRAW_LINE b l t l sColor -1 -1)
		(Graph grUPDATE_BOX (- nsTop 2) (- nsLeft 2) nsBottom (+ nsRight 3) 1)
	)

	(method (select relVer &tmp event whichCel tut)
		(return
			(cond
				((& signal $0004) 0)
				((and argc relVer (& signal $0001))
					(DrawCel view loop (= whichCel 1) nsLeft nsTop -1)
					(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					(while (!= ((= event (Event new:)) type:) evMOUSERELEASE)
						(event localize:)
						(cond
							((self onMe: event)
								(if (not whichCel)
									(DrawCel
										view
										loop
										(= whichCel 1)
										nsLeft
										nsTop
										-1
									)
									(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
								)
							)
							(whichCel
								(DrawCel view loop (= whichCel 0) nsLeft nsTop -1)
								(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
							)
						)
						(event dispose:)
					)
					(event dispose:)
					(if (== whichCel 1)
						(DrawCel view loop 0 nsLeft nsTop -1)
						(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					)
					(if
						(and
							(= tut (gGame script:))
							(tut isKindOf: Tutorial)
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
							(= tut (gGame script:))
							(tut isKindOf: Tutorial)
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
)

(class IconBar of Set
	(properties
		height 0
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
		port 0
		window 0
		state 1024
		activateHeight 0
		y 0
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

	(method (noClickHelp &tmp event lastIcon thisIcon tmpStr oldPort eO)
		(= lastIcon (= thisIcon 0))
		(= tmpStr (GetPort))
		(= oldPort (gSystemWindow eraseOnly:))
		(gSystemWindow eraseOnly: 1)
		(while (not ((= event ((gUser curEvent:) new:)) type:))
			(if (not (self isMemberOf: IconBar))
				(event localize:)
			)
			(cond
				((= thisIcon (self firstTrue: #onMe event))
					(if (and (!= thisIcon lastIcon) (thisIcon helpVerb:))
						(= lastIcon thisIcon)
						(if gModelessDialog
							(gModelessDialog dispose:)
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
								(thisIcon modNum:)
							modeless: 1
							init:
						)
						(SetPort tmpStr)
					)
				)
				(gModelessDialog
					(gModelessDialog dispose:)
				)
				(else
					(= lastIcon 0)
				)
			)
			(event dispose:)
		)
		(gSystemWindow eraseOnly: oldPort)
		(gGame setCursor: 999 1)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(SetPort tmpStr)
		(if (not (helpIconItem onMe: event))
			(self dispatchEvent: event)
		)
	)

	(method (handleEvent event &tmp keyInvoked evType oldCursor oldCurIcon newCursor oldInvIcon newEvent)
		(event localize:)
		(= evType (event type:))
		(cond
			((& state $0004))
			(
				(or
					(and
						(not evType)
						(& state $0400)
						(<= -10 (event y:) height)
						(<= 0 (event x:) 320)
						(not (= keyInvoked 0))
					)
					(and
						(== evType evKEYBOARD)
						(or
							(== (event message:) KEY_ESCAPE)
							(== (event message:) KEY_DELETE)
						)
						(= keyInvoked 1)
					)
				)
				(event globalize:)
				(= oldMouseX (event x:))
				(= oldMouseY (event y:))
				(= newCursor gTheCursor)
				(= oldInvIcon curIcon)
				(= newEvent curInvIcon)
				(self show:)
				(gGame setCursor: 999)
				(if keyInvoked
					(gGame
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
				(= oldCurIcon
					(if (or (gUser canControl:) (gUser canInput:))
						(curIcon cursor:)
					else
						gWaitCursor
					)
				)
				(if keyInvoked
					(gGame setCursor: oldCurIcon 1 oldMouseX oldMouseY)
				else
					(gGame
						setCursor:
							oldCurIcon
							1
							((event new:) x:)
							(Max (event y:) (+ 1 height))
					)
				)
				(self hide:)
			)
			((& evType evKEYBOARD)
				(switch (event message:)
					(KEY_RETURN
						(cond
							((not (IsObject curIcon)))
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
						(if (& (event type:) $0040) ; direction
							(self advanceCurIcon:)
							(event claimed: 1)
						)
					)
				)
			)
			((& evType evMOUSEBUTTON)
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
					((IsObject curIcon)
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

	(method (disable theIconNumber &tmp i thisIcon)
		(if argc
			(for ((= i 0)) (< i argc) ((++ i))
				(= thisIcon
					(if (IsObject [theIconNumber i])
						[theIconNumber i]
					else
						(self at: [theIconNumber i])
					)
				)
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

	(method (enable theIconNumber &tmp i thisIcon)
		(if argc
			(for ((= i 0)) (< i argc) ((++ i))
				(= thisIcon
					(if (IsObject [theIconNumber i])
						[theIconNumber i]
					else
						(self at: [theIconNumber i])
					)
				)
				(thisIcon signal: (& (thisIcon signal:) $fffb))
			)
		else
			(&= state $fffb)
		)
	)

	(method (show &tmp theIcon pnv i theX theY node nextNode obj)
		(gSounds pause:)
		(|= state $0020)
		(gGame setCursor: 999 1)
		(= height
			(CelHigh ((= theIcon (self at: 0)) view:) (theIcon loop:) (theIcon cel:))
		)
		(= port (GetPort))
		(SetPort -1)
		(= underBits (Graph grSAVE_BOX y 0 (+ y height) 320 1))
		(= pnv (PicNotValid))
		(PicNotValid 1)
		(= theX 0)
		(= theY y)
		(for ((= node (FirstNode elements))) node ((= node nextNode))
			(= nextNode (NextNode node))
			(if (not (IsObject (= obj (NodeValue node))))
				(return)
			)
			(if (<= (obj nsRight:) 0)
				(obj show: theX theY)
				(= theX (obj nsRight:))
			else
				(obj show:)
			)
		)
		(if curInvIcon
			(if (gEgo has: (gInventory indexOf: curInvIcon))
				(= theX
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
				(= theY
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
				(DrawCel
					(curInvIcon view:)
					(curInvIcon loop:)
					(curInvIcon cel:)
					theX
					theY
					-1
				)
				(if (& (useIconItem signal:) $0004)
					(useIconItem mask:)
				)
			else
				(= curInvIcon 0)
			)
		)
		(PicNotValid pnv)
		(Graph grUPDATE_BOX y 0 (+ y height) 320 1)
		(self highlight: curIcon)
	)

	(method (hide &tmp node nextNode obj)
		(if (& state $0020)
			(gSounds pause: 0)
			(&= state $ffdf)
			(for ((= node (FirstNode elements))) node ((= node nextNode))
				(= nextNode (NextNode node))
				(if (not (IsObject (= obj (NodeValue node))))
					(return)
				)
				((= obj (NodeValue node)) signal: (& (obj signal:) $ffdf))
			)
			(if
				(and
					(not (& state $0800))
					(IsObject helpIconItem)
					(& (helpIconItem signal:) $0010)
				)
				(helpIconItem signal: (& (helpIconItem signal:) $ffef))
			)
			(Graph grRESTORE_BOX underBits)
			(Graph grUPDATE_BOX y 0 (+ y height) 320 1)
			(Graph grREDRAW_BOX y 0 (+ y height) 320)
			(SetPort port)
			(= height activateHeight)
		)
	)

	(method (doit &tmp event eType eMsg eMod tut)
		(while (and (& state $0020) (= event ((gUser curEvent:) new:)))
			(= eType (event type:))
			(= eMsg (event message:))
			(= eMod (event modifiers:))
			(Wait 1)
			(= gGameTime (+ gTickOffset (GetTime)))
			(if gSet
				(gSet eachElementDo: #doit)
			)
			(if (and (= tut (gGame script:)) (tut isKindOf: Tutorial))
				(tut doit:)
			)
			(if (== eType 256)
				(= eType 4)
				(= eMsg (if (& eMod $0003) 27 else 13))
				(= eMod 0)
				(event type: eType message: eMsg modifiers: 0)
			)
			(event localize:)
			(if
				(and
					(or (== eType 1) (and (== eType 4) (== eMsg 13)))
					(IsObject helpIconItem)
					(& (helpIconItem signal:) $0010)
				)
				(event type: 24576 message: (helpIconItem message:))
			)
			(MapKeyToDir event)
			(breakif (self dispatchEvent: event))
		)
	)

	(method (dispatchEvent event &tmp evtY evtX evtType evtMsg thisIcon evtClaimed thePort [buffer 50] theCurs theSignal isHelp oldCur)
		(= evtX (event x:))
		(= evtY (event y:))
		(= evtType (event type:))
		(= evtMsg (event message:))
		(= evtClaimed (event claimed:))
		(if (= thisIcon (self firstTrue: #onMe event))
			(= theCurs (thisIcon cursor:))
			(= theSignal (thisIcon signal:))
			(= isHelp (== thisIcon helpIconItem))
		)
		(if (& evtType $0040) ; direction
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
						((not (and (<= 0 evtY (+ y height)) (<= 0 evtX 320)))
							(if
								(and
									(& state $0400)
									(or
										(not (IsObject helpIconItem))
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
							(if theCurs
								(gGame setCursor: theCurs)
							)
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
									(if (!= theCurs -1)
										(gGame setCursor: theCurs)
									)
									(if helpIconItem
										(helpIconItem
											signal:
												(| (helpIconItem signal:) $0010)
										)
									)
								)
								((and (IsObject thisIcon) (self select: thisIcon))
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
						(if (not (HaveMouse))
							(= oldCur (gGame setCursor: 996))
						)
						(= thePort (GetPort))
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
						(SetPort thePort)
						(if (not (HaveMouse))
							(gGame setCursor: oldCur)
						)
					)
					(if helpIconItem
						(helpIconItem signal: (& (helpIconItem signal:) $ffef))
					)
					(gGame setCursor: 999)
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
			(if (not (IsObject theIcon))
				(= theIcon (NodeValue (self first:)))
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
			(if (not (IsObject theIcon))
				(= theIcon (NodeValue (self last:)))
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
			(if (IsObject highlightedIcon)
				(highlightedIcon highlight: 0)
			)
			(= highlightedIcon theIcon)
			(highlightedIcon highlight: 1)
		)
		(if (and (>= argc 2) posnCursor)
			(gGame
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
		(gGame setCursor: (curIcon cursor:) 1)
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
		(gGame setCursor: (curIcon cursor:) 1)
	)
)

