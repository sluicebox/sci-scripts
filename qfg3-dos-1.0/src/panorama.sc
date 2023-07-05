;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50)
(include sci.sh)
(use Main)
(use PolyPath)
(use Timer)
(use Motion)
(use Game)
(use User)
(use System)

(public
	panorama 0
)

(local
	local0
	local1
	local2 = 1
	local3
	local4
)

(procedure (localproc_0 param1)
	(if (and (Random 0 1) (IsFlag 3))
		(= global365 11)
		(return)
	)
	(switch param1
		(4
			(cond
				((and (IsFlag 65) (not (IsFlag 102)))
					(= global365 6)
				)
				((== gCurRoomNum 180)
					(if (not (IsFlag 109))
						(= global365 8)
					else
						(switch (Random 0 2)
							(0
								(= global365 575)
							)
							(1
								(= global365 590)
							)
							(else
								(= global365 595)
							)
						)
					)
				)
				((IsFlag 102)
					(if (Random 0 1)
						(= global365 6)
					else
						(switch (Random 0 2)
							(0
								(= global365 580)
							)
							(1
								(= global365 565)
							)
							(else
								(= global365 585)
							)
						)
					)
				)
				(gNight
					(switch (Random 0 7)
						(0
							(= global365 580)
						)
						(1
							(= global365 565)
						)
						(2
							(= global365 585)
						)
						(3
							(if (== gCurRoomNum 180)
								(if (Random 0 1)
									(= global365 575)
								else
									(= global365 590)
								)
							else
								(= global365 595)
							)
						)
						(else
							(= global365 595)
						)
					)
				)
				(else
					(switch (Random 0 6)
						(0
							(= global365 580)
						)
						(1
							(= global365 565)
						)
						(2
							(= global365 585)
						)
						(3
							(if (== gCurRoomNum 180)
								(if (Random 0 1)
									(= global365 575)
								else
									(= global365 590)
								)
							else
								(= global365 595)
							)
						)
						(else
							(if
								(and
									(IsFlag 132)
									(IsFlag 133)
									(not (IsFlag 116))
								)
								(= global365 10)
							else
								(= global365 580)
							)
						)
					)
				)
			)
		)
		(2
			(if (Random 0 3)
				(= global365 585)
			else
				(switch (Random 0 1)
					(0
						(= global365 565)
					)
					(1
						(= global365 560)
					)
				)
			)
			(if (== param1 4)
				(SetFlag 34)
			)
		)
		(4096
			(switch (Random 0 1)
				(0
					(= global365 590)
				)
				(1
					(= global365 575)
				)
			)
			(SetFlag 34)
		)
		(16384
			(if
				(and
					(OneOf gCurRoomNum 150 160)
					(IsFlag 83)
					(not (IsFlag 99))
				)
				(switch (Random 0 7)
					(0
						(= global365 565)
					)
					(1
						(= global365 585)
					)
					(else
						(cond
							(
								(or
									(and
										(gEgo inRect: 171 85 313 115)
										(== gCurRoomNum 150)
									)
									(and
										(gEgo inRect: 6 62 101 146)
										(== gCurRoomNum 160)
									)
								)
								(= global468 gCurRoomNum)
								(= global365 2)
								(= global422 (gEgo x:))
								(= global423 (gEgo y:))
							)
							((Random 0 1)
								(= global365 565)
							)
							(else
								(= global365 585)
							)
						)
					)
				)
			else
				(switch (Random 0 1)
					(0
						(= global365 565)
					)
					(1
						(= global365 560)
					)
				)
			)
		)
	)
)

(procedure (localproc_1 param1)
	(if (and (Random 0 1) (IsFlag 3))
		(= global365 11)
		(return)
	)
	(= global365
		(switch (Random 0 50)
			(0 4)
			(1
				(if (== param1 16384) 0 else 4)
			)
			(2
				(if (== param1 16384) 3 else 4)
			)
			(3
				(if
					(and
						(IsFlag 2)
						(not ((gInventory at: 24) amount:)) ; theVine
						(not (Random 0 9))
					)
					11
				else
					4
				)
			)
			(4 5)
			(5 5)
			(else 999)
		)
	)
)

