;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 77)
(include sci.sh)
(use Main)
(use swatInvInit)
(use Osc)
(use System)

(public
	drillManager 0
	do45Drill 1
	doMP5Drill 2
	doShotgunDrill 3
	closeUpList 4
	doM16Drill 5
)

(local
	local0 = 1
	local1
)

(instance drillManager of Code
	(properties)

	(method (doit)
		(if (gCast contains: (ScriptID gCurRoomNum 14))
			((ScriptID gCurRoomNum 14) dispose:)
		)
		((ScriptID gCurRoomNum 11) init:)
		(Lock rsAUDIO 68 1)
		(Lock rsAUDIO 69 1)
		(Lock rsAUDIO 70 1)
		(cond
			((IsFlag 35)
				(Lock rsAUDIO 60 1)
				(Lock rsAUDIO 61 1)
				(Lock rsAUDIO 62 1)
				(if global134
					(do45Drill start: 2)
				else
					(gMessager say: 5 0 4 0 do45Drill 210) ; "Officers, with your sidearms... Make Ready!"
				)
				(gCurRoom setScript: do45Drill)
			)
			((IsFlag 37)
				(Lock rsAUDIO 63 1)
				(Lock rsAUDIO 64 1)
				(Lock rsAUDIO 65 1)
				(if global134
					(doMP5Drill start: 2)
				else
					(gMessager say: 5 0 2 0 doMP5Drill 210) ; "Officers, with your MP5's... Make Ready!"
				)
				(gCurRoom setScript: doMP5Drill)
			)
			((IsFlag 39)
				(Lock rsAUDIO 68 1)
				(Lock rsAUDIO 69 1)
				(Lock rsAUDIO 70 1)
				(if global134
					(doShotgunDrill start: 2)
				else
					(gMessager say: 5 0 3 0 doShotgunDrill 210) ; "Officers, with your shotguns... Make Ready!"
				)
				(gCurRoom setScript: doShotgunDrill)
			)
			((IsFlag 115)
				(Lock rsAUDIO 63 1)
				(Lock rsAUDIO 64 1)
				(Lock rsAUDIO 65 1)
				(if global134
					(doM16Drill start: 2)
				else
					(gMessager say: 5 0 15 0 doM16Drill 210) ; "Officers, with your M16's, make ready!"
				)
				(gCurRoom setScript: doM16Drill)
			)
		)
	)
)

