;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 96)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Game)
(use Actor)
(use System)

(public
	rm96 0
)

(instance rm96 of Rm
	(properties
		picture 96
	)

	(method (init)
		(Load rsVIEW 830)
		(Load rsSOUND 115)
		(super init:)
		(theSound play:)
		(gAddToPics add: aDeath doit:)
		(self setScript: rm96Script)
	)
)

(instance rm96Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(Print 96 0 #at -1 15 #width 280) ; "You are quickly taken to a local office of the KGB where a specialist in onklunk extraction is busy giving you the third degree!"
				(= seconds 3)
			)
			(2
				(Print 96 1 #at -1 15 #width 280) ; "And so, my leettle white-suited capitalist swine," says the KGB agent, "you vill now tell us zee location of zat onklunk or I vill be forced to run zeese alto saxophone reeds under your fingernails until you're zinging like zee Bird!"
				(= seconds 3)
			)
			(3
				(Print 96 2 #at -1 15 #width 280) ; "Things don't look good, Larry. Maybe next time a different approach would be better..."
				(= gCurrentStatus 1001)
			)
		)
	)
)

(instance theSound of Sound
	(properties
		number 115
	)
)

(instance aDeath of PV
	(properties
		y 185
		x 110
		view 830
		signal 16384
	)
)

