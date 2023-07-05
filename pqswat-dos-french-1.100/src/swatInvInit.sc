;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use Sound)
(use Actor)
(use System)

(public
	swatInvInit 0
	proc19_1 1
	addToInv 2
	proc19_3 3
)

(procedure (proc19_1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17)
	(= temp2 gInventory)
	(= temp12 (Set new:))
	(= temp13 0)
	(= temp5 (= temp4 (= temp1 0)))
	(= temp0 36)
	(= temp9 419)
	(= temp10 61)
	(for ((= temp3 0)) (< temp3 (temp2 size:)) ((++ temp3))
		(= temp8 (temp2 at: temp3))
		(if (not (temp8 isKindOf: PQInvItem))
			(break)
		)
		(= temp6 (CelWide (temp8 view:) (temp8 loop:) (temp8 cel:)))
		(= temp7 (CelHigh (temp8 view:) (temp8 loop:) (temp8 cel:)))
		(if
			(and
				temp4
				(or (> temp4 2) (> (+ temp0 temp6 18) (+ (* temp9 temp5) 388)))
			)
			(= temp16 (/ (- 352 temp13) (+ temp4 1)))
			(= temp17 (+ (* temp9 temp5) 36))
			(for ((= temp15 0)) (< temp15 (temp12 size:)) ((++ temp15))
				(= temp14 (temp12 at: temp15))
				(temp14 x: (+ temp17 temp16))
				(+=
					temp17
					(+
						temp16
						(CelWide (temp14 view:) (temp14 loop:) (temp14 cel:))
					)
				)
			)
			(= temp13 0)
			(temp12 release:)
			(= temp4 0)
			(++ temp5)
		)
		(+= temp13 temp6)
		(if (not temp4)
			(= temp0 (* temp5 temp9))
			(temp8 x: (+ temp0 36))
			(+= temp0 (+ 36 temp6))
		else
			(temp8 x: (+ temp0 18))
			(+= temp0 (+ 18 temp6))
		)
		(if (!= (gSwatInterface curInvLevel:) 1)
			(temp8 y: (+ (/ (- temp10 temp7) 2) 2 (* 1 temp10)))
		)
		(++ temp4)
		(temp12 add: temp8)
	)
	(temp12 release: dispose:)
	(gSwatInterface numInvPages: temp5 curInvPage: 0 nextInvPage: 0)
)

(procedure (proc19_3 param1)
	(return
		(switch param1
			(0 govt45)
			(2 gasMask)
			(3 mp5)
			(4 gauge12)
			(5 gauge12Buck)
			(6 gauge12Slug)
			(7 JHP45Mag)
			(8 FMJ45Mag)
			(9 STHP9Mag)
			(10 FMJ9Mag)
			(11 flashBang)
			(12 mirrorOnStick)
			(13 batteringRam)
			(14 robar308)
			(15 federal308)
			(16 gasGun)
			(17 gasRound)
			(18 gasGrenade)
			(19 ghilleSuit)
			(20 dopeBook)
			(21 m16)
			(22 m16_223)
			(else 0)
		)
	)
)