(class PanoRoom of Rm
	(properties
		toX 0
		toY 0
	)

	(method (init)
		(gWalkHandler addToFront: self)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(self toX: ((User curEvent:) x:))
				(self toY: ((User curEvent:) y:))
				(gEgo setMotion: PolyPath toX toY gCurRoom)
			)
			(74 ; Sleep
				(SetFlag 143)
				(= global365 74)
				(= global363 (gEgo x:))
				(= global364 (gEgo y:))
				(gCurRoom newRoom: 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(cond
			((and (not newRoomNumber) (not (IsFlag 130)))
				(if
					(or
						(== (gEgo onControl: 1) 4)
						(== (gEgo onControl: 1) 4096)
					)
					(if (not global365)
						(= global365 999)
					)
					(= newRoomNumber 700)
				else
					(= newRoomNumber 400)
				)
			)
			((IsFlag 130)
				(= newRoomNumber 310)
			)
		)
		(HandsOff)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)
)

(instance panorama of Rgn
	(properties)

	(method (init &tmp temp0 temp1)
		(ClearFlag 143)
		(= global365 999)
		(= global411 3)
		(if (= temp0 (PalVary pvGET_CURRENT_STEP))
			(= temp1 (/ (- 64 temp0) 10))
			(PalVary pvCHANGE_TICKS temp1)
		)
		(switch (gEgo moveSpeed:)
			(0
				(= local4 3)
			)
			(1
				(= local4 4)
			)
			(2
				(= local4 5)
			)
			(else
				(= local4 (gEgo moveSpeed:))
			)
		)
		(gEgo
			view: 151
			setLoop: 0
			cel: 0
			setCycle: Walk
			cycleSpeed: local4
			moveSpeed: local4
			setStep: 1 1
			setScale: 0
			init:
		)
		(= local0
			(switch gPrevRoomNum
				(400 50)
				(150 50)
				(280 12)
				(410 15)
				(420 25)
				(390 12)
				(600 22)
				(750 10)
				(720 16)
				(else 9)
			)
		)
		(= local0 (/ 60 global209))
		(if
			(and
				(or (== gPrevRoomNum 400) (== gPrevRoomNum 380) (== gPrevRoomNum 700))
				(not (IsFlag 92))
			)
			(Timer setTicks: 30 self)
		)
		(super init: &rest)
	)

	(method (cue)
		((ScriptID 7 3) init:) ; showTime
	)

	(method (doit &tmp temp0 temp1 temp2)
		(super doit: &rest)
		(if (!= (gEgo moveSpeed:) local4)
			(switch (gEgo moveSpeed:)
				(0
					(= local4 3)
				)
				(1
					(= local4 4)
				)
				(2
					(= local4 5)
				)
				(else
					(= local4 (gEgo moveSpeed:))
				)
			)
			(gEgo moveSpeed: local4 cycleSpeed: local4)
		)
		(cond
			(
				(or
					(!= (gEgo xLast:) global363)
					(!= (gEgo yLast:) global364)
				)
				(= global363 (gEgo xLast:))
				(= global364 (gEgo yLast:))
				(if (not (-- local2))
					(DrawCel 151 8 0 global363 global364 2)
					(= local2 2)
				)
				(if (IsFlag 6)
					(+= gClock 4)
					(if (IsFlag 131)
						(ClearFlag 131)
						(if
							(and
								(= temp2 (PalVary pvGET_CURRENT_STEP))
								(!= temp2 0)
								(!= temp2 64)
							)
							(= temp1 (/ (- 64 temp2) 24))
							(PalVary pvCHANGE_TICKS temp1)
						)
					)
					(= global411 3)
					(if (and (not (-- local0)) (not (IsFlag 88)))
						(= local0 (- (/ 60 global209) 10))
						(cond
							((& (= temp0 (gEgo onControl: 1)) $0400) 0)
							((not (Random 0 5))
								(= local3 1)
								(gCurRoom newRoom: 0)
							)
						)
					)
				)
			)
			((not (gEgo mover:))
				(= global411 1)
				(if (and (not (IsFlag 131)) (IsFlag 6))
					(SetFlag 131)
					(if (= temp2 (PalVary pvGET_CURRENT_STEP))
						(= temp1 (- 64 temp2))
						(PalVary pvCHANGE_TICKS temp1)
					)
				)
			)
		)
	)

	(method (dispose &tmp temp0 temp1)
		(if (= temp1 (PalVary pvGET_CURRENT_STEP))
			(= temp0 (- 64 temp1))
			(PalVary pvCHANGE_TICKS temp0)
		)
		(= local1 (- 11 (* 3 global209)))
		(cond
			((IsFlag 143) 0)
			((or (>= local1 (Random 0 100)) local3)
				(localproc_0 (gEgo onControl: 1))
			)
			(else
				(localproc_1 (gEgo onControl: 1))
			)
		)
		(= global411 1)
		(HandsOn)
		(super dispose:)
	)
)

