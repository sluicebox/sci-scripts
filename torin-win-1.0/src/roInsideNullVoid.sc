;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 51100)
(include sci.sh)
(use Main)
(use ScrollExit)
(use oHandsOnWhenCued)
(use TPSound)
(use ModalPlane)
(use PushButton)
(use Plane)
(use Polygon)
(use Feature)
(use Ego)
(use Motion)
(use Actor)
(use System)

(public
	roInsideNullVoid 0
)

(local
	nSlowTime
	vx
	vy
	vz
	tx
	ty
	tz
	IsUsingBagpipes
	leavingRoom
)

(procedure (TheDist x y &tmp cx cy newDist)
	(= cx (- x 474))
	(= cy (- y 474))
	(= newDist (+ (MulDiv cx cx 30) (MulDiv cy cy 30)))
)

(instance foLycentiaExit of Feature
	(properties
		x 692
		y 712
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 719 696 695 734 667 729 662 716 678 713 692 692
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (onMe &tmp reallyOnMe)
		(return
			(= reallyOnMe
				(and
					(super onMe: (poTorin x:) (poTorin y:))
					(< (Abs (- (poTorin priority:) 10)) 30)
				)
			)
		)
	)
)

(instance voCrystcorder of View
	(properties
		fixPriority 1
		view 60340
	)

	(method (init)
		(if (not ((ScriptID 64017 0) test: 215)) ; oFlags
			(= goCrystX (- (poTorin x:) 15))
			(= goCrystY (- (poTorin y:) 15))
			(= goCrystZ 128)
			((ScriptID 64017 0) set: 215) ; oFlags
			((ScriptID 64017 0) set: 220) ; oFlags
		)
		(self
			posn: goCrystX goCrystY
			setPri: goCrystZ
			setScaleDirect: goCrystZ
		)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Do
			(gEgo get: ((ScriptID 64001 0) get: 52)) ; oInvHandler, ioCrystcorder
			((ScriptID 64017 0) clear: 215) ; oFlags
			(self dispose:)
		)
	)
)

(instance foVoid of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 64)
	)

	(method (doVerb &tmp [temp0 3])
		(voCrystcorder init:)
		(gEgo put: ((ScriptID 64001 0) get: 52)) ; oInvHandler, ioCrystcorder
		((ScriptID 64017 0) set: 220) ; oFlags
		(if ((ScriptID 64017 0) test: 222) ; oFlags
			(gMessager say: 0 64 2 0) ; "Let's see just how smart that monster of hers is!"
		)
	)
)

(instance oNorth of PushButton
	(properties
		x 35
		y 26
		priority 10
		fixPriority 1
		view 51100
		loop 1
		signal 20481
		nSelectValue 1
	)
)

(instance oSouth of PushButton
	(properties
		x 35
		y 69
		priority 10
		fixPriority 1
		view 51100
		loop 2
		signal 20481
		nSelectValue 2
	)
)

(instance oEast of PushButton
	(properties
		x 58
		y 45
		priority 10
		fixPriority 1
		view 51100
		loop 3
		signal 20481
		nSelectValue 3
	)
)

(instance oWest of PushButton
	(properties
		x 15
		y 45
		priority 10
		fixPriority 1
		view 51100
		loop 4
		signal 20481
		nSelectValue 4
	)
)

(instance oOut of PushButton
	(properties
		x 26
		y 40
		priority 20
		fixPriority 1
		view 51100
		loop 5
		signal 20481
		nSelectValue 5
	)
)

(instance oIn of PushButton
	(properties
		x 46
		y 47
		priority 1
		fixPriority 1
		view 51100
		loop 6
		signal 20481
		nSelectValue 6
	)
)

(instance oSpeed of View
	(properties
		x 9
		y 114
		priority 1
		fixPriority 1
		view 51100
		loop 7
		signal 20481
	)
)

(instance oBackground of View
	(properties
		fixPriority 1
		view 51100
		signal 16385
	)
)

(instance foMove of MoveFeature
	(properties)
)