(class DrillScript of Script
	(properties
		theCase 0
		invItemId 0
		bulletType 0
		limitCursor 0
		ammoWarnings 0
		timeToLoad 0
		reprimandCnt 0
		resetScript 0
		sameShotAmmo 0
	)

	(method (checkGun)
		(return (== (gSwatInterface curInvItem:) (proc19_3 invItemId)))
	)

	(method (wrongGun)
		(return 0)
	)

	(method (setCase)
		(= theCase 0)
	)

	(method (getShotsAllowed)
		(return 0)
	)

	(method (setParTime)
		(return 0)
	)

	(method (backgroundFire)
		(return 0)
	)

	(method (noAmmo)
		(++ ammoWarnings)
	)

	(method (replaceGun)
		(return 0)
	)

	(method (selectGun)
		(return 0)
	)

	(method (checkSettings)
		(return 0)
	)

	(method (reprimand)
		(if (> (++ reprimandCnt) 2)
			(gGame handsOff:)
			(self start: 1 reprimandCnt: 0 seconds: 0 cycles: 0 ticks: 0)
			(gCurRoom setScript: reprimandScr 0 self)
		)
		(return reprimandCnt)
	)

	(method (nonWeapon)
		(self start: 1 seconds: 0 cycles: 0 ticks: 0)
		(if (gCast contains: (ScriptID 50 0)) ; PactTimer
			((ScriptID 50 0) caller: 0 clearClock: 1 stopDrillTimer:) ; PactTimer
		)
		(gCurRoom setScript: nonWeaponScript 0 self)
	)

	(method (doResetScript)
		(self start: 1 seconds: 0 cycles: 0 ticks: 0 sameShotAmmo: 1)
		(gCurRoom setScript: resetScript 0 self)
	)

	(method (dispose)
		(= global133 0)
		(super dispose: &rest)
	)

	(method (doit)
		(super doit:)
		(if (and limitCursor (< gMouseY limitCursor))
			(SetCursor gMouseX limitCursor)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0 0)
			(1
				(gGame handsOff:)
				(= timeToLoad 0)
				((ScriptID 50 0) caller: 0 stopDrillTimer:) ; PactTimer
				(= cycles 1)
			)
			(2
				(= global133 0)
				(= global135 0)
				(if (gCast contains: (ScriptID gCurRoomNum 14))
					((ScriptID gCurRoomNum 14) dispose:)
				)
				(if ((ScriptID gCurRoomNum 12) size:)
					((ScriptID gCurRoomNum 12) dispose:)
					((ScriptID gCurRoomNum 11) setCycle: Osc 1 self)
				else
					(= cycles 1)
				)
			)
			(3
				((ScriptID 50 0) clearClock: 1 caller: 0) ; PactTimer
				(self setCase:)
				(cond
					((!= invItemId 4)
						(= cycles 1)
					)
					((== bulletType 3)
						(gMessager say: 1 0 28 2 self 220) ; "With Buckshot, please!"
					)
					(else
						(gMessager say: 1 0 28 3 self 220) ; "With one ounce slug, please!"
					)
				)
			)
			(4
				(= global133 (ScriptID gCurRoomNum 10))
				(= timeToLoad 1)
				(gGame handsOn:)
				(if (not (IsFlag 36))
					(= seconds 8)
				else
					(= seconds 6)
				)
			)
			(5
				(if script
					(-- state)
					(= cycles 10)
				else
					(= global133 0)
					(= timeToLoad 0)
					(gGame handsOff:)
					(= cycles 1)
				)
			)
			(6
				(cond
					((self checkGun: 1)
						(gGame handsOff:)
						(= limitCursor 253)
						(gMessager say: 1 0 22 0 self 220) ; "Officers! Come to your guard!"
					)
					(resetScript
						(= global133 (ScriptID gCurRoomNum 10))
						(self doResetScript:)
					)
					(else
						(self state: 0 seconds: 0 cycles: 0 wrongGun: self)
					)
				)
			)
			(7
				(= global135 0)
				(if (not (gCast contains: (ScriptID 50 0))) ; PactTimer
					((ScriptID 50 0) ; PactTimer
						view: (if (== gCurRoomNum 220) 2202 else 2252)
						setLoop: 0
						setCel: 0
						posn: 110 91
						init:
					)
				)
				((ScriptID 50 0) shotsAllowed: (self getShotsAllowed:)) ; PactTimer
				(gMessager say: 1 0 theCase 1 self 220)
			)
			(8
				(self setParTime:)
				(gMessager say: 1 0 theCase 2 self 220)
			)
			(9
				(if (and (== gCurRoomNum 225) (OneOf theCase 24 27))
					(gMessager say: 1 0 theCase 3 self 220)
				else
					(= cycles 1)
				)
			)
			(10
				(= seconds 2)
			)
			(11
				(gFxSound number: 21002 setLoop: 0 play: self)
			)
			(12
				(= global133 (ScriptID gCurRoomNum 10))
				(= temp0 (proc19_3 invItemId))
				(gTheInvCursor
					view: (temp0 cView:)
					loop: (temp0 cLoop:)
					cel: (temp0 cCel:)
				)
				(= limitCursor 0)
				(gGame handsOn:)
				((ScriptID 50 0) start: self) ; PactTimer
				(self backgroundFire:)
			)
			(13
				(= cycles 1)
			)
			(14
				((ScriptID 50 0) caller: 0) ; PactTimer
				(gGame handsOff:)
				((ScriptID gCurRoomNum 14) init:)
				(gMessager say: 1 0 4 0 self 220) ; "On Guard!"
			)
			(15
				(cond
					(
						(and
							(not global135)
							(not (((proc19_3 invItemId) data:) roundsLeft:))
						)
						(gCurRoom setScript: ammoScript 0 self)
					)
					((not (self checkGun: 1))
						(if resetScript
							(self doResetScript:)
						else
							(self state: 0 seconds: 0 cycles: 0 wrongGun: self)
						)
					)
					((> global135 ((ScriptID 50 0) shotsAllowed:)) ; PactTimer
						(gMessager say: 1 0 12 0 self 220) ; "This is a training exercise, Officer! You will follow the drills, please!"
					)
					((< global135 ((ScriptID 50 0) shotsAllowed:)) ; PactTimer
						(gMessager say: 1 0 11 0 self 220) ; "Officer, if you're experiencing a malfunction clear it now! If not, I suggest you follow the drills!"
					)
					(
						(or
							(not ((ScriptID gCurRoomNum 12) size:))
							(< ((ScriptID gCurRoomNum 12) size:) global135)
						)
						(gMessager say: 1 0 12 0 self 220) ; "This is a training exercise, Officer! You will follow the drills, please!"
					)
					(else
						(= cycles 1)
					)
				)
			)
			(16
				(cond
					((>= (++ global134) 6)
						(= cycles 2)
					)
					((> ammoWarnings 1)
						(= cycles 2)
					)
					(else
						(gGame handsOn:)
						((ScriptID 50 0) startDrillTimer: 5 self) ; PactTimer
						(= timeToLoad 1)
						(= sameShotAmmo
							(= start (= seconds (= cycles (= state 0))))
						)
					)
				)
			)
			(17
				(if script
					(-- state)
					(= cycles 10)
				else
					(self replaceGun:)
					(SetFlag 68)
					(SetFlag 69)
					(gGame handsOff:)
				)
			)
			(18
				(if (gCast contains: (ScriptID gCurRoomNum 14))
					((ScriptID gCurRoomNum 14) dispose:)
				)
				((ScriptID 50 0) dispose:) ; PactTimer
				(= seconds 2)
			)
			(19
				(gCurRoom newRoom: 210)
			)
		)
	)
)

