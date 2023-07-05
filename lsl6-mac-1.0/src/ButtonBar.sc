;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 87)
(include sci.sh)
(use Main)
(use InvBar)
(use User)
(use System)

(public
	ButtonBar 0
)

(class BarIconI of Obj
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
		iconIndex 0
	)

	(method (show param1 param2 &tmp temp0 temp1)
		(SetPort 0 0 190 320 10 0)
		(|= signal $0020)
		(if argc
			(= nsRight (+ (= nsLeft param1) (= temp0 (CelWide view loop cel))))
			(= nsBottom (+ (= nsTop param2) (CelHigh view loop cel)))
		else
			(= nsRight (+ nsLeft (= temp0 (CelWide view loop cel))))
			(= nsBottom (+ nsTop (CelHigh view loop cel)))
		)
		(if
			(or
				(& signal $0004)
				(and (& (gTheIconBar state:) $0020) (& (gTheIconBar state:) $0004))
			)
			(self mask:)
		else
			(DrawCel view loop cel nsLeft nsTop -1 0)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
		(SetPort 0 0 139 320 10 0)
		(return temp0)
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

	(method (onMe param1)
		(return
			(and
				(>= (param1 x:) nsLeft)
				(>= (param1 y:) nsTop)
				(<= (param1 x:) nsRight)
				(<= (param1 y:) nsBottom)
			)
		)
	)

	(method (highlight param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (or (not (& signal $0020)) (== highlightColor -1))
			(return)
		)
		(= temp4 (if (and argc param1) highlightColor else lowlightColor))
		(= temp0 (+ nsTop 2))
		(= temp1 (+ nsLeft 2))
		(= temp2 (- nsBottom 3))
		(= temp3 (- nsRight 4))
		(Graph grDRAW_LINE temp0 temp1 temp0 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp0 temp3 temp2 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp3 temp2 temp1 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp1 temp0 temp1 temp4 -1 -1)
	)

	(method (select param1 &tmp temp0 temp1 temp2)
		(= temp1 0)
		(return
			(cond
				((& signal $0004) 0)
				((and argc param1 (& signal $0001))
					(SetPort 0 0 190 320 10 0)
					(DrawCel view loop (= temp1 1) nsLeft nsTop -1 0)
					(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
						(temp0 globalize:)
						(temp0 y: (- (temp0 y:) 10))
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
								)
							)
						)
						(temp0 dispose:)
					)
					(temp0 dispose:)
					(if (== temp1 1)
						(DrawCel view loop 0 nsLeft nsTop -1 0)
					)
					(SetPort 0)
					(SetPort 0 0 139 320 10 0)
					temp1
				)
				(else 1)
			)
		)
	)

	(procedure (localproc_0) ; UNUSED
		(SetPort 0 0 139 320 10 0)
	)

	(method (enable)
		(&= signal $fffb)
		(if (& (gTheIconBar state:) $0020)
			(self show:)
		)
	)

	(method (disable)
		(|= signal $0004)
		(if (& (gTheIconBar state:) $0020)
			(self show:)
		)
	)
)