(instance swatInvInit of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(= temp0 global108)
		(if argc
			(= temp0 param1)
		)
		(= gInventory gInventoryCast)
		(if (gInventory size:)
			(gInventory eachElementDo: #perform removeInvItems)
		)
		(cond
			((== temp0 2)
				(gInventory
					addToFront:
						mp5
						STHP9Mag
						FMJ9Mag
						govt45
						JHP45Mag
						FMJ45Mag
						flashBang
						gasMask
						mirrorOnStick
				)
			)
			((== temp0 3)
				(gInventory
					addToFront:
						gauge12
						gauge12Buck
						gauge12Slug
						govt45
						JHP45Mag
						FMJ45Mag
						flashBang
						gasMask
				)
			)
			((OneOf temp0 4 5)
				(gInventory
					addToFront:
						m16
						m16_223
						govt45
						JHP45Mag
						FMJ45Mag
						flashBang
						gasMask
				)
			)
			((== temp0 6)
				(gInventory
					addToFront:
						mp5
						STHP9Mag
						FMJ9Mag
						govt45
						JHP45Mag
						FMJ45Mag
						flashBang
						gasMask
				)
			)
			((== temp0 7)
				(gInventory
					addToFront: dopeBook federal308 govt45 JHP45Mag FMJ45Mag
				)
			)
			((OneOf temp0 1)
				(gInventory addToFront: robar308 federal308 govt45 dopeBook)
			)
			((OneOf temp0 0)
				(gInventory
					addToFront:
						govt45
						JHP45Mag
						FMJ45Mag
						mp5
						STHP9Mag
						FMJ9Mag
						m16
						m16_223
						gauge12
						gauge12Buck
						gauge12Slug
						flashBang
						gasMask
						mirrorOnStick
						batteringRam
				)
			)
		)
		(if (gInventory size:)
			(proc19_1)
			(gInventory eachElementDo: #init gInventory)
		)
	)
)

(instance addToInv of Code
	(properties)

	(method (doit param1 param2 &tmp temp0 temp1 temp2)
		(if (not (= temp0 (proc19_3 param1)))
			(return)
		)
		(if (or (< argc 2) (not param2))
			(gInventory add: temp0)
		else
			(gInventory delete: temp0)
		)
		(DeleteScreenItem temp0)
		(= temp1 (gSwatInterface setInvPage: 0))
		(proc19_1)
		(if (!= (gSwatInterface numInvPages:) temp1)
			(gSwatInterface nextInvPage: (- temp1 (gSwatInterface numInvPages:)))
		)
		(for ((= temp2 0)) (< temp2 (gInventoryCast size:)) ((++ temp2))
			(UpdateScreenItem (gInventoryCast at: temp2))
		)
		(UpdatePlane gInventoryPlane)
		(FrameOut)
	)
)

(class InvData of Obj
	(properties
		evtHandler 0
		numAllowed 0
		numLeft 0
	)

	(method (setNumAllowed param1)
		(= numAllowed param1)
	)

	(method (reset)
		(= numLeft numAllowed)
	)

	(method (new param1 &tmp temp0)
		(if (= temp0 (super new:))
			(if argc
				(temp0 setNumAllowed: param1)
			)
			(temp0 reset:)
		)
		(return temp0)
	)
)

(class GunData of Obj
	(properties
		evtHandler 0
		numRounds 0
		roundsLeft 0
		storeExtra 0
		weaponSetting 0
		bulletType 0
		reloadSnd 0
	)

	(method (reload param1)
		(= bulletType 2)
		(if argc
			(= bulletType param1)
		)
		(= roundsLeft (+ numRounds storeExtra))
		(if (and (gSwatInterface curInvItem:) (not ((gSwatInterface curInvItem:) data:)))
			(gSwatInterface replaceInvItem:)
		)
		(if reloadSnd
			(gunSound number: reloadSnd loop: 0 play:)
		)
	)

	(method (new param1 &tmp temp0)
		(if (and (= temp0 (super new:)) argc)
			(temp0 numRounds: [param1 0])
			(if (> argc 1)
				(temp0 storeExtra: [param1 1])
			)
		)
		(return temp0)
	)
)

(class PQInvItem of View
	(properties
		verb 1
		owner 0
		cView 0
		cLoop 1
		cCel 0
		enabled 0
		data 0
	)

	(method (enable param1)
		(if (and argc (not param1))
			(= enabled 0)
		else
			(= enabled 1)
		)
	)

	(method (dispose)
		(if data
			(data dispose: self)
		)
		(super dispose:)
	)

	(method (init)
		(self setPri: 50 ignoreActors: 1 enable: 1)
		(super init: &rest)
		(&= signal $efff)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(not (IsFlag 72))
					(& (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(event claimed: 1)
				(if (== (event message:) $001d)
					(gCurRoom getInvItem: verb)
				)
				(self doVerb: (event message:))
			)
		)
		(event claimed:)
	)

	(method (doVerb theVerb)
		(if (and enabled (== theVerb 29) (not (& signal $0008)))
			(self hide:)
			(gSwatInterface setInvItem: self)
		else
			(gGame pragmaFail:)
			(return 1)
		)
	)

	(method (isMyVerb param1)
		(return (== verb param1))
	)

	(method (moveTo param1)
		(= owner param1)
		(return self)
	)

	(method (ownedBy param1)
		(return (== owner param1))
	)

	(method (onMe)
		(if (IsFlag 12)
			(return (super onMe: &rest))
		else
			(return 0)
		)
	)

	(method (displayItem)
		(self show:)
	)
)

(instance govt45 of PQInvItem
	(properties
		view 23
		verb 6
		cView 22
	)

	(method (init)
		(super init: &rest)
		((= data (GunData new: 8 1))
			evtHandler: EHGovt45
			weaponSetting: 1
			reloadSnd: 57
		)
	)

	(method (doVerb theVerb)
		(if (== gCurRoomNum 1501)
			(if (not (gTalkers size:))
				(gMessager say: 1 2 83 0 0 1500) ; "Pup, this is no time to finger your sidearm. Scope the building."
			)
		else
			(switch theVerb
				(35
					(data reload: 2)
				)
				(36
					(data reload: 1)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance gasMask of PQInvItem
	(properties
		view 35
		verb 14
		cView 35
	)
)

(instance mp5 of PQInvItem
	(properties
		view 25
		verb 7
		cView 25
	)

	(method (init)
		(super init: &rest)
		((= data (GunData new: 30)) evtHandler: EHMP5 reloadSnd: 58)
	)

	(method (dispose)
		(= cel 0)
		(super dispose:)
	)

	(method (show)
		(if global139
			(= global139 0)
			(gunSound stop:)
		)
		(super show: &rest)
	)

	(method (displayItem)
		(if (and (gCurRoom inset:) (== (gCurRoom inset:) (ScriptID 27 0))) ; mp5Selector
			((ScriptID 27 0) dispose:) ; mp5Selector
		)
		(super displayItem:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(super doVerb: theVerb)
				(if (and (not (IsFlag 110)) (not (gCurRoom inset:)))
					(gCurRoom setInset: (ScriptID 27) 0 0 1) ; mp5Selector
				)
			)
			(52
				(= cel 1)
				(data reload: 2)
				(UpdateScreenItem self)
			)
			(53
				(= cel 1)
				(data reload: 1)
				(UpdateScreenItem self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance m16 of PQInvItem
	(properties
		view 50
		verb 10
		cView 50
	)

	(method (init)
		(super init: &rest)
		((= data (GunData new: 30))
			evtHandler: EHM16
			weaponSetting: 1
			reloadSnd: 58
		)
	)

	(method (dispose)
		(= cel 0)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(19
				(= cel 1)
				(data reload: 1)
				(UpdateScreenItem self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gauge12 of PQInvItem
	(properties
		view 26
		verb 8
		cView 26
	)

	(method (init)
		(super init: &rest)
		((= data (GunData new: 7 1))
			evtHandler: EH12Gauge
			weaponSetting: 1
			reloadSnd: 59
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(39
				(data reload: 4)
			)
			(38
				(data reload: 3)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gauge12Buck of PQInvItem
	(properties
		view 27
		verb 38
		cView 27
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8
				((gauge12 data:) reload: 3)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gauge12Slug of PQInvItem
	(properties
		view 28
		verb 39
		cView 28
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8
				((gauge12 data:) reload: 4)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance m16_223 of PQInvItem
	(properties
		view 51
		verb 19
		cView 51
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(m16 cel: 1)
				((m16 data:) reload: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance JHP45Mag of PQInvItem
	(properties
		view 29
		verb 35
		cView 29
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				((govt45 data:) reload: 2)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance FMJ45Mag of PQInvItem
	(properties
		view 30
		verb 36
		cView 30
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				((govt45 data:) reload: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance STHP9Mag of PQInvItem
	(properties
		view 31
		verb 52
		cView 31
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(mp5 cel: 1)
				((mp5 data:) reload: 2)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance FMJ9Mag of PQInvItem
	(properties
		view 32
		verb 53
		cView 32
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(mp5 cel: 1)
				((mp5 data:) reload: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance flashBang of PQInvItem
	(properties
		view 34
		verb 16
		cView 34
	)

	(method (init)
		(super init: &rest)
		((= data (InvData new: 4)) evtHandler: EHFlashBang)
	)
)

(instance mirrorOnStick of PQInvItem
	(properties
		view 36
		verb 40
		cView 36
	)
)

(instance batteringRam of PQInvItem
	(properties
		view 37
		verb 41
		cView 37
	)
)

(instance robar308 of PQInvItem
	(properties
		view 38
		verb 25
		cView 38
		cCel 1
	)

	(method (init)
		(super init: &rest)
		((= data (GunData new: 5)) evtHandler: EHRobar308 weaponSetting: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(27
				(data reload: 1)
			)
			(else
				(if (== gCurRoomNum 320)
					(gCurRoom newRoom: 325)
					(self hide:)
				else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance federal308 of PQInvItem
	(properties
		view 40
		verb 27
		cView 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25
				((robar308 data:) reload: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gasGun of PQInvItem
	(properties
		view 42
		verb 28
		cView 42
	)

	(method (init)
		(super init: &rest)
		((= data (GunData new: 1)) evtHandler: EHGasGun)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(31
				(data reload: 5)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gasRound of PQInvItem
	(properties
		view 43
		verb 31
		cView 43
	)
)

(instance gasGrenade of PQInvItem
	(properties
		view 44
		verb 32
		cView 44
	)

	(method (init)
		(super init: &rest)
		((= data (InvData new: 4)) evtHandler: EHGasGrenade)
	)
)

(instance ghilleSuit of PQInvItem
	(properties
		view 45
		verb 33
		cView 45
	)
)

(instance dopeBook of PQInvItem
	(properties
		view 46
		verb 34
		cView 999
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(if (not (gCurRoom inset:))
					(self hide:)
					(gCurRoom setInset: (ScriptID 45) 0 0 1) ; dopeBook
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(class GunHandler of EventHandler
	(properties
		totalShots 0
		techLevel 20
		maxXRecoil 12
		maxYRecoil 8
	)

	(method (dryFire))

	(method (firedShot))

	(method (adjustProjectile))

	(method (recoil &tmp temp0 temp1)
		(= temp0 (/ (* maxXRecoil 75) 100))
		(= temp1 (/ (* maxXRecoil 75) 100))
		(if (Random 0 1)
			(SetCursor
				(- gMouseX (Random temp0 maxXRecoil))
				(- gMouseY (Random temp1 maxYRecoil))
			)
		else
			(SetCursor
				(+ gMouseX (Random temp0 maxXRecoil))
				(- gMouseY (Random temp1 maxYRecoil))
			)
		)
		(if (and (IsFlag 71) (> (++ totalShots) techLevel))
			(= totalShots 0)
			(= maxXRecoil (Max 2 (- maxXRecoil 1)))
			(= maxYRecoil (Max 2 (- maxYRecoil 1)))
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if
			(and
				global139
				(or (& (event type:) evMOUSERELEASE) (not (gGame isHandsOn:)))
			)
			(= global139 0)
			(gunSound stop:)
			(if gMyAutoEventCode
				(gMyAutoEventCode doit:)
			)
			(event claimed: 1)
			(return)
		)
		(if
			(or
				(not (gThePlane onMe: event))
				(not (gGame isHandsOn:))
				(and
					(not (IsFlag 110))
					(== (((gSwatInterface curInvItem:) data:) weaponSetting:) 0)
					(event claimed: 1)
				)
				(and global114 (not (global114 doit: event)))
			)
			(return)
		)
		(if (not (= temp0 (((gSwatInterface curInvItem:) data:) roundsLeft:)))
			(self dryFire:)
			(if (and global139 gMyAutoEventCode)
				(gMyAutoEventCode doit:)
			)
			(= global139 0)
			(event claimed: 1)
			(return)
		)
		(((gSwatInterface curInvItem:) data:) roundsLeft: (- temp0 1))
		(self firedShot:)
		(self adjustProjectile: event)
		(self recoil:)
		(if global133
			(global133 doit: event)
		)
		(if (not (((gSwatInterface curInvItem:) data:) roundsLeft:))
			(= temp1 (gSwatInterface curInvItem:))
			((temp1 data:) bulletType: 0)
			(if (OneOf temp1 mp5 m16)
				(temp1 cel: 0)
				(if (temp1 isNotHidden:)
					(UpdateScreenItem temp1)
				)
			)
		)
		(event claimed: 0)
	)
)

(instance EHGovt45 of GunHandler
	(properties)

	(method (dryFire)
		(gunSound number: 47 loop: 0 play:)
	)

	(method (firedShot)
		(if (!= gCurRoomNum 197)
			(DoAudio 18 1) ; AudDACCritical
			(gunSound number: 50 setLoop: 0 play:)
			(DoAudio 18 0) ; AudDACCritical
		)
	)
)

(instance EHM16 of GunHandler
	(properties)

	(method (dryFire)
		(gunSound number: 48 loop: 0 play:)
	)

	(method (firedShot)
		(DoAudio 18 1) ; AudDACCritical
		(if (IsFlag 126)
			(gunSound number: 2994 setLoop: 0 play:)
		else
			(gunSound number: 43 setLoop: 0 play:)
		)
		(DoAudio 18 0) ; AudDACCritical
	)
)

(instance EHMP5 of GunHandler
	(properties)

	(method (dryFire)
		(gunSound number: 48 loop: 0 play:)
	)

	(method (firedShot)
		(DoAudio 18 1) ; AudDACCritical
		(if (== (((gSwatInterface curInvItem:) data:) weaponSetting:) 2)
			(if (not global139)
				(= global139 1)
				(gunSound number: 53 setLoop: 0 play:)
			)
		else
			(gunSound number: 51 setLoop: 0 play:)
		)
		(DoAudio 18 0) ; AudDACCritical
	)
)

(instance EH12Gauge of GunHandler
	(properties)

	(method (dryFire)
		(gunSound number: 49 loop: 0 play:)
	)

	(method (firedShot)
		(DoAudio 18 1) ; AudDACCritical
		(gunSound number: 56 setLoop: 0 play:)
		(DoAudio 18 0) ; AudDACCritical
	)
)

(instance EHRobar308 of GunHandler
	(properties)

	(method (handleEvent event)
		(super handleEvent: event &rest)
		(if (OneOf gCurRoomNum 325 1501)
			((ScriptID 45) update:) ; dopeBook
		)
	)
)

(instance EHRobar223 of GunHandler ; UNUSED
	(properties)
)

(instance EHGasGun of GunHandler
	(properties)
)

(class ThrownHandler of EventHandler
	(properties)

	(method (throwObj))

	(method (handleEvent event &tmp temp0)
		(if (== (= temp0 (((gSwatInterface curInvItem:) data:) numLeft:)) 0)
			(event claimed: 1)
			(return)
		)
		(self throwObj:)
		(if (and (not (IsFlag 110)) (!= global108 0))
			(((gSwatInterface curInvItem:) data:) numLeft: (- temp0 1))
			(if (!= (= temp0 (((gSwatInterface curInvItem:) data:) numLeft:)) 0)
				(gSwatInterface replaceInvItem:)
			else
				(gInventory delete: (gSwatInterface curInvItem:))
				(gSwatInterface curIcon: 0 curInvItem: 0)
				(gSwatInterface setCursor:)
			)
		)
		(event claimed: 0)
	)
)

(instance EHFlashBang of ThrownHandler
	(properties)
)

(instance EHGasGrenade of ThrownHandler
	(properties)
)

(instance removeInvItems of Code
	(properties)

	(method (doit param1)
		(if (param1 isKindOf: PQInvItem)
			(param1 dispose:)
		)
	)
)

(instance gunSound of Sound
	(properties
		flags 5
	)
)

