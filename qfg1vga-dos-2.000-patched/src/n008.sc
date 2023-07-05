;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8)
(include sci.sh)
(use Main)
(use n814)
(use Print)

(public
	EgoRests 0
)

(procedure (EgoRests param1 param2 &tmp [temp0 25] [temp25 30] temp55 temp56 temp57)
	(if
		(and
			(<= gDay global113)
			(<= gClock (+ global112 75))
			(> [gEgoStats 15] (/ (MaxStamina) 2)) ; stamina
		)
		(gMessager say: 1 0 0 1 0 8) ; "You're too impatient to rest right now."
	else
		(UseStamina (- param1))
		(UseMana (- (/ param1 5)))
		(TakeDamage (- (/ (+ param1 5) 15)))
		(if param2
			(Message msgGET 8 1 0 0 2 @temp0) ; "After %d minutes rest, you feel better."
			(Print font: gUserFont mode: 1 addTextF: @temp25 @temp0 param1 init:)
		)
		(= temp55 (/ (= temp57 (+ gClock (/ (* 15 param1) 6))) 150))
		(= temp56 (mod temp57 150))
		(FixTime temp55 temp56)
		(= global113 gDay)
		(= global112 gClock)
	)
)

