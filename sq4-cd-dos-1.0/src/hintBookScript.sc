;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 708)
(include sci.sh)
(use Main)
(use Sq4Feature)
(use System)

(public
	hintBookScript 0
)

(local
	local0 = -1
	local1
	[local2 4]
	[local6 12] = [99 1 10 19 27 35 42 50 57 62 64 69]
	local18
	local19 = 1
	[local20 14]
	local34 = -1
	local35
	[local36 275]
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1)
	(while
		(and
			(= temp0 (FirstNode (param1 elements:)))
			(IsObject (= temp1 (NodeValue temp0)))
		)
		(param2 add: temp1)
		(param1 delete: temp1)
	)
)

(procedure (localproc_1 param1 param2 &tmp temp0)
	(if (OneOf param1 1 6 12 18 24 29 34 39 41 46 50 55 57 63 65 67)
		(localproc_5 param1 param2 local18)
		(= temp0 0)
	else
		(Message msgGET 708 2 0 param1 1 @local36)
		(TextSize @local2 @local36 30 140)
		(localproc_3
			(- (+ local18 [local2 0]) 3)
			(- (+ param2 [local2 1]) 3)
			(+ local18 [local2 2])
			(+ param2 [local2 3])
		)
		(Display {\04} dsFONT 30 dsCOORD (- param2 12) (- local18 1))
		(= [local20 (++ local34)]
			((bulletFeat new:)
				x: (- param2 9)
				y: (+ local18 2)
				nsLeft: (- param2 13)
				nsTop: (- local18 1)
				nsRight: (- param2 5)
				nsBottom: (+ local18 5)
				who: param1
				whoX: param2
				whoY: local18
				yourself:
			)
		)
		([local20 local34] init:)
		(if (& [global163 (/ param1 16)] (>> $8000 (mod param1 16)))
			(localproc_5 param1 param2 local18)
		)
		(= temp0 2)
	)
	(TextSize @local2 @local36 30 140)
	(+= local18 (+ [local2 2] 3 temp0))
)

(procedure (localproc_2 &tmp temp0 temp1 [temp2 22])
	(for ((= temp0 0)) (< temp0 14) ((++ temp0))
		(if (IsObject [local20 temp0])
			([local20 temp0] dispose:)
		)
		(= [local20 temp0] 0)
	)
	(= local34 -1)
	(Graph grFILL_BOX 0 0 189 320 3 global130 15)
	(Graph grUPDATE_BOX 0 0 189 320 1)
	(Graph grDRAW_LINE 0 159 189 159 global129 -1 -1)
	(Graph grUPDATE_BOX 0 159 190 160 1)
	(Display 708 0 dsFONT 30 dsCOORD 50 3) ; "SQ IV Hint Book"
	(Display 708 0 dsFONT 30 dsCOORD 200 3) ; "SQ IV Hint Book"
	(Display 708 1 dsFONT 30 dsCOORD 5 3) ; "Page"
	(Display 708 1 dsFONT 30 dsCOORD 290 3) ; "Page"
	(if (> local19 9)
		(Format @temp2 708 2 local19) ; "%d"
	else
		(Format @temp2 708 3 local19) ; "%d"
	)
	(Display @temp2 dsFONT 30 dsBACKGROUND global130 dsCOORD 25 3)
	(if (> local19 8)
		(Format @temp2 708 2 (+ local19 1)) ; "%d"
	else
		(Format @temp2 708 3 (+ local19 1)) ; "%d"
	)
	(Display @temp2 dsFONT 30 dsBACKGROUND global130 dsCOORD 310 3)
	(localproc_4 exitBut (+ (exitBut nsLeft:) 1) (+ (exitBut nsTop:) 2) {exit})
	(localproc_4 nextBut (+ (nextBut nsLeft:) 1) (+ (nextBut nsTop:) 2) {next})
	(localproc_4 prevBut (+ (prevBut nsLeft:) 1) (+ (prevBut nsTop:) 2) {prev})
	(= local18 14)
	(for
		((= temp0 [local6 local19]))
		(< temp0 [local6 (+ local19 1)])
		((++ temp0))
		
		(localproc_1 temp0 14)
	)
	(++ local19)
	(= local18 14)
	(for
		((= temp0 [local6 local19]))
		(< temp0 [local6 (+ local19 1)])
		((++ temp0))
		
		(localproc_1 temp0 174)
	)
)

(procedure (localproc_3 param1 param2 param3 param4)
	(Graph grDRAW_LINE param1 param2 param1 param4 global129 -1 -1)
	(Graph grDRAW_LINE param1 param4 param3 param4 global129 -1 -1)
	(Graph grDRAW_LINE param3 param2 param3 param4 global129 -1 -1)
	(Graph grDRAW_LINE param1 param2 param3 param2 global129 -1 -1)
	(Graph grUPDATE_BOX param1 param2 (+ param3 1) (+ param4 1) 1)
)

(procedure (localproc_4 param1 param2 param3 param4)
	(localproc_3
		(param1 nsTop:)
		(param1 nsLeft:)
		(param1 nsBottom:)
		(param1 nsRight:)
	)
	(Display param4 dsFONT 30 dsCOORD param2 param3)
)

