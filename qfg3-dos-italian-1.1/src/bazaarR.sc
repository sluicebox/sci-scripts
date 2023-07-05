;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 51)
(include sci.sh)
(use Main)
(use TargFeature)
(use Game)
(use Actor)
(use System)

(public
	bazaarR 0
	proc51_1 1
	proc51_2 2
	proc51_3 3
)

(procedure (proc51_1 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp0 0)
	(= temp2 999)
	(for ((= temp4 0)) (< temp4 (gCast size:)) ((++ temp4))
		(if
			(and
				((gCast at: temp4) isKindOf: (or Actor TargActor))
				(!= (= temp1 (gCast at: temp4)) gEgo)
				(<
					(= temp3
						(GetDistance
							(gEgo x:)
							(gEgo y:)
							(temp1 x:)
							(temp1 y:)
						)
					)
					temp2
				)
			)
			(= temp2 temp3)
			(= temp0 temp1)
		)
	)
	(temp0)
)

(procedure (proc51_2 param1 &tmp temp0) ; UNUSED
	(= temp0 (gInventory at: param1))
	(return (== (temp0 realOwner:) gCurRoom))
)

(procedure (proc51_3 param1 param2 param3 &tmp temp0 temp1 temp2 [temp3 40]) ; UNUSED
	(= temp1 (gInventory at: 0)) ; theRoyals
	(= temp0 (+ global410 (* 100 (temp1 amount:))))
	(if
		(<
			(= temp2
				(*
					param2
					(if (== 100 (((param3 goods:) at: param1) denomination:))
						(* 100 (((param3 goods:) at: param1) price:))
					else
						(((param3 goods:) at: param1) price:)
					)
				)
			)
			global410
		)
		(-= global410 temp2)
	else
		(-= temp0 temp2)
		((gInventory at: 0) amount: (/ temp0 100)) ; theRoyals
		(= global410 (mod temp0 100))
	)
	(((param3 goods:) at: param1)
		quantity: (- (((param3 goods:) at: param1) quantity:) param2)
	)
)

(instance bazaarR of Rgn
	(properties)

	(method (init)
		(if (and (not gNight) (not (IsFlag 135)))
			(if (and (> gClock 2650) (not (IsFlag 81)))
				(ClearFlag 6)
			)
			(if (IsFlag 81)
				(SetFlag 121)
				(PalVary pvPAUSE_RESUME 1)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(if
			(and
				(IsFlag 6)
				(not (IsFlag 135))
				(> gClock 2650)
				(not gNight)
			)
			(ClearFlag 6)
		)
	)

	(method (newRoom newRoomNumber)
		(if (not (IsFlag 6))
			(if
				(or
					(== newRoomNumber 230)
					(== newRoomNumber 240)
					(== newRoomNumber 250)
					(== newRoomNumber 260)
				)
				(SetFlag 135)
				(gLongSong stop:)
			)
			(SetFlag 6)
		)
	)

	(method (dispose)
		(if (IsFlag 121)
			(ClearFlag 121)
			(PalVary pvPAUSE_RESUME 0)
		)
		(if (not (OneOf gNewRoomNum 230 240 250 260))
			(DisposeScript 51)
		)
	)
)

(class MerchantActor of Actor
	(properties
		lastAnswerDay 0
	)

	(method (init)
		(super init: &rest)
	)

	(method (newGreeting &tmp temp0))

	(method (newRumor &tmp [temp0 2]))

	(method (newTellResponse))

	(method (dispose)
		(super dispose: &rest)
	)
)

