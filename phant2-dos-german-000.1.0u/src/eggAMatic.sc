;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 910)
(include sci.sh)
(use Main)
(use Array)
(use WriteFeature)

(class eggAMatic of Obj
	(properties
		size 0
		roomArr 0
		eggArr 0
	)

	(method (init)
		(= roomArr (IntArray new:))
		(= eggArr (ByteArray new:))
		(if (roomArr data:)
			(KArray 4 (roomArr data:)) ; ArrayFree
		)
		(roomArr data: (KArray 0 1 (roomArr type:))) ; ArrayNew
		(if (eggArr data:)
			(KArray 4 (eggArr data:)) ; ArrayFree
		)
		(eggArr data: (KArray 0 1 (eggArr type:))) ; ArrayNew
		(= size 0)
	)

	(method (add param1 param2 param3 &tmp temp0 temp1)
		(if (== (= temp1 (roomArr indexOf: param1)) -1)
			(roomArr at: size param1)
			(eggArr at: size param2)
			(+= global242 param3)
			(+= size 1)
		else
			(= temp0 (eggArr at: temp1))
			(if (& param2 (~ temp0))
				(|= temp0 param2)
				(eggArr at: temp1 temp0)
				(+= global242 param3)
			)
		)
	)
)

