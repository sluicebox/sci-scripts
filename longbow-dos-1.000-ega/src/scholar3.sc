;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 314)
(include sci.sh)
(use Main)
(use n013)
(use Fair)
(use RTEyeCycle)
(use PPath)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	scholar3 0
)

(local
	local0 = 1
	local1
	[local2 7] = [1314 0 1 2 1 2 0]
	[local9 4] = [1314 5 2 0]
	[local13 4] = [1314 6 2 0]
	[local17 4] = [1314 8 2 0]
	[local21 4] = [1314 7 2 0]
	[local25 5] = [1314 9 1 2 0]
	[local30 5] = [1314 11 1 2 0]
	[local35 5] = [1314 13 2 2 0]
	[local40 4] = [1314 15 2 0]
	[local44 4] = [1314 16 2 0]
	[local48 5] = [1314 17 2 2 0]
	[local53 4] = [1314 19 2 0]
	[local57 6] = [1314 20 2 1 2 0]
	local63
	[local64 5]
	local69
	local70
	local71
	local72
	local73
	local74
	local75
	[local76 9] = [323 3 2 4 25 35 20 25 24]
)

(instance scholar3 of Actor
	(properties
		cycleSpeed 10
		moveSpeed 10
	)

	(method (init param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2)
		(= local75 param2)
		(= local74 param1)
		(if param5
			(if (> local74 0)
				(= param5 (- 801 param5))
			)
			(= temp0 (+ (/ (* param5 (- param4 1)) 801) 1))
		else
			(= temp0 (if (> local74 0) 0 else param4))
		)
		(if (> local74 0)
			(= temp1 (+ temp0 1))
			(= temp2 param4)
		else
			(= temp1 (- temp0 1))
			(= temp2 0)
		)
		(super init:)
		(self
			view: 320
			setCycle: SyncWalk
			posn: (WordAt param3 (*= temp0 2)) (WordAt param3 (+ temp0 1))
			setMotion: PPath param3 temp1 temp2 leave
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(cond
					((gCurRoom script:)
						(super doVerb: theVerb &rest)
					)
					(
						(or
							(> (gEgo distanceTo: scholar3) 50)
							(> (scholar3 x:) 312)
							(< (scholar3 x:) 5)
						)
						(Say 1311 0) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
					)
					(global197
						(switch global197
							(1
								(Converse @local25 999 @local76 0 1) ; "Sir, I truly wish to see this coat-of-arms."
								(= global197 2)
							)
							(2
								(Converse @local21 999 @local76 0 1) ; "Nay, nay, you wait here. I'll come back with another book."
							)
							(3
								(gCurRoom setScript: converse)
							)
							(4
								(Converse @local44 999 @local76 0 1) ; "I'm sorry, young man, but I simply cannot help you."
							)
						)
					)
					(else
						(gCurRoom setScript: converse)
					)
				)
			)
			(2 ; Look
				(if local0
					(Say 1311 2) ; "Ah, a Scholar!"
					(= local0 0)
				else
					(Say 1311 3) ; "The Scholar looks the same as he did before."
				)
			)
			(4 ; Inventory
				(if
					(or
						(> (gEgo distanceTo: scholar3) 50)
						(> (scholar3 x:) 312)
						(< (scholar3 x:) 5)
					)
					(Say 1311 0) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(switch invItem
						(17 ; handScroll
							(Converse @local48 999 @local76 0 1) ; "Oh, my. This is...umm...I'm sorry, but this is quite useless."
						)
						(0 ; bucks
							(if global197
								(Converse @local53 999 @local76 0 1) ; "Eh? Oh, forgive me, sir. I fear all my tomes are more costly than that."
							else
								(Converse @local57 999 @local76 0 1) ; "Do you owe me money, sir?"
							)
						)
						(else
							(super doVerb: theVerb &rest)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (delete)
		(super delete:)
		(DisposeScript 314)
	)

	(method (dispose)
		(if (== global197 2)
			(= global197 3)
		)
		(super dispose:)
	)
)

(instance leave of CueObj
	(properties)

	(method (cue &tmp temp0)
		(proc311_1 local75 local74 scholar3)
	)
)

(instance showIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(scholar3 setCycle: End self)
			)
			(1
				(= local69 (+ 12 (CelHigh 71 12 0)))
				(= local70 (+ 245 (CelWide 71 12 0)))
				(= local71 (Graph grSAVE_BOX 12 245 local69 local70 3))
				(DrawCel 71 12 0 245 12 15 1)
				(DrawCel 71 [local64 local63] 0 256 14 15 1)
				(= cycles 1)
			)
			(2
				(= local1 (AyeOrNay))
				(= cycles 2)
			)
			(3
				(Graph grRESTORE_BOX local71)
				(Graph grUPDATE_BOX 12 245 local69 local70 1)
				(= cycles 2)
			)
			(4
				(scholar3 setCycle: Beg self)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 [temp2 70])
		(switch (= state newState)
			(0
				(HandsOff)
				(for ((= temp0 0)) (< temp0 5) ((++ temp0))
					(= register (Random 1 11))
					(if (<= register global123)
						(-- register)
					)
					(= [local64 temp0] register)
					(for ((= temp1 0)) (< temp1 temp0) ((++ temp1))
						(if (== [local64 temp1] [local64 temp0])
							(-- temp0)
						)
					)
				)
				(= local72 (scholar3 mover:))
				(= local73 (scholar3 loop:))
				(scholar3 loop: (> (scholar3 x:) (gEgo x:)) mover: 0)
				(Face gEgo scholar3 self)
			)
			(1
				(scholar3 loop: (+ (scholar3 loop:) 2) cel: 0)
				(= cycles 2)
			)
			(2
				(if (== global197 3)
					(+= state 2)
					(Converse @local30 999 @local76 self 1) ; "Did you find the other book?"
				else
					(Converse @local2 999 @local76 self 0) ; "Merry day, greybeard."
				)
			)
			(3
				(GetFarText 1314 4 @temp2) ; "Perhaps you have a book which shows the coat-of-arms of"
				(GetFarText 1317 global123 (+ @temp2 (StrLen @temp2)))
				((ScriptID 851 2) show: say: @temp2 0 0 0 self) ; talker1
			)
			(4
				(Converse @local9 999 @local76 self 1) ; "Oh dear, oh dear, I'm not sure. I must have a look. Let's see....ah, would this be the one?"
			)
			(5
				(self setScript: showIt self)
			)
			(6
				(cond
					((== global197 3)
						(if local1
							(Converse @local35 999 @local76 self 1) ; "Tsk, tsk, just as I thought. You are no scholar."
						else
							(Converse @local40 999 @local76 self 1) ; "Oh, dear. I'm afraid I simply haven't got the one you desire. Pray excuse me."
						)
						(= global197 4)
					)
					(local1
						(= global197 1)
						(Converse @local17 999 @local76 self 1) ; "Tsk, tsk, young man. That isn't what it says at all. You're making fun of me."
					)
					(else
						(= global197 2)
						(Converse @local13 999 @local76 self 1) ; "Oh, dear. It may be in one of my other books. I'll fetch it from home and bring it back."
					)
				)
			)
			(7
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(scholar3 setCycle: Walk mover: local72 loop: local73)
		(super dispose:)
	)
)

