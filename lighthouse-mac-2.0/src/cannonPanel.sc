;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Main)
(use Plane)
(use Print)
(use Dialog)
(use PanelPlane)
(use Cursor)
(use Sound)
(use Actor)
(use System)

(public
	cannonPanel 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
)

(instance cannonPanel of PanelPlane
	(properties)

	(method (init param1 &tmp temp0)
		(= local0 0)
		(= local1 0)
		(= local2 0)
		(= local3 0)
		(= local4 0)
		(= local5 0)
		(= local6 0)
		(= local7 0)
		(= local8 0)
		(= local9 0)
		(= local10 0)
		(= local12 0)
		(= local13 0)
		(= local14 0)
		(= local15 0)
		(= local16 0)
		(= local17 0)
		(= local18 0)
		(= local19 0)
		(= local20 0)
		(gInventory addItem: (ScriptID 9 59)) ; invStock
		(= priority (+ (GetHighPlanePri) 1))
		(= picture -1)
		(super init: 0 0 640 480)
		(switch param1
			((ScriptID 9 31) ; invIonizer
				(= local0 part1)
				(= local2 selectPart1)
			)
			((ScriptID 9 62) ; invBarrel
				(= local0 part2)
				(= local2 selectPart2)
			)
			((ScriptID 9 61) ; invFiringMechanism
				(= local0 part3)
				(= local2 selectPart3)
			)
			((ScriptID 9 58) ; invVacuumPump
				(= local0 part4)
				(= local2 selectPart4)
			)
			((ScriptID 9 60) ; invPowerSupply
				(= local0 part5)
				(= local2 selectPart5)
			)
			((ScriptID 9 59) ; invStock
				(= local0 part6)
				(= local2 selectPart6)
			)
			((ScriptID 9 57) ; invCrystalBottle
				(= local0 part7)
				(= local2 selectPart7)
			)
			(else
				(self dispose:)
				(return)
			)
		)
		(= local1 -1)
		(local0 init: self 1 1)
		(selectPart1 setParts:)
		(selectPart2 setParts:)
		(selectPart3 setParts:)
		(selectPart4 setParts:)
		(selectPart5 setParts:)
		(selectPart6 setParts:)
		(selectPart7 setParts:)
		(= temp0 0)
		(if (selectPart1 partExists:)
			(++ temp0)
		)
		(if (selectPart2 partExists:)
			(++ temp0)
		)
		(if (selectPart3 partExists:)
			(++ temp0)
		)
		(if (selectPart4 partExists:)
			(++ temp0)
		)
		(if (selectPart5 partExists:)
			(++ temp0)
		)
		(if (selectPart6 partExists:)
			(++ temp0)
		)
		(if (selectPart7 partExists:)
			(++ temp0)
		)
		(= local9 (- 320 (/ (* temp0 90) 2)))
		(selectPart4 init: self 1 1)
		(selectPart2 init: self 1 1)
		(selectPart6 init: self 1 1)
		(selectPart3 init: self 1 1)
		(selectPart1 init: self 1 1)
		(selectPart7 init: self 1 1)
		(selectPart5 init: self 1 1)
		(exitButton init: self 1 1)
		(Load rsVIEW 1012)
		(Load rsVIEW 1037)
		(Lock rsAUDIO 875 1)
		(Lock rsAUDIO 876 1)
		(Lock rsAUDIO 878 1)
		(scriptObj init:)
		(gSounds eachElementDo: #pause 1)
		(myMusic number: 8200 setLoop: 1)
		(myMusic play: scriptObj)
	)

	(method (handleEvent event)
		(super handleEvent: event &rest)
		(event claimed: 1)
	)

	(method (dispose)
		(gInventory deleteItem: (ScriptID 9 59)) ; invStock
		(super dispose: &rest)
	)
)

(instance myMusic of Sound
	(properties)
)

(instance mySound of Sound
	(properties
		flags 4
	)
)

(instance exitButton of PanelView
	(properties
		x 320
		y 5
		view 1000
	)

	(method (init)
		(= x (- 320 (/ (CelWide view loop cel) 2)))
		(super init: &rest)
	)

	(method (doVerb)
		(if (and (== (subPart1 myState:) 5) (not local14))
			(gInventory deleteItem: (ScriptID 9 31)) ; invIonizer
			(gInventory deleteItem: (ScriptID 9 62)) ; invBarrel
			(gInventory deleteItem: (ScriptID 9 61)) ; invFiringMechanism
			(gInventory deleteItem: (ScriptID 9 58)) ; invVacuumPump
			(gInventory deleteItem: (ScriptID 9 60)) ; invPowerSupply
			(gInventory deleteItem: (ScriptID 9 59)) ; invStock
			(gInventory deleteItem: (ScriptID 9 57)) ; invCrystalBottle
			(gInventory addItem: (ScriptID 9 64)) ; invCannon
			(SetFlag 408)
			(gCurRoom cue:)
		else
			(self hide:)
			(Dialog mouseHiliting: 1)
			(gSystemPlane picture: -2)
			(if
				(myPrint
					addBitmap: 1000 1 0
					addButtonBM: 1000 2 0 0 {} 57 145
					addButtonBM: 1000 3 0 1 {} 185 145
					init:
				)
				(self show:)
				(gSystemPlane picture: -1)
				(Dialog mouseHiliting: 1)
				(return)
			)
			(gSystemPlane picture: -1)
			(Dialog mouseHiliting: 1)
		)
		(myMusic dispose:)
		(mySound client: 0 dispose:)
		(gSounds eachElementDo: #pause 0)
		(Lock rsAUDIO 875 0)
		(Lock rsAUDIO 876 0)
		(Lock rsAUDIO 878 0)
		(cannonPanel dispose:)
	)
)

(instance myPrint of Print
	(properties)
)

(instance myPlane of Plane ; UNUSED
	(properties)

	(method (new &tmp temp0)
		(= temp0 (super new:))
		(temp0 picture: -2)
		(return temp0)
	)
)

(instance selectList of Set
	(properties)
)

(class CannonPart of PanelProp
	(properties
		widestCel -1
		maxWidth -1
		myState 0
		onMeWidth 0
	)

	(method (changeToView param1 param2 param3)
		(self view: param1)
		(param2 view: (+ param1 1100))
		(= widestCel -1)
		(self setPosn:)
		(if (or (< argc 3) param3)
			(UpdateScreenItem self)
			(UpdateScreenItem param2)
			(FrameOut)
		)
	)

	(method (loadNextViews))

	(method (init)
		(|= signal $1000)
		(= widestCel -1)
		(if (== local0 self)
			(self setPosn: 3)
		else
			(self setPosn: 4)
		)
		(super init: &rest)
	)

	(method (setState param1)
		(= myState param1)
	)

	(method (checkForAction param1 &tmp temp0 temp1 temp2 temp3)
		(for ((= temp0 200)) (< temp0 250) ((++ temp0))
			(if (!= (= temp1 (CelLink 2 view loop cel temp0)) -1) ; GetXLinkPoint
				(= temp3 (CelInfo 0 view loop cel)) ; GetOrigX
				(= temp3 (- x temp3))
				(+= temp1 temp3)
				(= temp2 (CelLink 3 view loop cel temp0)) ; GetYLinkPoint
				(= temp3 (CelInfo 1 view loop cel)) ; GetOrigY
				(= temp3 (- y temp3))
				(+= temp2 temp3)
				(if
					(and
						(< (Abs (- temp1 (param1 x:))) 15)
						(< (Abs (- temp2 (param1 y:))) 15)
						(self doAction: temp0)
					)
					(if (and (== (subPart1 myState:) 5) (not local14))
						(mySound number: 878)
					else
						(mySound number: 876)
					)
					(gGame setCursor: gWaitCursor 1)
					(mySound setLoop: 1 play: self)
					(return 1)
				)
			)
		)
		(return 0)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(if (== self local0)
			(if (== local1 -1)
				(return (and (> temp1 30) (< temp1 300)))
			else
				(return (and (> temp1 30) (< temp1 300) (< temp0 local18)))
			)
		else
			(return (and (> temp1 30) (< temp1 300) (> temp0 local20)))
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (or (event claimed:) (& (event type:) evMOUSERELEASE))
			(return 0)
		)
		(if (== local0 self)
			(if (== local1 -1)
				(= local17 (+ x (/ maxWidth 2)))
				(= local18 640)
				(= local19 (- x (/ maxWidth 2)))
				(= local20 0)
			else
				(cond
					((== (local1 myState:) 4)
						(= local17 (+ x (/ maxWidth 2)))
						(= local18 (+ x (/ maxWidth 2) 30))
					)
					((== myState 4)
						(= local17 310)
						(= local18 (+ x (/ maxWidth 2)))
					)
					(else
						(= local17 (Min 260 (+ x (/ maxWidth 2))))
						(= local18 310)
					)
				)
				(= local19 (Max 60 (- x (/ maxWidth 2))))
				(= local20 0)
			)
		else
			(cond
				((== (local0 myState:) 4)
					(= local19 (- x (/ maxWidth 2)))
					(= local20 430)
				)
				((== myState 4)
					(= local19 (- x (/ maxWidth 2)))
					(= local20 (- (- x (/ maxWidth 2)) 30))
				)
				(else
					(= local19 (Max 370 (- x (/ maxWidth 2))))
					(= local20 330)
				)
			)
			(= local17 (Min 570 (+ x (/ maxWidth 2))))
			(= local18 640)
		)
		(cond
			((self onMe: event)
				(if (& (event type:) evMOUSEBUTTON)
					(cond
						((== gTheCursor rightCursor)
							(= temp1 0)
							(while
								(and
									(not (& (event type:) evMOUSERELEASE))
									(self onMe: event)
									(> (event x:) x)
								)
								(event localize: cannonPanel)
								(= gGameTime (+ gTickOffset (GetTime)))
								(if (> (Abs (- gGameTime temp1)) 6)
									(= temp1 gGameTime)
									(self rotate: 4)
									(UpdateScreenItem self)
									(FrameOut)
								)
								(GetEvent 32767 event)
							)
						)
						((== gTheCursor leftCursor)
							(= temp1 0)
							(while
								(and
									(not (& (event type:) evMOUSERELEASE))
									(self onMe: event)
									(< (event x:) x)
								)
								(event localize: cannonPanel)
								(= gGameTime (+ gTickOffset (GetTime)))
								(if (> (Abs (- gGameTime temp1)) 6)
									(= temp1 gGameTime)
									(self rotate: 3)
									(UpdateScreenItem self)
									(FrameOut)
								)
								(GetEvent 32767 event)
							)
						)
						((!= local1 -1)
							(if
								(and
									(not (self checkForAction: event))
									(IsOnMe (event x:) (event y:) self 0)
								)
								(self drag: event)
								(self drop:)
							)
						)
						(else
							(self checkForAction: event)
						)
					)
					(event claimed: 1)
					(return 1)
				else
					(if (not local10)
						(= local10 self)
					)
					(if (== local10 self)
						(cond
							(
								(and
									(!= gTheCursor leftCursor)
									(< (event x:) local19)
								)
								(gGame setCursor: leftCursor 1)
							)
							(
								(and
									(!= gTheCursor rightCursor)
									(> (event x:) local17)
								)
								(gGame setCursor: rightCursor 1)
							)
							(
								(and
									(!= gTheCursor gNormalCursor)
									(< (event x:) local17)
									(> (event x:) local19)
								)
								(gGame setCursor: gNormalCursor 1)
							)
						)
					)
				)
			)
			((== local10 self)
				(= local10 0)
				(if (!= gTheCursor gNormalCursor)
					(gGame setCursor: gNormalCursor 1)
				)
			)
		)
		(return 0)
	)

	(method (rotate param1)
		(cond
			((== param1 3)
				(if (== cel (self lastCel:))
					(= cel 0)
				else
					(++ cel)
				)
			)
			((not cel)
				(= cel (self lastCel:))
			)
			(else
				(-- cel)
			)
		)
		(UpdateScreenItem self)
	)

	(method (drag param1 &tmp temp0 temp1 temp2 temp3)
		(= temp0 x)
		(= temp1 y)
		(gTheCursor hide:)
		(self setPri: 500)
		(= temp2 (- (param1 x:) x))
		(= temp3 (- (param1 y:) y))
		(while (not (& (param1 type:) $0002))
			(param1 localize: cannonPanel)
			(if (or (!= temp0 (param1 x:)) (!= temp1 (param1 y:)))
				(= temp0 x)
				(= temp1 y)
				(self x: (- (param1 x:) temp2) y: (- (param1 y:) temp3))
				(UpdateScreenItem self)
				(FrameOut)
			)
			(GetEvent 32767 param1)
		)
		(self setPri: -1)
		(gTheCursor show:)
	)

	(method (drop)
		(cond
			((== local0 self)
				(if (not (local1 connect: self))
					(self setPosn:)
				)
			)
			((not (local0 connect: self))
				(self setPosn:)
			)
		)
	)

	(method (connect)
		(return 0)
	)

	(method (atConnectPoint param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 (CelLink 2 view loop cel param2)) ; GetXLinkPoint
		(= temp1 (CelLink 3 view loop cel param2)) ; GetYLinkPoint
		(= temp2 (CelLink 2 (param1 view:) (param1 loop:) (param1 cel:) param2)) ; GetXLinkPoint
		(= temp3 (CelLink 3 (param1 view:) (param1 loop:) (param1 cel:) param2)) ; GetYLinkPoint
		(if (or (== temp0 -1) (== temp1 -1) (== temp2 -1) (== temp3 -1))
			(return 0)
		)
		(= temp4 (CelInfo 0 view loop cel)) ; GetOrigX
		(= temp5 (- x temp4))
		(+= temp0 temp5)
		(= temp4 (CelInfo 0 (param1 view:) (param1 loop:) (param1 cel:))) ; GetOrigX
		(= temp5 (- (param1 x:) temp4))
		(+= temp2 temp5)
		(if (> (Abs (- temp0 temp2)) 15)
			(return 0)
		)
		(= temp4 (CelInfo 1 view loop cel)) ; GetOrigY
		(= temp5 (- y temp4))
		(+= temp1 temp5)
		(= temp4 (CelInfo 1 (param1 view:) (param1 loop:) (param1 cel:))) ; GetOrigY
		(= temp5 (- (param1 y:) temp4))
		(+= temp3 temp5)
		(if (> (Abs (- temp1 temp3)) 15)
			(return 0)
		)
		(return 1)
	)

	(method (findWidestCel &tmp temp0 temp1)
		(= maxWidth -1)
		(for ((= temp0 0)) (< temp0 (self lastCel:)) ((++ temp0))
			(if (> (CelWide view loop temp0) maxWidth)
				(= widestCel temp0)
				(= maxWidth (CelWide view loop widestCel))
				(= temp1 (CelInfo 0 view loop temp0)) ; GetOrigX
				(= onMeWidth
					(Min
						145
						(Max
							temp1
							(- (CelWide view loop temp0) temp1)
							70
						)
					)
				)
			)
		)
	)

	(method (setPosn)
		(if (< widestCel 0)
			(self findWidestCel:)
		)
		(= y 200)
		(if (== local1 -1)
			(= x 320)
			(return)
		)
		(cond
			((== local0 self)
				(if (> (- 160 (CelInfo 0 view loop widestCel)) 3) ; GetOrigX
					(= x 160)
				else
					(= x (+ 3 (CelInfo 0 view loop widestCel))) ; GetOrigX
				)
			)
			(
				(<
					(+
						480
						(-
							(CelWide view loop widestCel)
							(CelInfo 0 view loop widestCel) ; GetOrigX
						)
					)
					637
				)
				(= x 480)
			)
			(else
				(= x
					(-
						637
						(-
							(CelWide view loop widestCel)
							(CelInfo 0 view loop widestCel) ; GetOrigX
						)
					)
				)
			)
		)
	)

	(method (cue)
		(self loadNextViews:)
		(= local10 0)
		(gGame setCursor: gNormalCursor 1)
	)

	(method (doConnect param1 param2 param3 param4 &tmp temp0 temp1)
		(if (== cel (param1 cel:))
			(if (self atConnectPoint: param1 param4)
				(= local10 0)
				(local1 dispose: cannonPanel 1 1)
				(local0 dispose: cannonPanel 1 1)
				(local2 dispose: cannonPanel 1 1)
				(local3 dispose: cannonPanel 1 1)
				(= local1 -1)
				(= local3 0)
				(+= local9 45)
				(= temp1 0)
				(for ((= temp0 0)) (< temp0 (selectList size:)) ((++ temp0))
					(= temp1 (selectList at: temp0))
					(temp1 x: (+ local9 (* 90 temp0)))
					(UpdateScreenItem temp1)
				)
				(= local8 temp1)
				(= local2 param2)
				(local2 setState: param3)
				(= local0 (local2 myPart:))
				(gGame setCursor: gWaitCursor 1)
				(mySound number: 875 setLoop: 1)
				(mySound play: local0)
				(local2 init: cannonPanel 1 1)
				(local0 cel: cel init: cannonPanel 1 1)
				(FrameOut)
				(return 1)
			else
				(return 0)
			)
		else
			(return 0)
		)
	)

	(method (doVerb))
)

(class SelectPart of PanelView
	(properties
		y 380
		myPart 0
		myInvPart 0
		selected 0
		myState 0
	)

	(method (setState param1)
		(= myState param1)
		(self setParts:)
	)

	(method (select param1)
		(if param1
			(= selected 1)
			(self highlight: 1)
		else
			(= selected 0)
			(self highlight: 0)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(= temp0 0)
		(if selected
			(return temp0)
		)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evMOUSEBUTTON) (self onMe: event))
				(if (and (!= local0 myPart) (!= local1 myPart))
					(if (== local1 -1)
						(= local1 myPart)
						(local0 setPosn:)
						(= selected 1)
						(= local3 self)
						(self highlight: 1)
						(myPart init: cannonPanel 1 1)
					else
						(selectCursor view: view loop: 1 cel: 0)
						(gGame setCursor: selectCursor 1)
						(while (not (& (event type:) evMOUSERELEASE))
							(event localize: cannonPanel)
							(GetEvent 32767 event)
						)
						(if (< (event y:) 300)
							(if (< (event x:) 320)
								(local2 select: 0)
								(= local2 self)
								(local0 dispose: cannonPanel 1 1)
								(= local0 myPart)
							else
								(local3 select: 0)
								(= local3 self)
								(local1 dispose: cannonPanel 1 1)
								(= local1 myPart)
							)
							(self select: 1)
							(myPart init: cannonPanel 1 1)
						)
						(gGame setCursor: gNormalCursor 1)
					)
				)
				(= temp0 (event claimed: 1))
			)
			((not (& (event type:) $0fff)) ; extMouse | speechEvent | joyEvent | direction | evKEYUP | evMOUSEKEYBOARD | evMOUSERELEASE | evNULL | $0c80
				(if (self onMe: event)
					(self highlight: 1)
				else
					(self highlight: 0)
				)
			)
		)
		(return temp0)
	)

	(method (partExists)
		(if (and myInvPart (not (gInventory contains: myInvPart)))
			(return 0)
		else
			(return 1)
		)
	)

	(method (dispose)
		(selectList delete: self)
		(super dispose: &rest)
	)

	(method (init)
		(&= signal $efff)
		(if (or (== local1 myPart) (== local0 myPart))
			(self select: 1)
		else
			(self select: 0)
		)
		(if (not (self partExists:))
			(return)
		)
		(Load rsVIEW (myPart view:))
		(selectList add: self)
		(if (== local8 0)
			(= x local9)
		else
			(= x (+ (local8 x:) 90))
		)
		(super init: &rest)
		(= local8 self)
	)

	(method (highlight param1)
		(cond
			(param1
				(if loop
					(= loop 0)
					(if plane
						(UpdateScreenItem self)
						(FrameOut)
					)
				)
			)
			((not loop)
				(= loop 2)
				(if plane
					(UpdateScreenItem self)
					(FrameOut)
				)
			)
		)
	)
)

