;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 98)
(include sci.sh)
(use Main)
(use IconBar)
(use Tutorial)
(use System)

(local
	local0
)

(class Kq6IconBar of IconBar
	(properties
		activateHeight 10
		hiRes 0
	)

	(method (hide &tmp temp0 temp1 temp2)
		(if (& state $0020)
			(gSounds pause: 0)
			(&= state $ffdf)
			(for ((= temp0 (FirstNode elements))) temp0 ((= temp0 temp1))
				(= temp1 (NextNode temp0))
				(if (not (IsObject (= temp2 (NodeValue temp0))))
					(return)
				)
				((= temp2 (NodeValue temp0))
					signal: (& (temp2 signal:) $ffdf)
					view: local0
					maskView: local0
					hiRes: 0
				)
			)
			(if
				(and
					(not (& state $0800))
					helpIconItem
					(& (helpIconItem signal:) $0010)
				)
				(helpIconItem signal: (& (helpIconItem signal:) $ffef))
			)
			(Graph grRESTORE_BOX underBits)
			(Graph grUPDATE_BOX y 0 (+ y height) 320 1)
			(Graph grREDRAW_BOX y 0 (+ y height) 320)
			(SetPort port)
			(= hiRes 0)
			(= height activateHeight)
		)
	)

	(method (show &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(gSounds pause:)
		(|= state $0020)
		(gGame setCursor: 999 1)
		(= temp0 (self at: 0))
		(= local0 (temp0 view:))
		(= hiRes
			(if (and global169 (not (Platform 5)))
				(Platform 6)
			)
		)
		(if hiRes
			(temp0 view: (temp0 hrView:))
		else
			(temp0 view: (temp0 view:))
		)
		(= height (CelHigh (temp0 view:) (temp0 loop:) (temp0 cel:)))
		(= port (GetPort))
		(SetPort -1)
		(if hiRes
			(/= height 2)
			(= underBits (Graph 15 y 0 (+ y height) 319))
		else
			(= underBits (Graph grSAVE_BOX y 0 (+ y height) 320 1))
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
			(if hiRes
				(temp7
					maskView: (temp0 hrView:)
					view: (temp0 hrView:)
					nsRight: 0
				)
			else
				(temp7
					maskView: (temp0 maskView:)
					view: (temp0 view:)
					nsRight: 0
				)
			)
			(if (<= (temp7 nsRight:) 0)
				(temp7 show: temp3 temp4)
				(= temp3 (temp7 nsRight:))
			else
				(temp7 show:)
			)
		)
		(self updateInvIcon:)
		(PicNotValid temp1)
		(Graph
			grUPDATE_BOX
			y
			0
			(* height (if hiRes 2 else 1))
			639
			1
			(if hiRes underBits else 0)
		)
		(self highlight: curIcon)
	)

	(method (advance &tmp temp0 temp1)
		(for ((= temp1 1)) (<= temp1 size) ((++ temp1))
			(= temp0
				(self at: (mod (+ temp1 (self indexOf: highlightedIcon)) size))
			)
			(if (not (IsObject temp0))
				(= temp0 (NodeValue (self first:)))
			)
			(breakif (not (& (temp0 signal:) $0004)))
		)
		(self highlight: temp0 (& state $0020))
	)

	(method (retreat &tmp temp0 temp1)
		(for ((= temp1 1)) (<= temp1 size) ((++ temp1))
			(= temp0
				(self at: (mod (- (self indexOf: highlightedIcon) temp1) size))
			)
			(if (not (IsObject temp0))
				(= temp0 (NodeValue (self last:)))
			)
			(breakif (not (& (temp0 signal:) $0004)))
		)
		(self highlight: temp0 (& state $0020))
	)

	(method (updateInvIcon &tmp temp0 temp1)
		(if (and curInvIcon (not (& (useIconItem state:) $0004)))
			(curInvIcon view: (if hiRes 973 else 970))
			(if (gEgo has: (gInventory indexOf: curInvIcon))
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
				(DrawCel
					(curInvIcon view:)
					(curInvIcon loop:)
					(curInvIcon cel:)
					temp0
					temp1
					-1
					0
					(if hiRes underBits else 0)
				)
				(if (& (useIconItem signal:) $0004)
					(useIconItem mask:)
				)
			else
				(= curInvIcon 0)
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
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
				(= temp4 gTheCursor)
				(= temp5 curIcon)
				(= temp6 curInvIcon)
				(self show:)
				(gGame setCursor: 999)
				(if temp0
					(gGame
						setCursor:
							gTheCursor
							1
							(+
								(curIcon nsLeft:)
								(/
									(- (curIcon nsRight:) (curIcon nsLeft:))
									(if hiRes 4 else 2)
								)
							)
							(if (not hiRes)
								(- (curIcon nsBottom:) 3)
							else
								(-
									(+
										(curIcon nsTop:)
										(CelHigh
											(curIcon view:)
											(curIcon loop:)
											(curIcon cel:)
										)
									)
									3
								)
							)
					)
				)
				(self doit:)
				(= temp3
					(if (or (gUser canControl:) (gUser canInput:))
						(curIcon cursor:)
					else
						gWaitCursor
					)
				)
				(if temp0
					(gGame setCursor: temp3 1 oldMouseX oldMouseY)
				else
					(gGame setCursor: temp3 1)
				)
				(self hide:)
			)
			((& temp1 evKEYBOARD)
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
)

(class Kq6IconItem of IconI
	(properties
		hiRes 0
		hrView 981
	)

	(method (highlight param1 &tmp temp0 temp1 temp2 temp3 temp4 [temp5 2])
		(if (or (not (& signal $0020)) (== highlightColor -1) hiRes)
			(return)
		)
		(if (and argc param1)
			(= temp4 highlightColor)
			(= temp0 (+ nsTop 1))
			(= temp1 (+ nsLeft 1))
			(= temp2 (- nsBottom 3))
			(= temp3 (- nsRight 3))
			(Graph grDRAW_LINE temp0 temp1 temp0 temp3 temp4 -1 -1)
			(Graph grDRAW_LINE temp0 temp3 temp2 temp3 temp4 -1 -1)
			(Graph grDRAW_LINE temp2 temp3 temp2 temp1 temp4 -1 -1)
			(Graph grDRAW_LINE temp2 temp1 temp0 temp1 temp4 -1 -1)
		else
			(self show:)
			(if (Kq6IconBar curInvIcon:)
				(Kq6IconBar updateInvIcon:)
			)
		)
		(Graph grUPDATE_BOX (- nsTop 2) (- nsLeft 2) nsBottom (+ nsRight 3) 1)
	)

	(method (onMe param1)
		(return
			(and
				(>=
					(param1 x:)
					(if hiRes
						(/ nsLeft 2)
					else
						nsLeft
					)
				)
				(>=
					(param1 y:)
					(if hiRes
						(/ nsTop 2)
					else
						nsTop
					)
				)
				(<=
					(param1 x:)
					(if hiRes
						(/ nsRight 2)
					else
						nsRight
					)
				)
				(<=
					(param1 y:)
					(if hiRes
						(/ nsBottom 2)
					else
						nsBottom
					)
				)
			)
		)
	)

	(method (select param1 &tmp temp0 temp1 temp2 temp3)
		(if hiRes
			(= temp3 (gTheIconBar underBits:))
		else
			(= temp3 0)
		)
		(return
			(cond
				((& signal $0004) 0)
				((and argc param1 (& signal $0001))
					(DrawCel view loop (= temp1 1) nsLeft nsTop -1 0 temp3)
					(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1 temp3)
					(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
						(temp0 localize:)
						(cond
							((self onMe: temp0)
								(if (not temp1)
									(DrawCel
										view
										loop
										(= temp1 1)
										nsLeft
										nsTop
										-1
										0
										temp3
									)
									(Graph
										grUPDATE_BOX
										nsTop
										nsLeft
										nsBottom
										nsRight
										1
										temp3
									)
								)
							)
							(temp1
								(DrawCel
									view
									loop
									(= temp1 0)
									nsLeft
									nsTop
									-1
									0
									temp3
								)
								(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1 temp3)
							)
						)
						(temp0 dispose:)
					)
					(temp0 dispose:)
					(if (== temp1 1)
						(DrawCel view loop 0 nsLeft nsTop -1 0 temp3)
						(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1 temp3)
					)
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
			0
			(if hiRes
				(gTheIconBar underBits:)
			else
				0
			)
		)
	)

	(method (show param1 param2 &tmp [temp0 7])
		(= hiRes
			(if (and global169 (not (Platform 5)))
				(Platform 6)
			)
		)
		(|= signal $0020)
		(if argc
			(= nsRight (+ (= nsLeft param1) (CelWide view loop cel)))
			(= nsBottom (+ (= nsTop param2) (CelHigh view loop cel)))
		else
			(= nsRight (+ nsLeft (CelWide view loop cel)))
			(= nsBottom (+ nsTop (CelHigh view loop cel)))
		)
		(DrawCel
			view
			loop
			cel
			nsLeft
			nsTop
			-1
			0
			(if hiRes
				(gTheIconBar underBits:)
			else
				0
			)
		)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)
)

