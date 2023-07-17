;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31)
(include sci.sh)
(use Main)
(use n011)
(use Plane)
(use Array)
(use Inset)
(use Feature)
(use Actor)
(use System)

(local
	local0
	local1
	local2
	local3
	local4
)

(class Notebook of Inset
	(properties
		picture 14180
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
	)

	(method (init)
		(gGame handsOff:)
		(= local3 0)
		(= local4 0)
		(= plane (Plane new:))
		(plane setRect: 0 0 640 480)
		(= x (- 0 ((gCurRoom plane:) left:)))
		(= y (- 0 ((gCurRoom plane:) top:)))
		(super init: &rest)
		(if (gUser sel_715:)
			(= BAD_SELECTOR ((gUser sel_715:) sel_718:))
			((gUser sel_715:) sel_718: (Set new:))
		)
		(if (not gPanels)
			(= gPanels (List new:))
		)
		(gPanels addToFront: self)
		(self sel_824:)
		(exitButton init:)
	)

	(method (BAD_SELECTOR param1 &tmp temp0)
		(if (!= picture 14181)
			(= picture 14181)
			(plane drawPic: picture)
			(pageForward init:)
			(pageBackward init:)
		)
		(= BAD_SELECTOR param1)
		(= BAD_SELECTOR (= BAD_SELECTOR 0))
		(local1 eachElementDo: #x 517)
		(for ((= temp0 0)) (< temp0 (BAD_SELECTOR sel_828:)) ((++ temp0))
			((local1 at: temp0) hide:)
		)
		(BAD_SELECTOR setPri: 50 show:)
		(UpdateScreenItem BAD_SELECTOR)
		(for
			((= temp0 (+ (BAD_SELECTOR sel_828:) 1)))
			(< temp0 (local1 size:))
			((++ temp0))
			
			((local1 at: temp0) setPri: (- 15 temp0) show:)
			(UpdateScreenItem (local1 at: temp0))
		)
		(self sel_825:)
	)

	(method (BAD_SELECTOR param1 &tmp temp0 temp1 temp2 temp3)
		(= temp3 BAD_SELECTOR)
		(cond
			((== param1 1)
				(= BAD_SELECTOR (+ BAD_SELECTOR 1))
				(if (not (self sel_825:))
					(if
						(>=
							(= temp2 (+ (BAD_SELECTOR sel_828:) 1))
							(BAD_SELECTOR size:)
						)
						(= BAD_SELECTOR temp3)
						(= local4 1)
						(self sel_825:)
						(return)
					)
					(for ((= temp0 temp2)) (< temp0 (local1 size:)) ((++ temp0))
						(if (not ((local1 at: temp0) isEmpty:))
							(= temp2 temp0)
							(break)
						)
					)
					(if (== temp0 (BAD_SELECTOR size:))
						(= BAD_SELECTOR temp3)
						(= local4 1)
						(self sel_825:)
					else
						(self sel_803: (local1 at: temp2))
					)
				)
			)
			((not BAD_SELECTOR)
				(if (< (= temp2 (- (BAD_SELECTOR sel_828:) 1)) 0)
					(= local3 1)
					(return)
				else
					(BAD_SELECTOR setPri: (- 15 (BAD_SELECTOR sel_828:)))
					(UpdateScreenItem BAD_SELECTOR)
					(= BAD_SELECTOR (local1 at: temp2))
					(BAD_SELECTOR setPri: 50 show:)
					(UpdateScreenItem BAD_SELECTOR)
					(if (BAD_SELECTOR isEmpty:)
						(self sel_826: 0)
					else
						(self sel_827:)
						(self sel_825:)
					)
				)
			)
			(else
				(self sel_827:)
				(self sel_825:)
			)
		)
	)

	(method (BAD_SELECTOR &tmp temp0 temp1 temp2 temp3)
		(= temp0 BAD_SELECTOR)
		(= BAD_SELECTOR 0)
		(if (not temp0)
			(= temp2 (BAD_SELECTOR at: (BAD_SELECTOR sel_828:)))
			(= temp3 0)
			(for ((= temp1 0)) (< temp1 (temp2 size:)) ((++ temp1))
				(if (temp2 at: temp1)
					(= temp3 temp1)
				)
			)
			(while 1
				(self sel_825:)
				(if (== BAD_SELECTOR temp3)
					(break)
				else
					(= BAD_SELECTOR (+ BAD_SELECTOR 1))
				)
			)
		else
			(while 1
				(self sel_825:)
				(if (< BAD_SELECTOR (- temp0 1))
					(= BAD_SELECTOR (+ BAD_SELECTOR 1))
				else
					(break)
				)
			)
		)
	)

	(method (BAD_SELECTOR &tmp temp0 temp1)
		(local2 eachElementDo: #dispose)
		(if (not BAD_SELECTOR)
			(BAD_SELECTOR show:)
			(topicHeader init: (BAD_SELECTOR at: (BAD_SELECTOR sel_828:)))
			(= BAD_SELECTOR 80)
		else
			(BAD_SELECTOR hide:)
			(= BAD_SELECTOR 62)
		)
		(= temp1 (BAD_SELECTOR at: (BAD_SELECTOR sel_828:)))
		(for ((= temp0 BAD_SELECTOR)) (< temp0 (temp1 size:)) ((++ temp0))
			(if (temp1 at: temp0)
				(if (not (self sel_805: temp0))
					(break)
				else
					(= BAD_SELECTOR temp0)
				)
			)
		)
		(if (and (>= temp0 (temp1 size:)) (not (local2 size:)))
			(return 0)
		else
			(return 1)
		)
	)

	(method (BAD_SELECTOR param1 &tmp temp0 temp1 temp2)
		(= temp0
			(noteButton
				new:
					BAD_SELECTOR
					param1
					(BAD_SELECTOR at: (BAD_SELECTOR sel_828:))
					((BAD_SELECTOR at: (BAD_SELECTOR sel_828:)) at: param1)
			)
		)
		(if (or (< (temp0 nsBottom:) 480) (== (local2 size:) 1))
			(while (< BAD_SELECTOR (temp0 nsBottom:))
				(+= BAD_SELECTOR 18)
			)
			(= temp2 (- BAD_SELECTOR (temp0 nsBottom:)))
			(+= BAD_SELECTOR 18)
			(if (<= temp2 5)
				(+= BAD_SELECTOR 18)
			)
			(return 1)
		else
			(temp0 dispose:)
			(return 0)
		)
	)

	(method (BAD_SELECTOR &tmp temp0 temp1 temp2)
		(= picture 14180)
		(plane drawPic: picture)
		(if (not BAD_SELECTOR)
			(= BAD_SELECTOR
				(IDArray
					with:
						(IntArray
							with:
								(IsFlag 183)
								(IsFlag 174)
								(IsFlag 878)
								(IsFlag 19)
								(IsFlag 303)
								(IsFlag 309)
								(IsFlag 309)
						)
						(IntArray
							with:
								(IsFlag 177)
								(IsFlag 882)
								(IsFlag 160)
								(IsFlag 162)
								(IsFlag 161)
								(IsFlag 163)
								(and
									(IsFlag 897)
									(IsFlag 881)
									(not (IsFlag 35))
								)
								(and
									(IsFlag 897)
									(IsFlag 881)
									(not (IsFlag 35))
								)
								(and (IsFlag 897) (IsFlag 35))
								(and (IsFlag 897) (IsFlag 35))
						)
						(IntArray
							with:
								(and (IsFlag 466) (IsFlag 36))
								(and (IsFlag 466) (not (IsFlag 36)))
								(IsFlag 883)
								(IsFlag 287)
								(IsFlag 288)
								(IsFlag 289)
						)
						(IntArray
							with:
								(IsFlag 180)
								(IsFlag 305)
								(IsFlag 579)
								(IsFlag 582)
								(and (IsFlag 584) (IsFlag 585))
								(and (IsFlag 586) (IsFlag 574))
								(IsFlag 587)
								(IsFlag 583)
								(IsFlag 588)
								(IsFlag 310)
								(and (IsFlag 601) (IsFlag 602))
								(and (IsFlag 599) (IsFlag 600))
								(IsFlag 622)
								(IsFlag 624)
								(IsFlag 578)
								(IsFlag 597)
								(IsFlag 1004)
								(IsFlag 598)
								(IsFlag 282)
								(and (IsFlag 283) (IsFlag 310))
								(IsFlag 286)
								(IsFlag 281)
								(IsFlag 613)
								(IsFlag 284)
								(IsFlag 290)
						)
						(IntArray with: (> gChapter 3) (IsFlag 307))
						(IntArray
							with:
								(IsFlag 579)
								(IsFlag 642)
								(IsFlag 623)
								(IsFlag 285)
								(IsFlag 296)
								(and (IsFlag 298) (IsFlag 299))
								(and
									(IsFlag 300)
									(IsFlag 285)
									(IsFlag 310)
								)
								(IsFlag 593)
								(IsFlag 594)
								(IsFlag 1020)
								(IsFlag 611)
								(IsFlag 808)
						)
				)
			)
			(= BAD_SELECTOR
				(IDArray
					with:
						(IntArray with: 231 231 231 136 137 138 138)
						(IntArray with: 240 240 240 240 240 240 240 240 240 240)
						(IntArray with: 241 241 241 141 142 143)
						(IntArray
							with:
								242
								144
								145
								146
								147
								148
								149
								150
								151
								152
								153
								154
								156
								157
								158
								159
								7
								160
								162
								163
								164
								165
								166
								167
								168
						)
						(IntArray with: 139 140)
						(IntArray
							with:
								169
								170
								171
								172
								173
								175
								176
								177
								178
								179
								180
								181
						)
				)
			)
			(if 0
				(for ((= temp0 0)) (< temp0 (BAD_SELECTOR size:)) ((++ temp0))
					(= temp2 (BAD_SELECTOR at: temp0))
					(for ((= temp1 0)) (< temp1 (temp2 size:)) ((++ temp1))
						(temp2 at: temp1 1)
					)
				)
			)
			(= BAD_SELECTOR
				(IntArray with: 14183 14184 14185 14186 14187 14188)
			)
		)
		(= BAD_SELECTOR 0)
		(if (or (not local1) (not (local1 size:)))
			(= BAD_SELECTOR -5)
			(if (not local1)
				(= local1 (Cast new:))
				(plane addCast: local1)
			)
			(if (not local2)
				(= local2 (Cast new:))
				(plane addCast: local2)
			)
			(for ((= temp0 0)) (< temp0 (BAD_SELECTOR size:)) ((++ temp0))
				(= temp2 (BAD_SELECTOR at: temp0))
				(for ((= temp1 0)) (< temp1 (temp2 size:)) ((++ temp1))
					(if (temp2 at: temp1)
						(tabButton new: 0 temp0 BAD_SELECTOR)
						(break)
					)
				)
				(if (== temp1 (temp2 size:))
					(tabButton new: 1 temp0 BAD_SELECTOR)
				)
				(+= BAD_SELECTOR 75)
			)
			(gGame handsOn:)
		else
			(local1 eachElementDo: #show)
		)
	)

	(method (handleEvent event)
		(event localize: plane)
		(if (not (event type:))
			(if (gUser sel_715:)
				((gUser sel_715:) handleEvent: event)
			)
			(event claimed: 1)
			(return)
		)
		(if (& (event type:) $000a) ; evKEYUP | evMOUSERELEASE
			(event claimed: 1)
			(return)
		)
		(event type: (| (event type:) evVERB))
		(if plane
			(event
				claimed: ((plane casts:) eachElementDo: #handleEvent event)
			)
		)
		(if (not (event claimed:))
			(gFeatures handleEvent: event)
		)
		(if local0
			(= local0 0)
			(gCurRoom setInset: 0)
		)
		(event claimed: 1)
	)

	(method (drawInset)
		(if (!= picture -1)
			(plane drawPic: picture)
		)
		(plane posn: x y priority: (+ (GetHighPlanePri) 1))
		(UpdatePlane plane)
	)

	(method (dispose &tmp temp0)
		(if BAD_SELECTOR
			(((gUser sel_715:) sel_718:) release: dispose:)
			((gUser sel_715:) sel_718: BAD_SELECTOR)
			(= BAD_SELECTOR 0)
		)
		(if BAD_SELECTOR
			(for ((= temp0 0)) (< temp0 (BAD_SELECTOR size:)) ((++ temp0))
				((BAD_SELECTOR at: temp0) dispose:)
			)
			(BAD_SELECTOR dispose:)
			(= BAD_SELECTOR 0)
		)
		(if BAD_SELECTOR
			(for ((= temp0 0)) (< temp0 (BAD_SELECTOR size:)) ((++ temp0))
				((BAD_SELECTOR at: temp0) dispose:)
			)
			(BAD_SELECTOR dispose:)
			(= BAD_SELECTOR 0)
		)
		(if BAD_SELECTOR
			(BAD_SELECTOR dispose:)
			(= BAD_SELECTOR 0)
		)
		(gPanels delete: self)
		(super dispose: &rest)
		(= local1 (= plane 0))
		(= local2 0)
		(= local0 0)
	)
)

(instance pageForward of ExitFeature
	(properties
		nsLeft 590
		nsRight 640
		nsBottom 480
		BAD_SELECTOR 2
	)

	(method (setCursor param1)
		(param1 view: 993)
		(param1 loop: 1)
		(param1 cel: 0)
	)

	(method (onMe &tmp temp0)
		(if local4
			(return 0)
		else
			(super onMe: &rest)
		)
	)

	(method (doVerb)
		(gGame handsOff:)
		(= local3 0)
		(Notebook sel_826: 1)
		(gGame handsOn:)
	)
)

(instance pageBackward of ExitFeature
	(properties
		nsRight 50
		nsBottom 480
		BAD_SELECTOR 6
	)

	(method (init)
		(= nsBottom (- (exitButton nsTop:) 10))
		(super init: &rest)
	)

	(method (setCursor param1)
		(param1 view: 993)
		(param1 loop: 0)
		(param1 cel: 0)
	)

	(method (onMe &tmp temp0)
		(if local3
			(return 0)
		else
			(super onMe: &rest)
		)
	)

	(method (doVerb)
		(gGame handsOff:)
		(= local4 0)
		(Notebook sel_826: 0)
		(gGame handsOn:)
	)
)

(instance exitButton of Prop
	(properties
		x 8
		y 440
		view 140
		loop 11
	)

	(method (doVerb)
		(= local0 1)
	)
)

(instance topicHeader of View
	(properties
		x 150
		y 44
	)

	(method (onMe)
		(return 0)
	)

	(method (init param1)
		(= view param1)
		(super init: local2)
	)
)

(class noteButton of Prop
	(properties)

	(method (new param1 param2 param3 param4 &tmp temp0)
		(= temp0 (super new:))
		(temp0
			view: param3
			cel: (+ param2 1)
			noun: param4
			x: 150
			y: param1
			setPri: 50
			init: local2
			signal: (& (temp0 signal:) $efff)
		)
		(return temp0)
	)

	(method (init)
		(super init: local2)
	)

	(method (cue)
		(gGame handsOn:)
	)

	(method (doVerb)
		(gGame handsOff:)
		(switch noun
			(138
				(if (== cel 6)
					(gMessager sayRange: noun 62 0 1 2 self 22) ; "Okay. I'm going to log this, even though I have no idea if it's complete garbage or not, just in case it means something later on. Mrs. Smith did Gabriel's tarot and mine. Basically, she claims that there's this "high priestess" -- a powerful feminine spirit guide -- trying to warn Gabriel about this Black Wolf stuff and assist him because Gabriel is in deep doo-doo."
				else
					(gMessager sayRange: noun 62 0 3 4 self 22) ; "Also, I'm supposed to help by "using my positive-feeling energy for Gabriel." Unfortunately, I don't have any, so my pissed-off-feeling energy will have to do."
				)
			)
			(231
				(gMessager say: noun 62 0 cel self 22)
			)
			(240
				(gMessager say: noun 62 0 cel self 22)
			)
			(241
				(gMessager say: noun 62 0 cel self 22)
			)
			(else
				(gMessager say: noun 62 0 0 self 22)
			)
		)
	)
)

(class tabButton of View
	(properties
		view 14182
		BAD_SELECTOR 0
		isEmpty 0
	)

	(method (onMe)
		(if (or (< BAD_SELECTOR 0) isEmpty)
			(return 0)
		else
			(return (super onMe: &rest))
		)
	)

	(method (new param1 param2 param3 &tmp temp0)
		(= temp0 (super new:))
		(temp0
			view: 14182
			cel:
				(if (not param1)
					(+ param2 1)
				else
					0
				)
			sel_828: param2
			isEmpty: param1
			x: 545
			y: param3
			setPri: (- 15 param2)
			init: local1
		)
	)

	(method (doVerb)
		(gGame handsOff:)
		(Notebook sel_803: self)
		(gGame handsOn:)
	)
)