(instance part1 of CannonPart
	(properties
		view 1001
	)

	(method (init)
		(= cel (Random 0 15))
		(super init: &rest)
	)

	(method (connect param1 &tmp [temp0 2])
		(switch param1
			(part2
				(return (self doConnect: param1 selectSubPart1 0 1))
			)
			(subPart1
				(return
					(self
						doConnect:
							param1
							selectSubPart1
							(- (param1 myState:) 5)
							1
					)
				)
			)
		)
		(return 0)
	)
)

(instance selectPart1 of SelectPart
	(properties
		view 2101
	)

	(method (setParts)
		(= myPart part1)
		(= myInvPart (ScriptID 9 31)) ; invIonizer
	)
)

(instance part2 of CannonPart
	(properties
		view 1002
	)

	(method (init)
		(= cel (Random 0 15))
		(super init: &rest)
	)

	(method (connect param1 &tmp [temp0 2])
		(switch param1
			(part1
				(return (self doConnect: param1 selectSubPart1 0 1))
			)
			(part3
				(return (self doConnect: param1 selectSubPart1 6 2))
			)
		)
		(return 0)
	)
)

(instance selectPart2 of SelectPart
	(properties
		view 2102
	)

	(method (setParts)
		(= myPart part2)
		(= myInvPart (ScriptID 9 62)) ; invBarrel
	)
)

