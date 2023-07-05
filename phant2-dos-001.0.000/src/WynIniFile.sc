;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63019)
(include sci.sh)
(use Main)
(use eggAMatic)
(use P2ScrollBar)
(use nExit)
(use invItems)
(use n63002)
(use P2View)
(use Plane)
(use Str)
(use Rectangle)
(use Array)
(use BorderWindow)
(use PolyEdit)
(use WriteFeature)
(use Feature)
(use Timer)
(use TextField)
(use Menu)
(use System)

(local
	local0 = 10
	local1 = -1
	local2
	local3
	local4
)

(procedure (localproc_0 param1 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 param1) ((++ temp0))
		(= temp1 (GetTime))
		(while (== temp1 (GetTime))
		)
	)
)

(class WynIniFile of Obj
	(properties
		selArray 0
		valArray 0
		whichComp 0
		whichApp 0
	)

	(method (new &tmp temp0)
		(= temp0 (super new:))
		(temp0 init: &rest)
		((gWynNet SEANET:) add: temp0)
		(return temp0)
	)

	(method (init param1 param2)
		(if (not selArray)
			(= selArray (IntArray with: 571))
		)
		(if (not valArray)
			(= valArray (IntArray with: param1))
		)
		(= whichComp param1)
		(= whichApp param2)
		(super init:)
	)

	(method (imFor param1 param2)
		(return
			(and (== whichComp param1) (or (== argc 1) (== whichApp param2)))
		)
	)

	(method (read param1 param2 &tmp temp0)
		(if (!= -1 (= temp0 (selArray indexOf: param1)))
			(valArray at: temp0 param2)
		else
			(selArray at: (selArray size:) param1)
			(valArray at: (valArray size:) param2)
		)
	)

	(method (write &tmp temp0 temp1 temp2)
		(for ((= temp0 0)) (< temp0 (selArray size:)) ((++ temp0))
			(= temp1 (selArray at: temp0))
			(= temp2 (valArray at: temp0))
			(gCurRoom temp1: temp2)
		)
	)

	(method (dispose)
		((gWynNet SEANET:) delete: self)
		(if selArray
			(selArray dispose:)
			(= selArray 0)
		)
		(if valArray
			(valArray dispose:)
			(= valArray 0)
		)
		(super dispose: &rest)
	)
)

