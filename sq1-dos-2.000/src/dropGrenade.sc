;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 707)
(include sci.sh)
(use Main)
(use DeltaurRegion)
(use RangeOsc)
(use Motion)
(use System)

(public
	dropGrenade 0
	egoShot 1
)

(local
	local0
	[local1 2]
)

(instance dropGrenade of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if 0
					(gEgo setLoop: 0)
				else
					(gEgo setLoop: 1)
				)
				(if (== (DeltaurRegion egoStatus:) 1)
					(gEgo setLoop: (+ (gEgo loop:) 2))
				)
				(gEgo view: 75 cel: 0 cycleSpeed: 8 setCycle: CT 7 1 self)
			)
			(1
				(gSoundEffects number: 518 loop: 1 play:)
				(gLongSong2 number: 519 loop: 1 play:)
				(gEgo cel: 8 setCycle: CT 12 1)
				(= seconds 2)
			)
			(2
				(gEgo setCycle: CT 13 1 self)
			)
			(3
				(gEgo setCycle: RangeOsc 3 14 15 self)
			)
			(4
				(EgoDead
					934
					0
					0
					{Although you've always had an appreciation for the gases of the universe, this one proved a bit overwhelming. It really was a great idea, though. However, you should have chosen a victim not so close to yourself. Better choice next time.}
				)
				(self dispose:)
			)
		)
	)
)

(instance egoShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					((== (DeltaurRegion egoStatus:) 1)
						(if (OneOf (gEgo loop:) 0 4 6 3)
							(gEgo setLoop: 6)
						else
							(gEgo setLoop: 7)
						)
					)
					((> (gEgo loop:) 3)
						(gEgo setLoop: (- (gEgo loop:) 2))
					)
					(else
						(switch (gEgo loop:)
							(2
								(if (> (gEgo x:) local0)
									(gEgo setLoop: 3)
								)
							)
							(3
								(if (> (gEgo x:) local0)
									(gEgo setLoop: 5)
								else
									(gEgo setLoop: 4)
								)
							)
						)
					)
				)
				(if (== (DeltaurRegion egoStatus:) 2)
					(gEgo view: 50)
				else
					(gEgo view: 48 setLoop: 1)
				)
				(gSoundEffects number: 368 loop: 1 play:)
				(gEgo cel: 0 setCycle: End self)
			)
			(1
				(EgoDead
					940
					2
					0
					{BLAMMO! Those pulseray pistols sure are effective little weapons. Even after it kills you, your meat continues to cook to nice golden brown. Try not to get shot in the future. Even if your life isn't worth much, think about the rest of the universe.}
				)
				(self dispose:)
			)
		)
	)
)

