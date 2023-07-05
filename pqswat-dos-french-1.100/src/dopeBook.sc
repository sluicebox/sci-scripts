;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 45)
(include sci.sh)
(use Main)
(use swatInvInit)
(use DSelector)
(use DEdit)
(use Str)
(use Array)
(use Print)
(use Dialog)
(use Inset)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	dopeBook 0
)

(class DopeBook of Inset
	(properties
		picture 120
		curShot 0
		curBookPage 0
		dataPage 0
		zeroElevation 0
		zeroWindage 0
	)

	(method (initData &tmp temp0)
		(= global403 (List new:))
		(= global404 (List new:))
		(= global405 (List new:))
		(= global406 (List new:))
		(= global407 (List new:))
		(= global408 (List new:))
		(= global409 (List new:))
		(= global410 (List new:))
		(= global411 (List new:))
		(= global434 (List new:))
		(= global435 (List new:))
		(for ((= temp0 0)) (< temp0 3) ((++ temp0))
			(global403 add: (IntArray new: 10))
			(global404 add: (IntArray new: 10))
			(global405 add: (IntArray new: 10))
			(global406 add: (IntArray new: 10))
			(global407 add: (IntArray new: 10))
			(global408 add: (IntArray new: 10))
			(global409 add: (IntArray new: 10))
			(global410 add: (IntArray new: 10))
			(global411 add: (IntArray new: 10))
			(global434 add: (IntArray new: 10))
			(global435 add: (IntArray new: 10))
		)
	)

	(method (update param1 param2 param3 param4 param5 param6 param7 param8 param9 param10 param11 param12 &tmp [temp0 2] temp2 temp3)
		(if (> param1 29)
			(= param1 0)
		)
		(if (< param1 10)
			(= temp2 0)
		else
			(= temp2 (/ param1 10))
		)
		(if (>= param1 10)
			(= temp3 (mod param1 10))
		else
			(= temp3 param1)
		)
		(if (!= ((global403 at: temp2) at: temp3) 0)
			((global403 at: temp2) at: temp3 0)
			((global404 at: temp2) at: temp3 0)
			((global405 at: temp2) at: temp3 0)
			((global406 at: temp2) at: temp3 0)
			((global407 at: temp2) at: temp3 0)
			((global408 at: temp2) at: temp3 0)
			((global409 at: temp2) at: temp3 0)
			((global410 at: temp2) at: temp3 0)
			((global411 at: temp2) at: temp3 0)
			((global434 at: temp2) at: temp3 0)
			((global435 at: temp2) at: temp3 0)
		)
		(if (!= argc 12)
			(Prints
				{You didn't pass the correct amount of parameters to dataBook update.}
			)
			(return)
		else
			((global403 at: temp2) at: temp3 param2)
			((global404 at: temp2) at: temp3 param3)
			((global405 at: temp2) at: temp3 param4)
			((global406 at: temp2) at: temp3 param5)
			((global407 at: temp2) at: temp3 param6)
			((global408 at: temp2) at: temp3 param7)
			((global409 at: temp2) at: temp3 param8)
			((global410 at: temp2) at: temp3 param9)
			((global411 at: temp2) at: temp3 param10)
			((global434 at: temp2) at: temp3 param11)
			((global435 at: temp2) at: temp3 param12)
		)
		(++ global412)
	)

	(method (turnPage param1)
		(cond
			((not argc)
				(Prints
					{You must provide a direction when calling turnPage.}
				)
				(return)
			)
			(param1
				(cond
					((<= curBookPage 6)
						(++ curBookPage)
					)
					((!= dataPage 2)
						(self clearPrints:)
						(++ dataPage)
					)
				)
			)
			((>= curBookPage 1)
				(if dataPage
					(self clearPrints:)
					(-- dataPage)
				else
					(if (gCast contains: windView)
						(windView dispose:)
						(lightView dispose:)
						(backTarg dispose:)
						(bulletHole dispose:)
					)
					(-- curBookPage)
				)
			)
		)
	)

	(method (showInfo param1 &tmp temp0 temp1)
		(if (not (gCast contains: windView))
			(windView init:)
			(lightView init:)
		)
		(backTarg init:)
		(if
			(and
				((global434 at: dataPage) at: param1)
				((global435 at: dataPage) at: param1)
			)
			(bulletHole
				x: (+ ((global434 at: dataPage) at: param1) (backTarg x:))
				y: (- (backTarg y:) ((global435 at: dataPage) at: param1))
				init:
			)
		else
			(bulletHole dispose:)
		)
		(= temp1 ((global404 at: dataPage) at: param1))
		(windView setCel: (if (== temp1 12) 0 else temp1))
		(rangePrint
			addTextF: {%03d} ((global407 at: dataPage) at: param1)
			posn: 55 60
			init:
		)
		(riflePrint addText: {.308} posn: 100 60 init:)
		(= temp0 (Str new:))
		(temp0
			format:
				{%02d/%02d}
				(& (>> ((global406 at: dataPage) at: param1) $0005) $000f)
				(& ((global406 at: dataPage) at: param1) $001f)
		)
		(datePrint addTextF: (temp0 data:) posn: 152 60 init:)
		(temp0
			format:
				{%02d:%02d}
				(>> ((global405 at: dataPage) at: param1) $000c)
				(& (>> ((global405 at: dataPage) at: param1) $0006) $003f)
		)
		(timePrint addTextF: (temp0 data:) posn: 220 98 init:)
		(temp0 dispose:)
		(elevUsedPrint
			addTextF: {%02d} ((global408 at: dataPage) at: param1)
			posn: 254 60
			init:
		)
		(elevCorPrint
			addTextF: {%02d} ((global409 at: dataPage) at: param1)
			posn: 360 60
			init:
		)
		(windUsedPrint
			addTextF: {%02d} ((global410 at: dataPage) at: param1)
			posn: 467 60
			init:
		)
		(windCorPrint
			addTextF: {%02d} ((global411 at: dataPage) at: param1)
			posn: 560 60
			init:
		)
		(userEZeroPrint addTextF: {%02d} global438 posn: 340 150 init:)
		(userWZeroPrint addTextF: {%02d} global437 posn: 340 210 init:)
		(windDirPrint0
			addTextF: {%02d} ((global404 at: dataPage) at: 0)
			posn: 102 298
			init:
		)
		(windSpeedPrint0
			addTextF: {%02d} ((global403 at: dataPage) at: 0)
			posn: 102 322
			init:
		)
		(windDirPrint1
			addTextF: {%02d} ((global404 at: dataPage) at: 1)
			posn: 134 298
			init:
		)
		(windSpeedPrint1
			addTextF: {%02d} ((global403 at: dataPage) at: 1)
			posn: 134 322
			init:
		)
		(windDirPrint2
			addTextF: {%02d} ((global404 at: dataPage) at: 2)
			posn: 166 298
			init:
		)
		(windSpeedPrint2
			addTextF: {%02d} ((global403 at: dataPage) at: 2)
			posn: 166 322
			init:
		)
		(windDirPrint3
			addTextF: {%02d} ((global404 at: dataPage) at: 3)
			posn: 198 298
			init:
		)
		(windSpeedPrint3
			addTextF: {%02d} ((global403 at: dataPage) at: 3)
			posn: 198 322
			init:
		)
		(windDirPrint4
			addTextF: {%02d} ((global404 at: dataPage) at: 4)
			posn: 230 298
			init:
		)
		(windSpeedPrint4
			addTextF: {%02d} ((global403 at: dataPage) at: 4)
			posn: 230 322
			init:
		)
		(windDirPrint5
			addTextF: {%02d} ((global404 at: dataPage) at: 5)
			posn: 262 298
			init:
		)
		(windSpeedPrint5
			addTextF: {%02d} ((global403 at: dataPage) at: 5)
			posn: 262 322
			init:
		)
		(windDirPrint6
			addTextF: {%02d} ((global404 at: dataPage) at: 6)
			posn: 294 298
			init:
		)
		(windSpeedPrint6
			addTextF: {%02d} ((global403 at: dataPage) at: 6)
			posn: 294 322
			init:
		)
		(windDirPrint7
			addTextF: {%02d} ((global404 at: dataPage) at: 7)
			posn: 326 298
			init:
		)
		(windSpeedPrint7
			addTextF: {%02d} ((global403 at: dataPage) at: 7)
			posn: 326 322
			init:
		)
		(windDirPrint8
			addTextF: {%02d} ((global404 at: dataPage) at: 8)
			posn: 358 298
			init:
		)
		(windSpeedPrint8
			addTextF: {%02d} ((global403 at: dataPage) at: 8)
			posn: 358 322
			init:
		)
		(windDirPrint9
			addTextF: {%02d} ((global404 at: dataPage) at: 9)
			posn: 390 298
			init:
		)
		(windSpeedPrint9
			addTextF: {%02d} ((global403 at: dataPage) at: 9)
			posn: 390 322
			init:
		)
	)

	(method (clearPrints)
		(if (rangePrint dialog:)
			((rangePrint dialog:) dispose:)
		)
		(if (riflePrint dialog:)
			((riflePrint dialog:) dispose:)
		)
		(if (datePrint dialog:)
			((datePrint dialog:) dispose:)
		)
		(if (timePrint dialog:)
			((timePrint dialog:) dispose:)
		)
		(if (elevUsedPrint dialog:)
			((elevUsedPrint dialog:) dispose:)
		)
		(if (elevCorPrint dialog:)
			((elevCorPrint dialog:) dispose:)
		)
		(if (windUsedPrint dialog:)
			((windUsedPrint dialog:) dispose:)
		)
		(if (windCorPrint dialog:)
			((windCorPrint dialog:) dispose:)
		)
		(if (userWZeroPrint dialog:)
			((userWZeroPrint dialog:) dispose:)
		)
		(if (userEZeroPrint dialog:)
			((userEZeroPrint dialog:) dispose:)
		)
		(if (windDirPrint0 dialog:)
			((windDirPrint0 dialog:) dispose:)
		)
		(if (windSpeedPrint0 dialog:)
			((windSpeedPrint0 dialog:) dispose:)
		)
		(if (windDirPrint1 dialog:)
			((windDirPrint1 dialog:) dispose:)
		)
		(if (windSpeedPrint1 dialog:)
			((windSpeedPrint1 dialog:) dispose:)
		)
		(if (windDirPrint2 dialog:)
			((windDirPrint2 dialog:) dispose:)
		)
		(if (windSpeedPrint2 dialog:)
			((windSpeedPrint2 dialog:) dispose:)
		)
		(if (windDirPrint3 dialog:)
			((windDirPrint3 dialog:) dispose:)
		)
		(if (windSpeedPrint3 dialog:)
			((windSpeedPrint3 dialog:) dispose:)
		)
		(if (windDirPrint4 dialog:)
			((windDirPrint4 dialog:) dispose:)
		)
		(if (windSpeedPrint4 dialog:)
			((windSpeedPrint4 dialog:) dispose:)
		)
		(if (windDirPrint5 dialog:)
			((windDirPrint5 dialog:) dispose:)
		)
		(if (windSpeedPrint5 dialog:)
			((windSpeedPrint5 dialog:) dispose:)
		)
		(if (windDirPrint6 dialog:)
			((windDirPrint6 dialog:) dispose:)
		)
		(if (windSpeedPrint6 dialog:)
			((windSpeedPrint6 dialog:) dispose:)
		)
		(if (windDirPrint7 dialog:)
			((windDirPrint7 dialog:) dispose:)
		)
		(if (windSpeedPrint7 dialog:)
			((windSpeedPrint7 dialog:) dispose:)
		)
		(if (windDirPrint8 dialog:)
			((windDirPrint8 dialog:) dispose:)
		)
		(if (windSpeedPrint8 dialog:)
			((windSpeedPrint8 dialog:) dispose:)
		)
		(if (windDirPrint9 dialog:)
			((windDirPrint9 dialog:) dispose:)
		)
		(if (windSpeedPrint9 dialog:)
			((windSpeedPrint9 dialog:) dispose:)
		)
	)

	(method (dispose)
		(self clearPrints:)
		(super dispose: &rest)
		(DisposeScript 45)
	)
)

(instance dopeBook of DopeBook
	(properties
		disposeNotOnMe 1
	)

	(method (init)
		(super init: &rest)
		(bookPage init:)
		(forwardCorner init: gFtrInitializer plane)
		(backCorner init: gFtrInitializer plane)
	)

	(method (turnPage param1)
		(super turnPage: param1 &rest)
		(bookPage view: (Min (+ curBookPage 1201) 1208))
		(bookPage
			x: (if (== (bookPage view:) 1201) 12 else 37)
			y: (if (== (bookPage view:) 1201) 22 else 8)
		)
		(UpdateScreenItem bookPage)
		(if (== (bookPage view:) 1208)
			(shot0 init: gFtrInitializer plane)
			(shot1 init: gFtrInitializer plane)
			(shot2 init: gFtrInitializer plane)
			(shot3 init: gFtrInitializer plane)
			(shot4 init: gFtrInitializer plane)
			(shot5 init: gFtrInitializer plane)
			(shot6 init: gFtrInitializer plane)
			(shot7 init: gFtrInitializer plane)
			(shot8 init: gFtrInitializer plane)
			(shot9 init: gFtrInitializer plane)
			(self showInfo: curShot)
		else
			(if ((plane theFtrs:) contains: shot0)
				((plane theFtrs:) delete: shot0)
			)
			(shot0 dispose:)
			(if ((plane theFtrs:) contains: shot1)
				((plane theFtrs:) delete: shot1)
			)
			(shot1 dispose:)
			(if ((plane theFtrs:) contains: shot2)
				((plane theFtrs:) delete: shot2)
			)
			(shot2 dispose:)
			(if ((plane theFtrs:) contains: shot3)
				((plane theFtrs:) delete: shot3)
			)
			(shot3 dispose:)
			(if ((plane theFtrs:) contains: shot4)
				((plane theFtrs:) delete: shot4)
			)
			(shot4 dispose:)
			(if ((plane theFtrs:) contains: shot5)
				((plane theFtrs:) delete: shot5)
			)
			(shot5 dispose:)
			(if ((plane theFtrs:) contains: shot6)
				((plane theFtrs:) delete: shot6)
			)
			(shot6 dispose:)
			(if ((plane theFtrs:) contains: shot7)
				((plane theFtrs:) delete: shot7)
			)
			(shot7 dispose:)
			(if ((plane theFtrs:) contains: shot8)
				((plane theFtrs:) delete: shot8)
			)
			(shot8 dispose:)
			(if ((plane theFtrs:) contains: shot9)
				((plane theFtrs:) delete: shot9)
			)
			(shot9 dispose:)
			(self clearPrints:)
		)
	)

	(method (doVerb)
		(self dispose:)
	)

	(method (dispose)
		(bookPage dispose:)
		(forwardCorner dispose:)
		(backCorner dispose:)
		(shot0 dispose:)
		(shot1 dispose:)
		(shot2 dispose:)
		(shot3 dispose:)
		(shot4 dispose:)
		(shot5 dispose:)
		(shot6 dispose:)
		(shot7 dispose:)
		(shot8 dispose:)
		(shot9 dispose:)
		((proc19_3 20) show:)
		(super dispose: &rest)
	)
)

(instance bookPage of View
	(properties
		x 12
		y 22
		view 1201
	)

	(method (doVerb))
)

(instance windView of View
	(properties
		x 187
		y 145
		view 1210
	)

	(method (doVerb))
)

(instance lightView of View
	(properties
		x 55
		y 145
		view 1210
		cel 11
	)

	(method (doVerb))
)

(instance backTarg of View
	(properties
		x 450
		y 270
		view 1208
		loop 1
	)

	(method (doVerb))
)

(instance bulletHole of View
	(properties
		view 1208
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setCel: (Random 0 3) setPri: 350)
	)

	(method (doVerb))
)

