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
	numCols
)

(class InvI of IconI
	(properties
		view 0
		loop 0
		cel 0
		nsTop 0
		cursor 999
		message 4
		signal 0
		description 0
		owner 0
		script 0
		value 0
	)

	(method (onMe event)
		(return (and (super onMe: event) (not (& signal $0004))))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Printf 995 0 description) ; "%s"
			)
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
		normalHeading {Roger is carrying:}
		heading 0
		empty {nothing!}
		curScore {Score: %d out of %d}
		showScore 1
		iconBarInvItem 0
		okButton 0
		selectIcon 0
	)

	(procedure (DrawInvWindow whom selection &tmp numOwned tallestInv widestInv numIcons tallestIcon iconBarWidth cWide cHigh node obj invW invH iTop iLeft iBottom iRight numRows atX atY firstX i)
		(= numOwned (= tallestInv (= widestInv (= numIcons (= tallestIcon (= iconBarWidth 0))))))
		(for
			((= node (gInventory first:)))
			node
			((= node (gInventory next: node)))
			
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
			(Printf 995 1 normalHeading empty) ; "%s %s"
			(return 0)
		)
		(if (> (* (= numRows (Sqrt numOwned)) numRows) numOwned)
			(-- numRows)
		)
		(if (> numRows 3)
			(= numRows 3)
		)
		(= numCols (/ numOwned numRows))
		(if (< (* numRows numCols) numOwned)
			(++ numCols)
		)
		(= invW (Max (+ 4 iconBarWidth) (* numCols (+ 4 widestInv))))
		(= invH (* numRows (+ 4 tallestInv)))
		(= iTop (/ (- 190 invH) 2))
		(= iLeft (/ (- 320 invW) 2))
		(= iBottom (+ iTop invH))
		(= iRight (+ iLeft invW))
		(if (gInventory window:)
			((gInventory window:)
				top: iTop
				left: iLeft
				right: iRight
				bottom: iBottom
				open:
			)
		)
		(= i numCols)
		(if numOwned
			(= atY
				(+
					2
					(if ((gInventory window:) respondsTo: #yOffset)
						((gInventory window:) yOffset:)
					)
				)
			)
			(= firstX
				(= atX
					(+
						4
						(if ((gInventory window:) respondsTo: #xOffset)
							((gInventory window:) xOffset:)
						)
					)
				)
			)
			(for
				((= node (gInventory first:)))
				node
				((= node (gInventory next: node)))
				
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
							(= i numCols)
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
		(= atX
			(/
				(-
					(- ((gInventory window:) right:) ((gInventory window:) left:))
					iconBarWidth
				)
				2
			)
		)
		(= invH (- ((gInventory window:) bottom:) ((gInventory window:) top:)))
		(= atY 32767)
		(for
			((= node (gInventory first:)))
			node
			((= node (gInventory next: node)))
			
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
		(= gInventory self)
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
		(gGame setCursor: (selectIcon cursor:))
		(if (self show: (if argc whom else gEgo))
			(self doit:)
		)
	)

	(method (show who &tmp pnv diw)
		(= pnv (PicNotValid))
		(PicNotValid 0)
		(|= state $0020)
		(= diw
			(DrawInvWindow (if argc who else gEgo) (gTheIconBar curIcon:))
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

	(procedure (FindIcon hIcon y1 y2 &tmp thisIcon onMeEvent theY theX)
		(= theX
			(+ (/ (- (hIcon nsRight:) (hIcon nsLeft:)) 2) (hIcon nsLeft:))
		)
		(= theY y1)
		(while (>= (Abs (- theY y2)) 4)
			(if
				(= thisIcon
					(self
						firstTrue:
							#onMe
							((= onMeEvent (Event new:)) x: theX y: theY yourself:)
					)
				)
				(onMeEvent dispose:)
				(return thisIcon)
			)
			(onMeEvent dispose:)
			(if (< y1 y2)
				(+= theY 4)
			else
				(-= theY 4)
			)
		)
	)

	(method (doit &tmp temp0 temp1 temp2 [temp3 3] temp6 temp7 temp8)
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
			(GetEvent 32767 invEvent)
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
								(gGame setCursor: (curIcon cursor:) 1)
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
										(FindIcon
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
										(FindIcon
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
						(== temp2 16384)
						(= temp0 (self firstTrue: #onMe invEvent))
					)
					(cond
						((== (invEvent message:) 6)
							(if (and temp0 (temp0 helpStr:))
								(if (gSystemWindow respondsTo: #eraseOnly)
									(= temp6 (gSystemWindow eraseOnly:))
									(gSystemWindow eraseOnly: 1)
									(Printf 995 0 (temp0 helpStr:)) ; "%s"
									(gSystemWindow eraseOnly: temp6)
								else
									(Printf 995 0 (temp0 helpStr:)) ; "%s"
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
								(gGame setCursor: (curIcon cursor:) 1)
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
								(temp0
									doVerb:
										(curIcon message:)
										(self indexOf: curIcon)
								)
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
		)
		(if ((gTheIconBar curIcon:) cursor:)
			(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
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
		(gGame setCursor: (curIcon cursor:) 1)
	)
)

(instance invEvent of Event
	(properties)
)

