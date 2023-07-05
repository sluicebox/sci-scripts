;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 505)
(include sci.sh)
(use Main)
(use Game)
(use System)

(public
	sbar 0
)

(class sbar of Rgn
	(properties
		state 0
	)

	(method (init)
		(super init: &rest)
	)

	(method (doit)
		(super doit: &rest)
		(if (and (IsFlag 54) (not (self script:)))
			(self setScript: sWarningTimer)
		)
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 500 510 520 530))
		(= initialized 0)
		(super newRoom: newRoomNumber)
	)
)

(instance sWarningTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 100)
			)
			(1
				(gMessager say: 1 0 0 1 self 501) ; "|c1|Warning!|c| Station structural integrity has been compromised. All non-essential personnel are ordered to evacuate. Damage control teams report to deck 20."
			)
			(2
				(= seconds 50)
			)
			(3
				(gMessager say: 1 0 0 2 self 501) ; "|c1||f3|WARNING!|c||f| Hull breach imminent. All remaining personnel are ordered to evacuate the station immediately."
			)
			(4
				(= seconds 50)
			)
			(5
				(gMessager say: 1 0 0 3 self 501) ; "|c2||f8|WARNING! |c||f3|We're all going to die! We're all going to die! We're all going to die! HAHAHAHAHAHAHHAHA!"
			)
			(6
				(= seconds 50)
			)
			(7
				(gCurRoom newRoom: 550)
			)
		)
	)
)

