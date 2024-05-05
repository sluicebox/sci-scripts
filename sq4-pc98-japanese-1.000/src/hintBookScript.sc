;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 708)
(include sci.sh)
(use Main)
(use Interface)
(use Feature)
(use User)
(use System)

(public
	hintBookScript 0
)

(local
	local0 = -1
	local1
	[local2 142] = [0 0 0 0 708 0 708 1 708 2 708 3 708 4 708 5 708 6 708 7 708 8 708 9 708 10 708 11 708 12 708 13 708 14 708 15 708 16 708 17 708 18 708 19 708 20 708 21 708 22 708 23 708 24 708 25 708 26 708 27 708 28 708 29 708 30 708 31 708 32 708 33 708 34 708 35 708 36 708 37 708 38 708 39 708 40 708 41 708 42 708 43 708 44 708 45 708 46 708 47 708 48 708 49 708 50 708 51 708 52 708 53 708 54 708 55 708 56 708 57 708 58 708 59 708 60 708 61 708 62 708 63 708 64 708 65 708 66 708 67 708 68]
	[local144 13] = [99 0 9 18 25 34 40 48 54 61 63 67 69]
	[local157 12] = [99 0 9 18 25 34 40 48 54 61 65 69]
	[local169 12] = [99 0 9 17 23 33 38 45 52 59 64 69]
	[local181 12] = [99 0 9 18 26 34 41 49 56 61 64 69]
	[local193 12] = [99 0 9 18 26 34 41 49 56 61 64 69]
	local205
	local206 = 1
	local207 = 14
	[local208 14]
	local222 = -1
	local223
	local224
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

(procedure (localproc_1 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 [temp5 500])
	(if (OneOf param1 0 5 11 17 23 28 33 38 40 45 49 54 56 63 65 67)
		(localproc_5 param1 param2 local205)
		(GetFarText 708 param1 @temp5)
		(TextSize @local2 @temp5 30 140)
		(= temp1 (- (+ local205 [local2 0]) 3))
		(= temp2 (- (+ param2 [local2 1]) 3))
		(= temp4 (+ local205 [local2 2]))
		(= temp3 (+ param2 [local2 3]))
		(= temp0 0)
	else
		(GetFarText 708 param1 @temp5)
		(TextSize @local2 @temp5 30 140)
		(= temp1 (- (+ local205 [local2 0]) 3))
		(= temp2 (- (+ param2 [local2 1]) 3))
		(= temp4 (+ local205 [local2 2]))
		(= temp3 (+ param2 [local2 3]))
		(localproc_3 temp1 temp2 temp4 temp3)
		(Display 708 69 dsFONT 30 dsCOORD (- param2 12) (- local205 1)) ; "\04"
		(= [local208 (++ local222)]
			((bulletFeat new:)
				x: (- param2 9)
				y: (+ local205 2)
				nsLeft: (- param2 13)
				nsTop: (- local205 1)
				nsRight: (- param2 5)
				nsBottom: (+ local205 5)
				who: param1
				whoX: param2
				whoY: local205
				yourself:
			)
		)
		([local208 local222] init:)
		(if (& [global163 (/ param1 16)] (>> $8000 (mod param1 16)))
			(localproc_5 param1 param2 local205)
		)
		(if
			(and
				(OneOf
					(+ param1 1)
					0
					5
					11
					17
					23
					28
					33
					38
					40
					45
					49
					54
					56
					63
					65
					67
				)
				(!= (gGame printLang:) 1)
			)
			(= temp0 -1)
		else
			(= temp0 2)
		)
	)
	(TextSize @local2 @temp5 30 140)
	(+= local205 (+ [local2 2] 3 temp0))
)

(procedure (localproc_2 &tmp temp0 [temp1 2] [temp3 2])
	(for ((= temp0 0)) (< temp0 14) ((++ temp0))
		(if (IsObject [local208 temp0])
			([local208 temp0] dispose:)
		)
		(= [local208 temp0] 0)
	)
	(= local222 -1)
	(Graph grFILL_BOX 0 0 189 320 3 global130 15)
	(Graph grUPDATE_BOX 0 0 189 320 1)
	(Graph grDRAW_LINE 0 159 189 159 global129 -1 -1)
	(Graph grUPDATE_BOX 0 159 190 160 1)
	(Display 708 70 dsFONT 30 dsCOORD 50 3) ; "SQ IV Hint Book"
	(Display 708 70 dsFONT 30 dsCOORD 200 3) ; "SQ IV Hint Book"
	(Display 708 71 dsFONT 30 dsCOORD 5 3) ; "Page"
	(Display 708 71 dsFONT 30 dsCOORD 290 3) ; "Page"
	(localproc_4 exitBut (+ (exitBut nsLeft:) 1) (+ (exitBut nsTop:) 2) {exit})
	(localproc_4 nextBut (+ (nextBut nsLeft:) 1) (+ (nextBut nsTop:) 2) {next})
	(localproc_4 prevBut (+ (prevBut nsLeft:) 1) (+ (prevBut nsTop:) 2) {prev})
	(if (> local206 9)
		(Format @temp3 708 72 local206) ; "%d"
	else
		(Format @temp3 708 73 local206) ; "%d"
	)
	(Display @temp3 dsFONT 30 dsBACKGROUND global130 dsCOORD 25 3)
	(if (> local206 8)
		(Format @temp3 708 72 (+ local206 1)) ; "%d"
	else
		(Format @temp3 708 73 (+ local206 1)) ; "%d"
	)
	(Display @temp3 dsFONT 30 dsBACKGROUND global130 dsCOORD 310 3)
	(= local205 14)
	(for
		((= temp0 (localproc_6 local206)))
		(< temp0 (localproc_6 (+ local206 1)))
		((++ temp0))
		
		(localproc_1 temp0 14)
	)
	(++ local206)
	(= local205 14)
	(if (<= local206 (localproc_7))
		(for
			((= temp0 (localproc_6 local206)))
			(< temp0 (localproc_6 (+ local206 1)))
			((++ temp0))
			
			(localproc_1 temp0 174)
		)
	)
)

(procedure (localproc_3 param1 param2 param3 param4)
	(Graph grDRAW_LINE param1 param2 param1 param4 global129 -1 -1)
	(Graph grDRAW_LINE param1 param4 param3 param4 global129 -1 -1)
	(Graph grDRAW_LINE param3 param2 param3 param4 global129 -1 -1)
	(Graph grDRAW_LINE param1 param2 param3 param2 global129 -1 -1)
	(Graph grUPDATE_BOX param1 param2 (+ param3 1) (+ param4 1) 1)
)

(procedure (localproc_4 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (param1 nsTop:))
	(= temp1 (param1 nsLeft:))
	(= temp2 (param1 nsBottom:))
	(= temp3 (param1 nsRight:))
	(localproc_3 temp0 temp1 temp2 temp3)
	(Display param4 dsFONT 30 dsCOORD param2 param3)
)

(procedure (localproc_5 param1 param2 param3 &tmp temp0 [temp1 500])
	(GetFarText 708 param1 @temp1)
	(Display @temp1 dsFONT 30 dsWIDTH 140 dsCOORD param2 param3)
)

(procedure (localproc_6 param1)
	(switch (gGame printLang:)
		(49
			(return [local144 param1])
		)
		(34
			(return [local157 param1])
		)
		(33
			(return [local169 param1])
		)
		(39
			(return [local181 param1])
		)
		(else
			(return [local193 param1])
		)
	)
)

(procedure (localproc_7)
	(switch (gGame printLang:)
		(49
			(return 11)
		)
		(34
			(return 10)
		)
		(33
			(return 10)
		)
		(39
			(return 10)
		)
		(else
			(return 10)
		)
	)
)

(instance hintBookScript of Script
	(properties)

	(method (doit)
		(if (GameIsRestarting)
			(= start 2)
			(-- local206)
			(self init:)
		)
		(super doit:)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= local206 1)
				(= local205 0)
				(gEgo setMotion: 0)
				(= local1 (User controls:))
				(User canControl: 0)
				(= local224 (gCurRoom lookStr:))
				(gCurRoom lookStr: 0)
				(= cycles 2)
			)
			(1
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
				(= local223 999)
				(self dispose:)
			)
		)
	)

	(method (dispose &tmp temp0)
		(gFeatures release:)
		(gCurRoom drawPic: register 10)
		(if (!= (= gOverlays local0) -1)
			(DrawPic gOverlays 10 0 global40)
		)
		(for ((= temp0 0)) (< temp0 14) ((++ temp0))
			(if (IsObject [local208 temp0])
				([local208 temp0] dispose:)
			)
			(= [local208 temp0] 0)
		)
		(if (== local223 999)
			(localproc_0 aList gAddToPics)
			(localproc_0 fList gFeatures)
			(localproc_0 cList gCast)
			(gAddToPics doit:)
		)
		(aList eachElementDo: #dispose eachElementDo: #delete release: dispose:)
		(fList eachElementDo: #perform fdc release: dispose:)
		(cList eachElementDo: #dispose eachElementDo: #delete dispose:)
		(gCurRoom lookStr: local224)
		(User canControl: local1)
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

(instance exitBut of Feature
	(properties
		x 14
		y 183
		description {exit button}
		sightAngle 180
		lookStr {Press this button to put the hint book away.}
	)

	(method (init)
		(= nsLeft (proc0_19 2 4 4 4 4))
		(= nsTop 178)
		(= nsRight (proc0_19 39 24 28 24 24))
		(= nsBottom 188)
		(super init: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(3 ; Do
				(= temp0 1)
			)
			(4 ; Inventory
				(= temp0 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
		(if temp0
			(hintBookScript cue:)
		)
	)
)

(instance prevBut of Feature
	(properties
		x 41
		y 183
		description {previous page button}
		sightAngle 180
		lookStr {Press this button to turn back one page.}
	)

	(method (init)
		(= nsLeft (proc0_19 44 29 33 29 29))
		(= nsTop 178)
		(= nsRight (proc0_19 96 54 52 49 49))
		(= nsBottom 188)
		(super init: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(3 ; Do
				(= temp0 1)
			)
			(4 ; Inventory
				(= temp0 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
		(if (and temp0 (> local206 3))
			(-= local206 3)
			(localproc_2)
		)
	)
)

(instance nextBut of Feature
	(properties
		x 54
		y 183
		description {next page button\8e\9f\82\cc\83y\81[\83W\97p\83{\83^\83\93}
		sightAngle 180
		lookStr {Press this button to turn to the next page.}
	)

	(method (init)
		(= nsLeft (proc0_19 101 63 57 54 54))
		(= nsTop 178)
		(= nsRight (proc0_19 156 97 86 74 74))
		(= nsBottom 188)
		(super init: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(3 ; Do
				(= temp0 1)
			)
			(4 ; Inventory
				(= temp0 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
		(if (and temp0 (< local206 (localproc_7)))
			(++ local206)
			(localproc_2)
		)
	)
)

(class BulletFeat of Feature
	(properties
		who 0
		whoX 0
		whoY 0
	)
)

(instance bulletFeat of BulletFeat
	(properties
		description {hint activation button}
		lookStr {Press this with the Reveal-O-Matic Hint Revealer and a hint will be revealed.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 708 74) ; "You'll need the Reveal-O-Matic Hint Revealer."
			)
			(4 ; Inventory
				(cond
					((!= invItem 9) ; pen
						(super doVerb: theVerb invItem)
					)
					((> global168 100)
						(Print 708 75) ; "Sorry. Your Reveal-O-Matic seems to have exhausted its power supply. You'll have to contact the now defunct supplier for a replacement."
					)
					((& [global163 (/ who 16)] (>> $8000 (mod who 16))) 0)
					(else
						(|= [global163 (/ who 16)] (>> $8000 (mod who 16)))
						(localproc_5 who whoX whoY)
						(if (== who 32)
							(Animate (gCast elements:) 0)
							(Print 708 76) ; "Oh, great! Only half the answer showed! It must be a defective hint module."
						)
						(++ global168)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

