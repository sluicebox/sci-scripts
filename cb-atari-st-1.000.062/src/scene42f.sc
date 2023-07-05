;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 355)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Game)
(use System)

(public
	scene42f 0
)

(instance myMusic of Sound
	(properties)
)

(instance scene42f of Rm
	(properties
		picture 62
		style 7
	)

	(method (init)
		(super init:)
		(HandsOff)
		(myMusic number: 27 loop: -1 play:)
		(Load rsFONT 41)
		(LoadMany rsMESSAGE 406)
		(Load rsVIEW 642)
		(LoadMany rsSOUND 94 95 96 29)
		(self setScript: missColo)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
	)
)

(instance missColo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not global216)
						(= state -1)
					)
					((not (& gMustDos $0004))
						(|= gMustDos $0004)
						(self setScript: (ScriptID 406 0)) ; Clock
						(= state -1)
					)
					((self script:)
						(= state -1)
					)
				)
				(= cycles 1)
			)
			(1
				(Print 355 0 #at 70 63 #dispose) ; "Hmmmmm...there's no one in the Colonel's room."
				(= seconds 4)
			)
			(2
				(SetFlag 37)
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

