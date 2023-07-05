;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9)
(include sci.sh)
(use Main)
(use TrackingProp)
(use DText)
(use Str)
(use Array)
(use Talker)
(use PanelPlane)
(use Polygon)
(use ForwardCounter)
(use WalkieTalkie)
(use Sound)
(use Motion)
(use System)

(public
	LightInv 0
	PlInterface 1
	PlBagPlane 2
	PlCompass 3
	InvInset 4
	invLighter 5
	invUmbrella 6
	invBag 7
	invCarKeys 8
	invDrawbridgeKey 9
	invBabyBottle 10
	invRocks 11
	invLetter 12
	invCompass 13
	invLightHouseKey 14
	invLetterOpener 15
	invPuzzleBoxKey 16
	invCrowbar 17
	invSolderingIron 18
	invTube 19
	invWire 20
	invWindUpKey 21
	invShedKey 22
	invSpring 23
	invToySoldier 24
	invEnvelope 25
	invNotebook 26
	invStudyNotes 27
	invBedroomNotes 28
	invKitchenNotes 29
	invLabNotes 30
	invIonizer 31
	invThrottle 32
	invDeskKey 33
	invBatKey 34
	invWhistle 35
	invAmanda 36
	invAlanWrench 37
	invBottleNote 38
	invModulator 39
	invSparrow 40
	invBaubles 41
	invJems 42
	invCrank 43
	invGears 44
	invRadioControl 45
	invRadioBroke 46
	invOrnithopterPart 47
	invMachinePart 48
	invMachineTube 49
	invMachineBox 50
	invCD 51
	invLogs 52
	invIngots 53
	invCoal 54
	invMold 55
	invCircuitBoard 56
	invCrystalBottle 57
	invVacuumPump 58
	invStock 59
	invPowerSupply 60
	invFiringMechanism 61
	invBarrel 62
	invBluePrints 63
	invCannon 64
	invDynamite 65
	invTimeBomb 66
	invRockHammer 67
	invFish 68
	invAlarmClock 69
	invTool 70
	invSmallPlanks 71
	invLargePlanks 72
	invPuzzleAmulet 73
	invWindGear 74
	invStatueKey 75
	invCannonBall 76
	invCannonPowder 77
	invCannonFuse 78
	invHexBar 79
	invBoltCutter 80
	invPliers 81
	invWrench 82
	invAntenna 83
	invRail 84
	invDooDads 85
	invTorch 86
	returnButton 87
	invShell 88
	invBeingInBottle 89
	invPlans 90
	ppOptions 91
	proc9_92 92
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
)

(procedure (localproc_0 param1 &tmp temp0)
	(for
		((= temp0 gGameTime))
		(> (-= param1 (Abs (- (= gGameTime (+ gTickOffset (GetTime))) temp0))) 0)
		((= temp0 gGameTime))
	)
)

(procedure (proc9_92 param1)
	(cond
		(param1
			(cond
				(gPortal
					(gAutoRobot pause: 1)
				)
				(gAutoRobot
					(gAutoRobot pause: 1)
				)
				(global208
					(if (not (global208 paused:))
						(global208 pause: 1)
					else
						(= local2 1)
					)
				)
			)
		)
		(gPortal
			(gAutoRobot pause: 0)
		)
		(gAutoRobot
			(gAutoRobot pause: 0)
		)
		(global208
			(if (not local2)
				(global208 pause: 0)
			)
			(= local2 0)
		)
	)
)

(class PlBagPlane of PanelPlane
	(properties
		picture -1
		curRow 0
		bagSize -1
		extended 0
	)

	(method (handleEvent event)
		(if (not (event claimed:))
			(if
				(and
					(not (super handleEvent: event &rest))
					(& (event type:) evMOUSEBUTTON)
				)
				(invBag doVerb: 5)
				(if (< (invBag view:) 3000)
					(invBag view: (+ (invBag view:) 1000))
				)
				(event claimed: 1)
			)
			(if (event type:)
				(event claimed: 1)
			)
		)
		(event claimed:)
	)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(= priority (+ (GetHighPlanePri) 1))
		(= temp1 (- (gInventory size:) 5))
		(= bagSize (Min 5 (+ (/ (- temp1 1) 6) 2)))
		(= temp0 (- 296 (* (- bagSize 1) 90)))
		(= extended (> (gInventory size:) 29))
		(super init: 28 (+ temp0 75) (if extended 601 else 571) 465)
		(= temp3 (if extended 573 else 543))
		(= temp2 (+ (* (- bagSize 1) 90) 3))
		(AddLine self 0 0 temp3 0 500 202 0 0 1)
		(AddLine self 0 0 0 temp2 500 202 0 0 1)
		(AddLine self temp3 0 temp3 temp2 500 202 0 0 1)
		(AddLine self 0 temp2 temp3 temp2 500 202 0 0 1)
		(if extended
			(self initControls:)
		)
		(self drawHeldItems:)
		(self drawBagContents:)
	)

	(method (drawHeldItems &tmp temp0 temp1 temp2)
		(= temp0 (+ (* (- bagSize 1) 90) 5))
		(invBag x: 452 y: temp0 init: self 1 1)
		(pvBagBorders
			loop: 1
			x: 92
			y: temp0
			priority: 0
			fixPriority: 1
			init: self 1 1
		)
		(= temp1 92)
		(for ((= temp2 1)) (< temp2 5) ((++ temp2))
			((gInventory at: temp2)
				x: temp1
				y: temp0
				priority: 200
				fixPriority: 1
				init: self 1 1
			)
			(+= temp1 90)
		)
	)

	(method (drawBagContents &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 (+ (* 6 curRow) 5))
		(if curRow
			(self cleanRange: 5 temp0)
		)
		(= temp3 2)
		(= temp4 (+ (* (- bagSize 2) 90) 3))
		(= temp1 temp0)
		(for
			((= temp2 1))
			(and (<= temp2 24) (< temp1 (gInventory size:)))
			((++ temp2))
			
			((= temp5 (gInventory at: temp1)) x: temp3 y: temp4)
			(if (not (((self casts:) at: 0) contains: temp5))
				(temp5 priority: 200 fixPriority: 1 init: self 1 1)
			)
			(if (mod temp2 6)
				(+= temp3 90)
			else
				(-= temp4 90)
				(= temp3 2)
			)
			(++ temp1)
		)
		(if (< temp1 (gInventory size:))
			(self cleanRange: temp1 (gInventory size:))
		)
	)

	(method (cleanRange param1 param2 &tmp temp0 temp1)
		(for ((= temp0 param1)) (< temp0 param2) ((++ temp0))
			(= temp1 (gInventory at: temp0))
			(if (((self casts:) at: 0) contains: temp1)
				(temp1 dispose: self 1 1)
			)
		)
	)

	(method (initControls)
		(= curRow 0)
		(pvScrollerFrame init: self 1 1)
		(pbScrollerUp cel: 1 init: self 1 1)
		(pbScrollerDown cel: 0 active: 0 init: self 1 1)
	)

	(method (scrollUp)
		(if (< (+ (* curRow 6) 29) (gInventory size:))
			(++ curRow)
		else
			(return)
		)
		(if curRow
			(pbScrollerDown cel: 1 active: 1)
		)
		(if (>= (+ (* curRow 6) 29) (gInventory size:))
			(pbScrollerUp cel: 0 active: 0)
		)
		(self drawBagContents:)
	)

	(method (scrollDown)
		(= curRow (Max (-- curRow) 0))
		(if (not curRow)
			(pbScrollerDown cel: 0 active: 0)
		)
		(pbScrollerUp cel: 1 active: 1)
		(self drawBagContents:)
	)

	(method (dispose)
		(= curRow 0)
		(if extended
			(pvScrollerFrame dispose: self 1 1)
			(pbScrollerUp dispose: self 1 1)
			(pbScrollerDown dispose: self 1 1)
		)
		(if (gMouseDownHandler contains: self)
			(gMouseDownHandler delete: self)
		)
		(super dispose: &rest)
	)
)

(instance PlCompass of PanelPlane
	(properties
		disposeNotOnMe 0
	)

	(method (handleEvent)
		(return 0)
	)

	(method (dispose)
		(ClearFlag 368)
		(ppCompass dispose: self 1 1)
		(ppCompassFace dispose: self 1 1)
		(super dispose: &rest)
	)

	(method (init)
		(if casts
			(return)
		)
		(SetFlag 368)
		(= priority (+ (GetHighPlanePri) 1))
		(super init: 525 0 640 219)
		(ppCompass init: self 1 1)
		(ppCompassFace init: self 1 1)
	)
)

