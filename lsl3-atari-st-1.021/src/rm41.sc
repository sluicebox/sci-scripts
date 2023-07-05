;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 41)
(include sci.sh)
(use Main)
(use Interface)
(use Jump)
(use Motion)
(use Game)
(use System)

(public
	rm41 0
)

(local
	fallPri
	destY
	restoreX
	restoreY
	[string 44]
	[string2 22]
)

(instance rm41 of Rgn
	(properties)

	(method (init)
		(Load rsSOUND 4)
		(if gEgoIsPatti
			(Load rsVIEW 813)
		else
			(Load rsVIEW 713)
		)
		(super init:)
		(self setScript: FallScript)
	)

	(method (notify fallingPriority destinationY)
		(= fallPri fallingPriority)
		(= destY destinationY)
		(FallScript changeState: 1)
	)
)

(instance FallScript of Script
	(properties)

	(method (doit)
		(if (and gDebugging (== gEgoState 0))
			(= restoreX (gEgo x:))
			(= restoreY (gEgo y:))
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(HandsOff)
				(gSoundFX number: 4 loop: 1 play:)
				(Print (Format @string 41 0 gExpletive) #at -1 10 #dispose) ; "%s"
				(= gEgoState 2)
				(gEgo
					view: (if gEgoIsPatti 813 else 713)
					setLoop: 0
					cel: 0
					illegalBits: 0
					ignoreActors:
					setPri: fallPri
					setCycle: End self
				)
			)
			(2
				(gEgo setMotion: theJump)
			)
			(3
				(cls)
				(if gDebugging
					(NormalEgo)
					(= gEgoState 0)
					(gEgo posn: restoreX restoreY)
				else
					(gGame setScript: (ScriptID 40)) ; DyingScript
					((ScriptID 40) ; DyingScript
						caller: (+ 1 (gEgo view:))
						register: (Format @string 41 1 gEgoName) ; "Well, %s, are you now fully convinced that gravity really sucks?"
						next: (Format @string2 41 2) ; "You really FELL for that one..."
					)
				)
			)
		)
	)
)

(instance theJump of Jump
	(properties)

	(method (init)
		(super init: gEgo FallScript)
		(self yStep: 5 y: destY)
	)
)