(instance reprimandScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame showCloseUp: 2108 -1 -1 self)
			)
			(1
				(gCurRoom setScript: register)
			)
		)
	)
)

(instance ammoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(register noAmmo: self)
			)
			(1
				(gGame handsOn:)
				(= seconds 5)
			)
			(2
				(if
					(and
						(not global135)
						(not
							(((proc19_3 (register invItemId:)) data:)
								roundsLeft:
							)
						)
					)
					(if (> (register ammoWarnings:) 1)
						(register start: 16)
						(gCurRoom setScript: register)
					else
						(gGame handsOff:)
						(self init:)
					)
				else
					(register ammoWarnings: 0)
					(gCurRoom setScript: register)
				)
			)
		)
	)
)

(instance nonWeaponScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (register reprimand:) 3)
					(gMessager say: 1 0 local1 0 self 220)
				)
			)
			(1
				(gCurRoom setScript: register)
			)
		)
	)
)

(instance do45Drill of DrillScript
	(properties)

	(method (wrongGun)
		(cond
			(
				(OneOf
					(gSwatInterface curInvItem:)
					(proc19_3 3)
					(proc19_3 4)
					(proc19_3 21)
				)
				(if (< (self reprimand:) 3)
					(gMessager say: 1 0 29 0 self 220) ; "Officer, you have chosen the incorrect weapon for this drill. With your .45, please make ready!"
				)
			)
			((< (self reprimand:) 3)
				(gMessager say: 1 0 8 0 self 220) ; "Officer, this is a weapons drill. With your .45, please make ready!"
			)
		)
	)

	(method (nonWeapon)
		(= local1 8)
		(super nonWeapon:)
	)

	(method (setCase)
		(= theCase
			(switch (Random 0 2)
				(0 1)
				(1 2)
				(2 3)
			)
		)
	)

	(method (getShotsAllowed)
		(return
			(switch theCase
				(1 1)
				(2 2)
				(3 3)
			)
		)
	)

	(method (setParTime)
		(switch theCase
			(1
				((ScriptID 50 0) setPar: 20) ; PactTimer
			)
			(2
				((ScriptID 50 0) setPar: 15) ; PactTimer
			)
			(3
				((ScriptID 50 0) setPar: 25) ; PactTimer
			)
		)
	)

	(method (backgroundFire &tmp temp0)
		(= temp0
			(switch (Random 0 2)
				(0 60)
				(1 61)
				(2 62)
			)
		)
		(gFxSound number: temp0 loop: 1 play:)
	)

	(method (noAmmo param1)
		(gMessager say: 1 0 16 0 param1 220) ; "This is a participatory drill, Officer! Cooperation on your part is required! Please re-load at this time!"
		(super noAmmo:)
	)

	(method (replaceGun)
		(SetFlag 34)
		(gMessager say: 1 0 5 0 self 220) ; "Holster your weapon!"
		(gSwatInterface setInvItem: 0)
	)
)

