;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm28 0
)

(local
	work
	aLA
	aBird
	aSparkle
)

(instance theSound of Sound
	(properties
		number 116
	)
)

(instance rm28 of Rm
	(properties
		picture 28
		horizon 1
	)

	(method (init)
		(Load rsVIEW 239)
		(Load rsSOUND 116)
		(theSound init:)
		(super init:)
		((= aSparkle (Prop new:))
			view: 815
			setLoop: 0
			setPri: 15
			posn: 222 110
			init:
			hide:
			setScript: sparkleScript
		)
		((= aLA (Act new:))
			view: 239
			setLoop: 1
			setPri: 1
			posn: 55 37
			setStep: 1 1
			moveSpeed: 2
			init:
		)
		((= aBird (Act new:))
			view: 239
			setLoop: 0
			setPri: 4
			posn: 222 918
			ignoreActors:
			init:
			setCycle: Fwd
		)
		(HandsOff)
		(= gCurrentStatus 4)
		(self setScript: rm28Script)
	)
)

(instance rm28Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theSound play: self)
				(aLA setMotion: MoveTo -63 38 self)
				(= seconds 5)
			)
			(1
				(Print 28 0) ; "As Los Angeles slips out of view, your thoughts are on your search..."
				(Print 28 1) ; "...will you find love?"
				(Print 28 2 #at -1 152) ; "(Or just keep looking in all the wrong places?)"
				(= seconds 60)
			)
			(2
				(= seconds 2)
			)
			(3
				(aBird posn: 222 18 setMotion: MoveTo -23 19 self)
				(= seconds 60)
			)
			(5
				(SetRgTimer 2 9 30)
				(gCurRoom newRoom: 31)
			)
		)
	)
)

(instance sparkleScript of Script
	(properties)

	(method (changeState newState &tmp sparkleX sparkleY)
		(switch (= state newState)
			(0
				(= cycles (Random 3 10))
			)
			(1
				(switch (Random 1 10)
					(1
						(= sparkleX 212)
						(= sparkleY 47)
					)
					(2
						(= sparkleX 269)
						(= sparkleY 46)
					)
					(3
						(= sparkleX 193)
						(= sparkleY 13)
					)
					(4
						(= sparkleX 239)
						(= sparkleY 99)
					)
					(5
						(= sparkleX 238)
						(= sparkleY 104)
					)
					(6
						(= sparkleX 198)
						(= sparkleY 116)
					)
					(7
						(= sparkleX 318)
						(= sparkleY 112)
					)
					(8
						(= sparkleX 43)
						(= sparkleY 120)
					)
					(9
						(= sparkleX 163)
						(= sparkleY 155)
					)
					(else
						(= sparkleX 169)
						(= sparkleY 8)
					)
				)
				(aSparkle
					posn: sparkleX sparkleY
					cel: 0
					cycleSpeed: (Random 0 2)
					show:
					setCycle: End self
				)
			)
			(2
				(aSparkle hide:)
				(self changeState: 0)
			)
		)
	)
)