(class LightInv of Set
	(properties
		disabled 0
	)

	(method (disable param1)
		(if param1
			(if (gPanels contains: PlBagPlane)
				(PlBagPlane dispose:)
			)
			(gInventory draw:)
			(if
				(or
					(gPanels contains: (ScriptID 9 4)) ; InvInset
					(gPanels contains: (ScriptID 271 0)) ; toolBoxPanel
					(gPanels contains: (ScriptID 19 1)) ; BombInset
				)
				(invBag view: 3001)
				(if global108
					(PlInterface showTmpInv:)
				)
			else
				(invBag view: 3001)
			)
			(self disabled: 1)
		else
			(self disabled: 0)
		)
	)

	(method (addToNotebook param1)
		(gMySoundFX do: 19201)
		(if (IsFlag 61)
			(= local3 1)
		else
			(gInventory addItem: param1)
		)
		(switch param1
			(invStudyNotes
				(gUser canInput: 0)
				(pplStudyNotes init:)
			)
			(invBedroomNotes
				(gUser canInput: 0)
				(pplBedroomNotes init:)
			)
			(invKitchenNotes
				(gUser canInput: 0)
				(pplKitchenNotes init:)
			)
			(invLabNotes
				(gUser canInput: 0)
				(pplLabNotes init:)
			)
		)
	)

	(method (addItem param1 &tmp temp0)
		(if (and (gInventory contains: invBag) (> (gInventory size:) 4))
			(invBag setCycle: 0)
			(invBag cel: 2)
			(UpdateScreenItem invBag)
			(FrameOut)
			(localproc_0 10)
			(invBag cel: 4)
			(UpdateScreenItem invBag)
			(FrameOut)
			(localproc_0 10)
			(invBag cel: 2)
			(UpdateScreenItem invBag)
			(FrameOut)
			(localproc_0 10)
			(invBag cel: 0)
		)
		(cond
			((== param1 invBag)
				(self addToFront: param1)
			)
			((self contains: invBag)
				(self addAfter: invBag param1)
			)
			(else
				(self addToFront: param1)
			)
		)
		(param1 plane: PlInterface)
		(for ((= temp0 0)) (< temp0 (gInventory size:)) ((++ temp0))
			((gInventory at: temp0) dispose: PlInterface 1 1)
		)
		(self draw:)
	)

	(method (deleteItem param1 &tmp temp0)
		(if (not global215)
			(gGame normalizeCursor:)
		)
		(self delete: param1)
		(param1 dispose: PlInterface 1 1)
		(param1 dispose: PlBagPlane 1 1)
		(if (== param1 global110)
			(= global110 0)
		)
		(self draw:)
	)

	(method (draw &tmp temp0 temp1 temp2)
		(= temp1 4)
		(if (gInventory size:)
			(if (gInventory contains: invBag)
				(= temp0 1)
				(invBag
					x: 410
					y: 0
					priority: (+ (GetHighPlanePri) 1)
					fixPriority: 1
					init: PlInterface 1 1
				)
				(++ temp1)
			else
				(= temp0 0)
			)
			(for ((= temp2 50)) (< temp0 temp1) ((+= temp2 90))
				(if (< temp0 (gInventory size:))
					((gInventory at: temp0)
						x: temp2
						y: 0
						priority: (+ (GetHighPlanePri) 1)
						fixPriority: 1
						init: PlInterface 1 1
					)
					(if (gInventory contains: invBag)
						(pvBorders cel: temp0)
					else
						(pvBorders cel: (+ temp0 1))
					)
					(UpdateScreenItem pvBorders)
				)
				(++ temp0)
			)
		)
	)

	(method (drawBag &tmp temp0)
		(if (self size:)
			(if (< (self size:) 5)
				(return 0)
			else
				(for ((= temp0 0)) (< temp0 (gInventory size:)) ((++ temp0))
					((gInventory at: temp0) dispose: PlInterface 1 1)
				)
				(if (not (gPlanes contains: PlBagPlane))
					(PlBagPlane init:)
				)
			)
		)
	)
)

(class InvInset of PanelPlane
	(properties
		disposeNotOnMe 0
		curInv 0
	)

	(method (handleEvent event)
		(cond
			((gPanels contains: (ScriptID 9 2)) ; PlBagPlane
				(event claimed: 1)
			)
			((PlInterface onMe: event)
				(super handleEvent: event &rest)
			)
			((and (& (event type:) evMOUSEBUTTON) (not (self onMe: event)))
				(event claimed: 1)
				(self dispose:)
			)
			(else
				(super handleEvent: event &rest)
			)
		)
	)

	(method (init param1)
		(if
			(or
				casts
				(gPanels contains: (ScriptID 271 0)) ; toolBoxPanel
				(gPanels contains: (ScriptID 19 1)) ; BombInset
			)
			(return)
		)
		(if (gPanels contains: PlCompass)
			(PlCompass hide:)
		)
		(= curInv param1)
		(gMouseDownHandler add: self)
		(= priority (+ (GetHighPlanePri) 1))
		(if (not (IsFlag 388))
			(if (< (global108 view:) 3000)
				(global108 view: (+ (global108 view:) 1000))
			)
			(self showTmpInv:)
		)
		(invInsetItem setPri: -1)
		(switch param1
			(invMachinePart
				(super init: 440 0 640 200)
				(invInsetItem
					view: 4730
					loop:
						(cond
							((IsFlag 201) 2)
							((IsFlag 200) 1)
							(else 0)
						)
					cel: 0
					init: self 1 1
					setCycle: Fwd
				)
			)
			(invRadioControl
				(super init: 440 0 640 200)
				(invInsetItem view: 2039 loop: 0 cel: 0 init: self 1 1)
				(pvAntenna init: self 1 1)
				(ppLeftButton init: self 1 1)
				(ppMiddleButton init: self 1 1)
				(ppRightButton init: self 1 1)
				(if (IsFlag 312)
					(ppActivateButton init: self 1 1)
					(ppStatusScreen init: self 1 1 hide:)
					(ppViewScreen init: self 1 1 setCycle: Fwd)
				)
			)
			(invSparrow
				(super init: 440 0 640 200)
				(invInsetItem
					view: 4342
					loop: (if (IsFlag 346) 0 else 1)
					cel: 0
					init: self 1 1
					setCycle: Fwd
				)
			)
			(invWhistle
				(super init: 440 0 640 200)
				(invInsetItem
					view: 5491
					loop: 0
					cel: 0
					init: self 1 1
					setCycle: Fwd
				)
				(ppWhistleDial init: self 1 1 setCel: global256 x: 1000)
				(ppWhistleIndicator
					init: self 1 0
					setCel: (/ global256 2)
					x: 1000
				)
				(pfWhistleBut init: self 1)
			)
			(invToySoldier
				(super init: 440 0 640 200)
				(invInsetItem
					view: 4356
					loop: (if (IsFlag 59) 1 else 0)
					cel: 0
					init: self 1 1
					setCycle: Fwd
				)
			)
			(invEnvelope
				(super init: 390 0 640 200)
				(invInsetItem
					view: 4301
					loop: (if (IsFlag 32) 1 else 0)
					cel: 0
					init: self 1 1
				)
			)
			(invUmbrella
				(super init: 440 0 640 200)
				(invInsetItem
					view: 56
					setCel: (if (invUmbrella state:) 0 else 17)
					init: self 1 1
				)
				(fUmbrellaFeature init: self 1 1)
			)
			(invLighter
				(super init: 440 0 640 200)
				(invInsetItem view: 59)
				(switch (invLighter state:)
					(1
						(self setBitmap: 59 3 0)
						(invInsetItem
							setCel: (Random 0 3)
							setLoop: 1
							setPri: (+ (self priority:) 1)
						)
					)
					(2
						(self setBitmap: 59 3 1)
						(invInsetItem
							setCel: 0
							setLoop: 2
							setPri: (+ (self priority:) 1)
							setCycle: Fwd
						)
					)
					(else
						(self setBitmap: 59 3 0)
						(invInsetItem
							setCel: 0
							setLoop: 0
							setCycle: 0
							setPri: (+ (self priority:) 1)
						)
					)
				)
				(invInsetItem init: self 1 1)
			)
		)
	)

	(method (dispose)
		(if (gMouseDownHandler contains: self)
			(gMouseDownHandler delete: self)
		)
		(if (and (IsFlag 59) (== curInv invToySoldier))
			(gInventory deleteItem: (ScriptID 9 24)) ; invToySoldier
		)
		(if (== curInv invWhistle)
			(invSound stop:)
		)
		(if (== curInv invLighter)
			(invSound setLoop: 1 stop:)
			(invLighter state: 0 cel: 0)
		)
		(= curInv 0)
		(if (gPanels contains: PlCompass)
			(PlCompass show:)
		)
		(super dispose: &rest)
	)
)

(class PlInterface of PanelPlane
	(properties
		disposeNotOnMe 0
	)

	(method (init &tmp [temp0 3])
		(if (and gPanels (gPanels contains: self))
			(return)
		)
		(gGame liteInterface: self)
		(= priority (+ (GetHighPlanePri) 1))
		(gPanels add: self)
		(super init: 70 376 570 465)
		(ppOptions init: self 1 1)
		(pvBorders loop: 0 cel: 0 x: 0 y: 0 init: self 1 1)
		(LightInv draw:)
	)

	(method (handleEvent event)
		(cond
			((gPanels contains: PlBagPlane)
				(return)
			)
			(
				(and
					(== (gTheCursor view:) 1100)
					(self onMe: (event x:) (event y:))
				)
				(= global106 0)
				(gGame normalizeCursor:)
			)
			(
				(and
					(not (self onMe: (event x:) (event y:)))
					(or (== (ppOptions view:) 2055) (== (ppOptions loop:) 1))
				)
				(ppOptions view: 3055 loop: 0)
				(UpdateScreenItem ppOptions)
			)
			((and global108 (not (self onMe: (event x:) (event y:))))
				(cond
					(
						(or
							(gPanels contains: (ScriptID 9 4)) ; InvInset
							(gPanels contains: (ScriptID 271 0)) ; toolBoxPanel
							(gPanels contains: (ScriptID 19 1)) ; BombInset
						)
						(self showTmpInv: 0)
					)
					((< (global108 view:) 3000)
						(global108 view: (+ (global108 view:) 1000))
					)
				)
				(= global108 0)
			)
			((and (gPanels contains: InvInset) (not (self onMe: event)))
				(UpdateScreenItem invInsetItem)
			)
		)
		(self onMe: event)
		(super handleEvent: event &rest)
	)

	(method (dispose)
		(gGame liteInterface: 0)
		(super dispose: &rest)
	)
)

(instance invCarKeys of PanelInv
	(properties
		view 3003
		myVerb 6
	)
)