(class ButtonBar of Set
	(properties
		nsLeft 0
		nsRight 0
		nsTop 0
		nsBottom 0
		state 0
		curIcon 0
		uBits 0
		highlightedIcon 0
		hiResPort 0
		walkIconItem 0
		prevIcon 0
		lastIcon 0
		arrowActive 0
	)

	(method (show &tmp temp0 temp1 temp2 temp3 temp4)
		(if (& state $0004)
			(return)
		)
		(|= state $0020)
		(= temp0 0)
		(for ((= temp1 (FirstNode elements))) temp1 ((= temp1 temp2))
			(= temp2 (NextNode temp1))
			(if (IsObject (= temp3 (NodeValue temp1)))
				(+= temp0 (temp3 show: (+ nsLeft temp0) nsTop))
			else
				(= temp2 0)
			)
		)
		(= nsRight (+ nsLeft temp0))
		(= nsBottom ((NodeValue (FirstNode elements)) nsBottom:))
		(SetPort 0 0 139 320 10 0)
	)

	(method (hide)
		(&= state $ffdf)
	)

	(method (onMe param1)
		(return (self firstTrue: #onMe param1))
	)

	(method (advance &tmp temp0 temp1)
		(for ((= temp1 1)) (<= temp1 size) ((= temp1 (mod (+ temp1 1) size)))
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

	(method (highlight param1)
		(if (not (& (param1 signal:) $0004))
			(= highlightedIcon param1)
		)
	)

	(method (advanceCurIcon &tmp temp0 temp1 temp2 temp3)
		(if (& state $0004)
			(return)
		)
		(= temp0 curIcon)
		(cond
			((== (self indexOf: temp0) (self indexOf: lastIcon))
				(if (= temp3 (gInventory curObj:))
					(self curIcon: temp3)
					(temp3 select:)
					(return)
				)
			)
			((not (temp0 isKindOf: BarIconI))
				(= temp0 lastIcon)
			)
		)
		(= temp1 0)
		(while
			(&
				((= temp0 (self at: (mod (+ (self indexOf: temp0) 1) size)))
					signal:
				)
				$0006
			)
			(if (> temp1 (+ 1 size))
				(return)
			else
				(++ temp1)
			)
		)
		(= curIcon temp0)
		(gGame setCursor: (curIcon cursor:) 1)
	)

	(method (retreat &tmp temp0 temp1)
		(for ((= temp1 1)) (<= temp1 size) ((= temp1 (mod (+ temp1 1) size)))
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

	(method (select param1 param2)
		(return
			(if (param1 select: (and (>= argc 2) param2))
				(if (not (& (param1 signal:) $0002))
					(= curIcon param1)
				)
				(if (not (gGame isHandsOff:))
					(gGame setCursor: (curIcon cursor:) 1)
				)
				1
			)
		)
	)

	(method (findIcon param1 &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(= temp1 (self at: temp0))
			(if (== (temp1 message:) param1)
				(return temp1)
			)
		)
		(return 0)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(= temp0 (event type:))
		(event globalize:)
		(event y: (- (event y:) 10))
		(= temp1 (self onMe: event))
		(cond
			((& state $0004))
			(
				(or
					(& temp0 evMOUSEBUTTON)
					(and (& temp0 evKEYBOARD) (== (event message:) KEY_RETURN))
				)
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
					((event modifiers:) 0)
					(
						(and
							temp1
							(or
								(!= temp1 (ScriptID 0 8)) ; icon5
								(and
									(== temp1 (ScriptID 0 8)) ; icon5
									(not (& ((ScriptID 0 8) signal:) $0004)) ; icon5
								)
							)
						)
						(if (self select: temp1 (& temp0 evMOUSEBUTTON))
							(temp1 doit:)
						)
						(event claimed: 1)
					)
					(
						(and
							(> (event y:) 152)
							(!= curIcon (ScriptID 0 3)) ; icon0
							(gGame controlsVisible:)
						)
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
		(if (and (not (event claimed:)) (User canInput:))
			(cond
				(
					(and
						temp1
						(or
							(!= temp1 (ScriptID 0 8)) ; icon5
							(and
								(== temp1 (ScriptID 0 8)) ; icon5
								(not (& ((ScriptID 0 8) signal:) $0004)) ; icon5
							)
						)
					)
					(if (not arrowActive)
						(gGame setCursor: gNormalCursor)
						(= arrowActive 1)
					)
				)
				(arrowActive
					(gGame setCursor: (curIcon cursor:))
					(= arrowActive 0)
				)
			)
		)
	)

	(method (disable param1 &tmp temp0 temp1)
		(if argc
			(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
				(= temp1
					(if (IsObject [param1 temp0])
						[param1 temp0]
					else
						(self at: [param1 temp0])
					)
				)
				(temp1 disable:)
				(Platform 0 4 3 (temp1 iconIndex:))
				(cond
					((== temp1 curIcon)
						(self advanceCurIcon:)
					)
					((== temp1 highlightedIcon)
						(self advance:)
					)
				)
			)
		else
			(|= state $0004)
			(if (& state $0020)
				(gTheIconBar show:)
			)
			(Platform 0 4 3 -1)
		)
	)

	(method (enable param1 &tmp temp0 temp1)
		(if argc
			(Platform 0 4 2 -1)
			(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
				(= temp1
					(if (IsObject [param1 temp0])
						[param1 temp0]
					else
						(self at: [param1 temp0])
					)
				)
				(temp1 enable:)
				(Platform 0 4 2 (temp1 iconIndex:))
			)
		else
			(&= state $fffb)
			(if (& state $0020)
				(gTheIconBar show:)
			)
			(Platform 0 4 2 -1)
		)
	)

	(method (swapCurIcon &tmp temp0)
		(cond
			(
				(or
					(& state $0004)
					(and
						(= temp0 (NodeValue (self first:)))
						(!= temp0 walkIconItem)
					)
				)
				(return)
			)
			(
				(and
					(!= curIcon (= temp0 (NodeValue (self first:))))
					(not (& (temp0 signal:) $0004))
				)
				(= prevIcon curIcon)
				(= curIcon (NodeValue (self first:)))
			)
			(
				(and
					prevIcon
					(not (& (prevIcon signal:) $0004))
					(or
						(not (prevIcon isKindOf: BarInvI))
						(and
							(prevIcon isKindOf: BarInvI)
							(gEgo has: (gInventory indexOf: prevIcon))
						)
					)
				)
				(= curIcon prevIcon)
			)
		)
		(gGame setCursor: (curIcon cursor:) 1)
	)
)

