;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 920)
(include sci.sh)
(use Main)
(use DButton)
(use Plane)
(use Array)
(use Print)
(use System)

(public
	Teller 0
)

(class TellerButton of DButton
	(properties
		font 30
		highlightColor 255
		lowlightColor 0
		gap 1
		minWidth 40
	)

	(method (setSize param1 &tmp temp0 temp1)
		(= temp1 (if argc param1 else 300))
		(= textLeft (= nsLeft (= nsTop 0)))
		(= textTop gap)
		(= temp0 (IntArray with: 0 0 0 0))
		(TextSize (temp0 data:) text font temp1)
		(= textRight (temp0 at: 2))
		(= textBottom (+ gap (temp0 at: 3)))
		(temp0 dispose:)
		(= nsRight (if (< textRight minWidth) minWidth else textRight))
		(= nsBottom textBottom)
	)

	(method (hilite param1 &tmp temp0)
		(= fore (if (and argc param1) highlightColor else lowlightColor))
		(if bitmap
			(DisposeTextBitmap bitmap)
			(= bitmap 0)
		)
		(self draw:)
		(UpdateScreenItem self)
	)
)

(class Teller of Obj
	(properties
		curNoun -1
		sayNoun -1
		verb 0
		actionVerb 11
		modNum 0
		topNoun 0
		stack 0
		curList 0
		client 0
		iconValue 0
		printMenu 0
		title 0
		plane 0
		back 0
		doGlobals 0
		numButtons 0
		addY 0
		menuColor 54
		selectColor 7
		globalColor 1
		globalHiColor 17
		titleColor 17
		finalColor 1
		finalHiColor 17
		menuFont 30
	)

	(method (init param1 param2 param3 param4 param5)
		(if (not modNum)
			(= modNum gCurRoomNum)
		)
		(if (and argc param1)
			((= client param1) actions: self)
		)
		(if (and (== curNoun -1) client)
			(= curNoun (client noun:))
		)
		(if (> argc 1)
			(= curNoun param2)
			(if (> argc 2)
				(= verb param3)
				(if (> argc 3)
					(= sayNoun param4)
					(if (> argc 4)
						(= modNum param5)
					)
				)
			)
		)
		(= stack (IntArray with: curNoun))
		(= topNoun curNoun)
		(= plane Plane)
	)

	(method (addTitle)
		(return 1)
	)

	(method (prep)
		(return 1)
	)

	(method (dispose)
		(if stack
			(stack dispose:)
			(= stack 0)
		)
		(if curList
			(curList dispose:)
			(= curList 0)
		)
		(if client
			(client actions: 0)
			(= client 0)
		)
		(super dispose:)
	)

	(method (doVerb theVerb &tmp temp0)
		(cond
			((== theVerb actionVerb)
				(SetCursor -2)
				(= temp0
					(gGame setCursor: ((ScriptID 0 1) view: 999 yourself:)) ; globeCursor
				)
				(while 1
					(if (self respond:)
						(break)
					)
				)
				(gGame setCursor: temp0)
				(SetCursor 0 0 319 155)
			)
			(client
				(client doVerb: theVerb)
			)
			(else
				(return 0)
			)
		)
		(return 1)
	)

	(method (respond &tmp temp0 temp1)
		(= iconValue 0)
		(self buildCaseList: showCases:)
		(curList dispose:)
		(= curList 0)
		(switch iconValue
			(0
				(return 0)
			)
			(-999
				(return 1)
			)
			(999
				((= temp1 (IntArray new: 0))
					copyToFrom: 0 stack 1 (- (stack size:) 1)
				)
				(stack copy: temp1)
				(temp1 dipose:)
				(= curNoun (stack at: 0))
				(return 0)
			)
		)
		(self prep:)
		(self sayMessage:)
		(if
			(and
				(Message msgSIZE modNum curNoun verb iconValue 2)
				(> (= temp0 (Message 4 modNum curNoun verb iconValue 2)) -1) ; msgREF_NOUN
			)
			(= curNoun temp0)
			(stack move: 1 0 (stack size:) at: 0 curNoun)
		)
		(return 1)
	)

	(method (sayMessage)
		(gMessager say: sayNoun verb iconValue 0 self modNum)
	)

	(method (buildCaseList &tmp temp0 temp1)
		(if curList
			(curList dispose:)
		)
		(= curList (IntArray new: 0))
		(for ((= temp0 0)) (< temp0 250) ((++ temp0))
			(if (Message msgSIZE modNum curNoun verb temp0 1)
				(curList at: (curList size:) temp0)
			)
		)
	)

	(method (showCases param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp5 150)
		(= temp1 (= addY (= numButtons 0)))
		((= printMenu (Print new:))
			classButton: TellerButton
			plane: plane
			font: menuFont
			back: back
		)
		(if title
			(self addTitle:)
		)
		(if doGlobals
			(self addGlobals:)
		)
		(= temp2 (IntArray new: 0))
		(for ((= temp1 0)) (< temp1 argc) ((+= temp1 2))
			(if (not [param1 (+ 1 temp1)])
				(temp2 at: (temp2 size:) [param1 temp1])
			)
		)
		(= temp1 (curList size:))
		(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
			(if (== -1 (temp2 indexOf: (= temp3 (curList at: temp0))))
				((printMenu addButton: temp3 curNoun verb temp3 1 0 addY modNum)
					fore: menuColor
					lowlightColor: menuColor
					highlightColor: selectColor
				)
				(++ numButtons)
				(+= addY 8)
			)
		)
		(temp2 dispose:)
		(if (not numButtons)
			(client doVerb: actionVerb)
			(printMenu dispose:)
			(return -999)
		)
		(self addFinalButton:)
		(self setPosition:)
		((printMenu dialog:) mouseHiliting: 1)
		(return (= iconValue (printMenu init:)))
	)

	(method (addGlobals)
		(return 1)
	)

	(method (setPosition)
		(return 1)
	)

	(method (addFinalButton)
		(return 1)
	)

	(method (cue))

	(method (newNoun param1)
		(if stack
			(stack dispose:)
		)
		(= stack (IntArray with: (= curNoun param1)))
	)

	(method (goTop)
		(if stack
			(stack dispose:)
		)
		(= stack (IntArray with: (= curNoun topNoun)))
	)
)