(procedure (localproc_5 param1 param2 param3)
	(if (== param1 33)
		(StrCpy @local36 {\0e \0b \0c})
	else
		(Message msgGET 708 2 0 param1 1 @local36)
	)
	(Display @local36 dsFONT 30 dsWIDTH 140 dsCOORD param2 param3)
)

(instance hintBookScript of Script
	(properties)

	(method (doit)
		(if (GameIsRestarting)
			(= start 2)
			(-- local19)
			(self init:)
		)
		(super doit:)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= local19 1)
				(= local18 0)
				(gEgo setMotion: 0)
				(= local1 (gUser controls:))
				(gUser canControl: 0)
				(= cycles 2)
			)
			(1
				(if (== gCurRoomNum 391)
					(gTheIconBar disable: 0)
				)
				(= register (gCurRoom picture:))
				(= local0 gOverlays)
				(localproc_0 gAddToPics aList)
				(localproc_0 gFeatures fList)
				(localproc_0 gCast cList)
				(gCurRoom drawPic: 699 10)
				(= cycles 2)
			)
			(2
				(= temp1 (GetPort))
				(SetPort temp1)
				(exitBut init:)
				(nextBut init:)
				(prevBut init:)
				(localproc_2)
				(gGame setCursor: ((gInventory curIcon:) cursor:) 1)
			)
			(3
				(= local35 999)
				(self dispose:)
			)
		)
	)

	(method (dispose &tmp temp0)
		(gFeatures release:)
		(gCurRoom drawPic: register 10)
		(if (!= (= gOverlays local0) -1)
			(DrawPic gOverlays 10 0)
		)
		(for ((= temp0 0)) (< temp0 14) ((++ temp0))
			(if (IsObject [local20 temp0])
				([local20 temp0] dispose:)
			)
			(= [local20 temp0] 0)
		)
		(if (== local35 999)
			(localproc_0 aList gAddToPics)
			(localproc_0 fList gFeatures)
			(localproc_0 cList gCast)
			(gAddToPics doit:)
		)
		(aList eachElementDo: #dispose eachElementDo: #delete release: dispose:)
		(fList eachElementDo: #perform fdc release: dispose:)
		(cList eachElementDo: #dispose eachElementDo: #delete dispose:)
		(gUser canControl: local1)
		(if (== gCurRoomNum 391)
			(gTheIconBar enable: 0)
		)
		(super dispose:)
		(DisposeScript 708)
	)
)

(instance fdc of Code
	(properties)

	(method (doit param1)
		(if (param1 respondsTo: #delete)
			(param1 signal: (& (param1 signal:) $ffdf) dispose: delete:)
		else
			(param1 dispose:)
		)
	)
)

(instance aList of Collect
	(properties)
)

(instance fList of Collect
	(properties)
)

(instance cList of Collect
	(properties)
)

(instance exitBut of Sq4Feature
	(properties
		x 14
		y 183
		nsTop 178
		nsLeft 4
		nsBottom 188
		nsRight 24
		sightAngle 180
		lookStr 1
	)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 0)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 708 say: 1) ; "Press this button to put the hint book away."
			)
			(4 ; Do
				(= temp0 1)
			)
			(else
				(= temp0 1)
			)
		)
		(if temp0
			(hintBookScript cue:)
		)
	)
)

(instance prevBut of Sq4Feature
	(properties
		x 41
		y 183
		nsTop 178
		nsLeft 29
		nsBottom 188
		nsRight 49
		sightAngle 180
		lookStr 2
	)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 0)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 708 say: 2) ; "Press this button to turn back one page."
			)
			(4 ; Do
				(= temp0 1)
			)
			(else
				(= temp0 1)
			)
		)
		(if (and temp0 (> local19 3))
			(-= local19 3)
			(localproc_2)
		)
	)
)

(instance nextBut of Sq4Feature
	(properties
		x 54
		y 183
		nsTop 178
		nsLeft 54
		nsBottom 188
		nsRight 74
		sightAngle 180
		lookStr 3
	)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 0)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 708 say: 3) ; "Press this button to turn to the next page."
			)
			(4 ; Do
				(= temp0 1)
			)
			(else
				(= temp0 1)
			)
		)
		(if (and temp0 (< local19 10))
			(++ local19)
			(localproc_2)
		)
	)
)

(class BulletFeat of Sq4Feature
	(properties
		who 0
		whoX 0
		whoY 0
	)
)

(instance bulletFeat of BulletFeat
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 708 say: 4) ; "Press this with the Reveal-O-Matic Hint Revealer and a hint will be revealed."
			)
			(4 ; Do
				(gNarrator modNum: 708 say: 5) ; "You'll need the Reveal-O-Matic Hint Revealer."
			)
			(17 ; pen
				(cond
					((> global168 100)
						(gNarrator modNum: 708 say: 6) ; "Your Reveal-O-Matic seems to have exhausted its power supply. You'll have to contact the supplier for a replacement."
					)
					((& [global163 (/ who 16)] (>> $8000 (mod who 16))) 0)
					(else
						(|= [global163 (/ who 16)] (>> $8000 (mod who 16)))
						(localproc_5 who whoX whoY)
						(if (== who 33)
							(Animate (gCast elements:) 0)
							(gNarrator modNum: 708 say: 7) ; "Oh, great! Only half the answer showed! It must be a defective hint module."
						)
						(++ global168)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

