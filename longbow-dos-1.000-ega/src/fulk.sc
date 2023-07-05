;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use n013)
(use Monastery)
(use verseScript)
(use RTEyeCycle)
(use PolyPath)
(use Motion)
(use Actor)
(use System)

(public
	fulk 0
)

(local
	[local0 8] = [1015 0 2 1 2 1 2 0]
	[local8 8] = [1015 5 2 1 2 1 2 0]
	[local16 4] = [1015 13 1 0]
	[local20 4] = [1015 15 1 0]
	[local24 4] = [1015 16 1 0]
	[local28 4] = [1015 26 1 0]
	[local32 4] = [1015 17 1 0]
	[local36 4] = [1015 18 1 0]
	[local40 4] = [1015 19 1 0]
	[local44 4] = [1015 20 1 0]
	[local48 4] = [1015 21 1 0]
	[local52 4] = [1015 22 1 0]
	[local56 4] = [1015 24 1 0]
	[local60 4] = [1015 23 1 0]
)

(instance fulk of Actor
	(properties
		view 674
		xStep 2
	)

	(method (doVerb theVerb invItem)
		(switch gCurRoomNum
			(670
				(doVerb670 doit: theVerb invItem &rest)
			)
			(680
				(doVerb680 doit: theVerb invItem &rest)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance chip of Actor
	(properties
		x 160
		y 210
		view 16
		loop 3
	)
)

(instance doVerb670 of Code
	(properties)

	(method (doit param1 param2 &tmp temp0)
		(= temp0 (Monastery fulkStatus:))
		(switch param1
			(2
				(if (== temp0 0)
					(Say 1015 10) ; "By the Blessed Lady, what terrible pain he must be suffering."
				else
					(Say 1015 11) ; "He's a stout fellow and truly loyal to the Lionheart, to have resisted such torture."
				)
			)
			(5
				(switch temp0
					(0
						(Say 1015 14) ; "The dwarf is in too much agony to speak."
					)
					(1
						(Converse @local20 (Monastery tFULK:) 0) ; "There's nothing more to say, monk or hood or whatever you be, unless you return my verses to me."
					)
					(else
						(if (gEgo has: 17) ; handScroll
							(Converse @local24 (Monastery tFULK:) 0) ; "Hurry, my friend! Every minute you delay puts us a minute closer to death."
						else
							(Converse @local28 (Monastery tFULK:) 0) ; "Go! Find what you need, but hurry!"
						)
					)
				)
			)
			(3
				(if (== temp0 0)
					(Say 1015 12) ; "I can't pull on his body without causing him worse pain than he already suffers."
				else
					(Converse @local16 (Monastery tFULK:) 0) ; "Agh! It hurts! Please, don't try to move me yet."
				)
			)
			(4
				(switch param2
					(0
						(switch temp0
							(0
								(Say 1015 27) ; "Of what use is that to a man hanging from a strappado?"
							)
							(1
								(Converse @local32 (Monastery tFULK:) 0) ; "I will take nothing from you but my scroll."
							)
							(else
								(Converse @local36 (Monastery tFULK:) 0) ; "Waste no time on such things now. Hasten and find the scroll you need."
							)
						)
					)
					(2
						(switch temp0
							(0
								(Say 1015 27) ; "Of what use is that to a man hanging from a strappado?"
							)
							(1
								(Converse @local40 (Monastery tFULK:) 0) ; "Precious this may be, but my verses are more precious still."
							)
							(else
								(Converse @local44 (Monastery tFULK:) 0) ; "You are too generous. I could not take such a gift."
							)
						)
					)
					(14
						(switch temp0
							(0
								(Say 1015 27) ; "Of what use is that to a man hanging from a strappado?"
							)
							(1
								(Converse @local48 (Monastery tFULK:) 0) ; "Bring me my verses, then I will decide what else to take from you."
							)
							(else
								(Converse @local52 (Monastery tFULK:) 0) ; "I am right fond of amethyst. Thank you."
								(gEgo put: 14 -1) ; amethyst
							)
						)
					)
					(10
						(gEgo setScript: killEgoWithRing)
					)
					(17
						(if (== temp0 0)
							(Say 1015 27) ; "Of what use is that to a man hanging from a strappado?"
						else
							(Converse @local56 (Monastery tFULK:) 0) ; "You wish to give me a hand, I see, but I have two hands and that is enough for any man, and so I shall leave it in better hands, with thee."
						)
					)
					(16
						(if (== temp0 0)
							(Say 1015 25) ; "He sees or hears nothing but his own agony."
						else
							(gCurRoom setScript: giveItToHim)
						)
					)
					(else
						(switch temp0
							(0
								(Say 1015 27) ; "Of what use is that to a man hanging from a strappado?"
							)
							(1
								(Converse @local32 (Monastery tFULK:) 0) ; "I will take nothing from you but my scroll."
							)
							(else
								(Converse @local36 (Monastery tFULK:) 0) ; "Waste no time on such things now. Hasten and find the scroll you need."
							)
						)
					)
				)
			)
		)
	)
)

(instance doVerb680 of Code
	(properties)
)

(instance leaveNow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== ((ScriptID 15) view:) 674) ; fulk
					((ScriptID 15) setCycle: CT 6 -1 self) ; fulk
				else
					(++ state)
					(self cue:)
				)
			)
			(1
				((ScriptID 15) view: 671 loop: 2 cel: 0) ; fulk
				(= cycles 3)
			)
			(2
				(Converse @local0 999 (Monastery tFULK:) self) ; "Bless you, bless you, Hooded Robert!"
			)
			(3
				(Monastery fulkStatus: 3)
				((ScriptID 15) ; fulk
					view: 671
					loop: 2
					setCycle: Walk
					setMotion: PolyPath 106 250
				)
				(gEgo setMotion: PolyPath 126 250 self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance killEgoWithRing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(chip
					init:
					setCycle: Walk
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 15) self
				)
			)
			(1
				(Converse @local60 11 0 self) ; "Brother Eustace, the Prior sent me to--that ring! So you're the thief!"
			)
			(2
				(== gDeathNum 20)
				(gCurRoom newRoom: 170) ; robinDeath
			)
		)
	)
)

(instance giveItToHim of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 165 169 self)
			)
			(1
				(Face gEgo (ScriptID 15)) ; fulk
				(= cycles 10)
			)
			(2
				(gEgo setMotion: PolyPath 202 172 self)
			)
			(3
				(Face gEgo (ScriptID 15) self) ; fulk
				(SetScore 300)
				(gEgo put: 16 -1) ; fulkScroll
			)
			(4
				(if (gEgo has: 17) ; handScroll
					(= next leaveNow)
				else
					(Converse @local8 999 (Monastery tFULK:)) ; "Bless you, bless you, Hooded Robert!"
					(Monastery fulkStatus: 2)
				)
				(= cycles 1)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

