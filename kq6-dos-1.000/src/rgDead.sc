;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 70)
(include sci.sh)
(use n913)
(use RandCycle)
(use Game)
(use System)

(public
	rgDead 0
	proc70_1 1
)

(procedure (proc70_1 param1 param2 &tmp temp0 temp1)
	(= temp0 -1)
	(while (= temp1 (WordAt param2 (++ temp0)))
		((Clone param1)
			posn: temp1 (WordAt param2 (++ temp0))
			loop: (WordAt param2 (++ temp0))
			cel: (Random 0 3)
			setCycle: RandCycle
			init:
		)
	)
)

(class rgDead of Rgn
	(properties
		flag1 0
		stateOf690 0
		songWaiting 0
		loopWaiting 0
	)

	(method (isSet param1)
		(return (& flag1 param1))
	)

	(method (clrIt param1)
		(&= flag1 (^ flag1 param1))
	)

	(method (setIt param1 &tmp temp0)
		(= temp0 param1)
		(|= flag1 param1)
		(return (& temp0 param1))
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 600 605 615 620 630 640 650 660 670 680 690))
		(= initialized 0)
		(super newRoom: newRoomNumber &rest)
	)

	(method (cue)
		(super cue:)
		(SetFlag 121)
	)
)

