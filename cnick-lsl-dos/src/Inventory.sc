;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 995)
(include sci.sh)
(use Main)
(use Interface)
(use IconBar)
(use Window)
(use System)

(local
	yesI
)

(class InvI of IconI
	(properties
		view 0
		loop 0
		cel 0
		nsTop 0
		cursor 999
		message 0
		signal 0
		owner 0
		script 0
		value 0
	)

	(method (onMe event)
		(return (and (super onMe: event) (not (& signal $0004))))
	)

	(method (doVerb theVerb)
		(if (not modNum)
			(= modNum gCurRoomNum)
		)
		(if (and gMsgType (Message msgGET modNum noun theVerb 0 1))
			(gMessager say: noun theVerb 0 0 0 modNum)
		)
	)

	(method (highlight tOrF &tmp t l b r sColor)
		(if (== highlightColor -1)
			(return)
		)
		(= sColor (if (and argc tOrF) highlightColor else lowlightColor))
		(= t (- nsTop 2))
		(= l (- nsLeft 2))
		(= b (+ nsBottom 1))
		(= r (+ nsRight 1))
		(Graph grDRAW_LINE t l t r sColor -1 -1)
		(Graph grDRAW_LINE t r b r sColor -1 -1)
		(Graph grDRAW_LINE b r b l sColor -1 -1)
		(Graph grDRAW_LINE b l t l sColor -1 -1)
		(Graph grUPDATE_BOX (- nsTop 2) (- nsLeft 2) (+ nsBottom 2) (+ nsRight 2) 1)
	)

	(method (show &tmp [temp0 4])
		(DrawCel view loop cel nsLeft nsTop -1)
	)

	(method (ownedBy id)
		(return (== owner id))
	)

	(method (moveTo id)
		(= owner id)
		(if (and value (== id gEgo))
			(gGame changeScore: value)
			(= value 0)
		)
		(return self)
	)
)