(instance doMP5Drill of DrillScript
	(properties
		invItemId 3
	)

	(method (init)
		(super init: &rest)
		(= resetScript setupMP5)
	)

	(method (nonWeapon)
		(= local1 9)
		(super nonWeapon:)
	)

	(method (checkGun param1)
		(if (== param1 0)
			(return (== (gSwatInterface curInvItem:) (proc19_3 invItemId)))
		else
			(return
				(and
					(== (gSwatInterface curInvItem:) (proc19_3 invItemId))
					(!= (((proc19_3 3) data:) weaponSetting:) 2)
				)
			)
		)
	)

	(method (wrongGun param1)
		(cond
			(
				(OneOf
					(gSwatInterface curInvItem:)
					(proc19_3 0)
					(proc19_3 4)
					(proc19_3 21)
				)
				(if (< (self reprimand:) 3)
					(gMessager say: 1 0 30 0 param1 220) ; "Officer, you have chosen the incorrect weapon for this drill. With your MP5, please make ready!"
				)
			)
			((< (self reprimand:) 3)
				(gMessager say: 1 0 9 0 param1 220) ; "Officer, this is a weapons drill. With your MP5, please make ready!"
			)
		)
	)

	(method (setCase)
		(= theCase
			(switch (Random 0 2)
				(0 13)
				(1 14)
				(2 15)
			)
		)
	)

	(method (getShotsAllowed)
		(return
			(switch theCase
				(13 2)
				(14 1)
				(15 3)
			)
		)
	)

	(method (setParTime)
		(switch theCase
			(13
				((ScriptID 50 0) setPar: 20) ; PactTimer
			)
			(14
				((ScriptID 50 0) setPar: 15) ; PactTimer
			)
			(15
				((ScriptID 50 0) setPar: 25) ; PactTimer
			)
		)
	)

	(method (checkSettings)
		(if
			(and
				(not script)
				(or
					(not (self checkGun: 0))
					(== (((proc19_3 invItemId) data:) weaponSetting:) 2)
				)
			)
			((ScriptID 50 0) caller: 0 stop: clearClock:) ; PactTimer
			(self doResetScript:)
		)
	)

	(method (noAmmo param1)
		(gMessager say: 1 0 18 0 param1 220) ; "This is a participatory drill, Officer! Cooperation on your part is required. Load your weapon!"
		(super noAmmo:)
	)

	(method (replaceGun)
		(SetFlag 36)
		(= local0 0)
		(self setScript: replaceMP5 self)
	)

	(method (backgroundFire &tmp temp0)
		(= temp0
			(switch (Random 0 2)
				(0 63)
				(1 64)
				(2 65)
			)
		)
		(gFxSound number: temp0 loop: 1 play:)
	)
)