(class WynCompBaseRoom of CloseupRoom
	(properties
		whichComp 0
		docuStoreRm 0
		docuStoreIcon 0
		postalWareRm 0
		postalWareIcon 0
		sysconRm 0
		sysconIcon 0
		logoutIcon 0
		bevel 0
		myIni 0
	)

	(method (init &tmp temp0)
		(InvPlane recalc: 0)
		(if
			(not
				(= myIni
					((gWynNet SEANET:)
						firstTrue: #imFor whichComp (self getSuper:)
					)
				)
			)
			(= myIni (WynIniFile new: whichComp (self getSuper:)))
		)
		(myIni write:)
		(super init: &rest)
		(if local3
			(self slideDoors: local3)
			(= local3 0)
		)
		(self refresh:)
		((ScriptID 63000 0) dispose:) ; nExit
		(if bevel
			(((ScriptID 63000 1) target:) ; sExit
				setRect:
					(bevel x:)
					(((ScriptID 63000 1) target:) top:) ; sExit
					(((ScriptID 63000 1) target:) right:) ; sExit
					(((ScriptID 63000 1) target:) bottom:) ; sExit
			)
		)
	)

	(method (currentState param1 &tmp temp0 temp1 temp2)
		(= temp0 [global221 whichComp])
		(if argc
			(= [global221 whichComp] param1)
		)
		(if (== param1 0)
			(= temp2 (Set new:))
			(while (= temp1 ((gWynNet SEANET:) firstTrue: #imFor whichComp))
				(temp1 whichComp: -1)
				(temp2 add: temp1)
			)
			(while (temp2 size:)
				(= temp1 (temp2 at: 0))
				(temp2 delete: temp1)
				(if (temp1 selArray:)
					((temp1 selArray:) dispose:)
				)
				(if (temp1 valArray:)
					((temp1 valArray:) dispose:)
				)
				(temp1
					selArray: (IntArray with: 571)
					valArray: (IntArray with: whichComp)
					whichComp: whichComp
				)
			)
			(temp2 dispose:)
		)
		(return temp0)
	)

	(method (hideAll)
		(if docuStoreIcon
			(docuStoreIcon dispose:)
			(= docuStoreIcon 0)
		)
		(if postalWareIcon
			(postalWareIcon dispose:)
			(= postalWareIcon 0)
		)
		(if sysconIcon
			(sysconIcon dispose:)
			(= sysconIcon 0)
		)
		(if logoutIcon
			(logoutIcon dispose:)
			(= logoutIcon 0)
		)
		(if bevel
			(bevel dispose:)
			(= bevel 0)
		)
	)

	(method (slideDoors param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
		(= temp10 60)
		(= temp7 18)
		(= temp8 (* (/ 330 18) param1))
		(= temp3 (if (== param1 1) 0 else -330))
		(= temp4 (if (== param1 1) 639 else 969))
		(if (self isKindOf: WynLogin)
			((= temp1 (View new:))
				view: 3010
				loop: 12
				cel: 0
				init: gThePlane
				setPri: 800
				posn: temp3 0 1
			)
			((= temp2 (View new:))
				view: 3010
				loop: 12
				cel: 1
				init: gThePlane
				setPri: 800
				posn: temp4 0 1
			)
		else
			((= temp1 (View new:))
				view: 3015
				loop: 3
				cel: 0
				init: gThePlane
				setPri: 800
				posn: temp3 0 1
			)
			((= temp2 (View new:))
				view: 3015
				loop: 3
				cel: 1
				init: gThePlane
				setPri: 800
				posn: temp4 0 1
			)
		)
		(if (== param1 1)
			(FrameOut)
			(localproc_0 temp10)
		)
		(= temp0 0)
		(= temp5 temp3)
		(for ((= temp6 temp4)) (<= temp0 temp7) ((+= temp6 temp8))
			(temp1 posn: temp5 0 1)
			(temp2 posn: temp6 0 1)
			(FrameOut)
			(++ temp0)
			(-= temp5 temp8)
		)
		(temp2 posn: 639 0 1)
		(temp1 posn: 0 0 1)
		(if (== param1 -1)
			(FrameOut)
			(localproc_0 temp10)
			(self hideAll:)
		)
		(temp1 dispose:)
		(temp2 dispose:)
	)

	(method (refresh &tmp temp0)
		(self hideAll:)
		(if (not (self isKindOf: WynLogin))
			(= temp0 4)
			(= docuStoreIcon (P2View new:))
			(= postalWareIcon (P2View new:))
			(= logoutIcon (P2View new:))
			(docuStoreIcon
				view: 3026
				loop: 0
				cel: (if (self isKindOf: WynDocuStore) 0 else 1)
				isHot: (if (self isKindOf: WynDocuStore) 0 else 1)
				x: temp0
				y: 295
				nextRoom: docuStoreRm
				init:
			)
			(+= temp0 39)
			(postalWareIcon
				view: 3026
				loop: 1
				cel: (if (self isKindOf: WynPostalWare) 0 else 1)
				isHot: (if (self isKindOf: WynPostalWare) 0 else 1)
				x: temp0
				y: 295
				nextRoom: postalWareRm
				init:
			)
			(+= temp0 39)
			(if (and (== (& (self currentState:) $00f0) 32) (== whichComp 1))
				(= sysconIcon (P2View new:))
				(sysconIcon
					view: 3026
					loop: 3
					cel: (if (self isKindOf: WynSyscon) 0 else 1)
					isHot: (if (self isKindOf: WynSyscon) 0 else 1)
					x: temp0
					y: 295
					nextRoom: sysconRm
					init:
				)
				(+= temp0 39)
			)
			(logoutIcon
				view: 3026
				loop: 2
				cel: 1
				isHot: 1
				x: temp0
				y: 295
				whoDoit: logoutCode
				init:
			)
			(+= temp0 35)
			(= bevel (View new:))
			(bevel view: 3026 loop: 4 cel: 0 x: temp0 y: 295 init: gThePlane)
		)
	)

	(method (dispose)
		(self hideAll:)
		(if (not (OneOf gNewRoomNum docuStoreRm postalWareRm sysconRm))
			(self slideDoors: -1)
		)
		(InvPlane recalc: 1)
		(super dispose: &rest)
	)
)

(instance logoutCode of Code
	(properties)

	(method (doit param1)
		(if argc
			(cond
				((== param1 2)
					(gCurRoom
						hideAll:
						currentState: 0
						newRoom: (gCurRoom exitRoom:)
						drawPic: -2
					)
				)
				((logoutRUSure new:)
					(Send new: self 9 2)
				)
				(else
					(((gCurRoom logoutIcon:) target:) setCel: 1 update:)
				)
			)
		else
			(((gCurRoom logoutIcon:) target:) setCel: 0 update:)
			(Send new: self 9 1)
		)
	)
)

(class WynOneCelButn of Feature
	(properties
		view -1
		loop -1
		myView -1
		vX -1
		vY -1
	)

	(method (init)
		(super init: gThePlane 1 &rest)
		(self isHot: 1)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((!= myView -1)
				(if (& (event type:) evMOUSERELEASE)
					(= temp0 0)
					(localproc_0 10)
					((gUser hogs:) pop:)
					(event globalize: localize: gThePlane)
					(if (myView onMe: event)
						(= temp0 1)
					)
					(myView dispose:)
					(= myView -1)
					(if temp0
						(gCurRoom handleEvent: self event)
					)
					(event claimed: self)
				)
			)
			((& (event type:) evMOUSEBUTTON)
				((gUser hogs:) push: self 1)
				((= myView (View new:))
					view: view
					loop: loop
					cel: 0
					init: gThePlane
					posn: vX vY
				)
				(event claimed: self)
			)
		)
		(event claimed:)
	)
)

(class logoutRUSure of View
	(properties
		value 0
		x 170
		y 257
		view 3015
		bV 0
		okB 0
		cncB 0
	)

	(method (new &tmp temp0 temp1)
		(= temp0 (super new:))
		(temp0 init:)
		(= temp1 (temp0 value:))
		((temp0 plane:) dispose:)
		(return temp1)
	)

	(method (init)
		((= plane (Plane new:))
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
			setPri: (+ (GetHighPlanePri) 1) 1
			drawPic: -2
		)
		(gTheCursor set: 999 1 0)
		(super init: plane)
		(= okB (Rectangle new: 199 212 285 237))
		(= cncB (Rectangle new: 352 212 438 237))
		(self addTarget: okB addTarget: cncB)
		((gUser hogs:) push: self 1)
		(gUser doit:)
	)

	(method (handleEvent event)
		(event globalize: localize: plane)
		(cond
			((and bV (& (event type:) evMOUSERELEASE))
				(localproc_0 10)
				(if (bV onMe: event)
					((gUser hogs:) pop:)
				)
				(bV dispose:)
				(= bV 0)
			)
			((& (event type:) evMOUSEBUTTON)
				(cond
					((okB onMe: event)
						(= bV (View new:))
						(bV
							view: 3015
							loop: 1
							posn: 199 213
							setPri: 1001
							init: plane
						)
						(= value 1)
					)
					((cncB onMe: event)
						(= bV (View new:))
						(bV
							view: 3015
							loop: 2
							posn: 352 213
							setPri: 1001
							init: plane
						)
						(= value 0)
					)
				)
			)
		)
		(FrameOut)
		(event claimed: self)
	)

	(method (dispose)
		(if target
			(target dispose:)
			(= target 0)
		)
		(super dispose:)
	)
)

(class PasswordError of View
	(properties
		x 140
		y 221
		view 3035
		loop 3
		okbV 0
	)

	(method (new &tmp temp0 temp1)
		(= temp0 (super new:))
		((= temp1 (Plane new:))
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
			setPri: (+ (GetHighPlanePri) 1) 1
			drawPic: -2
		)
		(temp0 init: temp1)
		(temp1 dispose:)
	)

	(method (init)
		(super init: &rest)
		(self addTarget: (Rectangle new: 276 175 362 200))
		((gUser hogs:) push: self 1)
		(gUser doit:)
	)

	(method (handleEvent event)
		(event globalize: localize: plane)
		(cond
			((and (target onMe: event) (& (event type:) evMOUSEBUTTON) (not okbV))
				((= okbV (View new:))
					view: (if (== view 3010) 3010 else 3035)
					loop: (if (== view 3010) 10 else 1)
					cel: 0
					init: plane
					posn: 276 175
					setPri: 1001
					update:
				)
			)
			(
				(or
					(and okbV (& (event type:) evMOUSERELEASE))
					(and (& (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				)
				(localproc_0 10)
				(if okbV
					(okbV dispose:)
				)
				((gUser hogs:) pop:)
				(event claimed: self)
				(gCurRoom refresh:)
				(self dispose:)
			)
		)
		(FrameOut)
		(event claimed:)
	)

	(method (dispose)
		(if target
			(target dispose:)
			(= target 0)
		)
		(super dispose: &rest)
	)
)

(instance TypingFeature of Feature
	(properties)

	(method (init)
		(super init: gThePlane 0 0 0 0 0)
		((gUser mousers:) add: self)
	)

	(method (handleEvent event)
		(if (& (event type:) evKEYBOARD)
			(responder handleEvent: self event &rest)
		)
	)

	(method (dispose)
		((gUser mousers:) delete: self)
		(= responder 0)
		(super dispose:)
	)
)

(class PWWCursor of View
	(properties
		view 3035
		loop 5
		myWindow 0
	)

	(method (new &tmp temp0)
		(= temp0 (super new:))
		(temp0 init: &rest)
		(return temp0)
	)

	(method (init param1)
		(= myWindow param1)
		(self
			posn:
				(+ (myWindow x:) 115 (* 9 (((myWindow pwStars:) data:) size:)))
				(- (myWindow y:) 83)
		)
		(super init: (param1 plane:))
		(self setPri: 1001)
	)

	(method (doit &tmp temp0)
		(= temp0 (GetTime))
		(while (== (GetTime) temp0)
		)
		(if (not (-- local0))
			(= local0 10)
			(if cel
				(= cel 0)
			else
				(= cel 1)
			)
		)
		(if (myWindow pwStars:)
			(self
				posn:
					(+
						(myWindow x:)
						115
						(* 9 (((myWindow pwStars:) data:) size:))
					)
					(- (myWindow y:) 83)
					1
			)
		)
		(self update:)
		(super doit:)
	)
)

(class PassWordWindow of View
	(properties
		x 170
		y 254
		view 3035
		bV 0
		okB 0
		cncB 0
		pwStars 0
		pw 0
		curPw 0
		pwCursor 0
	)

	(method (new param1 &tmp temp0 temp1 temp2)
		(= temp0 (super new:))
		((= temp2 (Plane new:))
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
			setPri: (+ (GetHighPlanePri) 1) 1
			drawPic: -2
		)
		(temp0 pw: (Str format: {%s} param1) init: temp2)
		(= temp1
			(cond
				((not ((temp0 curPw:) weigh: (temp0 pw:))) 1)
				((not ((temp0 curPw:) weigh: {~cancel~})) -1)
				(else 0)
			)
		)
		(temp0 dispose:)
		(temp2 dispose:)
		(return temp1)
	)

	(method (init param1)
		(gTheCursor set: 999 1 0)
		(self setPri: 1000)
		(super init: param1)
		(= okB (Rectangle new: 199 212 285 237))
		(= cncB (Rectangle new: 352 212 438 237))
		(self addTarget: okB addTarget: cncB)
		(= curPw (Str format: {}))
		(= pwStars (Stack new:))
		(= pwCursor (PWWCursor new: self))
		((gUser hogs:) push: self 1)
		(gUser doit:)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(if
			(and
				(& (event type:) evKEYBOARD)
				(or
					(OneOf (= temp1 (event message:)) JOY_UPLEFT KEY_SPACE)
					(<= KEY_a temp1 KEY_z)
					(<= KEY_A temp1 KEY_Z)
					(<= KEY_0 temp1 KEY_9)
				)
				(or (== temp1 JOY_UPLEFT) (<= (curPw size:) 16))
			)
			(cond
				((== (event message:) JOY_UPLEFT)
					(if (curPw size:)
						(= temp2 (curPw getLeft: (- (curPw size:) 1)))
						(curPw dispose:)
						(= curPw temp2)
						(if (= temp0 (pwStars peek:))
							(pwStars pop:)
							(temp0 dispose:)
						)
					)
				)
				((<= (curPw size:) 15)
					(if (<= KEY_a temp1 KEY_z)
						(-= temp1 32)
					)
					(= temp2 (Str format: {%c} temp1))
					(curPw cat: temp2)
					(temp2 dispose:)
					((= temp0 (View new:))
						view: 3035
						loop: 4
						cel: 0
						init: plane
						setPri: 1001
						posn: (+ x 115 (* 9 ((pwStars data:) size:))) (- y 75) 1
					)
					(pwStars push: temp0)
				)
			)
		else
			(if
				(and
					(& (event type:) evKEYBOARD)
					(OneOf (event message:) KEY_RETURN KEY_ESCAPE)
				)
				((gUser hogs:) pop:)
				(if (== (event message:) KEY_ESCAPE)
					(curPw dispose:)
					(= curPw (Str format: {~cancel~}))
				)
				(if bV
					(bV dispose:)
					(= bV 0)
				)
			else
				(event globalize: localize: plane)
				(cond
					((and bV (& (event type:) evMOUSERELEASE))
						(localproc_0 10)
						(if (bV onMe: event)
							((gUser hogs:) pop:)
							(if (== (bV loop:) 2)
								(curPw dispose:)
								(= curPw (Str format: {~cancel~}))
							)
						)
						(bV dispose:)
						(= bV 0)
					)
					((& (event type:) evMOUSEBUTTON)
						(cond
							((okB onMe: event)
								(= bV (View new:))
								(bV
									view: 3015
									loop: 1
									posn: 199 210
									setPri: 1001
									init: plane
								)
							)
							((cncB onMe: event)
								(= bV (View new:))
								(bV
									view: 3015
									loop: 2
									posn: 352 210
									setPri: 1001
									init: plane
								)
							)
						)
					)
				)
			)
			(pwStars doit:)
			(pwCursor doit:)
			(FrameOut)
			(event claimed: self)
			(return)
		)
	)

	(method (dispose)
		((pwStars data:) release:)
		(pwStars dispose:)
		(curPw dispose:)
		(pw dispose:)
		(target dispose:)
		(if bV
			(bV dispose:)
		)
		(super dispose: &rest)
	)
)

(class WynTextView of TextView
	(properties
		borderColor 255
		amHighlighted 0
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
		(self setPri: 1)
	)

	(method (draw param1)
		(= amHighlighted (if (and argc param1) 1 else 0))
		(text
			back: (if amHighlighted 0 else borderColor)
			skip: borderColor
			fore: (if amHighlighted borderColor else 0)
		)
		(self setSize:)
		(super draw:)
	)

	(method (setText)
		(super setText: &rest)
		(text font: 7007)
	)
)

(class WynNetItem of Obj
	(properties
		titleText 0
		iconV 0
		iconVLoop 0
		msgM -1
		msgN -1
		msgV -1
		msgC -1
		msgS -1
		passWd 0
		users 48
	)

	(method (new &tmp temp0)
		(= temp0 (super new:))
		(temp0 init: &rest)
		(return temp0)
	)

	(method (init param1 param2 param3 param4 param5)
		(self msgM: param1 msgN: param2 msgV: param3 msgC: param4 msgS: param5)
		(super init: &rest)
	)

	(method (show param1 param2 &tmp temp0)
		(= temp0 0)
		(if (not iconV)
			((= iconV (View new:))
				view: 3030
				loop: iconVLoop
				cel: 0
				init: gThePlane
				posn: param1 param2
				responder: self
				setPri: 400
				isHot: 1
				update:
			)
			(= temp0 (+ (CelWide 3030 iconVLoop 0) 5))
		)
		(if (not titleText)
			((= titleText (WynTextView new:))
				setText: msgM msgN msgV msgC msgS
				setSize:
				init: gThePlane
				posn: (+ param1 temp0) param2
				responder: self
				setPri: 400
				isHot: 1
				update:
			)
		)
	)

	(method (hide)
		(if titleText
			(titleText responder: 0 dispose:)
			(= titleText 0)
		)
		(if (not (OneOf iconV 0 24415))
			(iconV responder: 0 dispose:)
			(= iconV 0)
		)
	)

	(method (dispose)
		(self hide:)
		(if passWd
			(KArray 4 passWd) ; ArrayFree
			(= passWd 0)
		)
		(randomVisions restoreVision:)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (& (event type:) evMOUSEBUTTON)
			(gCurRoom handleEvent: self event &rest)
			(event claimed: self)
		)
		(event claimed:)
	)

	(method (checkPw &tmp temp0)
		(= temp0 1)
		(if (and passWd (<= (= temp0 (PassWordWindow new: passWd)) 0))
			(if (not temp0)
				(PasswordError new:)
			)
			(= temp0 0)
			(gCurRoom refresh:)
		)
		(return temp0)
	)

	(method (availableTo param1 param2)
		(if (> argc 1)
			(if param2
				(|= users param1)
			else
				(&= users (~ param1))
			)
		)
		(return (& users param1))
	)

	(method (msgIs param1 param2 param3 param4 param5)
		(return
			(if
				(and
					(== msgM param1)
					(== msgN param2)
					(== msgV param3)
					(== msgC param4)
					(== msgS param5)
				)
				self
			else
				0
			)
		)
	)
)

(class WynNet of Obj
	(properties
		SEANET -1
		SNW -1
		BST -1
	)

	(method (new)
		((super new:) init:)
	)

	(method (init)
		(= gWynNet self)
		(= SNW (Set new:))
		(= BST (Set new:))
		(= SEANET (Set new:))
		(return self)
	)

	(method (addFolder)
		(SNW add: &rest)
	)

	(method (delFolder)
		(SNW delete: &rest)
	)

	(method (findItem &tmp temp0)
		(if (= temp0 (SNW firstTrue: #msgIs &rest))
			(return temp0)
		)
		(if (= temp0 (BST firstTrue: #msgIs &rest))
			(return temp0)
		)
		(if (= temp0 (SNW firstTrue: #findItem &rest))
			(= temp0 (temp0 findItem: &rest))
		)
		(return temp0)
	)
)

(class WynNetFolder of WynNetItem
	(properties
		myFiles -1
	)

	(method (init)
		(super init: &rest)
		(= myFiles (Set new:))
		(gWynNet addFolder: self)
	)

	(method (add)
		(myFiles add: &rest)
	)

	(method (delete)
		(myFiles delete: &rest)
	)

	(method (dispose)
		(gWynNet delFolder: self)
		(super dispose:)
	)

	(method (hide)
		(myFiles eachElementDo: #hide)
		(super hide: &rest)
	)

	(method (findItem)
		(myFiles firstTrue: #msgIs &rest)
	)
)

(class WynNetDoco of WynNetItem
	(properties
		iconVLoop 1
		folder -1
		nameX 70
		nameY 10
		nameMsgM -1
		nameMsgN -1
		nameMsgV -1
		nameMsgC -1
		nameMsgS -1
		noteX 70
		noteY 30
		noteMsgM -1
		noteMsgN -1
		noteMsgV -1
		noteMsgC -1
		noteMsgS -1
		contL 18
		contR 348
		contT 117
		contB 359
		contMsgM -1
		contMsgN -1
		contMsgV -1
		contMsgC -1
		contMsgS -1
	)

	(method (init param1 param2 param3 param4 param5 param6 param7 param8 param9 param10 param11 param12 param13 param14 param15 param16 param17 param18 param19 param20 param21)
		(super init: param2 param3 param4 param5 param6)
		(self
			nameMsgM: param7
			nameMsgN: param8
			nameMsgV: param9
			nameMsgC: param10
			nameMsgS: param11
			noteMsgM: param12
			noteMsgN: param13
			noteMsgV: param14
			noteMsgC: param15
			noteMsgS: param16
			contMsgM: param17
			contMsgN: param18
			contMsgV: param19
			contMsgC: param20
			contMsgS: param21
		)
		((= folder param1) add: self)
		(if (== folder (gWynNet BST:))
			(folder addToFront: self)
		)
	)

	(method (open param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp3 (- contB contT))
		((= temp0 (WynTextView new:))
			setText: nameMsgM nameMsgN nameMsgV nameMsgC nameMsgS
			setSize:
			init: gThePlane
			posn: nameX nameY
		)
		(param1 nameText: temp0)
		((= temp0 (WynTextView new:))
			setText: noteMsgM noteMsgN noteMsgV noteMsgC noteMsgS
			setSize:
			init: gThePlane
			posn: noteX noteY
		)
		(param1 noteText: temp0)
		((= temp1 (Plane new:))
			init: contL contT contR contB
			setPri: (+ (GetHighPlanePri) 1) 1
			drawPic: -2
		)
		(param1 docoTextPlane: temp1)
		((= temp0 (WynDocTextView new:))
			setText: contMsgM contMsgN contMsgV contMsgC contMsgS
		)
		((temp0 text:) setSize: (- contR contL))
		(temp0 setSize: init: temp1 posn: 0 0 responder: self setPri: 400)
		(param1 docoText: temp0)
		(temp0 cue: (param1 docoPos:) 1)
		(= temp4
			(if (or (self isKindOf: WynNetEmail) (self isKindOf: EmailResponse))
				8
			else
				1
			)
		)
		(if (> (+ (temp0 celHeight:) temp4) temp3)
			(= temp2
				(P2ScrollBar
					new:
						temp0
						(+ temp4 (/ (- (temp0 celHeight:) temp3) 14))
						(/ temp3 14)
						3025
						357
						47
				)
			)
			((temp2 forwardRegion:) fore: 0)
			((temp2 reverseRegion:) fore: 0)
			(param1 docoScrollbar: temp2)
			(temp2 move: (param1 docoPos:) 1)
		)
	)

	(method (dispose)
		(folder delete: self)
		(= folder -1)
		(super dispose:)
	)
)

(class WynDocTextView of WynTextView
	(properties)

	(method (setRect)
		(super
			setRect:
				0
				0
				(- (plane right:) (plane left:))
				(- (plane bottom:) (plane top:))
		)
	)

	(method (cue param1 param2 &tmp temp0 temp1)
		(self posn: 0 (- 0 (* param1 14)) 1)
		(if (not (and argc param2))
			(FrameOut)
		)
		(for ((= temp0 0)) (< temp0 10) ((++ temp0))
			(= temp1 (GetTime))
			(while (== temp1 (GetTime))
			)
		)
		(gCurRoom docoPos: param1)
	)
)

(class WynNetEmail of WynNetDoco
	(properties
		iconV 24415
		users 16
		nameX 73
		nameY 8
		noteX 73
		noteY 28
		subjText 0
		subjMsgM -1
		subjMsgN -1
		subjMsgV -1
		subjMsgC -1
		subjMsgS -1
		funnyR 0
		sarcasticR 0
		straightR 0
	)

	(method (init param1 param2 param3 param4 param5 param6 param7 param8 param9 param10 param11 param12 param13 param14 param15 param16 param17 param18 param19 param20)
		(super
			init:
				(gWynNet BST:)
				param1
				param2
				param3
				param4
				param5
				param6
				param7
				param8
				param9
				param10
				param11
				param12
				param13
				param14
				param15
				param16
				param17
				param18
				param19
				param20
		)
		(self
			subjMsgM: param11
			subjMsgN: param12
			subjMsgV: param13
			subjMsgC: param14
			subjMsgS: param15
		)
		(if (and gCurRoom (gCurRoom isKindOf: WynPostalWare))
			(gCurRoom refresh:)
		)
	)

	(method (show param1 param2 param3)
		(super show: param1 param3)
		(if (not subjText)
			((= subjText (WynTextView new:))
				setText: subjMsgM subjMsgN subjMsgV subjMsgC subjMsgS
				setSize:
				init: gThePlane
				posn: param2 param3
				responder: self
				setPri: 400
				update:
			)
		)
	)

	(method (hide)
		(if subjText
			(subjText responder: 0 dispose:)
			(= subjText 0)
		)
		(super hide:)
	)
)

(class EmailResponse of WynNetEmail
	(properties
		time 0
		users 0
		sent 0
		orig 0
	)

	(method (send)
		(= time (Clone Timer))
		(time cuee: self cueSelector: 20 plane: 0 set: 3 (Random 30 120))
		(gCast add: time)
		(= sent 1)
	)

	(method (cue)
		((WynNetEmail
				new:
					(orig msgM:)
					(orig msgN:)
					(orig msgV:)
					(orig msgC:)
					(orig msgS:)
					(orig nameMsgM:)
					(orig nameMsgN:)
					(orig nameMsgV:)
					(orig nameMsgC:)
					(orig nameMsgS:)
					(orig noteMsgM:)
					(orig noteMsgN:)
					(orig noteMsgV:)
					(orig noteMsgC:)
					(orig noteMsgS:)
					contMsgM
					contMsgN
					contMsgV
					contMsgC
					(+ contMsgS 1)
			)
			users: users
		)
		(= time 0)
	)

	(method (dispose)
		(if time
			(time dispose:)
			(= time 0)
		)
		(super dispose:)
	)
)

(class WynLogin of WynCompBaseRoom
	(properties
		picture 3010
		pwStars 0
		curPw 0
		pwCursor 0
		allowWho 16
		selectedName 0
		loginName 0
		loginPW 0
		loginBtn 0
		cancelBtn 0
	)

	(method (init &tmp temp0 temp1)
		(= local3 1)
		(if (not (OneOf (self currentState:) 0 1))
			(self
				newRoom:
					(cond
						((== (& (self currentState:) $000f) 2) docuStoreRm)
						((== (& (self currentState:) $000f) 3) postalWareRm)
						((== (& (self currentState:) $000f) 4) sysconRm)
					)
			)
			(return)
		else
			(self currentState: 1)
		)
		(super init: &rest)
		(= curPw (Str new: 0))
		(= pwStars (Stack new:))
		(for ((= temp0 0)) (<= temp0 6) ((++ temp0))
			((= temp1 (LoginName new:))
				view: 3010
				loop: temp0
				init: gThePlane
				posn: 62 (+ 63 (* temp0 12)) 1
				responder: self
				setPri: 400
				isHot: 1
				update:
			)
		)
		((= loginBtn (WynOneCelButn new:))
			init: 350 215 436 240
			view: 3010
			loop: 7
			vX: 350
			vY: 215
			priority: 400
			isHot: 1
		)
		((= cancelBtn (WynOneCelButn new:))
			init: 503 215 589 240
			view: 3010
			loop: 8
			vX: 503
			vY: 215
			priority: 400
			isHot: 1
		)
		((TypingFeature new:) init: responder: self priority: 400)
	)

	(method (handleEvent event param2 &tmp temp0 temp1 temp2)
		(cond
			(
				(and
					loginName
					(or
						(<= 97 (= temp0 (param2 message:)) 122)
						(<= 65 temp0 90)
						(<= 48 temp0 57)
						(== temp0 32)
					)
					(<= (curPw size:) 15)
				)
				(if (<= 97 temp0 122)
					(-= temp0 32)
				)
				(= temp2 (Str format: {%c} temp0))
				(curPw cat: temp2)
				(temp2 dispose:)
				((= temp1 (View new:))
					view: 3010
					loop: 9
					cel: 0
					posn: (+ 437 (* 9 ((pwStars data:) size:))) 132
					init: gThePlane
					setPri: 1
				)
				(pwStars push: temp1)
			)
			((== (param2 message:) 8)
				(if (curPw size:)
					(= temp2 (curPw getLeft: (- (curPw size:) 1)))
					(curPw dispose:)
					(= curPw temp2)
					(if (= temp1 (pwStars peek:))
						(pwStars pop:)
						(temp1 dispose:)
					)
				)
			)
			((or (== event loginBtn) (== (param2 message:) 13))
				(if loginName
					(switch (loginName loop:)
						(1
							(if
								(or
									(not (& allowWho $0010))
									(curPw weigh: {BLOB})
								)
								(Send new: LoginError 5)
								(curPw dispose:)
								(= curPw (Str new: 0))
								(pwStars dispose:)
								(= pwStars (Stack new:))
							else
								(self
									currentState:
										(|
											(&
												(self currentState:)
												(~
													(&
														(self currentState:)
														$00f0
													)
												)
											)
											$0010
										)
									newRoom: docuStoreRm
								)
							)
						)
						(2
							(if (not (curPw weigh: {XXX}))
								(eggAMatic add: 4041 1 50)
								(= temp2 (Str format: {}))
								(proc64986_1 temp2 15 {Enter nudity code:})
								(if (not (temp2 weigh: {adrienne}))
									(eggAMatic add: 4041 2 100)
									(Send new: ncCode 9 (loginName loop:))
								else
									(gP2SoundFX play: (Random 4804 4808))
									(Send new: LoginError 5)
								)
								(temp2 dispose:)
							else
								(Send new: LoginError 5)
							)
							(curPw dispose:)
							(= curPw (Str new: 0))
							(pwStars dispose:)
							(= pwStars (Stack new:))
						)
						(3
							(if
								(or
									(not (& allowWho $0020))
									(curPw weigh: {CARPE DIEM})
								)
								(Send new: LoginError 5)
								(curPw dispose:)
								(= curPw (Str new: 0))
								(pwStars dispose:)
								(= pwStars (Stack new:))
							else
								(self
									currentState:
										(|
											(&
												(self currentState:)
												(~
													(&
														(self currentState:)
														$00f0
													)
												)
											)
											$0020
										)
									newRoom: docuStoreRm
								)
							)
						)
						(4
							(if (not (curPw weigh: {XXX}))
								(= temp2 (Str format: {}))
								(proc64986_1 temp2 15 {Enter nudity code:})
								(eggAMatic add: 4041 1 50)
								(if (not (temp2 weigh: {adrienne}))
									(eggAMatic add: 4041 2 100)
									(Send new: ncCode 9 (loginName loop:))
								else
									(gP2SoundFX play: (Random 4804 4808))
									(Send new: LoginError 5)
								)
								(temp2 dispose:)
							else
								(Send new: LoginError 5)
							)
							(curPw dispose:)
							(= curPw (Str new: 0))
							(pwStars dispose:)
							(= pwStars (Stack new:))
						)
						(6
							(if (not (curPw weigh: {BELLYBUTTON}))
								(eggAMatic add: 4041 4 49)
								(self
									currentState:
										(|
											(&
												(self currentState:)
												(~
													(&
														(self currentState:)
														$00f0
													)
												)
											)
											$0040
										)
									newRoom: docuStoreRm
								)
							else
								(Send new: LoginError 5)
								(curPw dispose:)
								(= curPw (Str new: 0))
								(pwStars dispose:)
								(= pwStars (Stack new:))
							)
						)
						(else
							(Send new: LoginError 5)
							(curPw dispose:)
							(= curPw (Str new: 0))
							(pwStars dispose:)
							(= pwStars (Stack new:))
						)
					)
				)
			)
			((or (== event cancelBtn) (== (param2 message:) 27))
				(self currentState: 0)
				(gCurRoom newRoom: exitRoom)
			)
			((& (param2 type:) $0001)
				(if selectedName
					(selectedName setCel: 0)
				)
				(= selectedName event)
				(if (not loginName)
					((= loginName (View new:))
						view: 3010
						loop: (selectedName loop:)
						cel: 2
						init: gThePlane
						posn: 432 77
					)
				)
				(loginName setLoop: (selectedName loop:))
				(if (not pwCursor)
					(= pwCursor (LoginCursor new:))
				)
				(curPw dispose:)
				(= curPw (Str new: 0))
				(pwStars dispose:)
				(= pwStars (Stack new:))
			)
		)
	)

	(method (dispose)
		(if curPw
			(curPw dispose:)
			(= curPw 0)
		)
		(if pwStars
			(pwStars dispose:)
			(= pwStars 0)
		)
		(if loginBtn
			(loginBtn responder: 0 dispose:)
			(= loginBtn 0)
		)
		(if cancelBtn
			(cancelBtn responder: 0 dispose:)
			(= cancelBtn 0)
		)
		(if pwCursor
			(pwCursor dispose:)
			(= pwCursor 0)
		)
		(if (!= gNewRoomNum gCurRoomNum)
			((gUser primaDonnas:) delete: (gTheCursor hotObject:))
			(= selectedName 0)
		)
		(super dispose: &rest)
	)
)

(instance LoginCursor of View
	(properties
		x 437
		y 123
		view 3010
		loop 13
	)

	(method (new &tmp temp0)
		(= temp0 (super new:))
		(temp0 init:)
		(return temp0)
	)

	(method (init)
		(super init: gThePlane)
	)

	(method (doit &tmp temp0)
		(= temp0 (GetTime))
		(while (== (GetTime) temp0)
		)
		(if (not (-- local0))
			(= local0 10)
			(if cel
				(= cel 0)
			else
				(= cel 1)
			)
		)
		(if (gCurRoom pwStars:)
			(self posn: (+ 437 (* 9 (((gCurRoom pwStars:) data:) size:))) y 1)
		)
		(self update:)
		(super doit:)
	)
)

(instance LoginName of View
	(properties)

	(method (handleEvent event)
		(if
			(and
				(not cel)
				(& (event type:) evMOUSEBUTTON)
				(responder handleEvent: self event &rest)
			)
			(self setCel: 1)
			(event claimed: self)
		)
		(event claimed:)
	)

	(method (dispose)
		(= responder 0)
		(super dispose:)
	)
)

(instance LoginError of PasswordError
	(properties
		view 3010
		loop 11
	)
)

(class WynDocuStore of WynCompBaseRoom
	(properties
		picture 3030
		nameText 0
		noteText 0
		docoTextPlane 0
		docoText 0
		docoPos 0
		docoScrollbar 0
		curFolder 0
		curDoco 0
	)

	(method (init)
		(self
			currentState:
				(|
					(& (self currentState:) (~ (& (self currentState:) $000f)))
					$0002
				)
		)
		(super init: &rest)
		(randomVisions start:)
	)

	(method (hideAll)
		((gWynNet SNW:) eachElementDo: #hide)
		(self hideDoco:)
		(super hideAll:)
	)

	(method (refresh)
		(super refresh:)
		(self showList: 391 25 (gWynNet SNW:))
		(if (and curFolder ((gWynNet SNW:) contains: curFolder))
			(if (curFolder iconV:)
				((curFolder iconV:) setCel: 1)
			)
			(self showList: 392 139 (curFolder myFiles:))
			(if (and curDoco ((curFolder myFiles:) contains: curDoco))
				(if (curDoco iconV:)
					((curDoco iconV:) setCel: 1)
				)
				(self showDoco:)
			else
				(= curDoco 0)
			)
		else
			(= curFolder 0)
		)
	)

	(method (showList param1 param2 param3 &tmp temp0 temp1 temp2)
		(= temp1 param2)
		(for ((= temp0 (param3 first:))) temp0 ((= temp0 (param3 next: temp0)))
			(= temp2 (param3 value: temp0))
			(if (temp2 availableTo: (& (self currentState:) $00f0))
				(temp2 show: param1 temp1)
				(+=
					temp1
					(Max
						(CelHigh
							((temp2 iconV:) view:)
							((temp2 iconV:) loop:)
							((temp2 iconV:) cel:)
						)
						((temp2 titleText:) celHeight:)
					)
				)
				(-- temp1)
			)
		)
	)

	(method (showDoco param1)
		(self hideDoco:)
		(if argc
			(= curDoco param1)
		)
		(curDoco open: self)
	)

	(method (openFolder param1)
		(if (and (!= curFolder param1) (param1 checkPw:))
			(self hideDoco:)
			(= curDoco 0)
			(= curFolder param1)
		)
		(self refresh:)
	)

	(method (openDoco param1 param2)
		(cond
			((== (param1 msgM:) 3009)
				(= local4 1)
				(switch (param1 msgC:)
					(2
						(self newRoom: 3009) ; pRoom
					)
					(3
						(ClearFlag 1004)
						(if (& (param2 modifiers:) $0008)
							(SetFlag 1004)
							(eggAMatic add: 4041 8 1)
						)
						(self newRoom: 6868) ; ph2Invaders
					)
					(4
						(self newRoom: 30091) ; trek
					)
				)
				(= local4 0)
			)
			((!= curDoco param1)
				(if (param1 checkPw:)
					(= curDoco param1)
					(= docoPos 0)
				)
				(self refresh:)
			)
		)
	)

	(method (hideDoco)
		(if nameText
			(nameText responder: 0 dispose:)
			(= nameText 0)
		)
		(if noteText
			(noteText responder: 0 dispose:)
			(= noteText 0)
		)
		(if docoText
			(docoText responder: 0 dispose:)
			(= docoText 0)
		)
		(if docoTextPlane
			(docoTextPlane dispose:)
			(= docoTextPlane 0)
		)
		(if docoScrollbar
			(docoScrollbar dispose:)
			(= docoScrollbar 0)
		)
	)

	(method (handleEvent event param2)
		(cond
			((event isKindOf: WynNetDoco)
				(self openDoco: event param2)
			)
			((event isKindOf: WynNetFolder)
				(self openFolder: event param2)
			)
		)
	)

	(method (slideDoors)
		(if (not local4)
			(super slideDoors: &rest)
		)
	)

	(method (dispose)
		(if (!= (self currentState:) 0)
			(myIni read: 675 curFolder)
			(myIni read: 676 curDoco)
			(myIni read: 654 docoPos)
		)
		(randomVisions stop:)
		(super dispose: &rest)
	)
)

(instance ncCode of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1)
		(gP2SongPlyr pause: 1)
		(= temp0 (TextView new:))
		(if (IsFlag 1003)
			(temp0
				setText: {Nudity code De-activated!}
				setSize:
				posn: 300 160
				init: gThePlane
			)
			(ClearFlag 1003)
		else
			(temp0
				setText: {Nudity code activated!}
				setSize:
				posn: 300 160
				init: gThePlane
			)
			(SetFlag 1003)
		)
		(FrameOut)
		(switch param1
			(2
				(if (IsFlag 1003)
					(= temp1 4800)
				else
					(= temp1 4801)
				)
			)
			(4
				(if (IsFlag 1003)
					(= temp1 4802)
				else
					(= temp1 4803)
				)
			)
			(else
				(temp0 dispose:)
				(gP2SongPlyr pause: 0)
				(return 0)
			)
		)
		(gP2SoundFX play: temp1)
		(while (!= -1 (DoAudio audPOSITION temp1))
		)
		(temp0 dispose:)
		(return (gP2SongPlyr pause: 0))
	)
)

(class WynPostalWare of WynCompBaseRoom
	(properties
		picture 3020
		nameText 0
		noteText 0
		docoTextPlane 0
		docoText 0
		docoPos 0
		docoScrollbar 0
		curMessage 0
		oldMessage 0
		topMessage 0
		msgScrollbar 0
	)

	(method (init)
		(super init: &rest)
		((ScriptID 63000 2) dispose:) ; eExit
		(self
			currentState:
				(|
					(& (self currentState:) (~ (& (self currentState:) $000f)))
					$0003
				)
		)
	)

	(method (hideAll)
		((gWynNet BST:) eachElementDo: #hide)
		(self hideMsg:)
		(if msgScrollbar
			(msgScrollbar dispose:)
			(= msgScrollbar 0)
		)
		(super hideAll:)
	)

	(method (hideMsg)
		(if nameText
			(nameText responder: 0 dispose:)
			(= nameText 0)
		)
		(if noteText
			(noteText responder: 0 dispose:)
			(= noteText 0)
		)
		(if docoText
			(docoText responder: 0 dispose:)
			(= docoText 0)
		)
		(if docoTextPlane
			(docoTextPlane dispose:)
			(= docoTextPlane 0)
		)
		(if docoScrollbar
			(docoScrollbar dispose:)
			(= docoScrollbar 0)
		)
	)

	(method (refresh &tmp temp0 temp1 temp2)
		(= temp0 topMessage)
		(super refresh:)
		(= temp2 0)
		(for ((= temp1 0)) (< temp1 ((gWynNet BST:) size:)) ((++ temp1))
			(if
				(((gWynNet BST:) at: temp1)
					availableTo: (& (self currentState:) $00f0)
				)
				(++ temp2)
			)
		)
		(if (> temp2 19)
			(= msgScrollbar
				(P2ScrollBar
					new:
						topMsgScript
						(Max 0 (- temp2 19))
						19
						3021
						614
						27
				)
			)
			((msgScrollbar forwardRegion:) fore: 0)
			((msgScrollbar reverseRegion:) fore: 0)
			(msgScrollbar move: temp0 1)
		)
		(self showList: 387 453 25 (gWynNet BST:))
		(if (and curMessage ((gWynNet BST:) contains: curMessage))
			(self showMsg:)
			(FrameOut)
			(if (curMessage titleText:)
				((curMessage titleText:) draw: 1)
			)
			(if (curMessage subjText:)
				((curMessage subjText:) draw: 1)
			)
		else
			(= curMessage 0)
		)
	)

	(method (showList param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
		(= temp3 (Set new:))
		(for ((= temp0 0)) (< temp0 (param4 size:)) ((++ temp0))
			(if ((param4 at: temp0) availableTo: (& (self currentState:) $00f0))
				(temp3 add: (param4 at: temp0))
			)
		)
		(if (< (- (temp3 size:) topMessage) 19)
			(= topMessage (Max 0 (- (temp3 size:) 19)))
			(if msgScrollbar
				(msgScrollbar move: topMessage 1)
			)
		)
		(= temp1 param3)
		(for
			((= temp0 topMessage))
			(< temp0 (Min (temp3 size:) (+ topMessage 19)))
			((++ temp0))
			
			(= temp2 (temp3 at: temp0))
			(temp2 show: param1 param2 temp1)
			(+= temp1 ((temp2 titleText:) celHeight:))
		)
		(temp3 release: dispose:)
	)

	(method (showMsg param1)
		(self hideMsg:)
		(if argc
			(= curMessage param1)
		)
		(curMessage open: self)
		(if (and (curMessage isKindOf: EmailResponse) (not (curMessage sent:)))
			(responseSendButn new: docoTextPlane curMessage)
			(responseCancelButn new: docoTextPlane curMessage)
		else
			(if (curMessage straightR:)
				(responseChoiceButn new: 0 docoTextPlane curMessage)
			)
			(if (curMessage funnyR:)
				(responseChoiceButn new: 1 docoTextPlane curMessage)
			)
			(if (curMessage sarcasticR:)
				(responseChoiceButn new: 2 docoTextPlane curMessage)
			)
		)
	)

	(method (openMsg param1)
		(if (!= curMessage param1)
			(= docoPos 0)
			(= curMessage param1)
			(self refresh:)
		)
	)

	(method (handleEvent event)
		(if (event isKindOf: WynNetEmail)
			(self openMsg: event)
		)
	)

	(method (dispose)
		(if (!= (self currentState:) 0)
			(myIni
				read: 682 curMessage
				read: 683 oldMessage
				read: 684 topMessage
				read: 654 docoPos
			)
		)
		(super dispose: &rest)
	)
)

(instance topMsgScript of Script
	(properties)

	(method (cue param1 &tmp temp0)
		(gCurRoom topMessage: param1)
		((= temp0 (SendMany new: gCurRoom 589)) needsDoits: 1)
		(((gCurRoom plane:) cast:) add: temp0)
	)
)

(class EmailThreadButton of View
	(properties
		y 216
		view 3020
		whichMsg 0
	)

	(method (new &tmp temp0)
		(= temp0 (super new:))
		(temp0 init: &rest)
	)

	(method (init param1 param2)
		(super init: param1)
		(((param1 cast:) eventList:) addToFront: self)
		(= whichMsg param2)
		(self setPri: 1000)
	)

	(method (handleEvent event)
		(switch cel
			(0
				(if (& (event type:) evMOUSEBUTTON)
					((gUser hogs:) push: self 1)
					(self setCel: 1)
				)
			)
			(1
				(event globalize: localize: plane)
				(FrameOut)
				(if (& (event type:) evMOUSERELEASE)
					(localproc_0 10)
					((gUser hogs:) pop:)
					(self setCel: 0)
					(if (self onMe: event)
						(self action:)
					)
				)
			)
		)
	)
)

(instance responseChoiceButn of EmailThreadButton
	(properties)

	(method (init param1)
		(switch param1
			(1
				(= loop 1)
				(= x 117)
			)
			(2
				(= loop 2)
				(= x 217)
			)
			(0
				(= loop 0)
				(= x 3)
			)
		)
		(super init: &rest)
	)

	(method (action &tmp temp0)
		(switch loop
			(1
				(= temp0 (whichMsg funnyR:))
			)
			(2
				(= temp0 (whichMsg sarcasticR:))
			)
			(0
				(= temp0 (whichMsg straightR:))
			)
		)
		(temp0 users: 16)
		(gCurRoom oldMessage: whichMsg)
		(gCurRoom curMessage: temp0 docoPos: 0 refresh:)
	)
)

(instance responseSendButn of EmailThreadButton
	(properties
		x 66
		loop 3
	)

	(method (action)
		(whichMsg send: orig: (gCurRoom oldMessage:))
		((gCurRoom oldMessage:) funnyR: 0 sarcasticR: 0 straightR: 0)
		(gCurRoom curMessage: 0 oldMessage: 0 docoPos: 0 refresh:)
	)

	(method (dispose)
		(if (and whichMsg (not (whichMsg sent:)))
			(whichMsg users: 0)
		)
		(super dispose:)
	)
)

(instance responseCancelButn of EmailThreadButton
	(properties
		x 173
		loop 4
	)

	(method (action)
		(whichMsg users: 0)
		(gCurRoom
			curMessage: (gCurRoom oldMessage:)
			oldMessage: 0
			docoPos: 0
			refresh:
		)
	)
)

(class WynSyscon of WynCompBaseRoom
	(properties
		picture 3060
		whichComp 1
		selectedName 0
		adjustName 0
		levelView 0
		upBtn 0
		downBtn 0
		okBtn 0
		cnclBtn 0
		nameList 0
	)

	(method (init &tmp [temp0 2])
		(self currentState: (| (& (self currentState:) $fff0) $0004))
		(= local1 global226)
		(= local2 0)
		(super init: &rest)
	)

	(method (handleEvent event param2 &tmp temp0 temp1)
		(cond
			((and adjustName (not local2) (OneOf event upBtn downBtn))
				(= temp1 (confirmation new:))
				(if (== 1 temp1)
					(= local2 1)
					(self handleEvent: event param2 &rest)
				else
					(if (not temp1)
						(PasswordError new:)
					)
					(= local2 0)
				)
			)
			((== event upBtn)
				(if adjustName
					(self setLevel: (+ (self getLevel:) 1))
					(if levelView
						(levelView dispose:)
					)
					(= levelView (WynTextView new:))
					(levelView
						setText:
							(switch (self getLevel:)
								(1 {1})
								(2 {2})
								(3 {3})
							)
						setSize:
						posn: 470 124
						init: gThePlane
					)
					(if (and (== selectedName 2) (>= (self getLevel:) 2))
						(SetFlag 522)
					)
				)
			)
			((== event downBtn)
				(if adjustName
					(self setLevel: (- (self getLevel:) 1))
					(if levelView
						(levelView dispose:)
					)
					(= levelView (WynTextView new:))
					(levelView
						setText:
							(switch (self getLevel:)
								(1 {1})
								(2 {2})
								(3 {3})
							)
						setSize:
						posn: 470 124
						init: gThePlane
					)
					(if
						(and
							selectedName
							(== selectedName 2)
							(<= (self getLevel:) 1)
						)
						(ClearFlag 522)
					)
				)
			)
			((OneOf event okBtn cnclBtn)
				(if (== event okBtn)
					(= local1 global226)
				)
				(self newRoom: docuStoreRm)
			)
			((& (param2 type:) $0001)
				(= temp0 selectedName)
				(if selectedName
					((nameList at: (- selectedName 1)) setCel: 0 update:)
				)
				(= selectedName (- (event loop:) 4))
				((nameList at: (- selectedName 1)) setCel: 1 update:)
				(if (not (self getLevel:))
					(errDeceased new:)
					(= selectedName temp0)
					(self refresh:)
					(return 0)
				else
					(if (not adjustName)
						(= adjustName (View new:))
					)
					(adjustName
						view: 3060
						loop: (+ selectedName 12)
						cel: 0
						init: gThePlane
						posn: 432 77
					)
					(if levelView
						(levelView dispose:)
					)
					(= levelView (WynTextView new:))
					(levelView
						setText:
							(switch (self getLevel:)
								(1 {1})
								(2 {2})
								(3 {3})
							)
						setSize:
						posn: 470 124
						init: gThePlane
					)
				)
				(if selectedName
					((nameList at: (- selectedName 1)) setCel: 1 update:)
				)
			)
		)
	)

	(method (refresh &tmp temp0 temp1)
		(super refresh:)
		(= nameList (Set new:))
		(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
			((= temp1 (LoginName new:))
				view: 3060
				loop: (+ temp0 5)
				init: gThePlane
				posn: 62 (+ 63 (* temp0 12)) 1
				responder: self
				setPri: 400
				isHot: 1
				update:
			)
			(nameList add: temp1)
		)
		((= upBtn (WynOneCelButn new:))
			init: 498 114 515 129
			view: 3060
			loop: 0
			vX: 498
			vY: 114
			priority: 400
			isHot: 1
		)
		((= downBtn (WynOneCelButn new:))
			init: 498 130 515 145
			view: 3060
			loop: 1
			vX: 498
			vY: 130
			priority: 400
			isHot: 1
		)
		((= okBtn (WynOneCelButn new:))
			init: 351 215 437 240
			view: 3060
			loop: 11
			vX: 351
			vY: 215
			priority: 400
			isHot: 1
		)
		((= cnclBtn (WynOneCelButn new:))
			init: 503 215 589 240
			view: 3060
			loop: 12
			vX: 503
			vY: 215
			priority: 400
			isHot: 1
		)
		(if selectedName
			(= adjustName (View new:))
			(adjustName
				view: 3060
				loop: (+ selectedName 12)
				cel: 0
				init: gThePlane
				posn: 432 77
			)
			(if levelView
				(levelView dispose:)
			)
			(= levelView (WynTextView new:))
			(levelView
				setText:
					(switch (self getLevel:)
						(1 {1})
						(2 {2})
						(3 {3})
					)
				setSize:
				posn: 470 124
				init: gThePlane
			)
			((nameList at: (- selectedName 1)) setCel: 1)
		)
	)

	(method (hideAll)
		(if upBtn
			(upBtn responder: 0 dispose:)
			(= upBtn 0)
		)
		(if downBtn
			(downBtn responder: 0 dispose:)
			(= downBtn 0)
		)
		(if levelView
			(levelView dispose:)
			(= levelView 0)
		)
		(if adjustName
			(adjustName dispose:)
			(= adjustName 0)
		)
		(if nameList
			(nameList dispose:)
			(= nameList 0)
		)
		(if okBtn
			(okBtn dispose:)
			(= okBtn 0)
		)
		(if cnclBtn
			(cnclBtn dispose:)
			(= cnclBtn 0)
		)
		(super hideAll:)
	)

	(method (getLevel &tmp temp0 temp1)
		(if (not selectedName)
			(return 0)
		)
		(= temp0 (* 2 (- selectedName 1)))
		(return (= temp1 (& $0003 (>> global226 temp0))))
	)

	(method (setLevel param1 &tmp temp0 temp1)
		(if (not selectedName)
			(return 0)
		)
		(cond
			((or (not argc) (< param1 1))
				(= temp1 1)
				(errNoLower new:)
			)
			((> param1 3)
				(= temp1 3)
			)
			(else
				(= temp1 param1)
			)
		)
		(= temp0 (* 2 (- selectedName 1)))
		(return
			(= global226
				(| (& global226 (~ (<< $0003 temp0))) (<< temp1 temp0))
			)
		)
	)

	(method (dispose)
		(= global226 local1)
		(= local2 0)
		(super dispose: &rest)
	)
)

(instance confirmation of PassWordWindow
	(properties
		y 257
		view 3060
		loop 2
	)

	(method (new)
		(super new: {BLACKLOTUS})
	)
)

(instance errDeceased of PasswordError
	(properties
		view 3060
		loop 4
	)
)

(instance errNoLower of PasswordError
	(properties
		view 3060
	)
)

(class randomVisions of Obj
	(properties
		lastTime 0
		frequency 8
		duration 15
		timeLeft 1
		curVision 0
		tM 0
		tN 0
		tV 0
		tC 0
		tS 0
	)

	(method (start)
		(if (and (IsFlag 46) (== (& (gCurRoom currentState:) $00f0) 16))
			(= timeLeft (= frequency (- 9 gChapter)))
			(= lastTime (GetTime 1)) ; SysTime12
			(gCast add: self)
		)
	)

	(method (stop)
		(gCast delete: self)
		(self restoreVision:)
	)

	(method (doit)
		(cond
			(curVision
				(if (!= lastTime (GetTime))
					(= lastTime (GetTime))
					(if (not (-- timeLeft))
						(self restoreVision:)
					)
				)
			)
			((!= lastTime (GetTime 1)) ; SysTime12
				(= lastTime (GetTime 1)) ; SysTime12
				(if (not (-- timeLeft))
					(self createVision:)
				)
			)
		)
	)

	(method (restoreVision)
		(if curVision
			(curVision msgM: tM msgN: tN msgV: tV msgC: tC msgS: tS)
			(= curVision 0)
			(= lastTime (GetTime 1)) ; SysTime12
			(= timeLeft frequency)
			(if
				(and
					gCurRoom
					(gCurRoom isKindOf: WynCompBaseRoom)
					(== gCurRoomNum gNewRoomNum)
					((gUser hogs:) isEmpty:)
				)
				(gCurRoom refresh:)
			)
		)
	)

	(method (createVision &tmp temp0 temp1 temp2)
		(if curVision
			(self restoreVision:)
		)
		(= temp2 (Random 1 2))
		(= temp0 0)
		(while (or (not temp0) (not (temp0 size:)))
			(switch temp2
				(1
					(= temp0 (gWynNet SNW:))
				)
				(2
					(= temp0
						(((gWynNet SNW:)
								at: (Random 0 (- ((gWynNet SNW:) size:) 1))
							)
							myFiles:
						)
					)
				)
			)
		)
		(= temp2
			(if (== (temp0 size:) 1)
				0
			else
				(Random 0 (- (temp0 size:) 1))
			)
		)
		(= temp1 (temp0 at: temp2))
		(= tM (temp1 msgM:))
		(= tN (temp1 msgN:))
		(= tV (temp1 msgV:))
		(= tC (temp1 msgC:))
		(= tS (temp1 msgS:))
		(temp1 msgM: 6301 msgN: 10 msgV: 0 msgC: 45 msgS: (Random 1 20))
		(= lastTime (GetTime))
		(= timeLeft duration)
		(= curVision temp1)
		(if
			(and
				gCurRoom
				(gCurRoom isKindOf: WynCompBaseRoom)
				(== gCurRoomNum gNewRoomNum)
				((gUser hogs:) isEmpty:)
			)
			(gCurRoom refresh:)
		)
	)
)

