;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 995)
(include sci.sh)
(use Main)
(use Print)
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
			(Print addTextF: @buffer {%s %s} normalHeading empty init:)
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

	(method (doit &tmp thisIcon event evtType [evtMsg 3] node newIcon eO oldPort [keyInvoked 50])
		(if (gSystemWindow respondsTo: #eraseOnly)
			(= newIcon (gSystemWindow eraseOnly:))
			(gSystemWindow eraseOnly: 1)
		)
		(while ((= event (Event new:)) type:)
			(event dispose:)
		)
		(event dispose:)
		(= event 0)
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
			(GetEvent 32767 invEvent)
			(= gMouseX (invEvent x:))
			(= gMouseY (invEvent y:))
			(= oldPort 0)
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
							(= oldPort 1)
						)
						(and (== (invEvent type:) 256) (= oldPort 1))
					)
					(or
						(!= curIcon helpIconItem)
						(& (helpIconItem signal:) $0010)
					)
				)
				(invEvent type: 16384 message: (curIcon message:))
			)
			(MapKeyToDir invEvent)
			(= evtType (invEvent type:))
			(cond
				(gFastCast
					(gFastCast handleEvent: invEvent)
				)
				((and (== evtType 1) (invEvent modifiers:))
					(self advanceCurIcon:)
					(invEvent claimed: 1)
				)
				(
					(and
						(== evtType 0)
						(= thisIcon (self firstTrue: #onMe invEvent))
						(!= thisIcon highlightedIcon)
					)
					(self highlight: thisIcon)
				)
				(
					(or
						(== evtType 1)
						(and (== evtType 4) (== (invEvent message:) 13))
						(== evtType 256)
					)
					(if
						(and
							(IsObject highlightedIcon)
							(self select: highlightedIcon (== evtType 1))
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
				((& evtType $0040)
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
									(= thisIcon
										(localproc_0
											highlightedIcon
											(- (highlightedIcon nsTop:) 1)
											0
										)
									)
								)
								(self highlight: thisIcon 1)
							else
								(self retreat:)
							)
						)
						(5
							(if
								(and
									highlightedIcon
									(= thisIcon
										(localproc_0
											highlightedIcon
											(+ (highlightedIcon nsBottom:) 1)
											(window bottom:)
										)
									)
								)
								(self highlight: thisIcon 1)
							else
								(self advance:)
							)
						)
						(0
							(if (& evtType $0004)
								(self advanceCurIcon:)
							)
						)
					)
				)
				((== evtType 4)
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
						(& evtType $4000)
						(= thisIcon (self firstTrue: #onMe invEvent))
					)
					(cond
						((& evtType $2000)
							(if
								(and
									thisIcon
									(thisIcon noun:)
									(Message
										msgGET
										(thisIcon modNum:)
										(thisIcon noun:)
										(thisIcon helpVerb:)
										0
										1
										@keyInvoked
									)
								)
								(if (gSystemWindow respondsTo: #eraseOnly)
									(= node (gSystemWindow eraseOnly:))
									(gSystemWindow eraseOnly: 1)
									(Prints @keyInvoked)
									(gSystemWindow eraseOnly: node)
								else
									(Prints @keyInvoked)
								)
							)
							(helpIconItem
								signal: (& (helpIconItem signal:) $ffef)
							)
							(gGame setCursor: 999)
						)
						((== thisIcon okButton)
							(break)
						)
						((not (thisIcon isKindOf: InvI))
							(if (self select: thisIcon (not oldPort))
								(= curIcon thisIcon)
								(gGame setCursor: (curIcon cursor:))
								(if (== thisIcon helpIconItem)
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
								(= node (gSystemWindow eraseOnly:))
								(gSystemWindow eraseOnly: 1)
							)
							(if (curIcon isKindOf: InvI)
								(thisIcon doVerb: (curIcon message:))
							else
								(thisIcon doVerb: (invEvent message:))
							)
							(if (gSystemWindow respondsTo: #eraseOnly)
								(gSystemWindow eraseOnly: node)
							)
						)
					)
				)
			)
			(invEvent dispose:)
		)
		(invEvent dispose:)
		(if (gSystemWindow respondsTo: #eraseOnly)
			(gSystemWindow eraseOnly: newIcon)
		)
		(self hide:)
	)

	(method (hide &tmp theCurs)
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
			(if (= theCurs ((gTheIconBar curIcon:) cursor:))
				(gGame setCursor: theCurs)
			)
		)
	)
)

(instance invEvent of Event
	(properties)
)