(instance setupMP5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if global139
					(= ticks 1)
				else
					(self cue:)
				)
			)
			(1
				(= scratch 0)
				(cond
					(
						(or
							(not (gSwatInterface curInvItem:))
							(not
								(OneOf
									(gSwatInterface curInvItem:)
									(proc19_3 3)
									(proc19_3 4)
									(proc19_3 0)
									(proc19_3 21)
								)
							)
						)
						(gMessager say: 1 0 9 0 self 220) ; "Officer, this is a weapons drill. With your MP5, please make ready!"
					)
					((not (register checkGun: 0))
						(gMessager say: 1 0 30 0 self 220) ; "Officer, you have chosen the incorrect weapon for this drill. With your MP5, please make ready!"
					)
					((== (((proc19_3 3) data:) weaponSetting:) 2)
						(= scratch 1)
						(gMessager say: 1 0 17 0 self 220) ; "Weapons to low ready! We have a renegade! Officer, set your weapon to semi-auto now!"
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(if scratch
					(gGame handsOn:)
					(= local0 1)
					(= gSelectorCloseCode selectorCloseCode)
					(gCurRoom setInset: (ScriptID 27) self 0 1) ; mp5Selector
				else
					(= cycles 1)
				)
			)
			(3
				(= cycles 5)
			)
			(4
				(gCurRoom setScript: register)
			)
		)
	)
)

(instance replaceMP5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 0 6 0 self 220) ; "Put 'em on safe and let 'em hang!"
			)
			(1
				(if (!= (((proc19_3 3) data:) weaponSetting:) local0)
					(gGame handsOn:)
					(= gSelectorCloseCode selectorCloseCode)
					(gCurRoom setInset: (ScriptID 27) self 0 1) ; mp5Selector
				else
					(= cycles 1)
				)
			)
			(2
				(= cycles 1)
			)
			(3
				(= gSelectorCloseCode 0)
				(gSwatInterface setInvItem: 0)
				(gGame handsOff:)
				(if (not global138)
					(self dispose:)
				else
					(gCurRoom newRoom: global138)
				)
			)
		)
	)
)