(class oController of Plane
	(properties
		holdStart 0
		holdTime 0
	)

	(method (init)
		(= priority 21)
		(super init: 20 20 100 100)
		(oBackground init: self)
		(oNorth
			oSelectNotify: self
			oClickNotify: self
			oHeldNotify: self
			init: self
		)
		(oSouth
			oSelectNotify: self
			oClickNotify: self
			oHeldNotify: self
			init: self
		)
		(oEast
			oSelectNotify: self
			oClickNotify: self
			oHeldNotify: self
			init: self
		)
		(oWest
			oSelectNotify: self
			oClickNotify: self
			oHeldNotify: self
			init: self
		)
		(oOut
			oSelectNotify: self
			oClickNotify: self
			oHeldNotify: self
			init: self
		)
		(oIn
			oSelectNotify: self
			oClickNotify: self
			oHeldNotify: self
			init: self
		)
		(oSpeed init: self)
		(self setSize:)
		(foMove init: self makeTopBorder: 18)
		(self setSize:)
		(UpdatePlane self)
	)

	(method (doSelect value &tmp controlSpeed)
		(= controlSpeed (* holdTime 3))
		(switch value
			(1
				(+= ty (* controlSpeed -3))
			)
			(2
				(+= ty (* controlSpeed 3))
			)
			(3
				(+= tx (* controlSpeed 3))
			)
			(4
				(+= tx (* controlSpeed -3))
			)
			(5
				(+= tz controlSpeed)
			)
			(6
				(-= tz controlSpeed)
			)
		)
		(gCurRoom setScript: soSqueezeBagpipes)
	)

	(method (doClick)
		(= holdTime 0)
		(= holdStart gGameTime)
	)

	(method (doHeld)
		(if (and (< holdTime (oSpeed lastCel:)) (> (- gGameTime holdStart) 10))
			(= holdStart gGameTime)
			(++ holdTime)
			(oSpeed setCel: holdTime)
		)
	)
)

(instance soExitToPorch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oController dispose:)
				((ScriptID 64017 0) set: 219) ; oFlags
				(= ticks 20)
			)
			(1
				(goSound1 playSound: 51107)
				(gCurRoom newRoom: 51200) ; roLycentiasPorch
				(self dispose:)
			)
		)
	)
)

(instance soJustGotHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(gMessager say: 0 1 1 0) ; "How can I just float in mid-air like this?"
				(self dispose:)
			)
		)
	)
)

(instance soPullOutBagpipes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(((ScriptID 64001 0) get: 46) moveTo: -3) ; oInvHandler, ioBagpipes
				(poTorin setCycle: End self)
			)
			(1
				(poTorin setCel: 0 setLoop: 1 setCycle: End self)
			)
			(2
				(poTorin setLoop: 3)
				((ScriptID 64017 0) set: 218) ; oFlags
				(self dispose:)
			)
		)
	)
)