(instance invUmbrella of PanelInv
	(properties
		view 3005
		myVerb 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					((gPanels contains: (ScriptID 9 2)) ; PlBagPlane
						(super doVerb: theVerb &rest)
					)
					((== (InvInset curInv:) self)
						(InvInset dispose:)
						(super doVerb: theVerb &rest)
					)
					(else
						(if (gPanels contains: InvInset)
							(InvInset dispose:)
						)
						(InvInset init: self)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invBag of PanelInv
	(properties
		view 3001
		myVerb 12
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(5 ; Do
				(if (> (gInventory size:) 5)
					(if (and gPanels (gPanels contains: (ScriptID 9 2))) ; PlBagPlane
						(PlBagPlane dispose:)
						(gInventory draw:)
						(if (gPanels contains: (ScriptID 271 0)) ; toolBoxPanel
							(UpdateScreenItem ((ScriptID 271 0) bitmap:)) ; toolBoxPanel
						)
						(if
							(or
								(gPanels contains: (ScriptID 9 4)) ; InvInset
								(gPanels contains: (ScriptID 271 0)) ; toolBoxPanel
								(gPanels contains: (ScriptID 19 1)) ; BombInset
							)
							(= view 3001)
							(if global108
								(PlInterface showTmpInv: 0)
							)
						else
							(= view 2001)
						)
						(self setCycle: Beg)
					else
						(gInventory drawBag:)
						(self setCycle: End)
					)
				)
			)
			(39 ; ???
				(return 1)
			)
			(else
				(gGame normalizeCursor:)
			)
		)
	)
)

(instance invLighter of PanelInv
	(properties
		view 3007
		myVerb 11
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					((gPanels contains: (ScriptID 9 2)) ; PlBagPlane
						(super doVerb: theVerb &rest)
					)
					((== (InvInset curInv:) self)
						(super doVerb: theVerb &rest)
						(InvInset dispose:)
					)
					(else
						(if (gPanels contains: InvInset)
							(InvInset dispose:)
						)
						(InvInset init: self)
					)
				)
			)
			(11 ; invLighter
				(self state: 0 cel: 0)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(self cel: (self state:))
		(switch state
			(1
				(pfStriker init: InvInset 1 1)
			)
			(2
				(invInsetItem setLoop: 2 setCycle: Fwd)
				(if (OneOf (gCurRoom scene:) 663 698 950 951 954 694 700)
					(InvInset dispose:)
					(gGame handsOn:)
					(gUser curVerb: myVerb)
					(= global110 self)
					(gNormalCursor view: 2007 loop: 1 cel: 2)
					(invLighter state: 2 cel: 2)
					(gGame setCursor: gNormalCursor 1)
					(return)
				else
					(invSound number: 57 setLoop: -1 play:)
				)
			)
			(else
				(invSound stop:)
				(invSound number: 42 setLoop: 1 play:)
				(pfStriker dispose: InvInset 1 1)
			)
		)
		(gGame handsOn:)
	)
)

