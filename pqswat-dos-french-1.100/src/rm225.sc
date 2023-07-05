;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 225)
(include sci.sh)
(use Main)
(use PQRoom)
(use swatInvInit)
(use HotSpot)
(use BulletDrawCel)
(use drillManager)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	rm225 0
	drill1Code 10
	silouette 11
	silouetteList 12
	bulletHole 13
	closeUp 14
)

(local
	local0
	local1
	local2
	local3
)

(instance silouetteList of List
	(properties)
)

(instance rm225 of PQRoom
	(properties
		picture 225
		infoRoomSignal 136
	)

	(method (init)
		(SetFlag 71)
		(super init: &rest)
		(= global138 0)
		(topTarget init:)
		(concrete1Target init:)
		(concrete2Target init:)
		(rightSide init:)
		(leftSide init:)
		((ScriptID 77 0) doit:) ; drillManager
	)

	(method (newRoom newRoomNumber)
		(if (gCurRoom inset:)
			(= global138 newRoomNumber)
			(return)
		)
		(Lock rsAUDIO 60 0)
		(Lock rsAUDIO 61 0)
		(Lock rsAUDIO 62 0)
		(Lock rsAUDIO 63 0)
		(Lock rsAUDIO 64 0)
		(Lock rsAUDIO 65 0)
		(Lock rsAUDIO 68 0)
		(Lock rsAUDIO 69 0)
		(Lock rsAUDIO 70 0)
		(= global133 0)
		(= global134 0)
		(if (gCast contains: closeUp)
			(closeUp dispose:)
		)
		(if (gCast contains: (ScriptID 50 0)) ; PactTimer
			((ScriptID 50 0) dispose:) ; PactTimer
		)
		(if (not (OneOf newRoomNumber 210 15)) ; mainMenu
			(SetFlag 41)
			(= global138 newRoomNumber)
			(gCurRoom setScript: quitter)
		else
			(gCurRoom setScript: 0)
			(= gSelectorCloseCode 0)
			(= global133 0)
			(ClearFlag 71)
			(super newRoom: newRoomNumber)
		)
	)

	(method (dispose)
		(DisposeScript 77)
		(super dispose:)
	)
)

(instance silBitmap of BulletDrawCel
	(properties)

	(method (init)
		(= x (silouette x:))
		(= y (silouette y:))
		(= nsLeft (silouette nsLeft:))
		(= nsTop (silouette nsTop:))
		(= nsRight (silouette nsRight:))
		(= nsBottom (silouette nsBottom:))
		(super init: &rest)
		(self setPri: 301)
		(= local2 1)
	)

	(method (drawCel param1 &tmp temp0 temp1 temp2 temp3)
		(= temp1 (bulletHole view:))
		(= temp2
			(cond
				((!= (gSwatInterface curInvItem:) (proc19_3 4)) 4)
				((== local0 3) 2)
				(else 6)
			)
		)
		(= temp3
			(if (and (== (gSwatInterface curInvItem:) (proc19_3 4)) (== local0 3))
				(Random 0 3)
			else
				0
			)
		)
		(super drawCel: param1 temp1 temp2 temp3)
		(param1 claimed: (gCurRoom script:))
	)

	(method (dispose)
		(super dispose:)
		(= local2 0)
	)
)

(instance silouette of Prop
	(properties
		x 282
		y 135
		priority 100
		fixPriority 1
		view 2251
	)

	(method (init)
		(super init: &rest)
		(silBitmap init:)
	)

	(method (dispose)
		(silouetteList dispose:)
		(silBitmap dispose:)
		(super dispose:)
	)

	(method (setCycle)
		(super setCycle: &rest)
	)

	(method (doit)
		(if (and cycler (== (cycler cycleDir:) 1))
			(= local3 1)
			(if
				(and
					local2
					(>= (Abs (- gGameTime (cycler cycleCnt:))) cycleSpeed)
				)
				(silBitmap
					y: (+ (silBitmap y:) 3)
					nsTop: (+ (silBitmap nsTop:) 3)
					nsBottom: (+ (silBitmap nsBottom:) 3)
				)
				(UpdateScreenItem silBitmap)
			)
		)
		(if (and (not cycler) local3)
			(= local3 0)
			(silBitmap dispose:)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp temp0)
		(if (OneOf (event message:) JOY_DOWNLEFT JOY_LEFT JOY_UPLEFT $000a)
			(silouetteList
				add:
					((= temp0 (bulletHole new:))
						posn: (event x:) (event y:)
						setLoop:
							(cond
								((!= (gSwatInterface curInvItem:) (proc19_3 4)) 4)
								((== local0 3) 2)
								(else 6)
							)
						setCel:
							(if
								(and
									(== (gSwatInterface curInvItem:) (proc19_3 4))
									(== local0 3)
								)
								(Random 0 3)
							else
								0
							)
						yourself:
					)
			)
			(if (gCast contains: closeUp)
				((ScriptID 77 4) showBullet: temp0) ; closeUpList
			)
			(if (not local2)
				(silBitmap init:)
			)
			(silBitmap drawCel: event)
			(event claimed: (gCurRoom script:))
		else
			(super handleEvent: event)
		)
		(event claimed:)
	)
)

(instance bulletHole of View
	(properties
		priority 314
		fixPriority 1
		view 2251
	)

	(method (onMe)
		(return 0)
	)
)

