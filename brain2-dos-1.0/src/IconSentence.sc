;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 45)
(include sci.sh)
(use HandsOffScript)
(use Print)
(use System)

(procedure (localproc_0 param1 param2 &tmp [temp0 4])
	(TextSize @temp0 param1 param2 -1)
	(return (- [temp0 3] [temp0 1]))
)

(procedure (localproc_1 param1 param2 param3 &tmp [temp0 50] temp50 temp51 temp52 temp53)
	(= temp50 (/ param2 5))
	(= temp51 (StrLen param1))
	(while (< temp50 temp51)
		(if (== (StrAt param1 temp50) 32)
			(StrAt param1 temp50 0)
			(= temp53 (localproc_0 param1 param3))
			(StrAt param1 temp50 32)
			(if (> temp53 param2)
				(break)
			else
				(++ temp50)
			)
		else
			(++ temp50)
		)
	)
	(if (>= temp50 temp51)
		(return 0)
	else
		(while (and temp50 (!= (StrAt param1 (-- temp50)) 32))
		)
		(StrCpy @temp0 (+ param1 temp50))
		(return (localproc_0 @temp0 param3))
	)
)

(procedure (localproc_2 param1 param2 param3)
	(Memory memPOKE (+ param1 (* 2 param2)) param3)
)

(procedure (localproc_3 param1 param2 param3 param4 &tmp [temp0 4] temp4)
	(if (> (localproc_0 param1 param4) param3)
		(= temp4 (StrLen param1))
		(if (== param2 1)
			(while (> (localproc_0 param1 param4) param3)
				(while (and temp4 (!= (StrAt param1 (-- temp4)) 32))
				)
				(StrAt param1 temp4 0)
			)
		else
			(while (> (localproc_1 param1 param3 param4) param3)
				(while (and temp4 (!= (StrAt param1 (-- temp4)) 32))
				)
				(StrAt param1 temp4 0)
			)
		)
	)
)

(class IconSentence of Set
	(properties
		modNumber 0
		theNoun 0
		theVerb 0
		theCase 0
		theWidth 0
		theHeight 0
		whichSentence 0
		nsTop 0
		nsLeft 0
		theFont 999
		textColor 0
		wordCount 0
		fillColor 27
		lineHeight 8
		iconInstance 0
		wordsArray 0
		numWords 0
		numberOfLines 1
	)

	(method (init param1 param2 param3 param4 param5 param6)
		(= modNumber param1)
		(= theNoun param2)
		(= theVerb param3)
		(= theCase param4)
		(= whichSentence param5)
		(= theFont param6)
		(self getSentence:)
	)

	(method (getSentence &tmp temp0 [temp1 100] temp101 temp102 [temp103 100] temp203 temp204 temp205)
		(if (not iconInstance)
			(= iconInstance IconWord)
		)
		(Message msgGET modNumber theNoun theVerb theCase 1 @temp1)
		(= temp101 (StrLen @temp1))
		(= temp0 0)
		(while (< temp0 temp101)
			(if (<= 49 (= temp102 (StrAt @temp1 temp0)) 57)
				(self
					add:
						((= temp205 (iconInstance new:))
							parent: self
							value: (+ (* whichSentence 10) (- temp102 48))
							yourself:
						)
				)
				(localproc_2 wordsArray numWords temp205)
				(++ numWords)
				(++ wordCount)
				(++ temp0)
			else
				(= temp203 0)
				(while
					(and
						(< temp0 temp101)
						(not (<= 49 (= temp102 (StrAt @temp1 temp0)) 57))
					)
					(StrAt @temp103 temp203 temp102)
					(++ temp203)
					(++ temp0)
				)
				(StrAt @temp103 temp203 0)
				(if (== (++ temp203) 1)
					(Printf
						{theString: %s cntr: %d thelength: %d theChar value: %d theSentence :%s}
						@temp103
						temp0
						temp101
						temp102
						@temp1
					)
				)
				(= temp204 (Memory memALLOC_CRIT temp203))
				(StrCpy temp204 @temp103)
				(self add: ((someText new:) text: temp204 yourself:))
			)
		)
	)

	(method (showSentence &tmp [temp0 100] temp100 temp101 temp102 temp103 temp104)
		(= temp0 0)
		(for ((= temp100 (FirstNode elements))) temp100 ((= temp100 temp101))
			(= temp101 (NextNode temp100))
			(if (not (IsObject (= temp102 (NodeValue temp100))))
				(return)
			)
			(= temp104
				(if (IsObject temp101)
					(and
						(== (temp101 name:) {someText})
						(== (StrAt (temp101 text:) 0) 46)
					)
				)
			)
			(temp102 addOn: @temp0 temp104)
		)
		(localproc_3 @temp0 numberOfLines theWidth theFont)
		(Graph
			grFILL_BOX
			nsTop
			nsLeft
			(+ nsTop theHeight)
			(+ nsLeft theWidth 2)
			1
			fillColor
			-1
			-1
		)
		(Graph grUPDATE_BOX nsTop nsLeft (+ nsTop theHeight) (+ nsLeft theWidth 2) 1)
		(Display @temp0 dsCOORD nsLeft nsTop dsWIDTH theWidth dsFONT theFont dsCOLOR textColor)
	)

	(method (dispose &tmp [temp0 3])
		(self eachElementDo: #dispose)
		(super dispose: &rest)
	)
)

(class IconWord of CodeIcon
	(properties
		highlightColor 11
		parent 0
		textColor 50
		text 0
	)

	(method (addOn param1 param2 &tmp temp0 temp1 [temp2 20])
		(StrCpy @temp2 text)
		(if param2
			(StrCat @temp2 {.})
		)
		(= temp1
			(if text
				(localproc_0 @temp2 (parent theFont:))
			else
				12
			)
		)
		(cond
			(
				(<=
					(+ (= temp0 (localproc_0 param1 (parent theFont:))) temp1)
					(parent theWidth:)
				)
				(= nsLeft (+ (parent nsLeft:) temp0))
				(= nsTop (parent nsTop:))
			)
			((< temp0 (parent theWidth:))
				(= nsLeft (parent nsLeft:))
				(= nsTop (+ (parent nsTop:) (parent lineHeight:)))
			)
			(else
				(= nsLeft
					(if
						(= temp0
							(localproc_1
								param1
								(parent theWidth:)
								(parent theFont:)
							)
						)
						(- temp0 1)
					else
						(parent nsLeft:)
					)
				)
				(= nsTop (+ (parent nsTop:) (parent lineHeight:)))
			)
		)
		(if text
			(StrCat param1 text)
			(= nsRight (+ nsLeft temp1))
			(= nsBottom (+ nsTop (parent lineHeight:)))
		else
			(StrCat param1 {$$$})
		)
	)

	(method (show)
		(if text
			(Display text dsCOORD nsLeft nsTop dsFONT (parent theFont:) dsCOLOR textColor)
		else
			(super show: &rest)
		)
	)

	(method (highlight param1)
		(if text
			(Display
				text
				dsCOORD
				nsLeft
				nsTop
				dsFONT
				(parent theFont:)
				dsCOLOR
				(if param1 highlightColor else textColor)
			)
		else
			(super highlight: param1 &rest)
		)
	)
)

(class someText of Obj
	(properties
		text 0
	)

	(method (dispose)
		(Memory memFREE text)
		(super dispose: &rest)
	)

	(method (addOn param1)
		(StrCat param1 text)
	)
)