(instance invEnvelope of PanelInv
	(properties
		view 3011
		myVerb 33
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					((gPanels contains: (ScriptID 9 2)) ; PlBagPlane
						(super doVerb: theVerb &rest)
					)
					((== (InvInset curInv:) self)
						(InvInset dispose:)
						(super doVerb: theVerb &rest)
					)
					(else
						(if (gPanels contains: InvInset)
							(InvInset dispose:)
						)
						(InvInset init: self)
					)
				)
			)
			(16 ; invLetterOpener
				(cond
					((gPanels contains: (ScriptID 9 2)) ; PlBagPlane
						(super doVerb: theVerb &rest)
					)
					((== (InvInset curInv:) self)
						(InvInset dispose:)
						(super doVerb: theVerb &rest)
					)
					(else
						(if (gPanels contains: InvInset)
							(InvInset dispose:)
						)
						(InvInset init: self)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(proc9_92 0)
		(InvInset dispose:)
		(gInventory addItem: invLetter)
		(pplFullLetterPlane init:)
		(gGame handsOn:)
		(gInventory deleteItem: self)
	)
)

(instance invLetter of PanelInv
	(properties
		view 3010
		myVerb 14
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					((gPanels contains: (ScriptID 9 2)) ; PlBagPlane
						(super doVerb: theVerb &rest)
					)
					((gPanels contains: pplFullLetterPlane)
						(pplFullLetterPlane dispose:)
						(super doVerb: theVerb &rest)
					)
					(else
						(pplFullLetterPlane init:)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invPuzzleBoxKey of PanelInv
	(properties
		view 3008
		myVerb 17
	)
)

(instance invLightHouseKey of PanelInv
	(properties
		view 3014
		myVerb 15
	)
)

(instance invCrowbar of PanelInv
	(properties
		view 3016
		myVerb 25
	)
)

(instance invLetterOpener of PanelInv
	(properties
		view 3021
		myVerb 16
	)
)

(instance invBabyBottle of PanelInv
	(properties
		view 3024
		myVerb 8
	)
)

(instance invCompass of PanelInv
	(properties
		view 3026
		myVerb 13
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					((IsFlag 403)
						(return)
					)
					(
						(or
							(OneOf gCurRoomNum 700 210 220 212 225)
							(gPanels contains: (ScriptID 9 2)) ; PlBagPlane
							(gPanels contains: (ScriptID 271 0)) ; toolBoxPanel
						)
						(super doVerb: theVerb &rest)
					)
					((gPanels contains: PlCompass)
						(ppCompass doVerb: 5)
					)
					(else
						(if (gPanels contains: InvInset)
							(InvInset dispose:)
						)
						(PlCompass init:)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invDrawbridgeKey of PanelInv
	(properties
		view 3040
		myVerb 7
	)
)

(instance invRocks of PanelInv
	(properties
		view 3042
		myVerb 9
	)
)

(instance invSolderingIron of PanelInv
	(properties
		view 3032
		myVerb 26
	)
)

(instance invTube of PanelInv
	(properties
		view 3035
		myVerb 27
	)
)

(instance invWire of PanelInv
	(properties
		view 3036
		myVerb 28
	)
)

(instance invWindUpKey of PanelInv
	(properties
		view 3022
		myVerb 29
	)
)

(instance invShedKey of PanelInv
	(properties
		view 3012
		myVerb 30
	)
)

(instance invSpring of PanelInv
	(properties
		view 3051
		myVerb 31
	)
)

(instance invToySoldier of PanelInv
	(properties
		view 3013
		myVerb 32
	)

	(method (doVerb theVerb)
		(if (IsFlag 59)
			(return)
		)
		(switch theVerb
			(5 ; Do
				(cond
					((gPanels contains: (ScriptID 9 2)) ; PlBagPlane
						(super doVerb: theVerb &rest)
					)
					((== (InvInset curInv:) self)
						(InvInset dispose:)
						(super doVerb: theVerb &rest)
					)
					(else
						(if (gPanels contains: InvInset)
							(InvInset dispose:)
						)
						(InvInset init: self)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invIonizer of PanelInv
	(properties
		view 3092
		myVerb 40
	)
)

(instance invThrottle of PanelInv
	(properties
		view 3058
		myVerb 41
	)
)

(instance invDeskKey of PanelInv
	(properties
		view 3052
		myVerb 42
	)
)

(instance invBatKey of PanelInv
	(properties
		view 3053
		myVerb 43
	)
)

(instance invWhistle of PanelInv
	(properties
		view 3054
		myVerb 44
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					((gPanels contains: (ScriptID 9 2)) ; PlBagPlane
						(super doVerb: theVerb &rest)
					)
					((== (InvInset curInv:) self)
						(InvInset dispose:)
						(super doVerb: theVerb &rest)
					)
					(else
						(if (gPanels contains: InvInset)
							(InvInset dispose:)
						)
						(InvInset init: self)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invAmanda of PanelInv
	(properties
		view 3059
		myVerb 93
	)

	(method (doVerb theVerb)
		(if (IsFlag 432)
			(ClearFlag 432)
			(amandaSound number: 8390 setLoop: 0 play:)
		else
			(SetFlag 432)
			(amandaSound number: 8391 setLoop: 0 play:)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance invAlanWrench of PanelInv
	(properties
		view 3062
		myVerb 46
	)
)

(instance invModulator of PanelInv
	(properties
		view 3034
		myVerb 48
	)
)

(instance invSparrow of PanelInv
	(properties
		view 3020
		myVerb 21
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					((gPanels contains: (ScriptID 9 2)) ; PlBagPlane
						(super doVerb: theVerb &rest)
					)
					((== (InvInset curInv:) self)
						(InvInset dispose:)
						(super doVerb: theVerb &rest)
					)
					((not (IsFlag 346))
						(if (gPanels contains: InvInset)
							(InvInset dispose:)
						)
						(InvInset init: self)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(29 ; invWindUpKey
				(cond
					((gPanels contains: (ScriptID 9 2)) ; PlBagPlane
						(super doVerb: theVerb &rest)
					)
					((== (InvInset curInv:) self)
						(InvInset dispose:)
						(super doVerb: theVerb &rest)
					)
					((not (IsFlag 346))
						(if (gPanels contains: InvInset)
							(InvInset dispose:)
						)
						(InvInset init: self)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invBaubles of PanelInv
	(properties
		view 3037
		myVerb 51
	)
)

(instance invDooDads of PanelInv
	(properties
		view 3006
		myVerb 94
	)
)

(instance invJems of PanelInv
	(properties
		view 3038
		myVerb 50
	)
)

(instance invBottleNote of PanelInv
	(properties
		view 3044
		myVerb 47
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (gPanels contains: (ScriptID 9 2)) ; PlBagPlane
					(super doVerb: theVerb &rest)
				else
					(gUser canInput: 0)
					(pplBottleNote init:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invNotebook of PanelInv
	(properties
		view 3015
		myVerb 34
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (gPanels contains: (ScriptID 9 2)) ; PlBagPlane
					(super doVerb: theVerb &rest)
				else
					(if (gPanels contains: InvInset)
						(InvInset dispose:)
					)
					(gGame handsOff:)
					(self view: 2009 cel: 0 setCycle: End self)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(if cel
			(gUser canInput: 0)
			(pplNotebook init:)
		else
			(if (== global108 self)
				(= global108 0)
			)
			(self view: 3015 cel: 0)
		)
		(gGame handsOn:)
	)
)

(instance invStudyNotes of PanelInv
	(properties
		view 3023
		myVerb 35
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (gPanels contains: (ScriptID 9 2)) ; PlBagPlane
					(super doVerb: theVerb &rest)
				else
					(gUser canInput: 0)
					(pplStudyNotes init:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invBedroomNotes of PanelInv
	(properties
		view 3017
		myVerb 36
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (gPanels contains: (ScriptID 9 2)) ; PlBagPlane
					(super doVerb: theVerb &rest)
				else
					(gUser canInput: 0)
					(pplBedroomNotes init:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invKitchenNotes of PanelInv
	(properties
		view 3018
		myVerb 37
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (gPanels contains: (ScriptID 9 2)) ; PlBagPlane
					(super doVerb: theVerb &rest)
				else
					(gUser canInput: 0)
					(pplKitchenNotes init:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invLabNotes of PanelInv
	(properties
		view 3019
		myVerb 38
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (gPanels contains: (ScriptID 9 2)) ; PlBagPlane
					(super doVerb: theVerb &rest)
				else
					(gUser canInput: 0)
					(pplLabNotes init:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invCrank of PanelInv
	(properties
		view 3061
		myVerb 52
	)
)

(instance invGears of PanelInv
	(properties
		view 3060
		myVerb 53
	)
)

(instance invRadioControl of PanelInv
	(properties
		view 3050
		myVerb 54
	)

	(method (cue)
		(if (and (gPanels contains: InvInset) (== (gCurRoom scene:) 474))
			(InvInset dispose:)
		)
		(super cue:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					((gPanels contains: (ScriptID 9 2)) ; PlBagPlane
						(super doVerb: theVerb &rest)
					)
					((== (InvInset curInv:) self)
						(InvInset dispose:)
						(super doVerb: theVerb &rest)
					)
					(
						(or
							(IsFlag 312)
							(and (not (IsFlag 311)) (not (IsFlag 387)))
						)
						(if (gPanels contains: InvInset)
							(InvInset dispose:)
						)
						(InvInset init: self)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invRadioBroke of PanelInv
	(properties
		view 3056
		myVerb 55
	)
)

(instance invOrnithopterPart of PanelInv
	(properties
		view 3072
		myVerb 56
	)
)

(instance invMachinePart of PanelInv
	(properties
		view 3065
		myVerb 57
	)

	(method (init)
		(cond
			((IsFlag 201)
				(= view 3075)
			)
			((IsFlag 200)
				(= view 3063)
			)
			(else
				(= view 3065)
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					((gPanels contains: (ScriptID 9 2)) ; PlBagPlane
						(super doVerb: theVerb &rest)
					)
					((== (InvInset curInv:) self)
						(InvInset dispose:)
						(super doVerb: theVerb &rest)
					)
					(else
						(if (gPanels contains: InvInset)
							(InvInset dispose:)
						)
						(InvInset init: self)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invMachineTube of PanelInv
	(properties
		view 3066
		myVerb 58
	)
)

(instance invMachineBox of PanelInv
	(properties
		view 3067
		myVerb 59
	)
)

(instance invCD of PanelInv
	(properties
		view 3068
		myVerb 60
	)
)

(instance invCircuitBoard of PanelInv
	(properties
		view 3069
		myVerb 65
	)
)

(instance invCrystalBottle of PanelInv
	(properties
		view 3090
		myVerb 66
	)
)

(instance invVacuumPump of PanelInv
	(properties
		view 3107
		myVerb 67
	)
)

(instance invStock of PanelInv
	(properties
		view 3111
		myVerb 68
	)
)

(instance invPowerSupply of PanelInv
	(properties
		view 3109
		myVerb 69
	)
)

(instance invFiringMechanism of PanelInv
	(properties
		view 3103
		myVerb 70
	)
)

(instance invBarrel of PanelInv
	(properties
		view 3102
		myVerb 71
	)
)

(instance invBluePrints of PanelInv
	(properties
		view 3043
		myVerb 72
	)
)

(instance invCannon of PanelInv
	(properties
		view 3148
		myVerb 73
	)
)

(instance invIngots of PanelInv
	(properties
		view 3076
		myVerb 62
	)
)

(instance invCoal of PanelInv
	(properties
		view 3077
		myVerb 63
	)
)

(instance invLogs of PanelInv
	(properties
		view 3078
		myVerb 61
	)
)

(instance invMold of PanelInv
	(properties
		view 3079
		myVerb 64
	)
)

(instance invDynamite of PanelInv
	(properties
		view 3080
		myVerb 77
	)
)

(instance invTimeBomb of PanelInv
	(properties
		view 3082
		myVerb 75
	)
)

(instance invRockHammer of PanelInv
	(properties
		view 3083
		myVerb 76
	)
)

(instance invFish of PanelInv
	(properties
		view 3074
		myVerb 20
	)
)

(instance invAlarmClock of PanelInv
	(properties
		view 3025
		myVerb 78
	)
)

(instance invTool of PanelInv
	(properties
		view 3048
		myVerb 81
	)
)

(instance invAntenna of PanelInv
	(properties
		view 3049
		myVerb 91
	)
)

(instance invSmallPlanks of PanelInv
	(properties
		view 3070
		myVerb 79
	)
)

(instance invLargePlanks of PanelInv
	(properties
		view 3071
		myVerb 80
	)
)

(instance invPuzzleAmulet of PanelInv
	(properties
		view 3031
		myVerb 82
	)
)

(instance invWindGear of PanelInv
	(properties
		view 3073
		myVerb 74
	)
)

(instance invStatueKey of PanelInv
	(properties
		view 3085
		myVerb 86
	)
)

(instance invCannonBall of PanelInv
	(properties
		view 3098
		myVerb 83
	)
)

(instance invCannonPowder of PanelInv
	(properties
		view 3099
		myVerb 84
	)
)

(instance invCannonFuse of PanelInv
	(properties
		view 3097
		myVerb 85
	)
)

(instance invHexBar of PanelInv
	(properties
		view 3152
		myVerb 87
	)
)

(instance invBoltCutter of PanelInv
	(properties
		view 3045
		myVerb 88
	)
)

(instance invPliers of PanelInv
	(properties
		view 3046
		myVerb 89
	)
)

(instance invWrench of PanelInv
	(properties
		view 3033
		myVerb 90
	)
)

(instance invRail of PanelInv
	(properties
		view 3153
		myVerb 92
	)
)

(instance invTorch of PanelInv
	(properties
		view 3041
		myVerb 95
	)
)

(instance invShell of PanelInv
	(properties
		view 3064
		myVerb 19
	)
)

(instance invBeingInBottle of PanelInv
	(properties
		view 3028
		myVerb 96
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					((gPanels contains: (ScriptID 9 2)) ; PlBagPlane
						(super doVerb: theVerb &rest)
					)
					((or gPortal gAutoRobot global208)
						(super doVerb: theVerb &rest)
					)
					(else
						(pplBeingInBottle init:)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invPlans of PanelInv
	(properties
		view 3029
		myVerb 97
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (gPanels contains: (ScriptID 9 2)) ; PlBagPlane
					(super doVerb: theVerb &rest)
				else
					(pplPlans init:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pvScrollerFrame of PanelView
	(properties
		x 548
		y 164
		view 1210
	)
)

(instance pbScrollerUp of PanelButton
	(properties
		x 556
		y 173
		view 1210
		loop 1
		cel 1
	)

	(method (handleEvent event)
		(if (and active (self onMe: (event x:) (event y:)))
			(event claimed: 1)
			(if
				(and
					(& (event type:) evMOUSEBUTTON)
					(or (not relVerify) (self waitMouseUp:))
					(gUser canInput:)
				)
				(self doVerb: (gUser curVerb:))
			)
		)
		(event claimed:)
	)

	(method (doVerb)
		(gGame panelObj: plane panelSelector: 404)
	)
)

(instance pbScrollerDown of PanelButton
	(properties
		x 556
		y 188
		view 1210
		loop 2
		cel 1
	)

	(method (handleEvent event)
		(if (and active (self onMe: (event x:) (event y:)))
			(event claimed: 1)
			(if
				(and
					(& (event type:) evMOUSEBUTTON)
					(or (not relVerify) (self waitMouseUp:))
					(gUser canInput:)
				)
				(self doVerb: (gUser curVerb:))
			)
		)
		(event claimed:)
	)

	(method (doVerb)
		(gGame panelObj: plane panelSelector: 403)
	)
)

(instance controlPanel of PanelPlane
	(properties
		picture 1202
	)

	(method (init)
		(if casts
			(return)
		)
		(= priority (+ (GetHighPlanePri) 1))
		(super init: 0 0 640 480)
		(= global215 self)
		(quitButton init: self 1 1)
		(restartButton init: self 1 1)
		(loadButton init: self 1 1)
		(saveButton init: self 1 1)
		(returnButton init: self 1 1)
		(brightButton init: self 1 1)
		(brightSlider
			init: self 1 1
			setPoints: 27 17 64 17 104 17 141 17 179 17 220 17 258 17
		)
		(hintButton init: self 1 1)
		(hiliteButton init: self 1 1)
		(yesButton init: self 1 1)
		(noButton init: self 1 1)
		(= local5
			(IntArray
				newWith:
					10
					1
					2
					3
					4
					5
					6
					7
					8
					9
					10
					11
					12
					13
					14
					15
					16
					17
					18
					19
					20
					21
					22
					23
					24
					25
					26
					27
					28
					29
					30
					31
					32
					33
					34
					35
					36
					37
					38
					39
					40
					41
					42
					43
					44
					45
					46
					47
					48
					49
					50
					51
					52
					53
					54
					55
					56
					57
					58
					59
					60
					61
					62
					63
					64
					65
					66
					67
					68
					69
					70
					71
					72
					73
					74
					75
					76
					77
					78
					79
					80
					81
					82
					83
					84
					85
					86
					87
					88
					89
					90
					91
					92
					93
					94
					95
					96
					97
					98
					99
					100
			)
		)
		(FrameOut)
		(gGame cursHidden: 0)
		(gGame setCursor: gTheControlNormalCursor 1)
	)

	(method (dispose)
		(local5 dispose:)
		(= global215 0)
		(super dispose: &rest)
	)
)

(instance ppCompass of PanelProp
	(properties
		y 155
		view 4319
		signal 30753
	)

	(method (init)
		(gGame handsOff:)
		(super init: &rest)
		(self setLoop: 0 setCel: 0 setCycle: End self)
		(invSound number: 156 setLoop: 1 play:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(invSound number: 157 setLoop: 1 play:)
				(ppCompass setLoop: 0 setCel: 12 setCycle: Beg self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(if cel
			(invCompass view: 2027)
			(gGame handsOn:)
		else
			(invCompass view: 2026)
			(gGame handsOn:)
			(PlCompass dispose:)
		)
		(if (< (gInventory indexOf: invCompass) (gInventory indexOf: invBag))
			(UpdateScreenItem invCompass)
		)
	)

	(method (dispose)
		(if (not global221)
			(if (== global108 self)
				(= global108 0)
			)
			(invCompass view: 3026)
		)
		(gGame compassFace: 0)
		(super dispose: &rest)
	)
)

(instance ppCompassFace of PanelProp
	(properties
		x 2
		y 31
		view 4319
		loop 1
		signal 30753
	)

	(method (init)
		(= loop (gCurRoom compassDir:))
		(gGame compassFace: self)
		(super init: &rest)
	)
)

(instance invInsetItem of PanelProp
	(properties)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 0)
	)

	(method (doVerb theVerb)
		(switch ((self plane:) curInv:)
			(invSparrow
				(switch theVerb
					(29 ; invWindUpKey
						(gMySoundFX number: 114 setLoop: 0 play:)
						(SetFlag 346)
						(gInventory deleteItem: invWindUpKey)
						(self loop: 0)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(invMachinePart
				(switch theVerb
					(58 ; invMachineTube
						(invSound number: 7110 setLoop: 1 play:)
						(gInventory deleteItem: invMachineTube)
						(invMachinePart view: 3063)
						(SetFlag 200)
						(self loop: 1)
					)
					(59 ; invMachineBox
						(if (IsFlag 200)
							(invSound number: 7110 setLoop: 1 play:)
							(gInventory deleteItem: invMachineBox)
							(invMachinePart view: 3075)
							(SetFlag 201)
							(self loop: 2)
						else
							(super doVerb: theVerb)
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(invEnvelope
				(switch theVerb
					(16 ; invLetterOpener
						(if (not (IsFlag 32))
							(gGame handsOff:)
							(SetFlag 32)
							(invSound number: 52 setLoop: 1 play:)
							(gInventory deleteItem: invLetterOpener)
							(proc9_92 1)
							(self setCycle: End invEnvelope)
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(invLighter
				(switch theVerb
					(5 ; Do
						(gGame handsOff:)
						(if (>= (invLighter state:) 1)
							(invLighter state: 0)
							(InvInset setBitmap: 59 3 0)
							(self
								setCel: 11
								setLoop: 0
								setCycle: Beg invLighter
							)
						else
							(invLighter state: 1)
							(invSound number: 41 setLoop: 1 play:)
							(self setCel: 0 setLoop: 0 setCycle: End invLighter)
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(invWhistle
				(switch theVerb
					(5 ; Do
						(if cycler
							(if (> cel 13)
								(gUser canInput: 0)
								(self setCycle: End self)
							)
							(if (not cel)
								(self setCycle: 0 cue:)
							)
						else
							(ppWhistleDial x: 1000)
							(ppWhistleIndicator x: 1000)
							(self setCycle: Fwd)
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(invToySoldier
				(if (not (IsFlag 59))
					(if (!= cel 8)
						(self
							setCycle: CT 8 (if (> cel 8) -1 else 1) soldierCuee
						)
					else
						(soldierCuee cue:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(switch (InvInset curInv:)
			(invWhistle
				(self setCel: 0)
				(if (< (gInventory indexOf: invWhistle) (gInventory indexOf: invBag))
					(UpdateScreenItem self)
				)
				(ppWhistleDial x: 24 setCel: global256)
				(ppWhistleIndicator x: 24 setCel: (/ global256 2))
				(gUser canInput: 1)
			)
			(invUmbrella
				(if (invUmbrella state:)
					(invUmbrella cel: 0 state: 0)
				else
					(invUmbrella cel: 1 state: 1)
				)
				(if (< (gInventory indexOf: invUmbrella) (gInventory indexOf: invBag))
					(UpdateScreenItem invUmbrella)
				)
			)
		)
		(gGame handsOn:)
	)
)

(instance quitButton of PanelProp
	(properties
		x 400
		y 230
		view 1203
		loop 3
	)

	(method (init)
		(super init: &rest)
	)

	(method (doVerb)
		(self setScript: (ScriptID 0 3) self) ; sDepress
	)

	(method (cue)
		(= gQuit 1)
	)
)

(instance restartButton of PanelProp
	(properties
		x 240
		y 180
		view 1203
		cycleSpeed 4
	)

	(method (doVerb)
		(self setScript: (ScriptID 0 3) self) ; sDepress
	)

	(method (cue &tmp [temp0 2])
		(gGame restart:)
	)
)

(instance loadButton of PanelProp
	(properties
		x 425
		y 180
		view 1203
		loop 1
	)

	(method (doVerb)
		(self setScript: (ScriptID 0 3) self) ; sDepress
	)

	(method (cue)
		(super cue: &rest)
		(gGame restore: setCursor: gTheControlNormalCursor)
	)
)

(instance saveButton of PanelProp
	(properties
		x 215
		y 230
		view 1203
		loop 2
	)

	(method (init)
		(super init: &rest)
	)

	(method (doVerb)
		(self setScript: (ScriptID 0 3)) ; sDepress
	)

	(method (cue)
		(super cue: &rest)
		(gGame panelObj: gGame)
		(gGame panelSelector: 82)
	)
)

(instance returnButton of PanelProp
	(properties
		x 205
		y 280
		view 1203
		loop 4
	)

	(method (doit)
		(if (gGame gameRestored:)
			(gGame gameRestored: 0)
			(self setLoop: 14 cycleSpeed: 12 setCycle: Fwd)
		)
		(super doit: &rest)
	)

	(method (doVerb)
		(self setCycle: 0 setCel: 0 setLoop: 4)
		(if (not (IsFlag 163))
			(self setScript: (ScriptID 0 3)) ; sDepress
		)
	)

	(method (cue)
		(super cue: &rest)
		(gGame hideCursor:)
		(if (not (IsFlag 163))
			(proc9_92 0)
			(SetFlag 163)
		)
	)
)

(instance brightButton of PanelView
	(properties
		x 328
		y 333
		view 1202
	)
)

(instance brightSlider of TrackingProp
	(properties
		x 246
		y 357
		view 1202
		loop 2
		wrap 0
	)

	(method (init param1 param2 param3)
		(&= signal $fff7)
		(((param1 casts:) at: 0) add: self)
		(= plane param1)
		(AddScreenItem self)
		(= useInsetRect 0)
		(SetNowSeen self)
		(if (and (> argc 1) param2)
			(param1 addToDoits: self)
		)
		(if (and (> argc 2) param3)
			(param1 addToEvents: self)
		)
		(self setCel: global255)
	)

	(method (setCel param1)
		(Palette 4 global255) ; PalSetGamma
		(FrameOut)
		(super setCel: param1)
	)

	(method (nextCel param1 &tmp [temp0 4])
		(cond
			((< param1 cel)
				(if (or (not oneWay) (== oneWay -1))
					(-- global255)
					(brightSound number: 14 setLoop: 0 play:)
					(self setCel: (- cel 1))
				)
			)
			((or (not oneWay) (== oneWay 1))
				(++ global255)
				(brightSound number: 14 setLoop: 0 play:)
				(self setCel: (+ cel 1))
			)
		)
		(UpdateScreenItem self)
	)

	(method (dispose param1 param2 param3)
		(if (and (> argc 1) param2)
			(param1 addToDoits: self 0)
		)
		(if (and (> argc 2) param3)
			(param1 addToEvents: self 0)
		)
		(super dispose: &rest)
	)
)

(instance hiliteButton of PanelProp
	(properties
		x 215
		y 405
		view 1203
		loop 16
	)
)

(instance yesButton of PanelProp
	(properties
		x 458
		y 405
		view 1203
		loop 17
	)

	(method (doVerb)
		(if (not (IsFlag 163))
			(self setScript: (ScriptID 0 3)) ; sDepress
		)
	)

	(method (cue)
		(super cue: &rest)
		(SetFlag 436)
	)
)

(instance noButton of PanelProp
	(properties
		x 538
		y 405
		view 1203
		loop 18
	)

	(method (doVerb)
		(if (not (IsFlag 163))
			(self setScript: (ScriptID 0 3)) ; sDepress
		)
	)

	(method (cue)
		(super cue: &rest)
		(ClearFlag 436)
	)
)

(instance hintButton of PanelProp
	(properties
		x 425
		y 278
		view 1203
		loop 15
	)

	(method (doVerb)
		(if (not (IsFlag 163))
			(self setScript: (ScriptID 0 3)) ; sDepress
		)
	)

	(method (cue)
		(super cue: &rest)
		(hintPanel init:)
	)
)

(instance hintPanel of PanelPlane
	(properties
		picture 8004
	)

	(method (init)
		(if casts
			(return)
		)
		(= priority (+ (GetHighPlanePri) 1))
		(= global215 self)
		(super init: 0 0 640 480)
		(FrameOut)
		(gGame cursHidden: 0)
		(gGame setCursor: gTheControlNormalCursor 1)
		(= local7 1)
		(if (not (IsFlag 435))
			(SetFlag 435)
			(= local8 -1)
			(hintCode doit:)
		else
			(= local8 (gCurRoom scene:))
			(hintCode doit:)
		)
	)

	(method (dispose)
		(local6 dispose:)
		(= global215 controlPanel)
		(super dispose: &rest)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 0)
		)
		(= temp0 0)
		(if (and (event type:) (& (event type:) evMOUSEBUTTON) (self onMe: event))
			(local6 dispose:)
			(disposeHintText doit:)
			(if (not (hintCode doit:))
				(self dispose:)
			)
			(= temp0 1)
		)
		(event claimed: temp0)
	)
)

(instance hintCode of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4)
		(= local6 (Str new:))
		(if (== local8 -1)
			(if (= temp0 (Message msgGET 8000 1 0 103 local7 (local6 data:)))
				(makeHintText doit: (local6 data:) 80 60 7)
			)
			(++ local7)
			(return temp0)
		)
		(= temp1 (+ 8000 (/ local8 100)))
		(= temp4 (Str format: {%d.msg} temp1))
		(if (not (FileIO fiEXISTS (temp4 data:)))
			(if (= temp0 (Message msgGET 8000 1 0 102 local7 (local6 data:)))
				(makeHintText doit: (local6 data:) 80 60 7)
				(++ local7)
				(return temp0)
			)
			(temp4 dispose:)
			(return temp0)
		)
		(temp4 dispose:)
		(= temp2
			(switch (/ local8 100)
				(0 98)
				(2 100)
				(3 99)
				(4 104)
				(5 107)
				(6 138)
				(7 131)
				(8 160)
				(9 161)
				(26 144)
				(27 132)
				(28 155)
				(36 139)
				(48 163)
				(53 101)
				(54 105)
				(65 108)
				(75 119)
				(98 162)
			)
		)
		(= temp3 (local5 at: (umod local8 100)))
		(if (= temp0 (Message msgGET temp1 1 temp2 temp3 local7 (local6 data:)))
			(makeHintText doit: (local6 data:) 80 60 7)
			(++ local7)
			(return temp0)
		)
		(if
			(and
				(== gCurRoomNum 700)
				(not (OneOf local8 216 242 243 257))
				(= temp0 (Message msgGET 8000 1 0 101 local7 (local6 data:)))
			)
			(makeHintText doit: (local6 data:) 80 60 7)
			(++ local7)
			(return temp0)
		)
		(if (= temp0 (Message msgGET 8000 1 0 102 local7 (local6 data:)))
			(makeHintText doit: (local6 data:) 80 60 7)
			(++ local7)
			(return temp0)
		)
		(return 0)
	)
)

(instance hintTextList of List
	(properties)
)

(instance hintDText of DText
	(properties)

	(method (dispose)
		(hintTextList delete: self)
		(super dispose: &rest)
	)
)

(instance makeHintText of Code
	(properties)

	(method (doit param1 param2 param3 param4)
		(hintTextList
			add:
				((hintDText new:)
					text: (KArray 8 param1) ; ArrayDup
					font: param4
					fore: 0
					back: -2
					x: (+ param2 2)
					y: (+ param3 2)
					setSize: 480
					setPri: 504
					init: ((hintPanel casts:) at: 0)
					yourself:
				)
				((hintDText new:)
					text: (KArray 8 param1) ; ArrayDup
					font: param4
					fore: 255
					back: -2
					x: param2
					y: param3
					setSize: 480
					setPri: 505
					init: ((hintPanel casts:) at: 0)
					yourself:
				)
		)
	)
)

(instance disposeHintText of Code
	(properties)

	(method (doit)
		(hintTextList dispose:)
	)
)

(instance ppOptions of PanelProp
	(properties
		priority 1
		fixPriority 1
		view 3055
	)

	(method (init)
		(super init: &rest)
		(if approachX
			(global105 delete: approachX)
			(approachX dispose:)
			(= approachX 0)
		)
	)

	(method (handleEvent event)
		(cond
			(
				(and
					(== (gUser curVerb:) 5)
					(self onMe: event)
					(not (== view 2055))
				)
				(if
					(or
						(gPanels contains: (ScriptID 9 4)) ; InvInset
						(gPanels contains: (ScriptID 271 0)) ; toolBoxPanel
						(gPanels contains: (ScriptID 19 1)) ; BombInset
					)
					(= view 3055)
					(= loop 1)
				else
					(= view 2055)
					(= loop 0)
				)
				(UpdateScreenItem self)
			)
			((and (not (self onMe: event)) (or (!= view 3055) (!= loop 0)))
				(= view 3055)
				(= loop 0)
				(UpdateScreenItem self)
			)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(proc9_92 1)
				(gGame hideCursor:)
				(controlPanel init:)
			)
		)
	)
)

(instance pvBorders of PanelView
	(properties
		view 1200
	)

	(method (init)
		(super init: &rest)
		(if approachX
			(global105 delete: approachX)
			(approachX dispose:)
			(= approachX 0)
		)
	)
)

(instance pvBagBorders of PanelView
	(properties
		view 1200
	)

	(method (init)
		(super init: &rest)
		(if approachX
			(global105 delete: approachX)
			(approachX dispose:)
			(= approachX 0)
		)
	)
)

(instance pfStriker of PanelFeature
	(properties)

	(method (init)
		(self createPoly: 68 82 89 82 89 107 68 107)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(invLighter state: 2)
				(InvInset setBitmap: 59 3 1)
				(invInsetItem
					setCel: 0
					setLoop: 1
					setCycle: End invLighter
					setPri: (+ (InvInset priority:) 1)
				)
				(invSound setLoop: 1 number: 15 play:)
				(self dispose: InvInset 1 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fWindUpKeyFeature of PanelFeature
	(properties)

	(method (init)
		(self createPoly: 49 109 122 109 122 149 49 149)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (and (>= (invInsetItem cel:) 6) (<= (invInsetItem cel:) 10))
					(invInsetItem setLoop: 1)
					(UpdateScreenItem invInsetItem)
					(gInventory addItem: invWindUpKey)
					(SetFlag 59)
					(self dispose:)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fUmbrellaFeature of PanelFeature
	(properties)

	(method (init)
		(if (invUmbrella state:)
			(self createPoly: 86 81 108 81 108 104 86 104)
		else
			(self createPoly: 37 150 55 149 57 166 42 173 33 163)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(if (invUmbrella state:)
					(invSound number: 5101 setLoop: 1 play:)
					(self setPolygon: 0)
					(self createPoly: 37 150 55 149 57 166 42 173 33 163)
					(invInsetItem setCycle: End invInsetItem)
				else
					(invSound number: 51 setLoop: 1 play:)
					(self setPolygon: 0)
					(self createPoly: 86 81 108 81 108 104 86 104)
					(invInsetItem setCycle: Beg invInsetItem)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pplFullLetterPlane of PanelPlane
	(properties
		picture 311
	)

	(method (handleEvent event)
		(cond
			((and (& (event type:) evMOUSEBUTTON) (self onMe: event))
				(event claimed: 1)
				(self dispose:)
			)
			((not (PlInterface onMe: event))
				(event claimed: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (init)
		(= gPplFullLetterPlane self)
		(proc9_92 1)
		(self removePanels: 1)
		(= priority (+ (GetHighPlanePri) 1))
		(super init: 70 75 569 374)
		(FrameOut)
		(gMySoundFX do: 52)
	)

	(method (dispose)
		(= gPplFullLetterPlane 0)
		(proc9_92 0)
		(self removePanels: 0)
		(super dispose: &rest)
	)
)

(class FullInsetPanelPlane of PanelPlane
	(properties
		picture -1
	)

	(method (handleEvent event)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(self onMe: event)
				(not (ppNotePage onMe: event))
			)
			(gMessager caller: 0 dispose:)
			(ppNotePage setScript: 0)
			(if (IsFlag 61)
				(gGame handsOff:)
				(invNotebook view: 2009 cel: 9 setCycle: Beg invNotebook)
			)
			(self dispose:)
		)
		(event claimed: 1)
	)

	(method (init)
		(proc9_92 1)
		(gMouseDownHandler addToFront: self)
		(= priority (+ (GetHighPlanePri) 1))
		(super init: 0 0 640 480)
	)

	(method (dispose)
		(proc9_92 0)
		(if (gMouseDownHandler contains: self)
			(gMouseDownHandler delete: self)
		)
		(super dispose: &rest)
	)
)

(instance ppNotePage of PanelProp
	(properties
		x 150
		y 20
	)
)

(instance sNoteBookSpeechDelay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= ticks 60)
			)
			(2
				(gMessager say: 1 0 0 register self 330)
			)
			(3
				(= cycles 1)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance pplStudyNotes of FullInsetPanelPlane
	(properties)

	(method (init)
		(gMessager caller: 0 dispose:)
		(= local0 0)
		(super init: &rest)
		(ppNotePage
			view: 4010
			init: self 1 1
			setScript: sNoteBookSpeechDelay 0 15
		)
		(gUser canInput: 1)
	)

	(method (dispose)
		(if local3
			(= local3 0)
			(gCurRoom setScript: sUpdateNotebook)
		)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if (and (& (event type:) evMOUSEBUTTON) (ppNotePage onMe: event))
			(if (and gTalkers (gTalkers contains: Narrator))
				(gMessager caller: 0 dispose:)
				(event claimed: 1)
				(return)
			)
			(switch local0
				(0
					(++ local0)
					(ppNotePage view: 4011 setScript: sNoteBookSpeechDelay 0 16)
				)
				(1
					(++ local0)
					(ppNotePage view: 4012 setScript: sNoteBookSpeechDelay 0 18)
				)
				(else
					(= local0 0)
					(ppNotePage dispose: self 1 1)
					(self dispose:)
				)
			)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
		)
	)
)

(instance pplBedroomNotes of FullInsetPanelPlane
	(properties)

	(method (init)
		(gMessager caller: 0 dispose:)
		(= local0 0)
		(super init: &rest)
		(ppNotePage
			view: 4023
			init: self 1 1
			setScript: sNoteBookSpeechDelay 0 8
		)
		(gUser canInput: 1)
	)

	(method (dispose)
		(if local3
			(= local3 0)
			(gCurRoom setScript: sUpdateNotebook)
		)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(ppNotePage onMe: event)
				(not (event claimed:))
			)
			(if (and gTalkers (gTalkers contains: Narrator))
				(gMessager caller: 0 dispose:)
				(event claimed: 1)
				(return)
			)
			(switch local0
				(0
					(++ local0)
					(ppNotePage view: 4024 setScript: sNoteBookSpeechDelay 0 9)
				)
				(1
					(++ local0)
					(ppNotePage view: 4025 setScript: sNoteBookSpeechDelay 0 10)
				)
				(else
					(= local0 0)
					(ppNotePage dispose: self 1 1)
					(self dispose:)
				)
			)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
		)
	)
)

(instance pplKitchenNotes of FullInsetPanelPlane
	(properties)

	(method (init)
		(gMessager caller: 0 dispose:)
		(= local0 0)
		(super init: &rest)
		(ppNotePage
			view: 4015
			init: self 1 1
			setScript: sNoteBookSpeechDelay 0 1
		)
		(gUser canInput: 1)
	)

	(method (dispose)
		(if local3
			(= local3 0)
			(gCurRoom setScript: sUpdateNotebook)
		)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if (and (& (event type:) evMOUSEBUTTON) (ppNotePage onMe: event))
			(if (and gTalkers (gTalkers contains: Narrator))
				(gMessager caller: 0 dispose:)
				(event claimed: 1)
				(return)
			)
			(switch local0
				(0
					(++ local0)
					(ppNotePage view: 4016 setScript: sNoteBookSpeechDelay 0 2)
				)
				(1
					(++ local0)
					(ppNotePage view: 4017 setScript: sNoteBookSpeechDelay 0 3)
				)
				(else
					(= local0 0)
					(ppNotePage dispose: self 1 1)
					(self dispose:)
				)
			)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
		)
	)
)

(instance pplLabNotes of FullInsetPanelPlane
	(properties)

	(method (init)
		(gMessager caller: 0 dispose:)
		(= local0 0)
		(super init: &rest)
		(ppNotePage
			view: 4026
			init: self 1 1
			setScript: sNoteBookSpeechDelay 0 11
		)
		(gUser canInput: 1)
	)

	(method (dispose)
		(if local3
			(= local3 0)
			(gCurRoom setScript: sUpdateNotebook)
		)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if (and (& (event type:) evMOUSEBUTTON) (ppNotePage onMe: event))
			(if (and gTalkers (gTalkers contains: Narrator))
				(gMessager caller: 0 dispose:)
				(event claimed: 1)
				(return)
			)
			(switch local0
				(0
					(++ local0)
					(ppNotePage view: 4027 setScript: sNoteBookSpeechDelay 0 12)
				)
				(1
					(++ local0)
					(ppNotePage view: 4028 setScript: sNoteBookSpeechDelay 0 13)
				)
				(2
					(++ local0)
					(ppNotePage view: 4029 setScript: sNoteBookSpeechDelay 0 14)
				)
				(3
					(++ local0)
					(ppNotePage view: 4013 setScript: sNoteBookSpeechDelay 0 19)
				)
				(4
					(++ local0)
					(ppNotePage view: 4014 setScript: sNoteBookSpeechDelay 0 20)
				)
				(else
					(= local0 0)
					(ppNotePage dispose: self 1 1)
					(self dispose:)
				)
			)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
		)
	)
)

(instance pplBottleNote of FullInsetPanelPlane
	(properties)

	(method (init)
		(gMessager caller: 0 dispose:)
		(super init: &rest)
		(ppNotePage view: 4438 init: self)
		(gUser canInput: 1)
	)

	(method (handleEvent event &tmp temp0)
		(if (& (event type:) evMOUSEBUTTON)
			(for ((= temp0 0)) (< temp0 (gPanels size:)) ((++ temp0))
				(if (not (OneOf (gPanels at: temp0) (ScriptID 9 1) self)) ; PlInterface
					((gPanels at: temp0) dispose:)
				)
			)
			(= global108 invBottleNote)
			(invBottleNote view: 2044)
			(invBottleNote setCursor:)
			(self dispose:)
		)
		(event claimed: 1)
	)
)

(instance pplBeingInBottle of PanelPlane
	(properties
		picture -1
	)

	(method (init)
		(= priority (+ (GetHighPlanePri) 1))
		(super init: 0 0 640 480)
		(WalkieTalkie plane: self)
		(= global102 ((WalkieTalkie new:) doRobot: 132 208 88 self 0 yourself:))
	)

	(method (handleEvent event &tmp temp0)
		(if (& (event type:) evMOUSEBUTTON)
			(DoRobot)
			(if (not gInsetPanelPlane)
				(= global108 invBeingInBottle)
				(invBeingInBottle view: 2028)
				(invBeingInBottle setCursor:)
			)
			(self cue:)
		)
		(event claimed: 1)
	)

	(method (cue)
		(WalkieTalkie plane: gThePlane)
		(self dispose:)
	)
)

(instance pplPlans of FullInsetPanelPlane
	(properties)

	(method (init)
		(gMessager caller: 0 dispose:)
		(super init: &rest)
		(ppNotePage view: 4031 x: 75 y: 30 init: self)
		(gUser canInput: 1)
	)

	(method (dispose)
		(ppNotePage x: 150 y: 20)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (& (event type:) evMOUSEBUTTON)
			(self dispose:)
		)
		(event claimed: 1)
	)
)

(instance invSound of Sound
	(properties)
)

(instance pvAntenna of PanelView
	(properties
		x 79
		y 4
		view 2039
		loop 10
	)
)

(class ppButtonProp of PanelProp
	(properties
		view 2039
	)

	(method (dispose)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gUser canInput: 0)
				(ppStatusScreen hide: setCycle: 0)
				(if cel
					(if (!= loop 4)
						(ppLeftButton cel: 0)
						(ppMiddleButton cel: 0)
						(ppRightButton cel: 0)
						(ppActivateButton cel: 0)
					)
					(self setCycle: Beg self)
				else
					(if (!= loop 4)
						(ppLeftButton cel: 0)
						(ppMiddleButton cel: 0)
						(ppRightButton cel: 0)
						(ppActivateButton cel: 0)
					)
					(self setCycle: End self)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(switch loop
			(1
				(if (and cel (IsFlag 312))
					(gMySoundFX number: 44007 setLoop: 0 play:)
					(ppStatusScreen loop: 5 show:)
				)
			)
			(2
				(if (and cel (IsFlag 312))
					(gMySoundFX number: 44008 setLoop: 0 play:)
					(ppStatusScreen loop: 6 show:)
				)
			)
			(3
				(if (and cel (IsFlag 312))
					(gMySoundFX number: 44009 setLoop: 0 play:)
					(ppStatusScreen loop: 7 show:)
				)
			)
			(4
				(if (and (== (ppLeftButton cel:) 1) (== (gCurRoom scene:) 497))
					(gCurRoom notify:)
				)
				(if (and (!= (ppMiddleButton cel:) 0) (== gCurRoomNum 510))
					(gCurRoom notify:)
				)
				(if (and cel (not local1))
					(gGame handsOff:)
					(= local1 1)
					(IsFlag 312)
					(cond
						((== (ppLeftButton cel:) 1)
							(gMySoundFX number: 44010 setLoop: 0 play:)
						)
						((== (ppMiddleButton cel:) 1)
							(gMySoundFX number: 44011 setLoop: 0 play:)
						)
						((== (ppRightButton cel:) 1)
							(gMySoundFX number: 44012 setLoop: 0 play:)
						)
					)
					(ppStatusScreen
						loop: 8
						show:
						setCycle: ForwardCounter 5 self
					)
				else
					(= local1 0)
					(ppLeftButton cel: 0)
					(ppMiddleButton cel: 0)
					(ppRightButton cel: 0)
					(ppActivateButton cel: 0)
					(gGame handsOn:)
				)
			)
		)
		(gUser canInput: 1)
	)
)

(instance ppLeftButton of ppButtonProp
	(properties
		x 49
		y 105
		loop 1
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
		(global105 delete: approachX)
		(global105 addToFront: approachX)
	)
)

(instance ppMiddleButton of ppButtonProp
	(properties
		x 80
		y 120
		loop 2
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
		(global105 delete: approachX)
		(global105 addToFront: approachX)
	)
)

(instance ppRightButton of ppButtonProp
	(properties
		x 109
		y 105
		loop 3
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
		(global105 delete: approachX)
		(global105 addToFront: approachX)
	)
)

(instance ppActivateButton of ppButtonProp
	(properties
		x 87
		y 90
		loop 4
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
		(global105 delete: approachX)
		(global105 addToFront: approachX)
	)
)

(instance ppStatusScreen of ppButtonProp
	(properties
		x 57
		y 152
		loop 5
	)

	(method (doVerb))
)

(instance ppViewScreen of ppButtonProp
	(properties
		x 69
		y 84
		loop 9
	)

	(method (doVerb))
)

(instance ppWhistleDial of PanelProp
	(properties
		x 24
		y 173
		view 5491
		loop 1
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
		(global105 delete: approachX)
		(global105 addToFront: approachX)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(self
					setCel:
						(if (== cel 12)
							0
						else
							(+ cel 1)
						)
				)
				(= global256 cel)
				(ppWhistleIndicator setCel: (/ global256 2))
				(invSound stop: number: 44905 setLoop: 1 play:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pfWhistleBut of PanelFeature
	(properties
		x 138
		y 106
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 130 98 130 115 146 115 146 98
					yourself:
				)
		)
		(super init: &rest)
		(approachX hotVerbs: 5)
		(global105 delete: approachX)
		(global105 addToFront: approachX)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if
					(and
						(== (invInsetItem cel:) 0)
						(not (invInsetItem cycler:))
					)
					(cond
						((< (ppWhistleDial cel:) 2)
							(invSound stop: number: 44906 setLoop: 1 play:)
						)
						((< (ppWhistleDial cel:) 4)
							(invSound stop: number: 449 setLoop: 1 play:)
						)
						((< (ppWhistleDial cel:) 6)
							(invSound stop: number: 44901 setLoop: 1 play:)
						)
						((< (ppWhistleDial cel:) 8)
							(invSound stop: number: 44902 setLoop: 1 play:)
						)
						((< (ppWhistleDial cel:) 10)
							(invSound stop: number: 44903 setLoop: 1 play:)
						)
						((< (ppWhistleDial cel:) 12)
							(invSound stop: number: 44904 setLoop: 1 play:)
						)
						(
							(and
								(OneOf
									gCurRoomNum
									400
									440
									441
									447
									470
									480
									490
									500
									510
								)
								(== global232 710)
								(IsFlag 224)
							)
							(= global232 500)
							(= global228 0)
							(ClearFlag 232)
							(InvInset dispose:)
							(if (== gCurRoomNum 500)
								(gCurRoom notify:)
							else
								(proc0_8 6516)
							)
						)
						(
							(and
								(OneOf
									gCurRoomNum
									710
									715
									720
									730
									740
									750
									760
									765
									770
									780
								)
								(== global232 500)
								(IsFlag 224)
							)
							(= global232 710)
							(InvInset dispose:)
							(if (== gCurRoomNum 710)
								(gCurRoom notify:)
							)
							(proc0_8 6518)
						)
					)
				else
					(invInsetItem doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance ppWhistleIndicator of PanelProp
	(properties
		x 24
		y 173
		view 5491
		loop 2
	)
)

(instance sUpdateNotebook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if
					(and
						(!= (gInventory at: 1) invNotebook)
						(!= (gInventory at: 2) invNotebook)
						(!= (gInventory at: 3) invNotebook)
						(!= (gInventory at: 4) invNotebook)
					)
					(gInventory deleteItem: invNotebook)
					(gInventory addItem: invNotebook)
				)
				(invNotebook view: 2009 cel: 0 setCycle: End self)
			)
			(1
				(invNotebook cel: 0 loop: 1 setCycle: End self)
			)
			(2
				(invNotebook cel: 9 loop: 0 setCycle: Beg self)
			)
			(3
				(invNotebook view: 3015 cel: 0)
				(if (< (gInventory indexOf: invNotebook) (gInventory indexOf: invBag))
					(UpdateScreenItem invNotebook)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pplNotebook of FullInsetPanelPlane
	(properties)

	(method (handleEvent event)
		(if (and (& (event type:) evMOUSEBUTTON) (ppNotePage onMe: event))
			(if (and gTalkers (gTalkers contains: Narrator))
				(gMessager caller: 0 dispose:)
				(event claimed: 1)
				(return)
			)
			(ppNotePage setScript: 0)
			(cond
				((== (local4 at: 1) 1)
					(local4 at: 1 0)
					(ppNotePage view: 4016 setScript: sNoteBookSpeechDelay 0 2)
				)
				((== (local4 at: 2) 1)
					(local4 at: 2 0)
					(ppNotePage view: 4017 setScript: sNoteBookSpeechDelay 0 3)
				)
				((== (local4 at: 3) 1)
					(local4 at: 3 0)
					(ppNotePage view: 4018 setScript: sNoteBookSpeechDelay 0 4)
				)
				((== (local4 at: 4) 1)
					(local4 at: 4 0)
					(ppNotePage view: 4019 setScript: sNoteBookSpeechDelay 0 5)
				)
				((== (local4 at: 5) 1)
					(local4 at: 5 0)
					(ppNotePage view: 4020)
				)
				((== (local4 at: 6) 1)
					(local4 at: 6 0)
					(ppNotePage view: 4021 setScript: sNoteBookSpeechDelay 0 6)
				)
				((== (local4 at: 7) 1)
					(local4 at: 7 0)
					(ppNotePage view: 4022 setScript: sNoteBookSpeechDelay 0 7)
				)
				((== (local4 at: 8) 1)
					(local4 at: 8 0)
					(ppNotePage view: 4023 setScript: sNoteBookSpeechDelay 0 8)
				)
				((== (local4 at: 9) 1)
					(local4 at: 9 0)
					(ppNotePage view: 4024 setScript: sNoteBookSpeechDelay 0 9)
				)
				((== (local4 at: 10) 1)
					(local4 at: 10 0)
					(ppNotePage view: 4025 setScript: sNoteBookSpeechDelay 0 10)
				)
				((== (local4 at: 11) 1)
					(local4 at: 11 0)
					(ppNotePage view: 4026 setScript: sNoteBookSpeechDelay 0 11)
				)
				((== (local4 at: 12) 1)
					(local4 at: 12 0)
					(ppNotePage view: 4027 setScript: sNoteBookSpeechDelay 0 12)
				)
				((== (local4 at: 13) 1)
					(local4 at: 13 0)
					(ppNotePage view: 4028 setScript: sNoteBookSpeechDelay 0 13)
				)
				((== (local4 at: 14) 1)
					(local4 at: 14 0)
					(ppNotePage view: 4029 setScript: sNoteBookSpeechDelay 0 14)
				)
				((== (local4 at: 15) 1)
					(local4 at: 15 0)
					(ppNotePage view: 4010 setScript: sNoteBookSpeechDelay 0 15)
				)
				((== (local4 at: 16) 1)
					(local4 at: 16 0)
					(ppNotePage view: 4011 setScript: sNoteBookSpeechDelay 0 16)
				)
				((== (local4 at: 17) 1)
					(local4 at: 17 0)
					(ppNotePage view: 4012 setScript: sNoteBookSpeechDelay 0 18)
				)
				((== (local4 at: 18) 1)
					(local4 at: 18 0)
					(ppNotePage view: 4013 setScript: sNoteBookSpeechDelay 0 19)
				)
				((== (local4 at: 19) 1)
					(local4 at: 19 0)
					(ppNotePage view: 4014 setScript: sNoteBookSpeechDelay 0 20)
				)
				(else
					(self dispose:)
				)
			)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
		)
	)

	(method (init)
		(gMessager caller: 0 dispose:)
		(super init: &rest)
		(= local4 (IntArray with: 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0))
		(if (IsFlag 66)
			(local4 at: 0 1)
			(local4 at: 1 1)
			(local4 at: 2 1)
		)
		(local4 at: 3 1)
		(local4 at: 4 1)
		(local4 at: 5 1)
		(local4 at: 6 1)
		(local4 at: 7 1)
		(if (IsFlag 65)
			(local4 at: 8 1)
			(local4 at: 9 1)
			(local4 at: 10 1)
		)
		(if (IsFlag 67)
			(local4 at: 11 1)
			(local4 at: 12 1)
			(local4 at: 13 1)
			(local4 at: 14 1)
			(local4 at: 18 1)
			(local4 at: 19 1)
		)
		(if (IsFlag 64)
			(local4 at: 15 1)
			(local4 at: 16 1)
			(local4 at: 17 1)
		)
		(if (== (local4 at: 0) 1)
			(local4 at: 0 0)
			(ppNotePage
				view: 4015
				init: self 1 1
				setScript: sNoteBookSpeechDelay 0 1
			)
		else
			(local4 at: 3 0)
			(ppNotePage
				view: 4018
				init: self 1 1
				setScript: sNoteBookSpeechDelay 0 4
			)
		)
		(gUser canInput: 1)
	)

	(method (dispose)
		(gGame handsOff:)
		(local4 dispose:)
		(gMessager caller: 0 dispose:)
		(invNotebook view: 2009 cel: 9 setCycle: Beg invNotebook)
		(super dispose: &rest)
	)
)

(instance soldierCuee of Script
	(properties)

	(method (cue)
		(fWindUpKeyFeature init: InvInset 1 1)
	)
)

(instance amandaSound of Sound
	(properties)
)

(instance brightSound of Sound
	(properties)
)

