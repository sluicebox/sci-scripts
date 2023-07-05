;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 51)
(include sci.sh)
(use Main)
(use n013)
(use Teller)
(use Array)
(use Print)
(use Actor)
(use System)

(public
	GKTeller 0
	Interrogation 1
)

(class GKTeller of Teller
	(properties)

	(method (setPosition &tmp temp0)
		(= temp0
			(if (< (= temp0 (- 189 (* 10 numButtons))) 148) temp0 else 148)
		)
		(printMenu x: 5 y: (+ 10 temp0))
	)
)

(class Interrogation of Teller
	(properties
		sayNoun 7
		modNum 50
		title 1
		doGlobals 1
		selectColor 17
		color 0
		index 0
		transcript 0
		personals 0
		personalIndex 0
		curTopic -1
		view 0
		loop 0
		cel 0
		left 222
		top 85
		newCol 23
	)

	(method (init)
		(super init:)
		(self setPersonals:)
		(if view
			((= view (View new:)) view: view x: left y: top setPri: 14 init:)
		)
		(if (not (global176 at: index))
			(self makeStruct:)
		)
		(self getTranscript:)
		(return self)
	)

	(method (setPersonals)
		(Prints {Hey, some dummy forgot to redefine setPersonals})
	)

	(method (doVerb)
		(while 1
			(if (self respond:)
				(break)
			)
		)
		(if (or (not iconValue) (== iconValue -999))
			(gCurRoom cue:)
		)
	)

	(method (addGlobals &tmp temp0 temp1)
		(if (== topNoun curNoun)
			(for ((= temp1 1)) (<= temp1 15) ((++ temp1))
				(if (IsFlag (+ temp1 36))
					(= temp0
						(if (IsFlag (+ temp1 79)) globalColor else newCol)
					)
					((printMenu addButton: temp1 3 0 temp1 1 0 addY modNum)
						fore: temp0
						lowlightColor: temp0
						highlightColor: globalHiColor
					)
					(++ numButtons)
					(+= addY 8)
				)
			)
			(= menuColor color)
		else
			(= menuColor globalColor)
		)
	)

	(method (addTitle)
		(if (== curNoun topNoun)
			((printMenu addText: 0 0 title 1 0 addY 920) fore: titleColor)
			(+= addY 8)
		)
	)

	(method (addFinalButton)
		(if (== curNoun topNoun)
			((printMenu addButton: -999 0 0 3 1 0 addY 920)
				value: -999
				fore: finalColor
				lowlightColor: finalColor
				highlightColor: finalHiColor
			)
			(++ numButtons)
			(+= addY 8)
		)
	)

	(method (prep &tmp temp0 temp1)
		(if (< 0 iconValue 16)
			(SetFlag (+ 79 iconValue))
		)
		(if (== topNoun curNoun)
			(= curTopic
				(cond
					((<= 1 iconValue 15) iconValue)
					(
						(and
							(!= -1 (= temp1 (personals indexOf: iconValue)))
							(= temp0 (personalIndex at: temp1))
						)
						(+ temp0 15)
					)
					(else 0)
				)
			)
		)
	)

	(method (sayMessage &tmp temp0 temp1)
		(if
			(and
				curTopic
				(!= (= temp0 (Message msgGET modNum sayNoun verb iconValue 1 0)) 47)
				(!= temp0 3)
			)
			(= temp0 (transcript at: 0))
			(= temp1 curTopic)
			(temp0 at: 0 (+ 1 (temp0 at: 0)))
			(temp0 at: temp1 (+ 1 (temp0 at: temp1)))
			(= temp1 ((= temp0 (transcript at: curTopic)) size:))
			(temp0 at: temp1 iconValue)
		)
		(gMessager say: sayNoun verb iconValue 0 self modNum)
	)

	(method (cue)
		(self doVerb:)
	)

	(method (setPosition)
		(if (!= curNoun topNoun)
			(printMenu x: 100 y: 10)
		)
	)

	(method (getTranscript &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp1 (global176 at: index))
		(= transcript (List new:))
		(= temp3 (temp1 at: 0))
		(for ((= temp0 0)) (<= temp0 temp3) ((++ temp0))
			(transcript add: (IntArray new: 0))
		)
		(= temp2 (transcript at: 0))
		(temp2 at: 0 0)
		(= temp4 (+ 1 temp3))
		(for ((= temp0 1)) (<= temp0 temp3) ((++ temp0))
			(temp2 at: temp0 (= temp5 (temp1 at: temp0)))
			((transcript at: temp0) copyToFrom: 0 temp1 temp4 temp5)
			(+= temp4 temp5)
		)
		(temp2 at: 0 temp4)
	)

	(method (putTranscript &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp3 (transcript at: 0))
		(= temp1 (IntArray new: (temp3 at: 0)))
		(= temp2 (global176 at: index))
		(= temp4 (temp2 at: 0))
		(temp1 at: 0 temp4)
		(= temp5 (+ 1 temp4))
		(= temp0 1)
		(while (<= temp0 temp4)
			(temp1 at: temp0 (= temp6 (temp3 at: temp0)))
			(temp1 copyToFrom: temp5 (transcript at: temp0) 0 temp6)
			(++ temp0)
			(+= temp5 temp6)
		)
		(global176 at: index temp1)
		(temp2 dispose:)
		(transcript dispose:)
		(= transcript 0)
	)

	(method (makeStruct &tmp temp0 temp1 temp2)
		(for ((= temp0 (= temp1 0))) (< temp0 (personals size:)) ((++ temp0))
			(if (> (= temp2 (personalIndex at: temp0)) temp1)
				(= temp1 temp2)
			)
		)
		(+= temp1 15)
		(global176 at: index (= temp2 (IntArray new: (+ temp1 1))))
		(temp2 at: 0 temp1)
	)

	(method (dispose &tmp temp0)
		(self putTranscript:)
		(personals dispose:)
		(= personals 0)
		(personalIndex dispose:)
		(= personalIndex 0)
		(if view
			(= temp0 (view view:))
			(view dispose:)
			(= view temp0)
		)
		(super dispose:)
	)
)