(instance closeUp of View
	(properties
		x 472
		y 9
		priority 313
		fixPriority 1
		view 2251
		loop 1
	)

	(method (init)
		(super init:)
		((ScriptID 77 4) showAll:) ; closeUpList
	)

	(method (dispose)
		((ScriptID 77 4) dispose:) ; closeUpList
		(super dispose:)
	)
)

(instance drill1Code of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if (and (= temp0 (gCurRoom script:)) (temp0 isKindOf: DrillScript))
			(if (and (<= global135 7) ((ScriptID 50 0) shotTimes:)) ; PactTimer
				(((ScriptID 50 0) shotTimes:) ; PactTimer
					at: global135 ((ScriptID 50 0) currentTime:) ; PactTimer
				)
			)
			(++ global135)
			(= local0 (((gSwatInterface curInvItem:) data:) bulletType:))
			(if (temp0 timeToLoad:)
				(if (temp0 script:)
					((temp0 script:) caller: 0)
				)
				(= local1 temp0)
				(temp0 start: 1 seconds: 0 cycles: 0 ticks: 0)
				(gCurRoom setScript: followDrills local1)
			else
				(temp0 checkSettings:)
			)
			(if
				(and
					(>= global135 ((ScriptID 50 0) shotsAllowed:)) ; PactTimer
					(or (not global139) (& (param1 type:) $0002))
				)
				((ScriptID 50 0) stop: cueCaller:) ; PactTimer
			)
		)
	)
)

(instance followDrills of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(if (> (local1 reprimand:) 2)
					(self dispose:)
				else
					(= cycles 2)
				)
			)
			(2
				(gGame handsOff:)
				(= cycles 1)
			)
			(3
				(gMessager say: 1 0 12 0 self 220) ; "This is a training exercise, Officer! You will follow the drills, please!"
			)
			(4
				(gCurRoom setScript: local1)
				(= local1 0)
			)
		)
	)
)

(instance quitter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 50 0) caller: 0) ; PactTimer
				(= cycles 2)
			)
			(1
				(gMessager say: 5 0 14 0 self 210) ; "Officers! Hold your fire! We have a quitter in the group!"
			)
			(2
				(= cycles 2)
			)
			(3
				(gCurRoom newRoom: 210)
			)
		)
	)
)

(instance dirt of Feature ; UNUSED
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 157 60 155 33 187 31 232 13 247 0 316 0 267 30 270 40 279 41 289 33 299 27 312 33 316 40 333 44 343 48 361 42 369 33 396 34 408 35 422 30 440 34 440 60
					yourself:
				)
		)
	)

	(method (handleEvent event)
		(if (OneOf (event message:) JOY_DOWNLEFT JOY_LEFT JOY_UPLEFT)
			(if (gCurRoom script:)
				(event claimed: 1)
			else
				(event claimed: 0)
			)
		else
			(super handleEvent: event)
		)
		(event claimed:)
	)
)

(instance topTarget of BulletDrawCel
	(properties
		nsLeft 207
		nsTop 63
		nsRight 394
		nsBottom 133
		x 207
		y 63
	)

	(method (drawCel param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 (bulletHole view:))
		(= temp2
			(cond
				((!= (gSwatInterface curInvItem:) (proc19_3 4)) 9)
				((== local0 3) 8)
				(else 10)
			)
		)
		(= temp3
			(if (and (== (gSwatInterface curInvItem:) (proc19_3 4)) (== local0 3))
				(Random 0 3)
			else
				0
			)
		)
		(super drawCel: param1 temp1 temp2 temp3)
		(param1 claimed: (gCurRoom script:))
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 6 7 8 10))
			(gGame handsOff:)
			((gCurRoom script:) nonWeapon:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance concrete1Target of BulletDrawCel
	(properties
		nsLeft 207
		nsTop 179
		nsRight 394
		nsBottom 207
		x 207
		y 179
	)

	(method (drawCel param1 &tmp temp0 temp1 temp2)
		(= temp0 (bulletHole view:))
		(= temp1 11)
		(= temp2 (Random 0 8))
		(super drawCel: param1 temp0 temp1 temp2)
		(param1 claimed: (gCurRoom script:))
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 6 7 8 10))
			(gGame handsOff:)
			((gCurRoom script:) nonWeapon:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance concrete2Target of BulletDrawCel
	(properties
		nsLeft 233
		nsTop 291
		nsRight 385
		nsBottom 358
		x 233
		y 291
	)

	(method (drawCel param1 &tmp temp0 temp1 temp2 temp3)
		(= temp1 (bulletHole view:))
		(= temp2 11)
		(= temp3 (Random 0 8))
		(super drawCel: param1 temp1 temp2 temp3)
		(param1 claimed: (gCurRoom script:))
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 6 7 8 10))
			(gGame handsOff:)
			((gCurRoom script:) nonWeapon:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance rightSide of HotSpot
	(properties
		nsLeft 420
		nsRight 640
		nsBottom 355
		type 8
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 6 7 8 10))
			(gGame handsOff:)
			((gCurRoom script:) nonWeapon:)
		else
			(super doVerb: theVerb)
		)
	)

	(method (setupCursor)
		(gTheHotspotCursor view: 999 loop: 0 cel: 0)
	)
)

(instance leftSide of HotSpot
	(properties
		nsRight 220
		nsBottom 355
		type 8
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 6 7 8 10))
			(gGame handsOff:)
			((gCurRoom script:) nonWeapon:)
		else
			(super doVerb: theVerb)
		)
	)

	(method (setupCursor)
		(gTheHotspotCursor view: 999 loop: 0 cel: 0)
	)
)

