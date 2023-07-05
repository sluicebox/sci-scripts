;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 83)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use System)

(public
	rm83 0
)

(instance theSound of Sound
	(properties
		number 11
	)
)

(instance rm83 of Rm
	(properties
		picture 178
	)

	(method (init)
		(Load rsVIEW 185)
		(Load rsSOUND 11)
		(super init:)
		(theSound play:)
		(HandsOff)
		(gEgo view: 185 loop: 0 cel: 0 posn: 159 87 setCycle: Fwd init:)
		(self setScript: rm83Script)
	)
)

(instance rm83Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(Print 83 0 #at -1 152 #time 5 #dispose) ; "Once again, Larry, you're getting the shaft!"
				(= seconds 5)
			)
			(2
				(gCurRoom newRoom: 84)
			)
		)
	)
)

