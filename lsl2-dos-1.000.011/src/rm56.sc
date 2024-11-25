;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 56)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm56 0
)

(local
	aMind
	lineNum
	lineMax
	lineMaxY
	eastLineMaxX
	westLineMaxX
)

(instance rm56 of Rm
	(properties
		picture 56
		horizon 1
	)

	(method (init)
		(Load rsVIEW 522)
		(super init:)
		(= lineMaxY 166)
		(= eastLineMaxX 109)
		(= westLineMaxX 136)
		(cond
			((> gMachineSpeed 60)
				(= lineMax 4)
			)
			((> gMachineSpeed 40)
				(= lineMax 3)
			)
			((> gMachineSpeed 20)
				(= lineMax 2)
			)
			(else
				(= lineMax 1)
			)
		)
		(for ((= lineNum 1)) (<= lineNum lineMax) ((++ lineNum))
			((Act new:) setScript: (eastLineScript new:))
			((Act new:) setScript: (westLineScript new:))
		)
		((= aMind (Act new:))
			view: 522
			setLoop: 1
			setPri: 14
			setStep: 4 4
			illegalBits: $0010
			posn: 175 1042
			ignoreActors:
			init:
		)
		(HandsOff)
		(= gCurrentStatus 8)
		(self setRegions: 500 setScript: rm56Script) ; rm500
	)
)

(instance rm56Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(Print 56 0) ; "This is certainly a long terminal."
				(= seconds 10)
			)
			(2
				(Print 56 1) ; "Your mind wanders..."
				(= seconds 3)
			)
			(3
				(aMind posn: 175 42 setMotion: Wander 99)
				(= seconds 10)
			)
			(4
				(aMind ignoreControl: 16 setMotion: MoveTo (aMind x:) -20)
				(Print 56 2 #draw) ; "Previously, you believed that was just a figure of speech!"
				(= seconds 10)
			)
			(5
				(Print 56 3) ; "Finally, you reach the end of the moving sidewalk, and enter the waiting room for Gate #1."
				(gCurRoom newRoom: 57)
			)
		)
	)
)

(instance eastLineScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					view: 522
					setLoop: 0
					setCel: 0
					setPri: 5
					setStep: 1 1
					illegalBits: 0
					ignoreHorizon:
					ignoreActors:
					posn:
						(- 204 (* lineNum (/ eastLineMaxX lineMax)))
						(+ 3 (* lineNum (/ lineMaxY lineMax)))
					init:
				)
				(self changeState: 1)
			)
			(1
				(client setMotion: MoveTo 204 3 self)
			)
			(2
				(client posn: 95 169)
				(self changeState: 1)
			)
		)
	)
)

(instance westLineScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					view: 522
					setLoop: 0
					setCel: 1
					setPri: 5
					setStep: 1 1
					illegalBits: 0
					ignoreHorizon:
					ignoreActors:
					posn:
						(+ -58 (* lineNum (/ westLineMaxX lineMax)))
						(+ 3 (* lineNum (/ lineMaxY lineMax)))
					init:
				)
				(self changeState: 1)
			)
			(1
				(client setMotion: MoveTo -58 3 self)
			)
			(2
				(client posn: 78 169)
				(self changeState: 1)
			)
		)
	)
)