(instance soSqueezeBagpipes of Script
	(properties)

	(method (changeState newState &tmp dirLoop dx dy)
		(switch (= state newState)
			(0
				(= dirLoop (poTorin loop:))
				(= dx (+ vx tx))
				(= dy (+ vy ty))
				(cond
					((> (Abs dx) (Abs dy))
						(if (> dx 0)
							(= dirLoop 3)
						else
							(= dirLoop 4)
						)
					)
					((< (Abs dx) (Abs dy))
						(if (> dy 0)
							(= dirLoop 5)
						else
							(= dirLoop 6)
						)
					)
				)
				(poTorin setCel: 0 setLoop: dirLoop setCycle: CT 5 1 self)
			)
			(1
				(goSound1 playSound: (+ (Random 0 5) 51101))
				(poTorin setCycle: CT 7 1 self)
			)
			(2
				(+= vx tx)
				(+= vy ty)
				(+= vz tz)
				(= tx (= ty (= tz 0)))
				(poTorin setCycle: End self)
				(oSpeed setCel: 0)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance poTorin of Prop
	(properties
		x 308
		y 175
		priority 128
		fixPriority 1
		view 51101
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 63)
	)

	(method (doVerb)
		(if (not IsUsingBagpipes)
			(oController init:)
			(= IsUsingBagpipes 1)
			(gCurRoom setScript: soPullOutBagpipes (ScriptID 64020 0)) ; oHandsOnWhenCued
		)
	)

	(method (doit)
		(super doit:)
		(if (or vx vy vz)
			(PerformAutoScroll self)
		)
	)
)

(instance oBumpWall of TPSound
	(properties)
)

(instance poDreep of Prop
	(properties
		x 612
		y 679
		view 51103
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
		(self setPri: 30)
	)
)

(instance oNullVoidPlane of TorScrollPlane
	(properties
		priority 20
		oNScrollExit 0
		oSScrollExit 0
		oEScrollExit 0
		oWScrollExit 0
	)

	(method (addPics)
		(AddPicAt self 51100 0 0)
		(AddPicAt self 51101 474 0)
		(AddPicAt self 51102 0 316)
		(AddPicAt self 51103 474 316)
		(AddPicAt self 51104 0 632)
		(AddPicAt self 51105 474 632)
	)
)

(instance roInsideNullVoid of TPRoom
	(properties
		picture 51100
	)

	(method (init)
		(super init: &rest)
		(= plane (oNullVoidPlane init: 948 948 yourself:))
		(goMusic1 setMusic: 51100)
		(foVoid init:)
		(foLycentiaExit init:)
		(if
			(and
				((ScriptID 64017 0) test: 215) ; oFlags
				(not ((ScriptID 64017 0) test: 223)) ; oFlags
			)
			(voCrystcorder init:)
		)
		(if ((ScriptID 64017 0) test: 223) ; oFlags
			(poDreep init:)
		)
		(gGame handsOn:)
		(= leavingRoom 0)
		(switch gPrevRoomNum
			(51200 ; roLycentiasPorch
				(poTorin setLoop: 3 posn: 678 698 setPri: 10 init:)
				(= vx -3)
				(= vy -3)
				(= vz 0)
				(= nSlowTime 2)
				(= IsUsingBagpipes 1)
				(oController init:)
			)
			(else
				(= nSlowTime (= vx (= vy (= vz 0))))
				(poTorin
					setLoop: 0
					posn: 308 175
					init:
					cycleSpeed: 12
					setCycle: Fwd
				)
				(= IsUsingBagpipes 0)
				(gCurRoom setScript: soJustGotHere)
			)
		)
	)

	(method (doit &tmp newX newY newZ newDist newScale distScale)
		(super doit:)
		(if leavingRoom
			(return)
		)
		(if
			(and
				(poTorin isNotHidden:)
				(or (!= 0 vx) (!= 0 vy) (!= 0 vz))
			)
			(= newZ (+ (poTorin priority:) vz))
			(= newZ (Max 16 newZ))
			(= distScale (/ (= newZ (Min 128 newZ)) 16))
			(if (<= -1 distScale 1)
				(= newX (+ (poTorin x:) (/ vx 8)))
				(= newY (+ (poTorin y:) (/ vy 8)))
			else
				(= newX (+ (poTorin x:) (MulDiv distScale vx 8)))
				(= newY (+ (poTorin y:) (MulDiv distScale vy 8)))
			)
			(if (> (= newDist (TheDist newX newY)) 7400)
				(oBumpWall playSound: 51108)
				(= vx (- vx))
				(= vy (- vy))
				(= vz (- vz))
			else
				(poTorin setPri: newZ posn: newX newY setScaleDirect: newZ)
				(UpdateScreenItem poTorin)
			)
		)
		(if (foLycentiaExit onMe:)
			(= leavingRoom 1)
			(gCurRoom setScript: soExitToPorch)
			(return)
		)
		(if (<= nSlowTime 0)
			(if (<= -1 vx 1)
				(= vx 0)
			else
				(= vx (MulDiv vx 2 3))
			)
			(if (<= -1 vy 1)
				(= vy 0)
			else
				(= vy (MulDiv vy 2 3))
			)
			(if (<= -1 vz 1)
				(= vz 0)
			else
				(= vz (MulDiv vz 2 3))
			)
			(= nSlowTime 2)
		else
			(-- nSlowTime)
		)
	)
)

