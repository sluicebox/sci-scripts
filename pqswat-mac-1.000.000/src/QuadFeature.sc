;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use Plane)
(use Print)
(use Osc)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(procedure (localproc_0 param1 param2 param3)
	(if (param1 param2:)
		((param1 param2:) isKindOf: param3)
	)
)

(class QuadFeature of Feature
	(properties
		quadSignal 16
		quad12_Signal 0
		quad34_Signal 0
		mView 0
		mLoop 0
		mCel 0
		_quad1 0
		_quad2 0
		_quad3 0
		_quad4 0
		whichQuad 0
	)

	(method (init)
		(super init: gFtrInitializer &rest)
	)

	(method (setClickedOn))

	(method (onMe param1 &tmp temp0)
		(= temp0 (param1 plane:))
		(param1 globalize:)
		(= whichQuad
			(or
				(and (localproc_0 self 918 Polygon) (_quad1 onMe: param1) 1)
				(and (localproc_0 self 919 Polygon) (_quad2 onMe: param1) 2)
				(and (localproc_0 self 920 Polygon) (_quad3 onMe: param1) 3)
				(and (localproc_0 self 921 Polygon) (_quad4 onMe: param1) 4)
			)
		)
		(if temp0
			(param1 localize: temp0)
		)
		(if (not whichQuad)
			(return (super onMe: param1))
		)
		(return whichQuad)
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(if (!= theVerb 29)
			(return)
		)
		(= temp1 quad12_Signal)
		(if whichQuad
			(switch whichQuad
				(3
					(= temp1 (>> quad34_Signal $0010))
				)
				(4
					(= temp1 (>> quad34_Signal $0010))
				)
			)
			(&= temp1 $00ff)
		else
			(= temp1 quadSignal)
		)
		(cond
			((& temp1 $0001)
				(self doAvi:)
			)
			((& temp1 $0002)
				(self doDetail:)
			)
			((& temp1 $0004)
				(self doClassified:)
			)
			((& temp1 $0008)
				(self doView:)
			)
			((& temp1 $0010)
				(self doMsg: theVerb)
			)
		)
	)

	(method (setupDetail)
		(if (localproc_0 self 918 Feature)
			(_quad1 init: plane)
		)
		(if (localproc_0 self 919 Feature)
			(_quad2 init: plane)
		)
		(if (localproc_0 self 920 Feature)
			(_quad3 init: plane)
		)
		(if (localproc_0 self 921 Feature)
			(_quad4 init: plane)
		)
	)

	(method (clearDetail)
		(if (localproc_0 self 918 Polygon)
			(_quad1 dispose:)
		)
		(if (localproc_0 self 919 Polygon)
			(_quad2 dispose:)
		)
		(if (localproc_0 self 920 Polygon)
			(_quad3 dispose:)
		)
		(if (localproc_0 self 921 Polygon)
			(_quad4 dispose:)
		)
	)

	(method (doAvi)
		(Prints {Show an AVI})
	)

	(method (doDetail)
		(Prints {show another detail})
	)

	(method (doView)
		(Prints {display view})
	)

	(method (doClassified)
		(Prints {Classified})
	)

	(method (doMsg)
		(Prints {print msg})
	)
)

(class GalleryView of View
	(properties
		sightAngle 180
		hView -1
		hLoop -1
		hCel -1
		mView -1
		mLoop -1
		mCel -1
		ImOnPage 0
		rowNum 0
		colNum 0
		numInRow 0
		_quad1 0
		_quad2 0
		_quad3 0
		_quad4 0
	)

	(method (init)
		(if (== hView -1)
			(= hView view)
		)
		(if (== hLoop -1)
			(= hLoop loop)
		)
		(if (== hCel -1)
			(= hCel (+ cel 1))
		)
		(if (== mView -1)
			(= mView view)
		)
		(if (== mLoop -1)
			(= mLoop loop)
		)
		(if (== mCel -1)
			(= mCel cel)
		)
		(self setPri: 100)
		(super init: &rest)
		(&= signal $efff)
	)

	(method (doVerb)
		(gCurRoom setHilite: self)
	)

	(method (setupDetail)
		(if _quad1
			(_quad1 init: plane)
		)
		(if _quad2
			(_quad2 init: plane)
		)
		(if _quad3
			(_quad3 init: plane)
		)
		(if _quad4
			(_quad4 init: plane)
		)
	)

	(method (clearDetail)
		(if _quad1
			(_quad1 dispose:)
		)
		(if _quad2
			(_quad2 dispose:)
		)
		(if _quad3
			(_quad3 dispose:)
		)
		(if _quad4
			(_quad4 dispose:)
		)
	)
)

