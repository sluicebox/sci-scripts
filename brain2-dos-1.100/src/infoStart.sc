;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 55)
(include sci.sh)
(use Main)
(use PuzzleIcon)
(use BrainWindow)
(use IconBar)
(use Feature)
(use GameControls)
(use System)

(public
	infoStart 0
)

(local
	local0
	local1
	[local2 100]
	[local102 4] = [0 -2 -3 -999]
	[local106 7] = [0 4 5 26 6 7 999]
	[local113 7] = [0 38 39 40 41 42 999]
	[local120 4] = [0 -2 -3 999]
	[local124 8]
)

(procedure (localproc_0)
	(if (== (InfoObject doVerb:) -999)
		(gGame setCursor: local1)
		(DisposeScript 55)
	else
		(localproc_0)
	)
)

(procedure (localproc_1 param1 param2 param3)
	(Memory memPOKE (+ param1 (* 2 param2)) param3)
)

(instance infoStart of Code
	(properties)

	(method (init)
		(= local1 gTheCursor)
		(gGame setCursor: 999)
		(= [local124 0] @local102)
		(= [local124 1] @local106)
		(= [local124 2] @local113)
		(InfoObject init: info @local102 @local124 @local120)
		(info init:)
		(localproc_0)
	)
)

(instance info of Feature
	(properties
		x 160
		y 100
		noun 1
		nsBottom 199
		nsRight 319
	)
)

(class InfoIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 15
		signal 257
		maskView 361
		maskLoop 3
		myHandle 0
		value 0
		myTeller 0
	)

	(method (select)
		(myTeller iconValue: value)
		((myTeller theControls:)
			state: (& ((myTeller theControls:) state:) $ffdf)
		)
	)

	(method (show &tmp [temp0 15])
		(Message msgGET 100 0 0 36 1 @temp0) ; "Learn About:"
		(Display @temp0 dsCOORD 15 5 dsCOLOR 17)
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(Display myHandle dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(= temp0 46)
		else
			(= temp0 17)
		)
		(Display myHandle dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

(instance infocon of InfoIcon
	(properties)

	(method (show &tmp [temp0 30])
		(cond
			((== (InfoObject curArray:) @local102)
				(Message msgGET 100 1 2 1 1 @temp0) ; "Do You Want..."
				(Display @temp0 dsCOORD 15 5 dsCOLOR 17)
			)
			((== (InfoObject curArray:) @local113)
				(Message msgGET 100 1 2 22 1 @temp0) ; "Help..."
				(Display @temp0 dsCOORD 15 5 dsCOLOR 17)
			)
			((== (InfoObject curArray:) @local106)
				(Message msgGET 100 1 2 37 1 @temp0) ; "Tech info..."
				(Display @temp0 dsCOORD 15 5 dsCOLOR 17)
			)
		)
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(Display myHandle dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)
)

(class InfoObject of Obj
	(properties
		query 0
		curArray 0
		arrays 0
		keys 0
		client 0
		iconValue 0
		theControls 0
	)

	(method (init param1 param2 param3 param4)
		(= client param1)
		(= curArray param2)
		(= arrays param3)
		(if (> argc 3)
			(= keys param4)
		)
		(client actions: self)
		(super init:)
	)

	(method (doVerb)
		(= iconValue 0)
		(while 1
			(if (self response:)
				(break)
			)
		)
		(return query)
	)

	(method (doWindow)
		(self doLists: (if (== (WordAt arrays 0) curArray) 1 else 0) &rest)
	)

	(method (getSeq)
		(return 1)
	)

	(method (oldSubList param1 &tmp temp0)
		(= temp0 0)
		(while (++ temp0)
			(if (== (WordAt keys temp0) param1)
				(self fillArray: (WordAt arrays temp0) 1)
				(return 1)
			)
			(< (WordAt keys temp0) 999)
		)
		(return 1)
	)

	(method (response)
		(= query (self doWindow:))
		(if (and (!= query -999) iconValue)
			(= query iconValue)
		)
		(cond
			((or (not query) (== query -999))
				(= query -999)
				(return 1)
			)
			((== query 999)
				(self superList:)
				(return 0)
			)
			((and (< query 0) (not (self subList: query)))
				(return 1)
			)
		)
		(= query (Abs query))
		(Say 0 (client noun:) 5 query 0 0 100)
		(return 1)
	)

	(method (doLists param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 [temp15 30])
		(= temp0 [param1 (= temp3 0)])
		(= temp5 5)
		(= temp8 0)
		(= temp4 0)
		(= temp9 (List new:))
		((= theControls (GameControls new:))
			window:
				((BrainWindow new:)
					top: 40
					left: 70
					bottom: 140
					right: 250
					priority: 15
					yourself:
				)
		)
		(if (OneOf curArray @local102 @local113 @local106)
			(+= temp5 15)
		)
		(for ((= temp2 1)) (!= (WordAt curArray temp2) 999) ((++ temp2))
			(= temp6 1)
			(for ((= temp3 1)) (and temp6 (< temp3 argc)) ((+= temp3 2))
				(if
					(and
						(== (WordAt curArray temp2) [param1 temp3])
						(not [param1 (+ temp3 1)])
					)
					(= temp6 0)
				)
			)
			(if temp6
				(= temp7 (WordAt curArray temp2))
				(= temp14 (self getSeq: (Abs temp7)))
				(if
					(not
						(= temp13
							(Message msgSIZE 100 (client noun:) 2 (Abs temp7) temp14)
						)
					)
					(break)
				)
				(= temp1 (Memory memALLOC_NONCRIT temp13))
				(temp9 add: temp1)
				(Message msgGET 100 1 2 (Abs temp7) temp14 temp1)
				((= temp4 (infocon new:))
					myHandle: temp1
					value: temp7
					nsTop: temp5
					myTeller: self
				)
				(theControls add: temp4)
				(if (== (++ temp8) 1)
					(theControls curIcon: temp4)
				)
				(+= temp5 15)
			)
		)
		(if (not (IsObject temp4))
			((theControls window:) dispose:)
			(theControls dispose:)
			(temp9 dispose:)
			(return -999)
		)
		(= temp4 (infocon new:))
		(if (not temp0)
			(Message msgGET 100 0 0 34 1 @temp15) ; "Something Else"
			(temp4 myHandle: @temp15 value: 999 nsTop: temp5 myTeller: self)
		else
			(Message msgGET 100 0 0 35 1 @temp15) ; "Enough Already"
			(temp4 myHandle: @temp15 value: -999 nsTop: temp5 myTeller: self)
		)
		(theControls add: temp4)
		((theControls window:)
			top: (- 60 (* 7 temp8))
			bottom: (- (+ temp5 80) (* 7 temp8))
		)
		(theControls init: show: dispose:)
		(for
			((= temp10 (FirstNode (temp9 elements:))))
			temp10
			((= temp10 temp11))
			
			(= temp11 (NextNode temp10))
			(if (not (= temp12 (NodeValue temp10)))
				(break)
			else
				(Memory memFREE temp12)
			)
		)
		(return (temp9 dispose:))
	)

	(method (subList param1)
		(switch param1
			(-2
				(self oldSubList: param1)
				(self doVerb:)
				(return 0)
			)
			(-3
				(self oldSubList: param1)
				(self doVerb:)
				(return 0)
			)
			(else
				(return 1)
			)
		)
	)

	(method (superList)
		(self fillArray: (WordAt curArray 0) 0)
	)

	(method (fillArray param1 param2)
		(if param2
			(localproc_1 param1 0 curArray)
		)
		(= curArray param1)
		(return param2)
	)
)

