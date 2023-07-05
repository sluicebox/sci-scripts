;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35)
(include sci.sh)
(use Main)
(use skipCartoon)
(use scaryInvInit)
(use Plane)
(use Actor)
(use System)

(public
	chapEndRm 0
)

(local
	local0
	[local1 16]
	local17 = -1
)

(instance chapEndRm of KQRoom
	(properties)

	(method (init &tmp temp0)
		(super init:)
		(gKqMusic1 stop:)
		(gCurRoom inset: 1)
		(= local17 -1)
		(if (== gValOrRoz -4) ; Val
			(for ((= temp0 0)) (< temp0 16) ((++ temp0))
				(= [gRozInventoryIndexes temp0] -1)
			)
		else
			(for ((= temp0 0)) (< temp0 16) ((++ temp0))
				(= [gValInventoryIndexes temp0] -1)
			)
		)
		(global124 eachElementDo: #perform getIndexCode)
		0
		(while (>= local17 0)
			(gEgo put: [local1 local17])
			(-- local17)
		)
		(= local0 global124)
		(= global124 ((Cast new:) add:))
		(self setScript: chapBeginScr)
		(if (== gPrevRoomNum 20) ; nameGameRoom
			(gGame smallSave: global333)
		)
	)

	(method (handleEvent)
		(return 0)
	)

	(method (dispose &tmp temp0)
		(gCurRoom inset: 0)
		(= temp0 (Plane new:))
		(temp0 setRect: 0 0 319 135 back: 0 picture: -1 priority: 3000 init:)
		(FrameOut)
		(temp0 dispose:)
		(super dispose:)
	)
)

(instance getIndexCode of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if (param1 isKindOf: KQInventory)
			(= temp0 (gInventory indexOf: param1))
			(++ local17)
			(= [local1 local17] temp0)
			(cond
				((and (== gValOrRoz -4) (== (param1 owner:) -4)) ; Val
					(= [gRozInventoryIndexes local17] temp0)
				)
				((and (== gValOrRoz -3) (== (param1 owner:) -3)) ; Roz
					(= [gValInventoryIndexes local17] temp0)
				)
			)
		)
	)
)

(instance hideInvCode of Code ; UNUSED
	(properties)

	(method (doit param1)
		(if (param1 isKindOf: KQInventory)
			(gEgo put: (gInventory indexOf: param1))
		)
	)
)

(instance contButton of View
	(properties
		x 190
		y 120
		view 981
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 0 10 8) ; Exit, Do
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(if (not (event type:))
			(super handleEvent: event)
			(return)
		)
		(= temp1 0)
		(= temp2 1)
		(while temp2
			(= temp0 ((gUser curEvent:) new:))
			(cond
				((== (temp0 type:) 2)
					(= temp2 0)
				)
				((self onMe: temp0)
					(= temp1 (= cel 1))
					(UpdateScreenItem self)
				)
				(else
					(= temp1 (= cel 0))
					(UpdateScreenItem self)
				)
			)
			(FrameOut)
		)
		(= cel 0)
		(UpdateScreenItem self)
		(FrameOut)
		(if temp1
			((gCurRoom script:) cue:)
			(event claimed: 1)
			(return)
		else
			(return 1)
		)
	)
)

(instance quitButton of View
	(properties
		x 60
		y 120
		view 981
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 0 10 8) ; Exit, Do
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if (not (event type:))
			(super handleEvent: event)
			(return)
		)
		(= temp1 0)
		(= temp2 1)
		(while temp2
			(= temp0 ((gUser curEvent:) new:))
			(cond
				((temp0 type:)
					(= temp2 0)
				)
				((self onMe: temp0)
					(= temp1 (= cel 1))
					(UpdateScreenItem self)
				)
				(else
					(= temp1 (= cel 0))
					(UpdateScreenItem self)
				)
			)
			(FrameOut)
		)
		(= cel 0)
		(UpdateScreenItem self)
		(FrameOut)
		(if temp1
			(gGame smallSave:)
			(= temp4 (Plane new:))
			(= temp5 gCast)
			(temp4
				setRect: 0 0 319 199
				picture: -1
				back: 0
				priority: (+ (GetHighPlanePri) 1)
				init:
				addCast: (= gCast (Cast new:))
			)
			(= temp3 (View new:))
			(temp3
				view: 983
				x: (+ (Abs (gThePlane left:)) (/ (- 320 (CelWide 983 0 0)) 2))
				y: (+ (Abs (gThePlane top:)) (/ (- 136 (CelHigh 983 0 0)) 2))
				init:
			)
			(= temp6 (GetTime))
			(while (< (- (GetTime) temp6) 30)
				(FrameOut)
			)
			(gCast dispose:)
			(temp4 dispose:)
			(= gCast temp5)
			(gCurRoom newRoom: 30)
			(event claimed: 1)
			(return)
		else
			(return 1)
		)
	)
)

(instance chapView of View
	(properties
		x 30
		y 10
	)
)

(instance chapBeginScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gPrevRoomNum 20) ; nameGameRoom
					(gGame isHandsOn: 1)
				)
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(chapView view: (+ 400 gChapter) init:)
				(if (not (OneOf gPrevRoomNum 20 23)) ; nameGameRoom, selectGameRoom
					(contButton init:)
					(quitButton init:)
				)
				(if (not (gCast contains: quitButton))
					(= seconds 4)
				else
					(gGame handsOn:)
				)
			)
			(2
				(global124 dispose:)
				(= global124 local0)
				(gGame handsOff:)
				((ScriptID 28 0) doit:) ; kqChapCode
			)
		)
	)
)