(instance doShotgunDrill of DrillScript
	(properties
		invItemId 4
	)

	(method (init)
		(super init: &rest)
		(= resetScript setupShotgun)
	)

	(method (nonWeapon)
		(= local1 10)
		(super nonWeapon:)
	)

	(method (checkGun param1)
		(if (== param1 0)
			(return (== (gSwatInterface curInvItem:) (proc19_3 invItemId)))
		else
			(return
				(and
					(== (gSwatInterface curInvItem:) (proc19_3 invItemId))
					(== (((proc19_3 4) data:) bulletType:) bulletType)
				)
			)
		)
	)

	(method (wrongGun param1)
		(cond
			(
				(OneOf
					(gSwatInterface curInvItem:)
					(proc19_3 3)
					(proc19_3 0)
					(proc19_3 21)
				)
				(if (< (self reprimand:) 3)
					(gMessager say: 1 0 31 0 param1 220) ; "Officer, you have chosen the incorrect weapon for this drill. With your shotgun, please make ready!"
				)
			)
			((< (self reprimand:) 3)
				(gMessager say: 1 0 10 0 param1 220) ; "Officer, this is a weapons drill. With your shotgun, please make ready!"
			)
		)
	)

	(method (setCase)
		(= theCase
			(cond
				((== gCurRoomNum 220)
					(switch (Random 0 1)
						(0 23)
						(1 24)
					)
				)
				(sameShotAmmo theCase)
				(else
					(switch (Random 0 3)
						(0 23)
						(1 25)
						(2 26)
						(3 27)
					)
				)
			)
		)
		(if (== gCurRoomNum 220)
			(= bulletType 3)
		else
			(= bulletType
				(switch theCase
					(23 3)
					(24 3)
					(25 4)
					(26 3)
					(27 4)
				)
			)
		)
	)

	(method (getShotsAllowed)
		(return
			(if (== gCurRoomNum 220)
				(switch theCase
					(23 1)
					(24 2)
				)
			else
				(switch theCase
					(23 1)
					(24 2)
					(25 1)
					(26 2)
					(27 2)
				)
			)
		)
	)

	(method (setParTime)
		(if (== gCurRoomNum 220)
			(switch theCase
				(23
					((ScriptID 50 0) setPar: 15) ; PactTimer
				)
				(24
					((ScriptID 50 0) setPar: 20) ; PactTimer
				)
			)
		else
			(switch theCase
				(23
					((ScriptID 50 0) setPar: 25) ; PactTimer
				)
				(24
					((ScriptID 50 0) setPar: 30) ; PactTimer
				)
				(25
					((ScriptID 50 0) setPar: 25) ; PactTimer
				)
				(26
					((ScriptID 50 0) setPar: 30) ; PactTimer
				)
				(27
					((ScriptID 50 0) setPar: 30) ; PactTimer
				)
			)
		)
	)

	(method (noAmmo param1)
		(gMessager say: 1 0 20 0 param1 220) ; "Officer, if it's a weapons malfunction you're experiencing I suggest you visit the armorer later! If your weapon is unloaded, I suggest you load it now!"
		(super noAmmo:)
	)

	(method (replaceGun)
		(SetFlag 38)
		(gMessager say: 1 0 7 0 self 220) ; "Secure your weapon!"
		(gSwatInterface setInvItem: 0)
	)

	(method (backgroundFire &tmp temp0)
		(= temp0
			(switch (Random 0 2)
				(0 68)
				(1 69)
				(2 70)
			)
		)
		(gFxSound number: temp0 loop: 1 play:)
	)
)

(instance setupShotgun of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if global139
					(= ticks 1)
				else
					(self cue:)
				)
			)
			(1
				(= scratch 0)
				(cond
					(
						(or
							(not (gSwatInterface curInvItem:))
							(not
								(OneOf
									(gSwatInterface curInvItem:)
									(proc19_3 3)
									(proc19_3 4)
									(proc19_3 0)
									(proc19_3 21)
								)
							)
						)
						(gMessager say: 1 0 10 0 self 220) ; "Officer, this is a weapons drill. With your shotgun, please make ready!"
					)
					((not (register checkGun: 0))
						(gMessager say: 1 0 31 0 self 220) ; "Officer, you have chosen the incorrect weapon for this drill. With your shotgun, please make ready!"
					)
					((not (register checkGun: 1))
						(= scratch 1)
						(gMessager say: 1 0 28 1 self 220) ; "This is training, Officer! You will follow the drills!"
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(gGame handsOff:)
				(gCurRoom setScript: register)
			)
		)
	)
)