(class GalleryRoom of PQRoom
	(properties
		gPlane 0
		gCast 0
		galNumPages 0
		galCurPage 1
		curItem 0
		hiLiteObj 0
		magnified 0
		detailProp 0
		gPLeft 30
		gPTop 31
		gPRight 518
		gPBottom 328
		detailList 0
		detail_butn 0
		gear_butn 0
	)

	(method (init)
		(super init: &rest)
		((= gPlane (Plane new:))
			init: gPLeft gPTop gPRight gPBottom
			priority: 5
			picture: -2
			addCast: gCast
		)
		(gCast plane: gPlane)
		(self createGallery:)
		(= hiLiteObj (View new:))
		(self setHilite: (gCast at: 0) 1)
		(UpdatePlane gPlane)
	)

	(method (dispose)
		(gPlane dispose:)
		(super dispose:)
	)

	(method (createGallery &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21)
		(= temp11 (Set new:))
		(= temp18 (Set new:))
		(= temp21 (= temp19 0))
		(= temp2 1)
		(= temp0 10)
		(= temp9 10)
		(= temp3 (= temp10 (= temp4 (= temp5 (= temp6 0)))))
		(= temp7 (- (gPlane right:) (gPlane left:)))
		(= temp8 (- (gPlane bottom:) (gPlane top:)))
		(for ((= temp16 (KList 3 (gCast elements:)))) 1 ((= temp16 temp17)) ; FirstNode
			(= temp6 0)
			(if temp16
				(= temp17 (KList 6 temp16)) ; NextNode
				(= temp6 (KList 8 temp16)) ; NodeValue
			)
			(if temp6
				(temp6 init: gCast)
				(= temp4 (CelWide (temp6 hView:) (temp6 hLoop:) (temp6 hCel:)))
				(if
					(>
						(= temp5
							(CelHigh
								(temp6 hView:)
								(temp6 hLoop:)
								(temp6 hCel:)
							)
						)
						temp19
					)
					(= temp19 temp5)
				)
			)
			(if
				(or
					(not temp6)
					(>= (temp11 size:) 3)
					(> (+ temp0 temp4 10) (- temp7 10))
				)
				(= temp14
					(/ (- (- (- temp7 10) 10) temp10) (+ (temp11 size:) 1))
				)
				(= temp15 10)
				(for ((= temp13 0)) (< temp13 (temp11 size:)) ((++ temp13))
					(= temp12 (temp11 at: temp13))
					(temp12
						posn: (+ temp15 temp14) temp9
						ImOnPage: temp2
						numInRow: (temp11 size:)
					)
					(+=
						temp15
						(+
							temp14
							(CelWide
								(temp12 hView:)
								(temp12 hLoop:)
								(temp12 hCel:)
							)
						)
					)
					(UpdateScreenItem temp12)
				)
				(temp11 release:)
				(= temp0 10)
				(+= temp9 (+ temp19 10))
				(= temp10 0)
				(++ temp3)
				(++ temp21)
			)
			(+= temp10 temp4)
			(if (> (+ temp9 temp19) (- (* temp8 temp2) 10))
				(= temp20 (/ (- temp8 (* temp19 temp21)) (+ temp21 1)))
				(= temp9 (+ (* temp8 (- temp2 1)) temp20))
				(= temp21 -1)
				(for ((= temp13 0)) (< temp13 (temp18 size:)) ((++ temp13))
					(= temp12 (temp18 at: temp13))
					(if (== temp21 -1)
						(= temp21 (temp12 rowNum:))
					)
					(if (!= temp21 (temp12 rowNum:))
						(= temp21 (temp12 rowNum:))
						(+= temp9 (+ temp19 temp20))
					)
					(temp12 y: temp9)
					(UpdateScreenItem temp12)
				)
				(temp18 release:)
				(= temp9 (+ (* temp8 temp2) 10))
				(if temp6
					(++ temp2)
				)
				(= temp19 0)
				(= temp21 0)
			)
			(if temp6
				(temp6
					posn: temp0 temp9
					ImOnPage: temp2
					rowNum: temp3
					colNum: (+ (temp11 size:) 1)
				)
				(UpdateScreenItem temp6)
				(if (not (temp11 size:))
					(= temp0 (+ 10 temp4))
				else
					(+= temp0 (+ 10 temp4))
				)
			else
				(break)
			)
			(temp11 add: temp6)
			(temp18 add: temp6)
		)
		(temp11 release: dispose:)
		(temp18 release: dispose:)
		(= galNumPages temp2)
	)

	(method (slideGalPlane param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (or magnified (not param1) (not gPlane))
			(return)
		)
		(= temp4 (+ (= temp4 (gCurRoom galCurPage:)) param1))
		(= temp3 (- (gPlane bottom:) (gPlane top:)))
		(if (== (Min galNumPages (Max 1 temp4)) galCurPage)
			(return)
		)
		(= galCurPage temp4)
		(= temp1 (- (* (/ temp3 6) param1)))
		(= temp2 (- (* temp3 param1)))
		(= temp0 0)
		(while (!= temp0 temp2)
			(if
				(or
					(and (> temp1 0) (> (+ temp1 temp0) temp2))
					(and (< temp1 0) (< (+ temp1 temp0) temp2))
				)
				(= temp1 (- temp2 temp0))
			)
			(+= temp0 temp1)
			(MovePlaneItems gPlane 0 temp1 1)
			(UpdatePlane gPlane)
			(FrameOut)
		)
	)

	(method (setHilite param1)
		(= curItem param1)
		(hiLiteObj
			view: (curItem hView:)
			loop: (curItem hLoop:)
			cel: (curItem hCel:)
			posn: (curItem x:) (curItem y:)
			setPri: 500
			init: gCast
		)
		(UpdateScreenItem hiLiteObj)
		(self slideGalPlane: (- (curItem ImOnPage:) galCurPage))
	)

	(method (moveHilite param1 param2 &tmp temp0 temp1 temp2 temp3 [temp4 2])
		(if magnified
			(return)
		)
		(if (< (= temp0 (+ (gCast indexOf: curItem) param1 (* param2 3))) 0)
			(= temp0 0)
		)
		(if (>= temp0 (- (gCast size:) 1))
			(= temp0 (- (gCast size:) 2))
		)
		(= temp3 (gCast at: temp0))
		(= temp1 (curItem rowNum:))
		(if
			(and
				(!= param2 0)
				(or
					(!= (temp3 rowNum:) (+ (curItem rowNum:) param2))
					(!= (curItem numInRow:) 3)
					(!= (temp3 numInRow:) 3)
				)
			)
			(= temp0 (gCast indexOf: curItem))
			(if (> param2 0)
				0
				(while (<= temp0 (- (gCast size:) 2))
					(= temp3 (gCast at: temp0))
					(if
						(and
							(== (temp3 rowNum:) (+ temp1 param2))
							(== (temp3 colNum:) 1)
						)
						(break)
					)
					(++ temp0)
				)
			else
				0
				(while (> temp0 0)
					(= temp3 (gCast at: temp0))
					(if
						(and
							(== (temp3 rowNum:) (+ temp1 param2))
							(== (temp3 colNum:) 1)
						)
						(break)
					)
					(-- temp0)
				)
			)
		)
		(self setHilite: temp3)
	)

	(method (showGear &tmp temp0 temp1 temp2 temp3)
		(if (not detailList)
			(return 0)
		)
		(= temp3 (detailList at: (- (detailList size:) 1)))
		(if (temp3 respondsTo: #clearDetail)
			(temp3 clearDetail:)
		)
		(detailList release: dispose:)
		(= detailList 0)
		(= temp0 (- (gPlane right:) (gPlane left:)))
		(= temp1 (- (gPlane bottom:) (gPlane top:)))
		(Palette 2 42 254 0) ; PalIntensity
		(FrameOut)
		(MovePlaneItems gPlane (* temp0 1) 0 1)
		(gTheDoits delete: detailProp)
		(detailProp dispose:)
		(= magnified (= detailProp 0))
		(FrameOut)
		(Palette 2 42 254 100) ; PalIntensity
		(FrameOut)
		(return 1)
	)

	(method (showDetail param1 &tmp temp0 [temp1 4])
		(if (not detailList)
			((= detailList (List new:)) add:)
		)
		(if
			(and
				(detailList size:)
				(== param1 (detailList at: (- (detailList size:) 1)))
			)
			(return 0)
		)
		(detailList addToEnd: param1)
		(= temp0 (- (gPlane right:) (gPlane left:)))
		(Palette 2 42 254 0) ; PalIntensity
		(FrameOut)
		(if (not magnified)
			(= magnified 1)
			(MovePlaneItems gPlane (* temp0 -1) 0 1)
		)
		(if (not detailProp)
			(= detailProp (Prop new:))
		)
		(gTheDoits add: detailProp)
		(self setDetailView: (param1 mView:) (param1 mLoop:) (param1 mCel:))
		(param1 setupDetail:)
		(Palette 2 42 254 100) ; PalIntensity
		(FrameOut)
		(return 1)
	)

	(method (setDetailView param1 param2 param3 &tmp [temp0 4])
		(if (!= param1 (detailProp view:))
			(Palette 2 42 254 0) ; PalIntensity
			(FrameOut)
		)
		(detailProp
			view: param1
			setLoop: param2
			setCel: param3
			posn: -7 -7
			setPri: 200
		)
		(if (not (gCast contains: detailProp))
			(detailProp init: gCast)
		)
		(if (detailProp isNotHidden:)
			(UpdateScreenItem detailProp)
		)
		(FrameOut)
		(Palette 2 42 254 100) ; PalIntensity
		(FrameOut)
	)

	(method (showPropAni param1 param2 param3)
		(if (!= param1 (detailProp view:))
			(Palette 2 42 254 0) ; PalIntensity
			(FrameOut)
		)
		(detailProp
			view: param1
			setLoop: param2
			setCel: param3
			cycleSpeed: 17
			posn: -7 -7
			init: gCast
			setCycle: Osc -1
		)
		(UpdateScreenItem detailProp)
		(FrameOut)
		(Palette 2 42 254 100) ; PalIntensity
		(FrameOut)
	)

	(method (showVMD param1 param2 &tmp temp0 temp1)
		(= temp1 (gBackMusic number:))
		(detailProp setCycle: 0)
		(self setDetailView: 1 0 0)
		(proc4_17 param1 134 76)
		(Palette 2 42 254 0) ; PalIntensity
		(FrameOut)
		(self setDetailView: (param2 mView:) (param2 mLoop:) (param2 mCel:))
		(gBackMusic number: temp1 setLoop: -1 play:)
	)
)

