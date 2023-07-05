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
			(2 ; Look
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
		(if (and value (= id gEgo))
			(gGame changeScore: value)
			(= value 0)
		)
		(return self)
	)
)

(class Inv of IconBar
	(properties
		normalHeading {Graham is carrying:}
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
			(return)
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
		(self show: (if argc whom else gEgo) doit:)
	)

	(method (show who)
		(|= state $0020)
		(DrawInvWindow (if argc who else gEgo) (gTheIconBar curIcon:))
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
							(mod nextIcon size)
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
		(while (= temp1 (Event new:))
			(if (& state $0020)
				(= temp8 0)
				(temp1 localize:)
				(if
					(and
						curIcon
						(not (temp1 modifiers:))
						(!= curIcon selectIcon)
						(or
							(== (temp1 type:) evMOUSEBUTTON)
							(and
								(== (temp1 type:) evKEYBOARD)
								(== (temp1 message:) KEY_RETURN)
								(= temp8 1)
							)
							(and (== (temp1 type:) evJOYDOWN) (= temp8 1))
						)
						(or
							(!= curIcon helpIconItem)
							(& (helpIconItem signal:) $0010)
						)
					)
					(temp1 type: evVERB message: (curIcon message:))
				)
				(MapKeyToDir temp1)
				(cond
					((and (== (= temp2 (temp1 type:)) evMOUSEBUTTON) (temp1 modifiers:))
						(self advanceCurIcon:)
						(temp1 claimed: 1)
					)
					(
						(and
							(== temp2 evNULL)
							(= temp0 (self firstTrue: #onMe temp1))
							(!= temp0 highlightedIcon)
						)
						(self highlight: temp0)
					)
					(
						(or
							(== temp2 evMOUSEBUTTON)
							(and (== temp2 evKEYBOARD) (== (temp1 message:) KEY_RETURN))
							(== temp2 evJOYDOWN)
						)
						(if
							(and
								(IsObject highlightedIcon)
								(self select: highlightedIcon (== temp2 evMOUSEBUTTON))
							)
							(cond
								((== highlightedIcon okButton)
									(break)
								)
								((== highlightedIcon helpIconItem)
									(if (& state $0800)
										(self noClickHelp:)
									else
										(if (!= (highlightedIcon cursor:) -1)
											(gGame
												setCursor:
													(helpIconItem cursor:)
											)
										)
										(if helpIconItem
											(helpIconItem
												signal:
													(|
														(helpIconItem signal:)
														$0010
													)
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
					((& temp2 $0040) ; direction
						(switch (temp1 message:)
							(JOY_RIGHT
								(self advance:)
							)
							(JOY_LEFT
								(self retreat:)
							)
							(JOY_UP
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
							(JOY_DOWN
								(if
									(and
										highlightedIcon
										(= temp0
											(FindIcon
												highlightedIcon
												(+
													(highlightedIcon nsBottom:)
													1
												)
												(window bottom:)
											)
										)
									)
									(self highlight: temp0 1)
								else
									(self advance:)
								)
							)
							(JOY_NULL
								(if (& temp2 evKEYBOARD)
									(self advanceCurIcon:)
								)
							)
						)
					)
					((== temp2 evKEYBOARD)
						(switch (temp1 message:)
							(KEY_TAB
								(self advance:)
							)
							(KEY_SHIFTTAB
								(self retreat:)
							)
						)
					)
					(
						(and
							(== temp2 evVERB)
							(= temp0 (self firstTrue: #onMe temp1))
						)
						(= temp7 (GetPort))
						(cond
							((== (temp1 message:) JOY_DOWNLEFT)
								(if (and temp0 (temp0 helpStr:))
									(= temp6 (gSystemWindow eraseOnly:))
									(gSystemWindow eraseOnly: 1)
									(if (temp0 helpModule:)
										(Print
											(temp0 helpModule:)
											(temp0 helpStr:)
										)
									else
										(Printf 995 0 (temp0 helpStr:)) ; "%s"
									)
									(gSystemWindow eraseOnly: temp6)
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
									(temp0 doVerb: (temp1 message:))
								)
								(if (gSystemWindow respondsTo: #eraseOnly)
									(gSystemWindow eraseOnly: temp6)
								)
							)
						)
						(SetPort temp7)
					)
				)
			else
				(break)
			)
			(temp1 dispose:)
		)
		(temp1 dispose:)
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
		(if (== curIcon helpIconItem)
			(helpIconItem signal: (| (helpIconItem signal:) $0010))
		else
			(helpIconItem signal: (& (helpIconItem signal:) $ffef))
		)
		(gGame setCursor: (curIcon cursor:) 1)
	)
)