(instance doM16Drill of DrillScript
	(properties
		invItemId 21
	)

	(method (init)
		(super init: &rest)
		(= resetScript setupM16)
	)

	(method (nonWeapon)
		(= local1 33)
		(super nonWeapon:)
	)

	(method (wrongGun param1)
		(cond
			(
				(OneOf
					(gSwatInterface curInvItem:)
					(proc19_3 0)
					(proc19_3 4)
					(proc19_3 3)
				)
				(if (< (self reprimand:) 3)
					(gMessager say: 1 0 32 0 param1 220) ; "Officer, you have chosen the incorrect weapon for this drill. With your M16, please make ready!"
				)
			)
			((< (self reprimand:) 3)
				(gMessager say: 1 0 33 0 param1 220) ; "Officer, this is a weapons drill. With your M16, please make ready!"
			)
		)
	)

	(method (setCase)
		(= theCase
			(switch (Random 0 2)
				(0 34)
				(1 35)
				(2 36)
			)
		)
	)

	(method (getShotsAllowed)
		(return
			(switch theCase
				(34 2)
				(35 1)
				(36 3)
			)
		)
	)

	(method (setParTime)
		(switch theCase
			(34
				((ScriptID 50 0) setPar: 20) ; PactTimer
			)
			(35
				((ScriptID 50 0) setPar: 15) ; PactTimer
			)
			(36
				((ScriptID 50 0) setPar: 25) ; PactTimer
			)
		)
	)

	(method (checkSettings)
		(if (and (not script) (not (self checkGun:)))
			((ScriptID 50 0) caller: 0 stop: clearClock:) ; PactTimer
			(self doResetScript:)
		)
	)

	(method (noAmmo param1)
		(gMessager say: 1 0 18 0 param1 220) ; "This is a participatory drill, Officer! Cooperation on your part is required. Load your weapon!"
		(super noAmmo:)
	)

	(method (replaceGun)
		(SetFlag 117)
		(gMessager say: 1 0 7 0 self 220) ; "Secure your weapon!"
		(gSwatInterface setInvItem: 0)
	)

	(method (backgroundFire &tmp temp0)
		(= temp0
			(switch (Random 0 2)
				(0 63)
				(1 64)
				(2 65)
			)
		)
		(gFxSound number: temp0 loop: 1 play:)
	)
)

(instance setupM16 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if global139
					(= ticks 1)
				else
					(self cue:)
				)
			)
			(1
				(cond
					(
						(or
							(not (gSwatInterface curInvItem:))
							(not
								(OneOf
									(gSwatInterface curInvItem:)
									(proc19_3 3)
									(proc19_3 4)
									(proc19_3 0)
									(proc19_3 21)
								)
							)
						)
						(gMessager say: 1 0 33 0 self 220) ; "Officer, this is a weapons drill. With your M16, please make ready!"
					)
					((not (register checkGun: 0))
						(doM16Drill wrongGun: self)
					)
					(else
						(gGame handsOff:)
						(gCurRoom setScript: register)
					)
				)
			)
			(2
				(gGame handsOff:)
				(gCurRoom setScript: register)
			)
		)
	)
)

(instance selectorCloseCode of Code
	(properties)

	(method (doit)
		(return (== (((proc19_3 3) data:) weaponSetting:) local0))
	)
)

(class CloseUpBulletList of List
	(properties)

	(method (showAll &tmp temp0)
		(if size
			(self dispose:)
		)
		(for ((= temp0 0)) (< temp0 ((ScriptID gCurRoomNum 12) size:)) ((++ temp0))
			(self showBullet: ((ScriptID gCurRoomNum 12) at: temp0))
		)
	)

	(method (showBullet param1 &tmp temp0 temp1 temp2)
		(if (not (gCast contains: (ScriptID gCurRoomNum 14)))
			(return)
		)
		(if (== gCurRoomNum 220)
			(= temp2 2)
		else
			(= temp2 4)
		)
		(= temp0 (* (- (param1 x:) ((ScriptID gCurRoomNum 11) x:)) temp2))
		(= temp1 (* (- (param1 y:) ((ScriptID gCurRoomNum 11) y:)) temp2))
		(+= temp0 ((ScriptID gCurRoomNum 14) x:))
		(+= temp1 ((ScriptID gCurRoomNum 14) y:))
		(self
			add:
				(((ScriptID gCurRoomNum 13) new:)
					posn: temp0 temp1
					setLoop: (+ (param1 loop:) 1)
					setCel: (param1 cel:)
					init:
				)
		)
	)
)

(instance closeUpList of CloseUpBulletList
	(properties)
)