(instance part3 of CannonPart
	(properties
		view 1003
	)

	(method (init)
		(= cel (Random 0 15))
		(super init: &rest)
	)

	(method (connect param1 &tmp [temp0 2])
		(cond
			((and (== param1 subPart1) (== (param1 myState:) 0))
				(return (self doConnect: param1 selectSubPart1 1 2))
			)
			((== param1 part2)
				(return (self doConnect: param1 selectSubPart1 6 2))
			)
			(else
				(return 0)
			)
		)
	)
)

(instance selectPart3 of SelectPart
	(properties
		view 2103
	)

	(method (setParts)
		(= myPart part3)
		(= myInvPart (ScriptID 9 61)) ; invFiringMechanism
	)
)

(instance part4 of CannonPart
	(properties
		view 1007
	)

	(method (init)
		(= cel (Random 0 15))
		(super init: &rest)
	)

	(method (connect param1 &tmp [temp0 2])
		(if (== param1 subPart1)
			(cond
				((== (param1 myState:) 1)
					(return (self doConnect: param1 selectSubPart1 2 2))
				)
				((== (param1 myState:) 6)
					(return (self doConnect: param1 selectSubPart1 7 2))
				)
				(else
					(return 0)
				)
			)
		else
			(return 0)
		)
	)

	(method (doAction param1)
		(if (or (== param1 200) (== param1 201))
			(if (== view 1008)
				(self changeToView: 1007 selectPart4)
			else
				(self changeToView: 1008 selectPart4)
			)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance selectPart4 of SelectPart
	(properties
		view 2107
	)

	(method (setParts)
		(= myPart part4)
		(= myInvPart (ScriptID 9 58)) ; invVacuumPump
	)
)

(instance part5 of CannonPart
	(properties
		view 1009
	)

	(method (init)
		(= cel (Random 0 15))
		(super init: &rest)
	)

	(method (connect param1 &tmp [temp0 2])
		(if (== param1 subPart1)
			(cond
				((== (param1 myState:) 2)
					(return (self doConnect: param1 selectSubPart1 3 2))
				)
				((== (param1 myState:) 7)
					(return (self doConnect: param1 selectSubPart1 8 2))
				)
				(else
					(return 0)
				)
			)
		else
			(return 0)
		)
	)

	(method (doAction param1)
		(if (or (== param1 200) (== param1 201))
			(if (== view 1010)
				(self changeToView: 1009 selectPart5)
			else
				(self changeToView: 1010 selectPart5)
			)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance selectPart5 of SelectPart
	(properties
		view 2109
	)

	(method (setParts)
		(= myPart part5)
		(= myInvPart (ScriptID 9 60)) ; invPowerSupply
	)
)

(instance part6 of CannonPart
	(properties
		view 1011
	)

	(method (init)
		(= cel (Random 0 15))
		(super init: &rest)
	)

	(method (connect param1 &tmp [temp0 2])
		(if (== param1 subPart1)
			(cond
				((== (param1 myState:) 3)
					(return (self doConnect: param1 selectSubPart1 4 2))
				)
				((== (param1 myState:) 8)
					(return (self doConnect: param1 selectSubPart1 9 2))
				)
				(else
					(return 0)
				)
			)
		else
			(return 0)
		)
	)
)

(instance selectPart6 of SelectPart
	(properties
		view 2111
	)

	(method (setParts)
		(= myPart part6)
		(= myInvPart (ScriptID 9 59)) ; invStock
	)
)

(instance part7 of CannonPart
	(properties
		view 1051
	)

	(method (init)
		(= cel (Random 0 15))
		(super init: &rest)
	)

	(method (connect param1 &tmp [temp0 2])
		(if (and (== param1 subPart1) (== (param1 myState:) 4) local16)
			(return (self doConnect: param1 selectSubPart1 5 1))
		else
			(return 0)
		)
	)
)

(instance selectPart7 of SelectPart
	(properties
		view 2151
	)

	(method (setParts)
		(= myPart part7)
		(= myInvPart (ScriptID 9 57)) ; invCrystalBottle
	)
)

(instance subPart1 of CannonPart
	(properties
		view 1012
	)

	(method (connect param1 &tmp [temp0 2])
		(switch myState
			(0
				(switch param1
					(part3
						(return (self doConnect: param1 selectSubPart1 1 2))
					)
					(else
						(return 0)
					)
				)
			)
			(1
				(switch param1
					(part4
						(return (self doConnect: param1 selectSubPart1 2 2))
					)
					(else
						(return 0)
					)
				)
			)
			(2
				(switch param1
					(part5
						(return (self doConnect: param1 selectSubPart1 3 2))
					)
					(else
						(return 0)
					)
				)
			)
			(3
				(switch param1
					(part6
						(return (self doConnect: param1 selectSubPart1 4 2))
					)
					(else
						(return 0)
					)
				)
			)
			(4
				(switch param1
					(part7
						(return (self doConnect: param1 selectSubPart1 5 1))
					)
					(else
						(return 0)
					)
				)
			)
			(6
				(switch param1
					(part1
						(return (self doConnect: param1 selectSubPart1 1 1))
					)
					(part4
						(return (self doConnect: param1 selectSubPart1 7 2))
					)
					(else
						(return 0)
					)
				)
			)
			(7
				(switch param1
					(part1
						(return (self doConnect: param1 selectSubPart1 2 1))
					)
					(part5
						(return (self doConnect: param1 selectSubPart1 8 2))
					)
					(else
						(return 0)
					)
				)
			)
			(8
				(switch param1
					(part1
						(return (self doConnect: param1 selectSubPart1 3 1))
					)
					(part6
						(return (self doConnect: param1 selectSubPart1 9 2))
					)
					(else
						(return 0)
					)
				)
			)
			(9
				(switch param1
					(part1
						(return (self doConnect: param1 selectSubPart1 4 1))
					)
					(else
						(return 0)
					)
				)
			)
		)
	)

	(method (doAction param1)
		(switch myState
			(2
				(self changeToView: 1015 selectSubPart1)
				(= local12 1)
				(return 1)
			)
			(3
				(cond
					((or (== param1 200) (== param1 201))
						(if local12
							(self changeToView: 1021 selectSubPart1)
						else
							(self changeToView: 1020 selectSubPart1)
						)
						(= local13 1)
						(return 1)
					)
					((or (== param1 210) (== param1 211))
						(if local13
							(self changeToView: 1021 selectSubPart1)
						else
							(self changeToView: 1017 selectSubPart1)
						)
						(= local12 1)
						(return 1)
					)
				)
			)
			(4
				(cond
					((or (== param1 200) (== param1 201))
						(if local12
							(if local13
								(if local14
									(if local15
										(self changeToView: 1028 selectSubPart1)
										(= local16 1)
									else
										(self changeToView: 1027 selectSubPart1)
										(= local15 1)
									)
								else
									(self changeToView: 1026 selectSubPart1)
									(= local14 1)
								)
							else
								(self changeToView: 1025 selectSubPart1)
								(= local13 1)
							)
						else
							(self changeToView: 1024 selectSubPart1)
							(= local13 1)
						)
						(return 1)
					)
					((or (== param1 210) (== param1 211))
						(if local14
							(return 0)
						)
						(if local13
							(self changeToView: 1025 selectSubPart1)
						else
							(self changeToView: 1023 selectSubPart1)
						)
						(= local12 1)
						(return 1)
					)
				)
			)
			(5
				(cond
					((or (== param1 200) (== param1 201))
						(if local16
							(self changeToView: 1027 selectSubPart1)
							(= local16 0)
						)
						(return 1)
					)
					((or (== param1 210) (== param1 211))
						(if local14
							(if local15
								(self changeToView: 1026 selectSubPart1)
								(= local15 0)
							else
								(self changeToView: 1048 selectSubPart1)
								(= local14 0)
							)
						)
						(return 1)
					)
				)
			)
			(7
				(self changeToView: 1039 selectSubPart1)
				(= local12 1)
				(return 1)
			)
			(8
				(cond
					((or (== param1 200) (== param1 201))
						(if local12
							(self changeToView: 1043 selectSubPart1)
						else
							(self changeToView: 1042 selectSubPart1)
						)
						(= local13 1)
						(return 1)
					)
					((or (== param1 210) (== param1 211))
						(if local13
							(self changeToView: 1043 selectSubPart1)
						else
							(self changeToView: 1041 selectSubPart1)
						)
						(= local12 1)
						(return 1)
					)
				)
			)
			(9
				(cond
					((or (== param1 200) (== param1 201))
						(if local12
							(self changeToView: 1047 selectSubPart1)
						else
							(self changeToView: 1046 selectSubPart1)
						)
						(= local13 1)
						(return 1)
					)
					((or (== param1 210) (== param1 211))
						(if local13
							(self changeToView: 1047 selectSubPart1)
						else
							(self changeToView: 1045 selectSubPart1)
						)
						(= local12 1)
						(return 1)
					)
				)
			)
		)
	)

	(method (loadNextViews)
		(switch myState
			(0
				(Load rsVIEW 1013)
				(Load rsVIEW 2113)
			)
			(1
				(Load rsVIEW 1014)
				(Load rsVIEW 2114)
				(Load rsVIEW 1015)
				(Load rsVIEW 2115)
			)
			(2
				(if local12
					(Load rsVIEW 1017)
					(Load rsVIEW 2117)
				else
					(Load rsVIEW 1015)
					(Load rsVIEW 2115)
					(Load rsVIEW 1016)
					(Load rsVIEW 2116)
				)
			)
			(3
				(cond
					(local12
						(if local13
							(Load rsVIEW 1025)
							(Load rsVIEW 2125)
						else
							(Load rsVIEW 1021)
							(Load rsVIEW 2121)
							(Load rsVIEW 1023)
							(Load rsVIEW 2123)
						)
					)
					(local13
						(Load rsVIEW 1021)
						(Load rsVIEW 2121)
						(Load rsVIEW 1024)
						(Load rsVIEW 2124)
					)
					(else
						(Load rsVIEW 1017)
						(Load rsVIEW 2117)
						(Load rsVIEW 1020)
						(Load rsVIEW 2120)
						(Load rsVIEW 1022)
						(Load rsVIEW 2122)
					)
				)
			)
			(4
				(cond
					(local12
						(if local13
							(if local14
								(if local15
									(if local16
										(Load rsVIEW 1049)
										(Load rsVIEW 2149)
									else
										(Load rsVIEW 1028)
										(Load rsVIEW 2128)
									)
								else
									(Load rsVIEW 1027)
									(Load rsVIEW 2127)
								)
							else
								(Load rsVIEW 1026)
								(Load rsVIEW 2126)
							)
						else
							(Load rsVIEW 1025)
							(Load rsVIEW 2125)
						)
					)
					(local13
						(Load rsVIEW 1025)
						(Load rsVIEW 2125)
					)
					(else
						(Load rsVIEW 1023)
						(Load rsVIEW 2123)
						(Load rsVIEW 1024)
						(Load rsVIEW 2124)
					)
				)
			)
			(5
				(if local15
					(if local16
						(Load rsVIEW 1027)
						(Load rsVIEW 2127)
					else
						(Load rsVIEW 1026)
						(Load rsVIEW 2126)
					)
				else
					(Load rsVIEW 1048)
					(Load rsVIEW 2148)
				)
			)
			(6
				(Load rsVIEW 1038)
				(Load rsVIEW 2138)
				(Load rsVIEW 1013)
				(Load rsVIEW 2113)
			)
			(7
				(if local12
					(Load rsVIEW 1041)
					(Load rsVIEW 2141)
					(Load rsVIEW 1015)
					(Load rsVIEW 2115)
				else
					(Load rsVIEW 1040)
					(Load rsVIEW 2140)
					(Load rsVIEW 1016)
					(Load rsVIEW 2116)
				)
			)
			(8
				(cond
					(local12
						(if local13
							(Load rsVIEW 1047)
							(Load rsVIEW 2147)
							(Load rsVIEW 1021)
							(Load rsVIEW 2121)
						else
							(Load rsVIEW 1043)
							(Load rsVIEW 2143)
							(Load rsVIEW 1045)
							(Load rsVIEW 2145)
							(Load rsVIEW 1017)
							(Load rsVIEW 2117)
						)
					)
					(local13
						(Load rsVIEW 1043)
						(Load rsVIEW 2143)
						(Load rsVIEW 1046)
						(Load rsVIEW 2146)
						(Load rsVIEW 1020)
						(Load rsVIEW 2120)
					)
					(else
						(Load rsVIEW 1044)
						(Load rsVIEW 2144)
						(Load rsVIEW 1041)
						(Load rsVIEW 2141)
						(Load rsVIEW 1042)
						(Load rsVIEW 2142)
						(Load rsVIEW 1016)
						(Load rsVIEW 2116)
					)
				)
			)
			(9
				(cond
					(local12
						(if local13
							(Load rsVIEW 1025)
							(Load rsVIEW 2125)
						else
							(Load rsVIEW 1047)
							(Load rsVIEW 2147)
							(Load rsVIEW 1023)
							(Load rsVIEW 2123)
						)
					)
					(local13
						(Load rsVIEW 1047)
						(Load rsVIEW 2147)
						(Load rsVIEW 1024)
						(Load rsVIEW 2124)
					)
					(else
						(Load rsVIEW 1045)
						(Load rsVIEW 2145)
						(Load rsVIEW 1046)
						(Load rsVIEW 2146)
						(Load rsVIEW 1022)
						(Load rsVIEW 2122)
					)
				)
			)
		)
	)
)

(instance selectSubPart1 of SelectPart
	(properties
		view 2112
	)

	(method (setParts)
		(= myPart subPart1)
		(myPart setState: myState)
		(= myInvPart 0)
		(switch myState
			(0
				(myPart changeToView: 1012 self 0)
			)
			(1
				(myPart changeToView: 1013 self 0)
			)
			(2
				(if local12
					(myPart changeToView: 1015 self 0)
				else
					(myPart changeToView: 1014 self 0)
				)
			)
			(3
				(cond
					(local12
						(if local13
							(myPart changeToView: 1021 self 0)
						else
							(myPart changeToView: 1017 self 0)
						)
					)
					(local13
						(myPart changeToView: 1020 self 0)
					)
					(else
						(myPart changeToView: 1016 self 0)
					)
				)
			)
			(4
				(cond
					(local12
						(if local13
							(if local14
								(if local15
									(if local16
										(myPart changeToView: 1028 self 0)
									else
										(myPart changeToView: 1027 self 0)
									)
								else
									(myPart changeToView: 1026 self 0)
								)
							else
								(myPart changeToView: 1025 self 0)
							)
						else
							(myPart changeToView: 1023 self 0)
						)
					)
					(local13
						(myPart changeToView: 1024 self 0)
					)
					(else
						(myPart changeToView: 1022 self 0)
					)
				)
			)
			(5
				(if local14
					(if local15
						(if local16
							(myPart changeToView: 1049 self 0)
						else
							(myPart changeToView: 1027 self 0)
						)
					else
						(myPart changeToView: 1026 self 0)
					)
				else
					(myPart changeToView: 1048 self 0)
				)
			)
			(6
				(myPart changeToView: 1037 self 0)
			)
			(7
				(myPart changeToView: 1038 self 0)
			)
			(8
				(if local12
					(myPart changeToView: 1041 self 0)
				else
					(myPart changeToView: 1040 self 0)
				)
			)
			(9
				(cond
					(local12
						(if local13
							(myPart changeToView: 1047 self 0)
						else
							(myPart changeToView: 1045 self 0)
						)
					)
					(local13
						(myPart changeToView: 1046 self 0)
					)
					(else
						(myPart changeToView: 1044 self 0)
					)
				)
			)
		)
	)
)

(instance rightCursor of Cursor
	(properties
		view 1101
		cel 1
	)
)

(instance leftCursor of Cursor
	(properties
		view 1101
	)
)

(instance selectCursor of Cursor
	(properties
		view 1101
	)
)

(instance scriptObj of Prop
	(properties
		x -500
		view 0
	)

	(method (cue)
		(myMusic play: self)
	)
)