(class Inv of IconBar
	(properties
		normalHeading {You are carrying:}
		heading 0
		empty {nothing!}
		iconBarInvItem 0
		okButton 0
		selectIcon 0
	)

	(method (drawInvWindow whom selection &tmp numOwned tallestInv widestInv numIcons tallestIcon iconBarWidth cWide cHigh node obj invW invH iTop iLeft iBottom iRight numRows atX atY firstX i invWin [buffer 50])
		(= numOwned (= tallestInv (= widestInv (= numIcons (= tallestIcon (= iconBarWidth 0))))))
		(for ((= node (self first:))) node ((= node (self next: node)))
			(if ((= obj (NodeValue node)) isKindOf: InvI)
				(if (obj ownedBy: whom)
					(obj signal: (& (obj signal:) $fffb))
					(++ numOwned)
					(if
						(>
							(= cWide
								(CelWide
									(obj view:)
									(obj loop:)
									(obj cel:)
								)
							)
							widestInv
						)
						(= widestInv cWide)
					)
					(if
						(>
							(= cHigh
								(CelHigh
									(obj view:)
									(obj loop:)
									(obj cel:)
								)
							)
							tallestInv
						)
						(= tallestInv cHigh)
					)
				else
					(obj signal: (| (obj signal:) $0004))
				)
			else
				(++ numIcons)
				(+= iconBarWidth (CelWide (obj view:) (obj loop:) (obj cel:)))
				(if
					(>
						(= cHigh
							(CelHigh (obj view:) (obj loop:) (obj cel:))
						)
						tallestIcon
					)
					(= tallestIcon cHigh)
				)
			)
		)
		(if (not numOwned)
			(Format @buffer {%s %s} normalHeading empty)
			(Print @buffer)
			(return 0)
		)
		(if (> (* (= numRows (Sqrt numOwned)) numRows) numOwned)
			(-- numRows)
		)
		(if (> numRows 3)
			(= numRows 3)
		)
		(= yesI (/ numOwned numRows))
		(if (< (* numRows yesI) numOwned)
			(++ yesI)
		)
		(= invW (Max (+ 4 iconBarWidth) (* yesI (+ 4 widestInv))))
		(= invH (* numRows (+ 4 tallestInv)))
		(= iTop (/ (- 190 invH) 2))
		(= iLeft (/ (- 320 invW) 2))
		(= iBottom (+ iTop invH))
		(= iRight (+ iLeft invW))
		(if (= invWin (self window:))
			(invWin top: iTop left: iLeft right: iRight bottom: iBottom open:)
		)
		(= i yesI)
		(if numOwned
			(= atY
				(+
					2
					(if (invWin respondsTo: #yOffset)
						(invWin yOffset:)
					)
				)
			)
			(= firstX
				(= atX
					(+
						4
						(if (invWin respondsTo: #xOffset)
							(invWin xOffset:)
						)
					)
				)
			)
			(for ((= node (self first:))) node ((= node (self next: node)))
				(if
					(and
						(not (& ((= obj (NodeValue node)) signal:) $0004))
						(obj isKindOf: InvI)
					)
					(if (not (& (obj signal:) $0080))
						(obj
							nsLeft:
								(+
									atX
									(/
										(-
											widestInv
											(= cWide
												(CelWide
													(obj view:)
													(obj loop:)
													(obj cel:)
												)
											)
										)
										2
									)
								)
							nsTop:
								(+
									atY
									(/
										(-
											tallestInv
											(= cHigh
												(CelHigh
													(obj view:)
													(obj loop:)
													(obj cel:)
												)
											)
										)
										2
									)
								)
						)
						(obj
							nsRight: (+ (obj nsLeft:) cWide)
							nsBottom: (+ (obj nsTop:) cHigh)
						)
						(if (-- i)
							(+= atX widestInv)
						else
							(= i yesI)
							(+= atY tallestInv)
							(= atX firstX)
						)
					else
						(= atX (obj nsLeft:))
						(= atY (obj nsTop:))
					)
					(obj show:)
					(if (== obj selection)
						(obj highlight:)
					)
				)
			)
		)
		(= atX (/ (- (- (invWin right:) (invWin left:)) iconBarWidth) 2))
		(= invH (- (invWin bottom:) (invWin top:)))
		(= atY 32767)
		(for ((= node (self first:))) node ((= node (self next: node)))
			(if (not ((= obj (NodeValue node)) isKindOf: InvI))
				(= cWide (CelWide (obj view:) (obj loop:) (obj cel:)))
				(= cHigh (CelHigh (obj view:) (obj loop:) (obj cel:)))
				(if (not (& (obj signal:) $0080))
					(if (== atY 32767)
						(= atY (- invH cHigh))
					)
					(obj
						nsLeft: atX
						nsTop: atY
						nsBottom: invH
						nsRight: (+ atX cWide)
					)
				)
				(= atX (+ (obj nsLeft:) cWide))
				(= atY (obj nsTop:))
				(obj signal: (& (obj signal:) $fffb) show:)
			)
		)
		(return 1)
	)

	(method (init)
		(= heading normalHeading)
	)

	(method (ownedBy whom)
		(self firstTrue: #ownedBy whom)
	)

	(method (showSelf whom)
		(gSounds pause:)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
		(if (gTheIconBar height:)
			(gTheIconBar hide:)
		)
		(if (not window)
			(= window (SysWindow new:))
		)
		(if (window window:)
			(window dispose:)
			(= window 0)
		)
		(if (not okButton)
			(= okButton (NodeValue (self first:)))
		)
		(= curIcon 0)
		(if (self show: (if argc whom else gEgo))
			(self doit:)
		)
	)

	(method (show who &tmp pnv diw)
		(gGame
			setCursor:
				(if curIcon
					(curIcon cursor:)
				else
					(selectIcon cursor:)
				)
		)
		(= pnv (PicNotValid))
		(PicNotValid 0)
		(|= state $0020)
		(if
			(not
				(= diw
					(self
						drawInvWindow:
							(if argc who else gEgo)
							(gTheIconBar curIcon:)
					)
				)
			)
			(&= state $ffdf)
		)
		(PicNotValid pnv)
		(return diw)
	)

	(method (advance amount &tmp theIcon toMove highlightedNo nextIcon)
		(= toMove (if argc amount else 1))
		(= highlightedNo (self indexOf: highlightedIcon))
		(= nextIcon (+ toMove highlightedNo))
		(repeat
			(= theIcon
				(self
					at:
						(if (<= nextIcon size)
							nextIcon
						else
							(mod nextIcon (- size 1))
						)
				)
			)
			(if (not (IsObject theIcon))
				(= theIcon (NodeValue (self first:)))
			)
			(if (not (& (theIcon signal:) $0004))
				(break)
			else
				(++ nextIcon)
			)
		)
		(self highlight: theIcon 1)
	)

	(method (retreat amount &tmp theIcon toMove highlightedNo nextIcon)
		(= toMove (if argc amount else 1))
		(= nextIcon (- (= highlightedNo (self indexOf: highlightedIcon)) toMove))
		(repeat
			(= theIcon (self at: nextIcon))
			(if (not (IsObject theIcon))
				(= theIcon (NodeValue (self last:)))
			)
			(if (not (& (theIcon signal:) $0004))
				(break)
			else
				(-- nextIcon)
			)
		)
		(self highlight: theIcon 1)
	)

	(procedure (localproc_0 param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
		(= temp3
			(+ (/ (- (param1 nsRight:) (param1 nsLeft:)) 2) (param1 nsLeft:))
		)
		(= temp2 param2)
		(while (>= (Abs (- temp2 param3)) 4)
			(if
				(= temp0
					(self
						firstTrue:
							#onMe
							((= temp1 (Event new:)) x: temp3 y: temp2 yourself:)
					)
				)
				(temp1 dispose:)
				(return temp0)
			)
			(temp1 dispose:)
			(if (< param2 param3)
				(+= temp2 4)
			else
				(-= temp2 4)
			)
		)
	)

	(method (doit &tmp temp0 temp1 temp2 [temp3 3] temp6 temp7 temp8 [temp9 50])
		(while ((= temp1 (Event new:)) type:)
			(temp1 dispose:)
		)
		(temp1 dispose:)
		(= temp1 0)
		(while (& state $0020)
			(invEvent
				type: 0
				message: 0
				modifiers: 0
				y: 0
				x: 0
				claimed: 0
				port: 0
			)
			(GetEvent evALL_EVENTS invEvent)
			(= gMouseX (invEvent x:))
			(= gMouseY (invEvent y:))
			(= temp8 0)
			(invEvent localize:)
			(if
				(and
					curIcon
					(not (invEvent modifiers:))
					(!= curIcon selectIcon)
					(or
						(== (invEvent type:) 1)
						(and
							(== (invEvent type:) 4)
							(== (invEvent message:) 13)
							(= temp8 1)
						)
						(and (== (invEvent type:) 256) (= temp8 1))
					)
					(or
						(!= curIcon helpIconItem)
						(& (helpIconItem signal:) $0010)
					)
				)
				(invEvent type: 16384 message: (curIcon message:))
			)
			(MapKeyToDir invEvent)
			(cond
				((and (== (= temp2 (invEvent type:)) 1) (invEvent modifiers:))
					(self advanceCurIcon:)
					(invEvent claimed: 1)
				)
				(
					(and
						(== temp2 0)
						(= temp0 (self firstTrue: #onMe invEvent))
						(!= temp0 highlightedIcon)
					)
					(self highlight: temp0)
				)
				(
					(or
						(== temp2 1)
						(and (== temp2 4) (== (invEvent message:) 13))
						(== temp2 256)
					)
					(if
						(and
							(IsObject highlightedIcon)
							(self select: highlightedIcon (== temp2 1))
						)
						(cond
							((== highlightedIcon okButton)
								(break)
							)
							((== highlightedIcon helpIconItem)
								(if (!= (highlightedIcon cursor:) -1)
									(gGame setCursor: (helpIconItem cursor:))
								)
								(cond
									((& state $0800)
										(self noClickHelp:)
									)
									(helpIconItem
										(helpIconItem
											signal:
												(| (helpIconItem signal:) $0010)
										)
									)
								)
							)
							(else
								(= curIcon highlightedIcon)
								(gGame setCursor: (curIcon cursor:))
							)
						)
					)
				)
				((& temp2 $0040)
					(switch (invEvent message:)
						(3
							(self advance:)
						)
						(7
							(self retreat:)
						)
						(1
							(if
								(and
									highlightedIcon
									(= temp0
										(localproc_0
											highlightedIcon
											(- (highlightedIcon nsTop:) 1)
											0
										)
									)
								)
								(self highlight: temp0 1)
							else
								(self retreat:)
							)
						)
						(5
							(if
								(and
									highlightedIcon
									(= temp0
										(localproc_0
											highlightedIcon
											(+ (highlightedIcon nsBottom:) 1)
											(window bottom:)
										)
									)
								)
								(self highlight: temp0 1)
							else
								(self advance:)
							)
						)
						(0
							(if (& temp2 $0004)
								(self advanceCurIcon:)
							)
						)
					)
				)
				((== temp2 4)
					(switch (invEvent message:)
						(9
							(self advance:)
						)
						(3840
							(self retreat:)
						)
					)
				)
				(
					(and
						(& temp2 $4000)
						(= temp0 (self firstTrue: #onMe invEvent))
					)
					(cond
						((& temp2 $2000)
							(if (and temp0 (temp0 helpStr:))
								(Format @temp9 {%s} (temp0 helpStr:))
								(if (gSystemWindow respondsTo: #eraseOnly)
									(= temp6 (gSystemWindow eraseOnly:))
									(gSystemWindow eraseOnly: 1)
									(Print @temp9)
									(gSystemWindow eraseOnly: temp6)
								else
									(Print @temp9)
								)
							)
							(helpIconItem
								signal: (& (helpIconItem signal:) $ffef)
							)
							(gGame setCursor: 999)
						)
						((== temp0 okButton)
							(break)
						)
						((not (temp0 isKindOf: InvI))
							(if (self select: temp0 (not temp8))
								(= curIcon temp0)
								(gGame setCursor: (curIcon cursor:))
								(if (== temp0 helpIconItem)
									(if (& state $0800)
										(self noClickHelp:)
									else
										(helpIconItem
											signal:
												(| (helpIconItem signal:) $0010)
										)
									)
								)
							)
						)
						(curIcon
							(if (gSystemWindow respondsTo: #eraseOnly)
								(= temp6 (gSystemWindow eraseOnly:))
								(gSystemWindow eraseOnly: 1)
							)
							(if (curIcon isKindOf: InvI)
								(temp0 doVerb: (curIcon message:))
							else
								(temp0 doVerb: (invEvent message:))
							)
							(if (gSystemWindow respondsTo: #eraseOnly)
								(gSystemWindow eraseOnly: temp6)
							)
						)
					)
				)
			)
			(invEvent dispose:)
		)
		(invEvent dispose:)
		(self hide:)
	)

	(method (hide)
		(if (& state $0020)
			(gSounds pause: 0)
			(&= state $ffdf)
		)
		(if window
			(window dispose:)
		)
		(if (and (IsObject curIcon) (curIcon isKindOf: InvI))
			(if (not (gTheIconBar curInvIcon:))
				(gTheIconBar enable: (gTheIconBar useIconItem:))
			)
			(gTheIconBar
				curIcon:
					((gTheIconBar useIconItem:)
						cursor: (curIcon cursor:)
						yourself:
					)
				curInvIcon: curIcon
			)
			(if ((gTheIconBar curIcon:) cursor:)
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
			)
		)
	)

	(method (advanceCurIcon &tmp theIcon)
		(= theIcon curIcon)
		(while
			((= theIcon (self at: (mod (+ (self indexOf: theIcon) 1) size)))
				isKindOf: InvI
			)
		)
		(= curIcon theIcon)
		(if helpIconItem
			(if (== curIcon helpIconItem)
				(helpIconItem signal: (| (helpIconItem signal:) $0010))
			else
				(helpIconItem signal: (& (helpIconItem signal:) $ffef))
			)
		)
		(gGame setCursor: (curIcon cursor:))
	)
)

(instance invEvent of Event
	(properties)
)

