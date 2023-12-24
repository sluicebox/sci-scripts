;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use dummyClient)
(use IconBar)
(use Sound)
(use System)

(class HandsOffScript of Script
	(properties
		oldIllBits 0
		saveIgnrAct 0
	)

	(method (init)
		(HandsOff)
		(= oldIllBits (gEgo illegalBits:))
		(= saveIgnrAct (& (gEgo signal:) $4000))
		(gEgo illegalBits: 0 ignoreActors: 1)
		(super init: &rest)
	)

	(method (dispose)
		(HandsOn)
		(gEgo illegalBits: oldIllBits ignoreActors: saveIgnrAct)
		(super dispose:)
	)
)

(class CodeIcon of IconI
	(properties
		cel 2
		signal 129
		highlightColor 255
		value 0
		downClick 104
		upClick 207
		upClickOff 236
	)

	(method (show param1 param2 &tmp temp0)
		(|= signal $0020)
		(if (and argc (== argc 1))
			(= temp0 param1)
		else
			(= temp0 cel)
		)
		(if (and argc (> argc 1))
			(= nsRight (+ (= nsLeft param1) (CelWide view loop cel)))
			(= nsBottom (+ (= nsTop param2) (CelHigh view loop cel)))
		else
			(= nsRight (+ nsLeft (CelWide view loop cel)))
			(= nsBottom (+ nsTop (CelHigh view loop cel)))
		)
		(DrawCel view loop temp0 nsLeft nsTop -1)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0 [temp1 10])
		(= temp0 (if argc param1))
		(cond
			((not (& signal $0020)) 0)
			((& signal $2000)
				(super highlight: temp0 &rest)
			)
			(else
				(self show: (if temp0 0 else 2))
			)
		)
	)

	(method (select param1 &tmp temp0 temp1)
		(return
			(cond
				((& signal $0004) 0)
				((and argc param1 (& signal $0001))
					(if downClick
						(click number: downClick play:)
					)
					(self show: (= temp1 1))
					(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
						(temp0 localize:)
						(cond
							((self onMe: temp0)
								(if (not temp1)
									(self show: (= temp1 1))
								)
							)
							(temp1
								(self show: (= temp1 0))
							)
						)
						(temp0 dispose:)
					)
					(temp0 dispose:)
					(cond
						((== temp1 1)
							(if upClick
								(click number: upClick play:)
							)
							(self show: 0)
						)
						(upClickOff
							(click number: upClickOff play:)
						)
					)
					temp1
				)
				(else 1)
			)
		)
	)
)

(class TextIcon of CodeIcon
	(properties
		highlightColor 7
		lowlightColor 3
		text 0
		textColor 50
	)

	(method (show)
		(super show: &rest)
		(self showText: textColor)
	)

	(method (showText param1)
		(proc5_8 text param1 (+ nsLeft 1) (+ nsTop 2))
	)

	(method (highlight)
		(super highlight: &rest)
		(self showText: textColor)
	)

	(method (select param1 &tmp temp0 temp1)
		(return
			(cond
				((& signal $0004) 0)
				((and argc param1 (& signal $0001))
					(if downClick
						(click number: downClick play:)
					)
					(DrawCel view loop (= temp1 1) nsLeft nsTop -1)
					(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					(self showText: (- textColor 2))
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
									)
									(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
									(self showText: (- textColor 2))
								)
							)
							(temp1
								(DrawCel view loop (= temp1 0) nsLeft nsTop -1)
								(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
								(self showText: textColor)
							)
						)
						(temp0 dispose:)
					)
					(temp0 dispose:)
					(cond
						((== temp1 1)
							(if upClick
								(click number: upClick play:)
							)
							(DrawCel view loop 0 nsLeft nsTop -1)
							(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
							(self showText: textColor)
						)
						(upClickOff
							(click number: upClickOff play:)
						)
					)
					temp1
				)
				(else 1)
			)
		)
	)
)

(class LineBox of Obj
	(properties
		underLine1 0
		underLine2 0
		underLine3 0
		underLine4 0
		top 0
		left 0
		bottom 0
		right 0
	)

	(method (dispose)
		(self eraseBox:)
		(super dispose:)
	)

	(method (eraseBox)
		(if underLine1
			(Graph grRESTORE_BOX underLine4)
			(Graph grRESTORE_BOX underLine3)
			(Graph grRESTORE_BOX underLine2)
			(Graph grRESTORE_BOX underLine1)
			(Graph grUPDATE_BOX (- top 1) (- left 1) (+ bottom 2) (+ right 2) 1)
			(= underLine1 0)
		)
	)

	(method (drawBox param1 param2 param3 param4 param5 param6 &tmp temp0 temp1)
		(self eraseBox:)
		(= top param1)
		(= left param2)
		(= bottom param3)
		(= right param4)
		(= temp0 0)
		(= temp1 255)
		(if (> argc 4)
			(= temp0 param5)
			(if (> argc 5)
				(= temp1 param6)
			)
		)
		(= underLine1 (Graph grSAVE_BOX (- top 2) (- left 2) (+ top 2) (+ right 2) 1))
		(= underLine2
			(Graph grSAVE_BOX (- top 2) (- right 2) (+ bottom 2) (+ right 2) 1)
		)
		(= underLine3
			(Graph grSAVE_BOX (- bottom 2) (- left 2) (+ bottom 2) (+ right 2) 1)
		)
		(= underLine4 (Graph grSAVE_BOX (- top 2) (- left 2) (+ bottom 2) (+ left 2) 1))
		(Graph grDRAW_LINE top left top right temp0 -1 -1)
		(Graph grDRAW_LINE top right bottom right temp0 -1 -1)
		(Graph grDRAW_LINE bottom left bottom right temp0 -1 -1)
		(Graph grDRAW_LINE top left bottom left temp0 -1 -1)
		(if (!= param6 -1)
			(Graph grDRAW_LINE (- top 1) (- left 1) (- top 1) (+ right 1) temp1 -1 -1)
			(Graph grDRAW_LINE (- top 1) (+ right 1) (+ bottom 1) (+ right 1) temp1 -1 -1)
			(Graph
				grDRAW_LINE
				(+ bottom 1)
				(- left 1)
				(+ bottom 1)
				(+ right 1)
				temp1
				-1
				-1
			)
			(Graph grDRAW_LINE (- top 1) (- left 1) (+ bottom 1) (- left 1) temp1 -1 -1)
		)
		(Graph grUPDATE_BOX (- top 2) (- left 2) (+ bottom 2) (+ right 2) 1)
	)
)

(instance click of Sound
	(properties
		flags 1
	)
)

