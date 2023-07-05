;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 937)
(include sci.sh)
(use Main)
(use Print)
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

	(method (select relVer &tmp event whichCel)
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
					whichCel
				)
				(else 1)
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
		(for ((= i 0)) (< i argc) ((++ i))
			(= thisIcon (self at: i))
			(if (== (thisIcon message:) theVerb)
				(return thisIcon)
			)
		)
		(return 0)
	)

	(method (noClickHelp &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 (= temp2 0))
		(= temp3 (GetPort))
		(= temp4 (gSystemWindow eraseOnly:))
		(gSystemWindow eraseOnly: 1)
		(while (not ((= temp0 (Event new:)) type:))
			(if (not (self isMemberOf: IconBar))
				(temp0 localize:)
			)
			(cond
				((= temp2 (self firstTrue: #onMe temp0))
					(if (and (!= temp2 temp1) (temp2 helpVerb:))
						(= temp1 temp2)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print
							font: gUserFont
							width: 250
							addText:
								(temp2 noun:)
								(temp2 helpVerb:)
								0
								1
								0
								0
								(temp2 modNum:)
							modeless: 1
							init:
						)
						(SetPort temp3)
					)
				)
				(gModelessDialog
					(gModelessDialog dispose:)
				)
				(else
					(= temp1 0)
				)
			)
			(temp0 dispose:)
		)
		(gSystemWindow eraseOnly: temp4)
		(gGame setCursor: 999 1)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(SetPort temp3)
		(if (not (helpIconItem onMe: temp0))
			(self dispatchEvent: temp0)
		else
			(temp0 dispose:)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(event localize:)
		(= temp1 (event type:))
		(cond
			((& state $0004))
			(
				(or
					(and
						(not temp1)
						(& state $0400)
						(<= -10 (event y:) height)
						(<= 0 (event x:) 320)
						(not (= temp0 0))
					)
					(and
						(== temp1 evKEYBOARD)
						(or
							(== (event message:) KEY_ESCAPE)
							(== (event message:) KEY_DELETE)
						)
						(= temp0 1)
					)
				)
				(event globalize:)
				(= oldMouseX (event x:))
				(= oldMouseY (event y:))
				(= temp2 gTheCursor)
				(= temp3 curIcon)
				(= temp4 curInvIcon)
				(self show:)
				(gGame setCursor: 999)
				(if temp0
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
				(if temp0
					(gGame
						setCursor:
							(if
								(and
									(not (gUser canInput:))
									(not (gUser canControl:))
								)
								997
							else
								(curIcon cursor:)
							)
							1
							oldMouseX
							oldMouseY
					)
				else
					(gGame
						setCursor:
							(if
								(and
									(not (gUser canInput:))
									(not (gUser canControl:))
								)
								997
							else
								(curIcon cursor:)
							)
							1
							((= temp5 (Event new:)) x:)
							(Max (temp5 y:) (+ 1 height))
					)
					(temp5 dispose:)
				)
				(self hide:)
			)
			((& temp1 evKEYBOARD)
				(switch (event message:)
					(KEY_RETURN
						(if (IsObject curIcon)
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
									(+ (curInvIcon loop:) 1)
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
									(+ (curInvIcon loop:) 1)
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
					(+ (curInvIcon loop:) 1)
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
			(Graph grRESTORE_BOX underBits)
			(Graph grUPDATE_BOX y 0 (+ y height) 320 1)
			(Graph grREDRAW_BOX y 0 (+ y height) 320)
			(SetPort port)
			(= height activateHeight)
		)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(while (and (& state $0020) (= temp0 (Event new:)))
			(= temp1 (temp0 type:))
			(= temp2 (temp0 message:))
			(= temp3 (temp0 modifiers:))
			(Wait 1)
			(if (== temp1 evJOYDOWN)
				(= temp1 evKEYBOARD)
				(= temp2 (if (& temp3 emSHIFT) 27 else 13))
				(= temp3 $0000)
				(temp0 type: temp1 message: temp2 modifiers: $0000)
			)
			(temp0 localize:)
			(if
				(and
					(or (== temp1 evMOUSEBUTTON) (and (== temp1 evKEYBOARD) (== temp2 KEY_RETURN)))
					(IsObject helpIconItem)
					(& (helpIconItem signal:) $0010)
				)
				(temp0 type: $6000 message: (helpIconItem message:)) ; evVERB | evHELP
			)
			(MapKeyToDir temp0)
			(breakif (self dispatchEvent: temp0))
		)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 [temp7 50] temp57 temp58 temp59)
		(= temp1 (event x:))
		(= temp0 (event y:))
		(= temp2 (event type:))
		(= temp3 (event message:))
		(= temp5 (event claimed:))
		(if (= temp4 (self firstTrue: #onMe event))
			(= temp57 (temp4 cursor:))
			(= temp58 (temp4 signal:))
			(= temp59 (== temp4 helpIconItem))
		)
		(event dispose:)
		(if (& temp2 $0040) ; direction
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
						((not (and (<= 0 temp0 (+ y height)) (<= 0 temp1 320)))
							(if
								(and
									(& state $0400)
									(or
										(not (IsObject helpIconItem))
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
						(if temp59
							(if temp57
								(gGame setCursor: temp57)
							)
							(if (& state $0800)
								(self noClickHelp:)
							else
								(helpIconItem
									signal: (| (helpIconItem signal:) $0010)
								)
							)
						else
							(= temp5 (& temp58 $0040))
						)
						(temp4 doit:)
					)
				)
				(evKEYBOARD
					(switch temp3
						(KEY_ESCAPE
							(= temp5 1)
						)
						(KEY_DELETE
							(= temp5 1)
						)
						(KEY_RETURN
							(if (not temp4)
								(= temp4 highlightedIcon)
							)
							(cond
								((and temp4 (== temp4 helpIconItem))
									(if (!= temp57 -1)
										(gGame setCursor: temp57)
									)
									(if helpIconItem
										(helpIconItem
											signal:
												(| (helpIconItem signal:) $0010)
										)
									)
								)
								((and (IsObject temp4) (self select: temp4))
									(temp4 doit:)
									(= temp5 (& temp58 $0040))
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
					(if (and temp4 (temp4 helpVerb:))
						(= temp6 (GetPort))
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
						(SetPort temp6)
					)
					(if helpIconItem
						(helpIconItem signal: (& (helpIconItem signal:) $ffef))
					)
					(gGame setCursor: 999)
				)
			)
		)
		(return temp5)
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

