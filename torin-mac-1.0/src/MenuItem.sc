;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64893)
(include sci.sh)
(use Main)
(use TiledBitmap)
(use n64896)
(use Plane)
(use Str)
(use Actor)
(use System)

(class MenuItem of View
	(properties
		oNotify 0
		nSelectMethod 748
		chShortcut 0
		nModifiers 4
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

	(method (init oMyParent oMyHandler nSetLevel)
		(= oParent oMyParent)
		(= oHandler oMyHandler)
		(= oChildren (List new:))
		(= nLevel nSetLevel)
		(= bChecked (= bHilited 0))
		(self addItems:)
		(self setup: oHandler)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
		(oChildren eachElementDo: #init self oHandler (+ nLevel 1) &rest)
	)

	(method (setup &tmp moTemp node nTmpWidth nTmpHeight nOffX nOffY nRightOffX nMaxChildWidth)
		(if (== (oHandler nStyle:) 0)
			(= nWidth (CelWide view loop 0))
			(= nHeight (CelHigh view loop 0))
			(return)
		)
		(if (not nLeftWidth)
			(self calcTextWidths:)
		)
		(= nMaxChildWidth 0)
		(for
			((= node (oChildren first:)))
			node
			((= node (oChildren next: node)))
			
			(= moTemp (KList 8 node)) ; NodeValue
			(if (> (= nTmpWidth (moTemp calcTextWidths: oHandler)) nMaxChildWidth)
				(= nMaxChildWidth nTmpWidth)
			)
		)
		(oChildren eachElementDo: #setMinTextWidth nMaxChildWidth)
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
		(= nOffX (+ (oHandler nHBorder:) (self getCheckWidth:)))
		(= nOffY (oHandler nVBorder:))
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
				(= nTmpWidth (TiledBitmap nWidth:))
				(= nTmpHeight (TiledBitmap nHeight:))
				(TiledBitmap
					init:
						(oHandler vHilited:)
						nWidth
						nHeight
						0
						(oHandler bBorder:)
				)
				(= bmpOn (TiledBitmap getBitmap: 1))
				(+= nOffX (TiledBitmap nOffsetX:))
				(+= nOffY (TiledBitmap nOffsetY:))
				(= nWidth (TiledBitmap nWidth:))
				(= nHeight (TiledBitmap nHeight:))
				(or (!= nWidth nTmpWidth) (!= nHeight nTmpHeight))
			)
		)
		(Bitmap
			4 ; AddText
			bmpOff
			(oLeftString data:)
			nOffX
			nOffY
			(- (+ nOffX nLeftWidth) 1)
			(- (+ nOffY nTextHeight) 1)
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
			nOffX
			nOffY
			(- (+ nOffX nLeftWidth) 1)
			(- (+ nOffY nTextHeight) 1)
			(oHandler nHilitedFore:)
			255
			255
			(oHandler nFont:)
			0
			255
			0
		)
		(if oRightString
			(= nRightOffX (- (+ nOffX nMinTextWidth) nRightWidth))
			(Bitmap
				4 ; AddText
				bmpOff
				(oRightString data:)
				nRightOffX
				nOffY
				(- (+ nRightOffX nRightWidth) 1)
				(- (+ nOffY nTextHeight) 1)
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
				nRightOffX
				nOffY
				(- (+ nRightOffX nRightWidth) 1)
				(- (+ nOffY nTextHeight) 1)
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

	(method (setMinTextWidth nWid)
		(= nMinTextWidth nWid)
	)

	(method (getCheckWidth)
		(if (== nLevel 1)
			(return 0)
		else
			(return (oHandler getCheckWidth:))
		)
	)

	(method (calcTextWidths oMyHandler &tmp oTmp nSplit nLen)
		(if argc
			(= oHandler oMyHandler)
		)
		(if (not oText)
			(= oText (MakeMessageText nNoun nVerb nCase nSeq nModule))
			(if (not oText)
				(= oText (Str with: {default}))
			)
		)
		(if (not (IsStringObject oText))
			(= oTmp oText)
			(= oText (Str with: oTmp))
			(StringDispose oTmp)
		)
		(= nSplit (oText indexOf: 124))
		(= nLen (oText size:))
		(if (== nSplit -1)
			(= oLeftString (Str with: oText))
			(= oRightString 0)
		else
			(= oLeftString (oText subStr: 0 nSplit))
			(if (== (++ nSplit) nLen)
				(= oRightString 0)
			else
				(= oRightString (oText subStr: nSplit (- (oText size:) nSplit)))
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
		(return (+ nLeftWidth nGapWidth nRightWidth))
	)

	(method (setChildPos nX nY &tmp node moTemp)
		(for
			((= node (oChildren first:)))
			node
			((= node (oChildren next: node)))
			
			(= moTemp (KList 8 node)) ; NodeValue
			(moTemp posn: nX nY)
			(moTemp setChildPos: (+ nX (moTemp nWidth:)) nY)
			(+= nY (moTemp nHeight:))
		)
	)

	(method (posn nX nY)
		(super posn: nX nY &rest)
		(if voCheck
			(voCheck posn: nX nY)
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
			(Eval oNotify nSelectMethod)
		)
	)

	(method (setCel &tmp newCel)
		(cond
			((== (oHandler nStyle:) 0)
				(= newCel 0)
				(if bHilited
					(+= newCel 1)
				)
				(if (!= cel newCel)
					(= cel newCel)
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

	(method (hide &tmp bmTmp)
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
		(= bHilited 1)
		(self setCel:)
		(oChildren eachElementDo: #show)
		(oChildren eachElementDo: #unhilite)
		(oParent doAllButMe: self 972)
	)

	(method (unhilite)
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

	(method (doAllButMe moDont action &tmp node moThis)
		(for
			((= node (oChildren first:)))
			node
			((= node (oChildren next: node)))
			
			(if (!= (= moThis (KList 8 node)) moDont) ; NodeValue
				(moThis action: &rest)
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
			(if (== (event type:) evMOUSEBUTTON)
				(gOEventHandler registerEventHog: oHandler)
				(oHandler bMouseDown: 1)
			)
			(cond
				((oHandler bMouseDown:)
					(self hilite:)
				)
				((and (== (event type:) evMOUSERELEASE) (== (oChildren size:) 0))
					(self unhilite:)
					(oHandler hide:)
					(self doSelect:)
				)
				(else
					(super handleEvent: event &rest)
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
			(oChildren eachElementDo: #dispose)
			(oChildren dispose:)
		)
		(if oText
			(StringDispose oText)
			(= oText 0)
		)
		(if oLeftString
			(StringDispose oLeftString)
			(= oLeftString 0)
		)
		(if oRightString
			(StringDispose oRightString)
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

(class MenuHandler of Obj
	(properties
		nStyle 0
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
		plane 0
		oChildren 0
		oCast 0
		bMouseDown 0
		vCheck -1
		lCheck 0
		cCheck 0
		nDisableCount 0
	)

	(method (init theCast)
		(super init: &rest)
		(if (or (== argc 0) (not theCast))
			(= oCast (Cast new:))
		else
			(= oCast theCast)
		)
		(= plane (oCast plane:))
		(if (not plane)
			(= plane ((Plane new:) init: yourself:))
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
		(plane setSize:)
		(self hide:)
	)

	(method (enable bForceEnable)
		(if plane
			(if (and argc bForceEnable)
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

	(method (getCheckView voItem &tmp voRet)
		(if (== vCheck -1)
			(return 0)
		)
		(= voRet
			((View new:)
				view: vCheck
				loop: lCheck
				cel: cCheck
				setPri: 1000
				x: (voItem x:)
				y: (voItem y:)
				init: (voItem plane:)
				yourself:
			)
		)
		(if (not (voItem isNotHidden:))
			(voRet hide:)
		)
		(return voRet)
	)

	(method (getCheckWidth)
		(if (== vCheck -1)
			(return 0)
		else
			(return (CelWide vCheck lCheck cCheck))
		)
	)

	(method (setChildPos &tmp node moTemp nX nY)
		(if (not (= node (oChildren first:)))
			(return)
		)
		(= moTemp (KList 8 node)) ; NodeValue
		(= nX (moTemp x:))
		(= nY (moTemp y:))
		(while node
			(= moTemp (KList 8 node)) ; NodeValue
			(moTemp posn: nX nY)
			(moTemp setChildPos: nX (+ nY (moTemp nHeight:)))
			(+= nX (moTemp nWidth:))
			(= node (oChildren next: node))
		)
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

	(method (getWidth &tmp node moTemp nTmpWidth)
		(if oChildren
			(= nTmpWidth 0)
			(for
				((= node (oChildren first:)))
				node
				((= node (oChildren next: node)))
				
				(= moTemp (KList 8 node)) ; NodeValue
				(+= nTmpWidth (moTemp nWidth:))
			)
			(return nTmpWidth)
		else
			(return 0)
		)
	)

	(method (getHeight &tmp voTemp)
		(if oChildren
			(= voTemp (oChildren at: 0))
			(return (voTemp nHeight:))
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

	(method (doAllButMe moDont action &tmp node moThis)
		(for
			((= node (oChildren first:)))
			node
			((= node (oChildren next: node)))
			
			(if (!= (= moThis (KList 8 node)) moDont) ; NodeValue
				(moThis action: &rest)
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
		(if (and (not (event claimed:)) (== (event type:) evMOUSEBUTTON))
			(oChildren eachElementDo: #unhilite)
			(gOEventHandler unregisterEventHog: self)
		)
		(if (!= (event type:) evKEYBOARD)
			(event claimed: 1)
		)
		(event claimed:)
	)

	(method (dispose)
		(gOEventHandler unregisterEventHog: self)
		(gOEventHandler unregisterKeyHandler: self)
		(if plane
			(plane dispose:)
		)
		(= plane (= oCast 0))
		(super dispose: &rest)
	)
)