(instance forwardCorner of Feature
	(properties
		y 200
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 605 0 636 24 634 0 yourself:)
		)
	)

	(method (doVerb)
		(if (!= (dopeBook dataPage:) 2)
			(dopeBook turnPage: 1)
		)
	)
)

(instance backCorner of Feature
	(properties
		y 201
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 603 1 599 19 628 20 yourself:)
		)
	)

	(method (doVerb)
		(dopeBook turnPage: 0)
	)
)

(instance shot0 of Feature
	(properties
		nsLeft 100
		nsTop 278
		nsRight 132
		nsBottom 295
		y 199
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				((ScriptID 45 0) curShot: 0 clearPrints: showInfo: 0) ; dopeBook
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shot1 of Feature
	(properties
		nsLeft 132
		nsTop 278
		nsRight 164
		nsBottom 295
		y 199
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				((ScriptID 45 0) curShot: 1 clearPrints: showInfo: 1) ; dopeBook
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shot2 of Feature
	(properties
		nsLeft 164
		nsTop 278
		nsRight 196
		nsBottom 295
		y 199
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				((ScriptID 45 0) curShot: 2 clearPrints: showInfo: 2) ; dopeBook
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shot3 of Feature
	(properties
		nsLeft 196
		nsTop 278
		nsRight 228
		nsBottom 295
		y 199
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				((ScriptID 45 0) curShot: 3 clearPrints: showInfo: 3) ; dopeBook
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shot4 of Feature
	(properties
		nsLeft 228
		nsTop 278
		nsRight 260
		nsBottom 295
		y 199
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				((ScriptID 45 0) curShot: 4 clearPrints: showInfo: 4) ; dopeBook
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shot5 of Feature
	(properties
		nsLeft 260
		nsTop 278
		nsRight 292
		nsBottom 295
		y 199
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				((ScriptID 45 0) curShot: 5 clearPrints: showInfo: 5) ; dopeBook
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shot6 of Feature
	(properties
		nsLeft 292
		nsTop 278
		nsRight 324
		nsBottom 295
		y 199
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				((ScriptID 45 0) curShot: 6 clearPrints: showInfo: 6) ; dopeBook
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shot7 of Feature
	(properties
		nsLeft 324
		nsTop 278
		nsRight 356
		nsBottom 295
		y 199
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				((ScriptID 45 0) curShot: 7 clearPrints: showInfo: 7) ; dopeBook
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shot8 of Feature
	(properties
		nsLeft 356
		nsTop 278
		nsRight 388
		nsBottom 295
		y 199
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				((ScriptID 45 0) curShot: 8 clearPrints: showInfo: 8) ; dopeBook
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shot9 of Feature
	(properties
		nsLeft 388
		nsTop 278
		nsRight 420
		nsBottom 295
		y 199
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				((ScriptID 45 0) curShot: 9 clearPrints: showInfo: 9) ; dopeBook
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(class BookPrint of Print
	(properties
		font 20071
		fore 30
	)

	(method (doit))

	(method (init)
		(= back (= skip -1))
		(= modeless 2)
		(super init: &rest)
	)

	(method (showSelf &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if saveCursor
			(gGame setCursor: gNormalCursor)
		)
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		((= plane
				(if plane
					(plane new:)
				else
					(gSystemPlane new:)
				)
			)
			back: 0
			picture: -2
		)
		(dialog
			plane: plane
			name: {PODialog}
			caller: self
			text: title
			ticks: ticks
			margin: margin
			modeless: modeless
			onScreen: onScreen
			init:
		)
		(if bitmap
			(dialog
				nsLeft: (bitmap nsLeft:)
				nsTop: (bitmap nsTop:)
				nsRight: (bitmap nsRight:)
				nsBottom: (bitmap nsBottom:)
			)
		else
			(dialog setSize:)
		)
		(if title
			((dialog plane:) setTitle: title)
			(dialog
				nsLeft: ((dialog plane:) left:)
				nsTop: ((dialog plane:) top:)
				nsRight: ((dialog plane:) right:)
				nsBottom: ((dialog plane:) bottom:)
			)
		)
		(dialog center:)
		(= temp2
			(if (== x -1)
				(dialog nsLeft:)
			else
				x
			)
		)
		(= temp3
			(if (== y -1)
				(dialog nsTop:)
			else
				y
			)
		)
		(dialog moveTo: temp2 temp3 eachElementDo: #updatePlane)
		(FrameOut)
		(if (== modeless 0)
			(gSounds pause: 1)
			(if (not (= temp0 first))
				(if
					(and
						(= temp0 (dialog firstTrue: #checkState 1))
						(not (dialog firstTrue: #checkState 2))
					)
					(temp0 state: (| (temp0 state:) $0002))
				)
			else
				(= temp0 (dialog at: temp0))
			)
			(= retValue (dialog doit: temp0))
			(switch retValue
				(-1
					(= retValue 0)
				)
				(-2
					(= retValue 1)
				)
				(0
					(= retValue 1)
				)
				(else
					(if (retValue object:)
						(gGame
							panelObj: (retValue object:)
							panelSelector: (retValue selector:)
						)
					)
					(cond
						((retValue isKindOf: DEdit)
							(= retValue (retValue text:))
						)
						((retValue isKindOf: DSelector)
							(= retValue (retValue getText:))
						)
						(else
							(= retValue (retValue value:))
						)
					)
				)
			)
			(if (and saveCursor gTheIconBar)
				(gGame setCursor: (gTheIconBar getCursor:))
			)
			(= temp5 retValue)
			(dialog dispose:)
			(return temp5)
		else
			(gPrints addToFront: self)
		)
	)

	(method (handleEvent))
)

(instance rangePrint of BookPrint
	(properties)
)

(instance riflePrint of BookPrint
	(properties)
)

(instance datePrint of BookPrint
	(properties)
)

(instance timePrint of BookPrint
	(properties)
)

(instance elevUsedPrint of BookPrint
	(properties)
)

(instance elevCorPrint of BookPrint
	(properties)
)

(instance windUsedPrint of BookPrint
	(properties)
)

(instance windCorPrint of BookPrint
	(properties)
)

(instance userEZeroPrint of BookPrint
	(properties)
)

(instance userWZeroPrint of BookPrint
	(properties)
)

(instance windDirPrint0 of BookPrint
	(properties)
)

(instance windSpeedPrint0 of BookPrint
	(properties)
)

(instance windDirPrint1 of BookPrint
	(properties)
)

(instance windSpeedPrint1 of BookPrint
	(properties)
)

(instance windDirPrint2 of BookPrint
	(properties)
)

(instance windSpeedPrint2 of BookPrint
	(properties)
)

(instance windDirPrint3 of BookPrint
	(properties)
)

(instance windSpeedPrint3 of BookPrint
	(properties)
)

(instance windDirPrint4 of BookPrint
	(properties)
)

(instance windSpeedPrint4 of BookPrint
	(properties)
)

(instance windDirPrint5 of BookPrint
	(properties)
)

(instance windSpeedPrint5 of BookPrint
	(properties)
)

(instance windDirPrint6 of BookPrint
	(properties)
)

(instance windSpeedPrint6 of BookPrint
	(properties)
)

(instance windDirPrint7 of BookPrint
	(properties)
)

(instance windSpeedPrint7 of BookPrint
	(properties)
)

(instance windDirPrint8 of BookPrint
	(properties)
)

(instance windSpeedPrint8 of BookPrint
	(properties)
)

(instance windDirPrint9 of BookPrint
	(properties)
)

(instance windSpeedPrint9 of BookPrint
	(properties)
)

