;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64893)
(include sci.sh)
(use Main)
(use TiledBitmap)
(use soFlashCyberSniff)
(use Plane)
(use Str)
(use Actor)
(use System)

(class MenuItem of View
	(properties
		signal 1
		oNotify 0
		nSelectMethod 771
		chShortcut 0
		nModifiers 4
		userData 0
		nModule -1
		nNoun 0
		nVerb 0
		nCase 0
		nSeq 1
		oText 0
		bHilited 0
		bChecked 0
		nWidth 0
		nHeight 0
		oChildren 0
		oParent 0
		oHandler 0
		nLevel 0
		voCheck 0
		nMinTextWidth 0
		bmpOff 0
		bmpOn 0
		oRightString 0
		oLeftString 0
		nTextHeight 0
		nRightWidth 0
		nLeftWidth 0
		nGapWidth 0
	)

	(method (init param1 param2 param3)
		(= oParent param1)
		(= oHandler param2)
		(= oChildren (List new:))
		(= nLevel param3)
		(= bChecked (= bHilited 0))
		(self addItems:)
		(self setup: oHandler)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
		(oChildren eachElementDo: #init self oHandler (+ nLevel 1) &rest)
	)

	(method (addChild param1)
		(oChildren addToEnd: param1)
		(self setChildWidths:)
		(param1 init: self oHandler (+ nLevel 1) (oHandler plane:) &rest)
		(if (not (self isNotHidden:))
			(param1 hide:)
		)
		(oHandler setChildPos:)
	)

	(method (setChildWidths &tmp temp0 temp1 temp2 temp3)
		(= temp1 0)
		(for
			((= temp2 (oChildren first:)))
			temp2
			((= temp2 (oChildren next: temp2)))
			
			(= temp3 (KList 8 temp2)) ; NodeValue
			(if (> (= temp0 (temp3 calcTextWidths: oHandler)) temp1)
				(= temp1 temp0)
			)
		)
		(oChildren eachElementDo: #setMinTextWidth temp1)
	)

	(method (setup &tmp [temp0 2] temp2 temp3 temp4 temp5 temp6 temp7)
		(if (== (oHandler nStyle:) 0)
			(= nWidth (CelWide view loop 0))
			(= nHeight (CelHigh view loop 0))
			(return)
		)
		(if (not nLeftWidth)
			(self calcTextWidths:)
		)
		(self setChildWidths:)
		(if (== nMinTextWidth 0)
			(= nMinTextWidth (+ nLeftWidth nGapWidth nRightWidth))
		)
		(= nWidth
			(+
				(oHandler nHBorder:)
				(self getCheckWidth:)
				nMinTextWidth
				(oHandler nHBorder:)
			)
		)
		(= nHeight
			(-
				(+ (oHandler nVBorder:) nTextHeight (oHandler nVBorder:))
				(oHandler nLeading:)
			)
		)
		(= temp4 (+ (oHandler nHBorder:) (self getCheckWidth:)))
		(= temp5 (oHandler nVBorder:))
		(if bitmap
			(if bmpOff
				(= bitmap 0)
				(Bitmap 1 bmpOff) ; Dispose
				(= bmpOff 0)
				(Bitmap 1 bmpOn) ; Dispose
				(= bmpOn 0)
			else
				(Bitmap 1 bitmap) ; Dispose
				(= bitmap 0)
			)
		)
		(switch (oHandler nStyle:)
			(1
				(= bmpOff
					(Bitmap
						0 ; Create
						nWidth
						nHeight
						255
						(oHandler nUnhilitedBack:)
						640
						480
						1
					)
				)
				(Bitmap
					5 ; AddRect
					bmpOff
					0
					0
					(- nWidth 1)
					(- nHeight 1)
					(oHandler nUnhilitedBack:)
				)
				(= bmpOn
					(Bitmap
						0 ; Create
						nWidth
						nHeight
						255
						(oHandler nHilitedBack:)
						640
						480
						1
					)
				)
				(Bitmap
					5 ; AddRect
					bmpOn
					0
					0
					(- nWidth 1)
					(- nHeight 1)
					(oHandler nHilitedBack:)
				)
			)
			(2
				(TiledBitmap
					init:
						(oHandler vUnhilited:)
						nWidth
						nHeight
						0
						(oHandler bBorder:)
				)
				(= bmpOff (TiledBitmap getBitmap: 1))
				(= temp2 (TiledBitmap nWidth:))
				(= temp3 (TiledBitmap nHeight:))
				(TiledBitmap
					init:
						(oHandler vHilited:)
						nWidth
						nHeight
						0
						(oHandler bBorder:)
				)
				(= bmpOn (TiledBitmap getBitmap: 1))
				(+= temp4 (TiledBitmap nOffsetX:))
				(+= temp5 (TiledBitmap nOffsetY:))
				(= nWidth (TiledBitmap nWidth:))
				(= nHeight (TiledBitmap nHeight:))
				(or (!= nWidth temp2) (!= nHeight temp3))
			)
		)
		(Bitmap
			4 ; AddText
			bmpOff
			(oLeftString data:)
			temp4
			temp5
			(- (+ temp4 nLeftWidth) 1)
			(- (+ temp5 nTextHeight) 1)
			(oHandler nUnhilitedFore:)
			255
			255
			(oHandler nFont:)
			0
			255
			0
		)
		(Bitmap
			4 ; AddText
			bmpOn
			(oLeftString data:)
			temp4
			temp5
			(- (+ temp4 nLeftWidth) 1)
			(- (+ temp5 nTextHeight) 1)
			(oHandler nHilitedFore:)
			255
			255
			(oHandler nFont:)
			0
			255
			0
		)
		(if oRightString
			(= temp6 (- (+ temp4 nMinTextWidth) nRightWidth))
			(Bitmap
				4 ; AddText
				bmpOff
				(oRightString data:)
				temp6
				temp5
				(- (+ temp6 nRightWidth) 1)
				(- (+ temp5 nTextHeight) 1)
				(oHandler nUnhilitedFore:)
				255
				255
				(oHandler nFont:)
				0
				255
				0
			)
			(Bitmap
				4 ; AddText
				bmpOn
				(oRightString data:)
				temp6
				temp5
				(- (+ temp6 nRightWidth) 1)
				(- (+ temp5 nTextHeight) 1)
				(oHandler nHilitedFore:)
				255
				255
				(oHandler nFont:)
				0
				255
				0
			)
		)
		(= bitmap bmpOff)
	)

	(method (setMinTextWidth param1)
		(= nMinTextWidth param1)
		(= nWidth
			(+
				(oHandler nHBorder:)
				(self getCheckWidth:)
				nMinTextWidth
				(oHandler nHBorder:)
			)
		)
		(= nHeight
			(-
				(+ (oHandler nVBorder:) nTextHeight (oHandler nVBorder:))
				(oHandler nLeading:)
			)
		)
	)

	(method (getCheckWidth)
		(if (and (not (oHandler bPopup:)) (== nLevel 1))
			(return 0)
		else
			(return (oHandler getCheckWidth:))
		)
	)

	(method (calcTextWidths param1 &tmp temp0 temp1 temp2)
		(if argc
			(= oHandler param1)
		)
		(if (not oText)
			(= oText (MakeMessageText nNoun nVerb nCase nSeq nModule))
			(if (not oText)
				(= oText (Str with: {default}))
			)
		)
		(if (not (IsStringObject oText))
			(= temp0 oText)
			(= oText (Str with: temp0))
			(proc64896_7 temp0)
		)
		(if (not oLeftString)
			(= temp1 (oText indexOf: 124))
			(= temp2 (oText size:))
			(if (== temp1 -1)
				(= oLeftString (Str with: oText))
				(= oRightString 0)
			else
				(= oLeftString (oText subStr: 0 temp1))
				(if (== (++ temp1) temp2)
					(= oRightString 0)
				else
					(= oRightString
						(oText subStr: temp1 (- (oText size:) temp1))
					)
				)
			)
			(= nTextHeight (GetTextHeight oLeftString (oHandler nFont:) 0))
			(= nLeftWidth (GetTextWidth oLeftString (oHandler nFont:) 0))
			(if oRightString
				(= nRightWidth (GetTextWidth oRightString (oHandler nFont:) 0))
				(= nGapWidth (GetTextWidth {W} (oHandler nFont:) 0))
			else
				(= nGapWidth (= nRightWidth 0))
			)
		)
		(return (+ nLeftWidth nGapWidth nRightWidth))
	)

	(method (setChildPos param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
		(if (or (not oChildren) (not (oChildren size:)))
			(return)
		)
		(= temp6 0)
		(= temp7 ((oChildren at: 0) nWidth:))
		(= temp10 (oChildren size:))
		(for ((= temp9 0)) (< temp9 temp10) ((++ temp9))
			(+= temp6 ((oChildren at: temp9) nHeight:))
		)
		(= temp4 (+ param1 temp7))
		(= temp8 (+ param2 temp6))
		(if (< param1 0)
			(= param1 0)
		)
		(if (< param2 0)
			(= param2 0)
		)
		(if (> temp4 gLastScreenX)
			(-= param1 (- temp4 gLastScreenX))
		)
		(if (> temp8 gLastScreenY)
			(-= param2 (- temp8 gLastScreenY))
		)
		(for
			((= temp0 (oChildren first:)))
			temp0
			((= temp0 (oChildren next: temp0)))
			
			(= temp1 (KList 8 temp0)) ; NodeValue
			(temp1 posn: param1 param2)
			(= temp2 (temp1 oChildren:))
			(= temp5 1)
			(if (and temp2 (temp2 size:))
				(= temp3 ((temp2 at: 0) nWidth:))
				(if (> (= temp4 (+ param1 (temp1 nWidth:) temp3)) gLastScreenX)
					(= temp5 0)
				)
			)
			(if temp5
				(temp1 setChildPos: (+ param1 (temp1 nWidth:)) param2)
			else
				(temp1 setChildPos: (- param1 temp3) param2)
			)
			(+= param2 (temp1 nHeight:))
		)
	)

	(method (posn param1 param2)
		(super posn: param1 param2 &rest)
		(if voCheck
			(voCheck posn: param1 param2)
			(if (voCheck isNotHidden:)
				(UpdateScreenItem voCheck)
			)
			(SetNowSeen voCheck)
		)
		(if (self isNotHidden:)
			(UpdateScreenItem self)
			(SetNowSeen self)
		)
	)

	(method (addItems))

	(method (doSelect)
		(if oNotify
			(Eval oNotify nSelectMethod userData)
		)
	)

	(method (setCel &tmp temp0)
		(cond
			((== (oHandler nStyle:) 0)
				(= temp0 0)
				(if bHilited
					(+= temp0 1)
				)
				(if (!= cel temp0)
					(= cel temp0)
				)
			)
			(bHilited
				(= bitmap bmpOn)
			)
			(else
				(= bitmap bmpOff)
			)
		)
		(cond
			(bChecked
				(if (not voCheck)
					(= voCheck (oHandler getCheckView: self))
				)
			)
			(voCheck
				(voCheck dispose:)
				(= voCheck 0)
			)
		)
		(if (self isNotHidden:)
			(UpdateScreenItem self)
		)
	)

	(method (hide &tmp temp0)
		(if (not (self isNotHidden:))
			(return)
		)
		(self unhilite:)
		(oChildren eachElementDo: #hide)
		(super hide: &rest)
		(if voCheck
			(voCheck hide:)
		)
		(if (and (!= (oHandler nStyle:) 0) bitmap)
			(if bmpOff
				(= bitmap 0)
				(Bitmap 1 bmpOff) ; Dispose
				(= bmpOff 0)
				(Bitmap 1 bmpOn) ; Dispose
				(= bmpOn 0)
			else
				(Bitmap 1 bitmap) ; Dispose
				(= bitmap 0)
			)
		)
	)

	(method (show)
		(if (and (!= (oHandler nStyle:) 0) (not bitmap))
			(self setup:)
		)
		(self checkStatus:)
		(super show: &rest)
		(if voCheck
			(voCheck show:)
		)
	)

	(method (checkStatus))

	(method (hilite)
		(if bHilited
			(return)
		)
		(= bHilited 1)
		(self setCel:)
		(oChildren eachElementDo: #show)
		(oChildren eachElementDo: #unhilite)
		(oParent doAllButMe: self 989)
	)

	(method (unhilite)
		(if (not bHilited)
			(return)
		)
		(= bHilited 0)
		(self setCel:)
		(oChildren eachElementDo: #hide)
	)

	(method (check)
		(= bChecked 1)
		(self setCel:)
	)

	(method (uncheck)
		(= bChecked 0)
		(self setCel:)
	)

	(method (doAllButMe param1 param2 &tmp temp0 temp1)
		(for
			((= temp0 (oChildren first:)))
			temp0
			((= temp0 (oChildren next: temp0)))
			
			(if (!= (= temp1 (KList 8 temp0)) param1) ; NodeValue
				(temp1 param2: &rest)
			)
		)
	)

	(method (handleEvent event)
		(if (== (event type:) evKEYBOARD)
			(if
				(and
					(== (event message:) chShortcut)
					(== (event modifiers:) nModifiers)
				)
				(oHandler hide:)
				(event claimed: 1)
				(self doSelect:)
			else
				(oChildren eachElementDo: #handleEvent event)
			)
			(event claimed:)
			(return)
		)
		(if (self onMe: event)
			(gOEventHandler changeCursor: self)
			(if (== (event type:) evMOUSEBUTTON)
				(gOEventHandler registerEventHog: oHandler)
				(oHandler bMouseDown: 1)
			)
			(cond
				((or (oHandler bPopup:) (> nLevel 1))
					(self hilite:)
				)
				((oHandler bMouseDown:)
					(self hilite:)
				)
			)
			(if (and (== (event type:) evMOUSERELEASE) (== (oChildren size:) 0))
				(self unhilite:)
				(oHandler hide:)
				(oHandler nReturn: userData)
				(self doSelect:)
				(if (and (== gCurRoomNum 110) (not (oHandler bPopup:))) ; ro110
					(gCurRoom notify: 3)
				)
			)
			(event claimed: 1)
			(return 1)
		else
			(if (== (oChildren size:) 0)
				(self unhilite:)
			)
			(if bHilited
				(oChildren eachElementDo: #handleEvent event)
			)
			(event claimed:)
			(return)
		)
	)

	(method (dispose)
		(if oChildren
			(oChildren release:)
			(oChildren dispose:)
			(= oChildren 0)
		)
		(if oText
			(proc64896_7 oText)
			(= oText 0)
		)
		(if oLeftString
			(proc64896_7 oLeftString)
			(= oLeftString 0)
		)
		(if oRightString
			(proc64896_7 oRightString)
			(= oRightString 0)
		)
		(if bitmap
			(if bmpOff
				(= bitmap 0)
				(Bitmap 1 bmpOff) ; Dispose
				(= bmpOff 0)
				(Bitmap 1 bmpOn) ; Dispose
				(= bmpOn 0)
			else
				(Bitmap 1 bitmap) ; Dispose
				(= bitmap 0)
			)
		)
		(super dispose: &rest)
	)
)

(class MenuHeader of MenuItem
	(properties)

	(method (setCel))

	(method (setup &tmp [temp0 4] temp4 temp5 [temp6 2] temp8)
		(if (== (oHandler nStyle:) 0)
			(= nWidth (CelWide view loop 0))
			(= nHeight (CelHigh view loop 0))
			(return)
		)
		(if (not nLeftWidth)
			(self calcTextWidths:)
		)
		(self setChildWidths:)
		(if (== nMinTextWidth 0)
			(= nMinTextWidth (+ nLeftWidth nGapWidth nRightWidth))
		)
		(= nWidth
			(+
				(oHandler nHBorder:)
				(self getCheckWidth:)
				nMinTextWidth
				(oHandler nHBorder:)
			)
		)
		(= nHeight
			(-
				(+ (oHandler nVBorder:) nTextHeight (oHandler nVBorder:))
				(oHandler nLeading:)
			)
		)
		(= temp4 (+ (oHandler nHBorder:) (self getCheckWidth:)))
		(= temp5 (oHandler nVBorder:))
		(if bitmap
			(if bmpOff
				(= bitmap 0)
				(Bitmap 1 bmpOff) ; Dispose
				(= bmpOff 0)
				(Bitmap 1 bmpOn) ; Dispose
				(= bmpOn 0)
			else
				(Bitmap 1 bitmap) ; Dispose
				(= bitmap 0)
			)
		)
		(switch (oHandler nStyle:)
			(1
				(= bitmap
					(Bitmap
						0 ; Create
						nWidth
						nHeight
						255
						(oHandler nHeaderBack:)
						640
						480
						1
					)
				)
				(Bitmap
					5 ; AddRect
					bitmap
					0
					0
					(- nWidth 1)
					(- nHeight 1)
					(oHandler nHeaderBack:)
				)
			)
			(2
				(TiledBitmap
					init:
						(oHandler vUnhilited:)
						nWidth
						nHeight
						0
						(oHandler bBorder:)
				)
				(= bitmap (TiledBitmap getBitmap: 1))
				(+= temp4 (TiledBitmap nOffsetX:))
				(+= temp5 (TiledBitmap nOffsetY:))
				(= nWidth (TiledBitmap nWidth:))
				(= nHeight (TiledBitmap nHeight:))
			)
		)
		(= temp8 (/ (- nMinTextWidth nLeftWidth) 2))
		(Bitmap
			4 ; AddText
			bitmap
			(oLeftString data:)
			(+ temp4 temp8)
			temp5
			(- (+ temp4 temp8 nLeftWidth) 1)
			(- (+ temp5 nTextHeight) 1)
			(oHandler nHeaderFore:)
			255
			255
			(oHandler nFont:)
			0
			255
			0
		)
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(event claimed: 1)
		)
		(event claimed:)
	)
)

(class MenuHandler of Obj
	(properties
		nStyle 0
		bPopup 0
		nUnhilitedBack 0
		nHilitedBack 1
		vHilited -1
		vUnhilited -1
		bBorder 0
		nHilitedFore 1
		nUnhilitedFore 0
		nFont 0
		nLeading 2
		nVBorder 3
		nHBorder 5
		nHeaderBack 0
		nHeaderFore 1
		plane 0
		oChildren 0
		oCast 0
		bMouseDown 0
		vCheck -1
		lCheck 0
		cCheck 0
		nDisableCount 0
		nReturn 0
	)

	(method (init param1)
		(super init: &rest)
		(if (or (== argc 0) (not param1))
			(= oCast (Cast new:))
		else
			(= oCast param1)
		)
		(= plane (oCast plane:))
		(if (not plane)
			(= plane ((Plane new:) init: 0 0 640 480 yourself:))
		)
		(plane addCast: oCast)
		(= bMouseDown 0)
		(gOEventHandler registerKeyHandler: self)
		(plane setPri: -1)
		(plane picture: -2)
		(UpdatePlane plane)
		(= oChildren (List new:))
		(self addItems:)
		(oChildren eachElementDo: #init self self 1 oCast)
		(self setChildPos:)
		(self hide:)
	)

	(method (enable param1)
		(if plane
			(if (and argc param1)
				(= nDisableCount 0)
			else
				(= nDisableCount (Max (- nDisableCount 1) 0))
			)
		)
	)

	(method (disable)
		(if plane
			(++ nDisableCount)
			(self hide:)
		)
	)

	(method (getCheckView param1 &tmp temp0)
		(if (== vCheck -1)
			(return 0)
		)
		(= temp0
			((View new:)
				view: vCheck
				loop: lCheck
				cel: cCheck
				setPri: 1000
				x: (param1 x:)
				y: (param1 y:)
				init: (param1 plane:)
				yourself:
			)
		)
		(if (not (param1 isNotHidden:))
			(temp0 hide:)
		)
		(return temp0)
	)

	(method (getCheckWidth)
		(if (== vCheck -1)
			(return 0)
		else
			(return (CelWide vCheck lCheck cCheck))
		)
	)

	(method (setChildPos param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12)
		(if (not (= temp0 (oChildren first:)))
			(return)
		)
		(= temp1 (KList 8 temp0)) ; NodeValue
		(if (< argc 2)
			(= temp2 (temp1 x:))
			(= temp3 (temp1 y:))
		else
			(= temp2 param1)
			(= temp3 param2)
		)
		(if bPopup
			(= temp8 0)
			(= temp9 ((oChildren at: 0) nWidth:))
			(= temp12 (oChildren size:))
			(for ((= temp11 0)) (< temp11 temp12) ((++ temp11))
				(+= temp8 ((oChildren at: temp11) nHeight:))
			)
			(= temp6 (+ temp2 temp9))
			(= temp10 (+ temp3 temp8))
			(if (< temp2 0)
				(= temp2 0)
			)
			(if (< temp3 0)
				(= temp3 0)
			)
			(if (> temp6 gLastScreenX)
				(-= temp2 (- temp6 gLastScreenX))
			)
			(if (> temp10 gLastScreenY)
				(-= temp3 (- temp10 gLastScreenY))
			)
		)
		(while temp0
			(= temp1 (KList 8 temp0)) ; NodeValue
			(temp1 posn: temp2 temp3)
			(if bPopup
				(= temp4 (temp1 oChildren:))
				(= temp7 1)
				(if (and temp4 (temp4 size:))
					(= temp5 ((temp4 at: 0) nWidth:))
					(if (> (= temp6 (+ temp2 (temp1 nWidth:) temp5)) gLastScreenX)
						(= temp7 0)
					)
				)
				(if temp7
					(temp1 setChildPos: (+ temp2 (temp1 nWidth:)) temp3)
				else
					(temp1 setChildPos: (- temp2 temp5) temp3)
				)
				(+= temp3 (temp1 nHeight:))
			else
				(temp1 setChildPos: temp2 (+ temp3 (temp1 nHeight:)))
				(+= temp2 (temp1 nWidth:))
			)
			(= temp0 (oChildren next: temp0))
		)
	)

	(method (posn param1 param2)
		(if (or (not oChildren) (not (oChildren size:)))
			(PrintDebug {Trying to position empty menu. DJM menus.sc})
			(return)
		)
		(self setChildPos: param1 param2)
	)

	(method (posnAt param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 [temp10 2])
		(if (not argc)
			(PrintDebug {illegal call of posnOver.})
			(return)
		)
		(if (not bPopup)
			(PrintDebug {Attempt to use posnOver on non-popup menu})
			(return)
		)
		(if (or (not oChildren) (not (oChildren size:)))
			(return)
		)
		(if (< argc 3)
			(= temp0 gMouseX)
			(= temp1 gMouseY)
		else
			(= temp0 param2)
			(= temp1 param3)
		)
		(= temp5 ((oChildren at: 0) nWidth:))
		(= temp6 0)
		(= temp4 (oChildren size:))
		(for ((= temp7 0)) (< temp7 temp4) ((++ temp7))
			(+= temp6 ((oChildren at: temp7) nHeight:))
		)
		(= temp2 (/ temp5 2))
		(= temp3 0)
		(if (> param1 (- temp4 1))
			(= param1 (- temp4 1))
		)
		(for ((= temp7 0)) (< temp7 param1) ((++ temp7))
			(+= temp3 ((oChildren at: temp7) nHeight:))
		)
		(+= temp3 (/ ((oChildren at: param1) nHeight:) 2))
		(if (> (= temp9 (- (+ temp1 temp6) temp3)) gLastScreenY)
			(= temp3 (- temp6 (/ ((oChildren at: (- temp4 1)) nHeight:) 2)))
		)
		(self posn: (- temp0 temp2) (- temp1 temp3))
	)

	(method (addChild param1)
		(oChildren addToEnd: param1)
		(self setChildWidths:)
		(param1 init: self self 1 plane &rest)
		(if (== (plane priority:) -1)
			(param1 hide:)
		)
		(self setChildPos:)
	)

	(method (setChildWidths &tmp temp0 temp1 temp2 temp3)
		(if (not bPopup)
			(return)
		)
		(= temp1 0)
		(for
			((= temp2 (oChildren first:)))
			temp2
			((= temp2 (oChildren next: temp2)))
			
			(= temp3 (KList 8 temp2)) ; NodeValue
			(if (> (= temp0 (temp3 calcTextWidths: self)) temp1)
				(= temp1 temp0)
			)
		)
		(oChildren eachElementDo: #setMinTextWidth temp1)
	)

	(method (addItems))

	(method (isHilited)
		(if (not oChildren)
			(return 0)
		)
		(if (oChildren firstTrue: #bHilited)
			(return 1)
		)
		(return 0)
	)

	(method (isVisible)
		(return (== (plane priority:) 500))
	)

	(method (getWidth &tmp temp0 temp1 temp2)
		(if oChildren
			(= temp2 0)
			(for
				((= temp0 (oChildren first:)))
				temp0
				((= temp0 (oChildren next: temp0)))
				
				(= temp1 (KList 8 temp0)) ; NodeValue
				(+= temp2 (temp1 nWidth:))
			)
			(return temp2)
		else
			(return 0)
		)
	)

	(method (getHeight &tmp temp0)
		(if oChildren
			(= temp0 (oChildren at: 0))
			(return (temp0 nHeight:))
		else
			(return 0)
		)
	)

	(method (show)
		(if nDisableCount
			(return)
		)
		(plane setPri: 500)
		(UpdatePlane plane)
		(= bMouseDown 0)
		(oChildren eachElementDo: #unhilite)
		(oChildren eachElementDo: #show)
		(FrameOut)
	)

	(method (showPopup &tmp temp0 temp1)
		(if nDisableCount
			(return nDisableCount)
		)
		(plane setPri: 500)
		(UpdatePlane plane)
		(= bMouseDown 1)
		(oChildren eachElementDo: #unhilite)
		(oChildren eachElementDo: #show)
		(plane doit:)
		(FrameOut)
		(gOEventHandler registerEventHog: self)
		(while (== (plane priority:) 500)
			(= temp0 (Event new:))
			(= gGameTime (+ gTickOffset (GetTime)))
			(self handleEvent: temp0)
			(temp0 dispose:)
			(plane doit:)
			(FrameOut)
		)
		(= temp1 nReturn)
		(self dispose:)
		(return temp1)
	)

	(method (hide)
		(if gOEventHandler
			(gOEventHandler unregisterEventHog: self)
		)
		(plane setPri: -1)
		(UpdatePlane plane)
		(oChildren eachElementDo: #hide)
	)

	(method (stopHogging)
		(self hide:)
	)

	(method (doAllButMe param1 param2 &tmp temp0 temp1)
		(for
			((= temp0 (oChildren first:)))
			temp0
			((= temp0 (oChildren next: temp0)))
			
			(if (!= (= temp1 (KList 8 temp0)) param1) ; NodeValue
				(temp1 param2: &rest)
			)
		)
	)

	(method (handleEvent event)
		(if (or nDisableCount (not (gUser canControl:)))
			(return 0)
		)
		(if (== (event type:) evMOUSEBUTTON)
			(= bMouseDown 1)
		)
		(if (== (event type:) evMOUSERELEASE)
			(= bMouseDown 0)
		)
		(oChildren eachElementDo: #handleEvent event &rest)
		(if
			(and
				(not (event claimed:))
				(or (== (event type:) evMOUSEBUTTON) (and (== (event type:) evMOUSERELEASE) bPopup))
			)
			(oChildren eachElementDo: #unhilite)
			(gOEventHandler unregisterEventHog: self)
			(if bPopup
				(= nReturn -1)
				(self hide:)
			)
		)
		(if (!= (event type:) evKEYBOARD)
			(event claimed: 1)
		)
		(event claimed:)
	)

	(method (dispose)
		(gOEventHandler unregisterEventHog: self)
		(gOEventHandler unregisterKeyHandler: self)
		(if oChildren
			(oChildren release:)
			(oChildren dispose:)
			(= oChildren 0)
		)
		(if plane
			(plane dispose:)
		)
		(= plane (= oCast 0))
		(super dispose: &rest)
	)
)

