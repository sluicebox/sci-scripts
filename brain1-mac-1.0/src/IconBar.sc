;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 937)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
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
		height 10
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
		state 1024
		activateHeight 10
		y 0
		invLoop 1
		pri 15
		rgnDesc 0
	)

	(method (noClickHelp &tmp temp0 temp1 temp2 [temp3 100] temp103)
		(= temp1 (= temp2 0))
		(= temp103 (GetPort))
		(while (not ((= temp0 (Event new:)) type:))
			(if (not (self isMemberOf: IconBar))
				(temp0 localize:)
			)
			(cond
				((= temp2 (self firstTrue: #onMe temp0))
					(if (and (!= temp2 temp1) (temp2 helpStr:))
						(= temp1 temp2)
						(Format @temp3 (temp2 helpStr:))
						(Print @temp3 #dispose)
						(SetPort temp103)
					)
				)
				(gModelessDialog
					(gModelessDialog dispose:)
					(SetPort temp103)
				)
				(else
					(= temp1 0)
				)
			)
			(temp0 dispose:)
		)
		(temp0 dispose:)
		(gGame setCursor: 999 1)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(SetPort temp103)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(cond
			((& state $0004))
			(
				(and
					(not (= temp1 (event type:)))
					(<= y (event y:) (+ y height))
					(== (event message:) JOY_NULL)
					(not (= temp0 0))
				)
				(= oldMouseX (event x:))
				(= oldMouseY (event y:))
				(self show:)
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
				(self doit:)
				(if temp0
					(gGame setCursor: (curIcon cursor:) 1 oldMouseX oldMouseY)
				else
					(gGame setCursor: (curIcon cursor:) 1)
				)
				(self hide:)
			)
			((& temp1 evKEYBOARD)
				(switch (event message:)
					(KEY_RETURN
						(if (IsObject curIcon)
							(event
								type: (curIcon type:)
								message: (curIcon message:)
							)
						)
					)
					(KEY_INSERT
						(self swapCurIcon:)
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

	(method (show &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(gSounds pause:)
		(|= state $0020)
		(gGame setCursor: 999 1)
		(= height
			(CelHigh ((= temp0 (self at: 0)) view:) (temp0 loop:) (temp0 cel:))
		)
		(= port (GetPort))
		(SetPort 0)
		(SetPort 0)
		(= temp8 (Clone Event))
		(temp8 x: 0 y: y port: -1)
		(temp8 localize:)
		(= temp9 (temp8 y:))
		(temp8 dispose:)
		(= rgnDesc
			(Platform
				0
				1
				0
				1
				temp9
				0
				4
				16704
				(| height $c000)
				320
				(| height $8000)
			)
		)
		(= window
			(NewWindow
				temp9
				0
				(+ temp9 height)
				320
				temp9
				0
				(+ temp9 height)
				320
				0
				128
				pri
				0
				0
				0
				rgnDesc
			)
		)
		(if (!= pri -1)
			(Graph grFILL_BOX 0 0 height 320 2 0 pri)
		)
		(= temp1 (PicNotValid))
		(PicNotValid 1)
		(= temp3 0)
		(= temp4 y)
		(for ((= temp5 (FirstNode elements))) temp5 ((= temp5 temp6))
			(= temp6 (NextNode temp5))
			(if (not (IsObject (= temp7 (NodeValue temp5))))
				(return)
			)
			(if (<= (temp7 nsRight:) 0)
				(temp7 show: temp3 temp4)
				(= temp3 (temp7 nsRight:))
			else
				(temp7 show:)
			)
		)
		(if curInvIcon
			(if (gEgo has: (gInventory indexOf: curInvIcon))
				(= temp3
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
				(= temp4
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
					(+ (curInvIcon loop:) invLoop)
					(curInvIcon cel:)
					temp3
					temp4
					-1
				)
				(if (& (useIconItem signal:) $0004)
					(useIconItem mask:)
				)
			else
				(= curInvIcon 0)
			)
		)
		(PicNotValid temp1)
		(Graph grUPDATE_BOX y 0 (+ y height) 320 1)
		(self highlight: curIcon)
		(gGame
			setCursor:
				gTheCursor
				(+
					(curIcon nsLeft:)
					(/ (- (curIcon nsLeft:) (curIcon nsRight:)) 2)
				)
		)
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
			(DisposeWindow window 0)
			(Platform 0 1 1 rgnDesc)
			(= rgnDesc 0)
			(SetPort port)
			(= height activateHeight)
			(SL doit:)
		)
	)

	(method (doit &tmp temp0)
		(while (and (= temp0 (Event new:)) (& state $0020))
			(Wait 1)
			(if (== (temp0 type:) evJOYDOWN)
				(temp0
					type: evKEYBOARD
					message: (if (& (temp0 modifiers:) emSHIFT) 27 else 13)
					modifiers: $0000
				)
			)
			(temp0 localize:)
			(if
				(and
					(or
						(== (temp0 type:) evMOUSEBUTTON)
						(and (== (temp0 type:) evKEYBOARD) (== (temp0 message:) KEY_RETURN))
					)
					(IsObject helpIconItem)
					(& (helpIconItem signal:) $0010)
				)
				(temp0 type: evVERB message: (helpIconItem message:))
			)
			(MapKeyToDir temp0)
			(if (self dispatchEvent: temp0)
				(break)
			)
		)
		(if (IsObject temp0)
			(temp0 dispose:)
		)
	)

	(method (dispatchEvent event &tmp evtY evtX evtType evtMsg thisIcon evtClaimed thePort)
		(= evtX (event x:))
		(= evtY (event y:))
		(= evtType (event type:))
		(= evtMsg (event message:))
		(= evtClaimed (event claimed:))
		(= thisIcon (self firstTrue: #onMe event))
		(event dispose:)
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
						((or (!= evtMsg JOY_NULL) (< evtY y) (> evtY (+ y height)))
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
						(if (== thisIcon helpIconItem)
							(if (thisIcon cursor:)
								(gGame setCursor: (thisIcon cursor:))
							)
							(if (& state $0800)
								(self noClickHelp:)
							else
								(helpIconItem
									signal: (| (helpIconItem signal:) $0010)
								)
							)
						else
							(= evtClaimed (& (thisIcon signal:) $0040))
						)
					)
				)
				(evKEYBOARD
					(switch evtMsg
						(KEY_ESCAPE
							(= evtClaimed 1)
						)
						(KEY_RETURN
							(if (not thisIcon)
								(= thisIcon highlightedIcon)
							)
							(cond
								((and thisIcon (== thisIcon helpIconItem))
									(if (!= (thisIcon cursor:) -1)
										(gGame setCursor: (thisIcon cursor:))
									)
									(if helpIconItem
										(helpIconItem
											signal:
												(| (helpIconItem signal:) $0010)
										)
									)
								)
								((IsObject thisIcon)
									(self select: thisIcon)
									(= evtClaimed (& (thisIcon signal:) $0040))
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
				(evVERB
					(if (== evtMsg JOY_DOWNLEFT)
						(if (and thisIcon (thisIcon helpStr:))
							(= thePort (GetPort))
							(Printf 937 0 (thisIcon helpStr:)) ; "%s"
							(SetPort thePort)
						)
						(if helpIconItem
							(helpIconItem
								signal: (& (helpIconItem signal:) $ffef)
							)
						)
						(gGame setCursor: 999)
					)
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

