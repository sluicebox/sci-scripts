;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2)
(include sci.sh)
(use Main)
(use TransPlane)
(use DText)
(use Str)
(use Array)
(use IconBar)
(use Cursor)
(use User)
(use System)

(local
	[local0 2]
	local2
)

(class TellerIcon of IconI
	(properties
		nsTop 15
		priority 300
		fixPriority 1
		view 983
		signal 257
		highlightColor 13
		lowlightColor 22
		myHandle 0
		value 0
		myTeller 0
		text1 0
		text2 0
		text3 0
	)

	(method (dispose)
		(myHandle dispose:)
		((myTeller tellCast:) delete: self)
		(DeleteScreenItem self)
		(= myHandle 0)
		(if text1
			(text1 dispose:)
			(= text1 0)
		)
		(if text2
			(text2 dispose:)
			(= text2 0)
		)
		(if text2
			(text2 dispose:)
			(= text2 0)
		)
		(DisposeClone self)
	)

	(method (init &tmp temp0)
		(&= signal $fff7)
		((myTeller tellCast:) add: self)
		(= plane ((myTeller theControls:) plane:))
		(= nsRight (+ nsLeft (CelWide view loop cel)))
		(= nsBottom (+ nsTop (CelHigh view loop cel)))
		(AddScreenItem self)
	)

	(method (onMe param1)
		(return
			(and (< nsLeft (param1 x:) nsRight) (< nsTop (param1 y:) nsBottom))
		)
	)

	(method (select param1 &tmp temp0 temp1 temp2)
		(if
			(if (and argc param1 (& signal $0001))
				(= cel (= temp1 1))
				(text2 setPri: 240)
				(text3 setPri: 254)
				(UpdateScreenItem text2)
				(UpdateScreenItem text3)
				(UpdateScreenItem self)
				(FrameOut)
				(while (!= ((= temp0 ((gUser curEvent:) new:)) type:) 2)
					(temp0 localize: plane)
					(cond
						((self onMe: temp0)
							(if (not temp1)
								(= cel (= temp1 1))
								(text2 setPri: 240)
								(text3 setPri: 254)
								(UpdateScreenItem text2)
								(UpdateScreenItem text3)
								(UpdateScreenItem self)
								(FrameOut)
							)
						)
						(temp1
							(= cel (= temp1 0))
							(text2 setPri: 254)
							(text3 setPri: 240)
							(UpdateScreenItem text3)
							(UpdateScreenItem text2)
							(UpdateScreenItem self)
							(FrameOut)
						)
					)
				)
				(if (== temp1 1)
					(= cel 0)
					(UpdateScreenItem self)
					(FrameOut)
				)
				temp1
			else
				1
			)
			(myTeller iconValue: value)
			((myTeller theControls:)
				state: (& ((myTeller theControls:) state:) $ffdf)
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (show &tmp temp0 temp1)
		(= temp1 (IntArray with: 0 0 0 0))
		(TextSize (temp1 data:) (myHandle data:) (myTeller font:))
		(= nsRight (+ nsLeft (- (plane right:) (plane left:))))
		(= nsBottom (+ nsTop (temp1 at: 3) 7))
		(= x (+ nsLeft 10))
		(= y (+ nsTop 1))
		(= cel 0)
		(UpdateScreenItem self)
		(if (not text1)
			(= text1
				((myDText new:)
					posn: (+ x 11) (+ nsTop 1)
					text: (myHandle data:)
					font: (myTeller font:)
					fore: 0
					back: 24
					skip: 24
					setSize:
					init: (myTeller tellCast:)
					setPri: 249
					yourself:
				)
			)
		)
		(if (not text3)
			(= text3
				((myDText new:)
					posn: (+ 10 x) nsTop
					font: (myTeller font:)
					text: (myHandle data:)
					fore: lowlightColor
					back: 24
					skip: 24
					setSize:
					init: (myTeller tellCast:)
					setPri: 240
					yourself:
				)
			)
		)
		(if (not text2)
			(= text2
				((myDText new:)
					posn: (+ x 10) nsTop
					text: (myHandle data:)
					font: (myTeller font:)
					fore: highlightColor
					back: 24
					skip: 24
					setSize:
					init: (myTeller tellCast:)
					setPri: 255
					yourself:
				)
			)
		)
		(UpdateScreenItem text1)
		(UpdateScreenItem text3)
		(UpdateScreenItem text2)
		(temp1 dispose:)
	)

	(method (highlight param1)
		(if param1
			(= cel 1)
		else
			(= cel 0)
		)
		(UpdateScreenItem self)
	)
)

(instance myDText of DText
	(properties)

	(method (setPri)
		(super setPri: &rest)
		(UpdateScreenItem self)
	)

	(method (dispose &tmp temp0)
		(if bitmap
			(DisposeTextBitmap bitmap)
			(= bitmap 0)
		)
		(gCast delete: self)
		(if (self isNotHidden:)
			(DeleteScreenItem self)
		)
		(= temp0 (plane casts:))
		(temp0 eachElementDo: #delete self)
		(= plane 0)
		(DisposeClone self)
	)
)

(instance intList of List
	(properties)

	(method (dispose)
		(self release:)
		(DisposeClone self)
	)
)

(class Teller of Obj
	(properties
		curNoun 0
		sayNoun 0
		verb 0
		modNum 0
		stack 0
		curList 0
		client 0
		iconValue 0
		theControls 0
		title 0
		window 0
		loopMenu 1
		tellCursor 0
		tellCast 0
		font 4
		rootNoun 0
		actionVerb 0
		talker 0
	)

	(method (init param1 param2 param3 param4 param5)
		((= client param1) actions: self)
		(if (> argc 1)
			(= modNum param2)
			(if (> argc 2)
				(= sayNoun param3)
				(if (> argc 3)
					(= verb param4)
				)
			)
		else
			(= modNum gCurRoomNum)
		)
		(if (== argc 5)
			(= curNoun param5)
			(= rootNoun param5)
		else
			(= curNoun (client noun:))
			(= rootNoun (client noun:))
		)
		(if (not theControls)
			(= theControls tellerControls)
		)
		((= stack (intList new:)) addToFront: curNoun)
		(if (not actionVerb)
			(= actionVerb 2)
		)
	)

	(method (dispose)
		(if stack
			(stack dispose:)
		)
		(if client
			(client actions: 0)
		)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(tellerCursor view: 999)
			(while (not (self respond:))
			)
		else
			(client doVerb: theVerb)
		)
		(return 1)
	)

	(method (respond &tmp temp0 temp1 temp2)
		(= iconValue 0)
		(self buildCaseList: showCases:)
		(curList dispose:)
		(= curList 0)
		(cond
			((or (not iconValue) (== iconValue -999))
				(return 1)
			)
			((== iconValue 999)
				(FrameOut)
				(stack delete: curNoun)
				(= curNoun (stack at: 0))
				(return 0)
			)
			(else
				(= temp2 (self sayMessage:))
				(if
					(and
						(Message msgSIZE modNum curNoun verb iconValue 2)
						(>
							(= temp0
								(Message 4 modNum curNoun verb iconValue 2) ; msgREF_NOUN
							)
							-1
						)
					)
					(= curNoun temp0)
					(stack addToFront: curNoun)
				)
				(return temp2)
			)
		)
	)

	(method (sayMessage)
		(gMessager say: sayNoun verb iconValue 0 0 modNum)
		(return 1)
	)

	(method (buildCaseList &tmp temp0)
		(= tellCast (Cast new:))
		(= local2 self)
		(if curList
			(curList dispose:)
		)
		(= curList (intList new:))
		(for ((= temp0 0)) (< temp0 150) ((++ temp0))
			(if (Message msgSIZE modNum curNoun verb temp0 (self getSeqNum:))
				(curList add: temp0)
			)
		)
	)

	(method (showCases param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 [temp7 3] temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18)
		(= temp13 0)
		(= temp12 120)
		(= temp1 0)
		(= temp3 5)
		(= temp6 0)
		(= temp2 0)
		(= temp15 0)
		(= temp16 0)
		(if (not (theControls plane:))
			(theControls plane: (TransPlane new:))
		)
		(if title
			(= temp14 (Str newWith: 100 {}))
			(Message msgGET 2 0 0 title 1 (temp14 data:))
			((= temp15 (DText new:))
				text: (temp14 data:)
				font: font
				fore: 0
				back: 254
				skip: 254
			)
			(temp14 data: 0 dispose:)
			(= temp14 (Str newWith: 100 {}))
			(Message msgGET 2 0 0 title 1 (temp14 data:))
			((= temp16 (DText new:))
				text: (temp14 data:)
				font: font
				fore: 14
				back: 254
				skip: 254
				setPri: 255
				init: tellCast
			)
			(temp14 data: 0 dispose:)
			(+= temp3 15)
		)
		(for ((= temp0 0)) (< temp0 (curList size:)) ((++ temp0))
			(= temp4 1)
			(for ((= temp1 0)) (and temp4 (< temp1 argc)) ((+= temp1 2))
				(if
					(and
						(== (curList at: temp0) [param1 temp1])
						(not [param1 (+ temp1 1)])
					)
					(= temp4 0)
				)
			)
			(if temp4
				(= temp13 1)
				(= temp5 (curList at: temp0))
				(= temp11 (self getSeqNum: temp5))
				(if
					(not
						(= temp10 (Message msgSIZE modNum curNoun verb temp5 temp11))
					)
					(break)
				)
				(= temp2 (TellerIcon new:))
				(temp2 myHandle: (Str new: temp10))
				(Message
					msgGET
					modNum
					curNoun
					verb
					temp5
					temp11
					((temp2 myHandle:) data:)
				)
				(= temp17 (IntArray with: 0 0 0 0))
				(TextSize (temp17 data:) ((temp2 myHandle:) data:) font 0)
				(= temp10 (+ (temp17 at: 2) 20))
				(= temp18 (temp17 at: 3))
				(temp17 dispose:)
				(if (> temp10 temp12)
					(= temp12 temp10)
				)
				(temp2 value: temp5 nsTop: temp3 myTeller: self)
				(theControls add: temp2)
				(++ temp6)
				(+= temp3 (+ temp18 4))
			)
		)
		(if (not temp2)
			(client doVerb: 2)
			(theControls dispose:)
			(return -999)
		)
		((= temp2 (TellerIcon new:)) nsTop: temp3 myTeller: self)
		(if (!= curNoun rootNoun)
			(= temp10 (Message msgSIZE 2 0 0 2 1)) ; "Something else"
			(temp2 myHandle: (Str new: (+ temp10 1)))
			(Message msgGET 2 0 0 2 1 ((temp2 myHandle:) data:)) ; "Something else"
			(temp2 value: 999)
		else
			(= temp10 (Message msgSIZE 2 0 0 3 1)) ; "No more questions"
			(temp2 myHandle: (Str new: (+ temp10 1)))
			(Message msgGET 2 0 0 3 1 ((temp2 myHandle:) data:)) ; "No more questions"
			(temp2 value: -999)
		)
		(theControls add: temp2)
		((theControls plane:)
			top: (- 60 (* 7 temp6))
			bottom: (- (+ temp3 73) (* 7 temp6))
			left: (- 150 (/ temp12 2))
			right: (+ 170 (/ temp12 2))
			init:
			addCast: tellCast
		)
		(if temp15
			(temp15
				x:
					(+
						(/
							(-
								((theControls plane:) right:)
								((theControls plane:) left:)
							)
							2
						)
						1
					)
				y: 6
				init: tellCast
			)
			(temp16
				x:
					(/
						(-
							((theControls plane:) right:)
							((theControls plane:) left:)
						)
						2
					)
				y: 5
				init: tellCast
			)
		)
		(= tellCursor (gGame setCursor: tellerCursor 1))
		(theControls init: show: dispose:)
		(return (gGame setCursor: tellCursor 1))
	)

	(method (getSeqNum)
		(return 1)
	)

	(method (cue))
)

(instance tellerControls of IconBar
	(properties
		state 0
	)

	(method (select param1 param2)
		(return
			(if (param1 select: (and (>= argc 2) param2))
				(if (not (& (param1 signal:) $0002))
					(= curIcon param1)
				)
				1
			)
		)
	)

	(method (advanceCurIcon))

	(method (swapCurIcon))

	(method (init &tmp temp0)
		(plane
			priority: (+ (GetHighPlanePri) 1)
			setInsetRect:
				(plane left:)
				(plane top:)
				(plane right:)
				(plane bottom:)
		)
		(self eachElementDo: #init self)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= temp1 (event x:))
		(= temp0 (event y:))
		(= temp2 (event type:))
		(= temp3 (event message:))
		(= temp5 (event claimed:))
		(if (= temp4 (self firstTrue: #onMe event))
			(= temp6 (temp4 signal:))
			(= temp7 (== temp4 helpIconItem))
		)
		(if (& temp2 $0010) ; direction
			(switch temp3
				(JOY_RIGHT
					(self advance:)
				)
				(JOY_DOWN
					(self advance:)
				)
				(JOY_LEFT
					(self retreat:)
				)
				(JOY_UP
					(self retreat:)
				)
			)
		else
			(switch temp2
				(evNULL
					(if temp4
						(if (!= temp4 highlightedIcon)
							(= oldMouseY 0)
							(self highlight: temp4)
						)
					else
						(self highlight: 0)
					)
				)
				(evMOUSEBUTTON
					(if (and temp4 (self select: temp4 1))
						(= temp5 (& temp6 $0040))
					)
				)
				(evKEYBOARD
					(switch temp3
						(KEY_ESCAPE
							(= temp5 1)
						)
						(KEY_DELETE
							(= temp5 1)
						)
						(KEY_RETURN
							(if (not temp4)
								(= temp4 highlightedIcon)
							)
							(if (and temp4 (self select: temp4))
								(temp4 doit:)
								(= temp5 (& temp6 $0040))
							)
						)
						(KEY_SHIFTTAB
							(self retreat:)
						)
						(KEY_TAB
							(self advance:)
						)
					)
				)
			)
		)
		(return temp5)
	)

	(method (show &tmp temp0 temp1 temp2 temp3 [temp4 2])
		(|= state $0020)
		(UpdatePlane plane)
		(= temp0 30)
		(= temp1 30)
		(for ((= temp2 (FirstNode elements))) temp2 ((= temp2 nextNode))
			(= nextNode (NextNode temp2))
			(if (not (= temp3 (NodeValue temp2)))
				(return)
			)
			(if (and (not (& (temp3 signal:) $0080)) (<= (temp3 nsRight:) 0))
				(temp3 show: temp0 temp1)
				(= temp0 (+ 20 (temp3 nsRight:)))
			else
				(temp3 show:)
			)
		)
		(self doit: hide:)
		(= local2 0)
		(= curIcon 0)
		(= highlightedIcon 0)
	)

	(method (highlight param1 param2)
		(if (and highlightedIcon (highlightedIcon isKindOf: TellerIcon))
			(highlightedIcon highlight: 0)
		)
		(cond
			((not (= highlightedIcon param1)) 0)
			((& (param1 signal:) $0004)
				(= highlightedIcon 0)
			)
			(else
				(param1 highlight: 1)
				(if (and (>= argc 2) param2)
					(gGame
						setCursor:
							gTheCursor
							1
							(+
								(param1 nsLeft:)
								(/ (- (param1 nsRight:) (param1 nsLeft:)) 2)
							)
							(- (param1 nsBottom:) 3)
					)
				)
			)
		)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4)
		(while (and (& state $0020) (= temp0 (Event new:)))
			(= temp1 (temp0 type:))
			(= temp2 (temp0 message:))
			(= temp3 (temp0 modifiers:))
			(= gGameTime (+ gTickOffset (GetTime)))
			(FrameOut)
			(if gCuees
				(gCuees eachElementDo: #doit)
			)
			(if (== temp1 $0020) ; joyUp
				(= temp1 evKEYBOARD)
				(= temp2 (if (& temp3 emSHIFT) 27 else 13))
				(= temp3 $0000)
				(temp0 type: temp1 message: temp2 modifiers: $0000)
			)
			(temp0 localize: plane)
			(MapKeyToDir temp0)
			(breakif (self dispatchEvent: temp0))
			(temp0 dispose:)
			(= temp0 0)
		)
		(if temp0
			(temp0 dispose:)
		)
		((User curEvent:) claimed: 1)
	)

	(method (dispose)
		(self eachElementDo: #dispose)
		(if elements
			(DisposeList elements)
		)
		(plane deleteCast: self dispose:)
		(FrameOut)
		(= plane 0)
		(= elements 0)
		(= size 0)
		(DisposeClone self)
	)
)

(instance tellerCursor of Cursor
	(properties)
)

