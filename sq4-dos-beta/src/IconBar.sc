;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 937)
(include sci.sh)
(use Main)
(use Interface)
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
		helpStr 0
		maskView 0
		maskLoop 0
		maskCel 0
		highlightColor 0
		lowlightColor 0
	)

	(method (show iX iY &tmp [temp0 7])
		(if argc
			(= nsRight (+ (= nsLeft iX) (CelWide view loop cel)))
			(= nsBottom (+ (= nsTop iY) (CelHigh view loop cel)))
		else
			(= nsRight (+ nsLeft (CelWide view loop cel)))
			(= nsBottom (+ nsTop (CelHigh view loop cel)))
		)
		(DrawCel view loop cel nsLeft nsTop -1)
		(if (& signal $0004)
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
		(= sColor (if (and argc tOrF) highlightColor else lowlightColor))
		(= t (+ nsTop 2))
		(= l (+ nsLeft 2))
		(= b (- nsBottom 3))
		(= r (- nsRight 4))
		(Graph grDRAW_LINE t l t r sColor -1 -1)
		(Graph grDRAW_LINE t r b r sColor -1 -1)
		(Graph grDRAW_LINE b r b l sColor -1 -1)
		(Graph grDRAW_LINE b l t l sColor -1 -1)
		(Graph grUPDATE_BOX (- nsTop 2) (- nsLeft 2) (+ nsBottom 3) (+ nsRight 3) 1)
	)

	(method (select relVer &tmp event whichCel)
		(if (and argc relVer (& signal $0001))
			(DrawCel view loop (= whichCel 1) nsLeft nsTop -1)
			(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
			(while (!= ((= event (Event new:)) type:) evMOUSERELEASE)
				(event localize:)
				(cond
					((self onMe: event)
						(if (not whichCel)
							(DrawCel view loop (= whichCel 1) nsLeft nsTop -1)
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
			(return whichCel)
		else
			(return 1)
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
		port 0
		window 0
		state 0
	)

	(method (handleEvent event &tmp temp0)
		(event localize:)
		(cond
			(
				(and
					(== (event type:) evKEYBOARD)
					(== (event message:) KEY_RETURN)
					(IsObject curIcon)
				)
				(event type: (curIcon type:) message: (curIcon message:))
			)
			((== (event type:) evMOUSEBUTTON)
				(cond
					((& (event modifiers:) emSHIFT)
						(self advanceCurIcon:)
						(event claimed: 1)
					)
					((& (event modifiers:) emCTRL)
						(self swapCurIcon:)
						(event claimed: 1)
					)
					((IsObject curIcon)
						(event
							type: (curIcon type:)
							message: (curIcon message:)
						)
					)
				)
			)
			((& state $0004))
			(
				(or
					(and
						(not (event type:))
						(< (event y:) height)
						(not (= temp0 0))
					)
					(and
						(== (event type:) evKEYBOARD)
						(== (event message:) KEY_ESCAPE)
						(= temp0 1)
					)
				)
				(if temp0
					(gGame
						setCursor:
							gTheCursor
							1
							(+
								(curIcon nsLeft:)
								(/ (- (curIcon nsRight:) (curIcon nsLeft:)) 2)
							)
							(- (curIcon nsBottom:) 13)
					)
				)
				(= oldMouseX (event x:))
				(= oldMouseY (event y:))
				(self show:)
			)
		)
	)

	(method (disable theIconNumber &tmp i thisIcon)
		(if argc
			(for ((= i 0)) (< i argc) ((++ i))
				(= thisIcon (self at: [theIconNumber i]))
				(thisIcon signal: (| (thisIcon signal:) $0004))
				(cond
					((== thisIcon highlightedIcon)
						(self advance:)
					)
					((== thisIcon curIcon)
						(self advanceCurIcon:)
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
				(= thisIcon (self at: [theIconNumber i]))
				(thisIcon signal: (& (thisIcon signal:) $fffb))
			)
		else
			(&= state $fffb)
		)
	)

	(method (show &tmp theIcon pnv i theX theY node nextNode obj)
		(|= state $0020)
		(gGame setCursor: 999 1)
		(= height
			(CelHigh ((= theIcon (self at: 0)) view:) (theIcon loop:) (theIcon cel:))
		)
		(= port (GetPort))
		(SetPort 0)
		(= underBits (Graph grSAVE_BOX 0 0 height 320 1))
		(= pnv (PicNotValid))
		(PicNotValid 1)
		(= theX 0)
		(= theY 0)
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
			(if (curInvIcon ownedBy: gEgo)
				(= theX
					(+
						(/
							(-
								(- (useIconItem nsRight:) (useIconItem nsLeft:))
								(CelWide (curInvIcon view:) 1 (curInvIcon cel:))
							)
							2
						)
						(useIconItem nsLeft:)
					)
				)
				(= theY
					(+
						(/
							(-
								(- (useIconItem nsBottom:) (useIconItem nsTop:))
								(CelHigh (curInvIcon view:) 1 (curInvIcon cel:))
							)
							2
						)
						(useIconItem nsTop:)
					)
				)
				(DrawCel (curInvIcon view:) 1 (curInvIcon cel:) theX theY -1)
			else
				(= curInvIcon 0)
			)
		)
		(PicNotValid pnv)
		(Graph grUPDATE_BOX 0 0 height 320 1)
		(self highlight: curIcon)
		(gGame
			setCursor:
				gTheCursor
				(+
					(curIcon nsLeft:)
					(/ (- (curIcon nsLeft:) (curIcon nsRight:)) 2)
				)
		)
		(self doit:)
	)

	(method (hide)
		(&= state $ffdf)
		(Graph grRESTORE_BOX underBits)
		(Graph grUPDATE_BOX 0 0 height 320 1)
		(SetPort port)
		(= height 0)
	)

	(method (doit &tmp temp0)
		(while (and (= temp0 (Event new:)) (& state $0020))
			(temp0 localize:)
			(if
				(and
					(or
						(== (temp0 type:) evMOUSEBUTTON)
						(and (== (temp0 type:) evKEYBOARD) (== (temp0 message:) KEY_RETURN))
					)
					(or
						(not (IsObject helpIconItem))
						(& (helpIconItem signal:) $0010)
					)
				)
				(temp0 type: evVERB message: KEY_TAB)
			)
			(if (self dispatchEvent: temp0)
				(break)
			)
		)
		(if (IsObject temp0)
			(temp0 dispose:)
		)
		(if (and (IsObject curIcon) (!= (curIcon cursor:) -1))
			(gGame setCursor: (curIcon cursor:) 1)
		)
		(self hide:)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 (event y:))
		(= temp1 (event type:))
		(= temp2 (event message:))
		(= temp3 (event modifiers:))
		(= temp5 (event claimed:))
		(= temp4 (self firstTrue: #onMe event))
		(event dispose:)
		(switch temp1
			(evNULL
				(cond
					((> temp0 height)
						(if
							(or
								(not (IsObject helpIconItem))
								(not (& (helpIconItem signal:) $0010))
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
					(if (== temp4 helpIconItem)
						(if (temp4 cursor:)
							(gGame setCursor: (temp4 cursor:))
						)
						(helpIconItem signal: (| (helpIconItem signal:) $0010))
					else
						(= temp5 (& (temp4 signal:) $0040))
					)
				)
			)
			(evKEYBOARD
				(cond
					((== temp2 KEY_ESCAPE)
						(= temp5 1)
					)
					((== temp2 KEY_RETURN)
						(if (not temp4)
							(= temp4 highlightedIcon)
						)
						(if (== temp4 helpIconItem)
							(if (!= (temp4 cursor:) -1)
								(gGame setCursor: (temp4 cursor:))
							)
							(if helpIconItem
								(helpIconItem
									signal: (| (helpIconItem signal:) $0010)
								)
							)
						else
							(self select: temp4)
							(= temp5 (& (temp4 signal:) $0040))
						)
					)
					((or (== temp2 KEY_LEFT) (and (== temp2 KEY_SHIFTTAB) (& temp3 emSHIFT)))
						(self retreat:)
					)
					((or (== temp2 KEY_RIGHT) (== temp2 KEY_TAB))
						(self advance:)
					)
				)
			)
			(evVERB
				(if (== temp2 KEY_TAB)
					(if (and temp4 (temp4 helpStr:))
						(Printf 937 0 (temp4 helpStr:)) ; "%s"
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
			(= theIcon (self at: (+ i (self indexOf: highlightedIcon))))
			(if (not (IsObject theIcon))
				(= theIcon (NodeValue (self first:)))
			)
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
			(breakif (not (& (theIcon signal:) $0004)))
		)
		(self highlight: theIcon)
	)

	(method (retreat &tmp theIcon i)
		(for ((= i 1)) (<= i size) ((= i (mod (+ i 1) size)))
			(= theIcon (self at: (- (self indexOf: highlightedIcon) i)))
			(if (not (IsObject theIcon))
				(= theIcon (NodeValue (self last:)))
			)
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
			(breakif (not (& (theIcon signal:) $0004)))
		)
		(self highlight: theIcon)
	)

	(method (select theIcon relVer)
		(return
			(if
				(and
					(not (& (theIcon signal:) $0004))
					(theIcon select: (and (>= argc 2) relVer))
				)
				(if (not (& (theIcon signal:) $0002))
					(= curIcon theIcon)
				)
				1
			)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if (not (& (param1 signal:) $0004))
			(if (IsObject highlightedIcon)
				(highlightedIcon highlight: 0)
			)
			(= highlightedIcon param1)
			(highlightedIcon highlight: 1)
		)
	)

	(method (advanceCurIcon &tmp theIcon i)
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

	(method (swapCurIcon)
		(cond
			((& state $0004)
				(return)
			)
			((!= curIcon (self at: 0))
				(= prevIcon curIcon)
				(= curIcon (self at: 0))
			)
			(prevIcon
				(= curIcon prevIcon)
			)
		)
		(gGame setCursor: (curIcon cursor:) 1)
	)
)

