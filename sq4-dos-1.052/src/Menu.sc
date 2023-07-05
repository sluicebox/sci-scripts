;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 997)
(include sci.sh)
(use Main)
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
		state 1
		cursor -1
		type 16384
		message -1
		modifiers 0
		signal 1
	)

	(method (maskView &tmp temp0)
		(= temp0 state)
		(&= state $fffa)
		(if (& temp0 $0001)
			(|= state $0004)
		)
		(if (& temp0 $0004)
			(|= state $0001)
		)
	)

	(method (right param1 param2 &tmp [temp0 7])
		(if argc
			(= nsRight (+ (= nsLeft param1) (CelWide view loop cel)))
			(= nsBottom (+ (= nsTop param2) (CelHigh view loop cel)))
		)
		(DrawCel view loop cel nsLeft nsTop -1)
	)

	(method (helpStr param1)
		(return
			(and
				(>= (param1 x:) nsLeft)
				(>= (param1 y:) nsTop)
				(<= (param1 x:) nsRight)
				(<= (param1 y:) nsBottom)
			)
		)
	)

	(method (setCursor param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp0 (+ nsTop 1))
		(= temp1 (+ nsLeft 1))
		(= temp2 (- nsBottom 2))
		(= temp3 (- nsRight 3))
		(Graph grDRAW_LINE temp0 temp1 temp0 temp3 param1 -1 -1)
		(Graph grDRAW_LINE temp0 temp3 temp2 temp3 param1 -1 -1)
		(Graph grDRAW_LINE temp2 temp3 temp2 temp1 param1 -1 -1)
		(Graph grDRAW_LINE temp2 temp1 temp0 temp1 param1 -1 -1)
		(Graph grUPDATE_BOX (- nsTop 2) (- nsLeft 2) (+ nsBottom 3) (+ nsRight 3) 1)
	)

	(method (enable param1 &tmp temp0 temp1 temp2)
		(if (and argc param1 (& signal $0001))
			(DrawCel view loop (= temp1 1) nsLeft nsTop -1)
			(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
			(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
				(temp0 localize:)
				(cond
					((self helpStr: temp0)
						(if (not temp1)
							(DrawCel view loop (= temp1 1) nsLeft nsTop -1)
							(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
						)
					)
					(temp1
						(DrawCel view loop (= temp1 0) nsLeft nsTop -1)
						(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					)
				)
				(temp0 dispose:)
			)
			(temp0 dispose:)
			(if (== temp1 1)
				(DrawCel view loop 0 nsLeft nsTop -1)
				(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
			)
			(return temp1)
		else
			(return 1)
		)
	)
)

(class IconBar of Set
	(properties
		state 1
		maskLoop 0
		underBits 0
		maskCel 0
		highlightColor 0
		lowlightColor 0
		show 0
		getDistToPt 0
		deletePt 0
		movePt 0
		port 0
		window 0
	)

	(method (handleEvent event &tmp temp0)
		(event localize:)
		(cond
			(
				(or
					(and
						(not (event type:))
						(< (event y:) maskLoop)
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
						highlight:
							gTheCursor
							1
							(+
								(lowlightColor nsLeft:)
								(/
									(-
										(lowlightColor nsRight:)
										(lowlightColor nsLeft:)
									)
									2
								)
							)
							(- (lowlightColor nsBottom:) 13)
					)
				)
				(= maskCel (event x:))
				(= highlightColor (event y:))
				(self right:)
			)
			((== (event type:) evMOUSEBUTTON)
				(cond
					((& (event modifiers:) emSHIFT)
						(self getDistToLine:)
						(event claimed: 1)
					)
					((& (event modifiers:) emCTRL)
						(self saveForUndo:)
						(event claimed: 1)
					)
					((IsObject lowlightColor)
						(event
							type: (lowlightColor type:)
							message: (lowlightColor message:)
						)
					)
				)
			)
		)
	)

	(method (right &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(gGame highlight: 999 1)
		(= maskLoop
			(CelHigh ((= temp0 (self at: 0)) view:) (temp0 loop:) (temp0 cel:))
		)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(= port (GetPort))
		(SetPort 0)
		(= underBits (Graph grSAVE_BOX 0 0 maskLoop 320 1))
		(= temp1 (PicNotValid))
		(PicNotValid 1)
		(= temp3 0)
		(= temp4 0)
		(for ((= temp5 (FirstNode elements))) temp5 ((= temp5 temp6))
			(= temp6 (NextNode temp5))
			(if (not (IsObject (= temp7 (NodeValue temp5))))
				(return)
			)
			(if (<= (temp7 nsRight:) 0)
				(temp7 right: temp3 temp4)
				(= temp3 (temp7 nsRight:))
			else
				(temp7 right:)
			)
		)
		(if deletePt
			(= temp3
				(+
					(/
						(-
							(- (movePt nsRight:) (movePt nsLeft:))
							(CelWide (deletePt view:) 1 (deletePt cel:))
						)
						2
					)
					(movePt nsLeft:)
				)
			)
			(= temp4
				(+
					(/
						(-
							(- (movePt nsBottom:) (movePt nsTop:))
							(CelHigh (deletePt view:) 1 (deletePt cel:))
						)
						2
					)
					(movePt nsTop:)
				)
			)
			(DrawCel (deletePt view:) 1 (deletePt cel:) temp3 temp4 -1)
		)
		(PicNotValid temp1)
		(Graph grUPDATE_BOX 0 0 maskLoop 320 1)
		(self setCursor: lowlightColor)
		(gGame
			highlight:
				gTheCursor
				(+
					(lowlightColor nsLeft:)
					(/ (- (lowlightColor nsLeft:) (lowlightColor nsRight:)) 2)
				)
		)
		(self doit:)
	)

	(method (clean)
		(Graph grFILL_BOX 0 0 10 320 1 0)
		(Graph grRESTORE_BOX underBits)
		(Graph grUPDATE_BOX 0 0 maskLoop 320 1)
		(SetPort port)
		(= maskLoop 0)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(while (= temp0 (Event new:))
			(temp0 localize:)
			(= temp2 (self firstTrue: #helpStr temp0))
			(switch (temp0 type:)
				(evNULL
					(cond
						((> (temp0 y:) maskLoop)
							(= highlightColor 0)
							(break)
						)
						((and temp2 (!= temp2 show))
							(= highlightColor 0)
							(self setCursor: temp2)
						)
					)
				)
				(evMOUSEBUTTON
					(if (and temp2 (self enable: temp2 1))
						(break)
					)
				)
				(evKEYBOARD
					(cond
						((== (= temp1 (temp0 message:)) KEY_ESCAPE)
							(break)
						)
						((== temp1 KEY_RETURN)
							(self enable: temp2)
							(break)
						)
						(
							(or
								(== temp1 KEY_LEFT)
								(and
									(== temp1 KEY_SHIFTTAB)
									(& (temp0 modifiers:) emSHIFT)
								)
							)
							(self advance:)
						)
						((or (== temp1 KEY_RIGHT) (== temp1 KEY_TAB))
							(self cycle:)
						)
					)
				)
			)
			(temp0 dispose:)
		)
		(if (IsObject temp0)
			(if (< highlightColor maskLoop)
				(= maskCel (temp0 x:))
				(= highlightColor (temp0 y:))
			)
			(temp0 dispose:)
		)
		(gGame highlight: (lowlightColor cursor:) 1 maskCel highlightColor)
		(self clean:)
	)

	(method (cycle &tmp temp0)
		(= temp0 (self at: (+ 1 (self indexOf: show))))
		(if (not (IsObject temp0))
			(= temp0 (NodeValue (self first:)))
		)
		(gGame
			highlight:
				gTheCursor
				1
				(+ (temp0 nsLeft:) (/ (- (temp0 nsRight:) (temp0 nsLeft:)) 2))
				(- (temp0 nsBottom:) 3)
		)
		(self setCursor: temp0)
	)

	(method (advance &tmp temp0)
		(= temp0 (self at: (- (self indexOf: show) 1)))
		(if (not (IsObject temp0))
			(= temp0 (NodeValue (self last:)))
		)
		(gGame
			highlight:
				gTheCursor
				1
				(+ (temp0 nsLeft:) (/ (- (temp0 nsRight:) (temp0 nsLeft:)) 2))
				(- (temp0 nsBottom:) 3)
		)
		(self setCursor: temp0)
	)

	(method (enable param1 param2)
		(return
			(if (param1 enable: (and (>= argc 2) param2))
				(if (not (& (param1 signal:) $0002))
					(= lowlightColor param1)
				)
				1
			)
		)
	)

	(method (setCursor param1 &tmp temp0)
		(if (IsObject show)
			(= temp0
				(if window
					(window back:)
				else
					5
				)
			)
			(show setCursor: temp0)
		)
		(= show param1)
		(= temp0 12)
		(param1 setCursor: 1)
	)

	(method (getDistToLine &tmp temp0)
		(= temp0 lowlightColor)
		(while
			(&
				((= temp0 (self at: (mod (+ (self indexOf: temp0) 1) size)))
					signal:
				)
				$0002
			)
		)
		(= lowlightColor temp0)
		(gGame highlight: (lowlightColor cursor:) 1)
	)

	(method (saveForUndo)
		(cond
			((!= lowlightColor (self at: 0))
				(= getDistToPt lowlightColor)
				(= lowlightColor (self at: 0))
			)
			(getDistToPt
				(= lowlightColor getDistToPt)
			)
		)
		(gGame highlight: (lowlightColor cursor:) 1)
	)
)

